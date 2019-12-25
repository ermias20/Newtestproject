package SettingsTests.Refraction.PositiveCylinder;


import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;

public class CylPlusRefraction {

    public boolean RefractionCompare(double currentsphere, double currentcyl, double currentaxis, double Headsphere, double Headcyl, double Headaxis
            , AndroidTestHelper helper) {
        if (currentsphere == Headsphere && currentcyl == Headcyl && currentaxis == Headaxis) {
            return true;

        } else {
            return false;
        }

    }
}
