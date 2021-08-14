package click.erudosaba.mc.eminejobs2.skill

import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import org.bukkit.event.Listener

abstract class SkillProvider : Listener {


    //Enabledされている後のブロック
    fun block(jp: JobPlayer): Boolean {

        if (jp.hasJob()) {
            if (jp.hasSkill()) {
                if (jp.skillStatus == SkillStatus.ENABLED) {
                    if (jp.JobID == jp.selectedSkill.job) {
                        return false
                    }
                }
            }
        }
        return true
    }
}