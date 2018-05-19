package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.OutputFormatPage;
import com.tide.qa.pagefactory.Stage2Page;
import com.tide.qa.utility.Report;

public class OutputFormatTests extends TestBase
{
	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	OutputFormatPage OT = new OutputFormatPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	
	@Test(priority =87, groups={"TC3535_AddOutputFormat"})
	public void TC3535_AddOutputFormat()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3535_AddOutputFormat");
			//login.tideLogin(AdminUsername, AdminPassword);
			OT.AddOutputFormat_3535();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3535_AddOutputFormat "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add Output Format");
		videoRecordingStop();
	}
	
	@Test(priority =88, groups={"TC3536_EditOutputFormat"})
	public void TC3536_EditOutputFormat()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3536_EditOutputFormat");
			OT.EditOutputFormat_3536();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3536_EditOutputFormat "+e.getMessage(), "FAIL");
		}/*finally{
			login.tideAdminLogOut();
		}*/
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit Output Format");
		videoRecordingStop();
	}
		
}
