package io;

public class Tolerance {

    public boolean rn(double tolerance, double actual, double tolerncevalue) {
        if (Math.abs(tolerance - actual) <= tolerncevalue) {
            return true;

        } else {
            return false;
        }

    }
}
