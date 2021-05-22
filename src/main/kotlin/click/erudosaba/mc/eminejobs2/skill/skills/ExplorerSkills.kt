package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.Material
import org.bukkit.event.Listener

class ExplorerSkills(plugin : Main) {

    companion object {
        val jobID = "explorer"
    }

    init {
        plugin.server.pluginManager.registerEvents(WallClimb(),plugin)
        plugin.server.pluginManager.registerEvents(FrostWalk(),plugin)
    }

    class WallClimb : Skill("WallClimb", "壁登り", ExplorerSkills.jobID, arrayOf("180秒間壁が上れる＋移動速度上昇2"), Material.DIAMOND_BOOTS, 180, 25, 300), Listener {

    }

    class FrostWalk : Skill("FrostWalk", "氷渡り", ExplorerSkills.jobID, arrayOf("180秒間水の上を歩ける＋移動速度上昇2"), Material.DIAMOND_BOOTS, 180, 30, 300), Listener {

    }
}