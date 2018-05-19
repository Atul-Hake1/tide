package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.FinancialCalculationRiskAndPremiumPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

public class FinancialCalculationRiskAndPremiumTests extends TestBase {
	
	FinancialCalculationRiskAndPremiumPage RPpage= new FinancialCalculationRiskAndPremiumPage();
	LoginPage login = new LoginPage();
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Pa55word123";

	@Test(priority =432, groups={"TC4009_FCRiskAndPremium_Transactiontype"})
	public void TC4009_FCRiskAndPremium_Transactiontype()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4009_FCRiskAndPremium_Transactiontype");
			//login.tideLogin(AdminUsername2, AdminPassword2);
			RPpage.riskAndPremiumForTransactionType_4009();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4009_FCRiskAndPremium_Transactiontype"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Financial calculation Risk and premium for Transaction type Verification");
		videoRecordingStop();
	}
	
	@Test(priority =433, groups={"TC4010_TransactionTypeNotSupplied"})
	public void TC4010_TransactionTypeNotSupplied()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4010_TransactionTypeNotSupplied");
			RPpage.transactionTypeNotSupplied_4010();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4010_TransactionTypeNotSupplied"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Transaction Type Not Supplied Verification");
		videoRecordingStop();
	}
	
	@Test(priority =434, groups={"TC4011_ReportingtypeRESTATEMENT"})
	public void TC4011_ReportingtypeRESTATEMENT()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4011_ReportingtypeRESTATEMENT");
			RPpage.finalcialCalculationRESTATEMENT_4011();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4011_ReportingtypeRESTATEMENT"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Reporting type RESTATEMENT Verification");
		videoRecordingStop();
	}
	
	@Test(priority =435, groups={"TC4013_ReportingtypeRESTATEMENT"})
	public void TC4013_ReportingtypeRESTATEMENT()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4013_ReportingtypeRESTATEMENT");
			RPpage.riskAndPremiumForReportingtypeRESTATEMENT_4013();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4013_ReportingtypeRESTATEMENT"+e.getMessage(), "FAIL");
		}
		/*finally{
			login.tideCompanyAdminLogOut();
		}*/
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Transaction type not supplied and Reporting type RESTATEMENT Verification");
		videoRecordingStop();
	}	
	
}
