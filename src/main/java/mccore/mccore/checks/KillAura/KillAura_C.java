package mccore.mccore.checks.KillAura;

import org.bukkit.entity.Animals;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class KillAura_C implements Listener {
    @EventHandler
    public void KillAuraMulti (EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player || e.getEntity() instanceof Animals || e.getEntity() instanceof Monster) {
            if (e.getDamager() instanceof Player) {
//                e.getEntity().get
            }
        }
    }
}
