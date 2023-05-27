package me.devtarix.jarsmp.util.handles;

import me.devtarix.jarsmp.util.CI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Used to send players standard notifications
 * Interpreting this class is simple
 */

//TODO: Put the CI interface in here
public class Notifs {
    Player user;
    CommandSender sender;

    public void noBedFound(Player user) {
        this.user = user;

        user.sendMessage(CI.E + "Bed not found. Teleported to world spawn(ish)");
    }

    public void notUser(CommandSender sender) {
        this.sender = sender;

        sender.sendMessage(CI.E + "You must be a player to run this command");
    }

    public void notFound(CommandSender sender) {
        this.sender = sender;

        sender.sendMessage(CI.E + "Player was not found/isn't online");
    }

    public void criticalError(CommandSender sender) {
        this.sender = sender;

        sender.sendMessage(CI.E + "A critical error has been enountered. It's fine, Probably just shitty coding... :P");
        sender.sendMessage(CI.E + "-TarixCat");
    }

    public void missingargs(CommandSender sender, int argslength, String cmd ,String msg) {
        this.sender = sender;

        sender.sendMessage(CI.I + "You are missing args. The args should be " + argslength + " and they should be in the format /" + cmd + " " + msg +".");
    }
    public void currentlyrunning(CommandSender sender, boolean mode) {
        this.sender = sender;

        sender.sendMessage(CI.E + "The command you are currently running is already running as " + mode);
    }
}
