package click.erudosaba.mc.eminejobs2

import click.erudosaba.mc.eminejobs2.command.CommandManager
import click.erudosaba.mc.eminejobs2.listener.MyEventListener
import click.erudosaba.mc.eminejobs2.listener.bukkit.*
import click.erudosaba.mc.eminejobs2.mysql.MySQLManager
import click.erudosaba.mc.eminejobs2.mysql.MySQLUtility
import click.erudosaba.mc.eminejobs2.util.MyConfig
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    val plugin = this

    companion object {
        private val plugin: Main = Main.plugin
        val PluginName = "EMine-Jobs"

        val commandManager = CommandManager(plugin)
        val myConfig = MyConfig(plugin)
        val sqlUtil = MySQLUtility(MySQLManager(
                myConfig.host,
                myConfig.port,
                myConfig.database,
                myConfig.username,
                myConfig.password
        ))
    }


    override fun onDisable() {
        logger.info("$PluginName was Disabled!")
    }

    override fun onEnable() {

        /* init of Command*/
        commandManager.setup()

        /* init of Listener */
        val listeners = arrayOf(
                MyEventListener(this),
                OnBlockBreak(this),
                OnDamageMob(this),
                OnCraft(this),
                OnFish(this),
                OnEnchant(this),
                OnBlockPlace(this),
                OnEat(this)

        )
        listeners.forEach { listener ->  server.pluginManager.registerEvents(listener,this) }


        logger.info("$PluginName was Enabled!")

    }
}