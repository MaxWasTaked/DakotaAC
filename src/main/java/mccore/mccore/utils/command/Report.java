package mccore.mccore.utils.command;

import mccore.mccore.mccore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static mccore.mccore.utils.events.BanWaves.ban;
import static mccore.mccore.utils.events.SetBacks.hm;

public class Report implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            return false;
        }

        if(args.length == 1) {
            sender.sendMessage(ChatColor.RED + "You must have two arguments! /report <player> <reason>");
            return true;
        }

        if(args.length >= 2) {
            String targetName = args[0];
            Player player = (Player) sender;
            Player target = Bukkit.getPlayer(targetName);

            if (target == null) {
                player.sendMessage(ChatColor.RED + "We're sorry this player " + targetName + " isn't online/on the same server as you");
                return true;
            }

            for (int i = 1; i < args.length; i++) {
                if (i < args.length) {
                    Integer value = hm.get(target);

                    if (value != null) {
                        if (value >= 60) {
                            new BukkitRunnable() {
                                @Override
                                public void run () {

                                    player.sendMessage(ChatColor.GREEN + "Thanks for reporting! The player you raported has been banned!");

                                    if (target.isOnline()) {

                                        ban(target);

                                    } else {

                                        player.sendMessage(ChatColor.GREEN + "Thanks for reporting! The player you raported will been banned!");

                                    }
                                }
                            }.runTaskLater(mccore.getPlugin(mccore.class), 50);
                        }
                    }
                }
            }

            player.sendMessage(ChatColor.GREEN + "Thanks for reporting this player " + targetName + " our staff and anticheat will take care from now and will be reviewed as soon as possible!");
            return true;

        }
        return false;
    }
}
