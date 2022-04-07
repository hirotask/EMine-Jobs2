package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import click.erudosaba.mc.eminejobs2.gui.menu.SkillMenu
import org.bukkit.entity.Player

class Skills(val plg : Main) :  SubCommand() {

    override fun onCommand(player: Player, args: Array<String>) {
        SkillMenu(plg,player).open()
    }

    override fun name(): String {
        return "skills"
    }

    override fun info(): String {
        return ""
    }

    override fun aliases(): Array<String> {
        return arrayOf(String())
    }
}