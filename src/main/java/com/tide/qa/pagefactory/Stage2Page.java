package com.tide.qa.pagefactory;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;

public class Stage2Page extends PageBase{
	LoginPage loginPage = new LoginPage();
	BordereauQuePage BQPage = new BordereauQuePage();
	HomePage homePage = new HomePage();
	PolicyPage policy = new PolicyPage();
	//PolicyPage policy = new PolicyPage();
	BordereauProcessPage BordereauProcess = new BordereauProcessPage();
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
	
	DatasetReferenceDataPage DataRef = new DatasetReferenceDataPage();
	String CompanyReferenceval = "Automation Policy1"+getCurrentDateTimeMS();
	String UniqueReferenceVal2 = "Contract 2"+getCurrentDateTimeMS();
	static String  Rule = "AutoRule"+getCurrentDateTimeMS();
	static String  Rule1 = "AutoRule1"+getCurrentDateTimeMS();

	public static String contractId;

	public static String allSheetsPath = "";
	public static String sheet3541Path = "";
	public static String sheet3542Path = "";
	public static String sheet3542ScndPath = "";	
	public static String sheet3671Path = "";
	public static String sheet3671PathSecnd = "";
	public static String sheet3671Paththird = "";
	public static String sheet3876Path = "";
	public static String sheet3876Path1 = "";
	public static String sheet3914Path = "";
	public static String sheet3915Path = "";
	public static String sheet3981Path = "";
	public static String sheet3982Path = "";
	public static String sheet3915Path2 = "";
	public static String sheet5094Path = "";
	
	//TC 3473
	public static final String RenewalDrp = "@xpath=//tr[1]//*[@ng-model='item.TransactionType']//preceding-sibling::span[1]";
	public static final String NewDrp = "@xpath=//tr[2]//*[@ng-model='item.TransactionType']//preceding-sibling::span[1]";
	//public static final String Endorsment1 = "@xpath=//html/body/div[1]/div/div[2]/ul/li[4][text()='Endorsement']";
	public static final String Endorsment1 = "@xpath=//ul[@aria-hidden='false']//li[text()='Endorsement']";
	
	public static final String EndrsmntDrp = "@xpath=//*[@id='multiReference_Id']//tr[@ng-if='data.BDEngineErrorValues.length'][1]//span[@class='k-select']//preceding-sibling::span[1][text()='Endorsement']";
	//public static final String NewVal = "@xpath=//html/body/div[5]/div/div[2]/ul/li[2][text()='New']";
	public static final String NewVal = "@xpath=//ul[@aria-hidden='false']//li[text()='New']";
	public static final String EndrsmntDrp2 = "@xpath=//*[@id='multiReference_Id']//tr[@ng-if='data.BDEngineErrorValues.length'][2]//span[@class='k-select']//preceding-sibling::span[1][text()='Endorsement']";

	//public static final String NewVal2 = "@xpath=//html/body/div[7]/div/div[2]/ul/li[2][text()='New']";
	public static final String NewVal2 = "@xpath=//ul[@aria-hidden='false']//li[text()='New']";

	public static final String EndrsmntDrp3 = "@xpath=//*[@id='multiReference_Id']//tr[@ng-if='data.BDEngineErrorValues.length'][3]//span[@class='k-select']//preceding-sibling::span[1][text()='Endorsement']";
	//public static final String NewVall3 = "@xpath=//html/body/div[5]/div/div[2]/ul/li[2][text()='New']";
	public static final String NewVall3 = "@xpath=//ul[@aria-hidden='false']//li[text()='New']";
	
	//public static final String Endorsment2 = "@xpath=//*[@class='k-animation-container'][2]//li[4][text()='Endorsement']";
	public static final String Endorsment2 = "@xpath=//ul[@aria-hidden='false']//li[text()='Endorsement']";

	public static final String RiskRefFirst = "@xpath=//*[@id='multiReference_Id']//tr[1]//input[@ng-model='item.RiskReference']";
	public static final String RiskRefSecond = "@xpath=//*[@id='multiReference_Id']//tr[2]//input[@ng-model='item.RiskReference']";
	public static final String ContinueBtn = "@xpath=//*[@id='multiReference_Id']//button[@type='submit']";
	public static final String ContinueBtnSave = "@xpath=//*[@id='content']//button[@ng-click='save()']";

	public static final String CancellatiotoNew = "@xpath=//*[@id='multiReference_Id']//tr[@ng-if='data.BDEngineErrorValues.length'][1]//span[@class='k-select']//preceding-sibling::span[1][text()='Cancellation']";
	//public static final String NewVal3 = "@xpath=//html/body/div[9]/div/div[2]/ul/li[2][text()='New']";
	public static final String NewVal3 = "@xpath=//ul[@aria-hidden='false']//li[text()='New']";

	public static final String ReinstatmentDrp = "@xpath=//*[@id='multiReference_Id']//tr[@ng-if='data.BDEngineErrorValues.length'][1]//span[@class='k-select']//preceding-sibling::span[1][text()='Reinstatement']";
	//public static final String Cancellation1 = "@xpath=//html/body/div[11]/div/div[2]/ul/li[5][text()='Cancellation']";
	public static final String Cancellation1 = "@xpath=//ul[@aria-hidden='false']//li[text()='Cancellation']";

	public static final String ReinstatmentDrp2 = "@xpath=//*[@id='multiReference_Id']//tr[@ng-if='data.BDEngineErrorValues.length'][2]//span[@class='k-select']//preceding-sibling::span[1][text()='Reinstatement']";
	//public static final String Cancellation2 = "@xpath=//html/body/div[13]/div/div[2]/ul/li[5][text()='Cancellation']";
	public static final String Cancellation2 = "@xpath=//ul[@aria-hidden='false']//li[text()='Cancellation']";

	public static final String ReinstatmentDrp3 = "@xpath=//*[@id='multiReference_Id']//tr[@ng-if='data.BDEngineErrorValues.length'][3]//span[@class='k-select']//preceding-sibling::span[1][text()='Reinstatement']";
	//public static final String Cancellation3 = "@xpath=//div[35]//li[@class='k-item ng-scope'][text()='Cancellation']";
	public static final String Cancellation3 = "@xpath=//ul[@aria-hidden='false']//li[text()='Cancellation']";

	
	public static final String EnrichedValTxt = "@xpath=//*[@id='Data0']";

	public static final String TideValDrp = "@xpath=//*[@id='content']//div[@ng-if='data.BEnrichmentVMList.length']//td[2]/div/div";
	public static final String TideValDrp1 = "@xpath=//*[@id='content']//tr[1]//td[4]";

	public static final String TideDrpVal = "@xpath=//*[@id='Data0_listbox']//li[text()='No']";
	public static final String TideDrpValUK = "@xpath=//*[@id='Data0_listbox']//li[text()='United Kingdom']";
	public static final String TideDrpValRMS = "@xpath=//*[@id='Data{{$index}}_listbox']/li[text()='RMS: 0 - Unknown']";

	public static final String SbmtRcdAssmntBtn = "@xpath=//*[@id='content']//button[@ng-click='submitBordereau()']";
	public static final String ForApprvl = "@xpath=//button[text()='For Approval']";
	public static final String ForApprvlScndRw = "@xpath=//button[text()='For Approval']";
	public static final String ApprvdBtn = "@xpath=//*[@id='content']//button[@type='submit']";

	public static final String CreditCntrlCTab = "@xpath=.//*[@id='profile-main']//li[5]/a[text()='Credit Control']";
	public static final String FolderDrp = "@xpath=//*[@id='content']//div[@class='fg-line']//span[2]";


	//TC 3542
	public static final String GrossPremTxt = "@xpath=//*[@id='multiReference_Id']//input[@ng-model='item.Gross_Premium']";

