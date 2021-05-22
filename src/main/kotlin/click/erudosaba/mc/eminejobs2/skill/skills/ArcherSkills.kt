package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import org.bukkit.Material
import org.bukkit.entity.Arrow
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityShootBowEvent

class ArcherSkills(plugin: Main) {

    companion object {
        val jobID: String = "archer"
    }

    init {
        plugin.server.pluginManager.registerEvents(SpeedArrow(plugin),plugin)
        plugin.server.pluginManager.registerEvents(PowerArrow(plugin),plugin)
        plugin.server.pluginManager.registerEvents(HomingArrow(plugin),plugin)
    }

    class SpeedArrow(plg : Main) : Skill(plg,"SpeedArrow", "アイオロスの矢", ArcherSkills.jobID, arrayOf("10秒間自分が撃った矢に当たると空を飛べる","15秒間は落下ダメージが0となる"), Material.TIPPED_ARROW, 30, 25, 90), Listener {

        @EventHandler
        fun onArrowHitEntity(e : EntityDamageByEntityEvent) {
            if(e.damager !is Arrow) {
                return
            }

            val arrow = e.damager as Arrow

            if(arrow.shooter !is Player) {
                return
            }

            if(e.entity !is Player) {
                return
            }

            val shooter = arrow.shooter as Player
            val player = e.entity as Player
            val jp = JobPlayer(player,plugin)

            if(jp.skillStatus == SkillStatus.ENABLED) {
                if(shooter == player) {
                    val itemInHand = shooter.inventory.itemInMainHand

                    if(itemInHand.type == Material.BOW) {
                        val boostVec = player.location.direction.normalize().multiply(10.0).setY(1)
                        player.velocity = boostVec
                    }
                }
            }
        }
    }

    class PowerArrow(plg : Main) : Skill(plg,"PowerArrow", "アレスの矢", ArcherSkills.jobID, arrayOf("10秒間撃った矢が３方向に同時に飛ぶようになる"), Material.TIPPED_ARROW, 30, 30, 60), Listener {
        @EventHandler
        fun onShoot(e : EntityShootBowEvent) {
            val player = if(e.entity is Player) e.entity as Player else return
            val jp = JobPlayer(player,plugin)


        }
    }

    class HomingArrow(plg : Main) : Skill(plg,"HomingArrow", "ホーミングの矢", ArcherSkills.jobID, arrayOf("10秒間撃った矢がホーミングする"), Material.ARROW, 10, 35, 60), Listener {

    }
}