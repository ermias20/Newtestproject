package Settings;

import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.reporters.Reporter;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import org.openqa.selenium.By;

public class ExamFileSettings {


        public By VertexDistanceType = By.id("change_vertex_distance_type_vd");
        public By VertexPower = By.id("change_frame_vd");
        public By KeratoUnit = By.id("change_uint");
        public By KeratoStep = By.id("change_step");
        public By KeratoIndex= By.id("change_index");



        public By Contactlenses = By.xpath("//*[@text='Contact lenses']");
        public By Frames = By.xpath("//*[@text='Frames']");

        /*public By ThirteenMM = By.xpath("//*[@text='13mm']");
        public By FifteenMM = By.xpath("//*[@text='15mm']");*/
        public By MM = By.xpath("//*[@text='MM']");
        public By Diopter = By.xpath("//*[@text='D']");
        public By PointZeroFive = By.xpath("//*[@text='0.05']");
        public By PointTwelve  = By.xpath("//*[@text='0.12']");
        public By PointTwentyFive  = By.xpath("//*[@text='0.25']");
        public By KindexNum1  = By.xpath("//*[@text='1.332']");
        public By KindexNum2  = By.xpath("//*[@text='1.336']");
        public By KindexNum3  = By.xpath("//*[@text='1.3375']");


        AndroidDriver driver;
        Reporter report;
        AndroidActions test;

        public ExamFileSettings(AndroidTestHelper helper) {
            this.driver = helper.getDriver();
            this.report = helper.getReporter();
            this.test = helper.getDriver().testproject();
            this.driver.setTimeout(3500);

        }

        public boolean SetVDContactLenses() {
            test.clickIfVisible(VertexDistanceType);
            return test.clickIfVisible(Contactlenses);
        }

        public boolean SetVDFrames() {
            test.clickIfVisible(VertexDistanceType);
            return test.clickIfVisible(Frames);
        }

    public boolean SetVDContactLensesTwelveMM(int mmval) {
         By TwelveMM = By.xpath("//*[@text='"+mmval+"mm']");

        test.clickIfVisible(VertexPower);
        return test.clickIfVisible(TwelveMM);
    }




    public boolean SetKeratoUnitMM() {
        test.clickIfVisible(KeratoUnit);
        return test.clickIfVisible(MM);
    }
    public boolean SetKeratoUnitD() {
        test.clickIfVisible(KeratoUnit);
        return test.clickIfVisible(Diopter);
    }

    public boolean SetKeratoStepPointZeroFive() {
        test.clickIfVisible(KeratoStep);
        return test.clickIfVisible(PointZeroFive);
    }
    public boolean SetKeratoStepPointTwelve() {
        test.clickIfVisible(KeratoStep);
        return test.clickIfVisible(PointTwelve);
    }
    public boolean SetKeratoStepPointTwentyFive() {
        test.clickIfVisible(KeratoStep);
        return test.clickIfVisible(PointTwentyFive);
    }

    public boolean SetKeratoStepKindexNum1() {
        test.clickIfVisible(KeratoIndex);
        return test.clickIfVisible(KindexNum1);
    }
    public boolean SetKeratoStepKindexNum2() {
        test.clickIfVisible(KeratoIndex);
        return test.clickIfVisible(KindexNum2);
    }
    public boolean SetKeratoStepKindexNum3() {
        test.clickIfVisible(KeratoIndex);
        return test.clickIfVisible(KindexNum3);
    }



    }



