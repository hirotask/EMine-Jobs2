package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import java.lang.Exception

class SetSkill(val plugin : Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        if(args.size < 2) {
            player.sendMessage("${ChatColor.BOLD}引数が足りません")
            return
        }

        val target = (if (Bukkit.getPlayer(args[0]) != null) Bukkit.getPlayer(args[0]) else return) ?: return

        val skill = args[1]
        val jp = JobPlayer(target,plugin)

        try {
            jp.selectedSkill = Skill.valueOf(skill.toUpperCase())
            player.sendMessage("${target.name}のスキルを${ChatColor.YELLOW}${skill}${ChatColor.WHITE}に設定しました")
        }catch (e : Exception) {
            player.sendMessage("そのようなスキルは存在しません")
        }
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