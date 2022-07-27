package mccore.mccore.checks.KillAura;

import org.bukkit.block.Block;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class KillAura_A implements Listener {
    @EventHandler
    public void KillAuraThroughWalls (EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player || e.getEntity() instanceof Animals || e.getEntity() instanceof Monster) {
            if (e.getDamager() instanceof Player) {
                Block block = ((Player) e.getDamager()).getTargetBlockExact((int) e.getDamager().getLocation().distance(e.getEntity().getLocation()));

                if (!(block == null)) {
                    log("KillAura A", (Player) e.getDamager());
                    setback((Player) e.getDamager());
                }
            }
        }
    }
}
