package xcyl;

import Pages.QuestionScreen;
import Settings.RefractionSettings;
import Settings.Settings;
import Tools.ElementExists;
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

@Test(name = "xcyl dots", version = "1.0")

public class XcylTestsDots implements AndroidTest {

    //public By Xcyl = By.id("access_xcyl");


    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
        By Xcyl = By.id("access_xcyl");
        By optotypeLayout = By.xpath("//*[@text='point_large']");
        By openaccessories = By.id("open_accessories");
        Boolean OptotypeExist = false;

        AndroidDriver driver = helper.getDriver();
        TestReporter report = helper.getReporter();
        AndroidActions test = driver.testproject();
        ExecutionResult executionResult;

        Settings newSettings = new Settings(helper);
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings()
                , "open settings ");

        newSettings.OpenSettingsRefractionTab();
        RefractionSettings RefractionTab = new RefractionSettings(helper);
        BooleanCheck.ReporterCheck(report, RefractionTab.SelectDots()
                , "select xcyl dots settings ");
        QuestionScreen newExam = new QuestionScreen(helper);
        BooleanCheck.ReporterCheck(report, newExam.OpenQuestionScreen()
                , "open question screen ");

        WfMeasurment newWfMeasurment = new WfMeasurment(helper);

        BooleanCheck.ReporterCheck(report, newWfMeasurment.StartMeasure()
                , "measurment ");
        BooleanCheck.ReporterCheck(report, test.clickIfVisible(openaccessories)
                , "open accessories wheel ");
        BooleanCheck.ReporterCheck(report, test.clickIfVisible(Xcyl)
                , "select xcyl");
        ElementExists XCylTest = new ElementExists(helper);

        if (XCylTest.Exists(optotypeLayout)) {
            if (test.getText(optotypeLayout).contentEquals("point_large")) {
                OptotypeExist = true;
            } else {
                OptotypeExist = false;

            }
        } else {
            OptotypeExist = false;

        }

        BooleanCheck.ReporterCheck(report, OptotypeExist, "selected optotype seen on chart ");
        return ExecutionResult.PASSED;

    }


}
