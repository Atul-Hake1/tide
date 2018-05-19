package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.CancellationDateReasonPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

public class CancellationDateReasonTests extends TestBase {

	CancellationDateReasonPage date = new CancellationDateReasonPage();
	LoginPage login = new LoginPage();
	
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1 = "Pa55word123";

	@Test(priority =291, groups={"TC3767_CancellationDate"})
	public void TC3767_CancellationDate()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3767_CancellationDate");
			//login.tideLogin(AdminUsername1, AdminPassword1);
			date.cancellationDate_3767();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3767_CancellationDate"+e.getMessage(), "FAIL");
		}		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Cancellation Date & Reason Verification");
		videoRecordingStop();
	}

}
