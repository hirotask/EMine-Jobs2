package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.Material
import org.bukkit.event.Listener

object HungerSkills {

    val jobID = "hunger"

    class NoSlow1 : Skill("NoSlow1", "食べ歩き1", WoodCutterSkills.jobID, arrayOf("20秒間食事中の移動速度が遅くならない"), Material.COOKED_BEEF, 20, 25, 60), Listener {

    }

    class NoSlow2 : Skill("NoSlow2", "食べ歩き2", WoodCutterSkills.jobID, arrayOf("40秒間食事中の移動速度が遅くならない"), Material.COOKED_BEEF, 40, 35, 60), Listener {

    }

    class AlwaysFull : Skill("AlwaysFull", "常時満腹", WoodCutterSkills.jobID, arrayOf("120秒間食事中の移動速度が遅くならない"), Material.CAKE, 120, 45, 150), Listener {

    }
}