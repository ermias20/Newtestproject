package io;

import org.openqa.selenium.By;

import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;

public class QuickproMeasurmentData {
    public static double WfLeftSphere;
    public static double WfRightCyl;
    public static double WfLeftCyl;
    public static String WfRightAxis;
    public static String WfLeftAxis;
    public static double FinalRightSphere;
    public static double FinalLeftSphere;
    public static double FinalRightCyl;
    public static double FinalLeftCyl;
    public static String FinalRightAxis;
    public static String FinalLeftAxis;
    public static double LmRightSphere;
    public static double LmLeftSphere;
    public static double LmRightCyl;
    public static double LmleftCyl;
    public static String LmRightAxis;
    public static String LmLeftAxis;
    static AndroidDriver driver;
    //= "current_sphere_right_value";
    private static By ByLeftWfSphere = By.id("current_sphere_left_value");
    private static By ByRightWfCyl = By.id("current_cylinder_right_value");
    private static By ByLeftWfCyl = By.id("current_cylinder_left_value");
    private static By ByRightWfAxis = By.id("current_axis_right_value");
    private static By ByLeftWfAxis = By.id("current_axis_left_value");
    private static By ByRightFinalSphere = By.id("current_sphere_right_value");
    private static By ByLeftFinalSphere = By.id("current_sphere_left_value");
    private static By ByRightFinalCyl = By.id("current_cylinder_right_value");
    private static By ByLeftFinalCyl = By.id("current_cylinder_left_value");
    private static By ByRightFinalAxis = By.id("current_axis_right_value");
    private static By ByLeftFinalAxis = By.id("current_axis_left_value");
    private static By ByRightLmSphere = By.id("diff_sphere_right_value");
    private static By ByLeftLmSphere = By.id("diff_sphere_left_value");
    private static By ByRightLmCyl = By.id("diff_cylinder_right_value");
    private static By ByLeftLmCyl = By.id("diff_cylinder_left_value");
    private static By ByRightLmAxis = By.id("diff_axis_right_value");
    private static By ByLeftLmAxis = By.id("diff_axis_left_value");
    private static By RowTwoRightSphere = By.id("original_sphere_right_value");
    private static By RowTwoLeftSphere = By.id("original_sphere_left_value");
    private static By RowTwoRightWfCyl = By.id("original_cylinder_right_value");
    private static By RowTwoLeftCyl = By.id("original_cylinder_left_value");
    private static By RowTwoRightAxis = By.id("original_axis_right_value");
    private static By RowTwoLeftAxis = By.id("original_axis_left_value");


    public static void InitWfMeasurmentData(AndroidTestHelper helper) {

        driver = helper.getDriver();
        //WfRightSphere = Double.parseDouble(driver.findElement(ByRightWfSphere).getText());
        WfLeftSphere = Double.parseDouble(driver.findElement(ByLeftWfSphere).getText());
        WfRightCyl = Double.parseDouble(driver.findElement(ByRightWfCyl).getText());
        WfLeftCyl = Double.parseDouble(driver.findElement(ByLeftWfCyl).getText());
        WfRightAxis = driver.findElement(ByRightWfAxis).getText().replaceAll("\\D+", "");
        WfLeftAxis = driver.findElement(ByLeftWfAxis).getText().replaceAll("\\D+", "");
    }

    public static void InitFinalMeasurmentData(AndroidTestHelper helper) {
        driver = helper.getDriver();
        FinalRightSphere = Double.parseDouble(driver.findElement(ByRightFinalSphere).getText());
        FinalLeftSphere = Double.parseDouble(driver.findElement(ByLeftFinalSphere).getText());
        FinalRightCyl = Double.parseDouble(driver.findElement(ByRightFinalCyl).getText());
        FinalLeftCyl = Double.parseDouble(driver.findElement(ByLeftFinalCyl).getText());
        FinalRightAxis = driver.findElement(ByRightFinalAxis).getText().replaceAll("\\D+", "");
        FinalLeftAxis = driver.findElement(ByLeftFinalAxis).getText().replaceAll("\\D+", "");


    }


    public static void InitLmMeasurmentData(AndroidTestHelper helper) {
        driver = helper.getDriver();
        LmRightSphere = Double.parseDouble(driver.findElement(ByRightLmSphere).getText());
        LmLeftSphere = Double.parseDouble(driver.findElement(ByLeftLmSphere).getText());
        LmRightCyl = Double.parseDouble(driver.findElement(ByRightLmCyl).getText());
        LmleftCyl = Double.parseDouble(driver.findElement(ByLeftLmCyl).getText());
        LmRightAxis = driver.findElement(ByRightLmAxis).getText().replaceAll("\\D+", "");
        LmLeftAxis = driver.findElement(ByLeftLmAxis).getText().replaceAll("\\D+", "");

    }

}
