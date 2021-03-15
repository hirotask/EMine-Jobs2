package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import click.erudosaba.mc.eminejobs2.event.PlayerJobLeaveEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import org.bukkit.Bukkit
import org.bukkit.entity.Player

class Leave(val plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        if(!plugin.sqlUtil.isExists(player)) {
            return
        }

        val jobPlayer = JobPlayer(player,plugin)
        val event = PlayerJobLeaveEvent(jobPlayer,jobPlayer.jobName)
        Bukkit.getServer().pluginManager.callEvent(event)

        plugin.sqlUtil.delete(player)
        player.sendMessage("正常に退職しました")
    }

    override fun name(): String {
        return "leave"
    }

    override fun info(): String {
        return ""
    }

    override fun aliases(): Array<String> {
        return arrayOf(String())
    }

}
