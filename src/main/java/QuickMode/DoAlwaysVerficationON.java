package QuickMode;

import Pages.QuestionScreen;
import Settings.*;
import Tools.ElementExists;
import io.BooleanCheck;
import io.WfMeasurment;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.tests.AndroidTest;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import io.testproject.proxy.addon.io.testproject.addon.imagecomparison.actions.generic.CompareTwoImages;
import org.openqa.selenium.By;

public class DoAlwaysVerficationON implements AndroidTest {

    ExecutionResult executionResult;

    CompareTwoImages compareTwoImages;

    By CurrentStep = By.id("selected_header_text");

    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
        TestReporter report = helper.getReporter();
        AndroidDriver driver = helper.getDriver();
        AndroidActions test = driver.testproject();
        Settings newSettings = new Settings(helper);
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings(), "open settings ");
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettingsQuickmodeTab(), "open quick mode tab");
        QuickModeSettings newquickmode = new QuickModeSettings(helper);
        if(newquickmode.CheckDoAlwaysVerficationeState()){
            BooleanCheck.ReporterCheck(report, newquickmode.DoAlwaysVerfication(), "do always settings selected");
        }
        QuestionScreen newexam= new QuestionScreen(helper);
        BooleanCheck.ReporterCheck(report,   newexam.OpenQuestionScreen(), "new exam");

        WfMeasurment newmeasure = new WfMeasurment(helper);
        BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");
        ElementExists checkquickproapears = new ElementExists (helper);
        BooleanCheck.ReporterCheck(report, test.getText(CurrentStep).contains("STEP 2 - FAR VISION\n" +
                "Right eye verification"), "va step shown before quick pro shown");
        BooleanCheck.ReporterCheck(report,true,"current step is "+ test.getText(CurrentStep));
        return ExecutionResult.PASSED;



    }
}
