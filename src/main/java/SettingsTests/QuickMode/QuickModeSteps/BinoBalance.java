package SettingsTests.QuickMode.QuickModeSteps;

import Pages.QuestionScreen;
import Settings.QuickModeSettings;
import Settings.Settings;
import Tools.*;
import io.SphereBracketing;
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

import java.io.File;

@Test(name = "bino balance", version = "1.0")

public class BinoBalance implements AndroidTest {

    ExecutionResult executionResult;

    By binobalancetest = By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[3]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]");
    String RightOccludexpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.ImageView[3]";

    String LeftOccludxpath   = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.ImageView[4]";

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
        if(!newquickmode.CheckbinocularBalanceState()){
            BooleanCheck.ReporterCheck(report, newquickmode.binocularBalance(), "binocular settings selected");
        }

        QuestionScreen newexam= new QuestionScreen(helper);
        BooleanCheck.ReporterCheck(report,   newexam.OpenQuestionScreen(), "new exam");

        WfMeasurment newmeasure = new WfMeasurment(helper);
        BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");
        NextButton nextbefore = new  NextButton(helper);
        nextbefore.BeforeBracketNext();
        SphereBracketing newBracketing = new SphereBracketing(helper);
        newBracketing.bracketrighteye();
        newBracketing.bracketlefteye();

        //bino balance step
        BooleanCheck.ReporterCheck(report,test.getText(CurrentStepHeader).contains("STEP 7 - FAR VISION\n" +
                "Binocular balance") , "sphere verification step shown");
        BooleanCheck.ReporterCheck(report,test.getText(CurrentStepText).contains(binobalancefirstquestion) , "bino balance first step shown step shown");
        BooleanCheck.ReporterCheck(report,true,"current step is "+ test.getText(CurrentStepHeader));


        MobileElement Rightele = (MobileElement) driver.findElementByXPath(RightOccludexpath);
        MobileElement BinoTest = (MobileElement) driver.findElement(binobalancetest);
        MobileElement Leftele = (MobileElement) driver.findElementByXPath(LeftOccludxpath);


        ScreenShotByCoord takescreenshot = new ScreenShotByCoord(helper);
        takescreenshot.ScreenShot(Rightele, Rightpolorized);

        BaseCompareImages action = new BaseCompareImages();
        action.setThreshold("15");
        File Resourcesdirectory = new File("src/main/Resources/Red.png");
        File Screenshotdirectory = new File("src/main/Resources/Screenshots/Red.png");
        BooleanCheck.ReporterCheck(report, action.compareImagesUtils(Resourcesdirectory,Screenshotdirectory,report) ==ExecutionResult.PASSED, "Red Filter bino balance image compare result");



        takescreenshot.ScreenShot(Leftele, Leftpolorized);
        BooleanCheck.ReporterCheck(report, action.compareImagesUtils(new File("src/main/Resources/LeftOpaque.png"),new File("src/main/Resources/Screenshots/LeftOpaque.png"),report) ==ExecutionResult.PASSED, "Left Polorized Filter bino balance image compare result");

        takescreenshot.ScreenShot(BinoTest, binotest);
        BooleanCheck.ReporterCheck(report, action.compareImagesUtils(new File("src/main/Resources/Binotest.png"),new File("src/main/Resources/Screenshots/Binotest.png"),report) ==ExecutionResult.PASSED, " compare bino balance test");



    test.clickIfVisible(closebinotest);
        /*takescreenshot.ScreenShot(Leftele, "RightOpaque");
        BooleanCheck.ReporterCheck(report, action.compareImagesUtils(new File("src/main/Resources/LeftOpaque.png"),new File("src/main/Resources/Screenshots/LeftOpaque.png"),report) ==ExecutionResult.PASSED, "Check there is no polorized step after bino balance closed");
     */   BooleanCheck.ReporterCheck(report ,!test.getText(CurrentStepHeader).contains("STEP 7 - FAR VISION\n" +
                "Binocular balance"), " after bino step closes check that step is not bino balance");


        //toprow
        test.clickIfVisible(backtobinotext);
        test.clickIfVisible(binoyes);
        test.clickIfVisible(binotoprowopto);

        ElementExists deltaexist = new ElementExists(helper);
        BooleanCheck.ReporterCheck(report ,  deltaexist.Exists(leftbinobalancedelta), "check if left delta exist");

        takescreenshot.ScreenShot(Rightele, Rightpolorized);

        BooleanCheck.ReporterCheck(report, action.compareImagesUtils(new File("src/main/Resources/Red.png"),new File("src/main/Resources/Screenshots/Red.png"),report) ==ExecutionResult.PASSED, "Right Polorized Filter bino balance image compare result");

        takescreenshot.ScreenShot(Leftele, Leftpolorized);
        BooleanCheck.ReporterCheck(report, action.compareImagesUtils(new File("src/main/Resources/LeftOpaque.png"),new File("src/main/Resources/Screenshots/LeftOpaque.png"),report) ==ExecutionResult.PASSED, "Left Polorized Filter bino balance image compare result");

        takescreenshot.ScreenShot(BinoTest, Toprow);
        BooleanCheck.ReporterCheck(report, action.compareImagesUtils(new File("src/main/Resources/ToprowBinotest.png"),new File("src/main/Resources/Screenshots/ToprowBinotest.png"),report) ==ExecutionResult.PASSED, " compare top row bino balance test");



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



        takescreenshot.ScreenShot(BinoTest, Bottomrow);
        BooleanCheck.ReporterCheck(report, action.compareImagesUtils(new File("src/main/Resources/BottomrowBinotest.png"),new File("src/main/Resources/Screenshots/BottomrowBinotest.png"),report) ==ExecutionResult.PASSED, "Bottom row Binotest bino balance test");



        BooleanCheck.ReporterCheck(report ,   test.clickIfVisible(Leftdeltaconfirm), "confirm left delta and move to right");



