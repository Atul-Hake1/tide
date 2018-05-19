package com.tide.qa.tests;
import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;
public class BordereauProcessIdentifyContractTests extends TestBase {

	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Pa55word123";
	
	@Test(priority =110, groups={"TC5308_RecordsinContractdata"})
	public void TC5308_RecordsinContractdata()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC5308_RecordsinContractdata");
		//	login.tideLogin(AdminUsername, AdminPassword);
			sheets.recordsinContract_5308();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5308_RecordsinContractdata "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Records in Contract data should only relate to the Contract Instance");
		videoRecordingStop();
	}
}
