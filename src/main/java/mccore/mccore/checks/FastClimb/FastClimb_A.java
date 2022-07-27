package mccore.mccore.checks.FastClimb;

import mccore.mccore.mccore;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class FastClimb_A implements Listener {
    @EventHandler
    public void ladder (PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if((new Location (p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ()).getBlock().getBlockData().getMaterial() == Material.LADDER) && !p.isOnGround()) {

            Location loc1 = e.getPlayer().getLocation();

            new BukkitRunnable() {
                @Override
                public void run () {

                    Location loc2 = e.getPlayer().getLocation();

                    if (loc1.distance(loc2) >= 1.2) {
                        log("FastClimb A", e.getPlayer());
                        setback(e.getPlayer());
                    }
                }
            }.runTaskLater(mccore.getPlugin(mccore.class), 3);
        }
    }
}
