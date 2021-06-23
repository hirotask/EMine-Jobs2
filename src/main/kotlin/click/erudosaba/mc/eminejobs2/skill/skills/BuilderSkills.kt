package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Material
import org.bukkit.event.Listener

class BuilderSkills(plugin : Main) {

    init {
        plugin.server.pluginManager.registerEvents(Protean(plugin),plugin)
        plugin.server.pluginManager.registerEvents(Levitation(plugin),plugin)
    }

    class Protean(plg : Main) : SkillProvider(plg, Jobs.BUILDER), Listener {

    }

    class Levitation(plg : Main) : SkillProvider(plg, Jobs.BUILDER), Listener {

    }
}