package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.Effect
import click.erudosaba.mc.eminejobs2.skill.SkillManager
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import click.erudosaba.mc.eminejobs2.util.Blocks
import click.erudosaba.mc.eminejobs2.util.Items
import org.bukkit.CropState
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.LivingEntity
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.material.Crops
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scheduler.BukkitRunnable

class OnInteract(val plugin: Main) : Listener {

    @EventHandler
    fun onInteract(e: PlayerInteractEvent) {
        if (e.action == Action.RIGHT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_AIR) {
            val player = e.player
            val jp = JobPlayer(player, plugin)
            //スキル発動
            if (player.isSneaking) {
                if (jp.hasJob() && jp.hasSkill()) {
                    val skill = jp.selectedSkill
                    val skillmanager = SkillManager(plugin, jp)

                    skillmanager.run(skill, skill.effect.skilltime, skill.interval)
                }
            } else {
                if (jp.skillStatus == SkillStatus.RUNNING) {
                    //剣士スキル発動
                    if (jp.selectedSkill.effect == Effect.Slash1 || jp.selectedSkill.effect == Effect.Slash2 || jp.selectedSkill.effect == Effect.Slash3) {
                        if (Items.swords.contains(player.inventory.itemInMainHand.type) || Items.swords.contains(player.inventory.itemInOffHand.type)) {

                            val swordItem = if (Items.swords.contains(player.inventory.itemInMainHand.type)) player.inventory.itemInMainHand else player.inventory.itemInOffHand

                            object : BukkitRunnable() {
                                var t = 0.0
                                override fun run() {
                                    t += 0.5
                                    val loc = player.eyeLocation
                                    val direction = loc.direction.normalize()

                                    val x = direction.x * t
                                    val y = direction.y * t
                                    val z = direction.z * t

                                    loc.add(x, y, z)
                                    loc.world?.spawnParticle(Particle.SWEEP_ATTACK, loc, 2, 0.0, 0.0, 0.0)
                                    loc.world?.spawnParticle(Particle.SPELL_INSTANT, loc, 1, 1.0, 1.0, 1.0)
                                    loc.world?.playSound(loc, Sound.ENTITY_PLAYER_ATTACK_SWEEP, 0.5F, 5.0F)

                                    val entities = loc.world?.getNearbyEntities(loc, 2.0, 2.0, 2.0)

                                    if (entities != null) {
                                        for (e in entities) {
                                            val living = e as LivingEntity
                                            if (living == player) continue

                                            var multiple = 1.0
                                            var sworddamage = 1

                                            when (swordItem.type) {
                                                Material.WOODEN_SWORD -> sworddamage = 4
                                                Material.STONE_SWORD -> sworddamage = 5
                                                Material.IRON_SWORD -> sworddamage = 6
                                                Material.GOLDEN_SWORD -> sworddamage = 4
                                                Material.DIAMOND_SWORD -> sworddamage = 7
                                                Material.NETHERITE_SWORD -> sworddamage = 8
                                            }

                                            when (jp.selectedSkill.effect) {
                                                Effect.Slash1 -> {
                                                    multiple = 1.3
                                                }
                                                Effect.Slash2 -> {
                                                    living.addPotionEffect(PotionEffect(PotionEffectType.WEAKNESS, 10 * 20, 2, true))
                                                    multiple = 1.4
                                                }
                                                Effect.Slash3 -> {
                                                    living.addPotionEffect(PotionEffect(PotionEffectType.WEAKNESS, 15 * 20, 2, true))
                                                    multiple = 1.5
                                                }
                                            }



                                            living.damage(sworddamage * multiple)

                                        }
                                    }

                                    loc.subtract(x, y, z)

                                    if (t > 20) {
                                        this.cancel()
                                    }
                                }

                            }.runTaskTimer(plugin, 0, 1)
                        }
                    }
                }
            }

        }
    }
}