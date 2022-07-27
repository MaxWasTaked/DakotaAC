package mccore.mccore.checks.NoSlowDown;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class NoSlowDown_A implements Listener {
    @EventHandler
    public void NoSlowDownConsume (PlayerItemConsumeEvent event) {
        if (event.getPlayer().isSprinting() == true) {
            log("NoSlowDown A", event.getPlayer());
            setback(event.getPlayer());
        }
    }
}
