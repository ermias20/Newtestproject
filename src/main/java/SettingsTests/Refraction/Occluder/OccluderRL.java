package SettingsTests.Refraction.Occluder;

import Pages.QuestionScreen;
import Settings.RefractionSettings;
import Settings.Settings;
import Tools.BaseCompareImages;
import Tools.NextButton;
import Tools.ScreenShotByCoord;
import io.Attribiute;
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

@Test(name = "OccluderRL ", version = "1.0")

public class OccluderRL implements AndroidTest {
    ExecutionResult executionResult;


    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
        TestReporter report = helper.getReporter();
        AndroidDriver driver = helper.getDriver();
        AndroidActions test =  driver.testproject();
        String RLXpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]";
               String RightOccludexpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.ImageView[3]";
        String LeftOccludxpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.ImageView[3]";

        String RLOccluderchecked ="RLchecked";
        String RLOccluderunchecked ="RLunchecked";

        By OccludeRight = By.id("eye_right_toggle");
        By Occludeleft = By.id("eye_left_toggle");
        By rightSphere = By.id("current_sphere_right_value");
        By LeftSphere= By.id("current_sphere_left_value");


        // open settings
        Settings newSettings = new Settings(helper);
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings(), "open settings ");
        newSettings.OpenSettingsRefractionTab();
        //open refraction settings and change vertical prism value
        RefractionSettings RefractionTab = new RefractionSettings(helper);
        BooleanCheck.ReporterCheck(report, RefractionTab.RL() , "RL occluder  chosen");
        BooleanCheck.ReporterCheck(report, RefractionTab.Frosted() , "RL occluder  chosen");

        QuestionScreen newquestionscreen = new QuestionScreen(helper);
        newquestionscreen.OpenQuestionScreen();
        //measure
        WfMeasurment newmeasure = new WfMeasurment(helper);
        BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");
        NextButton nextbefore = new  NextButton(helper);
        nextbefore.BeforeBracketNext();
        //test.clickIfVisible(OccludeRight);
        test.clickIfVisible(Occludeleft);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MobileElement ele = (MobileElement) driver.findElementByXPath(RLXpath);
        ScreenShotByCoord takescreenshot = new ScreenShotByCoord(helper);
        String screenshotpath = takescreenshot.ScreenShot(ele, "RLchecked");

        BaseCompareImages action = new BaseCompareImages();

        action.setThreshold("15");
        File Resourcesdirectory = new File("src/main/Resources/RLchecked.png");
        File Screenshotdirectory = new File("src/main/Resources/Screenshots/RLchecked.png");
        executionResult = action.compareImagesUtils(Resourcesdirectory,Screenshotdirectory,report);


        Attribiute enabled = new Attribiute();
        BooleanCheck.ReporterCheck(report,         enabled.Enabled(rightSphere,helper), "right sph is enabled while occluder is opened");
        BooleanCheck.ReporterCheck(report,     enabled.Enabled(LeftSphere,helper), "left sph is enabled while occluder is opened");


        test.clickIfVisible(Occludeleft);
        test.clickIfVisible(OccludeRight);

        BooleanCheck.ReporterCheck(report,         !enabled.Enabled(rightSphere,helper), "right sph is disabled while occluder is closed");
        BooleanCheck.ReporterCheck(report,     !enabled.Enabled(LeftSphere,helper), "left sph is disabled while occluder is closed");


        return ExecutionResult.PASSED;


    }
}
