package click.erudosaba.mc.eminejobs2.skill

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.util.CustomConfig
import org.bukkit.Material

class Skill(val plg: Main, val path: String) : CustomConfig(plg, "skills/$path.yml") {

    val id : String? = config.getString("ID")
    val name: String? = config.getString("Name")
    val needLevel: Int = config.getInt("NeedLevel")
    val interval: Int = config.getInt("Interval")
    val effect: Effect = Effect.valueOf(config.getString("Effect")!!)
    val icon: Material = Material.valueOf(config.getString("Icon")!!)
}