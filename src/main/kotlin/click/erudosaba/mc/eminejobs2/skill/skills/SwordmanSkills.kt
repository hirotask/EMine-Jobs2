package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Material
import org.bukkit.event.Listener

class SwordmanSkills(plugin : Main) {

    init {
        plugin.server.pluginManager.registerEvents(Slash1(plugin),plugin)
        plugin.server.pluginManager.registerEvents(Slash2(plugin),plugin)
        plugin.server.pluginManager.registerEvents(Slash3(plugin),plugin)
    }

    class Slash1(plg : Main) : SkillProvider(plg, Jobs.SWORDMAN), Listener {

    }

    class Slash2(plg : Main) : SkillProvider(plg, Jobs.SWORDMAN), Listener {

    }

    class Slash3(plg : Main) : SkillProvider(plg, Jobs.SWORDMAN), Listener {

    }
}