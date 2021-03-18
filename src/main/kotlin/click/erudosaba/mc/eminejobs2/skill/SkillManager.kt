package click.erudosaba.mc.eminejobs2.skill

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import org.bukkit.entity.Player

class SkillManager(private val plugin: Main, private val player: Player) {

    val selectedSkill: Skill = JobPlayer(player, plugin).selectedSkill

}