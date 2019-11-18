package Pages;


import org.openqa.selenium.By;

import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.reporters.Reporter;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;

public class QuestionScreen {

    public By Homebutton = By.id("home_icon");
    public By NewExam = By.xpath("//*[@text='NEW EXAM']");
    AndroidDriver driver;
    Reporter report;
    AndroidActions test;
    AndroidTestHelper helper;

    public QuestionScreen(AndroidTestHelper helper) {
        this.driver = helper.getDriver();
        this.report = helper.getReporter();
        this.test = helper.getDriver().testproject();
        driver.setTimeout(10000);

    }

    public boolean OpenQuestionScreen() {
        test.clickIfVisible(Homebutton);
        return test.clickIfVisible(NewExam);
    }

}
