package click.erudosaba.mc.eminejobs2.runnable

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.Effect
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import click.erudosaba.mc.eminejobs2.util.Blocks
import click.erudosaba.mc.eminejobs2.util.Items
import org.bukkit.CropState
import org.bukkit.material.Crops
import org.bukkit.potion.Potion
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scheduler.BukkitRunnable

class SkillRunnable(val plugin: Main, val jp: JobPlayer, var time: Int, var interval: Int) : BukkitRunnable() {

    override fun run() {
        when (jp.selectedSkill.effect) {
            //WoodHaste
            Effect.WoodHaste1, Effect.WoodHaste2, Effect.WoodHaste3 -> {
                if (Items.axes.contains(jp.player.inventory.itemInMainHand.type)) {
                    jp.player.addPotionEffect(PotionEffect(PotionEffectType.FAST_DIGGING, 20 * 2, 2, true))
                }
            }
            //StoneHaste
            Effect.StoneHaste1, Effect.StoneHaste2, Effect.StoneHaste3 -> {
                if (Items.pickaxes.contains(jp.player.inventory.itemInMainHand.type)) {
                    jp.player.addPotionEffect(PotionEffect(PotionEffectType.FAST_DIGGING, 20 * 2, 2, true))
                }
            }
            //DirtHaste
            Effect.DirtHaste1, Effect.DirtHaste2, Effect.DirtHaste3 -> {
                if (Items.shovels.contains(jp.player.inventory.itemInMainHand.type)) {
                    jp.player.addPotionEffect(PotionEffect(PotionEffectType.FAST_DIGGING, 20 * 2, 2, true))
                }
            }
            //Growing1
            Effect.Growing1, Effect.Growing2, Effect.Growing3 -> {
                var radius = 0
                val player = jp.player
                val blocks = mutableListOf<org.bukkit.block.Block>()

                val cropStage = listOf(
                        CropState.SEEDED,
                        CropState.GERMINATED,
                        CropState.VERY_SMALL,
                        CropState.SMALL,
                        CropState.MEDIUM,
                        CropState.MEDIUM,
                        CropState.TALL,
                        CropState.VERY_TALL,
                        CropState.RIPE
                )

                when (jp.selectedSkill.effect) {
                    Effect.Growing1 -> radius = 3
                    Effect.Growing2 -> radius = 5
                    Effect.Growing3 -> radius = 8
                }

                //Get nearly Blocks
                for (x in (player.location.blockX - radius)..(player.location.blockX + radius)) {
                    for (y in (player.location.blockY - radius)..(player.location.blockY + radius)) {
                        for (z in (player.location.blockZ - radius)..(player.location.blockZ + radius)) {
                            blocks.add(player.location.world!!.getBlockAt(x, y, z))
                        }
                    }
                }

                //set Growth
                for (b in blocks) {
                    if (Blocks.crops.contains(b.type)) {
                        val crop = Crops(b.type)

                        for (stage in cropStage) {
                            if (crop.state == CropState.RIPE) {
                                break
                            }

                            if (crop.state == stage) {
                                crop.state = cropStage[cropStage.indexOf(stage) + 1]
                            }
                        }
                    }
                }
            }
        }


        //停止処理
        if (time <= 0) {
            jp.skillStatus = SkillStatus.INTERVAL
            IntervalRunnable(jp, interval).runTaskTimer(plugin, 0, 20)
            this.cancel()
        }
        time--
    }
}