package click.erudosaba.mc.eminejobs2.util;

import click.erudosaba.mc.eminejobs2.Main;
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.List;

public class SideBar {

    private static final String objectName = "EMJSideBar";
    private static final String[] initial = {
            "================",
            "Job： ",
            "Level： ",
            "Exp: ",
            "================ "
    };

    //InstanceField
    private Main plugin;
    private Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
    private Objective sidebar;
    private Player player;
    private final List<String> scores = new ArrayList<>();

    //Constructor
    public SideBar(Main plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
        manage();
        display();
    }

    private void manage() {
        JobPlayer jp = new JobPlayer(player, plugin);
        //値の取得と代入
        scores.add("================");
        scores.add("Job： " + jp.getJobID());
        scores.add("Level： " + jp.getLevel());
        scores.add("Exp: " + String.format("%.2f",jp.getExp()));
        scores.add("================ ");
    }

    private void display() {
        //オブジェクトの削除
        for (Objective obj : player.getScoreboard().getObjectives()) {
            if (obj.getName().equals(objectName)) {
                //player.sendMessage("テストメッセージ → オブジェクトを確認、削除します。");
                player.getScoreboard().getObjective(objectName).unregister();
            }
        }
        //オブジェクトの生成
        sidebar = scoreboard.registerNewObjective(objectName, "dummy", player.getName());
        sidebar.setDisplaySlot(DisplaySlot.SIDEBAR);
        //オブジェクトの初期化
        for (int i = 0; i < scores.size(); i++) sidebar.getScore(scores.get(i)).setScore(scores.size() - i);
        //オブジェクトの表示
        player.setScoreboard(scoreboard);
    }
}