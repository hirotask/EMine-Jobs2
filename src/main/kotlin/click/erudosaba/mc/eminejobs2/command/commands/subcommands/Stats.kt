package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class Stats(val plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        for (jp in Main.jPlayers) {
            if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                val messages = arrayOf(
                        "${ChatColor.YELLOW}=========================",
                        "職業： ${jp.jobID.Jobname}",
                        "レベル： ${jp.level}",
                        "現在の経験値： ${jp.exp}",
                        "${ChatColor.YELLOW}========================="
                )

                messages.forEach { s -> player.sendMessage(s) }
                return
            }
        }
        player.sendMessage("${ChatColor.BOLD}あなたは職業についていません")
    }

    override fun name(): String {
        return "stats"
    }

    override fun info(): String {
        return ""
    }

    override fun aliases(): Array<String> {
        return arrayOf(String())
    }

}
