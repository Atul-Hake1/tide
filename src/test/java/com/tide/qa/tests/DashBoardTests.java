package com.tide.qa.tests;

import org.testng.annotations.Test;
import com.tide.qa.common.TestBase;
//import com.tide.qa.pagefactory.ContractMetadataPage;
import com.tide.qa.pagefactory.DashBoardPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

public class DashBoardTests extends TestBase {
	
	DashBoardPage dashboard = new DashBoardPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	
	@Test(priority = 65, groups={"TC3379_AddDashboard"})
	public void TC3379_AddDashboard()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3379_AddDashboard");
			//login.tideLogin(AdminUsername, AdminPassword);
			dashboard.addDashboard_3379();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3379_AddDashboard"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add Dashboard Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 66, groups={"TC3380_EditDashboard"})
	public void TC3380_EditDashboard()
	{
		Report.createTestCaseReportHeader();
		
		try
		{
			videoRecordingStart("TC3380_EditDashboard");
			dashboard.editDashboard_3380();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3380_EditDashboard"+e.getMessage(), "FAIL");
		}
		/*finally{
			login.tideAdminLogOut();
		}*/
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit Dashboard Verification");
		videoRecordingStop();
	}
}
