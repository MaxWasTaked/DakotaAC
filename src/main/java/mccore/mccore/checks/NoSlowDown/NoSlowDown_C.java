package mccore.mccore.checks.NoSlowDown;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class NoSlowDown_C implements Listener {
    @EventHandler
    public void NoSlowDownCobweb (PlayerMoveEvent event) {

        Location loc = event.getPlayer().getLocation();
        loc.setY(loc.getY() + 1);
        Block block = loc.getWorld().getBlockAt(loc);

        if (block.getBlockData().getMaterial() == Material.COBWEB) {
            if (event.getFrom().distance(event.getTo()) > 0.12) {
                log("NoSlowDown C", event.getPlayer());
                setback(event.getPlayer());
            }
        }
    }
}
