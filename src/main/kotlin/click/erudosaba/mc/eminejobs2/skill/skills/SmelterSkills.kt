package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.block.Furnace
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.FurnaceInventory
import org.bukkit.inventory.FurnaceRecipe
import org.bukkit.inventory.ItemStack
import org.bukkit.scheduler.BukkitRunnable


class SmelterSkills(val plugin: Main) : Listener, SkillProvider() {

    companion object {
        var run = true
    }

    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        val player = event.player
        for (jp in Main.jPlayers) {
            if (jp.uuid == Bukkit.getPlayer(player.name)?.uniqueId) {
                if (block(jp)) return

                if (event.action != Action.RIGHT_CLICK_BLOCK) return
                if (event.clickedBlock!!.state !is Furnace) return
                val furnace: Furnace = event.clickedBlock!!.state as Furnace
                val inventory: FurnaceInventory = furnace.inventory

                // メイン処理

                // 1回までに制限
                if (!run) {
                    player.sendMessage("二回目以降です")
                    return
                }
                run = false
                if (!isBurning(inventory)) return
                val skillTime = 60
                val cut = 2.0
                var time = (200 - furnace.cookTime).toLong()
                time *= (1 / cut).toLong()
                var cookTime: Long = 200
                cookTime *= (1 / cut).toLong()
                val difference = 1
                while (time <= 20 * skillTime) {
                    object : BukkitRunnable() {
                        override fun run() {
                            // 燃えてるか
                            if (!isBurning(inventory)) {
                                cancel()
                                return
                            }

                            // message
                            player.playSound(player.location, Sound.BLOCK_ANVIL_PLACE, 1f, 1f)

                            // smeltingを1減らす
                            val smelting: ItemStack? = inventory.smelting
                            if (smelting != null) {
                                smelting.amount = smelting.amount - 1
                            }
                            inventory.smelting = smelting
                            inventory.smelting = null

                            // resultを1増やす
                            var result: ItemStack? = inventory.result
                            if (result == null) result = ItemStack(getFurnaceRecipeResult(smelting!!.type)!!) // null
                            else result.setAmount(result.getAmount() + 1)
                            if (result.getAmount() === result.getMaxStackSize()) inventory.location!!.world!!.dropItem(inventory.location!!, result) else inventory.result = result

                            // cookTimeを0にする
                            object : BukkitRunnable() {
                                override fun run() {
                                    inventory.smelting = smelting

                                    // 繰り返し
                                    if (!isBurning(inventory)) {
                                        cancel()
                                        return
                                    }
                                    var cookTime: Long = 200
                                    cookTime *= (1 / 1.3).toLong()
                                    cancel()
                                    return
                                }
                            }.runTaskLater(plugin, difference.toLong())
                        }
                    }.runTaskLater(plugin, time.toLong())
                    time += (cookTime + difference).toLong()
                }
            }
        }
    }

    // 製錬可能か
    fun isBurning(inventory: FurnaceInventory): Boolean {
        // 燃料確認
        if (inventory.fuel == null) return false
        if (!inventory.fuel!!.type.isFuel) return false
        // 燃やすアイテムが燃えるか確認
        if (inventory.smelting == null) return false
        if (!isFurnaceRecipeInput(inventory.smelting!!.type)) return false
        // 燃やしたアイテムがスタック上限か
        if (inventory.result == null) return true
        return inventory.result!!.amount != inventory.result!!.maxStackSize
    }

    fun getFurnaceRecipeResult(material: Material): Material? {
        if (material == Material.OAK_LOG || material == Material.BIRCH_LOG || material == Material.SPRUCE_LOG || material == Material.JUNGLE_LOG || material == Material.ACACIA_LOG || material == Material.STRIPPED_OAK_LOG || material == Material.STRIPPED_BIRCH_LOG || material == Material.STRIPPED_SPRUCE_LOG || material == Material.STRIPPED_JUNGLE_LOG || material == Material.STRIPPED_ACACIA_LOG || material == Material.STRIPPED_DARK_OAK_LOG) return Material.CHARCOAL
        var result: Material? = null
        val recipeIterator = Bukkit.recipeIterator()
        while (recipeIterator.hasNext()) {
            val recipe = recipeIterator.next() as? FurnaceRecipe ?: continue
            val furnaceRecipe: FurnaceRecipe = recipe as FurnaceRecipe
            if (furnaceRecipe.input.type !== material) continue
            result = furnaceRecipe.result.type
        }
        return result
    }

    private fun isFurnaceRecipeInput(material: Material): Boolean {
        if (material == Material.OAK_LOG || material == Material.BIRCH_LOG || material == Material.SPRUCE_LOG || material == Material.JUNGLE_LOG || material == Material.ACACIA_LOG || material == Material.STRIPPED_OAK_LOG || material == Material.STRIPPED_BIRCH_LOG || material == Material.STRIPPED_SPRUCE_LOG || material == Material.STRIPPED_JUNGLE_LOG || material == Material.STRIPPED_ACACIA_LOG || material == Material.STRIPPED_DARK_OAK_LOG) return true
        var `is` = false
        val recipeIterator = Bukkit.recipeIterator()
        while (recipeIterator.hasNext()) {
            val recipe = recipeIterator.next() as? FurnaceRecipe ?: continue
            val furnaceRecipe: FurnaceRecipe = recipe as FurnaceRecipe
            if (furnaceRecipe.input.type !== material) continue
            `is` = true
            break
        }
        return `is`
    }

}