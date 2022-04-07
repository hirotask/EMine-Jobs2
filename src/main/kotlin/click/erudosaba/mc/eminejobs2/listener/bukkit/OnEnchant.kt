package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.enchantment.EnchantItemEvent

class OnEnchant(val plugin : Main) : Listener {
    @EventHandler
    fun onEnchantItem(e: EnchantItemEvent) {
        val player = e.enchanter
        for (jp in Main.jPlayers) {
            if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                jp.addExp(Jobs.ENCHANTER)
            }
        }
    }

}