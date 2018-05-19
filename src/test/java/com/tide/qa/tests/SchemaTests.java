package com.tide.qa.tests;

import org.testng.annotations.Test;
import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.SchemaPage;
import com.tide.qa.utility.Report;

public class SchemaTests extends TestBase{

	SchemaPage schema= new SchemaPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	
	@Test(priority = 70, groups={"TC3174_AddRiskSchema"})
	public void TC3174_AddRiskSchema()
	{
		Report.createTestCaseReportHeader();
		
		try
		{
			videoRecordingStart("TC3174_AddRiskSchema");
			//login.tideLogin(AdminUsername, AdminPassword);
			schema.addRiskSchema_3174();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3174_AddRiskSchema"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add Risk Schema Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 71, groups={"TC3175_EditRiskSchema"})
	public void TC3175_EditRiskSchema()
	{
		Report.createTestCaseReportHeader();
		
		try
		{
			videoRecordingStart("TC3175_EditRiskSchema");
			schema.editRiskSchema_3175();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3175_EditRiskSchema"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("edit Risk Schema Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 72, groups={"TC3176_AddPremiumSchema"})
	public void TC3176_AddPremiumSchema()
	{
		Report.createTestCaseReportHeader();
		
		try
		{
			videoRecordingStart("TC3176_AddPremiumSchema");
			schema.addPremiumSchema_3176();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3176_AddPremiumSchema"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add Premium Schema Verification");
		videoRecordingStop();
	}
	
	
	@Test(priority = 73, groups={"TC3177_EditpremiumSchema"})
	public void TC3177_EditpremiumSchema()
	{
		Report.createTestCaseReportHeader();
		
		try
		{
			videoRecordingStart("TC3177_EditpremiumSchema");
			schema.editPremiumSchema_3177();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3177_EditpremiumSchema"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("edit Premium Schema Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 74, groups={"TC3178_AddClaimSchema"})
	public void TC3178_AddClaimSchema()
	{
		Report.createTestCaseReportHeader();
		
		try
		{
			videoRecordingStart("TC3178_AddClaimSchema");
			schema.addClaimSchema_3178();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3178_AddClaimSchema"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add Claim Schema Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 75, groups={"TC3179_EditClaimSchema"})
	public void TC3179_EditClaimSchema()
	{
		Report.createTestCaseReportHeader();
		
		try
		{
			videoRecordingStart("TC3179_EditClaimSchema");
			schema.editClaimSchema_3179();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3179_EditClaimSchema"+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("edit Claim Schema Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 76, groups={"TC3937_MultipleRuleConditionDataNotValid"})
	public void TC3937_MultipleRuleConditionDataNotValid()
	{
		Report.createTestCaseReportHeader();
		
		try
		{
			videoRecordingStart("TC3937_MultipleRuleConditionDataNotValid");
			schema.multipleRuleConditionDataNotValid();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3937_MultipleRuleConditionDataNotValid"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Multiple Rule Condition - Data is Not valid if the rule conditions are met Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 77, groups={"TC3938_MultipleRuleConditionDataIsValid"})
	public void TC3938_MultipleRuleConditionDataIsValid()
	{
		Report.createTestCaseReportHeader();
		
		try
		{
			videoRecordingStart("TC3938_MultipleRuleConditionDataIsValid");
			schema.multipleRuleConditionDataIsValid();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3938_MultipleRuleConditionDataIsValid"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Multiple Rule Condition - Data is valid if the rule conditions are met Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 78, groups={"TC3849_SingleRuleConditionDataNotValid"})
	public void TC3849_SingleRuleConditionDataNotValid()
	{
		Report.createTestCaseReportHeader();
		
		try
		{
			videoRecordingStart("TC3849_SingleRuleConditionDataNotValid");
			//login.tideLogin(AdminUsername, AdminPassword);
			schema.singleRuleConditionDataNotValid();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3849_SingleRuleConditionDataNotValid"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Schema Rules - single rule condition - data is not valid if the rule conditions are met Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 79, groups={"TC3850_SingleRuleConditionDataIsValid"})
	public void TC3850_SingleRuleConditionDataIsValid()
	{
		Report.createTestCaseReportHeader();
		
		try
		{
			videoRecordingStart("TC3850_SingleRuleConditionDataIsValid");
			schema.singleRuleConditionDataIsValid();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3850_SingleRuleConditionDataIsValid"+e.getMessage(), "FAIL");
		}

		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Schema Rules - single rule condition - data is valid if the rule conditions are met Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 80, groups={"TC3789_ComplianceDataRulesSingleRule"})
	public void TC3789_ComplianceDataRulesSingleRule()
	{
		Report.createTestCaseReportHeader();
		
		try
		{
			videoRecordingStart("TC3789_ComplianceDataRulesSingleRule");
			schema.complianceDataRulesSingleRuleCondition();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3789_ComplianceDataRulesSingleRule"+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Compliance Data Rules - single rule condition - warning and mandatory Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 81, groups={"TC4080_MultipleRuleConditionMandatory"})
	public void TC4080_MultipleRuleConditionMandatory()
	{
		Report.createTestCaseReportHeader();
		
		try
		{
			videoRecordingStart("TC4080_MultipleRuleConditionMandatory");
			//login.tideLogin(AdminUsername, AdminPassword);
			schema.MultipleRuleConditionMandatory_4080();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4080_MultipleRuleConditionMandatory"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Multiple Rule Condition Mandatory");
		videoRecordingStop();
	}
	
	@Test(priority = 116, groups={"TC5140_CompleteQuestionnairesAgainstSchema"})
	public void TC5140_CompleteQuestionnairesAgainstSchema()
	{
		Report.createTestCaseReportHeader();
		
		try
		{
			videoRecordingStart("TC5140_CompleteQuestionnairesAgainstSchemaWhileNotSupplyingMandatoryFields");
			//login.tideLogin(AdminUsername, AdminPassword);
			schema.CompleteQuestionnairesAgainstSchema_TC5140();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5140_CompleteQuestionnairesAgainstSchemaWhileNotSupplyingMandatoryFields"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Complete questionerry against schema");
		videoRecordingStop();
	}
	
	@Test(priority = 117, groups={"TC5141_ReProcessFileUsingMandatoryFields"})
	public void TC5141_ReProcessFileUsingMandatoryFields()
	{
		Report.createTestCaseReportHeader();
		
		try
		{
			videoRecordingStart("TC5141_ReProcessFileUsingMandatoryFields");
			//login.tideLogin(AdminUsername, AdminPassword);
			schema.ReProcessFileUsingMandatoryFields_TC5141();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5141_ReProcessFileUsingMandatoryFields"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Multiple Rule Condition Mandatory");
		videoRecordingStop();
	}
}
