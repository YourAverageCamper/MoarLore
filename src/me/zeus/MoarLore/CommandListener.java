
package me.zeus.MoarLore;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class CommandListener implements CommandExecutor {

    @Override
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {

        if (cmd.getName().equalsIgnoreCase("rename")) {
            if (sender instanceof Player) {
                final Player p = (Player) sender;

                if (p.hasPermission("MoarLore.rename")) {
                    final ItemStack hand = p.getItemInHand();
                    final ItemMeta meta = hand.getItemMeta();
                    //
                    //

                    if (args.length >= 1) {

                        final int startArg = 0;
                        final StringBuilder name = new StringBuilder(args[startArg]);
                        for (int i = startArg + 1; i < args.length; i++) {
                            name.append(' ').append(args[i]);
                        }
                        final String newName = name.toString();

                        if (newName.contains("&")) {
                            if (p.hasPermission("MoarLore.rename.color")) {
                                meta.setDisplayName(newName.replace("&", "§"));

                                hand.setItemMeta(meta);
                            } else {
                                p.sendMessage(ChatColor.DARK_BLUE + "[" + ChatColor.RED + ChatColor.DARK_BLUE + "] " + ChatColor.RESET
                                        + " You don't have permission to use color in your item name.");
                                return false;
                            }
                        } else {
                            meta.setDisplayName(newName);
                            hand.setItemMeta(meta);
                        }

                    }

                    //
                    //

                } else {
                    p.performCommand("donate gold");
                }
            }
        }

        return false;
    }

}
