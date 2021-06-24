package click.erudosaba.mc.eminejobs2.gui;

import click.erudosaba.mc.eminejobs2.Main;
import click.erudosaba.mc.eminejobs2.gui.menu.MainMenu;
import click.erudosaba.mc.eminejobs2.gui.menu.TestMenu;
import org.bukkit.entity.Player;

public enum GUIEnum {
    TEST(9, "テストメニュー"),
    MAIN(27, "メインメニュー");

    private int slot;
    private String title;

    GUIEnum(int slot, String title) {
        this.slot = slot;
        this.title = title;
    }

    public int getSlot() {
        return slot;
    }
    public String getTitle() {
        return title;
    }

    public static InventoryGUI getGUI(Main plugin, GUIEnum guiEnum, Player player) {
        if (guiEnum == TEST) return new TestMenu(plugin, player);
        else if (guiEnum == MAIN) return new MainMenu(plugin, player);
        else return null;
    }
}
