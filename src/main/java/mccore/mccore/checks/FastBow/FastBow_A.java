package mccore.mccore.checks.FastBow;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

import java.util.ArrayList;
import java.util.HashMap;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class FastBow_A implements Listener {
    public ArrayList<Player> drawing = new ArrayList();
    public HashMap<Player, Integer> warnings = new HashMap();
    public ArrayList<Player> AC = new ArrayList();

    @EventHandler
    public void shootBow(EntityShootBowEvent e) {
        if ((e.getEntity() instanceof Player))
        {
            Player p = (Player)e.getEntity();
            if ((this.drawing.contains(p)) && (e.getForce() == 1.0D))
            {
                e.setCancelled(true);
                if (!this.AC.contains(p))
                {
                    if (!this.warnings.containsKey(p))
                    {
                        this.warnings.put(p, Integer.valueOf(1));
                    }
                    else
                    {
                        int curWarnings = ((Integer)this.warnings.get(p)).intValue();
                        this.warnings.remove(p);
                        this.warnings.put(p, Integer.valueOf(curWarnings + 1));
                    }

                    log("FastBow A", p);
                    setback(p);

                }
            }
        }
    }
}
