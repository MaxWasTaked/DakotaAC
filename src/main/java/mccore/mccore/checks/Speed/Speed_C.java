package mccore.mccore.checks.Speed;

import mccore.mccore.mccore;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class Speed_C implements Listener {
    @EventHandler
    public void Speed_C (PlayerMoveEvent e) {

        Location loc1 = e.getPlayer().getLocation();

        loc1.setY(0);

        new BukkitRunnable() {
            @Override
            public void run () {
                if (e.getPlayer().isOnline()) {

                    Location loc2 = e.getPlayer().getLocation();

                    loc2.setY(0);

                    if (loc1.distance(loc2) >= 1) {
                        log("Speed C", e.getPlayer());
                        setback(e.getPlayer());
                    }
                }
            }
        }.runTaskLater(mccore.getPlugin(mccore.class), 2);
    }
}
