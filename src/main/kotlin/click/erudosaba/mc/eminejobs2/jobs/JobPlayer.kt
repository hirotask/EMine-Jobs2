package click.erudosaba.mc.eminejobs2.jobs

import click.erudosaba.mc.eminejobs2.Main
import org.bukkit.entity.Player
import kotlin.math.exp

class JobPlayer(val player : Player) {

    val UUID = player.uniqueId
    var jobName : String
        get() {
            return Main.sqlUtil.getJob(player)
        }
        set(value) {
            jobName = value
            Main.sqlUtil.setJob(player,jobName)
        }
    var exp : Double
        get() {
            return Main.sqlUtil.getExp(player)
        }
        set(value) {
            exp = value
            Main.sqlUtil.setExp(player,exp)
            val expFunc = 51.763 * exp(0.093 * (Main.sqlUtil.getLevel(player) + 1))

            if(exp > expFunc) {
                level += 1
            }
        }
    var level : Int
        get() {

            return Main.sqlUtil.getLevel(player)
        }
        set(value) {
            level = value
            Main.sqlUtil.setLevel(player,level)
        }


    fun hasJob() : Boolean{
        return Main.sqlUtil.isExists(player)
    }
}