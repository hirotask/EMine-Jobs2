package click.erudosaba.mc.eminejobs2.gui.menu

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.gui.InventoryGUI
import click.erudosaba.mc.eminejobs2.gui.SlotCommand
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack
import java.lang.Exception

class SkillMenu(val plugin: Main, val player: Player) : InventoryGUI(plugin, 18, title, player) {

    init {
        initialize()
    }

    companion object {
        val title = "現在習得可能なスキル"
    }

    override fun initialize() {
        val jp = JobPlayer(plugin = plugin ,player = player)
        var count = 0

        for((skill, option) in plugin.skillManager.skillOptions) {
            if(jp.JobID == skill.job) {
                val level = jp.level
                val needLevel = option.needLevel

                if(level >= needLevel) {
                    if(option.enabled) {
                        val item = ItemStack(option.icon)
                        val meta = item.itemMeta
                        meta?.setDisplayName(option.name)
                        meta?.lore = option.description.toList()
                        item.itemMeta = meta

                        addItem(object : SlotCommand(count, item){
                            override fun onClick(click: ClickType?): Boolean {
                                if(click == ClickType.LEFT || click == ClickType.RIGHT) {
                                    try {
                                        jp.selectedSkill = skill
                                        player.sendMessage("スキルを${ChatColor.YELLOW}${skill.name.toUpperCase()}${ChatColor.WHITE}に設定しました")
                                    }catch (e : Exception) {
                                        player.sendMessage("予期せぬエラーが発生しました")
                                    }
                                }

                                return true
                            }
                        })

                        count++
                    }
                }

            }
        }
    }
}