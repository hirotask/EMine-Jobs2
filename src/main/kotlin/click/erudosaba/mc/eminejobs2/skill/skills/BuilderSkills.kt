package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.Material
import org.bukkit.event.Listener

object BuilderSkills {

    val jobID = "builder"

    class Protean : Skill("Protean", "変幻自在", WoodCutterSkills.jobID, arrayOf("30秒間ブロックを殴ると，左手に持っているブロックに殴ったブロックが変化する(鉱石ブロックはナシ)"), Material.BRICKS, 30, 30, 90), Listener {

    }

    class Levitation : Skill("Levitation", "浮遊", WoodCutterSkills.jobID, arrayOf("60秒間浮遊が可能"), Material.FEATHER, 60, 45, 360), Listener {

    }
}