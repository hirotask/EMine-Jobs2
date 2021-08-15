package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class Transfer(val plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        if(args.size < 2) {
            player.sendMessage("${ChatColor.BOLD}引数が足りません")
            return
        }

        val target = (if (Bukkit.getPlayer(args[0]) != null) Bukkit.getPlayer(args[0]) else return) ?: return
        val newjob = args[1].toUpperCase()

        val job = Jobs.valueOf(args[0].toUpperCase())
        val jobName = job.name

        if(jobName == "NULL") {
            player.sendMessage("そのような職業は存在しません")
            return
        }

        for (jp in Main.jPlayers) {
            if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                jp.jobID = job
                player.sendMessage("${target.name}を${jobName}に就かせました")
                return
            }
        }
        player.sendMessage("${target.name}は無職です")

    }

    override fun name(): String {
        return "transfer"
    }

    override fun info(): String {
        return ""
    }

    override fun aliases(): Array<String> {
        return arrayOf(String())
    }

}
