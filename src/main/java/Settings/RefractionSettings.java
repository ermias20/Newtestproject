package Settings;


import org.openqa.selenium.By;

import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.reporters.Reporter;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
public class RefractionSettings {
    public By XcylDots = By.xpath("//*[@text='Dots']");
    public By Optotype = By.xpath("//*[@text='Optotype']");
    public By ChangeXcylTest = By.id("change_xcyl_tests");
    public By VercticalPrismDirection = By.id("change_vprism_dir");
    public By ByHorizontalPrismDirection = By.id("change_hprism_dir");
    public By Occluder = By.id("change_occluder_type");
    public By ChangeSphereRounding = By.id("change_sphere_addition_rounding");
    public By ChangeOccluderbuttons = By.id("changeOccluderButtons");


    public By VerticalUp = By.xpath("//*[@text='Up']");
    public By VerticalDown = By.xpath("//*[@text='Down']");
    public By HorizontalIn = By.xpath("//*[@text='In']");
    public By HorizontalDown = By.xpath("//*[@text='Out']");
    public By Opaque = By.xpath("//*[@text='Opaque']");
    public By Frosted = By.xpath("//*[@text='Frosted']");
    public By Quarter = By.xpath("//*[@text='0.25']");
    public By Eighth = By.xpath("//*[@text='0.125']");
    public By RL = By.xpath("//*[@text='RL']");
    public By RBL = By.xpath("//*[@text='RL / RBL']");
    AndroidDriver driver;
    Reporter report;
    AndroidActions test;

    public RefractionSettings(AndroidTestHelper helper) {
        this.driver = helper.getDriver();
        this.report = helper.getReporter();
        this.test = helper.getDriver().testproject();
        this.driver.setTimeout(3500);

    }

    public boolean SelectDots() {
        test.clickIfVisible(ChangeXcylTest);
        return test.clickIfVisible(XcylDots);
    }

    public boolean SelectOptotype() {
        test.clickIfVisible(ChangeXcylTest);
        return test.clickIfVisible(Optotype);
    }

    public boolean VerticalUp() {
        test.clickIfVisible(VercticalPrismDirection);
        return test.clickIfVisible(VerticalUp);
    }

    public boolean VerticalDown() {
        test.clickIfVisible(VercticalPrismDirection);
        return test.clickIfVisible(VerticalDown);
    }
    public boolean HorizontalIn() {
        test.clickIfVisible(ByHorizontalPrismDirection);
        return test.clickIfVisible(HorizontalIn);
    }

    public boolean HorizontalOut() {
        test.clickIfVisible(ByHorizontalPrismDirection);
        return test.clickIfVisible(HorizontalDown);
    }
    public boolean Opaque() {
        test.clickIfVisible(Occluder);
        return test.clickIfVisible(Opaque);
    }

    public boolean Frosted() {
        test.clickIfVisible(Occluder);
        return test.clickIfVisible(Frosted);
    }
    public boolean Quarter() {
        test.clickIfVisible(ChangeSphereRounding);
        return test.clickIfVisible(Quarter);
    }

    public boolean Eighth() {
        test.clickIfVisible(ChangeSphereRounding);
        return test.clickIfVisible(Eighth);
    }

    public boolean RL() {
        test.clickIfVisible(ChangeOccluderbuttons);
        return test.clickIfVisible(RL);
    }

    public boolean RBL() {
        test.clickIfVisible(ChangeOccluderbuttons);
        return test.clickIfVisible(RBL);
    }
    }

