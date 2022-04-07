package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.util.SideBar
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import java.lang.Exception

class Showstats(val plugin : Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        for (jp in Main.jPlayers) {
            if (jp.playerName == player.name) {
                SideBar(plugin, player)
            }
        }
    }

    override fun name(): String {
        return "showstats"
    }

    override fun info(): String {
        return ""
    }

    override fun aliases(): Array<String> {
        return arrayOf(String())
    }
}