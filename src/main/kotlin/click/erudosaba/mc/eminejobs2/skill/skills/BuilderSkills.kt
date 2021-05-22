package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.Material
import org.bukkit.event.Listener

class BuilderSkills(plugin : Main) {

    companion object {
        val jobID = "builder"
    }

    init {
        plugin.server.pluginManager.registerEvents(Protean(),plugin)
        plugin.server.pluginManager.registerEvents(Levitation(),plugin)
    }

    class Protean : Skill("Protean", "変幻自在", BuilderSkills.jobID, arrayOf("30秒間ブロックを殴ると，左手に持っているブロックに殴ったブロックが変化する(鉱石ブロックはナシ)"), Material.BRICKS, 30, 30, 90), Listener {

    }

    class Levitation : Skill("Levitation", "浮遊", BuilderSkills.jobID, arrayOf("60秒間浮遊が可能"), Material.FEATHER, 60, 45, 360), Listener {

    }
}