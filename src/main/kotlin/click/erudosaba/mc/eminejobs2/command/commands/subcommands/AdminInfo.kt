package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.jetbrains.annotations.Nullable

class AdminInfo(plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        if (args.isEmpty()) {
            player.sendMessage("${ChatColor.BOLD}引数を指定してください")
            return
        }

        val target = (if (Bukkit.getPlayer(args[0]) != null) Bukkit.getPlayer(args[0]) else return) ?: return

        if (!Main.sqlUtil.isExists(target)) {
            player.sendMessage("${target.name} は職業に就いていません")
            return
        } else {
            val messages = arrayOf(
                    "プレイヤー名： ${target.name}",
                    "職業： ${Main.sqlUtil.getJob(target)}",
                    "レベル； ${Main.sqlUtil.getLevel(target)}",
                    "経験値： ${Main.sqlUtil.getExp(target)}"
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
