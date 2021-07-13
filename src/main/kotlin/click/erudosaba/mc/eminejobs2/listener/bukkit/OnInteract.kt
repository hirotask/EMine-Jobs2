package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.SkillUseEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class OnInteract(val plugin : Main) : Listener{

    @EventHandler
    fun onInteract(e : PlayerInteractEvent) {
        if(e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK) {
            val player = e.player
            val jp = JobPlayer(player,plugin)
            val skill = jp.selectedSkill

            if(activateBlock(jp,skill)) return

            val skillOption = plugin.skillManager.getSkillOption(skill)

            val event = SkillUseEvent(jp,skillOption)
            Bukkit.getServer().pluginManager.callEvent(event)
        }
    }

    private fun activateBlock(jp : JobPlayer, skill : Skill) : Boolean {
        if(jp.player.isSneaking) {
            if(jp.hasSkill()){
                if(jp.hasJob()) {
                    if(jp.JobID == jp.selectedSkill.job) {
                        if(jp.selectedSkill == skill) {
                            if(jp.level >= plugin.skillManager.getSkillOption(jp.selectedSkill).needLevel) {
                                if(jp.skillStatus == SkillStatus.DISABLED) {
                                    return false
                                }
                            }
                        }
                    }
                }
            }
        }
        return true

    }
}