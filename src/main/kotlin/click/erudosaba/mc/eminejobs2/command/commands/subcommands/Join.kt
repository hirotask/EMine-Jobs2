package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import click.erudosaba.mc.eminejobs2.event.PlayerJobJoinEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class Join(val plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        if(args.isEmpty()) {
            player.sendMessage("${ChatColor.BOLD}引数を指定してください")
            return
        }

        val job = Jobs.valueOf(args[0].toUpperCase())
        val jobName = job.Jobname

        if(jobName == "NULL") {
            player.sendMessage("そのような職業は存在しません")
            return
        }

        for (jp in Main.jPlayers) {
            if (jp.playerName == player.name) {
                if(jp.level <= 20) {
                    jp.exp = 0.0
                    jp.level = 0
                    jp.jobID = job
                    jp.skillStatus = SkillStatus.DISABLED
                    player.sendMessage("あなたはレベルをリセットし，${ChatColor.YELLOW}${jobName}${ChatColor.WHITE}に転職しました")

                    val event = PlayerJobJoinEvent(jp,Jobs.valueOf(args[0].toUpperCase()))
                    Bukkit.getServer().pluginManager.callEvent(event)
                    return
                } else {
                    player.sendMessage("あなたはレベルが20より大きいのため転職できません")
                    return
                }
            }
        }

        player.sendMessage("あなたは${ChatColor.YELLOW}${jobName}${ChatColor.WHITE}に就きました")
        val jp = JobPlayer(player.uniqueId,player.name, job, 0.0, 0, null, SkillStatus.DISABLED)
        Main.jPlayers.add(jp)

        val event = PlayerJobJoinEvent(jp,Jobs.valueOf(args[0].toUpperCase()))
        Bukkit.getServer().pluginManager.callEvent(event)
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
