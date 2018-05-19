package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.CompanyPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

public class CompanyTests extends TestBase
{
	CompanyPage companyPage = new CompanyPage();
	LoginPage login = new LoginPage();
	 String AdminUsername = "admin@tide.com";
	 String AdminPassword = "Systenics123@";
	
	@Test(priority = 2, groups={"TC3151_AddCompany"})
	public void TC3151_AddCompany()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3151_AddCompany");
			//login.tideLogin(AdminUsername, AdminPassword);
			companyPage.addCompany();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3151_AddCompany"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add Company Verification");
		videoRecordingStop();
	}

	@Test(priority = 3, groups={"TC3152_EditCompany"})
	public void TC3152_EditCompany()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3152_EditCompany");
			companyPage.editCompany();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3152_EditCompany "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit Company Details");
		videoRecordingStop();
	}


	@Test(priority = 4, groups={"TC3154_AddDivision"})
	public void TC3154_AddDivision()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3154_AddDivision");
			companyPage.addDivision();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3154_AddDivision "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add Division Verification");
		videoRecordingStop();
	}
	

	@Test(priority = 5, groups={"TC3155_EditDivision"})
	public void TC3155_EditDivision()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3155_EditDivision");
			companyPage.editDivision();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3155_EditDivision "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit division Verification");
		videoRecordingStop();
	}

	@Test(priority = 20, groups={"TC3156_AddNewSubDivision"})
	public void TC3156_AddNewSubDivision()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3156_AddNewSubDivision");
			companyPage.addNewSubDivision();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3156_AddNewSubDivision "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add new sub division Verification");
		videoRecordingStop();
	}


	@Test(priority = 21, groups={"TC3157_EditSubDivision"})
	public void TC3157_EditSubDivision()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3157_EditSubDivision");
			companyPage.editSubDivision();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3157_EditSubDivisionDivision "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit Sub-Division Verification");
		videoRecordingStop();
	}

	@Test(priority = 22, groups={"TC3158_AddUserForCompany"})
	public void TC3158_AddUserForCompany()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3158_AddUserForCompany");
			companyPage.addNewUserForCompany();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3158_AddUserForCompany "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add user for company Verification");
		videoRecordingStop();
		}
	
	@Test(priority =23, groups={"TC3159_EditNewUser"})
	public void TC3159_EditNewUser()
	{
		Report.createTestCaseReportHeader();
		
		try
		{
			videoRecordingStart("TC3159_EditNewUser");
			companyPage.editNewUser();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3159_EditNewUser "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit user Verification");
		videoRecordingStop();
	}	
		
	@Test(priority = 24, groups={"TC3279_AddUserToDivision"})
	public void TC3279_AddUserToDivision()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3279_AddUserToDivision");
			companyPage.addUserToDivision();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3279_AddUserToDivision "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add User To Division Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 25, groups={"TC3280_AddUserToSubDivision"})
	public void TC3280_AddUserToSubDivision()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3280_AddUserToSubDivision");
			companyPage.addUserToSubDivision();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3280_AddUserToSubDivision "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add User To Sub Division Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 26, groups={"TC3163_ActivateUser"})
	public void TC3163_ActivateUser()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3163_ActivateUser");
			companyPage.activateNewUser();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3163_ActivateUser "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activate user verification");
		videoRecordingStop();
	}
	
	@Test(priority = 27, groups={"TC3164_DectivateUser"})
	public void TC3164_DectivateUser()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3164_DectivateUser");
			companyPage.deactivateNewUser();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3164_DectivateUser "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Deactivate user verification");
		videoRecordingStop();
	}
	
	@Test(priority = 28, groups={"TC4062_Edit_UserProfile_Of_User"})
	  public void TC4062_Edit_UserProfile_Of_User()
	  {
	   Report.createTestCaseReportHeader();
	   try
	   {
		   videoRecordingStart("TC4062_Edit_UserProfile_Of_User");
		   companyPage.Edit_UserProfile_Of_User_4062();

	   }catch(Exception e)
	   {
	    Report.LogInfo("Exception", "Exception in TC4062_Edit_UserProfile_Of_User "+e.getMessage(), "FAIL");
	   }
	   Report.createTestCaseReportFooter();
	   Report.SummaryReportlog("Edit UserProfile Of User");
	   videoRecordingStop();
	  }
}
