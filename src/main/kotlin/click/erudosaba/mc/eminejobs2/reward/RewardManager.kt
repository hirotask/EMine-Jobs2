package click.erudosaba.mc.eminejobs2.reward

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.reward.rewards.Amulet
import click.erudosaba.mc.eminejobs2.reward.rewards.FarmBoots
import click.erudosaba.mc.eminejobs2.util.CustomConfig
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class RewardManager(val plugin: Main) {

    val rewardOptions = mutableMapOf<RewardItem, RewardOption>()


    //報酬アイテムをrewarditems_config.ymlから取得
    //値が設定されてなかったらRewardItemから設定
    fun loadOptions() {
        val customConfig = CustomConfig(plugin, "rewardItems_config.yml")
        val config = customConfig.config
        var amountLoaded = 0
        var amountDisabled = 0

        val startTime = System.currentTimeMillis()
        val rewards = config.getConfigurationSection("rewardItems")

        if (rewards != null) {
            for (r in RewardItem.values()) {
                val rewardName = r.name.toLowerCase()
                val reward = rewards.getConfigurationSection(rewardName)
                if (reward != null) {
                    var hasKey = false
                    for (key in reward.getKeys(false)) {
                        if (key.length == 7) {
                            hasKey = true
                            break
                        }
                    }

                    if (hasKey) {
                        val path = "rewardItems.${reward}."
                        val rewarditem = RewardItem.valueOf(reward.name.toUpperCase())

                        //config内容
                        val enabled = config.getBoolean("${path}enabled", true)
                        val name = config.getString("${path}name", rewarditem.Itemname)
                        val needLevel = config.getInt("${path}need_level", rewarditem.needLevel)
                        val material = Material.valueOf(config.getString("${path}material", rewarditem.material.name)!!.toUpperCase())
                        val unbreakable = config.getBoolean("${path}unbreakable", rewarditem.unbreakable)
                        val lore = config.getStringList("${path}lore")
                        val enchantments = mutableMapOf<Enchantment, Int>()

                        val enchants = config.getConfigurationSection("enchants")

                        if (enchants != null) {
                            for (enchant in enchants.getKeys(false)) {
                                val encName = Enchantment.getByName(enchant.toUpperCase())
                                enchantments[encName!!] = config.getInt("${path}enchants.${enchant}")
                            }
                        }

                        if (!enabled) {
                            amountDisabled++
                        }

                        val option = RewardOption(enabled, name!!, needLevel, material, unbreakable, lore.toTypedArray(), enchantments)
                        rewardOptions[rewarditem] = option
                        amountLoaded++
                    }
                }

            }
        }

        val endTime = System.currentTimeMillis()
        val timeElapsed = endTime - startTime
        Bukkit.getLogger().info("[eMineJobs2] Disabled $amountDisabled Reward Items")
        Bukkit.getLogger().info("[eMineJobs2] Enabled $amountLoaded Reward Items")
        Bukkit.getLogger().info("[eMineJobs2] Time: $timeElapsed")
    }

    fun loadRewards() {
        val array = arrayOf(
                Amulet(plugin),
                FarmBoots(plugin)
        )

        array.forEach { plugin.server.pluginManager.registerEvents(it, plugin) }
    }

    fun getItem(reward: RewardItem): ItemStack {
        if (rewardOptions.containsKey(reward)) {
            val option = rewardOptions[reward]

            if (option != null) {
                val item = ItemStack(option.material)

                val meta = item.itemMeta
                meta!!.setDisplayName(option.name)
                meta.isUnbreakable = option.unbreakable
                meta.lore = option.lore.toMutableList()

                for ((enchant, level) in option.enchants) {
                    meta.addEnchant(enchant, level, true)
                }

                item.itemMeta = meta


                return item
            }
        }

        return ItemStack(Material.AIR)

    }

}