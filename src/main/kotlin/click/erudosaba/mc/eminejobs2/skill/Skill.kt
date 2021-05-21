package click.erudosaba.mc.eminejobs2.skill

import org.bukkit.Material

open class Skill(val ID: String,
                 val name: String,
                 val JobID: String,
                 val description: Array<String>,
                 val icon: Material,
                 val activeTime: Int,
                 val needLevel: Int,
                 val interval: Int) {
}