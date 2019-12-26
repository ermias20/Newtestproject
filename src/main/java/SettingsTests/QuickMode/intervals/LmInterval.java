package SettingsTests.QuickMode.intervals;

import Pages.QuestionScreen;
import Settings.QuickModeSettings;
import Settings.Settings;
import Tools.NextButton;
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

import java.io.IOException;

@Test(name = "Lm sphere and cylinder interval", version = "1.0")

public class LmInterval implements AndroidTest {
    ExecutionResult executionResult;

    @Parameter(defaultValue = "1.5", direction = ParameterDirection.INPUT)
    public String Lmsphinterval;
    @Parameter(defaultValue = "2.0", direction = ParameterDirection.INPUT)
    public String Lmcylinterval;
    By OccluderAttr = By.id("eye_right_toggle");

    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
        TestReporter report = helper.getReporter();
        AndroidDriver driver = helper.getDriver();
        AndroidActions test = driver.testproject();
        driver.setTimeout(1500);

        Settings newSettings =  new Settings(helper);

        BooleanCheck.ReporterCheck(report, newSettings.OpenSettings(), "open settings ");
        BooleanCheck.ReporterCheck(report,  newSettings.OpenSettingsQuickmodeTab(), "open quick mode tab");
        QuickModeSettings newquickmode = new QuickModeSettings(helper);

        newquickmode.LmSphererIntervalStep(Lmsphinterval);
        // newquickmode.CylinderIntervalStep("1.5");
        QuestionScreen newquestionscreen = new QuestionScreen(helper);
        newquestionscreen.OpenQuestionScreen();

        Lm addmanuallm = new Lm(helper);
        addmanuallm.OpenManualLmDialog();
        addmanuallm.EnterManualvalue(addmanuallm.RightSPh, -2.5);
        addmanuallm.EnterManualvalue(addmanuallm.LeftCyl, -1.5);
        addmanuallm.EnterManualvalue(addmanuallm.LeftSPh , -2.5);
        addmanuallm.EnterManualvalue(addmanuallm.LeftCyl, -1.5);
        addmanuallm.CloseManualLmDialog();
        //measure
        WfMeasurment newmeasure = new WfMeasurment(helper);
        BooleanCheck.ReporterCheck(report, newmeasure.StartMeasure(), "Measurement done");
        try {
            if (addmanuallm.DiffBetweenLmWf()){
                addmanuallm.ConfirmVal();
            }
        }catch (Exception e){

        }

        InitQuickpro init = new InitQuickpro(driver);
        init.RightEyeBuffer();
        Double absValSphinterval = Math.abs(Double.valueOf(Lmsphinterval));
        Double absCurrentSphinterval =  Math.abs(init.RowOneRightSphere-init.RowTwoRightSphere);
        BooleanCheck.ReporterCheck(report, absValSphinterval==absCurrentSphinterval, "sphere interval check ");

        By equalbutton = By.id("right_formula_equal");
        SphereBracketing newbracket = new SphereBracketing(helper);
        NextButton nextbefore = new  NextButton(helper);
        nextbefore.BeforeBracketNext();


        do {
            BooleanCheck.ReporterCheck(report, newbracket.SelectRowOne(newbracket.RightBracketRowOne),
                    "Right eye bracketing : row 1");
            BooleanCheck.ReporterCheck(report, newbracket.SelectRowTwo(newbracket.RightBracketRowTwo),
                    "Right eye  bracketing : row 2");
            if (Attribiute.Enabled(equalbutton, helper)){
                BooleanCheck.ReporterCheck(report, newbracket.ConfirmRowOne(newbracket.RightConfirmRowOne),
                        "Right eye  bracketing : confirm row 1");
                break;
            }
            BooleanCheck.ReporterCheck(report, newbracket.ConfirmRowOne(newbracket.RightConfirmRowOne),
                    "Right eye  bracketing : confirm row 1");

        }while (!Attribiute.Enabled(equalbutton, helper));

        init.RightEyeBuffer();
        Double absValCylinterval = Math.abs(Double.valueOf(Lmcylinterval));
        Double absCurrentCylinterval =  Math.abs(init.RowOneRightCyl-init.RowTwoRightCyl);
        BooleanCheck.ReporterCheck(report, absValCylinterval==absCurrentCylinterval, "cyl interval check ");

        while(Attribiute.Checked(OccluderAttr, helper)){
            BooleanCheck.ReporterCheck(report, newbracket.SelectRowOne(newbracket.RightBracketRowOne),
                    "Right eye bracketing : row 1");
            BooleanCheck.ReporterCheck(report, newbracket.SelectRowTwo(newbracket.RightBracketRowTwo),
                    "Right eye  bracketing : row 2");
            BooleanCheck.ReporterCheck(report, newbracket.ConfirmRowOne(newbracket.RightConfirmRowOne),
                    "Right eye  bracketing : confirm row 1");
        }

        // bracketing of left eye and data check

        SphereBracketing newLeftBracketing = new SphereBracketing(helper);
        init.LeftEyeBuffer();


        Double absValLeftSphinterval = Math.abs(Double.valueOf(Lmsphinterval));
        Double absCurrentLeftSphinterval =  Math.abs(init.RowOneLeftSphere-init.RowTwoLeftSphere);
        BooleanCheck.ReporterCheck(report, absValLeftSphinterval==absCurrentLeftSphinterval, "left sphere interval check ");

        By leftequalbutton = By.id("left_formula_equal");

        do {
            BooleanCheck.ReporterCheck(report, newLeftBracketing.SelectRowOne(newLeftBracketing.leftBracketRowOne),
                    "Right eye bracketing : row 1");
            BooleanCheck.ReporterCheck(report, newLeftBracketing.SelectRowTwo(newLeftBracketing.leftBracketRowTwo),
                    "Right eye  bracketing : row 2");
            if (Attribiute.Enabled(leftequalbutton, helper)){
                BooleanCheck.ReporterCheck(report, newLeftBracketing.ConfirmRowOne(newLeftBracketing.leftConfirmRowOne),
                        "Right eye  bracketing : confirm row 1");
                break;
            }
            BooleanCheck.ReporterCheck(report, newLeftBracketing.ConfirmRowOne(newLeftBracketing.leftConfirmRowOne),
                    "Right eye  bracketing : confirm row 1");

        }while (!Attribiute.Enabled(leftequalbutton, helper));

        init.LeftEyeBuffer();
        Double absValLeftCylinterval = Math.abs(Double.valueOf(Lmcylinterval));
        Double absCurrentLeftCylinterval =  Math.abs(init.RowOneleftCyl-init.RowTwoleftCyl);
        BooleanCheck.ReporterCheck(report, absValLeftCylinterval==absCurrentLeftCylinterval, "left cyl interval check ");


        try {
            EyeRefractRunner.runner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ExecutionResult.PASSED;

    }
}