package me.devtarix.jarsmp.util.handles;

import java.util.logging.Level;

/**
 * Logging Methods!!!
 */

//TODO: Probably could be put into Notifs or put Notifs into here
public class Logger {
    public static void log(Level level, String msg) {
        System.out.println("[" + level.toString() + "]: " + msg);
    }

    public static void print(String msg) {
        System.out.println(msg);
    }
}
