package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.Effect
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.Arrow
import org.bukkit.entity.Player
import org.bukkit.entity.Projectile
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityShootBowEvent
import org.bukkit.event.entity.ProjectileHitEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.util.Vector
import kotlin.math.cos
import kotlin.math.sin

class OnArrow(val plugin : Main) : Listener {

    val arrows : MutableList<Projectile> = mutableListOf()

    @EventHandler
    fun onArrowHitEntity(e : EntityDamageByEntityEvent) {


        //SpeedArrow

    }

    @EventHandler
    fun onShoot(e : EntityShootBowEvent) {
        val player = if(e.entity is Player) e.entity as Player else return
        val jp = JobPlayer(player,plugin)

        //PowerArrow
        if(jp.skillStatus == SkillStatus.RUNNING) {
            if(jp.selectedSkill.effect == Effect.PowerArrow) {

                if(player.inventory.itemInMainHand.type == Material.BOW) {
                    val multiply = e.projectile.velocity.length()

                    val loc = player.location

                    val arrowAngle = 15

                    val totalAngle1 = (((loc.yaw + 90) + arrowAngle) * Math.PI) / 100
                    val arrowDirX1 = cos(totalAngle1)
                    val arrowDirZ1 = sin(totalAngle1)

                    val totalAngle2 = (((loc.yaw + 90) - arrowAngle) * Math.PI) / 100
                    val arrowDirX2 = cos(totalAngle2)
                    val arrowDirZ2 = sin(totalAngle2)

                    val arrowDir1 = Vector(arrowDirX1,loc.direction.y,arrowDirZ1).normalize().multiply(multiply)
                    val arrowDir2 = Vector(arrowDirX2,loc.direction.y,arrowDirZ2).normalize().multiply(multiply)

                    player.launchProjectile(Arrow::class.java,arrowDir1)
                    player.launchProjectile(Arrow::class.java,arrowDir2)
                }
            } else if(jp.selectedSkill.effect == Effect.HomingArrow) { //HomingArrow
                arrows.add(e.projectile as Projectile)
            }
        }

        object : BukkitRunnable() {
            override fun run() {
                if(arrows.contains(e.projectile as Projectile)) { //矢が空中にあったら
                    val loc = e.projectile.location
                    val radius = 4

                    for(en in e.projectile.world.entities) {
                        if(loc.distance(en.location) <= radius && !en.isDead) {
                            val shooter = (e.projectile as Projectile).shooter as Player
                            if(en is Player) {
                                if(en == shooter) {
                                    continue
                                }
                            } else {
                                val homingVec = e.projectile.location.direction.subtract(en.location.toVector()).normalize()

                                e.projectile.velocity = homingVec

                            }

                        }
                    }
                } else {
                    cancel()
                }
            }
        }.runTaskTimer(plugin,0,1)
    }

    @EventHandler
    fun onProjectileHit(e : ProjectileHitEvent) {
        if(e.entity !is Arrow) {
            return
        }

        if(arrows.contains(e.entity as Arrow)) {
            arrows.remove(e.entity as Arrow)
        }


        if(e.hitEntity != null) {
            if(e.hitEntity is Player) {
                val arrow = if(e.entity is Arrow) e.entity as Arrow else return
                val player = if(e.hitEntity is Player ) e.hitEntity as Player else return
                val jp = JobPlayer(player,plugin)

                if(jp.skillStatus == SkillStatus.RUNNING) {
                    if(jp.selectedSkill.effect == Effect.SpeedArrow) {
                        if(arrow.shooter !is Player) return

                        if(arrow.shooter as Player == player) {
                            val boostVec = player.location.direction.normalize().multiply(2.5).setY(1)
                            player.velocity = boostVec
                        }

                    }
                }
            }

        }


    }


}