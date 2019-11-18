package io;

;


import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;

public class BooleanCheck {
    public static void ReporterCheck(TestReporter report, Boolean result, String message) {

        if (result.TRUE) {
            try {
                report.step(message, result);
            } catch (FailureException e) {
            }

        } else {

            try {
                report.step("fail");
            } catch (FailureException e) {
                // TODO Auto-generated catch block

            }

        }
    }
}
