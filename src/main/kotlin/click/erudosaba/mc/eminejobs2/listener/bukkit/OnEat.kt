package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.util.Items
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.FoodLevelChangeEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerMoveEvent

class OnEat(val plugin: Main) : Listener {

    private var isEating = false

    @EventHandler
    fun onInteract(e: PlayerInteractEvent) {
        if (e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK) {
            val player = e.player
            val itemInMainHand = player.inventory.itemInMainHand
            val itemInOffHand = player.inventory.itemInOffHand

            if(!isEating) {
                if (Items.foods.contains(itemInMainHand.type) || Items.foods.contains(itemInOffHand.type)) {
                    isEating = true
                }
            }
        }
    }

    @EventHandler
    fun onMove(e : PlayerMoveEvent) {
        if(isEating) isEating = false
    }

    @EventHandler
    fun onFoodLevelChanged(e: FoodLevelChangeEvent) {
        val player = if (e.entity is Player) e.entity as Player else return
        for (jp in Main.jPlayers) {
            if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                if(isEating) {
                    jp.addExp(Jobs.HUNGER)
                    isEating = false
                }
            }
        }
    }
}