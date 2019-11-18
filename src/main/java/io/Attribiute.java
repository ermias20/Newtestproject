package io;

import io.appium.java_client.android.AndroidDriver;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import org.openqa.selenium.By;

public class Attribiute {
    static AndroidDriver test;

    public Attribiute() {
    }

    public static boolean Checked(By by, AndroidTestHelper helper) {
        test = (AndroidDriver)helper.getDriver();
        String attr = test.findElement(by).getAttribute("checked");
        return attr.equals("false");
    }

    public static boolean Enabled(By by, AndroidTestHelper helper) {
        test = (AndroidDriver)helper.getDriver();
        String attr = test.findElement(by).getAttribute("enabled");
        return attr.equals("true");
    }
}