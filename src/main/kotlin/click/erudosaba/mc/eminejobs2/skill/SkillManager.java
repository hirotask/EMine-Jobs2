package click.erudosaba.mc.eminejobs2.skill;

import click.erudosaba.mc.eminejobs2.Main;
import click.erudosaba.mc.eminejobs2.jobs.JobPlayer;
import org.bukkit.entity.Player;

public class SkillManager {

    private Main plugin;
    private Player player;
    private Skill selectedSkill;

    public SkillManager(Main plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
        this.selectedSkill = new JobPlayer(player, plugin).getSelectedSkill();
        //以下で実行

    }
}
