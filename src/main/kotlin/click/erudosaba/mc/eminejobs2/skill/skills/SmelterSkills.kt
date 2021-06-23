package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Material
import org.bukkit.event.Listener
import kotlin.math.ln1p

class SmelterSkills(plugin : Main) {

    init {
        plugin.server.pluginManager.registerEvents(Smelt1(plugin),plugin)
        plugin.server.pluginManager.registerEvents(Smelt2(plugin),plugin)
        plugin.server.pluginManager.registerEvents(Smelt3(plugin),plugin)
    }


    class Smelt1(plg : Main) : SkillProvider(plg, Jobs.SMELTER), Listener {

    }

    class Smelt2(plg : Main) : SkillProvider(plg, Jobs.SMELTER), Listener {

    }

    class Smelt3(plg : Main) : SkillProvider(plg, Jobs.ENCHANTER), Listener {

    }
}