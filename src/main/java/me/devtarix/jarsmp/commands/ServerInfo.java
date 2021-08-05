package me.devtarix.jarsmp.commands;

import me.devtarix.jarsmp.util.CI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ServerInfo implements CommandExecutor {
    //Command Imported Before 11/20/2020 9:59 PM
    //Command Changed 11/20/2020 10:37 PM
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(CI.S + "Server Info:");
        sender.sendMessage(CI.G + "End Enabled: " + Bukkit.getAllowEnd());
        sender.sendMessage(CI.G + "Nether Enabled: " + Bukkit.getAllowNether());
        sender.sendMessage(CI.G + "Server Version: " + Bukkit.getServer().getVersion());
        sender.sendMessage(CI.G + "Server View Distance: " + Bukkit.getServer().getViewDistance());
        sender.sendMessage(CI.G + "Spawn Radius: " + Bukkit.getServer().getSpawnRadius());
        sender.sendMessage(CI.G + "Default Gamemode: " + Bukkit.getServer().getDefaultGameMode());
        sender.sendMessage(CI.G + "Generate Structures: " + Bukkit.getServer().getGenerateStructures());
        return true;
    }
}
