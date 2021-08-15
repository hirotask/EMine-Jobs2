package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import click.erudosaba.mc.eminejobs2.event.PlayerJobLeaveEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import org.bukkit.Bukkit
import org.bukkit.entity.Player

class Leave(val plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {

        for (jp in Main.jPlayers) {
            if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                val event = PlayerJobLeaveEvent(jp,jp.jobID)
                Bukkit.getServer().pluginManager.callEvent(event)

                Main.jPlayers.remove(jp)
                player.sendMessage("正常に退職しました")
            }
        }
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
