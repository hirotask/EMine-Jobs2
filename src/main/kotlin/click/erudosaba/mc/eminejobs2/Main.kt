package click.erudosaba.mc.eminejobs2

import click.erudosaba.mc.eminejobs2.command.CommandManager
import click.erudosaba.mc.eminejobs2.mysql.MySQLManager
import click.erudosaba.mc.eminejobs2.mysql.MySQLUtility
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    val PluginName = "EMine-Jobs"

    lateinit var commandManager : CommandManager
    lateinit var sqlUtil : MySQLUtility

    override fun onDisable() {
        logger.info("$PluginName was Disabled!")
    }

    override fun onEnable() {

        /* init of Command*/
        commandManager = CommandManager(this)
        commandManager.setup()


        logger.info("$PluginName was Enabled!")

    }
}