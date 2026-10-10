package de.felixschick.playTogetherEssentials.Menues;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public interface IInventoryMenu extends Listener {
    static String title = "";
    static Material fillerItemType = Material.BLACK_STAINED_GLASS_PANE;

    public static Inventory createMenu(Player player) {
        return null;
    }

    public static void openMenu(Player player) {

    }

    public static void closeMenu(Player player) {

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event);
}
