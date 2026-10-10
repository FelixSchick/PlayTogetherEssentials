package de.felixschick.playTogetherEssentials.utils;

import de.felixschick.playTogetherEssentials.PlayTogetherEssentials;
import de.felixschick.playTogetherEssentials.commands.PlayTogetherEssentialCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandRegisterHandler {

    private final PlayTogetherEssentials playTogetherEssentials;

    public CommandRegisterHandler(PlayTogetherEssentials _playTogetherEssentials) {
        this.playTogetherEssentials = _playTogetherEssentials;
        registerCommands();
    }

    private void registerCommands() {
        playTogetherEssentials.getCommand("playtogetheressential").setExecutor(new PlayTogetherEssentialCommand(playTogetherEssentials));
    }
}
