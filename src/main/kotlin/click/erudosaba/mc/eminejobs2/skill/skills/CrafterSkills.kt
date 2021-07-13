package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.CraftEvent
import click.erudosaba.mc.eminejobs2.event.SkillUseEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
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

        }

    }

}