package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.Material
import org.bukkit.event.Listener

class FishermanSkills(plugin : Main) {

    companion object {
        val jobID = "fisherman"
    }

    init {
        plugin.server.pluginManager.registerEvents(CatchFish(),plugin)
    }

    class CatchFish : Skill("CatchFish", "つかみ取り", FishermanSkills.jobID, arrayOf("5秒間素手で水を右クリックすると魚が取れる", "（この時経験値は増えない）"), Material.COD, 5, 25, 60), Listener {

    }
}