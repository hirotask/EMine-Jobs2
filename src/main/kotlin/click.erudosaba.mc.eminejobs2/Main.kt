package click.erudosaba.mc.eminejobs2

import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    val PluginName = "EMine-Jobs";

    override fun onDisable() {
        logger.info("$PluginName was Disabled!")
    }

    override fun onEnable() {
        logger.info("$PluginName was Enabled!")
    }
}