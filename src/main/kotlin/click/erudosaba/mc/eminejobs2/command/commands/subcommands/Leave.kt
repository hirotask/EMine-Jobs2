package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import org.bukkit.entity.Player

class Leave(plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        if(!Main.sqlUtil.isExists(player)) {
            return
        }

        Main.sqlUtil.delete(player)
        player.sendMessage("正常に退職しました")
    }

    override fun name(): String {
        return "leave"
    }

    override fun info(): String {
        return ""
    }

    override fun aliases(): Array<String> {
        return arrayOf(String())
    }

}