	//TC 3876
	public static final String OnlyCurrentBtn = "@xpath=//label[contains(@for,'ts3')]";
	public static final String PaginationItem = "@xpath=//span[contains(.,'16 items')]";
	//TC 3915
	public static final String GrossPremiumValue = "@xpath=//*[@id='grid']//following::td[contains(@ng-click,'Gross Premium')][text()='5,000.00']";
	
	public static final String Twelth ="@xpath=//*[@uib-popover='Review']//a";
	public static final String DefaultSpecified ="@xpath=//td[text()='Number of Stories']//following::td[2]//div[contains(.,'DEFAULT SPECIFIED')]";
	public static final String Edit1 ="@xpath=//tr[1]//button[@ng-if='!w.$edit'][1]";
	public static final String Edit2 ="@xpath=//tr[2]//button[@ng-if='!w.$edit'][1]";

	public static final String ChangedValue="@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[4]";
	public static final String OKBtn="@xpath=//div[@ng-click='cancel()']";
	public static final String DatasetLink = "@xpath=//a[text()='Datasets']";
	
	//-------------------------------------------------------- BordereauProcessIdentifySheetTests ---------------------------------------------------------------------//

	public void ErroscreenValTransactiontypSupplied_3541() throws Exception{
		String MonthDate = "April 2017";
		String val1 = "1";
		String val2 = "5";
		String IncDate = "01/01/2017";
		String ExpDate = "31/12/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		policy.addPolicy2(IncDate,ExpDate);
		verifyExists(BordereauProcess.DraftBtn,"Draft Status Button");
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\"668217YI\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		//BordereauProcess.applyFilterPolicy("668217YI");
		BordereauProcess.openSelectedPolicy();
		BordereauProcess.SubmitBordereauxWithYesnoButtons(MonthDate);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3541Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2_TC_3541.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3541Path);	
		contractId = addNewBordereauFormatPolicy(payload1, GetData);

