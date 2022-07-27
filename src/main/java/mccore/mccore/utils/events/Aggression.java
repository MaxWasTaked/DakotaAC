package mccore.mccore.utils.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import static mccore.mccore.utils.events.SetBacks.hm;

public class Aggression implements Listener {
    public static <CheckResult, User> void log (CheckResult cr, Player pl) {
        for (Player p : Bukkit.getOnlinePlayers()) {

            Bukkit.getLogger().info("[DKS] " + pl.getDisplayName() + " failed " + cr + " " + "(vl: " + hm.get(pl) + ")");

            if (p.isOp()) {
                if (hm.get(pl) != null) {
                    p.sendMessage(ChatColor.DARK_GRAY + "[DKS] " + ChatColor.GRAY + pl.getDisplayName() + ChatColor.WHITE + " failed " + ChatColor.AQUA + cr + " " + ChatColor.WHITE + "(vl: " + hm.get(pl) + ")");
                }
            }
        }
    }
}
