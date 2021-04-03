package click.erudosaba.mc.eminejobs2.runnable

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import org.bukkit.scheduler.BukkitRunnable

class SkillRunnable(val plugin : Main, val jp : JobPlayer, var time : Int, var interval : Int) : BukkitRunnable(){

    override fun run() {
        if(time <= 0) {
            jp.skillStatus = SkillStatus.INTERVAL
            IntervalRunnable(jp,interval).runTaskTimer(plugin,0,20)
            this.cancel()
        }
        time--
    }
}