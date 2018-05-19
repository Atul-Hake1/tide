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

public class ContractEndoEffectiveDatePage extends PageBase{

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BordereauQuePage BQue = new BordereauQuePage();
	BordereauProcessPage Br = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();

	public static String sheet5150Path = "";
	public static String sheet5151Path = "";
	public static String sheet5152Path = "";
	

	//Locators for TC-5127
	public static final String RuleHeaderLink = "@xpath=//a[text()='RULES']";

	public void CreateConEffectvdate_5150() throws Exception{
	
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
		sendKeys(policy.RuleNameTxt,"Number of stories Equals to 55","Rules Name");
		SelectDropDownValue(policy.DatasetTypeDD,policy.RiskValue);
		SelectDropDownValue(policy.ApplicationConditionDD,policy.ConditionMetValue);
		SelectDropDownValue(policy.CurrencyDD,policy.ContractCurrencyDrpDownValue2);
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
		SelectDropDownValue(policy.FieldNameDD,policy.NoOfStoriesVal);
		SelectDropDownValue(policy.OperatorDD,policy.EqualToValue);
		SelectDropDownValue(policy.AppliedToDD,policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,"55","Entry Or Selection textbox");
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
		}else{
			Report.LogInfo("PopUpCheck", "Endorsment pop up not available.", "FAIL");
		}
				
