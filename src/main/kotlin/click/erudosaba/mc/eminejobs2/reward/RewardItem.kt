package click.erudosaba.mc.eminejobs2.reward

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment

enum class RewardItem(
        val Itemname : String,
        val needLevel : Int,
        val material : Material,
        val unbreakable : Boolean,
        val lore : Array<String>,
        val enchants : Map<Enchantment,Int>) {

    AMULET("おまもり",20,Material.GHAST_TEAR,true, arrayOf("レベル20で貰える。","死んだときにアイテムがチェストに入ってその場に残る"), mapOf(Enchantment.DURABILITY to 1)),
    CUTAXE("無尽斧",30,Material.GOLDEN_AXE,true, arrayOf("レベル30で貰える","壊れない＆ちょっとだけ早い金の斧"), mapOf(Enchantment.DURABILITY to 1)),
    DIGSHOVEL("無尽円匙",30,Material.GOLDEN_SHOVEL,true, arrayOf("レベル30で貰える","壊れない＆ちょっとだけ早い金のシャベル"), mapOf(Enchantment.DURABILITY to 1)),
    FARMBOOTS("農業用長靴",15,Material.LEATHER_BOOTS,true, arrayOf("レベル15で貰える。","壊れない＆農耕地でジャンプしてももとに戻らなくなる"), mapOf(Enchantment.PROTECTION_ENVIRONMENTAL to 1)),
    GRAPPLE("立体機動装置",30,Material.FISHING_ROD,true, arrayOf("レベル30で貰える。","右クリックで使用。","ひっかけた場所に引っ張られる。"), mapOf(Enchantment.MENDING to 1)),
    HINOKI("ひのき棒",10,Material.STICK,true, arrayOf("レベル10で貰える。","これで世界の秩序を取り戻せ！"), mapOf(Enchantment.DURABILITY to 1,Enchantment.KNOCKBACK to 10)),
    MINEPICKAXE("無尽槌",30,Material.GOLDEN_PICKAXE,true, arrayOf("レベル30で貰える。","壊れない＆ちょっとだけ早い金のピッケル"), mapOf(Enchantment.DURABILITY to 1)),
    PORTABLEFURNACE("携帯型かまど",20,Material.IRON_HORSE_ARMOR,false, arrayOf("レベル20で貰える","右クリックで使用。","携帯できるかまど。"), mapOf(Enchantment.DURABILITY to 1)),
    PORTABLEWORKBENCH("携帯型作業台",20,Material.BRICK,false, arrayOf("レベル20で貰える。","右クリックで使用。","携帯できる作業台。"), mapOf(Enchantment.DURABILITY to 1))


}