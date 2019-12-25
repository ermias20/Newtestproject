/*

package Tools;

import io.appium.java_client.MobileElement;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import io.testproject.proxy.addon.ImageComparison;

import java.io.File;
import java.io.IOException;

public class imageComparison {


    AndroidTestHelper helper;
    ExecutionResult executionResult;


    public ExecutionResult compareImage(AndroidTestHelper helper , String Name,  MobileElement ele) throws IOException, FailureException {
       ScreenShotByCoord takescreenshottwo = new ScreenShotByCoord(helper);
        takescreenshottwo.ScreenShot(ele, Name);
        File Resourcesdirectory = new File("src/main/Resources/"+Name+".png");
        File Screenshotdirectory = new File("src/main/Resources/Screenshots/"+Name+".png");
        File diff = new File("src/main/Resources/Screenshots/");
        System.out.println(Resourcesdirectory.getAbsolutePath());
        System.out.println(Screenshotdirectory.getAbsolutePath());

        compareTwoImages = ImageComparison.compareTwoImages(Resourcesdirectory.getAbsolutePath() ,Screenshotdirectory.getAbsolutePath(), "20", diff.getAbsolutePath(), "diff");
        executionResult = helper.executeProxy(compareTwoImages);

        return executionResult;
    }
}

*/
