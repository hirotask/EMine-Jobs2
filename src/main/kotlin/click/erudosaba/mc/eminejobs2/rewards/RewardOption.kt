package click.erudosaba.mc.eminejobs2.rewards

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment

class RewardOption(
        val enabled : Boolean,
        val name : String,
        val needLevel : Int,
        val material : Material,
        val unbreakable : Boolean,
        val lore : Array<String>,
        val enchants : Map<Enchantment, Int>) {
}