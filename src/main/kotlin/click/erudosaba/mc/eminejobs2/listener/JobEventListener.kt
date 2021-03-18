package click.erudosaba.mc.eminejobs2.listener

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.PlayerLevelUpEvent
import click.erudosaba.mc.eminejobs2.rewards.RewardItem
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class JobEventListener(val plugin : Main) : Listener{

    @EventHandler
    fun onLevelUp(e: PlayerLevelUpEvent) {
        val lv = e.player.level
        val job = e.player.JobID
        val player = e.player.player

        when(job) {
            "woodcutter" -> {
                val item = RewardItem(plugin,"cutaxe")
                if(lv == 30)  player.inventory.addItem(item.getItem())
            }
            "miner" -> {
                val item = RewardItem(plugin,"minepickaxe")
                if(lv == 30)  player.inventory.addItem(item.getItem())
            }
            "digger" -> {
                val item = RewardItem(plugin,"digshovel")
                if(lv == 30)  player.inventory.addItem(item.getItem())
            }
            "swordman" -> {
                val item = RewardItem(plugin,"hinoki")
                if(lv == 10)  player.inventory.addItem(item.getItem())
            }
            "farmer" -> {
                val item = RewardItem(plugin,"farmboots")
                if(lv == 10)  player.inventory.addItem(item.getItem())
            }
            "explorer" -> {
                val item = RewardItem(plugin,"amulet")
                if(lv == 20)  player.inventory.addItem(item.getItem())
            }
            "smelter" -> {
                val item = RewardItem(plugin,"portablefurnace")
                if(lv == 20)  player.inventory.addItem(item.getItem())
            }
            "fisherman" -> {
                val item = RewardItem(plugin,"grapple")
                if(lv == 20)  player.inventory.addItem(item.getItem())
            }
            "crafter" -> {
                val item = RewardItem(plugin,"portableworkbench")
                if(lv == 20)  player.inventory.addItem(item.getItem())
            }
        }

        player.sendMessage("${ChatColor.GOLD} レベルアップｗｗｗｗｗ！！！")
    }
}