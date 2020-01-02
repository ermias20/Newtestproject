package SettingsTests.Measure;

import io.appium.java_client.android.AndroidElement;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ElementProxy implements InvocationHandler {

    private final AndroidElement element;

    public ElementProxy(AndroidElement element) {
        this.element = element;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //before invoking actual method check for the popup
        this.checkForPopupAndKill();
        //at this point, popup would have been closed if it had appeared. element action can be called safely now.
        Object result = method.invoke(element, args);
        return result;
    }

    private void checkForPopupAndKill() {
        if (element.isDisplayed()) {
            System.out.println("You damn popup, you appearded again!!?? I am gonna kill you now!!");
            element.click();
        }
    }

}