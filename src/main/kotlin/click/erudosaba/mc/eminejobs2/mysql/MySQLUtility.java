package click.erudosaba.mc.eminejobs2.mysql;

import click.erudosaba.mc.eminejobs2.skill.Skill;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLUtility {

    private MySQLManager manager;

    private final String table = "players",
            column_uuid = "uuid",
            column_name = "name",
            column_job = "job",
            column_exp = "exp",
            column_level = "level",
            column_selectedskill = "selectedskill";

    public MySQLUtility(MySQLManager manager) {
        this.manager = manager;
    }

    //insert
    public void insert(Player player, String job) {
        insert(player, job, 0, 0);
    }
    public void insert(Player player, String job, int exp, int level) {
        try {
            String s = "INSERT INTO " + table + " (" + column_uuid + ", " + column_name + ", " + column_job + ", " + column_exp + ", " + column_level + ") VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = manager.getConnection().prepareStatement(s);
            ps.setString(1, player.getUniqueId().toString());
            ps.setString(2, player.getName());
            ps.setString(3, job);
            ps.setInt(4, exp);
            ps.setInt(5, level);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //delete
    public void delete(Player player) {
        try {
            String s = "DELETE FROM " + table + " WHERE " + column_uuid + " = ?";
            PreparedStatement ps = manager.getConnection().prepareStatement(s);
            ps.setString(1, player.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //select
    public String selectString(Player player, String column) {
        try {
            String s = "SELECT * FROM "+ table +" WHERE " + column_uuid + " = ?";
            PreparedStatement ps = manager.getConnection().prepareStatement(s);
            ps.setString(1, player.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(column);
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public int selectInt(Player player, String column) {
        try {
            String s = "SELECT * FROM "+ table +" WHERE " + column_uuid + " = ?";
            PreparedStatement ps = manager.getConnection().prepareStatement(s);
            ps.setString(1, player.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(column);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    public double selectDouble(Player player, String column) {
        try {
            String s = "SELECT * FROM "+ table +" WHERE " + column_uuid + " = ?";
            PreparedStatement ps = manager.getConnection().prepareStatement(s);
            ps.setString(1, player.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble(column);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    //update
    public void update(Player player, String column, String value) {
        try {
            String s = "UPDATE "+ table +" SET "+ column +" = ? WHERE " + column_uuid + " = ?";
            PreparedStatement ps = manager.getConnection().prepareStatement(s);
            ps.setString(1, value);
            ps.setString(2, player.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Player player, String column, int value) {
        try {
            String s = "UPDATE "+ table +" SET "+ column +" = ? WHERE " + column_uuid + " = ?";
            PreparedStatement ps = manager.getConnection().prepareStatement(s);
            ps.setInt(1, value);
            ps.setString(2, player.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Player player, String column, double value) {
        try {
            String s = "UPDATE "+ table +" SET "+ column +" = ? WHERE " + column_uuid + " = ?";
            PreparedStatement ps = manager.getConnection().prepareStatement(s);
            ps.setDouble(1, value);
            ps.setString(2, player.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //exists
    public boolean isExists(Player player) {
        if (selectString(player, column_uuid) != null) return true;
        else return false;
    }
    //name
    public String getName(Player player) {
        return selectString(player , column_name);
    }
    public void setName(Player player, String value) {
        update(player, column_name, value);
    }
    //jobID
    public String getJob(Player player) {
        return selectString(player , column_job);
    }
    public void setJob(Player player, String value) {
        update(player, column_job, value);
    }
    //exp
    public double getExp(Player player) {
        return selectDouble(player , column_exp);
    }
    public void setExp(Player player, double value) {
        update(player, column_exp, value);
    }
    //level
    public int getLevel(Player player) {
        return selectInt(player , column_level);
    }
    public void setLevel(Player player, int value) {
        update(player, column_level, value);
    }
    //SelectedSkill
    public String getSelectedSkill(Player player) {
        return selectString(player, column_selectedskill);
    }
    public void setSelectedSkill(Player player, String value) {
        update(player, column_selectedskill, value);
    }
    public boolean SkillExists(Player player) {
        if(selectString(player,column_selectedskill) != null) {
            return true;
        } else {
            return false;
        }
    }
}
