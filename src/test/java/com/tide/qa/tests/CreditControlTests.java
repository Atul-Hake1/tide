package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.Stage2Page;
import com.tide.qa.utility.Report;

public class CreditControlTests extends TestBase
{
	BordereauProcessPage sheets = new BordereauProcessPage();
	Stage2Page s2 = new Stage2Page();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	
	@Test(priority =89, groups={"TC3671_CreditControl"})
	public void TC3671_CreditControl()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3671_CreditControl");
			//login.tideLogin(AdminUsername, AdminPassword);
			s2.CreditControl_3671();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3671_CreditControl"+e.getMessage(), "FAIL");
		}/*finally{
			login.tideAdminLogOut();
		}*/
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Use Credit Control screen");
		videoRecordingStop();		
	}
			
}
