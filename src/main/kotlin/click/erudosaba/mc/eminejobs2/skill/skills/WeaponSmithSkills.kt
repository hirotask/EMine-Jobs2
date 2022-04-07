package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.AnvilInventory
import org.bukkit.inventory.ItemStack


class WeaponSmithSkills(val plugin: Main) : Listener, SkillProvider() {

    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) {

        val player = event.whoClicked as Player
        for (jp in Main.jPlayers) {
            if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                if (block(jp)) return

                // Anvil Inventoryか確認
                if (event.clickedInventory !is AnvilInventory) return
                val inventory = event.clickedInventory as AnvilInventory?
                if (event.slot != 2) return
                if (inventory!!.getItem(2) == null) return
                var cost = inventory.repairCost - 4
                if (cost < 1) cost = 1
                val level = player.level - cost
                if (level < 0) return

                // メイン処理
                event.isCancelled = true

                if (event.currentItem != null) {
                    val item: ItemStack = event.currentItem!!
                    inventory.setItem(0, null)
                    inventory.setItem(1, null)
                    inventory.setItem(2, null)
                    player.level = level
                    player.playSound(player.location, Sound.BLOCK_ANVIL_USE, 1f, 1f)
                    player.inventory.addItem(item).forEach { (integer: Int?, itemStack: ItemStack?) -> player.world.dropItem(player.location, itemStack!!) }
                }
            }
        }
    }
}