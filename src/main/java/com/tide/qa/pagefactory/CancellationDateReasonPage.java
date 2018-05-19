package com.tide.qa.pagefactory;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;

import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;

public class CancellationDateReasonPage extends PageBase {
	LoginPage loginPage = new LoginPage();
	BordereauQuePage BQPage = new BordereauQuePage();
	BordereauProcessPage BordereauPage = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();
	HomePage homePage = new HomePage();
	DatasetReferenceDataPage datasetPage = new DatasetReferenceDataPage();
	String Questionnaire = "SP -";	

	PeriodofCoverEnhancementPage enhncement= new PeriodofCoverEnhancementPage();

	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddHHmmss");
		String datetime = ft.format(dNow);
		return datetime;
	}
	public static String getCurrentDateTimeMS1() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("HHmmssyyMMdd");
		String datetime = ft.format(dNow);
		return datetime;
	}


	public static String contractId;
	public static String sheet3767Path = "";
	public static String sheet3767SecondPath = "";	
	
	//=============================Locators===========================================//
	
	public static final String CancellationDate="@xpath=//*[@data-field='Cancellation_Date']";
	public static final String CancellationReason="@xpath=//*[@data-field='Cancellation_Reason']";
	public static final String CancellationDateRow="@xpath=//td[contains(@ng-click,'Cancellation_Date')][text()='03/10/2017']";
	public static final String CancellationReasonRow="@xpath=//td[contains(@ng-click,'Cancellation_Reason')][text()='Unknown']";

	public void cancellationDate_3767() throws Exception{
		String  subSheet="SP - First Sheet (Automation Schema)";
		String DateMonth = "February 2017";
		String ExpectedCancellationDateRow="03/10/2017";
		String ExpectedCancellationReasonRow="Unknown";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		//BordereauPage.applyFilterPolicy("132020KZ");
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\"132020KZ\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3767Path = fpath+"\\src\\test\\resources\\testdata\\Cancelation_jan_TC3767.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3767Path);

			contractId =BordereauPage.addNewBordereauFormatPolicy(payload1, GetData);
			//System.out.println(contractId);

			String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Cancelation_jan_TC3767.xlsx\",\"UniqueFileName\":\"S59908320171114.xlsx\",\"BordereauFormatId\":\"c691dc97-46d0-4b0f-8dd2-cc143c764386\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S59908320171114.xlsx\",\"Filesize\":17641,\"Path\":null,\"size\":17641,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)==true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				sleep(3000);
				click(BordereauPage.ReviewBtn,"Review button");
				waitForElementToAppear(BordereauPage.SuRcdAssmnt,10);
				verifyMustExists(BordereauPage.SuRcdAssmnt,"Submit recor for Assignment button");
				click(BordereauPage.SuRcdAssmnt,"Submit recor for Assignment button");
				waitForElementToAppear(BordereauPage.FrApprovalbtn,10);
				verifyMustExists(BordereauPage.FrApprovalbtn,"For Approval button");
				click(BordereauPage.FrApprovalbtn,"For Approval button");
				BordereauPage.clickOnApproveBordBtn();
				sleep(3000);
				BordereauPage.refreshUploadedFileForApproved();
				if(isVisible(BordereauPage.Approvedbtn)==true)
				{
					BordereauPage.SubmitBordereauxWithYesnoButtons(DateMonth);
					try 
					{
						String fpath = new File(".").getCanonicalPath();
						sheet3767SecondPath = fpath+"\\src\\test\\resources\\testdata\\Stage 2 errors - March 2017_TC3767_Second.xlsx";
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					File excelFile1 = new File(sheet3767SecondPath);  


					      String payload2="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Cancelation_date_reason_feb.xlsx\",\"UniqueFileName\":\"S25010420180303.xlsx\",\"BordereauFormatId\":\"c691dc97-46d0-4b0f-8dd2-cc143c764386\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S25010420180303.xlsx\",\"Filesize\":20442,\"Path\":null,\"size\":20442,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

					uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
					BordereauPage.refreshUploadedFile();
					if(isVisible(BordereauPage.ReviewBtn)==true){
						Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
						sleep(3000);
						verifyMustExists(BordereauPage.ReviewBtn,"Review button");
						BordereauPage.openDATALink();
						BordereauPage.navigateToDATARiskTab();
						mouseOverAction(CancellationDate);
						verifyMustExists(CancellationDate,"Cancellation Date column");
						mouseOverAction(CancellationDateRow);
						verifyMustExists(CancellationDateRow,"Cancellation Date row"); 
						String ActualCancellationDateRow = getTextFrom(CancellationDateRow);
						sleep(2000);
						if(ActualCancellationDateRow.equals(ExpectedCancellationDateRow))
						{
							Report.LogInfo("ValidateCancellationDateRow", "Cancellation Date Row validate successfully", "PASS");	
						}
						else
						{
							Report.LogInfo("ValidateCancellationDateRow", "Cancellation Date Row not validate successfully", "Fail");
						}
						mouseOverAction(CancellationReason);
						verifyMustExists(CancellationReason,"Cancellation Reason column");
						mouseOverAction(CancellationReasonRow);
						verifyMustExists(CancellationReasonRow,"CancellationReason row"); 
						String ActualCancellationReasonRow = getTextFrom(CancellationReasonRow);
						sleep(2000);
						if(ActualCancellationReasonRow.equals(ExpectedCancellationReasonRow))
						{
							Report.LogInfo("ValidateCancellationReasonRow", "Cancellation Reason Row validate successfully", "PASS");	
						}
						else
						{
							Report.LogInfo("ValidateCancellationReasonRow", "Cancellation Reason Row not validate successfully", "Fail");
						}	

					}else{
						Report.LogInfo("ReviewStatusValidation", "Review Button not Displayed", "FAIL");
						BordereauPage.deleteBorderEAUX();
					}

				}else{
					Report.LogInfo("ApprovedbuttonValidation", "Approved Button not Displayed", "FAIL");
				}
			}else{
				Report.LogInfo("ReviewStatusValidation", "Review Button not Displayed", "FAIL");
				BordereauPage.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");

		}
	}

}
