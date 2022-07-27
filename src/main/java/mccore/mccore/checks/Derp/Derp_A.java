package mccore.mccore.checks.Derp;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.HashMap;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class Derp_A implements Listener {

    public HashMap<Player, Integer> warnings = new HashMap();
    public ArrayList<Player> AC = new ArrayList();

    @EventHandler
    public void onPlayerMove (PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Location loc = p.getLocation();
        boolean b = false;
        if (loc.getPitch() > 90.0F) {
            p.teleport(new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), 90.0F));
            b = true;
        } else if (loc.getPitch() < -90.0F) {
            p.teleport(new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), -90.0F));
            b = true;
        }

        if ((b) && (!this.AC.contains(p))) {
            log("Derp A", p);
            setback(p);
        }
    }
}
