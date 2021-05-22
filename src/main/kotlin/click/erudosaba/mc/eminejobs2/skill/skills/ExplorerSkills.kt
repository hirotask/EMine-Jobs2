package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Material
import org.bukkit.event.Listener

class ExplorerSkills(plugin : Main) {

    init {
        plugin.server.pluginManager.registerEvents(WallClimb(plugin),plugin)
        plugin.server.pluginManager.registerEvents(FrostWalk(plugin),plugin)
    }

    class WallClimb(plg : Main) : SkillProvider(plg, Jobs.EXPLORER), Listener {

    }

    class FrostWalk(plg : Main) : SkillProvider(plg, Jobs.EXPLORER), Listener {

    }
}