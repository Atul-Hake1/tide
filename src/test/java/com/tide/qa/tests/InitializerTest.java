package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.RecordVideo;
import com.tide.qa.utility.Report;

public class InitializerTest extends TestBase
{
	LoginPage loginPage = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Test123@";
	
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1 = "Test123@";
	
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2= "Pa55word123";
		
	@Test(priority = 1, groups={"LoginToTideAdmin"})
	public void LoginToTideAdmin()
	{
		
		Report.createTestCaseReportHeader();
		//videoFlag = g.getVideoFlag();
		//VideosPath = g.getResultFolderPath()+"\\Videos\\";

		try
		{
			videoRecordingStart("LoginToTideAdmin");
			loginPage.tideLogin(AdminUsername, AdminPassword);

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in LoginToTide"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Tide Login Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 19, groups={"ReLoginToTideAdmin"})
	public void ReLoginToTideAdmin()
	{
		
		Report.createTestCaseReportHeader();
		//videoFlag = g.getVideoFlag();
		//VideosPath = g.getResultFolderPath()+"\\Videos\\";

		try
		{
			videoRecordingStart("ReLoginToTideAdmin");
			loginPage.tideLogin(AdminUsername, AdminPassword);

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in ReLoginToTideAdmin"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Tide Login Verification");
		videoRecordingStop();
	}

	@Test(priority = 15, groups={"LoginToTideCompanyAdmin"})
	public void LoginToTideCompanyAdmin()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("LoginToTideCompanyAdmin");
			loginPage.tideLogin(AdminUsername1, AdminPassword1);

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in LoginToTide"+e.getMessage(), "FAIL");
			//videoRecordingStop();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Tide Login Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 201, groups={"LoginToTideCompanyAdmin2"})
	public void LoginToTideCompanyAdmin2()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("LoginToTideCompanyAdmin2");
			loginPage.tideLogin(AdminUsername1, AdminPassword1);

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in LoginToTideCompanyAdmin2"+e.getMessage(), "FAIL");
			//videoRecordingStop();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Tide Login Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 401, groups={"LoginToTideAdmin2"})
	public void LoginToTideAdmin2()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("LoginToTideAdmin2");
			loginPage.tideLogin(AdminUsername2, AdminPassword2);

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in LoginToTide"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Tide Login Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 3000, groups={"LogOut"})
	public void LogOut()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("LogOut");
			loginPage.tideReadOnlyLogOut();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in LoginToTide"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Tide Logout Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 14, groups={"TideAdminLogOut"})
	public void TideAdminLogOut()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("LogOut");
			loginPage.tideReadOnlyLogOut();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TideAdminLogOut"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Tide Logout Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 121, groups={"TideAdminLogout2"})
	public void TideAdminLogOut2()  
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("LogOut");
			loginPage.tideReadOnlyLogOut();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TideAdminLogout2"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Tide Logout Verification");
		videoRecordingStop();
	}
	
	@Test(priority =445, groups={"TideAdminLogout3"})
	public void TideAdminLogOut3()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("LogOut");
			loginPage.tideReadOnlyLogOut();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TideAdminLogout3"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Tide Logout Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 18, groups={"CompanyAdminLogout"})
	public void CompanyAdminLogOut()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("LogOut");
			loginPage.tideReadOnlyLogOut();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in CompanyAdminLogOut"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Tide Logout Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 316, groups={"CompanyAdminLogout2"})
	public void CompanyAdminLogOut2()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("LogOut");
			loginPage.tideReadOnlyLogOut();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in CompanyAdminLogOut2"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Tide Logout Verification");
		videoRecordingStop();
	}
}
