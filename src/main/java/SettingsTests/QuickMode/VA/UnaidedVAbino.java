package SettingsTests.QuickMode.VA;

import Pages.QuestionScreen;
import Settings.QuickModeSettings;
import Settings.Settings;
import Tools.NextButton;
import io.BooleanCheck;
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

@Test(name = "unaided va bino", version = "1.0")

public class UnaidedVAbino implements AndroidTest {
    @Parameter(defaultValue = "1.5", direction = ParameterDirection.INPUT)
    public String Lmsphinterval;
    ExecutionResult executionResult;
    public AndroidTestHelper helper;
    public TestReporter report ;
    public AndroidDriver driver ;
    public AndroidActions test ;
    By CurrentStepHeader = By.id("selected_header_text");


    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
        this.helper = helper;
        this.report = helper.getReporter();
        this.driver = helper.getDriver();
        this.test = driver.testproject();
        System.out.println("started");
        Opensettings();
        QuickModeSettings newquickmode = new QuickModeSettings(helper);
        newquickmode.swipedown();
        if (newquickmode.UnaidedVaBinoCheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.UnaidedVaBino(), "Unaided Va Bino settings on");
        }
        if (!newquickmode.UnaidedVaMonocheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.UnaidedVaMono(), "Unaided Va mono settings on");
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

        Opensettings();
        newquickmode.swipedown();
        if (!newquickmode.UnaidedVaBinoCheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.UnaidedVaBino(), "Unaided Va Bino settings off");
        }
        MeasureandRefraction();
        return ExecutionResult.PASSED;

    }


    public void MeasureandRefraction() throws FailureException {
        QuestionScreen newexam = new QuestionScreen(helper);
        BooleanCheck.ReporterCheck(report, newexam.OpenQuestionScreen(), "new exam");

        WfMeasurment newmeasure = new WfMeasurment(helper);
        BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");
        NextButton nextbefore = new  NextButton(helper);
        nextbefore.BeforeBracketNext();
        BooleanCheck.ReporterCheck(report, test.getText(CurrentStepHeader).contains("STEP 2 - FAR VISION\n" +
                "Unaided QuickMode measurement R&L"), "Unaided step shown");



    }



    public void Opensettings()  {

        Settings newSettings = new Settings(helper);
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings(), "open settings ");
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettingsQuickmodeTab(), "open quick mode tab");

    }
}