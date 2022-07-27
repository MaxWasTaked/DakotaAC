package mccore.mccore.checks.Scaffold;

import mccore.mccore.mccore;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class Scaffold_A implements Listener {
    @EventHandler
    public void Scaffold_A (BlockPlaceEvent e) {

        Location loc1 = e.getPlayer().getLocation();

        new BukkitRunnable() {
            @Override
            public void run () {

                Location loc2 = e.getPlayer().getLocation();

                if (e.getBlock().getLocation().distance(e.getPlayer().getLocation()) < 1.8) {
                    if (loc1.distance(loc2) > 0.6) {
                        log("Scaffold A", e.getPlayer());
                        setback(e.getPlayer());
                    }
                }
            }
        }.runTaskLater(mccore.getPlugin(mccore.class), 3);
    }
}
