package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.BordereauQuePage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

public class BordereauProcessedMissingFutureTests extends TestBase
{
	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword = "Pa55word123";
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Pa55word123";
			
	@Test(priority =259, groups={"TC3448_SamePeriodNotYetApproved"})
	public void TC3448_SamePeriodNotYetApproved()
	{
		Report.createTestCaseReportHeader();
		try
		{
			//login.tideLogin(AdminUsername, AdminPassword);
			videoRecordingStart("TC3448_SamePeriodNotYetApproved");
			sheets.AnotherBordereauSamePeriodNotYetApproved();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3448_SamePeriodNotYetApproved "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Verify another bordereau same period not yet approved");
		videoRecordingStop();
	}
	
	@Test(priority =260, groups={"TC3449_PreviousBordereauNotYetApproved"})
	public void TC3449_PreviousBordereauNotYetApproved()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3449_PreviousBordereauNotYetApproved");
			sheets.PreviousBordereauNotYetApproved();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3449_PreviousBordereauNotYetApproved "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Verify previous bordereau not yet approved");
		videoRecordingStop();
	}
	
	@Test(priority =261, groups={"TC3450_BordereauPeriodPrior"})
	public void TC3450_BordereauPeriodPrior()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3450_BordereauPeriodPrior");
			//login.tideLogin(AdminUsername, AdminPassword);
			sheets.BordereauPeriodPriorToContractInception();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3450_BordereauPeriodPrior "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Verify bordereau period prior to contract inception");
		videoRecordingStop();
	}	

	@Test(priority = 262, groups={"TC3452_MissingFutureNilCancelProcessing"})
	public void TC3452_MissingFutureNilCancelProcessing()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3452_MissingFutureNilCancelProcessing");			
			sheets.missingFutureSequentiallyNilBordereaux_3452();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3452_MissingFutureNilCancelProcessing "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Risk Bordereau questionnaire -  User records as nil bordereaux then cancel processing");
		videoRecordingStop();
	}
		
	@Test(priority = 263, groups={"TC3451_MissingFutureSequentiallyNilBordereaux"})
	public void TC3451_MissingFutureSequentiallyNilBordereaux()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3451_MissingFutureSequentiallyNilBordereaux");
			//login.tideLogin(AdminUsername, AdminPassword);
			sheets.missingFutureSequentiallyNilBordereaux_3451();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3451_MissingFutureSequentiallyNilBordereaux "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Risk Bordereau questionnaire -  User records as nil bordereaux");
		videoRecordingStop();
	}	
			
	@Test(priority = 264, groups={"TC3453_AlreadyApprovedCancelProcessing"})
	public void TC3453_AlreadyApprovedCancelProcessing()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3453_AlreadyApprovedCancelProcessing");
			sheets.AlreadyApprovedCancelProcessing_3453();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3453_AlreadyApprovedCancelProcessing "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Risk Bordereau questionnaire -  Already Approved then cancel processing");
		videoRecordingStop();
	}
		
	@Test(priority = 265, groups={"TC3455_AlreadyApprovedIncorrectPeriod"})
	public void TC3455_AlreadyApprovedIncorrectPeriod()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3455_AlreadyApprovedIncorrectPeriod");
			sheets.AlreadyApprovedIncorrectPeriod_3455();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3455_AlreadyApprovedIncorrectPeriod "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Risk Bordereau questionnaire -  Already Approved then Incorrect Period");
		videoRecordingStop();
	}
		
	@Test(priority = 266, groups={"TC3456_AlreadyApprovedAdditionalBordereaux"})
	public void TC3456_AlreadyApprovedAdditionalBordereaux()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3456_AlreadyApprovedAdditionalBordereaux");
			sheets.AlreadyApprovedAdditionalBordereaux_3456();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3456_AlreadyApprovedAdditionalBordereaux "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Risk Bordereau questionnaire -  Already Approved then Additional Bordereaux");
		videoRecordingStop();
	}
	
	@Test(priority = 267, groups={"TC3458_AlreadyApprovedCorrectionBordereau"})
	public void TC3458_AlreadyApprovedCorrectionBordereau()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3458_AlreadyApprovedCorrectionBordereau");
			sheets.CorrectionBordereau_3458();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3458_AlreadyApprovedCorrectionBordereau "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Risk Bordereau questionnaire -  Already Approved then Correction Bordereaux");
		videoRecordingStop();
	}
			
	@Test(priority = 268, groups={"TC3463_MissingBordereauPeriodBordereaux"})
	public void TC3463_MissingBordereauPeriodBordereaux()
	{
		Report.createTestCaseReportHeader();

		try
		{
			
			videoRecordingStart("TC3463_MissingBordereauPeriodBordereaux");
			//login.tideLogin(AdminUsername, AdminPassword);
			sheets.MissingBordereauPeriod_3463();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3463_MissingBordereauPeriodBordereaux "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Multi contract - Missing Bordereau Period");
		videoRecordingStop();
	}
				
	@Test(priority = 269, groups={"TC3469_MissingBordereauContinueNillBordereau"})
	public void TC3469_MissingBordereauContinueNillBordereau()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3469_MissingBordereauContinueNillBordereau");
			sheets.MissingBordereauPeriodContinueNillBordereau_3469();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3469_MissingBordereauContinueNillBordereau "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Multi contract - Missing Bordereau Period Continue will nill bordereau");
		videoRecordingStop();
	}
			
	@Test(priority = 270, groups={"TC3471_ErrorRemainingCancelProcessing"})
	public void TC3471_ErrorRemainingCancelProcessing()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3471_ErrorRemainingCancelProcessing");
			sheets.ErrorRemainingCancelProcessing_3471();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3471_ErrorRemainingCancelProcessing "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Bordereau of the Previous period has errors remaining Cancel processing");
		videoRecordingStop();
	}
	
	@Test(priority = 271, groups={"TC3472_ErrorRemainingCancelProcessing"})
	public void TC3472_ErrorRemainingCancelProcessing()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3472_ErrorRemainingCancelProcessing");
			sheets.ErrorRemainingCancelProcessing_3472();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3472_ErrorRemainingCancelProcessing "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Same Bordereau has errors remaining(cancel Processing)");
		videoRecordingStop();
	}
		
		
	@Test(priority = 402, groups={"TC3475_ErrorRemainingContinueProcessing"})
	public void TC3475_ErrorRemainingContinueProcessing()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3475_ErrorRemainingContinueProcessing");
			//login.tideLogin(AdminUsername2, AdminPassword2);
			sheets.ErrorRemainingContinueProcessing_3475();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3475_ErrorRemainingContinueProcessing "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Bordereau of the Previous period has errors remaining Continue  processing(Yes)");
		videoRecordingStop();
	}
	
	@Test(priority = 403, groups={"TC3477_SameBordroErrorRemaining"})
	public void TC3477_SameBordroErrorRemaining()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3477_SameBordroErrorRemaining");
			sheets.SamebordorErrorRemainingContinueProcessing_3477();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3477_SameBordroErrorRemaining "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Same Bordereau has errors remaining(Continue Processing- Yes)");
		videoRecordingStop();
	}	
}