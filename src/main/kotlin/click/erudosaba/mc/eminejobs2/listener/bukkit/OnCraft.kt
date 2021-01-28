package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.CraftEvent
import org.bukkit.craftbukkit.v1_16_R2.event.CraftEventFactory
import org.bukkit.entity.Player
import org.bukkit.event.Cancellable
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.CraftItemEvent

class OnCraft(val plugin : Main) : Listener {

    @EventHandler
    fun onCraft(e: CraftItemEvent) {
        val player = if(e.whoClicked is Player) e.whoClicked as Player else return
        val result = if(e.currentItem != null) e.currentItem else return

        val event = CraftEvent(player, result!!)
        plugin.server.pluginManager.callEvent(event)
    }
}