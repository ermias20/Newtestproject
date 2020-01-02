package SettingsTests.Measure;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.support.PageFactory;

import java.lang.reflect.Field;

public class MyPageFactory {

    public static <T> void initElements(AndroidDriver driver, T pageobject) throws IllegalAccessException {

        //first init elements
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageobject);

        //then access all the WebElements and create a wrapper
        for(Field f:pageobject.getClass().getDeclaredFields()){
            if(f.getType().equals(AndroidElement.class)){
                boolean accessible = f.isAccessible();
                f.setAccessible(true);
                //reset the webelement with proxy object
                f.set(pageobject, ElementGuard.guard((AndroidElement) f.get(pageobject)));
                f.setAccessible(accessible);
            }
        }

    }

}