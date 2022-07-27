package mccore.mccore.utils.events;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.Random;

public class BanWaves implements Listener {

    public static void ban (Player p) {
        p.kickPlayer(null);
        Bukkit.getBanList(BanList.Type.NAME).addBan(p.getDisplayName(), null, null, null);
    }

    public static int getRandom(int lower, int upper) {
        Random random = new Random();
        return random.nextInt((upper - lower) + 1) + lower;
    }

    @EventHandler
    public void playerBanLoginEvent(PlayerLoginEvent e) {
        PlayerLoginEvent.Result r = e.getResult();

        if(r == PlayerLoginEvent.Result.KICK_BANNED) {
            e.setKickMessage(ChatColor.RED + "You are permanently banned from this server!\n" + "\n" + ChatColor.WHITE + "Cheating through the use of unfair game advantages\n" + "\n" + ChatColor.GRAY + "Ban ID: #" + getRandom(100000000,999999999) + "\n" + ChatColor.GRAY + "Sharing your Ban ID may affect the processing of your appeal!");
        }
    }
}
