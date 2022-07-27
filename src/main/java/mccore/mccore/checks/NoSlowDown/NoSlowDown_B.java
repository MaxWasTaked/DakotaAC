package mccore.mccore.checks.NoSlowDown;

import mccore.mccore.mccore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class NoSlowDown_B implements Listener {
    @EventHandler
    public void NoSlowDownBlocking (PlayerMoveEvent event) {
        if (event.getPlayer().isSprinting() == true) {
            new BukkitRunnable() {
                @Override
                public void run () {
                    if (event.getPlayer().isBlocking() == true) {
                        log("NoSlowDown B", event.getPlayer());
                        setback(event.getPlayer());
                    }
                }
            }.runTaskLater(mccore.getPlugin(mccore.class), 5);
        }
    }
}
