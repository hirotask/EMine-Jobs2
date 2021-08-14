package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.inventory.BrewEvent
import org.bukkit.event.player.PlayerInteractEvent

class OnBrew(val plg : Main) : Listener {

    lateinit var player : Player
    lateinit var block : Block

    @EventHandler
    fun onInteract(e : PlayerInteractEvent) {
        if(e.action == Action.RIGHT_CLICK_BLOCK) { //醸造台をクリックしたとき
            if(e.clickedBlock != null) {
                if(e.clickedBlock!!.type == Material.BREWING_STAND) {
                    block = e.clickedBlock!!
                    player = e.player
                }
            }
        }
    }

    @EventHandler
    fun onBrew(e : BrewEvent) {
        if(e.block.location.x == block.location.x
                && e.block.location.y == block.location.y
                && e.block.location.z == block.location.z) {
            val jp = JobPlayer(player,plg)
            jp.addExp(Jobs.BREWER)
        }
    }

}