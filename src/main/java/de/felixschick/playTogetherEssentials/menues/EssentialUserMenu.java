package de.felixschick.playTogetherEssentials.menues;

import de.felixschick.playTogetherEssentials.PlayTogetherEssentials;
import de.felixschick.playTogetherEssentials.utils.ItemBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class EssentialUserMenu implements IInventoryMenu {

    private PlayTogetherEssentials plugin;

    public EssentialUserMenu(PlayTogetherEssentials plugin) {
        this.plugin = plugin;
    }

    @Override
    public TextComponent title() {
        return Component.text("§4Essential Menu");
    }

    public Inventory createMenu(Player player) {

        //create inv
        Inventory essential = Bukkit.createInventory(player, 3 * 9, title());

        ItemStack particleMenu = new ItemBuilder(Material.DRAGON_BREATH)
                .setDisplayName(Component.text("Particle Menu", NamedTextColor.YELLOW))
                .build();



        essential.setItem(10, particleMenu);


        InventoryHelper.fillInventory(essential, fillerItem);
        return essential;
    }

    public void openMenu(Player player) {
        player.openInventory(createMenu(player));
    }

    public void closeMenu(Player player) {

    }

    @Override
    public void IInventoryMenu() {

    }

    @Override
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getCurrentItem() == null) return;
        if (event.getView().title().equals(title())) {
            if (event.getCurrentItem().equals(fillerItem)) {
                event.setCancelled(true);
            } else if (event.getCurrentItem().getType() == Material.DRAGON_BREATH) {
                event.setCancelled(true);
                plugin.particleMenu.openMenu((Player) event.getWhoClicked());
            } else {
                event.getWhoClicked().sendMessage("Feature not implemented " + event.getCurrentItem().getType().name());
            }
        }
    }
}
