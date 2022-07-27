package mccore.mccore.checks.FastEat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import java.util.ArrayList;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class FastEat_A implements Listener {

    public ArrayList<Player> eating = new ArrayList();

    @EventHandler
    public void FastEat (PlayerItemConsumeEvent e) {
        Player p = e.getPlayer();
        if (this.eating.contains(p)) {
            log("FastEat A", p);
            setback(p);
        }
    }
}
