package SettingsTests.Refraction.Xcyl;

import Pages.QuestionScreen;
import Settings.RefractionSettings;
import Settings.Settings;
import Tools.BaseCompareImages;
import Tools.NextButton;
import Tools.ScreenShotByCoord;
import io.BooleanCheck;
import io.WfMeasurment;
import io.appium.java_client.MobileElement;
import io.testproject.java.annotations.v2.Test;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.tests.AndroidTest;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import org.openqa.selenium.By;

import java.io.File;

@Test(name = "xcyl dots", version = "1.0")

public class XcylTestsDots implements AndroidTest {

    //public By Xcyl = By.id("access_xcyl");

    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
        AndroidDriver driver = helper.getDriver();
        TestReporter report = helper.getReporter();
        AndroidActions test = driver.testproject();
        ExecutionResult executionResult;

        By Xcyl = By.id("access_xcyl");
        String optotypeLayout = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[3]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]";
        MobileElement ele = (MobileElement) driver.findElementByXPath(optotypeLayout);
        String Xcyltest ="Dots";


        By openaccessories = By.id("open_accessories");
        Boolean OptotypeExist = false;



        Settings newSettings = new Settings(helper);
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings()
                , "open settings ");

        newSettings.OpenSettingsRefractionTab();
        RefractionSettings RefractionTab = new RefractionSettings(helper);
        BooleanCheck.ReporterCheck(report, RefractionTab.SelectDots()
                , "select xcyl dots settings ");
        QuestionScreen newExam = new QuestionScreen(helper);
        BooleanCheck.ReporterCheck(report, newExam.OpenQuestionScreen()
                , "open question screen ");

        WfMeasurment newWfMeasurment = new WfMeasurment(helper);

        BooleanCheck.ReporterCheck(report, newWfMeasurment.StartMeasure()
                , "measurment ");

        NextButton nextbefore = new  NextButton(helper);
        nextbefore.BeforeBracketNext();
        BooleanCheck.ReporterCheck(report, test.clickIfVisible(openaccessories)
                , "open accessories wheel ");
        BooleanCheck.ReporterCheck(report, test.clickIfVisible(Xcyl)
                , "select xcyl");
      /*  ElementExists XCylTest = new ElementExists(helper);

        if (XCylTest.Exists(optotypeLayout)) {
            if (test.getText(optotypeLayout).contentEquals("point_large")) {
                OptotypeExist = true;
            } else {
                OptotypeExist = false;

            }
        } else {
            OptotypeExist = false;

        }*/



        ScreenShotByCoord takescreenshot = new ScreenShotByCoord(helper);
        String screenshotpath = takescreenshot.ScreenShot(ele, Xcyltest);

        BaseCompareImages action = new BaseCompareImages();

        action.setThreshold("15");
        File Resourcesdirectory = new File("src/main/Resources/Dots.png");
        File Screenshotdirectory = new File("src/main/Resources/Screenshots/Dots.png");
        executionResult = action.compareImagesUtils(Resourcesdirectory,Screenshotdirectory,report);

        BooleanCheck.ReporterCheck(report, executionResult ==ExecutionResult.PASSED, "selected optotype seen on chart ");
        return ExecutionResult.PASSED;

    }


}
