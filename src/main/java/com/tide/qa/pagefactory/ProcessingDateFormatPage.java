package com.tide.qa.pagefactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class ProcessingDateFormatPage extends PageBase{
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

	public static String sheet3984Path = "";
	public static String sheet3984PathScnd = "";


	public static final String onlyCurrentIcon="@xpath=//label[text()='Only Current']/../label[2]";
	public static final String EnrchValDate="@xpath=//*[@ng-model='item.EnrichData']";
	public static final String ContinueBtn="@xpath=//*[@id='content']//button[@ng-click='save()']";
	public static final String CancelBtn="@xpath=//*[@id='content']//button[@ng-click='cancel()']";
	public static final String Okbtn="@xpath=//div[@ng-click='cancel()']";
	
	public void usToUkdate_3984() throws Exception{
		String subSheet="SP - First Sheet (Automation Schema)";
		String IncDate ="01/01/2017";
		String ExpDate="31/12/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.addPolicy2(IncDate, ExpDate);
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		//String pol1 ="162169SQ";
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		//BordereauPage.applyFilterPolicy("506290HF");
		BordereauPage.openSelectedPolicy();
		policy.contractId = ReturnContractID();
		BordereauPage.SubmitBordereaux(subSheet);	

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3984Path = fpath+"\\src\\test\\resources\\testdata\\us_to_uk_formatTC_3984.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3984Path);  
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"us_to_uk_formatTC_3984.xlsx\",\"UniqueFileName\":\"S40285020180005.xlsx\",\"BordereauFormatId\":\"cfa01995-b545-4567-a8d9-c15df85345fd\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S40285020180005.xlsx\",\"Filesize\":19333,\"Path\":null,\"size\":19333,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauPage.refreshUploadedFile();
		if(isVisible(BordereauPage.ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			BordereauPage.openDATALink();
			BordereauPage.navigateToDATARiskTab();
			//RiskInceptionDate
			BordereauPage.selectRowNumberAscOrder();
			String RiskInceptionDatecolumn="@xpath=//*[@data-field='RiskInceptionDate']";

			String RiskInceptionDate1="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[1]//td[contains(@ng-click,'RiskInceptionDate')][1][text()='14/01/2017']";
			String RiskInceptionDate2="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[2]//td[contains(@ng-click,'RiskInceptionDate')][1][text()='25/01/2017']";
			String RiskInceptionDate3="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[3]//td[contains(@ng-click,'RiskInceptionDate')][1][text()='14/01/2017']";
			String RiskInceptionDate4="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[4]//td[contains(@ng-click,'RiskInceptionDate')][1][text()='01/01/2017']";
			String RiskInceptionDate5="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[5]//td[contains(@ng-click,'RiskInceptionDate')][1][text()='01/01/2017']";
			waitForElementToAppear(RiskInceptionDatecolumn,5);
			mouseOverAction(RiskInceptionDatecolumn);
			verifyMustExists(RiskInceptionDatecolumn,"RiskInceptionDate column");
			sleep(2000);
			verifyExists(RiskInceptionDate1,"1st value");
			verifyExists(RiskInceptionDate2,"2nd value");
			verifyExists(RiskInceptionDate3,"3rd value");
			verifyExists(RiskInceptionDate4,"4th value");
			verifyExists(RiskInceptionDate5,"5th value");
			sleep(2000);
			//RiskExpiryDate
			String RiskExpiryDatecolumn="@xpath=//*[@data-field='RiskExpiryDate']";
			sleep(2000);
			String RiskExpiryDate1="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[1]//td[contains(@ng-click,'RiskExpiryDate')][1][text()='31/01/2017']";
			String RiskExpiryDate2="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[2]//td[contains(@ng-click,'RiskExpiryDate')][1][text()='31/01/2017']";
			String RiskExpiryDate3="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[3]//td[contains(@ng-click,'RiskExpiryDate')][1][text()='25/01/2017']";
			String RiskExpiryDate4="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[4]//td[contains(@ng-click,'RiskExpiryDate')][1][text()='25/01/2017']";
			String RiskExpiryDate5="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[5]//td[contains(@ng-click,'RiskExpiryDate')][1][text()='25/01/2017']";
			waitForElementToAppear(RiskExpiryDatecolumn,5);
			mouseOverAction(RiskExpiryDatecolumn);
			verifyMustExists(RiskExpiryDatecolumn,"RiskExpiryDate column");
			sleep(2000);
			verifyExists(RiskExpiryDate1,"1st value");
			verifyExists(RiskExpiryDate2,"2nd value");
			verifyExists(RiskExpiryDate3,"3rd value");
			verifyExists(RiskExpiryDate4,"4th value");
			verifyExists(RiskExpiryDate5,"5th value");
			sleep(2000);
			policy.navigationOnBordereauxTab();
			BordereauPage.refreshUploadedFile();
			BordereauPage.deleteBorderEAUX();
			
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3984PathScnd = fpath+"\\src\\test\\resources\\testdata\\us_to_uk_format_3984Scnd.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile1 = new File(sheet3984PathScnd);  
			String payload1 = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"us_to_uk_format_3984Scnd.xlsx\",\"UniqueFileName\":\"S18096120180127.xlsx\",\"BordereauFormatId\":\"e1f3d92f-bd74-4e8a-b3c2-2eb5f4d3bb9c\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S18096120180127.xlsx\",\"Filesize\":19316,\"Path\":null,\"size\":19316,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile1, payload1, DraftUrl);
			BordereauPage.refreshUploadedFile();
			
			if(BordereauPage.checkErrorReviewButton(BordereauPage.ReviewError) == true){
				
				if(isVisible(EnrchValDate)==true){
					verifyExists(EnrchValDate,"Enriched value test box");
					sendKeys(EnrchValDate,"25/02/2017","Date change");
					waitForElementToAppear(ContinueBtn,5);
					verifyExists(ContinueBtn,"Continue button");
					click(ContinueBtn,"Continue button");
					waitForElementToAppear(CancelBtn,5);
					verifyExists(CancelBtn,"Cancel button");
					click(CancelBtn,"Cancel button");
					
					BordereauPage.openDATALink();
					BordereauPage.navigateToDATARiskTab();
					//RiskInceptionDate
					BordereauPage.selectRowNumberAscOrder();
					
					String RiskExpiryDate4New="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[4]//td[contains(@ng-click,'RiskExpiryDate')][1][text()='25/02/2017']";
					
					String RiskExpiryDate11="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[1]//td[contains(@ng-click,'RiskExpiryDate')][1][text()='31/01/2017']";
					String RiskExpiryDate22="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[2]//td[contains(@ng-click,'RiskExpiryDate')][1][text()='31/01/2017']";
					String RiskExpiryDate33="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[3]//td[contains(@ng-click,'RiskExpiryDate')][1][text()='25/02/2017']";
					String RiskExpiryDate44="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[4]//td[contains(@ng-click,'RiskExpiryDate')][1][text()='25/01/2017']";
					String RiskExpiryDate55="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[5]//td[contains(@ng-click,'RiskExpiryDate')][1][text()='25/01/2017']";
					String runeName = "@xpath=//form[@name='form.Enrichment']//*[text()='Validate Date values']";
					
					//String RiskExpiryDatecolumn="@xpath=//*[@data-field='RiskExpiryDate']";

					waitForElementToAppear(RiskExpiryDatecolumn,5);
					mouseOverAction(RiskExpiryDatecolumn);
					verifyMustExists(RiskExpiryDatecolumn,"RiskExpiryDate column");
					sleep(2000);

					verifyExists(RiskExpiryDate33,"3rd value");
					verifyExists(RiskExpiryDate11,"1st value");
					verifyExists(RiskExpiryDate22,"2nd value");
					verifyExists(RiskExpiryDate44,"4th value");
					verifyExists(RiskExpiryDate55,"5th value");
					
					click(RiskExpiryDate33,"4th value");
					sleep(3000);
					waitForElementToAppear(runeName,5);
					verifyExists(runeName,"rule name");
					verifyExists(Okbtn,"Ok button");
					click(Okbtn,"Ok button");
					sleep(2000);
				}else{
					Report.LogInfo("ScreenCheck", "Expected screen not displayed.", "Fail"); 
				}
			}else{
				Report.LogInfo("ValidateReviewStatus", "Review error status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}
			
		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
			BordereauPage.deleteBorderEAUX();
		}
	}

}
