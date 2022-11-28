package me.devtarix.jarsmp.commands;

import me.devtarix.jarsmp.util.CI;
import me.devtarix.jarsmp.util.handles.Notifs;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NetherToOver implements CommandExecutor {
    Notifs n = new Notifs();
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.getWorld().getName().equals("world_nether")) {
                int blockX = player.getPlayer().getLocation().getBlockX();
                int blockY = player.getPlayer().getLocation().getBlockY();
                int blockZ = player.getPlayer().getLocation().getBlockZ();
                int NBlockX = blockX * 8;
                int NBlockZ = blockZ * 8;

                player.sendMessage(CI.I + "Your current coordinates translated in the Overworld:");
                player.sendMessage(CI.S + "X= " + NBlockX + " Y= " + blockY + " Z= " + NBlockZ);
            } else {
                player.sendMessage(CI.W + "Please run this command in the " + CI.E + "Nether " + CI.W + "for coordinate translation.");
            }
        } else {
            n.notUser(sender);
        }
        return true;
    }
}
