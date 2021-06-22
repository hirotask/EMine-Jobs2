package click.erudosaba.mc.eminejobs2.event

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.skill.Skill
import click.erudosaba.mc.eminejobs2.skill.SkillManager
import click.erudosaba.mc.eminejobs2.skill.SkillOption
import org.bukkit.Material
import org.bukkit.event.Cancellable
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class SkillUseEvent(val player : JobPlayer,val skillOption: SkillOption): Event(), Cancellable {

    var cancel = false

    override fun getHandlers(): HandlerList {
        return HANDLERS
    }

    override fun isCancelled(): Boolean {
        return cancel
    }

    override fun setCancelled(p0: Boolean) {
        cancel = p0
    }

    companion object {
        private val HANDLERS = HandlerList()

        @JvmStatic
        fun getHandlerList() : HandlerList {
            return HANDLERS
        }
    }
}