package mccore.mccore.checks.Scaffold;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class Scaffold_B implements Listener {
    @EventHandler
    public void Scaffold_B (BlockPlaceEvent e) {
        if (e.getPlayer().getLocation().add(0, -1, 0).getBlock().getBlockData().getMaterial() == Material.AIR) {
            e.getPlayer().sendMessage("yes is air");
        }
    }
}
