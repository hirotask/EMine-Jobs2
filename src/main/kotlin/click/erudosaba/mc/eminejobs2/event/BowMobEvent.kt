package click.erudosaba.mc.eminejobs2.event

import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.event.Cancellable
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class BowMobEvent(val player : Player, val entity : Entity) : Event(), Cancellable {
    var cancel : Boolean = false


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