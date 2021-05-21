package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.Material
import org.bukkit.event.Listener

object BrewerSkills {

    val jobID = "brewer"

    class FastBrewing1 : Skill("FastBrewing1", "醸造時間短縮1", WoodCutterSkills.jobID, arrayOf("10秒間醸造の時間が0.8倍"), Material.BREWING_STAND, 10, 20, 130), Listener {

    }

    class FastBrewing2 : Skill("FastBrewing2", "醸造時間短縮2", WoodCutterSkills.jobID, arrayOf("10秒間醸造の時間が0.6倍"), Material.BREWING_STAND, 10, 30, 130), Listener {

    }

    class FastBrewing3 : Skill("FastBrewing3", "醸造時間短縮3", WoodCutterSkills.jobID, arrayOf("10秒間醸造の時間が0.4倍"), Material.BREWING_STAND, 10, 40, 130), Listener {

    }
}