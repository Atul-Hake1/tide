package com.tide.qa.tests;


import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

public class YOASheetProcessingTests extends TestBase {
	
	
	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Pa55word123";

	@Test(priority =414, groups={"TC3754_YOASheetProcessing_January"})
	public void TC3754_YOASheetProcessing_January()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3754_YOASheetProcessing_January");
			//login.tideLogin(AdminUsername2, AdminPassword2);
			sheets.yoaSheetProcessing_3754();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3754_YOASheetProcessing_January"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("YOASheetProcessing_January Verification");
		videoRecordingStop();
	}
	
}
