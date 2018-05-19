package com.tide.qa.tests;

import org.testng.annotations.Test;
import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.PolicyPage;
import com.tide.qa.pagefactory.PolicyPageContractDataSummary;
import com.tide.qa.utility.Report;

public class PolicyTests extends TestBase
{
	PolicyPage policyPage = new PolicyPage();
	PolicyPageContractDataSummary polCon = new PolicyPageContractDataSummary();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1 = "Pa55word123";

	
	@Test(priority = 6, groups={"TC3191_AddNewPolicy"})
	public void TC3191_AddNewPolicy()
	{
		Report.createTestCaseReportHeader();

		try
		{	
			videoRecordingStart("TC3191_AddNewPolicy");
			//login.tideLogin(AdminUsername, AdminPassword);
			policyPage.addPolicy();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3191_AddNewPolicy "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add policy Verification");
		videoRecordingStop();
	}

	@Test(priority = 7, groups={"TC3228_ChangeDraftStatusToQuote"})
	public void TC3228_ChangeDraftStatusToQuote()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3228_ChangeDraftStatusToQuote");
			policyPage.changeStatusToQuote();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3228_ChangeDraftStatusToQuote "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Change Status To Quote Verification");
		videoRecordingStop();
	}

	@Test(priority = 8, groups={"TC3229_ChangeQuoteStatusToWritten"})
	public void TC3229_ChangeQuoteStatusToWritten()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3229_ChangeQuoteStatusToWritten");
			policyPage.changeStatusToWritten();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3229_ChangeStatusFromQuoteToWritten "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Change Status To Written Verification");
		videoRecordingStop();
	}

	@Test(priority = 9, groups={"TC3232_ChangeWrittenStatusToSigned"})
	public void TC3232_ChangeWrittenStatusToSigned()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3232_ChangeWrittenStatusToSigned");
			policyPage.changeStatusToSigned();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3232_ChangeWrittenStatusToSigned "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Change Written Status To Signed Verification");
		videoRecordingStop();
	}

	@Test(priority = 29, groups={"TC3285_CheckVersionAfterSigned"})
	public void TC3285_CheckVersionAfterSigned()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3285_CheckVersionAfterSigned");
			policyPage.checkVersionAfterSigned();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3285_CheckVersionAfterSigned "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Check Version After Signed Status Verification");
		videoRecordingStop();
	}

	@Test(priority = 30, groups={"TC3276_AddFileToContract"})
	public void TC3276_AddFileToContract()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3276_AddFileToContract");
			policyPage.addFileToContract();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3276_AddFileToContract "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add File To Contract Verification");
		videoRecordingStop();
	}

	@Test(priority =118, groups={"TC3286_AddReportingChanel"})
	public void TC3286_AddReportingChanel()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3286_AddReportingChanel");
			//login.tideLogin(AdminUsername, AdminPassword);
			policyPage.addReportingChannelForContract();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3286_AddReportingChanel "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add a reporting channel to a contract Verification");
		videoRecordingStop();
	}


	@Test(priority = 31, groups={"TC3411_VerifyReportingChanel"})
	public void TC3411_VerifyReportingChanel()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3411_VerifyReportingChanel");
			policyPage.verifyReportingChannel();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3286_AddReportingChanel "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Reporting channel Verification");
		videoRecordingStop();
	}

	@Test(priority = 119, groups={"TC3287_EditReportingChannelOfContract"})
	public void TC3287_EditReportingChannelOfContract()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3287_EditReportingChannelOfContract");
			policyPage.editReportingChannelOfContract();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3287_EditReportingChannelOfContract "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit a reporting channel Verification");
		videoRecordingStop();
	}

	@Test(priority = 120, groups={"TC3288_DeleteReportingChannelOfContract"})
	public void TC3288_DeleteReportingChannelOfContract()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3288_DeleteReportingChannelOfContract");
			policyPage.deleteReportingChannelOfContract();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3288_DeleteReportingChannelOfContract "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Delete a reporting channel Verification");
		videoRecordingStop();
	}

	@Test(priority = 34, groups={"TC3233_CreateAnotherContractForSamePolicy"})
	public void TC3233_CreateAnotherContractForSamePolicy()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3233_CreateAnotherContractForSamePolicy");
			policyPage.createAnotherContractForSamePolicy();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3233_CreateAnotherContractForSamePolicy "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add Another Contract For Same Policy Verification");
		videoRecordingStop();
	}


	@Test(priority = 35, groups={"TC3415_SelectionTabHiddenForPolicy"})
	public void TC3415_SelectionTabHiddenForPolicy()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3415_SelectionTabHiddenForPolicy");
			policyPage.selectionTabHiddenForPolicy();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3415_SelectionTabHiddenForPolicy "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Section tab hidden for policy type Binder Verification");
		videoRecordingStop();
	}

	@Test(priority = 36, groups={"TC3393_EditSectionDetails"})
	public void TC3393_EditSectionDetails()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3393_EditSectionDetails");
			policyPage.editSectionDetails();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3393_EditSectionDetails "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit Section Details Verification");
		videoRecordingStop();
	}

	@Test(priority = 37, groups={"TC3394_EditSectionReferenceDetails"})
	public void TC3394_EditSectionReferenceDetails()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3394_EditSectionReferenceDetails");
			policyPage.editSectionReference();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3394_EditSectionReferenceDetails "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit Section Reference Details Verification");
		videoRecordingStop();
	}
	@Test(priority = 38, groups={"TC4351_RiskCode_AddEditDelete"})
	public void TC4351_RiskCode_AddEditDelete()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4351_RiskCode_AddEditDelete");
			policyPage.RiskCode_AddEditDelete_TC4351();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4351_RiskCode_AddEditDelete "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Risk Code Add/Edit/Delete");
		videoRecordingStop();
	}
	@Test(priority = 39, groups={"TC3392_AddEditDeleteRules"})
	public void TC3392_AddEditDeleteRules()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3392_AddEditDeleteRules");	
			//login.tideLogin(AdminUsername, AdminPassword);
			policyPage.addEditDeleteRules();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3392_AddEditDeleteRules "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add/Edit/Delete Rules Verification");
		videoRecordingStop();
	}

	@Test(priority = 40, groups={"TC3282_AddEditDeleteIntrestForPolicy"})
	public void TC3282_AddEditDeleteIntrestForPolicy()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3282_AddEditDeleteIntrestForPolicy");
			//login.tideLogin(AdminUsername, AdminPassword);
			policyPage.addEditDeleteInterest();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3282_AddEditDeleteIntrestForPolicy "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add/Edit/Delete Interest to a section Verification");
		videoRecordingStop();
	}

	@Test(priority = 41, groups={"TC3283_AddEditDeletePerilsForPolicy"})
	public void TC3283_AddEditDeletePerilsForPolicy()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3283_AddEditDeletePerilsForPolicy");
			policyPage.addEditDeletePerils();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3283_AddEditDeletePerilsForPolicy "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add/Edit/Delete Perils to a section Verification");
		videoRecordingStop();
	}

	@Test(priority = 42, groups={"TC3284_AddEditDeleteLimitForPolicy"})
	public void TC3284_AddEditDeleteLimitForPolicy()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3284_AddEditDeleteLimitForPolicy");
			policyPage.addEditDeleteLimit();
			//login.tideAdminLogOut();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3284_AddEditDeleteLimitForPolicy "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add/Edit/Delete Limit to a section Verification");
		videoRecordingStop();
	}

	@Test(priority = 43, groups={"TC3529_EditGeneralAndLocationContractRules"})
	public void TC3529_EditGeneralAndLocationContractRules()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3529_EditGeneralAndLocationContractRules");
			//login.tideLogin(AdminUsername, AdminPassword);
			policyPage.firstEditGeneralAndLocation();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3529_EditGeneralAndLocationContractRules "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("First Edit of General and Location tab in Contract Rules Verification");
		videoRecordingStop();
	}

	@Test(priority = 44, groups={"TC3530_SeEditGeneralAndLocationContractRules"})
	public void TC3530_SeEditGeneralAndLocationContractRules()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3530_SeEditGeneralAndLocationContractRules");
			policyPage.secondEditGeneralAndLocation();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3530_SeEditGeneralAndLocationContractRules "+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Second Edit of General and Location tab in Contract Rules Verification");
		videoRecordingStop();
	}

	@Test(priority = 202, groups={"TC3648_AddBespokeContractRule"})
	public void TC3648_AddBespokeContractRule()
	{
		Report.createTestCaseReportHeader();

		try
		{		
			videoRecordingStart("TC3648_AddBespokeContractRule");
			//login.tideLogin(AdminUsername1, AdminPassword1);
			policyPage.addBespokeContractRule();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3648_AddBespokeContractRule "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add Bespoke Contract Rule Verification");
		videoRecordingStop();
	}

	@Test(priority = 203, groups={"TC3649_EditAndDeleteBespokeRule"})
	public void TC3649_EditAndDeleteBespokeRule()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3649_EditAndDeleteBespokeRule");
			policyPage.editAndDeleteBespokeContractRule();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3649_EditAndDeleteBespokeRule "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit and Delete Bespoke Contract Rule Verification");
		videoRecordingStop();
	}

	@Test(priority = 204, groups={"TC3647_AddBespokeInformationRule"})
	public void TC3647_AddBespokeInformationRule()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3647_AddBespokeInformationRule");
			policyPage.addBespokeInformationRule();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3647_AddBespokeInformationRule "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add Bespoke Information Rule Verification");
		videoRecordingStop();
	}

	@Test(priority = 205, groups={"TC3661_EditAndDeleteInformationRule"})
	public void TC3661_EditAndDeleteInformationRule()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3661_EditAndDeleteInformationRule");
			policyPage.editAndDeleteBespokeInformationRule();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3661_EditAndDeleteInformationRule "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit and Delete Information Rule Verification");
		videoRecordingStop();
	}

	@Test(priority = 206, groups={"TC3679_ProcessBordereauWithSupplementaryFiles"})
	public void TC3679_ProcessBordereauWithSupplementaryFiles()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3679_ProcessBordereauWithSupplementaryFiles");
			policyPage.processBordereauWithSupplementaryFiles();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3679_ProcessBordereauWithSupplementaryFiles "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Process Bordereau with Supplementary Files Verification");
		videoRecordingStop();
	}

	@Test(priority = 207, groups={"TC3680_NilBordereau"})
	public void TC3680_NilBordereau()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3680_NilBordereau");
			policyPage.nilBordereau();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3680_NilBordereau "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Nil Bordereau Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 45, groups={"TC4034_ContractClaimAuthorityEdit"})
	public void TC4034_ContractClaimAuthorityEdit()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4034_ContractClaimAuthorityEdit");
			policyPage.ContractClaimAuthority_Edit_4034();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4034_ContractClaimAuthorityEdit "+e.getMessage(), "FAIL");
		}		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit Claims Authority");
		videoRecordingStop();
	}
	
	@Test(priority = 208, groups={"TC3527_ContractRoleEdit"})
	public void TC3527_ContractRoleEdit()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3527_ContractRoleEdit");
			policyPage.ContractRoleEdit_TC3527();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3527_ContractRoleEdit "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit Contract Role");
		videoRecordingStop();
	}
	
	
	@Test(priority = 209, groups={"TC3801_ContractCoverHolder_AddOrEdit"})
	public void TC3801_ContractCoverHolder_AddOrEdit()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3801_ContractCoverHolder_AddOrEdit");
			//login.tideLogin(AdminUsername, AdminPassword);
			policyPage.ContractCoverHolder_AddOrEdit_TC3801();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3801_ContractCoverHolder_AddOrEdit"+e.getMessage(), "FAIL");
		}
	
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add Or Edit Contract CoverHolder");
		videoRecordingStop();
	}
	
	@Test(priority = 210, groups={"TC3804_Contract_Link"})
	public void TC3804_Contract_Link()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3804_Contract_Link");
			policyPage.Contract_Link_TC3804();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3804_Contract_Link"+e.getMessage(), "FAIL");
		}
	
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Contract Link");
		videoRecordingStop();
	}
	
	@Test(priority = 211, groups={"TC3803_Contract_MetaData"})
	public void TC3803_Contract_MetaData()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3803_Contract_MetaData");
			policyPage.Contract_MetaData_TC3803();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3803_Contract_MetaData"+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Contract MetaData");
		videoRecordingStop();
	}
	
	@Test(priority = 212, groups={"TC4041_Edit_Company_SpecificTab"})
	public void TC4041_Edit_Company_SpecificTab()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4041_Edit_Company_SpecificTab");
			policyPage.Edit_Company_SpecificTab_TC4041();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4041_Edit_Company_SpecificTab"+e.getMessage(), "FAIL");
		}
		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit Company Specific Tab");
		videoRecordingStop();
	}
	
	@Test(priority = 213, groups={"TC4042_EditAdditionalTab_for_Contract"})
	public void TC4042_EditAdditionalTab_for_Contract()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4042_EditAdditionalTab_for_Contract");
			policyPage.Edit_Additional_Tab_For_Contract_TC4042();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4042_EditAdditionalTab_for_Contract"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit Additional Tab for Contract");
		videoRecordingStop();
	}
	
	
	@Test(priority = 46, groups={"TC4729_ConDataSumMonthlyReporting"})
	public void TC4729_ConDataSumMonthlyReporting()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4729_ConDataSumMonthlyReporting");
			//login.tideLogin(AdminUsername, AdminPassword);
			polCon.ConDataSumMonthlyReporting_4729();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4729_ConDataSumMonthlyReporting"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Contract Data Summary-Monthly Reporting ");
		videoRecordingStop();
	}
	
	@Test(priority = 47, groups={"TC4745_ConDataSumQuaterlyReporting"})
	public void TC4745_ConDataSumQuaterlyReporting()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4745_ConDataSumQuaterlyReporting");
			//login.tideLogin(AdminUsername, AdminPassword);
			polCon.ConDataSumQuaterlyReporting_4745();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4745_ConDataSumQuaterlyReporting"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Contract Data Summary-Quartely Reporting");
		videoRecordingStop();
	}
	
	@Test(priority = 48, groups={"TC4839_ConDataSumQuaterlyNil"})
	public void TC4839_ConDataSumQuaterlyNil()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4839_ConDataSumQuaterlyNil");
			//login.tideLogin(AdminUsername, AdminPassword);
			polCon.ConDataSumQuaterlyNil_4839();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4839_ConDataSumQuaterlyNil"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Contract Data Summary-Quartely Reporting");
		videoRecordingStop();
	}	
	
	@Test(priority = 49, groups={"TC4757_ConDataSumAnnually"})
	public void TC4757_ConDataSumAnnually()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4757_ConDataSumAnnually");
			//login.tideLogin(AdminUsername, AdminPassword);
			polCon.ConDataSumAnnuallyReporting_4757();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4757_ConDataSumAnnually"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Contract Data Summary-Annually Reporting");
		videoRecordingStop();
	}
	
	@Test(priority = 115, groups={"TC5283_SectionMarket_AddEditDelete"})
	public void TC5283_SectionMarket_AddEditDelete()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC5283_SectionMarket_AddEditDelete");
			//login.tideLogin(AdminUsername, AdminPassword);
			policyPage.SectionMarket_AddEditDelete_TC5283();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5283_SectionMarket_AddEditDelete"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Section Market - Add ,Edit ,Delete");
		videoRecordingStop();
	}
}
