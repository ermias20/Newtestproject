package SettingsTests.Refraction.Occluder;

import Pages.QuestionScreen;
import Settings.RefractionSettings;
import Settings.Settings;
import Tools.BaseCompareImages;
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

@Test(name = "Opaque ", version = "1.0")

public class Opaque implements AndroidTest {
    ExecutionResult executionResult;


    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException  {


       TestReporter report = helper.getReporter();
        AndroidDriver driver = helper.getDriver();
        AndroidActions test =  driver.testproject();
        String  RightOccludxpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.ImageView[3]";
        String  Righttest = "RightOpaque";
        String  Lefttest = "LeftOpaque";

     String LeftOccludxpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.ImageView[3]";

        By OccludeRight = By.id("eye_right_toggle");
        By Occludeleft = By.id("eye_left_toggle");

        By Rightaccessories= By.xpath(RightOccludxpath);
        By Leftaccessories= By.xpath(LeftOccludxpath);

        By prism= By.id("access_prisma");
        String RightOccluder ="RightOpaque";
        String LeftOccluder ="LeftOpaque";

        // open settings
        Settings newSettings = new Settings(helper);
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings(), "open settings ");
        newSettings.OpenSettingsRefractionTab();
        //open refraction settings and change vertical prism value
       RefractionSettings RefractionTab = new RefractionSettings(helper);
        BooleanCheck.ReporterCheck(report, RefractionTab.Opaque(), "Opaque occluder  chosen");

        QuestionScreen newquestionscreen = new QuestionScreen(helper);
        newquestionscreen.OpenQuestionScreen();
        //measure
        WfMeasurment newmeasure = new WfMeasurment(helper);
        BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");
        test.clickIfVisible(OccludeRight);

        test.pause(1500);
        MobileElement Rightele = (MobileElement) driver.findElementByXPath(RightOccludxpath);


     ScreenShotByCoord takescreenshot = new ScreenShotByCoord(helper);
     String screenshotpath = takescreenshot.ScreenShot(Rightele, Righttest);

     BaseCompareImages action = new BaseCompareImages();

     action.setThreshold("15");
     File Resourcesdirectory = new File("src/main/Resources/RightOpaque.png");
     File Screenshotdirectory = new File("src/main/Resources/Screenshots/RightOpaque.png");
     executionResult = action.compareImagesUtils(Resourcesdirectory,Screenshotdirectory,report);

     BooleanCheck.ReporterCheck(report, executionResult ==ExecutionResult.PASSED, "Right opaque occluder image compare result");
     test.clickIfVisible(Occludeleft);

     test.pause(1500);

     MobileElement LeftEle = (MobileElement) driver.findElementByXPath(LeftOccludxpath);

     ScreenShotByCoord takescreenshot1 = new ScreenShotByCoord(helper);
     takescreenshot1.ScreenShot(LeftEle, Lefttest);

     action.setThreshold("15");
     File Resourcesdirectory1 = new File("src/main/Resources/LeftOpaque.png");
     File Screenshotdirectory1 = new File("src/main/Resources/Screenshots/LeftOpaque.png");
     executionResult = action.compareImagesUtils(Resourcesdirectory1,Screenshotdirectory1,report);

     BooleanCheck.ReporterCheck(report, executionResult ==ExecutionResult.PASSED, "left opaque occluder image compare result");



     return ExecutionResult.PASSED;

    }

}
