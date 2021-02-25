package click.erudosaba.mc.eminejobs2.util

import click.erudosaba.mc.eminejobs2.Main
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.jetbrains.annotations.NotNull
import java.io.File
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets

open class CustomConfig(val plugin: Main, path: String?) {

    lateinit var config: FileConfiguration
    val file = path ?: "config.yml"
    val configFile: File = File(plugin.dataFolder,file)

    init {
        this.reload()
    }

    fun reload() {
        config = YamlConfiguration.loadConfiguration(configFile)
        val configStream = plugin.getResource(file) ?: return

        (config as @NotNull YamlConfiguration).setDefaults(YamlConfiguration.loadConfiguration(InputStreamReader(configStream,StandardCharsets.UTF_8)))
    }
}