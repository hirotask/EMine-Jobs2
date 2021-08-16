package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import org.bukkit.Bukkit
import org.bukkit.Effect
import org.bukkit.GameMode
import org.bukkit.block.Block
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.event.player.PlayerToggleFlightEvent
import org.bukkit.event.player.PlayerToggleSneakEvent
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class GunnerSkills(val plugin : Main) : Listener, SkillProvider() {

    val cooldown = HashMap<Player,Boolean>()

    @EventHandler
    fun onDamage(e : EntityDamageEvent) {
        if(e.cause != EntityDamageEvent.DamageCause.FALL) return
        if(e.entity.type != EntityType.PLAYER) return

        val player = e.entity as Player

        for(jp in Main.jPlayers) {
            if (jp.playerName == player.name) {
                if (jp.hasJob()) {
                    if (jp.hasSkill()) {
                        if (jp.skillStatus == SkillStatus.ENABLED || jp.skillStatus == SkillStatus.INTERVAL) {
                            if (jp.jobID == jp.selectedSkill?.job) {
                                if(jp.selectedSkill == Skill.DOUBLEJUMP) {
                                    e.isCancelled = true

                                    if(player.isSneaking) {
                                        val blocks = ArrayList<Block>()
                                        blocks.add(player.world.getBlockAt(player.location.subtract(0.0,1.0,0.0)))
                                        blocks.add(player.world.getBlockAt(player.location.subtract(1.0,1.0,0.0)))
                                        blocks.add(player.world.getBlockAt(player.location.subtract(0.0,1.0,1.0)))
                                        blocks.add(player.world.getBlockAt(player.location.subtract(-1.0,1.0,0.0)))
                                        blocks.add(player.world.getBlockAt(player.location.subtract(0.0,1.0,-1.0)))
                                        blocks.add(player.world.getBlockAt(player.location.subtract(1.0,1.0,1.0)))
                                        blocks.add(player.world.getBlockAt(player.location.subtract(-1.0,1.0,-1.0)))
                                        blocks.add(player.world.getBlockAt(player.location.subtract(2.0,1.0,0.0)))
                                        blocks.add(player.world.getBlockAt(player.location.subtract(-2.0,1.0,0.0)))
                                        blocks.add(player.world.getBlockAt(player.location.subtract(0.0,1.0,2.0)))
                                        blocks.add(player.world.getBlockAt(player.location.subtract(0.0,1.0,-2.0)))

                                        for(block in blocks) {
                                            player.playEffect(block.location, Effect.STEP_SOUND,block.type.id)
                                        }

                                        player.isSneaking = false
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    fun onToggleSneak(e : PlayerToggleSneakEvent) {
        val player = e.player

        for(jp in Main.jPlayers) {
            if (jp.playerName == player.name) {
                if (block(jp)) return

                if (jp.selectedSkill == Skill.DOUBLEJUMP) {
                    if(!player.isOnGround && cooldown[player] != null && cooldown[player] == false) {
                        player.velocity = org.bukkit.util.Vector(0,-5,0)
                    }
                }
            }
        }
    }

    @EventHandler
    fun onMove(e : PlayerMoveEvent) {
        val player = e.player

        if(player.gameMode == GameMode.CREATIVE || player.gameMode == GameMode.CREATIVE) return
        for(jp in Main.jPlayers) {
            if (jp.playerName == player.name) {
                if (block(jp)) return

                if (jp.selectedSkill == Skill.DOUBLEJUMP) {
                    player.allowFlight = cooldown[player] != null && cooldown[player] == true

                    if(player.isOnGround) {
                        cooldown[player] = true
                    }
                }
            }
        }

    }

    @EventHandler
    fun onToggleFlight(e : PlayerToggleFlightEvent) {
        val player = e.player

        if(player.gameMode == GameMode.CREATIVE || player.gameMode == GameMode.SPECTATOR) return

        for(jp in Main.jPlayers) {
            if (jp.playerName == player.name) {
                if (block(jp)) return

                if (jp.selectedSkill == Skill.DOUBLEJUMP) {
                    if(cooldown[player] == true) {
                        e.isCancelled = true
                        cooldown[player] = false
                        player.velocity = player.location.direction.multiply(1.6).setY(1.0)
                        player.playEffect(player.location,Effect.MOBSPAWNER_FLAMES,2004)

                        player.allowFlight = false
                    }
                }
            }
        }
    }

}