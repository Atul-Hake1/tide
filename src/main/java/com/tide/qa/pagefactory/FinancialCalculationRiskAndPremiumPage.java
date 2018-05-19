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

public class FinancialCalculationRiskAndPremiumPage extends PageBase{
	LoginPage loginPage = new LoginPage();
	BordereauQuePage BQPage = new BordereauQuePage();
	BordereauProcessPage BordereauPage = new BordereauProcessPage();
	HomePage homePage = new HomePage();
	DatasetReferenceDataPage datasetPage = new DatasetReferenceDataPage();
	PolicyPage policy = new PolicyPage();
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

	public static String contractId;

	public static String sheet4009Path = "";
	public static String sheet4010Path = "";
	public static String sheet4011Path = "";
	public static String sheet4013Path = "";



	public static final String onlyCurrentIcon="@xpath=//label[text()='Only Current']/../label[2]";
	public static final String typeOfRiskTransaction="@xpath=//*[@ng-model='BFBasicDetails.RiskTransaction']/..";
	public static final String notSuppliedDD="@xpath=//*[@id='RiskTransaction_listbox']/li[1]";

	public void riskAndPremiumForTransactionType_4009() throws Exception{
		String subSheet="Bordereau Process (Automation Schema)";
		String IncDate ="01/01/2017";
		String ExpDate="31/12/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String SubmitSheet="Bordereau Process";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(SubmitSheet);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();

		policy.addPolicy2(IncDate, ExpDate);
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
			sheet4009Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC_4009.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4009Path);  

		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC_4009.xlsx\",\"UniqueFileName\":\"S68191620171118.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S68191620171118.xlsx\",\"Filesize\":19679,\"Path\":null,\"size\":19679,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauPage.refreshUploadedFile();
		if(isVisible(BordereauPage.ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			BordereauPage.openDATALink();
			BordereauPage.navigateToDATARiskTab();
			offOnlycurrentIcon();
			//Row number column 
			String RowNumber="@xpath=//*[@data-field='RowNumber']";
			String RowNumber1="@xpath=//*[@data-field='RowNumber']//following::tr[1]//td[contains(@ng-click,'RowNumber')][text()='2']";
			String RowNumber2="@xpath=//*[@data-field='RowNumber']//following::tr[2]//td[contains(@ng-click,'RowNumber')][text()='3']";
			String RowNumber3="@xpath=//*[@data-field='RowNumber']//following::tr[3]//td[contains(@ng-click,'RowNumber')][text()='4']";
			String RowNumber4="@xpath=//*[@data-field='RowNumber']//following::tr[4]//td[contains(@ng-click,'RowNumber')][text()='4']";			verifyExists(RowNumber1,"1st value");
			verifyExists(RowNumber1,"1st value");
			verifyExists(RowNumber2,"2nd value");
			verifyExists(RowNumber3,"3rd value");
			verifyExists(RowNumber4,"4th value");
			sleep(2000);
			//GrossPremium Including Tax Column 
			String GrossPremiumIncludingTaxcolumn="@xpath=//*[@data-field='Gross_Premium_including_Tax']";
			String GrossPremiumIncludingTax1="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,000.00']";
			String GrossPremiumIncludingTax2="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,000.00']";
			String GrossPremiumIncludingTax3="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='500.00']";
			String GrossPremiumIncludingTax4="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,500.00']";
			waitForElementToAppear(GrossPremiumIncludingTaxcolumn,20);
			mouseOverAction(GrossPremiumIncludingTaxcolumn);
			verifyMustExists(GrossPremiumIncludingTaxcolumn,"Gross Premium Including Tax column");
			sleep(2000);
			verifyExists(GrossPremiumIncludingTax1,"1st value");
			verifyExists(GrossPremiumIncludingTax2,"2nd value");
			verifyExists(GrossPremiumIncludingTax3,"3rd value");
			verifyExists(GrossPremiumIncludingTax4,"4th value");
			sleep(2000);
			//GrossPremium column 
			String GrossPremiumColumn ="@xpath=//*[@data-field='Gross_Premium']";
			String GrossPremium1="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][text()='1,000.00'][2]";
			String GrossPremium2="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][text()='1,000.00'][2]";
			String GrossPremium3="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium')][text()='500.00'][2]";
			String GrossPremium4="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium')][text()='1,500.00'][2]";
			waitForElementToAppear(GrossPremiumColumn,20);
			mouseOverAction(GrossPremiumColumn);
			verifyMustExists(GrossPremiumColumn,"Gross Premium Column");
			sleep(2000);
			verifyExists(GrossPremium1,"1st value");
			verifyExists(GrossPremium2,"2nd value");
			verifyExists(GrossPremium3,"3rd value");
			verifyExists(GrossPremium4,"4th value");
			sleep(2000);
			//Coverholder Commission column 
			String CoverholderCommissioncolumn ="@xpath=//*[@data-field='Coverholder_Commission']";
			String CoverholderCommission1="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
			String CoverholderCommission2="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
			String CoverholderCommission3="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
			String CoverholderCommission4="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission')][text()='1,000.00']";
			waitForElementToAppear(CoverholderCommissioncolumn,20);
			mouseOverAction(CoverholderCommissioncolumn);
			verifyMustExists(CoverholderCommissioncolumn,"Coverholder Commission column");
			sleep(2000);
			verifyExists(CoverholderCommission1,"1st value");
			verifyExists(CoverholderCommission2,"2nd value");
			verifyExists(CoverholderCommission3,"3rd value");
			verifyExists(CoverholderCommission4,"4th value");
			sleep(2000);
			//Net Premium column 
			String NetPremiumcolumn ="@xpath=//*[@data-field='Net_Premium']";
			String NetPremium1="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][text()='2,000.00']";
			String NetPremium2="@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][text()='1,000.00']";
			String NetPremium3="@xpath=//*[@data-field='Net_Premium']//following::tr[3]//td[contains(@ng-click,'Net_Premium')][text()='1,000.00']";
			String NetPremium4="@xpath=//*[@data-field='Net_Premium']//following::tr[4]//td[contains(@ng-click,'Net_Premium')][text()='2,000.00']";
			waitForElementToAppear(NetPremiumcolumn,20);
			mouseOverAction(NetPremiumcolumn);
			verifyMustExists(NetPremiumcolumn,"Net Premium column");
			sleep(2000);
			verifyExists(NetPremium1,"1st value");
			verifyExists(NetPremium2,"2nd value");
			verifyExists(NetPremium3,"3rd value");
			verifyExists(NetPremium4,"4th value");
			sleep(2000);
			//london brokerage column
			String LondonBrokeragecolumn ="@xpath=//*[@data-field='London_Brokerage']";
			String LondonBrokerage1="@xpath=//*[@data-field='London_Brokerage']//following::tr[1]//td[contains(@ng-click,'London_Brokerage')][text()='156.05']";
			String LondonBrokerage2="@xpath=//*[@data-field='London_Brokerage']//following::tr[2]//td[contains(@ng-click,'London_Brokerage')][text()='50.00']";
			String LondonBrokerage3="@xpath=//*[@data-field='London_Brokerage']//following::tr[3]//td[contains(@ng-click,'London_Brokerage')][text()='25.00']";
			String LondonBrokerage4="@xpath=//*[@data-field='London_Brokerage']//following::tr[4]//td[contains(@ng-click,'London_Brokerage')][text()='75.00']";
			waitForElementToAppear(LondonBrokeragecolumn,20);
			mouseOverAction(LondonBrokeragecolumn);
			verifyMustExists(LondonBrokeragecolumn,"London Brokerage column");
			sleep(2000);
			verifyExists(LondonBrokerage1,"1st value");
			verifyExists(LondonBrokerage2,"2nd value");
			verifyExists(LondonBrokerage3,"3rd value");
			verifyExists(LondonBrokerage4,"4th value");
			sleep(2000);
			//Final Net Premium column 
			String FinalNetPremiumcolumn ="@xpath=//*[@data-field='Final_Net_Premium']";
			String FinalNetPremium1="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[1]//td[contains(@ng-click,'Final_Net_Premium')][text()='1,843.95']";
			String FinalNetPremium2="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[2]//td[contains(@ng-click,'Final_Net_Premium')][text()='950.00']";
			String FinalNetPremium3="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[3]//td[contains(@ng-click,'Final_Net_Premium')][text()='975.00']";
			String FinalNetPremium4="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[4]//td[contains(@ng-click,'Final_Net_Premium')][text()='1,925.00']";
			waitForElementToAppear(FinalNetPremiumcolumn,20);
			mouseOverAction(FinalNetPremiumcolumn);
			verifyMustExists(FinalNetPremiumcolumn,"final Net Premium column");
			sleep(2000);
			verifyExists(FinalNetPremium1,"1st value");
			verifyExists(FinalNetPremium2,"2nd value");
			verifyExists(FinalNetPremium3,"3rd value");
			verifyExists(FinalNetPremium4,"4th value");
			sleep(2000);
			policy.navigationOnBordereauxTab();
			BordereauPage.refreshUploadedFile();
			BordereauPage.deleteBorderEAUX();
		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
			BordereauPage.deleteBorderEAUX();
		}

	}


