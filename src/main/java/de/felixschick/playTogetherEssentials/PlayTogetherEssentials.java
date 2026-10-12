package de.felixschick.playTogetherEssentials;

import de.felixschick.playTogetherEssentials.listeners.MenuClickListener;
import de.felixschick.playTogetherEssentials.menues.EssentialUserMenu;
import de.felixschick.playTogetherEssentials.menues.ParticleMenu;
import de.felixschick.playTogetherEssentials.providers.MessageProvider;
import de.felixschick.playTogetherEssentials.providers.ParticleProvider;
import de.felixschick.playTogetherEssentials.utils.CommandRegisterHandler;
import de.felixschick.playTogetherEssentials.utils.ConfigurationHandler;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayTogetherEssentials extends JavaPlugin {

    @Getter
    private static PlayTogetherEssentials instance;

    @Getter
    public MessageProvider messageProvider;

    @Getter
    public EssentialUserMenu essentialUserMenu;

    @Getter
    public ParticleMenu particleMenu;

    public ParticleProvider particleProvider;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        new ConfigurationHandler(this);
        this.messageProvider = new MessageProvider(this);
        this.particleProvider = new ParticleProvider(this);


        this.particleMenu = new ParticleMenu(this);
        this.essentialUserMenu = new EssentialUserMenu(this);

        Bukkit.getPluginManager().registerEvents(new MenuClickListener(this), this);


        CommandRegisterHandler commandRegisterHandler = new CommandRegisterHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
