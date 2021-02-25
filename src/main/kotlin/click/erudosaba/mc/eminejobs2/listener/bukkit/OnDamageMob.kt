package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.BowMobEvent
import click.erudosaba.mc.eminejobs2.event.SlashMobEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
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

            val event = BowMobEvent(JobPlayer(player,plugin),entity)
            plugin.server.pluginManager.callEvent(event)
        } else {
            val player = e.damager as Player

            val itemMainhand = player.inventory.itemInMainHand.type
            val itemOffhand = player.inventory.itemInOffHand.type

            if(Items.swords.contains(itemMainhand) || Items.swords.contains(itemOffhand)) {
                val event = SlashMobEvent(JobPlayer(player,plugin),entity)
                plugin.server.pluginManager.callEvent(event)
            }
        }
    }
}