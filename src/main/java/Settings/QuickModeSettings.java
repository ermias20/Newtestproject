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
    public By PolarizedFilter = By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[7]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]");
    public By OneLineVa= By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[7]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.Switch[1]");
    public By Changeoptotype= By.id("change_optotype");
    public By binocularBalance= By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.Switch[1]");
    public By newbinocularBalance= By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.Switch[1]");
    public By newdowalways= By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[11]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]");
    public By newsphereverfication= By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[12]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]");
    public By Doalwaysverfication= By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[10]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.Switch[1]");
    public By SphereVerficationSwitch= By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[11]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.Switch[1]");
    public By SphereVerficationTest= By.id("change_sphere_test");
    public By Optotype = By.xpath("//*[@text='Letters']");
    public By Number = By.xpath("//*[@text='Numbers']");
    public By SphereVerOptotype = By.xpath("//*[@text='Optotype']");
    public By SphereVerRedGreen = By.xpath("//*[@text='Red Green']");
    public By SphereVerJacksoncross = By.xpath("//*[@text='Jackson cross']");
    public By ByVAbino= By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[6]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.Switch[1]");
    public By ByVAmono= By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[7]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.Switch[1]");
    public By ByLMVAbino= By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[8]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.Switch[1]");
    public By ByLMVAmono= By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.Switch[1]");
    public By ByUnaidedVAbino= By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[10]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.Switch[1]");
    public By ByUnaidedVAmono= By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[11]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.Switch[1]");
    public By warningmessage= By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[12]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.Switch[1]");


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
        return Attribiute.Enabled(PolarizedFilter,helper);

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
        return Attribiute.Enabled(binocularBalance,helper);

    }
    public boolean DoAlwaysVerfication() {
        return test.clickIfVisible(Doalwaysverfication);
    }
    public boolean CheckDoAlwaysVerficationeState() {
        return Attribiute.Enabled(Doalwaysverfication,helper);
    }


    public boolean SphereVerficationSwitch() {
        return test.clickIfVisible(SphereVerficationSwitch);
    }
    public boolean CheckSphereVerficationSwitchState() {
        return Attribiute.Enabled(SphereVerficationSwitch,helper);
    }

    public boolean EnterSphereVerficationTest( String testname) {
        test.clickIfVisible(SphereVerficationTest);
        switch (testname){
            case "Optotype":
                test.clickIfVisible(SphereVerOptotype);
            break;
            case "Red Green":
                test.clickIfVisible(SphereVerRedGreen);
                break;
            case "Jackson cross":
                test.clickIfVisible(SphereVerJacksoncross);
                break;

        }

        return true;
    }

    public boolean   VaBino() {
        return test.clickIfVisible(ByVAbino);
    }

    public boolean   swipedown() {
        return test.swipeGesture(400,1241,1111,1220,403);
           }



    public boolean NewVaBinobalanceCheck() {
        return Attribiute.Enabled(binocularBalance,helper);

    } public boolean   NewVaBinobalance() {
        return test.clickIfVisible(binocularBalance);
    }



    public boolean NewSphVerCheck() {
        return Attribiute.Enabled(newsphereverfication,helper);

    } public boolean   NewSphVer() {
        return test.clickIfVisible(newsphereverfication);
    }

    public boolean NewdoalwaysCheck() {
        return Attribiute.Enabled(newdowalways,helper);

    } public boolean   Newdoalways() {

        return test.clickIfVisible(newdowalways);
    }

    public boolean VaBinoCheck() {
        swipedown();

        return Attribiute.Enabled(ByVAbino,helper);

    } public boolean   VaMono() {
        return test.clickIfVisible(ByVAmono);
    }
    public boolean VaMonocheck() {
        swipedown();

        return Attribiute.Enabled(ByVAmono,helper);

    } public boolean   LmVaBino() {
        swipedown();

        return test.clickIfVisible(ByLMVAbino);
    }
    public boolean LmVaBinoCheck() {
        swipedown();

        return Attribiute.Enabled(ByLMVAbino,helper);

    } public boolean   LmVaMono() {
        return test.clickIfVisible(ByLMVAmono);
    }
    public boolean LmVaMonocheck() {

        swipedown();
        test.pause(2000);

        return Attribiute.Enabled(ByLMVAmono,helper);

    } public boolean   UnaidedVaBino() {
        return test.clickIfVisible(ByUnaidedVAbino);
    }
    public boolean UnaidedVaBinoCheck() {

        swipedown();
        test.pause(2000);

        return Attribiute.Enabled(ByUnaidedVAbino,helper);

    } public boolean   UnaidedVaMono() {
        swipedown();
        test.pause(2000);

        return test.clickIfVisible(ByUnaidedVAmono);
    }
    public boolean UnaidedVaMonocheck() {
        swipedown();
        test.pause(2000);

        return Attribiute.Enabled(ByUnaidedVAmono,helper);

    } public boolean   WarningBetweensteps() {
        swipedown();
        test.pause(2000);

        return test.clickIfVisible(warningmessage);
    }
    public boolean WarningBetweenstepsCheck() {
        swipedown();
        test.pause(2000);
        return Attribiute.Enabled(warningmessage,helper);

    }

}
