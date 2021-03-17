package click.erudosaba.mc.eminejobs2.rewards

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.util.CustomConfig
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable

class RewardItem(plg: Main, path: String) : CustomConfig(plugin = plg, path = "rewarditems/${path}.yml") {

    val id: String? = config.getString("ID")
    val name: String? = config.getString("name")
    val needLevel: Int = config.getInt("needLevel")
    lateinit var material: Material
    val unbreakable = config.getBoolean("unbreakable")
    val lore: MutableList<String> = config.getStringList("lore")
    val enchants: MutableMap<Enchantment, Int> = mutableMapOf()

    init {
        if(config.getString("material") != null) {
            val s = config.getString("material")!!.toUpperCase()
            material = Material.getMaterial(s)!!
        }

        for (key: String in config.getConfigurationSection("enchants")?.getKeys(false)!!) {
            enchants.put(Enchantment.getByName(key.toUpperCase())!!, config.getInt("enchants.${key}"))
        }
    }

    fun getItem(): ItemStack {
        val item = ItemStack(material)

        if (!item.hasItemMeta()) {
            val meta = item.itemMeta
            meta?.setDisplayName(name.toString())
            meta?.lore = lore
            for ((k, v) in enchants) meta?.addEnchant(k, v, true)
            if(unbreakable) meta?.isUnbreakable = true
            item.itemMeta = meta
        }

        return item
    }

}