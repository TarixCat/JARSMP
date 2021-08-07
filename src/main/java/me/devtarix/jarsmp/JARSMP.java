package me.devtarix.jarsmp;

import me.devtarix.jarsmp.commands.*;
import me.devtarix.jarsmp.util.handles.Logger;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.logging.Level;

public final class JARSMP extends JavaPlugin {
    Logger logger = new Logger();

    public static void chat(Player p, String msg) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    }

    public static void broadcastMessage(String msg) {
        for (Player players : Bukkit.getOnlinePlayers()) {
            players.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
        }
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new JARSMPListener(), this);
        System.out.println("I am ready and coming online!");
        System.out.println("<TarixCat> I am the creator of the JARSMP plugin.");

        try {
            final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");

            bukkitCommandMap.setAccessible(true);
            CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());

            commandMap.register("nametag", new NameTag("nametag"));
        } catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        if(getConfig().getBoolean("dev-enabled")) {
            System.out.println("DEV MODE IS ENABLED!");
            this.getCommand("pull").setExecutor(new Pull());
            this.getCommand("wbcalc").setExecutor(new WorldBorder());
            this.getCommand("wbreset").setExecutor(new WBReset());
            this.getCommand("datadump").setExecutor(new DataDump());
        }
        PluginManager pm = getServer().getPluginManager();



        //this.getCommand("").setExecutor(gr);
        //General CMDS
        if(getConfig().getBoolean("cmd-groups.info")) {
            this.getCommand("playerinfo").setExecutor(new PlayerInfo());
            this.getCommand("serverinfo").setExecutor(new ServerInfo());
        }
        if(getConfig().getBoolean("cmd-groups.positions")) {
            this.getCommand("posbc").setExecutor(new PositionBroadcast());
            this.getCommand("nto").setExecutor(new NetherToOver());
            this.getCommand("otn").setExecutor(new OverToNether());
        }
        if(getConfig().getBoolean("cmd-groups.cheaty")) {
            //Cheaty CMDS
            this.getCommand("ss").setExecutor(new Help());
        }
        if(getConfig().getBoolean("cmd-groups.fun")) {
            //Fun CMDS
            this.getCommand("red").setExecutor(new Red());
            this.getCommand("pigstep").setExecutor(new Pigstep());
        }
        if(getConfig().getBoolean("cmd-groups.util")) {
            //Util CMDS
            this.getCommand("camacc").setExecutor(new SpecMode());
        }
    }

    @Override
    public void onDisable() {
        logger.log(Level.INFO, "Shutting Down...");
    }
}
