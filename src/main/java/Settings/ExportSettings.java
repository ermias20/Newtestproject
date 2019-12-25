package Settings;

import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.reporters.Reporter;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import org.openqa.selenium.By;

public class ExportSettings {
        public By XmlFormat = By.id("change_xml_format");
        public By XmlVersion1 = By.xpath("//*[@text='V01']");
        public By XmlVersion2 = By.xpath("//*[@text='V02']");
        AndroidDriver driver;
        Reporter report;
        AndroidActions test;

        public ExportSettings(AndroidTestHelper helper) {
            this.driver = helper.getDriver();
            this.report = helper.getReporter();
            this.test = helper.getDriver().testproject();
            this.driver.setTimeout(3500);

        }

        public boolean SelectVesrion1() {
            test.clickIfVisible(XmlFormat);
            return test.clickIfVisible(XmlVersion1);
        }

        public boolean SelectVesrion2() {
            test.clickIfVisible(XmlFormat);
            return test.clickIfVisible(XmlVersion2);
        }





}
