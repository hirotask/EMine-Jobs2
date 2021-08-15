package click.erudosaba.mc.eminejobs2.jobs

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.PlayerExpChangeEvent
import click.erudosaba.mc.eminejobs2.event.PlayerLevelUpEvent
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillStatus
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.util.*
import kotlin.math.exp
//JobPlayerクラス：プレイヤーと職業情報を紐づけ
//職業に就いているプレイヤーはこれで登録する
class JobPlayer(val uuid : UUID, var jobID : Jobs, var exp : Double, var level : Int, var selectedSkill : Skill?, var skillStatus : SkillStatus) {

    val player = Bukkit.getPlayer(uuid)

    fun hasSkill() : Boolean {
        if(selectedSkill != null) {
            return selectedSkill?.name == "NULL"
        }
        return selectedSkill == null
    }

    fun hasJob() : Boolean{
        return jobID.name == "NULL"
    }

    //もし就いている職がjobに等しかったらExpをjobExp分プラスする
    fun addExp(job : Jobs) {
        if(this.hasJob()) {
            if(this.jobID == job) {
                this.exp += job.jobExp

                val e = PlayerExpChangeEvent(this)
                Bukkit.getServer().pluginManager.callEvent(e)
            }
        }
    }
}