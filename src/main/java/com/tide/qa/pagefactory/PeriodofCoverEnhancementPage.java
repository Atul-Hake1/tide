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


public class PeriodofCoverEnhancementPage extends PageBase {
	LoginPage loginPage = new LoginPage();
	BordereauQuePage BQPage = new BordereauQuePage();
	BordereauProcessPage BordereauPage = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();
	HomePage homePage = new HomePage();
	DatasetReferenceDataPage datasetPage = new DatasetReferenceDataPage();
	String Questionnaire = "SP -";	
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

	String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
	//String UniqueReferenceVal3 = "Automation Policy1"+getCurrentDateTimeMS();
	String CompanyReferenceval = "Automation Policy1"+getCurrentDateTimeMS();
	String UniqueReferenceVal2 = "Contract 2"+getCurrentDateTimeMS();

	public static String contractId;
	public static String sheet3765Path = "";
	public static final String SignedBtn = "@buttonText=Signed";
	public static final String EnrichedValue1Txt = "@xpath=//*[@id='Data0']";
	public static final String EnrichedValue2Txt = "@xpath=//*[@id='Data1']";
	public static final String PauseBtn = "@xpath=//*[contains(text(),'Pause')]";
	public static final String CancelBtn = "@xpath=//*[@ng-click='cancel()']";
	public static final String RiskInceptionDate="@xpath=//*[@data-field='RiskInceptionDate']";
	public static final String RiskExpiryDate="@xpath=//*[@data-field='RiskExpiryDate']";
	public static final String RiskInceptionDateFirstRow="@xpath=//td[contains(@ng-click,'RiskInceptionDate')][text()='01/02/2017']";
	public static final String RiskInceptionDateSeconRow="@xpath=//td[contains(@ng-click,'RiskInceptionDate')][text()='01/03/2017']";
	public static final String RiskExpiryDateFirstRow="@xpath=//td[contains(@ng-click,'RiskExpiryDate')][text()='09/01/2017']";
	public static final String RiskExpiryDateSecondRow="@xpath=//td[contains(@ng-click,'RiskExpiryDate')][text()='10/07/2017']";
	public static final String RuleName1="@xpath=//form[@name='form.Enrichment']//*[text()='Validate Risk Inception Date values']";
	public static final String RuleName2="@xpath=//form[@name='form.Enrichment']//*[text()='Separate Risk Inception and Expiry from single cell']";
	public static final String Okbtn="@xpath=//div[@ng-click='cancel()']";
	
	public void separateRiskInception_3765() throws Exception{
		String  subSheet="Period Of Cover (Automation Schema)";
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String ExpectedRIDateFirstRow="01/02/2017";
		String ExpectedRIDateSecondRow="01/03/2017";
		String ExpectedREDateFirstRow="09/01/2017";
		String ExpectedREDateSecondRow="10/07/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails1(UniqueReferenceVal1, IncDate,ExpDate,BordereauPage.Status1, policy.Broker1, policy.Bline1, policy.Underline1);
		waitForElementToAppear(BordereauPage.DraftBtn,5);
		verifyExists(BordereauPage.DraftBtn,"Draft Status Button");
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);	
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3765Path = fpath+"\\src\\test\\resources\\testdata\\Period_of_cover_TC_3765.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3765Path);  

			contractId =BordereauPage.addNewBordereauFormatPolicy(payload1, GetData);
			//System.out.println(contractId);

			String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Period_of_cover_TC_3765.xlsx\",\"UniqueFileName\":\"S10459820171112.xlsx\",\"BordereauFormatId\":\"87e89466-d7ea-4447-b904-30ffdb675d80\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S10459820171112.xlsx\",\"Filesize\":18676,\"Path\":null,\"size\":18676,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

