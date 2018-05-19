package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.Stage2Page;
import com.tide.qa.utility.Report;

public class Stage2Tests extends TestBase
{
	BordereauProcessPage sheets = new BordereauProcessPage();
	Stage2Page s2 = new Stage2Page();
	LoginPage login = new LoginPage();
	String AdminUsername = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword = "Pa55word123";
	
	@Test(priority =16, groups={"TC3541_Stage2ErroscreenValTransSupplied"})
	public void TC3541_Stage2ErroscreenValTransSupplied()
	{
		Report.createTestCaseReportHeader();
		try
		{	
			videoRecordingStart("TC3541_Stage2ErroscreenValTransSupplied");
			//login.tideLogin(AdminUsername, AdminPassword);
			s2.ErroscreenValTransactiontypSupplied_3541();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3541_Stage2ErroscreenValTransSupplied"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Stage 2 error screen validation with transaction type Supplied");
		videoRecordingStop();
	}
	
	@Test(priority =17, groups={"TC3542_Stage2ErroscreenValTranstypSupplied"})
	public void TC3542_Stage2ErroscreenValTranstypSupplied()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3542_Stage2ErroscreenValTranstypSupplied");
			s2.ErroscreenValTransactiontypNotSupplied_3542();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3542_Stage2ErroscreenValTranstypSupplied"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("error screen validation with transaction type not supplied- Missing entries is not treated as cancellation");
		videoRecordingStop();
	}
	
	@Test(priority = 309, groups={"TC3876_MissingEntriesTreatedAsCancellation"})
	public void TC3876_MissingEntriesTreatedAsCancellation()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3876_MissingEntriesTreatedAsCancellation");
			//login.tideLogin(AdminUsername1, AdminPassword1);
			s2.missingEntriesTreatedAsCancellation();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3876_MissingEntriesTreatedAsCancellation "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Stage 2 error screen validation with transaction type not supplied- Missing entries is  treated as cancellation Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 310, groups={"TC3914_ValidateMandatoryReferenceField"})
	public void TC3914_ValidateMandatoryReferenceField()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3914_ValidateMandatoryReferenceField");
			//login.tideLogin(AdminUsername, AdminPassword);
			s2.validateMandatoryReferenceField();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3876_MissingEntriesTreatedAsCancellation "+e.getMessage(), "FAIL");
		}
	
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Validate mandatory reference field, boolean field, date Field, Integer Field, String field and percentage field");
		videoRecordingStop();
	}
	
	@Test(priority = 311, groups={"TC3915_ValidateIntitialPremiumPositive"})
	public void TC3915_ValidateIntitialPremiumPositive()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3915_ValidateIntitialPremiumPositive");
			//login.tideLogin(AdminUsername, AdminPassword);
			s2.validateIntitialPremiumPositive();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3915_ValidateIntitialPremiumPositive "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Validate intitial premium is positive Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 312, groups={"TC3981_BespokeMultipleDefaultValuesEqual"})
	public void TC3981_BespokeMultipleDefaultValuesEqual()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3981_BespokeMultipleDefaultValuesEqual");
			//login.tideLogin(AdminUsername, AdminPassword);
			s2.bespokeMultipleDefaultValuesEqual();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3981_BespokeMultipleDefaultValuesEqual "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Bespoke default - multiple default values based on conditions with equal to operator Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 313, groups={"TC3982_BespokeMultipleDefaultValuesNotEqual"})
	public void TC3982_BespokeMultipleDefaultValuesNotEqual()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3982_BespokeMultipleDefaultValuesNotEqual");
			s2.bespokeMultipleDefaultValuesNotEqual();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3982_BespokeMultipleDefaultValuesNotEqual "+e.getMessage(), "FAIL");
		}
			Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Bespoke default - multiple default values based on conditions with not equal to operator Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 114, groups={"TC5094_ValidateMandatoryReferenceField"})
	public void TC5094_ValidateMandatoryReferenceField()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC5094_ValidateMandatoryReferenceField");
			//login.tideLogin(AdminUsername1, AdminPassword1);
			s2.ValidateMandatoryReferenceField_TC5094();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5094_ValidateMandatoryReferenceField "+e.getMessage(), "FAIL");
		}
			Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Validate mandatory reference field, boolean field, date field, integer field, string field and percentage field");
		videoRecordingStop();
	}
		
}