//right eye sphere change
        BooleanCheck.ReporterCheck(report,test.getText(CurrentStepText).contains(binobalanceBottomoptoquestion) , "bino balance right step shown step shown");
        SpherebinobalQuickProData.FinalBuffer();
        double BeforesphRight  = SpherebinobalQuickProData.FinalRightSphere;
        binobalancechange.EnterManualvalue(rightbinobalancedelta,Rightspherebinobalance);
        SpherebinobalQuickProData.FinalBuffer();
        double AftersphRight  = SpherebinobalQuickProData.FinalRightSphere;
        BooleanCheck.ReporterCheck(report ,Rightspherebinobalance+BeforesphRight == AftersphRight, Rightspherebinobalance+BeforesphRight+" "+AftersphRight+"compare bino balance right delta");


       takescreenshot.ScreenShot(BinoTest, Toprow);
        BooleanCheck.ReporterCheck(report, action.compareImagesUtils(new File("src/main/Resources/ToprowBinotest.png"),new File("src/main/Resources/Screenshots/ToprowBinotest.png"),report) ==ExecutionResult.PASSED, " compare top  row bino balance test");


        BooleanCheck.ReporterCheck(report ,   test.click(Rightdeltaconfirm), "confirm right delta and move to right");
        BooleanCheck.ReporterCheck(report ,   test.click(Leftdeltaconfirm), "confirm left delta and move to right");

        test.clickIfVisible(backtobinotext);
        test.clickIfVisible(binoyes);
        test.clickIfVisible(binotoprowopto);
        test.clickIfVisible(RefreshStep);



        takescreenshot.ScreenShot(Leftele, "LeftOpaque");
        BooleanCheck.ReporterCheck(report, action.compareImagesUtils(new File("src/main/Resources/LeftOpaque.png"),new File("src/main/Resources/Screenshots/LeftOpaque.png"),report) ==ExecutionResult.PASSED, " after bino close right Polorized image compare result");

            BooleanCheck.ReporterCheck(report ,test.getText(CurrentStepHeader).contains("STEP 4 - FAR VISION\n" + "Binocular balance"), " after bino step refresh check that step is still bino balance");
            BooleanCheck.ReporterCheck(report,test.getText(CurrentStepText).contains(binobalancefirstquestion) , "after refresh  bino balance right step shown  ");


        test.clickIfVisible(closebinotest);

        //toprow

        By export = By.id("advanced_export_btn");
        nextbefore.AfterBracketNext();


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


