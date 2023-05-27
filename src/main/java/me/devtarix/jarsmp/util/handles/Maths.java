package me.devtarix.jarsmp.util.handles;

import org.bukkit.util.Vector;

/**
 * "Useful" maths
 */
public class Maths {
    /**
     * Used to apply a pull effect on movement (using movement code)
     * @param x x direction
     * @param y y direction
     * @param z z direction
     * @param speed speed
     * @return vector
     */
    public Vector vecpull(double x, double y, double z, double speed) {
        return new Vector(x, y, z).normalize().multiply(-speed);
    }

    /**
     * Used to apply a push effect on movement (using movement code)
     * @param x x direction
     * @param y y direction
     * @param z z direction
     * @param speed speed
     * @return vector
     */
    public Vector vecpush(double x, double y, double z, double speed) {
        return new Vector(x,y,z).normalize().multiply(speed);
    }
}
