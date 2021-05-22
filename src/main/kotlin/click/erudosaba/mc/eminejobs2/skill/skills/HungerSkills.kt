package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Material
import org.bukkit.event.Listener

class HungerSkills(plugin : Main) {

    init {
        plugin.server.pluginManager.registerEvents(NoSlow1(plugin),plugin)
        plugin.server.pluginManager.registerEvents(NoSlow2(plugin),plugin)
        plugin.server.pluginManager.registerEvents(AlwaysFull(plugin),plugin)
    }

    class NoSlow1(plg : Main) : SkillProvider(plg, Jobs.HUNGER), Listener {

    }

    class NoSlow2(plg : Main) : SkillProvider(plg, Jobs.HUNGER), Listener{

    }

    class AlwaysFull(plg : Main) : SkillProvider(plg, Jobs.HUNGER), Listener {

    }
}