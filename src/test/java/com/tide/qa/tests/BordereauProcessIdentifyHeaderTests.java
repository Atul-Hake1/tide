            package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

public class BordereauProcessIdentifyHeaderTests extends TestBase
{
	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword = "Pa55word123";
	
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Pa55word123";
	
	
	
	@Test(priority =215, groups={"TC3207_VerifyNormalAndExpectedHeader"})
	public void TC3207_VerifyNormalAndExpectedHeader()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3207_VerifyNormalAndExpectedHeader");
			//login.tideLogin(AdminUsername, AdminPassword);
			sheets.verifyNormalAndExpectedHeader_3207();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3207_VerifyNormalAndExpectedHeader "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Sheet where normal and expected header is provided");
		videoRecordingStop();
	}
		
	@Test(priority =192, groups={"TC3211_ContinueProcessing"})
	public void TC3211_ContinueProcessing()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3211_ContinueProcessing");
			sheets.continueProcessing_3211();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3211_ContinueProcessing "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("only sheet Verification for specific text for unchanged Process");
		videoRecordingStop();
	}
	
	@Test(priority =193, groups={"TC3212_CancelProcessing"})
	public void TC3212_CancelProcessing()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3212_CancelProcessing");
			sheets.cancelProcessing_3212();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3212_CancelProcessing "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("only sheet Verification for specific text for unchanged Process");
		videoRecordingStop();
	}
	
	
	@Test(priority =216, groups={"TC3213_IdentifyDuplicateColumn"})
	public void TC3213_IdentifyDuplicateColumn()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3213_IdentifyDuplicateColumn");
			sheets.identifyDuplicateColumn_3213();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3213_IdentifyDuplicateColumn "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("only sheet Verification for specific text for unchanged Process");
		videoRecordingStop();
	}
	
	@Test(priority =217, groups={"TC3214_ChangeColumnPosition"})
	public void TC3214_ChangeColumnPosition()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3214_ChangeColumnPosition");
			sheets.changeColumnPosition_3214();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3214_ChangeColumnPosition "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("only sheet Verification for specific text for unchanged Process");
		videoRecordingStop();
	}
	
	@Test(priority =197, groups={"TC3361_ColumnsMissing_MissingError"})
	public void TC3361_ColumnsMissing_MissingError()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3361_ColumnsMissing_MissingError");
			sheets.moreThanOneColumnMissing();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3361_ColumnsMissing_MissingError"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("More than one columns Missing from all sheets - Missing Error Verification");
		videoRecordingStop();
	}
	
	@Test(priority =218, groups={"TC3344_RemoveHeaderRowFromOneSheet"})
	public void TC3344_RemoveHeaderRowFromOneSheet()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3344_RemoveHeaderRowFromOneSheet");
			sheets.removeHeaderRow();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3344_RemoveHeaderRowFromOneSheet"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Remove Header Row From One Sheet Verification");
		videoRecordingStop();
	}
	
	@Test(priority =219, groups={"TC3349_RemoveHeaderFromAllSheets"})
	public void TC3349_RemoveHeaderFromAllSheets()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3349_RemoveHeaderFromAllSheets");
			sheets.removeHeaderFromAllSheets();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3349_RemoveHeaderFromAllSheets "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Remove Header From All Sheets Verification");
		videoRecordingStop();
	}
	
	@Test(priority =220, groups={"TC3345_SpecifyWrongHeaderForOneSheet"})
	public void TC3345_SpecifyWrongHeaderForOneSheet()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3345_SpecifyWrongHeaderForOneSheet");
			sheets.wrongHeaderRowNumberOneSheet();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3345_SpecifyWrongHeaderForOneSheet"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Specify Wrong Header Row Number For One Sheet Verification");
		videoRecordingStop();
	}
	
	@Test(priority =221, groups={"TC3346_SpecifyWrongHeaderForAllSheet"})
	public void TC3346_SpecifyWrongHeaderForAllSheet()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3346_SpecifyWrongHeaderForAllSheet");
			sheets.wrongHeaderRowNumberAllSheet();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3346_SpecifyWrongHeaderForAllSheet"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Specify wrong header row number for All sheet Verification");
		videoRecordingStop();
	}

	@Test(priority =222, groups={"TC3347_ChangeColumnPositionInOneSheet"})
	public void TC3347_ChangeColumnPositionInOneSheet()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3347_ChangeColumnPositionInOneSheet");
			sheets.changeColumnPosition();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3347_ChangeColumnPositionInOneSheet"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Change Column Position in One Sheet Verification");
		videoRecordingStop();
	}
	
	@Test(priority =223, groups={"TC3348_DuplicateColumnPresentInOneSheet"})
	public void TC3348_DuplicateColumnPresentInOneSheet()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3348_DuplicateColumnPresentInOneSheet");
			sheets.duplicateColumn();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3348_DuplicateColumnPresentInOneSheet"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Duplicate Column Present in One Sheet Verification");
		videoRecordingStop();
	}
	
	@Test(priority =224, groups={"TC3352_DuplicateColumnPresentInAllSheet"})
	public void TC3352_DuplicateColumnPresentInAllSheet()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3352_DuplicateColumnPresentInAllSheet");
			sheets.duplicateColumnAllSheet();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3352_DuplicateColumnPresentInAllSheet"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Duplicate Column Present in All Sheet(s) Verification");
		videoRecordingStop();
	}
	
	@Test(priority =205, groups={"TC3359_DeleteMappedColumn_MissingError"})
	public void TC3359_DeleteMappedColumn_MissingError()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3359_DeleteMappedColumn_MissingError");
			sheets.deleteMappedColumn();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3359_DeleteMappedColumn_MissingError"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Delete Mapped Column From Both Sheet - Missing Error Verification");
		videoRecordingStop();
	}
	
	@Test(priority =437, groups={"TC4470_Newcolumnsidentified"})
	public void TC4470_Newcolumnsidentified()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4470_Newcolumnsidentified");
			sheets.newcolumnsidentified_4470();		
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4470_Newcolumnsidentified"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("New columns identified - continue without using columns");
		videoRecordingStop();
	}
	
	@Test(priority =438, groups={"TC4472_editQuestionnaire_usecolumns"})
	public void TC4472_editQuestionnaire_usecolumns()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4472_editQuestionnaire_usecolumns");
			sheets.newColumnsIdentified_4472();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4472_editQuestionnaire_usecolumns"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("New columns identified - edit Questionnaire to use columns");
		videoRecordingStop();
	}
	
	@Test(priority =439, groups={"TC4473_expectedCloumnsMissing"})
	public void TC4473_expectedCloumnsMissing()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4473_expectedCloumnsMissing");
			sheets.expectedColumnsMissing_4473();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4473_expectedCloumnsMissing"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Expected columns missing - continue processing");
		videoRecordingStop();
	}
	
	@Test(priority =440, groups={"TC4474_oneExpectedCloumnsMissing"})
	public void TC4474_oneExpectedCloumnsMissing()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4474_oneExpectedCloumnsMissing");
			sheets.oneExpectedColumnsMissing_4474();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4474_oneExpectedCloumnsMissing"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("One or more expected column missing - edit Questionnaire to no longer expect these");
		videoRecordingStop();
	}
	
	@Test(priority =441, groups={"TC4481_DownloadBordereaufile"})
	public void TC4481_DownloadBordereaufile()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4481_DownloadBordereaufile");
			sheets.downloadBordereaufile_4481();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4481_DownloadBordereaufile"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Download Bordereau file from error screen");
		videoRecordingStop();
	}
	
}

