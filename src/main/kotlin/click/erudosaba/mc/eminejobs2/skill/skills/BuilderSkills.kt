package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import click.erudosaba.mc.eminejobs2.util.Blocks
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockDamageEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.player.PlayerMoveEvent

class BuilderSkills(val plugin: Main) : Listener, SkillProvider() {
    @EventHandler
    fun onBlockDamage(e: BlockDamageEvent) {
        val player = e.player
        for (jp in Main.jPlayers) {
            if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                if (block(jp)) return

                //ここからPROTEAN
                if (jp.selectedSkill != Skill.PROTEAN) return
                val targetBlock = e.block
                val blockInOffHand = player.inventory.itemInOffHand

                if (!Blocks.ores.contains(targetBlock.type) && !Blocks.ores.contains(blockInOffHand.type)) {
                    if (blockInOffHand.type == Material.AIR) {
                        return
                    }

                    targetBlock.type = blockInOffHand.type
                    targetBlock.location.world?.playSound(targetBlock.location, Sound.BLOCK_FIRE_EXTINGUISH, 0.5F, 1.3F)
                    targetBlock.location.world?.spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, targetBlock.location, 2)
                }
                //ここまでPROTEAN
            }
        }


    }

    @EventHandler
    fun onMove(e: PlayerMoveEvent) {
        val player = e.player
        for (jp in Main.jPlayers) {
            if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                if (block(jp)) return


                //ここからLEVITATION
                if (jp.selectedSkill != Skill.LEVITATION) return

                if (jp.skillStatus == SkillStatus.ENABLED) {
                    player.allowFlight = true
                    player.isFlying = true
                } else {
                    player.allowFlight = false
                    player.isFlying = false
                }
            }
        }
    }

    @EventHandler
    fun onPlayerDamage(e: EntityDamageEvent) {
        val player = if (e.entity is Player) e.entity as Player else return
        for (jp in Main.jPlayers) {
            if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                if (block(jp)) return

                //ここからLEVITATION
                if (jp.selectedSkill != Skill.LEVITATION) return

                if (e.cause == EntityDamageEvent.DamageCause.FALL) {
                    e.isCancelled = true
                }
            }
        }
    }
}