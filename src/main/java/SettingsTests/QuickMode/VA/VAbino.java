package SettingsTests.QuickMode.VA;

import Pages.QuestionScreen;
import Settings.QuickModeSettings;
import Settings.Settings;
import Tools.ElementExists;
import io.BooleanCheck;
import io.SphereBracketing;
import io.WfMeasurment;
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

@Test(name = "va bino", version = "1.0")

public class VAbino implements AndroidTest {
    @Parameter(defaultValue = "1.5", direction = ParameterDirection.INPUT)
    public String Lmsphinterval;
    ExecutionResult executionResult;
    public AndroidTestHelper helper;
    public TestReporter report ;
    public AndroidDriver driver ;
    public AndroidActions test ;
    By CurrentStepHeader = By.id("selected_header_text");

    By OccluderAttr = By.id("eye_right_toggle");
    String RightPolorizedFilter = "RightPolorizedFilter";
    By VALines = By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[3]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[2]/android.view.View[*]");

    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
        this.helper = helper;
        this.report = helper.getReporter();
        this.driver = helper.getDriver();
        this.test = driver.testproject();
        System.out.println("started");
        Opensettings();
        QuickModeSettings newquickmode = new QuickModeSettings(helper);
        newquickmode.swipedown();
        if (newquickmode.VaBinoCheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.VaBino(), "Va Bino settings on");
        }
        if (newquickmode.VaMonocheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.VaMono(), "Va mono settings on");
        }
        if (newquickmode.NewdoalwaysCheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.Newdoalways(), "turn on do always verfication settings");
        }
        if (!newquickmode.NewVaBinobalanceCheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.NewVaBinobalance(), "turn off bino balance");
        }
        if (!newquickmode.NewSphVerCheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.NewSphVer(), "turn off sphere verfication settings ");
        }
        MeasureandRefraction();
        CheckIfexist(true);
        Opensettings();
        newquickmode.swipedown();
        if (!newquickmode.VaBinoCheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.VaBino(), "Va Bino settings on");
        }
        MeasureandRefraction();
        CheckIfexist(true);
        return ExecutionResult.PASSED;

    }


    public void MeasureandRefraction() throws FailureException {
        QuestionScreen newexam = new QuestionScreen(helper);
        BooleanCheck.ReporterCheck(report, newexam.OpenQuestionScreen(), "new exam");

        WfMeasurment newmeasure = new WfMeasurment(helper);
        BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");
        BooleanCheck.ReporterCheck(report, test.getText(CurrentStepHeader).contains("STEP 2 - FAR VISION\n" +
                "Right eye verification"), "Right eye verification step shown");
        SphereBracketing newBracketing = new SphereBracketing(helper);
        newBracketing.bracketrighteye();
        newBracketing.bracketlefteye();


    }



    public void CheckIfexist(Boolean vareport)   {
        ElementExists exists = new ElementExists(helper);
        Boolean vastep = test.getText(CurrentStepHeader).contains("STEP 4 - FAR VISION\n" +
                "SettingsTests.QuickMode.VA.VA exam R&L");
        By next = By.id("advanced_next_step_btn");
        By export = By.id("advanced_export_btn");
        Boolean exportbuttonexists = exists.Exists(export);
        while (!exportbuttonexists) {
            driver.testproject().clickIfVisible(next);
            exportbuttonexists = driver.findElements(export).size() != 0;
            vastep = test.getText(CurrentStepHeader).contains("STEP 6 - FAR VISION\n" +
                    "SettingsTests.QuickMode.VA.VA exam R&L");
            if (vastep) {
                BooleanCheck.ReporterCheck(report, vareport, "va step found");
                break;
            }
        }
        ;
        if (!vastep) {
            BooleanCheck.ReporterCheck(report, vareport, "va step not found");

        }


    }
    public void Opensettings()  {

        Settings newSettings = new Settings(helper);
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings(), "open settings ");
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettingsQuickmodeTab(), "open quick mode tab");

    }
}