		String payload =  "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC4755.xlsx\",\"UniqueFileName\":\"S70532220180115.xlsx\",\"BordereauFormatId\":\"e1f3d92f-bd74-4e8a-b3c2-2eb5f4d3bb9c\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S70532220180115.xlsx\",\"Filesize\":20461,\"Path\":null,\"size\":20461,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//String payload = "{\"Bordereaux\":{\"ContractId\":\"41c29044-6b4e-4e4f-a85c-568ce9770b97\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2_TC_3541.xlsx\",\"UniqueFileName\":\"S76507320171114.xlsx\",\"BordereauFormatId\":\"5cd7b758-13d6-4a68-8e7d-13792d2b47a5\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S76507320171114.xlsx\",\"Filesize\":20461,\"Path\":null,\"size\":20461,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";


		uploadFile(ReqUrl, excelFile, payload, DraftUrl);

		BordereauProcess.refreshUploadedFile();
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true){
			if(isVisible(RenewalDrp)==true){
				EndorsmentFirstContinue(val1,val2);
				EndorsmentContinueSecond_3541();
				ChangeStasCanToNew();
				ReinstatementToCancl();
				EnrichedValChange();
				TideValChange();
				TideValChangeToUnitedKingdm();
				//TideValUKToRMS();
				//waitForElementToAppear(SbmtRcdAssmntBtn,3);
				if(isVisible(BordereauProcess.ErrorsAndWarningTab)==true){ 
					verifyMustExists(BordereauProcess.ErrorsAndWarningTab," Error and Warning");
					click(BordereauProcess.ErrorsAndWarningTab," Error and Warning");
					sleep(1000);
					click(BordereauProcess.NegativePremiumResolveErrors," Error and Warning");
					sleep(2000);
					verifyMustExists(GrossPremTxt,"gross Premium text");
					ChangGrossPremTxtVal();
					//sendKeys(BordereauProcess.NegativeGrossPremium, "1000");
					sleep(1000);
					if(isVisible(BordereauProcess.cancelAndDeleteProBtn)==true){
						verifyMustExists(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
						click(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
						sleep(1000);
					} else {
						Report.LogInfo("ErroScreenCheck", "Expected error not displayed.", "FAIL");
					}
					
				}	
				BordereauProcess.deleteBorderEAUX();				
			}else{
				Report.LogInfo("ErroScreenCheck", "Expected error not displayed.", "FAIL");
				goBack();
				BordereauProcess.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateStatus", "Review error status not displayed.", "FAIL");
			BordereauProcess.deleteBorderEAUX();
		}		
	}

	public void ErroscreenValTransactiontypNotSupplied_3542() throws Exception{
		String MonthDate = "April 2017";

		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		//BordereauProcess.applyFilterPolicy("649262RO");
		BordereauProcess.openSelectedPolicy();
		BordereauProcess.SubmitBordereauxWithYesnoButtons(MonthDate);
		BordereauProcess.DeleteError();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3542Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC_3542.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3542Path);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC_3542.xlsx\",\"UniqueFileName\":\"S10529720180317.xlsx\",\"BordereauFormatId\":\"65cf6d36-5e35-4d09-810c-1e0783c8ab8c\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S10529720180317.xlsx\",\"Filesize\":20461,\"Path\":null,\"size\":20461,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//String payload = "{\"Bordereaux\":{\"ContractId\":\"eed7dc87-8dd0-4aaf-8123-84bff3dd532d\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC_3542.xlsx\",\"UniqueFileName\":\"S65853620180008.xlsx\",\"BordereauFormatId\":\"dac54043-b48f-490c-b0e2-834bf134ffe2\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S65853620180008.xlsx\",\"Filesize\":20461,\"Path\":null,\"size\":20461,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);

		BordereauProcess.refreshUploadedFile();
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true){
			if(isVisible(GrossPremTxt)==true){
				ChangGrossPremTxtVal();
				EnrichedValChange();		
				TideValChange();
				TideValChangeToUnitedKingdm();
				//TideValUKToRMS();	
				if(isVisible(BordereauProcess.cancelAndDeleteProBtn)==true){
					verifyMustExists(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
					click(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
					sleep(1000);
				}				
				BordereauProcess.deleteBorderEAUX();				
			}else{
				Report.LogInfo("ErroScreenCheck", "Expected error not displayed.", "FAIL");
				goBack();
				BordereauProcess.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateStatus", "Review error status not displayed.", "FAIL");
			BordereauProcess.deleteBorderEAUX();
		}		
	}

	//3876 Add existing policies
	public void missingEntriesTreatedAsCancellation() throws Exception
	{
		ReportingChannel reportingChannel = new ReportingChannel();
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();

		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		String InceptionDate = "01/01/2017";
		String InceptionDate1 = "31/12/2017";
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails1(UniqueReferenceVal1, InceptionDate,InceptionDate1, policy.Status1, policy.Broker1, policy.Bline1, policy.Underline1);
		waitForElementToAppear(policy.DraftBtn,5);
		verifyExists(policy.DraftBtn,"Draft Status Button");
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		waitForElementToAppear(BordereauProcess.BORDEREAUXLink,10);
		verifyMustExists(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
		click(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
		sleep(3000);
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3876Path1 = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC_3876.xlsx";
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		File excelFile = new File(sheet3876Path1);  
		policy.contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//System.out.println(contractId);Stage 2 TC_3876
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC_3876.xlsx\",\"UniqueFileName\":\"S53903120171122.xlsx\",\"BordereauFormatId\":\"d8232041-5c03-4e62-99c3-49046d8cfd74\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S53903120171122.xlsx\",\"Filesize\":20186,\"Path\":null,\"size\":20186,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		reportingChannel.refreshUploadedFile();
		if(isVisible(BordereauProcess.ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			verifyMustExists(BordereauProcess.ReviewBtn,"Review button");
			click(BordereauProcess.ReviewBtn,"Review button");
			BordereauProcess.clickOnSubProcessRcdBtn();
			//BordereauProcess.clickOnSubAssesmntBtn();
			sleep(3000);
			waitForElementToAppear(policy.FrApprovalbtn,10);
			verifyMustExists(policy.FrApprovalbtn,"For Approval button");
			click(policy.FrApprovalbtn,"For Approval button");
			BordereauProcess.clickOnApproveBordBtn();		
		}else{
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not displayed.", "FAIL");				
			//BordereauProcess.deleteBorderEAUX();
		}

		BordereauProcess.openDATALink();
		BordereauProcess.navigateToDATARiskTab();
		//Locators
		List<WebElement> YearOfAccount =  webDriver.findElements(By.xpath("//*[@data-field='YearOfAccount']//following::td[contains(@ng-click,'YearOfAccount')][text()='2017']"));
		sleep(2000);
		if(YearOfAccount.size() == 7)
		{
			Report.LogInfo("YearOfAccount", "Year Of Account is Displayed properly", "PASS");
		}
		else
		{
			Report.LogInfo("YearOfAccount", "Year Of Account is Displayed wrong", "FAIL");
		}
		sleep(2000);
		policy.navigationOnBordereauxTab();
		sleep(1000);
		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3876Path = fpath+"\\src\\test\\resources\\testdata\\cancelation_2_3876.xlsx";
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		File excelFile1 = new File(sheet3876Path);  
		policy.contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//System.out.println(contractId);Stage 2 TC_3876
		String payload5 ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"cancelation_2_3876.xlsx\",\"UniqueFileName\":\"S38314620171122.xlsx\",\"BordereauFormatId\":\"d8232041-5c03-4e62-99c3-49046d8cfd74\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S38314620171122.xlsx\",\"Filesize\":19608,\"Path\":null,\"size\":19608,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile1, payload5, DraftUrl);
		reportingChannel.refreshUploadedFile();
		BordereauProcess.openDATALink();
		BordereauProcess.navigateToDATARiskTab();
		//Locators
		List<WebElement> Endorsement = webDriver.findElements(By.xpath("//*[@data-field='Transaction_Type']//following::td[contains(@ng-click,'Transaction_Type')][text()='Endorsement']"));
		sleep(2000);
		if(Endorsement.size() == 2)
		{
			Report.LogInfo("Endorsement", "Endorsement count is Displayed properly", "PASS");
		}
		else
		{
			Report.LogInfo("Endorsement", "Endorsement count is Displayed wrong", "FAIL");
		}
		sleep(1000);
		List<WebElement> Cancellation = webDriver.findElements(By.xpath("//*[@data-field='Transaction_Type']//following::td[contains(@ng-click,'Transaction Type')][text()='Cancellation']"));
		sleep(2000);
		if(Cancellation.size() == 5)
		{
			Report.LogInfo("Cancellation", "Cancellation count is Displayed properly", "PASS");
		}
		else
		{
			Report.LogInfo("Cancellation", "Cancellation count is Displayed wrong", "FAIL");
		}
		sleep(1000);
		verifyMustExists(OnlyCurrentBtn,"Only Current button");
		click(OnlyCurrentBtn,"Only Current button");
		sleep(3000);
		if(isVisible(PaginationItem) == true)
		{
			Report.LogInfo("PaginationCount", "Pagination count is Displayed 16 properly", "PASS");
		}
		else
		{
			Report.LogInfo("PaginationCount", "Pagination count is Displayed wrong", "FAIL");
		}
	}

	//3914 Validate mandatory reference field, boolean field, date Field, Integer Field, String field and percentage field
	public static final String CancelButtonOnScreen = "@xpath=//*[@ng-click='cancel()']";
	public static final String Okbtn="@xpath=//*[@ng-click='cancel()']";
	public static final String RuleNameField="@xpath=//*[@ng-repeat='item in NewBCellEnrich'][1]//td[6]";
	//public static final String TideValDrp = "@xpath=//*[@id='content']//div[@ng-if='data.BEnrichmentVMList.length']//td[2]/div/div";
	public static final String TideDrpValUK2 = "@xpath=//*[@class='k-animation-container'][last()]//*[@id='Data0_listbox']//li[text()='United Kingdom']";
		



	public void validateMandatoryReferenceField() throws Exception
		{
			ReportingChannel reportingChannel = new ReportingChannel();
			BordereauProcessPage BordereauPage = new BordereauProcessPage();

			String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
			String InceptionDate = "01/01/2017";
			String InceptionDate1 = "31/12/2017";
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			String subSheet ="Stage 2(Transaction type not Applied)";
			String SubmitSheet="Stage 2(Transaction type";
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
			policy.navigationOnPolicyTab();
			policy.navigationOnAddContractPage();
			policy.navigationOnSelectPolicyPopUp();
			policy.navigationOnAddPolicyPopUp();
			policy.addContractBinderDetails();
			policy.addPolicyContractDetails1(UniqueReferenceVal1, InceptionDate,InceptionDate1, policy.Status1, policy.Broker1, policy.Bline1, policy.Underline1);
			waitForElementToAppear(policy.DraftBtn,5);
			verifyExists(policy.DraftBtn,"Draft Status Button");
			policy.changeStatusToQuote();
			policy.changeStatusToWritten();
			policy.changeStatusToSigned();
			BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
			//BordereauProcess.applyFilterPolicy("428792WF");
			BordereauProcess.openSelectedPolicy();
			waitForElementToAppear(BordereauPage.SignedBtn,5);
			if(isVisible(BordereauPage.SignedBtn)== true){
				verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
				BordereauPage.SubmitBordereaux(subSheet);
				String GetData = Configuration.url+"/api/Contract/GetAllPage";
				String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet3914Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC_3914.xlsx";
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				File excelFile = new File(sheet3914Path);  
				policy.contractId = addNewBordereauFormatPolicy(payload1, GetData);
				String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC_3914.xlsx\",\"UniqueFileName\":\"S27408620180101.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S27408620180101.xlsx\",\"Filesize\":20609,\"Path\":null,\"size\":20609,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				uploadFile(ReqUrl, excelFile, payload, DraftUrl);
				reportingChannel.refreshUploadedFile();
				if(BordereauPage.checkErrorReviewButton(BordereauPage.ReviewError)==true){
				{
					Report.LogInfo("ReviewError", "Riview Error status displayed successfully.", "PASS");
					EnrichedValChange1("11");
					EnrichedValChange1("11");
					EnrichedValChange1("31/12/2017");
					EnrichedValChange1("10");
					TideValChange1();
					TideValChangeToUnitedKingdm1(TideDrpValUK);
					TideValChangeToUnitedKingdm1(TideDrpValUK2);
					waitForElementToAppear(CancelButtonOnScreen,5);
					click(CancelButtonOnScreen,"Cliked on Cancel");
					BordereauPage.refreshUploadedFile();
					if(isVisible(BordereauPage.ReviewBtn)==true){
						Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
						JavascriptExecutor jse = (JavascriptExecutor)webDriver;
						jse.executeScript("scroll(0, -250);");
						BordereauPage.openDATALink();
						BordereauPage.navigateToDATARiskTab();
						
						String RiskExpiryDatecolumn="@xpath=//*[@data-field='RiskExpiryDate']";
						String RiskExpiryDate1="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[1]//td[contains(@ng-click,'RiskExpiryDate')][text()='31/12/2017']";
						waitForElementToAppear(RiskExpiryDatecolumn,10);
						mouseOverAction(RiskExpiryDatecolumn);
						verifyMustExists(RiskExpiryDatecolumn,"RiskExpiryDate column");
						sleep(2000);
						verifyExists(RiskExpiryDate1,"1st value");
						BordereauPage.verifyBackground(RiskExpiryDate1,"rgba(0, 97, 0, 1)");
						click(RiskExpiryDate1,"RiskExpiryDate1");
						waitForElementToAppear(Okbtn,5);
						verifyExists(RuleNameField,"Rule Name Field");
						click(Okbtn,"ok Buttton");
						sleep(2000);
						
						String RiskCountrycolumn="@xpath=//*[@data-field='Risk_Country']";
						String RiskCountry5="@xpath=//*[@data-field='Risk_Country']//following::tr[5]//td[contains(@ng-click,'Risk_Country')][text()='United Kingdom']";
						waitForElementToAppear(RiskCountrycolumn,10);
						mouseOverAction(RiskCountrycolumn);
						verifyMustExists(RiskCountrycolumn,"Risk Country column");
						sleep(2000);
						verifyExists(RiskCountry5,"5th value");
						BordereauPage.verifyBackground(RiskCountry5,"rgba(0, 97, 0, 1)");
						click(RiskCountry5,"RiskCountry5");
						waitForElementToAppear(Okbtn,5);
						verifyExists(RuleNameField,"Rule Name Field");
						click(Okbtn,"ok Buttton");
						sleep(2000);
						
						String Sprinklerscolumn="@xpath=//*[@data-field='Sprinklers']";
						String SprinklersNo="@xpath=//*[@data-field='Sprinklers']//following::tr[3]//td[contains(@ng-click,'Sprinklers')][text()='No']";
						waitForElementToAppear(Sprinklerscolumn,10);
						mouseOverAction(Sprinklerscolumn);
						verifyMustExists(Sprinklerscolumn,"Sprintklers column");
						sleep(2000);
						verifyExists(SprinklersNo,"No value");
						BordereauPage.verifyBackground(SprinklersNo,"rgba(0, 97, 0, 1)");
						click(SprinklersNo,"Sprinklers No value");
						waitForElementToAppear(Okbtn,5);
						verifyExists(RuleNameField,"Rule Name Field");
						click(Okbtn,"ok Buttton");
						sleep(2000);
						
						String NumberOfStoriescolumn="@xpath=//*[@data-field='NumberOfStories']";
						String NumberOfStroies10value="@xpath=//*[@data-field='NumberOfStories']//following::tr[4]//td[contains(@ng-click,'NumberOfStories')][text()='10']";
						waitForElementToAppear(NumberOfStoriescolumn,10);
						mouseOverAction(NumberOfStoriescolumn);
						verifyMustExists(NumberOfStoriescolumn,"Number of Stories column");
						sleep(2000);
						verifyExists(NumberOfStroies10value,"4th value");
						BordereauPage.verifyBackground(NumberOfStroies10value,"rgba(0, 97, 0, 1)");
						click(NumberOfStroies10value,"Number of Stories 10 value");
						waitForElementToAppear(Okbtn,5);
						verifyExists(RuleNameField,"Rule Name Field");
						click(Okbtn,"ok Buttton");
						sleep(2000);
						
						String Taxpercent1column="@xpath=//*[@data-field='Tax_Percent_1']";
						String Taxpercent11value="@xpath=//*[@data-field='Tax_Percent_1']//following::tr[6]//td[contains(@ng-click,'Tax_Percent_1')][text()='11.00 %']";
						waitForElementToAppear(Taxpercent1column,10);
						mouseOverAction(Taxpercent1column);
						verifyMustExists(Taxpercent1column,"Tax percent 1 column");
						sleep(2000);
						verifyExists(Taxpercent11value,"11 % value");
						BordereauPage.verifyBackground(Taxpercent11value,"rgba(0, 97, 0, 1)");
						click(Taxpercent11value,"Number of Stories 10 value");
						waitForElementToAppear(Okbtn,5);
						verifyExists(RuleNameField,"Rule Name Field");
						click(Okbtn,"ok Buttton");
						sleep(2000);
						policy.navigationOnBordereauxTab();
						BordereauPage.deleteBorderEAUX();
						}else{
						Report.LogInfo("ValidateReviewButton", "Review button not displayed", "Fail");
							}	
						}				
					}else{
						Report.LogInfo("ReviewError", "Riview Error not displayed.", "FAIL");
						goBack();
					}
			}else{
				Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
				}	
		}

	//3915 Validate intitial premium is positive
	public void validateIntitialPremiumPositive() throws Exception
	{
		ReportingChannel reportingChannel = new ReportingChannel();
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		String InceptionDate = "01/01/2017";
		String InceptionDate1 = "31/12/2017";
		String SubmitSheet="Stage 2(Transaction type";
		String subSheet="Stage 2(Transaction type not Applied) (Automation Schema)";
		String subSheet1="SP - First Sheet";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(subSheet1);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails1(UniqueReferenceVal1, InceptionDate,InceptionDate1, policy.Status1, policy.Broker1, policy.Bline1, policy.Underline1);
		waitForElementToAppear(policy.DraftBtn,5);
		verifyExists(policy.DraftBtn,"Draft Status Button");
		policy.contractId = ReturnContractID();
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		//BordereauProcess.applyFilterPolicy("420163QY");
		BordereauProcess.openSelectedPolicy();
		waitForElementToAppear(BordereauProcess.SignedBtn,5);
		if(isVisible(BordereauProcess.SignedBtn)== true){
			verifyExists(BordereauProcess.SignedBtn,"Signed Status Button");
			BordereauProcess.SubmitBordereaux(subSheet);
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3915Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC_3915.xlsx";
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			File excelFile = new File(sheet3915Path);  
			String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC_3915.xlsx\",\"UniqueFileName\":\"S45626920180202.xlsx\",\"BordereauFormatId\":\"65cf6d36-5e35-4d09-810c-1e0783c8ab8c\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S45626920180202.xlsx\",\"Filesize\":19962,\"Path\":null,\"size\":19962,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			reportingChannel.refreshUploadedFile();
			if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
			{
				sleep(5000);
				if(isVisible(GrossPremTxt)==true){
					verifyMustExists(GrossPremTxt,"Tide value dropdown");
					sendKeys(GrossPremTxt,"5000","Gross Prem Txt");	
					waitForElementToAppear(ContinueBtn,3);
					verifyMustExists(ContinueBtn,"Continue button");
					click(ContinueBtn,"Continue button");
					sleep(2000);
					scrollUp();
					waitForElementToAppear(SbmtRcdAssmntBtn,5);
					if(isVisible(BordereauProcess.cancelAndDeleteProBtn)==true){
					verifyMustExists(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
					click(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
					sleep(1000);
					}else{
					Report.LogInfo("ErroScreenCheck", "Cancel button not displayed.", "FAIL");
					}
					
				}else{
					Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
				}
			}				
			else{
				Report.LogInfo("ErroScreenCheck", "Expected error not displayed.", "FAIL");
				goBack();
			
			}	
			sleep(2000);
			BordereauProcess.openDATALink();
			BordereauProcess.navigateToDATARiskTab();
			if(isVisible(GrossPremiumValue) == true)
			{
				Report.LogInfo("GrossPremium", "Gross Premium is Displayed properly", "PASS");
			}
			else
			{
				Report.LogInfo("GrossPremium", "Gross Premium is Displayed wrong", "FAIL");
			}
			click(GrossPremiumValue,"Select Gross Premium Value");
			if(isVisible(ChangedValue))
			{
				Report.LogInfo("ChangedValueData", "Data is displayed", "PASS");
				verifyMustExists(ChangedValue,"Changed Value");	
			}
			else{
				Report.LogInfo("ChangedValueData", "Data is not displayed", "FAIL");
			}
			verifyMustExists(OKBtn,"Edit button");
			click(OKBtn,"Edit button");
			
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
		policy.navigationOnBordereauxTab();
		BordereauProcess.deleteBorderEAUX();
		
		//Upload file2
		BordereauProcess.SubmitBordereaux(subSheet1);
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3915Path2 = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC_3915_Second.xlsx";
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		File excelFile = new File(sheet3915Path2);  
		//String payload2 ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC_3915_Second.xlsx\",\"UniqueFileName\":\"S22649520180205.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId +"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S22649520180205.xlsx\",\"Filesize\":19962,\"Path\":null,\"size\":19962,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String payload2 ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC_3915_Second.xlsx\",\"UniqueFileName\":\"S18347720180205.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S18347720180205.xlsx\",\"Filesize\":19920,\"Path\":null,\"size\":19920,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload2, DraftUrl);
		reportingChannel.refreshUploadedFile();
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
		{
			sleep(5000);
			if(isVisible(GrossPremTxt)==true){
				verifyMustExists(GrossPremTxt,"Tide value dropdown");
				sendKeys(GrossPremTxt,"5000","Gross Prem Txt");	
				waitForElementToAppear(ContinueBtn,3);
				verifyMustExists(ContinueBtn,"Continue button");
				click(ContinueBtn,"Continue button");
				sleep(2000);
				scrollUp();
				waitForElementToAppear(SbmtRcdAssmntBtn,5);
				if(isVisible(BordereauProcess.cancelAndDeleteProBtn)==true){
				verifyMustExists(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
				click(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
				sleep(1000);
				}else{
				Report.LogInfo("ErroScreenCheck", "Cancel button not displayed.", "FAIL");
				}
				
			}else{
				Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
			}
		}				
		else{
			Report.LogInfo("ErroScreenCheck", "Expected error not displayed.", "FAIL");
			goBack();
		
			}	
		sleep(2000);
		BordereauProcess.openDATALink();
		BordereauProcess.navigateToDATARiskTab();
		if(isVisible(GrossPremiumValue) == true)
		{
			Report.LogInfo("GrossPremium", "Gross Premium is Displayed properly", "PASS");
		}
		else
		{
			Report.LogInfo("GrossPremium", "Gross Premium is Displayed wrong", "FAIL");
		}
		click(GrossPremiumValue,"Select Gross Premium Value");
		if(isVisible(ChangedValue))
			{
				Report.LogInfo("ChangedValueData", "Data is displayed", "PASS");
				verifyMustExists(ChangedValue,"Changed Value");	
			}
			else{
				Report.LogInfo("ChangedValueData", "Data is not displayed", "FAIL");
			}		
		verifyMustExists(OKBtn,"Edit button");
		click(OKBtn,"Edit button");
}


	//3981 Bespoke default - multiple default values based on conditions with equal to operator
	public void bespokeMultipleDefaultValuesEqual() throws Exception{
		ReportingChannel reportingChannel = new ReportingChannel();
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		String SelectQuestionnaire ="@xpath=//ul//li//*[@value='Default Value Enhancement 1']";
		String SubsheetName ="Default value enhancement 1";
		String subSheet ="Default value enhancement 1";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire(SubsheetName, SelectQuestionnaire);
		if(isVisible(BQPage.EditBtn)==true){
			waitForElementToAppear(BQPage.EditBtn,5);
			verifyMustExists(BQPage.EditBtn,"Edit button");
			click(BQPage.EditBtn,"Edit button");
			sleep(2000);
			verifyMustExists(Twelth,"Review 12th step");
			click(Twelth,"Review 12th step");
			verifyMustExists(DefaultSpecified,"Default Specified Button");
			click(DefaultSpecified,"Default Specified Button");
			verifyMustExists(Edit1,"Edit icon");
			click(Edit1,"Edit icon");
			SelectDropDownValue(policy.OperatorDD,policy.EqualToValue);
			verifyMustExists(policy.CheckBtn,"Check icon");
			click(policy.CheckBtn,"Check icon");
			verifyMustExists(Edit2,"Edit icon");
			click(Edit2,"Edit icon");
			SelectDropDownValue(policy.OperatorDD,policy.EqualToValue);
			verifyMustExists(policy.CheckBtn,"Check icon");
			click(policy.CheckBtn,"Check icon");
			verifyMustExists(policy.SaveBtn2,"Save button");
			click(policy.SaveBtn2,"Save button");
			verifyMustExists(policy.SaveBtn,"Save button");
			BQPage.FormatId = ReturnFormatID();
			System.out.println(BQPage.FormatId);
			click(policy.SaveBtn,"Save button");
			sleep(2000);
			BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
			BordereauProcess.openSelectedPolicy();
			if(isVisible(BordereauProcess.SignedBtn)== true){
				verifyExists(BordereauProcess.SignedBtn,"Signed Status Button");
				BordereauProcess.SubmitBordereaux(subSheet);	
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet3981Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 errors - March 2017_TC_3981.xlsx";
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				File excelFile = new File(sheet3981Path);  
				String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 errors - March 2017_TC_3981.xlsx\",\"UniqueFileName\":\"S13562020180116.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S13562020180116.xlsx\",\"Filesize\":18959,\"Path\":null,\"size\":18959,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				uploadFile(ReqUrl, excelFile, payload, DraftUrl);
				reportingChannel.refreshUploadedFile();
				if(isVisible(BordereauProcess.ReviewBtn)== true){
					Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
					BordereauProcess.openDATALink();
					BordereauProcess.navigateToDATARiskTab();
					String NumberOfStoriescolumn="@xpath=//*[@data-field='NumberOfStories']";
					String NumberOfStoriesValue1="@xpath=//*[@data-field='NumberOfStories']//following::tr[1]//td[contains(@ng-click,'NumberOfStories')][text()='5']";
					String NumberOfStoriesValue2="@xpath=//*[@data-field='NumberOfStories']//following::tr[2]//td[contains(@ng-click,'NumberOfStories')][text()='20']";
					String NumberOfStoriesValue3="@xpath=//*[@data-field='NumberOfStories']//following::tr[3]//td[contains(@ng-click,'NumberOfStories')][text()='20']";
					String NumberOfStoriesValue4="@xpath=//*[@data-field='NumberOfStories']//following::tr[4]//td[contains(@ng-click,'NumberOfStories')][text()='15']";
					String NumberOfStoriesValue5="@xpath=//*[@data-field='NumberOfStories']//following::tr[5]//td[contains(@ng-click,'NumberOfStories')][text()='10']";		
					String NumberOfStoriesValue6="@xpath=//*[@data-field='NumberOfStories']//following::tr[6]//td[contains(@ng-click,'NumberOfStories')][text()='12']";		
					waitForElementToAppear(NumberOfStoriescolumn,8);
					mouseOverAction(NumberOfStoriescolumn);
					verifyMustExists(NumberOfStoriescolumn,"NumberOfStories column");
					sleep(2000);
					verifyExists(NumberOfStoriesValue1,"1st value");
					verifyExists(NumberOfStoriesValue2,"2nd value");
					verifyExists(NumberOfStoriesValue3,"3rd value");
					verifyExists(NumberOfStoriesValue4,"4th value");
					verifyExists(NumberOfStoriesValue5,"5th value");
					verifyExists(NumberOfStoriesValue6,"6th value");
					sleep(2000);	
				}else{
					Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
					BordereauProcess.deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
			}
		}else{
			Report.LogInfo("ButtonCheck", "Edit button not display", "FAIL");
		}
	}


	//3982 Bespoke default - multiple default values based on conditions with not equal to operator
	public void bespokeMultipleDefaultValuesNotEqual() throws Exception{
		ReportingChannel reportingChannel = new ReportingChannel();
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		String SelectQuestionnaire ="@xpath=//ul//li//*[@value='Default Value Enhancement 1']";
		String SubsheetName ="Default value enhancement 1";
		String subSheet ="Default value enhancement 1";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire(SubsheetName, SelectQuestionnaire);
		if(isVisible(BQPage.EditBtn)==true){
			waitForElementToAppear(BQPage.EditBtn,5);
			verifyMustExists(BQPage.EditBtn,"Edit button");
			click(BQPage.EditBtn,"Edit button");
			sleep(3000);
			verifyMustExists(Twelth,"Review 12th step");
			click(Twelth,"Review 12th step");
			verifyMustExists(DefaultSpecified,"Default Specified Button");
			click(DefaultSpecified,"Default Specified Button");
			verifyMustExists(Edit1,"Edit icon");
			click(Edit1,"Edit icon");
			SelectDropDownValue(policy.OperatorDD,policy.NotEqualToValue);
			verifyMustExists(policy.CheckBtn,"Check icon");
			click(policy.CheckBtn,"Check icon");
			verifyMustExists(Edit2,"Edit icon");
			click(Edit2,"Edit icon");
			SelectDropDownValue(policy.OperatorDD,policy.NotEqualToValue);
			verifyMustExists(policy.CheckBtn,"Check icon");
			click(policy.CheckBtn,"Check icon");
			verifyMustExists(policy.SaveBtn2,"Save button");
			click(policy.SaveBtn2,"Save button");
			verifyMustExists(policy.SaveBtn,"Save button");
			BQPage.FormatId = ReturnFormatID();
			System.out.println(BQPage.FormatId);
			click(policy.SaveBtn,"Save button");
			sleep(2000);
			BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
			BordereauProcess.openSelectedPolicy();
			if(isVisible(BordereauProcess.SignedBtn)== true){
				verifyExists(BordereauProcess.SignedBtn,"Signed Status Button");
				BordereauProcess.SubmitBordereaux(subSheet);
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet3982Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 errors - March 2017_TC_3982.xlsx";
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				File excelFile = new File(sheet3982Path);  
			//	String payload ="{\"Bordereaux\":{\"ContractId\":\"27126cba-98af-4d8b-9a00-a1463eebdb1d\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 errors - March 2017_TC_3982.xlsx\",\"UniqueFileName\":\"S26722320171122.xlsx\",\"BordereauFormatId\":\"9bd03061-a9e4-44d0-b3ba-57c71c5688be\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S26722320171122.xlsx\",\"Filesize\":20053,\"Path\":null,\"size\":20053,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 errors - March 2017_TC_3982.xlsx\",\"UniqueFileName\":\"S14001120180116.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S14001120180116.xlsx\",\"Filesize\":18605,\"Path\":null,\"size\":18605,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				uploadFile(ReqUrl, excelFile, payload, DraftUrl);
				reportingChannel.refreshUploadedFile();
				if(isVisible(BordereauProcess.ReviewBtn)== true){
					Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
					BordereauProcess.openDATALink();
					BordereauProcess.navigateToDATARiskTab();
					String NumberOfStoriescolumn="@xpath=//*[@data-field='NumberOfStories']";
					String NumberOfStoriesValue1="@xpath=//*[@data-field='NumberOfStories']//following::tr[1]//td[contains(@ng-click,'NumberOfStories')][text()='10']";
					String NumberOfStoriesValue2="@xpath=//*[@data-field='NumberOfStories']//following::tr[2]//td[contains(@ng-click,'NumberOfStories')][text()='20']";
					String NumberOfStoriesValue3="@xpath=//*[@data-field='NumberOfStories']//following::tr[3]//td[contains(@ng-click,'NumberOfStories')][text()='15']";
					String NumberOfStoriesValue4="@xpath=//*[@data-field='NumberOfStories']//following::tr[4]//td[contains(@ng-click,'NumberOfStories')][text()='20']";
					waitForElementToAppear(NumberOfStoriescolumn,8);
					mouseOverAction(NumberOfStoriescolumn);
					verifyMustExists(NumberOfStoriescolumn,"NumberOfStories column");
					sleep(2000);
					verifyExists(NumberOfStoriesValue1,"1st value");
					verifyExists(NumberOfStoriesValue2,"2nd value");
					verifyExists(NumberOfStoriesValue3,"3rd value");
					verifyExists(NumberOfStoriesValue4,"4th value");
					sleep(2000);	
				}else{
					Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
					BordereauProcess.deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
			}
		}else
		{
			Report.LogInfo("ButtonCheck", "Edit button not display", "FAIL");
		}
	}
	
	
	public void ValidateMandatoryReferenceField_TC5094() throws Exception
	{
		homePage.adminMenu(); 
		waitForElementToAppear(DatasetLink,5);
		verifyMustExists(DatasetLink,"Dataset link");
		click(DatasetLink,"Data set link");
		sleep(3000);
		DataRef.SelectRiskAndPremium();
		sleep(2000);
		BQPage.ChangeRiskAndPremium();
		String IncDate = "01/01/2017";
		String IncExpDate = "31/12/2017";
		String subSheet = "Rule testing(General and Location)";
		String ReqUrl = Configuration.url+"api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"api/Bordereaux/AddAsDraft";
			
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(subSheet);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		policy.addPolicy2(IncDate,IncExpDate);
		verifyExists(BordereauProcess.DraftBtn,"Draft Status Button");
		String GetData = Configuration.url+"api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		BordereauProcess.openSelectedPolicy();
		BordereauProcess.SubmitBordereaux(subSheet);
		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet5094Path = fpath+"\\src\\test\\resources\\testdata\\Financial Calculation_5094.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet5094Path);	
		BordereauProcess.contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+BordereauProcess.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculation_5094.xlsx\",\"UniqueFileName\":\"S39143520180223.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S39143520180223.xlsx\",\"Filesize\":107657,\"Path\":null,\"size\":107657,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauProcess.refreshUploadedFile();
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(2000);

			if(isVisible(BordereauProcess.EnrichedValueTxt)==true){
				verifyMustExists(BordereauProcess.EnrichedValueTxt,"Enriched Value textbox");
				sendKeys(BordereauProcess.EnrichedValueTxt, "31/01/2017", "Enriched Value textbox");
				verifyMustExists(BordereauProcess.continuebtx,"Continue button");
				click(BordereauProcess.continuebtx, "Continue button");
				sleep(2000);
				verifyMustExists(BordereauProcess.EnrichedValueTxt,"Enriched Value textbox");
				sendKeys(BordereauProcess.EnrichedValueTxt, "10", "Enriched Value textbox");
				sleep(2000);
			}else{
				Report.LogInfo("ErrorScreen", "Expected error screen not displayed.", "FAIL");
				goBack();
				BordereauProcess.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateStatus", "Review error status not displayed.", "FAIL");
			BordereauProcess.deleteBorderEAUX();
		}		
		
	}
	//----------------------------------------------------Credit control Test case----------------

	public void CreditControl_3671() throws Exception{
		String MonthDate = "April 2017";
		String val1 = "1";
		String val2 = "5";
		String IncDate = "01/01/2017";
		String ExpDate = "01/01/2018";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		policy.addPolicy2(IncDate,ExpDate);
		verifyExists(BordereauProcess.DraftBtn,"Draft Status Button");
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\"596023CT\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		//BordereauProcess.applyFilterPolicy("596023CT");
		BordereauProcess.openSelectedPolicy();
		BordereauProcess.SubmitBordereauxWithYesnoButtons(MonthDate);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3671Path = fpath+"\\src\\test\\resources\\testdata\\January 2016 Single Risk_TC_3671.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3671Path);	
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2016 Single Risk_TC_3671.xlsx\",\"UniqueFileName\":\"S73056820171113.xlsx\",\"BordereauFormatId\":\"a5e55365-619b-4dd2-86c3-298691f699dd\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S73056820171113.xlsx\",\"Filesize\":16407,\"Path\":null,\"size\":16407,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//String payload = "{\"Bordereaux\":{\"ContractId\":\"28d5003d-a872-4011-a009-c0251689ae00\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2016 Single Risk_TC_3671.xlsx\",\"UniqueFileName\":\"S73056820171113.xlsx\",\"BordereauFormatId\":\"a5e55365-619b-4dd2-86c3-298691f699dd\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S73056820171113.xlsx\",\"Filesize\":16407,\"Path\":null,\"size\":16407,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);

		BordereauProcess.refreshUploadedFile();
		if(isVisible(BordereauProcess.ReviewBtn)==true){
			click(BordereauProcess.ReviewBtn,"Review button");
			sleep(1000);
			SubmitRecordAssesmentBtn();
			sleep(1000);
			ForApprovalBtn();
			sleep(1000);
			ApprdBtn();
			sleep(1000);
			policy.navigateToReportingChannelsTab();
			sleep(1000);
			policy.addReportingChannelForpremium();
			sleep(1000);
			BordereauProcess.SubmitBordereauxWithYesnoButtons(MonthDate);

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3671PathSecnd = fpath+"\\src\\test\\resources\\testdata\\January 2016 Single Premium_TC_3671_Second.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile1 = new File(sheet3671PathSecnd);	
			String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"2\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2016 Single Premium_TC_3671_Second.xlsx\",\"UniqueFileName\":\"S44805120171114.xlsx\",\"BordereauFormatId\":\"42fd1f85-71e3-4052-9fa1-80f0073d8bca\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S44805120171114.xlsx\",\"Filesize\":16362,\"Path\":null,\"size\":16362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//String payload2 = "{\"Bordereaux\":{\"ContractId\":\"28d5003d-a872-4011-a009-c0251689ae00\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"2\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2016 Single Premium_TC_3671_Second.xlsx\",\"UniqueFileName\":\"S44805120171114.xlsx\",\"BordereauFormatId\":\"42fd1f85-71e3-4052-9fa1-80f0073d8bca\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S44805120171114.xlsx\",\"Filesize\":16362,\"Path\":null,\"size\":16362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

			uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
			BordereauProcess.refreshUploadedFile();
			if(isVisible(BordereauProcess.ReviewBtn)==true){
				click(BordereauProcess.ReviewBtn,"Review button");
				sleep(1000);
				SubmitRecordAssesmentBtn();
				sleep(1000);
				ForApprovalBtnSncdRow();
				sleep(1000);
				ApprdBtn();
				sleep(5000);
				BordereauProcess.openDATALink();
				sleep(5000);
				NavigationCreditContrlTab();
				sleep(5000); 
				SelectDrpValOfFolder();		

			}else{
				Report.LogInfo("ValidateStatus", "Review error status not displayed.", "FAIL");
				BordereauProcess.deleteBorderEAUX();				
			}
		}else{
			Report.LogInfo("ValidateStatus", "Review error status not displayed.", "FAIL");
			BordereauProcess.deleteBorderEAUX();
		}		
	}


	//--------------------------------------------------------------------------------------------------------------------------------------------//	
	//------------------------------------------------------- Reusable functions -----------------------------------------------------------------//
	//--------------------------------------------------------------------------------------------------------------------------------------------//	

	public void EndorsmentFirstContinue(String val1, String val2){
		SelectDropDownValue(RenewalDrp,Endorsment1);
		waitForElementToAppear(RiskRefFirst,3);
		verifyMustExists(RiskRefFirst,"Risk Referance");
		sendKeys(RiskRefFirst,val1,"Risk Referance");

		SelectDropDownValue(NewDrp,Endorsment2);

		waitForElementToAppear(RiskRefSecond,3);
		verifyMustExists(RiskRefSecond,"Risk Referance");
		sendKeys(RiskRefSecond,val2,"Risk Referance");

		verifyMustExists(ContinueBtn,"Continue button");
		click(ContinueBtn,"Continue button");
		sleep(2000);
	}
	
	public void EndorsmentContinueSecond(){
		//waitForElementToAppear(EndrsmntDrp,3);
		if(isVisible(EndrsmntDrp)==true){
			SelectDropDownValue(EndrsmntDrp,NewVal);

			sleep(1500);	
			SelectDropDownValue(EndrsmntDrp2,NewVal2);
			sleep(1500);
			SelectDropDownValue(EndrsmntDrp3,NewVal2);
			
			waitForElementToAppear(ContinueBtn,3);
			verifyMustExists(ContinueBtn,"Continue button");
			click(ContinueBtn,"Continue button");
			sleep(2000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}
	public void EndorsmentContinueSecond_3541(){
		//waitForElementToAppear(EndrsmntDrp,3);
		if(isVisible(EndrsmntDrp)==true){
			SelectDropDownValue(EndrsmntDrp,NewVal);

			sleep(1500);	
			SelectDropDownValue(EndrsmntDrp2,NewVal2);
			sleep(1500);
		//	SelectDropDownValue(EndrsmntDrp3,NewVal2);
			
			waitForElementToAppear(ContinueBtn,3);
			verifyMustExists(ContinueBtn,"Continue button");
			click(ContinueBtn,"Continue button");
			sleep(2000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}
	
	public void ChangeStasCanToNew(){
		//waitForElementToAppear(CancellatiotoNew,3);
		if(isVisible(CancellatiotoNew)==true){
			SelectDropDownValue(CancellatiotoNew,NewVal3);

			waitForElementToAppear(ContinueBtn,3);
			verifyMustExists(ContinueBtn,"Continue button");
			click(ContinueBtn,"Continue button");
			sleep(2000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void ReinstatementToCancl(){
		//waitForElementToAppear(ReinstatmentDrp,3);
		if(isVisible(ReinstatmentDrp)==true){
			SelectDropDownValue(ReinstatmentDrp,Cancellation1);

			sleep(1000);
			SelectDropDownValue(ReinstatmentDrp2,Cancellation2);

			waitForElementToAppear(ContinueBtn,3);
			verifyMustExists(ContinueBtn,"Continue button");
			click(ContinueBtn,"Continue button");
			sleep(2000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}
	
	public void ReinstatementToCancl1(){
		//waitForElementToAppear(ReinstatmentDrp,3);
		if(isVisible(ReinstatmentDrp)==true){
			SelectDropDownValue(ReinstatmentDrp,Cancellation1);

			sleep(1000);
			SelectDropDownValue(ReinstatmentDrp2,Cancellation2);
			sleep(1000);
			//if(isVisible(ReinstatmentDrp3)==true){
		//	SelectDropDownValue(ReinstatmentDrp3,Cancellation3);
		//	}
			waitForElementToAppear(ContinueBtn,3);
			verifyMustExists(ContinueBtn,"Continue button");
			click(ContinueBtn,"Continue button");
			sleep(2000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void EnrichedValChange(){
		//waitForElementToAppear(EnrichedValTxt,3);
		if(isVisible(EnrichedValTxt)==true){
			verifyMustExists(EnrichedValTxt,"Enriched value textbox");
			sendKeys(EnrichedValTxt,"10","Enriched Val Txt");
			waitForElementToAppear(ContinueBtnSave,3);
			verifyMustExists(ContinueBtnSave,"Continue button");
			click(ContinueBtnSave,"Continue button");
			sleep(2000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void TideValChange(){
		//waitForElementToAppear(TideValDrp,3);
		if(isVisible(TideValDrp)==true){
			verifyMustExists(TideValDrp,"Tide value dropdown");
			click(TideValDrp,"Tide value dropdown");
			sleep(2000);
			waitForElementToAppear(TideDrpVal,3);
			if(isVisible(TideDrpVal)==true){
				verifyMustExists(TideDrpVal,"Tide Drp Val");
				click(TideDrpVal,"Tide Drp Val");			
				waitForElementToAppear(ContinueBtnSave,3);
				verifyMustExists(ContinueBtnSave,"Continue button");
				click(ContinueBtnSave,"Continue button");
				sleep(2000);
			}else{
				Report.LogInfo("DrpVal", "Expected dropdown value not displayed.", "FAIL");
			}
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void TideValChangeToUnitedKingdm(){
		//waitForElementToAppear(TideValDrp,3);
		if(isVisible(TideValDrp)==true){
			SelectDropDownValue1(TideValDrp,TideDrpValUK);
			waitForElementToAppear(ContinueBtnSave,3);
			verifyMustExists(ContinueBtnSave,"Continue button");
			click(ContinueBtnSave,"Continue button");
			sleep(2000);			

			if(isVisible(TideValDrp)==true){
				refreshPage();
				sleep(2000);
				SelectDropDownValue1(TideValDrp,TideDrpValUK);
				waitForElementToAppear(ContinueBtnSave,3);
				verifyMustExists(ContinueBtnSave,"Continue button");
				click(ContinueBtnSave,"Continue button");
				sleep(2000);
			}else{
				Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
			}
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void TideValUKToRMS(){
		//waitForElementToAppear(TideValDrp,3);
		if(isVisible(TideValDrp1)==true){
			verifyMustExists(TideValDrp1,"Tide value dropdown");
			click(TideValDrp1,"Tide value dropdown");
			sleep(1000);
			waitForElementToAppear(TideDrpValRMS,3);
			if(isVisible(TideDrpValRMS)==true){
				verifyMustExists(TideDrpValRMS,"Tide Drp Val");
				click(TideDrpValRMS,"Tide Drp Val");		
				waitForElementToAppear(ContinueBtnSave,3);
				verifyMustExists(ContinueBtnSave,"Continue button");
				click(ContinueBtnSave,"Continue button");
				sleep(2000);
			}else{
				Report.LogInfo("DrpVal", "Expected dropdown value not displayed.", "FAIL");
			}
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}


	public void ChangGrossPremTxtVal(){
		//waitForElementToAppear(TideValDrp,3);
		if(isVisible(GrossPremTxt)==true){
			verifyMustExists(GrossPremTxt,"Tide value dropdown");
			sendKeys(GrossPremTxt,"6576","Gross Prem Txt");	
			waitForElementToAppear(ContinueBtn,3);
			verifyMustExists(ContinueBtn,"Continue button");
			click(ContinueBtn,"Continue button");
			sleep(2000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void SubmitRecordAssesmentBtn(){
		if(isVisible(SbmtRcdAssmntBtn)==true){
			verifyMustExists(SbmtRcdAssmntBtn," submit records for assignment button");
			click(SbmtRcdAssmntBtn," submit records for assignment button");
			sleep(1000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void ForApprovalBtn(){
		if(isVisible(ForApprvl)==true){
			verifyMustExists(ForApprvl," For Approval button");
			click(ForApprvl," For Approval button");
			sleep(1000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void ForApprovalBtnSncdRow(){
		if(isVisible(ForApprvlScndRw)==true){
			verifyMustExists(ForApprvlScndRw," For Approval button");
			click(ForApprvlScndRw," For Approval button");
			sleep(1000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void ApprdBtn(){
		if(isVisible(ApprvdBtn)==true){
			verifyMustExists(ApprvdBtn," For Approval button");
			click(ApprvdBtn," For Approval button");
			sleep(1000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void NavigationCreditContrlTab(){
		if(isVisible(CreditCntrlCTab)==true){
			verifyMustExists(CreditCntrlCTab," Credit control tab");
			click(CreditCntrlCTab," Credit control tab");
			sleep(1000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void SelectDrpValOfFolder(){

		String paymntStFirstRw = "@xpath=.//*[@data-field='Payment_Status']//following::td[text()='Fully Paid']";
		String paymntStScndRw = "@xpath=.//*[@data-field='Payment_Status']//following::td[text()='Unpaid']";
		String paymntStthirdRw = "@xpath=.//*[@data-field='Payment_Status']//following::td[text()='Partially Paid']";
		String paymntStFourthRw = "@xpath=.//*[@data-field='Payment_Status']//following::td[text()='Over  Paid']";

		if(isVisible(paymntStFirstRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		if(isVisible(paymntStScndRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		if(isVisible(paymntStthirdRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		if(isVisible(paymntStFourthRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		String GRPFirstRw = "@xpath=.//*[@data-field='Gross_Premium_Written']//following::tr[1]//td[5][text()='1,000.00']";
		String GRPScndRw = "@xpath=.//*[@data-field='Gross_Premium_Written']//following::tr[2]//td[5][text()='1,000.00']";
		String GRPthirdRw = "@xpath=.//*[@data-field='Gross_Premium_Written']//following::tr[3]//td[5][text()='1,000.00']";
		String GRPFourthRw = "@xpath=.//*[@data-field='Gross_Premium_Written']//following::tr[4]//td[5][text()='1,000.00']";

		if(isVisible(GRPFirstRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		if(isVisible(GRPScndRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		if(isVisible(GRPthirdRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		if(isVisible(GRPFourthRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		String GRPPFirstRw = "@xpath=.//*[@data-field='Gross_Premium_Paid']//following::tr[1]//td[6][text()='1,000.00']";
		String GRPPScndRw = "@xpath=.//*[@data-field='Gross_Premium_Paid']//following::tr[2]//td[6][text()='0.00']";
		String GRPPthirdRw = "@xpath=.//*[@data-field='Gross_Premium_Paid']//following::tr[3]//td[6][text()='500.00']";
		String GRPPFourthRw = "@xpath=.//*[@data-field='Gross_Premium_Paid']//following::tr[4]//td[6][text()='1,500.00']";

		if(isVisible(GRPPFirstRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		if(isVisible(GRPPScndRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		if(isVisible(GRPPthirdRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		if(isVisible(GRPPFourthRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		String GROFirstRw = "@xpath=.//*[@data-field='Gross_Premium_Outstanding']//following::tr[2]//td[7][text()='1,000.00']";
		String GROScndRw = "@xpath=.//*[@data-field='Gross_Premium_Outstanding']//following::tr[3]//td[7][text()='500.00']";
		String GROthirdRw = "@xpath=.//*[@data-field='Gross_Premium_Outstanding']//following::tr[4]//td[7][text()='-500.00']";

		if(isVisible(GROFirstRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		if(isVisible(GROScndRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		if(isVisible(GROthirdRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}			
	}
	
	public void EnrichedValChange1(String value){
		//waitForElementToAppear(EnrichedValTxt,3);
		if(isVisible(EnrichedValTxt)==true){
			verifyMustExists(EnrichedValTxt,"Enriched value textbox");
			sendKeys(EnrichedValTxt,value,"Enriched Val Txt");
			waitForElementToAppear(ContinueBtnSave,3);
			verifyMustExists(ContinueBtnSave,"Continue button");
			click(ContinueBtnSave,"Continue button");
			sleep(2000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}
	
	
	public void TideValChange1(){
		if(isVisible(TideValDrp)==true){
			SelectDropDownValue1(TideValDrp,TideDrpVal);
			verifyMustExists(ContinueBtnSave,"Continue button");
			click(ContinueBtnSave,"Continue button");
			sleep(2000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void TideValChangeToUnitedKingdm1(String value ){
		if(isVisible(TideValDrp)==true){
			SelectDropDownValue1(TideValDrp,value);
			waitForElementToAppear(ContinueBtnSave,3);
			verifyMustExists(ContinueBtnSave,"Continue button");
			click(ContinueBtnSave,"Continue button");
			sleep(2000);			
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}



}