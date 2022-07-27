package mccore.mccore.checks.Jesus;

import mccore.mccore.mccore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class Jesus_A implements Listener {
    @EventHandler
    public void jesus_a (PlayerMoveEvent e) {

        String liquid = e.getPlayer().getLocation().add(0,-0.5,0).getBlock().getBlockData().getMaterial().name().toLowerCase();

        new BukkitRunnable() {
            @Override
            public void run () {
                if (e.getTo().getZ() - e.getTo().getBlockZ() > 0.5 || e.getTo().getBlockZ() - e.getTo().getZ() > 0.5) {
                    if (e.getTo().getX() - e.getTo().getBlockX() > 0.5 || e.getTo().getBlockX() - e.getTo().getX() > 0.5) {
                        if (liquid.contains("water")) {
                            if (e.getPlayer().isOnGround() == true) {
                                log("Jesus A", e.getPlayer());
                                setback(e.getPlayer());
                            }
                        }
                    }
                }
            }
        }.runTaskLater(mccore.getPlugin(mccore.class), 3);
    }
}
