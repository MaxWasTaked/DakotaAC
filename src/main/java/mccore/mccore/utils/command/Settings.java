package mccore.mccore.utils.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static mccore.mccore.utils.events.SetBacks.hm;

public class Settings implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (cmd.getName().equalsIgnoreCase("dks_settings")) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("vlreset")) {
                        hm.put(((Player) sender).getPlayer(), 0);
                        sender.sendMessage(ChatColor.DARK_GRAY + "[DKS] " + ChatColor.GREEN + "Your VL has been reset!");
                        return true;
                    }
                }
            }

            if (cmd.getName().equalsIgnoreCase("dks_settings")) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("BanWaves")) {
                        sender.sendMessage(ChatColor.DARK_GRAY + "[DKS] " + ChatColor.GRAY + "This command is in development!");
                        return true;
                    }
                }
            }

            if (cmd.getName().equalsIgnoreCase("dks_settings")) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("kick")) {
                        sender.sendMessage(ChatColor.DARK_GRAY + "[DKS] " + ChatColor.GRAY + "This command is in development!");
                        return true;
                    }
                }
            }

            if (cmd.getName().equalsIgnoreCase("dks_settings")) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("ignore")) {
                        sender.sendMessage(ChatColor.DARK_GRAY + "[DKS] " + ChatColor.GRAY + "This command is in development!");
                        return true;
                    }
                }
            }
        }

        sender.sendMessage(ChatColor.RED + "The DakotaAC commands are: ");
        sender.sendMessage(ChatColor.RED + " ");
        sender.sendMessage(ChatColor.GRAY + " /dks_settings vlreset");
        sender.sendMessage(ChatColor.GRAY + " /dks_settings BanWaves");
        sender.sendMessage(ChatColor.GRAY + " /dks_settings kick");
        sender.sendMessage(ChatColor.GRAY + " /dks_settings ignore");

        return true;
    }
}
