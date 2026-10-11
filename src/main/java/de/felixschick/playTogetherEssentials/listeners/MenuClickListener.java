package de.felixschick.playTogetherEssentials.listeners;

import de.felixschick.playTogetherEssentials.menues.IInventoryMenu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class MenuClickListener implements Listener {
    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        event.getWhoClicked().sendMessage("t1");
        Reflections reflections = new Reflections("de.felixschick");
        Set<Class<? extends IInventoryMenu>> classesImplementingIIInventoryMenu = reflections.getSubTypesOf(IInventoryMenu.class);
        event.getWhoClicked().sendMessage(classesImplementingIIInventoryMenu.isEmpty() + "");


        for (Class<? extends IInventoryMenu> classImplementingInterface : classesImplementingIIInventoryMenu) {
            IInventoryMenu instance = null;
            try {
                instance = classImplementingInterface.getConstructor().newInstance();
                event.getWhoClicked().sendMessage(instance.title());
                if(event.getView().title().equals(instance.title())) instance.onInventoryClick(event);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
