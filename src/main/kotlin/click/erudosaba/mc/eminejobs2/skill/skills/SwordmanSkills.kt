package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.SkillUseEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
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

class SwordmanSkills(plugin : Main) {

    init {
        plugin.server.pluginManager.registerEvents(Slash1(plugin),plugin)
        plugin.server.pluginManager.registerEvents(Slash2(plugin),plugin)
        plugin.server.pluginManager.registerEvents(Slash3(plugin),plugin)
    }

    class Slash1(val plg : Main) : SkillProvider(plg, Jobs.SWORDMAN), Listener {
        @EventHandler
        fun onInteract(e : PlayerInteractEvent) {
            if(e.action == Action.RIGHT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_AIR) {
                val jp = JobPlayer(plugin=plg,player=e.player)
                if(jp.skillStatus == SkillStatus.ENABLED) { //剣士スキル内容
                    if(Items.swords.contains(e.player.inventory.itemInMainHand.type) || Items.swords.contains(e.player.inventory.itemInOffHand.type)) {
                        val swordItem = if(Items.swords.contains(e.player.inventory.itemInMainHand.type)) e.player.inventory.itemInMainHand else e.player.inventory.itemInOffHand

                        object : BukkitRunnable() {
                            var t = 0.0
                            override fun run() {
                                t += 0.5
                                val loc = e.player.eyeLocation
                                val direction = loc.direction.normalize()

                                val x = direction.x * t
                                val y = direction.y * t
                                val z = direction.z * t

                                loc.add(x,y,z)
                                loc.world?.spawnParticle(Particle.SWEEP_ATTACK,loc,2, 0.0, 0.0, 0.0)
                                loc.world?.spawnParticle(Particle.SPELL_INSTANT,loc,1, 1.0, 1.0, 1.0)
                                loc.world?.playSound(loc, Sound.ENTITY_PLAYER_ATTACK_SWEEP,0.5F,5.0F)

                                val entities = loc.world?.getNearbyEntities(loc,2.0,2.0,2.0)

                                if (entities != null) {
                                    for(e in entities) {
                                        val living = e as LivingEntity
                                        if(living == jp.player) continue

                                        var multiple = 1.3
                                        var sworddamage = 1

                                        when(swordItem.type) {
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

                                loc.subtract(x,y,z)

                                if(t > 20) {
                                    this.cancel()
                                }
                            }
                        }.runTaskTimer(plugin,0,1)
                    }

                } else {
                    if(activateBlock(jp,plg.skillManager,Skill.SLASH1)) return

                    val option = plg.skillManager.getSkillOption(Skill.SLASH1)
                    val event = SkillUseEvent(jp, option)
                    Bukkit.getServer().pluginManager.callEvent(event)
                }
            }
        }
    }

    class Slash2(val plg : Main) : SkillProvider(plg, Jobs.SWORDMAN), Listener {
        @EventHandler
        fun onInteract(e : PlayerInteractEvent) {
            if(e.action == Action.RIGHT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_AIR) {
                val jp = JobPlayer(plugin=plg,player=e.player)
                if(jp.skillStatus == SkillStatus.ENABLED) { //剣士スキル内容
                    if(Items.swords.contains(e.player.inventory.itemInMainHand.type) || Items.swords.contains(e.player.inventory.itemInOffHand.type)) {
                        val swordItem = if(Items.swords.contains(e.player.inventory.itemInMainHand.type)) e.player.inventory.itemInMainHand else e.player.inventory.itemInOffHand

                        object : BukkitRunnable() {
                            var t = 0.0
                            override fun run() {
                                t += 0.5
                                val loc = e.player.eyeLocation
                                val direction = loc.direction.normalize()

                                val x = direction.x * t
                                val y = direction.y * t
                                val z = direction.z * t

                                loc.add(x,y,z)
                                loc.world?.spawnParticle(Particle.SWEEP_ATTACK,loc,2, 0.0, 0.0, 0.0)
                                loc.world?.spawnParticle(Particle.SPELL_INSTANT,loc,1, 1.0, 1.0, 1.0)
                                loc.world?.playSound(loc, Sound.ENTITY_PLAYER_ATTACK_SWEEP,0.5F,5.0F)

                                val entities = loc.world?.getNearbyEntities(loc,2.0,2.0,2.0)

                                if (entities != null) {
                                    for(e in entities) {
                                        val living = e as LivingEntity
                                        if(living == jp.player) continue

                                        var multiple = 1.3
                                        var sworddamage = 1

                                        when(swordItem.type) {
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

                                loc.subtract(x,y,z)

                                if(t > 20) {
                                    this.cancel()
                                }
                            }
                        }.runTaskTimer(plugin,0,1)
                    }

                } else {
                    if(activateBlock(jp,plg.skillManager,Skill.SLASH2)) return

                    val option = plg.skillManager.getSkillOption(Skill.SLASH2)
                    val event = SkillUseEvent(jp, option)
                    Bukkit.getServer().pluginManager.callEvent(event)
                }
            }
        }
    }

    class Slash3(val plg : Main) : SkillProvider(plg, Jobs.SWORDMAN), Listener {
        @EventHandler
        fun onInteract(e : PlayerInteractEvent) {
            if(e.action == Action.RIGHT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_AIR) {
                val jp = JobPlayer(plugin=plg,player=e.player)
                if(jp.skillStatus == SkillStatus.ENABLED) { //剣士スキル内容
                    if(Items.swords.contains(e.player.inventory.itemInMainHand.type) || Items.swords.contains(e.player.inventory.itemInOffHand.type)) {
                        val swordItem = if(Items.swords.contains(e.player.inventory.itemInMainHand.type)) e.player.inventory.itemInMainHand else e.player.inventory.itemInOffHand

                        object : BukkitRunnable() {
                            var t = 0.0
                            override fun run() {
                                t += 0.5
                                val loc = e.player.eyeLocation
                                val direction = loc.direction.normalize()

                                val x = direction.x * t
                                val y = direction.y * t
                                val z = direction.z * t

                                loc.add(x,y,z)
                                loc.world?.spawnParticle(Particle.SWEEP_ATTACK,loc,2, 0.0, 0.0, 0.0)
                                loc.world?.spawnParticle(Particle.SPELL_INSTANT,loc,1, 1.0, 1.0, 1.0)
                                loc.world?.playSound(loc, Sound.ENTITY_PLAYER_ATTACK_SWEEP,0.5F,5.0F)

                                val entities = loc.world?.getNearbyEntities(loc,2.0,2.0,2.0)

                                if (entities != null) {
                                    for(e in entities) {
                                        val living = e as LivingEntity
                                        if(living == jp.player) continue

                                        var multiple = 1.3
                                        var sworddamage = 1

                                        when(swordItem.type) {
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

                                loc.subtract(x,y,z)

                                if(t > 20) {
                                    this.cancel()
                                }
                            }
                        }.runTaskTimer(plugin,0,1)
                    }

                } else {
                    if(activateBlock(jp,plg.skillManager,Skill.SLASH3)) return

                    val option = plg.skillManager.getSkillOption(Skill.SLASH3)
                    val event = SkillUseEvent(jp, option)
                    Bukkit.getServer().pluginManager.callEvent(event)
                }
            }
        }
    }
}