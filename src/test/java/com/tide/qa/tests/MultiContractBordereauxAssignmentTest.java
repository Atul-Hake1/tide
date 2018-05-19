package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

public class MultiContractBordereauxAssignmentTest extends TestBase {
	
	BordereauProcessPage BPPage = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	 String AdminUsername = "admin@tide.com";
	 String AdminPassword = "Systenics123@";
	
	@Test(priority = 111, groups={"TC5282_MultiContractbordereaux"})
	public void TC5282_MultiContractbordereaux()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC5282_MultiContractbordereaux");
			//login.tideLogin(AdminUsername, AdminPassword);
			BPPage.MultiContractbordereaux_TC5282();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5282_MultiContractbordereaux"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Multi-Contract bordereaux assignment screens in sequence");
		videoRecordingStop();
	}

}
