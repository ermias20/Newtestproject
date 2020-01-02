package SettingsTests.Measure;

import io.appium.java_client.android.AndroidElement;

import java.lang.reflect.Proxy;

public class ElementGuard {

    public static AndroidElement guard(AndroidElement element) {
        ElementProxy proxy = new ElementProxy(element);
        AndroidElement wrappdElement = (AndroidElement) Proxy.newProxyInstance(ElementProxy.class.getClassLoader(),
                new Class[] { AndroidElement.class },
                proxy);
        return wrappdElement;
    }

}