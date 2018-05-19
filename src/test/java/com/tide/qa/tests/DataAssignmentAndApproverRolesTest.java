package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.BordereauQuePage;
import com.tide.qa.pagefactory.DataAssignmentAndApproverRolesPage;
import com.tide.qa.utility.Report;


public class DataAssignmentAndApproverRolesTest  extends TestBase
{

	DataAssignmentAndApproverRolesPage assignment = new DataAssignmentAndApproverRolesPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Pa55word123";
	

	@Test(priority =442, groups={"TC4661_AutomaticAssignment"})
	public void TC4661_AutomaticAssignment()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4661_AutomaticAssignment");
			//login.tideLogin(AdminUsername2, AdminPassword2);
			assignment.automaticAssignment_4661();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4661_AutomaticAssignment"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Automatic assignment where single Section & single Risk Code");
		videoRecordingStop();
	}
	
	@Test(priority =443, groups={"TC4427_SectionAndRiskCode"})
	public void TC4427_SectionAndRiskCode()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4427_SectionAndRiskCode");
			assignment.sectionAndRiskCode_4427();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4427_SectionAndRiskCode"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Section and Risk Code as based on previously set rules & Risk Code as based on default selection");
			videoRecordingStop();
	}
	
	@Test(priority =444, groups={"TC4559_UpdateAssignmentMapping"})
	public void TC4559_UpdateAssignmentMapping()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4559_UpdateAssignmentMapping");
			assignment.updateAssignmentMapping_4559();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4559_UpdateAssignmentMapping"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Update of assignment mapping rules during assignment phase as new values identified & rules edited from Reporting Channel");
			videoRecordingStop();
	}
	
	

}
