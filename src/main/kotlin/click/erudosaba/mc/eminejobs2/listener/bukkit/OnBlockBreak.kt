package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.util.Blocks
import click.erudosaba.mc.eminejobs2.util.Items
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

class OnBlockBreak(val plugin : Main) : Listener {

    //ブロックが壊れた時ハンドラー
    @EventHandler
    fun onBlockBreak(e: BlockBreakEvent) {
        val player = e.player
        for (jp in Main.jPlayers) {
            if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                val brokenBlock = e.block

                val itemMainhand = player.inventory.itemInMainHand.type
                val itemOffhand = player.inventory.itemInOffHand.type

                if (Items.pickaxes.contains(itemMainhand) || Items.pickaxes.contains(itemOffhand)) {
                    if (Blocks.stones.contains(brokenBlock.type)) {
                        jp.addExp(Jobs.MINER)
                    }
                }

                if (Items.axes.contains(itemMainhand) || Items.axes.contains(itemOffhand)) {
                    if (Blocks.woods.contains(brokenBlock.type)) {
                        jp.addExp(Jobs.WOODCUTTER)
                    }
                }

                if (Items.shovels.contains(itemMainhand) || Items.shovels.contains(itemOffhand)) {
                    if (Blocks.dirts.contains(brokenBlock.type)) {
                        jp.addExp(Jobs.DIGGER)
                    }
                }

                if(Blocks.crops.contains(brokenBlock.type)) {
                    jp.addExp(Jobs.FARMER)
                }
            }
        }
    }

}