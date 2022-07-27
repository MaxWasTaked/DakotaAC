package mccore.mccore.checks.Freecam;

import mccore.mccore.mccore;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class Freecam_A implements Listener {
    @EventHandler
    public void freecam (PlayerMoveEvent e) {

        Location loc1 = e.getPlayer().getLocation();

        new BukkitRunnable() {
            @Override
            public void run () {
                Location loc2 = e.getPlayer().getLocation();
                if (loc1 == loc2) {
                    if (e.getPlayer().isSprinting()) {
                        log("Freecam A", e.getPlayer());
                        setback(e.getPlayer());
                    }
                }
            }
        }.runTaskLater(mccore.getPlugin(mccore.class), 3);
    }
}
