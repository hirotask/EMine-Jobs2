package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Material
import org.bukkit.event.Listener

class FarmerSkills(plugin : Main) {

    init {
        plugin.server.pluginManager.registerEvents(Growing1(plugin),plugin)
        plugin.server.pluginManager.registerEvents(Growing2(plugin),plugin)
        plugin.server.pluginManager.registerEvents(Growing3(plugin),plugin)
        plugin.server.pluginManager.registerEvents(AutoHarvest(plugin),plugin)
    }

    class Growing1(plg : Main) : SkillProvider(plg, Jobs.FARMER), Listener{

    }

    class Growing2(plg : Main) : SkillProvider(plg, Jobs.FARMER), Listener{

    }

    class Growing3(plg : Main) : SkillProvider(plg, Jobs.FARMER), Listener {

    }

    class AutoHarvest(plg : Main) : SkillProvider(plg, Jobs.FARMER), Listener {

    }
}