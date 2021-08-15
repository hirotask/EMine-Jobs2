package click.erudosaba.mc.eminejobs2.util.recipe

import click.erudosaba.mc.eminejobs2.Main
import me.zombie_striker.qg.api.QualityArmory
import org.bukkit.Material

class GunRecipe(val plugin : Main) {

    fun setupAmmo() {
        val recipes = ArrayList<ShapedRecipe>()

        var item = QualityArmory.getAmmoByName("9mm").itemStack
        item.amount = 10
        recipes.add(ShapedRecipe(
                item,
                arrayOf(
                        "GI ",
                        "   ",
                        "   "
                ),
                mapOf(
                        'G' to Material.GUNPOWDER,
                        'I' to Material.IRON_INGOT
                )
        ))

        item = QualityArmory.getAmmoByName("40mm").itemStack
        item.amount = 10
        recipes.add(ShapedRecipe(
                item,
                arrayOf(
                        "GI ",
                        "GI ",
                        "   "
                ),
                mapOf(
                        'G' to Material.GUNPOWDER,
                        'I' to Material.IRON_INGOT
                )
        ))

        item = QualityArmory.getAmmoByName("50bmg").itemStack
        item.amount = 10
        recipes.add(ShapedRecipe(
                item,
                arrayOf(
                        "GG ",
                        "IG ",
                        "   "
                ),
                mapOf(
                        'G' to Material.GUNPOWDER,
                        'I' to Material.IRON_INGOT
                )
        ))

        item = QualityArmory.getAmmoByName("556").itemStack
        item.amount = 10
        recipes.add(ShapedRecipe(
                item,
                arrayOf(
                        "GG ",
                        "I  ",
                        "   "
                ),
                mapOf(
                        'G' to Material.GUNPOWDER,
                        'I' to Material.IRON_INGOT
                )
        ))


        item = QualityArmory.getAmmoByName("762").itemStack
        item.amount = 10
        recipes.add(ShapedRecipe(
                item,
                arrayOf(
                        "GI ",
                        "I  ",
                        "   "
                ),
                mapOf(
                        'G' to Material.GUNPOWDER,
                        'I' to Material.IRON_INGOT
                )
        ))

        item = QualityArmory.getAmmoByName("fuel").itemStack
        item.amount = 2
        recipes.add(ShapedRecipe(
                item,
                arrayOf(
                        "BG ",
                        "I  ",
                        "   "
                ),
                mapOf(
                        'B' to Material.BLAZE_ROD,
                        'G' to Material.GUNPOWDER,
                        'I' to Material.IRON_INGOT
                )
        ))

        item = QualityArmory.getAmmoByName("fusion_cell").itemStack
        item.amount = 30
        recipes.add(ShapedRecipe(
                item,
                arrayOf(
                        "III",
                        "IGR",
                        "   "
                ),
                mapOf(
                        'I' to Material.IRON_INGOT,
                        'G' to Material.GUNPOWDER,
                        'R' to Material.REDSTONE
                )
        ))

        item = QualityArmory.getAmmoByName("mininuke").itemStack
        item.amount = 1
        recipes.add(ShapedRecipe(
                item,
                arrayOf(
                        "III",
                        "IRR",
                        "   "
                ),
                mapOf(
                        'I' to Material.IRON_INGOT,
                        'R' to Material.REDSTONE
                )
        ))

        item = QualityArmory.getAmmoByName("musketball").itemStack
        item.amount = 8
        recipes.add(ShapedRecipe(
                item,
                arrayOf(
                        "III",
                        "GG ",
                        "   "
                ),
                mapOf(
                        'I' to Material.IRON_INGOT,
                        'G' to Material.GUNPOWDER
                )
        ))

        item = QualityArmory.getAmmoByName("rocket").itemStack
        item.amount = 1
        recipes.add(ShapedRecipe(
                item,
                arrayOf(
                        "III",
                        "GBG",
                        "III"
                ),
                mapOf(
                        'I' to Material.IRON_INGOT,
                        'G' to Material.GUNPOWDER,
                        'B' to Material.REDSTONE_BLOCK
                )
        ))

        item = QualityArmory.getAmmoByName("shell").itemStack
        item.amount = 4
        recipes.add(ShapedRecipe(
                item,
                arrayOf(
                        "II ",
                        "GG ",
                        "   "
                ),
                mapOf(
                        'I' to Material.IRON_INGOT,
                        'G' to Material.GUNPOWDER
                )
        ))

        for(recipe in recipes) {
            val recipeManager = RecipeManager(plugin)
            recipeManager.setup(recipe)
        }
    }


