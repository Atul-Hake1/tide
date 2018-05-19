package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.AdminPermissionPage;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.CompanyPermissionPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.OutputFormatPage;
import com.tide.qa.pagefactory.Stage2Page;
import com.tide.qa.utility.Report;

public class CompanyPemissionTest extends TestBase
{
	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();	
	CompanyPermissionPage CP = new CompanyPermissionPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1 = "Pa55word123";
	
	String AdminUsername1Std = "standard.brookes@aspen.co.uk";
	String AdminPassword1Std = "Pa55word123";
	
	String AdminUsername1ReadOnly = "readonly.brookes@aspen.co.uk";
	String AdminPassword1ReadOnly = "Pa55word123";
	
	String AdminUsername1CompBrocker = "tushark@systenics.com";
	String AdminPassword1CompBrocker = "Test123@";
	
	String AdminUsername1StandrdBrocker = "tk.tester007@gmail.com";
	String AdminPassword1StandrdBrocker = "Test123@";
	
	String AdminUsername1ReadOnlyBrok = "shruti@systenics.com";
	String AdminPassword1ReadOnlyBrok = "2bnHmk$f";
	
	String AdminUsernameCoverHolder = "madhuri@systenics.com";
	String AdminPasswordCoverHolder = "Systenics123@";
	
	String AdminUsernameStandrdCoverHolder = "john.smith@coverholderinc.com";
	String AdminPasswordStandrdCoverHolder = "Pa55word123";
	
	String AdminUsernameReadOnlyCoverHolder = "readonly.brookes@aspen.co.uk";
	String AdminPasswordReadOnlyCoverHolder = "Pa55word123";
	
	String AdminUsernameTPA = "tushkadam91@gmail.com";
	String AdminPasswordTPA = "Test123@";
	
	String AdminUsernameStandardTPA = "standarduser@test.com";
	String AdminPasswordStandardTPA = "Test123@";
	
	String AdminUsernameServicePrvd = "nilesh@systenics.com";
	String AdminPasswordServicePrvd = "Test123@";
	
	String StandrdUsernameServicePrvd = "shrutika09deshmukh@gmail.com";
	String StandrdPasswordServicePrvd = "Test123@";
	
	String ReadOnlyUsernameTypServicePrvd = "tushar.driven@gmail.com";
	String ReadOnlyPasswordTypServicePrvd = "Systenics123@";
	
	@Test(priority =633, groups={"TC4050_CompanyPermissionTideAdmin"})
	public void TC4050_CompanyPermissionTideAdmin()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4050_CompanyPermissionTideAdmin");
			login.tideLogin(AdminUsername, AdminPassword);
			CP.CompanyPermissionTideAdmin_4050();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4050_CompanyPermissionTideAdmin "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Company permission- Tide Admin");
		videoRecordingStop();
	}
	
	@Test(priority =634, groups={"TC4051_CompanyPermissionCompanyAdmin"})
	public void TC4051_CompanyPermissionCompanyAdmin()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4051_CompanyPermissionCompanyAdmin");
			login.tideLogin(AdminUsername1, AdminPassword1);
			CP.CompanyUserComAdmin_4051();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4051_CompanyPermissionCompanyAdmin "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Company of User- Company Admin");
		videoRecordingStop();
	}
	
	@Test(priority =635, groups={"TC4052_CompanyStandardUser"})
	public void TC4052_CompanyStandardUser()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4052_CompanyStandardUser");
			login.tideLogin(AdminUsername1Std, AdminPasswordStandrdCoverHolder);
			CP.CompanyStandardUser_4052();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4052_CompanyStandardUser "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Company of User- Standard user");
		videoRecordingStop();
	}
	
	@Test(priority =636, groups={"TC4053_CompanyReadOnlyUser"})
	public void TC4053_CompanyReadOnlyUser()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4053_CompanyReadOnlyUser");
			login.tideLogin(AdminUsername1ReadOnly, AdminPassword1ReadOnly);
			CP.CompanyReadOnlyUser_4053();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4053_CompanyReadOnlyUser "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Company of User- Read only");
		videoRecordingStop();
	}
		
	/*@Test(priority =637, groups={"TC4054_CompanyNotOfUserCompanyAdmin"})
	public void TC4054_CompanyNotOfUserCompanyAdmin()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4054_CompanyNotOfUserCompanyAdmin");
			login.tideLogin(AdminUsername1, AdminPassword1);
			CP.CompanyAdminNotUser_4054();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4054_CompanyNotOfUserCompanyAdmin "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Company not of User - Company Admin");
		videoRecordingStop();
	}
	
	@Test(priority =638, groups={"TC4055_CompanyStandardUser"})
	public void TC4055_CompanyStandardUser()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4055_CompanyStandardUser");
			login.tideLogin(AdminUsernameStandrdCoverHolder, AdminPasswordStandrdCoverHolder);
			CP.CompanyStandardUser_4055();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4055_CompanyStandardUser "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Company not of User- Standard User");
		videoRecordingStop();
	}
	
	@Test(priority =639, groups={"TC4056_CompanyReadOnlyUser"})
	public void TC4056_CompanyReadOnlyUser()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4056_CompanyReadOnlyUser");
			login.tideLogin(AdminUsernameReadOnlyCoverHolder, AdminPasswordReadOnlyCoverHolder);
			CP.CompanyReadOnlyUser_4056();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4056_CompanyReadOnlyUser "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Company not of User -Read only");
		videoRecordingStop();
	}*/
}
