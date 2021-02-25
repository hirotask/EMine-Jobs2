package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import org.bukkit.entity.Player

class Reload(val plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        plugin.myConfig.reload()
        player.sendMessage("リロードが完了しました")
    }

    override fun name(): String {
        return "reload"
    }

    override fun info(): String {
        return ""
    }

    override fun aliases(): Array<String> {
        return arrayOf(String())
    }

}
