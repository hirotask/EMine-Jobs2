package click.erudosaba.mc.eminejobs2.runnable

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.Effect
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import click.erudosaba.mc.eminejobs2.util.Blocks
import click.erudosaba.mc.eminejobs2.util.Items
import org.bukkit.potion.Potion
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scheduler.BukkitRunnable

class SkillRunnable(val plugin : Main, val jp : JobPlayer, var time : Int, var interval : Int) : BukkitRunnable(){

    override fun run() {
        when(jp.selectedSkill.effect) {
            //WoodHaste
            Effect.WoodHaste1,Effect.WoodHaste2,Effect.WoodHaste3 -> {
                if(Items.axes.contains(jp.player.inventory.itemInMainHand.type)) {
                    jp.player.addPotionEffect(PotionEffect(PotionEffectType.FAST_DIGGING,20 * 2,2, true))
                }
            }
            //StoneHaste
            Effect.StoneHaste1,Effect.StoneHaste2,Effect.StoneHaste3 -> {
                if(Items.pickaxes.contains(jp.player.inventory.itemInMainHand.type)) {
                    jp.player.addPotionEffect(PotionEffect(PotionEffectType.FAST_DIGGING,20 * 2,2, true))
                }
            }
            //DirtHaste
            Effect.DirtHaste1,Effect.DirtHaste2,Effect.DirtHaste3 -> {
                if(Items.shovels.contains(jp.player.inventory.itemInMainHand.type)) {
                    jp.player.addPotionEffect(PotionEffect(PotionEffectType.FAST_DIGGING,20 * 2,2, true))
                }
            }
        }



        //停止処理
        if(time <= 0) {
            jp.skillStatus = SkillStatus.INTERVAL
            IntervalRunnable(jp,interval).runTaskTimer(plugin,0,20)
            this.cancel()
        }
        time--
    }
}