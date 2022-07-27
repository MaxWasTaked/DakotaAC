package mccore.mccore.checks.Speed;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class Speed_B implements Listener {
    @EventHandler
    public void Speed_B (PlayerMoveEvent e) {
        if (e.getFrom().distance(e.getTo()) >= 0.8) {
            if (e.getTo().getY() - e.getFrom().getY() >= 0) {
                log("Speed B", e.getPlayer());
                setback(e.getPlayer());
            }
        }
    }
}
