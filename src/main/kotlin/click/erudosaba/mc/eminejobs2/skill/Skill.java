package click.erudosaba.mc.eminejobs2.skill;

import click.erudosaba.mc.eminejobs2.Main;
import click.erudosaba.mc.eminejobs2.util.CustomConfig;
import org.bukkit.Material;

public class Skill extends CustomConfig {

    //インスタンスフィールド
    private final Main plugin;
    public final String id;
    public final String name;
    public final int needLevel;
    public final int interval;
    public final Effect effect;
    public final Material icon;

    public Skill(Main plugin, String id) {
        super(plugin, id + ".yml");
        this.plugin = plugin;
        this.id = id;
        this.name = config.getString("Name");
        this.needLevel = config.getInt("NeedLevel");
        this.interval = config.getInt("Interval");
        this.effect = Effect.valueOf(config.getString("Effect"));
        this.icon = Material.valueOf(config.getString("Icon"));
    }
}
