package com.tide.qa.tests;

import org.testng.annotations.Test;
import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.RateOfExchangePage;
import com.tide.qa.pagefactory.SchemaPage;
import com.tide.qa.utility.Report;

public class RateOfExchangeTests extends TestBase{

	RateOfExchangePage exchange = new RateOfExchangePage();
	SchemaPage schema= new SchemaPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	
	@Test(priority = 67, groups={"TC3376_EditRateofExchange"})
	public void TC3376_EditRateofExchange()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3376_EditRateofExchange");
			//login.tideLogin(AdminUsername, AdminPassword);
			exchange.editRateOfExchange_3376();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3376_EditRateofExchange"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit Rate of Exchange Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 68, groups={"TC3377_UploadinvalidRateofExchangeFile"})
	public void TC3377_UploadinvalidRateofExchangeFile()
	{
		Report.createTestCaseReportHeader();
		
		try
		{
			videoRecordingStart("TC3377_UploadinvalidRateofExchangeFile");
			exchange.uploadInvalidFile_3377();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3377_UploadinvalidRateofExchangeFile"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Upload invalid Rate of Exchange File Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 69, groups={"TC3378_UploadvalidRateofExchangeFile"})
	public void TC3378_UploadvalidRateofExchangeFile()
	{
		Report.createTestCaseReportHeader();
		
		try
		{	
			videoRecordingStart("TC3378_UploadvalidRateofExchangeFile");
			exchange.uploadvalidFile_3378();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3378_UploadvalidRateofExchangeFile"+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Upload valid Rate of Exchange File Verification");
		videoRecordingStop();
	}
}
