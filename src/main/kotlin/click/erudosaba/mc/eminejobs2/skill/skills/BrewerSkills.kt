package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.block.BrewingStand
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.inventory.BrewEvent
import org.bukkit.event.inventory.BrewingStandFuelEvent
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerInteractEvent

class BrewerSkills(val plugin: Main) : Listener, SkillProvider() {

    var run = true


    @EventHandler
    fun onInteract(e: PlayerInteractEvent) {
        if (e.action == Action.RIGHT_CLICK_BLOCK) {
            if (e.clickedBlock != null && e.clickedBlock!!.type == Material.BREWING_STAND) {
                val player = e.player
                val stand = e.clickedBlock!!.state as BrewingStand


                if (!run) {
                    player.sendMessage("二回目以降です")
                    return
                }
                run = false


                for (jp in Main.jPlayers) {
                    if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                        if (block(jp)) return

                        var multiply = 0.0

                        when (jp.selectedSkill) {
                            Skill.FASTBREWING1 -> {
                                multiply = 0.8
                            }
                            Skill.FASTBREWING2 -> {
                                multiply = 0.6
                            }
                            Skill.FASTBREWING3 -> {
                                multiply = 0.4
                            }
                        }

                        stand.brewingTime = (stand.brewingTime * multiply).toInt()
                        player.playSound(player.location, Sound.BLOCK_ANVIL_PLACE, 0.5f, 1f)
                        break
                    }
                }
            }
        }

    }
}