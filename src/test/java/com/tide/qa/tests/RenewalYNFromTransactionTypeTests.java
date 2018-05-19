package com.tide.qa.tests;
import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

public class RenewalYNFromTransactionTypeTests extends TestBase {

	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1 = "Pa55word123";
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	
	@Test(priority =285, groups={"TC3759_renewalYNTransactionType_January"})
	public void TC3759_renewalYNTransactionType_January()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3759_renewalYNTransactionType_January");
			//login.tideLogin(AdminUsername1, AdminPassword1);
			sheets.renewalYNTransactionType_January_3759();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3759_renewalYNTransactionType_January"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Renewal Y/N Transaction Type (January) Verification");
		videoRecordingStop();
	}
	
	@Test(priority =286, groups={"TC3761_mappingcount"})
	public void TC3761_mappingcount()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3761_mappingcount");
			sheets.mappingCount_3761();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3761_mappingcount"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("validate mapping count in Reference Dataset");
		videoRecordingStop();
	}

	@Test(priority =287, groups={"TC3760_renewalYNTransactionType_February"})
	public void TC3760_renewalYNTransactionType_February()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3760_renewalYNTransactionType_February");
			sheets.renewalYNTransactionType_February_3760();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3760_renewalYNTransactionType_February"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Renewal Y/N Transaction Type (February) Verification");
		videoRecordingStop();
	}
	
	@Test(priority =288, groups={"TC3762_validatemappingIncrementalIncrease"})
	public void TC3762_validatemappingIncrementalIncrease()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3762_validatemappingIncrementalIncrease");
			sheets.mappingIncrementalIncrease_3762();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3762_validatemappingIncrementalIncrease"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("mapping Incremental Increase Verification");
		videoRecordingStop();
	}
	
	@Test(priority =289, groups={"TC3773_PasswordProtectedFiles"})
	public void TC3773_PasswordProtectedFiles()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3773_PasswordProtectedFiles");
			sheets.PasswordProtectedFiles_3773();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3773_PasswordProtectedFiles"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Submission of password protected file - information screen displays stating not permitted");
		videoRecordingStop();
	}	
	
}
