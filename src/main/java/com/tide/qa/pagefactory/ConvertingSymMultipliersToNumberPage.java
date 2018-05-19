package com.tide.qa.pagefactory;

import com.tide.qa.common.PageBase;

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
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;

public class ConvertingSymMultipliersToNumberPage extends PageBase{
	LoginPage loginPage = new LoginPage();
	BordereauQuePage BQPage = new BordereauQuePage();
	BordereauProcessPage BordereauPage = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();
	HomePage homePage = new HomePage();
	//DatasetReferenceDataPage datasetPage = new DatasetReferenceDataPage();
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
	public static String sheet3770Path = "";
	public static final String SignedBtn = "@buttonText=Signed";
	public static final String EnrichedValue1Txt = "@xpath=//*[@id='Data0']";
	public static final String EnrichedValue2Txt = "@xpath=//*[@id='Data1']";
	public static final String PauseBtn = "@xpath=//*[contains(text(),'Pause')]";
	public static final String CancelBtn = "@xpath=//*[@ng-click='cancel()']";
	public static final String RiskInceptionDate="@xpath=//*[@data-field='RiskInceptionDate']";
	public static final String RiskExpiryDate="@xpath=//*[@data-field='RiskExpiryDate']";
	public static final String RiskInceptionDateFirstRow="@xpath=//*[@role='rowgroup']//tr[1]//td[14]";
	public static final String RiskInceptionDateSeconRow="@xpath=//*[@role='rowgroup']//tr[2]//td[14]";
	public static final String RiskExpiryDateFirstRow="@xpath=//*[@role='rowgroup']//tr[1]//td[15]";
	public static final String RiskExpiryDateSecondRow="@xpath=//*[@role='rowgroup']//tr[2]//td[15]";

	public static final String NetPremiumColumn ="@xpath=//*[@data-field='Net_Premium']";
	public static final String NetPremiumrow1="@xpath=//tr[1]//td[contains(@ng-click,'Net_Premium')][text()='1,000,000,000.00']";
	public static final String NetPremiumrow2="@xpath=//tr[2]//td[contains(@ng-click,'Net_Premium')][text()='1,000,000,000.00']";
	public static final String NetPremiumrow3="@xpath=//tr[3]//td[contains(@ng-click,'Net_Premium')][text()='1,000,000,000.00']";

	public void ConvertSymMultiplierToNumbers_3770() throws Exception{
		String  subSheet="SP - First Sheet (Automation Schema)";
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		String ExpectedFirstRow ="1,000,000,000.00";
		String ExpectedSecondRow ="1,000,000,000.00";
		String ExpectedThirdRow ="1,000,000,000.00";;
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails2(UniqueReferenceVal1, IncDate,ExpDate,BordereauPage.Status1, policy.Broker1, policy.Bline1, policy.Underline1);
		waitForElementToAppear(BordereauPage.DraftBtn,5);
		verifyExists(BordereauPage.DraftBtn,"Draft Status Button");
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		BordereauPage.SubmitBordereaux(subSheet);
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3770Path = fpath+"\\src\\test\\resources\\testdata\\Converting symbol multipliers to numbers_TC_3770.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3770Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Converting symbol multipliers to numbers_TC_3770.xlsx\",\"UniqueFileName\":\"S27266120171114.xlsx\",\"BordereauFormatId\":\"5cd7b758-13d6-4a68-8e7d-13792d2b47a5\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S27266120171114.xlsx\",\"Filesize\":17833,\"Path\":null,\"size\":17833,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";	
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauPage.refreshUploadedFile();

		if(isVisible(BordereauPage.ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			BordereauPage.openDATALink();
			BordereauPage.navigateToDATARiskTab();
			mouseOverAction(NetPremiumColumn);
			verifyMustExists(NetPremiumColumn,"Net Premium column");
			mouseOverAction(NetPremiumrow1);
			verifyMustExists(NetPremiumrow1,"Net Premium first row"); 
			String ActualFirstRow1 = getTextFrom(NetPremiumrow1);

			sleep(2000);
			if(ActualFirstRow1.equals(ExpectedFirstRow))
			{
				Report.LogInfo("ValidateFirstRow", "First Row validate successfully", "PASS");	
			}
			else
			{
				Report.LogInfo("ValidateFirstRow", "First Row not validate successfully", "Fail");
			}

			verifyMustExists(NetPremiumrow2,"Net Premium Second row"); 
			String ActualFirstRow2 = getTextFrom(NetPremiumrow2);
			sleep(2000);
			if(ActualFirstRow2.equals(ExpectedSecondRow))
			{
				Report.LogInfo("ValidateSeondRow", "Second Row validate successfully", "PASS");	
			}
			else
			{
				Report.LogInfo("ValidateSecondRow", "second Row not validate successfully", "Fail");
			}

			verifyMustExists(NetPremiumrow3,"Net Premium Third row"); 
			String ActualFirstRow3 = getTextFrom(NetPremiumrow3);
			sleep(2000);
			if(ActualFirstRow3.equals(ExpectedThirdRow))
			{
				Report.LogInfo("ValidateThirdRow", "Third Row validate successfully", "PASS");	
			}
			else
			{
				Report.LogInfo("ValidateThirdRow", "Third Row not validate successfully", "Fail");
			}

		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status Not displayed.", "Fail");
			BordereauPage.deleteBorderEAUX();
		}


	}
}
