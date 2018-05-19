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

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.jprotractor.NgBy;
import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;

public class BordereauQuePage extends PageBase
{
	//Read Excel data
	String path;
	String BordereauFilePath;
	static String FormatId;
	public static String BFormatId;
	public static String EditName;

	public static String allSheetsPath = "";
	public static String allSheetsPath1 = "";
	public static String firstSheetPath = "";
	public static String lastSheetPath = "";
	public static String specificTextSheetPath = "";
	public static String equalSpecificTextSheetPath = "";
	public static String anySheetContainsSpecificTextPath = "";
	public static String onlySpecificTextPath = "";
	public static String addPremiumQuestionairePath = "";
	public static String addClaimQuestionairePath = "";
	public static String sheet3684Path = "";
	public static String sheet3695Path = "";
	public static String allsheetPath = "";
	public static String sheet4303Path = "";
	String QuestionnaireName_TC5141 ="";
	
	GlobalVariables g = new GlobalVariables();
	{ 
		try {
			String path = new File(".").getCanonicalPath();
			g = new GlobalVariables();
			g.setRelativePath(path);

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		path = "./src/test/resources/TestData.xls";
		BordereauFilePath = "./src/main/resources/January 2017.xlsx";
	} 
	ReadExcelFile rd = new ReadExcelFile();

	/*	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("ssddMMMs");
		String datetime = ft.format(dNow);
		return datetime;
	}
	 */
	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddHHmmss");
		String datetime = ft.format(dNow);
		return datetime;
	}

	String QuestionnaireName = "SP - All Sheet(s)"+getCurrentDateTimeMS();
	String QuestionnaireName1 = "SP - All Sheet1(s)"+getCurrentDateTimeMS();
	String QuestionnaireName1stSheet = "SP - First Sheet"+getCurrentDateTimeMS();
	String QuestionnaireNameLastSheet = "SP - Last Sheet"+getCurrentDateTimeMS();
	String QuestionnaireSpecificTextSheet = "SP - The only sheet that contains specific text"+getCurrentDateTimeMS();
	String QuestionnaireEqualSpecificTextSheet = "SP - The only sheet that equals specific text"+getCurrentDateTimeMS();
	String QuestionnaireAnySheetContainsSpecificText = "SP - Any sheets that contains specific text"+getCurrentDateTimeMS();
	String QuestionnaireOnlySpecificText = "SP - Only specified Sheet(s)"+getCurrentDateTimeMS();
	String PremiumBordereauText = "Premium Bordereau Questionnaire"+getCurrentDateTimeMS();
	String ClaimBordereauText = "Automation Format-1 "+getCurrentDateTimeMS();
	String ClaimBordereauText1 = "Automation Format-2 "+getCurrentDateTimeMS();

	String AllSheetOption = "All Sheet";
	String FirstSheetOption = "First Sheet";
	String LastSheetOption = "Last Sheet";
	String SpecificTextSheetOption = "The only sheet that contains specific text";
	String EqualSpecificTextSheetOption = "The only sheet that contains specific text";
	String AnySheetContainsSpecificTextOption = "Any sheets that contains specific text";
	String OnlySpecificTextOption = "Only specified sheet(s)";
	String AllSheetsOption = "All Sheet(s)";

	//Class objects
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	PolicyPage policy = new PolicyPage();
	DatasetReferenceDataPage DataRef = new DatasetReferenceDataPage();

	//Element Locators
	//Select Bordereau Questionnaire Link from Admin Dropdown
	public static final String bordereauQueLink ="@xpath=//a[text()='Bordereau Questionnaires']";

	//Bordereau Questionnaire Page Locators
	public static final String bordereauQuePage ="@xpath=//*[@class='card-header']//div[contains(.,'Bordereau Questionnaire')]";
	public static final String addQueBtn ="@xpath=//*[@class='btn btn-primary ng-scope']";
	public static final String UploadSection ="@xpath=//div[contains(@ng-model,'picFile')]";
	public static final String typeOfBordereauDD ="@xpath=//*[contains(@ng-class,'step2data.DataSetType')]//span[@class='k-icon k-i-arrow-60-down']";
	public static final String riskOption ="@xpath=//li[text()='Risk']";
	public static final String businessClassDD ="@xpath=//*[@ng-hide='StepsMenuVM.IsSaved']//span[@class='k-icon k-i-arrow-60-down']";
	public static final String automationSchemaOption ="@xpath=//li[text()='Automation Schema']";
	public static final String questionnaireNameTxt ="@model=step2data.FormatName";
	public static final String nextStepBtn ="@buttonText=Next Step";
	public static final String suppliedBordereauSheetDD ="@xpath=//*[@ng-model='data.SheetIndex']//preceding-sibling::span[1]";
	public static final String suppliedBordereauSheetMarchOption ="@xpath=//li[text()='March 2017']";
	public static final String appliedToIdentifyDD ="@xpath=//*[@ng-model='data.SheetType']//preceding-sibling::span[1]";
	public static final String RiskOrderField ="@xpath= //*[@id='content']/div/ui-view/div/form/div/div/div/dl[7]/dd/div/div/input";
	public static final String Spinner ="@xpath=//*[@id='loading-bar-spinner']/div[@class='spinner']";
	public static final String FirstSheetVal ="@xpath=//ul/li[text()='First Sheet']";

	public static final String appliedRuleAllSheetsOption ="@xpath=//li[contains(text(),'All Sheet')]";
	public static final String sheetsContainTxt ="@model=data.SheetText";
	public static final String specifiedSheetProcessedDD ="@xpath=//*[@ng-model='form.multiSheetText']//preceding-sibling::div[1]";
	public static final String specifiedSheetMarchOption ="@xpath=//preceding::dt[contains(text(),'Please specify the sheet')][1]//following::li[contains(text(),'March 2017')][2]";
	public static final String specifiedSheetProcessedDD1 ="@xpath=//*[@ng-model='form.multiSheetText']//preceding-sibling::div//input";
	public static final String specifiedSheetMayOption ="@xpath=//preceding::dt[contains(text(),'Please specify the sheet')][1]//following::li[contains(text(),'May 2017')][2]";

	public static final String headerRowCountTxt ="@model=data.HeaderIndex";
	public static final String FinancialFigDrp ="@xpath=//*[@ng-model='BFBasicDetailsClaim.FinancialCurrency']//preceding-sibling::span[1]";
	public static final String OriginalCurrencyval ="@xpath=//div[@class='k-animation-container']//li[text()='Original Currency']";
	public static final String multipleLocationsRadioBtn ="@xpath=//*[@name='multilocationGrp'][@value='false']";
	public static final String YOAeachRiskSpecifiedDD ="@xpath=//*[@ng-model='BFBasicDetails.YearOfAccount']//preceding-sibling::span[1]";
	public static final String yearofAccountOption ="@xpath=//*[@id='YearOfAccount_listbox']//li[contains(.,'Year of Account')]//span";
	public static final String contractOrderRadioBtn ="@xpath=//label//input[@ng-model='BFBasicDetails.IsCeded'][@value='false']";
	public static final String riskAddressSection ="@xpath=//*[@id='grid']//td//span[contains(text(),'Address')]";
	public static final String arrowRightBtn ="@css=.zmdi.zmdi-arrow-right";
	public static final String totalInsurableValueDD ="@xpath=//*[@ng-model='BFCoreFinancialVM.TotalInsurableValue.MappingOptionsColumns']//preceding-sibling::div[1]";
	public static final String TIVOption ="@xpath=//*[@id='TIVSelect_listbox']//li[1]";
	public static final String coverholderCommissionDD ="@xpath=//*[@ng-model='BFDeductionsOptions.Commission']//preceding-sibling::span[1]";
	public static final String commissionAmountOption ="@xpath=//following-sibling::li[text()='Commission Percentage']//preceding-sibling::li[text()='Amount']";
	public static final String brokerageDD ="@xpath=//*[@ng-model='BFDeductionsOptions.LondonBrokerage']//preceding-sibling::span[1]";
	public static final String brokerageAmountOption ="@xpath=//following-sibling::li[text()='Percentage']//preceding-sibling::li[text()='Amount']";
	public static final String OtherFeesTxt ="@xpath=//*[@ng-model='BFCoreFinancialVM.OtherFeeDescription.Value']";
	public static final String OtherFeesNoOption ="@xpath=//*[@name='Other_FeesGrp'][@ng-value='false']";
	public static final String taxDD ="@xpath=//*[@ng-model='BFDeductionsOptions.Tax']//preceding-sibling::span[1]";
	public static final String taxAmountOption ="@xpath=//following-sibling::li[text()='Amount and Tax Percentage']//preceding-sibling::li[text()='Tax Percentage']";
	public static final String producingBrokerageRadioBtn ="@xpath=//*[@name='ProducingBrokerageBoolGrp'][@value='false']";
	public static final String taxRadioBtn ="@xpath=//*[@name='TaxTypeGrp'][@value='false']";
	public static final String taxTypeTxt ="@model=BFCoreFinancialVM.TaxType.Value";
	public static final String premiumsChk ="@name=chk1";
	public static final String limitsAndOthersChk ="@name=chk3";
	public static final String mappingYBBtn ="@xpath=//button[text()='YB']";
	public static final String tableRow1 ="@xpath=//*[@id='selection']//table/tbody/tr[1]/td[1]";
	public static final String SaveBtn ="@buttonText=Save";
	public static final String RiskSpecifiedDD ="@xpath=//*[@ng-model='BFBasicDetails.PremiumAllocation']//preceding-sibling::span[1]";
	public static final String RiskOption ="@xpath=//*[@class='k-list k-reset']//li[contains(.,'Risk')]";
	
	//---------------------------Step_4
	public static final String RiskinBordereauDD ="@xpath=//*[@id='content']/div/ui-view/div/form/div/div/div/dl[1]/dd/div/div/div/div/div";
	public static final String RiskinBordereauDDoption ="@xpath=//*[@class='k-list k-reset']//li[contains(.,'Policy Number 1')]";
	
	public static final String RiskcandeleteDD ="@xpath=//*[@id='content']/div/ui-view/div/form/div/div/div/dl[10]/dd/div/div/div/div/div";
	public static final String RiskcandeleteOption ="@xpath=//*[@id='DiscardRisk_listbox']//li[contains(.,'Policy Number 1')]";
   
	//-------------------------Step_5
	
	public static final String StartriskperiodDD ="@xpath=//*[@id='RiskDetails']/div/div/div/dl[1]/dd/div/div/div/span";
	public static final String StartriskperiodDDoption ="@xpath=//*[@id='RiskInceptionDate_listbox']//li[contains(.,'Start Date 1/1/2017 12:00:00 AM')]";
	
	public static final String EndriskperiodDD ="@xpath=//*[@id='RiskDetails']/div/div/div/dl[2]/dd/div/div/div/span";
	public static final String EndriskperiodOption ="@xpath=//*[@id='RiskExpiryDate_listbox']//li[contains(.,'Expiry 12/31/2017 12:00:00 AM')]";
	
	public static final String InsuredNameDD ="@xpath=//*[@id='RiskDetails']/div/div/div/dl[5]/dd/div/div/div/div";
	public static final String InsuredNameOption ="@xpath=//*[@id='InsuredName_listbox']//li[contains(.,'Insured Name Random Insured1')]";
		
	//Edit Questionnaire
	public static final String QuestionnaireNameFilter ="@xpath=//*[@data-title='Questionnaire Name']/a/span";
	public static final String SearchTxt ="@xpath=//input[@placeholder='Search']";
	public static final String SelectQuestionnaire2 ="@xpath=//*[@value='Default value enhancement']";
	//String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+QuestionnaireOnlySpecificText+"')][1]";
	public static final String FilterBtn ="@buttonText=Filter";
	public static final String EditBtn ="@xpath=//*[@id='grid']//div[@ng-click='commandEdit(1)']";
	public static final String VerifyVersion ="@xpath=//*[@id='content']//td[contains(.,'SP - Only specified Sheet')]//following-sibling::td[1]";
	public static final String VerifyVersion1 ="@xpath=//*[@id='content']//td[contains(.,'SP - All Sheet(s)')]//following-sibling::td[1]";
	public static final String VerifyVersion2 ="@xpath=//*[@id='content']//td[contains(.,'SP - All Sheet1(s)')]//following-sibling::td[1]";

	public static final String RemoveMarch2017 ="@xpath=//*[@class='k-reset']/li[1]/span/span";
	public static final String CancelBtn ="@xpath=//*[@ng-click='cancel()']";

	//Steps locators
	public static final String Steps ="@xpath=//*[@id='stepsBar']//li[contains(@class,'active')]";

	//Sprint 3 Premium Bordereau 
	public static final String premiumOption ="@xpath=//li[text()='Premium']";
	public static final String premiumSchemaOption ="@xpath=//li[contains(.,'Premium Schema')]";
	public static final String Restatement2 ="@name=chk4";
	//Step 6 Premium
	public static final String grossPremiumplusTax ="@xpath=//input[@ng-model='BFCoreFinancialOptions.GrossPremiumincludingTax'][@value='false']";
	//edit
	public static final String DoesThisUniqueRadio ="@xpath=//input[@ng-model='form.uniqueRefAdjust'][@value='true']";
	public static final String StaticCharactersTxt ="@model=BFBasicDetails.StaticCharacters";
	public static final String MultipleRisksReportedRadio ="@xpath=//input[@ng-model='form.multilocation'][@value='false']";
	public static final String AscertainRiskValue ="@xpath=//*[@id='YearOfAccount_listbox'][@aria-hidden='false']//li[contains(.,'Ascertain from the Risk Inception Date')]";

	//Sprint 3 Claim Bordereau 
	public static final String ClaimOption ="@xpath=//li[text()='Claim']";
	public static final String ClaimSchemaOption ="@xpath=//li[contains(.,'Automation Schema-Claim')]";
	public static final String RateOfExchangeTxt ="@model=BFBasicDetailsClaim.RateOfExchange";
	//Step 6 claim
	public static final String LossCounty ="@xpath=//*[@id='grid']//td//span[contains(text(),'Loss County')]";
	public static final String LossAddress ="@xpath=//*[@id='grid']//td//span[contains(text(),'Loss Address')]";
	//Step 7 claim
	public static final String RiskAddress ="@xpath=//*[@id='grid']//td//span[contains(text(),'Risk Address')]";
	//Step 8 claim
	public static final String InsuredAddress ="@xpath=//*[@id='grid']//td//span[contains(text(),'Insured Address')]";

