package click.erudosaba.mc.eminejobs2.gui.menu;

import click.erudosaba.mc.eminejobs2.Main;
import click.erudosaba.mc.eminejobs2.gui.InventoryGUI;
import click.erudosaba.mc.eminejobs2.gui.SlotCommand;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class    TestMenu extends InventoryGUI {

    public static final String title = "テストメニュー";

    public TestMenu(Main plugin, Player player) {
        super(plugin, 9, title, player);
        initialize();
    }

    @Override
    protected void initialize() {
        // ItemStack を用意
        ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
        // itemと処理を同じ場所に記述
        addItem(new SlotCommand(4, item) {
            @Override
            public boolean onClick(ClickType click) {
                if (click == ClickType.LEFT) {
                    player.sendMessage("左クリックしました");
                } else if (click == ClickType.RIGHT) {
                    player.sendMessage("右クリックしました");
                }
                // return はクリックイベントをキャンセルするかどうか
                return true;
            }
        });
    }
}
