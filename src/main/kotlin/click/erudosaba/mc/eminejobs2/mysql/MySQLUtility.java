package click.erudosaba.mc.eminejobs2.mysql;

import click.erudosaba.mc.eminejobs2.Main;
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer;
import click.erudosaba.mc.eminejobs2.jobs.Jobs;
import click.erudosaba.mc.eminejobs2.skill.Skill;
import click.erudosaba.mc.eminejobs2.skill.SkillStatus;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class MySQLUtility {

    private MySQLManager manager;

    private final String table = "players",
            column_uuid = "uuid",
            column_name = "name",
            column_job = "job",
            column_exp = "exp",
            column_level = "level",
            column_selectedskill = "selectedskill",
            column_skillstatus = "skillstatus";

    public MySQLUtility(MySQLManager manager) {
        this.manager = manager;
    }

    //insert
    public void insert(Player player, String job) {
        insert(player, job, 0, 0);
    }

    public void insert(Player player, String job, double exp, int level) {
        manager.connectionTest();
        String s = "INSERT INTO " + table + " (" + column_uuid + ", " + column_name + ", " + column_job + ", " + column_exp + ", " + column_level + ") VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = manager.getConnection().prepareStatement(s);
            ps.setString(1, player.getUniqueId().toString());
            ps.setString(2, player.getName());
            ps.setString(3, job);
            ps.setDouble(4, exp);
            ps.setInt(5, level);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(UUID uuid, String name, String job, double exp, int level, Skill skill, SkillStatus status) {
        manager.connectionTest();
        String s = "INSERT INTO " + table + " (" + column_uuid + ", " + column_name + ", " + column_job + ", " + column_exp + ", " + column_level + ", " + column_selectedskill + ", " + column_skillstatus + ") VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = manager.getConnection().prepareStatement(s);
            ps.setString(1, uuid.toString());
            ps.setString(2, name);
            ps.setString(3, job);
            ps.setDouble(4, exp);
            ps.setInt(5, level);
            if(skill != null) {
                ps.setString(6, skill.name().toUpperCase());
            } else {
                ps.setString(6, null);
            }

            ps.setString(7, status.name().toUpperCase());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete
    public void delete(Player player) {
        manager.connectionTest();
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
    public String selectString(UUID uuid, String column) {
        manager.connectionTest();
        String s = "SELECT * FROM " + table + " WHERE " + column_uuid + " = ?";
        try {
            PreparedStatement ps = manager.getConnection().prepareStatement(s);
            ps.setString(1, uuid.toString());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString(column);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int selectInt(Player player, String column) {
        manager.connectionTest();
        try {
            String s = "SELECT * FROM " + table + " WHERE " + column_uuid + " = ?";
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
        manager.connectionTest();
        try {
            String s = "SELECT * FROM " + table + " WHERE " + column_uuid + " = ?";
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
        manager.connectionTest();
        try {
            String s = "UPDATE " + table + " SET " + column + " = ? WHERE " + column_uuid + " = ?";
            PreparedStatement ps = manager.getConnection().prepareStatement(s);
            ps.setString(1, value);
            ps.setString(2, player.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Player player, String column, int value) {
        manager.connectionTest();
        try {
            String s = "UPDATE " + table + " SET " + column + " = ? WHERE " + column_uuid + " = ?";
            PreparedStatement ps = manager.getConnection().prepareStatement(s);
            ps.setInt(1, value);
            ps.setString(2, player.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Player player, String column, double value) {
        manager.connectionTest();
        try {
            String s = "UPDATE " + table + " SET " + column + " = ? WHERE " + column_uuid + " = ?";
            PreparedStatement ps = manager.getConnection().prepareStatement(s);
            ps.setDouble(1, value);
            ps.setString(2, player.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(UUID uuid, String name, String job, double exp, int level, Skill skill, SkillStatus status) {
        manager.connectionTest();
        String s = "UPDATE " + table + " SET " + column_uuid + " = ?, " + column_name + " = ?, " + column_job + " = ?, " + column_exp + " = ?, " + column_level + " = ?, " + column_selectedskill + " = ?, " + column_skillstatus + " = ? " + " WHERE " + column_uuid + " = ?";
        try {
            PreparedStatement ps = manager.getConnection().prepareStatement(s);
            ps.setString(1, uuid.toString());
            ps.setString(2, name);
            ps.setString(3, job.toLowerCase());
            ps.setDouble(4, exp);
            ps.setInt(5, level);
            ps.setString(6, skill.name().toUpperCase());
            ps.setString(7, status.name().toUpperCase());
            ps.setString(8, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<JobPlayer> getAllPlayers(Main plugin) {
        ArrayList<JobPlayer> jpList = new ArrayList<>();
        String sql = "SELECT * FROM " + table;
        try (Connection connection = manager.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    if(rs.getString(column_selectedskill) != null) {
                        jpList.add(new JobPlayer(
                                        UUID.fromString(rs.getString(column_uuid)),
                                        rs.getString(column_name),
                                        Jobs.valueOf(rs.getString(column_job).toUpperCase()),
                                        rs.getDouble(column_exp),
                                        rs.getInt(column_level),
                                        Skill.valueOf(rs.getString(column_selectedskill).toUpperCase()),
                                        SkillStatus.valueOf(rs.getString(column_skillstatus).toUpperCase())
                                )
                        );
                    } else {
                        jpList.add(new JobPlayer(
                                        UUID.fromString(rs.getString(column_uuid)),
                                        rs.getString(column_name),
                                        Jobs.valueOf(rs.getString(column_job).toUpperCase()),
                                        rs.getDouble(column_exp),
                                        rs.getInt(column_level),
                                        null,
                                        SkillStatus.valueOf(rs.getString(column_skillstatus).toUpperCase())
                                )
                        );
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return jpList;
    }

    public boolean isExists(UUID uuid) {
        if (selectString(uuid, column_uuid) != null) return true;
        else return false;
    }
}
