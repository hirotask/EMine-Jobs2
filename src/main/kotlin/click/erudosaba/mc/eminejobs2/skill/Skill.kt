package click.erudosaba.mc.eminejobs2.skill

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.SkillUseEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

open class Skill(val plugin : Main,
                 val ID: String,
                 val name: String,
                 val job: Jobs,
                 val description: Array<String>,
                 val icon: Material,
                 val activeTime: Int,
                 val needLevel: Int,
                 val interval: Int) : Listener{

    init {
        plugin.server.pluginManager.registerEvents(this,plugin)
    }

                     @EventHandler
                     fun onInteract(e : PlayerInteractEvent) {
                         val jp = JobPlayer(e.player,plugin)

                         if(e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK) {
                             if(e.player.isSneaking) {
                                 if(jp.hasJob() && jp.hasSkill()) {
                                     if(jp.JobID != JobID) {
                                         return
                                     }

                                     if(jp.level < needLevel) {
                                         return
                                     }

                                     val skill = jp.selectedSkill

                                     if(skill == ID.toLowerCase()) {
                                         if(jp.skillStatus == SkillStatus.DISABLED) {
                                             e.player.playSound(e.player.location, Sound.UI_BUTTON_CLICK,0.5F,1.3F)
                                             jp.skillStatus = SkillStatus.ENABLED

                                             val event = SkillUseEvent(jp,skill)
                                             Bukkit.getServer().pluginManager.callEvent(event)
                                         }
                                     }
                                 }
                             }
                         }
                     }
}