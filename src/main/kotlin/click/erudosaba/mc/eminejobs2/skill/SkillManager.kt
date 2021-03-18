package click.erudosaba.mc.eminejobs2.skill

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.SkillUseEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.effect.Effect
import org.bukkit.Bukkit

class SkillManager(private val plugin: Main, private val jp: JobPlayer) {

    val selectedSkill: Skill = jp.selectedSkill

    fun run(skill : Skill) {
        if(jp.level < skill.needLevel) {
            return
        }
        if(jp.JobID != skill.jobID) {
            return
        }

        /*
        when(skill.effect) {
            Effect.AlwaysFull -> {

            }
        }*/

        val event = SkillUseEvent(jp,skill)
        Bukkit.getServer().pluginManager.callEvent(event)
    }

}