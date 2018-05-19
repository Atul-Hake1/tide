package com.tide.qa.tests;
import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.BreachManagmentPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.PolicyPage;
import com.tide.qa.pagefactory.Rules;
import com.tide.qa.utility.Report;

public class BreachmanagmentTest  extends TestBase {
	LoginPage login = new LoginPage();

	BreachManagmentPage BrchMngnt = new BreachManagmentPage();
	String Admin1Username = "admin@tide.com";
	String Admin1Password ="Systenics123@";
	String AdminUsername = "dave.brit@brit.com";
	String AdminPassword = "Pa55word123";

	@Test(priority =98, groups={"TC5127_NoChangeToExistngBreach"})
	public void TC5127_NoChangeToExistngBreach()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC5127_NoChangeToExistngBreach");
			//login.tideLogin(Admin1Username, Admin1Password);
			BrchMngnt.NoChangeToExistngBreach_5127();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5127_NoChangeToExistngBreach "+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("No change to existing Breach");
		videoRecordingStop();
	}
	
	@Test(priority =99, groups={"TC5128_UpdateToExistngBreach"})
	public void TC5128_UpdateToExistngBreach()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC5128_UpdateToExistngBreach");
			//login.tideLogin(Admin1Username, Admin1Password);
			BrchMngnt.UpdateToExistngBreach_5128();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5128_UpdateToExistngBreach "+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Updates to existing Breaches that result in change in the Breach");
		videoRecordingStop();
	}

	
	@Test(priority =100, groups={"TC5129_AchiveOfPreviousBreach"})
	public void TC5129_AchiveOfPreviousBreach()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC5129_AchiveOfPreviousBreach");
			//login.tideLogin(Admin1Username, Admin1Password);
			BrchMngnt.AchiveOfPreviousBreach_5129();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5129_AchiveOfPreviousBreach "+e.getMessage(), "FAIL");
		}
			
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Archive of previously created Breach.");
		videoRecordingStop();
	}
}
