package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.ReportingChannel;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.utility.Report;
public class ReportingChannelTests extends TestBase{
	public BordereauProcessPage BorderPg=null ;
	ReportingChannel channel = new ReportingChannel();
	LoginPage login = new LoginPage();
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1 = "Pa55word123";
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	
	@Test(priority =59, groups={"TC3437_NoReportingChannelAvailable"})
	public void TC3437_NoReportingChannelAvailable()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3437_NoReportingChannelAvailable");
			//login.tideLogin(AdminUsername, AdminPassword);
			channel.NoReportingChannelAvailable();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3437_NoReportingChannelAvailable "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Verify no reporting channel availability");
		videoRecordingStop();

	}
	
	@Test(priority =251, groups={"TC3371_SingleMatchingReportingChannel"})
	public void TC3371_SingleMatchingReportingChannel()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3371_SingleMatchingReportingChannel");
			//login.tideLogin(AdminUsername1, AdminPassword1);
			channel.SingleMatchingReportingChannel();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3371_SingleMatchingReportingChannel "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Verify single matching reporting channel");
		videoRecordingStop();
	}
	
	
	@Test(priority =252, groups={"TC3439_AddingMAtchReportingChannel"})
	public void TC3439_AddingMAtchReportingChannel()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3439_AddingMAtchReportingChannel");
			channel.addMatchingReportingChannel();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3439_AddingMAtchReportingChannel "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Verify adding matching reporting channel");
		videoRecordingStop();
	}
	
	@Test(priority =253, groups={"TC3479_BordereauxReportingChannelCancel"})
	public void TC3479_BordereauxReportingChannelCancel()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3479_BordereauxReportingChannelCancel");
			channel.ProcessBordereauxMultipleReportingChannelCancel();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3479_BordereauxReportingChannelCancel "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Verify Process Bordereaux Multiple Reporting Channel Canceling");
		videoRecordingStop();
	}
	
	@Test(priority =254, groups={"TC3372_BordereauMatchingReportingChannel"})
	public void TC3372_BordereauMatchingReportingChannel()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3372_BordereauMatchingReportingChannel");
			channel.ProcessBordereauMoreThanOneMatchingReportingChannel();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3372_BordereauMatchingReportingChannel "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Verify process bordereau more than one matching reporting channel");
		videoRecordingStop();
	}
	
	
	@Test(priority =255, groups={"TC3440_DeleteReportingChannel"})
	public void TC3440_DeleteReportingChannel()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3440_DeleteReportingChannel");
			channel.DeleteCreatedReportingChannel();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3440_DeleteReportingChannel "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Verify deleting of created reporting channel");
		videoRecordingStop();
	}
	
	@Test(priority =256, groups={"TC3480_ProcessBordereauForMoreReportingChannel"})
	public void TC3480_ProcessBordereauForMoreReportingChannel()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3480_ProcessBordereauForMoreReportingChannel");
			channel.ProcessBordereauForMoreReportingChannel();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3480_ProcessBordereauForMoreReportingChannel "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Verify process border for more reporting channel");
		videoRecordingStop();
	}	
	
	@Test(priority =257, groups={"TC3481_AddReportingChannelForQuarter"})
	public void TC3481_AddReportingChannelForQuarter()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3481_AddReportingChannelForQuarter");
			channel.AddReportingChannelForQuarter();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3481_AddReportingChannelForQuarter "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Verify adding reporting channel for Quarter");
		videoRecordingStop();
	}
	
	@Test(priority =258, groups={"TC3482_AddReportingchannelAnnually"})
	public void TC3482_AddReportingchannelAnnually()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC3482_AddReportingchannelAnnually");
			channel.AddReportingchannelAnnually();			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3482_AddReportingchannelAnnually "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Verify adding reporting channel annually");
		videoRecordingStop();
	}
		
}
