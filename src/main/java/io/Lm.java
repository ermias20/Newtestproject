package io;


import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class Lm {
    static AndroidDriver driver;
    static AndroidActions test;
    private static By LoadLsm = By.id("question_one_yes");
    private static By NoLmessage = By.xpath(
            "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]");
    private static By DiffBetweenLmAndWf = By.id("va_warnings_options");
    private static By confirmValue = By.id("confirmValue");
    private static By deleteDataValue = By.id("deleteDataValue");
    By plus = By.id("step_plus");
    By minus = By.id("step_minus");

    By SetLsm = By.id("set_manually_lm");

    By SaveLsm = By.id("set_btn");
    By AxisStep = By.id("step_spec");
    By ZeroDegree = By.id("upper_first_value");
    By FourtyFiveDegree = By.id("upper_second_value");
    By NintyDegree = By.id("upper_third_value");
    By HundredThirtyFiveDegree = By.id("upper_fourth_value");

    public static double LmRightSphere;
    public static double LmLeftSphere;
    public static double LmRightCyl;
    public static double LmleftCyl;
    public static String LmRightAxis;
    public static String LmLeftAxis;

    public static By ByLmRightSphere = By.id("right_sphere_buffer");
    public static By ByLmLeftSphere = By.id("left_sphere_buffer");
    public static By ByLmRighttCyl = By.id("right_cylinder_buffer");
    public static By ByLmLeftCyl = By.id("left_cylinder_buffer");
    public static By ByRightLmAxis = By.id("right_axis_buffer");
    public static By ByLeftLmAxis = By.id("left_axis_buffer");

    public static By RightSPh = By.id("current_sphere_right_value");
    public static By LeftSPh = By.id("current_sphere_left_value");
    public static By RightCyl = By.id("current_cylinder_right_value");
    public static By LeftCyl = By.id("current_cylinder_left_value");
    public static By Rightaxis = By.id("current_axis_right_value");
    public static  By Leftaxis = By.id("current_axis_left_value");
    public Lm(AndroidTestHelper helper) {
        driver = helper.getDriver();
        test = helper.getDriver().testproject();
        this.driver.setTimeout(5000);
    }


    public static void InitLmMeasurmentData() {

        LmRightSphere = Double.parseDouble(driver.findElement(ByLmRightSphere).getText());
        LmLeftSphere = Double.parseDouble(driver.findElement(ByLmLeftSphere).getText());
        LmRightCyl = Double.parseDouble(driver.findElement(ByLmRighttCyl).getText());
        LmleftCyl = Double.parseDouble(driver.findElement(ByLmLeftCyl).getText());
        LmRightAxis = driver.findElement(ByRightLmAxis).getText().replaceAll("\\D+", "");
        LmLeftAxis = driver.findElement(ByLeftLmAxis).getText().replaceAll("\\D+", "");

    }

    public boolean LoadLsmData() {
        return test.clickIfVisible(LoadLsm);
    }

    public boolean ConfirmVal() {
        return test.clickIfVisible(confirmValue);
    }

    public boolean NoLsmData() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        boolean exists = driver.findElements(NoLmessage).size() != 0;
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        return exists;
    }

    public boolean DiffBetweenLmWf() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        boolean exists = driver.findElements(DiffBetweenLmAndWf).size() != 0;
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        return exists;
    }

    public boolean OpenManualLmDialog() {
        test.clickIfVisible(LoadLsm);
        return test.clickIfVisible(SetLsm);

    }
    public boolean CloseManualLmDialog() {
        return test.clickIfVisible(SaveLsm);

    }
    public void EnterManualvalue(By by, double Lmvalue) {

        test.clickIfVisible(by);
        double CurrentLmValue = Double.parseDouble(test.getText(by));
        while (Lmvalue != CurrentLmValue) {
            if(Lmvalue>0){
                test.clickIfVisible(plus);
            }else{
                test.clickIfVisible(minus);
            }
            CurrentLmValue = Double.parseDouble(test.getText(by));

        }
    }

    public void EnterManualAxisvalue(By by, int Value) {
        test.clickIfVisible(by);
        test.clickIfVisible(AxisStep);

        switch (Value) {
            case 0:
                test.clickIfVisible(ZeroDegree);
                break;
            case 45:
                test.clickIfVisible(FourtyFiveDegree);
                break;

            case 90:
                test.clickIfVisible(NintyDegree);
                break;

            case 135:
                test.clickIfVisible(HundredThirtyFiveDegree);
                break;
            default:
                break;
        }


    }


}
