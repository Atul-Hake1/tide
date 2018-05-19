package com.tide.qa.tests;
import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.PolicyPage;
import com.tide.qa.pagefactory.Rules;
import com.tide.qa.utility.Report;

public class RulesTest  extends TestBase {
	LoginPage login = new LoginPage();

	Rules rule = new Rules();
	String Admin1Username = "admin@tide.com";
	String Admin1Password ="Systenics123@";
	String AdminUsername = "dave.brit@brit.com";
	String AdminPassword = "Pa55word123";

	@Test(priority =417, groups={"TC3743_ApproveBordereauxInSequentialOrder"})
	public void TC3743_ApproveBordereauxInSequentialOrder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3743_ApproveBordereauxInSequentialOrder");
			//login.tideLogin(AdminUsername, AdminPassword);
			rule.ApproveBordereauxInSequentialOrder();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3743_ApproveBordereauxInSequentialOrder "+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Approve Bordereaux In Sequential Order");
		videoRecordingStop();
	}
	
	@Test(priority =418, groups={"TC3742_LCErrorDueToChangeRIDateInLifecycle"})
	public void TC3742_LCErrorDueToChangeRIDateInLifecycle()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3742_LCErrorDueToChangeRIDateInLifecycle");
			rule.LifecycleErrorDueToChangeRiskInceptionDateInLifecycleValidation();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3742_LCErrorDueToChangeRIDateInLifecycle "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Lifecycle Error Due To Change Risk Inception Date In Lifecycle Validation");
		videoRecordingStop();
	}
	
	@Test(priority =419, groups={"TC3741_CompletingLifecycleChecks"})
	public void TC3741_CompletingLifecycleChecks()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3741_CompletingLifecycleChecks");			
			rule.RiskAndPremiumRecordsAndCompletingLifecycleChecks();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3741_CompletingLifecycleChecks "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Risk and premium records and completing lifecycle checks");
		videoRecordingStop();
	}
	
	@Test(priority =420, groups={"TC3980_RiskInceptionDateInupdatingRiskAndPremiumRecords"})
	public void TC3980_RiskInceptionDateInupdatingRiskAndPremiumRecords()
	{
		Report.createTestCaseReportHeader();
		try
		{
			//login.tideLogin(AdminUsername, AdminPassword);
			videoRecordingStart("TC3980_RiskInceptionDateInupdatingRiskAndPremiumRecords");
			rule.RiskInceptionDateInupdatingRiskAndPremiumRecords_TC3980();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3980_RiskInceptionDateInupdatingRiskAndPremiumRecords "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Risk Inception Date In updating Risk And Premium Records");
		videoRecordingStop();
	}
	
	@Test(priority =421, groups={"TC3746_BespokeDefault_SingleDefaultValue"})
	public void TC3746_BespokeDefault_SingleDefaultValue()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3746_BespokeDefault_SingleDefaultValue");
			rule.BespokeDefault_SingleDefaultValue();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3746_BespokeDefault_SingleDefaultValue "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Bespoke Default Single Default Value");
		videoRecordingStop();
	}
	
	@Test(priority =60, groups={"TC3690_AddComplianceDataRule"})
	public void TC3690_AddComplianceDataRule()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3690_AddComplianceDataRule");
			//login.tideLogin(Admin1Username, Admin1Password);
			rule.AddComplianceDataRule();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3690_AddComplianceDataRule "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add Compliance Data Rule");
		videoRecordingStop();
	}

	@Test(priority =61, groups={"TC3691_EditComplianceDataRule"})
	public void TC3691_EditComplianceDataRule()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3691_EditComplianceDataRule");
			rule.EditComplianceDataRule();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3691_EditComplianceDataRule "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit Compliance Data Rule");
		videoRecordingStop();
	}

	@Test(priority =62, groups={"TC3692_AddNewSchemaRule"})
	public void TC3692_AddNewSchemaRule()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3692_AddNewSchemaRule");
			rule.AddNewSchemaRule();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3692_AddNewSchemaRule "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add New Schema Rule");
		videoRecordingStop();
	}
	@Test(priority =63, groups={"TC3693_EditSchemaRule"})
	public void TC3693_EditSchemaRule()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3693_EditSchemaRule");
			rule.EditSchemaRule();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3693_EditSchemaRule "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit Schema Rule");
		videoRecordingStop();
	}

	@Test(priority =64, groups={"TC3306_EditAboutTide"})
	public void TC3306_EditAboutTide()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3306_EditAboutTide");
			rule.EditAboutTide();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3306_EditAboutTide "+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit About Tide");
		videoRecordingStop();
	}
	
	@Test(priority =98, groups={"TC3785_MultipleRuleConditions"})
	 public void TC3785_MultipleRuleConditions()
	 {
	  Report.createTestCaseReportHeader();
	  try
	  {
	   videoRecordingStart("TC3785_MultipleRuleConditions");
	   //login.tideLogin(Admin1Username, Admin1Password);
	   rule.multipleRuleConditions_TC3785();
	  }catch(Exception e)
	  {
	   Report.LogInfo("Exception", "Exception in TC3785_MultipleRuleConditions "+e.getMessage(), "FAIL");
	  }
	  
	  Report.createTestCaseReportFooter();
	  Report.SummaryReportlog("Bespoke Contract Rules - multiple rule conditions");
	  videoRecordingStop();
	 }


}
