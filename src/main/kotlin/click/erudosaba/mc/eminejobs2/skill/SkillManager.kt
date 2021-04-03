package click.erudosaba.mc.eminejobs2.skill

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.SkillUseEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.runnable.SkillRunnable
import click.erudosaba.mc.eminejobs2.skill.effect.Effect
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scheduler.BukkitTask

class SkillManager(private val plugin: Main, private val jp: JobPlayer) {

    fun run(skill: Skill, time: Int, interval : Int) {
        val effect = jp.selectedSkill.effect
        val player = jp.player

        //何回も発動するのを防止
        if (jp.skillStatus == SkillStatus.NONE) {
            jp.player.playSound(jp.player.location,Sound.UI_BUTTON_CLICK,0.5F,1.3F)
            jp.skillStatus = SkillStatus.RUNNING

            SkillRunnable(plugin,jp,time,interval).runTaskTimer(plugin,0,20)

            val event = SkillUseEvent(jp, skill)
            Bukkit.getServer().pluginManager.callEvent(event)
        }
    }

}