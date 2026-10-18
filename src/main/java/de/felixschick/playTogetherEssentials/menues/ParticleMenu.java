package de.felixschick.playTogetherEssentials.menues;

import de.felixschick.playTogetherEssentials.PlayTogetherEssentials;
import de.felixschick.playTogetherEssentials.utils.ItemBuilder;
import de.felixschick.playTogetherEssentials.utils.enums.PTEParticles;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ParticleMenu implements IInventoryMenu {

    private final PlayTogetherEssentials plugin;

    private final PTEParticles[] particles = PTEParticles.values();

    public ParticleMenu(PlayTogetherEssentials plugin) {
        this.plugin = plugin;
    }

    @Override
    public TextComponent title() {
        return Component.text("Particle Menu", NamedTextColor.YELLOW);
    }

    @Override
    public Inventory createMenu(Player player) {
        return createMenu(player, null, 1);
    }

    public Inventory createMenu(Player player, IInventoryMenu backTo, int page) {


        int particleItemsCount = particles.length;

        int rowsTotal = Math.ceilDiv(particleItemsCount, 7);
        int pages = Math.ceilDiv(rowsTotal, 3);
        int rowsOnSelPage = (rowsTotal - ((page -1) * 3) > 3 ? 5 : ((rowsTotal - ((page -1)* 3))+2));

        if (page > pages) page = pages;

        //create inv
        Inventory particlemenu = Bukkit.createInventory(
                player,
                (rowsOnSelPage*9),
                title());

        int fromIndex = 0;
        int toIndex = 0;
        if (page == 1
                && particleItemsCount <= 21) {
            toIndex = particleItemsCount - 1;
        } else if (page > 1 && page == pages) {
            fromIndex = (page-1)*21;
            toIndex = particleItemsCount -1;
        } else {
            if (pages > 1) {
                fromIndex = (page-1)*21;
            }
            toIndex = (page*21)-1;
        }

        List<PTEParticles> selectedParticles = new ArrayList<>();
        selectedParticles.addAll(Arrays.asList(particles).subList(fromIndex, toIndex + 1));

        int indexSelectedParticles = 0;
        for (int i = 9; i < (rowsOnSelPage-1)*9; i++) {
            if (i % 9 != 0 && i % 9 != 8) {
                if (indexSelectedParticles < selectedParticles.size()) {
                    if (selectedParticles.get(indexSelectedParticles) != null) {
                        PTEParticles particle = selectedParticles.get(indexSelectedParticles);

                        boolean activatedParticles = false; //plugin.particleProvider.particlePlayers.contains(player.getUniqueId());
                        ItemStack particalEffect = new ItemBuilder(particle.material)
                                .setDisplayName(particle.title)
                                .addLoreAll(new ArrayList<>() {
                                    {
                                        add(particle.description);
                                        add((activatedParticles? Component.text("§2aactive"): Component.text("§4inactive")));
                                    }
                                })
                                .build();
                        particlemenu.setItem(i, particalEffect);

                        indexSelectedParticles++;
                    }
                }

            }
        }



        if (pages > page) {
            //set button for next page
            particlemenu.setItem((rowsOnSelPage*9)-1, new ItemBuilder(Material.ARROW).setDisplayName(Component.text("next page")).addLoreAll(List.of(Component.text((page+1)))).build());
        }
        if (page > 1) {
            //set button for last page
            particlemenu.setItem((rowsOnSelPage*9)-9, new ItemBuilder(Material.ARROW).setDisplayName(Component.text("last Page")).addLoreAll(List.of(Component.text((page-1)))).build());
        }
        if (backTo != null) {
            particlemenu.setItem(0, new ItemBuilder(Material.SPECTRAL_ARROW).build());
        }

        InventoryHelper.fillInventory(particlemenu, fillerItem);
        return particlemenu;

    }

    @Override
    public void openMenu(Player player) {
        player.openInventory(createMenu(player));
    }

    public void openMenu(Player player, int page) {
        player.openInventory(createMenu(player,null, page));
    }

    public void openMenu(Player player, IInventoryMenu backTo, int page) {
        player.openInventory(createMenu(player, backTo, page));
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
            } else if (event.getCurrentItem().getType().equals(Material.ARROW)) {
                if (event.getSlot() > event.getInventory().getSize()-10) {
                    int pageToGo = 1;
                    if (event.getCurrentItem().getItemMeta().hasLore()) {
                        String serialize = PlainTextComponentSerializer.plainText().serialize(
                                event.getCurrentItem().getItemMeta().lore().getLast()
                        );
                        try {
                            pageToGo = Integer.parseInt(serialize);
                        } catch (NumberFormatException e) {
                        }
                    }

                    openMenu((Player) event.getWhoClicked(), pageToGo);
                    event.setCancelled(true);
                } else {
                    event.setCancelled(true);
                }
            } else {
                Stream<PTEParticles> pteParticlesStream = Arrays.stream(particles).filter(particle -> particle.material.equals(event.getCurrentItem().getType()) &&
                        particle.title.equals(event.getCurrentItem().displayName()));
                if (pteParticlesStream.findAny().isPresent()) {
                    event.setCancelled(true);
                    //TODO: implement actual logic
                    PTEParticles pteParticle = pteParticlesStream.findAny().get();
                    System.out.println(pteParticle.title);
                } else {
                    event.setCancelled(true);
                    event.getWhoClicked().sendMessage("Feature not implemented " + event.getCurrentItem().getType().name());
                }
            }
        }
    }
}
