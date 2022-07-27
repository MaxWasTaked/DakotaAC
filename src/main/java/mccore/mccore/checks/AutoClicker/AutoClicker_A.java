package mccore.mccore.checks.AutoClicker;

import mccore.mccore.mccore;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class AutoClicker_A implements Listener {

    public static HashMap<Player, Integer> cps = new HashMap<>();

    @EventHandler
    public void onClick (PlayerInteractEvent e) {
        if (cps.get(e.getPlayer()) != null) {
            cps.put(e.getPlayer(), cps.get(e.getPlayer()) + 1);
        } else {
            cps.put(e.getPlayer(), 0);
        }

        new BukkitRunnable() {
            @Override
            public void run () {
                if (cps.get(e.getPlayer()) != 0) {
                    if (cps.get(e.getPlayer()) > 20) {
                        log("AutoClicker A", e.getPlayer());
                        setback(e.getPlayer());
                    }
                    cps.put(e.getPlayer(), 0);
                }
            }
        }.runTaskTimer(mccore.getPlugin(mccore.class), 10, 10000);

    }
}
