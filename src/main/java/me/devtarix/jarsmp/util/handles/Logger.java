package me.devtarix.jarsmp.util.handles;

import java.util.logging.Level;

public class Logger {
    public static void log(Level level, String msg) {
        System.out.println("[" + level.toString() + "]: " + msg);
    }

    public static void print(String msg) {
        System.out.println(msg);
    }
}
