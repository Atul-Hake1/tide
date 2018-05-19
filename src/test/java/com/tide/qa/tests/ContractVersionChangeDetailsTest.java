package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.ContractVersionChangeDetailsPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

public class ContractVersionChangeDetailsTest extends TestBase {

	ContractVersionChangeDetailsPage ContractVersionPage = new ContractVersionChangeDetailsPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	String AdminUsername1 = "dave.brit@brit.com";
	String AdminPassword1 = "Pa55word123";
	
	@Test(priority = 95, groups={"TC4402_VersionChanges_Settings"})
	public void TC4402_VersionChanges_Settings()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4402_VersionChanges_Settings");
			//login.tideLogin(AdminUsername, AdminPassword);
			ContractVersionPage.VersionChanges_Settings_TC4402();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4402_VersionChanges_Settings "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Version Changes_Settings");
		videoRecordingStop();
	}
	@Test(priority = 96, groups={"TC4406_VersionChanges_Contract"})
	public void TC4406_VersionChanges_Contract()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4406_VersionChanges_Contract");
		//	login.tideLogin(AdminUsername, AdminPassword);
			ContractVersionPage.VersionChanges_Contract_TC4406();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4406_VersionChanges_Contract "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Version Changes_Contract");
		videoRecordingStop();
	}
	@Test(priority = 97, groups={"TC4414_Version_Changes_ContractAndSettings"})
	public void TC4414_Version_Changes_ContractAndSettings()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4414_Version_Changes_ContractAndSettings");
			//login.tideLogin(AdminUsername, AdminPassword);
			ContractVersionPage.Version_Changes_ContractAndSettings_TC4414();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4414_Version_Changes_ContractAndSettings"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Version Changes Contract And Settings");
		videoRecordingStop();
	}
}
