package mccore.mccore.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Information implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("");
        sender.sendMessage(ChatColor.RED + "The build version is: " + ChatColor.GRAY + "DakotaAC v2.13");
        sender.sendMessage(ChatColor.GRAY + "This project is made by MaxWasTaked (AKA Yonaga678)!");
        sender.sendMessage("");
        return true;
    }
}
