package click.erudosaba.mc.eminejobs2.listener

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.PlayerExpChangeEvent
import click.erudosaba.mc.eminejobs2.event.PlayerJobJoinEvent
import click.erudosaba.mc.eminejobs2.event.PlayerLevelUpEvent
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.rewards.RewardItem
import click.erudosaba.mc.eminejobs2.util.SideBar
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
            Jobs.WOODCUTTER -> {
                val item = RewardItem(plugin,"cutaxe")
                if(lv == 30)  player.inventory.addItem(item.getItem())
            }
            Jobs.MINER -> {
                val item = RewardItem(plugin,"minepickaxe")
                if(lv == 30)  player.inventory.addItem(item.getItem())
            }
            Jobs.DIGGER -> {
                val item = RewardItem(plugin,"digshovel")
                if(lv == 30)  player.inventory.addItem(item.getItem())
            }
            Jobs.SWORDMAN -> {
                val item = RewardItem(plugin,"hinoki")
                if(lv == 10)  player.inventory.addItem(item.getItem())
            }
            Jobs.FARMER -> {
                val item = RewardItem(plugin,"farmboots")
                if(lv == 10)  player.inventory.addItem(item.getItem())
            }
            Jobs.EXPLORER -> {
                val item = RewardItem(plugin,"amulet")
                if(lv == 20)  player.inventory.addItem(item.getItem())
            }
            Jobs.SMELTER -> {
                val item = RewardItem(plugin,"portablefurnace")
                if(lv == 20)  player.inventory.addItem(item.getItem())
            }
            Jobs.FISHERMAN -> {
                val item = RewardItem(plugin,"grapple")
                if(lv == 20)  player.inventory.addItem(item.getItem())
            }
            Jobs.CRAFTER -> {
                val item = RewardItem(plugin,"portableworkbench")
                if(lv == 20)  player.inventory.addItem(item.getItem())
            }
        }

        SideBar(plugin,player)
        player.sendMessage("${ChatColor.GOLD} レベルアップｗｗｗｗｗ！！！")
    }

    @EventHandler
    fun onJobJoin(e: PlayerJobJoinEvent) {
        val jp = e.player
        SideBar(plugin,jp.player)
    }

    @EventHandler
    fun onExpChange(e: PlayerExpChangeEvent) {
        val jp = e.player
        SideBar(plugin,jp.player)
    }
}