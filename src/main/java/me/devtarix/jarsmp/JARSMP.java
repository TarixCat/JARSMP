package me.devtarix.jarsmp;

import me.devtarix.jarsmp.commands.*;
import me.devtarix.jarsmp.registries.ShapedRecipeProvider;
import me.devtarix.jarsmp.util.handles.Logger;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.command.CommandMap;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.logging.Level;

public final class JARSMP extends JavaPlugin {
    public static HashSet<Player> online = new HashSet<>();

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
        System.out.println("[Server] I am ready and coming online!");
        System.out.println("<TarixCat> I am the creator of the JARSMP plugin.");

        //Legacy Command Boot
        try {
            final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");

            bukkitCommandMap.setAccessible(true);
            CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());

            if (getConfig().getBoolean("cmd-groups.cheaty")) {
                commandMap.register("tag", new NameTag("tag"));
            }
            if (getConfig().getBoolean("dev-enabled")) {
                commandMap.register("giveitem", new GiveItem("giveitem"));
            }
        } catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        //Modern Command Boot
        if(getConfig().getBoolean("dev-enabled")) {
            System.out.println("DEV MODE IS ENABLED!");
            this.getCommand("pull").setExecutor(new Pull());
            this.getCommand("wbcalc").setExecutor(new WorldBorder());
            this.getCommand("wbreset").setExecutor(new WBReset());
        }
        PluginManager pm = getServer().getPluginManager();



        //this.getCommand("").setExecutor(gr);
        //General CMDS

        this.getCommand("playerinfo").setExecutor(new PlayerInfo());
        this.getCommand("posbc").setExecutor(new PositionBroadcast());
        this.getCommand("possend").setExecutor(new PositionSend());
        this.getCommand("serverinfo").setExecutor(new ServerInfo());
		this.getCommand("nto").setExecutor(new NetherToOver());
		this.getCommand("otn").setExecutor(new OverToNether());
		this.getCommand("info2").setExecutor(new DataDump());
        if(getConfig().getBoolean("cmd-groups.cheaty")) {
            //Cheaty CMDS
            this.getCommand("camacc").setExecutor(new SpecMode());
        }
        if(getConfig().getBoolean("cmd-groups.fun")) {
            //Fun CMDS
            this.getCommand("red").setExecutor(new Red());
            this.getCommand("pigstep").setExecutor(new Sounds(Sound.MUSIC_DISC_PIGSTEP));
            this.getCommand("otherside").setExecutor(new Sounds(Sound.MUSIC_DISC_OTHERSIDE));
        }
        if(getConfig().getBoolean("cmd-groups.util")) {
            //Util CMDS
            this.getCommand("ss").setExecutor(new Help());
        }
        new ShapedRecipeProvider();
    }

    @Override
    public void onDisable() {
        logger.log(Level.INFO, "Shutting Down...");
        online.clear();
    }

    public static NamespacedKey namespacedKey(String name) {
        Plugin p = JARSMP.getPlugin(JARSMP.class);
        return new NamespacedKey(p, name);
    }
}
