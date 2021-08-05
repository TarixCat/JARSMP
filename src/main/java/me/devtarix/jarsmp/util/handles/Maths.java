package me.devtarix.jarsmp.util.handles;

import org.bukkit.util.Vector;

public class Maths {
    public Vector vecpull(double x, double y, double z, double speed) {
        return new Vector(x, y, z).normalize().multiply(-speed);
    }
}
