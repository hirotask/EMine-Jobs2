package click.erudosaba.mc.eminejobs2.runnable

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.Job
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import click.erudosaba.mc.eminejobs2.skill.effect.Effect
import org.bukkit.Bukkit
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scheduler.BukkitTask

class SkillRunnable(val plugin : Main, val jp : JobPlayer, val time : Int) : BukkitRunnable(){

    var count = time

    override fun run() {
        if(count < 0) {
            jp.skillStatus = SkillStatus.INTERVAL
            this.cancel()
        } else {
            jp.player.sendMessage("count=$count")
            count--
        }
    }
}