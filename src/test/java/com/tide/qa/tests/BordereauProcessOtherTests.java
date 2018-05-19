package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

public class BordereauProcessOtherTests extends TestBase
{
	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword = "Pa55word123";
	
	@Test(priority =246, groups={"TC3210_AddInvalidInceptionDateField"})
	public void TC3210_AddInvalidInceptionDateField()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3210_AddInvalidInceptionDateField");
			//login.tideLogin(AdminUsername, AdminPassword);
			sheets.addInvalidInceptionDataFiled_3210();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3210_AddInvalidInceptionDateField"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add invalid inception data field verification");
		videoRecordingStop();
		}
	
	@Test(priority =247, groups={"TC3216_InvalidTransactionTypeError"})
	public void TC3216_InvalidTransactionTypeError()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3216_InvalidTransactionTypeError");
			sheets.invalidTransactionTypeError_3216();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3216_InvalidTransactionTypeError"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Invalid Transaction type error verification");
		videoRecordingStop();
		}
	
	@Test(priority =248, groups={"TC3244_YOAError"})
	public void TC3244_YOAError()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3244_YOAError");
			sheets.yoaError_3244();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3244_YOAError"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("YOA error verification");
		videoRecordingStop();
	}

	@Test(priority =249, groups={"TC3245_RiskContractPeriodIdentified"})
	public void TC3245_RiskContractPeriodIdentified()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3245_RiskContractPeriodIdentified");
			sheets.contractPeriodIdentification_3245();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3245_RiskContractPeriodIdentified "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Verify Risk Contract Period Identified");
		videoRecordingStop();
	}
	
	@Test(priority =250, groups={"TC3523_ContractStatusCheck"})
	public void TC3523_ContractStatusCheck()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3523_ContractStatusCheck");
			sheets.contractStatusCheck_3523();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3523_ContractStatusCheck "+e.getMessage(), "FAIL");
		}/*finally{
			login.tideCompanyAdminLogOut();
		}*/
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Contract Status Check Verification");
		videoRecordingStop();
	}
	@Test(priority =667, groups={"TC5675_ZeroPassRecord"})
	public void TC5675_ZeroPassRecord()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC5675_ZeroPassRecord");
			sheets.ZeroPassRecord_TC5675();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5675_ZeroPassRecord "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Contract Status Check Verification");
		videoRecordingStop();
	}
}
