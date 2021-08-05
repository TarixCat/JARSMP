package me.devtarix.jarsmp.commands;

import me.devtarix.jarsmp.util.CI;
import me.devtarix.jarsmp.util.handles.Notifs;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerInfo implements CommandExecutor {
    Notifs n = new Notifs();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player target = Bukkit.getPlayer(args[0]);
        String reqName = args[0];
        try {
            sender.sendMessage(CI.I + reqName);
            sender.sendMessage(CI.I + "Health: " + Math.ceil(target.getHealth()));
            sender.sendMessage(CI.I + "Food Level: " + target.getFoodLevel());
            sender.sendMessage(CI.I + "XP Level: " + target.getLevel());
            sender.sendMessage(CI.I + "Dimension: " + target.getWorld().toString());
        }
        catch(Exception e) {
            n.notFound(sender);
        }
        return true;
    }
}
