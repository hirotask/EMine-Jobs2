package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.EnchantEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.enchantment.EnchantItemEvent

class OnEnchant(val plugin : Main) : Listener {
    @EventHandler
    fun onEnchantItem(e: EnchantItemEvent) {
        val player = e.enchanter
        val item = e.item

        val event = EnchantEvent(JobPlayer(player),item)
        plugin.server.pluginManager.callEvent(event)
    }

}