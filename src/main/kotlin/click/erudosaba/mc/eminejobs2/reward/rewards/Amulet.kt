package click.erudosaba.mc.eminejobs2.reward.rewards

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.reward.RewardItem
import click.erudosaba.mc.eminejobs2.reward.RewardManager
import org.bukkit.Material
import org.bukkit.block.Chest
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.PlayerDeathEvent

class Amulet(val plugin : Main) : Listener {

    @EventHandler
    fun onDamage(e : EntityDamageEvent) {
        if(e.entity !is Player) return

        val player = e.entity as Player
        val rm = RewardManager(plugin)
        if(player.health <= 0) { //プレイヤーが死んだとき
            if(player.inventory.contains(rm.getItem(RewardItem.AMULET))) {
                val inv = player.inventory
                val loc = player.location.block.location.clone().subtract(0.0,-1.0,0.0)
                loc.block.type = Material.CHEST //死んだ地点にチェストを設置

                val chest = loc.block.state as Chest

                for(item in inv.contents) {
                    chest.inventory.addItem(item)
                }
            }
        }
    }
}