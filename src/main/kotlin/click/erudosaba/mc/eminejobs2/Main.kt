package click.erudosaba.mc.eminejobs2

import click.erudosaba.mc.eminejobs2.command.CommandManager
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    val PluginName = "EMine-Jobs"

    lateinit var commandManager : CommandManager

    override fun onDisable() {
        logger.info("$PluginName was Disabled!")
    }

    override fun onEnable() {
        commandManager = CommandManager(this)
        commandManager.setup()

        logger.info("$PluginName was Enabled!")

    }
}