package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.Material
import org.bukkit.event.Listener

object DiggerSkills {
    val jobID = "digger"

    class DirtHaste1 : Skill("DirtHaste1", "破壊速度上昇1", WoodCutterSkills.jobID, arrayOf("20秒間採掘速度を上昇する"), Material.PODZOL, 20, 15, 70), Listener {

    }

    class DirtHaste2 : Skill("DirtHaste2", "破壊速度上昇2", WoodCutterSkills.jobID, arrayOf("40秒間採掘速度を上昇する"), Material.PODZOL, 40, 25, 90), Listener {

    }

    class DirtHaste3 : Skill("DirtHaste3", "破壊速度上昇3", WoodCutterSkills.jobID, arrayOf("60秒間採掘速度を上昇する"), Material.PODZOL, 60, 35, 110), Listener {

    }

    class DigAll : Skill("DigAll", "一括破壊", WoodCutterSkills.jobID, arrayOf("10秒間土系を一括破壊できる","自分の立ってる高さ以下は破壊しない"), Material.DIAMOND_SHOVEL, 10, 40, 5), Listener {

    }
}