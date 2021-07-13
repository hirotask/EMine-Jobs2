package click.erudosaba.mc.eminejobs2.skill

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.SkillUseEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent

abstract class SkillProvider : Listener {


    //Enabledされている後のブロック
    fun block(jp: JobPlayer): Boolean {

        if (jp.hasJob()) {
            if (jp.hasSkill()) {
                if (jp.skillStatus == SkillStatus.ENABLED) {
                    if (jp.JobID == jp.selectedSkill.job) {
                        return false
                    }
                }
            }
        }
        return true
    }
}