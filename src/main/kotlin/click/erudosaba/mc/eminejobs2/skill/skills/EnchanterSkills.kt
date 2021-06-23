package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Material
import org.bukkit.event.Listener

class EnchanterSkills(plugin : Main) {


    init {
        plugin.server.pluginManager.registerEvents(TransEnchant(plugin),plugin)
    }

    class TransEnchant(plg : Main) : SkillProvider(plg, Jobs.ENCHANTER), Listener {

    }
}