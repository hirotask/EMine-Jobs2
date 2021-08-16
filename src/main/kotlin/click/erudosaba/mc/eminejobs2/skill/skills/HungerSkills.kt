package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import click.erudosaba.mc.eminejobs2.util.Foods
import click.erudosaba.mc.eminejobs2.util.Items
import org.bukkit.Material
import org.bukkit.block.Container
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.FoodLevelChangeEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scheduler.BukkitRunnable
import kotlin.random.Random

class HungerSkills(val plugin: Main) : Listener, SkillProvider() {

    private var beforeEatLevel: Int = 0
    private var afterEatLevel: Int = 0

    @EventHandler
    fun onInteract(e: PlayerInteractEvent) {
        if (e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK) {
            if(e.item == null) return
            if(e.clickedBlock is Container) return
            if(e.player.foodLevel >= 20) return

            val player = e.player
            val item = e.item


            for (jp in Main.jPlayers) {
                if (jp.playerName == player.name) {
                    if (block(jp)) return

                    if(jp.selectedSkill == Skill.FASTEAT) {
                        object : BukkitRunnable() {
                            override fun run() {
                                if(player.inventory.itemInMainHand == item) {
                                    if(Items.foods.contains(item.type)) {
                                        val rand = Random

                                        when(item.type) {
                                            Material.GOLDEN_APPLE -> {
                                                player.addPotionEffect(PotionEffect(PotionEffectType.ABSORPTION, 2400, 0))
                                                player.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION, 100, 1))
                                            }
                                            Material.ENCHANTED_GOLDEN_APPLE -> {
                                                player.addPotionEffect(PotionEffect(PotionEffectType.ABSORPTION, 2400, 3))
                                                player.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION, 400, 1))
                                                player.addPotionEffect(PotionEffect(PotionEffectType.FIRE_RESISTANCE, 6000, 0))
                                                player.addPotionEffect(PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 6000, 0))
                                            }
                                            Material.MILK_BUCKET -> {
                                                for (effect in player.activePotionEffects) player.removePotionEffect(effect.type)
                                                player.inventory.addItem(ItemStack(Material.BUCKET))
                                            }
                                            Material.PUFFERFISH -> {
                                                val chance: Double = rand.nextDouble()
                                                if (chance < 0.50) {
                                                    player.addPotionEffect(PotionEffect(PotionEffectType.HUNGER, 300, 2))
                                                } else if (chance >= 0.80) {
                                                    player.addPotionEffect(PotionEffect(PotionEffectType.CONFUSION, 300, 1))
                                                } else if (chance <= 0.95) {
                                                    player.addPotionEffect(PotionEffect(PotionEffectType.POISON, 1200, 3))
                                                }
                                            }
                                            Material.POISONOUS_POTATO -> {
                                                val chanceFleshPotato: Double = rand.nextDouble()
                                                if (chanceFleshPotato <= 0.80) {
                                                    player.addPotionEffect(PotionEffect(PotionEffectType.HUNGER, 600, 0))
                                                }
                                            }
                                            Material.SPIDER_EYE -> {
                                                player.addPotionEffect(PotionEffect(PotionEffectType.POISON, 80, 0))
                                            }
                                            Material.BEETROOT_SOUP -> {
                                                player.inventory.addItem(ItemStack(Material.BOWL))
                                            }
                                            Material.HONEY_BOTTLE -> {
                                                player.inventory.addItem(ItemStack(Material.GLASS_BOTTLE));
                                            }
                                        }
                                        val foods = Foods.valueOf(item.type.name).value
                                        player.foodLevel = player.foodLevel + foods[0]
                                        player.saturation = player.saturation + foods[1]
                                        item.amount = item.amount -1
                                    }
                                }
                            }

                        }.runTaskLater(plugin,5)

                    }

                }
            }
        }
    }

    @EventHandler
    fun onFoodLevelChanged(e: FoodLevelChangeEvent) {
        val player = if (e.entity is Player) e.entity as Player else return
        for (jp in Main.jPlayers) {
            if (jp.playerName == player.name) {
                if (block(jp)) return

                beforeEatLevel = (e.entity as Player).foodLevel
                afterEatLevel = e.foodLevel

                if (jp.selectedSkill == Skill.ALWAYSFULL) {
                    if (afterEatLevel - beforeEatLevel < 0) {
                        e.isCancelled = true
                    }
                }
            }
        }
    }
}