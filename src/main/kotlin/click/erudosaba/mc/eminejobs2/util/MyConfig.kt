package click.erudosaba.mc.eminejobs2.util

import click.erudosaba.mc.eminejobs2.Main

class MyConfig(plg: Main) : CustomConfig(plugin=plg,path = null) {

    val enabledMySQL = config.getBoolean("enabled-mysql")
    val host = config.getString("host")
    val port = config.getInt("port")
    val username = config.getString("username")
    val password = config.getString("password")
    val database = config.getString("database")
}