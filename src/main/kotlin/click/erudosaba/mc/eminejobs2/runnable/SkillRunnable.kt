package click.erudosaba.mc.eminejobs2.runnable

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.Job
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import click.erudosaba.mc.eminejobs2.skill.effect.Effect
import org.bukkit.Bukkit
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scheduler.BukkitTask

class SkillRunnable(val plugin : Main, jp : JobPlayer, val time : Int = 0) : BukkitRunnable(){

    var count = time
    val effect = jp.selectedSkill.effect
    val player = jp.player
    var skillStatus = jp.skillStatus
    var task : BukkitTask? = null

    //Slash1
    private var t = 0.0

    override fun run() {
        if(skillStatus != SkillStatus.RUNNING) {
            return
        }

        when(effect) {
            Effect.Slash1 -> {
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
                    //skillStatus = SkillStatus.INTERVAL
                    plugin.server.scheduler.cancelTask(task!!.taskId)
                }
            }
        }
    }
}