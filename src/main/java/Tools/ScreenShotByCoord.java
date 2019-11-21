package Tools;

import io.appium.java_client.MobileElement;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenShotByCoord {

    AndroidDriver driver;
    AndroidActions test;

    public ScreenShotByCoord(AndroidTestHelper helper) {
        this.driver = helper.getDriver();
        this.test = helper.getDriver().testproject();
    }

        public String ScreenShot (MobileElement ele,String imagepath) {

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            BufferedImage fullImg = null;
            try {
                fullImg = ImageIO.read(scrFile);
            } catch (IOException e) {
                e.printStackTrace();
            }


// Get the location of element on the page
            Point point = ele.getLocation();
// Get width and height of the element
            int eleWidth = ele.getSize().getWidth();
            int eleHeight = ele.getSize().getHeight();

// Crop the entire page screenshot to get only element screenshot
            BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(),
                    eleWidth, eleHeight);
            try {
                ImageIO.write(eleScreenshot, "png", scrFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

// Copy the element screenshot to disk
            File screenshotLocation = new File("src/main/Resources/Screenshots/" +imagepath+".png");
            System.out.println("absulute path"+screenshotLocation.getAbsolutePath());
            try {
                FileUtils.copyFile(scrFile, new File(screenshotLocation.getAbsolutePath()));
            } catch (IOException e) {
                e.printStackTrace();
            }

        return screenshotLocation.getPath();

        }
    }

