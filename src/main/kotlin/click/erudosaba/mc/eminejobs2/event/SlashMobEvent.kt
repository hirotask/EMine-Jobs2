package click.erudosaba.mc.eminejobs2.event

import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class SlashMobEvent(val player : Player, val entity : Entity) : Event(){
    override fun getHandlers(): HandlerList {
        return HANDLERS
    }

    companion object {
        private val HANDLERS = HandlerList()

        @JvmStatic
        fun getHandlerList() : HandlerList {
            return HANDLERS
        }
    }
}