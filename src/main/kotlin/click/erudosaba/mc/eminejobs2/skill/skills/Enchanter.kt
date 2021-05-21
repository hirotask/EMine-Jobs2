package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.Material
import org.bukkit.event.Listener

object Enchanter {

    val jobID = "enchanter"

    class TransEnchant : Skill("TransEnchant", "付与移植", WoodCutterSkills.jobID, arrayOf("30秒間の間にエンチャントしたら，そのエンチャントの本が１つ手に入る"), Material.BOOK, 30, 25, 90), Listener {

    }
}