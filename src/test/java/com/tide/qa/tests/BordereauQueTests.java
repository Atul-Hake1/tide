package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauQuePage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

public class BordereauQueTests extends TestBase
{
	BordereauQuePage QuePage = new BordereauQuePage();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";

	String AdminUsername4 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword4 = "Pa55word123";

	String AdminUsername1 = "dave.brit@brit.com";
	String AdminPassword1 = "Pa55word123";

	String AdminUsername2 = "john.smith@coverholderinc.com";
	String AdminPassword2 = "Pa55word123";
	

	String StandatdUsername2 = "standard.brookes@aspen.co.uk";
	String StandardPassword2 = "Pa55word123";

	String AdminUsername3 = "readonly.jones@coverholderinc.com";
	String AdminPassword3 = "Pa55word123";
	
	String ReadOnlyUsername3 = "readonly.brookes@aspen.co.uk";
	String ReadonlyPassword3 = "Pa55word123";
	


	@Test(priority = 10, groups={"TC3126_AddNewQuestionnaireAllsheets"})
	public void TC3126_AddNewQuestionnaireAllsheets()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3126_AddNewQuestionnaireAllsheets");
			//login.tideLogin(AdminUsername, AdminPassword);
			QuePage.addNewQuestionnaire();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3126_AddNewQuestionnaireAllsheets "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Risk Bordereau questionnaire - All sheets Verification");
		videoRecordingStop();
	}

	@Test(priority = 50, groups={"TC3135_SheetProcessingFirstSheet"})
	public void TC3135_SheetProcessingFirstSheet()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3135_SheetProcessingFirstSheet");
			//login.tideLogin(AdminUsername, AdminPassword);
			QuePage.sheetProcessingFirstSheet();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3135_SheetProcessingFirstSheet "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Sheet Processing First Sheet Verification");
		videoRecordingStop();
	}

	@Test(priority = 51, groups={"TC3141_SheetProcessingLastSheet"})
	public void TC3141_SheetProcessingLastSheet()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3141_SheetProcessingLastSheet");
			QuePage.sheetProcessingLastSheet();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3141_SheetProcessingLastSheet "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Sheet Processing Last Sheet Verification");
		videoRecordingStop();
	}

	@Test(priority = 52, groups={"TC3144_SheetProcessingSpecificTextSheet"})
	public void TC3144_SheetProcessingSpecificTextSheet()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3144_SheetProcessingSpecificTextSheet");
			QuePage.sheetProcessingSpecificText();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3144_SheetProcessingSpecificTextSheet "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Sheet Processing Specific Text Verification");
		videoRecordingStop();
	}

	@Test(priority = 53, groups={"TC3146_SheetProcessingEqualsTextSheet"})
	public void TC3146_SheetProcessingEqualsTextSheet()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3146_SheetProcessingEqualsTextSheet");
			QuePage.sheetProcessingEqualSpecificText();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3146_SheetProcessingEqualsTextSheet "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Sheet Processing Equals Specific Text Verification");
		videoRecordingStop();
	}

	@Test(priority = 54, groups={"TC3147_SheetProcessingAnySheetContainsText"})
	public void TC3147_SheetProcessingAnySheetContainsText()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3147_SheetProcessingAnySheetContainsText");
			QuePage.sheetProcessingAnySheetContainsSpecificText();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3147_SheetProcessingAnySheetContainsText "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Sheet Processing Any Sheet Contains Specific Text Verification");
		videoRecordingStop();
	}

	@Test(priority = 55, groups={"TC3148_SheetProcessingOnlySpecificText"})
	public void TC3148_SheetProcessingOnlySpecificText()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3148_SheetProcessingOnlySpecificText");
			QuePage.sheetProcessingOnlySpecificText();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3148_SheetProcessingOnlySpecificText "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Sheet Processing Only Specific Text Verification");
		videoRecordingStop();
	}

	@Test(priority = 11, groups={"TC3460_EditBordereauxQuestionaire"})
	public void TC3460_EditBordereauxQuestionaire()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3460_EditBordereauxQuestionaire");
			QuePage.editBordereauFormat();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3460_EditBordereauxQuestionaire "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit Bordereaux Questionaire Verification");
		videoRecordingStop();
	}

	@Test(priority = 56, groups={"TC3732_AddPremiumQuestionaire"})
	public void TC3732_AddPremiumQuestionaire()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3732_AddPremiumQuestionaire");
			//login.tideLogin(AdminUsername, AdminPassword);
			QuePage.addPremiumQuestionaire();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3732_AddPremiumQuestionaire "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add a Premium Questionaire Verification");
		videoRecordingStop();
	}

	@Test(priority = 57, groups={"TC3733_EditPremiumQuestionaire"})
	public void TC3733_EditPremiumQuestionaire()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3733_EditPremiumQuestionaire");
			QuePage.editPremiumQuestionaire();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3733_EditPremiumQuestionaire "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit a Questionaire Verification");
		videoRecordingStop();
	}

	@Test(priority = 12, groups={"TC3532_AddBordereauFormatClaim"})
	public void TC3532_AddBordereauFormatClaim()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3532_AddBordereauFormatClaim");

			QuePage.addBordereauFormatClaim();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3532_AddBordereauFormatClaim "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add a bordereau Format(Claim) Verification");
		videoRecordingStop();
	}

	@Test(priority = 13, groups={"TC3533_EditBordereauFormatClaim"})
	public void TC3533_EditBordereauFormatClaim()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3533_EditBordereauFormatClaim");
			QuePage.editClaimQuestionaire();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3533_EditBordereauFormatClaim "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Edit Bordereau Format(Claim) Verification");
		videoRecordingStop();
	}

	@Test(priority = 637, groups={"TC4058_BordereauQuestionaireTideAdmin"})
	public void TC4058_BordereauQuestionaireTideAdmin()
	{
		Report.createTestCaseReportHeader();

		try

		{
			videoRecordingStart("TC4058_BordereauQuestionaireTideAdmin");
			login.tideLogin(AdminUsername, AdminPassword);
			QuePage.BordereauQuestionaireTideAdmin_4058();
			

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4058_BordereauQuestionaireTideAdmin "+e.getMessage(), "FAIL");
		}finally{
			login.tideAdminLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Bordereau Questionaire- Tide Admin");
		videoRecordingStop();
	}

	@Test(priority = 638, groups={"TC4059_BordereauQuestionaireCompanyAdmin"})
	public void TC4059_BordereauQuestionaireCompanyAdmin()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4059_BordereauQuestionaireCompanyAdmin");
			//Test case having processing isseu on step for only for Company user.
			login.tideLogin(AdminUsername4, AdminPassword4);
			QuePage.BordereauQuestionaireCompanyAdmin_4059();
		

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4059_BordereauQuestionaireCompanyAdmin "+e.getMessage(), "FAIL");
		}finally{
			login.tideCompanyAdminLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Bordereau Questionaire- Company Admin");
		videoRecordingStop();
	}

	@Test(priority = 639, groups={"TC4060_BordereauQuestionaireStandardUSer"})
	public void TC4060_BordereauQuestionaireStandardUSer()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4060_BordereauQuestionaireStandardUSer");
			//Test case having processing isseu on step for only for Company user.
			login.tideLogin(StandatdUsername2, StandardPassword2);
			QuePage.BordereauQuestionaireStandardUser_4060();
			

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4060_BordereauQuestionaireStandardUSer "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Bordereau Questionaire- Standard user");
		videoRecordingStop();
	}

	@Test(priority = 640, groups={"TC4061_BordereauQuestionaireReadOnly"})
	public void TC4061_BordereauQuestionaireReadOnly()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4061_BordereauQuestionaireReadOnly");
			login.tideLogin(ReadOnlyUsername3, ReadonlyPassword3);
			QuePage.BordereauQuestionaireReadOnly_4061();
	

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4061_BordereauQuestionaireReadOnly "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Bordereau Questionaire- Read only");
		videoRecordingStop();
	}

	@Test(priority = 436, groups={"TC4197_AddBordereauQuestionaireNote"})
	public void TC4197_AddBordereauQuestionaireNote()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4197_AddBordereauQuestionaireNote");
			//login.tideLogin(AdminUsername1, AdminPassword1);
			QuePage.AddBordereauQuestionaireNotes_4197();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4197_AddBordereauQuestionaireNote "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add Bordereau Questionaire Note");
		videoRecordingStop();
	}

	@Test(priority = 112, groups={"TC4199_StandardReferencesInQuestionnaire"})
	public void TC4199_StandardReferencesInQuestionnaire()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4199_StandardReferencesInQuestionnaire");
			//login.tideLogin(AdminUsername, AdminPassword);
			QuePage.StandardReferencesInQuestionnaire_TC4199();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4199_StandardReferencesInQuestionnaire"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Standard References InQuestionnaire");
		videoRecordingStop();
	}

	@Test(priority = 113, groups={"TC4303_ViewUsedQuestionnaire"})
	public void TC4303_ViewUsedQuestionnaire()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4303_ViewUsedQuestionnaire");
			//login.tideLogin(AdminUsername, AdminPassword);
			QuePage.ViewUsedQuestionnaire_TC4303();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4303_ViewUsedQuestionnaire "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("View Used Questionnaire");
		videoRecordingStop();
	}
	
	@Test(priority = 666, groups={"TC5524_HeaderrowselectionQuestionnaire"})
	public void TC5524_HeaderrowselectionQuestionnaire()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC5524_HeaderrowselectionQuestionnaire");
		//	login.tideLogin(AdminUsername, AdminPassword);
			QuePage.HeaderrowselectionQuestionnaire_TC5524();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5524_HeaderrowselectionQuestionnaire "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Header row selection Questionnaire");
		videoRecordingStop();
	}

}