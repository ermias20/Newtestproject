package ExamFile;

import Pages.QuestionScreen;
import Settings.ExamFileSettings;
import Settings.Settings;
import Tools.ElementExists;
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
@Test(name = "Vertex Distance", version = "1.0")

public class VertexDistance implements AndroidTest {

    ExecutionResult executionResult;
    AndroidTestHelper helper;
    By CurrentStep = By.id("selected_header_text");
    By VDtoggle = By.id("right_track_text");
    @Parameter(defaultValue = "13", direction = ParameterDirection.INPUT)
    public int VDvalue;
    @Parameter(defaultValue = "-2", direction = ParameterDirection.INPUT)
    public double LeftsphereVerfication;
    @Parameter(defaultValue = "Optotype", direction = ParameterDirection.INPUT)
    public String Testtype;

    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
        TestReporter report = helper.getReporter();
        AndroidDriver driver = helper.getDriver();
        AndroidActions test = driver.testproject();
        this.helper= helper;

        Settings newSettings = new Settings(helper);
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings(), "open settings ");
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettingsExamfileTab(), "open exam file tab");
        ExamFileSettings Examfile = new ExamFileSettings(helper);
        BooleanCheck.ReporterCheck(report, Examfile.SetVDFrames(), "vertex distance settings selected");

        BooleanCheck.ReporterCheck(report, Examfile.SetVDContactLensesTwelveMM(VDvalue), VDvalue+" vertex distance settings selected");


        QuestionScreen newexam= new QuestionScreen(helper);
        BooleanCheck.ReporterCheck(report,   newexam.OpenQuestionScreen(), "new exam");

        WfMeasurment newmeasure = new WfMeasurment(helper);
        BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");

        By ok = By.id("ok_btn");
        By bracket = By.id("right_formula_equal");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        boolean popup ;

        boolean exists = driver.findElements(bracket).size() != 0;
        By b = By.id("advanced_next_step_btn");
        while (!exists) {

            driver.testproject().clickIfVisible(b);
            test.pause(1000);
            exists = driver.findElements(bracket).size() != 0;
             popup = driver.findElements(By.id("text")).size() != 0;
            if(popup)
            {
                test.clickIfVisible(ok);
            }

        }
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        InitQuickpro WfQuickProData = new InitQuickpro(driver);
        WfQuickProData.FinalBuffer();
        double WfsphRight = WfQuickProData.FinalRightSphere;
        double WfWfsphLeft  = WfQuickProData.FinalLeftSphere;
        double WfCylRight = WfQuickProData.FinalRightCyl;
        double WfCylLeft  = WfQuickProData.FinalLeftCyl;

        SphereBracketing newBracketing = new SphereBracketing(helper);
        newBracketing.bracketrighteye();
        newBracketing.bracketlefteye();

        InitQuickpro FinalQuickProData = new InitQuickpro(driver);
        FinalQuickProData.FinalBuffer();
        double FinalsphRight = FinalQuickProData.FinalRightSphere;
        double FinalWfsphLeft  = FinalQuickProData.FinalLeftSphere;
        double FinalCylRight = FinalQuickProData.FinalRightCyl;
        double FinalCylLeft  = FinalQuickProData.FinalLeftCyl;

        By export = By.id("advanced_export_btn");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
         exists = driver.findElements(export).size() != 0;
         b = By.id("advanced_next_step_btn");
        while (!exists) {
            driver.testproject().clickIfVisible(b);
            test.pause(1000);
            exists = driver.findElements(export).size() != 0;
        }
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        test.pause(1000);
        ElementExists waitforhome = new ElementExists(helper);
        waitforhome.clickOn(export,driver ,15000);
        driver.testproject().isVisible(By.id("measurement_list"));
        driver.testproject().click(VDtoggle);
        // Exam file Wf Measure data compare
        test.pause(2000);

        ExamFileMeasureData NewExamFileData = new ExamFileMeasureData(helper);

        double AfterVDWfsphRight = getBackVertexPower(WfsphRight);
        double AfterVDWfWfsphLeft = getBackVertexPower(WfWfsphLeft);
        double AfterVDWfCylRight = getBackVertexPower(WfsphRight+WfCylRight)-AfterVDWfsphRight;
        double AfterVDWfCylLeft =getBackVertexPower(WfWfsphLeft+WfCylLeft)-AfterVDWfWfsphLeft;
        double AfterVDFinalsphRight = getBackVertexPower(FinalsphRight);
        double AfterVDFinalWfsphLeft = getBackVertexPower(FinalWfsphLeft);
        double AfterVDFinalCylRight = getBackVertexPower(FinalsphRight+FinalCylRight)-AfterVDFinalsphRight;
        double FAfterVDinalCylLeft = getBackVertexPower(FinalWfsphLeft+FinalCylLeft)-AfterVDFinalWfsphLeft;


        BooleanCheck.ReporterCheck(report,AfterVDWfsphRight==NewExamFileData.WfRightSphere, AfterVDWfsphRight+" compare wf right sph vd check"+NewExamFileData.WfRightSphere);
        BooleanCheck.ReporterCheck(report,AfterVDWfWfsphLeft==NewExamFileData.WfLeftSphere,AfterVDWfWfsphLeft+" wf left sph vd check "+NewExamFileData.WfLeftSphere);
        BooleanCheck.ReporterCheck(report,AfterVDWfCylRight==NewExamFileData.WfRightCyl,AfterVDWfCylRight+" wf right cyl vd check "+NewExamFileData.WfRightCyl);
        BooleanCheck.ReporterCheck(report,AfterVDWfCylLeft==NewExamFileData.WfLeftCyl, AfterVDWfCylLeft+" wf left cyl vd check "+NewExamFileData.WfLeftCyl);
        BooleanCheck.ReporterCheck(report,AfterVDFinalsphRight==NewExamFileData.FinalRightSphere, AfterVDFinalsphRight+" Final right sph vd check "+NewExamFileData.FinalRightSphere);
        BooleanCheck.ReporterCheck(report,AfterVDFinalWfsphLeft==NewExamFileData.FinalLeftSphere, AfterVDFinalWfsphLeft+" Final left sph vd check "+NewExamFileData.FinalLeftSphere);
        BooleanCheck.ReporterCheck(report,AfterVDFinalCylRight==NewExamFileData.FinalRightCyl, AfterVDFinalCylRight+" Final right cyl vd check "+NewExamFileData.FinalRightCyl);
        BooleanCheck.ReporterCheck(report,FAfterVDinalCylLeft==NewExamFileData.FinalLeftCyl, FAfterVDinalCylLeft+" Final left cyl vd check "+NewExamFileData.FinalLeftCyl);

        // Report page Measure data compare

       // driver.testproject().clickIfVisible(By.id("printBtn"));
        //driver.testproject().isVisible(By.id("printBtn"));

        /*PdfReportMeasurmentData finalreportdata = new PdfReportMeasurmentData(helper);
        finalreportdata.PdfReportFinal();
        BooleanCheck.ReporterCheck(report,finalreportdata.FinalRightSphere==NewsphRight,"comparison between sphere verfication right sphere and report page sphere");
        BooleanCheck.ReporterCheck(report,finalreportdata.FinalLeftSphere==NewsphLeft,"comparison between sphere verfication left sphere and report page sphere");
*/
        return ExecutionResult.PASSED;

    }

    private double getBackVertexPower(final double backVertexPowerD)
    {
        int newVDvalue =0-VDvalue;
        return (double) Math.round((backVertexPowerD / (1.0 + 0.001 * newVDvalue * backVertexPowerD))*4)/4f;
    };

}
