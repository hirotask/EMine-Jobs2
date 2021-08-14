package click.erudosaba.mc.eminejobs2.util.recipe

import click.erudosaba.mc.eminejobs2.Main
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.inventory.ShapelessRecipe

class RecipeManager(val plugin: Main, val MyRecipe: Recipe) {

    fun setup() {
        val str = ChatColor.stripColor(MyRecipe.item.itemMeta?.displayName)?.replace(" ", "_")
        val key = NamespacedKey(plugin, "${plugin.description.name}_$str")
        val recipe = ShapelessRecipe(key, MyRecipe.item)

        for((v,i) in MyRecipe.ingredients) {
            recipe.addIngredient(i,v)
        }

        Bukkit.addRecipe(recipe)
    }
}