	//Step 9 claim
	public static final String paragraph1 ="@xpath=//*[@id='ReservePaidClaim']/div/div/div[1]/p[1]";
	public static final String paragraph2 ="@xpath=//*[@id='ReservePaidClaim']/div/div/div[1]/p[2]";
	
	//Step 10 claim
	public static final String paragraph3 ="@xpath=//*[@id='ReservePaidClaim']/div/div/div[1]/p[1]";
	public static final String paragraph4 ="@xpath=//*[@id='ReservePaidClaim']/div/div/div[1]/p[2]";
	
	//Step 11 claim
	public static final String paragraph5 ="@xpath=//*[@id='TotalIncurredClaim']/div/div/div[1]/p[1]";
	public static final String paragraph6 ="@xpath=//*[@id='TotalIncurredClaim']/div/div/div[1]/p[2]";
	
	String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+QuestionnaireOnlySpecificText+"')][1]";

	//Edit Questionnaire
	public static final String FilterGrp ="@xpath=//*[@name='FilterGrp'][@value='false']";
	public static final String SpecifyFilter ="@xpath=//*[@id='content']//button[@ng-click='SpecifyFilter()']";

	public static final String AdditionalBookingBtn ="@xpath=//button[@ng-click='addFilterCondition()']";

	public static final String AppConDrpValRetain ="@xpath=//ul/li[text()='Rows should be retained if the conditions are met']";
	public static final String AppConDrp ="@xpath=//div[@class='fg-line']//select[@ng-model='data.IsFilterValid']//preceding-sibling::span";
	public static final String AppConDrpValDelete ="@xpath=//ul/li[text()='Rows should be deleted if the conditions are met']";
	//public static final String SaveChangesBtn ="@xpath=//button[@ng-click='save()']";
	public static final String SaveChangesBtn ="@xpath=//button[@ng-click-single='save()']";
	public static final String NumStories1 ="@xpath=//*[@data-field='NumberOfStories']//following::tr[1]//td[contains(@ng-click,'NumberOfStories')][text()='10']";
	public static final String NumStories2 ="@xpath=//*[@data-field='NumberOfStories']//following::tr[2]//td[contains(@ng-click,'NumberOfStories')][text()='11']";

	public static final String RecordOne ="@xpath=//*[@id='grid']//tbody//tr";
	public static final String GotoHome ="@xpath=//*[@ng-click='back()']";

	public static final String VerifyVersionNumber = "@xpath =//*[@id='content']//td[contains(.,'SP- FirstSheet')]//following-sibling::td[1]";
	public static final String EditBtnVersionNo ="@xpath =//*[@id='grid']//div[@ng-click='commandEdit(8)']";
	public static final String NoteBtn ="@xpath=//*[@ng-click='OpenNotesPopup()']";
	public static final String NotePopup ="@xpath=//div[text()='Bordereau Questionnaire Notes']";
	public static final String AddNoteBtn ="@xpath=//*[@ng-click='addNote()']";
	public static final String AddNotePopup ="@xpath=//h2[text()='Add Note']";
	public static final String AddNoteTxt ="@xpath=//*[@ng-model='data.Note']";
	//public static final String SaveNoteBtn ="@xpath=//*[@ng-click='Save()']";
	public static final String SaveNoteBtn ="@xpath=//*[@ng-click-single='Save()']";
	public static final String VersionCount="@xpath=//div[@class='m-b-20']//span[4]";
	public static final String NoteVersionCount="@xpath=//*[@class='k-grid-content k-auto-scrollable']//tr[1]//td[2]";
	public static final String SecondNoteVersionCount="@xpath=//*[@class='k-grid-content k-auto-scrollable']//tr[2]//td[2]";
	public static final String CancelNoteBtn ="@xpath=//*//button[@ng-click='cancel()']";

	public static final String Step11Btn ="@xpath=//li[@uib-popover='Remaining Fields']//*[@id='editLink']";
	public static final String FirstsheetVersion ="@xpath=//*[@id='content']//tr[1]//td[contains(.,'SP - First Sheet')]//following-sibling::td[1]";
	public static final String SecondVersionCount="@xpath=//*[@class='k-grid-content k-auto-scrollable']//tr[3]//td[2]";
	public static final String step11link ="@xpath=//*[@uib-popover='Remaining Fields']/a";
	public static final String Step12Btn ="@xpath=//li[@uib-popover='Review']//*[@id='editLink']";	

	public static final String riskAndPremiumOption ="@xpath=//li[text()='Risk And Premium']";
	public static final String suppliedBordereauSheetBordDataOption ="@xpath=//li[text()='bord data']";
	public static final String ShowadvanceOption ="@xpath=//label[@class='ts-helper']";
	public static final String StandaredRefereanceColumn ="@xpath=.//*[@data-title='Standard Reference']";
	public static final String EditInsuredName ="@xpath=//*[@ng-click='editClick(12)']";
	public static final String BorderueFieldNameFilter ="@xpath=//*[@data-title='Bordereau Field']/a/span";
	public static final String VerifyStandaredRefValue ="@xpath=//*[@id='StandardReference']";
	public static final String EditRiskIssuranceDate ="@xpath=//*[@ng-click='editClick(113)']";
	public static final String MandatoryYes ="@xpath=//*[@ng-model='fieldData.IsMandatory'][@value='true']/..";
	public static final String EditBuildingYearBuilt ="@xpath=//*[@ng-click='editClick(18)']";
	public static final String EditNumberofStories ="@xpath=//*[@ng-click='editClick(17)']";

	public static final String VerifyFirstRow ="@xpath=//tr[1]//*[@id='TideField']";
	public static final String VerifySecondRow ="@xpath=//tr[2]//*[@id='TideField']";
	public static final String VerifyThirdRow ="@xpath=//tr[3]//*[@id='TideField']";
	public static final String VerifyFourthRow ="@xpath=//tr[4]//*[@id='TideField']";
	public static final String ViewQueBtn ="@xpath=//*[@ng-click='OpenBordereauQuestionnairePopup()']";
	public static final String ViewQuetionnariePopup ="@xpath=//div[@class='pmbb-header']//div[Contains(text(),'View Bordereau Questionnaire')]";
	public static final String NoteTab ="@xpath=//*[@ng-click='OpenNotes()']";
	public static final String OkBtn ="@xpath=//*[@ng-click='ok()']";
	public static final String BSummaryPage ="@xpath=//h2[text()='Bordereau Summary']";

