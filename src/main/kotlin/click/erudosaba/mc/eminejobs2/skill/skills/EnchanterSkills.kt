package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.enchantment.EnchantItemEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.EnchantmentStorageMeta
import kotlin.random.Random

class EnchanterSkills(val plugin : Main) : Listener, SkillProvider() {

    @EventHandler
    fun onEnchant(e : EnchantItemEvent) {
        val player = e.enchanter
        val jp = JobPlayer(player,plugin)

        if(block(jp)) return

        if(jp.selectedSkill != Skill.TRANSENCHANT) return

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