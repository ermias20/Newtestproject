package SettingsTests.Refraction.Prism;

import Pages.QuestionScreen;
import Settings.RefractionSettings;
import Settings.Settings;
import Tools.BaseCompareImages;
import Tools.NextButton;
import Tools.ScreenShotByCoord;
import Tools.Toolbar;
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

@Test(name = "HorizontalPrismOut", version = "1.0")

public class HorizontalPrismOut implements AndroidTest {


    ExecutionResult executionResult;


    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
        TestReporter report = helper.getReporter();
        AndroidDriver driver = helper.getDriver();
        AndroidActions test =  driver.testproject();
        String XpathaccHorizontal = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.ImageView[3]";
        By by = By.id("expert_mode");
        By accessories= By.xpath(XpathaccHorizontal);
        By prism= By.id("access_prisma");
        By CurrentPrismyRightValue= By.id("current_prism_y_left_value");
        String prismtest ="HorizontalPrismOut";
        int HorizontalPrismInval= 6;;

        // open settings
        Settings newSettings = new Settings(helper);
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings(), "open settings ");
        newSettings.OpenSettingsRefractionTab();
        //open refraction settings and change vertical prism value
        RefractionSettings RefractionTab = new RefractionSettings(helper);
        Toolbar seekbar = new Toolbar(helper);
        BooleanCheck.ReporterCheck(report, seekbar.dragSeekBarTo(HorizontalPrismInval,seekbar.hprismseekBar,seekbar.hstep), "Horizontal out prism  value is " + HorizontalPrismInval);

        BooleanCheck.ReporterCheck(report, RefractionTab.HorizontalOut(), "Horizontal out prism  chosen");

        QuestionScreen newquestionscreen = new QuestionScreen(helper);
        newquestionscreen.OpenQuestionScreen();
        //measure
        WfMeasurment newmeasure = new WfMeasurment(helper);
        BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");
        NextButton nextbefore = new  NextButton(helper);
        nextbefore.BeforeBracketNext();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test.clickIfVisible(accessories);
        BooleanCheck.ReporterCheck(report, test.clickIfVisible(prism), "Prism chosen from accessories wheel");
        MobileElement ele = (MobileElement) driver.findElementByXPath(XpathaccHorizontal);
        ScreenShotByCoord takescreenshot = new ScreenShotByCoord(helper);
        String screenshotpath = takescreenshot.ScreenShot(ele, prismtest);

        BaseCompareImages action = new BaseCompareImages();

        action.setThreshold("15");
        File Resourcesdirectory = new File("src/main/Resources/HorizontalPrismOut.png");
        File Screenshotdirectory = new File("src/main/Resources/Screenshots/HorizontalPrismOut.png");
        executionResult = action.compareImagesUtils(Resourcesdirectory,Screenshotdirectory,report);





        return ExecutionResult.PASSED;


    }

}
