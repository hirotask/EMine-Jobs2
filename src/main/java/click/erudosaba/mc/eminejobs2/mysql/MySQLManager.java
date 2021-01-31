package click.erudosaba.mc.eminejobs2.mysql;

import click.erudosaba.mc.eminejobs2.util.Blocks;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLManager {

    private Connection connection;

    private final String host;
    private final int port;
    private final String database;
    private final String username;
    private final String password;

    public MySQLManager(String host, int port, String database, String username, String password) {
        this.host = host;
        this.database = database;
        this.username = username;
        this.password = password;
        this.port = port;

        connectionTest();
    }

    public Boolean connectionTest() {
        try {
            openConnection();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    private void openConnection() throws SQLException, ClassNotFoundException {
        synchronized (this) {
            if (connection != null && !connection.isClosed()) return;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"+ host +":"+ port +"/"+ database, username, password);
            //Message
            Bukkit.getLogger().info("§3Setting up MySQL");
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
