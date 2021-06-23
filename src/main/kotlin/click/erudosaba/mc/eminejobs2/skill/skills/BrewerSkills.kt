package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Material
import org.bukkit.event.Listener

class BrewerSkills(plugin : Main) {

    init {
        plugin.server.pluginManager.registerEvents(FastBrewing1(plugin),plugin)
        plugin.server.pluginManager.registerEvents(FastBrewing2(plugin),plugin)
        plugin.server.pluginManager.registerEvents(FastBrewing3(plugin),plugin)
    }


    class FastBrewing1(plg : Main) : SkillProvider(plg, Jobs.BREWER), Listener {

    }

    class FastBrewing2(plg : Main) : SkillProvider(plg,Jobs.BREWER), Listener {

    }

    class FastBrewing3(plg : Main) : SkillProvider(plg,Jobs.BREWER), Listener {

    }
}