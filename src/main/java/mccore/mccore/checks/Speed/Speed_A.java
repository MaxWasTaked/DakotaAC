package mccore.mccore.checks.Speed;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class Speed_A implements Listener {
    @EventHandler
    public void Speed_A (PlayerMoveEvent event) {
        if (event.getFrom().distance(event.getTo()) >= 0.8) {
            if (event.getTo().getY() - event.getFrom().getY() > 0) {
                log("Speed A", event.getPlayer());
                setback(event.getPlayer());
            }
        }
    }
}
