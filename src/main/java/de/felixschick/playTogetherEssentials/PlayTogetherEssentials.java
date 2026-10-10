package de.felixschick.playTogetherEssentials;

import de.felixschick.playTogetherEssentials.Menues.EssentialUserMenu;
import de.felixschick.playTogetherEssentials.providers.MessageProvider;
import de.felixschick.playTogetherEssentials.providers.ParticleProvider;
import de.felixschick.playTogetherEssentials.utils.CommandRegisterHandler;
import de.felixschick.playTogetherEssentials.utils.ConfigurationHandler;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.BitSet;

public final class PlayTogetherEssentials extends JavaPlugin {

    private PlayTogetherEssentials instance;

    public static PlayTogetherEssentials getInstance() {
        return getInstance();
    }

    @Getter
    public MessageProvider messageProvider;

    public ParticleProvider particleProvider;

    @Override
    public void onEnable() {
        // Plugin startup logic
        new ConfigurationHandler(this);
        this.messageProvider = new MessageProvider(this);

        this.particleProvider = new ParticleProvider(this);

        Bukkit.getPluginManager().registerEvents(new EssentialUserMenu(), this);


        CommandRegisterHandler commandRegisterHandler = new CommandRegisterHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