	public void addNewQuestionnaire() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		addQuestionnaire();
	}

	public void addNewQuestionnaireTC4058() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		addQuestionnaireTC4058();
	}

	public void addNewQuestionnaire1ForTC4059() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		addQuestionnaireTC4059();
	}

	public void sheetProcessingFirstSheet1(String SchemaName1) throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		firstSheetProcess(SchemaName1);
	}

	public void sheetProcessingFirstSheet() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		firstSheetProcess();
	}

	public void sheetProcessingFirstSheet2(String SchemaName1) throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		firstSheetProcess1(SchemaName1);
	}

	public void sheetProcessingFirstSheet5(String SchemaName1,String QueName) throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		firstSheetProcess5(SchemaName1,QueName);
	}

	public void sheetProcessingLastSheet() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		lastSheetProcess();
	}
	public void sheetProcessingFirstSheet3(String SchemaName1) throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		firstSheetProcess3(SchemaName1);
	}
	public void sheetProcessingFirstSheet4(String SchemaName1) throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		firstSheetProcess4(SchemaName1);
	}

	public void sheetProcessingSpecificText() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		specificTextSheetProcess();
	}

	public void sheetProcessingEqualSpecificText() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		equalSpecificTextSheetProcess();
	}

	public void sheetProcessingAnySheetContainsSpecificText() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		anySheetContainsSpecificTextProcess();
	}

	public void sheetProcessingOnlySpecificText() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{

		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		onlySpecificTextProcess();
	}

	public void editBordereauFormat(String que, String year) throws InterruptedException, AWTException
	{
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		editTextProcess(que, year);
	}

	//3460	Edit Bordereaux Questionaire 
	public void editBordereauFormat() throws InterruptedException, AWTException
	{
		//String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+QuestionnaireOnlySpecificText+"')][1]";
		String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+EditName+"')][1]";

		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		filterBordereauQuestionnaire(EditName, SelectQuestionnaire);
		editTextProcess();
		filterBordereauQuestionnaire(EditName, SelectQuestionnaire);
		sleep(3000);
		waitForElementToAppear(VerifyVersion1,5);
		if(getTextFrom(VerifyVersion1).equals("2") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 2", "PASS");
		}
		else
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "FAIL");
		}
	}

	//3723	Add a Premium Questionaire 
	public void addPremiumQuestionaire() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		addPremiumQuestionaireFile();
	}

	//3733	Edit a Questionaire 
	public void editPremiumQuestionaire() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		String VerifyVersion1 ="@xpath=//*[@id='content']//td[contains(.,'"+PremiumBordereauText+"')]//following-sibling::td[1]";
		String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+PremiumBordereauText+"')][1]";

		filterBordereauQuestionnaire(PremiumBordereauText, SelectQuestionnaire);
		sleep(5000);
		if(getTextFrom(VerifyVersion1).equals("1") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "PASS");
		}	
		//sleep(5000);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(3000);
		nextStapeClick();
		nextStapeClick();
		javaScriptclick(DoesThisUniqueRadio,"Does This Unique reference Yes button");
		verifyMustExists(StaticCharactersTxt,"Static Characters textbox");
		sendKeys(StaticCharactersTxt,"2","Static Characters textbox");
		javaScriptclick(MultipleRisksReportedRadio,"Does This Unique reference Yes button");
		verifyMustExists(YOAeachRiskSpecifiedDD,"YOA associated with each Risk specified? Dropdown");
		click(YOAeachRiskSpecifiedDD,"YOA associated with each Risk specified? Dropdown");
		verifyMustExists(AscertainRiskValue,"Ascertain from the Risk Inception Date");
		click(AscertainRiskValue,"Ascertain from the Risk Inception Date");
		nextStapeClick();
		verifyMustExists(CancelBtn,"Cancel button");
		click(CancelBtn,"Cancel button");
		sleep(3000);
		filterBordereauQuestionnaire(PremiumBordereauText,SelectQuestionnaire);
		sleep(3000);
		waitForElementToAppear(VerifyVersion1,5);
		if(getTextFrom(VerifyVersion1).equals("2") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 2", "PASS");
		}
		else
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "FAIL");
		}
	}


	//3532	Add a bordereau Format(Claim)
	public void addBordereauFormatClaim() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		addClaimQuestionaireFile();
	}

	public void addBordereauFormatClaim1() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		addClaimQuestionaireFile1();
	}

	//3533	Edit Bordereau Format(Claim)
	public void editClaimQuestionaire() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		String VerifyVersion1 ="@xpath=//*[@id='content']//td[contains(.,'"+ClaimBordereauText+"')]//following-sibling::td[1]";
		String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+ClaimBordereauText+"')][1]";

		filterBordereauQuestionnaire(ClaimBordereauText, SelectQuestionnaire);
		sleep(5000);
		if(getTextFrom(VerifyVersion1).equals("1") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "PASS");
		}	
		//sleep(5000);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(3000);
		nextStapeClick();
		nextStapeClick();
		verifyMustExists(RateOfExchangeTxt,"Rate Of Exchange textbox");
		sendKeys(RateOfExchangeTxt,"3","Rate Of Exchange textbox");
		nextStapeClick();
		verifyMustExists(CancelBtn,"Cancel button");
		click(CancelBtn,"Cancel button");
		sleep(3000);
		filterBordereauQuestionnaire(ClaimBordereauText, SelectQuestionnaire);
		sleep(3000);
		waitForElementToAppear(VerifyVersion1,5);
		if(getTextFrom(VerifyVersion1).equals("2") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 2", "PASS");
		}
		else
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "FAIL");
		}
	}

	//4058	Bordereau Questionaire- Tide Admin
	public void BordereauQuestionaireTideAdmin_4058() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		addNewQuestionnaireTC4058();
		editBordereauFormatDubForTc4058_1();
		deactivateQuestionnaire();
	}

	//4059	Bordereau Questionaire- Company Admin
	public void BordereauQuestionaireCompanyAdmin_4059() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		addNewQuestionnaire1ForTC4059();
		//editBordereauFormatDubForTc4058();
		deactivateQuestionnaire();
	}

	//4060	Bordereau Questionaire- Standard user
	public void BordereauQuestionaireStandardUser_4060() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		addNewQuestionnaire1ForTC4059();
	//	editBordereauFormatDubForTc4058_1();
		deactivateQuestionnaire();
	}

	//4061	Bordereau Questionaire- Standard user
	public void BordereauQuestionaireReadOnly_4061() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		sleep(2000);
		if(isVisible(homePage.adminDropdown)==false){
			Report.LogInfo("ReadOnly", "Admin tab not available for this user", "PASS");
		}else{
			Report.LogInfo("ReadOnly", "Admin tab is available for this user", "FAIL");

		}
	}

	public void AddBordereauQuestionaireNotes_4197() throws Exception
	{
		String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+QuestionnaireName1stSheet+"')][1]";
		//TC3135
		sheetProcessingFirstSheet();
		refreshPage();
		filterBordereauQuestionnaire(QuestionnaireName1stSheet, SelectQuestionnaire);
		sleep(2000);
		verifyMustExists(FirstsheetVersion,"First sheet Version");
		String VersionNumber = getTextFrom(FirstsheetVersion);
		waitForElementToPresent(By.xpath(EditBtn), 3);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(3000);

		verifyMustExists(NoteBtn,"Note button");
		String NoteCount =getTextFrom(NoteBtn);
		String NoteCount0 ="NOTES - 0";
		if(NoteCount.equals(NoteCount0)){
			Report.LogInfo("VerifyNoteCount", "Note Count is Zero", "PASS");
			click(NoteBtn,"Notevbutton");
		}
		else{
			Report.LogInfo("VerifyNoteCount", "Note Count is not Zero", "Fail");
			click(NoteBtn,"Note button");
		}
		sleep(2000);
		verifyMustExists(NotePopup,"Note Popup");
		verifyMustExists(AddNoteBtn,"Add Note button");
		click(AddNoteBtn,"Add Note button");
		sleep(2000);
		verifyMustExists(AddNotePopup,"Note Popup");
		verifyMustExists(AddNoteTxt,"Note Textbox");
		sendKeys(AddNoteTxt,"Test");
		sleep(2000);
		verifyMustExists(SaveNoteBtn,"Save Note button");
		click(SaveNoteBtn,"Save Note button");
		verifyMustExists(VersionCount," Version Count is 1");
		verifyMustExists(NoteVersionCount,"Version Count is 1");
		String NoteCnt= getTextFrom(NoteVersionCount);
		if(VersionNumber.equals(NoteCnt))
		{
			Report.LogInfo("VerifyNoteCount", "Note Count is matched", "PASS");
		}
		else{
			Report.LogInfo("VerifyNoteCount", "Note Count is not matched", "Fail");
		}
		verifyMustExists(AddNoteBtn,"Add Note button");
		click(AddNoteBtn,"Add Note button");
		sleep(2000);
		verifyMustExists(AddNotePopup,"Add Note Popup");
		verifyMustExists(AddNoteTxt,"Add Note Text");
		sendKeys(AddNoteTxt,"Test 1");
		sleep(2000);
		verifyMustExists(SaveNoteBtn,"Save Note button");
		click(SaveNoteBtn,"Save Note button");
		verifyMustExists(VersionCount,"Version Count");
		verifyMustExists(SecondNoteVersionCount,"Second Note Version Count");
		String VersionCnt = getTextFrom(VersionCount);
		String SecondVersionCnt = getTextFrom(SecondNoteVersionCount);
		if(VersionCnt.equals(SecondVersionCnt))
		{
			Report.LogInfo("VerifyNoteCount", "Second Note Count is matched", "PASS");
		}
		else{
			Report.LogInfo("VerifyNoteCount", "Second Note Count is not matched", "Fail");
		}
		sleep(2000);
		verifyMustExists(CancelNoteBtn,"Add Note button");
		click(CancelNoteBtn,"Add Note button");
		verifyMustExists(NoteBtn,"Note button Count is changed");
		sleep(2000);
		refreshPage();
		verifyMustExists(Step11Btn,"Step11 button");
		click(Step11Btn,"Step11 button");
		sleep(2000);
		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(100);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(1000);
			}
		}
		sleep(2000);
		String BuildingsValueDrag = "@xpath=//button[text()='Buildings']";
		String BuildingsValueDrop = "@xpath=//td[contains(.,'Buildings Value')]//preceding-sibling::td/div/div";
		dragDropElement(BuildingsValueDrag,BuildingsValueDrop);
		sleep(2000);
		step11();
		step12();
		refreshPage();
		filterBordereauQuestionnaire(QuestionnaireName1stSheet, SelectQuestionnaire);
		waitForElementToAppear(FirstsheetVersion,5);
		if(getTextFrom(FirstsheetVersion).equals("2") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 2", "PASS");
		}
		else
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "FAIL");
		}
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(3000);
		verifyMustExists(NoteBtn,"Note button");
		click(NoteBtn,"Notevbutton");			
		sleep(2000);
		verifyMustExists(NotePopup,"Note Popup");
		verifyMustExists(AddNoteBtn,"Add Note button");
		click(AddNoteBtn,"Add Note button");
		sleep(2000);
		verifyMustExists(AddNotePopup,"Note Popup");
		verifyMustExists(AddNoteTxt,"Note Text");
		sendKeys(AddNoteTxt,"Test2");
		sleep(2000);
		verifyMustExists(SaveNoteBtn,"Save Note button");
		click(SaveNoteBtn,"Save Note button");
		verifyMustExists(VersionCount,"Version Count");
		verifyMustExists(SecondVersionCount,"Save Note Version Count");
		String SecondVersionNote = getTextFrom(VersionCount);
		String SecondVersionNoteCnt= getTextFrom(SecondVersionCount);
		if(SecondVersionNote.equals(SecondVersionNoteCnt))
		{
			Report.LogInfo("VerifyNoteCount", "Note Count is matched", "PASS");
		}
		else{
			Report.LogInfo("VerifyNoteCount", "Note Count is not matched", "Fail");
		}
		sleep(2000);
		verifyMustExists(CancelNoteBtn,"Cancel Note button");
		click(CancelNoteBtn,"Cancel Note button");
		verifyMustExists(NoteBtn,"Note button Count is changed");
		refreshPage();
		verifyMustExists(Step12Btn,"Step12 Link");
		click(Step12Btn,"Step12 Link");
		sleep(2000);
		step12();
		sleep(3000);
		bordereauQuePage();
	}

	public void firstSheetProcess(String SchemaName) throws AWTException, ClientProtocolException, IOException
	{
		String QuestionnaireName = "SP - All Sheet(s)"+getCurrentDateTimeMS();

		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S82113320171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S82113320171010.xlsx\"}}";
		//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S37427020171126.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S37427020171126.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\January_2017_First_Sheet.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		String QuestioneriesValue ="@xpath=//li[contains(.,'"+SchemaName+"')]";
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		//sleep(2000);
		verifyMustExists(riskOption,"Select Risk Option");
		click(riskOption,"Select Risk Option");
		//sleep(2000);
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		//sleep(2000);
		verifyMustExists(QuestioneriesValue,"Questioneries Value");
		click(QuestioneriesValue,"Questioneries Value");
		//sleep(2000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,QuestionnaireName,"Questionnaire Name Textbox.");
		nextStapeClick();
		//System.out.println(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		//sleep(2000);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7_1();
		step8();
		step9();
		step10();
		String BuildingsPopover = "@xpath=//div[@popover='Buildings']";
		String ContentsPopover = "@xpath=//div[@popover='Contents']";
		String SprinklersPopover = "@xpath=//div[@popover='Sprinklers']";
		String OccupancySchemePopover = "@xpath=//div[@popover='Occupancy Scheme']";
		String OccupancyCodePopover = "@xpath=//div[@popover='Occupancy Code']";
		String OccupancyDescriptionPopover = "@xpath=//div[@popover='Occupancy Description']";
		String YB = "@xpath=//div[contains(@popover,'YB')]//i";
		String TIV = "@xpath=//div[contains(@popover,'TIV')]//i";
		String GrossSpace = "@xpath=//div[contains(@popover,'Gross Space')]//i";
		String ConstructionScheme = "@xpath=//div[contains(@popover,'Construction Scheme')]//i";
		String ConstructionDescription = "@xpath=//div[contains(@popover,'Construction Description')]//i";
		String ConstructionCode = "@xpath=//div[contains(@popover,'Construction Code')]//i";
		String PostalCode = "@xpath=//div[contains(@popover,'Postal Code')]//i";
		String Country = "@xpath=//div[contains(@popover,'Country')]//i";
		String Buildings = "@xpath=//div[contains(@popover,'Buildings')]//i";
		String Address1 = "@xpath=//tr[6]//div[contains(@popover,'Address 1')]//i";
		String Address2 = "@xpath=//tr[7]//div[contains(@popover,'Address 1')]//i";
		String Address3 = "@xpath=//tr[11]//div[contains(@popover,'Address 1')]//i";
		String Address4 = "@xpath=//tr[17]//div[contains(@popover,'Address 1')]//i";
		String Contents1 = "@xpath=//tr[9]//div[contains(@popover,'Contents')]//i";
		String Contents2 = "@xpath=//tr[10]//div[contains(@popover,'Contents')]//i";
		String Contents3 = "@xpath=//tr[21]//div[contains(@popover,'Contents')]//i";

		sleep(1000);

		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(100);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(1000);
			}
		}

		String NoStoriesDrag = "@xpath=//button[contains(.,'No. Stories')]";
		String NoStoriesDrop = "@xpath=//td[contains(.,'Number of Stories')]//preceding-sibling::td/div/div";
		String BuildingYearBuiltDrag = "@xpath=//button[contains(.,'YB')]";
		String BuildingYearBuiltDrop = "@xpath=//td[contains(.,'Building Year Built')]//preceding-sibling::td/div/div";
		String BuildingsValueDrag = "@xpath=//button[text()='Buildings']";
		String BuildingsValueDrop = "@xpath=//td[contains(.,'Buildings Value')]//preceding-sibling::td/div/div";
		String OccupancyCodeDrag = "@xpath=//button[text()='Occupancy Code']";
		String OccupancyCodeDrop = "@xpath=//td[contains(.,'Occupancy Code')]//preceding-sibling::td/div/div";
		String OccupancyDescriptionDrag = "@xpath=//button[text()='Occupancy Description']";
		String OccupancyDescriptionDrop = "@xpath=//td[contains(.,'Occupancy Description')]//preceding-sibling::td/div/div";
		String OccupancySchemeDrag = "@xpath=//button[text()='Occupancy Scheme']";
		String OccupancySchemeDrop = "@xpath=//td[contains(.,'Occupancy Scheme')]//preceding-sibling::td/div/div";
		String SprinklersDrag = "@xpath=//button[text()='Sprinklers']";
		String SprinklersDrop = "@xpath=//td[contains(.,'Sprinklers')]//preceding-sibling::td/div/div";

		dragDropElement(NoStoriesDrag,NoStoriesDrop);
		dragDropElement(BuildingYearBuiltDrag,BuildingYearBuiltDrop);
		dragDropElement(BuildingsValueDrag,BuildingsValueDrop);
		dragDropElement(OccupancyCodeDrag,OccupancyCodeDrop);
		dragDropElement(OccupancyDescriptionDrag,OccupancyDescriptionDrop);
		dragDropElement(OccupancySchemeDrag,OccupancySchemeDrop);
		dragDropElement(SprinklersDrag,SprinklersDrop);


		step11();
		BFormatId= ReturnFormatID();
		step12();
	}

	/***********************************************************************************/
	public void bordereauQueLink()
	{
		//sleep(2000);
		verifyMustExists(bordereauQueLink,"Bordereau Questionnaire Link");
		click(bordereauQueLink,"Bordereau Questionnaire Link");
	}

	public void bordereauQuePage()
	{
		//sleep(2000);
		waitForElementToAppear(bordereauQuePage,2);
		verifyExists(bordereauQuePage,"Bordereau Questionnaire Page Title");	
	}

	public void addQuestionnaire() throws AWTException, ClientProtocolException, IOException
	{		
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		  
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S24286620171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":24625,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S24286620171010.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			allSheetsPath = fpath+"\\src\\test\\resources\\testdata\\January_2017.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(allSheetsPath);
		File excelFile = new File(allSheetsPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		//UploadFile(allSheets,);
		verifyExists(bordereauQuePage,"Bordereau Questionnaire Page Title");	
		step2(QuestionnaireName);
		step3(AllSheetOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7();
		step8();
		step9();
		step10();
		step11();
		step12();
	}
	//Headrer row Selecton Questionnaire
	public void addQuestionnaireHR() throws AWTException, ClientProtocolException, IOException, InterruptedException
	{	
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S87947120180316.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":18146,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S87947120180316.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
	
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\January_2017_1.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File excelFile = new File(firstSheetPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		step2(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1-2", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7();
		step8();
		step9();
		step10();
		step11();
		step12();
		// Edited Questionnaire
		String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+EditName+"')][1]";

		filterBordereauQuestionnaire(EditName, SelectQuestionnaire);
		waitForElementToPresent(By.xpath(EditBtn), 3);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(3000);
		nextStapeClick();
				
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1-3", "Header Row Count Textbox.");
		nextStapeClick();
		nextStapeClick();
		verifyMustExists(CancelBtn,"Cancel button");
		click(CancelBtn,"Cancel button");
		
		addQuestionnaireHR_1();
		
	}
	public void addQuestionnaireHR_1() throws AWTException, ClientProtocolException, IOException, InterruptedException
	{
		bordereauQuePage();
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
	    String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S92666120180316.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S92666120180316.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			allSheetsPath = fpath+"\\src\\test\\resources\\testdata\\January_2017.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		File excelFile = new File(allSheetsPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId= addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);
	
		step2(QuestionnaireName);
		step3(AllSheetOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1-2", "Header Row Count Textbox.");
		nextStapeClick();
		step_4();
		step_5();
		
	}

	public void addQuestionnaireTC4058() throws AWTException, ClientProtocolException, IOException
	{
		//String QuestionnaireName = "SP - All Sheet(s)"+getCurrentDateTimeMS();
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S24286620171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":24625,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S24286620171010.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			allSheetsPath = fpath+"\\src\\test\\resources\\testdata\\January_2017.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(allSheetsPath);
		File excelFile = new File(allSheetsPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		//refreshPage();
		openurl(URL);
		//UploadFile(allSheets,);
		step2(QuestionnaireName1);
		step3(AllSheetOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7();
		step8();
		step9();
		step10();
		step11();
		step12();
	}

	public void addQuestionnaireTC4059() throws AWTException, ClientProtocolException, IOException, InterruptedException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S24286620171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":24625,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S24286620171010.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			allSheetsPath = fpath+"\\src\\test\\resources\\testdata\\January_2017.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(allSheetsPath);
		File excelFile = new File(allSheetsPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		//UploadFile(allSheets,);
		step2(QuestionnaireName);
		step3(AllSheetOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		//webDriver.navigate().refresh();
		nextStapeClick1();

		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		webDriver.manage().deleteAllCookies();
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			allSheetsPath1 = fpath+"\\src\\test\\resources\\testdata\\January_2017.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(allSheetsPath);
		File excelFile1 = new File(allSheetsPath1);
		uploadFileQue(requestURL, excelFile1, payload, URLname);
		String formatId1 = addNewBordereauFormat(payload, URLname);
		String URL1 = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId1+"&isEdit=0&CreateAndProcess=0";
		openurl(URL1);

		//UploadFile(allSheets,);
		step2(QuestionnaireName);
		step3(AllSheetOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();

		step4();
		step5();
		step6();
		step7();
		step8();
		step9();
		step10();
		step11();
		step12();
	}

	public void firstSheetProcess() throws AWTException, ClientProtocolException, IOException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S88238920180121.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S88238920180121.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		//sleep(2000);
		step1();

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\January_2017_First_Sheet.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		step2(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		//sleep(2000);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7();
		step8();
		step9();
		//sleep(5000);
		step10();
		//sleep(5000);
		step11();
		step12();
	}

	public void firstSheetProcess1(String SchemaName) throws AWTException, ClientProtocolException, IOException
	{
		String QuestionnaireName = "SP - All Sheet(s)"+getCurrentDateTimeMS();

		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S82113320171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S82113320171010.xlsx\"}}";
		//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S37427020171126.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S37427020171126.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\January_2017_First_Sheet.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		String QuestioneriesValue ="@xpath=//li[contains(.,'"+SchemaName+"')]";
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		//sleep(2000);
		verifyMustExists(riskOption,"Select Risk Option");
		click(riskOption,"Select Risk Option");
		//sleep(2000);
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		//sleep(2000);
		verifyMustExists(QuestioneriesValue,"Questioneries Value");
		click(QuestioneriesValue,"Questioneries Value");
		//sleep(2000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,QuestionnaireName,"Questionnaire Name Textbox.");
		nextStapeClick();
		//System.out.println(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		//sleep(2000);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7_1();
		step8();
		step9();
		step10();

		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));
		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(1000);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(200);
			}
		}
		sleep(1000);
		String NoStoriesDrag = "@xpath=//button[contains(.,'No. Stories')]";
		String NoStoriesDrop = "@xpath=//td[contains(.,'Number of Stories')]//preceding-sibling::td/div/div";
		String BuildingYearBuiltDrag = "@xpath=//button[contains(.,'YB')]";
		String BuildingYearBuiltDrop = "@xpath=//td[contains(.,'Building Year Built')]//preceding-sibling::td/div/div";
		String BuildingsValueDrag = "@xpath=//button[text()='Buildings']";
		String BuildingsValueDrop = "@xpath=//td[contains(.,'Buildings Value')]//preceding-sibling::td/div/div";
		String OccupancyCodeDrag = "@xpath=//button[text()='Occupancy Code']";
		String OccupancyCodeDrop = "@xpath=//td[contains(.,'Occupancy Code')]//preceding-sibling::td/div/div";
		String OccupancyDescriptionDrag = "@xpath=//button[text()='Occupancy Description']";
		String OccupancyDescriptionDrop = "@xpath=//td[contains(.,'Occupancy Description')]//preceding-sibling::td/div/div";
		String OccupancySchemeDrag = "@xpath=//button[text()='Occupancy Scheme']";
		String OccupancySchemeDrop = "@xpath=//td[contains(.,'Occupancy Scheme')]//preceding-sibling::td/div/div";
		String SprinklersDrag = "@xpath=//button[text()='Sprinklers']";
		String SprinklersDrop = "@xpath=//td[contains(.,'Sprinklers')]//preceding-sibling::td/div/div";

		dragDropElement(NoStoriesDrag,NoStoriesDrop);
		dragDropElement(BuildingYearBuiltDrag,BuildingYearBuiltDrop);
		dragDropElement(BuildingsValueDrag,BuildingsValueDrop);
		dragDropElement(OccupancyCodeDrag,OccupancyCodeDrop);
		dragDropElement(OccupancyDescriptionDrag,OccupancyDescriptionDrop);
		dragDropElement(OccupancySchemeDrag,OccupancySchemeDrop);
		dragDropElement(SprinklersDrag,SprinklersDrop);

		step11();
		BFormatId= ReturnFormatID();
		//System.out.println(BFormatId);
		step12();
	}

	public void lastSheetProcess() throws AWTException, ClientProtocolException, IOException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S12440520171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":24625,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S12440520171010.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			lastSheetPath = fpath+"\\src\\test\\resources\\testdata\\January_2017_Last_Sheet.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(lastSheetPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		step2(QuestionnaireNameLastSheet);
		step3(LastSheetOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1","Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7();
		step8();
		step9();
		step10();
		step11();
		step12();
	}

	public void specificTextSheetProcess() throws AWTException, ClientProtocolException, IOException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S48296320171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":24625,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S48296320171010.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			specificTextSheetPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_Specific_Text.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(specificTextSheetPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		step2(QuestionnaireSpecificTextSheet);
		step3(SpecificTextSheetOption);
		waitForElementToAppear(sheetsContainTxt,2);
		verifyMustExists(sheetsContainTxt,"Questionnaire Name Textbox");
		sendKeys(sheetsContainTxt,"March");
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Questionnaire Name Textbox");
		sendKeys(headerRowCountTxt,"1");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7();
		step8();
		step9();
		step10();
		step11();
		step12();
	}

	public void firstSheetProcess3(String SchemaName) throws AWTException, ClientProtocolException, IOException
	{
		String QuestionnaireName = "SP - All Sheet(s)"+getCurrentDateTimeMS();

		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S82113320171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S82113320171010.xlsx\"}}";
		//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S37427020171126.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S37427020171126.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\January_2017_First_Sheet.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		String QuestioneriesValue ="@xpath=//li[contains(.,'"+SchemaName+"')]";
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		//sleep(2000);
		verifyMustExists(riskOption,"Select Risk Option");
		click(riskOption,"Select Risk Option");
		//sleep(2000);
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		//sleep(2000);
		verifyMustExists(QuestioneriesValue,"Questioneries Value");
		click(QuestioneriesValue,"Questioneries Value");
		//sleep(2000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,QuestionnaireName,"Questionnaire Name Textbox.");
		nextStapeClick();
		//System.out.println(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		//sleep(2000);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7_1();
		step8();
		step9();
		step10();

		sleep(1000);

		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(100);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(1000);
			}
		}

		String YBDrag = "@xpath=//button[contains(.,'YB')]";
		String YBDrop = "@xpath=//td[contains(.,'Building Year Built')]//preceding-sibling::td/div/div";

		String OccupancyCodeDrag = "@xpath=//button[text()='Occupancy Code']";
		String OccupancyCodeDrop = "@xpath=//td[contains(.,'Occupancy Code')]//preceding-sibling::td/div/div";
		String OccupancyDescriptionDrag = "@xpath=//button[text()='Occupancy Description']";
		String OccupancyDescriptionDrop = "@xpath=//td[contains(.,'Occupancy Description')]//preceding-sibling::td/div/div";
		String OccupancySchemeDrag = "@xpath=//button[text()='Occupancy Scheme']";
		String OccupancySchemeDrop = "@xpath=//td[contains(.,'Occupancy Scheme')]//preceding-sibling::td/div/div";
		String SprinklersDrag = "@xpath=//button[text()='Sprinklers']";
		String SprinklersDrop = "@xpath=//td[contains(.,'Sprinklers')]//preceding-sibling::td/div/div";

		dragDropElement(YBDrag,YBDrop);
		dragDropElement(OccupancySchemeDrag,OccupancySchemeDrop);
		dragDropElement(OccupancyCodeDrag,OccupancyCodeDrop);
		dragDropElement(OccupancyDescriptionDrag,OccupancyDescriptionDrop);
		dragDropElement(SprinklersDrag,SprinklersDrop);


		step11();
		BFormatId= ReturnFormatID();
		step12();
	}

	public void firstSheetProcess4(String SchemaName) throws AWTException, ClientProtocolException, IOException
	{
		String QuestionnaireName = "SP - All Sheet(s)"+getCurrentDateTimeMS();

		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S82113320171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S82113320171010.xlsx\"}}";
	    String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\January_2017_First_Sheet.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		String QuestioneriesValue ="@xpath=//li[contains(.,'"+SchemaName+"')]";
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		//sleep(2000);
		verifyMustExists(riskOption,"Select Risk Option");
		click(riskOption,"Select Risk Option");
		//sleep(2000);
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		//sleep(2000);
		verifyMustExists(QuestioneriesValue,"Questioneries Value");
		click(QuestioneriesValue,"Questioneries Value");
		//sleep(2000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,QuestionnaireName,"Questionnaire Name Textbox.");
		nextStapeClick();
		//System.out.println(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		//sleep(2000);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7_1();
		step8_1();
		step9();
		step10();

		sleep(1000);

		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(100);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(1000);
			}
		}

		String YBDrag = "@xpath=//button[contains(.,'YB')]";
		String YBDrop = "@xpath=//td[contains(.,'Building Year Built')]//preceding-sibling::td/div/div";
		String ContentsDrag = "@xpath=//button[text()='Contents']";
		String ContentsDrop = "@xpath=//td[contains(.,'C - Contents Value')]//preceding-sibling::td/div/div";
		String AddressDrag = "@xpath=//button[contains(.,'Address 1')]";
		String AddressDrop = "@xpath=//td[contains(.,'Insured Address')]//preceding-sibling::td/div/div";
		String CountryDrag = "@xpath=//button[contains(.,'Country')]";
		String CountryDrop = "@xpath=//td[contains(.,'Insured Country')]//preceding-sibling::td/div/div";

		String NoStoriesDrag = "@xpath=//button[contains(.,'No. Stories')]";
		String NoStoriesDrop = "@xpath=//td[contains(.,'Number of Stories')]//preceding-sibling::td/div/div";
		String PostalCodeDrag = "@xpath=//button[contains(.,'Postal Code')]";
		String PostalCodeDrop = "@xpath=//td[contains(.,'Insured Postal/Zip Code')]//preceding-sibling::td/div/div";
		String BuildingsValueDrag = "@xpath=//button[text()='Buildings']";
		String BuildingsValueDrop = "@xpath=//td[contains(.,'A - Buildings Value')]//preceding-sibling::td/div/div";
		String OccupancyCodeDrag = "@xpath=//button[text()='Occupancy Code']";
		String OccupancyCodeDrop = "@xpath=//td[contains(.,'Location Occupancy Code')]//preceding-sibling::td/div/div";
		String OccupancyDescriptionDrag = "@xpath=//button[text()='Occupancy Description']";
		String OccupancyDescriptionDrop = "@xpath=//td[contains(.,'Location Occupancy Description')]//preceding-sibling::td/div/div";
		String OccupancySchemeDrag = "@xpath=//button[text()='Occupancy Scheme']";
		String OccupancySchemeDrop = "@xpath=//td[contains(.,'Location Occupancy Scheme')]//preceding-sibling::td/div/div";
		String SprinklersDrag = "@xpath=//button[text()='Sprinklers']";
		String SprinklersDrop = "@xpath=//td[contains(.,'Location Sprinklers (Y/N)')]//preceding-sibling::td/div/div";

		dragDropElement(YBDrag,YBDrop);
		dragDropElement(BuildingsValueDrag,BuildingsValueDrop);
		dragDropElement(ContentsDrag,ContentsDrop);
		dragDropElement(AddressDrag,AddressDrop);
		dragDropElement(CountryDrag,CountryDrop);
		dragDropElement(PostalCodeDrag,PostalCodeDrop);
		dragDropElement(NoStoriesDrag,NoStoriesDrop);
		dragDropElement(OccupancyCodeDrag,OccupancyCodeDrop);
		dragDropElement(OccupancyDescriptionDrag,OccupancyDescriptionDrop);
		dragDropElement(OccupancySchemeDrag,OccupancySchemeDrop);
		dragDropElement(SprinklersDrag,SprinklersDrop);
		step11();
		BFormatId= ReturnFormatID();
		step12();
	}

	public void equalSpecificTextSheetProcess() throws AWTException, ClientProtocolException, IOException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S27595720171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":24625,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S27595720171010.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			equalSpecificTextSheetPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_Specific_Text.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(equalSpecificTextSheetPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		step2(QuestionnaireEqualSpecificTextSheet);
		step3(EqualSpecificTextSheetOption);
		waitForElementToAppear(sheetsContainTxt,2);
		verifyMustExists(sheetsContainTxt,"Sheets Contain Textbox");
		sendKeys(sheetsContainTxt,"March 2017","Sheets Contain Textbox.");
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1","Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7();
		step8();
		step9();
		step10();
		step11();
		step12();
	}

	public void anySheetContainsSpecificTextProcess() throws AWTException, ClientProtocolException, IOException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S16069320171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":24625,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S16069320171010.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			anySheetContainsSpecificTextPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_Equal_Any_Text.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(anySheetContainsSpecificTextPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		step2(QuestionnaireAnySheetContainsSpecificText);
		step3(AnySheetContainsSpecificTextOption);
		waitForElementToAppear(sheetsContainTxt,2);
		verifyMustExists(sheetsContainTxt,"Sheets Contain Textbox");
		sendKeys(sheetsContainTxt,"2017","Sheets Contain Textbox.");

		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1","Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7();
		step8();
		step9();
		step10();
		step11();
		step12();
	}

	public void onlySpecificTextProcess() throws AWTException, ClientProtocolException, IOException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S72986420171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":24625,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S72986420171010.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();
		//sleep(4000);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			onlySpecificTextPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_Only_Specific_Text.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(onlySpecificTextPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		step2(QuestionnaireOnlySpecificText);
		step3(OnlySpecificTextOption);
		waitForElementToAppear(specifiedSheetProcessedDD,2);
		verifyMustExists(specifiedSheetProcessedDD,"Please specify the sheet(s) to be processed Dropdown");
		click(specifiedSheetProcessedDD,"Please specify the sheet(s) to be processed Dropdown");
		//sleep(2000);
		click(specifiedSheetMarchOption,"Select March 2017 Option");
		//sleep(3000);
		click(specifiedSheetProcessedDD1,"Please specify the sheet(s) to be processed Dropdown");
		waitForElementToAppear(specifiedSheetMayOption,2);
		click(specifiedSheetMayOption,"Select May 2017 Option");
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1","Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7();
		step8();
		step9();
		step10();
		step11();
		step12();
	}

	public void addPremiumQuestionaireFile() throws AWTException, ClientProtocolException, IOException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S54677220171113.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":23081,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S54677220171113.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();
		//sleep(4000);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			addPremiumQuestionairePath = fpath+"\\src\\test\\resources\\testdata\\January 2017_PremiumQuestionaire_3732.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(addPremiumQuestionairePath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		verifyMustExists(premiumOption,"Select Premium Option");
		click(premiumOption,"Select Premium Option");
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		click(premiumSchemaOption,"Select Automation Schema Option");
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,PremiumBordereauText,"Questionnaire Name Textbox.");
		nextStapeClick();
		step3(AllSheetsOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		javaScriptclick(multipleLocationsRadioBtn,"Select multiple locations reported for each Risk? Radio Button");
		step5();
		step6_1();
		step8();
		nextStapeClick();
		nextStapeClick();
		findWebElement(premiumsChk).sendKeys(Keys.SPACE);
		findWebElement(Restatement2).sendKeys(Keys.SPACE);
		nextStapeClick();
		step11();
		step12();
	}

	public void addClaimQuestionaireFile() throws AWTException, ClientProtocolException, IOException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S28072720171113.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":22224,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S28072720171113.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();
		//sleep(4000);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			addClaimQuestionairePath = fpath+"\\src\\test\\resources\\testdata\\Jan_All sheets_BordereauFormatClaim_3532.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(addClaimQuestionairePath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		verifyMustExists(ClaimOption,"Select Premium Option");
		click(ClaimOption,"Select Premium Option");
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		click(ClaimSchemaOption,"Select Automation Schema Option");
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,ClaimBordereauText,"Questionnaire Name Textbox.");
		nextStapeClick();
		step3(AllSheetsOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");		
		nextStapeClick();
		step4Claim();		
		nextStapeClick();
		step6Claim();
		step7Claim();
		step8Claim();
		step9Claim();
		step10Claim();
		step11Claim();
		/*nextStapeClick();
		nextStapeClick();
		nextStapeClick();*/
		nextStapeClick();
		FormatId = ReturnFormatID();
		step12();
	}

	public void addClaimQuestionaireFile1() throws AWTException, ClientProtocolException, IOException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S28072720171113.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":22224,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S28072720171113.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();
		//sleep(4000);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			addClaimQuestionairePath = fpath+"\\src\\test\\resources\\testdata\\Jan_All sheets_BordereauFormatClaim_3532.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(addClaimQuestionairePath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		verifyMustExists(ClaimOption,"Select Premium Option");
		click(ClaimOption,"Select Premium Option");
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		click(ClaimSchemaOption,"Select Automation Schema Option");
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,ClaimBordereauText1,"Questionnaire Name Textbox.");
		nextStapeClick();
		step3(AllSheetsOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");		
		nextStapeClick();
		step4Claim();		
		nextStapeClick();
		step6Claim();
		step7Claim();
		step8Claim();
		nextStapeClick();
		nextStapeClick();
		nextStapeClick();
		nextStapeClick();
		FormatId = ReturnFormatID();
		step12();
	}

	//3684	Edit Bordereaux Questionaire 
	public void FilterRecrdToRetainRcrd_3684() throws Exception
	{
		BordereauProcessPage BR = new BordereauProcessPage();
		String FormtFiltr = "Format Filter";
		String IncDate = "01/01/2017";
		String IncExpDate = "31/12/2017";
		String subSheet = "Bordereau Processing (kruthika test schema)";
		String ReqUrl = Configuration.url+"api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"api/Bordereaux/AddAsDraft";

		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		filterBordereauQuestionnaire1(FormtFiltr);
		sleep(2000);
		waitForElementToAppear(EditBtn,5);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		nextStapeClick();
		nextStapeClick();			
		sleep(2000);
		//verifyMustExists(FilterGrp,"FilterGrp button");
		javaScriptclick(FilterGrp,"FilterGrp button");
		verifyMustExists(SpecifyFilter,"FilterGrp button");
		click(SpecifyFilter,"FilterGrp button");

		if(isVisible(AppConDrp)==true){
			verifyMustExists(AppConDrp,"Application Condition Drop down");
			click(AppConDrp,"Application Condition Drop down");
			sleep(1000);
			waitForElementToAppear(AppConDrpValRetain,5);
			verifyMustExists(AppConDrpValRetain,"Application Condition Drop down value");
			click(AppConDrpValRetain,"Application Condition Drop down value");
			sleep(1000);
			waitForElementToAppear(SaveChangesBtn,5);
			verifyMustExists(SaveChangesBtn,"Application Condition Drop down value");
			click(SaveChangesBtn,"Application Condition Drop down value");
		}
		sleep(2000);
		nextStapeClick();
		FormatId = ReturnFormatID();
		//System.out.println(FormatId);
		policy.addPolicy2(IncDate,IncExpDate);
		verifyExists(BR.DraftBtn,"Draft Status Button");
		String GetData = Configuration.url+"api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		BR.applyFilterPolicy(policy.PolicyNumber);
		BR.openSelectedPolicy();
		BR.SubmitBordereauxWithYesnoButtons(FormtFiltr);	

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3684Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3684.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3684Path);	
		BR.contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+BR.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3684.xlsx\",\"UniqueFileName\":\"S72251020171114.xlsx\",\"BordereauFormatId\":\""+FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S72251020171114.xlsx\",\"Filesize\":23623,\"Path\":null,\"size\":23623,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//String payload = "{\"Bordereaux\":{\"ContractId\":\"710a56ee-539b-4ae1-8494-af011ab45499\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3684.xlsx\",\"UniqueFileName\":\"S72251020171114.xlsx\",\"BordereauFormatId\":\"c0053cb9-ad5b-4ea4-b823-f4c48e6dfa21\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S72251020171114.xlsx\",\"Filesize\":23623,\"Path\":null,\"size\":23623,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);

		BR.refreshUploadedFile();
		if(isVisible(BR.ReviewBtn) == true){
			BR.openDATALink();
			BR.navigateToDATARiskTab();
			if(isVisible(NumStories1)==true){
				Report.LogInfo("RecordCheck", "Record Match.", "PASS");
			}else{
				Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
			}
			if(isVisible(NumStories2)==true){
				Report.LogInfo("RecordCheck", "Record Match.", "PASS");
			}else{
				Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
			}
			BR.SubmitBordereauxWithYesnoButtons(FormtFiltr);
			BR.deleteBorderEAUX();
		}else{
			Report.LogInfo("StatusCheck", "Review status not display.", "FAIL");
			BR.deleteBorderEAUX();
		}
	}

	//3695	Edit Bordereaux Questionaire 
	public void FilterRecrdToDiscardRcrd_3695() throws Exception
	{
		BordereauProcessPage BR = new BordereauProcessPage();
		String FormtFiltr = "Format Filter";
		//String IncDate = "01/01/2017";
		//String IncExpDate = "31/12/2017";
		String subSheet = "Bordereau Processing (kruthika test schema)";
		String ReqUrl = Configuration.url+"api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"api/Bordereaux/AddAsDraft";

		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		filterBordereauQuestionnaire1(FormtFiltr);
		sleep(2000);
		waitForElementToAppear(EditBtn,5);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		nextStapeClick();
		nextStapeClick();			
		sleep(2000);
		javaScriptclick(FilterGrp,"FilterGrp button");
		verifyMustExists(SpecifyFilter,"FilterGrp button");
		click(SpecifyFilter,"FilterGrp button");

		if(isVisible(AppConDrp)==true){
			verifyMustExists(AppConDrp,"Application Condition Drop down");
			click(AppConDrp,"Application Condition Drop down");
			sleep(1000);
			waitForElementToAppear(AppConDrpValDelete,5);
			verifyMustExists(AppConDrpValDelete,"Application Condition Drop down value");
			click(AppConDrpValDelete,"Application Condition Drop down value");
			sleep(1000);
			waitForElementToAppear(SaveChangesBtn,5);
			verifyMustExists(SaveChangesBtn,"Application Condition Drop down value");
			click(SaveChangesBtn,"Application Condition Drop down value");
		}

		nextStapeClick();
		FormatId = ReturnFormatID();
		//System.out.println(FormatId);

		BR.applyFilterPolicy(policy.PolicyNumber);
		BR.openSelectedPolicy();
		BR.SubmitBordereaux(subSheet);	

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3695Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3695.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3695Path);	

		String payload = "{\"Bordereaux\":{\"ContractId\":\""+BR.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3695.xlsx\",\"UniqueFileName\":\"S17867720171114.xlsx\",\"BordereauFormatId\":\""+FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S17867720171114.xlsx\",\"Filesize\":23623,\"Path\":null,\"size\":23623,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//String payload = "{\"Bordereaux\":{\"ContractId\":\"a4b6f903-4017-4ac8-9928-fa27f335cc6e\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3695.xlsx\",\"UniqueFileName\":\"S17867720171114.xlsx\",\"BordereauFormatId\":\"c0053cb9-ad5b-4ea4-b823-f4c48e6dfa21\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S17867720171114.xlsx\",\"Filesize\":23623,\"Path\":null,\"size\":23623,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);

		BR.refreshUploadedFile();
		if(isVisible(BR.ReviewBtn) == true){
			BR.openDATALink();
			BR.navigateToDATARiskTab();
			if(isVisible(RecordOne)==true){
				Report.LogInfo("RecordCheck", "Record Match.", "PASS");
			}else{
				Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
			}
			BR.SubmitBordereauxWithYesnoButtons(FormtFiltr);	
			BR.deleteBorderEAUX();
		}else{
			Report.LogInfo("StatusCheck", "Review status not display.", "FAIL");
			BR.deleteBorderEAUX();
		}
	}

	public void StandardReferencesInQuestionnaire_TC4199() throws Exception
	{
		String QueNameFiltr ="SP - First Sheet";
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();

		filterBordereauQuestionnaire1(QueNameFiltr);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(2000);

		verifyMustExists(Step12Btn,"Step12 Link");
		click(Step12Btn,"Step12 Link");
		sleep(2000);
		verifyMustExists(ShowadvanceOption,"Show advanced Option button");
		click(ShowadvanceOption,"Show advanced Option button");
		sleep(2000);
		verifyMustExists(StandaredRefereanceColumn,"Standared Refereance Column");

		homePage.adminMenu();
		waitForElementToAppear(DataRef.DatasetLink,5);
		verifyMustExists(DataRef.DatasetLink,"Dataset link");
		click(DataRef.DatasetLink,"Data set link");
		sleep(3000);
		DataRef.SelectRiskAndPremium();
		sleep(2000);
		EditRiskAndPremium("Insured Test");

		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		filterBordereauQuestionnaire1(QueNameFiltr);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(2000);

		verifyMustExists(Step12Btn,"Step12 Link");
		click(Step12Btn,"Step12 Link");
		sleep(2000);
		verifyMustExists(ShowadvanceOption,"Show advanced Option button");
		click(ShowadvanceOption,"Show advanced Option button");
		sleep(2000);
		scrollUp();
		filterBordereauField("Insured Name");
		verifyMustExists(VerifyStandaredRefValue,"Show advanced Option button");
		step12();
		sleep(1000);
		bordereauQuePage();
		homePage.adminMenu();
		waitForElementToAppear(DataRef.DatasetLink,5);
		verifyMustExists(DataRef.DatasetLink,"Dataset link");
		click(DataRef.DatasetLink,"Data set link");
		sleep(3000);
		DataRef.SelectRiskAndPremium();
		sleep(1000);
		RemoveRiskAndPremiumData();
		sleep(2000);
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		filterBordereauQuestionnaire1(QueNameFiltr);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(2000);

		verifyMustExists(Step12Btn,"Step12 Link");
		click(Step12Btn,"Step12 Link");
		sleep(2000);
		verifyMustExists(ShowadvanceOption,"Show advanced Option button");
		click(ShowadvanceOption,"Show advanced Option button");
		sleep(2000);
		scrollUp();
		filterBordereauField("Insured Name");
		verifyMustExists(VerifyStandaredRefValue,"Show advanced Option button");
		step12();
	}

	public void ViewUsedQuestionnaire_TC4303() throws Exception
	{
		BordereauProcessPage BR = new BordereauProcessPage();
		//String FormtFiltr = "Format Filter";
		String IncDate = "01/01/2017";
		String IncExpDate = "01/01/2018";
		String subSheet = "SP - All Sheet(s)";
		String ReqUrl = Configuration.url+"api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"api/Bordereaux/AddAsDraft";

		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		filterBordereauQuestionnaire1(subSheet);
		sleep(2000);
		waitForElementToAppear(EditBtn,5);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		nextStapeClick();
		FormatId = ReturnFormatID();
		policy.addPolicy2(IncDate,IncExpDate);
		verifyExists(BR.DraftBtn,"Draft Status Button");
		String GetData = Configuration.url+"api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		BR.applyFilterPolicy(policy.PolicyNumber);
		BR.openSelectedPolicy();
		BR.SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4303Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC4303.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4303Path);	
		BR.contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//System.out.println(contractId);
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+BR.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC4303.xlsx\",\"UniqueFileName\":\"S78678320180222.xlsx\",\"BordereauFormatId\":\""+FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S78678320180222.xlsx\",\"Filesize\":24663,\"Path\":null,\"size\":24663,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BR.refreshUploadedFile();
		if(isVisible(BR.ReviewBtn) == true){
			Report.LogInfo("StatusCheck", "Review status is display.", "PASS");
			click(BR.ReviewBtn,"Click on Review Button");
			sleep(2000);
			verifyMustExists(ViewQueBtn,"View Questioneries");
			click(ViewQueBtn,"View Questioneries");
			sleep(2000);
			//verifyMustExists(ViewQuetionnariePopup,"View Questioneries Popup");
			verifyMustExists(NoteTab,"Note Tab");
			click(NoteTab,"Note Tab");
			sleep(1000);
			verifyMustExists(OkBtn,"Ok Button");
			click(OkBtn,"Ok Button");
			sleep(1000);
			verifyMustExists(BSummaryPage,"Bordearue Summary Page");
		}else{
			Report.LogInfo("StatusCheck", "Review status not display.", "FAIL");
			BR.deleteBorderEAUX();
		}
	}


