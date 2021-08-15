package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.util.Blocks
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent

class OnBlockPlace(val plugin : Main) : Listener {

    @EventHandler
    fun onBlockPlace(e: BlockPlaceEvent) {
        val player = e.player
        for (jp in Main.jPlayers) {
            if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                val block = e.block

                if(Blocks.BuildBlocks.contains(block.type)) {
                    jp.addExp(Jobs.BUILDER)
                }
            }
        }

    }
}