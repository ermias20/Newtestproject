package io;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.support.PageFactory;

public class InitQuickpro {

    public static double WfRightSphere;
    public static double WfLeftSphere;
    public static double WfRightCyl;
    public static double WfLeftCyl;
    public static double WfRightAxis;
    public static double WfLeftAxis;
    public static double FinalRightSphere;
    public static double FinalLeftSphere;
    public static double FinalRightCyl;
    public static double FinalLeftCyl;
    public static double FinalRightAxis;
    public static double FinalLeftAxis;
    public static double LmRightSphere;
    public static double LmLeftSphere;
    public static double LmRightCyl;
    public static double LmleftCyl;
    public static double LmRightAxis;
    public static double LmLeftAxis;
    public static double RowOneRightSphere;
    public static double RowOneLeftSphere;
    public static double RowOneRightCyl;
    public static double RowOneleftCyl;
    public static double RowOneRightAxis;
    public static double RowOneleftAxis;
    public static double RowTwoRightSphere;
    public static double RowTwoLeftSphere;
    public static double RowTwoRightCyl;
    public static double RowTwoleftCyl;
    public static double RowTwoRightAxis;
    public static double RowTwoleftAxis;
    @AndroidFindBy(id = "current_sphere_right_value")
    public static AndroidElement ByRightWfSphere;
    @AndroidFindBy(id = "current_sphere_left_value")
    public static AndroidElement ByLeftWfSphere;
    @AndroidFindBy(id = "current_cylinder_right_value")
    public static AndroidElement ByRightWfCyl;
    @AndroidFindBy(id = "current_cylinder_left_value")
    public static AndroidElement ByLeftWfCyl;
    @AndroidFindBy(id = "current_axis_right_value")
    public static AndroidElement ByRightWfAxis;
    @AndroidFindBy(id = "current_axis_left_value")
    public static AndroidElement ByLeftWfAxis;
    @AndroidFindBy(id = "current_sphere_right_value")
    public static AndroidElement ByRightFinalSphere;
    @AndroidFindBy(id = "current_sphere_left_value")
    public static AndroidElement ByLeftFinalSphere;
    @AndroidFindBy(id = "current_cylinder_right_value")
    public static AndroidElement ByRightFinalCyl;
    @AndroidFindBy(id = "current_cylinder_left_value")
    public static AndroidElement ByLeftFinalCyl;
    @AndroidFindBy(id = "current_axis_right_value")
    public static AndroidElement ByRightFinalAxis;
    @AndroidFindBy(id = "current_axis_left_value")
    public static AndroidElement ByLeftFinalAxis;
    @AndroidFindBy(id = "diff_sphere_right_value")
    public static AndroidElement ByRightLmSphere;
    @AndroidFindBy(id = "diff_sphere_left_value")
    public static AndroidElement ByLeftLmSphere;
    @AndroidFindBy(id = "diff_cylinder_right_value")
    public static AndroidElement ByRightLmCyl;
    @AndroidFindBy(id = "diff_cylinder_left_value")
    public static AndroidElement ByLeftLmCyl;
    @AndroidFindBy(id = "diff_axis_right_value")
    public static AndroidElement ByRightLmAxis;
    @AndroidFindBy(id = "diff_axis_left_value")
    public static AndroidElement ByLeftLmAxis;
    @AndroidFindBy(id = "original_sphere_right_value")
    public static AndroidElement ByRowTwoRightSphere;
    @AndroidFindBy(id = "original_sphere_left_value")
    public static AndroidElement ByRowTwoLeftSphere;
    @AndroidFindBy(id = "original_cylinder_right_value")
    public static AndroidElement ByRowTwoRightWfCyl;
    @AndroidFindBy(id = "original_cylinder_left_value")
    public static AndroidElement ByRowTwoLeftCyl;
    @AndroidFindBy(id = "original_axis_right_value")
    public static AndroidElement ByRowTwoRightAxis;
    @AndroidFindBy(id = "original_axis_left_value")
    public static AndroidElement ByRowTwoLeftAxis;
    @AndroidFindBy(id = "diff_sphere_right_value")
    public static AndroidElement RowOneRightLmSphere;
    @AndroidFindBy(id = "diff_sphere_left_value")
    public static AndroidElement RowOneLeftLmSphere;
    @AndroidFindBy(id = "diff_cylinder_right_value")
    public static AndroidElement RowOneRightLmCyl;
    @AndroidFindBy(id = "diff_cylinder_left_value")
    public static AndroidElement RowOneLeftLmCyl;
    @AndroidFindBy(id = "diff_axis_right_value")
    public static AndroidElement RowOneRightLmAxis;
    @AndroidFindBy(id = "diff_axis_left_value")
    public static AndroidElement RowOneLeftLmAxis;
    public AndroidDriver<AndroidElement> driver;

    public InitQuickpro(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void RightEyeBuffer() {
        RowOneRightSphere = Double.parseDouble(RowOneRightLmSphere.getText());
        RowOneRightCyl = Double.parseDouble(RowOneRightLmCyl.getText());
        RowOneRightAxis = Double.parseDouble(RowOneRightLmAxis.getText().replaceAll("\\D+", ""));

        RowTwoRightSphere = Double.parseDouble(ByRowTwoRightSphere.getText());
        RowTwoRightCyl = Double.parseDouble(ByRowTwoRightWfCyl.getText());
        RowTwoRightAxis = Double.parseDouble(ByRowTwoRightAxis.getText().replaceAll("\\D+", ""));
    }

    public void LeftEyeBuffer() {
        RowOneLeftSphere = Double.parseDouble(RowOneLeftLmSphere.getText());
        RowOneleftCyl = Double.parseDouble(RowOneLeftLmCyl.getText());
        RowOneleftAxis = Double.parseDouble(RowOneLeftLmAxis.getText().replaceAll("\\D+", ""));

        RowTwoLeftSphere = Double.parseDouble(ByRowTwoLeftSphere.getText());
        RowTwoleftCyl = Double.parseDouble(ByRowTwoLeftCyl.getText());
        RowTwoleftAxis = Double.parseDouble(ByRowTwoLeftAxis.getText().replaceAll("\\D+", ""));
    }

    public void FinalBuffer() {
        FinalRightSphere = Double.parseDouble(ByRightFinalSphere.getText());
        FinalRightCyl = Double.parseDouble(ByRightFinalCyl.getText());
        FinalRightAxis = Double.parseDouble(ByRightFinalAxis.getText().replaceAll("\\D+", ""));
        FinalLeftSphere = Double.parseDouble(ByLeftFinalSphere.getText());
        FinalLeftCyl = Double.parseDouble(ByLeftFinalCyl.getText());
        FinalLeftAxis = Double.parseDouble(ByLeftFinalAxis.getText().replaceAll("\\D+", ""));
    }


    public void RightHeadBuffer() {
        WfRightSphere = Double.parseDouble(ByRightWfSphere.getText());
        WfRightCyl = Double.parseDouble(ByRightWfCyl.getText());
        WfRightAxis = Double.parseDouble(ByRightWfAxis.getText().replaceAll("\\D+", ""));
    }

    public void LeftHeadBuffer() {
        WfLeftSphere = Double.parseDouble(ByLeftWfSphere.getText());
        WfLeftCyl = Double.parseDouble(ByLeftWfCyl.getText());
        WfLeftAxis = Double.parseDouble(ByLeftWfAxis.getText().replaceAll("\\D+", ""));
    }

}
