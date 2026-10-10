package de.felixschick.playTogetherEssentials.providers;

import de.felixschick.playTogetherEssentials.PlayTogetherEssentials;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MessageProvider {
    private final PlayTogetherEssentials plugin;

    private final String PREFIX;

    public MessageProvider(PlayTogetherEssentials plugin) {
        this.plugin = plugin;

        this.PREFIX = plugin.getConfig().getString("prefix").replace("&", "§");
    }

    public void sendMessage(Player player, String message) {
        player.sendMessage(PREFIX +" §r§8| §r" +  message);
    }

    public void sendNoPermissionMessage(Player player) {
        sendMessage(player, "§4You don't have permission to use this action.");
    }

}
