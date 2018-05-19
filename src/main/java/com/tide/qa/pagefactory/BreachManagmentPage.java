package com.tide.qa.pagefactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
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
import com.tide.qa.pagefactory.ReportingChannel;

public class BreachManagmentPage extends PageBase{

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BordereauQuePage BQue = new BordereauQuePage();
	BordereauProcessPage Br = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();

	public static String sheet5127Path = "";
	public static String sheet5128Path = "";
	public static String sheet5128PathScnd = "";
	public static String sheet5129Path = "";
	public static final String RiskRefranceA2 = "@xpath=//td[@title='RiskReference_Mapped'][1]//a[@ng-click='openRiskReference(dataItem)'][text()='2']";
	public static final String RiskRefranceA1 = "@xpath=//td[@title='RiskReference_Mapped'][1]//a[@ng-click='openRiskReference(dataItem)'][text()='1']";
	public static final String RiskRefranceA3 = "@xpath=//td[@title='RiskReference_Mapped'][1]//a[@ng-click='openRiskReference(dataItem)'][text()='3']";
	public static final String BreachCount = "@xpath=//span[contains(text(),'1 - 3 of 3 items')]";	
	public static final String StringBreachRiskTab =  "@xpath=//li[2]/a[contains(.,'Risk')]";
	public static final String CurrentEntry =  "@xpath=//*[@id='grid']//td[text()='Current']";
	//Locators for TC-5127
	public static final String RuleHeaderLink = "@xpath=//a[text()='RULES']";

