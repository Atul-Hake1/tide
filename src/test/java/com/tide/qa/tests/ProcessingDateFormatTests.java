package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.ProcessingDateFormatPage;
import com.tide.qa.utility.Report;

public class ProcessingDateFormatTests extends TestBase {
	
	ProcessingDateFormatPage Dateformat= new ProcessingDateFormatPage();
	LoginPage login = new LoginPage();
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Pa55word123";

	@Test(priority =295, groups={"TC3984_USDateFormatsToUKDateFormat"})
	public void TC3984_USDateFormatsToUKDateFormat()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3984_USDateFormatsToUKDateFormat");
			//login.tideLogin(AdminUsername2, AdminPassword2);
			Dateformat.usToUkdate_3984();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3984_USDateFormatsToUKDateFormat"+e.getMessage(), "FAIL");
		}		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("US Date Formats To UK Date Format Verification");
		videoRecordingStop();
	}

}
