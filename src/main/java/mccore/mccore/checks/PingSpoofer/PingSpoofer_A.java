package mccore.mccore.player;

import mccore.mccore.mccore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class PingSpoofer_A implements Listener {
    public static int getPing (Player p) {
        String v = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
        if (!p.getClass().getName().equals("org.bukkit.craftbukkit." + v + ".entity.CraftPlayer")) { //compatibility with some plugins
            p = Bukkit.getPlayer(p.getUniqueId()); //cast to org.bukkit.entity.Player
        }
        try {
            int ping = p.getPing();
            return ping;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @EventHandler
    public void PingSpoofer (PlayerJoinEvent event) {

        int ping1 = getPing(event.getPlayer());

        new BukkitRunnable() {
            @Override
            public void run () {

                int ping2 = getPing(event.getPlayer());

                if (ping1 != ping2) {
                    log("PingSpoofer A", event.getPlayer());
                    setback(event.getPlayer());
                }

            }
        }.runTaskLater(mccore.getPlugin(mccore.class), 50);

    }
}
