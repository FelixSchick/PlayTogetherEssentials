package de.felixschick.playTogetherEssentials.Menues;

import de.felixschick.playTogetherEssentials.PlayTogetherEssentials;
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
import java.util.Collections;

public class EssentialUserMenu implements IInventoryMenu {

    public static final TextComponent title = Component.text("§4Essential Menu");
    static Material fillerItemType = Material.BLACK_STAINED_GLASS_PANE;

    public static Inventory createMenu(Player player) {

        ItemStack filler = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta itemMeta = filler.getItemMeta();
        itemMeta.customName(Component.empty());
        filler.setItemMeta(itemMeta);

        //create inv
        Inventory essential = Bukkit.createInventory(player, 3 * 9, title);

        ItemStack particalEffect = new ItemStack(Material.DRAGON_BREATH);
        ItemMeta particalEffectMeta = filler.getItemMeta();
        particalEffectMeta.customName(Component.text("Particles", NamedTextColor.YELLOW));
        particalEffectMeta.lore( new ArrayList<> (Collections.singleton(Component.text("by activating this you get a circel around you", NamedTextColor.YELLOW))));
        particalEffect.setItemMeta(particalEffectMeta);

        essential.setItem(10, particalEffect);


        InventoryHelper.fillInventory(essential, filler);
        return essential;
    }

    public static void openMenu(Player player) {
        player.openInventory(createMenu(player));
    }

    public static void closeMenu(Player player) {

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        event.getWhoClicked().sendMessage("test 1");
        if (event.getCurrentItem() == null) return;
        event.getWhoClicked().sendMessage("test 2");
        if (event.getView().title().equals(title)) {
            if (event.getCurrentItem().getType() == fillerItemType) {
                event.setCancelled(true);
            } else if (event.getCurrentItem().getType() == Material.DRAGON_BREATH) {
                PlayTogetherEssentials.getInstance().particleProvider.addPlayer((Player) event.getWhoClicked());
                event.setCancelled(true);
            } else {
                event.getWhoClicked().sendMessage("Feature not implemented " + event.getCurrentItem().getType().name());
            }
        }
    }
}
