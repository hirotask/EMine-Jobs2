package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.Material
import org.bukkit.event.Listener

class BrewerSkills(plugin : Main) {

    companion object {
        val jobID = "brewer"
    }

    init {
        plugin.server.pluginManager.registerEvents(FastBrewing1(),plugin)
        plugin.server.pluginManager.registerEvents(FastBrewing2(),plugin)
        plugin.server.pluginManager.registerEvents(FastBrewing3(),plugin)
    }


    class FastBrewing1 : Skill("FastBrewing1", "醸造時間短縮1", BrewerSkills.jobID, arrayOf("10秒間醸造の時間が0.8倍"), Material.BREWING_STAND, 10, 20, 130), Listener {

    }

    class FastBrewing2 : Skill("FastBrewing2", "醸造時間短縮2", BrewerSkills.jobID, arrayOf("10秒間醸造の時間が0.6倍"), Material.BREWING_STAND, 10, 30, 130), Listener {

    }

    class FastBrewing3 : Skill("FastBrewing3", "醸造時間短縮3", BrewerSkills.jobID, arrayOf("10秒間醸造の時間が0.4倍"), Material.BREWING_STAND, 10, 40, 130), Listener {

    }
}