		sleep(2000);
		scrollUp();
		Br.SubmitBordereauxWithYesnoButtons(MonthDate);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet5150Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_5150.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet5150Path); 

		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_5150.xlsx\",\"UniqueFileName\":\"S99612120180222.xlsx\",\"BordereauFormatId\":\"e1f3d92f-bd74-4e8a-b3c2-2eb5f4d3bb9c\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S99612120180222.xlsx\",\"Filesize\":24671,\"Path\":null,\"size\":24671,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

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
				SelectDropDownValue(policy.RulesDD,policy.RulesDDValue4);
				sleep(2000);
				/*verifyExists(Br.RiskRefrance,"Referance value 3");*/
				
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
				verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
				sendKeys(policy.EntryOrSelectionTxt ,"50","Entry Or Selection textbox");
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
					verifyExists(policy.DatePicker,"Date picker");
					sendKeys(policy.DatePicker,"09/09/2017","Effective date");
					sleep(1000);
					verifyExists(policy.SaveBtn3,"Save Button");
					click(policy.SaveBtn3,"Save Button");
					sleep(10000);
					scrollUp();
					sleep(10000);
					policy.navigateBreachesTab();
					waitForElementToAppear(policy.RulesDD,3);
					verifyMustExists(policy.RulesDD,"Rules Drop Down");
					SelectDropDownValue(policy.RulesDD,policy.RulesDDValue4);
					sleep(2000);
					verifyExists(policy.RecordCont4,"record count 4");
					
				}else{
					Report.LogInfo("PopUpCheck", "Endorsment pop up not available.", "FAIL");
				}				
				
			}else{
				Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
			}
		}else{
			Report.LogInfo("ReviewStatus", "Review Status not displayed.", "FAIL");
		}

	}
	
	
	public void CreateConEffectvdatePastNtIncptnDate_5151() throws Exception{
		
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
		sendKeys(policy.RuleNameTxt,"sprinkler equal to no","Rules Name");
		SelectDropDownValue(policy.DatasetTypeDD,policy.RiskValue);
		SelectDropDownValue(policy.ApplicationConditionDD,policy.ConditionNotMetValue);
		SelectDropDownValue(policy.CurrencyDD,policy.CurrencyGBPValue);
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
		SelectDropDownValue(policy.FieldNameDD,policy.LocSprinklrVal);
		SelectDropDownValue(policy.OperatorDD,policy.EqualToValue);
		SelectDropDownValue(policy.AppliedToDD,policy.Value);
		SelectDropDownValue(policy.EntryOrSelectionDD,policy.EntryOrSelectionValue);
	
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
		}else{
			Report.LogInfo("PopUpCheck", "Endorsment pop up not available.", "FAIL");
		}
	
		sleep(2000);
		scrollUp();
		Br.SubmitBordereauxWithYesnoButtons(MonthDate);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet5151Path = fpath+"\\src\\test\\resources\\testdata\\Training Case 1 - January 2_TC_5151.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet5151Path); 

		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Training Case 1 - January 2_TC_5151.xlsx\",\"UniqueFileName\":\"S77176520180222.xlsx\",\"BordereauFormatId\":\"e1f3d92f-bd74-4e8a-b3c2-2eb5f4d3bb9c\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S77176520180222.xlsx\",\"Filesize\":18340,\"Path\":null,\"size\":18340,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		Br.refreshUploadedFile();
		
		if(Br.checkErrorReviewButton(Br.ReviewError) == true){
			sleep(2000);
			if(isVisible(Br.ContinueProc)==true){
			verifyExists(Br.ContinueProc,"Continue processing");
			click(Br.ContinueProc,"Continue processing");
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
					waitForElementToAppear(policy.EditRulesBtn,5);
					verifyMustExists(policy.EditRulesBtn,"Edit Rule button");
					click(policy.EditRulesBtn,"Edit Rule button");
					waitForElementToAppear(policy.AddRulesPopup,5);
					scrollDown();
					waitForElementToAppear(policy.EditCondition,5);
					verifyExists(policy.EditCondition,"Edit condition button");
					click(policy.EditCondition,"Edit condition button");
					sleep(2000);
					SelectDropDownValue(policy.EntryOrSelectionDD,policy.EntryOrSelectionValueYes);
					
					verifyMustExists(policy.CheckBtn,"Check button");
					click(policy.CheckBtn,"Check button");
					waitForElementToAppear(policy.SaveBtn,5);
					verifyMustExists(policy.SaveBtn,"Save button");
					click(policy.SaveBtn,"Save button");
					sleep(2000);
					if(isVisible(policy.ConEndrsmntPopUp) == true)
					{							
						sleep(1000);
						verifyExists(policy.DatePicker,"Date picker");
						sendKeys(policy.DatePicker,"02/02/2017","Effective date");
						sleep(1000);
						verifyExists(policy.SaveBtn3,"Save Button");
						click(policy.SaveBtn3,"Save Button");
						sleep(3000);
						scrollUp();
						policy.navigateBreachesTab();
						waitForElementToAppear(policy.RulesDD,3);
						verifyMustExists(policy.RulesDD,"Rules Drop Down");
						SelectDropDownValue(policy.RulesDD,policy.RulesDDValue3);
						sleep(2000);
						verifyExists(policy.RecordCont2,"record count 2");
					}else{
						Report.LogInfo("PopUpCheck", "Endorsment pop up not available.", "FAIL");
					}					
					
				}else{
					Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
					}
				}else{
					Report.LogInfo("ReviewStatus", "Review Status not displayed.", "FAIL");
				}
			
			}else{
				Report.LogInfo("ScreenCheck", "Expected screen not displayed.", "FAIL");
			}			
		}else{
			Report.LogInfo("ReviewErrorStatus", "Review Error status not displayed.", "FAIL");
		}	

	}
	
	
	public void CreateConEffectvdateEqualsIncptnDate_5152() throws Exception{
		
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
		sendKeys(policy.RuleNameTxt,"Risk Currency Equal to GBP","Rules Name");
		SelectDropDownValue(policy.DatasetTypeDD,policy.RiskValue);
		SelectDropDownValue(policy.ApplicationConditionDD,policy.ConditionMetValue);
		SelectDropDownValue(policy.CurrencyDD,policy.ContractCurrencyDrpDownValue2);
		verifyMustExists(policy.ROEToleranceTxt,"ROE Tolerance textbox");
		sendKeys(policy.ROEToleranceTxt,"6","ROE Tolerance textbox");

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
		SelectDropDownValue(policy.FieldNameDD,policy.RiskCurrencyVal);
		SelectDropDownValue(policy.OperatorDD,policy.EqualToValue);
		SelectDropDownValue(policy.AppliedToDD,policy.Value);
		SelectDropDownValue(policy.EntryOrSelectionDD,policy.CurrencyGBPValue1);
	
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
		}else{
			Report.LogInfo("PopUpCheck", "Endorsment pop up not available.", "FAIL");
		}
	
		sleep(2000);
		scrollUp();
		Br.SubmitBordereauxWithYesnoButtons(MonthDate);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet5152Path = fpath+"\\src\\test\\resources\\testdata\\January 2017 TC_5152.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet5152Path); 

		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017 TC_5152.xlsx\",\"UniqueFileName\":\"S21875820180223.xlsx\",\"BordereauFormatId\":\"e1f3d92f-bd74-4e8a-b3c2-2eb5f4d3bb9c\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S21875820180223.xlsx\",\"Filesize\":24699,\"Path\":null,\"size\":24699,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

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
					SelectDropDownValue(policy.RulesDD,policy.RulesDDValue5);
					sleep(2000);
					verifyExists(policy.RecordCont2,"record count 2");
					
					policy.navigateRulesTab();
					waitForElementToAppear(policy.EditRulesBtn,5);
					verifyMustExists(policy.EditRulesBtn,"Edit Rule button");
					click(policy.EditRulesBtn,"Edit Rule button");
					waitForElementToAppear(policy.AddRulesPopup,5);
					verifyMustExists(policy.RuleNameTxt,"Rules Name textbox");
					sendKeys(policy.RuleNameTxt,"Risk Currency Equal to USD","Rules Name");				
					scrollDown();
					waitForElementToAppear(policy.EditCondition,5);
					verifyExists(policy.EditCondition,"Edit condition button");
					click(policy.EditCondition,"Edit condition button");
					sleep(2000);
					SelectDropDownValue(policy.EntryOrSelectionDD,policy.CurrencyUSDValue);
					verifyMustExists(policy.CheckBtn,"Check button");
					click(policy.CheckBtn,"Check button");
					waitForElementToAppear(policy.SaveBtn,5);
					verifyMustExists(policy.SaveBtn,"Save button");
					click(policy.SaveBtn,"Save button");
					sleep(2000);
					if(isVisible(policy.ConEndrsmntPopUp) == true)
					{							
						sleep(1000);
						verifyExists(policy.DatePicker,"Date picker");
						sendKeys(policy.DatePicker,"01/01/2017","Effective date");
						sleep(1000);
						verifyExists(policy.SaveBtn3,"Save Button");
						click(policy.SaveBtn3,"Save Button");
						sleep(3000);
						scrollUp();
						policy.navigateBreachesTab();
						waitForElementToAppear(policy.RulesDD,3);
						verifyMustExists(policy.RulesDD,"Rules Drop Down");
						SelectDropDownValue(policy.RulesDD,policy.RulesDDValue6);
						sleep(2000);
						verifyExists(policy.RecordCont3,"record count 3");
					}else{
						Report.LogInfo("PopUpCheck", "Endorsment pop up not available.", "FAIL");
					}					
					
				}else{
					Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
					}
				}else{
					Report.LogInfo("ReviewStatus", "Review Status not displayed.", "FAIL");
				}			

	}
	
	

	//---------------------------Reusable functions for 'Rules'------------------------------------------------------//
	//================================================================================================================//


}





