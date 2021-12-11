package me.devtarix.jarsmp.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class MobCommands extends BukkitCommand {
    public MobCommands(String name) {
        super(name);
        this.description = "A command";
        this.setUsage("/mc");
        this.setPermission("jarsmp.player");
        this.setAliases(new ArrayList<>());
    }

    @Override
    public boolean execute(CommandSender sender, String command, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

        }

        return true;
    }

}
