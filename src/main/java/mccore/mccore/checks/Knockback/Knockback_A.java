package mccore.mccore.checks.Knockback;

import mccore.mccore.mccore;
import org.bukkit.Location;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class Knockback_A implements Listener {
    @EventHandler
    public void Knockback (EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player || e.getDamager() instanceof Animals || e.getDamager() instanceof Monster || e.getDamager() instanceof Projectile) {
            if (e.getEntity() instanceof Player) {
                Location loc1 = ((Player) e.getEntity()).getPlayer().getLocation();
                new BukkitRunnable() {
                    @Override
                    public void run () {
                        Location loc2 = ((Player) e.getEntity()).getPlayer().getLocation();
                        if (loc1.distance(loc2) < 0.3) {
                            log("Knockback A", (Player) e.getEntity());
                            setback((Player) e.getEntity());
                        }

                    }
                }.runTaskLater(mccore.getPlugin(mccore.class), 3);
            }
        }
    }
}
