package click.erudosaba.mc.eminejobs2.gui.menu;

import click.erudosaba.mc.eminejobs2.Main;
import click.erudosaba.mc.eminejobs2.gui.InventoryGUI;
import org.bukkit.entity.Player;

public class MainMenu extends InventoryGUI {

    public static final String title = "メインメニュー";

    public MainMenu(Main plugin, Player player) {
        super(plugin, 27, title, player);
        initialize();
    }

    @Override
    protected void initialize() {
        //
    }
}
