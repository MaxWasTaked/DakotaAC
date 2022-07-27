package mccore.mccore.checks.ESP;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class ESP_A implements Listener {
    @EventHandler
    public void esp (PlayerMoveEvent e) {
        for (Entity ok : e.getPlayer().getNearbyEntities(20, 20, 20)){
            ok.setCustomNameVisible(false);
        }

        for (Entity ok : e.getPlayer().getNearbyEntities(10, 10, 10)){
            ok.setCustomNameVisible(true);
        }
    }
}
