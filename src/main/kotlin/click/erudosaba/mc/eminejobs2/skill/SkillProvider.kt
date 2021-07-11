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
    fun block(jp : JobPlayer, skill : Skill) : Boolean {

        if(jp.hasJob()) {
            if(jp.hasSkill()){
                if(jp.selectedSkill == skill) {
                    if(jp.skillStatus == SkillStatus.ENABLED) {
                        if(jp.JobID == job) {
                            return false
                        }
                    }
                }
            }
        }
        return true
    }

    //Enabledされる前のブロック
    fun activateBlock(jp : JobPlayer, skillManager : SkillManager, skill : Skill) : Boolean {
        if(jp.player.isSneaking) {
            if(jp.hasSkill()){
                if(jp.hasJob()) {
                    if(jp.JobID == jp.selectedSkill.job) {
                        if(jp.selectedSkill == skill) {
                            if(jp.level >= skillManager.getSkillOption(jp.selectedSkill).needLevel) {
                                if(jp.skillStatus == SkillStatus.DISABLED) {
                                    return false
                                }
                            }
                        }
                    }
                }
            }
        }
        return true

    }
}