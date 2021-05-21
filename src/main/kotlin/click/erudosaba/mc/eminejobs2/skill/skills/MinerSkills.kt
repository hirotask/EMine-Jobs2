package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.Material
import org.bukkit.event.Listener

object MinerSkills {
    val jobID = "miner"

    class StoneHaste1 : Skill("StoneHaste1", "破壊速度上昇1", WoodCutterSkills.jobID, arrayOf("20秒間採掘速度を上昇する"), Material.COAL_ORE, 20, 15, 70), Listener {

    }

    class StoneHaste2 : Skill("StoneHaste2", "破壊速度上昇2", WoodCutterSkills.jobID, arrayOf("40秒間採掘速度を上昇する"), Material.IRON_ORE, 40, 25, 90), Listener {

    }

    class StoneHaste3 : Skill("StoneHaste3", "破壊速度上昇3", WoodCutterSkills.jobID, arrayOf("60秒間採掘速度を上昇する"), Material.GOLD_ORE, 60, 35, 110), Listener {

    }

    class MineAll : Skill("MineAll", "一括破壊", WoodCutterSkills.jobID, arrayOf("10秒間鉱石ブロックを一括破壊できる(自分の立ってる高さ以下は破壊しない)"), Material.DIAMOND_PICKAXE, 10, 40, 5), Listener {

    }
}