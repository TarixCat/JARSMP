package me.devtarix.jarsmp.commands;

import me.devtarix.jarsmp.util.CI;
import me.devtarix.jarsmp.util.handles.Notifs;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PositionSend implements CommandExecutor {
    Notifs n = new Notifs();
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Player target = Bukkit.getPlayer(args[0]);
            
            double blockX = player.getPlayer().getLocation().getBlockX();
            double blockY = player.getPlayer().getLocation().getBlockY();
            double blockZ = player.getPlayer().getLocation().getBlockZ();

            player.sendMessage(CI.I + "Sending coordinates to " + target);
            target.sendMessage(CI.S + "Player " + player.getName() + " X= " + blockX + " Y= " + blockY + " Z= " + blockZ + " Dimension: " + player.getWorld().toString());
        }
        else {
            n.notUser(sender);
        }
        return true;
    }
}
