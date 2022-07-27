package mccore.mccore.checks.KillAura;

import org.bukkit.entity.Animals;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class KillAura_B implements Listener {
    @EventHandler
    public void KillAuraSwitch (EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player || e.getEntity() instanceof Animals || e.getEntity() instanceof Monster) {
            if (e.getDamager() instanceof Player) {
//                e.getEntity().get
            }
        }
    }
}
