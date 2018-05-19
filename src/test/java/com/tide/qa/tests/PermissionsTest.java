package com.tide.qa.tests;
import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.Permissions;
import com.tide.qa.pagefactory.PolicyPage;
import com.tide.qa.utility.Report;

public class PermissionsTest extends TestBase {
	
	LoginPage login = new LoginPage();
	Permissions permission = new Permissions();
	String Admin1Username1 = "dave.brit@brit.com";
	String Admin1Password1 ="Pa55word123";
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	String Admin1Username2 = "companyadmin.brookes@aspen.co.uk";
	String Admin1Password2 ="Pa55word123";
	String StandardUsername = "standard.brookes@aspen.co.uk";
	String StandardPassword = "Pa55word123";
	String ReadonlyUserCompanyTypeInsurerUserName = "readonly.brookes@aspen.co.uk";
	String ReadonlyUserCompanyTypeInsurerPassword = "Pa55word123";
	String CompanyAdminTypeBrokerUserNamae = "tushark@systenics.com";
	String CompanyAdminTypeBrokerPassword = "Test123@";
	String CompanyAdminTypeBrokerUserNama1 = "shruti@systenics.com";
	String CompanyAdminTypeBrokerPassword1 = "2bnHmk$f";
	String StandardUserCompanyTypeBrokerUsername = "tk.tester007@gmail.com";
	String StandardUserCompanyTypeBrokerPassword = "Test123@";
	String ReadOnlyUserCompanyTypeInsuranceUsername = "readonly.brookes@aspen.co.uk";
	String ReadOnlyUserCompanyTypeInsurancePassword = "Pa55word123";
	String StandardUserTypeCoverholderUsername = "john.smith@coverholderinc.com";
	String StandardUserTypeCoverholderPassword = "Pa55word123";
	String CompanyAdminTypeCoverholderUsername = "madhuri@systenics.com";
	String CompanyAdminTypeCoverholderPassword = "Systenics123@";
	String ReadOnlyUserTypeCoverholderUsername = "readonly.jones@coverholderinc.com";
	String ReadOnlyUserTypeCoverholderPassword = "Pa55word123";
	String CompanyAdminCompanyTypeTPAUsername = "tushkadam91@gmail.com";
	String CompanyAdminCompanyTypeTPAPassword = "Test123@";
	String StandardUserCompanyTypeTPAUsername = "standarduser@test.com";
	String StandardUserCompanyTypeTPAPassword = "Test123@";
	String ReadUserCompanyTypeTPAUsername = "nohid@systenics.com";
	String ReadUserCompanyTypeTPAPassword = "2ceM$aig";
	String CompanyAdminTypeServiceProviderUsername = "nilesh@systenics.com";
	String CompanyAdminTypeServiceProviderPassword = "Test123@";
	String StandardUserTypeServiceProviderUsername = "shrutika09deshmukh@gmail.com";
	String StandardUserTypeServiceProviderPassword = "Test123@";
	String ReadUserTypeServiceProviderUsername = "tushar.driven@gmail.com";
	String ReadUserTypeServiceProviderPassword = "Systenics123@";
	
	
	@Test(priority = 601, groups={"TC4141_ContractTideAdminPermission"})
	public void TC4141_ContractTideAdminPermission()
	{
		Report.createTestCaseReportHeader();
		
		try
		{	
			videoRecordingStart("TC4141_ContractTideAdminPermission");
			login.tideLogin(AdminUsername, AdminPassword);
			permission.ContractTideAdminPermission_4141();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4141_ContractTideAdminPermission "+e.getMessage(), "FAIL");
		}
		finally{
			
			login.tideAdminLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Contract Tide Admin Permission");
		videoRecordingStop();
	}
	
	@Test(priority = 602, groups={"TC4142_CompanyAdminPermissionCompanyTypeInsurer"})
	public void TC4142_CompanyAdminPermissionCompanyTypeInsurer()
	{
		Report.createTestCaseReportHeader();
		
		try
		{	
			videoRecordingStart("TC4142_CompanyAdminPermissionCompanyTypeInsurer");
			login.tideLogin(Admin1Username2, Admin1Password2);
			permission.CompanyAdminPermissionForCompanyTypeInsurer_4142();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4142_CompanyAdminPermissionCompanyTypeInsurer "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideCompanyAdminLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Company Admin Permission For Company Type Insurer");
		videoRecordingStop();
	}
	
	@Test(priority = 603, groups={"TC4143_StandardUserPermissionCompanyInsurer"})
	public void TC4143_StandardUserPermissionCompanyInsurer()
	{
		Report.createTestCaseReportHeader();
		
		try
		{	
			videoRecordingStart("TC4143_StandardUserPermissionCompanyInsurer");
			login.tideLogin(StandardUsername, StandardPassword);
			permission.StandardUserPermissionCompanyInsurer_4143();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4143_StandardUserPermissionCompanyInsurer "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();			
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Standard User Permission Company Insurer");
		videoRecordingStop();
	}
	
	@Test(priority = 604, groups={"TC4144_ReadOnlyPermissionCompanyTypeInsurer"})
	public void TC4144_ReadOnlyPermissionCompanyTypeInsurer()
	{
		Report.createTestCaseReportHeader();
		
		try
		{	
			videoRecordingStart("TC4144_ReadOnlyPermissionCompanyTypeInsurer");
			login.tideLogin(ReadOnlyUserCompanyTypeInsuranceUsername,ReadOnlyUserCompanyTypeInsurancePassword );
			permission.ContractReadOnlyPermissionCompanyTypeInsurer_4144();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4144_ReadOnlyPermissionCompanyTypeInsurer "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();			
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Contract Read Only Permission Company Type Insurer");
		videoRecordingStop();
	}
	
	@Test(priority = 605, groups={"TC4330_CompanyAdminPermissionCoverholder"})
	public void TC4330_CompanyAdminPermissionCoverholder()
	{
		Report.createTestCaseReportHeader();
		
		try
		{	
			videoRecordingStart("TC4330_CompanyAdminPermissionCoverholder");
			login.tideLogin(CompanyAdminTypeCoverholderUsername,CompanyAdminTypeCoverholderPassword);
			permission.ContractCompanyAdminPermissionCompanyTypeCoverholder_4330();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4330_CompanyAdminPermissionCoverholder "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();			
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Contract Company Admin Permission Company Type Coverholder");
		videoRecordingStop();
	}	
	
	@Test(priority = 606, groups={"TC4329_StandardUserPermissionCoverholder"})
	public void TC4329_StandardUserPermissionCoverholder()
	{
		Report.createTestCaseReportHeader();
		
		try
		{	
			videoRecordingStart("TC4329_StandardUserPermissionCoverholder");
			login.tideLogin(StandardUserTypeCoverholderUsername,StandardUserTypeCoverholderPassword);
			permission.ContractStandardUserPermissionCompanyTypeCoverholder_4329();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4329_StandardUserPermissionCoverholder "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();			
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Contract Standard User Permission Company Type Coverholder");
		videoRecordingStop();
	}
	
	@Test(priority = 607, groups={"TC4325_ContractReadOnlyPermissionCoverholder"})
	public void TC4325_ContractReadOnlyPermissionCoverholder()
	{
		Report.createTestCaseReportHeader();
		
		try
		{	
			videoRecordingStart("TC4325_ContractReadOnlyPermissionCoverholder");
			login.tideLogin(ReadOnlyUserTypeCoverholderUsername,ReadOnlyUserTypeCoverholderPassword);
			permission.ContractReadOnlyPermissionCompanyTypeCoverholder_4325();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4325_ContractReadOnlyPermissionCoverholder "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();			
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Contract Read Only Permission Company Type Coverholder");
		videoRecordingStop();
	}

	@Test(priority = 608, groups={"TC4327_CompanyAdminPermissionCompanyTypeTPA"})
	public void TC4327_CompanyAdminPermissionCompanyTypeTPA()
	{
		Report.createTestCaseReportHeader();
		
		try
		{	
			videoRecordingStart("TC4327_CompanyAdminPermissionCompanyTypeTPA");
			login.tideLogin(CompanyAdminCompanyTypeTPAUsername,CompanyAdminCompanyTypeTPAPassword);
			permission.CompanyAdminPermissionCompanyTypeTPA_4327();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4327_CompanyAdminPermissionCompanyTypeTPA "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();			
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Contract Company Admin Permission Company Type TPA");
		videoRecordingStop();
	}

	
	@Test(priority = 609, groups={"TC4328_StandardUserPermissionCompanyTypeTPA"})
	public void TC4328_StandardUserPermissionCompanyTypeTPA()
	{
		Report.createTestCaseReportHeader();
		
		try
		{	
			videoRecordingStart("TC4328_StandardUserPermissionCompanyTypeTPA");
			login.tideLogin(StandardUserCompanyTypeTPAUsername,StandardUserCompanyTypeTPAPassword);
			permission.StandardUserPermissionCompanyTypeTPA_4328();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4328_StandardUserPermissionCompanyTypeTPA "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();			
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Contract Company Admin Permission Company Type TPA");
		videoRecordingStop();
	}
	
	@Test(priority = 610, groups={"TC4326_ReadOnlyPermissionForCompanyTypeTPA"})
	public void TC4326_ReadOnlyPermissionForCompanyTypeTPA()
	{
		Report.createTestCaseReportHeader();
		
		try
		{	
			videoRecordingStart("TC4326_ReadOnlyPermissionForCompanyTypeTPA");
			login.tideLogin(ReadUserCompanyTypeTPAUsername,ReadUserCompanyTypeTPAPassword);
			permission.ReadOnlyPermissionForCompanyTypeTPA_4326();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4326_ReadOnlyPermissionForCompanyTypeTPA "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();			
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Read Only Permission For Company Type TPA");
		videoRecordingStop();
	}
	
	@Test(priority = 611, groups={"TC4331_CompanyAdminPermissionServiceProvider"})
	public void TC4331_CompanyAdminPermissionServiceProvider()
	{
		Report.createTestCaseReportHeader();
		
		try
		{	
			videoRecordingStart("TC4331_CompanyAdminPermissionServiceProvider");
			login.tideLogin(CompanyAdminTypeServiceProviderUsername,CompanyAdminTypeServiceProviderPassword);
			permission.ContractCompanyAdminPermissionForCompanyTypeServiceProvider_4331();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4331_CompanyAdminPermissionServiceProvider "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();			
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Contract Company Admin Permission For Company Type Service Provider");
		videoRecordingStop();
	} 
	
	@Test(priority = 612, groups={"TC4332_StandardUserPermissionServiceProvider"})
	public void TC4332_StandardUserPermissionServiceProvider()
	{
		Report.createTestCaseReportHeader();
		
		try
		{	
			videoRecordingStart("TC4332_StandardUserPermissionServiceProvider");
			login.tideLogin(StandardUserTypeServiceProviderUsername,StandardUserTypeServiceProviderPassword);
			permission.StandardUserPermissionForCompanyTypeServiceProvider_4332();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4332_StandardUserPermissionServiceProvider "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();			
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Standard User Permission For Company Type Service Provider");
		videoRecordingStop();
	}
	
	@Test(priority = 613, groups={"TC4333_ReadOnlyPermissionForCompanyTypeServiceProvider"})
	public void TC4333_ReadOnlyPermissionForCompanyTypeServiceProvider()
	{
		Report.createTestCaseReportHeader();
		
		try
		{	
			videoRecordingStart("TC4333_ReadOnlyPermissionForCompanyTypeServiceProvider");
			login.tideLogin(ReadUserTypeServiceProviderUsername,ReadUserTypeServiceProviderPassword);
			permission.ReadOnlyPermissionForCompanyTypeServiceProvider_4333();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4333_ReadOnlyPermissionForCompanyTypeServiceProvider "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();			
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Read Only Permission For Company Type Service Provider");
		videoRecordingStop();
	}	
	
	
	
	@Test(priority = 614, groups={"TC4148_CompanyAdminPermissionCompanyTypeBroker"})
	public void TC4148_CompanyAdminPermissionCompanyTypeBroker()
	{
		Report.createTestCaseReportHeader();
		
		try
		{	
			videoRecordingStart("TC4148_CompanyAdminPermissionCompanyTypeBroker");
			login.tideLogin(CompanyAdminTypeBrokerUserNamae, CompanyAdminTypeBrokerPassword);
			permission.CompanyAdminPermissionCompanyTypeBroker_4148();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4148_CompanyAdminPermissionCompanyTypeBroker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();			
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Company Admin Permission Company Type Broker");
		videoRecordingStop();
	}
	
	@Test(priority = 615, groups={"TC4149_StandardUserPermissionCompanyTypeBroker"})
	public void TC4149_StandardUserPermissionCompanyTypeBroker()
	{
		Report.createTestCaseReportHeader();
		
		try
		{	
			videoRecordingStart("TC4149_StandardUserPermissionCompanyTypeBroker");
			login.tideLogin(StandardUserCompanyTypeBrokerUsername, StandardUserCompanyTypeBrokerPassword);
			permission.StandardUserPermissionCompanyTypeBroker_4149();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4149_StandardUserPermissionCompanyTypeBroker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();			
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Standard User Permission Company Type Broker");
		videoRecordingStop();
	}
	
	@Test(priority = 616, groups={"TC4335_ContractReadOnlyPermissionForCompanyTypeBroker"})
	public void TC4335_ContractReadOnlyPermissionForCompanyTypeBroker()
	{
		Report.createTestCaseReportHeader();
		
		try
		{	
			videoRecordingStart("TC4335_ContractReadOnlyPermissionForCompanyTypeBroker");
			login.tideLogin(CompanyAdminTypeBrokerUserNama1, CompanyAdminTypeBrokerPassword1);
			permission.ContractReadOnlyPermissionForCompanyTypeBroker_4335();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4335_ContractReadOnlyPermissionForCompanyTypeBroker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();			
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Contract Read Only Permission For Company Type Broker");
		videoRecordingStop();
	}

}
