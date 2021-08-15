package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import click.erudosaba.mc.eminejobs2.util.Items
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.LivingEntity
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scheduler.BukkitRunnable

class SwordmanSkills(val plugin: Main) : Listener, SkillProvider() {

    //剣士スキル
    @EventHandler
    fun onInteract(e: PlayerInteractEvent) {
        if (e.action == Action.RIGHT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_AIR) {
            for (jp in Main.jPlayers) {
                if (jp.uuid == Bukkit.getPlayer(e.player.name)?.uniqueId) {
                    if (block(jp)) return

                    if (Items.swords.contains(e.player.inventory.itemInMainHand.type)
                            || Items.swords.contains(e.player.inventory.itemInOffHand.type)) {

                        val swordItem = if (Items.swords.contains(e.player.inventory.itemInMainHand.type)) e.player.inventory.itemInMainHand else e.player.inventory.itemInOffHand

                        when (jp.selectedSkill) {
                            Skill.SLASH1 -> {


                                object : BukkitRunnable() {
                                    var t = 0.0
                                    override fun run() {
                                        t += 0.5
                                        val loc = e.player.eyeLocation
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
                                                if (e !is LivingEntity) {
                                                    return
                                                }

                                                val living = e as LivingEntity
                                                if (living == jp.player) continue

                                                var multiple = 1.3
                                                var sworddamage = 1

                                                when (swordItem.type) {
                                                    Material.WOODEN_SWORD -> sworddamage = 4
                                                    Material.STONE_SWORD -> sworddamage = 5
                                                    Material.IRON_SWORD -> sworddamage = 6
                                                    Material.GOLDEN_SWORD -> sworddamage = 4
                                                    Material.DIAMOND_SWORD -> sworddamage = 7
                                                    Material.NETHERITE_SWORD -> sworddamage = 8
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
                            Skill.SLASH2 -> {

                                object : BukkitRunnable() {
                                    var t = 0.0
                                    override fun run() {
                                        t += 0.5
                                        val loc = e.player.eyeLocation
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
                                                if (e !is LivingEntity) {
                                                    return
                                                }

                                                val living = e as LivingEntity
                                                if (living == jp.player) continue

                                                var multiple = 1.3
                                                var sworddamage = 1

                                                when (swordItem.type) {
                                                    Material.WOODEN_SWORD -> sworddamage = 4
                                                    Material.STONE_SWORD -> sworddamage = 5
                                                    Material.IRON_SWORD -> sworddamage = 6
                                                    Material.GOLDEN_SWORD -> sworddamage = 4
                                                    Material.DIAMOND_SWORD -> sworddamage = 7
                                                    Material.NETHERITE_SWORD -> sworddamage = 8
                                                }

                                                living.damage(sworddamage * multiple)
                                                living.addPotionEffect(PotionEffect(PotionEffectType.WEAKNESS, 20 * 10, 2, true))

                                            }
                                        }

                                        loc.subtract(x, y, z)

                                        if (t > 20) {
                                            this.cancel()
                                        }
                                    }
                                }.runTaskTimer(plugin, 0, 1)
                            }

                            Skill.SLASH3 -> {
                                object : BukkitRunnable() {
                                    var t = 0.0
                                    override fun run() {
                                        t += 0.5
                                        val loc = e.player.eyeLocation
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
                                                if (e !is LivingEntity) {
                                                    return
                                                }

                                                val living = e as LivingEntity
                                                if (living == jp.player) continue

                                                var multiple = 1.3
                                                var sworddamage = 1

                                                when (swordItem.type) {
                                                    Material.WOODEN_SWORD -> sworddamage = 4
                                                    Material.STONE_SWORD -> sworddamage = 5
                                                    Material.IRON_SWORD -> sworddamage = 6
                                                    Material.GOLDEN_SWORD -> sworddamage = 4
                                                    Material.DIAMOND_SWORD -> sworddamage = 7
                                                    Material.NETHERITE_SWORD -> sworddamage = 8
                                                }

                                                living.damage(sworddamage * multiple)
                                                living.addPotionEffect(PotionEffect(PotionEffectType.WEAKNESS, 20 * 15, 2, true))

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
}