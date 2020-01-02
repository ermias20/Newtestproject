package SettingsTests.Measure;

import Pages.QuestionScreen;
import Tools.ElementExists;
import io.BooleanCheck;
import io.WfMeasurment;
import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.annotations.v2.Test;
import io.testproject.java.enums.ParameterDirection;
import io.testproject.java.enums.TakeScreenshotConditionType;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.tests.AndroidTest;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import org.openqa.selenium.By;

@Test(name = "Measure Loop ", version = "1.0")

public class MeasureLoop implements AndroidTest {


    By popupmessage = By.id("message_content");
    public TestReporter report ;
    @Parameter(defaultValue = "2", direction = ParameterDirection.INPUT)
    public int loop;


    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {



        try {

        for (int i = 0; i < loop; i++) {
             report = helper.getReporter();
            AndroidDriver driver = helper.getDriver();
            AndroidActions test = driver.testproject();
            driver.setTimeout(15000);
            BooleanCheck.ReporterCheck(report, true, "start new measure ");
            QuestionScreen newexam = new QuestionScreen(helper);
            WfMeasurment newmeasure = new WfMeasurment(helper);
            BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");





            report.step(" picture of measure number"+i, true, TakeScreenshotConditionType.Always);

            ElementExists measurestopped = new ElementExists(helper);
            BooleanCheck.ReporterCheck(report, measurestopped.Exists(popupmessage), "Measurement stopped message");
            BooleanCheck.ReporterCheck(report, newexam.OpenQuestionScreen(), "new exam");
        }
}catch (Exception e){
   ExecutionResult.valueOf(e.toString());
        report.step("exception "+e, false, TakeScreenshotConditionType.Always);}
        return ExecutionResult.PASSED;

    }
}