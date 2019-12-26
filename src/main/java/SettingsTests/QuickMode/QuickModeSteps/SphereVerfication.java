package SettingsTests.QuickMode.QuickModeSteps;

import Pages.QuestionScreen;
import Settings.QuickModeSettings;
import Settings.Settings;
import Tools.EntersphereManaully;
import io.*;
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

import java.util.concurrent.TimeUnit;
@Test(name = "Sphere Verfication", version = "1.0")

public class SphereVerfication implements AndroidTest {

    ExecutionResult executionResult;


    By CurrentStep = By.id("selected_header_text");
    @Parameter(defaultValue = "-1.5", direction = ParameterDirection.INPUT)
    public double RightsphereVerfication;
    @Parameter(defaultValue = "-2", direction = ParameterDirection.INPUT)
    public double LeftsphereVerfication;
    @Parameter(defaultValue = "Optotype", direction = ParameterDirection.INPUT)
    public String Testtype;

    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
        TestReporter report = helper.getReporter();
        AndroidDriver driver = helper.getDriver();
        AndroidActions test = driver.testproject();
        Settings newSettings = new Settings(helper);
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings(), "open settings ");
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettingsQuickmodeTab(), "open quick mode tab");
        QuickModeSettings newquickmode = new QuickModeSettings(helper);
        if(newquickmode.CheckSphereVerficationSwitchState()){
            BooleanCheck.ReporterCheck(report, newquickmode.SphereVerficationSwitch(), "sphere verification settings selected");
        }
        BooleanCheck.ReporterCheck(report, newquickmode.EnterSphereVerficationTest(Testtype), "sphere verification optotype test selected");

        QuestionScreen newexam= new QuestionScreen(helper);
        BooleanCheck.ReporterCheck(report,   newexam.OpenQuestionScreen(), "new exam");

        WfMeasurment newmeasure = new WfMeasurment(helper);
        BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");
        SphereBracketing newBracketing = new SphereBracketing(helper);
        newBracketing.bracketrighteye();
        newBracketing.bracketlefteye();

        BooleanCheck.ReporterCheck(report,test.getText(CurrentStep).contains("STEP 4 - FAR VISION\n" +
                "Sphere verification R&L") , "sphere verification step shown");
        BooleanCheck.ReporterCheck(report,true,"current step is "+ test.getText(CurrentStep));
        InitQuickpro SphereverQuickProData = new InitQuickpro(driver);
        SphereverQuickProData.FinalBuffer();
        double sphRight = SphereverQuickProData.FinalRightSphere;
        double sphLeft  = SphereverQuickProData.FinalLeftSphere;

        EntersphereManaully sphereverfication = new EntersphereManaully(helper);
        sphereverfication.EnterManualvalue(sphereverfication.rightsph,RightsphereVerfication);
        sphereverfication.EnterManualvalue(sphereverfication.leftsph,LeftsphereVerfication);

        SphereverQuickProData.FinalBuffer();
        double NewsphRight = SphereverQuickProData.FinalRightSphere;
        double NewsphLeft  = SphereverQuickProData.FinalLeftSphere;




        By export = By.id("advanced_export_btn");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        boolean exists = driver.findElements(export).size() != 0;
        By b = By.id("advanced_next_step_btn");
        while (!exists) {
            driver.testproject().clickIfVisible(b);
            exists = driver.findElements(export).size() != 0;
        }
        ;
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        driver.testproject().click(export);
        driver.testproject().isVisible(By.id("measurement_list"));

        // Exam file Wf Measure data compare
        ExamFileMeasureData NewExamFileData = new ExamFileMeasureData(helper);




        // Exam file Final Measure data compare
        BooleanCheck.ReporterCheck(report,NewExamFileData.FinalRightSphere==NewsphRight,"comparison between sphere verfication right sphere and exam file sphere");
        BooleanCheck.ReporterCheck(report,NewExamFileData.FinalLeftSphere==NewsphLeft,"comparison between sphere verfication left sphere and exam file sphere");




        // Report page Measure data compare

        driver.testproject().clickIfVisible(By.id("printBtn"));
        driver.testproject().isVisible(By.id("printBtn"));

        PdfReportMeasurmentData finalreportdata = new PdfReportMeasurmentData(helper);
        finalreportdata.PdfReportFinal();
        BooleanCheck.ReporterCheck(report,finalreportdata.FinalRightSphere==NewsphRight,"comparison between sphere verfication right sphere and report page sphere");
        BooleanCheck.ReporterCheck(report,finalreportdata.FinalLeftSphere==NewsphLeft,"comparison between sphere verfication left sphere and report page sphere");




        return ExecutionResult.PASSED;



    }
}
