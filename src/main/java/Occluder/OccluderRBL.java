package Occluder;

import Pages.QuestionScreen;
import Settings.RefractionSettings;
import Settings.Settings;
import Tools.imageComparison;
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
import io.testproject.proxy.addon.io.testproject.addon.imagecomparison.actions.generic.CompareTwoImages;
import org.openqa.selenium.By;

import java.io.IOException;

@Test(name = "OccluderRBL ", version = "1.0")

public class OccluderRBL implements AndroidTest {
    ExecutionResult executionResult;

    CompareTwoImages compareTwoImages;

    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
        TestReporter report = helper.getReporter();
        AndroidDriver driver = helper.getDriver();
        AndroidActions test =  driver.testproject();
        String RLXpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]";
        String RightOccludexpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.ImageView[3]";
        String LeftOccludxpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.ImageView[3]";

        String RbLOccluderchecked ="RBLchecked";
        String RbLOccluderunchecked ="RBLunchecked";

        By OccludeRight = By.id("eye_right_toggle");
        By Occludeleft = By.id("eye_left_toggle");
        By OccludeBino = By.id("eye_r_and_l_toggle");

        By rightSphere = By.id("current_sphere_right_value");
        By LeftSphere= By.id("current_sphere_left_value");


        // open settings
        Settings newSettings = new Settings(helper);
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings(), "open settings ");
        newSettings.OpenSettingsRefractionTab();
        //open refraction settings and change vertical prism value
        RefractionSettings RefractionTab = new RefractionSettings(helper);
        BooleanCheck.ReporterCheck(report, RefractionTab.RBL() , "RBL occluder  chosen");
        BooleanCheck.ReporterCheck(report, RefractionTab.Frosted() , "RBL occluder  chosen");

        QuestionScreen newquestionscreen = new QuestionScreen(helper);
        newquestionscreen.OpenQuestionScreen();
        //measure
        WfMeasurment newmeasure = new WfMeasurment(helper);



            BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");


        test.clickIfVisible(OccludeBino);
        test.clickIfVisible(OccludeBino);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MobileElement ele = (MobileElement) driver.findElementByXPath(RLXpath);
        imageComparison newcomparison = new imageComparison();
        try {
            BooleanCheck.ReporterCheck(report, newcomparison.compareImage(helper ,RbLOccluderchecked, ele)== ExecutionResult.PASSED, "RBl occluder image compare result");

        } catch (IOException e) {
            e.printStackTrace();
        }


        Attribiute enabled = new Attribiute();
        BooleanCheck.ReporterCheck(report,         enabled.Enabled(rightSphere,helper), "right sph is enabled while occluder is opened");
        BooleanCheck.ReporterCheck(report,     enabled.Enabled(LeftSphere,helper), "left sph is enabled while occluder is opened");


        test.clickIfVisible(OccludeBino);


        BooleanCheck.ReporterCheck(report,         !enabled.Enabled(rightSphere,helper), "right sph is disabled while occluder is closed");
        BooleanCheck.ReporterCheck(report,     !enabled.Enabled(LeftSphere,helper), "left sph is disabled while occluder is closed");

        MobileElement rightoccluder = (MobileElement) driver.findElementByXPath(RightOccludexpath);
        MobileElement leftuccluder = (MobileElement) driver.findElementByXPath(LeftOccludxpath);
        String RightOccluder ="RightFrosted";
        String LeftOccluder ="LeftFrosted";
        try {
            BooleanCheck.ReporterCheck(report, newcomparison.compareImage(helper ,RbLOccluderunchecked, ele)== ExecutionResult.PASSED, "Rl occluder unchecked image compare result");
            BooleanCheck.ReporterCheck(report, newcomparison.compareImage(helper ,RightOccluder, rightoccluder)== ExecutionResult.PASSED, "check right occludr frosted image compare result");
            BooleanCheck.ReporterCheck(report, newcomparison.compareImage(helper ,LeftOccluder, leftuccluder)== ExecutionResult.PASSED, "check left occludr frosted image compare result");

        } catch (IOException e) {
            e.printStackTrace();
        }
        test.clickIfVisible(Occludeleft);
        BooleanCheck.ReporterCheck(report,     enabled.Enabled(LeftSphere,helper), "left sph is enabled while occluder is closed");
        BooleanCheck.ReporterCheck(report,         !enabled.Enabled(rightSphere,helper), "right sph is disabled while occluder is closed");

        test.clickIfVisible(OccludeRight);
        BooleanCheck.ReporterCheck(report,     !enabled.Enabled(LeftSphere,helper), "left sph is disabled while occluder is closed");
        BooleanCheck.ReporterCheck(report,         enabled.Enabled(rightSphere,helper), "right sph is enabled while occluder is opend");

        return ExecutionResult.PASSED;


    }
}
