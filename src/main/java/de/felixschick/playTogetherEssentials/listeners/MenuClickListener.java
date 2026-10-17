package de.felixschick.playTogetherEssentials.listeners;

import de.felixschick.playTogetherEssentials.PlayTogetherEssentials;
import de.felixschick.playTogetherEssentials.menues.IInventoryMenu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ServiceLoader;
import java.util.Set;

public class MenuClickListener implements Listener {

    private PlayTogetherEssentials plugin;

    public MenuClickListener(PlayTogetherEssentials plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        Reflections reflections = new Reflections("de.felixschick");
        Set<Class<? extends IInventoryMenu>> classesImplementingIIInventoryMenu = reflections.getSubTypesOf(IInventoryMenu.class);

        for (Class<? extends IInventoryMenu> k : classesImplementingIIInventoryMenu) {
            IInventoryMenu menu = null;
            try {
                menu = k.getDeclaredConstructor(PlayTogetherEssentials.class).newInstance(plugin);
                if(event.getView().title().equals(menu.title())) menu.onInventoryClick(event);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                event.setCancelled(true);
                plugin.getLogger().warning("Error while trying to instantiate in MenuClickListener" + k.getSimpleName());
                throw new RuntimeException(e);
            }

        }

    }
}
