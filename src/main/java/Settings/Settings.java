package Settings;


import Tools.ElementExists;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import org.openqa.selenium.By;

public class Settings {
    public By Homebutton = By.id("home_icon");
    public By Settings = By.xpath("//*[@text='SETTINGS']");
    public By SettingsGeneral = By.xpath("//*[@text='General']");
    public By SettingsMeasure = By.xpath("//*[@text='Measure']");
    public By SettingsRefraction = By.xpath("//*[@text='Refraction']");
    public By SettingsQuickmode = By.xpath("//*[@text='Quick mode']");
    public By SettingsExamfile = By.xpath("//*[@text='Exam file']");
    public By SettingsConnection = By.xpath("//*[@text='Connection']");
    public By SettingsExport = By.xpath("//*[@text='Export']");
    public By SettingsChart = By.xpath("//*[@text='Chart display / Near vision tablet']");
    public By SettingsMaintenance = By.xpath("//*[@text='Maintenance']");
    public By ChangeXcylTest = By.id("change_xcyl_tests");
    AndroidDriver driver;
    TestReporter report;
    AndroidActions test;
    AndroidTestHelper helper;
    public Settings(AndroidTestHelper helper)  {
        this.driver = helper.getDriver();
        this.report = helper.getReporter();
        this.helper = helper;

        this.test = helper.getDriver().testproject();
        this.driver.setTimeout(15000);

    }

    public boolean OpenSettings() {
        ElementExists waitforhome = new ElementExists(helper);
        waitforhome.clickOn(Homebutton,driver ,150000);
        return test.clickIfVisible(Settings);
    }


    public boolean OpenSettingsGeneralTab() {
        return test.clickIfVisible(SettingsGeneral);
    }

    public boolean OpenSettingsMeasureTab() {
        return test.clickIfVisible(SettingsMeasure);
    }

    public boolean OpenSettingsRefractionTab() {
        return test.clickIfVisible(SettingsRefraction);
    }

    public boolean OpenSettingsQuickmodeTab() {
        return test.clickIfVisible(SettingsQuickmode);
    }

    public boolean OpenSettingsExamfileTab() {
        return test.clickIfVisible(SettingsExamfile);
    }

    public boolean OpenSettingsConnectionTab() {
        return test.clickIfVisible(SettingsConnection);
    }

    public boolean OpenSettingsExportTab() {
        return test.clickIfVisible(SettingsExport);
    }

    public boolean OpenSettingsChartTab() {
        return test.clickIfVisible(SettingsChart);
    }

    public boolean OpenSettingsMaintenance() {
        return test.clickIfVisible(SettingsMaintenance);
    }

}
