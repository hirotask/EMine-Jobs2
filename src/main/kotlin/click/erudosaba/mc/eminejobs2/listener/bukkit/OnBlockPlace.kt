package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.util.Blocks
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent

class OnBlockPlace(val plugin : Main) : Listener {

    @EventHandler
    fun onBlockPlace(e: BlockPlaceEvent) {
        val player = e.player
        val jp = JobPlayer(player,plugin)
        val block = e.block

        if(Blocks.BuildBlocks.contains(block.type)) {
            jp.addExp(Jobs.BUILDER)
        }
    }
}