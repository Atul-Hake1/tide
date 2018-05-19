package com.tide.qa.pagefactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class SchemaPage extends PageBase {


	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BordereauProcessPage Br = new BordereauProcessPage();
	BordereauQuePage QuePage = new BordereauQuePage();
	BordereauProcessPage BordereauProcess = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();
	Rules rule = new Rules();
	String RuleNameInformation;
	String UniqueReferenceVal1;
	String FilteredRuleNameVerification;
	
	public static String COBName;

	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("ssMsddMMyy");
		String datetime = ft.format(dNow);
		return datetime;
	}

	public static String getCurrentDateTimeMS1() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMssddHHmm");
		String datetime = ft.format(dNow);
		return datetime;
	}

	String RuleName;
	String FilteredRuleNameVerification1;

	public static String contractId;
	public static String sheet4076Path = "";
	public static String sheet3937Path = "";
	public static String sheet3938Path = "";
	public static String sheet3849Path = "";
	public static String sheet3850Path = "";
	public static String sheet3789Path = "";
	public static String sheet3789Path1 = "";
	public static String sheet4044Path = "";
	public static String sheet4080Path = "";
	public static String sheet4080Path1 = "";
	public static String sheet5141Path = "";

	//Schema name
	public static final String RiskSchemaName = "Automation_"+getCurrentDateTimeMS();
	public static final String PremiumSchemaName = "Premium_Test_Schema_"+getCurrentDateTimeMS();
	public static final String ClaimSchemaName = "Automation_Claim_Schema_"+getCurrentDateTimeMS();
	//public static final String PremiumSchemaName="Premium_Automation_431143221117";

	public static final String SchemaLink = "@linkText=Schema";

	//Schema page label
	public static final String SchemaPageLbl = "@xpath=//*[text()='SCHEMA']";
	public static final String RiskLbl = "@xpath=//h3[text()='Risk']";
	public static final String PremiumLbl = "@xpath=//h3[text()='Premium']";
	public static final String ClaimLbl = "@xpath=//h3[text()='Claim']";

	//Add Schema icon
	public static final String AddRiskBtn = "@xpath=//*[@ng-repeat='dataset in SchemaSet'][3]//button";
	public static final String AddPremiumBtn = "@xpath=//*[@ng-repeat='dataset in SchemaSet'][2]//button";
	public static final String AddClaimBtn = "@xpath=//*[@ng-repeat='dataset in SchemaSet'][1]//button";

	//Add Schema page Details
	public static final String SchemaNameTxt = "@xpath=//*[@ng-model='data.SchemaDetails.SchemaName']";
	public static final String ClassOfBusinessDD="@xpath=//*[@ng-model='data.SelectedCOBList']//preceding-sibling::div[1]/input";
	public static final String ClassOfBusinessDDValue = "@xpath=//li[contains(text(),'Property D&F (US binder)')]";
	public static final String ClassOfBusinessDDValue1 = "@xpath=//li[contains(text(),'Cargo')]";
	public static final String SchemaTypeDD="@xpath=//*[@ng-model='data.SchemaDetails.SchemaType']//preceding-sibling::span[1]";
	public static final String SchemaTypeDDValue = "@xpath=//li[contains(text(),'Bordereaux')]";
	public static final String SchemaTypeDDValue1 = "@xpath=//li[contains(text(),'Schedule')]";
	public static final String SaveBtn="@buttonText=Save";
	public static final String SaveChangesBtn="@buttonText=Save Changes";
	public static final String CBddValue="Property D&F (US binder)";
	public static final String SchemaTypeDDTechnology = "@xpath=//li[contains(.,'Technology')]";
	public static final String STddValue="Bordereaux";
	public static final String STddValue1="Schedule";

	//Schema edit page
	public static final String EditkebabIcon = "@xpath=//ui-view[@id='content']//a[@class='dropdown-toggle']";
	public static final String Editlink = "@xpath=//ui-view[@id='content']//a[text()='Edit']";
	public static final String EditClassOfBusinessDD="@xpath=//*[@id='COBLIST']//preceding-sibling::div[1]/input";
	public static final String PropertyDFCancelIcon="@xpath=//dt[text()='Class of Business']/..//li//span[@class='k-icon k-i-close']";
	public static final String EditClassOfBusinessDDValue = "@xpath=//li[contains(text(),'Professional Indemnity (US)')]";
	public static final String BuildingsValue = "@xpath=//*[text()='A - Buildings Value']";
	public static final String BuildingsValue1 = "@xpath=//ul[@aria-hidden='false']//li[text()='Buildings Value']";
    
	public static final String BuildingsValuecheckbox1 ="@xpath=//label[contains(.,'A - Buildings Value')]";
	public static final String ContentValueCheckBox ="@xpath=//label[contains(.,'C - Contents Value')]";
	public static final String LocationSprinklersCheckBox ="@xpath=//label[contains(.,'Location Sprinklers (Y/N)')]";
	public static final String NoOfStoriescheckbox ="@xpath=//label[contains(.,'Number of Stories')]";
	public static final String BuildingYearBuiltcheckbox ="@xpath=//label[contains(.,'Building Year Built')]";
	public static final String ConstructionSchemecheckbox ="@xpath=//label[contains(.,'Location Occupancy Scheme')]";
	public static final String ConstructionCodecheckbox ="@xpath=//label[contains(.,'Location Occupancy Code')]";
	public static final String ConstructionDescriptioncheckbox ="@xpath=//label[contains(.,'Location Occupancy Description')]";
	
	
	public static final String RightArrowIcon = "@xpath=//*[@ng-click='addToSchemaList()']";
	public static final String SaveAndPublishBtn = "@xpath=//*[@ng-click='savePublish()']";
	public static final String InsuredNameValue="@xpath=//*[@ng-bind='dataItem.DisplayFieldName'][contains(.,'Insured Name')]";

	public static final String FieldSelectionTab = "@xpath=//a[@ng-click='fieldSelection()']";
	public static final String SettingsTab = "@xpath=//a[text()='Settings']";
	public static final String TotalValueSelectionDD = "@xpath=//*[text()='Total Value Selection']/..//*[@class='k-dropdown-wrap k-state-default']";
	public static final String TotalValueSelectionDDValue = "@xpath=//li[contains(text(),'Total Sum Insured')]";
	public static final String ClassOfBusinessTxt = "@xpath=//*[text()='Class of Business']/../dd";
	public static final String PublishedDescriptionTxt = "@xpath=//*[text()='Published Description']/../dd";
	public static final String PublishDescriptionTxt = "@xpath=//textarea";
	public static final String PublishBtn = "@xpath=//button[@ng-click='publish()']";
	public static final String AddSchemaPageErrorMsg = "@xpath=//*[@ng-if='hasError']";
	public static final String EditPageErrorMsg = "@xpath=//*[@ng-if='hasError']";

	public static final String NoteValue = "@xpath=//*[text()='Notes']";
	public static final String TransactionReference = "@xpath=//*[text()='Transaction Reference']";
	public static final String changedversion = "@xpath=//small";
	//Locators for TC_4076
	public static final String AddRuleInformation= "@xpath=//li[@ng-click='addData(w)']//a[contains(text(),'Information')]";
	public static final String RuleNameText ="@xpath=//*[@ng-model='data.Rules.RuleName']";
	public static final String ErrorMsgTxt ="@xpath=//*[@ng-model='data.Rules.ErrorMessage']";
	public static final String DataSetValueDD = "@xpath=//*[@ng-model='data.Rules.DatasetType']//preceding-sibling::span[1]";
	public static final String DatasetValueDDValue = "@xpath=//li[text()='Risk']";
	public static final String SchemaValueDD = "@xpath=//*[@ng-model='data.Rules.SchemaId']//preceding-sibling::span[1]";
	//public static final String SchemaValueDDValue = "@xpath=//li[contains(.,'Information Schema')]";
	public static final String AppConditionValueDD = "@xpath=//*[@ng-model='data.Rules.IsRuleValid']//preceding-sibling::span[1]";
	public static final String AppConditionValueDDValue = "@xpath=//div[@class='k-list-scroller']//li[text() ='Data is not valid if the rule conditions are met']";
	public static final String AddRuleConditionBtn ="@xpath=//*[@ng-click='addRulesCondition()']";
	public static final String FieldNameValueDD = "@xpath=//*[@ng-model='w.FieldId']//preceding-sibling::span[1]";
	public static final String FieldNameDDValue = "@xpath=//li[text()='Buildings Value']";
	public static final String OperatorValueDD = "@xpath=//*[@ng-model='w.Operator']//preceding-sibling::span[1]";
	public static final String OperatorDDValue = "@xpath=//li[text()='Not Between']";
	public static final String AppliedToValueDD = "@xpath=//*[@ng-model='w.AppliedTo']//preceding-sibling::span[1]";
	public static final String AppliedToDDValue = "@xpath=//li[text()='Value']";
	public static final String EntryValueFromText ="@xpath=//*[@ng-model='w.EntryValueFrom']";
	public static final String EntryValueToText ="@xpath=//*[@ng-model='w.EntryValueTo']";
	public static final String EditRuleBtn ="@xpath=//div[1]//*[@ng-if='w.$edit']/../button[1]";
	public static final String SaveRuleBtn ="@xpath=//*[@ ng-click='save()']";

	// For Filter Schema
	public static final String FilterIconSchema = "@xpath=//*[@data-title='Schema']/a/span";
	public static final String ContentsValueSchema = "@xpath=//*[text()='Contents Value']";
	public static final String RuleBreach = "@xpath=.//*[@id='grid']//tr[1]/td[9]";
	public static final String FilterBtnSchema = "@xpath=//button[contains(.,'Filter')]";
	public static final String FilterIcon = "@xpath=//*[@data-title='Field Name']/a/span";
	public static final String SearchTxt = "@xpath=//input[@placeholder='Search']";
	public static final String FilterBtn = "@xpath=//button[contains(.,'Filter')]";
	public static final String RuleHeaderLink = "@xpath=//a[text()='RULES']";
	public static final String AddRuleDropDown= "@xpath=//button[@ng-click='addData()']//following-sibling::button[1]";
	public static final String AddRuleComplianceData= "@xpath=//li[@ng-click='addData(w)']//a[contains(text(),'Compliance Data')]";
	public static final String ErrorMessgaeText= "@xpath=//input[@ng-model='data.Rules.ErrorMessage']";
	public static final String DataSetDrpDwn= "@xpath=//*[text()='Dataset']//parent::dl//dd//span[@class='k-input ng-scope']";
	public static final String ProcessingActionDrpDwn= "@xpath=//*[text()='Processing Action']//parent::dl//dd//span[@class='k-input ng-scope']";
	public static final String CurrencyDrpDwn= "@xpath=//select[@ng-model='data.Rules.Currency']//preceding-sibling::span[1]";
	public static final String ROETolerance= "@xpath=.//*[@ng-model='data.Rules.ROETolerance']";
	public static final String AppConditonDrpDwn= "@xpath=//select[@k-ng-model='data.Rules.IsRuleValid']//preceding-sibling::span[1]";
	public static final String AppSectionDrpDwn= "@xpath=//select[@ng-model='data.SelectedContractSection']//preceding-sibling::div[1]";
	//public static final String FilterIconRuleName= "@xpath=//*[@id='45f80b49-9d49-4615-8c76-9e1fc6d3ce65']/a[1]/span";
	//public static final String FilterIconRuleName= "@xpath=//*[data-title='Rule Name']/a/span";
	//public static final String FilterRuleName = "@xpath=//button[contains(.,'Filter')]";

	public static final String ContentsValue = "@xpath=//*[text()='C - Contents Value']";
	public static final String Sprinklers = "@xpath=//span[text()='Location Sprinklers (Y/N)']";
	public static final String NumberOfStories = "@xpath=//span[contains(.,'Number of Stories')]";
	public static final String BuildingYearBuilt = "@xpath=//span[contains(.,'Building Year Built')]";
	public static final String OccupancyScheme = "@xpath=//span[contains(.,'Occupancy Scheme')]";
	public static final String OccupancyCode = "@xpath=//span[contains(.,'Occupancy Code')]";
	public static final String OccupancyDescription = "@xpath=//span[contains(.,'Occupancy Description')]";
	public static final String TotalInsurableValue = "@xpath=//span[contains(.,'Total Insurable Value')]";
	public static final String TotalValueDD = "@xpath=//*[@ng-model='data.TotalValue']//preceding-sibling::span[1]";
	public static final String TotalValueDDValue = "@xpath=//li[contains(.,'Total Insurable Value')]";

	//3937 Error screen
	public static final String MultipleConditionRuleError ="@xpath=//h2[contains(.,'Multiple Condition Rule')]";
	public static final String Data0 ="@xpath=//input[contains(@id,'Data0')]";
	public static final String Data1 ="@xpath=//input[contains(@id,'Data1')]";
	public static final String Data2 ="@xpath=//input[contains(@id,'Data2')]";
	public static final String Data3 ="@xpath=//input[contains(@id,'Data3')]";
	public static final String Data4 ="@xpath=//input[contains(@id,'Data4')]";
	public static final String ContinueBtn ="@xpath=//button[@type='submit']";
	public static final String CancelBtn ="@xpath=//button[@ng-click='cancel()']";


	//Rule
	public static final String GrossPremiumValue ="@xpath=//ul//li[text()='Gross Premium']";
	public static final String GreaterThanOrEqualToValue ="@xpath=//li[contains(.,'Greater Than Or Equal To')]";
	public static final String NumberOfStoriesValue ="@xpath=//li[contains(.,'Number of Stories')]";
	public static final String InsuredAddressValue ="@xpath=//li[contains(.,'Insured Address')]";
	public static final String BetweenValue ="@xpath=//li[text()=('Between')]";
	public static final String EntryValueFromTxt ="@model=w.EntryValueFrom";
	public static final String EntryValueToTxt ="@model=w.EntryValueTo";
	public static final String OrValue ="@xpath=//li[text()='Or']";
	public static final String RiskInceptionDateValue ="@xpath=//li[contains(.,'Risk Inception Date')]";
	public static final String NotEqualToValue ="@xpath=//li[contains(.,'Not Equal To')]";
	public static final String TotalInsurableValueRule ="@xpath=//li[contains(.,'Total Insurable Value')]";
	public static final String GreaterThanValue ="@xpath=//li[contains(.,'Greater Than')]";
	public static final String LessThanValue ="@xpath=//li[text()='Less Than']";
	public static final String BuildingYearBuiltValue ="@xpath=//li[contains(.,'Building Year Built')]";
	public static final String ContentsValue1 ="@xpath=//ul[@aria-hidden='false']//li[text()='Contents Value']";
	public static final String EntryValueFromDD ="@xpath=//*[@ng-model='w.EntryValueFrom']//preceding-sibling::span[1]";
	public static final String EntryValueToDD ="@xpath=//*[@ng-model='w.EntryValueTo']//preceding-sibling::span[1]";
	public static final String EntryValueFromDD1960Value ="@xpath=//ul/li[contains(.,'1960')]";
	public static final String BuildingYearBuiltDD ="@xpath=//*[@id='Data2']//preceding-sibling::span[1]";
	public static final String RiskCurrencyValue ="@xpath=//li[contains(.,'Risk Currency')]";
	//public static final String RiskCurrencyValue ="@xpath=//li[contains(.,'Risk Currency')]";
	public static final String EntryValueFromDDUSDValue ="@xpath=//ul/li[contains(.,'USD')]";
	public static final String TotalTaxValue ="@xpath=//li[contains(.,'Total Tax %')]";
	public static final String LessThanOrEqualToValue ="@xpath=//li[contains(.,'Less Than Or Equal To')]";
	public static final String RiskPostalCodeValue ="@xpath=//li[contains(.,'Risk Postal/Zip Code')]";
	public static final String ContainsValue ="@xpath=//li[contains(.,'Contains')]";
	public static final String NetPremiumValue ="@xpath=//li[text()='Net Premium To Broker']";
	public static final String SprinklersValue ="@xpath=//li[contains(.,'Sprinklers (Y/N)')]";
	public static final String YearOfAcValue ="@xpath=//li[contains(.,'Year Of Account')]";

	public static final String EqualToValue ="@xpath=//li[text()='Equal To']";
	public static final String NoValue ="@xpath=//li[text()='No']";
	public static final String OccupancyCodeValue ="@xpath=//li[contains(.,'Occupancy Code')]";
	public static final String IsBlankValue ="@xpath=//li[contains(.,'Is Blank')]";
	public static final String NotBetweenValue ="@xpath=//li[text()='Not Between']";
	public static final String ClassBusinessSelction= "@xpath=//*[contains(text(),'Class Of Business')]//parent::dl//div[@id='ClassOfBusinessParent']";

	public static final String SingleRuleConditionError ="@xpath=//h2[contains(.,'Single Rule Condition Greater Than')]";
	public static final String EntryValueFromDD300 ="@xpath=//ul[@aria-hidden='false']//li[contains(.,'300')]";
	public static final String EntryValueFromDD400 ="@xpath=//ul[@aria-hidden='false']//li[contains(.,'400')]";
	public static final String Data0DD ="@xpath=//*[@id='Data0']//preceding-sibling::span[1]";
	public static final String USDValue ="@xpath=//ul[@aria-hidden='false']//li[text()='USD']";
	public static final String Data1DD ="@xpath=//*[@id='Data1']//preceding-sibling::span[1]";
	public static final String Data2DD ="@xpath=//*[@id='Data2']//preceding-sibling::span[1]";
	public static final String Data3DD ="@xpath=//*[@id='Data3']//preceding-sibling::span[1]";
	public static final String YesValue ="@xpath=//ul[@aria-hidden='false']//li[text()='Yes']";
	public static final String AFNValue ="@xpath=//ul[@aria-hidden='false']//li[text()='AFN']";
	public static final String GBPValue ="@xpath=//ul[@aria-hidden='false']//li[text()='GBP']";
	public static final String EURValue ="@xpath=//ul[@aria-hidden='false']//li[text()='EUR']";
	public static final String BuildingValue ="@xpath=//li[contains(.,'Buildings Value')]";

	public static final String SingleRuleConditionLessThanEqualError ="@xpath=//h2[contains(.,'Single Rule Condition Less than Equal to Operator')]";
	// Locators:- TC_4044
	//TC_4044
	public static final String AddRulesDropDwn = "@xpath=//*[@ng-click='addData()']//following-sibling::button[1]";
	public static final String AddRulesOptionInformation = "@xpath=//a[text()='Information']";
	public static final String DataSetDropDwn = "@xpath=//*[@ng-model='data.Rules.DatasetType']//preceding-sibling::span";
	public static final String SelectOptionDataSetDropDwn = "@xpath=//li[text()='Risk']";
	public static final String SchemaDropDwn = "@xpath=//*[@ng-model='data.Rules.SchemaId']//preceding-sibling::span";
	public static final String SchemaDropDwnOption = "@xpath=//li[text()='Automation Schema']";
	public static final String SchemaSearchTextBox = "@xpath=//dt[text()='Schema']//following::input[3]";
	public static final String SelectOptionSchemaDropDwn = "@xpath=//li[text()='Automation Schema']";
	public static final String RulesMenuTab = "@xpath=//*[@ng-if='viewRulesTab']//a";
	public static final String SelectOptionNumberOfStories = "@xpath=//li[contains(.,'Number of Stories')]";
	public static final String EntrySelction1 = "@xpath=//*[@ng-model='w.EntryValueFrom']";
	public static final String EntrySelction2 = "@xpath=//input[@ng-model='w.EntryValueTo']";
	public static final String BetweenSlectionOption = "@xpath=//li[text()='Between']";
	public static final String PopupSaveButton = "@xpath=//*[@class='col-sm-12 p-t-10 ng-scope']//following::button[@ng-click='save()']";
	public static final String BreachesLink = "@xpath=//a[text()='Breaches']";
	public static final String RulseDropDwnSelection = "@xpath=//*[@ng-model='SelectedRuleId']//preceding-sibling::span";
	//public static final String RulseDropDwnSelectionOption = "@xpath=//li[contains(.,'Single Information Rule - 7')]";
	public static final String RulesConditionTab = "@xpath=//dd[contains(.,' Number of Stories between 50 and 99')]";
	public static final String PopupTitle = "@xpath=//h2[contains(.,'Signed Contract Change')]";

	//TC_4080
	public static final String InsurableValue= "@xpath=//li[contains(.,'Total Insurable Value')]";
	public static final String BetweenValue1= "@xpath=//li[text()='Between']";
	public static final String Method1= "@xpath=//*[@ng-model='w.Method']//preceding-sibling::span";
	public static final String AndOption= "@xpath=//li[text()='And']";
	public static final String OrOption= "@xpath=//li[text()='Or']";
	public static final String ValueOption= "@xpath=//li[text()='Value']";
	//public static final String DatasetRiskReference= "@xpath=//*[@ng-bind='dataItem.DisplayFieldName']";
	//public static final String DatasetRiskExpiryDate= "@xpath=//td[contains(.,'Risk Expiry Date')]";
	public static final String DatasetRiskInspectionDate= "@xpath=//*[@ng-bind='dataItem.DisplayFieldName'][contains(.,'Risk Inception Date')]";
	public static final String DatasetGrossPremium= "@xpath=//span[text()='Gross Premium']";
	public static final String DatasetTotalInsurableValue= "@xpath=//span[text()='Total Insurable Value']";
	public static final String RightArrowIcon1= "@xpath=//*[@ng-click='addToSelectionList()']/span";

	public static final String AddRulesConditionButton = "@xpath=//button[@ng-click='addRulesCondition()']";
	public static final String FieldNameDrpDwn = "@xpath= //*[@ng-model='w.FieldId']//preceding-sibling::span[1]";
	public static final String OperatorDrpDwn = "@xpath= //*[@ng-model='w.Operator']//preceding-sibling::span[1]";
	public static final String AppliedToDrpDwn = "@xpath= //*[@ng-model='w.AppliedTo']//preceding-sibling::span[1]";
	public static final String EntrySelectionText1 = "@xpath=//*[@ng-model='w.EntryValueFrom']";	
	
	public static final String TickMarkButton1 = "@xpath=//tr[2][@ng-repeat='w in rulesConditionsList track by $index']//descendant::button[1]";
	public static final String TickMarkButton2 = "@xpath=//tr[3][@ng-repeat='w in rulesConditionsList track by $index']//descendant::button[1]";
	public static final String OperatorDrpDwnSearchText = "@xpath= //div[@class='k-animation-container'][5]//input[@class='k-textbox']";
	public static final String OperatorDrpDwnSelectOption = "@xpath=//*[@data-role='staticlist']//li[text()='Equal To']";
	public static final String FieldNameDrpDwnSearchText = "@xpath= //div[@class='k-animation-container'][4]//input[@class='k-textbox']";
	public static final String FieldNameDrpDwnSelectOption1 = "@xpath= //*[@data-role='staticlist']//li[contains(text(),'Risk Inception Date')]";
	public static final String AppliedToDrpDwnSearchText = "@xpath=//div[@class='k-animation-container'][6]//input[@class='k-textbox']";
	public static final String AppliedToDrpDwnSelectOption = "@xpath=//*[@data-role='staticlist']//li[text()='Value']";
	public static final String TickMarkButton = "@xpath= //tr[@ng-repeat='w in rulesConditionsList track by $index']//descendant::button[1]";
	//public static final String EntrySelectionText2 = "@xpath=//input[@ng-model='w.EntryValueTo']";
	public static final String EntrySelectionText2 = "@xpath=//*[@id='content']/div/div/div/form/div/div[2]/div/div[2]/div/div[1]/div/table/tbody/tr[2]/td[5]/div/div/div[2]/span/span[1]";
	//public static final String EntrySelectionText2 = "@xpath=//*[@id='content']/div/div/div/form/div/div[2]/div/div[2]/div/div[1]/div/table/tbody/tr[2]/td[5]/div/div/div[2]/span/span[1]/span[2]/span";
	public static final String SaveButtonComplianceRule= "@xpath=//button[@ng-click='save()']";
	public static final String ApplicationConditionDrpDwn ="@xpath=//*[contains(text(),'Application Condition')]//parent::dt[1]//following::span[@class='k-input ng-scope'][1]";
	public static final String ApplicationConditionDrpDwnSelectOption ="@xpath=//*[@data-role='staticlist']//li[text()='Data is valid if the rule conditions are met']";
	public static final String SubmitPassedWarningRecordsForAssignmentBtn ="@xpath=//button[@ng-click='submitBordereau()']";

	//Create Class of business locators
	public static final String SystemReferanceDataOption ="@xpath=//a[contains(.,'Reference Data')]";
	public static final String ClassOfBusinesslabel ="@xpath=//td[contains(.,'Class Of Business')]";
	public static final String AddClassOfBusinessBtn ="@xpath=//div[@ng-if='permission.Create']";
	public static final String ClassOfBusinessNameTxt ="@model=data.ClassOfBusinessName";
	public static final String ClassOfBusinessShortNameTxt ="@model=data.ClassOfBusinessShortName";
	public static final String LineOfBusinessDD ="@xpath=//*[@ng-model='data.LineOfBusinessId']//preceding-sibling::span[1]";
	public static final String LineOfBusinessValue ="@xpath=//li[text()='Marine']";
	public static final String YearValue1957 ="@xpath=//ul[@aria-hidden='false']//li[contains(.,'1957')]";
	public static final String YearValue1958 ="@xpath=//ul[@aria-hidden='false']//li[contains(.,'1958')]";
	public static final String YearValue1959 ="@xpath=//ul[@aria-hidden='false']//li[contains(.,'1959')]";

	//3789
	public static final String DataSetFilterIcon ="@xpath=//a[text()='Data']/preceding-sibling::a/span";
	public static final String DataSetFilterSearch ="@xpath=//input[@placeholder='Search']";
	//public static final String COBChkBox ="@xpath=//span[contains(.,'Class of Business')]";
	public static final String COBChkBox ="@xpath=/html/body/div[2]/form/ul/li[32]/label/input";
	public static final String RiskExpiryDateValue="@xpath=//*[@ng-bind='dataItem.DisplayFieldName'][contains(.,'Risk Expiry Date')]";
	public static final String GrossPremium = "@xpath=//span[text()=('Gross Premium')]";
	
	public static final String ClassOfBusinessDDValue2 = "@xpath=//li[contains(text(),'Airline')]";
	 public static final String ContentValueChkBox ="@xpath=//span[@ng-bind='dataItem.DisplayFieldName'][text()='Contents Value']/parent::td//following-sibling::td[4]//input";
	 public static final String SpinklersChkBox ="@xpath=//span[@ng-bind='dataItem.DisplayFieldName'][text()='Sprinklers (Y/N)']/parent::td//following-sibling::td[4]//input";
	 public static final String NumberOFStoriesChkBox ="@xpath=//span[@ng-bind='dataItem.DisplayFieldName'][text()='Number of Stories']/parent::td//following-sibling::td[4]//input";
	 public static final String CancellationDateChkBox ="@xpath=//span[@ng-bind='dataItem.DisplayFieldName'][text()='Cancellation Date']/parent::td//following-sibling::td[4]//input";
	 public static final String SaveAndPublishButton="@xpath=//*[@ng-click='savePublish()']";
	 public static final String ViewQuestinnarie ="@xpath=//*[@ng-click='ViewQuestionnaire()']";
	 public static final String RemoveSprinkler ="@xpath=//*[text()='Sprinklers']//following-sibling::span//*[@id='tempData124']";
	 public static final String SaveandReprocess ="@xpath=//*[@ng-if='saveAndReprocess']";

	public void addRiskSchema_3174() throws InterruptedException
	{
		homePage.adminMenu();
		schemaLink();
		schemapage();
		verifySchemaSection(RiskLbl);
		verifyAddschemabutton(AddRiskBtn);
		clickonAddSchemabutton(AddRiskBtn);
		addSchema(RiskSchemaName,ClassOfBusinessDDValue,SchemaTypeDDValue,CBddValue,STddValue);
		verifySchema(RiskSchemaName);
	}

	public void editRiskSchema_3175() throws InterruptedException
	{
		String ExpectedClassofBusiness="Professional Indemnity (US)";
		String ExpectedPublishedDiscription= "Automation Test";
		refreshPage();
		if(webDriver.findElement(By.xpath("//ui-view[@id='content']//h3[contains(text(),'"+RiskSchemaName+"')]")).isDisplayed()== true)
		{
			Report.LogInfo("verifyAddedSchema", "verify added schema successfully", "PASS");
			openInEditMode();
			editSchemaDetails();
			verifyeditedSchema("C - Contents Value", ContentValueCheckBox);
			verifyMustExists(ContentsValue,"Contents Value");
			click(ContentsValue,"Contents Value");
			verifyMustExists(RightArrowIcon,"Right Arrow icon");
			click(RightArrowIcon,"Right Arrow icon");
			sleep(3000);
			navigateToSettingsTab();
			TotalValueSelection(TotalValueSelectionDDValue);
			navigateToFieldSelectionTab();
			SaveAndPublish();
			verifyeditedSchema(RiskSchemaName,ExpectedClassofBusiness,ExpectedPublishedDiscription);	
		}else{
			Report.LogInfo("verifyAddedSchema", "Schema not added successfully", "FAIL");
		}

	}

	public void addPremiumSchema_3176() throws InterruptedException
	{
		homePage.adminMenu();
		schemaLink();
		schemapage();
		verifySchemaSection(PremiumLbl);
		verifyAddschemabutton(AddPremiumBtn);
		clickonAddSchemabutton(AddPremiumBtn);
		addSchema(PremiumSchemaName,ClassOfBusinessDDValue,SchemaTypeDDValue,CBddValue,STddValue);
		verifySchema(PremiumSchemaName);
	}

	public void editPremiumSchema_3177() throws InterruptedException
	{
		String ExpectedClassofBusiness="Professional Indemnity (US)";
		String ExpectedPublishedDiscription= "Automation Test";
		if(isVisible(AddSchemaPageErrorMsg)==true)
		{
			Report.LogInfo("verifyerrorMessage", "Error message displayed,Premiun Schema not added successfully", "Fail");
		}else
		{
			if(webDriver.findElement(By.xpath("//ui-view[@id='content']//h3[contains(text(),'"+PremiumSchemaName+"')]")).isDisplayed()== true)
			{
				Report.LogInfo("verifyAddedSchema", "verify added schema successfully", "PASS");
				openInEditMode();
				if(isVisible(EditPageErrorMsg)==true)
				{
					Report.LogInfo("verifyerrorMessage", "Error message displayed on edit Schema page", "FAIL");	
				}else{
					editSchemaDetails();
					verifyMustExists(NoteValue,"Note value");
					click(NoteValue,"Note value");
					verifyMustExists(RightArrowIcon,"Right Arrow icon");
					click(RightArrowIcon,"Right Arrow icon");
					SaveAndPublish();
					verifyeditedSchema(PremiumSchemaName,ExpectedClassofBusiness,ExpectedPublishedDiscription);
				}
			}else{
				Report.LogInfo("verifyAddedSchema", "Schema not added successfully", "FAIL");
			}

		}

	}

	public void addClaimSchema_3178() throws InterruptedException
	{
		homePage.adminMenu();
		schemaLink();
		schemapage();
		verifySchemaSection(ClaimLbl);
		verifyAddschemabutton(AddClaimBtn);
		clickonAddSchemabutton(AddClaimBtn);
		addSchema(ClaimSchemaName,ClassOfBusinessDDValue,SchemaTypeDDValue,CBddValue,STddValue);
		verifySchema(ClaimSchemaName);
	}

	public void editClaimSchema_3179() throws InterruptedException
	{
		String ExpectedClassofBusiness="Professional Indemnity (US)";
		String ExpectedPublishedDiscription= "Automation Test";
		if(isVisible(AddSchemaPageErrorMsg)==true)
		{
			Report.LogInfo("verifyerrorMessage", "Error message displayed,Claim Schema not added successfully", "Fail");
		}else
		{
			if(webDriver.findElement(By.xpath("//ui-view[@id='content']//h3[contains(text(),'"+ClaimSchemaName+"')]")).isDisplayed()== true)
			{
				Report.LogInfo("verifyAddedSchema", "verify added schema successfully", "PASS");
				openInEditMode();
				if(isVisible(EditPageErrorMsg)==true)
				{
					Report.LogInfo("verifyerrorMessage", "Error message displayed on edit Schema page", "FAIL");	
				}else{
					editSchemaDetails();
					SaveAndPublish();
					verifyeditedSchema(ClaimSchemaName,ExpectedClassofBusiness,ExpectedPublishedDiscription);
				}
			}else{
				Report.LogInfo("verifyAddedSchema", "Schema not added successfully", "FAIL");
			}

		}
	}
	
	public void AddSchema_Risk(String RiskSchemaName) throws Exception{
		
		
	    String TotalInsurableChk = "@xpath=//label[contains(.,'Total Insurable Value')]";
		BordereauQuePage QuePage = new BordereauQuePage();
		homePage.adminMenu();
		schemaLink();
		schemapage();
		verifyAddschemabutton(AddRiskBtn);
		clickonAddSchemabutton(AddRiskBtn);
		addSchema1(RiskSchemaName,SchemaTypeDDTechnology,SchemaTypeDDValue);
		sleep(3000);
		scrollUp();
		editSchemaAndPublish("Risk_schema", TotalInsurableChk);
		scrollUp();
	}


	//3937 Multiple Rule Condition - Data is Not valid if the rule conditions are met
	public void multipleRuleConditionDataNotValid() throws Exception
	{
		Rules rule = new Rules();
		PolicyPage policy = new PolicyPage();
		String RiskSchemaName = "Schema Rule 3 Test_"+getCurrentDateTimeMS();
		AddSchema_Risk(RiskSchemaName);
		scrollUp();
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Multiple Condition Rule - Method Or .And (Not valid) Error Identified", "Gross Premium Greter Than Or Equal to 100 And Number of Stories Between 50 to 99 Or Risk Inception Date Note Equal To", RiskSchemaName, "Mandatory", "Data is not valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		grossPremiumRule();
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		SelectDropDownValue1(policy.MethodDD,policy.AndValue);
		numberOfStories();
		click(policy.CheckBtn,"Check button");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		SelectDropDownValue1(policy.MethodDD,OrValue);
		riskInceptionDate();
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		QuePage.sheetProcessingFirstSheet4(RiskSchemaName);

		String UniqueReferenceVal1 = "Automation Policy_12"+getCurrentDateTimeMS1();
		String InceptionDate = "01/01/2017";
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails(UniqueReferenceVal1, InceptionDate, policy.Status1, policy.Broker2, policy.Bline2, policy.Underline2);

		policy.waitForElementToAppear(policy.DraftBtn,5);
		verifyExists(policy.DraftBtn,"Draft Status Button");
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();

		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		String subSheet = "Bordereau Processing (kruthika test schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnBordereauxTab();
		//BordereauProcess.SubmitBordereaux(subSheet);
		//QuePage.BFormatId;
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3937Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_3937.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(allSheetsPath);
		File excelFile = new File(sheet3937Path);
		policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_3937.xlsx\",\"UniqueFileName\":\"S44411120180008.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S44411120180008.xlsx\",\"Filesize\":24706,\"Path\":null,\"size\":24706,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauProcess.refreshUploadedFile();
		String MultipleConditionRule= "@xpath=//h2[contains(.,'Multiple Condition Rule')]";

		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
			if(isVisible(MultipleConditionRule)== true){
				verifyMustExists(Data0,"L4");
				sendKeys(Data0,"50.00","L4");
				verifyMustExists(Data1,"W4");
				sendKeys(Data1,"49","W4");
				verifyMustExists(Data2,"D4");
				sendKeys(Data2,"01/02/2017","D4");
				verifyMustExists(ContinueBtn,"Continue button");
				click(ContinueBtn,"Continue button");

				sleep(2000);
				verifyMustExists(CancelBtn,"Cancel button");
				click(CancelBtn,"Cancel button");
				sleep(2000);

				if(isVisible(BordereauProcess.ReviewBtn)==true)
				{
					verifyExists(BordereauProcess.ReviewBtn,"Review button");
					BordereauProcess.deleteBorderEAUX();
				}
				else
				{
					BordereauProcess.refreshUploadedFile();
					verifyExists(BordereauProcess.ReviewBtn,"Review button");
					BordereauProcess.deleteBorderEAUX();
				}				
			}	else
			{
				Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
				goBack();
				BordereauProcess.deleteBorderEAUX();				
			}
		}
		else
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status not changed to Review Error", "FAIL");
			BordereauProcess.deleteBorderEAUX();				
		}
	}

	//3938 Multiple Rule Condition - Data is valid if the rule conditions are met
	public void multipleRuleConditionDataIsValid() throws Exception
	{
		Rules rule = new Rules();
		PolicyPage policy = new PolicyPage();
		String RiskSchemaName = "Schema Rule 4 Test_"+getCurrentDateTimeMS1();
		String TotalInsurableChk = "@xpath=//label[contains(.,'Total Insurable Value')]";
		String SchemaTypeDDTermLife = "@xpath=//li[contains(.,'Term Life')]";
		BordereauQuePage QuePage = new BordereauQuePage();
		homePage.adminMenu();
		schemaLink();
		schemapage();
		verifyAddschemabutton(AddRiskBtn);
		clickonAddSchemabutton(AddRiskBtn);
		addSchema1(RiskSchemaName,SchemaTypeDDTermLife,SchemaTypeDDValue);
		sleep(3000);
		editSchemaAndPublish("Schema Rule 4 Test", TotalInsurableChk);
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");		
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Multiple Condition Rule - Method And, Or(Valid) Error Identified", "Total Insurable Value Greater Than 8000000 And Contents Value Less Than 1000 Or Building Year Built Not Equal To 1960", RiskSchemaName, "Warning", "Data is valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		totalInsuranceValue("8000000");
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");	
		SelectDropDownValue1(policy.MethodDD,policy.AndValue);
		contentsValue();
		click(policy.CheckBtn,"Check button");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		SelectDropDownValue1(policy.MethodDD,OrValue);
		buildingYearBuiltValue();
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");
		QuePage.sheetProcessingFirstSheet4(RiskSchemaName);

		String UniqueReferenceVal1 = "Automation Policy_18"+getCurrentDateTimeMS1();
		String InceptionDate = "01/01/2017";
		//String InceptionDateExp = "01/01/2018";
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails(UniqueReferenceVal1, InceptionDate, policy.Status1, policy.Broker2, policy.Bline2, policy.Underline2);

		policy.waitForElementToAppear(policy.DraftBtn,5);
		verifyExists(policy.DraftBtn,"Draft Status Button");
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		/*BordereauProcess.applyFilterPolicy("154718PA");
				policy.openSelectedPolicy();*/
		//policy.navigationOnBordereauxTab();
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();

		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		String subSheet = "Bordereau Processing (kruthika test schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnBordereauxTab();
		//			BordereauProcess.SubmitBordereaux(subSheet);
		//QuePage.BFormatId;
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3938Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_3938.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(allSheetsPath);
		File excelFile = new File(sheet3938Path);
		policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_3938.xlsx\",\"UniqueFileName\":\"S10389320180008.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S10389320180008.xlsx\",\"Filesize\":24706,\"Path\":null,\"size\":24706,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauProcess.refreshUploadedFile();
		String MultipleConditionRule= "@xpath=//h2[contains(.,'Multiple Condition Rule')]";

		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
			if(isVisible(MultipleConditionRule)== true){
				verifyMustExists(Data0,"S5");
				sendKeys(Data0,"880,000,0","S5");
				verifyMustExists(Data1,"R5");
				sendKeys(Data1,"999","R5");
				SelectDropDownValue1(Data2DD,YearValue1957);
				verifyMustExists(ContinueBtn,"Continue button");
				click(ContinueBtn,"Continue button");
				sleep(2000);
				verifyMustExists(CancelBtn,"Cancel button");
				click(CancelBtn,"Cancel button");
				sleep(2000);

				if(isVisible(BordereauProcess.ReviewBtn)==true)
				{
					verifyExists(BordereauProcess.ReviewBtn,"Review button");
					BordereauProcess.deleteBorderEAUX();
				}
				else
				{
					BordereauProcess.refreshUploadedFile();
					verifyExists(BordereauProcess.ReviewBtn,"Review button");
					BordereauProcess.deleteBorderEAUX();
				}				
			}
			else
			{
				Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
				goBack();
				BordereauProcess.deleteBorderEAUX();				
			}
		}
		else
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status not changed to Review Error", "FAIL");
			BordereauProcess.deleteBorderEAUX();				
		}

	}


	//3849 Multiple Rule Condition - Data is valid if the rule conditions are met
	public void singleRuleConditionDataNotValid() throws Exception
	{
		Rules rule = new Rules();
		PolicyPage policy = new PolicyPage();
		String RiskSchemaName = "Schema Rule Test_"+getCurrentDateTimeMS1();
		System.out.println(RiskSchemaName);
		String TotalInsurableChk = "@xpath=//label[contains(.,'Total Insurable Value')]";
		String SchemaTypeDDProperty = "@xpath=//li[contains(.,'Property D&F (US binder)')]";
		BordereauQuePage QuePage = new BordereauQuePage();
		homePage.adminMenu();
		schemaLink();
		schemapage();
		verifyAddschemabutton(AddRiskBtn);
		clickonAddSchemabutton(AddRiskBtn);
		addSchema1(RiskSchemaName,SchemaTypeDDProperty,SchemaTypeDDValue);
		sleep(3000);
		editSchemaAndPublish("Compilance Schema", TotalInsurableChk);
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");	

		//Rule 1
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Single Rule Condition Not Equal to Operator (Not Valid) Error Identified", "Risk Currency Not Equal To USD", RiskSchemaName, "Warning", "Data is not valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		scrollDown();
		riskCurrency();
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		//Rule 2
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");	
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Single Rule Condition - Less than or equal to Operator (Not Valid)Error identified", "Net Premium Less than or Equal to 100", RiskSchemaName, "Warning", "Data is not valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		netPremiumLessThanOrEqual("100");
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		//Rule 3
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");	
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Single Rule Condition - Contains operator(Not valid) Identified error", "Risk Postal Code Contains 879", RiskSchemaName, "Warning", "Data is not valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		riskPostalCode("879");
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		//Rule 4
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");	
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Single Rule Condition - Between operator(Not valid) Identified error", "Risk Inception Date Between 01/02/2017 to 10/12/2017", RiskSchemaName, "Warning", "Data is not valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		riskInceptionDateNotBetween2("01/02/2017","10/12/2017");
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		//Rule 5
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");	
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Single Rule Condition - Is Blank  operator(Not valid) Identified error", "Number of stories Is Blank", RiskSchemaName, "Warning", "Data is not valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		numberOfStoriesIsBlank();
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		//Rule 6
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Single Rule Condition - Equal to operator(Not valid) Identified error", "Sprinklers (Y/N) Equal to Yes", RiskSchemaName, "Mandatory", "Data is not valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		sprinklers1();
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		//Rule 7
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");	
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Single Rule Condition - Not Between operator(Not valid) Identified error", "Building Value Not Between 300 to 500", RiskSchemaName, "Mandatory", "Data is not valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		buildingsValue("300.00","500.00");
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		//Rule 8
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Single Rule Condition - Less than operator(Not valid) Identified error", "Total Insurable Value Greater Than 8000000", RiskSchemaName, "Mandatory", "Data is not valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		totalInsuranceValue("8000000");
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		//Rule 9
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");	
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Single Rule Condition - Less than Operator(Not valid) Identified error", "Contents Value Less than 1000", RiskSchemaName, "Mandatory", "Data is not valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		contentsValue();
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		//Rule 10
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");	
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Single Rule Condition - Greater Than or Equal to operator(Not valid) Identified error", "Gross Premium - Greater than or equal to 100", RiskSchemaName, "Mandatory", "Data is not valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		grossPremium();
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		QuePage.sheetProcessingFirstSheet1(RiskSchemaName);

		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		String InceptionDate = "01/01/2017";
		//String InceptionDateExp = "01/01/2018";
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails(UniqueReferenceVal1, InceptionDate, policy.Status1, policy.Broker2, policy.Bline2, policy.Underline2);

		policy.waitForElementToAppear(policy.DraftBtn,5);
		verifyExists(policy.DraftBtn,"Draft Status Button");
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();

		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		String subSheet = "Bordereau Processing (kruthika test schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnBordereauxTab();
		//BordereauProcess.SubmitBordereaux(subSheet);
		//QuePage.BFormatId;
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3849Path = fpath+"\\src\\test\\resources\\testdata\\Schema rule_3849.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(allSheetsPath);
		File excelFile = new File(sheet3849Path);
		policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Schema rule_3849.xlsx\",\"UniqueFileName\":\"S36452620180005.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S36452620180005.xlsx\",\"Filesize\":24821,\"Path\":null,\"size\":24821,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauProcess.refreshUploadedFile();
		String SingleRuleConditionNotEqualToOperator ="@xpath=//*[@id='dataType_Id']//h2[contains(.,'Single Rule Condition Not Equal to Operator')]";

		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
			if(isVisible(SingleRuleConditionNotEqualToOperator)== true){
				SelectDropDownValue1(Data0DD,USDValue);
				SelectDropDownValue1(Data1DD,USDValue);
				click(ContinueBtn,"Continue button");
				sleep(2000);

				verifyMustExists(Data0,"O2");
				sendKeys(Data0,"1000.00","O2");
				verifyMustExists(Data1,"O3");
				sendKeys(Data1,"190.00","O3");
				verifyMustExists(Data2,"O4");
				sendKeys(Data2,"1100.00","O4");
				click(ContinueBtn,"Continue button");
				sleep(2000);

				verifyMustExists(Data0,"G5");
				sendKeys(Data0,"SW12 87","G5");
				verifyMustExists(Data1,"G6");
				sendKeys(Data1,"SW12 87","G6");
				click(ContinueBtn,"Continue button");
				sleep(2000);

				verifyMustExists(Data0,"D2");
				sendKeys(Data0,"12/02/2017","D2");
				verifyMustExists(Data1,"D3");
				sendKeys(Data1,"11/02/2017","D3");
				verifyMustExists(Data2,"D4");
				sendKeys(Data2,"01/02/2017","D4");
				verifyMustExists(Data3,"D5");
				sendKeys(Data3,"02/02/2017","D5");
				click(ContinueBtn,"Continue button");
				sleep(2000);

				verifyMustExists(Data0,"W4");
				sendKeys(Data0,"50","W4");
				click(ContinueBtn,"Continue button");
				sleep(2000);

				SelectDropDownValue1(Data0DD,NoValue);
				click(ContinueBtn,"Continue button");
				sleep(2000);

				verifyMustExists(Data0,"Q2");
				sendKeys(Data0,"300","Q2");
				verifyMustExists(Data1,"Q3");
				sendKeys(Data1,"333","Q3");
				verifyMustExists(Data2,"Q4");
				sendKeys(Data2,"500","Q4");
				click(ContinueBtn,"Continue button");
				sleep(2000);

				verifyMustExists(Data0,"S5");
				sendKeys(Data0,"80,000.00","S5");
				click(ContinueBtn,"Continue button");
				sleep(2000);

				verifyMustExists(Data0,"2");
				sendKeys(Data0,"5055","2");
				verifyMustExists(Data1,"3");
				sendKeys(Data1,"1001","3");
				verifyMustExists(Data2,"4");
				sendKeys(Data2,"1001","4");
				verifyMustExists(Data3,"5");
				sendKeys(Data3,"2223","5");
				verifyMustExists(Data4,"6");
				sendKeys(Data4,"44556","6");
				click(ContinueBtn,"Continue button");
				sleep(2000);

				verifyMustExists(Data0,"L3");
				sendKeys(Data0,"10","L3");
				verifyMustExists(Data1,"L4");
				sendKeys(Data1,"15","L4");
				verifyMustExists(Data2,"L5");
				sendKeys(Data2,"15","L5");
				verifyMustExists(Data3,"L6");
				sendKeys(Data3,"15","L6");
				click(ContinueBtn,"Continue button");
				sleep(2000);			

				sleep(2000);
				verifyMustExists(CancelBtn,"Cancel button");
				click(CancelBtn,"Cancel button");
				sleep(2000);

				if(isVisible(BordereauProcess.ReviewBtn)==true)
				{
					verifyExists(BordereauProcess.ReviewBtn,"Review button");
					BordereauProcess.deleteBorderEAUX();
				}
				else
				{
					BordereauProcess.refreshUploadedFile();
					verifyExists(BordereauProcess.ReviewBtn,"Review button");
					BordereauProcess.deleteBorderEAUX();
				}				
			}
			else
			{
				Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
				goBack();
				BordereauProcess.deleteBorderEAUX();				
			}
		}
		else
		{
			Report.LogInfo("ReviewErrorStatusVal", "Status not changed to Review Error.", "FAIL");
			BordereauProcess.deleteBorderEAUX();				
		}
	}

	//3850 Schema Rules - single rule condition - data is valid if the rule conditions are met
	public void singleRuleConditionDataIsValid() throws Exception
	{
		Rules rule = new Rules();
		PolicyPage policy = new PolicyPage();
		String RiskSchemaName = "Schema Rule 2 Test_"+getCurrentDateTimeMS1();
		//String RiskSchemaName = "Schema Rule 2 Test_171228281535";

		String TotalInsurableChk = "@xpath=//label[contains(.,'Total Insurable Value')]";
		String SchemaTypeDDProperty = "@xpath=//li[contains(.,'Property D&F (US binder)')]";
		BordereauQuePage QuePage = new BordereauQuePage();
		homePage.adminMenu();
		schemaLink();
		schemapage();
		verifyAddschemabutton(AddRiskBtn);
		clickonAddSchemabutton(AddRiskBtn);
		addSchema1(RiskSchemaName,SchemaTypeDDProperty,SchemaTypeDDValue);
		sleep(3000);
		editSchemaAndPublish("Schema Rule 2 Test", TotalInsurableChk);

		//Rule 1
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Single Rule Condition Equal to Operator (Valid) Error Identified", "Number Of Stories Between 50 to 99", RiskSchemaName, "Mandatory", "Data is valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		numberOfStories();
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		//Rule 2
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");	
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);	
		rule.AddSchemaRule1("Single Rule Condition - Contains Operator or (Valid)Error identified", "Risk Postal Code contains 9", RiskSchemaName, "Mandatory", "Data is valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		riskPostalCode("9");
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		//Rule 3
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");	
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Single Rule Condition - Equal to operator(Valid) Identified error", "Sprinklers (Y/N) Equal to Yes", RiskSchemaName, "Warning", "Data is valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		sprinklersYes();
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		//Rule 4
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Single Rule Condition - Contains Less Than Equal to operator(Valid) Identified error", "Risk currency not Equal to USD", RiskSchemaName, "Warning", "Data is valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		riskCurrency();
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		//Rule 5
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");	
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Single Rule Condition - Is Blank Operator (Valid) Identified error", "Insured Address Is Blank", RiskSchemaName, "Warning", "Data is valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		insuredAddress();
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		//Rule 6
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Single Rule Condition - Equal  to operator(Valid) Identified error", "Gross Premium Greater Than Or Equal To 100", RiskSchemaName, "Mandatory", "Data is valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		grossPremium();
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		//Rule 7
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");	
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Single Rule Condition - Less than operator(Valid) Identified error", "Net Premium Less Than 100", RiskSchemaName, "Warning", "Data is valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		netPremium();
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		//Rule 8
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");	
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Single Rule Condition - Not Between operator (Valid) Identified error", "Risk Inception Not Between 01/02/2017 to 10/10/2017", RiskSchemaName, "Mandatory", "Data is valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		riskInceptionDateNotBetween();
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		//Rule 9
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");	
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Single Rule Condition - Greater than Operator(Valid) Identified error", "Total Insurable Value Greater Than 1000000", RiskSchemaName, "Warning", "Data is valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		totalInsuranceValue("1000000");
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		//Rule 10
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
		rule.AddSchemaRule1("Single Rule Condition - Less Than Equal to operator(Valid) Identified error", "Content value Less Than Or Equal to 10", RiskSchemaName, "Mandatory", "Data is valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		contentsValue("1000");
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");

		QuePage.sheetProcessingFirstSheet2(RiskSchemaName);

		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		String InceptionDate = "01/01/2017";
		//String InceptionDateExp = "01/01/2018";
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails(UniqueReferenceVal1, InceptionDate, policy.Status1, policy.Broker2, policy.Bline2, policy.Underline2);

		policy.waitForElementToAppear(policy.DraftBtn,5);
		verifyExists(policy.DraftBtn,"Draft Status Button");
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		/*BordereauProcess.applyFilterPolicy("660852HN");
			policy.openSelectedPolicy();*/
		policy.navigationOnBordereauxTab();
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();

		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		String subSheet = "Bordereau Processing (kruthika test schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnBordereauxTab();
		BordereauProcess.SubmitBordereaux(subSheet);
		//QuePage.BFormatId;
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3850Path = fpath+"\\src\\test\\resources\\testdata\\Schemarule2_3850.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(allSheetsPath);
		File excelFile = new File(sheet3850Path);
		policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Schemarule2_3850.xlsx\",\"UniqueFileName\":\"S88247820180030.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S88247820180030.xlsx\",\"Filesize\":24635,\"Path\":null,\"size\":24635,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauProcess.refreshUploadedFile();
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
			String SingleRuleConditionBetweenOperator ="@xpath=//h2[contains(.,'Single Rule Condition Equal to Operator')]";
			if(isVisible(SingleRuleConditionBetweenOperator)== true){
				verifyMustExists(Data0,"W2");
				sendKeys(Data0,"66","W2");
				verifyMustExists(Data1,"W6");
				sendKeys(Data1,"77","W6");	
				click(ContinueBtn,"Continue button");
				sleep(2000);

				verifyMustExists(Data0,"G2");
				sendKeys(Data0,"SW12 9","G2");
				verifyMustExists(Data1,"G3");
				sendKeys(Data1,"SW12 9","G3");	
				verifyMustExists(Data2,"G4");
				sendKeys(Data2,"SW12 9","G4");
				click(ContinueBtn,"Continue button");
				sleep(2000);

				SelectDropDownValue1(Data0DD,YesValue);
				SelectDropDownValue1(Data1DD,YesValue);
				SelectDropDownValue1(Data2DD,YesValue);
				SelectDropDownValue1(Data3DD,YesValue);
				click(ContinueBtn,"Continue button");
				sleep(2000);

				SelectDropDownValue1(Data0DD,AFNValue);
				SelectDropDownValue1(Data1DD,EURValue);
				SelectDropDownValue1(Data2DD,GBPValue);
				click(ContinueBtn,"Continue button");
				sleep(2000);

				verifyMustExists(Data0,"F3");
				clearTextBox(Data0);
				verifyMustExists(Data1,"F4");
				clearTextBox(Data1);	
				verifyMustExists(Data2,"F5");
				clearTextBox(Data2);
				verifyMustExists(Data3,"F6");
				clearTextBox(Data3);
				click(ContinueBtn,"Continue button");
				sleep(2000);

				verifyMustExists(Data0,"L6");
				sendKeys(Data0,"100","L6");
				click(ContinueBtn,"Continue button");
				sleep(2000);

				verifyMustExists(Data0,"O4");
				sendKeys(Data0,"5","O4");
				verifyMustExists(Data1,"O5");
				sendKeys(Data1,"5","O5");	
				verifyMustExists(Data2,"O6");
				sendKeys(Data2,"5","O6");
				click(ContinueBtn,"Continue button");
				sleep(2000);

				verifyMustExists(Data0,"D6");
				sendKeys(Data0,"01/01/2017","D6");
				click(ContinueBtn,"Continue button");
				sleep(2000);

				verifyMustExists(Data0,"S2");
				sendKeys(Data0,"8800,000.00","S2");
				verifyMustExists(Data1,"S3");
				sendKeys(Data1,"8800,000.00","S3");	
				verifyMustExists(Data2,"S4");
				sendKeys(Data2,"8883,000.00","S4");
				verifyMustExists(Data3,"S6");
				sendKeys(Data3,"8960,000.00","S6");
				click(ContinueBtn,"Continue button");
				sleep(2000);

				verifyMustExists(Data0,"R4");
				sendKeys(Data0,"1,50","R4");
				verifyMustExists(Data1,"R5");
				sendKeys(Data1,"1,50","R5");
				click(ContinueBtn,"Continue button");
				sleep(2000);
				verifyMustExists(CancelBtn,"Cancel button");
				click(CancelBtn,"Cancel button");
				sleep(2000);

				if(isVisible(BordereauProcess.ReviewBtn)==true)
				{
					verifyExists(BordereauProcess.ReviewBtn,"Review button");
					BordereauProcess.deleteBorderEAUX();
				}
				else
				{
					BordereauProcess.refreshUploadedFile();
					verifyExists(BordereauProcess.ReviewBtn,"Review button");
					BordereauProcess.deleteBorderEAUX();
				}				
			}
			else
			{
				Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
				goBack();
				BordereauProcess.deleteBorderEAUX();				
			}
		}
		else
		{
			Report.LogInfo("ReviewErrorStatusVal", "Status not changed to Review Error.", "FAIL");
			BordereauProcess.deleteBorderEAUX();				
		}
	}
	//3789 Compliance Data Rules - single rule condition - warning and mandatory
	public void complianceDataRulesSingleRuleCondition() throws Exception
	{
		Rules rule = new Rules();
		DatasetReferenceDataPage refData = new DatasetReferenceDataPage();
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		COBName = "Automation class of business_"+getCurrentDateTimeMS1();
		homePage.adminMenu();
		refData.DatasetReferenceDataLink();
		refData.DatasetReferenceDatapage();
		
		//Filter
		applyDataSetFilter("Class of Business");
		verifyMustExists(ClassOfBusinesslabel,"Class Of Business");
		click(ClassOfBusinesslabel,"Class Of Business");
		createClassOfBusiness1(COBName);
		
		homePage.adminMenu();
		schemaLink();
		schemapage();
		String SchemaName = "Schema for Compliance Data_"+getCurrentDateTimeMS();
		String TotalInsurableChk = "@xpath=//label[contains(.,'Total Insurable Value')]";
		verifyAddschemabutton(AddRiskBtn);
		clickonAddSchemabutton(AddRiskBtn);
		addSchema1(SchemaName,COBName,SchemaTypeDDValue);
		sleep(3000);
		editSchemaAndPublish("Schema for Compliance Rule", TotalInsurableChk);	
		
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleComplianceData);
		rule.AddComplianceDataRule("Risk inception date should be equal to 01/01/2017","Mandatory field blank", "Risk", "Mandatory", COBName);
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		riskInceptionDateNotEqual("01/01/2017");
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		DatasetSelection2();
	
		QuePage.sheetProcessingFirstSheet4(SchemaName);
		
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		String InceptionDate = "01/01/2017";
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails(UniqueReferenceVal1, InceptionDate, policy.Status1, policy.Broker2, policy.Bline2, policy.Underline2);
		policy.waitForElementToAppear(policy.DraftBtn,5);
		verifyExists(policy.DraftBtn,"Draft Status Button");

		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();

		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnBordereauxTab();

		//QuePage.BFormatId;
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3789Path = fpath+"\\src\\test\\resources\\testdata\\velidate_date_ref_precentage_integer_3789.xlsx";
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		File excelFile = new File(sheet3789Path);
		policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"velidate_date_ref_precentage_integer_3789.xlsx\",\"UniqueFileName\":\"S84530820180101.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S84530820180101.xlsx\",\"Filesize\":20548,\"Path\":null,\"size\":20548,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauProcess.refreshUploadedFile();
		String RiskInceptionDate ="@xpath=//*[@id='dataType_Id']//h2[contains(.,'Risk inception date')]";
		String X9 ="@xpath=//td[contains(.,'X9')]";
		String F3 ="@xpath=//td[contains(.,'F3')]";
		String ContinueProcessing ="@xpath=//button[contains(.,'Continue Processing ')]";
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
			if(isVisible(ContinueProcessing)== true)
			{
				verifyMustExists(ContinueProcessing,"Continue Processing");
				click(ContinueProcessing,"Continue Processing");
				BordereauProcess.refreshUploadedFile();
				BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError);
			}
			
			if(isVisible(RiskInceptionDate)== true)
			{
				if(isVisible(F3)== true)
				{
					verifyMustExists(Data0,"F3");
					sendKeys(Data0,"31/01/2107","F3");
					click(ContinueBtn,"Continue button");
					sleep(2000);
				}
				else
				{
					verifyMustExists(Data0,"X9");
					sendKeys(Data0,"10","X9");
					click(ContinueBtn,"Continue button");
					sleep(2000);
				}
				
				if(isVisible(X9)== true)
				{
					verifyMustExists(Data0,"X9");
					sendKeys(Data0,"10","X9");
					click(ContinueBtn,"Continue button");
					sleep(2000);
				}
				else
				{
					verifyMustExists(Data0,"F3");
					sendKeys(Data0,"31/01/2107","F3");
					click(ContinueBtn,"Continue button");
					sleep(2000);
				}
				if(isVisible(BordereauProcess.Cancelbtn1)==true)
				{
					verifyExists(BordereauProcess.Cancelbtn1,"Cancel button");
					click(BordereauProcess.Cancelbtn1,"Cancel button");
				}
				if(isVisible(BordereauProcess.ReviewBtn)==true)
				{
					verifyExists(BordereauProcess.ReviewBtn,"Review button");
					click(BordereauProcess.ReviewBtn,"Review button");
					sleep(2000);
					verifyMustExists(SubmitPassedWarningRecordsForAssignmentBtn,"Submit Passed Warning Records For Assignment button");
					click(SubmitPassedWarningRecordsForAssignmentBtn,"Submit Passed Warning Records For Assignment button");
					sleep(2000);
				}
				if(isVisible(BordereauProcess.ForApprovalBtn)==true)
				{
					click(BordereauProcess.ForApprovalBtn,"Approval button");
					sleep(2000);
					verifyMustExists(BordereauProcess.ApproveBordBtn,"Approve Bordereau button");
					click(BordereauProcess.ApproveBordBtn,"Approve Bordereau button");
					BordereauProcess.refreshUploadedFileApprovedStatus();
					verifyExists(BordereauProcess.ApprvedBtn,"Apprved button");
					sleep(2000);
				}
			}
			}
		    else
		    {
		     Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
		     goBack();
		     BordereauProcess.deleteBorderEAUX();    
		    }
			
			policy.navigationOnBordereauxTab();
			//BordereauProcess.SubmitBordereaux(subSheet);
			//QuePage.BFormatId;
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3789Path1 = fpath+"\\src\\test\\resources\\testdata\\velidate_date_ref_precentage_integer1_3789.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile1 = new File(sheet3789Path1);
			String payload1 = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"velidate_date_ref_precentage_integer1_3789.xlsx\",\"UniqueFileName\":\"S68200420180101.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S68200420180101.xlsx\",\"Filesize\":19766,\"Path\":null,\"size\":19766,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			
			uploadFile(ReqUrl, excelFile1, payload1, DraftUrl);
			BordereauProcess.refreshUploadedFile();
	}

	public void MultipleRuleConditionMandatory_4080() throws Exception
	{
		String SchemaName1 = "Compliance Rule"+getCurrentDateTimeMS();
		String SchemaTypeDDTechnology = "@xpath=//li[contains(.,'Casualty Treaty (Non-US)')]";
		RuleName= "Risk inception date equal to 04/01/2017 and country equal to India"+getCurrentDateTimeMS();
		FilteredRuleNameVerification1= "@xpath=//tr[1]//td[contains(text(),'"+RuleName+"')]";
		String ErrorMessage = "Mandatory fields are blank";
		String Dataset = "Risk";
		String ProcessingAction = "Mandatory";
		String CLassBusiness = "TestComplianceData";
		String FieldName= "Risk Inception Date";
		String OPERATOR = "Equal To";
		String APPLIEDTO = "Value";
		String Date = "04/01/2017";
		String FieldName2= "Risk Country";
		String EntrySelection2 = "India";
	
		
		//SelectComplianceData();
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleComplianceData);
		AddComplianceDataRule(RuleName,ErrorMessage,Dataset,ProcessingAction,"All Classes of Business");
		AddRuleConditionForComplianceRule(FieldName,OPERATOR,APPLIEDTO,Date);
		AddRuleConditionForComplianceRule2(FieldName2,OPERATOR,EntrySelection2);
		DatasetSelection1(); 
						
		String UniqueReferenceVal1 = "Automation Policy_19"+getCurrentDateTimeMS();
		String Status1 = "Draft";
		String InceptionDate1 = "01/01/2017";
		String subSheet = "Risk Reference Format";
		//String InceptionDateExp = "01/01/2018";
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails(UniqueReferenceVal1, InceptionDate1, Status1, policy.Broker1, policy.Bline1, policy.Underline1);
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		
		sleep(2000);
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnBordereauxTab();
		//QuePage.BFormatId;
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4080Path = fpath+"\\src\\test\\resources\\testdata\\velidate_date_ref_precentage_integer_4080.xlsx";
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		policy.contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"velidate_date_ref_precentage_integer_4080.xlsx\",\"UniqueFileName\":\"S72145720180102.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S72145720180102.xlsx\",\"Filesize\":19951,\"Path\":null,\"size\":19951,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"velidate_date_ref_precentage_integer_4080.xlsx\",\"UniqueFileName\":\"S60627920180403.xlsx\",\"BordereauFormatId\":\"cfa01995-b545-4567-a8d9-c15df85345fd\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S60627920180403.xlsx\",\"Filesize\":19612,\"Path\":null,\"size\":19612,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		File excelFile = new File(sheet4080Path);
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		Br.refreshUploadedFile();
		String C6 ="@xpath=//td[contains(.,'C6')]";
		String F3 ="@xpath=//td[contains(.,'F3')]";
		String ContinueProcessing ="@xpath=//button[contains(.,'Continue Processing ')]";
		String RiskInceptionDate ="@xpath=//*[@id='dataType_Id']//h2[contains(.,'Risk inception date')]";
		 
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
			
			if(isVisible(RiskInceptionDate)== true)
			{
				if(isVisible(F3)== true)
				{
					verifyMustExists(Data0,"F3");
					sendKeys(Data0,"31/01/2107","F3");
					click(ContinueBtn,"Continue button");
					sleep(2000);
				}
				else
				{
					verifyMustExists(Data0,"C6");
					sendKeys(Data0,"Insured name 2","C6");
					click(ContinueBtn,"Continue button");
					sleep(2000);
				}
				
				if(isVisible(C6)== true)
				{
					verifyMustExists(Data0,"C6");
					sendKeys(Data0,"Insured name 2","C6");
					click(ContinueBtn,"Continue button");
					sleep(2000);
				}
				else
				{
					verifyMustExists(Data0,"F3");
					sendKeys(Data0,"31/01/2107","F3");
					click(ContinueBtn,"Continue button");
					sleep(2000);
				}
				if(isVisible(BordereauProcess.Cancelbtn1)==true)
				{
					verifyExists(BordereauProcess.Cancelbtn1,"Cancel button");
					click(BordereauProcess.Cancelbtn1,"Cancel button");
				}
				if(isVisible(BordereauProcess.ReviewBtn)==true)
				{
					verifyExists(BordereauProcess.ReviewBtn,"Review button");
					click(BordereauProcess.ReviewBtn,"Review button");
					sleep(2000);
					verifyMustExists(SubmitPassedWarningRecordsForAssignmentBtn,"Submit Passed Warning Records For Assignment button");
					click(SubmitPassedWarningRecordsForAssignmentBtn,"Submit Passed Warning Records For Assignment button");
					sleep(2000);
				}
				if(isVisible(BordereauProcess.ForApprovalBtn)==true)
				{
					click(BordereauProcess.ForApprovalBtn,"Approval button");
					sleep(2000);
					verifyMustExists(BordereauProcess.ApproveBordBtn,"Approve Bordereau button");
					click(BordereauProcess.ApproveBordBtn,"Approve Bordereau button");
					BordereauProcess.refreshUploadedFileApprovedStatus();
					verifyExists(BordereauProcess.ApprvedBtn,"Apprved button");
					sleep(2000);
				}
			}
			}
		    else
		    {
		     Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
		     goBack();
		     BordereauProcess.deleteBorderEAUX();    
		    }
				
			policy.navigationOnBordereauxTab();
			//BordereauProcess.SubmitBordereaux(subSheet);
			//QuePage.BFormatId;
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4080Path1 = fpath+"\\src\\test\\resources\\testdata\\compliance_feb_4080.xlsx";
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			File excelFile1 = new File(sheet4080Path1);
			//String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"compliance_feb_4080.xlsx\",\"UniqueFileName\":\"S64343820180102.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S64343820180102.xlsx\",\"Filesize\":19941,\"Path\":null,\"size\":19941,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"compliance_feb_4080.xlsx\",\"UniqueFileName\":\"S70348420180403.xlsx\",\"BordereauFormatId\":\"cfa01995-b545-4567-a8d9-c15df85345fd\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S70348420180403.xlsx\",\"Filesize\":19601,\"Path\":null,\"size\":19601,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
			BordereauProcess.refreshUploadedFile();
		    filterRulename(RuleName);
	}
	public void filterRulename(String RuleName)
	{
		String SearchTextFieldRule1 ="@xpath=//ul//li[contains(.,'"+RuleName+"')][1]";
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");
		
		waitForElementToAppear(rule.RuleNameFilterIcon,5);
		verifyMustExists(rule.RuleNameFilterIcon ,"Rule Name Filter");
		click(rule.RuleNameFilterIcon,"Rule Name Filter");
		waitForElementToAppear(rule.SearchTextFieldRule,5);
		verifyMustExists(rule.SearchTextFieldRule,"Search textbox");
		sendKeys(rule.SearchTextFieldRule,RuleName,"Search textbox");
		waitForElementToAppear(SearchTextFieldRule1,5);
		verifyMustExists(SearchTextFieldRule1,"RuleName");
		click(SearchTextFieldRule1,"RuleName");
		verifyMustExists(rule.SearchedRuleFilterButton,"Filter button");
		click(rule.SearchedRuleFilterButton,"Filter button");
		// Edit Rule
		waitForElementToAppear(rule.Edit,5);
		verifyMustExists(rule.Edit ,"Edit rule");
		click(rule.Edit,"Edit Rule");
		//InActive Rule
		waitForElementToAppear(rule.InActive,5);
		verifyMustExists(rule.InActive ,"InActive rule");
		click(rule.InActive,"InActive rule");
		waitForElementToAppear(SaveButtonComplianceRule,5);
		verifyMustExists(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		click(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		sleep(4000);
	}

	public void SingleRuleConditionValidContractTab_4044() throws Exception{

		String Status1 = "Draft";
		String subSheet = "Risk Reference Format";
		String InceptionDate1 = "01/01/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS();
		RuleNameInformation = "Single Information Rule"+getCurrentDateTimeMS();
		//System.out.println("Information Rule "+RuleNameInformation);
		FilteredRuleNameVerification= "@xpath=//tr[1]//td[contains(text(),'"+RuleNameInformation+"')]";

		System.out.println("RuleName"+FilteredRuleNameVerification);
		String ErrorMessgae = "Number of Stories 50 to 99";
		String Dataset = "Risk";
		String Schema = "Automation Schema";
		//String MandatoryWarning = "Warning";
		String ApplicationCondition = "Data is valid if the rule conditions are met";
		String FieldName = "Number of Stories";
		String OPERATOR = "Between";
		String APPLIEDTO = "Value";
		String ENTRY_SELECTIONFirst = "50";
		String ENTRY_SELECTIONSecond = "99";

		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails(UniqueReferenceVal1, InceptionDate1, Status1, policy.Broker1, policy.Bline1, policy.Underline1);
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		sleep(2000);
		waitForElementToAppear(RulesMenuTab,5);
		verifyMustExists(RulesMenuTab,"RulesMenuTab");
		click(RulesMenuTab,"RulesMenuTab");
		//selectInformationRule();
		AddInformationRule(RuleNameInformation,ErrorMessgae,Dataset,ApplicationCondition,Schema);
		AddRuleConditionForInformationRule(FieldName,OPERATOR,APPLIEDTO,ENTRY_SELECTIONFirst,ENTRY_SELECTIONSecond);
		String ActualAddedRuleNameSchema = getTextFrom(FilteredRuleNameVerification);
		if(RuleNameInformation.equalsIgnoreCase(ActualAddedRuleNameSchema)){

			Report.LogInfo("ValidateAddedRuleSchema", "Schema Rule added successfully.", "PASS");
		}else{
			Report.LogInfo("ValidateAddedRuleSchema", "Schema Rule not added successfully.", "FAIL");

		}
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		sleep(1000);
		Br.SubmitBordereaux(subSheet);
		fileUpload_4044();
		selectBreaches();
	}

	public void CompleteQuestionnairesAgainstSchema_TC5140() throws Exception
	{
		homePage.adminMenu();
		schemaLink();
		schemapage();
		String SchemaName = "Schema for Compliance Data_"+getCurrentDateTimeMS();
		String TotalInsurableChk = "@xpath=//label[contains(.,'Total Insurable Value')]";
		verifyAddschemabutton(AddRiskBtn);
		clickonAddSchemabutton(AddRiskBtn);
		addSchema3(RiskSchemaName,ClassOfBusinessDDValue2,SchemaTypeDDValue);
		sleep(3000);
		scrollUp();
		openInEditMode();
		
		verifyMustExists(BuildingsValue,"Buiding value");
		click(BuildingsValue,"Building value");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(ContentsValue,"Contents Value");
		click(ContentsValue,"Contents Value");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(Sprinklers,"Sprinklers Y/N");
		click(Sprinklers,"Sprinklers Y/N");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(NumberOfStories,"Number of Stories");
		click(NumberOfStories,"Number of Stories");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(BuildingYearBuilt,"Building Year Built");
		click(BuildingYearBuilt,"Building Year Built");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(OccupancyScheme,"Occupancy Scheme");
		click(OccupancyScheme,"Occupancy Scheme");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(OccupancyCode,"Occupancy Code");
		click(OccupancyCode,"Occupancy Code");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(OccupancyDescription,"Occupancy Description");
		click(OccupancyDescription,"Occupancy Description");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyeditedSchema("Total Insurable Value", TotalInsurableChk);
		verifyMustExists(TotalInsurableValue,"Occupancy Code");
		click(TotalInsurableValue,"Occupancy Code");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");	
		sleep(2000);
		javaScriptclick(CancellationDateChkBox,"Cancellation Date ChkBox");
		sleep(1000);
		javaScriptclick(ContentValueChkBox,"Content Value ChkBox");
		sleep(1000);
		javaScriptclick(SpinklersChkBox,"Spinklers ChkBox");
		sleep(1000);
		javaScriptclick(NumberOFStoriesChkBox,"Number Of Stories ChkBox");
		
		verifyMustExists(SettingsTab,"Settings Tab");
		click(SettingsTab,"Settings Tab");	
		verifyMustExists(TotalValueDD,"Total Value dropdown");
		click(TotalValueDD,"Total Value dropdown");	
		verifyMustExists(TotalValueDDValue,"Total Insurable Value option");
		click(TotalValueDDValue,"Total Insurable Value option");	
		verifyMustExists(SaveAndPublishBtn,"Save and Publish button");
		click(SaveAndPublishBtn,"Save and Publish button");	
		sleep(2000);
		verifyMustExists(PublishDescriptionTxt,"Publish Description textbox");
		sendKeys(PublishDescriptionTxt,"Information 2 Schema","Publish Description textbox");	
		verifyMustExists(PublishBtn,"Publish button");
		click(PublishBtn,"Publish button");
		sleep(2000);
		homePage.adminMenu();
		QuePage.bordereauQueLink();
		QuePage.bordereauQuePage();
		QuePage.firstSheetProcess11(RiskSchemaName);
		
	}
	public void ReProcessFileUsingMandatoryFields_TC5141() throws Exception
	{
		String SprinklersDrag = "@xpath=//button[text()='Sprinklers']";
		String SprinklersDrop = "@xpath=//td[contains(.,'Sprinklers')]//preceding-sibling::td/div/div";
	
		String  subSheet= QuePage.QuestionnaireName_TC5141;
		//String  subSheet= "SP - All Sheet(s)180321184056";
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		String IncDate = "01/01/2017";
		String ExpDate = "31/12/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails1(UniqueReferenceVal1, IncDate,ExpDate,BordereauProcess.Status1, policy.Broker1, policy.Bline1, policy.Underline1);
		waitForElementToAppear(BordereauProcess.DraftBtn,5);
		verifyExists(BordereauProcess.DraftBtn,"Draft Status Button");
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		BordereauProcess.openSelectedPolicy();
		
		BordereauProcess.SubmitBordereaux(subSheet);
	
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet5141Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC5141.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet5141Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//System.out.println(contractId);
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC5141.xlsx\",\"UniqueFileName\":\"S66838020180221.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S66838020180221.xlsx\",\"Filesize\":18394,\"Path\":null,\"size\":18394,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauProcess.refreshUploadedFile();
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
			verifyMustExists(ViewQuestinnarie,"View Questinnarie button");
			click(ViewQuestinnarie,"View Questinnarie button");
			sleep(2000);
	
			verifyMustExists(QuePage.Step11Btn,"Step 11");
			click(QuePage.Step11Btn,"Step 11");
			sleep(2000);
			verifyMustExists(RemoveSprinkler,"Remove Sprinkler");
			click(RemoveSprinkler,"RemoveSprinkler");
			QuePage.step11();
			verifyMustExists(QuePage.VerifyFirstRow,"Verify Sprinkler is displayed in First Row");
			//verifyMustExists(SaveandReprocess,"Verify Save and Reprocess button");
			if(isEnable(SaveandReprocess)==false)
			{
				Report.LogInfo("SaveandReprocessValidation", "Save and Reprocess button is disable", "PASS");
				
			}
			else{
				Report.LogInfo("SaveandReprocessValidation", "Save and Reprocess button is not disable", "FAIL");
			}
			sleep(2000);
			verifyMustExists(QuePage.Step11Btn,"Step 11");
			click(QuePage.Step11Btn,"Step 11");
			sleep(1000);
			dragDropElement(SprinklersDrag,SprinklersDrop);
			QuePage.step11();
			sleep(2000);
			verifyMustExists(SaveandReprocess,"Verify Save and Reprocess button");
			if(isEnable(SaveandReprocess)==true)
			{
				Report.LogInfo("SaveandReprocessValidation", "Save and Reprocess button is Enable", "PASS");
				
			}
			else{
				Report.LogInfo("SaveandReprocessValidation", "Save and Reprocess button is not Enable", "FAIL");
			}
			click(SaveandReprocess,"Click on Save and Reprocess button");
			sleep(5000);
		}
		else
	    {
	     Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
	    
	    }
	}
	//================================================ Reusable function ==============================================================================================

	public void schemaLink()
	{
		waitForElementToAppear(SchemaLink,5);
		verifyMustExists(SchemaLink,"Schema Link");
		click(SchemaLink,"Schema Link");
	}

	public void schemapage()
	{
		if(isVisible(SchemaPageLbl)==true){
			waitForElementToAppear(SchemaPageLbl,5);
			verifyMustExists(SchemaPageLbl,"Schema page lable");
		}else{
			Report.LogInfo("verifysavepublicButton", "Save public button not dispalyed", "FAIL");
		}
	}

	public void verifySchemaSection(String SchemaSectionlbl)
	{
		waitForElementToAppear(SchemaSectionlbl,5);
		verifyMustExists(SchemaSectionlbl,"Schema section lable");
	}

	public void verifyAddschemabutton(String CreateSchemaIcon)
	{
		if(isVisible(CreateSchemaIcon)==true){
			verifyMustExists(CreateSchemaIcon,"Add Schema button");
		}else{
			Report.LogInfo("verifyAddSchemaButton", "Add schema button not dispalyed", "FAIL");
		}
	}

	public void clickonAddSchemabutton(String CreateSchemaIcon)
	{
		for(int i= 0; i<=5; i++)
		{

			click(CreateSchemaIcon,"Add Schema button");
			sleep(2000);
			if(isVisible(SchemaNameTxt)==true)
			{
				break;
			}
		}
	}

	public void addSchema(String Name,String ClassOfBusinessDDValue,String SchemaTypeDDValue,String CBdropdownValue, String STdropdownValue)
	{
		if(isVisible(SchemaNameTxt)==true){
			verifyMustExists(SchemaNameTxt,"Schema Name text field");	
			sendKeys(SchemaNameTxt,Name,"Schema Name field.");
			SelectDropDownValue1(ClassOfBusinessDD,ClassOfBusinessDDValue);
			SelectDropDownValue1(SchemaTypeDD,SchemaTypeDDValue);
			verifyMustExists(SaveBtn,"Save button");
			click(SaveBtn,"Save button");
		}else{
			Report.LogInfo("verifyAddSchemaPage", "Add schema Page not dispalyed", "FAIL");
		}
	}

	public void verifySchema(String SchemaName )
	{
		if(isVisible(AddSchemaPageErrorMsg)==true)
		{
			Report.LogInfo("verifyerrorMessage", "Error message displayed,Schema not added successfully", "Fail");
		}else
		{
			if(webDriver.findElement(By.xpath("//ui-view[@id='content']//h3[contains(text(),'"+SchemaName+"')]")).isDisplayed()== true)
			{
				Report.LogInfo("verifyAddedSchema", "Schema added successfully", "PASS");
			}else{
				Report.LogInfo("verifyAddedSchema", "Schema not added successfully", "FAIL");
			}
		}
	}

	public void openInEditMode()
	{
		if(isVisible(EditkebabIcon)==true){
			waitForElementToAppear(EditkebabIcon,5);
			verifyMustExists(EditkebabIcon,"Edit kebab icon");
			//mouseOverAction(EditkebabIcon);
			click(EditkebabIcon,"Edit kebab icon");
			waitForElementToAppear(Editlink,5);
			verifyMustExists(Editlink,"Edit Link");
			click(Editlink,"Edit Link");
		}else{
			Report.LogInfo("verifyEditedIcon", "Edit icon not displayed", "FAIL");
		}
	}

	public void editSchemaDetails()
	{
		if(isVisible(EditClassOfBusinessDD)==true){
			waitForElementToAppear(EditClassOfBusinessDD,5);
			verifyMustExists(EditClassOfBusinessDD,"Class of Business dropdown");
			verifyMustExists(PropertyDFCancelIcon,"Property D&F (US binder) cancel icon");
			click(PropertyDFCancelIcon,"Property D&F (US binder) cancel icon");
			SelectDropDownValue1(EditClassOfBusinessDD,EditClassOfBusinessDDValue);
		}else{
			Report.LogInfo("verifyeditpage", "edit page not displayed", "FAIL");
		}

	}

	public void navigateToSettingsTab()
	{
		if(isVisible(SettingsTab)==true){
			waitForElementToAppear(SettingsTab,5);
			verifyMustExists(SettingsTab,"Settings Tab");
			click(SettingsTab,"Settings Tab");
		}else{
			Report.LogInfo("verifySettingTab", "Setting Tab not displayed", "FAIL");
		}
	}
	public void navigateToFieldSelectionTab()
	{
		if(isVisible(FieldSelectionTab)==true){
			waitForElementToAppear(FieldSelectionTab,5);
			verifyMustExists(FieldSelectionTab,"Field Selection Tab");
			click(FieldSelectionTab,"Field selection Tab");
		}else{
			Report.LogInfo("verifyFieldSelectionTab", "Field Selection Tab not displayed", "FAIL");
		}
	}	

	public void TotalValueSelection(String DDValue)
	{
		if(isVisible(TotalValueSelectionDD)==true){
			waitForElementToAppear(TotalValueSelectionDD,5);
			verifyMustExists(TotalValueSelectionDD,"Total Value Selection Dropdown");
			click(TotalValueSelectionDD,"Total Value Selection Dropdown");
			javaScriptWait();
			verifyMustExists(DDValue,"dropdown value");	
			click(DDValue,"dropdown value");	
		}else{
			Report.LogInfo("verifyTotalVauedropdown", "Total value drop down not displayed", "FAIL");
		}
	}

	public void SaveAndPublish()
	{
		if(isVisible(SaveAndPublishBtn)==true){
			waitForElementToAppear(SaveAndPublishBtn,5);
			verifyMustExists(SaveAndPublishBtn,"Save And Publish button");
			click(SaveAndPublishBtn,"Save And Publish button");	
			waitForElementToAppear(PublishDescriptionTxt,5);
			verifyMustExists(PublishDescriptionTxt,"publish Description text field");
			sendKeys(PublishDescriptionTxt,"Automation Test","public Description text field");
			verifyMustExists(PublishBtn,"Publish button");
			click(PublishBtn,"Publish button");	
		}else{
			Report.LogInfo("verifysavepublicButton", "Save public button not dispalyed", "FAIL");
		}
	}
	public void verifyeditedSchema(String SchemaName,String ExpectedClassBussiness,String ExpectedPDescription )
	{
		if(webDriver.findElement(By.xpath("//ui-view[@id='content']//h3[contains(text(),'"+SchemaName+"')]")).isDisplayed()== true)
		{
			Report.LogInfo("verifyEditedSchema", "Schema edited successfully", "PASS");
		}else{
			Report.LogInfo("verifyEditedSchema", "Schema not edited successfully", "FAIL");
		}
		verifyMustExists(changedversion,"edited version");
		verifyMustExists(ClassOfBusinessTxt,"Class of Business text field");
		String ActualClassBussiness =getTextFrom(ClassOfBusinessTxt);
		if(ExpectedClassBussiness.equals(ActualClassBussiness))
		{
			Report.LogInfo("verifyClassofBusiness", "edited Class Of Business field verify successfully", "PASS");
		}else{
			Report.LogInfo("verifyClassofBusiness", "edited Class Of Business field not verify successfully", "FAIL");
		}

		verifyMustExists(PublishedDescriptionTxt,"published Description text field");
		String ActualPublishedDesc =getTextFrom(PublishedDescriptionTxt);

		if(ExpectedPDescription.equals(ActualPublishedDesc))
		{
			Report.LogInfo("verifypublishedDescription", "edited published Description field verify successfully", "PASS");
		}else{
			Report.LogInfo("verifypublishedDescription", "edited published Description field not verify successfully", "FAIL");
		}	
	}

	public void addSchema2(String Name,String ClassOfBusinessDDValue,String SchemaTypeDDValue)
	{
		if(isVisible(SchemaNameTxt)==true){
			verifyMustExists(SchemaNameTxt,"Schema Name text field");	
			sendKeys(SchemaNameTxt,Name,"Schema Name field.");
			SelectDropDownValue1(ClassOfBusinessDD,ClassOfBusinessDDValue1);
			SelectDropDownValue1(SchemaTypeDD,SchemaTypeDDValue);
			verifyMustExists(SaveBtn,"Save button");
			click(SaveBtn,"Save button");
		}else{
			Report.LogInfo("verifyAddSchemaPage", "Add schema Page not dispalyed", "FAIL");
		}
	}

	public void verifyeditedSchema(String FilterText, String FilterResult)
	{
		waitForElementToAppear(FilterIcon,5);
		verifyMustExists(FilterIcon,"Filter Icon");
		click(FilterIcon,"Filter Icon");
		verifyMustExists(SearchTxt,"Filter Icon");
		sendKeys(SearchTxt,FilterText,"Filter Icon");
		verifyMustExists(FilterResult,"Filter Button");
		click(FilterResult,"Filter Button");
		verifyMustExists(FilterBtn,"Filter Button");
		click(FilterBtn,"Filter Button");
	}

	public void SearchEditedAddedSchema(String FilterText)
	{
		String Val = "@xpath=//input[@value='"+FilterText+"']";
		waitForElementToAppear(FilterIconSchema,5);
		verifyMustExists(FilterIconSchema,"Filter Icon");
		click(FilterIconSchema,"Filter Icon");
		verifyMustExists(SearchTxt,"Filter Icon");
		sendKeys(SearchTxt,FilterText,"Filter Icon");
		verifyMustExists(Val,"Filter Button");
		click(Val,"Filter Button");
		verifyMustExists(FilterBtn,"Filter Button");
		click(FilterBtn,"Filter Button");
	}

	public void addSchema1(String Name,String ClassOfBusinessDDValue,String SchemaTypeDDValue)
	{
		if(isVisible(SchemaNameTxt)==true){
			verifyMustExists(SchemaNameTxt,"Schema Name text field");	
			sendKeys(SchemaNameTxt,Name,"Schema Name field.");
			String Val = "@xpath=//li[contains(.,'"+ClassOfBusinessDDValue+"')]";
			SelectDropDownValue1(ClassOfBusinessDD,Val);
			SelectDropDownValue1(SchemaTypeDD,SchemaTypeDDValue);
			verifyMustExists(SaveBtn,"Save button");
			click(SaveBtn,"Save button");
		}else{
			Report.LogInfo("verifyAddSchemaPage", "Add schema Page not dispalyed", "FAIL");
		}
	}

	public void editSchemaAndPublish(String PublishName, String InsurableCheck)
	{
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		sleep(2000);
		openInEditMode();
		sleep(1000);
		//Add building value to schema
		verifyeditedSchema("A - Buildings Value", BuildingsValuecheckbox1);
		verifyMustExists(BuildingsValue,"Buiding value");
		click(BuildingsValue,"Building value");
	    verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		//Add content value to schema
		verifyeditedSchema("C - Contents Value", ContentValueCheckBox);
		verifyMustExists(ContentsValue,"Contents Value");
		click(ContentsValue,"Contents Value");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Location Sprinklers (Y/N)", LocationSprinklersCheckBox);
		verifyMustExists(Sprinklers,"Location Sprinklers (Y/N)");
		click(Sprinklers,"Location Sprinklers (Y/N)");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Number of Stories", NoOfStoriescheckbox);
		verifyMustExists(NumberOfStories,"Number of Stories");
		click(NumberOfStories,"Number of Stories");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("building year built", BuildingYearBuiltcheckbox);
		verifyMustExists(BuildingYearBuilt,"Building Year Built");
		click(BuildingYearBuilt,"Building Year Built");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Location Occupancy Scheme", ConstructionSchemecheckbox);
		verifyMustExists(OccupancyScheme,"Occupancy Scheme");
		click(OccupancyScheme,"Occupancy Scheme");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Location Occupancy Code", ConstructionCodecheckbox);
		verifyMustExists(OccupancyCode,"Occupancy Code");
		click(OccupancyCode,"Occupancy Code");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Location Occupancy Description", ConstructionDescriptioncheckbox);		
		verifyMustExists(OccupancyDescription,"Occupancy Description");
		click(OccupancyDescription,"Occupancy Description");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Total Insurable Value", InsurableCheck);
		verifyMustExists(TotalInsurableValue,"Total Insured Value");
		click(TotalInsurableValue,"Occupancy Code");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");		
		verifyMustExists(SettingsTab,"Settings Tab");
		click(SettingsTab,"Settings Tab");	
		SelectDropDownValue1(TotalValueDD,TotalValueDDValue);
		verifyMustExists(SaveAndPublishBtn,"Save and Publish button");
		click(SaveAndPublishBtn,"Save and Publish button");	
		verifyMustExists(PublishDescriptionTxt,"Publish Description textbox");
		sendKeys(PublishDescriptionTxt,PublishName,"Publish Description textbox");	
		verifyMustExists(PublishBtn,"Publish button");
		click(PublishBtn,"Publish button");
		sleep(2000);
	}

	public void editSchemaAndPublish1(String PublishName)
	{
		scrollUp();
		sleep(2000);
		openInEditMode();
		sleep(1000);
		verifyMustExists(BuildingsValue,"Buiding value");
		click(BuildingsValue,"Building value");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(ContentsValue,"Contents Value");
		click(ContentsValue,"Contents Value");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(Sprinklers,"Sprinklers Y/N");
		click(Sprinklers,"Sprinklers Y/N");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(NumberOfStories,"Number of Stories");
		click(NumberOfStories,"Number of Stories");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(BuildingYearBuilt,"Building Year Built");
		click(BuildingYearBuilt,"Building Year Built");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(OccupancyScheme,"Occupancy Scheme");
		click(OccupancyScheme,"Occupancy Scheme");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(OccupancyCode,"Occupancy Code");
		click(OccupancyCode,"Occupancy Code");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(OccupancyDescription,"Occupancy Description");
		click(OccupancyDescription,"Occupancy Description");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(TotalInsurableValue,"Occupancy Code");
		click(TotalInsurableValue,"Occupancy Code");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");		
		verifyMustExists(SettingsTab,"Settings Tab");
		click(SettingsTab,"Settings Tab");	
		SelectDropDownValue1(TotalValueDD,TotalValueDDValue);
		verifyMustExists(SaveAndPublishBtn,"Save and Publish button");
		click(SaveAndPublishBtn,"Save and Publish button");	
		verifyMustExists(PublishDescriptionTxt,"Publish Description textbox");
		sendKeys(PublishDescriptionTxt,PublishName,"Publish Description textbox");	
		verifyMustExists(PublishBtn,"Publish button");
		click(PublishBtn,"Publish button");
		sleep(2000);
	}

	//3937
	public void grossPremiumRule()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD, GrossPremiumValue);
		SelectDropDownValue1(policy.OperatorDD,GreaterThanOrEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,"100.00","Entry Or Selection textbox");
	}
	//3937
	public void numberOfStories()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,NumberOfStoriesValue);
		SelectDropDownValue1(policy.OperatorDD,BetweenValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt,"50","Entry Value From textbox");
		verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
		sendKeys(EntryValueToTxt,"99","Entry Value From textbox");
	}

	//3937
	public void numberOfStoriesLessThanOrEqual(String Value)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,NumberOfStoriesValue);
		SelectDropDownValue1(policy.OperatorDD,LessThanOrEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt ,Value,"Entry Value From textbox");
	}
	//3937
	public void riskInceptionDate()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskInceptionDateValue);
		SelectDropDownValue1(policy.OperatorDD,NotEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt ,"01/02/2017","Entry Value From textbox");		
	}
	//3849
	public void riskInceptionDateNotBetween1()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskInceptionDateValue);
		SelectDropDownValue1(policy.OperatorDD,NotBetweenValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt ,"01/02/2017","Entry Value From textbox");
		verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
		sendKeys(EntryValueToTxt,"02/03/2017","Entry Value From textbox");
	}

	public void riskInceptionDateNotBetween2(String date1, String date2)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskInceptionDateValue);
		SelectDropDownValue1(policy.OperatorDD,NotBetweenValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt ,date1,"Entry Value From textbox");
		verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
		sendKeys(EntryValueToTxt,date2,"Entry Value From textbox");
	}

	//3937
	public void riskInceptionDateNotBetween()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskInceptionDateValue);		
		SelectDropDownValue1(policy.OperatorDD,NotBetweenValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt ,"01/02/2017","Entry Value From textbox");
		verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
		sendKeys(EntryValueToTxt,"10/10/2017","Entry Value From textbox");
	}

	//3937
	public void riskInceptionDateNotBetween1(String value, String value1)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskInceptionDateValue);		
		SelectDropDownValue1(policy.OperatorDD,NotBetweenValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt ,value,"Entry Value From textbox");
		verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
		sendKeys(EntryValueToTxt,value1,"Entry Value From textbox");
	}

	//3938
	public void totalInsuranceValue(String Value)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,TotalInsurableValueRule);
		SelectDropDownValue1(policy.OperatorDD,GreaterThanValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,Value,"Entry Or Selection textbox");
	}

	//3938
	public void contentsValue()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,ContentsValue1);
		SelectDropDownValue1(policy.OperatorDD,LessThanValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,"1000","Entry Or Selection textbox");
	}

	//3938
	public void buildingYearBuiltValue()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,BuildingYearBuiltValue);
		SelectDropDownValue1(policy.OperatorDD,NotEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromDD,"Entry Value From dropdown");
		click(EntryValueFromDD,"Entry Value From dropdown");
		verifyMustExists(EntryValueFromDD1960Value,"1960 Value");
		click(EntryValueFromDD1960Value,"1960 Value");
	}

	//3849
	public void riskCurrency()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskCurrencyValue);
		SelectDropDownValue1(policy.OperatorDD,NotEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		SelectDropDownValue1(EntryValueFromDD,EntryValueFromDDUSDValue);
	}

	//3849
	public void totalTax()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,TotalTaxValue);
		SelectDropDownValue1(policy.OperatorDD,LessThanOrEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt,"10","Entry Value From textbox");
	}

	//3849
	public void riskPostalCode(String value)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskPostalCodeValue);
		SelectDropDownValue1(policy.OperatorDD,ContainsValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt,value,"Entry Value From textbox");
	}

	//3849
	public void netPremium()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,NetPremiumValue);
		SelectDropDownValue1(policy.OperatorDD,LessThanValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt,"100","Entry Value From textbox");
	}

	public void netPremiumLessThanOrEqual(String value)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,NetPremiumValue);
		SelectDropDownValue1(policy.OperatorDD,LessThanOrEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt,value,"Entry Value From textbox");
	}

	//3849
	public void sprinklers()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,SprinklersValue);
		SelectDropDownValue1(policy.OperatorDD,EqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		SelectDropDownValue1(EntryValueFromDD,NoValue);
	}

	public void yearOfAccount(String val)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,YearOfAcValue);
		SelectDropDownValue1(policy.OperatorDD,EqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt,val,"Entry Value From textbox");
	}

	//3850
	public void sprinklers1()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,SprinklersValue);
		SelectDropDownValue1(policy.OperatorDD,EqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		SelectDropDownValue1(EntryValueFromDD,YesValue);
	}

	public void buildingsValue(String value1, String value2)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,BuildingsValue1);
		SelectDropDownValue1(policy.OperatorDD,NotBetweenValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt ,value1,"Entry Value From textbox");
		verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
		sendKeys(EntryValueToTxt,value2,"Entry Value From textbox");
	}



	//3849
	public void occupancyCode()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,OccupancyCodeValue);
		SelectDropDownValue1(policy.OperatorDD,IsBlankValue);			
	}

	//3849
	public void grossPremium()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,GrossPremiumValue);		
		SelectDropDownValue1(policy.OperatorDD,GreaterThanOrEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt,"100","Entry Value From textbox");	
	}

	//3850
	public void numberOfStoriesIsBlank()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,NumberOfStoriesValue);
		SelectDropDownValue1(policy.OperatorDD,IsBlankValue);	
	}

	//3850
	public void insuredAddress()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,InsuredAddressValue);
		SelectDropDownValue1(policy.OperatorDD,IsBlankValue);		
	}

	public void occupancyCodeNotBetween()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,OccupancyCodeValue);
		SelectDropDownValue1(policy.OperatorDD,NotBetweenValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt ,"300","Entry Value From textbox");
		verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
		sendKeys(EntryValueToTxt,"400","Entry Value From textbox");
	}

	public void occupancyCodeNotBetweenCompliance()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,OccupancyCodeValue);
		SelectDropDownValue1(policy.OperatorDD,NotBetweenValue);	
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		SelectDropDownValue1(EntryValueFromDD, EntryValueFromDD300);
		SelectDropDownValue1(EntryValueToDD, EntryValueFromDD400);	
	}

	public void buildingValueNotBetweenCompliance(String value, String Value1)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,BuildingValue);
		SelectDropDownValue1(policy.OperatorDD,NotBetweenValue);	
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt ,value,"Entry Value From textbox");
		verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
		sendKeys(EntryValueToTxt,Value1,"Entry Value From textbox");
	}

	public void SelectComplianceData()
	{
		waitForElementToAppear(RuleHeaderLink,5);
		verifyMustExists(RuleHeaderLink,"RuleHeaderLink");
		click(RuleHeaderLink,"RuleHeaderLink");
		SelectDropDownValue1(AddRuleDropDown,AddRuleComplianceData);
	}

	public void AddComplianceDataRule(String Rule_Name,String Error_Messgage,String Data_Set, String Processing_Action,String Classic_Bussiness){

		waitForElementToAppear(RuleNameText,5);
		verifyMustExists(RuleNameText,"RuleNameText");
		sendKeys(RuleNameText,Rule_Name,"Enter RuleName");
		waitForElementToAppear(ErrorMessgaeText,5);
		verifyMustExists(ErrorMessgaeText,"ErrorMessgaeText");
		sendKeys(ErrorMessgaeText,Error_Messgage,"Enter ErrorMessgaeText");

		waitForElementToAppear(DataSetDrpDwn,5);
		verifyMustExists(DataSetDrpDwn,"DataSetDrpDwn");
		click(DataSetDrpDwn,"DataSetDrpDwn");
		sleep(1000);
		webDriver.findElement(By.xpath("//li[text()='"+Data_Set+"']")).click();
		waitForElementToAppear(ProcessingActionDrpDwn,5);
		verifyMustExists(ProcessingActionDrpDwn,"ProcessingActionDrpDwn");
		click(ProcessingActionDrpDwn,"ProcessingActionDrpDwn");
		sleep(1000);
		webDriver.findElement(By.xpath("//li[text()='"+Processing_Action+"']")).click();
		waitForElementToAppear(ClassBusinessSelction,5);
		verifyMustExists(ClassBusinessSelction,"ClassBusinessSelction");
		click(ClassBusinessSelction,"ClassBusinessSelction");
		sleep(1000);
		webDriver.findElement(By.xpath("//li[text()='"+Classic_Bussiness+"']")).click();
	}

	public void AddContractRule(String Rule_Name, String Data_Set, String Currency_Val, String AppCondition_Val){

		waitForElementToAppear(RuleNameText,5);
		verifyMustExists(RuleNameText,"RuleNameText");
		sendKeys(RuleNameText,Rule_Name,"Enter RuleName");

		String dataSetVal = "@xpath=//li[text()='"+Data_Set+"']";
		waitForElementToAppear(DataSetDrpDwn,3);
		SelectDropDownValue1(DataSetDrpDwn,dataSetVal);

		String Currency_Value = "@xpath=//li[text()='"+Currency_Val+"']";
		waitForElementToAppear(CurrencyDrpDwn,3);
		SelectDropDownValue1(CurrencyDrpDwn,Currency_Value);

		waitForElementToAppear(ROETolerance,5);
		verifyMustExists(ROETolerance,"ROE Tolerance");
		sendKeys(ROETolerance,"5","Enter ROE Tolerance");

		String AppCondition_Value = "@xpath=//li[text()='"+AppCondition_Val+"']";
		//String AppCondition_Value = "@xpath=//li[text()='Data is valid if the rule conditions are met']";
		waitForElementToAppear(AppConditonDrpDwn,3);
		SelectDropDownValue1(AppConditonDrpDwn,AppCondition_Value);

		String AppSec_Value = "@xpath=//li[contains(.,'Section2')]";
		String AppSec_Value1 = "@xpath=//li[contains(.,'Section1')]";

		waitForElementToAppear(AppSectionDrpDwn,3);
		SelectDropDownValue1(AppSectionDrpDwn,AppSec_Value);
		SelectDropDownValue1(AppSectionDrpDwn,AppSec_Value1);


	}	

	public void CreatePolicyAndUploadFile() throws Exception{
		String UniqueReferenceVal1 = "Automation Policy_19"+getCurrentDateTimeMS();
		String Status1 = "Draft";
		String InceptionDate1 = "01/01/2017";
		String subSheet = "Risk Reference Format";
		//String InceptionDateExp = "01/01/2018";
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails(UniqueReferenceVal1, InceptionDate1, Status1, policy.Broker1, policy.Bline1, policy.Underline1);
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		sleep(2000);
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		Br.SubmitBordereaux(subSheet);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4080Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_4080.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		policy.contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_4080.xlsx\",\"UniqueFileName\":\"S84333320180008.xlsx\",\"BordereauFormatId\":\"b9dc3d28-c6bf-44cf-abaf-c9076bdb3581\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S84333320180008.xlsx\",\"Filesize\":24684,\"Path\":null,\"size\":24684,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		File excelFile = new File(sheet4080Path);
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		Br.refreshUploadedFile();
		String MultipleRuleConditionError ="@xpath=//*[@id='dataType_Id']//h2[contains(.,'Multiple rule condition Error')]";


		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
			if(isVisible(MultipleRuleConditionError)== true)
			{
				verifyMustExists(Data0,"Gross Premium");
				sendKeys(Data0,"01/02/2017","Gross Premium");
				verifyMustExists(Data1,"Number of Stories");
				sendKeys(Data1,"447","Number of Stories");
				verifyMustExists(Data2,"Risk Inception Date");
				sendKeys(Data2,"1992","Risk Inception Date");
				verifyMustExists(ContinueBtn,"Continue button");
				click(ContinueBtn,"Continue button");
				sleep(2000);
				verifyMustExists(CancelBtn,"Cancel button");
				click(CancelBtn,"Cancel button");
				sleep(2000);
				if(isVisible(BordereauProcess.ReviewBtn)==true)
				{
					verifyExists(BordereauProcess.ReviewBtn,"Review button");
					BordereauProcess.deleteBorderEAUX();
				}
				else
				{
					BordereauProcess.refreshUploadedFile();
					verifyExists(BordereauProcess.ReviewBtn,"Review button");
					BordereauProcess.deleteBorderEAUX();
				}	
			}
		}
		else
		{
			Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
			goBack();
			BordereauProcess.deleteBorderEAUX();				
		}
	}


	public void AddRuleConditionForComplianceRule2(String FieldName1,String OPERATOR1,String ENTRY_SELECTION1 ){


		waitForElementToAppear(AddRulesConditionButton,5);
		verifyMustExists(AddRulesConditionButton,"AddRulesConditionButton");
		click(AddRulesConditionButton,"AddRulesConditionButton");
		waitForElementToAppear(Method1,5);
		verifyMustExists(Method1,"Method1");
		click(Method1,"Method1");
		waitForElementToAppear(AndOption,5);
		verifyMustExists(AndOption,"AndOption");
		click(AndOption,"AndOption");
		waitForElementToAppear(FieldNameDrpDwn,5);
		verifyMustExists(FieldNameDrpDwn,"FieldNameDrpDwn");
		click(FieldNameDrpDwn,"FieldNameDrpDwn");
		sleep(1000);
		webDriver.findElement(By.xpath("//*[@data-role='staticlist']//li[contains(text(),'"+FieldName1+"')]")).click();
		waitForElementToAppear(OperatorDrpDwn,5);
		verifyMustExists(OperatorDrpDwn,"OperatorDrpDwn");
		click(OperatorDrpDwn,"OperatorDrpDwn");
		sleep(1000);
		webDriver.findElement(By.xpath("//*[@data-role='staticlist']//li[contains(text(),'"+OPERATOR1+"')]")).click();
		waitForElementToAppear(AppliedToDrpDwn,5);
		verifyMustExists(AppliedToDrpDwn,"AppliedToDrpDwn");
		click(AppliedToDrpDwn,"AppliedToDrpDwn");
		waitForElementToAppear(ValueOption,5);
		verifyMustExists(ValueOption,"ValueOption");
		click(ValueOption,"ValueOption");
		//webDriver.findElement(By.xpath("//*[@data-role='staticlist']//li[contains(text(),'"+APPLIEDTO1+"')]")).click();
		waitForElementToAppear(EntrySelectionText2,5);
		verifyMustExists(EntrySelectionText2,"EntrySelectionText");
		sleep(1000);
		click(EntrySelectionText2,"EntrySelectionText");
		sleep(1000);
		webDriver.findElement(By.xpath("//*[@data-role='staticlist']//li[contains(text(),'"+ENTRY_SELECTION1+"')]")).click();
		sleep(1000);
		//sendKeys(EntrySelectionText2,ENTRY_SELECTION1,"EntrySelectionText");
		waitForElementToAppear(TickMarkButton1,5);
		verifyMustExists(TickMarkButton1,"TickMarkButton");
		click(TickMarkButton1,"TickMarkButton");
		/*waitForElementToAppear(SaveButtonComplianceRule,5);
		verifyMustExists(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		click(SaveButtonComplianceRule,"SaveButtonComplianceRule"); 
		sleep(2000);*/
	}

	public void AddRuleConditionForComplianceRule(String FieldName1,String OPERATOR1,String APPLIEDTO1,String ENTRY_SELECTION1 ){


		waitForElementToAppear(AddRulesConditionButton,5);
		verifyMustExists(AddRulesConditionButton,"AddRulesConditionButton");
		click(AddRulesConditionButton,"AddRulesConditionButton");

		//SelectDropDownValue1(FieldNameDrpDwn,FieldNameDrpDwnSelectOption1);
		waitForElementToAppear(FieldNameDrpDwn,5);
		verifyMustExists(FieldNameDrpDwn,"FieldNameDrpDwn");
		click(FieldNameDrpDwn,"FieldNameDrpDwn");
		waitForElementToAppear(FieldNameDrpDwnSearchText,5);
		verifyMustExists(FieldNameDrpDwnSearchText,"FieldNameDrpDwnSearchText");
		sendKeys(FieldNameDrpDwnSearchText,FieldName1,"FieldNameDrpDwnSearchText");
		sleep(2000);
		waitForElementToAppear(FieldNameDrpDwnSelectOption1,5);
		verifyMustExists(FieldNameDrpDwnSelectOption1,"FieldNameDrpDwnSelectOption");
		click(FieldNameDrpDwnSelectOption1,"FieldNameDrpDwnSelectOption");
		SelectDropDownValue1(OperatorDrpDwn,OperatorDrpDwnSelectOption);	
		SelectDropDownValue1(AppliedToDrpDwn,AppliedToDrpDwnSelectOption);
		waitForElementToAppear(EntrySelectionText1,5);
		verifyMustExists(EntrySelectionText1,"EntrySelectionText");
		sendKeys(EntrySelectionText1,ENTRY_SELECTION1,"EntrySelectionText");
		waitForElementToAppear(TickMarkButton,5);
		verifyMustExists(TickMarkButton,"TickMarkButton");
		click(TickMarkButton,"TickMarkButton");
	}



	public void AddRuleConditionForComplianceRule1(String ENTRY_SELECTION1 ,String ENTRY_SELECTION2){

		waitForElementToAppear(AddRulesConditionButton,5);
		verifyMustExists(AddRulesConditionButton,"AddRulesConditionButton");
		click(AddRulesConditionButton,"AddRulesConditionButton");
		waitForElementToAppear(Method1,5);
		verifyMustExists(Method1,"Method1");
		click(Method1,"Method1");
		waitForElementToAppear(OrOption,5);
		verifyMustExists(OrOption,"OrOption");
		click(OrOption,"OrOption");
		SelectDropDownValue1(FieldNameDrpDwn,InsurableValue);
		SelectDropDownValue1(OperatorDrpDwn,BetweenValue1);
		SelectDropDownValue1(AppliedToDrpDwn,ValueOption);						
		waitForElementToAppear(EntrySelectionText1,5);
		verifyMustExists(EntrySelectionText1,"EntrySelectionText");
		sendKeys(EntrySelectionText1,ENTRY_SELECTION1,"EntrySelectionText");
		waitForElementToAppear(EntrySelectionText2,5);
		verifyMustExists(EntrySelectionText2,"EntrySelectionText");
		sendKeys(EntrySelectionText2,ENTRY_SELECTION2,"EntrySelectionText");
		waitForElementToAppear(TickMarkButton2,5);
		verifyMustExists(TickMarkButton2,"TickMarkButton");
		click(TickMarkButton2,"TickMarkButton");
		sleep(2000);
	}

	public void DatasetSelection(){
		waitForElementToAppear(DatasetRiskInspectionDate,5);
		verifyMustExists(DatasetRiskInspectionDate,"DatasetRiskInspectionDate");
		click(DatasetRiskInspectionDate,"DatasetRiskInspectionDate");
		waitForElementToAppear(RightArrowIcon1,5);
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		waitForElementToAppear(DatasetGrossPremium,5);
		verifyMustExists(DatasetGrossPremium,"DatasetGrossPremium");
		click(DatasetGrossPremium,"DatasetGrossPremium");
		waitForElementToAppear(RightArrowIcon1,5);
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		waitForElementToAppear(DatasetTotalInsurableValue,5);
		verifyMustExists(DatasetTotalInsurableValue,"DatasetTotalInsurableValue");
		click(DatasetTotalInsurableValue,"DatasetTotalInsurableValue");
		waitForElementToAppear(RightArrowIcon1,5);
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		waitForElementToAppear(SaveButtonComplianceRule,5);
		verifyMustExists(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		click(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		sleep(4000);
	}

	public void selectInformationRule(){
		SelectDropDownValue1(AddRulesDropDwn,AddRulesOptionInformation);
	}

	public void fileUpload_4044() throws  Exception{
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4044Path = fpath+"\\src\\test\\resources\\testdata\\Information Rule_TC_4044.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Information Rule_TC_4044.xlsx\",\"UniqueFileName\":\"S11350320171127.xlsx\",\"BordereauFormatId\":\"dd7607a8-5fe7-4565-b28b-960cb2f53a8b\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S11350320171127.xlsx\",\"Filesize\":18067,\"Path\":null,\"size\":18067,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		File excelFile = new File(sheet4044Path);
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		Br.refreshUploadedFile();

		if(isVisible(Br.ReviewBtn)==true){
			Report.LogInfo("ValidateReviewStatus", "Review Button displayed", "PASS");
			verifyMustExists(Br.ReviewBtn,"Review Button");
			click(Br.ReviewBtn,"Clicked on Review Button");
			rule.GetApproveStatus();

		}else{
			Report.LogInfo("ValidateReviewStatus", "Review Button not displayed", "FAIL");
			Br.deleteBorderEAUX();
		}	
	}

	public void AddInformationRule(String Rule_Name,String Error_Messgage,String dataset1,String ApplicationCondition1,String Schema1 ){
		waitForElementToAppear(RuleNameText,5);
		verifyMustExists(RuleNameText,"RuleNameText"); 
		sendKeys(RuleNameText,Rule_Name,"Enter RuleName");
		waitForElementToAppear(ErrorMessgaeText,5);
		verifyMustExists(ErrorMessgaeText,"ErrorMessgaeText");
		sendKeys(ErrorMessgaeText,Error_Messgage,"Enter ErrorMessgaeText");

		waitForElementToAppear(DataSetDropDwn,5);
		verifyMustExists(DataSetDropDwn,"DataSetDropDwn");
		click(DataSetDropDwn,"DataSetDropDwn");
		waitForElementToAppear(SelectOptionDataSetDropDwn,5);
		verifyMustExists(SelectOptionDataSetDropDwn,"SelectOptionDataSetDropDwn");
		webDriver.findElement(By.xpath("//li[text()='"+dataset1+"']")).click();
		waitForElementToAppear(ApplicationConditionDrpDwn,5);
		verifyMustExists(ApplicationConditionDrpDwn,"ApplicationConditionDrpDwn");
		click(ApplicationConditionDrpDwn,"ApplicationConditionDrpDwn");
		waitForElementToAppear(ApplicationConditionDrpDwnSelectOption,5);
		verifyMustExists(ApplicationConditionDrpDwnSelectOption,"ApplicationConditionDrpDwnSelectOption");
		webDriver.findElement(By.xpath("//li[text()='"+ApplicationCondition1+"']")).click();

		SelectDropDownValue1(SchemaDropDwn,SchemaDropDwnOption);
	}

	public void AddRuleConditionForInformationRule(String FieldName1,String OPERATOR1,String APPLIEDTO1,String ENTRY_SELECTION1,String ENTRY_SELECTION2 ){
		waitForElementToAppear(AddRulesConditionButton,5);
		verifyMustExists(AddRulesConditionButton,"AddRulesConditionButton");
		click(AddRulesConditionButton,"AddRulesConditionButton");
		SelectDropDownValue1(FieldNameDrpDwn,SelectOptionNumberOfStories);
		sleep(2000);
		SelectDropDownValue1(OperatorDrpDwn,BetweenSlectionOption);

		SelectDropDownValue1(AppliedToDrpDwn,AppliedToDrpDwnSelectOption);
		waitForElementToAppear(EntrySelction1,5);
		verifyMustExists(EntrySelction1,"EntrySelctionFirst");
		sendKeys(EntrySelction1,ENTRY_SELECTION1,"Enter First Entry");
		waitForElementToAppear(EntrySelction2,5);
		verifyMustExists(EntrySelction2,"EntrySelctionSecond");
		sendKeys(EntrySelction2,ENTRY_SELECTION2,"Enter Second Entry");

		waitForElementToAppear(TickMarkButton,5);
		verifyMustExists(TickMarkButton,"TickMarkButton");
		click(TickMarkButton,"TickMarkButton");
		waitForElementToAppear(SaveButtonComplianceRule,5);
		verifyMustExists(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		click(SaveButtonComplianceRule,"SaveButtonComplianceRule"); 
		sleep(2000);
		if(isVisible(PopupTitle)==true){
			waitForElementToAppear(PopupSaveButton,5);
			verifyMustExists(PopupSaveButton,"PopupSaveButton");
			click(PopupSaveButton,"PopupSaveButton");
		}else{
			sleep(4000);	
		}		
	}

	public void selectBreaches(){
		String RulseDropDwnSelectionOption = "@xpath=//li[contains(.,'"+RuleNameInformation+"')]";
		waitForElementToAppear(RulesMenuTab,5);
		verifyMustExists(RulesMenuTab,"RulesMenuTab");
		click(RulesMenuTab,"RulesMenuTab");
		waitForElementToAppear(BreachesLink,5);
		verifyMustExists(BreachesLink,"BreachesLink");
		click(BreachesLink,"BreachesLink");
		waitForElementToAppear(RulseDropDwnSelection,5);
		verifyMustExists(RulseDropDwnSelection,"RulseDropDwnSelection");
		click(RulseDropDwnSelection,"RulseDropDwnSelection");
		waitForElementToAppear(RulseDropDwnSelectionOption,5);
		verifyMustExists(RulseDropDwnSelectionOption,"RulseDropDwnSelectionOption");
		click(RulseDropDwnSelectionOption,"RulseDropDwnSelectionOption");
		if(isVisible(RulesConditionTab)==true){
			Report.LogInfo("ValidateBreachesStatus", "Breaches get opened", "PASS");
		}else{
			Report.LogInfo("ValidateBreachesStatus", "Breaches not get opened", "FAIL");
		}
	}

	public void createClassOfBusiness(String name) throws InterruptedException
	{
		homePage.adminMenu();
		verifyMustExists(SystemReferanceDataOption,"System Referance Data Option");
		click(SystemReferanceDataOption,"System Referance Data Option");
		verifyMustExists(ClassOfBusinesslabel,"Class Of Business label");
		click(ClassOfBusinesslabel,"Class Of Business label");
		verifyMustExists(AddClassOfBusinessBtn,"Add Class Of Business button");
		click(AddClassOfBusinessBtn,"Add Class Of Business button");
		verifyMustExists(ClassOfBusinessNameTxt,"Class Of Business Name textbox");
		sendKeys(ClassOfBusinessNameTxt,name,"Class Of Business Name textbox");
		verifyMustExists(ClassOfBusinessShortNameTxt,"Class Of Business Short Name textbox");
		sendKeys(ClassOfBusinessShortNameTxt,"aCob","Class Of Business Short Name textbox");
		SelectDropDownValue1(LineOfBusinessDD,LineOfBusinessValue);
		verifyMustExists(SaveBtn,"Save button");
		click(SaveBtn,"Save button");
	}

	public void sprinklersYes()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,SprinklersValue);
		SelectDropDownValue1(policy.OperatorDD,EqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		SelectDropDownValue1(EntryValueFromDD,YesValue);
	}

	public void contentsValue(String value)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,ContentsValue1);
		SelectDropDownValue1(policy.OperatorDD,LessThanOrEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,value,"Entry Or Selection textbox");
	}
	
	public void applyDataSetFilter(String FilterString) throws InterruptedException
	{
		int i=0;

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(DataSetFilterIcon, "Policy Reference Filter Icon");
			sleep(2000);
			if(isVisible(DataSetFilterSearch))
			{
				verifyMustExists(DataSetFilterSearch,"Search Filter Textbox");	
				sendKeys(DataSetFilterSearch,FilterString,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(COBChkBox) && i<5);

		click(COBChkBox, "Searched Record Checkbox");
		verifyMustExists(policy.FilterButton,"Filter Button");
		click(policy.FilterButton,"Filter Button");
		sleep(3000);
	}
	
	public void createClassOfBusiness1(String name) throws InterruptedException
	{
		verifyMustExists(AddClassOfBusinessBtn,"Add Class Of Business button");
		click(AddClassOfBusinessBtn,"Add Class Of Business button");
		verifyMustExists(ClassOfBusinessNameTxt,"Class Of Business Name textbox");
		sendKeys(ClassOfBusinessNameTxt,name,"Class Of Business Name textbox");
		verifyMustExists(ClassOfBusinessShortNameTxt,"Class Of Business Short Name textbox");
		sendKeys(ClassOfBusinessShortNameTxt,"aCob","Class Of Business Short Name textbox");
		SelectDropDownValue1(LineOfBusinessDD,LineOfBusinessValue);
		verifyMustExists(SaveBtn,"Save button");
		click(SaveBtn,"Save button");
	}
	
	public void riskInceptionDateNotEqual(String Date)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskInceptionDateValue);		
		SelectDropDownValue1(policy.OperatorDD,EqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt, Date, "Entry Value From textbox");
	}
	
	public void DatasetSelection2(){
		verifyMustExists(RiskExpiryDateValue,"DatasetRiskInspectionDate");
		click(RiskExpiryDateValue,"DatasetRiskInspectionDate");
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		verifyMustExists(NumberOfStories,"NumberOfStories");
		click(NumberOfStories,"NumberOfStories");
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		verifyMustExists(GrossPremium,"GrossPremium");
		click(GrossPremium,"GrossPremium");
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		waitForElementToAppear(SaveButtonComplianceRule,5);
		verifyMustExists(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		click(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		sleep(4000);
	}
	
	public void DatasetSelection1(){
		waitForElementToAppear(RiskExpiryDateValue,5);
		verifyMustExists(RiskExpiryDateValue,"DatasetRiskInspectionDate");
		click(RiskExpiryDateValue,"DatasetRiskInspectionDate");
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		waitForElementToAppear(InsuredNameValue,5);
		verifyMustExists(InsuredNameValue,"DatasetGrossPremium");
		click(InsuredNameValue,"DatasetGrossPremium");
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		waitForElementToAppear(SaveButtonComplianceRule,5);
		verifyMustExists(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		click(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		sleep(4000);
	}
	
	public void addSchema3(String Name,String ClassOfBusinessDDValue,String SchemaTypeDDValue)
	 {
	  if(isVisible(SchemaNameTxt)==true){
	   verifyMustExists(SchemaNameTxt,"Schema Name text field"); 
	   sendKeys(SchemaNameTxt,Name,"Schema Name field.");
	   SelectDropDownValue1(ClassOfBusinessDD,ClassOfBusinessDDValue2);
	   SelectDropDownValue1(SchemaTypeDD,SchemaTypeDDValue);
	   verifyMustExists(SaveBtn,"Save button");
	   click(SaveBtn,"Save button");
	  }else{
	   Report.LogInfo("verifyAddSchemaPage", "Add schema Page not dispalyed", "FAIL");
	  }
	 }
}



