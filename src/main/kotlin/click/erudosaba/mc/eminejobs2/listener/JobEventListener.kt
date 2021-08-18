package click.erudosaba.mc.eminejobs2.listener

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.PlayerExpChangeEvent
import click.erudosaba.mc.eminejobs2.event.PlayerJobJoinEvent
import click.erudosaba.mc.eminejobs2.event.PlayerLevelUpEvent
import click.erudosaba.mc.eminejobs2.event.PlayerSkillUseEvent
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.reward.RewardItem
import click.erudosaba.mc.eminejobs2.reward.RewardManager
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import click.erudosaba.mc.eminejobs2.util.SideBar
import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.scheduler.BukkitRunnable

class JobEventListener(val plugin : Main) : Listener{

    @EventHandler
    fun onLevelUp(e: PlayerLevelUpEvent) {
        val lv = e.player.level
        val job = e.player.jobID
        val player = Bukkit.getPlayer(e.player.playerName)
        val rewardManager = RewardManager(plugin)


        when(job) {
            Jobs.WOODCUTTER -> {
                val item = RewardItem.CUTAXE
                if(lv == item.needLevel)  player?.inventory?.addItem(rewardManager.getItem(RewardItem.CUTAXE))
            }
            Jobs.MINER -> {
                val item = RewardItem.MINEPICKAXE
                if(lv == item.needLevel)  player?.inventory?.addItem(rewardManager.getItem(RewardItem.MINEPICKAXE))
            }
            Jobs.DIGGER -> {
                val item = RewardItem.DIGSHOVEL
                if(lv == item.needLevel)  player?.inventory?.addItem(rewardManager.getItem(RewardItem.DIGSHOVEL))
            }
            Jobs.SWORDMAN -> {
                val item = RewardItem.HINOKI
                if(lv == item.needLevel)  player?.inventory?.addItem(rewardManager.getItem(RewardItem.HINOKI))
            }
            Jobs.FARMER -> {
                val item = RewardItem.FARMBOOTS
                if(lv == item.needLevel)  player?.inventory?.addItem(rewardManager.getItem(RewardItem.FARMBOOTS))
            }
            Jobs.SMELTER -> {
                val item = RewardItem.PORTABLEFURNACE
                if(lv == item.needLevel)  player?.inventory?.addItem(rewardManager.getItem(RewardItem.PORTABLEFURNACE))
            }
            Jobs.FISHERMAN -> {
                val item = RewardItem.GRAPPLE
                if(lv == item.needLevel)  player?.inventory?.addItem(rewardManager.getItem(RewardItem.GRAPPLE))
            }
            Jobs.CRAFTER -> {
                val item = RewardItem.PORTABLEWORKBENCH
                if(lv == item.needLevel)  player?.inventory?.addItem(rewardManager.getItem(RewardItem.PORTABLEWORKBENCH))
            }
        }

        SideBar(plugin,player)
        player?.sendMessage("${ChatColor.GOLD} レベルアップｗｗｗｗｗ！！！")
    }

    @EventHandler
    fun onJobJoin(e: PlayerJobJoinEvent) {
        val jp = e.player
        val player = Bukkit.getPlayer(e.player.playerName)
        SideBar(plugin,player)
    }

    @EventHandler
    fun onExpChange(e: PlayerExpChangeEvent) {
        val jp = e.player
        val player = Bukkit.getPlayer(e.player.playerName)
        val expFunc = 51.763 * kotlin.math.exp(0.093 * (jp.level + 1) - 0.5)

        if(jp.exp > expFunc) {
            jp.level += 1
            val event = PlayerLevelUpEvent(jp)
            Bukkit.getServer().pluginManager.callEvent(event)
        }

        SideBar(plugin,player)
    }

    @EventHandler
    fun onSkillUse(e : PlayerSkillUseEvent) {
        val option = e.skillOption
        val jp = e.player
        val player = Bukkit.getPlayer(e.player.playerName)
        jp.skillStatus = SkillStatus.ENABLED
        player?.playSound(player.location, Sound.UI_BUTTON_CLICK, 0.5F, 1.3F)

        var activeTime = option.activeTime
        var interval = option.interval
        //Interval処理
        object : BukkitRunnable() {
            override fun run() {
                if(jp.skillStatus == SkillStatus.ENABLED) {
                    if(activeTime <= 0) {
                        jp.skillStatus = SkillStatus.INTERVAL
                    }
                    player?.spigot()?.sendMessage(ChatMessageType.ACTION_BAR,TextComponent("有効時間：${ChatColor.YELLOW}$activeTime"))
                    activeTime--
                } else if(jp.skillStatus == SkillStatus.INTERVAL) {
                    if(interval <= 0) {
                        jp.skillStatus = SkillStatus.DISABLED
                        player?.playSound(player.location, Sound.ENTITY_PLAYER_LEVELUP, 0.5F, 1.3F)
                        cancel()
                    }
                    player?.spigot()?.sendMessage(ChatMessageType.ACTION_BAR,TextComponent("インターバル：${ChatColor.YELLOW}$interval"))
                    interval--
                } else {
                    cancel()
                }
            }

        }.runTaskTimer(plugin,0L,20L)
    }
}