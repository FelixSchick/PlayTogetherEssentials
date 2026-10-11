package de.felixschick.playTogetherEssentials.menues;

import de.felixschick.playTogetherEssentials.PlayTogetherEssentials;
import de.felixschick.playTogetherEssentials.utils.ItemBuilder;
import de.felixschick.playTogetherEssentials.utils.enums.PTEParticles;
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

public class ParticleMenu implements IInventoryMenu {

    private final PlayTogetherEssentials plugin;

    public ParticleMenu(PlayTogetherEssentials plugin) {
        this.plugin = plugin;
    }

    @Override
    public TextComponent title() {
        return Component.text("Particle Menu", NamedTextColor.YELLOW);
    }

    @Override
    public Inventory createMenu(Player player) {

        int particleItemsCount = PTEParticles.values().length;

        int rowsTotal = Math.ceilDiv(particleItemsCount, 7);
        int pages = Math.ceilDiv(rowsTotal, 3);

        //create inv
        Inventory particlemenu = Bukkit.createInventory(
                player,
                ((pages > 1) ? 5*9 : (rowsTotal+2)*9),
                title());

        boolean activatedParticles = plugin.particleProvider.particlePlayers.contains(player.getUniqueId());
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



        particlemenu.setItem(10, particalEffect);


        InventoryHelper.fillInventory(particlemenu, fillerItem);
        return particlemenu;

    }

    @Override
    public void openMenu(Player player) {
        player.openInventory(createMenu(player));
    }

    @Override
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
            } else {
                event.getWhoClicked().sendMessage("Feature not implemented " + event.getCurrentItem().getType().name());
            }
        }
    }
}
