package click.erudosaba.mc.eminejobs2.skill

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.skill.skills.*

class SkillManager(val plugin : Main) {

    fun loadSkills() {
        ArcherSkills(plugin)
        BrewerSkills(plugin)
        BuilderSkills(plugin)
        CrafterSkills(plugin)
        DiggerSkills(plugin)
        EnchanterSkills(plugin)
        ExplorerSkills(plugin)
        FarmerSkills(plugin)
        FishermanSkills(plugin)
        GunnerSkills(plugin)
        HungerSkills(plugin)
        MinerSkills(plugin)
        SmelterSkills(plugin)
        SwordmanSkills(plugin)
        WeaponSmithSkills(plugin)
        WoodCutterSkills(plugin)
    }

    
}