package mccore.mccore.checks.InventoryMovement;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static mccore.mccore.utils.events.Aggression.log;
import static mccore.mccore.utils.events.SetBacks.setback;

public class InventoryMovement_A implements Listener {
    @EventHandler
    public void InventoryMovement (InventoryClickEvent event) {

        Player p = (Player) event.getWhoClicked();

        if (p.isSprinting() == true) {
            log("InventoryMovement A", p);
            setback(p);
        }

        if (p.isSneaking() == true) {
            log("InventoryMovement A", p);
            setback(p);
        }

        if (p.getVelocity().distance(p.getLocation().getDirection()) >= 1.0) {
            log("InventoryMovement A", p);
            setback(p);
        }
    }
}
