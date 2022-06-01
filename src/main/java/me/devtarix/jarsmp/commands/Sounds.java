package me.devtarix.jarsmp.commands;

import me.devtarix.jarsmp.util.handles.Notifs;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Sounds implements CommandExecutor {

    private Sound run;
    Notifs n = new Notifs();
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            ((Player) sender).playSound(((Player) sender).getLocation() ,run, 150, 1);
        }
        else {
            n.notUser(sender);
        }
        return true;
    }

    public Sounds(Sound sound) {
        this.run = sound;
    }
}
