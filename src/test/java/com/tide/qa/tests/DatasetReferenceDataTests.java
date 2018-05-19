package com.tide.qa.tests;

import org.testng.annotations.Test;
import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.DatasetReferenceDataPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;


public class DatasetReferenceDataTests extends TestBase {

	DatasetReferenceDataPage datasetReferenceData = new DatasetReferenceDataPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";

	@Test(priority = 82, groups={"TC3381_AddDatasetReferenceData"})
	public void TC3381_AddDatasetReferenceData()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3381_AddDatasetReferenceData");
			//login.tideLogin(AdminUsername, AdminPassword);
			datasetReferenceData.addDatasetReference_3381();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3381_AddDatasetReferenceData"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add Dataset Reference Data Verification");
		videoRecordingStop();
	}

	@Test(priority = 83, groups={"TC3382_AddValue_existingDataset"})
	public void TC3382_AddValue_existingDataset()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3382_AddValue_existingDataset");
			datasetReferenceData.addvalueDatasetReference_3382();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3382_AddValue_existingDataset "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add a value to existing Dataset Reference data Verification");
		videoRecordingStop();
	}

	@Test(priority = 84, groups={"TC3383_AddNewValueMapping"})
	public void TC3383_AddNewValueMapping()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3383_AddNewValueMapping");
			datasetReferenceData.mappingReferenceDataset_3383();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3383_AddNewValueMapping"+e.getMessage(), "FAIL");
		}		
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Manually add new value mapping to Reference Dataset Verification");
		videoRecordingStop();
	}	

	@Test(priority = 85, groups={"TC4027_AddClaimFields"})
	public void TC4027_AddClaimFields()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4027_AddClaimFields");
			//login.tideLogin(AdminUsername, AdminPassword);
			datasetReferenceData.AddClaimFields_4027();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4027_AddClaimFields"+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add Claim Fields");
		videoRecordingStop();
	}
	
	@Test(priority = 86, groups={"TC4023_AddRiskPremiumFields"})
	public void TC4023_AddRiskPremiumFields()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4023_AddRiskPremiumFields");
			//login.tideLogin(AdminUsername, AdminPassword);
			datasetReferenceData.AddRiskPremiumFields_4023();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4023_AddRiskPremiumFields"+e.getMessage(), "FAIL");
		}/*finally{
			login.tideAdminLogOut();
		}*/
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Add Risk and Premium Fields");
		videoRecordingStop();
	}

}