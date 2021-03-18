package click.erudosaba.mc.eminejobs2.util;

import click.erudosaba.mc.eminejobs2.Main;
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

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
    private String[] scores;

    //Constructor
    public SideBar(Main plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
        manage();
        display();
    }

    private void manage() {
        JobPlayer jp = new JobPlayer(player, plugin);
        //初期化
        scores = initial;
        //値の取得と代入
        scores[1] = scores[1] + jp.getJobiD();
        scores[2] = scores[2] + jp.getLevel();
        scores[3] = scores[3] + String.format("%.2f", jp.getExp());
    }

    private void display() {
        //オブジェクトの削除
        for (Objective obj : player.getScoreboard().getObjectives()) {
            if (obj.getName().equals(objectName)) {
                player.sendMessage("テストメッセージ → オブジェクトを確認、削除します。");
                player.getScoreboard().getObjective(objectName).unregister();
            }
        }
        //オブジェクトの生成
        sidebar = scoreboard.registerNewObjective(objectName, "dummy", player.getName());
        sidebar.setDisplaySlot(DisplaySlot.SIDEBAR);
        //オブジェクトの初期化
        for (int i = 0; i < scores.length; i++) sidebar.getScore(scores[i]).setScore(scores.length - i);
        //オブジェクトの表示
        player.setScoreboard(scoreboard);
    }
}