package mccore.mccore.checks.FastPlace;

import mccore.mccore.mccore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class FastPlace_A implements Listener {

    int delay;

    @EventHandler
    public void FastPlace_A (BlockPlaceEvent e) {

        delay++;

        new BukkitRunnable() {
            @Override
            public void run () {
//                e.getPlayer().sendMessage("You placed " + delay + " per 3 ticks!");
                delay = 0;
            }
        }.runTaskLater(mccore.getPlugin(mccore.class), 3);
    }
}
