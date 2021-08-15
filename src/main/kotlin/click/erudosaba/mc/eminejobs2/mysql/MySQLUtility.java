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
    public synchronized void insert(Player player, String job) {
        insert(player, job, 0, 0);
    }

    public synchronized void insert(Player player, String job, double exp, int level) {
        String s = "INSERT INTO " + table + " (" + column_uuid + ", " + column_name + ", " + column_job + ", " + column_exp + ", " + column_level + ") VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = manager.getConnection();
             PreparedStatement ps = connection.prepareStatement(s)) {
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

    public synchronized void insert(UUID uuid, String name, String job, double exp, int level, Skill skill, SkillStatus status) {
        String s = "INSERT INTO " + table + " (" + column_uuid + ", " + column_name + ", " + column_job + ", " + column_exp + ", " + column_level + ", " + column_selectedskill + ", " + column_skillstatus +  ") VALUES (?, ?, ?, ?, ?, ?. ?)";
        try (Connection connection = manager.getConnection();
             PreparedStatement ps = connection.prepareStatement(s)) {
            ps.setString(1, uuid.toString());
            ps.setString(2, name);
            ps.setString(3, job);
            ps.setDouble(4, exp);
            ps.setInt(5, level);
            ps.setString(6, skill.name().toUpperCase());
            ps.setString(7, status.name().toUpperCase());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete
    public synchronized void delete(Player player) {
        String s = "DELETE FROM " + table + " WHERE " + column_uuid + " = ?";
        try (Connection connection = manager.getConnection();
             PreparedStatement ps = connection.prepareStatement(s)) {
            ps.setString(1, player.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //select
    public synchronized String selectString(Player player, String column) {
        String s = "SELECT * FROM " + table + " WHERE " + column_uuid + " = ?";
        try (Connection connection = manager.getConnection();
             PreparedStatement ps = connection.prepareStatement(s)) {
            ps.setString(1, player.getUniqueId().toString());

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

    public synchronized int selectInt(Player player, String column) {
        String s = "SELECT * FROM " + table + " WHERE " + column_uuid + " = ?";
        try (Connection connection = manager.getConnection();
             PreparedStatement ps = connection.prepareStatement(s)) {
            ps.setString(1, player.getUniqueId().toString());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(column);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public synchronized double selectDouble(Player player, String column) {
        String s = "SELECT * FROM " + table + " WHERE " + column_uuid + " = ?";
        try (Connection connection = manager.getConnection();
             PreparedStatement ps = connection.prepareStatement(s)) {
            ps.setString(1, player.getUniqueId().toString());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble(column);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //update
    public synchronized void update(Player player, String column, String value) {
        String s = "UPDATE " + table + " SET " + column + " = ? WHERE " + column_uuid + " = ?";
        try (Connection connection = manager.getConnection();
             PreparedStatement ps = connection.prepareStatement(s)) {
            ps.setString(1, value);
            ps.setString(2, player.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized void update(Player player, String column, int value) {
        String s = "UPDATE " + table + " SET " + column + " = ? WHERE " + column_uuid + " = ?";
        try (Connection connection = manager.getConnection();
             PreparedStatement ps = connection.prepareStatement(s)) {
            ps.setInt(1, value);
            ps.setString(2, player.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized void update(Player player, String column, double value) {
        String s = "UPDATE " + table + " SET " + column + " = ? WHERE " + column_uuid + " = ?";
        try (Connection connection = manager.getConnection();
             PreparedStatement ps = connection.prepareStatement(s)) {
            ps.setDouble(1, value);
            ps.setString(2, player.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public synchronized ArrayList<JobPlayer> getAllPlayers(Main plugin) {
        ArrayList<JobPlayer> jpList = new ArrayList<>();
        String sql = "SELECT * FROM " + table;
        try (Connection connection = manager.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    jpList.add(new JobPlayer(
                            UUID.fromString(rs.getString(column_name)),
                            Jobs.valueOf(rs.getString(column_job)),
                            rs.getDouble(column_exp),
                            rs.getInt(column_level),
                            Skill.valueOf(rs.getString(column_selectedskill)),
                            SkillStatus.valueOf(rs.getString(column_skillstatus))
                            )
                    );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return jpList;
    }

    //exists
    public synchronized boolean isExists(Player player) {
        if (selectString(player, column_uuid) != null) return true;
        else return false;
    }

    //name
    public synchronized String getName(Player player) {
        return selectString(player, column_name);
    }

    public synchronized void setName(Player player, String value) {
        update(player, column_name, value);
    }

    //jobID
    public synchronized String getJob(Player player) {
        return selectString(player, column_job);
    }

    public synchronized void setJob(Player player, String value) {
        update(player, column_job, value);
    }

    //exp
    public synchronized double getExp(Player player) {
        return selectDouble(player, column_exp);
    }

    public synchronized void setExp(Player player, double value) {
        update(player, column_exp, value);
    }

    //level
    public synchronized int getLevel(Player player) {
        return selectInt(player, column_level);
    }

    public synchronized void setLevel(Player player, int value) {
        update(player, column_level, value);
    }

    //SelectedSkill
    public synchronized String getSelectedSkill(Player player) {
        return selectString(player, column_selectedskill);
    }

    public synchronized void setSelectedSkill(Player player, String value) {
        update(player, column_selectedskill, value);
    }

    //SkillStatus
    public synchronized String getSkillStatus(Player player) {
        return selectString(player, column_skillstatus);
    }

    public synchronized void setSkillStatus(Player player, String value) {
        update(player, column_skillstatus, value);
    }

    public synchronized boolean SkillExists(Player player) {
        if (selectString(player, column_selectedskill) != null) {
            return true;
        } else {
            return false;
        }
    }
}
