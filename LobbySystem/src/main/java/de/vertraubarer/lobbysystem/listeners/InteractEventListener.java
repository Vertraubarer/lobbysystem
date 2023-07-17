package de.vertraubarer.lobbysystem.listeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InteractEventListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction().toString().contains("RIGHT")) {
            if (player.getItemInHand().getType() == Material.RECOVERY_COMPASS &&
                player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.DARK_AQUA + "Games")) {
                openGamesGUI(player);
            }
        }
    }

    private void openGamesGUI(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, ChatColor.DARK_AQUA + "Games");

        ItemStack citybuildItem = new ItemStack(Material.BAMBOO);
        ItemMeta citybuildMeta = citybuildItem.getItemMeta();
        citybuildMeta.setDisplayName("§eCityBuild");
        citybuildItem.setItemMeta(citybuildMeta);
        gui.setItem(11, citybuildItem);

        ItemStack survivalItem = new ItemStack(Material.PAPER);
        ItemMeta survivalMeta = survivalItem.getItemMeta();
        survivalMeta.setDisplayName("§cSurvival");
        survivalItem.setItemMeta(survivalMeta);
        gui.setItem(15, survivalItem);

        player.openInventory(gui);
    }
}
