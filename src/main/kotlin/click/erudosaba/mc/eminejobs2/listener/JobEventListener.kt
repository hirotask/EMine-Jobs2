package click.erudosaba.mc.eminejobs2.listener

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.PlayerExpChangeEvent
import click.erudosaba.mc.eminejobs2.event.PlayerJobJoinEvent
import click.erudosaba.mc.eminejobs2.event.PlayerLevelUpEvent
import click.erudosaba.mc.eminejobs2.event.SkillUseEvent
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.rewards.RewardItem
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import click.erudosaba.mc.eminejobs2.util.SideBar
import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.scheduler.BukkitRunnable

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

    @EventHandler
    fun onSkillUse(e : SkillUseEvent) {
        val option = e.skillOption
        val jp = e.player
        jp.skillStatus = SkillStatus.ENABLED
        jp.player.playSound(jp.player.location, Sound.UI_BUTTON_CLICK, 0.5F, 1.3F)

        var activeTime = option.activeTime
        var interval = option.interval
        //Interval処理
        object : BukkitRunnable() {
            override fun run() {
                if(jp.skillStatus == SkillStatus.ENABLED) {
                    if(activeTime <= 0) {
                        jp.skillStatus = SkillStatus.INTERVAL
                    }
                    activeTime--
                }
                if(jp.skillStatus == SkillStatus.INTERVAL) {
                    if(interval <= 0) {
                        jp.skillStatus = SkillStatus.DISABLED
                        cancel()
                    }
                    interval--
                }
            }

        }.runTaskTimer(plugin,0L,20L)
    }
}