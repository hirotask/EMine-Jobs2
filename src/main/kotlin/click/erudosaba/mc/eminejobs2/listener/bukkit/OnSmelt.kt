package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import org.bukkit.Bukkit
import org.bukkit.block.Furnace
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.FurnaceInventory

//精練が完了したときに，SmeltEventを発火するためのListener
class OnSmelt(private val plg : Main) : Listener {

    @EventHandler
    fun onInteract(e : PlayerInteractEvent) {
        val player = e.player
        for (jp in Main.jPlayers) {
            if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                if (e.action != Action.RIGHT_CLICK_BLOCK) return
                if (e.clickedBlock!!.state !is Furnace) return

                val furnace: Furnace = e.clickedBlock!!.state as Furnace
                val inventory: FurnaceInventory = furnace.inventory

                //SmeltEventの発火
                if(inventory.result != null) {
                    jp.addExp(Jobs.SMELTER)
                }

            }
        }


    }
}