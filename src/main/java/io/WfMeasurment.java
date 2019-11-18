package io;


import org.openqa.selenium.By;

import io.testproject.java.enums.TakeScreenshotConditionType;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;

public class WfMeasurment {
    public static AndroidDriver driver;
    public static TestReporter report;
    public static AndroidActions test;
    public boolean MoveToMeasureScreen;
    public boolean StartMeasureButtonResult;
    public boolean LeftAccessoriesVisibile;
    public boolean HomeButtonResult =false;
    public boolean RightprogressBarResult;

    public String value;


    public By Homebutton = By.id("home_icon");
    public By MeasureScreen = By.xpath("//*[@text='MEASURE']");
    public By StartMeasureButton = By.id("start_stop_measurment");
    public By RightprogressBar = By.id("right_progress");
    public By LeftAccessories = By.id("left_accessories");


    public WfMeasurment(AndroidTestHelper helper) {
        this.driver = helper.getDriver();
        driver.setTimeout(15000);
        this.report = helper.getReporter();
        this.test = driver.testproject();


    }

    public boolean StartMeasure() throws FailureException {
        driver.setTimeout(15000);
        HomeButtonResult = test.clickIfVisible(Homebutton);
        report.step("Tap home button", HomeButtonResult, TakeScreenshotConditionType.Failure);
        MoveToMeasureScreen = test.clickIfVisible(MeasureScreen);
        report.step("Click on 'Measure' tab", MoveToMeasureScreen, TakeScreenshotConditionType.Failure);

        StartMeasureButtonResult = test.clickIfVisible(StartMeasureButton);
        report.step("start measure", StartMeasureButtonResult, TakeScreenshotConditionType.Failure);
        try {
            Thread.sleep(2000);
            String progressbar = driver.testproject().getText(RightprogressBar);
            if (progressbar == "0") {
                RightprogressBarResult = false;
                System.out.println("fail exception");
                report.step("progress bar", RightprogressBarResult, TakeScreenshotConditionType.Always);
            } else {
                RightprogressBarResult = true;
                System.out.println("pass");
                report.step("progress bar", RightprogressBarResult, TakeScreenshotConditionType.Failure);
            }

        } catch (Exception e) {
        }


        try {
            driver.setTimeout(500000);
            LeftAccessoriesVisibile = driver.testproject().isVisible(LeftAccessories);
            report.step("Is refraction page visible?", LeftAccessoriesVisibile,
                    TakeScreenshotConditionType.Failure);

        } catch (Exception e) {

        }
        return true;
    }
}
