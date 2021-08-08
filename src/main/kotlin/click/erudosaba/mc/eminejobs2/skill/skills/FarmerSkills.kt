package click.erudosaba.mc.eminejobs2.skill.skills

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillProvider
import click.erudosaba.mc.eminejobs2.util.Blocks
import org.bukkit.Location
import org.bukkit.block.Block
import org.bukkit.block.data.Ageable
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import kotlin.math.max
import kotlin.math.min

class FarmerSkills(val plugin : Main) : Listener, SkillProvider() {

    @EventHandler
    fun onMove(e : PlayerMoveEvent) {
        val player = e.player
        val jp = JobPlayer(player,plugin)



        if (block(jp)) return

        when(jp.selectedSkill) {
            Skill.GROWING1 -> {
                autoGrowing(player,3)
            }
            Skill.GROWING2 -> {
                autoGrowing(player,5)
            }
            Skill.GROWING3 -> {
                autoGrowing(player,8)
            }
        }
    }

    //Location locを中心とした，半径radiusの範囲の作物ブロックを取得
    private fun sphereAround(loc : Location, radius : Int) : Set<Block> {
        val sphere = HashSet<Block>()
        val center = loc.block
        for(x in -radius..radius) {
            for(y in -radius..radius) {
                for(z in -radius..radius) {
                    val b = center.getRelative(x,y,z)

                    if(center.location.distance((b.location)) <= radius) {
                        if(Blocks.crops.contains(b.type)) {
                            sphere.add(b)
                        }
                    }
                }
            }
        }

        return sphere
    }

    private fun getCropAge(block : Block) : Int {
        val data = block.blockData

        if (Blocks.crops.contains(block.type)) {
            if (data is Ageable) {
                return data.age
            }
        }

        return -1;
    }

    private fun setCropAge(block : Block, age : Int) {
        val data = block.blockData

        if(Blocks.crops.contains(block.type)) {
            if(data is Ageable) {
                data.age = min(age,data.maximumAge)
            }
        }
    }

    private fun autoGrowing(player : Player, radius : Int) {
        val crops = sphereAround(player.location, radius)

        for(crop in crops) {
            if(getCropAge(crop) > -1) {
                setCropAge(crop,getCropAge(crop) + 1)
            }
        }
    }


}