package mccore.mccore.checks.Critical;

import com.google.common.collect.Sets;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class Critical_B implements Listener {
    private final Set<UUID> prevPlayersOnGround = Sets.newHashSet();

    private boolean PlayerJumped;

    @EventHandler
    public void playerJump (PlayerMoveEvent e) {

        Player player = e.getPlayer();

        if (player.getVelocity().getY() <= 0) {
            PlayerJumped = false;
            prevPlayersOnGround.clear();
            player.sendMessage();
        }

        if (player.getVelocity().getY() > 0) {
            double jumpVelocity = 0.42F;
            if (player.hasPotionEffect(PotionEffectType.JUMP)) {
                jumpVelocity += (float) (Objects.requireNonNull(player.getPotionEffect(PotionEffectType.JUMP)).getAmplifier() + 1) * 0.1F;
            }
            if (e.getPlayer().getLocation().getBlock().getType() != Material.LADDER && prevPlayersOnGround.contains(player.getUniqueId())) {
                if (!player.isOnGround() && Double.compare(player.getVelocity().getY(), jumpVelocity) == 0) {
                    PlayerJumped = true;
                }
            }
        }

        if (player.isOnGround()) {
            prevPlayersOnGround.add(player.getUniqueId());
        } else {
            prevPlayersOnGround.remove(player.getUniqueId());
        }
    }

    @EventHandler
    public void Critical_B (EntityDamageByEntityEvent e) {

        if (!(e.getDamager() instanceof Player) || e.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
            return;
        }

        final Player player = (Player) e.getDamager();

        if ((player.getLocation().getY() % 1.0 == 0 || player.getLocation().getY() % 0.5 == 0) && player.getLocation().clone().subtract(0, 1.0, 0).getBlock().getType().isSolid()) {
            if (!PlayerJumped) {
                if (player.isOnGround()) {
                    log("Critical B", player);
                    setback(player);
                }
            }
        }
    }
}
