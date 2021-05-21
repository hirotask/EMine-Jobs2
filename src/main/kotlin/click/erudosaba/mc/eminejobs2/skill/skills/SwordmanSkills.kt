package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.Material
import org.bukkit.event.Listener

object SwordmanSkills {
    val jobID = "swordman"

    class Slash1 : Skill("Slash1", "斬撃1", WoodCutterSkills.jobID, arrayOf("10秒間の間に剣を持って右クリックをすると斬撃を飛ばして，あたったプレイヤーに持ってる剣のダメージ*1.3"), Material.IRON_SWORD, 10, 20, 20), Listener {

    }

    class Slash2 : Skill("Slash2", "斬撃2", WoodCutterSkills.jobID, arrayOf("10秒間の間に剣を持って右クリックをすると斬撃を飛ばして，あたったプレイヤーに持ってる剣のダメージ*1.4 + 弱体化10秒"), Material.GOLDEN_SWORD, 10, 30, 20), Listener {

    }

    class Slash3 : Skill("Slash3", "斬撃3", WoodCutterSkills.jobID, arrayOf("10秒間の間に剣を持って右クリックをすると飛ばして，あたったプレイヤーに持ってる剣のダメージ*1.5 + 弱体化15秒"), Material.DIAMOND_SWORD, 10, 40, 20), Listener {

    }
}