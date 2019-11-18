package Occluder;
import Pages.QuestionScreen;
import Settings.RefractionSettings;
import Settings.Settings;
import Tools.imageComparison;
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
import io.testproject.proxy.addon.io.testproject.addon.imagecomparison.actions.generic.CompareTwoImages;
import org.openqa.selenium.By;

import java.io.IOException;

@Test(name = "Opaque ", version = "1.0")

public class Opaque implements AndroidTest {
    ExecutionResult executionResult;

    CompareTwoImages compareTwoImages;

    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException  {


       TestReporter report = helper.getReporter();
        AndroidDriver driver = helper.getDriver();
        AndroidActions test =  driver.testproject();
        String RightOccludexpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.ImageView[3]";
        String LeftOccludxpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.ImageView[3]";

        By OccludeRight = By.id("eye_right_toggle");
        By Occludeleft = By.id("eye_left_toggle");

        By Rightaccessories= By.xpath(RightOccludexpath);
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

        MobileElement Rightele = (MobileElement) driver.findElementByXPath(RightOccludexpath);
        imageComparison Rightcomparison = new imageComparison();
        try {

            BooleanCheck.ReporterCheck(report ,Rightcomparison.compareImage(helper ,RightOccluder  ,Rightele)==ExecutionResult.PASSED, " right occluder image compare result");

        } catch (IOException e) {
            e.printStackTrace();
        }

        test.pause(1500);

        MobileElement Leftele = (MobileElement) driver.findElementByXPath(LeftOccludxpath);
        imageComparison leftcomparison = new imageComparison();
        try {

            BooleanCheck.ReporterCheck(report ,leftcomparison.compareImage(helper ,LeftOccluder  ,Leftele)==ExecutionResult.PASSED, " left occluder image compare result");

        } catch (IOException e) {
            e.printStackTrace();
        }



        return ExecutionResult.PASSED;

    }

}
