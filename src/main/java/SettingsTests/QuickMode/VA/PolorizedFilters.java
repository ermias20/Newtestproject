package SettingsTests.QuickMode.VA;

import Pages.QuestionScreen;
import Settings.QuickModeSettings;
import Settings.Settings;
import Tools.BaseCompareImages;
import Tools.ScreenShotByCoord;
import io.BooleanCheck;
import io.WfMeasurment;
import io.appium.java_client.MobileElement;
import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.annotations.v2.Test;
import io.testproject.java.enums.ParameterDirection;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.tests.AndroidTest;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import org.openqa.selenium.By;

import java.io.File;

@Test(name = "Polorized Filters", version = "1.0")

    public class PolorizedFilters implements AndroidTest {
        ExecutionResult executionResult;

        @Parameter(defaultValue = "1.5", direction = ParameterDirection.INPUT)
        public String Lmsphinterval;
        By OccluderAttr = By.id("eye_right_toggle");
    String RightOccludexpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.ImageView[3]";

    String LeftOccludxpath   = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.ImageView[4]";
    String RightPolorizedFilter = "RightPolorizedFilter";
    String LeftPolorizedFilter = "LeftPolorizedFilter";

    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
            TestReporter report = helper.getReporter();
            AndroidDriver driver = helper.getDriver();
            AndroidActions test = driver.testproject();
            driver.setTimeout(10000);
            Settings newSettings = new Settings(helper);
            BooleanCheck.ReporterCheck(report, newSettings.OpenSettings(), "open settings ");
            BooleanCheck.ReporterCheck(report, newSettings.OpenSettingsQuickmodeTab(), "open quick mode tab");
            QuickModeSettings newquickmode = new QuickModeSettings(helper);
            if(newquickmode.CheckPolorizedFilterState()){
                newquickmode.PolorizedFilter();
            }
        QuestionScreen newexam= new QuestionScreen(helper);
            newexam.OpenQuestionScreen();
            WfMeasurment newmeasure = new WfMeasurment(helper);
            BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");

            MobileElement Rightele = (MobileElement) driver.findElementByXPath(RightOccludexpath);


        MobileElement Leftele = (MobileElement) driver.findElementByXPath(LeftOccludxpath);


        ScreenShotByCoord takescreenshot = new ScreenShotByCoord(helper);
        takescreenshot.ScreenShot(Rightele, RightPolorizedFilter);

        BaseCompareImages action = new BaseCompareImages();
        action.setThreshold("15");
        File Resourcesdirectory = new File("src/main/Resources/RightPolorizedFilter.png");
        File Screenshotdirectory = new File("src/main/Resources/Screenshots/RightPolorizedFilter.png");
        BooleanCheck.ReporterCheck(report, action.compareImagesUtils(Resourcesdirectory,Screenshotdirectory,report) ==ExecutionResult.PASSED, "right polorized Filter image compare result");
        test.pause(1500);

        takescreenshot.ScreenShot(Leftele, LeftPolorizedFilter);
        BooleanCheck.ReporterCheck(report, action.compareImagesUtils(new File("src/main/Resources/LeftPolorizedFilter.png"),new File("src/main/Resources/Screenshots/LeftPolorizedFilter.png"),report) ==ExecutionResult.PASSED, " left polorized Filter image compare result");





            return ExecutionResult.PASSED;



    }
}