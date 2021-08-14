package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.gui.menu.BrowseMenu
import click.erudosaba.mc.eminejobs2.gui.menu.SkillMenu
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.AnvilInventory

class OnInventoryClick(val plugin: Main) : Listener {

    @EventHandler
    fun onInvClick(e: InventoryClickEvent) {
        val title = e.view.title
        val player = e.whoClicked as Player
        val jp = JobPlayer(player,plugin)
        val slot = e.slot
        val clickType = e.click
        val inventory = e.clickedInventory

        //ForgeEvent発火処理
        if (inventory is AnvilInventory) {
            if (slot == 2 && inventory.getItem(slot) != null) {
                jp.addExp(Jobs.WEAPONSMITH)
            }
        }


        when(title) { //GUIの処理
            BrowseMenu.title -> {
                if (BrowseMenu(plugin, player).onClick(slot, clickType)) {
                    e.isCancelled = true
                }
            }
            SkillMenu.title -> {
                if (SkillMenu(plugin, player).onClick(slot, clickType)) {
                    e.isCancelled = true
                }
            }
        }
    }
}