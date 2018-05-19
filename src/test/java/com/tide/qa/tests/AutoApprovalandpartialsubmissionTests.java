package com.tide.qa.tests;

import org.testng.annotations.Test;
import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.ApprovalAutoApprovalandpartialsubmissionPage;
//import com.tide.qa.pagefactory.ContractMetadataPage;
import com.tide.qa.pagefactory.DashBoardPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

public class AutoApprovalandpartialsubmissionTests extends TestBase {
	
	ApprovalAutoApprovalandpartialsubmissionPage Apprvl = new ApprovalAutoApprovalandpartialsubmissionPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1 = "Pa55word123";
	
	@Test(priority = 92, groups={"TC4756_LetTideSelctQue"})
	public void TC4756_LetTideSelctQue()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4756_LetTideSelctQue");
			//login.tideLogin(AdminUsername, AdminPassword);
			Apprvl.LetTideSelctQue_4756();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4756_LetTideSelctQue"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Let Tide select Questionnaire");
		videoRecordingStop();
	}
	
	@Test(priority = 93, groups={"TC4755_PatialSubResolvError"})
	public void TC4755_PatialSubResolvError()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4755_PatialSubResolvError");
			//login.tideLogin(AdminUsername, AdminPassword);
			Apprvl.PatialSubResolvError_4755();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4755_PatialSubResolvError"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Partial submission - resolve remaining errors");
		videoRecordingStop();
	}
	
	@Test(priority = 94, groups={"TC4754_PatialSubDisscardError"})
	public void TC4754_PatialSubDisscardError()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4754_PatialSubDisscardError");
			//login.tideLogin(AdminUsername, AdminPassword);
			Apprvl.PatialSubDisscardError_4754();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4754_PatialSubDisscardError"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Partial submission - discard remaining errors");
		videoRecordingStop();
	}
	
	@Test(priority = 314, groups={"TC4721_AutoApprvl"})
	public void TC4721_AutoApprvl()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4721_AutoApprvl");
			//login.tideLogin(AdminUsername1, AdminPassword1);
			Apprvl.AutoApprvl_4721();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4721_AutoApprvl"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Auto-approval of Bordereau");
		videoRecordingStop();
	}
	
	@Test(priority = 315, groups={"TC4720_ApprvlMultplConSameCon"})
	public void TC4720_ApprvlMultplConSameCon()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4720_ApprvlMultplConSameCon");
			//login.tideLogin(AdminUsername1, AdminPassword1);
			Apprvl.ApprvlMultplConSameCon_4720();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4720_ApprvlMultplConSameCon"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Approval of single Bordereau covering multiple Contracts of same Contract Folder");
		videoRecordingStop();
	}

}