    fun setupGuns() {
        //TODO: 銃のレシピ追加
        val recipes = ArrayList<ShapedRecipe>()
        recipes.add(ShapedRecipe(
                QualityArmory.getGunByName("10mmpistol").itemStack,
                arrayOf(
                        "III",
                        "R  ",
                        "   "
                ),
                mapOf(
                        'I' to Material.IRON_INGOT,
                        'R' to Material.REDSTONE
                )
        ))

        recipes.add(ShapedRecipe(
                QualityArmory.getGunByName("aa12").itemStack,
                arrayOf(
                        "III",
                        "RG ",
                        "R  "
                ),
                mapOf(
                        'I' to Material.IRON_INGOT,
                        'G' to Material.GUNPOWDER,
                        'R' to Material.REDSTONE
                )
        ))

        recipes.add(ShapedRecipe(
                QualityArmory.getGunByName("ak47").itemStack,
                arrayOf(
                        "III",
                        "DR ",
                        "   "
                ),
                mapOf(
                        'I' to Material.IRON_INGOT,
                        'D' to Material.GOLD_INGOT,
                        'R' to Material.REDSTONE
                )
        ))

        recipes.add(ShapedRecipe(
                QualityArmory.getGunByName("ak47u").itemStack,
                arrayOf(
                        "III",
                        "RD ",
                        "   "
                ),
                mapOf(
                        'I' to Material.IRON_INGOT,
                        'D' to Material.GOLD_INGOT,
                        'R' to Material.REDSTONE
                )
        ))

        recipes.add(ShapedRecipe(
                QualityArmory.getGunByName("m41pulserifle").itemStack,
                arrayOf(
                        "III",
                        "DR ",
                        "R  "
                ),
                mapOf(
                        'I' to Material.IRON_INGOT,
                        'D' to Material.GOLD_INGOT,
                        'R' to Material.REDSTONE
                )
        ))

        recipes.add(ShapedRecipe(
                QualityArmory.getGunByName("arcgun9").itemStack,
                arrayOf(
                        "DDD",
                        "RR ",
                        "   "
                ),
                mapOf(
                        'D' to Material.GOLD_INGOT,
                        'R' to Material.REDSTONE
                )
        ))

        recipes.add(ShapedRecipe(
                QualityArmory.getGunByName("asval").itemStack,
                arrayOf(
                        "III",
                        "R R",
                        "   "
                ),
                mapOf(
                        'I' to Material.IRON_INGOT,
                        'R' to Material.REDSTONE
                )
        ))

        recipes.add(ShapedRecipe(
                QualityArmory.getGunByName("auto9").itemStack,
                arrayOf(
                        "III",
                        "I  ",
                        "R  "
                ),
                mapOf(
                        'I' to Material.IRON_INGOT,
                        'R' to Material.REDSTONE
                )
        ))

        recipes.add(ShapedRecipe(
                QualityArmory.getGunByName("awp").itemStack,
                arrayOf(
                        "III",
                        "II ",
                        "B  "
                ),
                mapOf(
                        'I' to Material.IRON_INGOT,
                        'B' to Material.REDSTONE_BLOCK
                )
        ))

        recipes.add(ShapedRecipe(
                QualityArmory.getGunByName("barrett").itemStack,
                arrayOf(
                        "IOI",
                        "II ",
                        "B  "
                ),
                mapOf(
                        'I' to Material.IRON_INGOT,
                        'O' to Material.OAK_PLANKS,
                        'B' to Material.REDSTONE_BLOCK
                )
        ))
    }
}