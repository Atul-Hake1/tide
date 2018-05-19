package com.tide.qa.tests;
import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.BreachManagmentPage;
import com.tide.qa.pagefactory.ContractEndoEffectiveDatePage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.PolicyPage;
import com.tide.qa.pagefactory.Rules;
import com.tide.qa.utility.Report;

public class ContractEndoEffctivedateTest  extends TestBase {
	LoginPage login = new LoginPage();

	ContractEndoEffectiveDatePage ConEFD = new ContractEndoEffectiveDatePage();
	String Admin1Username = "admin@tide.com";
	String Admin1Password ="Systenics123@";
	
	@Test(priority =101, groups={"TC5150_CreateConEffectvdate"})
	public void TC5150_CreateConEffectvdate()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC5150_CreateConEffectvdate");
			//login.tideLogin(Admin1Username, Admin1Password);
			ConEFD.CreateConEffectvdate_5150();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5150_CreateConEffectvdate "+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Create Contract Endorsement with Effective Date - future Date");
		videoRecordingStop();
	}
	
	@Test(priority =102, groups={"TC5151_CreateConEffectvdatePastNtIncptnDate"})
	public void TC5151_CreateConEffectvdatePastNtIncptnDate()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC5151_CreateConEffectvdatePastNtIncptnDate");
			//login.tideLogin(Admin1Username, Admin1Password);
			ConEFD.CreateConEffectvdatePastNtIncptnDate_5151();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5151_CreateConEffectvdatePastNtIncptnDate "+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Create Contract Endorsemnet with Effective Date -Past & not equal to Contract Inception Date");
		videoRecordingStop();
	}
	
	
	@Test(priority =103, groups={"TC5152_CreateConEffectvdateEqualsIncptnDate"})
	public void TC5152_CreateConEffectvdateEqualsIncptnDate()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC5152_CreateConEffectvdateEqualsIncptnDate");
			//login.tideLogin(Admin1Username, Admin1Password);
			ConEFD.CreateConEffectvdateEqualsIncptnDate_5152();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5152_CreateConEffectvdateEqualsIncptnDate "+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Create Contract Endorsemnet with Effective Date - Equal to Contract Inception Date");
		videoRecordingStop();
	}

}
