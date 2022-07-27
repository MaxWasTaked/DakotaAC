package mccore.mccore.checks.NoRotateSet;

import mccore.mccore.mccore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class NoRotateSet_A implements Listener {
    @EventHandler
    public void NoRotateSet_A (PlayerJoinEvent e) {

        float Y1 = e.getPlayer().getWorld().getSpawnLocation().getYaw();
        float P1 = e.getPlayer().getWorld().getSpawnLocation().getPitch();

        new BukkitRunnable() {
            @Override
            public void run () {

                float Y2 = e.getPlayer().getLocation().getYaw();
                float P2 = e.getPlayer().getLocation().getPitch();

                if (Y1 != Y2 || P1 != P2) {
                    log("NoRotateSet A", e.getPlayer());
                    setback(e.getPlayer());
                }
            }
        }.runTaskLater(mccore.getPlugin(mccore.class), 3);
    }
}
