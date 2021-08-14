package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import org.bukkit.entity.Item
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerFishEvent


class OnFish(val plugin : Main) : Listener {

    @EventHandler
    fun onFish(e: PlayerFishEvent) {
        val player = e.player
        val jp = JobPlayer(player,plugin)
        val item = if(e.caught is Item) e.caught as Item else return

        jp.addExp(Jobs.FISHERMAN)
    }

}