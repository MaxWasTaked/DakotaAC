package mccore.mccore.utils.events;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.HashMap;

import static mccore.mccore.utils.events.BanWaves.ban;

public class SetBacks implements Listener {
    public static HashMap<Player, Integer> hm = new HashMap<>();

    public static void setback (Player p) {
        if (!p.isOp()) {
            if (hm.containsKey(p)) {
                hm.put(p, hm.get(p) + 1);
            } else {
                hm.put(p, 0);
            }

            if (p.getLocation().add( 0, -0.5, 0).getBlock().getType() == Material.AIR) {
                p.teleport(p.getLocation().add(0, -0.5, 0));
            } else {
                p.teleport(p.getLocation().add(0, 0, 0));
            }

            if (hm.get(p) >= 120) {

                for (Player username : Bukkit.getOnlinePlayers()) {
                    username.playSound(username.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 100.0F, 1.0F);
                }

                Bukkit.broadcastMessage("" + ChatColor.RED + ChatColor.BOLD + "A player has been removed from your game!");
                ban(p);
                hm.remove(p);
            }
        }
    }
}
