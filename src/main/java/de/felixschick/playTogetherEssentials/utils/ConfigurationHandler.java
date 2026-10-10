package de.felixschick.playTogetherEssentials.utils;

import lombok.Getter;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class ConfigurationHandler {

    private File configF;
    private final JavaPlugin PLUGIN;
    @Getter
    public FileConfiguration config;

    public ConfigurationHandler(JavaPlugin plugin) {
        this.PLUGIN = plugin;

        createFiles();
    }

    public void createFiles() {
        configF = new File(PLUGIN.getDataFolder(), "config.yml");
        if (!configF.exists()) {
            configF.getParentFile().mkdirs();
            PLUGIN.saveResource("config.yml", false);
        }
        config = new YamlConfiguration();
        try {
            config.load(configF);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

}
