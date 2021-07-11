package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.EnchantEvent
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
import org.bukkit.event.enchantment.EnchantItemEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.EnchantmentStorageMeta
import kotlin.random.Random

class EnchanterSkills(plugin : Main) {


    init {
        plugin.server.pluginManager.registerEvents(TransEnchant(plugin),plugin)
    }

    class TransEnchant(val plg : Main) : SkillProvider(plg, Jobs.ENCHANTER), Listener {

        @EventHandler
        fun onInteract(e: PlayerInteractEvent) {
            if (e.action == Action.RIGHT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_AIR) {
                val jp = JobPlayer(plugin = plg, player = e.player)
                if (activateBlock(jp, plg.skillManager, Skill.TRANSENCHANT)) return

                val option = plg.skillManager.getSkillOption(Skill.TRANSENCHANT)
                val event = SkillUseEvent(jp, option)
                Bukkit.getServer().pluginManager.callEvent(event)
            }
        }

        @EventHandler
        fun onEnchant(e : EnchantItemEvent) {
            val player = e.enchanter
            val jp = JobPlayer(player,plg)

            if(block(jp,Skill.TRANSENCHANT)) return

            val book = ItemStack(Material.ENCHANTED_BOOK)
            val meta = book.itemMeta as EnchantmentStorageMeta

            val randomInt = Random.nextInt(e.enchantsToAdd.size)
            var count = 0

            for((enchant,level) in e.enchantsToAdd) {
                if(count == randomInt) {
                    meta.addStoredEnchant(enchant,level,true)
                }
                count++
            }

            book.itemMeta = meta
            player.inventory.addItem(book)
            player.sendMessage("エンチャントの本が一つ追加された")
        }
    }
}