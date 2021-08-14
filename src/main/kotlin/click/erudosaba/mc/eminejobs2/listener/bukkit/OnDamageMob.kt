package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.util.Items
import org.bukkit.entity.Arrow
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent

class OnDamageMob(val plugin : Main) : Listener {

    @EventHandler
    fun onSlashMob(e: EntityDamageByEntityEvent) {
        val entity = e.entity

        if(e.damager !is Player) {
            val arrow = if(e.damager is Arrow) e.damager as Arrow else return
            val player = if(arrow.shooter is Player) arrow.shooter as Player else return
            val jp = JobPlayer(player,plugin)

            jp.addExp(Jobs.ARCHER)
        } else {
            val player = e.damager as Player
            val jp = JobPlayer(player,plugin)

            val itemMainhand = player.inventory.itemInMainHand.type
            val itemOffhand = player.inventory.itemInOffHand.type

            if(Items.swords.contains(itemMainhand) || Items.swords.contains(itemOffhand)) {
                jp.addExp(Jobs.SWORDMAN)
            }
        }
    }
}