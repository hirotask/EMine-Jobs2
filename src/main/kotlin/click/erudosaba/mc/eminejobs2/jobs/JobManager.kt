package click.erudosaba.mc.eminejobs2.jobs

import click.erudosaba.mc.eminejobs2.Main
import org.bukkit.configuration.InvalidConfigurationException
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.craftbukkit.libs.org.apache.commons.io.FileUtils
import java.io.File
import java.io.IOException

class JobManager(private var plugin: Main, private val fileName: String) {

    private val configFile = File(plugin.dataFolder, "/jobs/$fileName")
    private val config = YamlConfiguration()

    val id : Int
    val JobName : String?
    val category : JobCategory
    val JobExp : Double
    val items : List<String>
    val skills : List<String>

    init {
        this.saveDefault()
        this.reload()

        id = config.getInt("ID")
        JobName = config.getString("JobName")
        category =
                try {
                    JobCategory.valueOf(config.getString("Category").toString())
                } catch(e: IllegalArgumentException) {
                    e.printStackTrace()
                    JobCategory.INVALID
                }
        JobExp = config.getDouble("JobExp")
        items = config.getStringList("Items")
        skills = config.getStringList("Skills")

    }

    private fun reload() {
        try {
            config.load(configFile)
        } catch(e: IOException) {
            e.printStackTrace()
        } catch(e: InvalidConfigurationException) {
            e.printStackTrace()
        }

        val defaultConfigStream = plugin.getResource("/jobs/$fileName")
        if(defaultConfigStream != null) {
            val file = File(plugin.dataFolder, "/jobs/$fileName")
            try {
                FileUtils.copyInputStreamToFile(defaultConfigStream,file)
            } catch(e: IOException) {
                e.printStackTrace()
            }

            val defaultConfig = YamlConfiguration.loadConfiguration(file)
            config.setDefaults(defaultConfig)
        }
    }

    private fun saveDefault() {
        if(!configFile.exists()) {
            plugin.saveResource("jobs/$fileName",false)
        }
    }
}