package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Material
import org.bukkit.event.Listener

class DiggerSkills(plugin : Main) {

    init {
        plugin.server.pluginManager.registerEvents(DirtHaste1(plugin),plugin)
        plugin.server.pluginManager.registerEvents(DirtHaste2(plugin),plugin)
        plugin.server.pluginManager.registerEvents(DirtHaste3(plugin),plugin)
        plugin.server.pluginManager.registerEvents(DigAll(plugin),plugin)
    }

    class DirtHaste1(plg : Main) : SkillProvider(plg, Jobs.DIGGER), Listener {

    }

    class DirtHaste2(plg : Main) : SkillProvider(plg, Jobs.DIGGER), Listener {

    }

    class DirtHaste3(plg : Main) : SkillProvider(plg, Jobs.DIGGER), Listener {

    }

    class DigAll(plg : Main) : SkillProvider(plg, Jobs.DIGGER), Listener {

    }
}