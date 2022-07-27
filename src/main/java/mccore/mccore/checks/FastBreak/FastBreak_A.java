package mccore.mccore.checks.FastBreak;

import mccore.mccore.mccore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class FastBreak_A implements Listener {
    int delay;

    @EventHandler
    public void FastBreak_A (BlockPlaceEvent e) {

        delay++;

        new BukkitRunnable() {
            @Override
            public void run () {
//                e.getPlayer().sendMessage("You braked " + delay + " per 3 ticks!");
                delay = 0;
            }
        }.runTaskLater(mccore.getPlugin(mccore.class), 3);
    }
}
