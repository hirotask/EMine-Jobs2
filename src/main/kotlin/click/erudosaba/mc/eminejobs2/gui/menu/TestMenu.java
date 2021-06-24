package click.erudosaba.mc.eminejobs2.gui.menu;

import click.erudosaba.mc.eminejobs2.Main;
import click.erudosaba.mc.eminejobs2.gui.GUIEnum;
import click.erudosaba.mc.eminejobs2.gui.InventoryGUI;
import click.erudosaba.mc.eminejobs2.gui.SlotCommand;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class TestMenu extends InventoryGUI {

    public TestMenu(Main plugin, Player player) {
        super(plugin, GUIEnum.TEST, player);
        initialize();
    }

    @Override
    protected void initialize() {
        // create the ItemStack
        ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("クリックすんじゃねーぞ！");
        List<String> lore = meta.getLore();
        lore.add("クリックしてください...");
        meta.setLore(lore);
        item.setItemMeta(meta);
        // add Item and Command
        addItem(new SlotCommand(4, item) {
            @Override
            public boolean onClick(ClickType click) {
                player.sendMessage("クリックすんなって言っただろ！！！");
                return true;
            }
        });
    }
}
