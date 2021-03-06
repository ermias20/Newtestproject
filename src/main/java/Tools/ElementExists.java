package Tools;

import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.reporters.Reporter;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ElementExists {


    AndroidDriver driver;
    Reporter report;
    AndroidActions test;

    public ElementExists(AndroidTestHelper helper) {
        this.driver = helper.getDriver();
        this.report = helper.getReporter();
        this.test = helper.getDriver().testproject();
    }

    public boolean Exists(By by) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        boolean exists;
        exists = driver.findElements(by).size() != 0;
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        return exists;
    }


    public static  void clickOn(By locator, AndroidDriver driver, int timeout)
    {
        final WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(locator)));
        driver.findElement(locator).click();
    }



    public static  void waitfotwoele(By ElementTwo,By ElementOne, AndroidDriver driver, int timeout)
    {
        final WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.or(
            ExpectedConditions.presenceOfElementLocated(ElementOne),
            ExpectedConditions.presenceOfElementLocated(ElementTwo)));
}


    public String popup(By by) {
        final WebDriverWait wait = new WebDriverWait(driver, 150000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();


    }
}
