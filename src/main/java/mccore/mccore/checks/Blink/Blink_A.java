package mccore.mccore.checks.Blink;

import mccore.mccore.mccore;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class Blink_A implements Listener {
    @EventHandler
    public void Blink (PlayerMoveEvent e) {

        Location loc1 = e.getPlayer().getLocation();

        new BukkitRunnable() {
            @Override
            public void run () {

                Location loc2 = e.getPlayer().getLocation();

                if (loc1.getWorld() == loc2.getWorld()) {
                    if (loc1.distance(loc2) > 20) {
                        log("Blink A", e.getPlayer());
                        setback(e.getPlayer());
                    }
                }
            }
        }.runTaskLater(mccore.getPlugin(mccore.class), 3);
    }
}
