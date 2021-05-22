package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Material
import org.bukkit.event.Listener

class GunnerSkills(plugin : Main) {

    init {
        plugin.server.pluginManager.registerEvents(DoubleJump(plugin),plugin)
    }


    class DoubleJump(plg : Main) : SkillProvider(plg, Jobs.GUNNER), Listener{

    }
}