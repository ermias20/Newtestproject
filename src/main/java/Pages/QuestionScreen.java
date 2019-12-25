package Pages;


import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.reporters.Reporter;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        clickskipexception(Homebutton);
        return clickskipexception(NewExam);
    }


    public boolean clickskipexception(By by) {
        final WebDriverWait wait = new WebDriverWait(driver, 150000);
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(by)));
        driver.findElement(by).click();
        return true;

    }
}