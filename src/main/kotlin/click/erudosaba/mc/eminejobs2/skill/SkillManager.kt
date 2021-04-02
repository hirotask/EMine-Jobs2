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

class SkillManager(private val plugin: Main, private val jp: JobPlayer) {

    fun run(skill : Skill, time : Int = 0) {
        if(jp.skillStatus == SkillStatus.RUNNING) {
            return
        }

        jp.skillStatus = SkillStatus.RUNNING

        if(skill.effect.skilltime == 0) { //即発動のスキル
            val instantSkill = SkillRunnable(plugin, jp)
            val task = plugin.server.scheduler.runTaskTimer(plugin,instantSkill,0,1)
            instantSkill.task = task
        } else {
            val skillRun = SkillRunnable(plugin, jp)
            val task = plugin.server.scheduler.runTaskTimer(plugin,skillRun,0,20)
            skillRun.task = task
        }

        val event = SkillUseEvent(jp,skill)
        Bukkit.getServer().pluginManager.callEvent(event)
    }

}