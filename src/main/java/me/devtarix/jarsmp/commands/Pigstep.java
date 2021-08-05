package me.devtarix.jarsmp.commands;

import me.devtarix.jarsmp.util.handles.Notifs;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Pigstep implements CommandExecutor {
    Notifs n = new Notifs();
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            ((Player) sender).playSound(((Player) sender).getLocation() ,Sound.MUSIC_DISC_PIGSTEP, 150, 1);
        }
        else {
            n.notUser(sender);
        }
        return true;
    }
}
