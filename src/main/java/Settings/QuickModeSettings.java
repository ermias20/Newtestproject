package Settings;

import io.Attribiute;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.reporters.Reporter;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import org.openqa.selenium.By;

public class QuickModeSettings {

    public By SphereIntervalStep = By.id("change_obj_sphere_interval_step");
    public By CylinderIntervalStep = By.id("change_obj_cylinder_interval_step");
    public By LmSphererIntervalStep = By.id("change_lm_sphere_interval_step");
    public By LmCylinderIntervalStep = By.id("change_lm_cylinder_interval_step");
    public By PolarizedFilter = By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[7]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.Switch[1]");
    public By OneLineVa= By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[8]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.Switch[1]");
    public By Changeoptotype= By.id("change_optotype");
    public By binocularBalance= By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[10]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.Switch[1]");
    public By Doalwaysverfication= By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[11]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.Switch[1]");
    public By SphereVerficationSwitch= By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[12]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.Switch[1]\n");
    public By SphereVerficationTest= By.id("change_sphere_test");

    public By Optotype = By.xpath("//*[@text='Letters']");
    public By Number = By.xpath("//*[@text='Numbers']");
    public By SphereVerOptotype = By.xpath("//*[@text='Optotype']");
    public By SphereVerRedGreen = By.xpath("//*[@text='Red Green']");
    public By SphereVerJacksoncross = By.xpath("//*[@text='Jackson cross']");

    AndroidDriver driver;
    Reporter report;
    AndroidActions test;
    AndroidTestHelper helper;

    public QuickModeSettings(AndroidTestHelper helper) {
        this.driver = helper.getDriver();
        this.helper =helper;
        this.report = helper.getReporter();
        this.test = helper.getDriver().testproject();
        this.driver.setTimeout(15000);

    }

    public boolean SphereIntervalStep(String value) {
        test.clearContents(SphereIntervalStep);
        return test.typeText(SphereIntervalStep,value);
    }

    public boolean CylinderIntervalStep(String value) {
        test.clearContents(CylinderIntervalStep);
        return test.typeText(CylinderIntervalStep,value);
    }
    public boolean LmSphererIntervalStep(String value) {
        test.clearContents(LmSphererIntervalStep);
        return test.typeText(LmSphererIntervalStep,value);
    }
    public boolean LmCylinderIntervalStep(String value) {
        test.clearContents(LmCylinderIntervalStep);
        return test.typeText(LmCylinderIntervalStep,value);
    }
    public boolean   PolorizedFilter() {
        return test.clickIfVisible(PolarizedFilter);
    }
    public boolean CheckPolorizedFilterState() {
        return Attribiute.Checked(PolarizedFilter,helper);

    }
    public boolean OneLineofVa() {
        return test.clickIfVisible(OneLineVa);
    }

    public boolean CheckOneLineofVaState() {
        return Attribiute.Checked(OneLineVa,helper);

    }
    public boolean Optotype(By by) {
        test.clickIfVisible(Changeoptotype);
        return test.clickIfVisible(by);
    }
    public boolean CheckOptotypeState() {
        return Attribiute.Checked(Changeoptotype,helper);
    }

    public boolean binocularBalance() {
        return test.clickIfVisible(binocularBalance);
    }
    public boolean CheckbinocularBalanceState() {
        return Attribiute.Checked(binocularBalance,helper);

    }
    public boolean DoAlwaysVerfication() {
        return test.clickIfVisible(Doalwaysverfication);
    }
    public boolean CheckDoAlwaysVerficationeState() {
        return Attribiute.Checked(Doalwaysverfication,helper);
    }


    public boolean SphereVerficationSwitch() {
        return test.clickIfVisible(SphereVerficationSwitch);
    }
    public boolean CheckSphereVerficationSwitchState() {
        return Attribiute.Checked(SphereVerficationSwitch,helper);
    }


    public boolean SphereVerficationTest(By by) {
        test.clickIfVisible(SphereVerficationTest);
        return test.clickIfVisible(by);
    }
}
