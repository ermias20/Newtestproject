package io;


import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;

public class CheckConvention {
    public static By Convention = By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]");
    AndroidDriver driver;
    TestReporter report;
    AndroidActions test;

    public CheckConvention(AndroidTestHelper helper) {
        this.driver = helper.getDriver();
        this.report = helper.getReporter();
        this.test = helper.getDriver().testproject();

    }

    public boolean ChangeConvention() {
        return test.clickIfVisible(Convention);
    }

    public boolean IsCylPostive() {
        if (test.getText(Convention).contentEquals("+")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsValueNegative(double val) {
        if (val < 0) {
            return true;
        } else {
            return false;
        }


    }

}
