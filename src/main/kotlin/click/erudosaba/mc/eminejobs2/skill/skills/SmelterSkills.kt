package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.Material
import org.bukkit.event.Listener

class SmelterSkills(plugin : Main) {

    companion object {
        val jobID = "smelter"
    }

    init {
        plugin.server.pluginManager.registerEvents(Smelt1(),plugin)
        plugin.server.pluginManager.registerEvents(Smelt2(),plugin)
        plugin.server.pluginManager.registerEvents(Smelt3(),plugin)
    }


    class Smelt1 : Skill("Smelt1", "精錬速度上昇1", SmelterSkills.jobID, arrayOf("180秒間精練速度が1.3倍"), Material.FURNACE, 180, 15, 300), Listener {

    }

    class Smelt2 : Skill("Smelt2", "精錬速度上昇2", SmelterSkills.jobID, arrayOf("180秒間精練速度が1.6倍"), Material.FURNACE, 180, 25, 300), Listener {

    }

    class Smelt3 : Skill("Smelt3", "精錬速度上昇3", SmelterSkills.jobID, arrayOf("180秒間精練速度が2倍"), Material.FURNACE, 180, 35, 300), Listener {

    }
}