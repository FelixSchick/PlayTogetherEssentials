package de.felixschick.playTogetherEssentials.providers;

import de.felixschick.playTogetherEssentials.PlayTogetherEssentials;
import de.felixschick.playTogetherEssentials.utils.enums.Messages;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MessageProvider {
    private final PlayTogetherEssentials plugin;

    @Getter
    private final String PREFIX;

    public MessageProvider(PlayTogetherEssentials plugin) {
        this.plugin = plugin;

        this.PREFIX = plugin.getConfig().getString("prefix").replace("&", "§");
    }

    public void sendMessage(Player player, String message) {
        player.sendMessage(PREFIX +" §r§8| §r" +  message);
    }

    public void sendMessage(Player player, Messages message) {
        player.sendMessage(PREFIX +" §r§8| §r" +  message.message);
    }

}
