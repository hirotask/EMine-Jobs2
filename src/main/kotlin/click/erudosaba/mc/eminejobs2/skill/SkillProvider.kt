package click.erudosaba.mc.eminejobs2.skill

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs

open class SkillProvider(val plugin : Main, val job : Jobs) {

    fun block(jp : JobPlayer) : Boolean {
        if(!jp.hasSkill()){
            return false
        }
        if(!jp.hasJob()) {
            return false
        }
        if(jp.skillStatus != SkillStatus.ENABLED) {
            return false
        }

        val skillManager = SkillManager(plugin)

        if(jp.level < skillManager.getSkillOption(jp.selectedSkill)!!.needLevel) {
            return false
        }

        if(jp.JobID != job) {
            return false
        }

        return true
    }

}