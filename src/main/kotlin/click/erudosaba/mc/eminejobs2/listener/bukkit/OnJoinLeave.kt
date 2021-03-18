package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.util.SideBar
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class OnJoinLeave(val plugin : Main) : Listener {
    @EventHandler
    fun onJoin(e : PlayerJoinEvent) {
        SideBar(plugin, e.player)
    }
}