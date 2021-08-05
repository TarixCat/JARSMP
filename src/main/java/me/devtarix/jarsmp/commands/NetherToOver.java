package me.devtarix.jarsmp.commands;

import me.devtarix.jarsmp.util.CI;
import me.devtarix.jarsmp.util.handles.Notifs;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NetherToOver implements CommandExecutor {
    Notifs n = new Notifs();
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            double blockX = player.getPlayer().getLocation().getBlockX();
            double blockY = player.getPlayer().getLocation().getBlockY();
            double blockZ = player.getPlayer().getLocation().getBlockZ();
            double NBlockX = blockX * 8;
            double NBlockZ = blockZ * 8;

            player.sendMessage(CI.W + "This command does not check what dimension you are in. Run this command in the " + CI.E + "Nether");
            player.sendMessage(CI.I + "Your current coordinates translated in the Overworld:");
            player.sendMessage(CI.S + "X= " + NBlockX + " Y= " + blockY + " Z= " + NBlockZ);
        }
        else {
            n.notUser(sender);
        }
        return true;
    }
}
