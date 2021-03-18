package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import click.erudosaba.mc.eminejobs2.event.PlayerJobLeaveEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class Fire(val plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        if(args.isEmpty()) {
            player.sendMessage("${ChatColor.BOLD}引数を指定してください")
            return
        }

        val target = (if (Bukkit.getPlayer(args[0]) != null) Bukkit.getPlayer(args[0]) else return) ?: return

        if(!plugin.sqlUtil.isExists(target)) {
            player.sendMessage("${target.name}は職業に就いていません")
        } else{
            val jobPlayer = JobPlayer(target,plugin)
            val event = PlayerJobLeaveEvent(jobPlayer,jobPlayer.JobiD)
            Bukkit.getServer().pluginManager.callEvent(event)

            plugin.sqlUtil.delete(target)
            player.sendMessage("${target.name}をクビにしました")

        }
    }

    override fun name(): String {
        return "fire"
    }

    override fun info(): String {
        return ""
    }

    override fun aliases(): Array<String> {
        return arrayOf(String())
    }

}
