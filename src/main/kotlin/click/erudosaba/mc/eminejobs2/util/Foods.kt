package click.erudosaba.mc.eminejobs2.util


enum class Foods(value: Int, saturation: Int) {
    APPLE(4, 2), BREAD(5, 6), PORKCHOP(1, 2), COOKED_PORKCHOP(8, 12), GOLDEN_APPLE(4, 9), ENCHANTED_GOLDEN_APPLE(4, 9), COD(2, 1), COOKED_COD(5, 6), SALMON(2, 1), COOKED_SALMON(5, 9), TROPICAL_FISH(1, 1), COOKIE(2, 0), MELON_SLICE(2, 1), DRIED_KELP(1, 0), BEEF(3, 2), COOKED_BEEF(8, 12), CHICKEN(2, 1), COOKED_CHICKEN(6, 7), CARROT(3, 3), GOLDEN_CARROT(6, 14), POTATO(1, 0), BAKED_POTATO(5, 6), PUMPKIN_PIE(8, 5), RABBIT(3, 2), COOKED_RABBIT(5, 6), RABBIT_STEW(10, 12), MUTTON(2, 1), COOKED_MUTTON(6, 9), BEETROOT(1, 2), BEETROOT_SOUP(6, 7), SWEET_BERRIES(2, 1), HONEY_BOTTLE(6, 1), MUSHROOM_STEW(6, 7), MILK_BUCKET(0, 0), CHORUS_FRUIT(4, 2), PUFFERFISH(1, 0), ROTTEN_FLESH(4, 1), SPIDER_EYE(2, 3), POISONOUS_POTATO(2, 1);

    val value: Array<Int> = arrayOf(value, saturation)

    fun returnByName(name: String?): Foods {
        return valueOf(name!!)
    }

}