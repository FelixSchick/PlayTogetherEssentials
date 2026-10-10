package de.felixschick.playTogetherEssentials.commands;

import de.felixschick.playTogetherEssentials.Menues.EssentialUserMenu;
import de.felixschick.playTogetherEssentials.PlayTogetherEssentials;
import de.felixschick.playTogetherEssentials.providers.MessageProvider;
import de.felixschick.playTogetherEssentials.utils.enums.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
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
                if (args.length > 0) {
                    if (args[0].equalsIgnoreCase("admin")) {
                        if (player.hasPermission("playtogetheressentials.playtogether.admin")) {
                            Inventory inventory = Bukkit.createInventory(player, 9*3, "§2Essentials Admin Menu");
                            for (int i = 0; i < inventory.getSize(); i++) {
                                inventory.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
                            }

                            if (args.length > 1) {
                                if (Bukkit.getPlayer(args[1]) != null) {
                                    Player target = Bukkit.getPlayer(args[1]);
                                    target.openInventory(inventory);
                                } else
                                    messageProvider.sendMessage(player, Messages.NO_PLAYER_FOUND);
                            } else
                                player.openInventory(inventory);
                        } else
                            messageProvider.sendMessage(player, Messages.NO_PERMISSIONS);
                    }
                } else {
                    EssentialUserMenu.openMenu(player);
                }


            } else {
                messageProvider.sendMessage(player, Messages.NO_PERMISSIONS);
            }
        }
        return false;
    }
}
