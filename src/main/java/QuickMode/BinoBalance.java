package QuickMode;

import Pages.QuestionScreen;
import Settings.QuickModeSettings;
import Settings.Settings;
import Tools.ElementExists;
import Tools.EntersphereManaully;
import io.*;
import io.appium.java_client.MobileElement;
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

@Test(name = "bino balance", version = "1.0")

public class BinoBalance implements AndroidTest {

    ExecutionResult executionResult;

    By binobalancetest = By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[3]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]");
    String RightOccludexpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.ImageView[3]";
    String LeftOccludxpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.ImageView[3]";


    By CurrentStepHeader = By.id("selected_header_text");
    By CurrentStepText = By.id("selected_desc_text");
    By closebinotest = By.id("step1No");
    By backtobinotest = By.id("advanced_test_upper_name");
    public By backtobinotext = By.xpath("//*[@text='Binocular balance']");
    public By backtobino = By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[3]/android.widget.LinearLayout[1]/android.widget.TabHost[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[2]");
    By binotoprowopto = By.id("btnStarTopRow");
    By binoyes = By.id("step1Yes");


    By binobottomrowopto = By.id("btnStarBottomRow");
    By binoequalbutton = By.id("btnEqualRow");
    By leftbinobalancedelta = By.id("leftBinocularBalanceText");
    By rightbinobalancedelta = By.id("rightBinocularBalanceText");
    By Leftdeltaconfirm = By.id("left_subj1_formula_update");
    By Rightdeltaconfirm = By.id("right_subj1_formula_update");
    By RefreshStep = By.id("advanced_prefinished_step_init_step_btn");


    @Parameter(defaultValue = "do you see both lines ? simulataneously ? among each other ? click on the buttons according to the answers", direction = ParameterDirection.INPUT)
    public String binobalancefirstquestion;
    @Parameter(defaultValue = "please , look only the top line adjust the left sphere and click on v button", direction = ParameterDirection.INPUT)
    public String binobalancetopoptoquestion;
    @Parameter(defaultValue = "please , look only the bottom line adjust the right sphere and click on v button", direction = ParameterDirection.INPUT)
    public String binobalanceBottomoptoquestion;
    @Parameter(defaultValue = "-1.5", direction = ParameterDirection.INPUT)
    public double Rightspherebinobalance;
    @Parameter(defaultValue = "-2", direction = ParameterDirection.INPUT)
    public double Leftspherebinobalance;
    @Parameter(defaultValue = "Optotype", direction = ParameterDirection.INPUT)
    public String Testtype;
    String Rightpolorized ="RightPolorizedFilter";
    String Leftpolorized ="LeftPolorizedFilter";
    String binotest ="Binotest";
    String Toprow ="ToprowBinotest";
    String Bottomrow ="BottomrowBinotest";

    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
        TestReporter report = helper.getReporter();
        AndroidDriver driver = helper.getDriver();
        AndroidActions test = driver.testproject();
        driver.setTimeout(15000);
        Settings newSettings = new Settings(helper);
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings(), "open settings ");
        BooleanCheck.ReporterCheck(report, newSettings.OpenSettingsQuickmodeTab(), "open quick mode tab");
        QuickModeSettings newquickmode = new QuickModeSettings(helper);
        if(newquickmode.CheckbinocularBalanceState()){
            BooleanCheck.ReporterCheck(report, newquickmode.binocularBalance(), "binocular settings selected");
        }

        QuestionScreen newexam= new QuestionScreen(helper);
        BooleanCheck.ReporterCheck(report,   newexam.OpenQuestionScreen(), "new exam");

        WfMeasurment newmeasure = new WfMeasurment(helper);
        BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");
        SphereBracketing newBracketing = new SphereBracketing(helper);
        newBracketing.bracketrighteye();
        newBracketing.bracketlefteye();

        //bino balance step
        BooleanCheck.ReporterCheck(report,test.getText(CurrentStepHeader).contains("STEP 4 - FAR VISION\n" +
                "Binocular balance") , "sphere verification step shown");
        BooleanCheck.ReporterCheck(report,test.getText(CurrentStepText).contains(binobalancefirstquestion) , "bino balance first step shown step shown");
        BooleanCheck.ReporterCheck(report,true,"current step is "+ test.getText(CurrentStepHeader));


        MobileElement Rightele = (MobileElement) driver.findElementByXPath(RightOccludexpath);
        MobileElement BinoTest = (MobileElement) driver.findElement(binobalancetest);
        MobileElement Leftele = (MobileElement) driver.findElementByXPath(LeftOccludxpath);

       /* imageComparison Rightcomparison = new imageComparison();
        try {
            BooleanCheck.ReporterCheck(report ,Rightcomparison.compareImage(helper , binotest ,BinoTest)==ExecutionResult.PASSED, " compare bino balance test");
            BooleanCheck.ReporterCheck(report ,Rightcomparison.compareImage(helper ,Rightpolorized  ,Rightele)==ExecutionResult.PASSED, " right Polorized image compare result");
            BooleanCheck.ReporterCheck(report ,Rightcomparison.compareImage(helper ,Leftpolorized  ,Leftele)==ExecutionResult.PASSED, " Left Polorized image compare result");

        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        //check polo closede

//closebinobalance
    test.clickIfVisible(closebinotest);


     /*   try {
            BooleanCheck.ReporterCheck(report ,Rightcomparison.compareImage(helper ,"LeftOpaque"  ,Leftele)==ExecutionResult.PASSED, " after bino close right Polorized image compare result");
            BooleanCheck.ReporterCheck(report ,!test.getText(CurrentStepHeader).contains("STEP 4 - FAR VISION\n" +
                    "Binocular balance"), " after bino step closes check that step is not bino balance");

        } catch (Exception e) {
            BooleanCheck.ReporterCheck(report ,false, "exception ");

        }*/

        //toprow
        test.clickIfVisible(backtobinotext);
        test.clickIfVisible(binoyes);
        test.clickIfVisible(binotoprowopto);

        ElementExists deltaexist = new ElementExists(helper);
        BooleanCheck.ReporterCheck(report ,  deltaexist.Exists(leftbinobalancedelta), "check if left delta exist");
       /* try {
            ExecutionResult binotestimagecompare = Rightcomparison.compareImage(helper , Toprow ,BinoTest);
            BooleanCheck.ReporterCheck(report ,binotestimagecompare ==ExecutionResult.PASSED, " compare top row bino balance test");
            BooleanCheck.ReporterCheck(report ,Rightcomparison.compareImage(helper ,Rightpolorized  ,Rightele)==ExecutionResult.PASSED, " right Polorized image compare result");
            BooleanCheck.ReporterCheck(report ,Rightcomparison.compareImage(helper ,Leftpolorized  ,Leftele)==ExecutionResult.PASSED, " Left Polorized image compare result");

        } catch (IOException e) {
            e.printStackTrace();
        }*/

    //left eye sphere change
        InitQuickpro SpherebinobalQuickProData = new InitQuickpro(driver);
        BooleanCheck.ReporterCheck(report,test.getText(CurrentStepText).contains(binobalancetopoptoquestion) , "bino balance left step shown step shown");
        EntersphereManaully binobalancechange = new EntersphereManaully(helper);
        SpherebinobalQuickProData.FinalBuffer();
        double BeforesphLeft  = SpherebinobalQuickProData.FinalLeftSphere;

        binobalancechange.EnterManualvalue(leftbinobalancedelta,Leftspherebinobalance);
        SpherebinobalQuickProData.FinalBuffer();
        double AftersphLeft  = SpherebinobalQuickProData.FinalLeftSphere;

        BooleanCheck.ReporterCheck(report ,Leftspherebinobalance+BeforesphLeft == AftersphLeft, Leftspherebinobalance+BeforesphLeft+" and "+AftersphLeft+" compare bino balance left delta");
        //right eye sphere change
