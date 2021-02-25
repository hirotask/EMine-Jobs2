package click.erudosaba.mc.eminejobs2.listener

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.PlayerLevelUpEvent
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class JobEventListener(val plugin : Main) : Listener{

    @EventHandler
    fun onLevelUp(e: PlayerLevelUpEvent) {
        val player = e.player

        player.sendMessage("${ChatColor.GOLD} レベルアップｗｗｗｗｗ！！！")
    }
}