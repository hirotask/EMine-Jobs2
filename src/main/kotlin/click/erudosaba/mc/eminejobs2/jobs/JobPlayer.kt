package click.erudosaba.mc.eminejobs2.jobs

import click.erudosaba.mc.eminejobs2.Main
import org.bukkit.entity.Player

class JobPlayer(val player : Player) {

    val UUID = player.uniqueId
    var jobName : String
        get() {
            return Main.sqlUtil.getJob(player)
        }
        set(value) {
            Main.sqlUtil.setJob(player,value)
        }
    var exp : Int
        get() {
            return Main.sqlUtil.getExp(player)
        }
        set(value) {
            Main.sqlUtil.setExp(player,value)
        }
    var level : Int
        get() {
            return Main.sqlUtil.getLevel(player)
        }
        set(value) {
            Main.sqlUtil.getLevel(player)
        }


    fun hasJob() : Boolean{
        return Main.sqlUtil.isExists(player)
    }
}