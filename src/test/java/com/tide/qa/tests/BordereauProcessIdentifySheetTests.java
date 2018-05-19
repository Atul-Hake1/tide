package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

public class BordereauProcessIdentifySheetTests extends TestBase
{
	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword = "Pa55word123";
	
	@Test(priority = 225, groups={"TC3145_AllSheets"})
	public void TC3145_AllSheets()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3145_AllSheets");
			//login.tideLogin(AdminUsername, AdminPassword);
			sheets.allSheets_3145();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3145_AllSheets "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Verify all sheets");
		videoRecordingStop();
	}

	@Test(priority = 226, groups={"TC3149_FirstSheets"})
	public void TC3149_FirstSheets()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3149_FirstSheets");
			sheets.FirstSheet_3149();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3149_FirstSheets "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Verify First sheets");
		videoRecordingStop();
	}
	@Test(priority = 227, groups={"TC3150_LastSheets"})
	public void TC3150_LastSheets()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3150_LastSheets");
			sheets.LastSheet_3150();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3150_LastSheets "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Verify Last sheets");
		videoRecordingStop();
	}
	
	@Test(priority =228, groups={"TC3186_MultipleSheet"})
	public void TC3186_MultipleSheet()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3186_MultipleSheet");
			sheets.multiplesheetProcessing_3186();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3186_MultipleSheet "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Verify Multiple sheet specific text");
		videoRecordingStop();
	}
	@Test(priority =229, groups={"TC3160_OnlySheetsIdentifed"})
	public void TC3160_OnlySheetsIdentifed()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3160_OnlySheetsIdentifed");
			sheets.onlySheet_3160();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3160_OnlySheetsIdentifed "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("only sheet Verification");
		videoRecordingStop();
	}
	
	@Test(priority =230, groups={"TC3165_SheetContainsSpecificTextUnchanged"})
	public void TC3165_SheetContainsSpecificTextUnchanged()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3165_SheetContainsSpecificTextUnchanged");
			sheets.processingSelectingSheetUnchanged_3165();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3165_SheetContainsSpecificTextUnchanged "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("only sheet Verification for specific text for unchanged Process");
		videoRecordingStop();
	}
	
		
	@Test(priority =231, groups={"TC3166_CancelAndDeleteBorderEAUX"})
	public void TC3166_CancelAndDeleteBorderEAUX()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3166_CancelAndDeleteBorderEAUX");
			sheets.cancelBordereauProcess_3166();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3166_CancelAndDeleteBorderEAUX "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Verify cancel and delete Bordereau");
		videoRecordingStop();
	}
	
	@Test(priority =232, groups={"TC3161_OnlySheetThatContainsSpecificText"})
	public void TC3161_OnlySheetThatContainsSpecificText()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3161_OnlySheetThatContainsSpecificText");
			sheets.sheetIdentification_3161();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3161_OnlySheetThatContainsSpecificText "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("only sheet Verification for specific text");
		videoRecordingStop();
	}
	
	@Test(priority =233, groups={"TC3192_MultipleSheetsIdentifed"})
	public void TC3192_MultipleSheetsIdentifed()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3192_MultipleSheetsIdentifed");
			sheets.multiplesheet_3192();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3192_MultipleSheetsIdentifed "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("multiple sheets Verification");
		videoRecordingStop();
	} 

	@Test(priority =234, groups={"TC3193_MultipleSheetsCancelProcessing"})
	public void TC3193_MultipleSheetsCancelProcessing()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3193_MultipleSheetsCancelProcessing");
			sheets.multiplesheetCancelProcessing_3193();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3193_MultipleSheetsCancelProcessing "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("multiple sheets cancel Processing verification");
		videoRecordingStop();
	}

	@Test(priority =235, groups={"TC3194_VerifySheetEqualsSpecificText"})
	public void TC3194_VerifySheetEqualsSpecificText()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3194_VerifySheetEqualsSpecificText");
			sheets.verifyOnlySheetThatEqualsSpecificText_3194();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3194_VerifySheetEqualsSpecificText "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("The only sheet that equals specific text - Sheet can be identified");
		videoRecordingStop();
	}

	@Test(priority =236, groups={"TC3195_VerifyTextAndObserveReviewBtn"})
	public void TC3195_VerifyTextAndObserveReviewBtn()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3195_VerifyTextAndObserveReviewBtn");
			sheets.verifySpecificTextAndObserveReviewBtn_3195();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3195_VerifyTextAndObserveReviewBtn "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("The only sheet that equals specific text No sheets equal specified text");
		videoRecordingStop();
	}

	@Test(priority =237, groups={"TC3196_VerifyTextAndObserveDataRecord"})
	public void TC3196_VerifyTextAndObserveDataRecord()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3196_VerifyTextAndObserveDataRecord");
			sheets.verifySpecificTextAndObserveDataRecord_3196();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3196_VerifyTextAndObserveDataRecord "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("No sheets equal specified text - Select expected sheet");
		videoRecordingStop();
	}

	@Test(priority =238, groups={"TC3197_CancelProcessing"})
	public void TC3197_CancelProcessing()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3197_CancelProcessing");
			sheets.cancelProcessing_3197();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3197_CancelProcessing "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("No sheets equal specified text - Cancel Processing");
		videoRecordingStop();
	}

	@Test(priority =239, groups={"TC3198_ContainsSpecificTextMatchRecords"})
	public void TC3198_containsSpecificTextMatchRecords()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3198_ContainsSpecificTextMatchRecords");
			sheets.containsSpecificTextMatchRecords_3198();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3198_containsSpecificTextMatchRecords "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Any sheets that contains specific text - Sheet can be identified");
		videoRecordingStop();
	}
	
	@Test(priority =240, groups={"TC3200_VerifyTextAndObserveDataRecord"})
	public void TC3200_VerifyTextAndObserveDataRecord()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3200_VerifyTextAndObserveDataRecord");
			sheets.verifyContainsSpecificTextAndObserveDataRecord_3200();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3200_VerifyTextAndObserveDataRecord "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Sheet can not be identified - Select expected sheet");
		videoRecordingStop();
	}
	
	@Test(priority =241, groups={"TC3201_CancelProcessing"})
	public void TC3201_CancelProcessing()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3201_CancelProcessing");
			sheets.cancelProcessing_3201();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3201_CancelProcessing "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Sheet can not be identified - Cancel Processing");
		videoRecordingStop();
	}
	
	@Test(priority =242, groups={"TC3199_EditContainsSpecificText"})
	public void TC3199_EditContainsSpecificText()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3199_EditContainsSpecificText");
			sheets.editContainsSpecificText_3199();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3199_EditContainsSpecificText "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Sheet can not be identified - Edit the specific text that the only sheet to be processed");
		videoRecordingStop();
	}

	@Test(priority =243, groups={"TC3202_OnlySpecifiedSheet"})
	public void TC3202_OnlySpecifiedSheet()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3202_OnlySpecifiedSheet");
			sheets.OnlySpecifiedSheet_3202();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3202_OnlySpecifiedSheet "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Only Specified Sheet(s) - Sheet can be identified");
		videoRecordingStop();
	}

	@Test(priority =244, groups={"TC3203_OnlySpecifiedSheetCanNotBeIdentified"})
	public void TC3203_OnlySpecifiedSheetCanNotBeIdentified()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3203_OnlySpecifiedSheetCanNotBeIdentified");
			sheets.OnlySpecifiedSheetCanNotBeIdentified_3203();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3203_OnlySpecifiedSheetCanNotBeIdentified "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Sheet can not be identified - Edit the specific text that the only sheet to be processed");
		videoRecordingStop();
	}

	@Test(priority =245, groups={"TC3204_OnlySpecifiedSheetCancelProcessing"})
	public void TC3204_OnlySpecifiedSheetCancelProcessing()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3204_OnlySpecifiedSheetCancelProcessing");
			sheets.OnlySpecifiedSheetCancelProcessing_3204();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3204_OnlySpecifiedSheetCancelProcessing "+e.getMessage(), "FAIL");
		}/*finally{
			login.tideCompanyAdminLogOut();
		}*/
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Only Specified Sheet(s) -Sheet can not be identified - Cancel Processing");
		videoRecordingStop();
	}	
}
