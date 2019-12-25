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
import io.testproject.java.sdk.v2.Runner;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.tests.AndroidTest;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import org.openqa.selenium.By;

import java.io.File;

@Test(name = "Vertical Prism up", version = "1.0")

public class VerticalPrismUp implements AndroidTest {
    ExecutionResult executionResult;
    String xpathaccvertical = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.ImageView[3]";
    By accessories= By.xpath(xpathaccvertical);
    By prism= By.id("access_prisma");
    By CurrentPrismyRightValue= By.id("current_prism_y_right_value");
    public static Runner runner;

    String prismtest ="VerticalPrismup";
    int verticalprismval= 7;

    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
        TestReporter report = helper.getReporter();
        AndroidDriver driver = helper.getDriver();
        AndroidActions test = driver.testproject();
        // open settings
        Settings newSettings = new Settings(helper);
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings(), "open settings ");
        newSettings.OpenSettingsRefractionTab();
        //open refraction settings and change vertical prism value
        RefractionSettings RefractionTab = new RefractionSettings(helper);
        Toolbar seekbar = new Toolbar(helper);
        BooleanCheck.ReporterCheck(report, seekbar.dragSeekBarTo(verticalprismval,seekbar.vprismseekBar,seekbar.vstep), "Vertical prism up value is " + verticalprismval);

        BooleanCheck.ReporterCheck(report, RefractionTab.VerticalUp(), "Vertical prism up chosen");

        QuestionScreen newquestionscreen = new QuestionScreen(helper);
        newquestionscreen.OpenQuestionScreen();
        //measure
        WfMeasurment newmeasure = new WfMeasurment(helper);
        BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");
        NextButton nextbefore = new  NextButton(helper);
        nextbefore.BeforeBracketNext();
        By RightAxis = By.id("current_axis_right_value");
        By ZeroAxis = By.id("directBtn1");
        By Leftoccluder = By.id("eye_left_toggle");
        By LeftAxis = By.id("current_axis_left_value");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test.clickIfVisible(accessories);
        BooleanCheck.ReporterCheck(report, test.clickIfVisible(prism), "Prism chosen from accessories wheel");

        MobileElement ele = (MobileElement) driver.findElementByXPath(xpathaccvertical);
        ScreenShotByCoord takescreenshot = new ScreenShotByCoord(helper);
        String screenshotpath = takescreenshot.ScreenShot(ele, prismtest);

        ClassLoader classLoader = VerticalPrismUp.class.getClassLoader();
      /*  String Screenshot = classLoader.getResource("io/testproject/generated/tests/eyerefract/Resources/Screenshots/VerticalPrismup.png").getPath();
        String Resource = classLoader.getResource("io/testproject/generated/tests/eyerefract/Resources/VerticalPrismup.png").getPath();


        compareTwoImages = ImageComparison.compareTwoImages(Screenshot, Resource, "20", "src/main/java/eyerefract/Screenshots/", "VerticalPrismupDiff");
        executionResult = helper.executeProxy(compareTwoImages);*/


        BaseCompareImages action = new BaseCompareImages();

        action.setThreshold("15");
        File Resourcesdirectory = new File("src/main/Resources/VerticalPrismup.png");
        File Screenshotdirectory = new File("src/main/Resources/Screenshots/VerticalPrismup.png");
        executionResult = action.compareImagesUtils(Resourcesdirectory,Screenshotdirectory,report);

        BooleanCheck.ReporterCheck(report, executionResult == ExecutionResult.PASSED, "compare result");

        String prismvalue = String.valueOf(verticalprismval).replaceAll("\\D", "");;
        String Currentprismvalue =  test.getText(CurrentPrismyRightValue).replaceAll("\\.0*$", "");
        String NewCurrentprismvalue =Currentprismvalue.replaceAll("\\D", "");
        Boolean prismval =NewCurrentprismvalue.contentEquals(prismvalue);
        BooleanCheck.ReporterCheck(report, prismval, "prism y value");

        return ExecutionResult.PASSED;

    }

}
