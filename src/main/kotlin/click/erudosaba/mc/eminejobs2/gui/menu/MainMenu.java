package click.erudosaba.mc.eminejobs2.gui.menu;

import click.erudosaba.mc.eminejobs2.Main;
import click.erudosaba.mc.eminejobs2.gui.GUIEnum;
import click.erudosaba.mc.eminejobs2.gui.InventoryGUI;
import org.bukkit.entity.Player;

public class MainMenu extends InventoryGUI {

    public MainMenu(Main plugin, Player player) {
        super(plugin, GUIEnum.MAIN, player);
        initialize();
    }

    @Override
    protected void initialize() {
        //
    }
}
