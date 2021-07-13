package click.erudosaba.mc.eminejobs2.skill

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.SkillUseEvent
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import click.erudosaba.mc.eminejobs2.skill.skills.*
import click.erudosaba.mc.eminejobs2.util.CustomConfig
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class SkillManager(val plugin: Main) {

    val skillOptions = mutableMapOf<Skill, SkillOption>()

    //スキルをskill_config.ymlからロード
    //値が設定されていなかったらSkillから取得
    fun loadOptions() {
        val customConfig = CustomConfig(plugin, "skills_config.yml")
        val config = customConfig.config
        var amountLoaded = 0
        var amountDisabled = 0

        val startTime = System.currentTimeMillis()
        val skills = config.getConfigurationSection("skills")
        if (skills != null) {
            for (job in Jobs.values()) {
                val jobName = job.name.toLowerCase()
                val jobSkills = skills.getConfigurationSection(jobName)
                if (jobSkills != null) {
                    for (skillName in jobSkills.getKeys(false)) {
                        //check if skill is valid
                        var hasKey = false
                        for (skill in Skill.values()) {
                            if (skillName.toUpperCase() == skill.name) {
                                hasKey = true
                                break
                            }
                        }
                        if (hasKey) {
                            val path = "skills.${jobName}.${skillName}."
                            val skill = Skill.valueOf(skillName.toUpperCase())
                            //configの内容
                            val enabled = config.getBoolean("${path}enabled", true)
                            val name = config.getString("${path}name", skill.name.toLowerCase())
                            val needLevel = config.getInt("${path}need_level", skill.defaultNeedLevel)
                            val activeTime = config.getInt("${path}active_time", skill.defaultActiveTime)
                            val interval = config.getInt("${path}interval", skill.defaultInterval)
                            val description = config.getStringList("${path}description")
                            val iconStr = config.getString("${path}icon", skill.defaultIcon)
                            val icon = Material.valueOf(iconStr!!.toUpperCase())

                            if (!enabled) {
                                amountDisabled++
                            }

                            val option = SkillOption(enabled, name!!, needLevel, activeTime, interval, description.toTypedArray(), icon)
                            skillOptions[skill] = option
                            amountLoaded++

                        }
                    }
                }
            }
        }
        val endTime = System.currentTimeMillis()
        val timeElapsed = endTime - startTime
        Bukkit.getLogger().info("[eMineJobs2] Disabled $amountDisabled Skills")
        Bukkit.getLogger().info("[eMineJobs2] Enabled $amountLoaded Skills")
        Bukkit.getLogger().info("[eMineJobs2] Time: $timeElapsed")

    }

    fun loadSkills() {
        val skills = arrayOf(
                ArcherSkills(plugin),
                BrewerSkills(plugin),
                BuilderSkills(plugin),
                CrafterSkills(plugin),
                DiggerSkills(plugin),
                EnchanterSkills(plugin),
                ExplorerSkills(plugin),
                FarmerSkills(plugin),
                FishermanSkills(plugin),
                GunnerSkills(plugin),
                HungerSkills(plugin),
                MinerSkills(plugin),
                SmelterSkills(plugin),
                SwordmanSkills(plugin),
                WeaponSmithSkills(plugin),
                WoodCutterSkills(plugin)
        )

        skills.forEach { listener -> plugin.server.pluginManager.registerEvents(listener,plugin) }

    }

    fun getSkillOption(skill: Skill): SkillOption {
        return skillOptions[skill]!!
    }

    fun isEnabled(skill: Skill): Boolean? {
        return if (skillOptions.containsKey(skill)) {
            skillOptions[skill]?.enabled
        } else {
            true
        }
    }


}