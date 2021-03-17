package click.erudosaba.mc.eminejobs2.rewards

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.util.CustomConfig
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable

class RewardItem(plg: Main, path: String) : CustomConfig(plugin = plg, path = "rewarditems/${path}.yml") {

    var id: String? = config.getString("ID")
    var name: String? = config.getString("Name")
    var needLevel: Int = config.getInt("needLevel")
    var material: Material? = if (config.getString("material") != null) Material.getMaterial("material") else null
    var lore: MutableList<String> = config.getStringList("lore")
    var enchants: MutableMap<Enchantment, Int> = mutableMapOf()

    init {
        for (key: String in config.getConfigurationSection("enchants")?.getKeys(false)!!) {
            enchants.put(Enchantment.getByName(key.toUpperCase())!!, config.getInt("enchants.${key}"))
        }
    }

    fun getItem(): ItemStack {
        val item = ItemStack(material!!)

        if (item.hasItemMeta()) {
            val meta = item.itemMeta
            meta?.setDisplayName(name.toString())
            meta?.lore = lore
            for ((k, v) in enchants) meta?.addEnchant(k, v, true)
            item.itemMeta = meta
        }

        return item
    }

}