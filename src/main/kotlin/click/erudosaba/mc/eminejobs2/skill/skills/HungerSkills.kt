package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.Material
import org.bukkit.event.Listener

class HungerSkills(plugin : Main) {

    companion object {
        val jobID = "hunger"
    }

    init {
        plugin.server.pluginManager.registerEvents(NoSlow1(),plugin)
        plugin.server.pluginManager.registerEvents(NoSlow2(),plugin)
        plugin.server.pluginManager.registerEvents(AlwaysFull(),plugin)
    }

    class NoSlow1 : Skill("NoSlow1", "食べ歩き1", HungerSkills.jobID, arrayOf("20秒間食事中の移動速度が遅くならない"), Material.COOKED_BEEF, 20, 25, 60), Listener {

    }

    class NoSlow2 : Skill("NoSlow2", "食べ歩き2", HungerSkills.jobID, arrayOf("40秒間食事中の移動速度が遅くならない"), Material.COOKED_BEEF, 40, 35, 60), Listener {

    }

    class AlwaysFull : Skill("AlwaysFull", "常時満腹", HungerSkills.jobID, arrayOf("120秒間食事中の移動速度が遅くならない"), Material.CAKE, 120, 45, 150), Listener {

    }
}