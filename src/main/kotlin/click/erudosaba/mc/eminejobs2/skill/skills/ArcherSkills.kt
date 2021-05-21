package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.Material
import org.bukkit.event.Listener

object ArcherSkills {

    val jobID = "archer"

    class SpeedArrow : Skill("SpeedArrow", "アイオロスの矢", WoodCutterSkills.jobID, arrayOf("10秒間自分が撃った矢に当たると空を飛べる","15秒間は落下ダメージが0となる"), Material.TIPPED_ARROW, 30, 25, 90), Listener {

    }

    class PowerArrow : Skill("PowerArrow", "アレスの矢", WoodCutterSkills.jobID, arrayOf("10秒間撃った矢が３方向に同時に飛ぶようになる"), Material.TIPPED_ARROW, 30, 30, 60), Listener {

    }

    class HomingArrow : Skill("HomingArrow", "ホーミングの矢", WoodCutterSkills.jobID, arrayOf("10秒間撃った矢がホーミングする"), Material.ARROW, 10, 35, 60), Listener {

    }
}