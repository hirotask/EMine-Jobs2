package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.CraftItemEvent

class OnCraft(val plugin : Main) : Listener {

    @EventHandler
    fun onCraft(e: CraftItemEvent) {
        val player = if(e.whoClicked is Player) e.whoClicked as Player else return
        val jp = JobPlayer(player,plugin)
        val result = if(e.currentItem != null) e.currentItem else return

        jp.addExp(Jobs.CRAFTER)
    }
}