package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Material
import org.bukkit.event.Listener

class CrafterSkills(plugin : Main) {

    init {
        plugin.server.pluginManager.registerEvents(RandomEffect1(plugin),plugin)
        plugin.server.pluginManager.registerEvents(RandomEffect2(plugin),plugin)
        plugin.server.pluginManager.registerEvents(RandomEffect3(plugin),plugin)
        plugin.server.pluginManager.registerEvents(RandomUpgrade(plugin),plugin)
    }

    class RandomEffect1(plg : Main) : SkillProvider(plg, Jobs.CRAFTER), Listener {

    }

    class RandomEffect2(plg : Main) : SkillProvider(plg, Jobs.CRAFTER), Listener {

    }

    class RandomEffect3(plg : Main) : SkillProvider(plg, Jobs.CRAFTER), Listener {

    }

    class RandomUpgrade(plg : Main) : SkillProvider(plg, Jobs.CRAFTER), Listener {

    }
}