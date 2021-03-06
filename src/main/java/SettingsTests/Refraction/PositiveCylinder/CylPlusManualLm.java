	package SettingsTests.Refraction.PositiveCylinder;

 import Tools.ManualLM;
import Tools.NextButton;
import io.*;
import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.annotations.v2.Test;
import io.testproject.java.enums.ParameterDirection;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.drivers.actions.AndroidActions;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.tests.AndroidTest;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import org.openqa.selenium.By;



@Test(name = "cyl+ manual lm", version = "1.0")

	public class CylPlusManualLm implements AndroidTest {
		@Parameter(defaultValue = "0.25", direction = ParameterDirection.INPUT)
		public Double ManualLmRightSphere;
		@Parameter(defaultValue = "0.5", direction = ParameterDirection.INPUT)
		public Double ManuaLmleftSphere;
		@Parameter(defaultValue = "0.75", direction = ParameterDirection.INPUT)
		public Double ManualLmRightCyl;
		@Parameter(defaultValue = "1.25", direction = ParameterDirection.INPUT)
		public Double ManualLmLeftCyl;

		@Parameter(defaultValue = "45", direction = ParameterDirection.INPUT)
		public int ManualLmRightAxis;
		@Parameter(defaultValue = "90", direction = ParameterDirection.INPUT)
		public int ManualLmLeftAxis;

		double finalRightSphere;
		double finalRightCyl;
		double finalRightAxis;
		double finalLeftSphere;
		double finalLeftCyl;
		double finalLeftAxis;

		double wfRightSphere;
		double wfRightCyl;
		double wfRightAxis;
		double wfLeftSphere;
		double wfLeftCyl;
		double wfLeftAxis;

		public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
			AndroidDriver driver = helper.getDriver();
			TestReporter report = helper.getReporter();
			AndroidActions test = driver.testproject();
			By by;
            ManualLM EnterManualLm = new ManualLM(helper);
			EnterManualLm.OpenManualLmDialog();
			EnterManualLm.EnterManualvalue(EnterManualLm.RightSPh, ManualLmRightSphere);
			EnterManualLm.EnterManualvalue(EnterManualLm.LeftSPh, ManuaLmleftSphere);
			EnterManualLm.EnterManualvalue(EnterManualLm.RightCyl, ManualLmRightCyl);
			EnterManualLm.EnterManualvalue(EnterManualLm.LeftCyl, ManualLmLeftCyl);
			EnterManualLm.EnterManualAxisvalue(EnterManualLm.Rightaxis, ManualLmRightAxis);
			EnterManualLm.EnterManualAxisvalue(EnterManualLm.Leftaxis, ManualLmLeftAxis);
			EnterManualLm.CloseManualLmDialog();
			WfMeasurment newMeasure = new WfMeasurment(helper);
			newMeasure.StartMeasure();
			if (EnterManualLm.DiffBetweenLmWf()) {
				BooleanCheck.ReporterCheck(report, EnterManualLm.DiffBetweenLmWf(), "diff between lm and wf");
				EnterManualLm.ConfirmVal();
			}
            NextButton nextbefore = new  NextButton(helper);
            nextbefore.BeforeBracketNext();
			// set timeout for driver actions (similar to step timeout)
			driver.setTimeout(15000);

			// 4. compare 'right sphere' value with expected value and check tolerance
			by = By.id("current_sphere_right_value");

			CylPlusRefraction Refractioncheck = new CylPlusRefraction();
			SphereBracketing newRightBracketing = new SphereBracketing(helper);
			By OccluderAttr = By.id("eye_right_toggle");

			InitQuickpro QuickProData = new InitQuickpro(driver);
			QuickProData.RightHeadBuffer();
			QuickProData.LeftHeadBuffer();

			wfRightSphere = QuickProData.WfRightSphere;
			wfRightCyl = QuickProData.WfRightCyl;
			wfRightAxis = QuickProData.WfRightAxis;
			wfLeftSphere = QuickProData.WfLeftSphere;
			wfLeftCyl = QuickProData.WfLeftCyl;
			wfLeftAxis = QuickProData.WfLeftAxis;

			// bracketing of right eye and data check

			while (Attribiute.Checked(OccluderAttr, helper)) {
				BooleanCheck.ReporterCheck(report, newRightBracketing.SelectRowOne(newRightBracketing.RightBracketRowOne),
						"Right eye bracketing : row 1");
				QuickProData.RightEyeBuffer();
				QuickProData.RightHeadBuffer();
				boolean RightrowoneCheck = Refractioncheck.RefractionCompare(QuickProData.RowOneRightSphere,
						QuickProData.RowOneRightCyl, QuickProData.RowOneRightAxis, QuickProData.WfRightSphere,
						QuickProData.WfRightCyl, QuickProData.WfRightAxis, helper);
				BooleanCheck.ReporterCheck(report, RightrowoneCheck, "row one buffer inserted in the head");
				BooleanCheck.ReporterCheck(report, newRightBracketing.SelectRowTwo(newRightBracketing.RightBracketRowTwo),
						"Right eye  bracketing : row 2");
				QuickProData.RightEyeBuffer();
				QuickProData.RightHeadBuffer();
				boolean RightrowTwoCheck = Refractioncheck.RefractionCompare(QuickProData.RowTwoRightSphere,
						QuickProData.RowTwoRightCyl, QuickProData.RowTwoRightAxis, QuickProData.WfRightSphere,
						QuickProData.WfRightCyl, QuickProData.WfRightAxis, helper);
				BooleanCheck.ReporterCheck(report, RightrowTwoCheck, "row two buffer inserted in the head");
				BooleanCheck.ReporterCheck(report, newRightBracketing.ConfirmRowOne(newRightBracketing.RightConfirmRowOne),
						"Right eye  bracketing : confirm row 1");
				QuickProData.RightEyeBuffer();
				QuickProData.RightHeadBuffer();
				boolean ConfirmRowOneCheck = Refractioncheck.RefractionCompare(QuickProData.RowOneRightSphere,
						QuickProData.RowOneRightCyl, QuickProData.RowOneRightAxis, QuickProData.WfRightSphere,
						QuickProData.WfRightCyl, QuickProData.WfRightAxis, helper);
				BooleanCheck.ReporterCheck(report, ConfirmRowOneCheck, "row one Confirm buffer inserted in the head");

			}
			;

			// bracketing of left eye and data check

			SphereBracketing newLeftBracketing = new SphereBracketing(helper);
			By LeftOccluderAttr = By.id("eye_left_toggle");
			while (Attribiute.Checked(LeftOccluderAttr, helper)) {
				BooleanCheck.ReporterCheck(report, newLeftBracketing.SelectRowOne(newLeftBracketing.leftBracketRowOne),
						"left eye bracketing : row 1");
				QuickProData.LeftEyeBuffer();
				QuickProData.LeftHeadBuffer();
				boolean LeftrowoneCheck = Refractioncheck.RefractionCompare(QuickProData.RowOneLeftSphere,
						QuickProData.RowOneleftCyl, QuickProData.RowOneleftAxis, QuickProData.WfLeftSphere,
						QuickProData.WfLeftCyl, QuickProData.WfLeftAxis, helper);
				BooleanCheck.ReporterCheck(report, LeftrowoneCheck, "row one buffer inserted in the head");
				BooleanCheck.ReporterCheck(report, newLeftBracketing.SelectRowTwo(newLeftBracketing.leftBracketRowTwo),
						"left eye  bracketing : row 2");

				QuickProData.LeftEyeBuffer();
				QuickProData.LeftHeadBuffer();

				boolean LeftrowTwoCheck = Refractioncheck.RefractionCompare(QuickProData.RowTwoLeftSphere,
						QuickProData.RowTwoleftCyl, QuickProData.RowTwoleftAxis, QuickProData.WfLeftSphere,
						QuickProData.WfLeftCyl, QuickProData.WfLeftAxis, helper);
				BooleanCheck.ReporterCheck(report, LeftrowTwoCheck, "row one buffer inserted in the head");

				BooleanCheck.ReporterCheck(report, newLeftBracketing.ConfirmRowOne(newLeftBracketing.leftConfirmRowOne),
						"left eye  bracketing : confirm row 1");
				QuickProData.LeftEyeBuffer();
				QuickProData.LeftHeadBuffer();
				boolean ConfirmRowoneCheck = Refractioncheck.RefractionCompare(QuickProData.RowOneLeftSphere,
						QuickProData.RowOneleftCyl, QuickProData.RowOneleftAxis, QuickProData.WfLeftSphere,
						QuickProData.WfLeftCyl, QuickProData.WfLeftAxis, helper);
				BooleanCheck.ReporterCheck(report, ConfirmRowoneCheck, "row one Confirm buffer inserted in the head");
			}
			QuickProData.FinalBuffer();
			finalRightSphere = QuickProData.FinalRightSphere;
			finalRightCyl = QuickProData.FinalRightCyl;
			finalRightAxis = QuickProData.FinalRightAxis;
			finalLeftSphere = QuickProData.FinalLeftSphere;
			finalLeftCyl = QuickProData.FinalLeftCyl;
			finalLeftAxis = QuickProData.FinalLeftAxis;

			By export = By.id("advanced_export_btn");
            nextbefore.AfterBracketNext();

			driver.testproject().click(export);
			driver.testproject().isVisible(By.id("measurement_list"));

			// Exam file Wf Measure data compare
			ExamFileMeasureData NewExamFileData = new ExamFileMeasureData(helper);
			boolean CompareRightWfExamFile = Refractioncheck.RefractionCompare(NewExamFileData.WfRightSphere,
					NewExamFileData.WfRightCyl, NewExamFileData.WfRightAxis, wfRightSphere, wfRightCyl, wfRightAxis,
					helper);
			BooleanCheck.ReporterCheck(report, CompareRightWfExamFile,
					"Right Eye Measure data compare between Wf and exam file");

			boolean CompareLeftWfExamFile = Refractioncheck.RefractionCompare(NewExamFileData.WfLeftSphere,
					NewExamFileData.WfLeftCyl, NewExamFileData.WfLeftAxis, wfLeftSphere, wfLeftCyl, wfLeftAxis, helper);
			BooleanCheck.ReporterCheck(report, CompareLeftWfExamFile,
					"Left Eye Measure data compare between Wf and exam file");

			// Exam file Lm Wf data compare
			double DManualLmRightAxis = Double.valueOf(ManualLmRightAxis);
			double DManualLmLeftAxis = Double.valueOf(ManualLmLeftAxis);

			boolean CompareRightLmExamFile = Refractioncheck.RefractionCompare(NewExamFileData.LmRightSphere,
					NewExamFileData.LmRightCyl, NewExamFileData.LmRightAxis, ManualLmRightSphere, ManualLmRightCyl,
					DManualLmRightAxis, helper);
			BooleanCheck.ReporterCheck(report, CompareRightLmExamFile,
					"Right Eye Measure data compare between LM and exam file");

			boolean CompareLeftLmExamFile = Refractioncheck.RefractionCompare(NewExamFileData.LmLeftSphere,
					NewExamFileData.LmleftCyl, NewExamFileData.LmLeftAxis, ManuaLmleftSphere, ManualLmLeftCyl,
					DManualLmLeftAxis, helper);
			BooleanCheck.ReporterCheck(report, CompareLeftLmExamFile,
					"Left Eye Measure data compare between lm and exam file");

			// Exam file Final Measure data compare

			boolean CompareRightFinalExamFile = Refractioncheck.RefractionCompare(NewExamFileData.FinalRightSphere,
					NewExamFileData.FinalRightCyl, NewExamFileData.FinalRightAxis, finalRightSphere, finalRightCyl,
					finalRightAxis, helper);
			BooleanCheck.ReporterCheck(report, CompareRightFinalExamFile,
					"Right Eye Measure data compare between Final and exam file");

			boolean CompareLeftFinalExamFile = Refractioncheck.RefractionCompare(NewExamFileData.FinalLeftSphere,
					NewExamFileData.FinalLeftCyl, NewExamFileData.FinalLeftAxis, finalLeftSphere, finalLeftCyl,
					finalLeftAxis, helper);
			BooleanCheck.ReporterCheck(report, CompareLeftFinalExamFile,
					"Left Eye Measure data compare between Final and exam file");

			// check convention toggle
			CheckConvention NegativeCyl = new CheckConvention(helper);

			BooleanCheck.ReporterCheck(report, NegativeCyl.ChangeConvention(), "Change cyl convention to negative : ");
			ExamFileMeasureData negativedata = new ExamFileMeasureData(helper);
			BooleanCheck.ReporterCheck(report, NegativeCyl.IsValueNegative(negativedata.FinalRightCyl),
					"right final cyl value is : " + negativedata.FinalRightCyl);
			BooleanCheck.ReporterCheck(report, NegativeCyl.IsValueNegative(negativedata.FinalLeftCyl),
					"left final cyl value is : " + negativedata.FinalLeftCyl);
			BooleanCheck.ReporterCheck(report, NegativeCyl.IsValueNegative(negativedata.WfRightCyl),
					"right wf cyl value is : " + negativedata.WfRightCyl);
			BooleanCheck.ReporterCheck(report, NegativeCyl.IsValueNegative(negativedata.WfLeftCyl),
					"left wf cyl value is : " + negativedata.WfLeftCyl);

			PositiveCyl ExamFileNegativemode = new PositiveCyl();
			CylPlusRefraction Examfilecompare = new CylPlusRefraction();

			double finalrightsph = ExamFileNegativemode.newsph(negativedata.FinalRightSphere, negativedata.FinalRightCyl);
			double finalrightcyl = ExamFileNegativemode.newcyl(negativedata.FinalRightCyl);
			double finalrightaxis = ExamFileNegativemode.newaxis(negativedata.FinalRightAxis);

			boolean NegativeFinalRightCompare = Examfilecompare.RefractionCompare(finalrightsph, finalrightcyl,
					finalrightaxis, finalRightSphere, finalRightCyl, finalRightAxis, helper);

			BooleanCheck.ReporterCheck(report, NegativeFinalRightCompare,
					"Right eye  final negative data comparison with positive data");

			double finallefttsph = ExamFileNegativemode.newsph(negativedata.FinalLeftSphere, negativedata.FinalLeftCyl);
			double finalleftcyl = ExamFileNegativemode.newcyl(negativedata.FinalLeftCyl);
			double finalleftaxis = ExamFileNegativemode.newaxis(negativedata.FinalLeftAxis);
			boolean NegativeFinalleftCompare = Examfilecompare.RefractionCompare(finallefttsph, finalleftcyl, finalleftaxis,
					finalLeftSphere, finalLeftCyl, finalLeftAxis, helper);
			BooleanCheck.ReporterCheck(report, NegativeFinalleftCompare,
					"Left eye  final negative data comparison with positive data");

			double wfrightsph = ExamFileNegativemode.newsph(negativedata.WfRightSphere, negativedata.WfRightCyl);
			double wfrightcyl = ExamFileNegativemode.newcyl(negativedata.WfRightCyl);
			double wfrightaxis = ExamFileNegativemode.newaxis(negativedata.WfRightAxis);

			boolean NegativeWfRightCompare = Examfilecompare.RefractionCompare(wfrightsph, wfrightcyl, wfrightaxis,
					this.wfRightSphere, this.wfRightCyl, this.wfRightAxis, helper);
			BooleanCheck.ReporterCheck(report, NegativeWfRightCompare,
					"Right eye  Wf negative data comparison with positive data");

			double wfleftsph = ExamFileNegativemode.newsph(negativedata.WfLeftSphere, negativedata.WfLeftCyl);
			double wfleftcyl = ExamFileNegativemode.newcyl(negativedata.WfLeftCyl);
			double wfleftaxis = ExamFileNegativemode.newaxis(negativedata.WfLeftAxis);

			boolean NegativeWfLeftCompare = Examfilecompare.RefractionCompare(wfleftsph, wfleftcyl, wfleftaxis,
					wfLeftSphere, wfLeftCyl, wfLeftAxis, helper);
			BooleanCheck.ReporterCheck(report, NegativeWfLeftCompare,
					"left eye  Wf negative data comparison with positive data");
			NegativeCyl.ChangeConvention();
			driver.testproject().clickIfVisible(By.id("printBtn"));
			driver.testproject().isVisible(By.id("printBtn"));

			PdfReportMeasurmentData finalreportdata = new PdfReportMeasurmentData(helper);
			finalreportdata.PdfReportFinal();
			finalreportdata.PdfReportWf();
			// Report page Measure data compare
			boolean CompareRightWfReportPage = Refractioncheck.RefractionCompare(finalreportdata.WfRightSphere,
					finalreportdata.WfRightCyl, finalreportdata.WfRightAxis, wfRightSphere, wfRightCyl, wfRightAxis,
					helper);
			BooleanCheck.ReporterCheck(report, CompareRightWfReportPage,
					"Right Eye Measure data compare between Wf and Report page");

			boolean CompareLeftWfReportPage = Refractioncheck.RefractionCompare(finalreportdata.WfLeftSphere,
					finalreportdata.WfLeftCyl, finalreportdata.WfLeftAxis, wfLeftSphere, wfLeftCyl, wfLeftAxis, helper);
			BooleanCheck.ReporterCheck(report, CompareLeftWfReportPage,
					"Left Eye Measure data compare between Wf and Report file");

			// Report page Final Measure data compare

			boolean CompareRightFinalReportPage = Refractioncheck.RefractionCompare(finalreportdata.FinalRightSphere,
					finalreportdata.FinalRightCyl, finalreportdata.FinalRightAxis, finalRightSphere, finalRightCyl,
					finalRightAxis, helper);
			BooleanCheck.ReporterCheck(report, CompareRightFinalReportPage,
					"Right Eye Measure data compare between Final and  Report page");

			boolean CompareLeftFinalReportPage = Refractioncheck.RefractionCompare(finalreportdata.FinalLeftSphere,
					finalreportdata.FinalLeftCyl, finalreportdata.FinalLeftAxis, finalLeftSphere, finalLeftCyl,
					finalLeftAxis, helper);
			BooleanCheck.ReporterCheck(report, CompareLeftFinalReportPage,
					"Left Eye Measure data compare between Final and  Report page");

			// Report page lm data compare

			finalreportdata.PdfReportLm();

			boolean CompareRightLmReportPage = Refractioncheck.RefractionCompare(finalreportdata.LmRightSphere,
					finalreportdata.FinalRightCyl, finalreportdata.LmRightAxis, ManualLmRightSphere, ManualLmRightCyl,
					DManualLmRightAxis, helper);
			BooleanCheck.ReporterCheck(report, CompareRightLmReportPage,
					"Right Eye Measure data compare between LM and exam file");

			boolean CompareLeftLmReportPage = Refractioncheck.RefractionCompare(finalreportdata.LmLeftSphere,
					finalreportdata.LmleftCyl, finalreportdata.LmLeftAxis, ManuaLmleftSphere, ManualLmLeftCyl,
					DManualLmLeftAxis, helper);
			BooleanCheck.ReporterCheck(report, CompareLeftLmReportPage,
					"Left Eye Measure data compare between lm and exam file");

			return ExecutionResult.PASSED;
		}
	}


