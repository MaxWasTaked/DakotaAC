package mccore.mccore.checks.Reach;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class Reach_A implements Listener {
    @EventHandler
    public void onReach (EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player p = (Player) e.getDamager();
            Entity v = e.getEntity();
            if (p.getLocation().getX() - v.getLocation().getBlockX() >= 3.15) {
                log("Reach A", p);
                setback(p);
            }
        }
    }
}
