package click.erudosaba.mc.eminejobs2.util.recipe

import click.erudosaba.mc.eminejobs2.Main
import org.bukkit.Bukkit
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ShapedRecipe

class RecipeManager(val plugin: Main, val MyRecipe : Recipe) {

    val key = NamespacedKey(plugin,plugin.description.name)
    val recipe = ShapedRecipe(key, MyRecipe.item)

    fun setup() {
        if(MyRecipe.shape.size == 3) {
            recipe.apply {
                shape(MyRecipe.shape[0],MyRecipe.shape[1],MyRecipe.shape[2])
                for((c,m) in MyRecipe.ingredients) {
                    var flag = false
                    for(s in MyRecipe.shape) {
                        val index = s.indexOf(c)
                        if(index > -1 && !flag) { //文字列の中に文字cが含まれているか
                            setIngredient(c,m)
                            flag = true
                        }
                    }
                }
            }

            Bukkit.addRecipe(recipe)
        }
    }
}