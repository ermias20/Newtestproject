package VA;



import Pages.QuestionScreen;
import Settings.QuickModeSettings;
import Settings.Settings;
import Tools.ElementExists;
import io.BooleanCheck;
import io.SphereBracketing;
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

@Test(name = "unaided va mono", version = "1.0")

public class UnaidedVAMono implements AndroidTest {
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
        if (newquickmode.UnaidedVaMonocheck()) {
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
        CheckIfexist(true);

        Opensettings();
        newquickmode.swipedown();
        if (!newquickmode.VaBinoCheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.VaMono(), "Va Bino settings off");
        }
        if (!newquickmode.UnaidedVaMonocheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.UnaidedVaMono(), "Unaided Va mono settings off");
        }
        MeasureandRefraction();
        CheckIfexist(true);
        return ExecutionResult.PASSED;

    }


    public void MeasureandRefraction() throws FailureException {
        QuestionScreen newexam = new QuestionScreen(helper);
        BooleanCheck.ReporterCheck(report, newexam.OpenQuestionScreen(), "new exam");

        WfMeasurment newmeasure = new WfMeasurment(helper);
        BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");
        BooleanCheck.ReporterCheck(report, test.getText(CurrentStepHeader).contains("STEP 2 - FAR VISION\n" +
                "Unaided VA measurement R&L"), "Unaided step shown");        SphereBracketing newBracketing = new SphereBracketing(helper);



    }



    public void CheckIfexist(Boolean vareport)   {
        ElementExists exists = new ElementExists(helper);
        Boolean righverficationstep =  test.getText(CurrentStepHeader).contains("STEP 5 - FAR VISION\n" +
                "Right eye verification");
        Boolean stepthreerighverficationstep =  test.getText(CurrentStepHeader).contains("STEP 3 - FAR VISION\n" +
                "Right eye verification");

        Boolean unaidedvastepBino  = test.getText(CurrentStepHeader).contains("STEP 2 - FAR VISION\n" +
                "Unaided VA measurement R&L");
        Boolean unaidedvastepR  = test.getText(CurrentStepHeader).contains("STEP 3 - FAR VISION\n" +
                "Unaided VA measurement R");
        Boolean unaidedvastepL= test.getText(CurrentStepHeader).contains("STEP 4 - FAR VISION\n"  + "Unaided VA measurement L");
        By next = By.id("advanced_next_step_btn");

        while (!righverficationstep) {
            stepthreerighverficationstep =  test.getText(CurrentStepHeader).contains("STEP 3 - FAR VISION\n" +
                    "Right eye verification");
            if(stepthreerighverficationstep){
                break;
            }
            driver.testproject().clickIfVisible(next);

             righverficationstep =  test.getText(CurrentStepHeader).contains("STEP 5 - FAR VISION\n" +
                    "Right eye verification");
             unaidedvastepBino  = test.getText(CurrentStepHeader).contains("STEP 2 - FAR VISION\n" +
                    "Unaided VA measurement R&L");
             unaidedvastepR  = test.getText(CurrentStepHeader).contains("STEP 3 - FAR VISION\n" +
                    "Unaided VA measurement R");
             unaidedvastepL= test.getText(CurrentStepHeader).contains("STEP 4 - FAR VISION\n"  + "Unaided VA measurement L");

            if (unaidedvastepBino) {
                BooleanCheck.ReporterCheck(report, vareport, "Unaided bino  step found");

            }
            if (unaidedvastepR) {
                BooleanCheck.ReporterCheck(report, vareport, "Unaided right step found");

            }
            if (unaidedvastepL) {
                BooleanCheck.ReporterCheck(report, vareport, "Unaided left step found");
                break;
            }
        }
        ;

        if (!unaidedvastepBino) {
            BooleanCheck.ReporterCheck(report, vareport, "Unaided bino step not found");

        }
        if (!unaidedvastepR) {
            BooleanCheck.ReporterCheck(report, vareport, "Unaided right step not found");

        }
        if (!unaidedvastepL) {
            BooleanCheck.ReporterCheck(report, vareport, "Unaided left step not found");
        }

    }
    public void Opensettings()  {

        Settings newSettings = new Settings(helper);
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings(), "open settings ");
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettingsQuickmodeTab(), "open quick mode tab");

    }
}