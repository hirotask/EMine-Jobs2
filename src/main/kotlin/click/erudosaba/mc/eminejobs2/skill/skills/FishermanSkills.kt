package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import click.erudosaba.mc.eminejobs2.util.Items
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack
import kotlin.random.Random

class FishermanSkills(val plugin: Main) : Listener, SkillProvider() {

    @EventHandler
    fun onInteract(e: PlayerInteractEvent) {
        val player = e.player
        for (jp in Main.jPlayers) {
            if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                val action = e.action

                if (block(jp)) return

                if (jp.selectedSkill == Skill.CATCHFISH) { //CatchFishのスキル
                    if (action == Action.RIGHT_CLICK_BLOCK && e.clickedBlock != null) {
                        val block = e.clickedBlock!!

                        if (block.isLiquid && block.type == Material.WATER) {
                            val randomInt = Random.nextInt(Items.fish.size)
                            val fish = ItemStack(Items.fish[randomInt])

                            player.inventory.addItem(fish)
                        }
                    }
                }

            }
        }

    }

}