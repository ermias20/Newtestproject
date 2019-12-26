package io;


import Tools.ElementExists;
import io.testproject.java.enums.TakeScreenshotConditionType;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WfMeasurment {
    public static AndroidDriver driver;
    public static TestReporter report;
    public static AndroidActions test;
    public static AndroidTestHelper helper;
    public boolean MoveToMeasureScreen;
    public boolean StartMeasureButtonResult;
    public boolean LeftAccessoriesVisibile;
    public boolean HomeButtonResult = false;
    public boolean RightprogressBarResult;

    public String value;


    public By Homebutton = By.id("home_icon");
    public By MeasureScreen = By.xpath("//*[@text='MEASURE']");
    public By Measureproblem = By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]");
    public By StartMeasureButton = By.id("start_stop_measurment");
    public By RightprogressBar = By.id("right_progress");
    public By LeftAccessories = By.id("left_accessories");
    public By Ok = By.id("ok_btn");


    public WfMeasurment(AndroidTestHelper helper) {
        this.driver = helper.getDriver();
        driver.setTimeout(15000);
        this.report = helper.getReporter();
        this.test = driver.testproject();
        this.helper = helper;

    }



    public boolean clickskipexception(By by) {
        final WebDriverWait wait = new WebDriverWait(driver, 150000);
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(by)));
                driver.findElement(by).click();
        return true;

    }
    public boolean StartMeasure() throws FailureException {
        HomeButtonResult =   clickskipexception(Homebutton);

        report.step("Tap home button", HomeButtonResult, TakeScreenshotConditionType.Failure);

        MoveToMeasureScreen = clickskipexception(MeasureScreen);
        report.step("Click on 'Measure' tab", MoveToMeasureScreen, TakeScreenshotConditionType.Failure);


        //StartMeasureButtonResult = test.clickIfVisible(StartMeasureButton);
        ElementExists waitforhome = new ElementExists(helper);
        clickskipexception(StartMeasureButton);
        //waitforhome.clickOn(StartMeasureButton, driver, 150000);

        //.step("start measure", StartMeasureButtonResult, TakeScreenshotConditionType.Failure);
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

        ElementExists wait = new ElementExists(helper);

        try
    {

        wait.waitfotwoele(Measureproblem,LeftAccessories,driver,180000);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        boolean Measureproblemexists = driver.findElements(Measureproblem).size() != 0;
        if(Measureproblemexists){
            driver.testproject().clickIfVisible(Ok) ;
        }
        boolean LeftAccessoriesExist = driver.findElements(LeftAccessories).size() != 0;
        if(LeftAccessoriesExist){
            report.step("Is refraction page visible?", LeftAccessoriesVisibile,
                    TakeScreenshotConditionType.Failure);
        }



    } catch(Exception e)

    {
    }
        return true;
}

}

