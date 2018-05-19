package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.Stage1Page;
import com.tide.qa.utility.Report;

public class Stage1Tests extends TestBase
{
	BordereauProcessPage sheets = new BordereauProcessPage();
	Stage1Page s1= new Stage1Page();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1 = "Pa55word123";
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Pa55word123";
	
	@Test(priority = 90, groups={"TC3369_AddNewPolicyInstance"})
	public void TC3369_AddNewPolicyInstance()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3369_AddNewPolicyInstance");
			//login.tideLogin(AdminUsername, AdminPassword);
			s1.addNewPolicyInstance();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3369_AddNewPolicyInstance "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add new  Policy instance Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 91, groups={"TC3702_AddExistingPolicies"})
	public void TC3702_AddExistingPolicies()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3702_AddExistingPolicies");
		//	login.tideLogin(AdminUsername, AdminPassword);
			s1.addExistingPolicies();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3702_AddExistingPolicies "+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add existing policies Verification");
		videoRecordingStop();
	}
	
}
