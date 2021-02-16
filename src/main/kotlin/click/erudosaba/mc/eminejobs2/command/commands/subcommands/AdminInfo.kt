package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.jetbrains.annotations.Nullable

class AdminInfo(val plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        if (args.isEmpty()) {
            player.sendMessage("${ChatColor.BOLD}引数を指定してください")
            return
        }

        val target = (if (Bukkit.getPlayer(args[0]) != null) Bukkit.getPlayer(args[0]) else return) ?: return

        if (!plugin.sqlUtil.isExists(target)) {
            player.sendMessage("${target.name} は職業に就いていません")
            return
        } else {
            val messages = arrayOf(
                    "プレイヤー名： ${target.name}",
                    "職業： ${plugin.sqlUtil.getJob(target)}",
                    "レベル； ${plugin.sqlUtil.getLevel(target)}",
                    "経験値： ${plugin.sqlUtil.getExp(target)}"
            )

            messages.forEach { s -> player.sendMessage(s) }
        }
    }

    override fun name(): String {
        return "admininfo"
    }

    override fun info(): String {
        return ""
    }

    override fun aliases(): Array<String> {
        return arrayOf(String())
    }

}
