package Tools;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;

public class Toolbar {
    public TouchAction action;

    @FindBy(id = "vprism_seekbar")
    public WebElement vprismseekBar;
    @FindBy(id = "hprism_seekbar")
    public WebElement hprismseekBar;
    public double vstep = 28;
    public double hstep = 19;


    AndroidDriver driver;
    TestReporter report;
    AndroidActions test;

    public Toolbar(AndroidTestHelper helper) {
        this.driver = helper.getDriver();
        this.report = helper.getReporter();
        this.test = helper.getDriver().testproject();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }


    public boolean dragSeekBarTo(int num ,WebElement element,double step) {
        // get location of seek bar from left
        int start = element.getLocation().getX();
        System.out.println("Startpoint - " + start);
        //get location of seekbar from top
        int y = element.getLocation().getY();
        System.out.println("Yaxis - " + y);

        //Get total width of seekbar
        int end = start + element.getSize().getWidth();
        System.out.println("End point - " + end);

        action = new TouchAction((PerformsTouchActions) driver);

        //move slider to 70% of width
        // int moveTo= (int)(end * ((float)perc/100));


        int moveTo = (int) (start + (step) * num);
        action.longPress(PointOption.point(start, y))
                .moveTo(PointOption.point(moveTo, y))
                .release().perform();
        return true;
    }

}

