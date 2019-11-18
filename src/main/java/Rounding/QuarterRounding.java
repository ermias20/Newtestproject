package Rounding;

import Pages.QuestionScreen;
import Settings.RefractionSettings;
import Settings.Settings;
import Tools.CheckRounding;
import io.BooleanCheck;
import io.ExamFileMeasureData;
import io.PdfReportMeasurmentData;
import io.WfMeasurment;
import io.testproject.java.annotations.v2.Test;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.tests.AndroidTest;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import io.testproject.proxy.addon.io.testproject.addon.imagecomparison.actions.generic.CompareTwoImages;
import org.openqa.selenium.By;

@Test(name = "QuarterRounding", version = "1.0")

public class QuarterRounding implements AndroidTest {
    ExecutionResult executionResult;
    CompareTwoImages compareTwoImages;
    Double ExamFileWFRightsphere;
    Double ExamFileWFlefttsphere;
    Double ExamFileFinalRightsphere;
    Double ExamFileFinalLeftsphere;
    Double ReportWFRightsphere;
    Double ReporWFLeftsphere;
    Double ReportFinalRightsphere;
    Double ReportFinalLeftsphere;

    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
        TestReporter report = helper.getReporter();
        AndroidDriver driver = helper.getDriver();
        AndroidActions test =  driver.testproject();
    By examfile = By.id("open_data_management");

        // open settings
        Settings newSettings = new Settings(helper);
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings(), "open settings ");
        newSettings.OpenSettingsRefractionTab();
        //open refraction settings and change vertical prism value
        RefractionSettings RefractionTab = new RefractionSettings(helper);
        BooleanCheck.ReporterCheck(report,RefractionTab.Quarter() , "0.25 sphere rounding chosen");
        QuestionScreen newquestionscreen = new QuestionScreen(helper);
        newquestionscreen.OpenQuestionScreen();
        //measure
        WfMeasurment newmeasure = new WfMeasurment(helper);
        BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");



        test.clickIfVisible(examfile);
        ExamFileMeasureData initexamfile = new ExamFileMeasureData(helper);
        this.ExamFileWFRightsphere= initexamfile.WfRightSphere;
        this.ExamFileWFlefttsphere=  initexamfile.WfLeftSphere;
        this.ExamFileFinalRightsphere=  initexamfile.FinalRightSphere;
        this.ExamFileFinalLeftsphere= initexamfile.FinalLeftSphere ;
        CheckRounding checkWf = new CheckRounding();

        BooleanCheck.ReporterCheck(report, checkWf.check(ExamFileWFRightsphere,0.25), "Exam file Right wf Sphere 0.25 rounding check");
        BooleanCheck.ReporterCheck(report, checkWf.check(ExamFileWFlefttsphere,0.25), "Exam file Left wf Sphere 0.25 rounding check");
        BooleanCheck.ReporterCheck(report, checkWf.check(ExamFileFinalRightsphere,0.25), "Exam file Right final Sphere 0.25 rounding check");
        BooleanCheck.ReporterCheck(report,  checkWf.check(ExamFileFinalLeftsphere,0.25), "Exam file Left final Sphere 0.25 rounding check");
        test.clickIfVisible(By.id("printBtn"));
        test.isVisible(By.id("printBtn"));
        PdfReportMeasurmentData inioreportpage = new PdfReportMeasurmentData(helper);
        inioreportpage.PdfReportWf();
        inioreportpage.PdfReportFinal();
        CheckRounding checkFinal = new CheckRounding();

        this.ReportWFRightsphere= inioreportpage.WfRightSphere;
        this.ReporWFLeftsphere=  inioreportpage.WfLeftSphere;
        this.ReportFinalRightsphere=  inioreportpage.FinalRightSphere;
        this.ReportFinalLeftsphere= inioreportpage.FinalLeftSphere ;
        BooleanCheck.ReporterCheck(report, checkFinal.check(ReportWFRightsphere,0.25), "Report page Right wf Sphere 0.25 rounding check");
        BooleanCheck.ReporterCheck(report, checkFinal.check(ReporWFLeftsphere,0.25), "Report page Right wf Sphere 0.25 rounding check");
        BooleanCheck.ReporterCheck(report,  checkFinal.check(ReportFinalRightsphere,0.25), "Report page Right wf Sphere 0.25 rounding check");
        BooleanCheck.ReporterCheck(report,  checkFinal.check(ReportFinalLeftsphere,0.25), "Report page Right wf Sphere 0.25 rounding check");





        return ExecutionResult.PASSED;


    }


}
