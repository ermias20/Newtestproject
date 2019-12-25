package Tools;

import QuickMode.DoAlwaysVerficationON;
import QuickMode.WarningMessage;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.tests.AndroidTest;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;

public class Runtest implements AndroidTest {
    public   ExecutionResult execute (AndroidTestHelper helper) throws FailureException {

        WarningMessage runwarning = new WarningMessage();
        runwarning.execute(helper);
        System.out.println("second test");
        DoAlwaysVerficationON rundoalways = new  DoAlwaysVerficationON();
        rundoalways.execute(helper);

        return ExecutionResult.PASSED;


    }

}
