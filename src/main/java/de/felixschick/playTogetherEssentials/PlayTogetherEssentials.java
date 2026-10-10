package de.felixschick.playTogetherEssentials;

import de.felixschick.playTogetherEssentials.providers.MessageProvider;
import de.felixschick.playTogetherEssentials.utils.CommandRegisterHandler;
import de.felixschick.playTogetherEssentials.utils.ConfigurationHandler;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayTogetherEssentials extends JavaPlugin {

    @Getter
    public MessageProvider messageProvider;

    @Override
    public void onEnable() {
        // Plugin startup logic
        new ConfigurationHandler(this);

        this.messageProvider = new MessageProvider(this);

        CommandRegisterHandler commandRegisterHandler = new CommandRegisterHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
