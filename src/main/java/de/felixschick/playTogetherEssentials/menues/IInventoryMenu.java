package de.felixschick.playTogetherEssentials.menues;

import de.felixschick.playTogetherEssentials.utils.ItemBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public interface IInventoryMenu {
    public TextComponent title();
    final ItemStack fillerItem = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayName(Component.empty()).build();

    public Inventory createMenu(Player player);

    public void openMenu(Player player);

    public void closeMenu(Player player);

    public void IInventoryMenu();

    public void onInventoryClick(InventoryClickEvent event);
}
