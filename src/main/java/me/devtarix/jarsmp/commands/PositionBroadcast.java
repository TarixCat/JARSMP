package me.devtarix.jarsmp.commands;

import me.devtarix.jarsmp.util.CI;
import me.devtarix.jarsmp.util.handles.Notifs;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PositionBroadcast implements CommandExecutor {
    Notifs n = new Notifs();
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            int blockX = player.getPlayer().getLocation().getBlockX();
            int blockY = player.getPlayer().getLocation().getBlockY();
            int blockZ = player.getPlayer().getLocation().getBlockZ();

            player.sendMessage(CI.I + "Broadcasting coordinates to server");
            Bukkit.getServer().broadcastMessage(CI.S + "Player " + player.getName() + " X= " + blockX + " Y= " + blockY + " Z= " + blockZ + " Dimension: " + player.getWorld().getEnvironment());
        }
        else {
            n.notUser(sender);
        }
        return true;
    }
}
