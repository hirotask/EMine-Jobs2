package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.event.Event

class SetSkill(val plugin : Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        if(args.isEmpty()) {
            player.sendMessage("${ChatColor.BOLD}引数を指定してください")
            return
        }

        val skill = Skill(plugin,args[0])
        val jp = JobPlayer(player,plugin)
        jp.selectedSkill = skill

        player.sendMessage("スキルを${ChatColor.YELLOW}${skill.name}${ChatColor.WHITE}に設定しました")
    }

    override fun name(): String {
        return "setskill"
    }

    override fun info(): String {
        return ""
    }

    override fun aliases(): Array<String> {
        return arrayOf(String())
    }
}