package QuickMode;

import Pages.QuestionScreen;
import Settings.QuickModeSettings;
import Settings.Settings;
import Tools.ElementExists;
import io.Attribiute;
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
import io.testproject.proxy.addon.io.testproject.addon.imagecomparison.actions.generic.CompareTwoImages;
import org.openqa.selenium.By;



@Test(name = "Warning Message", version = "1.0")

public class WarningMessage implements AndroidTest {
    @Parameter(defaultValue = "1.5", direction = ParameterDirection.INPUT)
    public String Lmsphinterval;
    ExecutionResult executionResult;
    public AndroidTestHelper helper;
    public TestReporter report ;
    public AndroidDriver driver ;
    public AndroidActions test ;
    CompareTwoImages compareTwoImages;
    By CurrentStepHeader = By.id("selected_header_text");
    By warningmessage = By.id("text");
    By okbutton = By.id("ok_btn");


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
        if (newquickmode.WarningBetweenstepsCheck()) {
            BooleanCheck.ReporterCheck(report, newquickmode.WarningBetweensteps(), "turn on warning message settings ");
        }
        Measure();
        SphereBracketing newRightBracketing = new SphereBracketing(helper);
        ElementExists checkwarningmessage = new ElementExists(helper);
        By OccluderAttr = By.id("eye_right_toggle");

        while (Attribiute.Checked(OccluderAttr, helper)) {

            BooleanCheck.ReporterCheck(report, newRightBracketing.SelectRowOne(newRightBracketing.RightBracketRowOne),
                    "Right eye bracketing : row 1");

            BooleanCheck.ReporterCheck(report, newRightBracketing.SelectRowTwo(newRightBracketing.RightBracketRowTwo),
                    "Right eye  bracketing : row 2");

            BooleanCheck.ReporterCheck(report, newRightBracketing.ConfirmRowOne(newRightBracketing.RightConfirmRowOne),
                    "Right eye  bracketing : confirm row 1");
            if(checkwarningmessage.Exists(warningmessage)){
                 BooleanCheck.ReporterCheck(report, checkwarningmessage.Exists(warningmessage), "does warning message visible ");
                 BooleanCheck.ReporterCheck(report,  test.containsText(warningmessage,"I now switch to the left eye."), "does warning message contains text ");
                 test.clickIfVisible(okbutton);
                break;
            }
            }



        return ExecutionResult.PASSED;

    }


    public void Measure() throws FailureException {
        QuestionScreen newexam = new QuestionScreen(helper);
        BooleanCheck.ReporterCheck(report, newexam.OpenQuestionScreen(), "new exam");
        WfMeasurment newmeasure = new WfMeasurment(helper);
        newmeasure.StartMeasure();


    }



    public void Opensettings()  {

        Settings newSettings = new Settings(helper);
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings(), "open settings ");
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettingsQuickmodeTab(), "open quick mode tab");

    }
}