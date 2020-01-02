package SettingsTests.Measure;


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

public class KMeasure {
    public static AndroidDriver driver;
    public static TestReporter report;
    public static AndroidActions test;
    public static AndroidTestHelper helper;
    public boolean MoveToMeasureScreen;
    public boolean LeftAccessoriesVisibile;
    public boolean HomeButtonResult = false;
    public boolean RightprogressBarResult;

    public String value;

    public By Homebutton = By.id("home_icon");
    public By MeasureScreen = By.xpath("//*[@text='MEASURE']");
    public By Measureproblem = By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]");
    public By StartMeasureButton = By.id("start_stop_measurment");
    public By RightprogressBar = By.id("right_progress");
    public By QuickPro = By.id("sphere_param");
    public By Ok = By.id("ok_btn");


    public KMeasure(AndroidTestHelper helper) {
        this.driver = helper.getDriver();
        driver.setTimeout(15000);
        this.report = helper.getReporter();
        this.test = driver.testproject();
        this.helper = helper;

    }


    public boolean clickskipexception(By by) {
        final WebDriverWait wait = new WebDriverWait(driver, 150000);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by)));
        driver.findElement(by).click();
        return true;
    }


    public boolean StartMeasure() throws FailureException {
        HomeButtonResult =   clickskipexception(Homebutton);
        report.step("Tap home button", HomeButtonResult, TakeScreenshotConditionType.Failure);
        MoveToMeasureScreen = clickskipexception(MeasureScreen);
        report.step("Click on 'Measure' tab", MoveToMeasureScreen, TakeScreenshotConditionType.Failure);
        ElementExists waitforhome = new ElementExists(helper);
        clickskipexception(StartMeasureButton);

       // wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by)));

        /*AndroidDriver wait = new FluentWait<AndroidDriver>(driver)
                .withTimeout(12, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);*/

        try {
            By popupmessage = By.id("message_content");
            report.step("meaasurment stopped messsage",   waitforhome.Exists(popupmessage), TakeScreenshotConditionType.Always);
            String progressbar = driver.testproject().getText(RightprogressBar);


        } catch (Exception e) {
            e.printStackTrace();
        }

        ElementExists wait = new ElementExists(helper);

        try
        {

            wait.waitfotwoele(Measureproblem,QuickPro,driver,240000);

            driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
            boolean Measureproblemexists = driver.findElements(Measureproblem).size() != 0;
            if(Measureproblemexists){
                driver.testproject().clickIfVisible(Ok) ;
            }
            boolean LeftAccessoriesExist = driver.findElements(QuickPro).size() != 0;
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

