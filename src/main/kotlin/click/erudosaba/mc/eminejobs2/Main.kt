package click.erudosaba.mc.eminejobs2

import click.erudosaba.mc.eminejobs2.command.CommandManager
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer
import click.erudosaba.mc.eminejobs2.listener.JobEventListener
import click.erudosaba.mc.eminejobs2.listener.bukkit.OnSmelt
import click.erudosaba.mc.eminejobs2.listener.bukkit.*
import click.erudosaba.mc.eminejobs2.mysql.MySQLManager
import click.erudosaba.mc.eminejobs2.mysql.MySQLUtility
import click.erudosaba.mc.eminejobs2.skill.SkillManager
import click.erudosaba.mc.eminejobs2.util.FileUtils
import click.erudosaba.mc.eminejobs2.util.MyConfig
import click.erudosaba.mc.eminejobs2.util.recipe.GunRecipe
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    val commandManager = CommandManager(this)
    val myConfig = MyConfig(this)
    val sqlUtil = MySQLUtility(MySQLManager(
            myConfig.host,
            myConfig.port,
            myConfig.database,
            myConfig.username,
            myConfig.password
    ))
    val skillManager = SkillManager(plugin = this)

    companion object {
        const val PluginName = "EMine-Jobs"
        var jPlayers = ArrayList<JobPlayer>()
    }


    override fun onDisable() {
        for(jp in jPlayers) {
            sqlUtil.insert(jp.uuid,jp.player?.name,jp.jobID.name.toLowerCase(),jp.exp,jp.level,jp.selectedSkill,jp.skillStatus)
        }


        logger.info("$PluginName was Disabled!")
    }

    override fun onEnable() {

        val fileUtils = FileUtils()

        /* init of SQL */
        jPlayers = sqlUtil.getAllPlayers(this)
        for(jp in jPlayers) {
            println(jp.player?.name)
        }

        /* init of Command */
        commandManager.setup()

        /* init of Listener */
        val listeners = arrayOf(
                JobEventListener(this),
                OnInventoryClick(this),
                OnBlockBreak(this),
                OnDamageMob(this),
                OnCraft(this),
                OnFish(this),
                OnEnchant(this),
                OnBlockPlace(this),
                OnEat(this),
                OnInteract(this),
                OnJoinLeave(this),
                OnSmelt(this)
        )
        listeners.forEach { listener ->  server.pluginManager.registerEvents(listener,this) }

        /* init of Skills */
        skillManager.loadOptions()
        skillManager.loadSkills()

        /* init of Recipe */
        val gunRecipe = GunRecipe(this)
        gunRecipe.setupAmmo()
        gunRecipe.setupGuns()

        logger.info("$PluginName was Enabled!")
    }
}