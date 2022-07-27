package mccore.mccore.checks.Flight;

import mccore.mccore.mccore;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class Flight_B implements Listener {
    @EventHandler
    public void Flight_B (PlayerMoveEvent e) {

        Player player = e.getPlayer();

        if(!player.getAllowFlight()) {
            if(Objects.requireNonNull(e.getTo()).getY() - e.getFrom().getY() == 0.0) {
                if (e.getPlayer().getVelocity().getY() <= -0) {
                    if (!e.getPlayer().isOnGround()) {
                        new BukkitRunnable() {
                            @Override
                            public void run () {
                                if (!e.getPlayer().isOnGround()) {
                                    Location loc = e.getPlayer().getLocation();
                                    loc.setY(loc.getY() - 1);
                                    Block block = loc.getWorld().getBlockAt(loc);

                                    if (block.getBlockData().getMaterial() == Material.AIR) {
                                        log("Flight B", e.getPlayer());
                                        setback(e.getPlayer());
                                    }
                                }
                            }
                        }.runTaskLater(mccore.getPlugin(mccore.class), 3);
                    }
                }
            }
        }
    }
}
