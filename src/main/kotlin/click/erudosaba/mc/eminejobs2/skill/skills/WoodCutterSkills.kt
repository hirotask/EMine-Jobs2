package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class WoodCutterSkills(plugin : Main) {

    init {
        plugin.server.pluginManager.registerEvents(WoodHaste1(plugin),plugin)
        plugin.server.pluginManager.registerEvents(WoodHaste2(plugin),plugin)
        plugin.server.pluginManager.registerEvents(WoodHaste3(plugin),plugin)
        plugin.server.pluginManager.registerEvents(CutAll(plugin),plugin)
    }

    class WoodHaste1(plg : Main) : SkillProvider(plg, Jobs.WOODCUTTER), Listener{

    }

    class WoodHaste2(plg : Main) : SkillProvider(plg, Jobs.WOODCUTTER), Listener{

    }

    class WoodHaste3(plg : Main) :SkillProvider(plg, Jobs.WOODCUTTER), Listener{

    }

    class CutAll(plg : Main) : SkillProvider(plg, Jobs.WOODCUTTER), Listener{

    }
}