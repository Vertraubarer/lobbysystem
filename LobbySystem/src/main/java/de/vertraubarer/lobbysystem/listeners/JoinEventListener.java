package de.vertraubarer.lobbysystem.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinEventListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        event.setJoinMessage(ChatColor.GREEN + player.getName() + " §7joined.");

        player.setGameMode(GameMode.ADVENTURE);
        player.getInventory().clear();

        ItemStack serverSwitchItem = new ItemStack(Material.RECOVERY_COMPASS);
        ItemMeta serverSwitchMeta = serverSwitchItem.getItemMeta();
        serverSwitchMeta.setDisplayName("§3Games");
        serverSwitchItem.setItemMeta(serverSwitchMeta);

        player.getInventory().setItem(4, serverSwitchItem);

        ItemStack infoItem = new ItemStack(Material.BOOK);
        ItemMeta infoMeta = infoItem.getItemMeta();
        infoMeta.setDisplayName("§bInfo");
        infoItem.setItemMeta(infoMeta);

        player.getInventory().setItem(0, infoItem);
    }
}
