package io;

import SettingsTests.QuickMode.QuickModeSteps.BinoBalance;
import io.testproject.java.execution.results.StepExecutionResult;
import io.testproject.java.sdk.v2.Runner;

/**
 * This class was automatically generated by TestProject
 * Provides an example how to run coded TestProject tests
 */
public class EyeRefractRunner {
    public static String developerToken = "nVz02uGI3U7n85ReV9xY8ewCLK9iU7EUKDqK48JyJqI";
/*"192.168.42.5:5555"*/
    public static String deviceUdid = "52008171b4feb40f";
    public static String androidPackage = "com.visionix.visionixpanel";
    public static String androidName = "com.visionix.visionixpanel.Activitie.MainActivity";
    public static  Runner runner;
    public static void main(String[] args) {
        try {
            runCyl();
        } catch (Exception e) {
        }
    }

    /**
     * Runs "Cyl"
     */
    public static StepExecutionResult runCyl() throws Exception {
        runner = Runner.createAndroid(developerToken, deviceUdid, androidPackage, androidName);

        return runner.run(new BinoBalance(), true);

    }
}