	public void transactionTypeNotSupplied_4010() throws Exception {
		String subSheet="Missing entries as cancellation2 (Automation Schema)";
		String pol="836221AW";
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn,10);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);	
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			//String GetData = Configuration.url+"/api/Contract/GetAllPage";
			//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4010Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC_4010.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4010Path);  
			//contractId = addNewBordereauFormatPolicy(payload1, GetData);
			//String payload="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC_4010.xlsx\",\"UniqueFileName\":\"S21288820171118.xlsx\",\"BordereauFormatId\":\"8aebc949-83c0-4f88-bfb6-db384cd4873d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S21288820171118.xlsx\",\"Filesize\":19693,\"Path\":null,\"size\":19693,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			String payload="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC_4010.xlsx\",\"UniqueFileName\":\"S41268020171128.xlsx\",\"BordereauFormatId\":\"75e77eaa-5b7e-4a80-ba90-b7c4a8c5abed\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S41268020171128.xlsx\",\"Filesize\":19693,\"Path\":null,\"size\":19693,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();
				offOnlycurrentIcon();	
				//GrossPremium Including Tax Column 
				String GrossPremiumIncludingTaxcolumn="@xpath=//*[@data-field='Gross_Premium_including_Tax']";
				String GrossPremiumIncludingTax1="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,000.00']";
				String GrossPremiumIncludingTax2="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='500.00']";
				String GrossPremiumIncludingTax3="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,000.00']";
				String GrossPremiumIncludingTax4="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,500.00']";
				waitForElementToAppear(GrossPremiumIncludingTaxcolumn,20);
				mouseOverAction(GrossPremiumIncludingTaxcolumn);
				verifyMustExists(GrossPremiumIncludingTaxcolumn,"Gross Premium Including Tax column");
				sleep(2000);
				verifyExists(GrossPremiumIncludingTax1,"1st value");
				verifyExists(GrossPremiumIncludingTax2,"2nd value");
				verifyExists(GrossPremiumIncludingTax3,"3rd value");
				verifyExists(GrossPremiumIncludingTax4,"4th value");
				sleep(2000);
				//GrossPremium column 
				String GrossPremiumColumn ="@xpath=//*[@data-field='Gross_Premium']";
				String GrossPremium1="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][text()='1,000.00'][2]";
				String GrossPremium2="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][text()='500.00'][2]";
				String GrossPremium3="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium')][text()='1,000.00'][2]";
				String GrossPremium4="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium')][text()='1,500.00'][2]";
				waitForElementToAppear(GrossPremiumColumn,20);
				mouseOverAction(GrossPremiumColumn);
				verifyMustExists(GrossPremiumColumn,"Gross Premium Column");
				sleep(2000);
				verifyExists(GrossPremium1,"1st value");
				verifyExists(GrossPremium2,"2nd value");
				verifyExists(GrossPremium3,"3rd value");
				verifyExists(GrossPremium4,"4th value");
				sleep(2000);
				//Coverholder Commission column 
				String CoverholderCommissioncolumn ="@xpath=//*[@data-field='Coverholder_Commission']";
				String CoverholderCommission1="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
				String CoverholderCommission2="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
				String CoverholderCommission3="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
				String CoverholderCommission4="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission')][text()='1,000.00']";
				waitForElementToAppear(CoverholderCommissioncolumn,20);
				mouseOverAction(CoverholderCommissioncolumn);
				verifyMustExists(CoverholderCommissioncolumn,"Coverholder Commission column");
				sleep(2000);
				verifyExists(CoverholderCommission1,"1st value");
				verifyExists(CoverholderCommission2,"2nd value");
				verifyExists(CoverholderCommission3,"3rd value");
				verifyExists(CoverholderCommission4,"4th value");
				sleep(2000);
				//Net Premium column 
				String NetPremiumcolumn ="@xpath=//*[@data-field='Net_Premium']";
				String NetPremium1="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][text()='2,000.00']";
				String NetPremium2="@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][text()='1,000.00']";
				String NetPremium3="@xpath=//*[@data-field='Net_Premium']//following::tr[3]//td[contains(@ng-click,'Net_Premium')][text()='1,000.00']";
				String NetPremium4="@xpath=//*[@data-field='Net_Premium']//following::tr[4]//td[contains(@ng-click,'Net_Premium')][text()='2,000.00']";
				waitForElementToAppear(NetPremiumcolumn,20);
				mouseOverAction(NetPremiumcolumn);
				verifyMustExists(NetPremiumcolumn,"Net Premium column");
				sleep(2000);
				verifyExists(NetPremium1,"1st value");
				verifyExists(NetPremium2,"2nd value");
				verifyExists(NetPremium3,"3rd value");
				verifyExists(NetPremium4,"4th value");
				sleep(2000);
				//london brokerage column	 
				String LondonBrokeragecolumn ="@xpath=//*[@data-field='London_Brokerage']";
				String LondonBrokerage1="@xpath=//*[@data-field='London_Brokerage']//following::tr[1]//td[contains(@ng-click,'London_Brokerage')][text()='156.05']";
				String LondonBrokerage2="@xpath=//*[@data-field='London_Brokerage']//following::tr[2]//td[contains(@ng-click,'London_Brokerage')][text()='25.00']";
				String LondonBrokerage3="@xpath=//*[@data-field='London_Brokerage']//following::tr[3]//td[contains(@ng-click,'London_Brokerage')][text()='50.00']";
				String LondonBrokerage4="@xpath=//*[@data-field='London_Brokerage']//following::tr[4]//td[contains(@ng-click,'London_Brokerage')][text()='75.00']";
				waitForElementToAppear(LondonBrokeragecolumn,20);
				mouseOverAction(LondonBrokeragecolumn);
				verifyMustExists(LondonBrokeragecolumn,"London Brokerage column");
				sleep(2000);
				verifyExists(LondonBrokerage1,"1st value");
				verifyExists(LondonBrokerage2,"2nd value");
				verifyExists(LondonBrokerage3,"3rd value");
				verifyExists(LondonBrokerage4,"4th value");
				sleep(2000);
				policy.navigationOnBordereauxTab();
				//BordereauPage.refreshUploadedFile();
				BordereauPage.deleteBorderEAUX();
			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");

		}
	}

	public void finalcialCalculationRESTATEMENT_4011() throws Exception {
		String subSheet="Restatement-Financial calculations (Automation Schema)";
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn,10);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);	
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			//String GetData = Configuration.url+"/api/Contract/GetAllPage";
			//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4011Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC_4011.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4011Path);  
			//contractId = addNewBordereauFormatPolicy(payload1, GetData);
			String payload="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC_4011.xlsx\",\"UniqueFileName\":\"S85010920171119.xlsx\",\"BordereauFormatId\":\"53a5ab00-ef46-4347-a4fb-fcd2ffb91fab\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S85010920171119.xlsx\",\"Filesize\":19679,\"Path\":null,\"size\":19679,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();
				offOnlycurrentIcon();	
				//GrossPremium Including Tax Column 
				String GrossPremiumIncludingTaxcolumn="@xpath=//*[@data-field='Gross_Premium_including_Tax']";
				String GrossPremiumIncludingTax1="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,000.00']";
				String GrossPremiumIncludingTax2="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,000.00']";
				String GrossPremiumIncludingTax3="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='-500.00']";
				String GrossPremiumIncludingTax4="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='500.00']";
				waitForElementToAppear(GrossPremiumIncludingTaxcolumn,20);
				mouseOverAction(GrossPremiumIncludingTaxcolumn);
				verifyMustExists(GrossPremiumIncludingTaxcolumn,"Gross Premium Including Tax column");
				sleep(2000);
				verifyExists(GrossPremiumIncludingTax1,"1st value");
				verifyExists(GrossPremiumIncludingTax2,"2nd value");
				verifyExists(GrossPremiumIncludingTax3,"3rd value");
				verifyExists(GrossPremiumIncludingTax4,"4th value");
				sleep(2000);
				//GrossPremium column 
				String GrossPremiumColumn ="@xpath=//*[@data-field='Gross_Premium']";
				String GrossPremium1="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][text()='1,000.00'][2]";
				String GrossPremium2="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][text()='1,000.00'][2]";
				String GrossPremium3="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium')][text()='-500.00'][2]";
				String GrossPremium4="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium')][text()='500.00'][2]";
				waitForElementToAppear(GrossPremiumColumn,20);
				mouseOverAction(GrossPremiumColumn);
				verifyMustExists(GrossPremiumColumn,"Gross Premium Column");
				sleep(2000);
				verifyExists(GrossPremium1,"1st value");
				verifyExists(GrossPremium2,"2nd value");
				verifyExists(GrossPremium3,"3rd value");
				verifyExists(GrossPremium4,"4th value");
				sleep(2000);
				//Coverholder Commission column 
				String CoverholderCommissioncolumn ="@xpath=//*[@data-field='Coverholder_Commission']";
				String CoverholderCommission1="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
				String CoverholderCommission2="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
				String CoverholderCommission3="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission')][text()='0.00']";
				String CoverholderCommission4="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
				waitForElementToAppear(CoverholderCommissioncolumn,20);
				mouseOverAction(CoverholderCommissioncolumn);
				verifyMustExists(CoverholderCommissioncolumn,"Coverholder Commission column");
				sleep(2000);
				verifyExists(CoverholderCommission1,"1st value");
				verifyExists(CoverholderCommission2,"2nd value");
				verifyExists(CoverholderCommission3,"3rd value");
				verifyExists(CoverholderCommission4,"4th value");
				sleep(2000);
				//Net Premium column 
				String NetPremiumcolumn ="@xpath=//*[@data-field='Net_Premium']";
				String NetPremium1="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][text()='2,000.00']";
				String NetPremium2="@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][text()='1,000.00']";
				String NetPremium3="@xpath=//*[@data-field='Net_Premium']//following::tr[3]//td[contains(@ng-click,'Net_Premium')][text()='0.00']";
				String NetPremium4="@xpath=//*[@data-field='Net_Premium']//following::tr[4]//td[contains(@ng-click,'Net_Premium')][text()='1,000.00']";
				waitForElementToAppear(NetPremiumcolumn,20);
				mouseOverAction(NetPremiumcolumn);
				verifyMustExists(NetPremiumcolumn,"Net Premium column");
				sleep(2000);
				verifyExists(NetPremium1,"1st value");
				verifyExists(NetPremium2,"2nd value");
				verifyExists(NetPremium3,"3rd value");
				verifyExists(NetPremium4,"4th value");
				sleep(2000);
				//Final Net Premium column 
				String FinalNetPremiumcolumn ="@xpath=//*[@data-field='Final_Net_Premium']";
				String FinalNetPremium1="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[1]//td[contains(@ng-click,'Final_Net_Premium')][text()='1,843.95']";
				String FinalNetPremium2="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[2]//td[contains(@ng-click,'Final_Net_Premium')][text()='950.00']";
				String FinalNetPremium3="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[3]//td[contains(@ng-click,'Final_Net_Premium')][text()='25.00']";
				String FinalNetPremium4="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[4]//td[contains(@ng-click,'Final_Net_Premium')][text()='975.00']";
				waitForElementToAppear(FinalNetPremiumcolumn,20);
				mouseOverAction(FinalNetPremiumcolumn);
				verifyMustExists(FinalNetPremiumcolumn,"final Net Premium column");
				sleep(2000);
				verifyExists(FinalNetPremium1,"1st value");
				verifyExists(FinalNetPremium2,"2nd value");
				verifyExists(FinalNetPremium3,"3rd value");
				verifyExists(FinalNetPremium4,"4th value");	

			}
			else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}

	public void riskAndPremiumForReportingtypeRESTATEMENT_4013() throws Exception {
		String subSheet="Restatement-Financial calculations (Automation Schema)";
		String QuestionnaireOnlySpecificText="Restatement-Financial calculations";
		String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+QuestionnaireOnlySpecificText+"')][1]";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire(QuestionnaireOnlySpecificText, SelectQuestionnaire);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		sleep(3000);
		BQPage.nextStapeClick();
		BQPage.nextStapeClick();			
		sleep(2000);
		verifyMustExists(typeOfRiskTransaction,"type of Risk Transaction drop down");
		click(typeOfRiskTransaction,"type of Risk Transaction drop down");
		javaScriptWait();
		verifyMustExists(notSuppliedDD,"Not supplied drop down value");
		click(notSuppliedDD,"Not supplied drop down value");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		verifyMustExists(BQPage.CancelBtn,"Cancel button");
		click(BQPage.CancelBtn,"Cancel button");
		sleep(3000);
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn,10);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			//String GetData = Configuration.url+"/api/Contract/GetAllPage";
			//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4013Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC_4013.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4013Path);  
			//contractId = addNewBordereauFormatPolicy(payload1, GetData);
			//String payload="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC_4013.xlsx\",\"UniqueFileName\":\"S46552320171119.xlsx\",\"BordereauFormatId\":\"53a5ab00-ef46-4347-a4fb-fcd2ffb91fab\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S46552320171119.xlsx\",\"Filesize\":19679,\"Path\":null,\"size\":19679,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			String payload="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC_4013.xlsx\",\"UniqueFileName\":\"S46552320171119.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S46552320171119.xlsx\",\"Filesize\":19679,\"Path\":null,\"size\":19679,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();
				offOnlycurrentIcon();	
				//GrossPremium Including Tax Column 
				String GrossPremiumIncludingTaxcolumn="@xpath=//*[@data-field='Gross_Premium_including_Tax']";
				String GrossPremiumIncludingTax1="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,000.00']";
				String GrossPremiumIncludingTax2="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,000.00']";
				String GrossPremiumIncludingTax3="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='-500.00']";
				String GrossPremiumIncludingTax4="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='500.00']";
				waitForElementToAppear(GrossPremiumIncludingTaxcolumn,20);
				mouseOverAction(GrossPremiumIncludingTaxcolumn);
				verifyMustExists(GrossPremiumIncludingTaxcolumn,"Gross Premium Including Tax column");
				sleep(2000);
				verifyExists(GrossPremiumIncludingTax1,"1st value");
				verifyExists(GrossPremiumIncludingTax2,"2nd value");
				verifyExists(GrossPremiumIncludingTax3,"3rd value");
				verifyExists(GrossPremiumIncludingTax4,"4th value");
				sleep(2000);
				//GrossPremium column 
				String GrossPremiumColumn ="@xpath=//*[@data-field='Gross_Premium']";
				String GrossPremium1="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][text()='1,000.00'][2]";
				String GrossPremium2="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][text()='1,000.00'][2]";
				String GrossPremium3="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium')][text()='-500.00'][2]";
				String GrossPremium4="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium')][text()='500.00'][2]";
				waitForElementToAppear(GrossPremiumColumn,20);
				mouseOverAction(GrossPremiumColumn);
				verifyMustExists(GrossPremiumColumn,"Gross Premium Column");
				sleep(2000);
				verifyExists(GrossPremium1,"1st value");
				verifyExists(GrossPremium2,"2nd value");
				verifyExists(GrossPremium3,"3rd value");
				verifyExists(GrossPremium4,"4th value");
				sleep(2000);
				//Coverholder Commission column 
				String CoverholderCommissioncolumn ="@xpath=//*[@data-field='Coverholder_Commission']";
				String CoverholderCommission1="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
				String CoverholderCommission2="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
				String CoverholderCommission3="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission')][text()='0.00']";
				String CoverholderCommission4="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
				waitForElementToAppear(CoverholderCommissioncolumn,20);
				mouseOverAction(CoverholderCommissioncolumn);
				verifyMustExists(CoverholderCommissioncolumn,"Coverholder Commission column");
				sleep(2000);
				verifyExists(CoverholderCommission1,"1st value");
				verifyExists(CoverholderCommission2,"2nd value");
				verifyExists(CoverholderCommission3,"3rd value");
				verifyExists(CoverholderCommission4,"4th value");
				sleep(2000);
				//Coverholder Commission % column 
				String CoverholderCommissionpercentcolumn ="@xpath=//*[@data-field='Coverholder_Commission_Percent']";
				String CoverholderCommissionpercent1="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='50.00 %']";
				String CoverholderCommissionpercent2="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='50.00 %']";
				String CoverholderCommissionpercent3="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='100.00 %']";
				String CoverholderCommissionpercent4="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='100.00 %']";
				waitForElementToAppear(CoverholderCommissionpercentcolumn,20);
				mouseOverAction(CoverholderCommissionpercentcolumn);
				verifyMustExists(CoverholderCommissionpercentcolumn,"Coverholder Commission percent column");
				sleep(2000);
				verifyExists(CoverholderCommissionpercent1,"1st value");
				verifyExists(CoverholderCommissionpercent2,"2nd value");
				verifyExists(CoverholderCommissionpercent3,"3rd value");
				verifyExists(CoverholderCommissionpercent4,"4th value");
				sleep(2000);
				//Net Premium column  
				String NetPremiumcolumn ="@xpath=//*[@data-field='Net_Premium']";
				String NetPremium1="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][text()='2,000.00']";
				String NetPremium2="@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][text()='1,000.00']";
				String NetPremium3="@xpath=//*[@data-field='Net_Premium']//following::tr[3]//td[contains(@ng-click,'Net_Premium')][text()='0.00']";
				String NetPremium4="@xpath=//*[@data-field='Net_Premium']//following::tr[4]//td[contains(@ng-click,'Net_Premium')][text()='1,000.00']";
				waitForElementToAppear(NetPremiumcolumn,20);
				mouseOverAction(NetPremiumcolumn);
				verifyMustExists(NetPremiumcolumn,"Net Premium column");
				sleep(2000);
				verifyExists(NetPremium1,"1st value");
				verifyExists(NetPremium2,"2nd value");
				verifyExists(NetPremium3,"3rd value");
				verifyExists(NetPremium4,"4th value");
				sleep(2000);
				//london brokerage column
				String LondonBrokeragecolumn ="@xpath=//*[@data-field='London_Brokerage']";
				String LondonBrokerage1="@xpath=//*[@data-field='London_Brokerage']//following::tr[1]//td[contains(@ng-click,'London_Brokerage')][text()='156.05']";
				String LondonBrokerage2="@xpath=//*[@data-field='London_Brokerage']//following::tr[2]//td[contains(@ng-click,'London_Brokerage')][text()='50.00']";
				String LondonBrokerage3="@xpath=//*[@data-field='London_Brokerage']//following::tr[3]//td[contains(@ng-click,'London_Brokerage')][text()='-25.00']";
				String LondonBrokerage4="@xpath=//*[@data-field='London_Brokerage']//following::tr[4]//td[contains(@ng-click,'London_Brokerage')][text()='25.00']";
				waitForElementToAppear(LondonBrokeragecolumn,20);
				mouseOverAction(LondonBrokeragecolumn);
				verifyMustExists(LondonBrokeragecolumn,"London Brokerage column");
				sleep(2000);
				verifyExists(LondonBrokerage1,"1st value");
				verifyExists(LondonBrokerage2,"2nd value");
				verifyExists(LondonBrokerage3,"3rd value");
				verifyExists(LondonBrokerage4,"4th value");
				sleep(2000);	 
				//Final Net Premium column 
				String FinalNetPremiumcolumn ="@xpath=//*[@data-field='Final_Net_Premium']";
				String FinalNetPremium1="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[1]//td[contains(@ng-click,'Final_Net_Premium')][text()='1,843.95']";
				String FinalNetPremium2="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[2]//td[contains(@ng-click,'Final_Net_Premium')][text()='950.00']";
				String FinalNetPremium3="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[3]//td[contains(@ng-click,'Final_Net_Premium')][text()='25.00']";
				String FinalNetPremium4="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[4]//td[contains(@ng-click,'Final_Net_Premium')][text()='975.00']";
				waitForElementToAppear(FinalNetPremiumcolumn,20);
				mouseOverAction(FinalNetPremiumcolumn);
				verifyMustExists(FinalNetPremiumcolumn,"final Net Premium column");
				sleep(2000);
				verifyExists(FinalNetPremium1,"1st value");
				verifyExists(FinalNetPremium2,"2nd value");
				verifyExists(FinalNetPremium3,"3rd value");
				verifyExists(FinalNetPremium4,"4th value");	

			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}


	//=======================================================Reusable function==========================================================================================================//


	public void offOnlycurrentIcon()
	{
		waitForElementToAppear(onlyCurrentIcon,10);
		verifyMustExists(onlyCurrentIcon,"only current Icon");
		click(onlyCurrentIcon,"only current Icon");
		sleep(3000);	
	}	
}
