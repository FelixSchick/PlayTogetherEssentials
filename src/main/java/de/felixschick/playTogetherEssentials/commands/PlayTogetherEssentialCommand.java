package de.felixschick.playTogetherEssentials.commands;

import de.felixschick.playTogetherEssentials.PlayTogetherEssentials;
import de.felixschick.playTogetherEssentials.providers.MessageProvider;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlayTogetherEssentialCommand implements CommandExecutor {

    private final MessageProvider messageProvider;

    public PlayTogetherEssentialCommand(PlayTogetherEssentials plugin) {

        this.messageProvider = plugin.messageProvider;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("playtogetheressentials.playtogether")) {

            } else {
                messageProvider.sendNoPermissionMessage(player);
            }
        }
        return false;
    }
}
