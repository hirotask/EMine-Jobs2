package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class Promote(val plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        if(args.size < 2) {
            player.sendMessage("${ChatColor.BOLD}引数が足りません")
            return
        }

        val target = (if (Bukkit.getPlayer(args[0]) != null) Bukkit.getPlayer(args[0]) else return) ?: return
        val level = args[1].toIntOrNull() ?: return

        if(level <= 0) {
            player.sendMessage("1以上の自然数を入力してください")
            return
        }

        for (jp in Main.jPlayers) {
            if (jp.uuid == Bukkit.getPlayer(target.name)?.uniqueId) {
                jp.level += level
                player.sendMessage("${target.name}のレベルを${level}あげました")

            }
        }
    }

    override fun name(): String {
        return "promote"
    }

    override fun info(): String {
        return ""
    }

    override fun aliases(): Array<String> {
        return arrayOf(String())
    }

}
