package click.erudosaba.mc.eminejobs2.skill

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.SkillUseEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.event.Listener

open class SkillProvider(val plugin : Main, val job : Jobs) : Listener {


    //Enabledされている後のブロック
    fun block(jp : JobPlayer, skillManager: SkillManager) : Boolean {
        if(!jp.hasSkill()){
            return false
        }
        if(!jp.hasJob()) {
            return false
        }
        if(jp.skillStatus != SkillStatus.ENABLED) {
            return false
        }

        if(jp.level < skillManager.getSkillOption(jp.selectedSkill)!!.needLevel) {
            return false
        }

        if(jp.JobID != job) {
            return false
        }

        return true
    }

    //Enabledされる前のブロック
    fun activateBlock(jp : JobPlayer, skillManager : SkillManager) : Boolean{
        if(!jp.hasSkill()){
            return false
        }
        if(!jp.hasJob()) {
            return false
        }

        if(jp.JobID != jp.selectedSkill.job) {
            return false
        }

        if(jp.skillStatus == SkillStatus.ENABLED) {
            return false
        }

        if(jp.level < skillManager.getSkillOption(jp.selectedSkill)!!.needLevel) {
            return false
        }

        return true

    }

}