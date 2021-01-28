package click.erudosaba.mc.eminejobs2.event

import org.bukkit.block.Block
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class WoodBreakEvent(val player : Player, val brokenBlock : Block) : Event() {
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