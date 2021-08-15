package click.erudosaba.mc.eminejobs2.listener.bukkit

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import click.erudosaba.mc.eminejobs2.util.SideBar
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class OnJoinLeave(val plugin: Main) : Listener {
    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        val player = e.player
        for (jp in Main.jPlayers) {
            if (jp.playerName == player.name) {
                if (jp.skillStatus != SkillStatus.DISABLED) {
                    jp.skillStatus = SkillStatus.DISABLED
                }

                if (jp.hasJob()) {
                    SideBar(plugin, player)
                }
            }
        }
    }
}