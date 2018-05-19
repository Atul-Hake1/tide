package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

public class InvalidFinancialValueTests extends TestBase
{
	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword = "Pa55word123";
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Pa55word123";

	@Test(priority =272, groups={"TC3373_FinancialFieldEnterCharacter"})
	public void TC3373_FinancialFieldEnterCharacter()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3373_FinancialFieldEnterCharacter");
			//login.tideLogin(AdminUsername, AdminPassword);
			sheets.EnterCharacterFinantialfields_3373();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3373_FinancialFieldEnterCharacter "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Enter charecter in financial fields");
		videoRecordingStop();
	}

	@Test(priority =273, groups={"TC3424_AlphaNemericFinancialfield"})
	public void TC3424_AlphaNemericFinancialfield()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3424_AlphaNemericFinancialfield");
			sheets.AlphaNumericFinantialfields_3424();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3424_AlphaNemericFinancialfield "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Enter Alpha-numeric value in financial fields");
		videoRecordingStop();
	}

	@Test(priority =274, groups={"TC3425_SpecialCharFinancialfield"})
	public void TC3425_SpecialCharFinancialfield()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3425_SpecialCharFinancialfield");
			sheets.SpecialCharFinantialfields_3425();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3425_SpecialCharFinancialfield "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Enter special- charecters in financial fields");
		videoRecordingStop();
	}

	@Test(priority =275, groups={"TC3441_Calculation_GPIncludingTax"})
	public void TC3441_Calculation_GPIncludingTax()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3441_Calculation_GPIncludingTax");
			sheets.financialCalculation_GrossPremiumIncludingTax();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3441_Calculation_GPIncludingTax"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Core Financial Calculation (Gross Premium Including Tax) Verification");
		videoRecordingStop();
	} 

	@Test(priority =276, groups={"TC3483_Calculation_GrossPremium"})
	public void TC3483_Calculation_GrossPremium()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3483_Calculation_GrossPremium");
			sheets.financialCalculation_GrossPremium();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3483_Calculation_GrossPremium"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Core Financial Calculation (Gross Premium ) Verification");
		videoRecordingStop();
	}

	@Test(priority =277, groups={"TC3484_Calculation_CoverholderCommission"})
	public void TC3484_Calculation_CoverholderCommission()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3484_Calculation_CoverholderCommission");
			sheets.financialCalculation_CoverholderCommission();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3484_Calculation_CoverholderCommission"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Core financial Calculation validation(Coverholder Commission) Verification");
		videoRecordingStop();
	}

	@Test(priority =278, groups={"TC3494_Calculation_CC_Percent"})
	public void TC3494_Calculation_CC_Percent()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3494_Calculation_CC_Percent");
			sheets.financialCalculation_CoverholderCommission_Percent();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3494_Calculation_CC_Percent"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Core financial Calculation validation(Coverholder Commission %) Verification");
		videoRecordingStop();
	}

	@Test(priority =279, groups={"TC3486_Calculation_NetPremium"})
	public void TC3486_Calculation_NetPremium()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3486_Calculation_NetPremium");
			sheets.financialCalculation_NetPremium();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3486_Calculation_NetPremium"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Core financial Calculation validation(Net Premium) Verification");
		videoRecordingStop();
	}

	@Test(priority =280, groups={"TC3487_CorefinancialCalculation_Brokerage"})
	public void TC3487_CorefinancialCalculation_Brokerage()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3487_CorefinancialCalculation_Brokerage");
			sheets.financialCalculation_Brokerage();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3487_CorefinancialCalculation_Brokerage"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Core financial Calculation validation(Brokerage) Verification");
		videoRecordingStop();
	} 

	@Test(priority =281, groups={"TC3488_Calculation_BrokeragePercent"})
	public void TC3488_Calculation_BrokeragePercent()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3488_Calculation_BrokeragePercent");
			sheets.financialCalculation_BrokeragePercent();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "TC3488_Calculation_BrokeragePercent"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Core financial Calculation validation(Brokerage %) Verification");
		videoRecordingStop();
	}

	@Test(priority =282, groups={"TC3489_Calculation_FinalNetPremium"})
	public void TC3489_Calculation_FinalNetPremium()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3489_Calculation_FinalNetPremium");
			sheets.financialCalculation_FinalNetPremium();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "TC3489_Calculation_FinalNetPremium"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Core financial Calculation validation(Final Net Premium) Verification");
		videoRecordingStop();
	}

	@Test(priority =283, groups={"TC3490_financialCalculationGrossPremium"})
	public void TC3490_financialCalculationGrossPremium()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3490_financialCalculationGrossPremium");
			sheets.financialCalculationGrossPremium();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3490_financialCalculationGrossPremium "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Verify financial calculation gross premium");
		videoRecordingStop();
	}

	@Test(priority =284, groups={"TC3491_CoreFinancialCalculationValidationTax"})
	public void TC3491_CoreFinancialCalculationValidationTax()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3491_CoreFinancialCalculationValidationTax");
			sheets.CoreFinancialCalculationValidationTax();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3491_CoreFinancialCalculationValidationTax "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Verify financial calculation gross premium");
		videoRecordingStop();
	}

	@Test(priority =404, groups={"TC3429_ProcessBorderoWithDefaulstRisk"})
	public void TC3429_ProcessBorderoWithDefaulstRisk()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3429_ProcessBorderoWithDefaulstRisk");
			//login.tideLogin(AdminUsername2, AdminPassword2);
			sheets.ProcessBorderoWithDefaulstRisk_3429();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3429_ProcessBorderoWithDefaulstRisk "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Process Bordereau with default Risk Order % in Bordereau Questionnaire");
		videoRecordingStop();
	}

	@Test(priority =405, groups={"TC3430_ProcessBorderoWithRisk"})
	public void TC3430_ProcessBorderoWithRisk()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3430_ProcessBorderoWithRisk");
			sheets.ProcessBorderoWithRisk_3430();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3430_ProcessBorderoWithRisk "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Process Bordereau with Risk Order % column");
		videoRecordingStop();
	}

	@Test(priority =406, groups={"TC3714_UseLeftCharactersRiskReference"})
	public void TC3714_UseLeftCharactersRiskReference()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3714_UseLeftCharactersRiskReference");
			//login.tideLogin(AdminUsername2, AdminPassword2);
			sheets.useLeftCharactersRiskReference();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3714_UseLeftCharactersRiskReference "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Use set number of left characters from Risk Reference Verification");
		videoRecordingStop();
	}

	@Test(priority =407, groups={"TC3717_DeleteRowsBasedSingleColumn"})
	public void TC3717_DeleteRowsBasedSingleColumn()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3717_DeleteRowsBasedSingleColumn");
			sheets.deleteRowsBasedSingleColumn();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3717_DeleteRowsBasedSingleColumn "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Delete rows based on single column being blank Verification");
		videoRecordingStop();
	}

	@Test(priority =408, groups={"TC3719_DeleteRowsBasedMultipleColumn"})
	public void TC3719_DeleteRowsBasedMultipleColumn()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3719_DeleteRowsBasedMultipleColumn");
			sheets.deleteRowsBasedMultipleColumn();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3719_DeleteRowsBasedMultipleColumn "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Delete rows based on multiple columns being blank Verification");
		videoRecordingStop();
	}

	@Test(priority =409, groups={"TC3727_RiskBordereauxonCCLookup"})
	public void TC3727_RiskBordereauxonCCLookup()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3727_RiskBordereauxonCCLookup");
			sheets.riskBordereauxonContractCurrencyLookup();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3727_RiskBordereauxonCCLookup "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Risk Bordereaux Currency based on Contract Currency lookup Verification");
		videoRecordingStop();
	}

	@Test(priority =410, groups={"TC3728_AdvancedOption"})
	public void TC3728_AdvancedOption()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3728_AdvancedOption");
			sheets.advancedOption();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3728_AdvancedOption "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Advanced Options");
		videoRecordingStop();
	}
	
	@Test(priority =411, groups={"TC4476_Calculate_tax_fieldsBySelecting_yes_OnlyOne_option"})
	public void TC4476_Calculate_tax_fieldsBySelecting_yes_OnlyOne_option()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4476_Calculate_tax_fieldsBySelecting_yes_OnlyOne_option");
			//login.tideLogin(AdminUsername2, AdminPassword2);
	 		sheets.TC4476_CalculateTaxBySelecting_Yes_OnlyOne_option();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4476_Calculate_tax_fieldsBySelecting_yes_OnlyOne_option "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Calculate Tax fieldsBySelecting_yes_OnlyOne_option");
		videoRecordingStop();
	}
	@Test(priority =412, groups={"TC4477_CalculateTaxWithOutadditonalTax"})
	public void TC4477_CalculateTaxWithOutadditonalTax()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4477_CalculateTaxWithOutadditonalTax");
			sheets.TC4477_CalculateTaxWithOutadditonalTax();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4477_CalculateTaxWithOutadditonalTax "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Calculate Tax WithOut additonal Tax");
		videoRecordingStop();
	}
	
	@Test(priority =413, groups={"TC4478_CalculateTaxWithadditonalTax"})
	public void TC4478_CalculateTaxWithadditonalTax()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4478_CalculateTaxWithadditonalTax");
			//login.tideLogin(AdminUsername2, AdminPassword2);
			sheets.CalculateTaxWithadditonalTax_TC4478();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4478_CalculateTaxWithadditonalTax "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Calculate Tax With additonal Tax");
		videoRecordingStop();
	}
}
