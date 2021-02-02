package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class GrantExp(plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        if(args.size < 2) {
            player.sendMessage("${ChatColor.BOLD}引数が足りません")
            return
        }

        val target = (if (Bukkit.getPlayer(args[0]) != null) Bukkit.getPlayer(args[0]) else return) ?: return
        val exp = args[1].toDoubleOrNull() ?: return

        if(Main.sqlUtil.isExists(target)) {
            Main.sqlUtil.setExp(target,Main.sqlUtil.getLevel(target) + exp)
            player.sendMessage("${target.name}のレベルを${exp}あげました")
        }
    }

    override fun name(): String {
        return "grantexp"
    }

    override fun info(): String {
        return ""
    }

    override fun aliases(): Array<String> {
        return arrayOf(String())
    }

}
