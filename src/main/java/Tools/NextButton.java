package Tools;

import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.reporters.Reporter;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class NextButton {


    AndroidDriver driver;
    Reporter report;
    AndroidActions test;
    By ok = By.id("ok_btn");
    By bracket = By.id("right_formula_equal");
    boolean exists;
    By Nextbutton = By.id("advanced_next_step_btn");
    By export = By.id("advanced_export_btn");
    public NextButton(AndroidTestHelper helper) {
        this.driver = helper.getDriver();
        this.report = helper.getReporter();
        this.test = helper.getDriver().testproject();
    }

    public boolean BeforeBracketNext() {

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        boolean popup;
        exists = driver.findElements(bracket).size() != 0;
        while (!exists) {

            driver.testproject().clickIfVisible(Nextbutton);
            test.pause(1000);
            exists = driver.findElements(bracket).size() != 0;
            popup = driver.findElements(By.id("text")).size() != 0;
            if (popup) {
                test.clickIfVisible(ok);
            }

        }
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        return exists;
    }


    public  boolean AfterBracketNext() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        exists = driver.findElements(export).size() != 0;
        while (!exists) {
            driver.testproject().clickIfVisible(Nextbutton);
            test.pause(1000);
            exists = driver.findElements(export).size() != 0;


        }
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        return exists;
    }

}


