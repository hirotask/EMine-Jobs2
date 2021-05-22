package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Material
import org.bukkit.event.Listener

class MinerSkills(plugin : Main) {

    init {
        plugin.server.pluginManager.registerEvents(StoneHaste1(plugin),plugin)
        plugin.server.pluginManager.registerEvents(StoneHaste2(plugin),plugin)
        plugin.server.pluginManager.registerEvents(StoneHaste3(plugin),plugin)
        plugin.server.pluginManager.registerEvents(MineAll(plugin),plugin)
    }

    class StoneHaste1(plg : Main) : SkillProvider(plg, Jobs.MINER), Listener {

    }

    class StoneHaste2(plg : Main) : SkillProvider(plg, Jobs.MINER), Listener{

    }

    class StoneHaste3(plg : Main) :SkillProvider(plg, Jobs.MINER), Listener {

    }

    class MineAll(plg : Main) : SkillProvider(plg, Jobs.MINER), Listener {

    }
}