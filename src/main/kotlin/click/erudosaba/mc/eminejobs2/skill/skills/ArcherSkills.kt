package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Arrow
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityShootBowEvent
import org.bukkit.util.Vector
import kotlin.math.cos
import kotlin.math.sin

class ArcherSkills(val plugin: Main) : Listener, SkillProvider() {

    @EventHandler
    fun onArrowHitEntity(e : EntityDamageByEntityEvent) {
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
        for (jp in Main.jPlayers) {
            if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                if(block(jp)) return

                if(jp.selectedSkill != Skill.SPEEDARROW) return

                //ここからSpeedArrow
                if (shooter == player) {
                    val itemInHand = shooter.inventory.itemInMainHand

                    if (itemInHand.type == Material.BOW) {
                        val boostVec = player.location.direction.normalize().multiply(10.0).setY(1)
                        player.velocity = boostVec
                    }
                }
            }
        }
    }

    @EventHandler
    fun onShoot(e : EntityShootBowEvent) {
        val player = if (e.entity is Player) e.entity as Player else return
        for (jp in Main.jPlayers) {
            if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                if(block(jp)) return

                if(jp.selectedSkill != Skill.POWERARROW) return

                //ここからPOWERARROW
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
    }
}