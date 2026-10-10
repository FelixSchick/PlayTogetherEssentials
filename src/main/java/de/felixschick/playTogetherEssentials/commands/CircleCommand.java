package de.felixschick.playTogetherEssentials.commands;

import de.felixschick.playTogetherEssentials.PlayTogetherEssentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CircleCommand implements CommandExecutor, TabCompleter {

    private PlayTogetherEssentials playTogetherEssentials;
    public CircleCommand(PlayTogetherEssentials playTogetherEssentials) {
        this.playTogetherEssentials = playTogetherEssentials;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0) {

            } else
                playTogetherEssentials.messageProvider.sendMessage(player, "Please use /circle add/remove");

            playTogetherEssentials.particleProvider.addPlayer(player);
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        return List.of();
    }
}
