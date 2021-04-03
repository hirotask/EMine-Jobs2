package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.SkillUseEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.SkillManager
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import click.erudosaba.mc.eminejobs2.util.Items
import org.bukkit.Bukkit
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.scheduler.BukkitRunnable

class OnInteract(val plugin : Main) : Listener {

    @EventHandler
    fun onInteract(e : PlayerInteractEvent) {
        if(e.action == Action.RIGHT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_AIR) {
            val player = e.player
            val jp = JobPlayer(player, plugin)
            //スキル発動
            if(player.isSneaking) {
                if(jp.hasJob() && jp.hasSkill()) {
                    val skill = jp.selectedSkill
                    val skillmanager = SkillManager(plugin, jp)

                    skillmanager.run(skill,skill.effect.skilltime)
                }
            } else {
                //剣士スキル発動
                if(jp.skillStatus == SkillStatus.RUNNING){
                    if(Items.swords.contains(player.inventory.itemInMainHand.type) || Items.swords.contains(player.inventory.itemInOffHand.type)) {
                        player.sendMessage("剣士スキル発動")

                        object : BukkitRunnable() {
                            var t = 0.0
                            override fun run() {
                                t += 0.5
                                val loc = player.eyeLocation
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
                                        if(e !is Player) continue

                                        val p : Player = e
                                        p.damage(6.0)


                                    }
                                }

                                loc.subtract(x,y,z)

                                if(t > 20) {
                                    this.cancel()
                                }
                            }

                        }.runTaskTimer(plugin,0,1)

                    }
                }
            }



        }
    }

}