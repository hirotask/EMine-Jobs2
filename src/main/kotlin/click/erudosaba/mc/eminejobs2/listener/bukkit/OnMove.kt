package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.Effect
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import click.erudosaba.mc.eminejobs2.util.Items
import org.bukkit.Material
import org.bukkit.block.BlockFace
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent

class OnMove(val plugin : Main) : Listener {

    @EventHandler
    fun onPlayerMove(e : PlayerMoveEvent) {
        val player = e.player
        val jp = JobPlayer(player, plugin)

        if(jp.skillStatus != SkillStatus.RUNNING) return

        //FrostWalk発動
        if (jp.selectedSkill.effect == Effect.FrostWalk) {
            val downBlock = player.location.block.getRelative(BlockFace.DOWN)
            if(downBlock.isLiquid) {
                if(downBlock.type == Material.WATER) {
                    downBlock.type = Material.ICE
                }
            }
        }
    }
}