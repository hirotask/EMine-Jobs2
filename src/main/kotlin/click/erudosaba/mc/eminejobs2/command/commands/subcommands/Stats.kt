package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class Stats(val plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        if(!plugin.sqlUtil.isExists(player)) {
            player.sendMessage("${ChatColor.BOLD}あなたは職業についていません")
            return
        }

        val messages = arrayOf(
                "=========================",
                "職業： ${plugin.sqlUtil.getJob(player)}",
                "レベル： ${plugin.sqlUtil.getLevel(player)}",
                "現在の経験値： ${plugin.sqlUtil.getExp(player)}"
        )

        messages.forEach { s -> player.sendMessage(s)}
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
