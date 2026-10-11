package de.felixschick.playTogetherEssentials.Menues;

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
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EssentialUserMenu implements IInventoryMenu {

    public static final TextComponent title = Component.text("§4Essential Menu");
    static ItemStack fillerItem= new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayName(Component.empty()).build();


    public static Inventory createMenu(Player player) {

        //create inv
        Inventory essential = Bukkit.createInventory(player, 3 * 9, title);

        boolean activatedParticles = PlayTogetherEssentials.getInstance().particleProvider.particlePlayers.contains(player.getUniqueId());
        ItemStack particalEffect = new ItemBuilder(Material.DRAGON_BREATH)
                .setDisplayName(Component.text("Particles", NamedTextColor.YELLOW))
                .setGlow(
                        activatedParticles
                )
                .addLoreAll(new ArrayList<>() {
                    {
                        add((activatedParticles? Component.text("§2aActive"): Component.text("§4inactive")));
                    }
                })
                .build();



        essential.setItem(10, particalEffect);


        InventoryHelper.fillInventory(essential, fillerItem);
        return essential;
    }

    public static void openMenu(Player player) {
        player.openInventory(createMenu(player));
    }

    public static void closeMenu(Player player) {

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getCurrentItem() == null) return;
        if (event.getView().title().equals(title)) {
            if (event.getCurrentItem().equals(fillerItem)) {
                event.setCancelled(true);
            } else if (event.getCurrentItem().getType() == Material.DRAGON_BREATH) {
                event.setCancelled(true);
                PlayTogetherEssentials.getInstance().particleProvider.toggleParticle((Player) event.getWhoClicked());
                openMenu((Player) event.getWhoClicked());
            } else {
                event.getWhoClicked().sendMessage("Feature not implemented " + event.getCurrentItem().getType().name());
            }
        }
    }
}
