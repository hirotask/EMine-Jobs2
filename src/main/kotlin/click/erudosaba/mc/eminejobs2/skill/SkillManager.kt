package click.erudosaba.mc.eminejobs2.skill

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer

class SkillManager(private val plugin: Main, private val jp: JobPlayer) {

    val selectedSkill: Skill = jp.selectedSkill

    fun run(skill : Skill) {
        if(jp.level < skill.needLevel) {
            return
        }
        if(jp.JobiD != skill.jobID) {
            return
        }


    }

}