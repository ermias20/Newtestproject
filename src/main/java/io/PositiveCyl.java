package io;

public class PositiveCyl {
    public double positivsph;
    public double positivcyl;
    public double positivaxis;

    public double newsph(double sph, double cyl) {
        positivsph = sph + cyl;
        return positivsph;
    }

    public double newcyl(double cyl) {
        positivcyl = Math.abs(cyl);
        ;
        return positivcyl;
    }

    public double newaxis(double axis) {
        positivaxis = axis + 90;
        return positivaxis;
    }

}
