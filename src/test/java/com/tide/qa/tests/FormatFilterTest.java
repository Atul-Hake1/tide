package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.BordereauQuePage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.Stage2Page;
import com.tide.qa.utility.Report;

public class FormatFilterTest extends TestBase
{
	BordereauQuePage sheets = new BordereauQuePage();
	//Stage2Page s2 = new Stage2Page();
	LoginPage login = new LoginPage();
	String AdminUsername = "dave.brit@brit.com";
	String AdminPassword = "Pa55word123";
	
	@Test(priority =415, groups={"TC3684_FilterRecrdToRetainRcrd"})
	public void TC3684_FilterRecrdToRetainRcrd()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3684_FilterRecrdToRetainRcrd");
			//login.tideLogin(AdminUsername, AdminPassword);
			sheets.FilterRecrdToRetainRcrd_3684();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3684_FilterRecrdToRetainRcrd"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Filter records to retain records if conditions are met");
		videoRecordingStop();
	}
	
	@Test(priority =416, groups={"TC3695_FilterRecrdToDiscardRcrd"})
	public void TC3695_FilterRecrdToDiscardRcrd()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3695_FilterRecrdToDiscardRcrd");
			sheets.FilterRecrdToDiscardRcrd_3695();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3695_FilterRecrdToDiscardRcrd"+e.getMessage(), "FAIL");
		}/*finally{
			login.tideCompanyAdminLogOut();
		}*/
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Filter records to discard records if conditions are met");
		videoRecordingStop();
	}
			
}
