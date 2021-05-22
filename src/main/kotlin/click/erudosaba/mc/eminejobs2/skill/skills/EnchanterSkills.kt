package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.Material
import org.bukkit.event.Listener

class EnchanterSkills(plugin : Main) {

    companion object {

        val jobID = "enchanter"
    }

    init {
        plugin.server.pluginManager.registerEvents(TransEnchant(),plugin)
    }

    class TransEnchant : Skill("TransEnchant", "付与移植", EnchanterSkills.jobID, arrayOf("30秒間の間にエンチャントしたら，そのエンチャントの本が１つ手に入る"), Material.BOOK, 30, 25, 90), Listener {

    }
}