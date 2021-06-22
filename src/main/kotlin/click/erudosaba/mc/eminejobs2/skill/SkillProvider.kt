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

abstract class SkillProvider(val plugin : Main, val job : Jobs) : Listener {


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
            return true
        }
        if(!jp.hasJob()) {
            return true
        }

        if(jp.JobID != jp.selectedSkill.job) {
            return true
        }

        if(jp.skillStatus != SkillStatus.DISABLED) {
            return true
        }

        if(jp.level < skillManager.getSkillOption(jp.selectedSkill)!!.needLevel) {
            return true
        }

        if(!jp.player.isSneaking) {
            return true
        }

        return false

    }
}