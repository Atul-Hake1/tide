package com.tide.qa.tests;

import org.testng.annotations.Test;
import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.FinancialCalculationClaimPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

public class FinancialCalculationClaimTest extends TestBase{

	FinancialCalculationClaimPage sheets = new FinancialCalculationClaimPage();
	//Stage2Page s2 = new Stage2Page();
	LoginPage login = new LoginPage();
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Pa55word123";
	
	@Test(priority =422, groups={"TC4094_Calculate_Fees_Reserve"})
	public void TC4094_Calculate_Fees_Reserve()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4094_Calculate_Fees_Reserve");
			//login.tideLogin(AdminUsername2, AdminPassword2);
			sheets.CalculateFeesReserve_4094();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4094_Calculate_Fees_Reserve"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Calculate Fees Reserve");
		videoRecordingStop();
	}
	@Test(priority =423, groups={"TC4095_CalculateFeesPaid"})
	public void TC4095_CalculateFeesPaid()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4095_CalculateFeesPaid");
			sheets.CalculateFeesPaid_4095();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4095_CalculateFeesPaid"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Calculate Paid Fees");
		videoRecordingStop();
	}
	@Test(priority =424, groups={"TC4093_CalculateFees_TotalIncurred"})
	public void TC4093_CalculateFees_TotalIncurred()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4093_CalculateFees_TotalIncurred");
			sheets.CalculateFees_TotalIncurred_4093();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4093_CalculateFees_TotalIncurred"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Calculate Fees Total Incurred");
		videoRecordingStop();
	}
	@Test(priority =425, groups={"TC4092_Indemnity_TotalIncurred"})
	public void TC4092_Indemnity_TotalIncurred()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4092_Indemnity_TotalIncurred");
			sheets.Indemnity_TotalIncurred_4092();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4092_Indemnity_TotalIncurred"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Calculate Indemnity Total Incurred");
		videoRecordingStop();
	}
	@Test(priority =426, groups={"TC4089_CalculateTotal_Reserve"})
	public void TC4089_CalculateTotal_Reserve()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4089_CalculateTotal_Reserve");
			sheets.CalculateTotal_Reserve_4089();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4089_CalculateTotal_Reserve"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Calculate Total Reserve");
		videoRecordingStop();
	}
	@Test(priority =427, groups={"TC4090_Total_Paid"})
	public void TC4090_Total_Paid()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4090_Total_Paid");
			sheets.CalculateTotal_Paid_4090();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4090_Total_Paid"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Calculate Total Paid");
		videoRecordingStop();
	}
	@Test(priority =428, groups={"TC4091_Total_Incurred"})
	public void TC4091_Total_Incurred()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4091_Total_Incurred");
			sheets.CalculateTotal_Incurred_4091();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4091_Total_Incurred"+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Calculate Total Incurred");
		videoRecordingStop();
	}
	
	@Test(priority =429, groups={"TC4096_ChangeValuePositiveToNegative"})
	public void TC4096_ChangeValuePositiveToNegative()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4096_ChangeValuePositiveToNegative");
			sheets.positiveToNegative_4096();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4096_ChangeValuePositiveToNegative"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Change Value Positive To Negative verification");
		videoRecordingStop();
	}
	
	@Test(priority =430, groups={"TC4103_ClaimsFinancials"})
	public void TC4103_ClaimsFinancials()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4103_ClaimsFinancials");
			sheets.claimsFinancials_4103();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4103_ClaimsFinancials"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Claims Financials-paid Transactional and Reserve-Restatement verification");
		videoRecordingStop();
	}
	
	@Test(priority =431, groups={"TC4104_ClaimsFinancials"})
	public void TC4104_ClaimsFinancials()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4104_ClaimsFinancials");
			sheets.claimsFinancials_4104();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4103_ClaimsFinancials"+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Claims Financials- paid Transactional verification");
		videoRecordingStop();
	}
}
