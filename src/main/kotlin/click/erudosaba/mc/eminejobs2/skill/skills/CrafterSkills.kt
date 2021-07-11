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

class CrafterSkills(plugin : Main) {

    init {
        plugin.server.pluginManager.registerEvents(RandomEffect1(plugin),plugin)
        plugin.server.pluginManager.registerEvents(RandomEffect2(plugin),plugin)
        plugin.server.pluginManager.registerEvents(RandomEffect3(plugin),plugin)
        plugin.server.pluginManager.registerEvents(RandomUpgrade(plugin),plugin)
    }

    class RandomEffect1(val plg : Main) : SkillProvider(plg, Jobs.CRAFTER), Listener {
        @EventHandler
        fun onInteract(e: PlayerInteractEvent) {
            if (e.action == Action.RIGHT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_AIR) {
                val jp = JobPlayer(plugin = plg, player = e.player)
                if (activateBlock(jp, plg.skillManager, Skill.RANDOMEFFECT1)) return

                val option = plg.skillManager.getSkillOption(Skill.RANDOMEFFECT1)
                val event = SkillUseEvent(jp, option)
                Bukkit.getServer().pluginManager.callEvent(event)
            }
        }

        @EventHandler
        fun onCraft(e : CraftEvent) {
            val jp = e.player
            val player = jp.player

            if(block(jp,Skill.RANDOMEFFECT1)) return

            val randomInt = Random.nextInt(PotionEffectType.values().size)

            for((v,i) in PotionEffectType.values().withIndex()) {
                if(v == randomInt) {
                    player.addPotionEffect(PotionEffect(i,10 * 20, 0),true)
                }
            }
        }
    }

    class RandomEffect2(val plg : Main) : SkillProvider(plg, Jobs.CRAFTER), Listener {
        @EventHandler
        fun onInteract(e: PlayerInteractEvent) {
            if (e.action == Action.RIGHT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_AIR) {
                val jp = JobPlayer(plugin = plg, player = e.player)
                if (activateBlock(jp, plg.skillManager, Skill.RANDOMEFFECT2)) return

                val option = plg.skillManager.getSkillOption(Skill.RANDOMEFFECT2)
                val event = SkillUseEvent(jp, option)
                Bukkit.getServer().pluginManager.callEvent(event)
            }
        }

        @EventHandler
        fun onCraft(e : CraftEvent) {
            val jp = e.player
            val player = jp.player

            if(block(jp,Skill.RANDOMEFFECT2)) return

            val randomInt = Random.nextInt(PotionEffectType.values().size)

            for((v,i) in PotionEffectType.values().withIndex()) {
                if(v == randomInt) {
                    player.addPotionEffect(PotionEffect(i,10 * 20, 1),true)
                }
            }
        }
    }

    class RandomEffect3(val plg : Main) : SkillProvider(plg, Jobs.CRAFTER), Listener {
        @EventHandler
        fun onInteract(e: PlayerInteractEvent) {
            if (e.action == Action.RIGHT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_AIR) {
                val jp = JobPlayer(plugin = plg, player = e.player)
                if (activateBlock(jp, plg.skillManager, Skill.RANDOMEFFECT3)) return

                val option = plg.skillManager.getSkillOption(Skill.RANDOMEFFECT3)
                val event = SkillUseEvent(jp, option)
                Bukkit.getServer().pluginManager.callEvent(event)
            }
        }

        @EventHandler
        fun onCraft(e : CraftEvent) {
            val jp = e.player
            val player = jp.player

            if(block(jp,Skill.RANDOMEFFECT3)) return

            val randomInt = Random.nextInt(PotionEffectType.values().size)

            for((v,i) in PotionEffectType.values().withIndex()) {
                if(v == randomInt) {
                    player.addPotionEffect(PotionEffect(i,10 * 20, 2),true)
                }
            }
        }
    }

    class RandomUpgrade(plg : Main) : SkillProvider(plg, Jobs.CRAFTER), Listener {
        //TODO: 処理を書く
    }
}