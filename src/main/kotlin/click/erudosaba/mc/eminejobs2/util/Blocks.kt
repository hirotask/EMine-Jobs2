package click.erudosaba.mc.eminejobs2.util

import org.bukkit.Material.*

object Blocks {
    enum class BlockCategory {
        BUILD,
        DECORATION,
        REDSTONE
    }

    val stones = arrayOf(
            STONE,
            DIORITE,
            ANDESITE,
            GRANITE,
            COBBLESTONE,
            MOSSY_COBBLESTONE
    )

    val woods = arrayOf(
            OAK_LOG,
            SPRUCE_LOG,
            BIRCH_LOG,
            JUNGLE_LOG,
            ACACIA_LOG,
            DARK_OAK_LOG
    )

    val dirts = arrayOf(
            DIRT,
            COARSE_DIRT,
            GRAVEL,
            SAND
    )

    val crops = arrayOf(
            MELON,
            CARROTS,
            POTATOES,
            CHORUS_FLOWER,
            BEETROOTS,
            SWEET_BERRY_BUSH,
            WHEAT
    )
}