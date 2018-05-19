package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauQuePage;
import com.tide.qa.pagefactory.ConvertingSymMultipliersToNumberPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

public class ConvertingSymMultiplierToNumberTests extends TestBase {

	ConvertingSymMultipliersToNumberPage ConvSymMultiToMumPage = new ConvertingSymMultipliersToNumberPage();
	LoginPage login = new LoginPage();
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1= "Pa55word123";

	@Test(priority = 292, groups={"TC3770_MultiplierToNumber"})
	public void TC3770_MultiplierToNumber()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3770_MultiplierToNumber");
			//login.tideLogin(AdminUsername1, AdminPassword1);
			ConvSymMultiToMumPage.ConvertSymMultiplierToNumbers_3770();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3770_MultiplierToNumber "+e.getMessage(), "FAIL");
		}
		/*finally{
			login.tideCompanyAdminLogOut();
		}*/
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Converting Multiplier to Number");
		videoRecordingStop();
	}
}
