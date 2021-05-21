package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.Material
import org.bukkit.event.Listener

object CrafterSkills {

    val jobID = "crafter"

    class RandomEffect1 : Skill("RandomEffect1", "ランダムエフェクト1", WoodCutterSkills.jobID, arrayOf("30秒間の間にクラフトしたら，10秒間ランダムなエフェクト(lv.1)がつく"), Material.CRAFTING_TABLE, 30, 15, 90), Listener {

    }

    class RandomEffect2 : Skill("RandomEffect2", "ランダムエフェクト2", WoodCutterSkills.jobID, arrayOf("30秒間の間にクラフトしたら，10秒間ランダムなエフェクト(lv.2)がつく"), Material.CRAFTING_TABLE, 30, 25, 90), Listener {

    }

    class RandomEffect3 : Skill("RandomEffect3", "ランダムエフェクト3", WoodCutterSkills.jobID, arrayOf("30秒間の間にクラフトしたら，10秒間ランダムなエフェクト(lv.3)がつく"), Material.CRAFTING_TABLE, 30, 35, 90), Listener {

    }

    class RandomUpgrade : Skill("RandomUpgrade", "ランダムアップグレード", WoodCutterSkills.jobID, arrayOf("10秒間の間にクラフトしたら，2%が上位のツールになる", "（木→石→鉄→金→ダイヤ→ネザライト）"), Material.CRAFTING_TABLE, 10, 40, 130), Listener {

    }
}