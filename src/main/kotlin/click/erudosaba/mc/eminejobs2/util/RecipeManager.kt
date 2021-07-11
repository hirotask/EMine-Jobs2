package click.erudosaba.mc.eminejobs2.util

import click.erudosaba.mc.eminejobs2.Main
import me.zombie_striker.qg.api.QualityArmory
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.Recipe
import org.bukkit.inventory.ShapedRecipe

class RecipeManager(val plg : Main) {

    val recipes = mutableListOf<Recipe>()

    fun addGunRecipes() {
        while(QualityArmory.getAmmo().hasNext()) {
            val ammo = QualityArmory.getAmmo().next()
            val item = ammo.itemStack

            val key = NamespacedKey(plg, plg.description.name)
            val recipe = ShapedRecipe(key, item)

            recipe.apply {
                shape("GGI")
                setIngredient('G', Material.GUNPOWDER)
                setIngredient('I', Material.IRON_INGOT)
            }

            Bukkit.addRecipe(recipe)
            recipes.add(recipe)
        }
    }

}