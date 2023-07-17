package de.vertraubarer.lobbysystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Dieser Befehl kann nur von Spielern verwendet werden.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("fly.command")) {
            player.sendMessage("§cDu hast keine Berechtigung, diesen Befehl auszuführen.");
            return true;
        }

        if (player.getAllowFlight()) {

            player.setAllowFlight(false);
            player.setFlying(false);
            player.sendMessage("Du hast den Flugmodus deaktiviert.");
        } else {

            player.setAllowFlight(true);
            player.sendMessage("Du hast den Flugmodus aktiviert.");
        }

        return true;
    }
}
