package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import click.erudosaba.mc.eminejobs2.event.PlayerJobJoinEvent
import click.erudosaba.mc.eminejobs2.event.PlayerJobLeaveEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class Fire(val plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        if(args.isEmpty()) {
            player.sendMessage("${ChatColor.BOLD}引数を指定してください")
            return
        }

        val target = (if (Bukkit.getPlayer(args[0]) != null) Bukkit.getPlayer(args[0]) else return) ?: return


        for(jp in Main.jPlayers) {
            if (jp.uuid == Bukkit.getPlayer(target.name)?.uniqueId) {
                val event = PlayerJobLeaveEvent(jp,jp.jobID)
                Bukkit.getServer().pluginManager.callEvent(event)
                Main.jPlayers.remove(jp)

                player.sendMessage("${target.name}をクビにしました")
            }
        }
        player.sendMessage("${target.name}は職業に就いていません")

    }

    override fun name(): String {
        return "fire"
    }

    override fun info(): String {
        return ""
    }

    override fun aliases(): Array<String> {
        return arrayOf(String())
    }

}
