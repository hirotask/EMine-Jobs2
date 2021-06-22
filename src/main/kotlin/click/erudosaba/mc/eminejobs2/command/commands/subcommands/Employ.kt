package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import click.erudosaba.mc.eminejobs2.event.PlayerJobJoinEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class Employ(val plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        //レベルを強制的にリセットし，転職させる

        if(args.size < 2) {
            player.sendMessage("${ChatColor.BOLD}引数が足りません")
            return
        }

        val target = (if (Bukkit.getPlayer(args[0]) != null) Bukkit.getPlayer(args[0]) else return) ?: return

        val job = Jobs.valueOf(args[1].toUpperCase())
        val jobName = job.name

        if(jobName == "NULL") {
            player.sendMessage("そのような職業は存在しません")
            return
        }

        if(plugin.sqlUtil.isExists(target)) {
            plugin.sqlUtil.delete(target)
        }
        plugin.sqlUtil.insert(target,args[1].toUpperCase())
        player.sendMessage("${target.name}を${jobName}に就かせました")

        val event = PlayerJobJoinEvent(JobPlayer(player,plugin),Jobs.valueOf(args[1].toUpperCase()))
        Bukkit.getServer().pluginManager.callEvent(event)
    }

    override fun name(): String {
        return "employ"
    }

    override fun info(): String {
        return ""
    }

    override fun aliases(): Array<String> {
        return arrayOf(String())
    }

}
