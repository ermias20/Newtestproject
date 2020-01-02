package SettingsTests.QuickMode.DoAlwaysVerfication;

import Pages.QuestionScreen;
import Settings.QuickModeSettings;
import Settings.Settings;
import Tools.ElementExists;
import Tools.NextButton;
import io.BooleanCheck;
import io.WfMeasurment;
import io.testproject.java.annotations.v2.Test;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.tests.AndroidTest;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import org.openqa.selenium.By;
@Test(name = "Do Always Verfication off", version = "1.0")

public class DoAlwaysVerficationOFF implements AndroidTest {

    ExecutionResult executionResult;


    By CurrentStep = By.id("selected_header_text");

    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
        TestReporter report = helper.getReporter();
        AndroidDriver driver = helper.getDriver();
        AndroidActions test = driver.testproject();
        Settings newSettings = new Settings(helper);
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings(), "open settings ");
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettingsQuickmodeTab(), "open quick mode tab");
        QuickModeSettings newquickmode = new QuickModeSettings(helper);
        if(!newquickmode.CheckDoAlwaysVerficationeState()){
            BooleanCheck.ReporterCheck(report, newquickmode.DoAlwaysVerfication(), "do always settings selected");
        }
        QuestionScreen newexam= new QuestionScreen(helper);
        BooleanCheck.ReporterCheck(report,   newexam.OpenQuestionScreen(), "new exam");

        WfMeasurment newmeasure = new WfMeasurment(helper);
        BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");
        NextButton nextbefore = new  NextButton(helper);
        nextbefore.BeforeBracketNext();
        ElementExists checkquickproapears = new ElementExists (helper);
        System.out.println(test.getText(CurrentStep));
        BooleanCheck.ReporterCheck(report, !test.getText(CurrentStep).contains("STEP 5 - FAR VISION\n" +
                "Right eye verification"), "va step shown before quick pro shown");
        BooleanCheck.ReporterCheck(report,true,"current step is "+ test.getText(CurrentStep));
        return ExecutionResult.PASSED;



    }
}
