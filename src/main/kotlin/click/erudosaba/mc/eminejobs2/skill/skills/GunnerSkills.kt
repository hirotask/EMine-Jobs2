package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.Material
import org.bukkit.event.Listener

object GunnerSkills {

    val jobID = "gunner"

    class DoubleJump : Skill("DoubleJump", "2段ジャンプ", WoodCutterSkills.jobID, arrayOf("60秒間スペースキーを２回押すと，２段ジャンプが可能"), Material.FEATHER, 60, 20, 180), Listener {

    }
}