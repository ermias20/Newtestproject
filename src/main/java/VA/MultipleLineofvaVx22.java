package VA;

import Pages.QuestionScreen;
import Settings.QuickModeSettings;
import Settings.Settings;
import io.BooleanCheck;
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
import org.openqa.selenium.WebElement;

import java.util.List;

@Test(name = "Multiple line of va", version = "1.0")

public class MultipleLineofvaVx22 implements AndroidTest {
    @Parameter(defaultValue = "1.5", direction = ParameterDirection.INPUT)
    public String Lmsphinterval;
    ExecutionResult executionResult;

    CompareTwoImages compareTwoImages;

         By OccluderAttr = By.id("eye_right_toggle");
     String RightPolorizedFilter = "RightPolorizedFilter";
    By VALines = By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[3]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[2]/android.view.View[*]");

    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
        TestReporter report = helper.getReporter();
        AndroidDriver driver = helper.getDriver();
        AndroidActions test = driver.testproject();
        Settings newSettings = new Settings(helper);
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings(), "open settings ");
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettingsQuickmodeTab(), "open quick mode tab");
        QuickModeSettings newquickmode = new QuickModeSettings(helper);
        if(!newquickmode.CheckOneLineofVaState()){
            BooleanCheck.ReporterCheck(report, newquickmode.OneLineofVa(), "multiple row settings selected");
        }
        QuestionScreen newexam= new QuestionScreen(helper);
        BooleanCheck.ReporterCheck(report,         newexam.OpenQuestionScreen(), "new exam");

        WfMeasurment newmeasure = new WfMeasurment(helper);
        BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");
        List<WebElement> elements = (List<WebElement>) driver.findElements(VALines);
        BooleanCheck.ReporterCheck(report, elements.size()>0, "multiple rows of va shown");

        return ExecutionResult.PASSED;



    }
}