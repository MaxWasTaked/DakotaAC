package mccore.mccore.checks.NoFall;

import mccore.mccore.mccore;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class NoFall_A implements Listener {

    private double inair = 0;
    private double onground = 0;

    private String world;

    @EventHandler
    public void NoFall (PlayerMoveEvent event) {

        if (event.getTo().getY() - event.getFrom().getY() == 0.0) {
            onground = event.getPlayer().getHealth();

            world = event.getPlayer().getWorld().getName();
        }

        if (event.getTo().getY() - event.getFrom().getY() <= -0.8) {
            onground = 0;
            inair = event.getPlayer().getHealth();

            world = event.getPlayer().getWorld().getName();
        }

        if (inair == onground) {

            inair = 0;
            onground = 0;

            if (!(event.getPlayer().getPreviousGameMode() == GameMode.CREATIVE || event.getPlayer().getPreviousGameMode() == GameMode.SPECTATOR)) {
                if (!(event.getPlayer().isFlying())) {

                    Block block = event.getPlayer().getLocation().add(0,0,0).getBlock();

                    new BukkitRunnable() {
                        @Override
                        public void run () {
                            if (block.getType() == Material.AIR) {
                                if (event.getPlayer().getWorld().getName().equals(world)) {
                                    log("NoFall A", event.getPlayer());
                                    setback(event.getPlayer());
                                }
                            }
                        }
                    }.runTaskLater(mccore.getPlugin(mccore.class), 3);
                }
            }
        }
    }
}
