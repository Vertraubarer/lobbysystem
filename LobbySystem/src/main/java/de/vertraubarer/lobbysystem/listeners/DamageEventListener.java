package de.vertraubarer.lobbysystem.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageEventListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent event) {

        Player victim = (Player) event.getEntity();

        if (victim instanceof Player) {
            event.setCancelled(true);
        }
    }
}
