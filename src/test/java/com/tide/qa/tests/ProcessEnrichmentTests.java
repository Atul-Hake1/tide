package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.FinancialCalculationRiskAndPremiumPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.ProcessEnrichmentPage;
import com.tide.qa.utility.Report;

public class ProcessEnrichmentTests  extends TestBase {
	
	ProcessEnrichmentPage PEpage= new ProcessEnrichmentPage();
	LoginPage login = new LoginPage();
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Pa55word123";
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1 = "Pa55word123";
	
		
	@Test(priority =296, groups={"TC3879_extractYOA"})
	public void TC3879_extractYOA()
 	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3879_extractYOA");
			//login.tideLogin(AdminUsername1, AdminPassword1);
			PEpage.extractYOA_3879();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3879_extractYOA"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Extract Year of Account from Sheet Name Verification");
		videoRecordingStop();
	}
	 	
	@Test(priority =297, groups={"TC3880_DeriveBrokeragePercentage"})
	public void TC3880_DeriveBrokeragePercentage()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3880_DeriveBrokeragePercentage");
			PEpage.deriveBrokeragePercentage_3880();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3880_DeriveBrokeragePercentage"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Derive the Brokerage Percentage from the relevant Contract Verification");
		videoRecordingStop();
	}

	@Test(priority =298, groups={"TC3881_RemoveISOcurrencycode"})
	public void TC3881_RemoveISOcurrencycode()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3881_RemoveISOcurrencycode");
			PEpage.removeISOcurrencycode_3881();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3881_RemoveISOcurrencycode"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Remove ISO currency code characters & symbols Verification");
		videoRecordingStop();
	}
	
	@Test(priority =299, groups={"TC3882_RiskExpiryDatedefaulted"})
	public void TC3882_RiskExpiryDatedefaulted()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3882_RiskExpiryDatedefaulted");
			PEpage.riskExpiryDate_3882();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3882_RiskExpiryDatedefaulted"+e.getMessage(), "FAIL");
		}

		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Risk Expiry Date defaulted Verification");
		videoRecordingStop();
	}
	
	@Test(priority =300, groups={"TC3884_Defaultvalue_CCommissionPercentage"})
	public void TC3884_Defaultvalue_CCommissionPercentage()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3884_Defaultvalue_CCommissionPercentage");
			PEpage.defaultValueCCPercentage_3884();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3884_Defaultvalue_CCommissionPercentage"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Default value of Coverholder Commission Percentage Verification");
		videoRecordingStop();
	}
	
	@Test(priority =301, groups={"TC3890_RiskExpiryDateDefaultedToReportingPeriod"})
	public void TC3890_RiskExpiryDateDefaultedToReportingPeriod()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3890_RiskExpiryDateDefaultedToReportingPeriod");
			//login.tideLogin(AdminUsername1, AdminPassword1);
			PEpage.riskExpiryDate_3890();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3890_RiskExpiryDateDefaultedToReportingPeriod"+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Risk Expiry Date defaulted to the final day of the Bordereau reporting period Verification");
		videoRecordingStop();
	}
	
	@Test(priority =302, groups={"TC3891_DeriveCoverholderCommission"})
	public void TC3891_DeriveCoverholderCommission()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3891_DeriveCoverholderCommission");
			PEpage.deriveCoverholderCommission_3891();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3891_DeriveCoverholderCommission"+e.getMessage(), "FAIL");
		}
	
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Derive the Coverholder Commission from the relevant Contract Verification");
		videoRecordingStop();
	}
	
	@Test(priority =303, groups={"TC3892_BrokeragePercentageDefaultValue"})
	public void TC3892_BrokeragePercentageDefaultValue()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3892_BrokeragePercentageDefaultValue");
			PEpage.brokeragePercentageDefaultValue_3892();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3892_BrokeragePercentageDefaultValue"+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Default value of Brokerage Percentage used Verification");
		videoRecordingStop();
	}
		
	@Test(priority =304, groups={"TC3893_DefaultCurrencyused"})
	public void TC3893_DefaultCurrencyused()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3893_DefaultCurrencyused");
			PEpage.defaultCurrency_3893();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3893_DefaultCurrencyused"+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Default Currency used Verification");
		videoRecordingStop();
	}
	
	@Test(priority =305, groups={"TC3894_DeriveCurrency"})
	public void TC3894_DeriveCurrency()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3894_DeriveCurrency");
			//login.tideLogin(AdminUsername1, AdminPassword1);
			PEpage.deriveCurrency_3894();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3894_DeriveCurrency"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Derive the Currency from the relevant Contract Verification");
		videoRecordingStop();
	}
	
	@Test(priority =306, groups={"TC3987_TotalInsurableValue"})
	public void TC3987_TotalInsurableValue()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3987_TotalInsurableValue");
			//login.tideLogin(AdminUsername2, AdminPassword2);
			PEpage.TotalInsurableValue_3987();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3987_TotalInsurableValue"+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("If Total Sums Insured is not supplied then use value from Total Insurable Value Verification");
		videoRecordingStop();
	}
	
	@Test(priority =307, groups={"TC3988_LimitofIndemnity"})
	public void TC3988_LimitofIndemnity()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3988_LimitofIndemnity");
			PEpage.limitOfIndemnity_3988();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3988_LimitofIndemnity"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("If Total Sums Insured is not supplied then use value from Limit of Indemnity Verification");
		videoRecordingStop();
	}
	
	@Test(priority =308, groups={"TC3992_RemovenonDateCharacters"})
	public void TC3992_RemovenonDateCharacters()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3992_RemovenonDateCharacters");
			PEpage.RemovenonDateCharacters_3992();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3992_RemovenonDateCharacters"+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Remove non-date characters from date fields Verification");
		videoRecordingStop();
	}

	@Test(priority =104, groups={"TC5337_RiskInceptionDateasEndormentEfDate"})
	public void TC5337_RiskInceptionDateasEndormentEfDate()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC5337_RiskInceptionDateasEndormentEfDate");
			PEpage.RiskInceptionDateasEndormentEfDate_5337();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5337_RiskInceptionDateasEndormentEfDate"+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Use of Risk Inception Date as Endorsement Effective Date");
		videoRecordingStop();
	}
	
}



