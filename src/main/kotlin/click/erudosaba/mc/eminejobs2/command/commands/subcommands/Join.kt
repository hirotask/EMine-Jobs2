package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import click.erudosaba.mc.eminejobs2.jobs.JobManager
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class Join(val plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        if(args.isEmpty()) {
            player.sendMessage("${ChatColor.BOLD}引数を指定してください")
            return
        }

        val job = JobManager(plugin,args[0])
        val jobName = job.JobName

        if(!plugin.sqlUtil.isExists(player)) {
            plugin.sqlUtil.insert(player,jobName)
            player.sendMessage("あなたは${ChatColor.YELLOW}${jobName}に就きました")
        } else {
            if(plugin.sqlUtil.getLevel(player) <= 20) {
                plugin.sqlUtil.delete(player)
                plugin.sqlUtil.insert(player,jobName)
                player.sendMessage("あなたはレベルをリセットし，${ChatColor.YELLOW}${jobName}に転職しました")
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
