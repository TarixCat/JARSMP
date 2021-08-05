package me.devtarix.jarsmp.util.handles;

import java.util.logging.Level;

public class Logger {
    public void log(Level level, String msg) {
        System.out.println("[" + level.toString() + "]: " + msg);
    }
}
