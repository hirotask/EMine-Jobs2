package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import org.bukkit.Material
import org.bukkit.entity.Arrow
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityShootBowEvent

class ArcherSkills(plugin: Main) {

    init {
        plugin.server.pluginManager.registerEvents(SpeedArrow(plugin), plugin)
        plugin.server.pluginManager.registerEvents(PowerArrow(plugin), plugin)
        plugin.server.pluginManager.registerEvents(HomingArrow(plugin), plugin)
    }

    class SpeedArrow(val plg: Main) : SkillProvider(plg,Jobs.ARCHER), Listener {

        @EventHandler
        fun onArrowHitEntity(e: EntityDamageByEntityEvent) {
            if (e.damager !is Arrow) {
                return
            }

            val arrow = e.damager as Arrow

            if (arrow.shooter !is Player) {
                return
            }

            if (e.entity !is Player) {
                return
            }

            val shooter = arrow.shooter as Player
            val player = e.entity as Player
            val jp = JobPlayer(player, plg)


            if(block(jp)) return

            if (shooter == player) {
                val itemInHand = shooter.inventory.itemInMainHand

                if (itemInHand.type == Material.BOW) {
                    val boostVec = player.location.direction.normalize().multiply(10.0).setY(1)
                    player.velocity = boostVec
                }
            }

        }
    }

    class PowerArrow(plg: Main) : SkillProvider(plg,Jobs.ARCHER), Listener {
        @EventHandler
        fun onShoot(e: EntityShootBowEvent) {
            val player = if (e.entity is Player) e.entity as Player else return
            val jp = JobPlayer(player, plugin)


        }
    }

    class HomingArrow(plg: Main) : SkillProvider(plg,Jobs.ARCHER), Listener {

    }
}