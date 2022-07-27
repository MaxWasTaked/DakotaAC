package mccore.mccore.checks.Flight;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.HashMap;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class Flight_A implements Listener {

    public ArrayList<Player> inAir = new ArrayList();
    public HashMap<Player, Location> origin = new HashMap();

    @EventHandler
    public void Flight_A (PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Location loc = p.getLocation();
        World w = loc.getWorld();
        Block under = w.getBlockAt(new Location(w, loc.getBlockX(), loc.getBlockY() - 1, loc.getBlockZ()));
        Block under2 = w.getBlockAt(new Location(w, loc.getBlockX(), loc.getBlockY() - 2, loc.getBlockZ()));
        if ((under.getType() == Material.AIR) && (under2.getType() == Material.AIR))
        {
            if (!this.inAir.contains(p))
            {
                this.inAir.add(p);
                if (!this.origin.containsKey(p)) {
                    this.origin.put(p, loc);
                }
            }
            if ((((Location)this.origin.get(p)).distance(loc) >= 4.0D) && (((Location)this.origin.get(p)).getY() <= loc.getY())) {
                log("Flight A", e.getPlayer());
                setback(e.getPlayer());
            }
        }
        else if (this.inAir.contains(p))
        {
            this.inAir.remove(p);
            this.origin.remove(p);
        }
    }
}
