package click.erudosaba.mc.eminejobs2.command.commands

import org.bukkit.entity.Player

abstract class SubCommand {

    abstract fun onCommand(player: Player, args: Array<String>)

    abstract fun name(): String

    abstract fun info() : String

    abstract fun aliases() : Array<String>


}