//====================================== Reusable function ===============================//

	public void step1() throws AWTException
	{
		waitForElementToAppear(addQueBtn,5);
		verifyMustExists(addQueBtn,"Add New Questionnaire Button");
		click(addQueBtn,"Add New Questionnaire Button");
		//sleep(3000);
	}

	public void step2(String queName)
	{
		EditName = queName;
		System.out.println(EditName);
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		//sleep(2000);
		verifyMustExists(riskOption,"Select Risk Option");
		click(riskOption,"Select Risk Option");
		//sleep(2000);
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		//sleep(2000);
		click(automationSchemaOption,"Select Automation Schema Option");
		//sleep(2000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,queName,"Questionnaire Name Textbox.");
		nextStapeClick();

	}

	public void step3(String sheetName)
	{
		//sleep(2000);
		verifyMustExists(suppliedBordereauSheetDD,"Supplied Bordereau Dropdown");
		click(suppliedBordereauSheetDD,"Supplied Bordereau Dropdown");
		//sleep(2000);
		click(suppliedBordereauSheetMarchOption,"Select March Option");
		//sleep(2000);
		verifyMustExists(appliedToIdentifyDD,"Applied Bordereau Dropdown");
		click(appliedToIdentifyDD,"Applied Bordereau Dropdown");
		sleep(2000);
		webDriver.findElement(By.xpath("//li[contains(text(),'"+sheetName+"')]")).click();
	}

	public void step4()
	{
		//webDriver.navigate().refresh();
		if(isVisible(RiskSpecifiedDD) == true)
		{
			verifyMustExists(RiskSpecifiedDD,"Risk Specified Dropdown");
			click(RiskSpecifiedDD,"Risk Specified Dropdown");
			//sleep(1000);
			click(RiskOption,"Risk Option");
			//sleep(1000);
		}
		javaScriptclick(multipleLocationsRadioBtn,"Select multiple locations reported for each Risk? Radio Button");
		verifyMustExists(YOAeachRiskSpecifiedDD,"YOA associated with each Risk specified? Dropdown");
		click(YOAeachRiskSpecifiedDD,"YOA associated with each Risk specified? Dropdown");
		//sleep(2000);
		click(yearofAccountOption,"Select Year of Account ");
		//sleep(1000);
		javaScriptclick(contractOrderRadioBtn,"Select Contract Order supplied in the Bordereau? Radio Button");
		nextStapeClick();
	}
	public void step_4()
	{
		verifyMustExists(RiskinBordereauDD,"Risk in Borderea Dropdown");
		click(RiskinBordereauDD,"Risk in Borderea Dropdown");
		click(RiskinBordereauDDoption,"Risk in Borderea Option");
		
		if(isVisible(RiskSpecifiedDD) == true)
		{
			verifyMustExists(RiskSpecifiedDD,"Risk Specified Dropdown");
			click(RiskSpecifiedDD,"Risk Specified Dropdown");
			//sleep(1000);
			click(RiskOption,"Risk Option");
			//sleep(1000);
		}
		javaScriptclick(multipleLocationsRadioBtn,"Select multiple locations reported for each Risk? Radio Button");
		verifyMustExists(YOAeachRiskSpecifiedDD,"YOA associated with each Risk specified? Dropdown");
		click(YOAeachRiskSpecifiedDD,"YOA associated with each Risk specified? Dropdown");
		//sleep(2000);
		click(yearofAccountOption,"Select Year of Account ");
		//sleep(1000);
		//javaScriptclick(contractOrderRadioBtn,"Select Contract Order supplied in the Bordereau? Radio Button");
		verifyMustExists(RiskcandeleteDD,"row can be deleted?");
		click(RiskcandeleteDD,"row can be deleted?");
		//sleep(1000);
		click(RiskcandeleteOption,"row can be deleted? Option");
		
		nextStapeClick();
	}

	public void step4Claim()
	{
		verifyMustExists(RateOfExchangeTxt,"Rate Of Exchange textbox");
		sendKeys(RateOfExchangeTxt,"1","Rate Of Exchange textbox");
		sleep(1000);
		waitForElementToAppear(FinancialFigDrp,2);
		verifyMustExists(FinancialFigDrp,"Financial figur");
		click(FinancialFigDrp,"Financial figur");
		sleep(1000);
		waitForElementToAppear(OriginalCurrencyval,2);
		verifyMustExists(OriginalCurrencyval,"Financial figur Drop down value");
		click(OriginalCurrencyval,"Financial figur Drop down value");
		nextStapeClick();
	}

	public void step5()
	{
		nextStapeClick();
	}
	
	public void step_5()
	{
		verifyMustExists(StartriskperiodDD,"Risk in Borderea Dropdown");
		click(StartriskperiodDD,"Risk in Borderea Dropdown");
		click(StartriskperiodDDoption,"Risk in Borderea Option");
		
		verifyMustExists(EndriskperiodDD,"Risk in Borderea Dropdown");
		click(EndriskperiodDD,"Risk in Borderea Dropdown");
		click(EndriskperiodOption,"Risk in Borderea Option");
		
		verifyMustExists(InsuredNameDD,"Risk in Borderea Dropdown");
		click(InsuredNameDD,"Risk in Borderea Dropdown");
		click(InsuredNameOption,"Risk in Borderea Option");
		sleep(1000);
		verifyMustExists(CancelBtn,"Cancel button");
		click(CancelBtn,"Cancel button");
		
	}

	String RenExistriskVal = "@xpath=.//li[text()='Not supplied']";
	String RenExistriskDD = "@xpath=//input[@ng-model='BFRiskDetails.NewRenwalIndicator']//preceding::span[2]";

	public void step5_1()
	{
		sleep(1000);
		SelectDropDownValue(RenExistriskDD, RenExistriskVal);
		sleep(1000);
		nextStapeClick();
	}

	public void step6()
	{
		waitForElementToAppear(riskAddressSection, 8);
		verifyMustExists(riskAddressSection,"Available Risk Address");
		click(riskAddressSection,"Available Risk Address");
		verifyMustExists(arrowRightBtn,"Right Arrow");
		click(arrowRightBtn,"Right Arrow");
		nextStapeClick();
	}

	public void step6_1()
	{
		javaScriptclick(grossPremiumplusTax,"Gross Premium plus Tax?");
		nextStapeClick();
	}

	public void step6Claim()
	{
		waitForElementToAppear(LossCounty, 8);
		verifyMustExists(LossCounty,"Loss County");
		click(LossCounty,"Loss County");
		verifyMustExists(arrowRightBtn,"Right Arrow");
		click(arrowRightBtn,"Right Arrow");
		verifyMustExists(LossAddress,"Loss Address");
		click(LossAddress,"Loss Address");
		verifyMustExists(arrowRightBtn,"Right Arrow");
		click(arrowRightBtn,"Right Arrow");
		nextStapeClick();
	}


	public void step7()
	{
		/*waitForElementToAppear(totalInsurableValueDD, 8);
		verifyMustExists(totalInsurableValueDD,"Total Insurable Value? Dropdown");
		click(totalInsurableValueDD,"Total Insurable Value? Dropdown");
		waitForElementToAppear(TIVOption,2);
		click(TIVOption,"Select TIV option");*/
		nextStapeClick();
	}

	public void step7_1()
	{
		waitForElementToAppear(totalInsurableValueDD, 8);
		verifyMustExists(totalInsurableValueDD,"Total Insurable Value? Dropdown");
		click(totalInsurableValueDD,"Total Insurable Value? Dropdown");
		//waitForElementToAppear(TIVOption,2);
		//click(TIVOption,"Select TIV option");
		nextStapeClick();
	}

	public void step7Claim()
	{
		waitForElementToAppear(RiskAddress, 8);
		verifyMustExists(RiskAddress,"Loss Address");
		click(RiskAddress,"Loss Address");
		verifyMustExists(arrowRightBtn,"Right Arrow");
		click(arrowRightBtn,"Right Arrow");
		nextStapeClick();
	}

	public void step8LastSheet()
	{
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		//sleep(2000);
		waitForElementToAppear(coverholderCommissionDD, 8);
		verifyMustExists(coverholderCommissionDD,"Coverholder Commission amount, percentage, or both Dropdown");
		click(coverholderCommissionDD,"Coverholder Commission amount, percentage, or both Dropdown");
		//sleep(2000);
		click(commissionAmountOption,"Select Amount option");
		verifyMustExists(brokerageDD,"Brokerage amount, percentage, or both? Dropdown");
		click(brokerageDD,"Brokerage amount, percentage, or both?  Dropdown");
		//sleep(2000);
		click(brokerageAmountOption,"Select Amount option");
		javaScriptclick(producingBrokerageRadioBtn,"Select Producing Brokerage Radio Button");
		javaScriptclick(taxRadioBtn,"Select taxRadioBtn Radio Button");
		verifyMustExists(taxDD,"Tax charged to the insured, either as an amount, percentage, or both? Dropdown");
		click(taxDD,"Tax charged to the insured, either as an amount, percentage, or both? Dropdown");
		//sleep(2000);
		click(taxAmountOption,"Select Amount option");
		nextStapeClick();
	}

	public void step8Claim()
	{
		waitForElementToAppear(InsuredAddress, 8);
		verifyMustExists(InsuredAddress,"Insured Address");
		click(InsuredAddress,"Insured Address");
		verifyMustExists(arrowRightBtn,"Right Arrow");
		click(arrowRightBtn,"Right Arrow");
		nextStapeClick();
	}
	public void step9Claim()
	{
		
		verifyMustExists(paragraph1,"Insured Address");
		verifyMustExists(paragraph2,"Insured Address");
		nextStapeClick();
	}
	public void step10Claim()
	{
		verifyMustExists(paragraph3,"Insured Address");
		verifyMustExists(paragraph4,"Insured Address");
		nextStapeClick();
	}
	public void step11Claim()
	{
		verifyMustExists(paragraph5,"Insured Address");
		verifyMustExists(paragraph6,"Insured Address");
		nextStapeClick();
	}

	public void step8()
	{
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		//sleep(2000);
		waitForElementToAppear(coverholderCommissionDD, 8);
		verifyMustExists(coverholderCommissionDD,"Coverholder Commission amount, percentage, or both Dropdown");
		click(coverholderCommissionDD,"Coverholder Commission amount, percentage, or both Dropdown");
		waitForElementToAppear(commissionAmountOption,2);
		click(commissionAmountOption,"Select Amount option");
		verifyMustExists(brokerageDD,"Brokerage amount, percentage, or both? Dropdown");
		click(brokerageDD,"Brokerage amount, percentage, or both?  Dropdown");
		waitForElementToAppear(brokerageAmountOption,2);
		click(brokerageAmountOption,"Select Amount option");	
		if(isVisible(OtherFeesTxt)==true){
			Report.LogInfo("TextBoxCheck", "Other Fees No option is not selected", "FAIL");
			javaScriptclick(OtherFeesNoOption,"Click on other fees no option.");
		}else{
			Report.LogInfo("TextBoxCheck", "Other Fees No option is selected", "PASS");
		}		
		nextStapeClick();
	}

	public void step9()
	{
		//findWebElement(premiumsChk).sendKeys(Keys.SPACE);
		//findWebElement(limitsAndOthersChk).sendKeys(Keys.SPACE);
		nextStapeClick();
	}

	public void step10()
	{
		findWebElement(premiumsChk).sendKeys(Keys.SPACE);
		findWebElement(limitsAndOthersChk).sendKeys(Keys.SPACE);
		nextStapeClick();
		//sleep(5000);
	}

	public void step11()
	{
		//findWebElement(premiumsChk).sendKeys(Keys.SPACE);
		//findWebElement(limitsAndOthersChk).sendKeys(Keys.SPACE);
		nextStapeClick();
	}

	public void step12()
	{
		waitForElementToAppear(SaveBtn, 10);
		verifyMustExists(SaveBtn,"Save Button");
		click(SaveBtn,"Save Button");
		//sleep(15000);
	}

	public void nextStapeClick()
	{	

		waitForElementToAppear(nextStepBtn,5);
		verifyMustExists(nextStepBtn,"Next Step Button");
		javaScriptclick(nextStepBtn,"Next Step Button");
		sleep(3000);
		waitForElementToAppear(Steps,20);
	}

	public void nextStapeClick1() throws InterruptedException
	{	
		verifyMustExists(nextStepBtn,"Next Step Button");
		//javaScriptclick(nextStepBtn,"Next Step Button");
		click(nextStepBtn,"Next button");
		Thread.sleep(5000);
		if(isVisible(Spinner)==true){
			Thread.sleep(2000);
			webDriver.findElement(By.xpath("//*[@ng-click='cancel()']")).click();
			//click(CancelBtn,"Cancel button");
			Thread.sleep(2000);
			click(GotoHome,"Go to home");			
		}
	}

	public void editTextProcess(String Questionnaire, String Year) throws AWTException
	{		
		//Filter
		waitForElementToPresent(By.xpath(QuestionnaireNameFilter), 3);
		verifyMustExists(QuestionnaireNameFilter,"Questionnaire Name Filter");
		click(QuestionnaireNameFilter,"Questionnaire Name Filter");
		waitForElementToPresent(By.xpath(SearchTxt), 3);
		verifyMustExists(SearchTxt,"Search textbox");
		sendKeys(SearchTxt,Questionnaire,"Search textbox");
		sleep(2000);
		webDriver.findElement(By.xpath("//ul//li[contains(.,'"+Questionnaire+"')][1]")).click();
		verifyMustExists(FilterBtn,"Filter button");
		click(FilterBtn,"Filter button");
		waitForElementToPresent(By.xpath(EditBtn), 3);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		//sleep(5000);
		nextStapeClick();
		//step3(TheOnlySheetSpecificTextOption);
		waitForElementToAppear(sheetsContainTxt,3);
		verifyMustExists(sheetsContainTxt,"Questionnaire Name Textbox");
		sendKeys(sheetsContainTxt, Year, "Year");
		nextStapeClick();
	}

	public void filterBordereauQuestionnaire(String QueSearch, String SelectQuestionnaire)
	{
		int i=0;
		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			waitForElementToAppear(QuestionnaireNameFilter,5);
			click(QuestionnaireNameFilter, "Questionnaire Filter");
			sleep(2000);
			if(isVisible(SearchTxt))
			{
				verifyMustExists(SearchTxt,"Search Filter Textbox");	
				sendKeys(SearchTxt,QueSearch,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(SelectQuestionnaire) && i<5);

		click(SelectQuestionnaire, "Searched Record Checkbox");
		verifyMustExists(FilterBtn,"Filter Button");	
		click(FilterBtn,"Filter Button");
	}

	public void editTextProcess() throws AWTException
	{
		sleep(2000);
		if(getTextFrom(VerifyVersion1).equals("1") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "PASS");
		}		
		waitForElementToAppear(EditBtn, 3);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(3000);
		nextStapeClick();
		waitForElementToAppear(appliedToIdentifyDD, 3);
		verifyMustExists(appliedToIdentifyDD,"Applied Bordereau Dropdown");
		click(appliedToIdentifyDD,"Applied Bordereau Dropdown");
		sleep(2000);
		webDriver.findElement(By.xpath("//li[contains(text(),'"+FirstSheetOption+"')]")).click();

		nextStapeClick();
		verifyMustExists(CancelBtn,"Cancel button");
		click(CancelBtn,"Cancel button");
		sleep(3000);
	}

	public void filterBordereauQuestionnaire(String QueSearch)
	{
		waitForElementToPresent(By.xpath(QuestionnaireNameFilter), 3);
		verifyMustExists(QuestionnaireNameFilter,"Questionnaire Name Filter");
		click(QuestionnaireNameFilter,"Questionnaire Name Filter");
		waitForElementToPresent(By.xpath(SearchTxt), 3);
		verifyMustExists(SearchTxt,"Search textbox");
		sendKeys(SearchTxt,QueSearch,"Search textbox");
		waitForElementToPresent(By.xpath(SelectQuestionnaire), 3);
		verifyMustExists(SelectQuestionnaire,"Questionnaire");
		click(SelectQuestionnaire,"Questionnaire");
		verifyMustExists(FilterBtn,"Filter button");
		click(FilterBtn,"Filter button");
	}

	public void filterBordereauQuestionnaire1(String QueSearch)
	{
		String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+QueSearch+"')][1]";

		waitForElementToPresent(By.xpath(QuestionnaireNameFilter), 3);
		verifyMustExists(QuestionnaireNameFilter,"Questionnaire Name Filter");
		click(QuestionnaireNameFilter,"Questionnaire Name Filter");
		waitForElementToPresent(By.xpath(SearchTxt), 3);
		verifyMustExists(SearchTxt,"Search textbox");
		sendKeys(SearchTxt,QueSearch,"Search textbox");
		waitForElementToPresent(By.xpath(SelectQuestionnaire), 3);
		verifyMustExists(SelectQuestionnaire,"Questionnaire");
		click(SelectQuestionnaire,"Questionnaire");
		verifyMustExists(FilterBtn,"Filter button");
		click(FilterBtn,"Filter button");
	}

	public void filterBordereauQuestionnaire2(String QueSearch)
	{
		waitForElementToPresent(By.xpath(QuestionnaireNameFilter), 3);
		verifyMustExists(QuestionnaireNameFilter,"Questionnaire Name Filter");
		click(QuestionnaireNameFilter,"Questionnaire Name Filter");
		waitForElementToPresent(By.xpath(SearchTxt), 5);
		verifyMustExists(SearchTxt,"Search textbox");
		sendKeys(SearchTxt,QueSearch,"Search textbox");
		waitForElementToPresent(By.xpath(SelectQuestionnaire2), 4);
		verifyMustExists(SelectQuestionnaire2,"Questionnaire");
		click(SelectQuestionnaire2,"Questionnaire");
		verifyMustExists(FilterBtn,"Filter button");
		click(FilterBtn,"Filter button");
	}

	public void editTextProcess1() throws AWTException
	{
		sleep(2000);
		if(getTextFrom(VerifyVersion1).equals("1") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "PASS");
		}		
		waitForElementToPresent(By.xpath(EditBtn), 3);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(3000);
		nextStapeClick();
		waitForElementToAppear(appliedToIdentifyDD,2);
		click(appliedToIdentifyDD,"All sheet drop");
		sleep(1000);
		verifyMustExists(FirstSheetVal,"First sheet val");
		click(FirstSheetVal,"First sheet val");
		nextStapeClick();
		verifyMustExists(CancelBtn,"Cancel button");
		click(CancelBtn,"Cancel button");
		sleep(3000);
	}

	public void editTextProcess_1() throws AWTException
	{
		sleep(2000);
		if(getTextFrom(VerifyVersion1).equals("1") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "PASS");
		}		
		waitForElementToPresent(By.xpath(EditBtn), 3);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(3000);
		nextStapeClick();
		
		
		
	}

	public void editTextProcess2() throws AWTException
	{
		sleep(2000);
		if(getTextFrom(VerifyVersion2).equals("1") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "PASS");
		}		
		waitForElementToPresent(By.xpath(EditBtn), 3);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(3000);
		nextStapeClick();
		waitForElementToAppear(appliedToIdentifyDD,2);
		click(appliedToIdentifyDD,"All sheet drop");
		sleep(1000);
		verifyMustExists(FirstSheetVal,"First sheet val");
		click(FirstSheetVal,"First sheet val");
		nextStapeClick();
		verifyMustExists(CancelBtn,"Cancel button");
		click(CancelBtn,"Cancel button");
		sleep(3000);
	}

	//3460	Edit Bordereaux Questionaire 
	public void editBordereauFormatDubForTc4058() throws InterruptedException, AWTException
	{
		String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+QuestionnaireName+"')][1]";

		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		filterBordereauQuestionnaire(QuestionnaireName, SelectQuestionnaire);
		editTextProcess1();
		filterBordereauQuestionnaire(QuestionnaireName, SelectQuestionnaire);
		sleep(3000);
		waitForElementToAppear(VerifyVersion1,5);
		if(getTextFrom(VerifyVersion1).equals("2") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 2", "PASS");
		}
		else
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "FAIL");
		}
	}

	public void editBordereauFormatDubForTc4058_1() throws InterruptedException, AWTException
	{
		String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+QuestionnaireName1+"')][1]";

		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		filterBordereauQuestionnaire(QuestionnaireName1, SelectQuestionnaire);
		editTextProcess2();
		filterBordereauQuestionnaire(QuestionnaireName1, SelectQuestionnaire);
		sleep(3000);
		waitForElementToAppear(VerifyVersion2,5);
		if(getTextFrom(VerifyVersion2).equals("2") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 2", "PASS");
		}
		else
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "FAIL");
		}
	}

	public void deactivateQuestionnaire()
	{
		//filterBordereauQuestionnaire(QuestionnaireName1, SelectQuestionnaire);
		String DectiveBtnQue = "@xpath=.//*[@ng-click='ActiveDeactive(dataItem,false)']";
		//String ActiveBtnQue = "@xpath=..//*[@ng-click='ActiveDeactive(dataItem,true)']";
		if(isVisible(DectiveBtnQue)==true){
			Report.LogInfo("Deactivate", "Bordereau Questionnaire is Deactivate", "PASS");
		}else{
			Report.LogInfo("Deactivate", "Bordereau Questionnaire is not Deactivate", "FAIL");

		}
	}

	public void firstSheetProcess5(String SchemaName,String QuestionnaireName) throws AWTException, ClientProtocolException, IOException
	{

		//String QuestionnaireName = "SP - All Sheet(s)"+getCurrentDateTimeMS();

		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S82113320171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S82113320171010.xlsx\"}}";
		//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S37427020171126.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S37427020171126.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\January_2017_First_Sheet.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		String QuestioneriesValue ="@xpath=//li[contains(.,'"+SchemaName+"')]";
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		//sleep(2000);
		verifyMustExists(riskOption,"Select Risk Option");
		click(riskOption,"Select Risk Option");
		//sleep(2000);
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		//sleep(2000);
		verifyMustExists(QuestioneriesValue,"Questioneries Value");
		click(QuestioneriesValue,"Questioneries Value");
		//sleep(2000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,QuestionnaireName,"Questionnaire Name Textbox.");
		nextStapeClick();
		//System.out.println(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		//sleep(2000);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5_1();
		step6();
		step7_1();
		step8();
		step9();
		step10();

		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));
		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(1000);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(200);
			}
		}
		sleep(1000);
		String YBDrag = "@xpath=//button[contains(.,'YB')]";
		String YBDrop = "@xpath=//td[contains(.,'Building Year Built')]//preceding-sibling::td/div/div";

		String ContentsDrag = "@xpath=//button[text()='Contents']";
		String ContentsDrop = "@xpath=//td[contains(.,'Contents Value')]//preceding-sibling::td/div/div";
		String AddressDrag = "@xpath=//button[contains(.,'Address 1')]";
		String AddressDrop = "@xpath=//td[contains(.,'Insured Address')]//preceding-sibling::td/div/div";
		String CountryDrag = "@xpath=//button[contains(.,'Country')]";
		String CountryDrop = "@xpath=//td[contains(.,'Insured Country')]//preceding-sibling::td/div/div";


		//td[contains(.,'Construction Code')]//preceding-sibling::td/div/div


		String NoStoriesDrag = "@xpath=//button[contains(.,'No. Stories')]";
		String NoStoriesDrop = "@xpath=//td[contains(.,'Number of Stories')]//preceding-sibling::td/div/div";
		//String PostalCodeDrag = "@xpath=//button[contains(.,'Postal Code')]";
		//String PostalCodeDrop = "@xpath=//td[contains(.,'Insured Postal Code')]//preceding-sibling::td/div/div";
		String BuildingsValueDrag = "@xpath=//button[text()='Buildings']";
		String BuildingsValueDrop = "@xpath=//td[contains(.,'Buildings Value')]//preceding-sibling::td/div/div";
		String OccupancyCodeDrag = "@xpath=//button[text()='Occupancy Code']";
		String OccupancyCodeDrop = "@xpath=//td[contains(.,'Occupancy Code')]//preceding-sibling::td/div/div";
		String OccupancyDescriptionDrag = "@xpath=//button[text()='Occupancy Description']";
		String OccupancyDescriptionDrop = "@xpath=//td[contains(.,'Occupancy Description')]//preceding-sibling::td/div/div";
		String OccupancySchemeDrag = "@xpath=//button[text()='Occupancy Scheme']";
		String OccupancySchemeDrop = "@xpath=//td[contains(.,'Occupancy Scheme')]//preceding-sibling::td/div/div";
		String SprinklersDrag = "@xpath=//button[text()='Sprinklers']";
		String SprinklersDrop = "@xpath=//td[contains(.,'Sprinklers')]//preceding-sibling::td/div/div";
		String ConstructionCodeDrag = "@xpath=//button[text()='Construction Code']";
		String ConstructionCodeDrop = "@xpath=//td[contains(.,'Construction Code')]//preceding-sibling::td//div[@popover='Construction Code']";
		String ConstructionDescrDrag = "@xpath=//button[text()='Construction Description']";
		String ConstructionDescrDrop = "@xpath=//td[contains(.,'Construction Description')]//preceding-sibling::td//div[@popover='Construction Description']";
		String ConstructionSchemaDrag = "@xpath=//button[text()='Construction Scheme']";
		String ConstructionSchemaDrop = "@xpath=//td[contains(.,'Construction Scheme')]//preceding-sibling::td//div[@popover='Construction Scheme']";
		String CountryRiskDrag = "@xpath=//button[text()='Country']";
		String RiskCountryDrop = "@xpath=//*[@ng-bind='dataItem.fieldName'][text()='Risk County']//preceding::td[1]";

		dragDropElement(YBDrag,YBDrop);
		dragDropElement(ConstructionCodeDrag,ConstructionCodeDrop);
		dragDropElement(ConstructionDescrDrag,ConstructionDescrDrop);
		dragDropElement(ConstructionSchemaDrag,ConstructionSchemaDrop);
		dragDropElement(BuildingsValueDrag,BuildingsValueDrop);
		dragDropElement(ContentsDrag,ContentsDrop);
		dragDropElement(AddressDrag,AddressDrop);
		dragDropElement(CountryDrag,CountryDrop);
		//dragDropElement(PostalCodeDrag,PostalCodeDrop);
		dragDropElement(NoStoriesDrag,NoStoriesDrop);
		dragDropElement(OccupancyCodeDrag,OccupancyCodeDrop);
		dragDropElement(OccupancyDescriptionDrag,OccupancyDescriptionDrop);
		dragDropElement(OccupancySchemeDrag,OccupancySchemeDrop);
		dragDropElement(CountryRiskDrag,RiskCountryDrop);
		dragDropElement(SprinklersDrag,SprinklersDrop);


		step11();
		BFormatId= ReturnFormatID();
		//System.out.println(BFormatId);
		step12();
	}

	public void step8_1()
	{
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		//sleep(2000);
		waitForElementToAppear(coverholderCommissionDD, 8);
		verifyMustExists(coverholderCommissionDD,"Coverholder Commission amount, percentage, or both Dropdown");
		click(coverholderCommissionDD,"Coverholder Commission amount, percentage, or both Dropdown");
		waitForElementToAppear(commissionAmountOption,2);
		javaScriptclick(producingBrokerageRadioBtn,"Select Producing Brokerage Radio Button");
		click(commissionAmountOption,"Select Amount option");
		verifyMustExists(brokerageDD,"Brokerage amount, percentage, or both? Dropdown");
		click(brokerageDD,"Brokerage amount, percentage, or both?  Dropdown");
		waitForElementToAppear(brokerageAmountOption,2);
		click(brokerageAmountOption,"Select Amount option");		
		nextStapeClick();
	}

	public void gotostep11()
	{
		waitForElementToAppear(step11link,5);
		verifyMustExists(step11link,"Step 11 link");
		javaScriptclick(step11link,"Step 11 link");
		sleep(2000);
		waitForElementToAppear(nextStepBtn,5);
	}

	public void sheetProcessingriskAndPrimium(String SchemaName1,String QueName) throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		allSheetProcess(SchemaName1,QueName);
	}

	public void allSheetProcess(String SchemaName,String QuestionnaireName) throws AWTException, ClientProtocolException, IOException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S43761520180220.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":17660,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S43761520180220.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			allsheetPath = fpath+"\\src\\test\\resources\\testdata\\January 2017 - Aprroved_TC_5185_first.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(allsheetPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		String QuestioneriesValue ="@xpath=//li[contains(.,'"+SchemaName+"')]";
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		verifyMustExists(riskAndPremiumOption,"Select Risk and Premium Option");
		click(riskAndPremiumOption,"Select Risk and Premium Option");
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		verifyMustExists(QuestioneriesValue,"Questioneries Value");
		click(QuestioneriesValue,"Questioneries Value");
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,QuestionnaireName,"Questionnaire Name Textbox.");
		nextStapeClick();
		step3one(FirstSheetOption);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5_1();
		step6();
		step7_1();
		step8();
		nextStapeClick();
		nextStapeClick();
		step9();
	step10();

		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));
		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(1000);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(200);
			}
		}
		sleep(1000);
		step12one();
		BFormatId= ReturnFormatID();
		step13();
	}

	public void step3one(String sheetName)
	{
		verifyMustExists(suppliedBordereauSheetDD,"Supplied Bordereau Dropdown");
		click(suppliedBordereauSheetDD,"Supplied Bordereau Dropdown");
		click(suppliedBordereauSheetBordDataOption,"Select bord data Option");
		verifyMustExists(appliedToIdentifyDD,"Applied Bordereau Dropdown");
		click(appliedToIdentifyDD,"Applied Bordereau Dropdown");
		sleep(2000);
		webDriver.findElement(By.xpath("//li[contains(text(),'"+sheetName+"')]")).click();
	}

	public void step11one()
	{
		findWebElement(premiumsChk).sendKeys(Keys.SPACE);
		findWebElement(limitsAndOthersChk).sendKeys(Keys.SPACE);
		nextStapeClick();
	}

	public void step12one()
	{
		nextStapeClick();
		sleep(2000);
	}

	public void step13()
	{
		waitForElementToAppear(SaveBtn, 10);
		verifyMustExists(SaveBtn,"Save Button");
		click(SaveBtn,"Save Button");
		sleep(3000);
	}

	public void EditRiskAndPremium(String BoredereauName)
	{ 
		verifyMustExists(DataRef.EditKebabThreeDotsLink,"Edit Risk & Premium Field");
		click(DataRef.EditKebabThreeDotsLink,"Edit Risk & Premium Field");
		sleep(1000);
		verifyMustExists(DataRef.EditLink,"Edit Risk & Premium Field");
		click(DataRef.EditLink,"Edit Risk & Premium Field");
		sleep(2000);
		scrollUp();
		DataRef.applyFieldNameFilter("Insured Name");
		verifyMustExists(EditInsuredName,"Verify Edit Insured Name Field");
		click(EditInsuredName,"Edit Insured Name Field");
		sleep(1000);
		waitForElementToAppear(DataRef.SourceDataStandardReference,5);
		verifyMustExists(DataRef.SourceDataStandardReference,"Source Data Standard Reference");
		sendKeys(DataRef.SourceDataStandardReference, BoredereauName, "Enter Source Data Standard Reference");

		verifyMustExists(DataRef.AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		click(DataRef.AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		sleep(4000);
		waitForElementToAppear(DataRef.WarningMessage,5);
		verifyMustExists(DataRef.WarningMessage,"WarningMessage");
		// waitForElementToAppear(ValueIfNullDropDwn,5);*/
		verifyMustExists(DataRef.AddFieldsPopupSaveChangesButton,"AddFieldsPopupSaveChangesButton");
		click(DataRef.AddFieldsPopupSaveChangesButton,"AddFieldsPopupSaveChangesButton");
		sleep(2000);
	}
	public void RemoveRiskAndPremiumData()
	{ 
		verifyMustExists(DataRef.EditKebabThreeDotsLink,"Edit Risk & Premium Field");
		click(DataRef.EditKebabThreeDotsLink,"Edit Risk & Premium Field");
		sleep(1000);
		verifyMustExists(DataRef.EditLink,"Edit Risk & Premium Field");
		click(DataRef.EditLink,"Edit Risk & Premium Field");
		sleep(2000);
		scrollUp();
		DataRef.applyFieldNameFilter("Insured Name");
		verifyMustExists(EditInsuredName,"Verify Edit Insured Name Field");
		click(EditInsuredName,"Edit Insured Name Field");
		sleep(1000);
		waitForElementToAppear(DataRef.SourceDataStandardReference,5);
		verifyMustExists(DataRef.SourceDataStandardReference,"Source Data Standard Reference");
		clearTextBox(DataRef.SourceDataStandardReference);
		//sendKeys(DataRef.SourceDataStandardReference, BoredereauName, "Enter Source Data Standard Reference");

		verifyMustExists(DataRef.AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		click(DataRef.AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		sleep(4000);
		waitForElementToAppear(DataRef.WarningMessage,5);
		verifyMustExists(DataRef.WarningMessage,"WarningMessage");
		// waitForElementToAppear(ValueIfNullDropDwn,5);*/
		verifyMustExists(DataRef.AddFieldsPopupSaveChangesButton,"AddFieldsPopupSaveChangesButton");
		click(DataRef.AddFieldsPopupSaveChangesButton,"AddFieldsPopupSaveChangesButton");
		sleep(2000);
	}
	public void filterBordereauField(String BordereauSearch)
	{
		String SelectFieldName = "@xpath=//input[@value='"+BordereauSearch+"']";

		waitForElementToPresent(By.xpath(BorderueFieldNameFilter), 3);
		verifyMustExists(BorderueFieldNameFilter,"Borderue Field Name Filter");
		click(BorderueFieldNameFilter,"Borderue Field Name Filter");
		waitForElementToPresent(By.xpath(SearchTxt), 3);
		verifyMustExists(SearchTxt,"Search textbox");
		sendKeys(SearchTxt,BordereauSearch,"Search textbox");
		waitForElementToPresent(By.xpath(SelectFieldName), 3);
		verifyMustExists(SelectFieldName,"Questionnaire");
		click(SelectFieldName,"Questionnaire");
		verifyMustExists(FilterBtn,"Filter button");
		click(FilterBtn,"Filter button");
	}
	public void ChangeRiskAndPremium()
	{ 
		verifyMustExists(DataRef.EditKebabThreeDotsLink,"Edit Risk & Premium Field");
		click(DataRef.EditKebabThreeDotsLink,"Edit Risk & Premium Field");
		sleep(1000);
		verifyMustExists(DataRef.EditLink,"Edit Risk & Premium Field");
		click(DataRef.EditLink,"Edit Risk & Premium Field");
		sleep(2000);
		scrollUp();
		DataRef.applyFieldNameFilter("Risk Issuance Date");
		verifyMustExists(EditRiskIssuranceDate,"Verify Edit Risk Issurance Date Field");
		click(EditRiskIssuranceDate,"Edit Risk Issurance Date Field");
		sleep(1000);
		waitForElementToAppear(MandatoryYes,5);
		verifyMustExists(MandatoryYes,"Mandatory Yes");
		click(MandatoryYes,"Mandatory Yes");
		sleep(1000);			
		verifyMustExists(DataRef.AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		click(DataRef.AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		sleep(4000);
		DataRef.applyFieldNameFilter("Building Year Built");
		verifyMustExists(EditBuildingYearBuilt,"Verify Edit Building Year Built Field");
		click(EditBuildingYearBuilt,"Edit Building Year Built Field");
		sleep(1000);
		waitForElementToAppear(MandatoryYes,5);
		verifyMustExists(MandatoryYes,"Mandatory Yes");
		click(MandatoryYes,"Mandatory Yes");
		sleep(1000);			
		verifyMustExists(DataRef.AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		click(DataRef.AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		sleep(2000);
		DataRef.applyFieldNameFilter("Number of Stories");
		verifyMustExists(EditNumberofStories,"Verify Edit Number of Stories");
		click(EditNumberofStories,"Edit Risk Number of Stories Field");
		sleep(1000);
		waitForElementToAppear(MandatoryYes,5);
		verifyMustExists(MandatoryYes,"Mandatory Yes");
		click(MandatoryYes,"Mandatory Yes");
		sleep(1000);			
		verifyMustExists(DataRef.AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		click(DataRef.AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		sleep(2000);
		waitForElementToAppear(DataRef.WarningMessage,5);
		verifyMustExists(DataRef.WarningMessage,"WarningMessage");
		// waitForElementToAppear(ValueIfNullDropDwn,5);*/
		verifyMustExists(DataRef.AddFieldsPopupSaveChangesButton,"AddFieldsPopupSaveChangesButton");
		click(DataRef.AddFieldsPopupSaveChangesButton,"AddFieldsPopupSaveChangesButton");
		sleep(2000);
	}
	
	public void firstSheetProcess11(String SchemaName) throws AWTException, ClientProtocolException, IOException
	{
		String QuestionnaireName = "SP - All Sheet(s)"+getCurrentDateTimeMS();

		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S82113320171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S82113320171010.xlsx\"}}";
		//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S37427020171126.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S37427020171126.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\January_2017_First_Sheet.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		String QuestioneriesValue ="@xpath=//li[contains(.,'"+SchemaName+"')]";
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		//sleep(2000);
		verifyMustExists(riskOption,"Select Risk Option");
		click(riskOption,"Select Risk Option");
		//sleep(2000);
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		//sleep(2000);
		verifyMustExists(QuestioneriesValue,"Questioneries Value");
		click(QuestioneriesValue,"Questioneries Value");
		//sleep(2000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,QuestionnaireName,"Questionnaire Name Textbox.");
		nextStapeClick();
		//System.out.println(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		//sleep(2000);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7_1();
		step8();
		step9();
		step10();

		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));
		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(1000);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(200);
			}
		}
		String AddressDrag = "@xpath=//button[contains(.,'Address 1')]";
		String AddressDrop = "@xpath=//td[contains(.,'Insured Address')]//preceding-sibling::td/div/div";
		String CountryDrag = "@xpath=//button[contains(.,'Country')]";
		String CountryDrop = "@xpath=//td[contains(.,'Insured Country')]//preceding-sibling::td/div/div";
		String ContentsDrag = "@xpath=//button[text()='Contents']";
		String ContentsDrop = "@xpath=//td[contains(.,'Contents Value')]//preceding-sibling::td/div/div";
	
		String PostalCodeDrag = "@xpath=//button[contains(.,'Postal Code')]";
		String PostalCodeDrop = "@xpath=//td[contains(.,'Insured Postal Code')]//preceding-sibling::td/div/div";
		String BuildingsValueDrag = "@xpath=//button[text()='Buildings']";
		String BuildingsValueDrop = "@xpath=//td[contains(.,'Buildings Value')]//preceding-sibling::td/div/div";
		String OccupancyCodeDrag = "@xpath=//button[text()='Occupancy Code']";
		String OccupancyCodeDrop = "@xpath=//td[contains(.,'Occupancy Code')]//preceding-sibling::td/div/div";
		String OccupancyDescriptionDrag = "@xpath=//button[text()='Occupancy Description']";
		String OccupancyDescriptionDrop = "@xpath=//td[contains(.,'Occupancy Description')]//preceding-sibling::td/div/div";
		String OccupancySchemeDrag = "@xpath=//button[text()='Occupancy Scheme']";
		String OccupancySchemeDrop = "@xpath=//td[contains(.,'Occupancy Scheme')]//preceding-sibling::td/div/div";
		String BuildingYearBuiltDrag = "@xpath=//button[contains(.,'YB')]";
		String BuildingYearBuiltDrop = "@xpath=//td[contains(.,'Building Year Built')]//preceding-sibling::td/div/div";
		String SprinklersDrag = "@xpath=//button[text()='Sprinklers']";
		String SprinklersDrop = "@xpath=//td[contains(.,'Sprinklers')]//preceding-sibling::td/div/div";
		String NoStoriesDrag = "@xpath=//button[contains(.,'No. Stories')]";
		String NoStoriesDrop = "@xpath=//td[contains(.,'Number of Stories')]//preceding-sibling::td/div/div";
		String ExpiryDrag = "@xpath=//button[text()='Expiry']";
		String ExpiryDrop = "@xpath=//td[contains(.,'Cancellation Date')]//preceding-sibling::td/div[1]/div";
	
		dragDropElement(BuildingYearBuiltDrag,BuildingYearBuiltDrop);
		dragDropElement(BuildingsValueDrag,BuildingsValueDrop);
		dragDropElement(AddressDrag,AddressDrop);
		dragDropElement(CountryDrag,CountryDrop);
		dragDropElement(PostalCodeDrag,PostalCodeDrop);
		dragDropElement(OccupancyCodeDrag,OccupancyCodeDrop);
		dragDropElement(OccupancyDescriptionDrag,OccupancyDescriptionDrop);
		dragDropElement(OccupancySchemeDrag,OccupancySchemeDrop);
		sleep(1000);

		step11();
		verifyExists(VerifyFirstRow,"Verify First Row");
		String FirstRow = getTextFrom(VerifyFirstRow);
		String SecondRow = getTextFrom(VerifySecondRow);
		String ThirdRow = getTextFrom(VerifyThirdRow);
		String FourthRow = getTextFrom(VerifyFourthRow);
		if(FirstRow=="Cancellation Date"){
			Report.LogInfo("FirstRowValidation", "Cancellation Date is Display is Red", "PASS");
		}
		else{
			Report.LogInfo("SaveandReprocessValidation", "Cancellation Date is not Display is Red", "FAIL");
		}			
		verifyExists(VerifySecondRow,"Verify Second Row");
		if(FirstRow=="Contents Value"){
			Report.LogInfo("FirstRowValidation", "Contents Value is Display is Red", "PASS");
		}
		else{
			Report.LogInfo("SaveandReprocessValidation", "Contents Value is not Display is Red", "FAIL");
		}
		verifyExists(VerifyThirdRow,"Verify Third Row");
		if(FirstRow=="Number of Stories"){
			Report.LogInfo("FirstRowValidation", "Cancellation Date is Display is Red", "PASS");
		}
		else{
			Report.LogInfo("SaveandReprocessValidation", "Cancellation Date is not Display is Red", "FAIL");
		}
		verifyExists(VerifyFourthRow,"Verify Fourth Row");
		if(FirstRow=="Sprinkers(Y/N)"){
			Report.LogInfo("FirstRowValidation", "Cancellation Date is Display is Red", "PASS");
		}
		else{
			Report.LogInfo("SaveandReprocessValidation", "Cancellation Date is not Display is Red", "FAIL");
		}
		verifyMustExists(Step11Btn,"Step 11");
		click(Step11Btn,"Step 11");
		
		/*List<WebElement> RemoveIcon1 = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));
		for(int i=1; i<=RemoveIcon1.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(1000);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(200);
			}
		}*/
		
		dragDropElement(ContentsDrag,ContentsDrop);
		dragDropElement(NoStoriesDrag,NoStoriesDrop);
		dragDropElement(SprinklersDrag,SprinklersDrop);
		dragDropElement(ExpiryDrag,ExpiryDrop);
		step11();
		sleep(2000);
		BFormatId= ReturnFormatID();
		//System.out.println(BFormatId);
		step12();
		QuestionnaireName_TC5141 = QuestionnaireName;
	}
	

	public void HeaderrowselectionQuestionnaire_TC5524() throws Exception
	{
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		addQuestionnaireHR();
	}
}
