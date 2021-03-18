package click.erudosaba.mc.eminejobs2.jobs

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.util.CustomConfig
import org.bukkit.configuration.InvalidConfigurationException
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.craftbukkit.libs.org.apache.commons.io.FileUtils
import java.io.File
import java.io.IOException

class Job(plg: Main, fileName: String) : CustomConfig(plugin=plg, path="jobs/${fileName}.yml") {

    val id : Int = config.getInt("ID")
    val JobName : String? = config.getString("JobName")
    val category : JobCategory =
            try {
                JobCategory.valueOf(config.getString("Category").toString())
            } catch(e: IllegalArgumentException) {
                JobCategory.INVALID
            }
    val JobExp : Double = config.getDouble("JobExp")
    val items : List<String> = config.getStringList("Items")
    val skills : List<String> = config.getStringList("Skills")

}