			BordereauPage.uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(BordereauPage.checkErrorReviewButton(BordereauPage.ReviewError)==true){
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				invalidRiskInceptionDate();
				yoaError();
				BordereauPage.refreshUploadedFile();
				if(BordereauPage.checkErrorReviewButton(BordereauPage.ReviewError)==true){
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
					invaliddatavalueIdentied();
					sleep(5000);
					BordereauPage.refreshUploadedFile();
					if(isVisible(BordereauPage.ReviewBtn)== true){
						Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
						//refreshPage();
						sleep(2000);
						mouseOverAction(BordereauPage.DATAlink);
						BordereauPage.openDATALink();
						BordereauPage.navigateToDATARiskTab();
						mouseOverAction(RiskInceptionDate);
						verifyMustExists(RiskInceptionDate,"Risk Inception Date column");
						mouseOverAction(RiskInceptionDateFirstRow);
						click(RiskInceptionDateFirstRow,"Risk Inception Date- first row"); 
						sleep(3000);
						waitForElementToAppear(RuleName1,5);
						verifyExists(RuleName1,"First rule name");
						verifyExists(RuleName2,"Second rule name");
						verifyExists(Okbtn,"Ok button");
						click(Okbtn,"Ok button");
						waitForElementToAppear(BordereauPage.BORDEREAUXLink,5);
						verifyMustExists(BordereauPage.BORDEREAUXLink,"BORDEREAUX Link");
						click(BordereauPage.BORDEREAUXLink,"BORDEREAUX Link");
						BordereauPage.navigateOnProcessingTab();
						sleep(3000);
						BordereauPage.deleteBorderEAUX();

					}else{
						Report.LogInfo("ReviewStatusValidation", "Review Status Button not Displayed", "FAIL");
						BordereauPage.deleteBorderEAUX();
					}

				}else{
					Report.LogInfo("ReviewErrorStatusValidation", "Review Error Status Button not Displayed", "FAIL");
					BordereauPage.deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ReviewErrorStatusValidation", "Review Error Status Button not Displayed", "FAIL");
				BordereauPage.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("SignedStatusValidation", "Signed Status not displayed", "FAIL");
		}
	}


	//==========================================================================Reusable function =========================================================			


	public void invalidRiskInceptionDate()
	{
		if(isVisible(EnrichedValue1Txt)==true){
			verifyExists(EnrichedValue1Txt,"Enriched Value1 field");
			clearTextBox(EnrichedValue1Txt);
			sendKeys(EnrichedValue1Txt,"01/02/2017","Enriched Value1 field.");
			BordereauPage.verifyBackground(EnrichedValue1Txt,"rgba(0, 97, 0, 1)");
			verifyMustExists(EnrichedValue2Txt,"Year Account2 field.");
			clearTextBox(EnrichedValue2Txt);//2 row
			sendKeys(EnrichedValue2Txt,"01/03/2017","Enriched Value2 field.");
			BordereauPage.verifyBackground(EnrichedValue2Txt,"rgba(0, 97, 0, 1)");
			verifyMustExists(BordereauPage.continuebtn,"Continue button");
			click(BordereauPage.continuebtn,"Continue button");
		}else{
			Report.LogInfo("ExpectedScreenValidation", "Expected screen not displayed", "FAIL");
			goBack();
			BordereauPage.deleteBorderEAUX();
		}
	}

	public void yoaError()
	{

		if(isVisible(BordereauPage.discardRecord)== true){
			verifyMustExists(BordereauPage.discardRecord,"discard record");
			click(BordereauPage.discardRecord,"Discard record");
			verifyMustExists(BordereauPage.continuebtx,"Continue button");
			click(BordereauPage.continuebtx,"Continue button");
			sleep(3000);
		}else{
			Report.LogInfo("ExpectedScreenValidation", "Expected screen not displayed", "FAIL");
		}

	}

	public void invaliddatavalueIdentied()
	{
		if(isVisible(EnrichedValue1Txt)==true){
			verifyExists(EnrichedValue1Txt,"Enriched Value1 field");
			clearTextBox(EnrichedValue1Txt);
			sendKeys(EnrichedValue1Txt,"09/01/2017","Enriched Value1 field.");
			BordereauPage.verifyBackground(EnrichedValue1Txt,"rgba(0, 97, 0, 1)");
			verifyExists(EnrichedValue2Txt,"Enriched Value2 field");
			clearTextBox(EnrichedValue2Txt);
			sendKeys(EnrichedValue2Txt,"10/07/2017","Enriched Value2 field.");
			BordereauPage.verifyBackground(EnrichedValue1Txt,"rgba(0, 97, 0, 1)");
			verifyMustExists(BordereauPage.continuebtn,"Continue button");
			click(BordereauPage.continuebtn,"Continue button");
			waitForElementToAppear(CancelBtn,10);
			verifyExists(CancelBtn,"Cancel button");
			click(CancelBtn,"Cancel button");
		}else{
			Report.LogInfo("ExpectedScreenValidation", "Expected screen not displayed", "FAIL");
			goBack();
			BordereauPage.deleteBorderEAUX();
		}
	}		

}
