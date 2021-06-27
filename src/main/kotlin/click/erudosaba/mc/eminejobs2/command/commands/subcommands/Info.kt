package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class Info(plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        val job = Jobs.valueOf(args[0].toUpperCase())
        val id = job.name
        val jobName = job.Jobname
        val category = job.jobCategory.name
        val exp = job.jobExp
        val skills = mutableListOf<String>()

        for (skill in Skill.values()) {
            if (skill.job == job) {
                skills.add(skill.name)
            }
        }

        val array = arrayOf(
                "${ChatColor.YELLOW}========================="
                ,"ID：${ChatColor.AQUA}$id"
                ,"名前：${ChatColor.AQUA}$jobName"
                ,"経験値カテゴリ：${ChatColor.AQUA}$category"
                ,"獲得経験値：${ChatColor.AQUA}$exp"
                ,"${ChatColor.YELLOW}========================="
                )

        for(a in array) player.sendMessage(a)
    }

    override fun name(): String {
        return "info"
    }

    override fun info(): String {
        return ""
    }

    override fun aliases(): Array<String> {
        return arrayOf(String())
    }

}
