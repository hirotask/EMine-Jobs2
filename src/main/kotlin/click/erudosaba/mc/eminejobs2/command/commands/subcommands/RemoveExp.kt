package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class RemoveExp(val plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        if(args.size < 2) {
            player.sendMessage("${ChatColor.BOLD}引数が足りません")
            return
        }

        val target = (if (Bukkit.getPlayer(args[0]) != null) Bukkit.getPlayer(args[0]) else return) ?: return
        val exp = args[1].toDoubleOrNull() ?: return

        if(exp <= 0) {
            player.sendMessage("正の実数を入力してください")
            return
        }

        if(plugin.sqlUtil.isExists(target)) {
            if(plugin.sqlUtil.getLevel(target) - exp < 0) {
                player.sendMessage("マイナスの値になるため経験値を0に設定しました")
                plugin.sqlUtil.setExp(target,0.0)
            } else {
                plugin.sqlUtil.setExp(target,plugin.sqlUtil.getLevel(target) - exp)
                player.sendMessage("${target.name}のレベルを${exp}さげました")
            }
        }
    }

    override fun name(): String {
        return "removeexp"
    }

    override fun info(): String {
        return ""
    }

    override fun aliases(): Array<String> {
        return arrayOf(String())
    }

}
