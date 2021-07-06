package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.gui.menu.BrowseMenu
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

class OnInventoryClick(val plugin: Main) : Listener {

    @EventHandler
    fun onInvClick(e: InventoryClickEvent) {
        val title = e.view.title
        val player = e.whoClicked as Player
        val slot = e.slot
        val clickType = e.click
        when(title) {
            BrowseMenu.title -> {
                if (BrowseMenu(plugin, player).onClick(slot, clickType)) {
                    e.isCancelled = true
                }
            }
        }
    }
}