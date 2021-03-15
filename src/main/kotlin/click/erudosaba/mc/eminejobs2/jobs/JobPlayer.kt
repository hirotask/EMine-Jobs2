package click.erudosaba.mc.eminejobs2.jobs

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.PlayerExpChangeEvent
import click.erudosaba.mc.eminejobs2.event.PlayerLevelUpEvent
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import kotlin.math.exp

class JobPlayer(val player : Player, val plugin : Main) {

    val UUID = player.uniqueId
    var jobName : String
        get() {
            return plugin.sqlUtil.getJob(player)
        }
        set(value) {
            plugin.sqlUtil.setJob(player,value)
        }
    var exp : Double
        get() {
            return plugin.sqlUtil.getExp(player)
        }
        set(value) {
            plugin.sqlUtil.setExp(player,value)
            val e = PlayerExpChangeEvent(player)
            Bukkit.getServer().pluginManager.callEvent(e)

            val expFunc = 51.763 * exp(0.093 * plugin.sqlUtil.getLevel(player)-0.5)

            if(exp > expFunc) {
                level += 1
                val event = PlayerLevelUpEvent(player)
                Bukkit.getServer().pluginManager.callEvent(event)
            }
        }
    var level : Int
        get() {
            return plugin.sqlUtil.getLevel(player)
        }
        set(value) {
            plugin.sqlUtil.setLevel(player,value)
        }


    fun hasJob() : Boolean{
        return plugin.sqlUtil.isExists(player)
    }
}