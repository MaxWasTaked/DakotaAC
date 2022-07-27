package mccore.mccore.checks.Phase;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class Phase_A implements Listener {
    @EventHandler
    public void Phase (PlayerMoveEvent e) {

        Block block = e.getPlayer().getLocation().getBlock();

        if (block.getType().isSolid()) {

            Block above = e.getPlayer().getEyeLocation().add(0,0,0).getBlock();

            if(above.getBlockData().getMaterial() != Material.AIR) {
                log("Phase A", e.getPlayer());
                setback(e.getPlayer());
            }
        }
    }
}
