package mccore.mccore.checks.AntiBot;

import mccore.mccore.mccore;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.trait.trait.Equipment;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class AntiBot_A implements Listener {

    private static final HashMap<Player, NPC> list = new HashMap<Player, NPC>();

    // This methode is to destroy the bot when the player quit
    @EventHandler
    public void onLeftBotDestory (PlayerQuitEvent e) {

        Player p = e.getPlayer();
        NPC npc = list.get(p);

        if (!(npc == null)) {
            npc.destroy();
        }
    }

    // This methode is to move the bot to the player
    @EventHandler
    public void onMoveBotTeleport (PlayerMoveEvent e) {

        Location Entity = e.getPlayer().getLocation().add(e.getPlayer().getLocation().getDirection().multiply(-3.5));

        Player p = e.getPlayer();
        NPC npc = list.get(p);

        if (npc != null) {

            for (Player user : Bukkit.getOnlinePlayers()) {
                if (user != p) {
                    if (p.isOnline()) {
                        if (npc.getEntity() != null) {
                            user.hidePlayer(mccore.getPlugin(mccore.class), (Player) npc.getEntity());
                        }
                    }
                }
            }

            npc.teleport(Entity, PlayerTeleportEvent.TeleportCause.COMMAND);
        }
    }

    // This methode hide the player or show when the player hit another player
    @EventHandler
    public void PlayerShowEntity (EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player || e.getEntity() instanceof Animals || e.getEntity() instanceof Monster) {
            if (e.getDamager() instanceof Player) {

                Player p = (Player) e.getDamager();
                NPC npc = list.get(p);

                if (npc != null) {
                    final boolean[] show = {false};

                    if (show[0] == false) {
                        if (p.isOnline()) {
                            p.showPlayer(mccore.getPlugin(mccore.class), (Player) npc.getEntity());
                            show[0] = true;
                        }
                    }

                    if (show[0] == true) {
                        new BukkitRunnable() {
                            @Override
                            public void run () {
                                for (Player user : Bukkit.getOnlinePlayers()) {
                                    if (p.isOnline()) {
                                        if (npc.getEntity() != null) {
                                            user.hidePlayer(mccore.getPlugin(mccore.class), (Player) npc.getEntity());
                                        }

                                        show[0] = false;
                                        npc.destroy();

                                        list.remove(p, npc);
                                    }
                                }
                            }
                        }.runTaskLater(mccore.getPlugin(mccore.class), 1520);
                    }
                } else {
                    checkbot(p);
                }
            }
        }
    }

    // This methode send an Aggression to the staff
    @EventHandler
    public void onDamageBotAlert (EntityDamageByEntityEvent e) {

        Entity damager = e.getDamager();
        Entity victom = e.getEntity();

        if (damager instanceof Player && victom instanceof Player) {
            Player pl = (Player) damager;
            if (!(victom.getCustomName() == null)) {
                if (victom.getCustomName().equalsIgnoreCase(list.get(pl).getName())) {
                    log("AntiBot A", pl);
                    setback(pl);
                }
            }
        }
    }

    public static NPC npc;

    public static void checkbot (Player p) {
        ArrayList<String> allPlayers = new ArrayList<String>();

        for(Player players : Bukkit.getOnlinePlayers()) {
            allPlayers.add(players.getDisplayName());
        }

        int index = new Random().nextInt(allPlayers.size());

        Object picked = allPlayers.get(index);

        npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, String.valueOf(picked));

        npc.spawn(p.getLocation().add(0, 50, 0));
        npc.getEntity().setGravity(false);

        for (Player user : Bukkit.getOnlinePlayers()) {
            if (p.isOnline()) {
                user.hidePlayer(mccore.getPlugin(mccore.class), (Player) npc.getEntity());
            }
        }

        list.put(p, npc);

        Equipment equipTrait = npc.getTrait(Equipment.class);

        equipTrait.set(0, new ItemStack(Material.DIAMOND_SWORD, 1));
        equipTrait.set(1, new ItemStack(Material.LEATHER_HELMET, 5));
        equipTrait.set(2, new ItemStack(Material.LEATHER_CHESTPLATE, 3));
        equipTrait.set(3, new ItemStack(Material.LEATHER_LEGGINGS, 8));
        equipTrait.set(4, new ItemStack(Material.LEATHER_BOOTS, 6));

        npc.addTrait(equipTrait);
    }
}
