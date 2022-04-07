package click.erudosaba.mc.eminejobs2.util.recipe

import click.erudosaba.mc.eminejobs2.Main
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.inventory.ShapelessRecipe

class RecipeManager(val plugin: Main) {

    fun setup(MyRecipe: click.erudosaba.mc.eminejobs2.util.recipe.ShapelessRecipe) {
        val str = ChatColor.stripColor(MyRecipe.item.itemMeta?.displayName)?.replace(" ", "_")
        val key = NamespacedKey(plugin, "${plugin.description.name}_$str")
        val recipe = ShapelessRecipe(key, MyRecipe.item)

        for((v,i) in MyRecipe.ingredients) {
            recipe.addIngredient(i,v)
        }

        Bukkit.addRecipe(recipe)
    }

    fun setup(MyRecipe: click.erudosaba.mc.eminejobs2.util.recipe.ShapedRecipe) {
        val str = ChatColor.stripColor(MyRecipe.item.itemMeta?.displayName)?.replace(" ", "_")
        val key = NamespacedKey(plugin, "${plugin.description.name}_$str")
        val recipe = ShapedRecipe(key, MyRecipe.item)

        recipe.apply {
            if(MyRecipe.shape.size == 3) {
                shape(MyRecipe.shape[0], MyRecipe.shape[1], MyRecipe.shape[2])

                for(s in MyRecipe.shape) {
                    for((c,v) in MyRecipe.ingredients) {
                        if(s.indexOf(' ') > -1) {
                            setIngredient(' ', Material.AIR)
                        }

                        if(s.indexOf(c) > -1) {
                            setIngredient(c,v)
                        }
                    }
                }

            }
        }

        Bukkit.addRecipe(recipe)
    }
}