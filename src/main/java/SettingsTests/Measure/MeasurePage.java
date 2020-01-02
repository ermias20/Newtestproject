package SettingsTests.Measure;

import io.appium.java_client.android.AndroidElement;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MeasurePage {

    private final AndroidDriver driver;
    @FindBy(id = "home_icon")
    private AndroidElement Homebutton;
@FindBy(id = "sphere_param")
    private AndroidElement QuickPro;
@FindBy(id = "text")
    private AndroidElement WfProblem;

    @FindBy(id = "start_stop_measurment")
    private AndroidElement StartMeasureButton;
    @FindBy(id = "dialog_message")
    private AndroidElement Kmeasurepopup;
    @FindBy(id = "retry")
    private AndroidElement KmeasuRetry;
    @FindBy(id = "right_progress")
    private AndroidElement RightprogressBar;
     @FindBy(id = "measument_dialog_layout")
    private AndroidElement Measureerror;
    @FindBy(id = "ok_btn")
    private AndroidElement Ok;
    @FindBy(xpath = "//*[@text='MEASURE']")
    private AndroidElement MeasureScreen;
    @FindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    private AndroidElement Measureproblem;

    public MeasurePage(AndroidDriver driver) throws Exception {
        this.driver = driver;
        MyPageFactory.initElements( driver, this);

    }

    public MeasurePage movetomeasure() {
        this.Homebutton.click();
        this.MeasureScreen.click();

        return this;
    }

    public MeasurePage startmeasure() {
        this.StartMeasureButton.click();
        return this;
    }

    public MeasurePage waittorefraction() {
        final WebDriverWait wait = new WebDriverWait(driver, 150000);
         wait.until(ExpectedConditions.visibilityOf(QuickPro));
         return this;
    }




}