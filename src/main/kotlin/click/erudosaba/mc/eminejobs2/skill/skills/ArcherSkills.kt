package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.SkillUseEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Arrow
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityShootBowEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.util.Vector
import kotlin.math.cos
import kotlin.math.sin

class ArcherSkills(plugin: Main) {

    init {
        plugin.server.pluginManager.registerEvents(SpeedArrow(plugin), plugin)
        plugin.server.pluginManager.registerEvents(PowerArrow(plugin), plugin)
        plugin.server.pluginManager.registerEvents(HomingArrow(plugin), plugin)
    }

    class SpeedArrow(val plg: Main) : SkillProvider(plg,Jobs.ARCHER), Listener {

        @EventHandler
        fun onInteract(e : PlayerInteractEvent) {
            if(e.action == Action.RIGHT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_AIR) {
                val jp = JobPlayer(plugin=plg,player=e.player)
                if(activateBlock(jp,plg.skillManager,Skill.SPEEDARROW)) return

                val option = plg.skillManager.getSkillOption(Skill.SPEEDARROW)
                val event = SkillUseEvent(jp, option)
                Bukkit.getServer().pluginManager.callEvent(event)
            }
        }

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

    class PowerArrow(val plg: Main) : SkillProvider(plg,Jobs.ARCHER), Listener {

        @EventHandler
        fun onInteract(e : PlayerInteractEvent) {
            if(e.action == Action.RIGHT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_AIR) {
                val jp = JobPlayer(plugin=plg,player=e.player)
                if(activateBlock(jp,plg.skillManager,Skill.POWERARROW)) return

                val option = plg.skillManager.getSkillOption(Skill.POWERARROW)
                val event = SkillUseEvent(jp, option)
                Bukkit.getServer().pluginManager.callEvent(event)
            }
        }

        @EventHandler
        fun onShoot(e: EntityShootBowEvent) {
            val player = if (e.entity is Player) e.entity as Player else return
            val jp = JobPlayer(player, plugin)
            if(block(jp)) return

            if(player.inventory.itemInMainHand.type == Material.BOW) {
                val multiply = e.projectile.velocity.length()

                val loc = player.location

                val arrowAngle = 15

                val totalAngle1 = (((loc.yaw + 90) + arrowAngle) * Math.PI) / 100
                val arrowDirX1 = cos(totalAngle1)
                val arrowDirZ1 = sin(totalAngle1)

                val totalAngle2 =(((loc.yaw + 90) - arrowAngle) * Math.PI) /100
                val arrowDirX2 = cos(totalAngle2)
                val arrowDirZ2 = sin(totalAngle2)

                val arrowDir1 = Vector(arrowDirX1,loc.direction.y,arrowDirZ1).normalize().multiply(multiply)
                val arrowDir2 = Vector(arrowDirX2,loc.direction.y,arrowDirZ2).normalize().multiply(multiply)

                player.launchProjectile(Arrow::class.java,arrowDir1)
                player.launchProjectile(Arrow::class.java,arrowDir2)
            }
        }
    }

    class HomingArrow(val plg: Main) : SkillProvider(plg,Jobs.ARCHER), Listener {

        @EventHandler
        fun onInteract(e : PlayerInteractEvent) {
            if(e.action == Action.RIGHT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_AIR) {
                val jp = JobPlayer(plugin=plg,player=e.player)
                if(activateBlock(jp,plg.skillManager,Skill.HOMINGARROW)) return

                val option = plg.skillManager.getSkillOption(Skill.HOMINGARROW)
                val event = SkillUseEvent(jp, option)
                Bukkit.getServer().pluginManager.callEvent(event)
            }
        }
    }
}