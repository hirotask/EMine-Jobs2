package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import click.erudosaba.mc.eminejobs2.event.PlayerJobJoinEvent
import click.erudosaba.mc.eminejobs2.jobs.Job
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class Join(val plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        if(args.isEmpty()) {
            player.sendMessage("${ChatColor.BOLD}引数を指定してください")
            return
        }

        val job = Job(plugin,args[0])
        val jobName = job.JobName

        if(jobName == null) {
            player.sendMessage("そのような職業は存在しません")
            return
        }

        if(!plugin.sqlUtil.isExists(player)) {
            plugin.sqlUtil.insert(player,args[0])
            player.sendMessage("あなたは${ChatColor.YELLOW}${jobName}${ChatColor.WHITE}に就きました")

            val event = PlayerJobJoinEvent(JobPlayer(player,plugin),args[0])
            Bukkit.getServer().pluginManager.callEvent(event)
        } else {
            if(plugin.sqlUtil.getLevel(player) <= 20) {
                plugin.sqlUtil.delete(player)
                plugin.sqlUtil.insert(player,args[0])
                player.sendMessage("あなたはレベルをリセットし，${ChatColor.YELLOW}${jobName}${ChatColor.WHITE}に転職しました")

                val event = PlayerJobJoinEvent(JobPlayer(player,plugin),args[0])
                Bukkit.getServer().pluginManager.callEvent(event)
            } else {
                player.sendMessage("あなたはレベルが20より大きいのため転職できません")
                return
            }
        }
    }

    override fun name(): String {
        return "join"
    }

    override fun info(): String {
        return ""
    }

    override fun aliases(): Array<String> {
        return arrayOf(String())
    }

}
