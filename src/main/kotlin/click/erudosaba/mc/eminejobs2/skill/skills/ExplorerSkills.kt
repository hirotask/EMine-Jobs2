package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.block.BlockFace
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.util.Vector

class ExplorerSkills(val plugin : Main) : Listener, SkillProvider() {

    @EventHandler
    fun onMove(e : PlayerMoveEvent) {

    }

    @EventHandler
    fun onInteract(e : PlayerInteractEvent) {
        if(e.action == Action.RIGHT_CLICK_BLOCK) {
            if(e.clickedBlock == null) return

            val clickedBlock = e.clickedBlock!!
            val player = e.player

            for (jp in Main.jPlayers) {
                if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                    if(jp.selectedSkill == Skill.WALLCLIMB) {
                        climb(player,clickedBlock)
                    }
                }
            }
        }
    }

    private fun climb(player : Player, clickedBlock : Block) {

        if(player.location.distance(clickedBlock.location) < 3) {

        }

    }


}