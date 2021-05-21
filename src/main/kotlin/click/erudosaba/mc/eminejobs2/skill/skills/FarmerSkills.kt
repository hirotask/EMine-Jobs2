package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.Material
import org.bukkit.event.Listener

object FarmerSkills {

    val jobID = "farmer"

    class Growing1 : Skill("Growing1", "成長促進1", WoodCutterSkills.jobID, arrayOf("10秒間半径3ブロックの植物の成長速度を早める"), Material.WHEAT_SEEDS, 10, 15, 60), Listener {

    }

    class Growing2 : Skill("Growing2", "成長促進2", WoodCutterSkills.jobID, arrayOf("10秒間半径5ブロックの植物の成長速度を早める"), Material.WHEAT_SEEDS, 10, 25, 60), Listener {

    }

    class Growing3 : Skill("Growing3", "成長促進3", WoodCutterSkills.jobID, arrayOf("10秒間半径8ブロックの植物の成長速度を早める"), Material.WHEAT_SEEDS, 10, 35, 60), Listener {

    }

    class AutoHarvest : Skill("AutoHarvest", "自動収穫", WoodCutterSkills.jobID, arrayOf("20秒間自分が歩いた地点から半径3ブロックの範囲の作物を自動で破壊する"), Material.LEATHER_BOOTS, 20, 40, 90), Listener {

    }
}