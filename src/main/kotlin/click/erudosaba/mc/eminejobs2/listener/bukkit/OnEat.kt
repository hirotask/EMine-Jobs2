package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.EatEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.util.Items
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.FoodLevelChangeEvent
import org.bukkit.event.player.PlayerInteractEvent

class OnEat(val plugin: Main) : Listener {

    private var beforeEat = 0
    private var afterEat = 0
    private var isEating = false

    @EventHandler
    fun onInteract(e: PlayerInteractEvent) {
        if (e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK) {
            val player = e.player
            val itemInMainHand = player.inventory.itemInMainHand
            val itemInOffHand = player.inventory.itemInOffHand

            if(!isEating) {
                if (Items.foods.contains(itemInMainHand.type) || Items.foods.contains(itemInOffHand.type)) {
                    beforeEat = player.foodLevel
                    isEating = true
                }
            }
        }
    }

    @EventHandler
    fun onFoodLevelChanged(e: FoodLevelChangeEvent) {
        val player = if (e.entity is Player) e.entity as Player else return

        if(isEating) {
            afterEat = e.foodLevel
            val diff = afterEat - beforeEat

            val event = EatEvent(JobPlayer(player,plugin), diff)
            plugin.server.pluginManager.callEvent(event)
            isEating = false
        }
    }
}