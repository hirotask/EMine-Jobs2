package click.erudosaba.mc.eminejobs2.util.recipe

import click.erudosaba.mc.eminejobs2.Main
import me.zombie_striker.qg.api.QualityArmory
import org.bukkit.Material

class GunRecipe(val plugin : Main) {

    fun setupAmmo() {
        val recipes = ArrayList<Recipe>()

        var item = QualityArmory.getAmmoByName("9mm").itemStack
        item.amount = 10
        recipes.add(Recipe(
                item,
                mapOf(
                        Material.GUNPOWDER to 1,
                        Material.IRON_INGOT to 1
                )
        ))

        item = QualityArmory.getAmmoByName("40mm").itemStack
        item.amount = 10
        recipes.add(Recipe(
                item,
                mapOf(
                        Material.GUNPOWDER to 2,
                        Material.IRON_INGOT to 2
                )
        ))

        item = QualityArmory.getAmmoByName("50bmg").itemStack
        item.amount = 10
        recipes.add(Recipe(
                item,
                mapOf(
                        Material.GUNPOWDER to 3,
                        Material.IRON_INGOT to 1
                )
        ))

        item = QualityArmory.getAmmoByName("556").itemStack
        item.amount = 10
        recipes.add(Recipe(
                item,
                mapOf(
                        Material.GUNPOWDER to 2,
                        Material.IRON_INGOT to 1
                )
        ))


        item = QualityArmory.getAmmoByName("762").itemStack
        item.amount = 10
        recipes.add(Recipe(
                item,
                mapOf(
                        Material.GUNPOWDER to 1,
                        Material.IRON_INGOT to 2
                )
        ))

        item = QualityArmory.getAmmoByName("fuel").itemStack
        item.amount = 2
        recipes.add(Recipe(
                item,
                mapOf(
                        Material.BLAZE_ROD to 1,
                        Material.GUNPOWDER to 1,
                        Material.IRON_INGOT to 1
                )
        ))

        item = QualityArmory.getAmmoByName("fusion_cell").itemStack
        item.amount = 30
        recipes.add(Recipe(
                item,
                mapOf(
                        Material.IRON_INGOT to 6,
                        Material.REDSTONE to 3
                )
        ))

        item = QualityArmory.getAmmoByName("mininuke").itemStack
        item.amount = 1
        recipes.add(Recipe(
                item,
                mapOf(
                        Material.IRON_INGOT to 4,
                        Material.REDSTONE to 5
                )
        ))

        item = QualityArmory.getAmmoByName("musketball").itemStack
        item.amount = 8
        recipes.add(Recipe(
                item,
                mapOf(
                        Material.IRON_INGOT to 3,
                        Material.GUNPOWDER to 2
                )
        ))

        item = QualityArmory.getAmmoByName("rocket").itemStack
        item.amount = 1
        recipes.add(Recipe(
                item,
                mapOf(
                        Material.IRON_INGOT to 4,
                        Material.GUNPOWDER to 4,
                        Material.REDSTONE_BLOCK to 1
                )
        ))

        item = QualityArmory.getAmmoByName("shell").itemStack
        item.amount = 4
        recipes.add(Recipe(
                item,
                mapOf(
                        Material.GUNPOWDER to 4,
                        Material.IRON_INGOT to 4
                )
        ))

        for(recipe in recipes) {
            val recipeManager = RecipeManager(plugin,recipe)
            recipeManager.setup()
        }
    }


    fun setupGuns() {
        //TODO: 銃のレシピ追加
    }
}