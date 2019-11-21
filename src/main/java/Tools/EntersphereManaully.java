package Tools;

import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import org.openqa.selenium.By;

public class EntersphereManaully {

    static AndroidDriver driver;
    static AndroidActions test;
    By plus = By.id("step_plus");
    By minus = By.id("step_minus");
   public By rightsph = By.id("current_sphere_right_value");
    public By leftsph = By.id("current_sphere_left_value");

    public EntersphereManaully(AndroidTestHelper helper) {
        driver = helper.getDriver();
        test = helper.getDriver().testproject();
        this.driver.setTimeout(5000);
    }
    public void EnterManualvalue(By by, double spherevalue) {

        test.clickIfVisible(by);
        double CurrentLmValue = Double.parseDouble(test.getText(by));
        double sum =  Double.sum(CurrentLmValue ,spherevalue);


        while (sum != CurrentLmValue) {
            if(spherevalue>0){
                test.clickIfVisible(plus);
            }else{
                test.clickIfVisible(minus);
            }
            CurrentLmValue = Double.parseDouble(test.getText(by));

        }
    }

}
