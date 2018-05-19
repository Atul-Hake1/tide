package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.ContractMetadataPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.TasksPage;
import com.tide.qa.utility.Report;

public class TasksTests extends TestBase
{
	TasksPage addTasksdata = new TasksPage();
	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1 = "Pa55word123";
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";

	@Test(priority =293, groups={"TC3500_DataFormatNotIdentified"})
	public void TC3500_DataFormatNotIdentified()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3500_DataFormatNotIdentified");
			//login.tideLogin(AdminUsername1, AdminPassword1);
			sheets.DataFormatNotIdentified();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3500_DataFormatNotIdentified "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("To make sure data format not indentified");
		videoRecordingStop();
	}

	@Test(priority =294, groups={"TC4475_DatePresentationCannotIdentified"})
	public void TC4475_DatePresentationCannotIdentified()
	{

		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4475_DatePresentationCannotIdentified");
			//login.tideLogin(AdminUsername1, AdminPassword1);
			sheets.DatePresentationCannotIdentified_4475();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4475_DatePresentationCannotIdentified "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Date presentation cannot be identified - select 'months - days - years'");
		videoRecordingStop();
	}

}