package mccore.mccore.checks.Teleport;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class Teleport_A implements Listener {
    @EventHandler
    public void Teleport (PlayerTeleportEvent e) {
        if (e.getEventName() == null) {
            log("Teleport A", e.getPlayer());
            setback(e.getPlayer());
        }
    }
}
