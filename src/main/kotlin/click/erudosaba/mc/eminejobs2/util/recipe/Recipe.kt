package click.erudosaba.mc.eminejobs2.util.recipe

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Recipe(val item : ItemStack, val shape : Array<String>, val ingredients : Map<Char, Material>) {
}