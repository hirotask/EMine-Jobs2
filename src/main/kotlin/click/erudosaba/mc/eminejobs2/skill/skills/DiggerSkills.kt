package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.SkillUseEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import click.erudosaba.mc.eminejobs2.util.Blocks
import click.erudosaba.mc.eminejobs2.util.Items
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.potion.Potion
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class DiggerSkills(plugin : Main) {

    init {
        plugin.server.pluginManager.registerEvents(DigHaste1(plugin),plugin)
        plugin.server.pluginManager.registerEvents(DigHaste2(plugin),plugin)
        plugin.server.pluginManager.registerEvents(DigHaste3(plugin),plugin)
        plugin.server.pluginManager.registerEvents(DigAll(plugin),plugin)
    }

    class DigHaste1(val plg : Main) : SkillProvider(plg, Jobs.DIGGER), Listener {
        @EventHandler
        fun onInteract(e : PlayerInteractEvent) {
            if(e.action == Action.RIGHT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_AIR) {
                val jp = JobPlayer(plugin=plg,player=e.player)
                if(activateBlock(jp,plg.skillManager)) return

                val option = plg.skillManager.getSkillOption(Skill.DIGHASTE1)
                val event = SkillUseEvent(jp, option)
                Bukkit.getServer().pluginManager.callEvent(event)
            }
        }

        @EventHandler
        fun onMove(e : PlayerMoveEvent) {
            val player = e.player
            val jp = JobPlayer(player,plg)

            if(jp.skillStatus == SkillStatus.ENABLED) {
                if(Items.shovels.contains(player.inventory.itemInMainHand.type)) {
                    val targetBlock = player.getTargetBlock(null,5).type
                    if(Blocks.dirts.contains(targetBlock)) {
                        player.addPotionEffect(PotionEffect(PotionEffectType.FAST_DIGGING,20 * 2, 2,true))
                    }
                }
            }
        }
    }

    class DigHaste2(val plg : Main) : SkillProvider(plg, Jobs.DIGGER), Listener {
        @EventHandler
        fun onInteract(e : PlayerInteractEvent) {
            if(e.action == Action.RIGHT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_AIR) {
                val jp = JobPlayer(plugin=plg,player=e.player)
                if(activateBlock(jp,plg.skillManager)) return

                val option = plg.skillManager.getSkillOption(Skill.DIGHASTE2)
                val event = SkillUseEvent(jp, option)
                Bukkit.getServer().pluginManager.callEvent(event)
            }
        }

        @EventHandler
        fun onMove(e : PlayerMoveEvent) {
            val player = e.player
            val jp = JobPlayer(player,plg)

            if(jp.skillStatus == SkillStatus.ENABLED) {
                if(Items.shovels.contains(player.inventory.itemInMainHand.type)) {
                    val targetBlock = player.getTargetBlock(null,5).type
                    if(Blocks.dirts.contains(targetBlock)) {
                        player.addPotionEffect(PotionEffect(PotionEffectType.FAST_DIGGING,20 * 2, 2,true))
                    }
                }
            }
        }
    }

    class DigHaste3(val plg : Main) : SkillProvider(plg, Jobs.DIGGER), Listener {
        @EventHandler
        fun onInteract(e : PlayerInteractEvent) {
            if(e.action == Action.RIGHT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_AIR) {
                val jp = JobPlayer(plugin=plg,player=e.player)
                if(activateBlock(jp,plg.skillManager)) return

                val option = plg.skillManager.getSkillOption(Skill.DIGHASTE3)
                val event = SkillUseEvent(jp, option)
                Bukkit.getServer().pluginManager.callEvent(event)
            }
        }

        @EventHandler
        fun onMove(e : PlayerMoveEvent) {
            val player = e.player
            val jp = JobPlayer(player,plg)

            if(jp.skillStatus == SkillStatus.ENABLED) {
                if(Items.shovels.contains(player.inventory.itemInMainHand.type)) {
                    val targetBlock = player.getTargetBlock(null,5).type
                    if(Blocks.dirts.contains(targetBlock)) {
                        player.addPotionEffect(PotionEffect(PotionEffectType.FAST_DIGGING,20 * 2, 2,true))
                    }
                }
            }
        }

    }

    class DigAll(val plg : Main) : SkillProvider(plg, Jobs.DIGGER), Listener {
        @EventHandler
        fun onInteract(e : PlayerInteractEvent) {
            if(e.action == Action.RIGHT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_AIR) {
                val jp = JobPlayer(plugin=plg,player=e.player)
                if(activateBlock(jp,plg.skillManager)) return

                val option = plg.skillManager.getSkillOption(Skill.DIGALL)
                val event = SkillUseEvent(jp, option)
                Bukkit.getServer().pluginManager.callEvent(event)
            }
        }
    }
}