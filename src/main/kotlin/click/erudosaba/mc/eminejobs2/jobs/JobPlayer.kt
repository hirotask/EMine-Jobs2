package click.erudosaba.mc.eminejobs2.jobs

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.PlayerExpChangeEvent
import click.erudosaba.mc.eminejobs2.event.PlayerLevelUpEvent
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import kotlin.math.exp
//JobPlayerクラス：プレイヤーと職業情報を紐づけ
class JobPlayer(val player : Player, private val plugin : Main) {

    val UUID = player.uniqueId
    var JobID : Jobs
        get() {
            val jobStr = plugin.sqlUtil.getJob(player).toUpperCase()
            return Jobs.valueOf(jobStr)
        }
        set(value) {
            plugin.sqlUtil.setJob(player,value.name.toUpperCase())
        }
    var exp : Double
        get() {
            return plugin.sqlUtil.getExp(player)
        }
        set(value) {
            plugin.sqlUtil.setExp(player,value)
            val expFunc = 51.763 * exp(0.093 * (plugin.sqlUtil.getLevel(player)+1)-0.5)

            val e = PlayerExpChangeEvent(this)
            Bukkit.getServer().pluginManager.callEvent(e)

            if(exp > expFunc) {
                level += 1
                val event = PlayerLevelUpEvent(this)
                Bukkit.getServer().pluginManager.callEvent(event)
            }

        }
    var level : Int
        get() {
            return plugin.sqlUtil.getLevel(player)
        }
        set(value) {
            if(value > plugin.myConfig.maxLevel) {
                player.sendMessage("最大レベルに到達しています。")
            } else {
                plugin.sqlUtil.setLevel(player,value)
            }
        }
    var selectedSkill : Skill
        get() {
            return Skill.valueOf(plugin.sqlUtil.getSelectedSkill(player).toUpperCase())
        }
        set(value) {
            plugin.sqlUtil.setSelectedSkill(player, value.name.toUpperCase())
        }
    var skillStatus : SkillStatus
        get() {
            val values = SkillStatus.values()
            for(v in values){
                if(v.name == plugin.sqlUtil.getSkillStatus(player)) {
                    return v
                }
            }
            return SkillStatus.DISABLED
        }
        set(value) {
            plugin.sqlUtil.setSkillStatus(player,value.name)
        }
    fun hasSkill() : Boolean {
        return plugin.sqlUtil.SkillExists(player)
    }

    fun hasJob() : Boolean{
        return plugin.sqlUtil.isExists(player)
    }

    //もし就いている職がjobに等しかったらExpをjobExp分プラスする
    fun addExp(job : Jobs) {
        if(this.hasJob()) {
            if(this.JobID == job) {
                this.exp += job.jobExp
            }
        }
    }
}