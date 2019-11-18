package io;


import org.openqa.selenium.By;

import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;

public class SphereBracketing {

    public By RightBracketRowOne = By.id("right_res_title");
    public By RightConfirmRowOne = By.id("right_lm_formula_update");
    public By RightBracketRowTwo = By.id("right_compare_to_title");
    public By RightConfirmRowTwo = By.id("right_subj1_formula_update");

    public By leftBracketRowOne = By.id("left_res_title");
    public By leftConfirmRowOne = By.id("left_lm_formula_update");
    public By leftBracketRowTwo = By.id("left_compare_to_title");
    public By leftConfirmRowTwo = By.id("left_subj1_formula_update");

    AndroidDriver driver;
    TestReporter report;
    AndroidActions test;

    public SphereBracketing(AndroidTestHelper helper) {
        this.driver = helper.getDriver();
        this.report = helper.getReporter();
        this.test = helper.getDriver().testproject();
        this.driver.setTimeout(2500);

    }

    public boolean SelectRowOne(By by) {
        return test.clickIfVisible(by);

    }

    public boolean ConfirmRowOne(By by) {
        return test.clickIfVisible(by);

    }

    public boolean SelectRowTwo(By by) {
        return test.clickIfVisible(by);

    }

    public boolean ConfirmRowTwo(By by) {
        return test.clickIfVisible(by);

    }

}
