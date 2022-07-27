package mccore.mccore.checks.Step;

import mccore.mccore.mccore;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class Step_A implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {

        Location from = e.getFrom();
        Location to = e.getTo();
        Player player = e.getPlayer();

        String block = e.getPlayer().getLocation().getBlock().getBlockData().getMaterial().name();

        new BukkitRunnable() {
            @Override
            public void run () {
                if (from.getBlockY() < to.getBlockY() && !player.isSwimming() && !player.isFlying()) {
                    if (!(block.contains("SLAB")) && !(block.contains("STAIRS"))) {
                        if (player.isOnGround() == true) {
                            log("Step A", e.getPlayer());
                            setback(e.getPlayer());
                        }
                    }
                }
            }
        }.runTaskLater(mccore.getPlugin(mccore.class), 3);
    }
}
