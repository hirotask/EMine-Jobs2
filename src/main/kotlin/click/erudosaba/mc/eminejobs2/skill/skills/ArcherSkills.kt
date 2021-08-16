package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.Arrow
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityShootBowEvent
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.util.Vector
import kotlin.math.cos
import kotlin.math.min
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
        if(e.projectile !is Arrow) return

        val arrow = e.projectile as Arrow

        for (jp in Main.jPlayers) {
            if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                if(block(jp)) return

                //ここからPOWERARROW
                if(player.inventory.itemInMainHand.type == Material.BOW) {
                    if(jp.selectedSkill == Skill.POWERARROW) {
                        val multiply = e.projectile.velocity.length()

                        val loc = player.location

                        val arrowAngle = 15

                        val totalAngle1 = (((loc.yaw + 90) + arrowAngle) * Math.PI) / 180
                        val arrowDirX1 = cos(totalAngle1)
                        val arrowDirZ1 = sin(totalAngle1)

                        val totalAngle2 =(((loc.yaw + 90) - arrowAngle) * Math.PI) / 180
                        val arrowDirX2 = cos(totalAngle2)
                        val arrowDirZ2 = sin(totalAngle2)

                        val arrowDir1 = Vector(arrowDirX1,loc.direction.y,arrowDirZ1).normalize().multiply(multiply)
                        val arrowDir2 = Vector(arrowDirX2,loc.direction.y,arrowDirZ2).normalize().multiply(multiply)

                        player.launchProjectile(Arrow::class.java,arrowDir1)
                        player.launchProjectile(Arrow::class.java,arrowDir2)

                    } else if(jp.selectedSkill == Skill.HOMINGARROW) { //ここからHOMINGARROW
                        val minAngle = 18.283185307179586
                        var minEntity : LivingEntity? = null

                        for(entity in getNearbyEntity(player.getTargetBlock(null,64).location,20)) {
                            if(entity !is Player) { //
                                if(player.hasLineOfSight(entity) && !entity.isDead) {
                                    val toTarget = entity.location.toVector().clone().subtract(player.location.toVector())
                                    val angle = arrow.velocity.angle(toTarget).toDouble()
                                    if(angle < minAngle) {
                                        minEntity = entity as LivingEntity
                                        break
                                    }
                                }
                            }
                        }

                        if(minEntity != null && !minEntity.isDead) {
                            HomingTask(arrow,minEntity,plugin).runTaskTimer(plugin,1L,1L)
                        }
                    }
                }
            }
        }
    }

    private fun getNearbyEntity(loc : Location, size : Int) : List<Entity> {
        val entities = ArrayList<Entity>()
        for(e in loc.world!!.entities) {
            if(loc.distance(e.location) >= size) {
                entities.add(e)
            }
        }
        return entities
    }

    class HomingTask(val arrow : Arrow, val target: LivingEntity, val plugin: Main) : BukkitRunnable() {
        override fun run() {
            val speed = arrow.velocity.length()
            if(arrow.isOnGround || arrow.isDead || target.isDead) {
                cancel()
                return
            }

            if(isDistance(arrow,target)) {
                cancel()
                return
            }

            val toTarget = target.location.clone().add(Vector(0.0,0.5,0.0)).subtract(arrow.location).toVector()
            val dirVelocity = arrow.velocity.clone().normalize()
            val dirToTarget = toTarget.clone().normalize()
            val angle = dirVelocity.angle(dirToTarget)
            val newSpeed = 0.9 * speed + 0.14
            var newVelocity = Vector(0,0,0)

            if(angle < 0.12) {
                newVelocity = dirVelocity.clone().multiply(newSpeed)
            } else {
                val newDir = dirVelocity.clone().multiply((angle - 60) / angle).add(dirToTarget.clone().multiply(60 / angle))
                newDir.normalize()
                newVelocity = newDir.clone().multiply(newSpeed)
            }
            arrow.velocity = newVelocity.add(Vector(0.0,0.03,0.0))

        }

        private fun isDistance(arrow: Arrow, le : LivingEntity) : Boolean{
            val loc1 = arrow.location
            val loc2 = le.location
            val distance = loc1.distance(loc2)
            return (distance >= 60)
        }

    }
}