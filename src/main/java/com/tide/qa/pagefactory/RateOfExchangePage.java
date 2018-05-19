package com.tide.qa.pagefactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;

import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class RateOfExchangePage extends PageBase {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BordereauProcessPage borderauPage = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();

	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("ssMsddMMyy");
		String datetime = ft.format(dNow);
		return datetime;
	}

	public static String contractId;
	public static String sheet3377Path = "";
	public static String sheet3378Path = "";

	//public static final String ExchangeRateType="CTMA XE.com Exchange Rates";
	public static final String Editvalue="5555";

	//Rate of Exchange link 
	public static final String RateOfExchangeLink = "@linkText=Rates of Exchange";

	//Rate of exchange page
	public static final String RateOfExchangePageLbl = "@xpath=//*[text()='Rates Of Exchange']";
	public static final String ExchangeTypeFilter ="@xpath=//th[@data-field='ExchangeRateTypeString']//a//span";
	public static final String SearchFilterTxt ="@css=[placeholder='Search']";
	public static final String FilterBtn="@buttonText=Filter";
	public static final String openselectedExchangeRate= "@xpath=//*[@ng-bind='dataItem.ExchangeRateTypeString']";

	//edit page locator
	public static final String RateOfExchnageTxt= "@xpath=//*[@ng-model='data.RateOfExchange']";
	public static final String SaveChangesBtn="@xpath=//button[@ng-click='update()']";
	public static final String RateOfExchangeValue= "@xpath=//*[@ng-bind='dataItem.RateOfExchange']";

	//upload file page locator
	public static final String UploadBtn="@xpath=//button[@ng-click='uploadPopup()']";
	public static final String ExchangeRateDD="@xpath=//*[@name='form.addEditData']//*[text()='Exchange Rate Type']/..//*[@class='form-group']";
	public static final String ExchangeRateDDValue = "@xpath=//li[contains(text(),'Lloyd')]";
	public static final String AccountingPeriodDD="@xpath=//*[@name='form.addEditData']//*[text()='Accounting Period']/..//*[@class='form-group']";
	public static final String AccountingPeriodDDValue = "@xpath=//li[contains(text(),'201708')]";
	public static final String FileUploadBtn="@xpath=//button[@ng-click='save()']";

	public static final String errorMsg="@xpath=//*[@ng-if='hasError'][contains(text(),'Invalid File Type')]";
	public static final String TideExchangRate="@xpath=//tr[1]//*[@ng-bind='dataItem.ExchangeRateTypeString']";

	public void editRateOfExchange_3376() throws InterruptedException
	{
		String ExchangeRateType="CTMA XE.com Exchange Rates";
		String Expectedvalue="5,555.00000";
		homePage.adminMenu();
		rateOfExhangeLink();
		rateOfExhangePage();
		applyExchangeTypeFilter(ExchangeRateType);
		openSelectedExchangeRateType();
		editdetails(Editvalue);
		waitForElementToAppear(RateOfExchangeValue,5);
		verifyMustExists(RateOfExchangeValue,"Rate of Exchange value"); 
		String Actualvalue= getTextFrom(RateOfExchangeValue);
		sleep(2000);
		if(Actualvalue.equals(Expectedvalue))
		{
			Report.LogInfo("ValidateUpdatedValue", "Upadated value validate successfully", "PASS");	
		}
		else
		{
			Report.LogInfo("ValidateUpdatedValue", "Updated value not validate successfully", "Fail");
		}	
	}


	public void uploadInvalidFile_3377() throws Exception
	{
		String ExpectedError="Invalid File Type";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String RequestURL= Configuration.url+"/api/FileStorage/UploadFile/7";

		refreshPage();
		rateOfExhangePage();
		verifyuploadbutton();
	
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3377Path = fpath+"\\src\\test\\resources\\testdata\\error1.png";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File excelFile = new File(sheet3377Path);
		String contractId = uploadFileInvalid(RequestURL, excelFile);
		//System.out.println(contractId);
		String ActualError=contractId;
		sleep(2000);
		if(ActualError.equals(ExpectedError))
		{
			Report.LogInfo("ValidateErrorMessage", "Error Message validate successfully", "PASS");	
		}
		else
		{
			Report.LogInfo("ValidateErrorMessage", "Error Message validate successfully", "FAIL");
		}	
	}



	public void uploadvalidFile_3378() throws Exception
	{
		String ExchangeRateType="Tide Exchange Rate";
		homePage.adminMenu();
		rateOfExhangeLink();
		rateOfExhangePage();
		verifyuploadbutton();
		String ReqUrl= Configuration.url+"/api/FileStorage/UploadFile/7";
		String DraftUrl = Configuration.url+"/api/FileStorage/GetRatesOfExchangeSheet";
		String payload = "{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S67076420180119.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":24080,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"AccountingPeriodId\":\"24\",\"ExchangeRateType\":\"1\",\"OpenFlag\":0}";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3378Path = fpath+"\\src\\test\\resources\\testdata\\ExchangeRateTemplate_TC_3378.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3378Path);
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		waitForElementToAppear(borderauPage.RefreshAfterUpload,5);
		refreshPage();
		sleep(2000);
		applyExchangeTypeFilter1(ExchangeRateType);
		if(isVisible(TideExchangRate)==true){
			Report.LogInfo("ValidateTideExchangeRate","Tide Exchange Rate displayed", "PASS");
			waitForElementToAppear(TideExchangRate,5);
			verifyMustExists(TideExchangRate,"");	
		}else{
			Report.LogInfo("ValidateTideExchangeRate","Tide Exchange Rate not  displayed", "FAIL");
		}
	}




	//==========================================================Reusable function ===========================================================================


	public void rateOfExhangeLink()
	{
		waitForElementToAppear(RateOfExchangeLink,5);
		verifyMustExists(RateOfExchangeLink,"Rate of Exchange Link");
		click(RateOfExchangeLink,"Rate of Exchange Link");
	}

	public void rateOfExhangePage()
	{
		if(isVisible(RateOfExchangePageLbl)==true){
			waitForElementToAppear(RateOfExchangePageLbl,5);
			verifyMustExists(RateOfExchangePageLbl,"Rate of exchange Lbl");	
		}else{
			Report.LogInfo("ValidateRateOfExchangePage", "Rate of Exhcnage page not displayed", "FAIL");
		}
	}

	public void applyExchangeTypeFilter (String ExchangeName){
		int i=0;
		String RecordCheckbox ="@xpath=//li//span[contains(text(),'"+ExchangeName+"')]";
		//sleep(3000);
		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(ExchangeTypeFilter, "Exchange Rate Type Filter");
			sleep(2000);
			if(isVisible(SearchFilterTxt))
			{
				verifyMustExists(SearchFilterTxt,"Search Filter Textbox");	
				sendKeys(SearchFilterTxt,ExchangeName,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);

		click(RecordCheckbox, "Searched Record Checkbox");
		verifyMustExists(FilterBtn,"Filter Button");	
		click(FilterBtn,"Filter Button");
	}


	public void applyExchangeTypeFilter1 (String ExchangeName){
		int i=0;
		String RecordCheckbox ="@xpath=//li//span[contains(text(),'"+ExchangeName+"')]";
		//sleep(3000);
		javaScriptWait();


		if(i>0)
		{
			refreshPage();
			javaScriptWait();
		}
		for( i= 0; i<=5; i++)
		{

			click(ExchangeTypeFilter,"Exchange Rate Type Filter");
			sleep(2000);
			if(isVisible(SearchFilterTxt)==true)
			{
				break;
			}
		}
		verifyMustExists(SearchFilterTxt,"Search Filter Textbox");	
		sendKeys(SearchFilterTxt,ExchangeName,"Search Filter Textbox.");
		sleep(2000);
		if(isVisible(RecordCheckbox)==true){
			click(RecordCheckbox, "Searched Record Checkbox");
			verifyMustExists(FilterBtn,"Filter Button");	
			click(FilterBtn,"Filter Button");
			sleep(3000);
			Report.LogInfo("ValidateSelectedExchangeType", "Selected Exchange Type displayed", "PASS");
		}else{
			verifyMustExists(FilterBtn,"Filter Button");	
			click(FilterBtn,"Filter Button");
			Report.LogInfo("ValidateSelectedExchangeType", "Selected Exchange Type not displayed", "FAIL");
		}

	}

	public void openSelectedExchangeRateType()
	{
		if(isVisible(openselectedExchangeRate)==true){
			waitForElementToAppear(openselectedExchangeRate,3);
			verifyMustExists(openselectedExchangeRate,"Rate of Exchange type");
			click(openselectedExchangeRate,"Rate of Exchange type");
		}else{
			Report.LogInfo("ValidateSelectedExchangeType", "Selected Exhcange Type not displayed", "FAIL");
		}
	}

	public void editdetails(String value)
	{
		waitForElementToAppear(RateOfExchnageTxt,3);
		if(isVisible(RateOfExchnageTxt)==true){
			verifyMustExists(RateOfExchnageTxt,"Selected Policy");
			sendKeys(RateOfExchnageTxt,value,"Rate of exchange text field");
			verifyMustExists(SaveChangesBtn,"Save Changes button");
			click(SaveChangesBtn,"Save Changes button");
		}else{
			Report.LogInfo("ValidateRateOFExchangeEditPage", "Rate of Exchange edit page not displayed", "FAIL");
		}
	}

	public void verifyuploadbutton()
	{
		if(isVisible(UploadBtn)==true){
			waitForElementToAppear(UploadBtn,3);
			verifyMustExists(UploadBtn,"upload button");
		}else{
			Report.LogInfo("ValidateUpaloadButton", "Upload Button not displayed", "FAIL");
		}
	}

	/*public void uploadFileDetails(String ERateDDValue,String APeriodDDvalue)
	{
		waitForElementToAppear(UploadBtn,3);
		verifyMustExists(UploadBtn,"upload button");
		click(UploadBtn,"upload button");
		waitForElementToAppear(ExchangeRateDD,5);
		verifyMustExists(ExchangeRateDD,"Exchange Rate dropdown");
		click(ExchangeRateDD,"Exchange Rate dropdown");
		javaScriptWait();
		verifyMustExists(ERateDDValue,"Lloyd's dropdown value");
		click(ERateDDValue,"Lloyd's drop down value");
		verifyMustExists(AccountingPeriodDD,"Accounting Period Dropdown");
		click(AccountingPeriodDD,"Accounting period dropdown");
		javaScriptWait();
		verifyMustExists(APeriodDDvalue,"Rate of Exchange type");
		click(APeriodDDvalue,"201708 dropdown value");

	}*/




}
