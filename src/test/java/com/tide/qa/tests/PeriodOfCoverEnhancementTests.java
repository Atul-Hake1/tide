package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.CancellationDateReasonPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.PeriodofCoverEnhancementPage;
import com.tide.qa.utility.Report;

public class PeriodOfCoverEnhancementTests extends TestBase {

	PeriodofCoverEnhancementPage Enhancement = new PeriodofCoverEnhancementPage();
	CancellationDateReasonPage date =new CancellationDateReasonPage();
	LoginPage login = new LoginPage();
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1 = "Pa55word123";

	@Test(priority =290, groups={"TC3765_SeparateRiskInception"})
	public void TC3765_SeparateRiskInception()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3765_SeparateRiskInception");
			//login.tideLogin(AdminUsername1, AdminPassword1);
			Enhancement.separateRiskInception_3765();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3765_SeparateRiskInception"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Renewal Y/N Transaction Type (January) Verification");
		videoRecordingStop();
	}
	
}
