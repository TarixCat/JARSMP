package me.devtarix.jarsmp.commands;

import me.devtarix.jarsmp.util.CI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DataDump implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(CI.S + "Data!");
        sender.sendMessage(CI.G + "Difficulty: " + Bukkit.getWorld("world").getDifficulty());
        sender.sendMessage(CI.G + "Monster Spawn Limit: " + Bukkit.getWorld("world").getMonsterSpawnLimit());
        sender.sendMessage(CI.G + "Ambient Spawn Limit: " + Bukkit.getWorld("world").getAmbientSpawnLimit());
        sender.sendMessage(CI.G + "Animal Spawn Limit: " + Bukkit.getWorld("world").getAnimalSpawnLimit());
        sender.sendMessage(CI.G + "Gamerules: " + Bukkit.getWorld("world").getGameRules());
        return true;
    }
}
