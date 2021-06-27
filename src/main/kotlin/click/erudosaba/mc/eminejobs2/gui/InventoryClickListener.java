package click.erudosaba.mc.eminejobs2.gui;

import click.erudosaba.mc.eminejobs2.Main;
import click.erudosaba.mc.eminejobs2.gui.menu.MainMenu;
import click.erudosaba.mc.eminejobs2.gui.menu.TestMenu;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    private final Main plugin;

    public InventoryClickListener(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) throws InvalidConfigurationException {
        String title = event.getView().getTitle();
        Player player = (Player) event.getWhoClicked();
        int slot = event.getSlot();
        ClickType clickType = event.getClick();
        switch (title) {
            case MainMenu.title:
                if (new MainMenu(plugin, player).onClick(slot, clickType)) {
                    event.setCancelled(true);
                }
                break;
            case TestMenu.title:
                if (new TestMenu(plugin, player).onClick(slot, clickType)) {
                    event.setCancelled(true);
                }
                break;
        }
    }
}
