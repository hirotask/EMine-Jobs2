package click.erudosaba.mc.eminejobs2.jobs

import org.bukkit.Material

//列挙型Jobs：職業のデフォルト設定を記載
enum class Jobs(val Jobname : String, val jobCategory: JobCategory, val jobExp : Double, val icon : Material) {
    WOODCUTTER("木こり",JobCategory.CUT,0.30, Material.STONE_AXE),
    MINER("鉱夫",JobCategory.MINE,0.30, Material.STONE_PICKAXE),
    DIGGER("掘削屋",JobCategory.DIG,0.30, Material.STONE_SHOVEL),
    SWORDMAN("剣士",JobCategory.SLASH,0.30, Material.STONE_SWORD),
    ARCHER("アーチャー",JobCategory.SHOOT,0.30, Material.BOW),
    FARMER("農家",JobCategory.FARM,0.98, Material.STONE_HOE),
    EXPLORER("探検家",JobCategory.EXPLORE,0.98, Material.LEATHER_BOOTS),
    SMELTER("精練家",JobCategory.SMELT,0.98, Material.FURNACE),
    FISHERMAN("釣り師",JobCategory.FISH,0.98, Material.FISHING_ROD),
    CRAFTER("クラフター",JobCategory.CRAFT,0.98, Material.CRAFTING_TABLE),
    ENCHANTER("エンチャンター",JobCategory.ENCHANT,1.2, Material.ENCHANTING_TABLE),
    WEAPONSMITH("鍛冶屋",JobCategory.FORGE,1.2, Material.ANVIL),
    BREWER("醸造家",JobCategory.BREW,1.2, Material.BREWING_STAND),
    BUILDER("建築家",JobCategory.BUILD,0.98, Material.BRICKS),
    GUNNER("ガンナー",JobCategory.GUN,0.98, Material.GOLDEN_HORSE_ARMOR),
    HUNGER("暴飲暴食",JobCategory.EAT,0.98, Material.BREAD)

}