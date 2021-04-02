package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.SkillUseEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.SkillManager
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class OnInteract(val plugin : Main) : Listener {

    @EventHandler
    fun onInteract(e : PlayerInteractEvent) {
        if(e.action == Action.RIGHT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_AIR) {
            val player = e.player
            if(player.isSneaking) {
                val jp = JobPlayer(player, plugin)

                if(jp.hasJob() && jp.hasSkill()) {
                    val skill = jp.selectedSkill
                    val skillmanager = SkillManager(plugin, jp)

                    skillmanager.run(skill)
                }
            }
        }
    }

}