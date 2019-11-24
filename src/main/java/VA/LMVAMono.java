package VA;

import Pages.QuestionScreen;
import Settings.QuickModeSettings;
import Settings.Settings;
import Tools.ElementExists;
import io.BooleanCheck;
import io.Lm;
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
import io.testproject.proxy.addon.io.testproject.addon.imagecomparison.actions.generic.CompareTwoImages;
import org.openqa.selenium.By;

@Test(name = "LM va mono", version = "1.0")

public class LMVAMono implements AndroidTest {
    @Parameter(defaultValue = "1.5", direction = ParameterDirection.INPUT)
    public String Lmsphinterval;
    ExecutionResult executionResult;
    public AndroidTestHelper helper;
    public TestReporter report ;
    public AndroidDriver driver ;
    public AndroidActions test ;
    CompareTwoImages compareTwoImages;
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
        if (!newquickmode.UnaidedVaBinoCheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.UnaidedVaBino(), "Unaided Va Bino settings off");
        }
        if (!newquickmode.UnaidedVaMonocheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.UnaidedVaMono(), "Unaided Va mono settings off");
        }
        if (newquickmode.NewdoalwaysCheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.Newdoalways(), "turn  do always verfication settings");
        }
        if (!newquickmode.NewVaBinobalanceCheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.NewVaBinobalance(), "turn off bino balance");
        }
        if (!newquickmode.NewSphVerCheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.NewSphVer(), "turn off sphere verfication settings ");
        }
        if (newquickmode.LmVaBinoCheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.LmVaBino(), "turn on lm va bino settings ");
        }
        if (newquickmode.LmVaMonocheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.LmVaMono(), "turn on lm va mono settings ");
        }
        MeasureandRefraction();
        CheckIfexist(true);
        Opensettings();
        newquickmode.swipedown();
        if (!newquickmode.LmVaBinoCheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.LmVaBino(), "turn off lm va bino settings ");
        }
        if (!newquickmode.LmVaMonocheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.LmVaMono(), "turn off lm va mono settings ");
        }
        MeasureandRefraction();
        CheckIfexist(true);

        return ExecutionResult.PASSED;

    }


    public void MeasureandRefraction() throws FailureException {
        QuestionScreen newexam = new QuestionScreen(helper);
        BooleanCheck.ReporterCheck(report, newexam.OpenQuestionScreen(), "new exam");

        Lm addmanuallm = new Lm(helper);
        addmanuallm.OpenManualLmDialog();
        addmanuallm.EnterManualvalue(addmanuallm.RightSPh,-1.75);
        addmanuallm.EnterManualvalue(addmanuallm.LeftSPh,-1.5);
        addmanuallm.EnterManualvalue(addmanuallm.RightCyl,-1.25);
        addmanuallm.EnterManualvalue(addmanuallm.LeftCyl,-0.75);
        addmanuallm.EnterManualAxisvalue(addmanuallm.Rightaxis,45);
        addmanuallm.EnterManualAxisvalue(addmanuallm.Leftaxis,90);
        addmanuallm.CloseManualLmDialog();

        WfMeasurment newmeasure = new WfMeasurment(helper);
        BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");
        try {
            if(addmanuallm.DiffBetweenLmWf()){

                addmanuallm.ConfirmVal();
                BooleanCheck.ReporterCheck(report, true, "confirm diff between lm and wf");

            }

        }catch (Exception e)
        {

        }
        BooleanCheck.ReporterCheck(report, test.getText(CurrentStepHeader).substring(8).contains("FAR VISION\n" +
                "LM VA measurement R&L"), "lm va step step shown");



    }

    public void CheckIfexist(Boolean vareport)   {
        ElementExists exists = new ElementExists(helper);
        Boolean righverficationstep =  test.getText(CurrentStepHeader).substring(8).contains ("FAR VISION\n" +
                "Right eye verification");
        Boolean LmvastepBino  = test.getText(CurrentStepHeader).substring(8).contains("FAR VISION\n" +
                "LM VA measurement R&L");
        Boolean LMvastepR  = test.getText(CurrentStepHeader).substring(8).contains("FAR VISION\n" +
                "LM VA measurement R");
        Boolean LMvastepL= test.getText(CurrentStepHeader).substring(8).contains("FAR VISION\n"
                + "LM VA measurement L");
        By next = By.id("advanced_next_step_btn");

        while (!righverficationstep) {
            righverficationstep =  test.getText(CurrentStepHeader).substring(8).contains("FAR VISION\n" +
                    "Right eye verification");
            if(righverficationstep){
                break;
            }
            driver.testproject().clickIfVisible(next);

            righverficationstep =  test.getText(CurrentStepHeader).substring(8).contains("FAR VISION\n" +
                    "Right eye verification");
            LmvastepBino  = test.getText(CurrentStepHeader).substring(8).contains("FAR VISION\n" +
                    "LM VA measurement R&L");
            LMvastepR  = test.getText(CurrentStepHeader).substring(8).contains("FAR VISION\n" +
                    "LM VA measurement R");
            LMvastepL= test.getText(CurrentStepHeader).substring(8).contains("FAR VISION\n"  +
                    "LM VA measurement L");

            if (LmvastepBino) {
                BooleanCheck.ReporterCheck(report, vareport, "LM bino  step found");

            }
            if (LMvastepR) {
                BooleanCheck.ReporterCheck(report, vareport, "LM right step found");

            }
            if (LMvastepL) {
                BooleanCheck.ReporterCheck(report, vareport, "LM left step found");
                break;
            }
        }
        ;


        if (!LMvastepR) {
            BooleanCheck.ReporterCheck(report, vareport, "LM right step not found");

        }
        if (!LMvastepL) {
            BooleanCheck.ReporterCheck(report, vareport, "LM left step not found");
        }

    }

    public void Opensettings()  {

        Settings newSettings = new Settings(helper);
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings(), "open settings ");
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettingsQuickmodeTab(), "open quick mode tab");

    }
}