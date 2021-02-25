package click.erudosaba.mc.eminejobs2.jobs

import click.erudosaba.mc.eminejobs2.Main
import org.bukkit.entity.Player
import kotlin.math.exp

class JobPlayer(val player : Player, val plugin : Main) {

    val UUID = player.uniqueId
    var jobName : String
        get() {
            return plugin.sqlUtil.getJob(player)
        }
        set(value) {
            jobName = value
            plugin.sqlUtil.setJob(player,jobName)
        }
    var exp : Double
        get() {
            return plugin.sqlUtil.getExp(player)
        }
        set(value) {
            exp = value
            plugin.sqlUtil.setExp(player,exp)
            val expFunc = 51.763 * exp(0.093 * (plugin.sqlUtil.getLevel(player) + 1))

            if(exp > expFunc) {
                level += 1
            }
        }
    var level : Int
        get() {

            return plugin.sqlUtil.getLevel(player)
        }
        set(value) {
            level = value
            plugin.sqlUtil.setLevel(player,level)
        }


    fun hasJob() : Boolean{
        return plugin.sqlUtil.isExists(player)
    }
}