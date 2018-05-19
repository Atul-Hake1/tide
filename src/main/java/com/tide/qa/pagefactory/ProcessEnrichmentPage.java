package com.tide.qa.pagefactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class ProcessEnrichmentPage extends PageBase{
	LoginPage loginPage = new LoginPage();
	BordereauQuePage BQPage = new BordereauQuePage();
	BordereauProcessPage BordereauPage = new BordereauProcessPage();
	HomePage homePage = new HomePage();
	DatasetReferenceDataPage datasetPage = new DatasetReferenceDataPage();
	PolicyPage policy = new PolicyPage();
	FinancialCalculationRiskAndPremiumPage FCRPpage = new FinancialCalculationRiskAndPremiumPage ();
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

	public static String sheet3879Path = "";
	public static String sheet3880Path = "";
	public static String sheet3881Path = "";
	public static String sheet3882Path = "";
	public static String sheet3882secondPath = "";
	public static String sheet3890Path = "";
	public static String sheet3893Path = "";
	public static String sheet3894Path = "";
	public static String sheet3987Path = "";
	public static String sheet3988Path = "";
	public static String sheet3992Path = "";
	public static String sheet5337Path = "";

	public static final String ContractCurrrency="@xpath=//*[@id='profile-main']//*[text()='GBP - British Pound']";
	public static final String Verify10PercentCoverholderCommission="@xpath=//dt[contains(.,'Coverholder Commission')]/..//dd";
	public static final String Okbtn="@xpath=//*[@ng-click='cancel()']";
	public static final String RuleNameField="@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[6]";
	public static final String RuleNameRiskExpiryDate="@xpath=//*[@uib-popover='Risk Expiry Date defaulted from the Risk Inception Date plus 1 year']";
	public static final String OriginalValue="@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[3]";
	public static final String ChangedValue="@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[4]";
	public static final String EfectiveDate="@xpath=.//tr[1]//td[contains(@ng-click,'Endorsement Effective Date')]";
	public static final String RuleName="@xpath=//td//div[text()='Use of Risk Inception Date as Endorsement Effective Date']";
	
	public void extractYOA_3879() throws Exception{
		String subSheet="Process Enrichment Format (Automation Schema)";
		String IncDate = "01/01/2017";
		String ExpDate="01/01/2018";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
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
			sheet3879Path = fpath+"\\src\\test\\resources\\testdata\\YOAFrom_sheet_name_TC_3879.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3879Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"YOAFrom_sheet_name_TC_3879.xlsx\",\"UniqueFileName\":\"S49248220180025.xlsx\",\"BordereauFormatId\":\"bc2ca3dd-d933-4930-8989-a65bf0499b82\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S49248220180025.xlsx\",\"Filesize\":18482,\"Path\":null,\"size\":18482,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";		
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauPage.refreshUploadedFile();
		if(isVisible(BordereauPage.ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			BordereauPage.openDATALink();
			BordereauPage.navigateToDATARiskTab();
			//Row number column 
			//YearOfAccount
			String YearOfAccountcolumn="@xpath=//*[@data-field='YearOfAccount']";
			String YearOfAccount1="@xpath=//*[@data-field='YearOfAccount']//following::tr[1]//td[contains(@ng-click,'YearOfAccount')][text()='2017']";
			String YearOfAccount2="@xpath=//*[@data-field='YearOfAccount']//following::tr[2]//td[contains(@ng-click,'YearOfAccount')][text()='2017']";
			String YearOfAccount3="@xpath=//*[@data-field='YearOfAccount']//following::tr[3]//td[contains(@ng-click,'YearOfAccount')][text()='2017']";
			String YearOfAccount4="@xpath=//*[@data-field='YearOfAccount']//following::tr[4]//td[contains(@ng-click,'YearOfAccount')][text()='2017']";
			String YearOfAccount5="@xpath=//*[@data-field='YearOfAccount']//following::tr[5]//td[contains(@ng-click,'YearOfAccount')][text()='2017']";
			waitForElementToAppear(YearOfAccountcolumn,20);
			mouseOverAction(YearOfAccountcolumn);
			verifyMustExists(YearOfAccountcolumn,"Year Of Account column");
			sleep(2000);
			verifyExists(YearOfAccount1,"1st value");
			verifyExists(YearOfAccount2,"2nd value");
			verifyExists(YearOfAccount3,"3rd value");
			verifyExists(YearOfAccount4,"4th value");
			verifyExists(YearOfAccount5,"5th value");
			sleep(2000);
		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
			BordereauPage.deleteBorderEAUX();
		}
	}

	public void deriveBrokeragePercentage_3880() throws Exception{
		String subSheet="Process Enrichment Format (Automation Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn,10);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			policy.navigationOnBordereauxTab();
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				// london brokerage % Column 
				String London_Brokerage_Percentcolumn="@xpath=//*[@data-field='London_Brokerage_Percent']";
				String London_Brokerage_Percent1="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[1]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='10.00 %']";
				String London_Brokerage_Percent2="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[2]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='10.00 %']";
				String London_Brokerage_Percent3="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[3]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='10.00 %']";
				String London_Brokerage_Percent4="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[4]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='10.00 %']";
				String London_Brokerage_Percent5="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[5]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='10.00 %']";
				waitForElementToAppear(London_Brokerage_Percentcolumn,5);
				mouseOverAction(London_Brokerage_Percentcolumn);
				verifyMustExists(London_Brokerage_Percentcolumn,"London_Brokerage_Percent column");
				sleep(2000);
				verifyExists(London_Brokerage_Percent1,"1st value");
				verifyExists(London_Brokerage_Percent2,"2nd value");
				verifyExists(London_Brokerage_Percent3,"3rd value");
				verifyExists(London_Brokerage_Percent4,"4th value");
				verifyExists(London_Brokerage_Percent5,"4th value");
				sleep(2000);	
				policy.navigateToSectionTab();
				policy.navigateToSectionDotEdit();
				policy.EditBrekaregeSection("0");
				BordereauPage.SubmitBordereaux(subSheet);	
		
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet3880Path = fpath+"\\src\\test\\resources\\testdata\\YOAFrom_sheet_name_TC_3880.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File excelFile = new File(sheet3880Path);  

				//contractId = addNewBordereauFormatPolicy(payload1, GetData);
				String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"YOAFrom_sheet_name_TC_3880.xlsx\",\"UniqueFileName\":\"S83349820180025.xlsx\",\"BordereauFormatId\":\"bc2ca3dd-d933-4930-8989-a65bf0499b82\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S83349820180025.xlsx\",\"Filesize\":18482,\"Path\":null,\"size\":18482,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";				uploadFile(ReqUrl, excelFile, payload, DraftUrl);
				BordereauPage.refreshUploadedFile();
				if(isVisible(BordereauPage.ReviewBtn)== true){
					Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
					BordereauPage.openDATALink();
					BordereauPage.navigateToDATARiskTab();
					// london brokerage % Column = second
					String London_Brokerage_zeroPercentcolumn="@xpath=//*[@data-field='London_Brokerage_Percent']";
					String London_Brokerage_zeroPercent1="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[1]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='0.00 %']";
					String London_Brokerage_zeroPercent2="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[2]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='0.00 %']";
					String London_Brokerage_zeroPercent3="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[3]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='0.00 %']";
					String London_Brokerage_zeroPercent4="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[4]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='0.00 %']";
					String London_Brokerage_zeroPercent5="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[5]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='0.00 %']";
					waitForElementToAppear(London_Brokerage_zeroPercentcolumn,5);
					mouseOverAction(London_Brokerage_zeroPercentcolumn);
					verifyMustExists(London_Brokerage_zeroPercentcolumn,"London_Brokerage_Percent column");
					sleep(2000);
					verifyExists(London_Brokerage_zeroPercent1,"1st value");
					verifyExists(London_Brokerage_zeroPercent2,"2nd value");
					verifyExists(London_Brokerage_zeroPercent3,"3rd value");
					verifyExists(London_Brokerage_zeroPercent4,"4th value");
					verifyExists(London_Brokerage_zeroPercent5,"4th value");
					sleep(2000);
					policy.navigationOnBordereauxTab();
					BordereauPage.refreshUploadedFile();
					BordereauPage.deleteBorderEAUX();

				}else{
					Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
					BordereauPage.deleteBorderEAUX();
				}

			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}

	}

	public void removeISOcurrencycode_3881() throws Exception{
		String subSheet="SP - First Sheet";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		//String pol ="692166EX";
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
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn,10);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);	
			//String GetData = Configuration.url+"/api/Contract/GetAllPage";
			//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3881Path = fpath+"\\src\\test\\resources\\testdata\\Symbol_characteor_TC_3881.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3881Path);  

			String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Symbol_characteor_TC_3881.xlsx\",\"UniqueFileName\":\"S61490420180025.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S61490420180025.xlsx\",\"Filesize\":18801,\"Path\":null,\"size\":18801,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauPage.refreshUploadedFile();
			waitForElementToAppear(BordereauPage.ReviewBtn,20);
			if(isVisible(BordereauPage.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				BordereauPage.selectRowNumberAscOrder();
				// Gross_Premium Column 
				String Gross_Premiumcolumn="@xpath=//*[@data-field='Gross_Premium']";
				//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][2][text()='4,000.00']
				String Gross_Premium1="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][2][text()='1,000.00']";
				String Gross_Premium2="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][2][text()='4,000.00']";
				String Gross_Premium3="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium')][2][text()='8,000,000.00']";
				String Gross_Premium4="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium')][2][text()='1,000,000.00']";
				String Gross_Premium5="@xpath=//*[@data-field='Gross_Premium']//following::tr[5]//td[contains(@ng-click,'Gross_Premium')][2][text()='1,000,000,000.00']";
				String Gross_Premium6="@xpath=//*[@data-field='Gross_Premium']//following::tr[6]//td[contains(@ng-click,'Gross_Premium')][2][text()='1,000,000,000.00']";
				waitForElementToAppear(Gross_Premiumcolumn,20);
				mouseOverAction(Gross_Premiumcolumn);
				verifyMustExists(Gross_Premiumcolumn,"Gross_Premium column");
				sleep(2000);
				verifyExists(Gross_Premium1,"1st value");
				verifyExists(Gross_Premium2,"2nd value");
				verifyExists(Gross_Premium3,"3rd value");
				verifyExists(Gross_Premium4,"4th value");
				verifyExists(Gross_Premium5,"5th value");
				verifyExists(Gross_Premium6,"6th value");
				sleep(2000);
				//Coverholder commission column
				String Coverholder_commissioncolumn="@xpath=//*[@data-field='Coverholder_Commission']";
				String Coverholder_commission1="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='124.50']";
				String Coverholder_commission2="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='426.80']";
				String Coverholder_commission3="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='8,855.00']";
				String Coverholder_commission4="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='124.50']";
				String Coverholder_commission5="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[5]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='124.50']";
				String Coverholder_commission6="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[6]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='124.50']";
				String ValidateData ="@xpath=//td[contains(.,'Remove ISO currency code characters & symbols')]";
				String ValidatePopup ="@xpath=//h2[contains(.,'Coverholder Commission')]";
				String Ok="@xpath=//div[@ng-click='cancel()']";
				waitForElementToAppear(Coverholder_commissioncolumn,20);
				mouseOverAction(Coverholder_commissioncolumn);
				verifyMustExists(Coverholder_commissioncolumn,"Coverholder commission column");
				sleep(2000);
				verifyExists(Coverholder_commission1,"1st value");
				verifyExists(Coverholder_commission2,"2nd value");
				verifyExists(Coverholder_commission3,"3rd value");
				verifyExists(Coverholder_commission4,"4th value");
				verifyExists(Coverholder_commission5,"5th value");
				verifyExists(Coverholder_commission6,"6th value");
				sleep(2000);
				waitForElementToAppear(Coverholder_commission1,5);
				verifyExists(Coverholder_commission1,"1st value");
				click(Coverholder_commission1,"1st Coverholder name");
				sleep(2000);
				if(isVisible(ValidatePopup)==true)
				{
					Report.LogInfo("ValidateCoverholder_commission", "Coverholder commission popup  displayed.", "Pass"); 
					verifyExists(ValidatePopup,"Validate Popup");
					sleep(2000);
					verifyExists(ValidateData,"Validate Message");
					verifyExists(Ok,"Ok button");
					click(Ok,"Ok button");
					sleep(2000);
					policy.navigationOnBordereauxTab();
					BordereauPage.refreshUploadedFile();
					BordereauPage.deleteBorderEAUX();
				}
				else{
					Report.LogInfo("ValidateCoverholder_commission", "Coverholder commission popup not displayed.", "Fail"); 
					policy.navigationOnBordereauxTab();
					BordereauPage.refreshUploadedFile();
					BordereauPage.deleteBorderEAUX();					
				}
			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}

	}

	public void riskExpiryDate_3882() throws Exception{
		String subSheet="Process Enrichment Format (Automation Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String SubsheetName="Process Enrichment Format";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(SubsheetName);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn,10);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3882Path = fpath+"\\src\\test\\resources\\testdata\\Default Risk expair date_TC_3882.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3882Path);  
			//contractId = addNewBordereauFormatPolicy(payload1, GetData);
			String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Default Risk expair date_TC_3882.xlsx\",\"UniqueFileName\":\"S36583320171122.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S36583320171122.xlsx\",\"Filesize\":18316,\"Path\":null,\"size\":18316,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				//RiskExpiryDate
				String RiskExpiryDatecolumn="@xpath=//*[@data-field='RiskExpiryDate']";
				String RiskExpiryDate1="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[1]//td[contains(@ng-click,'RiskExpiryDate')][text()='31/12/2017']";
				String RiskExpiryDate2="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[2]//td[contains(@ng-click,'RiskExpiryDate')][text()='31/12/2017']";
				String RiskExpiryDate3="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[3]//td[contains(@ng-click,'RiskExpiryDate')][text()='31/12/2017']";
				String RiskExpiryDate4="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[4]//td[contains(@ng-click,'RiskExpiryDate')][text()='31/12/2017']";
				String RiskExpiryDate5="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[5]//td[contains(@ng-click,'RiskExpiryDate')][text()='31/12/2017']";		
				waitForElementToAppear(RiskExpiryDatecolumn,20);
				mouseOverAction(RiskExpiryDatecolumn);
				verifyMustExists(RiskExpiryDatecolumn,"RiskExpiryDate column");
				sleep(2000);
				verifyExists(RiskExpiryDate1,"1st value");
				verifyExists(RiskExpiryDate2,"2nd value");
				verifyExists(RiskExpiryDate3,"3rd value");
				verifyExists(RiskExpiryDate4,"4th value");
				verifyExists(RiskExpiryDate5,"5th value");
				BordereauPage.verifyBackground(RiskExpiryDate5,"rgba(0, 97, 0, 1)");
				sleep(2000);
				click(RiskExpiryDate5,"RiskExpiryDate5");
				waitForElementToAppear(Okbtn,5);
				verifyExists(RuleNameRiskExpiryDate,"Rule Name Field");
				click(Okbtn,"ok Buttton");
				sleep(2000);
			} else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}

	

	public void defaultValueCCPercentage_3884() throws Exception{
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn, 10);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			policy.navigationOnBordereauxTab();
			waitForElementToAppear(BordereauPage.ReviewBtn, 10);
			if(isVisible(BordereauPage.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				//Coverholder Commission percentage column 
				String CoverholderCommissionpercentagecolumn ="@xpath=//*[@data-field='Coverholder_Commission_Percent']";
				String CoverholderCommissionpercentage1="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='10.00 %']";
				String CoverholderCommissionpercentage2="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='10.00 %']";
				String CoverholderCommissionpercentage3="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='10.00 %']";
				String CoverholderCommissionpercentage4="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='10.00 %']";
				String CoverholderCommissionpercentage5="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[5]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='10.00 %']";		
				waitForElementToAppear(CoverholderCommissionpercentagecolumn,20);
				mouseOverAction(CoverholderCommissionpercentagecolumn);
				verifyMustExists(CoverholderCommissionpercentagecolumn,"Coverholder Commission percentage column");
				sleep(2000);
				verifyExists(CoverholderCommissionpercentage1,"1st value");
				verifyExists(CoverholderCommissionpercentage2,"2nd value");
				verifyExists(CoverholderCommissionpercentage3,"3rd value");
				verifyExists(CoverholderCommissionpercentage4,"4th value");
				verifyExists(CoverholderCommissionpercentage5,"5th value");
				sleep(2000);

			} else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}

	}


	public void riskExpiryDate_3890() throws Exception{
		String subSheet="Process Enrichment2 Format (Automation Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String SubmitSheet="Process Enrichment2 Format";
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
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn,5);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3890Path = fpath+"\\src\\test\\resources\\testdata\\Default Risk Expairy date_3890.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3890Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Default Risk Expairy date_3890.xlsx\",\"UniqueFileName\":\"S12836720180101.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S12836720180101.xlsx\",\"Filesize\":19304,\"Path\":null,\"size\":19304,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				//RiskExpiryDate
				String RiskExpiryDatecolumn="@xpath=//*[@data-field='RiskExpiryDate']";
				String RiskExpiryDate1="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[1]//td[contains(@ng-click,'RiskExpiryDate')][text()='31/01/2017']";
				String RiskExpiryDate2="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[2]//td[contains(@ng-click,'RiskExpiryDate')][text()='31/01/2017']";
				String RiskExpiryDate3="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[3]//td[contains(@ng-click,'RiskExpiryDate')][text()='31/01/2017']";
				String RiskExpiryDate4="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[4]//td[contains(@ng-click,'RiskExpiryDate')][text()='31/01/2017']";
				String RiskExpiryDate5="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[5]//td[contains(@ng-click,'RiskExpiryDate')][text()='31/01/2017']";

				waitForElementToAppear(RiskExpiryDatecolumn,10);
				mouseOverAction(RiskExpiryDatecolumn);
				verifyMustExists(RiskExpiryDatecolumn,"RiskExpiryDate column");
				sleep(2000);
				verifyExists(RiskExpiryDate1,"1st value");
				verifyExists(RiskExpiryDate2,"2nd value");
				verifyExists(RiskExpiryDate3,"3rd value");
				verifyExists(RiskExpiryDate4,"4th value");
				verifyExists(RiskExpiryDate5,"5th value");
				BordereauPage.verifyBackground(RiskExpiryDate5,"rgba(0, 97, 0, 1)");
				click(RiskExpiryDate5,"RiskExpiryDate5");
				waitForElementToAppear(Okbtn,5);
				verifyExists(RuleNameField,"Rule Name Field");
				click(Okbtn,"ok Buttton");
				sleep(2000);
				policy.navigationOnBordereauxTab();				
				
			} else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				//BordereauPage.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}

	}

	public void deriveCoverholderCommission_3891() throws Exception{
		String ExpectedValue="10%";
		//String pol ="692166EX";
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn, 10);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			policy.navigationOnBordereauxTab();
			waitForElementToAppear(BordereauPage.ReviewBtn, 5);
			if(isVisible(BordereauPage.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				//Coverholder Commission percentage column 
				String CoverholderCommissionpercentagecolumn ="@xpath=//*[@data-field='Coverholder_Commission_Percent']";
				String CoverholderCommissionpercentage1="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='10.00 %']";
				String CoverholderCommissionpercentage2="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='10.00 %']";
				String CoverholderCommissionpercentage3="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='10.00 %']";
				String CoverholderCommissionpercentage4="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='10.00 %']";
				String CoverholderCommissionpercentage5="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[5]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='10.00 %']";				String CHPercentagePopup = "@xpath=//h2[contains(.,'Coverholder Commission %')]";
				String ExpectedColor = "rgba(0, 97, 0, 1)";

				waitForElementToAppear(CoverholderCommissionpercentagecolumn,20);
				mouseOverAction(CoverholderCommissionpercentagecolumn);
				verifyMustExists(CoverholderCommissionpercentagecolumn,"Coverholder Commission percentage column");
				sleep(2000);
				verifyExists(CoverholderCommissionpercentage1,"1st value");

				verifyExists(CoverholderCommissionpercentage2,"2nd value");
				verifyExists(CoverholderCommissionpercentage3,"3rd value");
				verifyExists(CoverholderCommissionpercentage4,"4th value");
				verifyExists(CoverholderCommissionpercentage5,"5th value");

				BordereauPage.verifyBackground(CoverholderCommissionpercentage5,ExpectedColor);
				click(CoverholderCommissionpercentage5,"CC 5th value");
				sleep(2000);
				verifyExists(CHPercentagePopup,"Coverholder % Popup");
				sleep(2000);
				policy.navigateToSectionTab();
				waitForElementToAppear(Verify10PercentCoverholderCommission, 5);
				verifyExists(Verify10PercentCoverholderCommission,"Brokerage value");
				String actualBrokerage=getTextFrom(Verify10PercentCoverholderCommission);
				if(actualBrokerage.equals(ExpectedValue)){
					Report.LogInfo("ValidateBrokerageValue", "Expected Brokerage value is displayed successfully", "Pass");
				}else{
					Report.LogInfo("ValidateBrokerageValue", "Expected Brokerage value not displayed", "Fail");
				}			 

			} else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				//BordereauPage.deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}			

	}

	public void brokeragePercentageDefaultValue_3892() throws Exception{
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn, 10);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			policy.navigationOnBordereauxTab();
			waitForElementToAppear(BordereauPage.ReviewBtn, 10);
			if(isVisible(BordereauPage.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				//London_Brokerage_Percent column 
				String LondonBrokeragepercentagecolumn ="@xpath=//*[@data-field='London_Brokerage_Percent']";
				String LondonBrokeragepercentage1="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[1]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='7.00 %']";
				String LondonBrokeragepercentage2="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[2]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='7.00 %']";
				String LondonBrokeragepercentage3="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[3]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='7.00 %']";
				String LondonBrokeragepercentage4="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[4]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='7.00 %']";
				String LondonBrokeragepercentage5="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[5]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='7.00 %']";				 waitForElementToAppear(LondonBrokeragepercentagecolumn,20);
				mouseOverAction(LondonBrokeragepercentagecolumn);
				verifyMustExists(LondonBrokeragepercentagecolumn,"London Brokerage percentage column");
				sleep(2000);
				verifyExists(LondonBrokeragepercentage1,"1st value");
				verifyExists(LondonBrokeragepercentage2,"2nd value");
				verifyExists(LondonBrokeragepercentage3,"3rd value");
				verifyExists(LondonBrokeragepercentage4,"4th value");
				verifyExists(LondonBrokeragepercentage5,"5th value");
				sleep(2000);
				policy.navigationOnBordereauxTab();
				BordereauPage.deleteBorderEAUX();

			} else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}


	public void defaultCurrency_3893() throws Exception{
		String subSheet="Process Enrichment2 Format (Automation Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn, 10);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3893Path = fpath+"\\src\\test\\resources\\testdata\\Defult Currency _TC_3893.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3893Path);  

			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Defult Currency _TC_3893.xlsx\",\"UniqueFileName\":\"S88216320180025.xlsx\",\"BordereauFormatId\":\"173f5b48-f912-49fe-9a50-7e0b09567c82\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S88216320180025.xlsx\",\"Filesize\":19306,\"Path\":null,\"size\":19306,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				//Premium_Currency
				String PremiumCurrencycolumn="@xpath=//*[@data-field='Premium_Currency']";
				String PremiumCurrency1="@xpath=//*[@data-field='Premium_Currency']//following::tr[1]//td[contains(@ng-click,'Premium_Currency')][text()='USD']";
				String PremiumCurrency2="@xpath=//*[@data-field='Premium_Currency']//following::tr[2]//td[contains(@ng-click,'Premium_Currency')][text()='USD']";
				String PremiumCurrency3="@xpath=//*[@data-field='Premium_Currency']//following::tr[3]//td[contains(@ng-click,'Premium_Currency')][text()='USD']";
				String PremiumCurrency4="@xpath=//*[@data-field='Premium_Currency']//following::tr[4]//td[contains(@ng-click,'Premium_Currency')][text()='USD']";
				String PremiumCurrency5="@xpath=//*[@data-field='Premium_Currency']//following::tr[5]//td[contains(@ng-click,'Premium_Currency')][text()='USD']";
				waitForElementToAppear(PremiumCurrencycolumn,20);
				mouseOverAction(PremiumCurrencycolumn);
				verifyMustExists(PremiumCurrencycolumn,"Premium Currency column");
				sleep(2000);
				verifyExists(PremiumCurrency1,"1st value");
				verifyExists(PremiumCurrency2,"2nd value");
				verifyExists(PremiumCurrency3,"3rd value");
				verifyExists(PremiumCurrency4,"4th value");
				verifyExists(PremiumCurrency5,"5th value");
				sleep(2000);
				policy.navigationOnBordereauxTab();
				BordereauPage.deleteBorderEAUX();

			} else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL"); 
				BordereauPage.deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}

	}

	public void deriveCurrency_3894() throws Exception{
		String subSheet="Process Enrichment3 Format (Automation Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		//BordereauPage.applyFilterPolicy("586014DU");
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn, 10);
		verifyExists(ContractCurrrency,"GBP contract currency");
		if(isVisible(BordereauPage.SignedBtn )&&isVisible(ContractCurrrency) == true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			verifyExists(ContractCurrrency,"GBP contract currency");
			BordereauPage.SubmitBordereaux(subSheet);
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3894Path = fpath+"\\src\\test\\resources\\testdata\\Derive the Currency relevant contract_TC_3894.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3894Path);  
			//contractId = addNewBordereauFormatPolicy(payload1, GetData);
			String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Derive the Currency relevant contract_TC_3894.xlsx\",\"UniqueFileName\":\"S19212520180025.xlsx\",\"BordereauFormatId\":\"104ba4c7-98e7-4b4d-9309-c6aa783232e1\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S19212520180025.xlsx\",\"Filesize\":19307,\"Path\":null,\"size\":19307,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";			
			//String payload ="{\"Bordereaux\":{\"ContractId\":\"783b1ed1-3232-4164-a683-50e5ca47418a\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Derive the Currency relevant contract_TC_3894.xlsx\",\"UniqueFileName\":\"S19212520180025.xlsx\",\"BordereauFormatId\":\"104ba4c7-98e7-4b4d-9309-c6aa783232e1\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S19212520180025.xlsx\",\"Filesize\":19307,\"Path\":null,\"size\":19307,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";			
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauPage.refreshUploadedFile();

			if(isVisible(BordereauPage.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				//Premium_Currency
				String RiskCurrencycolumn="@xpath=//*[@data-field='Premium_Currency']";
				String RiskCurrency1="@xpath=//*[@data-field='Premium_Currency']//following::tr[1]//td[contains(@ng-click,'Premium_Currency')][text()='GBP']";
				String RiskCurrency2="@xpath=//*[@data-field='Premium_Currency']//following::tr[2]//td[contains(@ng-click,'Premium_Currency')][text()='GBP']";
				String RiskCurrency3="@xpath=//*[@data-field='Premium_Currency']//following::tr[3]//td[contains(@ng-click,'Premium_Currency')][text()='GBP']";
				String RiskCurrency4="@xpath=//*[@data-field='Premium_Currency']//following::tr[4]//td[contains(@ng-click,'Premium_Currency')][text()='GBP']";
				String RiskCurrency5="@xpath=//*[@data-field='Premium_Currency']//following::tr[5]//td[contains(@ng-click,'Premium_Currency')][text()='GBP']";
				waitForElementToAppear(RiskCurrencycolumn,20);
				mouseOverAction(RiskCurrencycolumn);
				verifyMustExists(RiskCurrencycolumn,"Risk Currency column");
				sleep(2000);
				verifyExists(RiskCurrency1,"1st value");
				verifyExists(RiskCurrency2,"2nd value");
				verifyExists(RiskCurrency3,"3rd value");
				verifyExists(RiskCurrency4,"4th value");
				verifyExists(RiskCurrency5,"5th value");
				sleep(2000);
				//Risk_Currency
				String PremiumCurrencycolumn="@xpath=//*[@data-field='Risk_Currency']";
				String PremiumCurrency1="@xpath=//*[@data-field='Risk_Currency']//following::tr[1]//td[contains(@ng-click,'Risk_Currency')][text()='GBP']";
				String PremiumCurrency2="@xpath=//*[@data-field='Risk_Currency']//following::tr[2]//td[contains(@ng-click,'Risk_Currency')][text()='GBP']";
				String PremiumCurrency3="@xpath=//*[@data-field='Risk_Currency']//following::tr[3]//td[contains(@ng-click,'Risk_Currency')][text()='GBP']";
				String PremiumCurrency4="@xpath=//*[@data-field='Risk_Currency']//following::tr[4]//td[contains(@ng-click,'Risk_Currency')][text()='GBP']";
				String PremiumCurrency5="@xpath=//*[@data-field='Risk_Currency']//following::tr[5]//td[contains(@ng-click,'Risk_Currency')][text()='GBP']";
				waitForElementToAppear(PremiumCurrencycolumn,20);
				mouseOverAction(PremiumCurrencycolumn);
				verifyMustExists(PremiumCurrencycolumn,"Premium Currency column");
				sleep(2000);
				verifyExists(PremiumCurrency1,"1st value");
				verifyExists(PremiumCurrency2,"2nd value");
				verifyExists(PremiumCurrency3,"3rd value");
				verifyExists(PremiumCurrency4,"4th value");
				verifyExists(PremiumCurrency5,"5th value");
				sleep(2000);
				policy.navigationOnBordereauxTab();
				BordereauPage.deleteBorderEAUX();

			} else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL"); 
				BordereauPage.deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}

	}

	public void TotalInsurableValue_3987() throws Exception{
		String subSheet="Total insured value (TIV Schema)";
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
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
			sheet3987Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3987.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3987Path); 
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3987.xlsx\",\"UniqueFileName\":\"S86216120171128.xlsx\",\"BordereauFormatId\":\"efb80c40-74c8-44fe-9f78-29225c728ec5\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S86216120171128.xlsx\",\"Filesize\":25020,\"Path\":null,\"size\":25020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauPage.refreshUploadedFile();
		if(isVisible(BordereauPage.ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			BordereauPage.openDATALink();
			BordereauPage.navigateToDATARiskTab();
			//Total_Sum_Insured
			String TotalSumInsuredcolumn="@xpath=//*[@data-field='Total_Sum_Insured']";
			String TotalSumInsured1="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[1]//td[contains(@ng-click,'Total_Sum_Insured')][text()='4,000.00']";
			String TotalSumInsured2="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[2]//td[contains(@ng-click,'Total_Sum_Insured')][text()='2,000.00']";
			String TotalSumInsured3="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[3]//td[contains(@ng-click,'Total_Sum_Insured')][text()='900,001.00']";
			String TotalSumInsured4="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[4]//td[contains(@ng-click,'Total_Sum_Insured')][text()='900,001.00']";
			String TotalSumInsured5="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[5]//td[contains(@ng-click,'Total_Sum_Insured')][text()='900,001.00']";
			String TotalSumInsured6="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[6]//td[contains(@ng-click,'Total_Sum_Insured')][text()='900,001.00']";
			String TotalSumInsured7="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[7]//td[contains(@ng-click,'Total_Sum_Insured')][text()='900,001.00']";
			String TotalSumInsured8="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[8]//td[contains(@ng-click,'Total_Sum_Insured')][text()='900,001.00']";
			String TotalSumInsured9="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[9]//td[contains(@ng-click,'Total_Sum_Insured')][text()='900,001.00']";
			waitForElementToAppear(TotalSumInsuredcolumn,5);
			mouseOverAction(TotalSumInsuredcolumn);
			verifyMustExists(TotalSumInsuredcolumn,"Total Sum Insured column");
			sleep(2000);
			verifyExists(TotalSumInsured1,"1st value");
			click(TotalSumInsured1,"1st value");
			waitForElementToAppear(Okbtn,10);
			verifyExists(RuleNameField,"Rule Name Field");
			click(Okbtn,"ok Buttton");
			waitForElementToAppear(TotalSumInsured2,10);
			verifyExists(TotalSumInsured2,"2nd value");
			verifyExists(TotalSumInsured3,"3rd value");
			verifyExists(TotalSumInsured4,"4th value");
			verifyExists(TotalSumInsured5,"5th value");
			verifyExists(TotalSumInsured6,"6th value");
			verifyExists(TotalSumInsured7,"7th value");
			verifyExists(TotalSumInsured8,"8th value");
			verifyExists(TotalSumInsured9,"9th value");
			sleep(2000);
			//Total_Insurable_Value
			String TotalInsurableValuecolumn="@xpath=//*[@data-field='Total_Insurable_Value']";
			String TotalInsurableValue1="@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[1]//td[contains(@ng-click,'Total_Insurable_Value')][text()='4,000.00']";
			String TotalInsurableValue2="@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[2]//td[contains(@ng-click,'Total_Insurable_Value')][text()='2,000.00']";
			String TotalInsurableValue3="@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[3]//td[contains(@ng-click,'Total_Insurable_Value')][text()='900,001.00']";
			String TotalInsurableValue4="@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[4]//td[contains(@ng-click,'Total_Insurable_Value')][text()='900,001.00']";
			String TotalInsurableValue5="@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[5]//td[contains(@ng-click,'Total_Insurable_Value')][text()='900,001.00']";
			String TotalInsurableValue6="@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[6]//td[contains(@ng-click,'Total_Insurable_Value')][text()='900,001.00']";
			String TotalInsurableValue7="@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[7]//td[contains(@ng-click,'Total_Insurable_Value')][text()='900,001.00']";
			String TotalInsurableValue8="@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[8]//td[contains(@ng-click,'Total_Insurable_Value')][text()='900,001.00']";
			String TotalInsurableValue9="@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[9]//td[contains(@ng-click,'Total_Insurable_Value')][text()='900,001.00']";
			waitForElementToAppear(TotalInsurableValuecolumn,5);
			mouseOverAction(TotalInsurableValuecolumn);
			verifyMustExists(TotalInsurableValuecolumn,"Total Insurable Value column");
			sleep(2000);
			verifyExists(TotalInsurableValue1,"1st value");
			verifyExists(TotalInsurableValue2,"2nd value");
			verifyExists(TotalInsurableValue3,"3rd value");
			verifyExists(TotalInsurableValue4,"4th value");
			verifyExists(TotalInsurableValue5,"5th value");
			verifyExists(TotalInsurableValue6,"6th value");
			verifyExists(TotalInsurableValue7,"7th value");
			verifyExists(TotalInsurableValue8,"8th value");
			verifyExists(TotalInsurableValue9,"9th value");
			sleep(2000);
			policy.navigationOnBordereauxTab();
			BordereauPage.deleteBorderEAUX();

		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
			BordereauPage.deleteBorderEAUX();
		}
	}

	public void limitOfIndemnity_3988() throws Exception{
		String subSheet="LOI Format (Limit of Idiminity)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn, 10);
		if(isVisible(BordereauPage.SignedBtn ) == true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3988Path = fpath+"\\src\\test\\resources\\testdata\\Financial Calculation_TC_3988.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3988Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculation_TC_3988.xlsx\",\"UniqueFileName\":\"S73910620171128.xlsx\",\"BordereauFormatId\":\"56a45723-e221-423d-8af9-6fc33b50e2fb\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S73910620171128.xlsx\",\"Filesize\":107427,\"Path\":null,\"size\":107427,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				//Total_Sum_Insured
				String TotalSumInsuredcolumn="@xpath=//*[@data-field='Total_Sum_Insured']";
				String TotalSumInsured1="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[1]//td[contains(@ng-click,'Total_Sum_Insured')][text()='4,000.00']";
				String TotalSumInsured2="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[2]//td[contains(@ng-click,'Total_Sum_Insured')][text()='2,000.00']";
				String TotalSumInsured3="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[3]//td[contains(@ng-click,'Total_Sum_Insured')][text()='2,000.00']";
				String TotalSumInsured4="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[4]//td[contains(@ng-click,'Total_Sum_Insured')][text()='2,000.00']";
				String TotalSumInsured5="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[5]//td[contains(@ng-click,'Total_Sum_Insured')][text()='2,000.00']";
				String TotalSumInsured6="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[6]//td[contains(@ng-click,'Total_Sum_Insured')][text()='2,000.00']";
				String TotalSumInsured7="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[7]//td[contains(@ng-click,'Total_Sum_Insured')][text()='2,000.00']";
				String TotalSumInsured8="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[8]//td[contains(@ng-click,'Total_Sum_Insured')][text()='2,000.00']";
				String TotalSumInsured9="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[9]//td[contains(@ng-click,'Total_Sum_Insured')][text()='2,000.00']";
				String TotalSumInsured10="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[10]//td[contains(@ng-click,'Total_Sum_Insured')][text()='2,000.00']";
				waitForElementToAppear(TotalSumInsuredcolumn,20);
				mouseOverAction(TotalSumInsuredcolumn);
				verifyMustExists(TotalSumInsuredcolumn,"Total Sum Insured column");
				sleep(2000);
				verifyExists(TotalSumInsured1,"1st value");
				click(TotalSumInsured1,"1st value");
				waitForElementToAppear(Okbtn,10);
				verifyExists(RuleNameField,"Rule Name Field");
				click(Okbtn,"ok Buttton");
				waitForElementToAppear(TotalSumInsured2,10);
				verifyExists(TotalSumInsured2,"2nd value");
				verifyExists(TotalSumInsured3,"3rd value");
				verifyExists(TotalSumInsured4,"4th value");
				verifyExists(TotalSumInsured5,"5th value");
				verifyExists(TotalSumInsured6,"6th value");
				verifyExists(TotalSumInsured7,"7th value");
				verifyExists(TotalSumInsured8,"8th value");
				verifyExists(TotalSumInsured9,"9th value");
				verifyExists(TotalSumInsured10,"10th value");
				sleep(2000);
				//LimitOfIndemnity				
				String LimitOfIndemnitycolumn="@xpath=//*[@data-field='LimitOfIndemnity']";
				String LimitOfIndemnity1="@xpath=//*[@data-field='LimitOfIndemnity']//following::tr[1]//td[contains(@ng-click,'LimitOfIndemnity')][text()='4,000.00']";
				String LimitOfIndemnity2="@xpath=//*[@data-field='LimitOfIndemnity']//following::tr[2]//td[contains(@ng-click,'LimitOfIndemnity')][text()='2,000.00']";
				String LimitOfIndemnity3="@xpath=//*[@data-field='LimitOfIndemnity']//following::tr[3]//td[contains(@ng-click,'LimitOfIndemnity')][text()='2,000.00']";
				String LimitOfIndemnity4="@xpath=//*[@data-field='LimitOfIndemnity']//following::tr[4]//td[contains(@ng-click,'LimitOfIndemnity')][text()='2,000.00']";
				String LimitOfIndemnity5="@xpath=//*[@data-field='LimitOfIndemnity']//following::tr[5]//td[contains(@ng-click,'LimitOfIndemnity')][text()='2,000.00']";
				String LimitOfIndemnity6="@xpath=//*[@data-field='LimitOfIndemnity']//following::tr[6]//td[contains(@ng-click,'LimitOfIndemnity')][text()='2,000.00']";
				String LimitOfIndemnity7="@xpath=//*[@data-field='LimitOfIndemnity']//following::tr[7]//td[contains(@ng-click,'LimitOfIndemnity')][text()='2,000.00']";
				String LimitOfIndemnity8="@xpath=//*[@data-field='LimitOfIndemnity']//following::tr[8]//td[contains(@ng-click,'LimitOfIndemnity')][text()='2,000.00']";
				String LimitOfIndemnity9="@xpath=//*[@data-field='LimitOfIndemnity']//following::tr[9]//td[contains(@ng-click,'LimitOfIndemnity')][text()='2,000.00']";
				String LimitOfIndemnity10="@xpath=//*[@data-field='LimitOfIndemnity']//following::tr[10]//td[contains(@ng-click,'LimitOfIndemnity')][text()='2,000.00']";
				waitForElementToAppear(LimitOfIndemnitycolumn,20);
				mouseOverAction(LimitOfIndemnitycolumn);
				verifyMustExists(LimitOfIndemnitycolumn,"Limit Of Indemnity column");
				sleep(2000);
				verifyExists(LimitOfIndemnity1,"1st value");
				verifyExists(LimitOfIndemnity2,"2nd value");
				verifyExists(LimitOfIndemnity3,"3rd value");
				verifyExists(LimitOfIndemnity4,"4th value");
				verifyExists(LimitOfIndemnity5,"5th value");
				verifyExists(LimitOfIndemnity6,"6th value");
				verifyExists(LimitOfIndemnity7,"7th value");
				verifyExists(LimitOfIndemnity8,"8th value");
				verifyExists(LimitOfIndemnity9,"9th value");
				verifyExists(LimitOfIndemnity10,"10th value");
				sleep(2000);
				policy.navigationOnBordereauxTab();
				BordereauPage.deleteBorderEAUX();

			} else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}


	public void RemovenonDateCharacters_3992() throws Exception{
		String subSheet="Process Enrichment Format (Automation Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn, 10);
		if(isVisible(BordereauPage.SignedBtn ) == true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3992Path = fpath+"\\src\\test\\resources\\testdata\\Default Risk expair date_TC_3992.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3992Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Default Risk expair date_TC_3992.xlsx\",\"UniqueFileName\":\"S19511720171128.xlsx\",\"BordereauFormatId\":\"bc2ca3dd-d933-4930-8989-a65bf0499b82\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S19511720171128.xlsx\",\"Filesize\":19285,\"Path\":null,\"size\":19285,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				BordereauPage.selectRowNumberAscOrder();
				//RiskInceptionDate
				String RiskInceptionDatecolumn="@xpath=//*[@data-field='RiskInceptionDate']";
				String RiskInceptionDate1="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[1]//td[contains(@ng-click,'RiskInceptionDate')][text()='01/01/2017']";
				String RiskInceptionDate2="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[2]//td[contains(@ng-click,'RiskInceptionDate')][text()='12/01/2017']";
				String RiskInceptionDate3="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[3]//td[contains(@ng-click,'RiskInceptionDate')][text()='12/02/2017']";
				String RiskInceptionDate4="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[4]//td[contains(@ng-click,'RiskInceptionDate')]";
				String RiskInceptionDate5="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[5]//td[contains(@ng-click,'RiskInceptionDate')]";
				waitForElementToAppear(RiskInceptionDatecolumn,20);
				mouseOverAction(RiskInceptionDatecolumn);
				verifyMustExists(RiskInceptionDatecolumn,"Risk Inception Date column");
				sleep(2000);
				verifyExists(RiskInceptionDate1,"1st value");
				verifyExists(RiskInceptionDate2,"2nd value");
				verifyExists(RiskInceptionDate3,"3rd value");
				verifyExists(RiskInceptionDate4,"4th field");
				verifyExists(RiskInceptionDate5,"5th field");
				click(RiskInceptionDate5,"5st field ");
				waitForElementToAppear(Okbtn,10);
				verifyExists(RuleNameField,"Rule Name Field");
				verifyExists(OriginalValue,"Original Value Field");
				verifyExists(ChangedValue,"Changed Value Field");
				click(Okbtn,"ok Buttton");
				sleep(3000);
				policy.navigationOnBordereauxTab();
				BordereauPage.deleteBorderEAUX();

			} else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}

	}
	
	public void RiskInceptionDateasEndormentEfDate_5337() throws Exception{
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		policy.addPolicy2(IncDate, ExpDate);
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		String subSheet="Process Enrichment Format (Automation Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		String contractId = ReturnContractID();
		waitForElementToAppear(BordereauPage.SignedBtn, 10);
		if(isVisible(BordereauPage.SignedBtn ) == true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet5337Path = fpath+"\\src\\test\\resources\\testdata\\Renewal_jan_TC_5337.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet5337Path);  
			//contractId = addNewBordereauFormatPolicy(payload1, GetData);
			String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Renewal_jan_TC_5337.xlsx\",\"UniqueFileName\":\"S10085520180223.xlsx\",\"BordereauFormatId\":\"eec96ded-631b-446f-a9fa-d48fc8cbe4b2\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S10085520180223.xlsx\",\"Filesize\":18592,\"Path\":null,\"size\":18592,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				mouseOver(EfectiveDate);
				verifyExists(EfectiveDate,"Efective date");
				click(EfectiveDate,"Effective date");
				waitForElementToAppear(Okbtn,5);
				sleep(1500);
				verifyExists(RuleName,"Rule Name Field");
				click(Okbtn,"ok Buttton");
				
			} else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}

	}

}
