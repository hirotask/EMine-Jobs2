package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.CraftEvent
import click.erudosaba.mc.eminejobs2.event.SkillUseEvent
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
import org.bukkit.potion.Potion
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import kotlin.random.Random

class CrafterSkills(val plugin : Main) : Listener, SkillProvider() {

    @EventHandler
    fun onCraft(e : CraftEvent) {
        val jp = e.player
        val player = jp.player

        if(block(jp)) return

        val randomInt = Random.nextInt(PotionEffectType.values().size)
        val randomInt2 = Random.nextInt(100) //0~99

        if(jp.selectedSkill == Skill.RANDOMEFFECT1) { //ここからRANDOMEFFECT1
            for((v,i) in PotionEffectType.values().withIndex()) {
                if(v == randomInt) {
                    player.addPotionEffect(PotionEffect(i,10 * 20, 0),true)
                }
            }
        } else if(jp.selectedSkill == Skill.RANDOMEFFECT2) { //ここからRANDOMEFFECT2
            for((v,i) in PotionEffectType.values().withIndex()) {
                if(v == randomInt) {
                    player.addPotionEffect(PotionEffect(i,10 * 20, 1),true)
                }
            }
        } else if(jp.selectedSkill == Skill.RANDOMEFFECT3) { //ここからRANDOMEFFECT3
            for((v,i) in PotionEffectType.values().withIndex()) {
                if(v == randomInt) {
                    player.addPotionEffect(PotionEffect(i,10 * 20, 2),true)
                }
            }
        } else if(jp.selectedSkill == Skill.RANDOMUPGRADE) { //ここからRANDOMUPGRADE
            val item = e.item

            if(randomInt2 > 2) {
                return
            }

            //randomInt2が0,1のときのみ実行される
            if(Items.swords.contains(item.type)) { //アイテムが剣だったら
                for((index,value) in Items.swords.withIndex()) {
                    if(value == item.type && index + 1 <=  Items.swords.size) {
                        e.cancel = true
                        player.inventory.addItem(ItemStack(Items.swords[index+1]))
                    }
                }
            }

            if(Items.axes.contains(item.type)) { //アイテムが斧だったら
                for((index,value) in Items.axes.withIndex()) {
                    if(value == item.type && index + 1 <=  Items.axes.size) {
                        e.cancel = true
                        player.inventory.addItem(ItemStack(Items.axes[index+1]))
                    }
                }
            }

            if(Items.shovels.contains(item.type)) { //アイテムがショベルだったら
                for((index,value) in Items.shovels.withIndex()) {
                    if(value == item.type && index + 1 <=  Items.shovels.size) {
                        e.cancel = true
                        player.inventory.addItem(ItemStack(Items.shovels[index+1]))
                    }
                }
            }

            if(Items.pickaxes.contains(item.type)) { //アイテムがピッケルだったら
                for((index,value) in Items.pickaxes.withIndex()) {
                    if(value == item.type && index + 1 <=  Items.pickaxes.size) {
                        e.cancel = true
                        player.inventory.addItem(ItemStack(Items.pickaxes[index+1]))
                    }
                }
            }
        }

    }

}