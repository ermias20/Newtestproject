package Export;

import Pages.QuestionScreen;
import Settings.ExportSettings;
import Settings.Settings;
import Tools.ElementExists;
import Tools.NextButton;
import Tools.ReadXMLFile;
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
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Test(name = "xml version", version = "1.0")

public class XmlVersion implements AndroidTest {

    ExecutionResult executionResult;
    AndroidTestHelper helper;
    By CurrentStep = By.id("selected_header_text");
    By VDtoggle = By.id("right_track_text");
    By export = By.id("advanced_export_btn");

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
        String xmlpath = "C:\\Users\\ermias\\Documents\\4842_20190409_144031_VX160_01.xml";

        Settings newSettings = new Settings(helper);
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings(), "open settings ");
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettingsExportTab(), "open export file tab");
        ExportSettings Export = new ExportSettings(helper);
        BooleanCheck.ReporterCheck(report, Export.SelectVesrion1(), "select xml version one");
        QuestionScreen newexam= new QuestionScreen(helper);
        BooleanCheck.ReporterCheck(report,   newexam.OpenQuestionScreen(), "new exam");

        WfMeasurment newmeasure = new WfMeasurment(helper);
        BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");

        NextButton nextbefore = new  NextButton(helper);
        nextbefore.BeforeBracketNext();
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
        nextbefore.AfterBracketNext();


        test.pause(1000);
        ElementExists waitforhome = new ElementExists(helper);
        waitforhome.clickOn(export,driver ,15000);
        driver.testproject().isVisible(By.id("measurement_list"));
        driver.testproject().click(VDtoggle);
        // Exam file Wf Measure data compare
        test.pause(2000);

        ExamFileMeasureData NewExamFileData = new ExamFileMeasureData(helper);

        try {
            ReadXMLFile xml = new ReadXMLFile(xmlpath);
            xml.FinalxmlData();
            xml.WfxmlData();
            xml.LmxmlData();
            BooleanCheck.ReporterCheck(report, true, " Encoding "+xml.doc.getXmlEncoding());
            BooleanCheck.ReporterCheck(report, true, " Xml Version "+xml.doc.getXmlVersion());
            BooleanCheck.ReporterCheck(report,true, " Base URI "+xml.doc.getBaseURI());


            BooleanCheck.ReporterCheck(report,xml.WfRightSphere==NewExamFileData.WfRightSphere, " compare wf right sph of xml and tablet ");
            BooleanCheck.ReporterCheck(report,xml.WfLeftSphere==NewExamFileData.WfLeftSphere," wf left sph of xml and tablet ");
            BooleanCheck.ReporterCheck(report,xml.WfRightCyl==NewExamFileData.WfRightCyl," wf right cyl of xml and tablet ");
            BooleanCheck.ReporterCheck(report,xml.WfLeftCyl==NewExamFileData.WfLeftCyl, " wf left cyl of xml and tablet ");
            BooleanCheck.ReporterCheck(report,xml.WfRightAxis==NewExamFileData.WfRightAxis, " Final right sph of xml and tablet ");
            BooleanCheck.ReporterCheck(report,xml.WfLeftAxis==NewExamFileData.WfLeftAxis, " Final right sph of xml and tablet ");
            BooleanCheck.ReporterCheck(report,xml.FinalRightSphere==NewExamFileData.FinalRightSphere, " Final right sph of xml and tablet ");
            BooleanCheck.ReporterCheck(report,xml.FinalLeftSphere==NewExamFileData.FinalLeftSphere, " Final right sph of xml and tablet ");
            BooleanCheck.ReporterCheck(report,xml.FinalRightCyl==NewExamFileData.FinalRightCyl, " Final right sph of xml and tablet ");
            BooleanCheck.ReporterCheck(report,xml.FinalLeftCyl==NewExamFileData.FinalLeftCyl, " Final left sph of xml and tablet ");
            BooleanCheck.ReporterCheck(report,xml.FinalRightAxis==NewExamFileData.FinalRightAxis, " Final right cyl of xml and tablet ");
            BooleanCheck.ReporterCheck(report,xml.FinalLeftAxis==NewExamFileData.FinalLeftAxis, " Final left cyl of xml and tablet ");





        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }


        return ExecutionResult.PASSED;

    }



}
