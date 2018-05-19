package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.AdminPermissionPage;
import com.tide.qa.pagefactory.BordereauProcessPage;
//import com.tide.qa.pagefactory.CompanyPermissionPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.OutputFormatPage;
import com.tide.qa.pagefactory.Stage2Page;
import com.tide.qa.utility.Report;

public class PemissionAdminTest extends TestBase
{
	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	//CompanyPermissionPage CP = new CompanyPermissionPage();
	AdminPermissionPage AP = new AdminPermissionPage();
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
	
	String AdminUsernameReadOnlyCoverHolder = "readonly.jones@coverholderinc.com";
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
			
	@Test(priority =617, groups={"TC4174_AdminOperations"})
	public void TC4174_AdminOperations()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4174_AdminOperations");
			login.tideLogin(AdminUsername, AdminPassword);
			AP.AdminPermission_4174();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4174_AdminOperations "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Admin operations- Tide admin");
		videoRecordingStop();
	}
	
	@Test(priority =618, groups={"TC4175_AdminTypeInsurer"})
	public void TC4175_AdminTypeInsurer()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4175_AdminTypeInsurer");
			login.tideLogin(AdminUsername1, AdminPassword1);
			AP.ComAdminTypeInsurer_4175();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4175_AdminTypeInsurer "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Admin operations- Company Admin of type Insurer");
		videoRecordingStop();
	}
	
	@Test(priority =619, groups={"TC4180_StandardUserTypeInsurer"})
	public void TC4180_StandardUserTypeInsurer()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4180_StandardUserTypeInsurer");
			login.tideLogin(AdminUsername1Std, AdminPassword1Std);
			AP.StandardUserTypeInsurer_4180();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4180_StandardUserTypeInsurer "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Admin operations- Standard user of type Insurer");
		videoRecordingStop();
	}
	
	@Test(priority =620, groups={"TC4185_ReadOnlyUserTypeInsurer"})
	public void TC4185_ReadOnlyUserTypeInsurer()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4185_ReadOnlyUserTypeInsurer");
			login.tideLogin(AdminUsername1ReadOnly, AdminPassword1ReadOnly);
			AP.ReadOnlyUserTypeInsurer_4185();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4185_ReadOnlyUserTypeInsurer "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Admin operations- Read only of type Insurer");
		videoRecordingStop();
	}
	
	@Test(priority =621, groups={"TC4176_CompAdminTypeBrocker"})
	public void TC4176_CompAdminTypeBrocker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4176_CompAdminTypeBrocker");
			login.tideLogin(AdminUsername1CompBrocker, AdminPassword1CompBrocker);
			AP.ComAdminTypeBrocker_4176();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4176_CompAdminTypeBrocker "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Admin operations- Company Admin of type broker");
		videoRecordingStop();
	}
	
	@Test(priority =622, groups={"TC4181_StandrdUserTypeBrocker"})
	public void TC4181_StandrdUserTypeBrocker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4181_StandrdUserTypeBrocker");
			login.tideLogin(AdminUsername1StandrdBrocker, AdminPassword1StandrdBrocker);
			AP.StandardUserTypeBroker_4181();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4181_StandrdUserTypeBrocker "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Admin operations- Company Admin of type broker");
		videoRecordingStop();
	}
	
	@Test(priority =623, groups={"TC4186_ReadOnlyUserTypeBrocker"})
	public void TC4186_ReadOnlyUserTypeBrocker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4186_ReadOnlyUserTypeBrocker");
			login.tideLogin(AdminUsername1ReadOnlyBrok, AdminPassword1ReadOnlyBrok);
			AP.ReadOnlyUserTypeBrocker_4186();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4186_ReadOnlyUserTypeBrocker "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Admin operations- Read only of type Broker");
		videoRecordingStop();
	}
	
	@Test(priority =624, groups={"TC4177_ComAdminTypeCoverholder"})
	public void TC4177_ComAdminTypeCoverholder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4177_ComAdminTypeCoverholder");
			login.tideLogin(AdminUsernameCoverHolder, AdminPasswordCoverHolder);
			AP.ComAdminTypeCoverHolder_4177();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4177_ComAdminTypeCoverholder "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Admin operations- Company Admin of type coverholder");
		videoRecordingStop();
	}
	
	@Test(priority =625, groups={"TC4182_StanduserTypeCoverholder"})
	public void TC4182_StanduserTypeCoverholder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4182_StanduserTypeCoverholder");
			login.tideLogin(AdminUsernameStandrdCoverHolder, AdminPasswordStandrdCoverHolder);
			AP.StandardUserTypeCoverHolder_4182();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4182_StanduserTypeCoverholder "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Admin operations- Standard user of type Coverholder");
		videoRecordingStop();
	}
	
	@Test(priority =626, groups={"TC4187_ReadOnlyTypeCoverholder"})
	public void TC4187_ReadOnlyTypeCoverholder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4187_ReadOnlyTypeCoverholder");
			login.tideLogin(AdminUsernameReadOnlyCoverHolder, AdminPasswordReadOnlyCoverHolder);
			AP.ReadOnlyUserTypeCoverHolder_4187();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4187_ReadOnlyTypeCoverholder "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Admin operations- Read only of type coverholder");
		videoRecordingStop();
	}

	@Test(priority =627, groups={"TC4178_CompAdminTypeTPA"})
	public void TC4178_CompAdminTypeTPA()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4178_CompAdminTypeTPA");
			login.tideLogin(AdminUsernameTPA, AdminPasswordTPA);
			AP.ComAdminTypeTPA_4178();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4178_CompAdminTypeTPA"+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Admin operations- Company Admin of type TPA");
		videoRecordingStop();
	}
		
	@Test(priority =628, groups={"TC4183_StandardUserTypeTPA"})
	public void TC4183_StandardUserTypeTPA()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4183_StandardUserTypeTPA");
			login.tideLogin(AdminUsernameStandardTPA, AdminPasswordStandardTPA);
			AP.StandardUserTypeTPA_4183();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4183_StandardUserTypeTPA"+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Admin operations- Standard user of type TPA");
		videoRecordingStop();
	}
	
	@Test(priority =629, groups={"TC4189_ReadOnlyTypeTPA"})
	public void TC4189_ReadOnlyTypeTPA()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4189_ReadOnlyTypeTPA");
			login.tideLogin(AdminUsernameReadOnlyCoverHolder, AdminPasswordReadOnlyCoverHolder);
			AP.ReadOnlyUserTypeTPA_4189();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4189_ReadOnlyTypeTPA"+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Admin operations- Read only of type TPA");
		videoRecordingStop();
	}

	@Test(priority =630, groups={"TC4179_CompAdminTypeServiceProvider"})
	public void TC4179_CompAdminTypeServiceProvider()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4179_CompAdminTypeServiceProvider");
			login.tideLogin(AdminUsernameServicePrvd, AdminPasswordServicePrvd);
			AP.CompAdminUserTypeServiceProvdr_4179();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4179_CompAdminTypeServiceProvider"+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Admin operations- Company Admin of type Service provider");
		videoRecordingStop();
	}
	
	@Test(priority =631, groups={"TC4184_StandrdUserTypeServiceProvider"})
	public void TC4184_StandrdUserTypeServiceProvider()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4184_StandrdUserTypeServiceProvider");
			login.tideLogin(StandrdUsernameServicePrvd, StandrdPasswordServicePrvd);
			AP.StandardUserTypeServiceProdr_4184();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4184_StandrdUserTypeServiceProvider"+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Admin operations- Standard user of type Service provider");
		videoRecordingStop();
	}
	
	@Test(priority =632, groups={"TC4188_ReadOnlyUserTypeServiceProvider"})
	public void TC4188_ReadOnlyUserTypeServiceProvider()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4188_ReadOnlyUserTypeServiceProvider");
			login.tideLogin(ReadOnlyUsernameTypServicePrvd, ReadOnlyPasswordTypServicePrvd);
			AP.ReadOnlyUserTypeServicePro_4188();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4188_ReadOnlyUserTypeServiceProvider"+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Admin operations- Read only of type Service provider");
		videoRecordingStop();
	}
	
}
