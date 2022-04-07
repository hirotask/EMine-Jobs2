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

        for(jp in Main.jPlayers) {
            if(jp.playerName == target.name){
                val messages = arrayOf(
                        "プレイヤー名： ${jp.playerName}",
                        "職業： ${jp.jobID.Jobname}",
                        "レベル； ${jp.level}",
                        "経験値： ${jp.exp}"
                )

                messages.forEach { s -> player.sendMessage(s) }
                return
            }
        }
        player.sendMessage("${target.name} は職業に就いていません")
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