/*

        try {
            ExecutionResult binotestimagecompare = Rightcomparison.compareImage(helper , Bottomrow ,BinoTest);
            BooleanCheck.ReporterCheck(report ,binotestimagecompare ==ExecutionResult.PASSED, " compare bottom  row bino balance test");
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        BooleanCheck.ReporterCheck(report ,   test.clickIfVisible(Leftdeltaconfirm), "confirm left delta and move to right");



//right eye sphere change
        BooleanCheck.ReporterCheck(report,test.getText(CurrentStepText).contains(binobalanceBottomoptoquestion) , "bino balance right step shown step shown");
        SpherebinobalQuickProData.FinalBuffer();
        double BeforesphRight  = SpherebinobalQuickProData.FinalRightSphere;
        binobalancechange.EnterManualvalue(rightbinobalancedelta,Rightspherebinobalance);
        SpherebinobalQuickProData.FinalBuffer();
        double AftersphRight  = SpherebinobalQuickProData.FinalRightSphere;
        BooleanCheck.ReporterCheck(report ,Rightspherebinobalance+BeforesphRight == AftersphRight, Rightspherebinobalance+BeforesphRight+" "+AftersphRight+"compare bino balance right delta");
       /* try {
            ExecutionResult binotestimagecompare = Rightcomparison.compareImage(helper , Toprow ,BinoTest);
            BooleanCheck.ReporterCheck(report ,binotestimagecompare ==ExecutionResult.PASSED, " compare top  row bino balance test");
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        BooleanCheck.ReporterCheck(report ,   test.click(Rightdeltaconfirm), "confirm right delta and move to right");
        BooleanCheck.ReporterCheck(report ,   test.click(Leftdeltaconfirm), "confirm left delta and move to right");

        test.clickIfVisible(backtobinotext);
        test.clickIfVisible(binoyes);
        test.clickIfVisible(binotoprowopto);
        test.clickIfVisible(RefreshStep);

       /* try {
            BooleanCheck.ReporterCheck(report ,Rightcomparison.compareImage(helper ,"LeftOpaque"  ,Leftele)==ExecutionResult.PASSED, " after bino close right Polorized image compare result");
            BooleanCheck.ReporterCheck(report ,test.getText(CurrentStepHeader).contains("STEP 4 - FAR VISION\n" +
                    "Binocular balance"), " after bino step refresh check that step is still bino balance");
            BooleanCheck.ReporterCheck(report,test.getText(CurrentStepText).contains(binobalancefirstquestion) , "after refresh  bino balance right step shown  ");

        } catch (Exception e) {
            BooleanCheck.ReporterCheck(report ,false, "exception ");

        }
        test.clickIfVisible(closebinotest);
*/
        //toprow







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
        BooleanCheck.ReporterCheck(report,NewExamFileData.FinalRightSphere==AftersphRight,"comparison between bino balance right sphere and exam file sphere");
        BooleanCheck.ReporterCheck(report,NewExamFileData.FinalLeftSphere==AftersphLeft,"comparison between bino balance left sphere and exam file sphere");




        // Report page Measure data compare

        driver.testproject().clickIfVisible(By.id("printBtn"));
        driver.testproject().isVisible(By.id("printBtn"));

        PdfReportMeasurmentData finalreportdata = new PdfReportMeasurmentData(helper);
        finalreportdata.PdfReportFinal();
        BooleanCheck.ReporterCheck(report,finalreportdata.FinalRightSphere==AftersphRight,"comparison between sphere verfication right sphere and report page sphere");
        BooleanCheck.ReporterCheck(report,finalreportdata.FinalLeftSphere==AftersphLeft,"comparison between sphere verfication left sphere and report page sphere");



        return ExecutionResult.PASSED;



    }
}


