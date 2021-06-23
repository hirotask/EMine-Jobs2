package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Material
import org.bukkit.event.Listener

class WeaponSmithSkills(plugin : Main) {


    init {
        plugin.server.pluginManager.registerEvents(LowCostRepair1(plugin),plugin)
        plugin.server.pluginManager.registerEvents(LowCostRepair2(plugin),plugin)
        plugin.server.pluginManager.registerEvents(LowCostRepair3(plugin),plugin)
    }

    class LowCostRepair1(plg : Main) : SkillProvider(plg, Jobs.WEAPONSMITH), Listener {

    }

    class LowCostRepair2(plg : Main) : SkillProvider(plg, Jobs.WEAPONSMITH), Listener {

    }

    class LowCostRepair3(plg : Main) : SkillProvider(plg, Jobs.WEAPONSMITH), Listener {
    }
}