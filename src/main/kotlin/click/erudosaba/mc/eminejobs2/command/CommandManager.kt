package click.erudosaba.mc.eminejobs2.command

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import click.erudosaba.mc.eminejobs2.command.commands.subcommands.Help
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.lang.Exception

class CommandManager(private val plugin: Main) : CommandExecutor {

    private val mainCommand = "emj"
    private lateinit var commands : MutableList<SubCommand>

    fun setup() {
        plugin.getCommand(mainCommand)?.setExecutor(this)

        this.commands.add(Help(plugin))
    }

    override fun onCommand(p0: CommandSender, p1: Command, p2: String, p3: Array<out String>): Boolean {
        if(p0 !is Player) {
            Bukkit.getLogger().warning("Only players can run this command!")
            return true
        }

        val player: Player = p0

        if(p1.name.equals(mainCommand,true)) {
            if(p3.isEmpty()) {
                player.sendMessage("引数が0です")
                return true
            }

            val target = this.get(p3[0])

            if(target == null) {
                player.sendMessage("invalid command")
                return true
            }

            val list : MutableList<String> = ArrayList<String>()
            list.addAll(p3)
            list.removeAt(0)

            try {
                target.onCommand(player=player,args=list.toTypedArray())
            } catch(e: Exception) {
                player.sendMessage("error command")
                e.printStackTrace()
            }

        }

        return true
    }

    fun get(name: String) : SubCommand? {
        val subcommands = this.commands.iterator()

        while(subcommands.hasNext()) {
            val sc = subcommands.next()

            if(sc.name().equals(name,true)) {
                return sc
            }

            val aliases : Array<String> = sc.aliases()

            for(alias in aliases) {
                if(name.equals(alias,true)) {
                    return sc
                }
            }
        }

        return null
    }


}
