package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.SchedulePage;
import com.tide.qa.utility.Report;

public class ScheduleTests extends TestBase{

	SchedulePage Schedule= new SchedulePage();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	
	String AdminUsername1 = "dave.brit@brit.com";
	String AdminPassword1 = "Pa55word123";
	
	@Test(priority = 445, groups={"TC5122_Update_DataReferenceData_AdminArea"})
	public void TC5122_Update_DataReferenceData_AdminArea()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC5122_Update_DataReferenceData_AdminArea");
		//	login.tideLogin(AdminUsername1, AdminPassword1);
			Schedule.Update_DataReferenceData_AdminArea_TC5122();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5122_Update_DataReferenceData_AdminArea "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity role: Claim Approval - Read Only User of Insurer");
		videoRecordingStop();
	} 
	
	@Test(priority =105, groups={"TC5185_RiskPremiumBordereauType"})
	public void TC5185_RiskPremiumBordereauType()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC5185_RiskPremiumBordereauType");
		//	login.tideLogin(AdminUsername, AdminPassword);
			Schedule.riskPremiumBordereauType_5185();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5185_RiskPremiumBordereauType "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Risk & Premium Bordereau Type");
		videoRecordingStop();
	}
	
	@Test(priority =106, groups={"TC5188_RiskPremiumBordereauType"})
	public void TC5188_RiskPremiumBordereauType()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC5188_RiskPremiumBordereauType");
			//login.tideLogin(AdminUsername, AdminPassword);
			Schedule.coreFinancialRevisedCalculation_5188();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5188_RiskPremiumBordereauType "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Core Financial Revised Calculation");
		videoRecordingStop();
	}	

	
	@Test(priority =107, groups={"TC5085_LocationBreaches"})
	public void TC5085_LocationBreaches()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC5085_LocationBreaches");
		//	login.tideLogin(AdminUsername, AdminPassword);
			Schedule.locationBreaches_5085();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5085_LocationBreaches "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Location Breaches (Country and State Level)");
		videoRecordingStop();
	}
	
	@Test(priority =108, groups={"TC5190_BordereauSummaryErrorsandWarnings"})
	public void TC5190_BordereauSummaryErrorsandWarnings()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC5190_BordereauSummaryErrorsandWarnings");
			//login.tideLogin(AdminUsername, AdminPassword);
			Schedule.BordereauSummaryErrorsAndWarnings_5190();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5190_BordereauSummaryErrorsandWarnings "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Bordereau Summary Display of Errors and Warnings");
		videoRecordingStop();
	}
	
	@Test(priority =109, groups={"TC5303_copyfromsection1tosection2"})
	public void TC5303_copyfromsection1tosection2()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC5303_copyfromsection1tosection2");
		//	login.tideLogin(AdminUsername, AdminPassword);
			Schedule.bordereauSummaryErrorsAndWarnings_5303();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5303_copyfromsection1tosection2 "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Location breaches when copy from section 1 to section 2 &  Un-Approval Bordereaux");
		videoRecordingStop();
	}
	
	
}