	public void NoChangeToExistngBreach_5127() throws Exception{
		String IncDate = "01/01/2017";
		String ExpDate = "31/12/2017";
		String MonthDate = "April 2017";
		//String payload = "{\"Bordereaux\":{\"ContractId\":\"830c9438-85a5-4162-b5c8-30b9e73fb075\",\"Id\":\"0\",\"BordereauMonth\":4,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"PolicyId\":\"0\",\"OriginalFileName\":\"January 2017_CancelProcessing_3452.xlsx\",\"UniqueFileName\":\"S11726320171010.xlsx\",\"BordereauFormatId\":\"f3d9edd1-9335-4e0c-bc14-b7dcc6f3771f\",\"IsPolicyRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S11726320171010.xlsx\",\"Filesize\":25020,\"Path\":null,\"size\":25020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauPolicy\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		//Step 1
		policy.addPolicy2(IncDate,ExpDate);
		String contractId = ReturnContractID();
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();

		//Step 2
		policy.navigateRulesTab();
		verifyMustExists(policy.AddRulesBtn,"Add Rule button");
		click(policy.AddRulesBtn,"Add Rule button");
		waitForElementToAppear(policy.AddRulesPopup,5);
		verifyMustExists(policy.AddRulesPopup,"Add Rules popup");
		verifyMustExists(policy.RuleNameTxt,"Rules Name textbox");
		sendKeys(policy.RuleNameTxt,"Gross Premium less than 400 is valid","Rules Name");
		SelectDropDownValue(policy.DatasetTypeDD,policy.RiskValue);
		SelectDropDownValue(policy.ApplicationConditionDD,policy.ConditionMetValue);
		SelectDropDownValue(policy.CurrencyDD,policy.ContractCurrencyDrpDownValue1);
		verifyMustExists(policy.ROEToleranceTxt,"ROE Tolerance textbox");
		sendKeys(policy.ROEToleranceTxt,"4","ROE Tolerance textbox");

		WebElement Section = webDriver.findElement(By.xpath("//dt//span[contains(.,'Applicable Section')]//following::input[1]"));
		Actions a = new Actions(webDriver);
		sleep(1000);
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.BACK_SPACE).build().perform();
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.ENTER).build().perform();
		sleep(1000);

		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		scrollDown();
		SelectDropDownValue(policy.FieldNameDD,policy.GrossPreVal);
		SelectDropDownValue(policy.OperatorDD,policy.LessThan);
		SelectDropDownValue(policy.AppliedToDD,policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,"500","Entry Or Selection textbox");
		verifyMustExists(policy.CheckBtn,"Check button");
		click(policy.CheckBtn,"Check button");
		sleep(2000);

		waitForElementToAppear(policy.SaveBtn,5);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");
		sleep(2000);
		if(isVisible(policy.ConEndrsmntPopUp) == true)
		{
			sleep(1000);
			verifyExists(policy.SaveBtn3,"Save Button");
			click(policy.SaveBtn3,"Save Button");
			sleep(3000);
		}

		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		scrollUp();
		Br.SubmitBordereauxWithYesnoButtons(MonthDate);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet5127Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC5127.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet5127Path); 

		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC5127.xlsx\",\"UniqueFileName\":\"S16806520180220.xlsx\",\"BordereauFormatId\":\"dd7607a8-5fe7-4565-b28b-960cb2f53a8b\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S16806520180220.xlsx\",\"Filesize\":18312,\"Path\":null,\"size\":18312,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		Br.refreshUploadedFile();
		if(isVisible(Br.ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			verifyMustExists(Br.ReviewBtn,"Review button");
			click(Br.ReviewBtn,"Review button");
			waitForElementToAppear(Br.SuRcdAssmnt,5);
			verifyMustExists(Br.SuRcdAssmnt,"Submit recor for Assignment button");
			click(Br.SuRcdAssmnt,"Submit recor for Assignment button");
			waitForElementToAppear(Br.FrApprovalbtn,5);
			verifyMustExists(Br.FrApprovalbtn,"For Approval button");
			click(Br.FrApprovalbtn,"For Approval button");
			Br.clickOnApproveBordBtn();
			Br.refreshUploadedFileApprovedStatus();
			if(isVisible(Br.Approvedbtn)==true)
			{
				Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
				Report.LogInfo("StepsCheck", "Step 3 completed", "PASS");
				policy.navigateRulesTab();
				policy.navigateBreachesTab();
				waitForElementToAppear(policy.RulesDD,3);
				verifyMustExists(policy.RulesDD,"Rules Drop Down");
				SelectDropDownValue(policy.RulesDD,policy.RulesDDValue1);
				sleep(2000);
				verifyExists(Br.RiskRefrance,"Referance value 3");

				policy.navigateRulesTab();
				verifyMustExists(policy.EditRulesBtn,"Edit Rule button");
				click(policy.EditRulesBtn,"Edit Rule button");
				waitForElementToAppear(policy.AddRulesPopup,5);
				verifyMustExists(policy.RuleNameTxt,"Rules Name textbox");
				sendKeys(policy.RuleNameTxt,"Data is valid if the rule condition is met","Rules Name");

				waitForElementToAppear(policy.EditCondition,5);
				verifyExists(policy.EditCondition,"Edit condition button");
				click(policy.EditCondition,"Edit condition button");
				sleep(2000);
				verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
				sendKeys(policy.EntryOrSelectionTxt ,"400","Entry Or Selection textbox");
				verifyMustExists(policy.CheckBtn,"Check button");
				click(policy.CheckBtn,"Check button");
				sleep(2000);

				waitForElementToAppear(policy.SaveBtn,5);
				verifyMustExists(policy.SaveBtn,"Save button");
				click(policy.SaveBtn,"Save button");
				sleep(2000);
				if(isVisible(policy.ConEndrsmntPopUp) == true)
				{
					sleep(1000);
					verifyExists(policy.SaveBtn3,"Save Button");
					click(policy.SaveBtn3,"Save Button");
					sleep(3000);
				}

				policy.navigateBreachesTab();
				waitForElementToAppear(policy.RulesDD,3);
				verifyMustExists(policy.RulesDD,"Rules Drop Down");
				SelectDropDownValue(policy.RulesDD,policy.RulesDDValue2);
				sleep(2000);
				verifyExists(Br.RiskRefrance,"Referance value 3");

			}
		}else{
			Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
		}
	}


	public void UpdateToExistngBreach_5128() throws Exception{

		String IncDate = "01/01/2017";
		String ExpDate = "31/12/2017";
		String MonthDate = "April 2017";
		//String payload = "{\"Bordereaux\":{\"ContractId\":\"830c9438-85a5-4162-b5c8-30b9e73fb075\",\"Id\":\"0\",\"BordereauMonth\":4,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"PolicyId\":\"0\",\"OriginalFileName\":\"January 2017_CancelProcessing_3452.xlsx\",\"UniqueFileName\":\"S11726320171010.xlsx\",\"BordereauFormatId\":\"f3d9edd1-9335-4e0c-bc14-b7dcc6f3771f\",\"IsPolicyRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S11726320171010.xlsx\",\"Filesize\":25020,\"Path\":null,\"size\":25020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauPolicy\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		//Step 1
		policy.addPolicy2(IncDate,ExpDate);
		String contractId = ReturnContractID();
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();

		//Step 2
		policy.navigateRulesTab();
		verifyMustExists(policy.AddRulesBtn,"Add Rule button");
		click(policy.AddRulesBtn,"Add Rule button");
		waitForElementToAppear(policy.AddRulesPopup,5);
		verifyMustExists(policy.AddRulesPopup,"Add Rules popup");
		verifyMustExists(policy.RuleNameTxt,"Rules Name textbox");
		sendKeys(policy.RuleNameTxt,"Gross Premium less than 400 is valid","Rules Name");
		SelectDropDownValue(policy.DatasetTypeDD,policy.RiskValue);
		SelectDropDownValue(policy.ApplicationConditionDD,policy.ConditionMetValue);
		SelectDropDownValue(policy.CurrencyDD,policy.ContractCurrencyDrpDownValue1);
		verifyMustExists(policy.ROEToleranceTxt,"ROE Tolerance textbox");
		sendKeys(policy.ROEToleranceTxt,"4","ROE Tolerance textbox");

		WebElement Section = webDriver.findElement(By.xpath("//dt//span[contains(.,'Applicable Section')]//following::input[1]"));
		Actions a = new Actions(webDriver);
		sleep(1000);
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.BACK_SPACE).build().perform();
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.ENTER).build().perform();
		sleep(1000);

		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		scrollDown();
		SelectDropDownValue(policy.FieldNameDD,policy.GrossPreVal);
		SelectDropDownValue(policy.OperatorDD,policy.LessThan);
		SelectDropDownValue(policy.AppliedToDD,policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,"400","Entry Or Selection textbox");
		verifyMustExists(policy.CheckBtn,"Check button");
		click(policy.CheckBtn,"Check button");
		sleep(2000);

		waitForElementToAppear(policy.SaveBtn,5);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");
		sleep(2000);
		if(isVisible(policy.ConEndrsmntPopUp) == true)
		{
			sleep(1000);
			verifyExists(policy.SaveBtn3,"Save Button");
			click(policy.SaveBtn3,"Save Button");
			sleep(3000);
		}

		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		scrollUp();
		Br.SubmitBordereauxWithYesnoButtons(MonthDate);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet5128Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_5128.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet5128Path); 

		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_5128.xlsx\",\"UniqueFileName\":\"S61043020180221.xlsx\",\"BordereauFormatId\":\"dd7607a8-5fe7-4565-b28b-960cb2f53a8b\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S61043020180221.xlsx\",\"Filesize\":18312,\"Path\":null,\"size\":18312,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		Br.refreshUploadedFile();
		if(isVisible(Br.ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			verifyMustExists(Br.ReviewBtn,"Review button");
			click(Br.ReviewBtn,"Review button");
			waitForElementToAppear(Br.SuRcdAssmnt,5);
			verifyMustExists(Br.SuRcdAssmnt,"Submit recor for Assignment button");
			click(Br.SuRcdAssmnt,"Submit recor for Assignment button");
			waitForElementToAppear(Br.FrApprovalbtn,5);
			verifyMustExists(Br.FrApprovalbtn,"For Approval button");
			click(Br.FrApprovalbtn,"For Approval button");
			Br.clickOnApproveBordBtn();
			Br.refreshUploadedFileForApprovedScndRw();
			if(isVisible(Br.Approvedbtn)==true)
			{
				Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
				Report.LogInfo("StepsCheck", "Step 3 completed", "PASS");
				policy.navigateRulesTab();
				policy.navigateBreachesTab();
				waitForElementToAppear(policy.RulesDD,3);
				verifyMustExists(policy.RulesDD,"Rules Drop Down");
				SelectDropDownValue(policy.RulesDD,policy.RulesDDValue1);
				sleep(2000);				

				verifyExists(Br.RiskRefrance,"Referance value 3");
				verifyExists(Br.RiskRefrance2,"Referance value 2");

				Br.SubmitBordereauxWithYesnoButtons(MonthDate);
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet5128PathScnd = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC5128_Scnd.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File excelFile1 = new File(sheet5128PathScnd); 

				//System.out.println(contractId);
				String payload1 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC5128_Scnd.xlsx\",\"UniqueFileName\":\"S26665420180221.xlsx\",\"BordereauFormatId\":\"dd7607a8-5fe7-4565-b28b-960cb2f53a8b\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S26665420180221.xlsx\",\"Filesize\":17830,\"Path\":null,\"size\":17830,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

				uploadFile(ReqUrl, excelFile1, payload1, DraftUrl);
				Br.refreshUploadedFile();

				if(isVisible(Br.ReviewBtn)==true){
					Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
					sleep(2000);
					verifyMustExists(Br.ReviewBtn,"Review button");
					click(Br.ReviewBtn,"Review button");
					waitForElementToAppear(Br.SuRcdAssmnt,5);
					verifyMustExists(Br.SuRcdAssmnt,"Submit recor for Assignment button");
					click(Br.SuRcdAssmnt,"Submit recor for Assignment button");
					waitForElementToAppear(Br.FrApprovalbtn,5);
					verifyMustExists(Br.FrApprovalbtn,"For Approval button");
					click(Br.FrApprovalbtn,"For Approval button");
					Br.clickOnApproveBordBtn();
					Br.refreshUploadedFileApprovedStatus();
					if(isVisible(Br.Approvedbtn)==true)
					{
						Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
						Report.LogInfo("StepsCheck", "Step 3 completed", "PASS");
						policy.navigateRulesTab();
						policy.navigateBreachesTab();
						waitForElementToAppear(policy.RulesDD,3);
						verifyMustExists(policy.RulesDD,"Rules Drop Down");
						SelectDropDownValue(policy.RulesDD,policy.RulesDDValue1);
						sleep(2000);
						verifyExists(Br.RiskRefrance,"Referance value 3");
				     	verifyExists(Br.RiskRefrance2,"Referance value 2");
						verifyExists(Br.Version1,"Version 1 row");
						verifyExists(Br.Version2,"Verison 2 second");
						verifyExists(Br.RuleConditionExists,"Validate Rule condition");
						

					}else{
						Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
					}
				}else{
					Report.LogInfo("ValidateReviewStatus", "Review Status not displayed.", "FAIL");
				}					
			}
		}else{
			Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
		}
	}


	public void AchiveOfPreviousBreach_5129() throws Exception{

		String IncDate = "01/01/2017";
		String ExpDate = "31/12/2017";
		String MonthDate = "April 2017";
		//String payload = "{\"Bordereaux\":{\"ContractId\":\"830c9438-85a5-4162-b5c8-30b9e73fb075\",\"Id\":\"0\",\"BordereauMonth\":4,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"PolicyId\":\"0\",\"OriginalFileName\":\"January 2017_CancelProcessing_3452.xlsx\",\"UniqueFileName\":\"S11726320171010.xlsx\",\"BordereauFormatId\":\"f3d9edd1-9335-4e0c-bc14-b7dcc6f3771f\",\"IsPolicyRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S11726320171010.xlsx\",\"Filesize\":25020,\"Path\":null,\"size\":25020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauPolicy\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		//Step 1
		policy.addPolicy2(IncDate,ExpDate);
		String contractId = ReturnContractID();
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();

		//Step 2
		policy.navigateRulesTab();
		verifyMustExists(policy.AddRulesBtn,"Add Rule button");
		click(policy.AddRulesBtn,"Add Rule button");
		waitForElementToAppear(policy.AddRulesPopup,5);
		verifyMustExists(policy.AddRulesPopup,"Add Rules popup");
		verifyMustExists(policy.RuleNameTxt,"Rules Name textbox");
		sendKeys(policy.RuleNameTxt,"Risk country equals to united states","Rules Name");
		SelectDropDownValue(policy.DatasetTypeDD,policy.RiskValue);
		SelectDropDownValue(policy.ApplicationConditionDD,policy.ConditionMetValue);
		SelectDropDownValue(policy.CurrencyDD,policy.ContractCurrencyDrpDownValue1);
		verifyMustExists(policy.ROEToleranceTxt,"ROE Tolerance textbox");
		sendKeys(policy.ROEToleranceTxt,"4","ROE Tolerance textbox");

		WebElement Section = webDriver.findElement(By.xpath("//dt//span[contains(.,'Applicable Section')]//following::input[1]"));
		Actions a = new Actions(webDriver);
		sleep(1000);
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.BACK_SPACE).build().perform();
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.ENTER).build().perform();
		sleep(1000);

		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		scrollDown();
		SelectDropDownValue(policy.FieldNameDD,policy.RiskCountryVal);
		SelectDropDownValue(policy.OperatorDD,policy.EqualToValue);
		SelectDropDownValue(policy.AppliedToDD,policy.Value);
		SelectDropDownValue(policy.EntryOrSelectionDD,policy.EntryOrSelectionValueUS);
		verifyMustExists(policy.CheckBtn,"Check button");
		click(policy.CheckBtn,"Check button");
		sleep(2000);

		waitForElementToAppear(policy.SaveBtn,5);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");
		sleep(2000);
		if(isVisible(policy.ConEndrsmntPopUp) == true)
		{
			sleep(1000);
			verifyExists(policy.SaveBtn3,"Save Button");
			click(policy.SaveBtn3,"Save Button");
			sleep(3000);
		}
		
		sleep(2000);
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		scrollUp();
		Br.SubmitBordereauxWithYesnoButtons(MonthDate);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet5129Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC5129.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet5129Path); 

		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC5129.xlsx\",\"UniqueFileName\":\"S43237820180222.xlsx\",\"BordereauFormatId\":\"93f99891-5ddb-4afe-b363-fce57e73eea3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S43237820180222.xlsx\",\"Filesize\":18327,\"Path\":null,\"size\":18327,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		Br.refreshUploadedFile();
		if(isVisible(Br.ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			verifyMustExists(Br.ReviewBtn,"Review button");
			click(Br.ReviewBtn,"Review button");
			waitForElementToAppear(Br.SuRcdAssmnt,5);
			verifyMustExists(Br.SuRcdAssmnt,"Submit recor for Assignment button");
			click(Br.SuRcdAssmnt,"Submit recor for Assignment button");
			waitForElementToAppear(Br.FrApprovalbtn,5);
			verifyMustExists(Br.FrApprovalbtn,"For Approval button");
			click(Br.FrApprovalbtn,"For Approval button");
			Br.clickOnApproveBordBtn();
			Br.refreshUploadedFileForApproved();
			if(isVisible(Br.Approvedbtn)==true)
			{
				Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
				Report.LogInfo("StepsCheck", "Step 3 completed", "PASS");
				policy.navigateRulesTab();
				policy.navigateBreachesTab();
				waitForElementToAppear(policy.RulesDD,3);
				verifyMustExists(policy.RulesDD,"Rules Drop Down");
				SelectDropDownValue(policy.RulesDD,policy.RulesDDValue3);
				sleep(2000);				

				verifyExists(Br.RiskRefrance,"Referance value 3");
				
				sleep(2000);
				policy.navigateRulesTab();

				verifyMustExists(policy.EditRulesBtn,"Edit Rule button");
				click(policy.EditRulesBtn,"Edit Rule button");
				waitForElementToAppear(policy.AddRulesPopup,5);
				
				waitForElementToAppear(policy.EditCondition,5);
				verifyExists(policy.EditCondition,"Edit condition button");
				click(policy.EditCondition,"Edit condition button");
				sleep(2000);
				scrollDown();
				SelectDropDownValue(policy.EntryOrSelectionDD,policy.EntryOrSelectionValueUK);
				verifyMustExists(policy.CheckBtn,"Check button");
				click(policy.CheckBtn,"Check button");
				sleep(2000);

				waitForElementToAppear(policy.SaveBtn,5);
				verifyMustExists(policy.SaveBtn,"Save button");
				click(policy.SaveBtn,"Save button");
				sleep(2000);
				if(isVisible(policy.ConEndrsmntPopUp) == true)
				{
					sleep(1000);
					verifyExists(policy.SaveBtn3,"Save Button");
					click(policy.SaveBtn3,"Save Button");
					sleep(3000);
				}
				
				sleep(10000);
				scrollUp();
				policy.navigateBreachesTab();
				sleep(10000);
				waitForElementToAppear(policy.RulesDD,3);
				verifyMustExists(policy.RulesDD,"Rules Drop Down");
				SelectDropDownValue(policy.RulesDD,policy.RulesDDValue3);
				sleep(2000);
				waitForElementToAppear(BreachCount,3);
				verifyMustExists(BreachCount,"Breach count equal to 3");
				verifyMustExists(RiskRefranceA2, "Risk reference 2 exists");
				verifyMustExists(RiskRefranceA1,"Risk reference 1 exists");
				verifyMustExists(RiskRefranceA3,"Risk reference 3 exists");
				if(isVisible(Br.RiskRefrance)==true)
				{
					Report.LogInfo("RecordCheck", "Referance record archive.", "PASS");
				}else{
					Report.LogInfo("RecordCheck", "Referance record not archive.", "Fail");
				}
				
					
			}else{
				Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
			}
		}else{
			Report.LogInfo("ReviewStatus", "Review Status not displayed.", "FAIL");
		}
		click(Br.RiskRefrance,"Click on risk reference");
		verifyMustExists(StringBreachRiskTab, "Navigated to risk Tab");
		verifyMustExists(CurrentEntry, "Verify current entry exists");
		
	}

	//---------------------------Reusable functions for 'Rules'------------------------------------------------------//
	//================================================================================================================//


}





