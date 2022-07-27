package mccore.mccore.checks.InventoryCleaner;

import mccore.mccore.mccore;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class InventoryCleaner_A implements Listener {
    @EventHandler
    public void InventoryCleaner (PlayerDropItemEvent e) {

        Location loc1 = e.getPlayer().getLocation();

        new BukkitRunnable() {
            @Override
            public void run () {
                if (e.getPlayer().isOnline()) {
                    Location loc2 = e.getPlayer().getLocation();

                    if (!(e.getPlayer().getInventory().getItemInMainHand().getType().equals(e.getItemDrop().getItemStack().getType()))) {
                        if (loc1.distance(loc2) > 0.5) {
                            log("InventoryCleaner A", e.getPlayer());
                            setback(e.getPlayer());
                        }
                    }
                }
            }
        }.runTaskLater(mccore.getPlugin(mccore.class), 3);
    }
}
