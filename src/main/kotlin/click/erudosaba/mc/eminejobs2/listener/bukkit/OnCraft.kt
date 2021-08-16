package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import me.zombie_striker.qg.api.QualityArmory
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.CraftItemEvent

class OnCraft(val plugin : Main) : Listener {

    @EventHandler
    fun onCraft(e: CraftItemEvent) {
        val player = if(e.whoClicked is Player) e.whoClicked as Player else return
        for (jp in Main.jPlayers) {
            if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                val result = if(e.currentItem != null) e.currentItem else return

                if(QualityArmory.isGun(result) || QualityArmory.isAmmo(result)) {
                    jp.addExp(Jobs.GUNNER)
                } else {
                    jp.addExp(Jobs.CRAFTER)
                }
            }
        }
    }
}