package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class Employ(plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        //レベルを強制的にリセットし，転職させる

        if(args.size < 2) {
            player.sendMessage("${ChatColor.BOLD}引数が足りません")
            return
        }

        val target = (if (Bukkit.getPlayer(args[0]) != null) Bukkit.getPlayer(args[0]) else return) ?: return
        val job = args[1]

        if(Main.sqlUtil.isExists(target)) {
            Main.sqlUtil.delete(target)
        }
        Main.sqlUtil.insert(target,job)
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
