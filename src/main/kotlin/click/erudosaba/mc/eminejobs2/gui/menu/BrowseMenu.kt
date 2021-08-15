package click.erudosaba.mc.eminejobs2.gui.menu

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.PlayerJobJoinEvent
import click.erudosaba.mc.eminejobs2.gui.InventoryGUI
import click.erudosaba.mc.eminejobs2.gui.SlotCommand
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack

class BrowseMenu(plugin: Main, player: Player) : InventoryGUI(plugin, 18, title, player) {

    init {
        initialize()
    }

    companion object {
        val title = "現在就くことが出来る職業"
    }

    override fun initialize() {
        for ((count, job) in Jobs.values().withIndex()) {
            val item = ItemStack(job.icon)
            val meta = item.itemMeta
            meta?.setDisplayName("${ChatColor.GOLD}${job.Jobname}")
            val lore = mutableListOf(
                    "経験値取得方法：${job.jobCategory.name}",
                    "獲得経験値量：${job.jobExp}",
                    "獲得可能スキル："
            )

            for (skill in Skill.values()) {
                if (skill.job == job) {
                    lore.add("- ${skill.name}")
                }
            }

            meta?.lore = lore
            item.itemMeta = meta

            addItem(object : SlotCommand(count, item) {
                override fun onClick(click: ClickType?): Boolean {
                    if(click == ClickType.RIGHT || click == ClickType.LEFT) {
                        for(jp in Main.jPlayers) {
                            if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                                if (jp.level <= 20) {
                                    jp.exp = 0.0
                                    jp.level = 0
                                    jp.jobID = job
                                    jp.selectedSkill = null
                                    jp.skillStatus = SkillStatus.DISABLED
                                    player.sendMessage("あなたはレベルをリセットし，${ChatColor.YELLOW}${job.Jobname}${ChatColor.WHITE}に転職しました")

                                    val event = PlayerJobJoinEvent(jp, Jobs.valueOf(job.name))
                                    Bukkit.getServer().pluginManager.callEvent(event)
                                } else {
                                    player.sendMessage("あなたはレベルが20より大きいのため転職できません")
                                }
                                break
                            }
                        }
                        val jp = JobPlayer(player.uniqueId,player.name, job,0.0,0,null,SkillStatus.DISABLED)
                        player.sendMessage("あなたは${ChatColor.YELLOW}${job.Jobname}${ChatColor.WHITE}に就きました")

                        val event = PlayerJobJoinEvent(jp, Jobs.valueOf(job.name))
                        Bukkit.getServer().pluginManager.callEvent(event)

                    }

                    return true
                }
            })

        }


    }

}