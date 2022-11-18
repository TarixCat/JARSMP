package me.devtarix.jarsmp.commands;

import me.devtarix.jarsmp.util.CI;
import me.devtarix.jarsmp.util.handles.Notifs;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OverToNether implements CommandExecutor {
    Notifs n = new Notifs();
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.getLocation().getWorld().getEnvironment().equals(World.Environment.NETHER)) {
                int blockX = player.getPlayer().getLocation().getBlockX();
                int blockY = player.getPlayer().getLocation().getBlockY();
                int blockZ = player.getPlayer().getLocation().getBlockZ();
                int NBlockX = blockX / 8;
                int NBlockZ = blockZ / 8;

                player.sendMessage(CI.I + "Your current coordinates translated in the Nether:");
                player.sendMessage(CI.S + "X= " + NBlockX + " Y= " + blockY + " Z= " + NBlockZ);
            } else {
                player.sendMessage(CI.W + "Please run this command in the " + CI.I + "Overworld " + CI.W + "for coordinate translation.");
            }
        }
        else {
            n.notUser(sender);
        }
        return true;
    }
}
