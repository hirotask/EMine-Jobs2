package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import click.erudosaba.mc.eminejobs2.util.Blocks
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.block.data.Ageable
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.scheduler.BukkitRunnable
import kotlin.math.max
import kotlin.math.min

class FarmerSkills(val plugin: Main) : Listener, SkillProvider() {

    @EventHandler
    fun onMove(e: PlayerMoveEvent) {
        val player = e.player
        val jp = JobPlayer(player, plugin)

        if (block(jp)) return

        when (jp.selectedSkill) {
            Skill.GROWING1 -> {
                autoGrowing(player, 3)
            }
            Skill.GROWING2 -> {
                autoGrowing(player, 5)
            }
            Skill.GROWING3 -> {
                autoGrowing(player, 8)
            }
            Skill.AUTOHARVEST -> {
                harvest(player,3)
            }
        }
    }

    //Location locを中心とした，半径radiusの範囲のブロックを取得
    private fun sphereAround(loc: Location, radius: Int): Set<Block> {
        val sphere = HashSet<Block>()
        val center = loc.block
        for (x in -radius..radius) {
            for (y in -radius..radius) {
                for (z in -radius..radius) {
                    val b = center.getRelative(x, y, z)

                    if (center.location.distance((b.location)) <= radius) {
                        sphere.add(b)
                    }
                }
            }
        }

        return sphere
    }

    private fun getCropAge(block: Block): Int {
        val data = block.blockData

        if (data is Ageable) {
            return data.age
        }

        return -1
    }

    private fun isFullyGrown(block: Block): Boolean {
        val data = block.blockData

        if (data is Ageable) {
            return data.age == data.maximumAge
        }

        return false
    }

    private fun setCropAge(block: Block, age: Int) {
        val data = block.blockData

        if (data is Ageable) {
            data.age = min(age, data.maximumAge)
            block.blockData = data
        }

    }

    private fun autoGrowing(player: Player, radius: Int) {
        val crops = sphereAround(player.location, radius)

        for (crop in crops) {
            if (getCropAge(crop) > -1) {
                setCropAge(crop, getCropAge(crop)+1)
            }
        }
    }

    private fun harvest(player: Player, radius: Int) {
        val crops = sphereAround(player.location, radius)

        for (crop in crops) {
            val cropType = crop.type
            if (Blocks.crops.contains(cropType)) {
                if (isFullyGrown(crop)) {
                    crop.breakNaturally()

                    val seedType = getSeedType(cropType)
                    if (isSeedInInventory(player, cropType)) {
                        removeSeed(player, seedType)
                        crop.location.block.type = cropType
                    }
                }
            }
        }
    }

    private fun removeSeed(player : Player, seedType : Material) {
        var seedIndex = -1
        val inventory = player.inventory

        for(slotIndex in 0 until inventory.size) {
            val currentItem = inventory.getItem(slotIndex)
            if(currentItem != null) {
                if(currentItem.type == seedType) {
                    seedIndex = slotIndex
                    break
                }
            }
        }

        if(seedIndex != -1) {
            val seedItem = inventory.getItem(seedIndex)
            if(seedItem != null) {
                val seedAmount = seedItem.amount
                seedItem.amount = seedAmount -1
            }
        }
    }

    private fun isSeedInInventory(player : Player, cropBlockType : Material) : Boolean {
        val inventory = player.inventory
        if(Blocks.crops.contains(cropBlockType)) {
            return inventory.contains(getSeedType(cropBlockType))
        }

        return false
    }

    private fun getSeedType(cropBlockType : Material) : Material  {
        when(cropBlockType) {
            Material.MELON -> {
                return Material.MELON_SEEDS
            }
            Material.CARROTS -> {
                return Material.CARROT
            }
            Material.POTATOES -> {
                return Material.POTATO
            }
            Material.BEETROOTS -> {
                return Material.BEETROOT
            }
            Material.WHEAT -> {
                return Material.WHEAT_SEEDS
            }
        }
        return Material.WHEAT_SEEDS
    }
}