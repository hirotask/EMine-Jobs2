package click.erudosaba.mc.eminejobs2.runnable

import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import org.bukkit.scheduler.BukkitRunnable

class IntervalRunnable(val jp : JobPlayer,var interval : Int) : BukkitRunnable() {

    override fun run() {
        if(interval < 0) {
            jp.skillStatus = SkillStatus.NONE
            this.cancel()
        }
        interval--
    }
}