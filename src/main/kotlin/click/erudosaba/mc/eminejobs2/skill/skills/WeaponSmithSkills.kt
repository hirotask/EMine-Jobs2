package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.skill.Skill
import org.bukkit.Material
import org.bukkit.event.Listener

class WeaponSmithSkills(plugin : Main) {

    companion object {
        val jobID = "weaponsmith"
    }

    init {
        plugin.server.pluginManager.registerEvents(LowCostRepair1(),plugin)
        plugin.server.pluginManager.registerEvents(LowCostRepair2(),plugin)
        plugin.server.pluginManager.registerEvents(LowCostRepair3(),plugin)
    }

    class LowCostRepair1 : Skill("LowCostRepair1", "低コスト修理1", WeaponSmithSkills.jobID, arrayOf("10秒間の間に金床を使用すると，修理コストが（普通のコスト - 4)される"), Material.ANVIL, 10, 20, 130), Listener {

    }

    class LowCostRepair2 : Skill("LowCostRepair2", "低コスト修理2", WeaponSmithSkills.jobID, arrayOf("10秒間の間に金床を使用すると，修理コストが（普通のコスト - 7)される"), Material.ANVIL, 10, 30, 130), Listener {

    }

    class LowCostRepair3 : Skill("LowCostRepair3", "低コスト修理3", WeaponSmithSkills.jobID, arrayOf("10秒間の間に金床を使用すると，修理コストが（普通のコスト - 10)される"), Material.ANVIL, 10, 40, 130), Listener {

    }
}