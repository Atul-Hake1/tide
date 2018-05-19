package com.tide.qa.pagefactory;

import java.awt.AWTException;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.lang.model.element.Element;
import javax.sound.sampled.AudioFileFormat.Type;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.paulhammant.ngwebdriver.ByAngular;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class PolicyPage extends PageBase
{
	LoginPage loginPage = new LoginPage();
	//BordereauProcessPage BorProc = new BordereauProcessPage();
	//BProcessingRiskPremiumClaimPage BPProcessng = new BProcessingRiskPremiumClaimPage();

	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddHHmmss");
		String datetime = ft.format(dNow);
		return datetime;
	}
	public static String getCurrentDateTimeMS1() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMssddHHmm");
		String datetime = ft.format(dNow);
		return datetime;
	}
	String UniqueReferenceVal1 = "Automation Policy3"+getCurrentDateTimeMS1();
	String UniqueReferenceVal3 = "Automation Policy4"+getCurrentDateTimeMS();
	String CompanyReferenceval = "Automation Policy5"+getCurrentDateTimeMS();
	String UniqueReferenceVal2 = "Contract 2"+getCurrentDateTimeMS();
	static String  Rule = "AutoRule"+getCurrentDateTimeMS();
	static String  Rule1 = "AutoRule1"+getCurrentDateTimeMS();
	String BrokerageVal = "10";
	String Status1 = "Draft";
	String Status2 = "Quote";
	String Broker1 = "Alwen Hough Johnson Ltd - TBC";
	String Bline1 = "Property (D&F)";
	String Underline1 = "Abhi, Standard";
	//String Status2 = "Draft";
	String Broker2 = "Alwen Hough Johnson Ltd - TBC";
	String Broker3 = "AON - DUA team";
	String Bline2 = "Energy";
	String Underline2 = "Tide, Admin";
	String InceptionDate1 = "01/01/2017";
	String InceptionDate2 = "01/01/2018";
	static String PolicyNumber;
	String OpenPolicy;
	public static String contractId;
	public String addFile = "";
	public static String FinancialCalculation = "";
	public static String sheet3679Path = "";
	public static String SupplementaryFile = "";
	public static String nonDateCharacters = "";
	public static String sheet3529 = "";

	//Start Date 4/10/2017 Rohit
	public static final String PolicyTab = "@css=.menu-btn[href='#!/app/contractlist']";
	public static final String RuleTab = "@xpath=//*[@id='header']//li[@href='#!/app/rulesList/rules']";
	public static final String Existingpolcy = "@xpath=//*[@id='grid']//tr[1]//span[@ng-bind='dataItem.FolderRandomNumber']";
	public static final String AddContractBtn = "@xpath=//div[@ng-click='goToAdd()']";
	public static final String SelectPolicyBtn = "@xpath=//div[contains(@ng-click,'addFolder()')]";
	public static final String AddPolicyBtn = "@xpath=//div[@ng-click='addData()']";
	public static final String PolicyDrpDown = "@xpath=//div[@class='modal-content']//descendant::*[@class='k-input ng-scope'][1]";
	public static final String DivisionDrpDown = "@xpath=//div[@class='modal-content']//descendant::*[@class='k-input ng-scope'][2]";
	//public static final String DivisionDrpValue = "@xpath=//*[@class='k-list k-reset']//*[text()='Charles Taylor InsureTech - Development']";
	//public static final String DivisionDrpValue = "@xpath=//div[@class='k-animation-container']//div[3]/ul[@aria-hidden='false']/li[1]";
	public static final String CashHoldrmultipleBtn = "@xpath=//dl[@ng-if='showSingleMultiple']//label[@class='radio radio-inline m-r-20'][2]";
	public static final String InsuredTxt = "@model=data.Insured";
	public static final String CashHoldrSingleBtn = "@xpath=//dl[@ng-if='showSingleMultiple']//label[@class='radio radio-inline m-r-20'][1]";
	public static final String LoyldYesBtn = "@xpath=//dd[@class='p-t-10']//descendant::label[@class='radio radio-inline m-r-20'][1]";
	public static final String PolicySaveBtn = "@xpath=//h2[contains(.,'Add Folder')]//following::button[@ng-click='save()']";
	public static final String CoverholderDrpDown = "@css=[ng-if='!data.IsMultipleCoverholder && showSingleMultiple'] .k-input.ng-scope";
	public static final String CoverholderDrpValue = "@xpath=//div[@class='k-animation-container']//div[3]/ul[@aria-hidden='false']/li[1]";
	public static final String UniqueReference = "@model=data.UniqueReference";
	//public static final String ContractCurrencyDrpDown = "@css=.k-widget.k-dropdown.k-header.full-width.m-b.form-control.ng-scope.ng-valid-parse.ng-touched.ng-not-empty.ng-valid.ng-valid-required.k-valid.ng-dirty .k-dropdown-wrap.k-state-default .k-icon.k-i-arrow-60-down";
	public static final String ContractCurrencyDrpDown = "@xpath=//*[@id='profile-main']//*[@k-data-source='currencyList']//preceding-sibling::span[1]";
	public static final String ContractCurrencyDrpDownValue = "@xpath=//ul[@class='k-list k-reset']//*[contains(.,'GBP - British Pound')]";
	public static final String SettlementCurrencyDrpDown="@xpath= //*[@id=\"profile-main\"]/data/form/div/div/div/div[1]/div/dl[4]/dd/div/div/span/span/span[1]";
	public static final String SettlementCurrencyDrpDownValue= "@xpath=//ul[@class='k-list k-reset']//*[contains(.,'GBP - British Pound')]";
	public static final String ContractCurrencyDrpDownValueUSD = "@xpath=//ul[@class='k-list k-reset']//*[contains(.,'USD - United States Dollar')]";
//	/html/body/div[6]/div/div[3]/ul/li
	public static final String CompanyReference = "@model=data.CompanyReference";
	public static final String Brokerage = "@model=data.Brokerage";
	public static final String ContractOrder = "@model=data.ContractOrder";
	public static final String ContractStatusDrpDown = "@xpath=//*[@id='profile-main']//*[@ng-model='data.ContractStatus']//preceding-sibling::span[1]";
	public static final String ContractStatusDrpValue = "@xpath=//ul[@class='k-list k-reset']//*[text()='Quote']";
	public static final String BrokerDrpDown = "@xpath=//*[@ng-model='data.BrokerDivisionId']//preceding-sibling::span[1]";
	public static final String BrokerDrpDownValue1 = "@xpath=//ul[@class='k-list k-reset']/li[contains(.,'Aon')]";
	public static final String BrokerDrpDownValue = "@xpath=//ul[@class='k-list k-reset']//*[text()='ACE Underwriting Agencies Limited - 2488']";
	public static final String InceptionDateIcon = "@xpath=//*[@ng-change='addDefaultExpiry()']";
	public static final String LineofBusinessDrpDown = "@xpath=//*[@ng-model='data.LineOfBusinessId']//preceding-sibling::span[1]";
	public static final String LineofBusinessDrpDownValue = "@xpath=//ul[@class='k-list k-reset']//*[text()='Property (D&F)']";
	public static final String UnderwriterDrpDown = "@xpath=//*[@ng-model='data.Underwriter']//preceding-sibling::span[1]";
	//public static final String UnderwriterDrpDownValue = "@xpath=//ul[@class='k-list k-reset']//*[text()='Abhi, Standard']";
	public static final String UnderwriterDrpDownValue = "@xpath=//div[@class='k-animation-container']//ul[@aria-hidden='false']//li[2]";
	public static final String TechnicianDrpDown = "@xpath=//*[contains(@ng-model,'data.Technician')]//preceding-sibling::span[1]";
	public static final String TechnicianDrpDownValue = "@xpath=//div[@class='k-animation-container']//ul[@aria-hidden='false']//li[2]";

	//public static final String TechnicianDrpDownValue = "@xpath=//preceding::span[text()='Technician'][1]//following::li[text()='Abhi, Standard'][2]";
	public static final String AddPolicytitle = "@xpath=//div[@ng-click='addFolder()']";
	public static final String Policytitle = "@xpath=//div[contains(@ng-if,'selectedFolder')]";
	public static final String PolicytitleOnCotractDetails = "@xpath=//*[contains(@class,'card-header')]/div[1]";
	public static final String ExpDtpop = "@xpath=//div[@class='modal-content']";
	public static final String ErrorPopUpOKbtn="@xpath=//*[@ng-click='ok()']";
	public static final String ExpiryDateIcon = "@xpath=//*[@ng-model='data.ExpiryDate']";

	//Locators for apply filter on policies
	public static final String PolicyLink = "@xpath=//a[text()='POLICIES']";
	public static final String PolicyReferenceFilterIcon = "@css=[data-field='PolicyRandomNumber'] span:nth-child(1)";
	public static final String SearchText = "@css=[placeholder='Search']";
	public static final String FilterButton = "@css=.k-button.k-primary";

	//Open Selected policy
	public static final String SelectedPolicy = "@css=tbody[role='rowgroup'] td:nth-child(1)";
	public static final String StatusFilterIcon = "@css=[data-title=Status] .k-icon.k-i-filter";
	public static final String SearchTxtBox = "@css=.k-textbox.k-space-right>input";
	public static final String DraftCheckbox = "@css=[value='Draft']";
	public static final String FilterLink ="@css=.k-button.k-primary";
	public static final String DraftFstRcrd ="@css=#grid tbody:nth-child(2) tr:nth-child(1)";
	public static final String ContactGreyStatus ="@css=.btn.btn-xs.btn-primary.btn-wide.waves-effect.waves-light.ng-binding.bgm-gray";
	public static final String CotractStsDropDown ="@css=.k-icon.k-i-arrow-60-down";
	public static final String Quote ="@css=.k-item.ng-scope:nth-child(1)";
	public static final String SaveBtn ="@xpath=//button[contains(text(),'Save')]";
	public static final String SaveBtn1 ="@xpath=//button[@ng-if='form.SignedContractChanged.$valid ']";
	public static final String SaveBtn3 ="@xpath=//button[@ng-if='form.isEndorsement || form.SignedContractChanged.$valid ']";
	public static final String SaveBtn4 ="@xpath=//button[contains(@ng-if,'form.SignedContractChanged.$valid ')]";
	public static final String DivisionDrpValue = "@xpath=//ul[@aria-hidden='false']/li[1]";

	//Change contract from Draft to Quote
	public static final String DraftBtn = "@buttonText=Draft";
	public static final String ContractStatusDD ="@xpath=//*[@ng-model='data.ContractVersions.Status']//preceding-sibling::span//span[@class='k-icon k-i-arrow-60-down']";
	public static final String ContractStatusQuoteValue ="@xpath=//li[contains(.,'Quote')]";

	//Change contract from Quote to Written
	public static final String QuoteBtn = "@buttonText=Quote";
	public static final String ContractStatusWrittenValue ="@xpath=//ul[@class='k-list k-reset']//*[text()='Written']";

	//Change contract from Written to Signed
	public static final String WrittenBtn = "@buttonText=Written";
	public static final String ContractStatusSignedValue ="@xpath=//ul[@class='k-list k-reset']//*[text()='Signed']";
	public static final String CannotChangeStatusToSignedValidation ="@xpath=//*[@class='ng-scope']/p[contains(text(),'You cannot change the status of the Contract to Signed')]";
	public static final String SectionMustRecordedValidation ="@xpath=//*[@class='ng-binding ng-scope'][contains(text(),'At least one Section must be recorded')]";
	public static final String CancelBtn ="@xpath=//*[@ng-click='cancel()']";
	public static final String AddSectionTab ="@css=.btn-primary.pointer.tab-hover.ng-scope>a";
	public static final String AddSectionPopup ="@xpath=//h2[text()='Add Section']";
	public static final String SectionReferenceTxt ="@model=data.SectionReference";
	public static final String SubDiviDrp ="@xpath=//select[@ng-model='data.SubDivisionId']//preceding-sibling::span[1]";
	public static final String SubDiviDrpval ="@xpath=//ul[@class='k-list k-reset']//li[2]";

	public static final String MarketSectionDescriptionTxt ="@model=data.MarketSectionDescription";
	public static final String ComissionTxt ="@model=data.Comission";
	public static final String AdditionalDeductionTxt ="@model=data.AdditionalDeduction";
	public static final String ClassOfBusinessDD ="@xpath=//*[@ng-model='data.ClassOfBusinessId']//preceding-sibling::span[1]//span[@class='k-icon k-i-arrow-60-down']";
	public static final String ClassOfBusinessFilter ="@xpath=//div[4][@class='k-animation-container']/div/span/input";
	public static final String PropertyRiskValue ="@xpath=//ul[@class='k-list k-reset']//li[text()='Property D&F (US binder)']";
	public static final String SectionCurrencyFilter ="@xpath=//div[5][@class='k-animation-container']/div/span/input";
	public static final String SectionCurrencyDD ="@xpath=//*[@ng-model='data.CurrencyId']//preceding-sibling::span[1]//span[@class='k-icon k-i-arrow-60-down']";
	public static final String SectionCurrencyValue ="@xpath=//ul[@class='k-list k-reset']//li[text()='INR - Indian Rupee']";
	public static final String EstimatedPermiumIncomeTxt ="@model=data.EstimatedPermiumIncome";
	public static final String GrossPermiumIncomeTxt ="@model=data.GPIncomeLimit";
	public static final String SectionCurrencyValue1 ="@xpath=//ul[@aria-hidden='false']//li[contains(.,'GBP - British Pound')]";
	public static final String MaximumLimitofLiabilityTxt ="@model=data.MaximumLimitofLiability";
	public static final String MarineLiabilityValue ="@xpath=//ul[@aria-hidden='false']//li[contains(.,'Marine Liability')]";

	public static final String GrossPermiumLimitTxt ="@model=data.GPILNotificationPercentage";
	public static final String ConductRiskRatingDD ="@xpath=//*[@ng-model='data.ConductRiskRatingId']//preceding-sibling::span[1]//span[@class='k-icon k-i-arrow-60-down']";
	public static final String ConductRiskRatingValue="@xpath=//ul//li[contains(.,'Low')]";
	public static final String sectionTab ="@xpath=//li[@ng-if='viewSectionTab']//a[contains(.,'Section 1')]";
	public static final String sectionTab2 ="@xpath=//li[@ng-if='viewSectionTab']//a[contains(.,'Section 2')]";

	public static final String sectionDetails ="@css=div.pmb-block.p-t-10.p-l-0.ng-scope";
	public static final String contractDetailsTab ="@xpath=//li[@ng-if='showEdit']/a[@data-ui-sref='app.contract.detailsparent.main']";
	public static final String ClaimsAuthorityTab ="@xpath=.//*[@data-ui-sref='app.contract.detailsparent.ClaimsAuthority']";
	public static final String BinderDrpValue = "@xpath=//*[@class='k-list k-reset']//*[text()='Binder']";
	public static final String OpenMarketValue = "@xpath=//*[@class='k-list k-reset']//*[text()='Open Market']";
	public static final String MarketsLeadInsurerMustValidation ="@xpath=//*[@class='ng-binding ng-scope'][contains(text(),'There must be a lead Insurer recorded in the Markets tab within the Automation section Section')]";
	public static final String RiskCodesEntriesMustValidation ="@xpath=//*[@class='ng-binding ng-scope'][contains(text(),'There must be at least one Risk Code within Section Automation section')]";
	public static final String ReportingChannelMustValidation ="@xpath=//*[@class='ng-binding ng-scope'][contains(text(),'There must be at least one Reporting Channel in the Contract')]";
	public static final String SignedPopupValidation ="@xpath=//div[@class='p-t-10 ng-scope']//p[contains(text(),'Once the Contract Status has been changed to Signed, then any further changes to the Contract will be recorded as an endorsement')]";
	public static final String sectionTab1 ="@xpath=//li[@ng-if='viewSectionTab']//a[contains(.,'Section 2')]";
	
	public static final String Underwriter ="@xpath=//dt[contains(.,'Underwriter')]";
	public static final String CompanyReferenceDetails ="@xpath=//dt[contains(.,'Company Section Reference')]";
	
	public static final String MarketsTab ="@xpath=//li[@ng-if='viewMarketsTab']";
	public static final String AddMarketButton ="@xpath=//div[@ng-click='add()']";
	public static final String ExistingMarketDetails ="@xpath=//td[contains(.,'Aspen Managing Agency Limited')]";
	public static final String ExistingMarketDetails1 ="@xpath=//td[contains(.,'Brit Syndicates Limited')]";
	public static final String InsurerDropdown ="@xpath=//*[@ng-model='data.DivisionId']//preceding-sibling::span[1]";
	public static final String InsurerSelectTextbox ="@css=input.k-textbox";
	public static final String InsurerDDValue ="@xpath=//ul[@aria-hidden='false']//li[1]";
	public static final String WrittenLinePercentTBox ="@model=data.WrittenLinePercent";
	public static final String SignedLinePercentTBox ="@model=data.SignedLinePercent";
	public static final String IsLeadYesRadioBtn = "@xpath=//dd[@class='p-t-10']//descendant::label[@class='radio radio-inline m-r-20'][1]";
	public static final String secondSectionPopUp ="@xpath=//h2[contains(.,'Signed Contract Change')]";
	public static final String ThirdSectionPopUp ="@xpath=//h2[contains(.,'Contract Settings Update')]";
	public static final String ConEndrsmntPopUp ="@xpath=//h2[contains(.,'Contract Endorsement')]";
	public static final String DatePicker ="@xpath=//input[@data-role='datepicker']";
	public static final String ExistingMarket ="@xpath=//tr[1][@ng-if='dataList.length']";

	public static final String RiskCodesTab ="@xpath=//li[@ng-if='viewRiskCode']";
	public static final String AddRiskCodeButton ="@xpath=//div[@ng-click='add()']";
	public static final String RiskCodeDropdown ="@xpath=//*[@ng-model='data.RiskCodeId']//preceding-sibling::span/span[2]";
	public static final String RiskCodeSelectTextbox ="@css=input.k-textbox";
	public static final String RiskCodeDDValue ="@xpath=//ul[@aria-hidden='false']//li[2]";
	public static final String SplitPercentTBox ="@model=data.SplitPercent";
	//public static final String RiskCodeSaveBtn ="@css=button.btn.btn-primary.p-lr-lg.save.ng-scope.waves-effect.waves-light";
	public static final String TypeDDValue_Premium ="@xpath=//ul[@aria-hidden='false']//li[text()='Premium']";
	public static final String TypeDDValue_Claim ="@xpath=//ul[@aria-hidden='false']//li[contains(.,'Claim')]";
	public static final String ConSettingPopUp ="@xpath=//h2[contains(.,'Contract Settings Update')]";


	public static final String ReportingChannelsTab ="@xpath=//li[@ng-if='IsBinder && viewReportingChannelsTab']/a[@data-ui-sref='app.contract.reportingChannelParent.reportingChannel']";
	public static final String AddReportingChannelBtn ="@xpath=//div[@ng-click='add()']";
	public static final String ChannelTypeDropdown ="@xpath=//form[@name='form.addEditData']/descendant::dl[1]/descendant::span[@class='k-icon k-i-arrow-60-down']";
	public static final String ChannelTypeDropdown1 ="@xpath=//div[@class='modal-content']//h2[text()='Add Reporting Channel']";
	public static final String ChannelTypeTextbox ="@xpath=//div[@class='k-list-container k-popup k-group k-reset k-state-border-up']/descendant::input[@class='k-textbox']";
	public static final String ChannelTypeDDValue ="@xpath=//ul[@class='k-list k-reset']//li[text()='Bordereaux']";
	public static final String TypeDropdown ="@xpath=//form[@name='form.addEditData']/descendant::dl[2]/descendant::span[@class='k-icon k-i-arrow-60-down']";
	public static final String TypeDDValueClaim ="@xpath=//ul[@class='k-list k-reset']//li[text()='Claim']";

	public static final String TypeTextbox ="@xpath=//div[@class='k-list-container k-popup k-group k-reset k-state-border-up']/descendant::input[@class='k-textbox']";
	public static final String TypeDDValue ="@xpath=//ul[@class='k-list k-reset']//li[text()='Risk']";

	public static final String FrequencyDropdown ="@xpath=//form[@name='form.addEditData']/descendant::dl[3]/descendant::span[@class='k-icon k-i-arrow-60-down']";
	public static final String FrequencyTextbox ="@xpath=//div[@class='k-list-container k-popup k-group k-reset k-state-border-up']/descendant::input[@class='k-textbox']";
	public static final String FrequencyDDValue ="@xpath=//ul[@class='k-list k-reset']//li[text()='Monthly']";
	public static final String ReportingChannelIdTBox ="@model=data.ReportingChannelIdentifier";
	public static final String TypeDDValuePrem ="@xpath=//ul[@class='k-list k-reset']//li[text()='Premium']";

	//public static final String ReportingChannelSaveBtn ="@css=button.btn.btn-primary.p-lr-lg.save.ng-scope.waves-effect.waves-light";
	public static final String DueDaysTxt ="@model=data.DueDays";
	public static final String NumberExpectedTxt ="@model=data.NumberExpected";


	//Check version status is set to singed
	public static final String VersionTab ="@xpath=//*[@id='content']//li//a[contains(.,'Versions')]";
	public static final String VerifySignedVerion ="@xpath=//*[@id='grid']//table//td//span[contains(.,'Signed')]";

	//Edit reporting channel
	public static final String EditBtn ="@xpath=//*[@id='grid']//tr[2]//button[@ng-click='details(dataItem)']";
	public static final String EditBtn1 ="@xpath=//*[@id='grid']//tr[1]//button[@ng-click='details(dataItem)']";

	public static final String EditReportingChannelPopup ="@css=.font-bold.lead.p-l-30.ng-binding";

	//Delete reporting channel
	public static final String EditedChannel ="@xpath=//td[contains(.,'risk')]//preceding::td/div[@ng-click='details(dataItem)']";
	public static final String ReportingChannelRecord ="@xpath=//div[@id='grid']/descendant::table[@role='grid']/descendant::td[text()='Bordereaux']";
	public static final String BordereauxTab ="@xpath=//li[@ng-if='IsBinder && IsBordereauTabDisplay']";
	public static final String Processingtab = "@xpath=.//*[@data-ui-sref='app.contract.bordereauxParent.bordereauxTabs({BordereauxTypeEnum: 2})']";

	public static final String SignedBtn = "@buttonText=Signed";

	//Policy Number filter
	public static final String PolicyNumberFilter ="@xpath=//th[@data-field='FolderRandomNumber']/a[1]/span";
	public static final String RuleTypeFilter ="@xpath=//th[@data-title='Rule Type']//span[@class='k-icon k-i-filter']";
	public static final String SearchByTextFilter ="@xpath=//input[@placeholder='Search']";

	public static final String FilterBtn ="@buttonText=Filter";
	public static final String SelectBtn ="@buttonText=Select".trim();
	public static final String SelectPolicy ="@xpath=//td[@role='gridcell'][2]";

	//Add file
	public static final String FilesTab ="@xpath=//*[@id='content']//li//a[contains(.,'Files')]";
	public static final String AddFileBtn ="@xpath=//*[@id='profile-main']//ui-view//div[@ng-click='addEditData()']";
	public static final String FileTypeDD ="@xpath=//*[@ng-model='data.FileType']//preceding-sibling::span[1]";
	public static final String CoverHolderValue ="@xpath=//ul//li[contains(.,'Coverholder CV')]";
	public static final String FileTitleTxt ="@model=data.FileName";
	public static final String VerifyAddedFile ="@xpath=//*[@id='grid']//tbody//td[contains(.,'Endorsement')]";
	public static final String AddFileRefresh ="@xpath=//*[@id='grid']//a[@title='Refresh']";
	public static final String Filetype="@xpath=//table//th[1]"; 
	public static final String Filename="@xpath=//table//th[2]"; 
	public static final String FileTitle="@xpath=//table//th[3]"; 
	public static final String DateTimeUploaded="@xpath=//table//th[4]"; 
	//Add Edit Delete Interest 
	//Add
	public static final String InterestsTab ="@xpath=//li//a[contains(.,'Interests')]";
	public static final String AddIntrestBtn ="@xpath=//*[@ng-click='addInterest()']";
	public static final String AddInterestPopup ="@css=.font-bold.lead.p-l-30.ng-binding";
	public static final String SelectInterestDD ="@xpath=//*[@ng-model='data.InterestPerilId']//preceding-sibling::span[1]";
	public static final String BuildingsValue ="@xpath=//ul/li[contains(.,'Buildings')]";
	public static final String VerifyAddedInterest ="@xpath=//*[@ng-click='InterestDetails(data)'][contains(.,'Buildings')]";
	//Edit
	public static final String ContentsValue ="@xpath=//ul/li[contains(.,'Contents')]";
	public static final String SaveChangesBtn ="@xpath=//button[contains(text(),'Save Changes')]";
	public static final String VerifyEditedIntrest ="@xpath=//*[@ng-click='InterestDetails(data)'][contains(.,'Contents')]";
	//Delete
	public static final String DeleteBtn ="@xpath=//button[contains(text(),'Delete')]";
	public static final String YesDeleteBtn ="@xpath=//button[contains(.,'Yes, Delete it!')]";

	//Add Edit Delete Perils
	//Add
	public static final String PerilsTab ="@xpath=//li//a[contains(.,'Perils')]";
	public static final String AddPerilsBtn ="@xpath=//*[@ng-click='addPeril()']";
	public static final String AddPerilsPopup ="@css=.font-bold.lead.p-l-30.ng-binding";
	public static final String SelectPerilsDD ="@xpath=//*[@ng-model='data.InterestPerilId']//preceding-sibling::span[1]";
	public static final String EarthquakeValue ="@xpath=//ul/li[contains(.,'Earthquake')]";
	public static final String VerifyAddedPerils ="@xpath=//*[@ng-click='PerilDetails(data)'][contains(.,'Earthquake')]";
	//Edit
	public static final String FireValue ="@xpath=//ul/li[contains(.,'Fire')]";
	public static final String VerifyEditedPerils ="@xpath=//*[@ng-click='PerilDetails(data)'][contains(.,'Fire')]";

	//Add Edit Delete Limit
	//Add
	public static final String LimitTab ="@xpath=//li//a[contains(.,'Modelling')]";
	public static final String AddLimitBtn ="@xpath=//*[@ng-click='add()']";
	public static final String AddLimitPopup ="@css=.font-bold.lead.p-l-30.ng-binding";
	public static final String LimitNameTxt ="@model=data.Limit.LimitName";	
	public static final String LimitBasisDD ="@xpath=//*[@ng-model='data.Limit.LimitBasic']//preceding-sibling::span[1]";
	public static final String AnyOneEventValue ="@xpath=//ul/li[contains(.,'Any One Event')]";
	public static final String LimitCurrencyDD ="@xpath=//*[@ng-model='data.Limit.LimitCurrency']//preceding-sibling::span[1]";
	public static final String INRValue ="@xpath=//ul/li[contains(.,'INR - Indian Rupee')]";
	public static final String LimitTxt ="@model=data.Limit.LimitAmount";	
	public static final String ExcessTxt ="@model=data.Limit.ExcessAmount";	
	public static final String DeductibleTxt ="@model=data.Limit.DeductibleAmount";	
	public static final String DeductibleTypeDD ="@xpath=//*[@ng-model='data.Limit.DeductibleType']//preceding-sibling::span[1]";
	public static final String AmountValue ="@xpath=//ul/li[contains(.,'Amount')]";
	public static final String VerifyAddedLimit ="@xpath=//*[@ng-click='edit(data)'][contains(.,'Amount')]";

	//Edit
	public static final String PercentageValue ="@xpath=//ul/li[contains(.,'Percentage')]";
	public static final String VerifyEditedLimit ="@xpath=//*[@ng-click='edit(data)'][contains(.,'Percentage')]";

	//Add Edit Delete Rule
	//Add
	//public static final String RulesTab ="@xpath=//*[@id='profile-main']//li//a[contains(.,'Rules')]";
	public static final String SectionRulesTab ="@xpath=//*li[@ng-if='viewRulsTab']//a[contains(.,'Rules')]"; 
	public static final String RulesTabHeader3 ="@xpath=//th[3][@data-title='Rule Name']";
	public static final String RulesTabHeader4 ="@xpath=//th[4][@data-title='Schema']";
	public static final String RulesTabHeader5 ="@xpath=//th[5][@data-title='Rule Condition']";
	public static final String RulesTabHeader6 ="@xpath=//th[6][@data-title='Rule Breaches']";
	public static final String RulesTabHeader7 ="@xpath=//th[7][@data-title='Status']";
	public static final String RulesTabHeader8 ="@xpath=//th[8][@data-title='Created By']";
	public static final String RulesTabHeader9 ="@xpath=//th[9][@data-title='Created Date']";
	public static final String AddRuleButton ="@xpath=//button[contains(.,'Rule')]";
	public static final String RulesTab ="@xpath=//*[@id='content']//li//a[contains(.,'Rules')]";
	public static final String AddRulesBtn ="@xpath=//*[@id='nocard']//button[@ng-click='addData(w)']";
	public static final String EditRulesBtn ="@xpath=.//*[@ng-click='editClick(1)']";
	public static final String RulesGeneralTab ="@xpath=.//*[@data-ui-sref='app.contract.rulesList.general']";
	public static final String EditRulebtn ="@xpath=//*[@class='dropdown-toggle']";
	public static final String EditRulebtn1 ="@xpath=//div[@ng-click='editClick(1)']";
	
	public static final String AddRulesPopup ="@css=.font-bold.lead.p-l-30.ng-binding"; 
	public static final String RuleNameTxt ="@model=data.Rules.RuleName";
	public static final String EditCondition ="@xpath=.//button[@ng-if='!w.$edit']//i[@class='zmdi zmdi-edit']";
	public static final String DatasetTypeDD ="@xpath=//*[@ng-model='data.Rules.DatasetType']//preceding-sibling::span[1]";
	public static final String RiskValue ="@xpath=//ul/li[text()='Risk']";
	public static final String ApplicableSecDD ="@xpath=//*[@ng-model='data.SelectedContractSection']//preceding-sibling::div[1]";
	public static final String ApplicableSecVal ="@xpath=//ul/li[contains(.,'Automation (Indian Rupee)')]";
	public static final String ApplicationConditionDD ="@xpath=//*[@k-ng-model='data.Rules.IsRuleValid']//preceding-sibling::span[1]";
	public static final String ConditionMetValue ="@xpath=//ul/li[contains(.,'Data is valid if the rule conditions are met')]";
	public static final String ConditionNotMetValue ="@xpath=//ul/li[contains(.,'Data is not valid if the rule conditions are met')]";

	public static final String CurrencyDD ="@xpath=//*[@ng-model='data.Rules.Currency']//preceding-sibling::span[1]";
	public static final String CurrencyINRValue ="@xpath=//ul/li[contains(.,'INR')]";
	public static final String ROEToleranceTxt ="@model=data.Rules.ROETolerance";
	public static final String AddRuleConditionBtn ="@xpath=//button[contains(.,'ADD RULE CONDITION')]";
	public static final String FieldNameDD ="@xpath=//*[@ng-model='w.FieldId']//preceding-sibling::span[1]";
	public static final String YOAValue ="@xpath=//ul/li[contains(.,'Number of Stories')]";
	public static final String GrossPreVal ="@xpath=//ul/li[text()='Gross Premium']";
	//public static final String GrossPreVal ="@xpath=//ul/li[contains(.,'Gross Premium')][@data-offset-index='121']";
	//public static final String RiskCountryVal ="@xpath=//ul/li[contains(.,'Risk Country')][@data-offset-index='73']";
	public static final String RiskCountryVal ="@xpath=//ul/li[contains(.,'Risk Country')]";
	public static final String NoOfStoriesVal ="@xpath=//ul/li[text()='Number of Stories']";
	public static final String LocSprinklrVal ="@xpath=//ul/li[text()='Sprinklers (Y/N)']";
	public static final String RiskCurrencyVal ="@xpath=//ul/li[text()='Risk Currency']";

	
	public static final String OperatorDD ="@xpath=//*[@ng-model='w.Operator']//preceding-sibling::span[1]";
	public static final String EqualToValue ="@xpath=//ul/li[text()='Equal To']";
	public static final String NotEqualToValue ="@xpath=//ul/li[text()='Not Equal To']";
	public static final String AppliedToDD ="@xpath=//*[@ng-model='w.AppliedTo']//preceding-sibling::span[1]";
	//public static final String Value ="@xpath=//ul/li[(text()='Value')]";
	public static final String Value ="@xpath=//li[(text()='Value')]";
	public static final String RemoveSection ="@xpath=//dt//span[contains(.,'Applicable Section')]//following::input[1]//following::span[1]";
	public static final String ApplicableSection ="@xpath=//dt//span[contains(.,'Applicable Section')]//following::input[1]";
	public static final String ApplicableSectionvalue ="@xpath=//ul[@class='k-list k-reset']//li[contains(.,'Automation')]";
	public static final String EntryOrSelectionTxt ="@model=w.EntryValueFrom";
	public static final String EntryOrSelectionDD ="@xpath=//*[@ng-model='w.EntryValueFrom']//preceding-sibling::span/span[2]";
	public static final String EntryOrSelectionValue ="@xpath=//ul[@class='k-list k-reset']//li[text()='No']";
	public static final String EntryOrSelectionValueYes ="@xpath=//ul[@class='k-list k-reset']//li[text()='Yes']";

	public static final String EntryOrSelectionValueUS ="@xpath=//ul[@class='k-list k-reset']//li[text()='United States']";
	public static final String EntryOrSelectionValueUK ="@xpath=//ul[@class='k-list k-reset']//li[text()='United Kingdom']";

	public static final String CheckBtn ="@xpath=//button[@ng-if='w.$edit'][1]";
	public static final String SaveBtn2 ="@xpath=//button[2][contains(text(),'Save')]";
	public static final String RulesMenuTab ="@xpath=//*[@id='content']//li//a[contains(.,'Rules')]";
	public static final String PerilsMenuTab ="@xpath=//*[@id='content']//li//a[contains(.,'Peril')]";
	public static final String ModelingMenuTab ="@xpath=//*[@id='content']//li//a[contains(.,'Modeling')]";

	//Edit
	public static final String EditRuleBtn ="@xpath=//*[text()='AutoRule171101161056']//preceding-sibling::td/div";
	public static final String MethodDD ="@xpath=//*[@ng-model='w.Method']//preceding-sibling::span[1]";
	public static final String AndValue ="@xpath=//ul/li[(text()='And')]";
	public static final String TransactionTypeValue ="@xpath=//ul/li[contains(.,'Sprinklers (Y/N)')]";

	//Delete
	public static final String RuleDeleteBtn ="@xpath=//button[contains(@ng-click,'deleteRulesCondition')]//preceding::tr//div//button[contains(@ng-click,'deleteRulesCondition')]";
	public static final String RuleDeleteBtn1 ="@xpath=//button[contains(@ng-click,'deleteRulesCondition')]";
	public static final String DeleteRule ="@xpath=//*[text()='"+Rule1+"']//preceding-sibling::td/div";
	public static final String YesChangeItBtn ="@xpath=//button[contains(.,'change it!')]";
	//VerifyReportingChannel
	public static final String ExpectedTab ="@xpath=//ul[@class='tab-nav tab-hover']//li//a[contains(.,'Expected')]";

	//SectionEdit
	public static final String ThreeDots ="@xpath=//ul[@class='actions hidden-xs']//a[@class='dropdown-toggle']";
	public static final String EditOption ="@xpath=//ul[@class='actions hidden-xs']//a[contains(.,'Edit')]";
	public static final String EditSectionPopup ="@xpath=//h2[text()='Edit Section']";
	public static final String SectionCurrencyDKKValue ="@xpath=//ul[@class='k-list k-reset']//li[text()='DKK - Danish Krone']";
	public static final String VerifyEditedSection ="@xpath=//dd[contains(.,'DKK - Danish Krone')]";

	//SectionReferanceEdit
	public static final String ThreeDotsRef ="@xpath=//ul[@class='actions hidden-xs ng-scope']//a[@class='dropdown-toggle']";
	public static final String EditOptionRef ="@xpath=//ul[@class='actions hidden-xs ng-scope']//a[contains(.,'Edit')]";
	public static final String VerifyEditedRefSection ="@xpath=//dd[contains(.,'Test edit')]";

	//Edit General And Location In Contract Rules
	public static final String MainRule ="@xpath=//*[@id='content']//a[text()='Rules']";
	public static final String GeneralTab ="@xpath=//a[contains(.,'General')]";
	public static final String EditDot ="@xpath=//*[@id='nocard']//ul[contains(@class,'actions hidden')]//li[@class='dropdown']/a";
	public static final String PolicyEditDot ="@xpath=//ul[@ng-if='Permission.Edit || Permission.view || PermissionContractMainCompanyReference.Edit || PermissionContract.Add']";
	public static final String GeneralEdit ="@xpath=//*[@id='nocard']//li//a[@ng-click='edit()']";
	public static final String GPILimitTxt ="@model=data.GPIncomeLimit";
	public static final String GPILimitNotificationPercentageTxt ="@model=data.GPILNotificationPercentage";
	public static final String TypicalPolicyPeriodMonths = "@xpath=//*[@id='nocard']//input[@ng-model='data.TypicalPolicyPeriodMonths']";
	public static final String MaxPolicyPeriodMonthsTxt = "@xpath=//*[@id='nocard']//input[@ng-model='data.MaxFolderPeriodMonths']";
	public static final String DaysPolicyIssuedTxt =  "@xpath=//*[@id='nocard']//input[@ng-model='data.DaysFolderIssued']";
	public static final String SettlementDueDaysTxt = "@xpath=//*[@id='nocard']//input[@ng-model='data.SettelementDueDays']";
	public static final String LocationTab ="@xpath=//a[contains(.,'Location')]";
	//public static final String EditLocationBtn ="@xpath=//button[@ng-click='edit()']";
	public static final String EditDotsLocation ="@xpath=//*[@id='profile-main']//div[@ng-disabled='loading1']//a[@class='dropdown-toggle']";
	public static final String EditLocationBtn ="@xpath=//*[@id='profile-main']//div[2]//ul[contains(@class,'actions hidden')]//a[text()='Edit']";
	public static final String NorthAmericaExpandArrow ="@xpath=//*[text()='North America']//preceding-sibling::span";
	public static final String UnitedStatesChk ="@xpath=//*[@id='grid']//td[contains(.,'United States')]//preceding-sibling::input";
	public static final String BreachesTab ="@xpath=//a[contains(.,'Breaches')]";
	public static final String RulesDD ="@xpath=//*[@ng-model='SelectedRuleId']//preceding-sibling::span[1]";
	public static final String RulesValues ="@xpath=//ul[@aria-hidden='false']//li";
	public static final String RecordCont4 ="@xpath=.//*[@id='grid']//span[text()='1 - 4 of 4 items']";
	public static final String RecordCont2 ="@xpath=.//*[@id='grid']//span[text()='1 - 2 of 2 items']";
	public static final String RecordCont3 ="@xpath=.//*[@id='grid']//span[text()='1 - 3 of 3 items']";

	
	public static final String ProcessAsCorrectionBtn ="@xpath=//button[contains(@ng-click,'CorrectionBordereaux()')]";

	public static final String BespokeTab ="@xpath=//*[@id='nocard']//li//a[text()='Bespoke']";
	public static final String AddRuleDownArrow ="@xpath=//*[@id='nocard']//button[@ng-click='addData(w)']";
	public static final String ContractOption ="@xpath=//*[@id='nocard']//a[text()='Contract']";
	public static final String CurrencyGBPValue ="@xpath=//ul/li[contains(.,'GBP')]";
	public static final String CurrencyUSDValue ="@xpath=//ul/li[contains(.,'USD')]";
	public static final String CurrencyGBPValue1 ="@xpath=//ul/li[contains(.,'GBP')]";
	public static final String GreaterThan ="@xpath=//ul/li[text()='Greater Than']";
	public static final String LessThan ="@xpath=//ul/li[text()='Less Than']";
	public static final String ConditionMetValue1 ="@xpath=//ul/li[contains(.,'Data is not valid if the rule conditions are met')]";
	public static final String FrApprovalbtn ="@xpath=//*[@id='grid']//button[@ng-click='GoToBordereauSummaryScreen(dataItem, false)']";
	public static final String RulesDDValues ="@xpath=//ul/li[contains(.,'Test')]";
	public static final String EditBespokeRuleBtn ="@xpath=//*[@id='grid']//td/div[contains(.,'Edit')]";
	public static final String BreachesCount ="@xpath=//*[@id='grid']//button[contains(@ng-click,'getRulesBreach')]";
	public static final String InformationOption ="@xpath=//*[@id='nocard']//a[text()='Information']";
	public static final String ErrorMessageTxt ="@model=data.Rules.ErrorMessage";
	public static final String PremiumValue ="@xpath=//ul/li[text()='Premium']";
	public static final String SchemaDD ="@xpath=//*[@ng-model='data.Rules.SchemaId']//preceding-sibling::span[1]";
	public static final String SchemaValue ="@xpath=//ul/li[contains(.,'Testing Schema - Premium')]";
	public static final String GrossPremiumValue ="@xpath=//ul/li[text()='Gross Premium']";
	public static final String NetPremiumValue ="@xpath=//ul/li[text()='Net Premium']";
	public static final String SubmitBordereauxDownArrow ="@xpath=//*[@id='profile-main']//div[@ng-if='!isProcessingDisabled']";
	public static final String RiskOption ="@xpath=//a[text()='Risk']";
	public static final String SupplementaryFilesLbl ="@xpath=//span[contains(.,'Supplementary Files')]";
	public static final String SupplementaryAddFileBtn ="@xpath=//div[@ng-click='addEditData()']";
	public static final String AddFilePopUp ="@xpath=//h2[contains(.,'Add File')]";
	public static final String OverdueBtn ="@xpath=//tr[3]/td/button[contains(.,'Overdue')]";

	public static final String AddFilePopUp1 ="@xpath=//*[@ng-click='addEditData()']";
	public static final String Supplementary1 ="@xpath=//*[@id='grid']//button[contains(.,'1')]";
	public static final String EndorsementFile ="@xpath=//*[@id='grid']//td[1]";
	public static final String OkBtn ="@xpath=//*[@ng-click='ok()']";

	public static final String DataTab ="@xpath=//*[@id='content']//a[contains(.,'Data')]";
	//public static final String RiskInceptionDateCount ="@xpath=//*[@id='RiskInceptionDate']//following::td[contains(@ng-click,'RiskInceptionDate')][text()='01/01/2017']";
	//public static final String RiskExpiryDate ="@xpath=//*[@id='RiskExpiryDate']//following::td[contains(@ng-click,'RiskExpiryDate')][text()='31/12/2017']";
	public static final String NoBtn ="@xpath=//button[contains(.,'No')]";
	public static final String GeneralTabError="@xpath=//div[@role='alert']";
	public static final String ContractCurrencyDrpDownValue1 = "@xpath=//ul[@class='k-list k-reset']//*[text()='USD - United States Dollar']";
	public static final String ContractCurrencyDrpDownValue2 = "@xpath=//ul[@class='k-list k-reset']//*[text()='INR - Indian Rupee']";

	
	//Contract Role Edit_TC
	public static final String Roletab="@xpath=//a[text()='Roles']";
	public static final String CompanyRole ="@xpath=//div[@class='table-responsive ng-scope']//tr[1]/td[3]";
	public static final String ContractAdministratorPopup ="@xpath=//h2[contains(.,'Contract Contract Administrator')]";
	public static final String CompanyAdministratoropdwn ="@xpath=//*[@ng-model='form.dataId']//preceding-sibling::span[1]";
	public static final String CompanyAdministratoroddvalue ="@xpath=//ul/li[contains(.,'Alwen Hough Johnson Ltd - TBC')]";
	public static final String SaveCompany ="@xpath=//*[@ng-click='save()']";
	public static final String SignedContractChange ="@xpath=//h2[contains(.,'Signed Contract Change')]";
	public static final String SaveCompanyContract ="@xpath=//*[@class='btn btn-primary p-lr-lg save ng-scope']";

	//Locators for TC_4034 - Contract - Claim Authority - Edit
	public static final String ClaimAuthorityTab ="@xpath=//a[contains(.,'Claims Authority')]";
	public static final String EditClaimAuthorityTab ="@xpath=//*[@ng-if='Permission.Edit']/li[1]";
	public static final String EditClaimAuthorityBtn ="@xpath=//*[@ng-click='openEditPopup()']";
	public static final String VerifyAddClaimsAuthority ="@xpath=//h2[contains(.,'Add Claims Authority')]";
	public static final String ClaimAuthoritydropdwn ="@xpath=//*[@ng-model='data.ClaimsAuthorityId']//preceding-sibling::span[1]";
	public static final String ClaimAuthorityddvalue ="@xpath=//ul/li[contains(.,'Antares Managing Agency Limited - 1274')]";
	public static final String ClaimAuthorityCurrencydropdwn ="@xpath=//*[@ng-model='data.CurrencyId']//preceding-sibling::span[1]";
	public static final String ClaimAuthorityCurrencyddvalue ="@xpath=//ul/li[contains(.,'GBP')]";
	public static final String ClaimsAuthorityLimit ="@xpath=//*[@ng-model='data.ClaimsAuthorityLimit']";
	public static final String ClaimsAuthoritySavechanges ="@xpath=//*[@ng-if='!editPage']";
	public static final String ClaimsAuthorityEndorsementSavechanges ="@xpath=//button[@ng-click='save()'][@ng-if='form.isEndorsement || form.SignedContractChanged.$valid ']";
	
	public static final String ClaimsAuthorityCancelchanges ="@xpath=//div[@class='m-t-md pull-right']/button[1]";
	public static final String VerifyClaimsAuthority ="@xpath=.//div[@class='pmbb-view col-md-11']//dl[1]//a";
	public static final String VerifyClaimsAuthorityLimit ="@xpath=.//div[@class='pmbb-view col-md-11']//dl[2]//a";	

	// Contract Cover holder - Add/ Edit -3801
	public static final String Coverholdertab="@xpath=//*[text()='Coverholders']";
	public static final String AddCoverholderBtn="@xpath=//div[@ng-click='addEditData()']";
	public static final String VerifyAddCoverholder="@xpath=//h2[text()='Add Coverholder']";
	public static final String coverholderdropdwn ="@xpath=//*[@ng-model='data.CoverholderId']//preceding-sibling::span[1]";
	public static final String coverholderddValue ="@xpath=//ul/li[contains(.,'Coverholder Inc - New York')]";
	public static final String coverholderddValue2 ="@xpath=//ul/li[contains(.,'Brit Insurance Services USA Inc - 111885TNW')]";
	public static final String CoverholderContactdropdwn ="@xpath=//*[@ng-model='data.CoverHolderContactId']//preceding-sibling::span[1]";
	public static final String CoverholderContactddvalue ="@xpath=//ul/li[contains(.,'tester standard User')]";
	public static final String PrimarycoverholderYes ="@xpath=//label[@class='checkbox checkbox-inline m-r-20'][1]";
	public static final String PrimarycoverholderNo ="@xpath=//label[@class='checkbox checkbox-inline m-r-20'][2]";
	public static final String coverholderSave ="@xpath=//*[@ng-click='save()']";

	public static final String EditCoverholder ="@xpath=//div[@ng-click='addEditData(dataItem)']";
	public static final String EditCoverholder2 ="@xpath=//*[@id='grid']/div[2]/table/tbody/tr[2]/td[1]/div/i";
	public static final String EditCoverholderPopup ="@xpath=//h2[contains(.,'Edit Coverholder')]";
	public static final String EditCoverholderContactdropdwn ="@xpath=//*[@ng-model='data.CoverHolderContactId']//preceding-sibling::span[1]";
	public static final String EditCoverholderContactddvalue ="@xpath=//ul/li[contains(.,'Company Admin Madhuri')]";
	public static final String SaveChangesCoverholder ="@xpath=//*[@ng-click='save()']";
	public static final String SignedStatusPopup ="@xpath=//div[@class='p-t-10 ng-scope']";
	public static final String SignedPopupSaveButton ="@xpath=//button[2][@ng-click='save()'][@ng-if='form.SignedContractChanged.$valid ']";
	//*[@ng-model='data.Note.Description']
	public static final String ContractSettingsNotes ="@xpath=//*[@ng-model='data.Note.Description']";
	
	//Contract Link -TC3804
	public static final String ContractLink="@xpath=//*[@ng-click='openContractLinkPopup(data)']";
	public static final String ContractLinkpopup="@xpath=//h2[contains(.,'Contract Link(s)')]";
	public static final String ParentContractdropdwn ="@xpath=//*[@ng-model='data.ParentContractId']//preceding-sibling::span[1]";
	public static final String ParentContractddvalue ="@xpath=//ul/li[contains(.,'714016WU17 - Automation Policy001814171219 (Allstar Underwriters - retyry)')]";

	public static final String Saveparent = "@xpath=//*[@ng-click='save()']";

	//Locators for TC_4041 -  Edit company specific tab 
	public static final String CompanySpecificTab ="@xpath=//a[contains(.,'Company Specific')]";
	public static final String ContractMetaDataField ="@xpath=//dt[contains(.,'Automation_Contract_Metadata')]";
	public static final String EditCompanySpecificTab ="@xpath=//*[@ng-if='Permission.Edit']/li[1]";
	public static final String EditCompanySpecificBtn ="@xpath=//*[@ng-click='edit()']";
	public static final String underwritingtab ="@xpath=//h4[contains(.,'Underwriting')]";
	public static final String Editfield1 ="@xpath=//h4[contains(.,'Underwriting')]/../dl[1]//input";
	public static final String Editfield2 ="@xpath=//h4[contains(.,'Underwriting')]/../dl[2]//input";
	public static final String Editfield3 ="@xpath=//h4[contains(.,'Underwriting')]/../dl[3]//input";
	public static final String SaveEditChanges ="@xpath=//*[@ng-click='save()']";
	public static final String ErrorMsg ="@xpath=//*[@ng-if='hasError']//div";

	//Locators for TC_4042 -  Edit Additional tab for a contract
	public static final String AdditionalTab ="@xpath=//a[contains(.,'Additional')]";
	public static final String EditAdditionalTab ="@xpath=//*[@ng-if='Permission.Edit']/li[1]";
	public static final String EditAddtionalBtn ="@xpath=//*[@ng-click='edit()']";
	public static final String ManagedBydropdwn ="@xpath=//*[@ng-model='data.FieldValue']//preceding-sibling::span[1]";
	public static final String ManagedByddvalue ="@xpath=//ul/li[contains(.,'Property & Casualty')]";
	public static final String VerifyUnderwriting = "@xpath=//h4[contains(.,'Underwriting')]";
	public static final String EditAutomationfield ="@xpath=//h4[contains(.,'Underwriting')]/..//input";
	public static final String VerifyClaim = "@xpath=//div//h4[contains(.,'Claims')]";
	public static final String EditClaimAuthorityLimit ="@xpath=//div//h4[contains(.,'Claims')]/..//input";
	public static final String SaveAdditionalChanges ="@xpath=//*[@ng-click='save()']";

	public static final String BrokerageDD ="@xpath=//*[@ng-model='data.Brokerage']";
	public static final String VerifyEditedBrokerageSection ="@xpath=//dt[contains(.,'Brokerage')]/..//dd";
	public static final String Savebtn ="@xpath=//*[@ng-click='save()']";
	public static final String ContractStatusPopUp ="@xpath=//h2[contains(.,'Contract Status')]";

	//======================================Sprint 5 locators=============================
	public static final String AddRulebtnCon ="@xpath=//*[@ng-click='addData(w)']";
	public static final String Sub_DivisionDD ="@xpath=//*[@ng-model='data.SubDivisionId']//preceding-sibling::span[1]//span[@class='k-icon k-i-arrow-60-down']";
	public static final String Sub_DivisionDD_Value ="@xpath=//ul[@class='k-list k-reset']//li[text()='Property']";
	public static final String MaximumLimitOfLiability ="@xpath=//*[@ng-model='data.MaximumLimitofLiability']";
	public static final String EstimatedPremiumIncome ="@xpath=//*[@ng-model='data.EstimatedPermiumIncome']";
	public static final String ConSettUpdate = "@xpath=//button[@ng-if='form.SignedContractChanged.$valid ']";

	//Sprint 5 locators
	public static final String FirstYesRadioBtn = "@xpath=//label[1]//*[@ng-model='form.isEndorsement']";
	public static final String FirstNoRadioBtn = "@xpath=//label[2]//*[@ng-model='form.isEndorsement']";
	public static final String FirstEnterText = "@xpath=//*[@name='form.SignedContractChanged']//div[3]//*[@ng-model='n.Description']";
	public static final String SaveFirstYesRadioBtn = "@xpath=//*[@ng-click='save()']";
	public static final String YesRadioBtn = "@xpath=//*[@name='form.SignedContractChanged']//dl[@class='dl-horizontal']//descendant::label[@class='radio radio-inline m-r-20'][1]";
	public static final String SaveEditedMarket = "@xpath=//*[@ng-click='edit()']";
	public static final String InsurerDDValue2 = "@xpath=//ul[@aria-hidden='false']//li[2]";
	public static final String ApplicableSectionDD = "@xpath=//*[@ng-model='data.SelectedContractSection']//preceding-sibling::div[1]";
	public static final String ApplicableSectionValue = "@xpath=//ul/li[contains(.,'Test Secti (British Pound)')]";
	public static final String NotBetween = "@xpath=//ul/li[text()='Not Between']";
	public static final String EntryOrSelectionTxt2 = "@model=w.EntryValueTo";
	public static final String SecondRuleSectionPopUp = "@xpath=//h2[contains(.,'Contract Endorsement')]";
	public static final String PopUpSaveBtn = "@xpath=//*[@ng-click='save()']";
	public static final String SignContractChangePopUp = "@xpath=//h2[contains(.,'Signed Contract Change')]";
	public static final String firstYesBtn ="@xpath=//*[@name='form.SignedContractChanged']//dl[@class='dl-horizontal ng-scope']//descendant::label[@class='radio radio-inline m-r-20'][1]";
	
	// Edit Risk Code
	public static final String Edit1stRiskCode = "@xpath=//*[@ng-click='edit(data)']//td[1]";
	public static final String SaveEditedChanges = "@xpath=//*[@ng-click='edit()']";
	public static final String VerifyEditedvalue = "@xpath=//*[@ng-click='edit(data)']//td[3]";
	public static final String VerifyEditRiskCodePopup = "@xpath=//h2[text()='Edit Risk Code']";
	public static final String DeleteRiskCode = "@xpath=//*[@ng-click='deleteCall(data)']";
	public static final String ConfirmDeleteRiskCode = "@xpath=//*[@ng-click='deleteSectionRiskCode()']";

	public static final String AddNoteIForClaim ="@xpath=//*[@ng-model='data.Note.Description']";
	public static final String SecondContractUpdatePopUp ="@xpath=//h2[contains(.,'Contract Settings Update')]";
	public static final String secondContractEndorsementPopUp ="@xpath=//h2[contains(.,'Contract Endorsement')]";

	public static final String SecondDraftEndoresmentPopUp ="@xpath=//h2[text()='Contract Endorsement']";
	public static final String SecondPopUpYesBtn ="@xpath= //*[@name='endorsement'][@ng-value='true']";
	public static final String SecondPopUpSaveBtn ="@xpath=//form[@name='form.SignedContractChanged']//div//div[2]//button[2]";
	public static final String TechnicianDrpDownValue1 = "@xpath=//div[@class='k-animation-container']//ul[@aria-hidden='false']//li[1]";
	
	//public static final String Processingtab = "@xpath=.//*[@data-ui-sref='app.contract.bordereauxParent.bordereauxTabs({BordereauxTypeEnum: 2})']";
	public static final String section2Tab ="@xpath=//li[@ng-if='viewSectionTab']//a[contains(.,'Section 2')]";
	public static final String RuleTabOnSection="@xpath=//*[@ng-if='viewRulsTab'][contains(.,'Rules')]";
	
	public static final String MethodNameDD ="@xpath=//*[@ng-model='w.Method']//preceding-sibling::span[1]";
	public static final String MethodValue ="@xpath=//ul/li[text()='And']";
	public static final String RulesDDValue ="@xpath=//*[@ng-model='SelectedRuleId']//ancestor::body/div[last()]//ul//li[contains(.,'Number of stories and Sprinklers(Y/N)')]";
	public static final String RulesDDValue1 ="@xpath=//*[@ng-model='SelectedRuleId']//ancestor::body/div[last()]//ul//li[contains(.,'Gross Premium less than 400 is valid')]";
	public static final String RulesDDValue2 ="@xpath=//*[@ng-model='SelectedRuleId']//ancestor::body/div[last()]//ul//li[contains(.,'Data is valid if the rule condition is met')]";
	public static final String RulesDDValue3 ="@xpath=//*[@ng-model='SelectedRuleId']//ancestor::body/div[last()]//ul//li[contains(.,'Risk country equals to united states')]";
	public static final String RulesDDValue4 ="@xpath=//*[@ng-model='SelectedRuleId']//ancestor::body/div[last()]//ul//li[contains(.,'Number of stories Equals to 55')]";
	public static final String RulesDDValue5 ="@xpath=//*[@ng-model='SelectedRuleId']//ancestor::body/div[last()]//ul//li[contains(.,'Risk Currency Equal to GBP')]";
	public static final String RulesDDValue6 ="@xpath=//*[@ng-model='SelectedRuleId']//ancestor::body/div[last()]//ul//li[contains(.,'Risk Currency Equal to USD')]";
	
	public static final String TypeDDValue_RiskAndPremium ="@xpath=//ul//li[text()='Risk And Premium']";
	//public static final String RulesDDValue1 ="@xpath=//*[@ng-model='SelectedRuleId']//ancestor::body/div[last()]//ul//li[contains(.,'Risks Located state')]";
	//public static final String RulesDDValue2 ="@xpath=//*[@ng-model='SelectedRuleId']//ancestor::body/div[last()]//ul//li[contains(.,'Number of stories and Sprinklers(Y/N)')]";
	//public static final String RulesDDValue3 ="@xpath=//*[@ng-model='SelectedRuleId']//ancestor::body/div[last()]//ul//li[contains(.,'Number of stories and Sprinklers(Y/N)')]";
	public static final String RulesRisksCountryDDValue ="@xpath=//*[@ng-model='SelectedRuleId']//ancestor::body/div[last()]//ul//li[contains(.,'Risks Located Country')]";
	public static final String RulesInsuredCountryDDValue ="@xpath=//*[@ng-model='SelectedRuleId']//ancestor::body/div[last()]//ul//li[contains(.,'Insured Domiciled Country')]";
	public static final String RulesRisksStateDDValue ="@xpath=//*[@ng-model='SelectedRuleId']//ancestor::body/div[last()]//ul//li[contains(.,'Risks Located State')]";
	public static final String RulesInsuredStateDDValue ="@xpath=//*[@ng-model='SelectedRuleId']//ancestor::body/div[last()]//ul//li[contains(.,'Insured Domiciled State')]";
	
	public static final String EditMarket ="@xpath=//*[@ng-click='details(data)']/td[1]";
	//public static final String EditBtn1 ="@xpath=//*[@id='grid']//tr[1]//button[@ng-click='details(dataItem)']";
	
	public void addPolicy() throws InterruptedException
	{
		String UniqueReferenceVal1 = "Automation Policy1"+getCurrentDateTimeMS1();		
		//loginPage.tideLogin();
		navigationOnPolicyTab();
		navigationOnAddContractPage();
		navigationOnSelectPolicyPopUp();
		navigationOnAddPolicyPopUp();
		addContractBinderDetails();
		addPolicyContractDetails(UniqueReferenceVal1, InceptionDate1, Status1, Broker1, Bline1, Underline1);
		//sleep(3000);
		waitForElementToAppear(DraftBtn,5);
		verifyExists(DraftBtn,"Draft Status Button");
	}

	public void addPolicy1(String InceptionDate) throws InterruptedException
	{
		String UniqueReferenceVal1 = "Automation Policy2"+getCurrentDateTimeMS();
		//loginPage.tideLogin();
		navigationOnPolicyTab();
		navigationOnAddContractPage();
		navigationOnSelectPolicyPopUp();
		navigationOnAddPolicyPopUp();
		addContractBinderDetails();
		addPolicyContractDetails(UniqueReferenceVal1, InceptionDate, Status1, Broker1, Bline1, Underline1);
		//sleep(3000);
		waitForElementToAppear(DraftBtn,5);
		verifyExists(DraftBtn,"Draft Status Button");
	}
	//3228 Contract status change to Quote
	public void changeStatusToQuote() throws InterruptedException
	{
		if(isVisible(DraftBtn)==true){
			click(DraftBtn,"Draft Status Button");
			waitForElementToAppear(ContractStatusPopUp, 5);
			if(isVisible(ContractStatusDD)==true){
				SelectDropDownValue(ContractStatusDD,ContractStatusQuoteValue);
				verifyExists(SaveBtn,"Save Button");
				click(SaveBtn,"Save Button");
				//sleep(3000);
				waitForElementToAppear(QuoteBtn,5);
				verifyExists(QuoteBtn,"Quote Status Button");
			}else{
				Report.LogInfo("ElementCheck", "ContractStatusDD Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "DraftBtn Expected element not found", "FAIL");
		}
	}

	//3229 Contract status change to Written
	public void changeStatusToWritten() throws InterruptedException
	{
		if(isVisible(QuoteBtn)==true){
			click(QuoteBtn,"Quote Status Button");
			waitForElementToAppear(ContractStatusPopUp, 5);
			if(isVisible(ContractStatusDD)==true){
				SelectDropDownValue(ContractStatusDD,ContractStatusWrittenValue);
				verifyExists(SaveBtn,"Save Button");
				click(SaveBtn,"Save Button");
				//sleep(3000);
				waitForElementToAppear(WrittenBtn,5);
				verifyExists(WrittenBtn,"Written Status Button");
			}else{
				Report.LogInfo("ElementCheck", "ContractStatusDD Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "QuoteBtn Expected element not found", "FAIL");
		}
	}

	//3232 Contract status from written to signed
	public void changeStatusToSigned() throws InterruptedException
	{
		writtenToSignedStatus();
		waitForElementToAppear(CannotChangeStatusToSignedValidation,5);
		verifyExists(CannotChangeStatusToSignedValidation,"Cannot Change to Signed Validation Msg");
		verifyExists(SectionMustRecordedValidation,"One Section Must Be Recorded Validation Msg");
		verifyExists(CancelBtn,"Cancel Button");
		click(CancelBtn,"Cancel Button");

		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(-250,0 );");
		if(isVisible(AddSectionTab)==true){
			addSection();
			navigateToContractDetailsTab();
			writtenToSignedStatus();
			waitForElementToAppear(CannotChangeStatusToSignedValidation,5);
			verifyExists(CannotChangeStatusToSignedValidation,"Cannot Change to Signed Validation Msg");
			verifyExists(MarketsLeadInsurerMustValidation,"Markets Lead Insurer Must Validationn Msg");
			verifyExists(RiskCodesEntriesMustValidation,"Risk Codes Entries Must Validation Msg");
			verifyExists(ReportingChannelMustValidation,"Reporting Channel Must Validation Msg");
			click(CancelBtn,"Cancel Button");

			navigateToSectionTab();		
			navigateToMarketsTabOnSection();
			addMarketOnSection();

			navigateToRiskCodesTabOnSection();
			addRiskCodesOnSection();

			navigateToContractDetailsTab();
			writtenToSignedStatus();
			waitForElementToAppear(CannotChangeStatusToSignedValidation,5);
			verifyExists(CannotChangeStatusToSignedValidation,"Cannot Change to Signed Validation Msg");
			verifyExists(ReportingChannelMustValidation,"Reporting Channel Must Validation Msg");
			click(CancelBtn,"Cancel Button");

			navigateToReportingChannelsTab();
			addReportingChannel();
			addCoverholder();

			navigateToContractDetailsTab();
			writtenToSignedStatus();
			verifyExists(SaveBtn,"Save Button");
			click(SaveBtn,"Save Button");
			sleep(3000);
			verifyExists(SignedBtn,"Signed Status Button");
		}else{
			Report.LogInfo("ElementCheck", "Expected element not found", "FAIL");
		}
	}

	public void changeStatusToSigned2(String Type, String FreqVal) throws InterruptedException
	{
		writtenToSignedStatus();
		waitForElementToAppear(CannotChangeStatusToSignedValidation,5);
		verifyExists(CannotChangeStatusToSignedValidation,"Cannot Change to Signed Validation Msg");
		verifyExists(SectionMustRecordedValidation,"One Section Must Be Recorded Validation Msg");
		verifyExists(CancelBtn,"Cancel Button");
		click(CancelBtn,"Cancel Button");

		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(-250,0 );");
		if(isVisible(AddSectionTab)==true){
			addSection();
			navigateToContractDetailsTab();
			writtenToSignedStatus();
			waitForElementToAppear(CannotChangeStatusToSignedValidation,5);
			verifyExists(CannotChangeStatusToSignedValidation,"Cannot Change to Signed Validation Msg");
			verifyExists(MarketsLeadInsurerMustValidation,"Markets Lead Insurer Must Validationn Msg");
			verifyExists(RiskCodesEntriesMustValidation,"Risk Codes Entries Must Validation Msg");
			verifyExists(ReportingChannelMustValidation,"Reporting Channel Must Validation Msg");
			click(CancelBtn,"Cancel Button");

			navigateToSectionTab();		
			navigateToMarketsTabOnSection();
			addMarketOnSection();

			navigateToRiskCodesTabOnSection();
			addRiskCodesOnSection();

			navigateToContractDetailsTab();
			writtenToSignedStatus();
			waitForElementToAppear(CannotChangeStatusToSignedValidation,5);
			verifyExists(CannotChangeStatusToSignedValidation,"Cannot Change to Signed Validation Msg");
			verifyExists(ReportingChannelMustValidation,"Reporting Channel Must Validation Msg");
			click(CancelBtn,"Cancel Button");

			navigateToReportingChannelsTab();						
			addReportingChannelForAnyComb(Type,FreqVal);
			addCoverholder();
			
			navigateToContractDetailsTab();
			writtenToSignedStatus();
			verifyExists(SaveBtn,"Save Button");
			click(SaveBtn,"Save Button");
			sleep(3000);
			verifyExists(SignedBtn,"Signed Status Button");
		}else{
			Report.LogInfo("ElementCheck", "Expected element not found", "FAIL");
		}
	}

	//4094 Calculate Fees Reserve written to signed
	public void changeStatusToSignedWithClaim() throws InterruptedException
	{
		writtenToSignedStatus();
		waitForElementToAppear(CannotChangeStatusToSignedValidation,5);
		verifyExists(CannotChangeStatusToSignedValidation,"Cannot Change to Signed Validation Msg");
		verifyExists(SectionMustRecordedValidation,"One Section Must Be Recorded Validation Msg");
		verifyExists(CancelBtn,"Cancel Button");
		click(CancelBtn,"Cancel Button");

		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(-250,0 );");
		if(isVisible(AddSectionTab)==true){
			addSection();
			navigateToContractDetailsTab();
			writtenToSignedStatus();
			waitForElementToAppear(CannotChangeStatusToSignedValidation,5);
			verifyExists(CannotChangeStatusToSignedValidation,"Cannot Change to Signed Validation Msg");
			verifyExists(MarketsLeadInsurerMustValidation,"Markets Lead Insurer Must Validationn Msg");
			verifyExists(RiskCodesEntriesMustValidation,"Risk Codes Entries Must Validation Msg");
			verifyExists(ReportingChannelMustValidation,"Reporting Channel Must Validation Msg");
			click(CancelBtn,"Cancel Button");

			navigateToSectionTab();		
			navigateToMarketsTabOnSection();
			addMarketOnSection();		
			navigateToRiskCodesTabOnSection();
			addRiskCodesOnSection();

			navigateToContractDetailsTab();
			writtenToSignedStatus();
			waitForElementToAppear(CannotChangeStatusToSignedValidation,5);
			verifyExists(CannotChangeStatusToSignedValidation,"Cannot Change to Signed Validation Msg");
			verifyExists(ReportingChannelMustValidation,"Reporting Channel Must Validation Msg");
			click(CancelBtn,"Cancel Button");

			navigateToReportingChannelsTab();
			addReportingChannelClaim();
			addCoverholder();
			

			navigateToContractDetailsTab();
			writtenToSignedStatus();
			verifyExists(SaveBtn,"Save Button");
			click(SaveBtn,"Save Button");
			sleep(3000);
			verifyExists(SignedBtn,"Signed Status Button");
		}else{
			Report.LogInfo("ElementCheck", "Expected element not found", "FAIL");
		}
	}

	//3285 Check version tab after contract status is set to signed
	public void checkVersionAfterSigned() throws InterruptedException
	{
		addPolicy();
		changeStatusToQuote();
		changeStatusToWritten();
		changeStatusToSigned();
		navigateToVesrionTab();

	}


	//3286 Add a reporting channel to a contract(Bordereaux)
	public void addReportingChannelForContract() throws InterruptedException
	{
		navigateToReportingChannelsTab();
		addReportingChannel("Test Risk");
	}

	//3411 Verify reporting channel
	public void verifyReportingChannel() throws InterruptedException
	{
		List<WebElement> ScheduledBtn = webDriver.findElements(By.xpath("//button[contains(.,'Scheduled')]"));
		navigationOnBordereauxTab();
		verifyMustExists(ExpectedTab,"Expected Tab");
		click(ExpectedTab,"Expected Tab");
		sleep(2000);
		if(ScheduledBtn.size() == 0)
		{
			Report.LogInfo("ScheduledVerification", "Scheduled Status is Displayed", "PASS");
		}
		else
		{
			Report.LogInfo("ScheduledVerification", "Scheduled Status not Display", "FAIL");
		}
	}

	//3287 Edit a reporting channel
	public void editReportingChannelOfContract() throws InterruptedException
	{
		navigateToReportingChannelsTab();
		if(isVisible(EditBtn)==true){
			waitForElementToAppear(EditBtn,5);
			verifyMustExists(EditBtn,"Edit button");
			click(EditBtn,"Edit button");
			//sleep(5000);
			if(isVisible(EditReportingChannelPopup)==true){
				waitForElementToAppear(EditReportingChannelPopup,5);
				verifyMustExists(EditReportingChannelPopup,"Edit Reporting Channel Popup");
				click(EditReportingChannelPopup,"Edit Reporting Channel Popup");
				//sleep(5000);
				waitForElementToAppear(ReportingChannelIdTBox,20);
				verifyMustExists(ReportingChannelIdTBox,"Reporting Channel Identifier Textbox");
				sendKeys(ReportingChannelIdTBox, "risk", "Reporting Channel Identifier Textbox.");
				sleep(1000);
				verifyMustExists(SaveChangesBtn,"Reporting Channel Save Button");
				click(SaveChangesBtn,"Reporting Channel Save Button");
				sleep(2000);
				if(isVisible(secondSectionPopUp) == true)
				{
					verifyExists(SaveBtn1,"Save Button");
					click(SaveBtn1,"Save Button");
					sleep(1000);
				}
				ContSettingPopUpAccept();
				//waitForElementToAppear(EditedChannel,5);
				//verifyMustExists(EditedChannel,"Edited Channel");
			}else{
				Report.LogInfo("ElementCheck", "EditReportingChannelPopup Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "EditBtn Expected element not found", "FAIL");
		}
	}
	
	public void editReportingChannelOfContractForPer() throws InterruptedException
	{
		navigateToReportingChannelsTab();
		if(isVisible(EditBtn1)==true){
			waitForElementToAppear(EditBtn1,5);
			verifyMustExists(EditBtn1,"Edit button");
			click(EditBtn1,"Edit button");
			//sleep(5000);
			if(isVisible(EditReportingChannelPopup)==true){
				waitForElementToAppear(EditReportingChannelPopup,5);
				verifyMustExists(EditReportingChannelPopup,"Edit Reporting Channel Popup");
				click(EditReportingChannelPopup,"Edit Reporting Channel Popup");
				//sleep(5000);
				waitForElementToAppear(ReportingChannelIdTBox,20);
				verifyMustExists(ReportingChannelIdTBox,"Reporting Channel Identifier Textbox");
				sendKeys(ReportingChannelIdTBox, "Risk Bordereaux Test1", "Reporting Channel Identifier Textbox.");
				sleep(1000);
				verifyMustExists(SaveChangesBtn,"Reporting Channel Save Button");
				click(SaveChangesBtn,"Reporting Channel Save Button");
				sleep(2000);
				if(isVisible(secondSectionPopUp) == true)
				{
					verifyExists(SaveBtn1,"Save Button");
					click(SaveBtn1,"Save Button");
					sleep(1000);
				}
				ContSettingPopUpAccept();
				//waitForElementToAppear(EditedChannel,5);
				//verifyMustExists(EditedChannel,"Edited Channel");
			}else{
				Report.LogInfo("ElementCheck", "EditReportingChannelPopup Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "EditBtn Expected element not found", "FAIL");
		}
	}
	
	public void editandDeleteReportingChannelOfContractForPer() throws InterruptedException
	{
		navigateToReportingChannelsTab();
		if(isVisible(EditBtn1)==true){
			waitForElementToAppear(EditBtn1,5);
			verifyMustExists(EditBtn1,"Edit button");
			click(EditBtn1,"Edit button");
			//sleep(5000);
			if(isVisible(EditReportingChannelPopup)==true){
				waitForElementToAppear(EditReportingChannelPopup,5);
				verifyMustExists(EditReportingChannelPopup,"Edit Reporting Channel Popup");
				click(EditReportingChannelPopup,"Edit Reporting Channel Popup");
				//sleep(5000);
				waitForElementToAppear(ReportingChannelIdTBox,20);
				verifyMustExists(ReportingChannelIdTBox,"Reporting Channel Identifier Textbox");
				sendKeys(ReportingChannelIdTBox, "Risk Bordereaux Test1", "Reporting Channel Identifier Textbox.");
				sleep(1000);
				verifyMustExists(DeleteBtn,"Reporting Channel Delete Button");
				click(DeleteBtn,"Reporting Channel Delete Button");
				sleep(2000);
				
				verifyMustExists(YesDeleteBtn,"Reporting Channel Delete Button");
				click(YesDeleteBtn,"Reporting Channel Delete Button");
	
				if(isVisible(secondSectionPopUp) == true)
				{
					verifyExists(SaveBtn1,"Save Button");
					click(SaveBtn1,"Save Button");
					sleep(1000);
				}
				ContSettingPopUpAccept();
				//waitForElementToAppear(EditedChannel,5);
				//verifyMustExists(EditedChannel,"Edited Channel");
			}else{
				Report.LogInfo("ElementCheck", "EditReportingChannelPopup Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "EditBtn Expected element not found", "FAIL");
		}
	}



	//3288 Delete a reporting channel
	public void deleteReportingChannelOfContract() throws InterruptedException
	{
		navigateToReportingChannelsTab();
		if(isVisible(EditBtn)==true){
			waitForElementToAppear(EditBtn,20);
			verifyMustExists(EditBtn,"Edit button");
			click(EditBtn,"Edit button");
			//sleep(5000);
			if(isVisible(EditReportingChannelPopup)==true){
				waitForElementToAppear(EditReportingChannelPopup,20);
				verifyMustExists(EditReportingChannelPopup,"Edit Reporting Channel Popup");
				verifyExists(DeleteBtn,"Delete button");
				click(DeleteBtn,"Delete button");
				sleep(3000);
				if(isVisible(secondSectionPopUp) == true)
				{
					verifyExists(SaveBtn1,"Save Button");
					click(SaveBtn1,"Save Button");
					sleep(1000);
				}				
				waitForElementToAppear(YesDeleteBtn,5);
				verifyMustExists(YesDeleteBtn,"Yes, Delete it! button");
				click(YesDeleteBtn,"Yes, Delete it! button");
				sleep(1000);
				ContSettingPopUpAccept();
				sleep(3000);				
			}else{
				Report.LogInfo("ElementCheck", "EditReportingChannelPopup Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "EditBtn Expected element not found", "FAIL");
		}
	}
	
	public void deleteReportingChannelOfContractForPer() throws InterruptedException
	{
		navigateToReportingChannelsTab();
		if(isVisible(EditBtn1)==true){
			waitForElementToAppear(EditBtn1,20);
			verifyMustExists(EditBtn1,"Edit button");
			click(EditBtn1,"Edit button");
			//sleep(5000);
			if(isVisible(EditReportingChannelPopup)==true){
				waitForElementToAppear(EditReportingChannelPopup,20);
				verifyMustExists(EditReportingChannelPopup,"Edit Reporting Channel Popup");
				verifyExists(DeleteBtn,"Delete button");
				click(DeleteBtn,"Delete button");
				sleep(3000);
				if(isVisible(secondSectionPopUp) == true)
				{
					verifyExists(SaveBtn1,"Save Button");
					click(SaveBtn1,"Save Button");
					sleep(1000);
				}				
				waitForElementToAppear(YesDeleteBtn,5);
				verifyMustExists(YesDeleteBtn,"Yes, Delete it! button");
				click(YesDeleteBtn,"Yes, Delete it! button");
				sleep(1000);
				ContSettingPopUpAccept();
				sleep(3000);				
			}else{
				Report.LogInfo("ElementCheck", "EditReportingChannelPopup Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "EditBtn Expected element not found", "FAIL");
		}
	}

	//3233 Create another contract for same Policy
	public void createAnotherContractForSamePolicy() throws InterruptedException
	{
		BProcessingRiskPremiumClaimPage BPProcessng = new BProcessingRiskPremiumClaimPage();
		//String OpenPolicy = "@xpath=//*[@id='FolderListGrid']//tr//td[contains(.,'"+PolicyNumber+"')]";
		navigationOnPolicyTab();
		selectPolicyFilter(PolicyNumber);
		openSelectedPolicy();
		BPProcessng.openPolicyCreateContract();

		addPolicyContractDetails(UniqueReferenceVal2, InceptionDate2, Status1, Broker2, Bline2, Underline2);
		verifyExists(DraftBtn,"Draft Status Button");
	}


	//3282 Add/edit/Delete Interest to a section
	public void addEditDeleteInterest() throws InterruptedException
	{
		navigateToSectionTab();
		addInterestTab();
		deleteExistingInterest();
		addInterest();
		editInterest();
		deleteInterest();

	}

	//3283 Add/edit/delete Perils to a section
	public void addEditDeletePerils() throws InterruptedException
	{
		perilTab();
		addPeril();
		editPeril();
		deletePeril();
	}

	//3284 Add/edit/delete Limit to a section
	public void addEditDeleteLimit() throws InterruptedException
	{
		limitTab();
		deleteExistingLimit();
		addLimit();
		editLimit();
		deleteLimit();
	}

	//3392 Add/edit/delete Rules
	public void addEditDeleteRules() throws InterruptedException
	{
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		navigationOnPolicyTab();
		navigationOnAddContractPage();
		navigationOnSelectPolicyPopUp();
		navigationOnAddPolicyPopUp();
		addContractOpenMarketDetails();
		addPolicyContractDetails(UniqueReferenceVal1, InceptionDate1, Status1, Broker1, Bline1, Underline1);
		//sleep(3000);
		waitForElementToAppear(DraftBtn,5);
		verifyExists(DraftBtn,"Draft Status Button");
		addReportingChannel();
		addSection();
		navigateToSectionTab();
		navigateSectionRulesTab();		
		navigateRulesTab();
		addRules();
		editRules();
		deleteRules();
	}

	//3415 Section tab hidden for policy type Binder
	public void selectionTabHiddenForPolicy() throws InterruptedException
	{
		addSection();
		navigateToSectionTab();
		if(isVisible(MarketsTab)==true){
			verifyMustExists(MarketsTab,"Markets Tab on Section");
			verifyMustExists(RiskCodesTab,"Risk Codes Tab on Section");
			verifyMustExists(RulesTab,"Rules Tab");
			if(isVisible(RulesMenuTab)== true)
			{
				Report.LogInfo("RulesTabVisible", "Rules Tab is Visible", "PASS");
			}else{
				Report.LogInfo("RulesTabVisible", "Rules Tab is Not Visible", "FAIL");
			}
			if(isVisible(PerilsMenuTab)== true)
			{
				Report.LogInfo("PerilsTabVisible", "Perils Tab is Visible", "FAIL");
			}else{
				Report.LogInfo("PerilsTabVisible", "Perils Tab is Not Visible", "PASS");
			}
			if(isVisible(ModelingMenuTab)== true)
			{
				Report.LogInfo("ModelingTabVisible", "Modeling Tab is Visible", "FAIL");
			}else{
				Report.LogInfo("ModelingTabVisible", "Modeling Tab is Not Visible", "PASS");
			}
		}else{
			Report.LogInfo("ElementCheck", "MarketsTab Expected element not found", "FAIL");
		}

	}


	//3393 Edit section details
	public void editSectionDetails() throws InterruptedException
	{
		navigateToSectionTab();
		navigateToSectionDotEdit();
		EditSection();

	}


	//3394 Edit Section Reference Details
	public void editSectionReference() throws InterruptedException
	{
		navigateToSectionTab();
		navigateToSectionRefDotEdit();
		EditRefSection();

	}

	//3276 Add File to contract
	public void addFileToContract() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		navigateToFilesTab();
		//addFileButton();
		addFile();
	}


	//3529 First Edit of General and Location tab in Contract Rules
	public void firstEditGeneralAndLocation() throws Exception
	{
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		String subSheet = "Rule testing(General and Location) (Automation Schema)";
		String InceptionDate = "01/01/2017";
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		navigationOnPolicyTab();
		navigationOnAddContractPage();
		navigationOnSelectPolicyPopUp();
		navigationOnAddPolicyPopUp();
		addContractBinderDetails();
		addPolicyContractDetails(UniqueReferenceVal1, InceptionDate, Status1, Broker1, Bline1, Underline1);
		waitForElementToAppear(DraftBtn,5);
		verifyExists(DraftBtn,"Draft Status Button");
		contractId = ReturnContractID();
		changeStatusToQuote();
		changeStatusToWritten();
		changeStatusToSigned();
		BordereauProcess.applyFilterPolicy(PolicyNumber);
		openSelectedPolicy();
		navigateMainRulesTab();
		navigateGeneralTab();
		addGeneralRule("90");
		sleep(2000);
		//refreshPage();
		sleep(3000);
		navigateToSectionTab();
		navigateLocationTab();
		addLocationRule();
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		navigationOnBordereauxTab();
		BordereauProcess.SubmitBordereaux(subSheet);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3529 = fpath+"\\src\\test\\resources\\testdata\\Financial_Calculation_TC3529.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File excelFile = new File(sheet3529);

		String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial_Calculation_TC3529.xlsx\",\"UniqueFileName\":\"S86772220180114.xlsx\",\"BordereauFormatId\":\"540a5777-7264-45bd-bbb7-944a26d9bd3b\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S86772220180114.xlsx\",\"Filesize\":107501,\"Path\":null,\"size\":107501,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);

		sleep(3000);
		//UploadFile(allSheets);
		BordereauProcess.refreshUploadedFile();
		if(isVisible(BordereauProcess.ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			verifyMustExists(BordereauProcess.ReviewBtn,"Review button");
			click(BordereauProcess.ReviewBtn,"Review button");
			BordereauProcess.clickOnSubProcessRcdBtn();
			sleep(3000);
			waitForElementToAppear(FrApprovalbtn,10);
			verifyMustExists(FrApprovalbtn,"For Approval button");
			click(FrApprovalbtn,"For Approval button");
			BordereauProcess.clickOnApproveBordBtn();
			BordereauProcess.refreshUploadedFileApprovedStatus();
		}else{
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not displayed.", "FAIL");				
			BordereauProcess.deleteBorderEAUX();
		}
		sleep(2000);
		navigateMainRulesTab();
		navigateBreachesTab();
		verifyBrancesDDValues();
	}

	//3530 Second Edit of General and Location tab in Contract Rules
	public void secondEditGeneralAndLocation() throws Exception
	{
		navigateToSectionTab();
		navigateMainRulesTab();
		navigateGeneralTab();
		addGeneralRule("100");
		//navigateLocationTab();
	}


	//3648	Add contract Rule(BESPOKE)
	public void addBespokeContractRule() throws Exception
	{
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		String InceptionDate = "01/01/2017";

		navigationOnPolicyTab();
		navigationOnAddContractPage();
		navigationOnSelectPolicyPopUp();
		navigationOnAddPolicyPopUp();
		addContractBinderDetails();
		addPolicyContractDetails(UniqueReferenceVal1, InceptionDate, Status1, Broker1, Bline1, Underline1);
		//sleep(3000);
		waitForElementToAppear(DraftBtn,5);
		verifyExists(DraftBtn,"Draft Status Button");
		contractId = ReturnContractID();
		changeStatusToQuote();
		changeStatusToWritten();
		changeStatusToSigned();

		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		navigateMainRulesTab();
		navigateBespokeTab();
		addBespokeContractRules();
		editBespokeRules();
		//JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		//jse.executeScript("scroll(0, -250);");
		scrollUp();
		String subSheet = "Bordereau Processing (kruthika test schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		navigationOnBordereauxTab();
		BordereauProcess.SubmitBordereaux(subSheet);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			FinancialCalculation = fpath+"\\src\\test\\resources\\testdata\\January Contract Rule Test_3648.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(FinancialCalculation);
	
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January Contract Rule Test_3648.xlsx\",\"UniqueFileName\":\"S18575320171105.xlsx\",\"BordereauFormatId\":\"c1cd77c2-d430-4fe8-851d-15ce8049171b\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S18575320171105.xlsx\",\"Filesize\":18536,\"Path\":null,\"size\":18536,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);

		//sleep(3000);
		//UploadFile(allSheets);
		BordereauProcess.refreshUploadedFile();
		if(isVisible(BordereauProcess.ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			verifyMustExists(BordereauProcess.ReviewBtn,"Review button");
			click(BordereauProcess.ReviewBtn,"Review button");
			BordereauProcess.clickOnSubProcessRcdBtn();
			//BordereauProcess.clickOnSubAssesmntBtn();
			sleep(3000);
			waitForElementToAppear(FrApprovalbtn,10);
			verifyMustExists(FrApprovalbtn,"For Approval button");
			click(FrApprovalbtn,"For Approval button");
			BordereauProcess.clickOnApproveBordBtn();
			BordereauProcess.refreshUploadedFileForApproved();
		}else{
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not displayed.", "FAIL");				
			BordereauProcess.deleteBorderEAUX();
		}
		navigateMainRulesTab();
		navigateBespokeTab();
		String RuleBreaches = getTextFrom(BreachesCount);
		int Breaches = Integer.parseInt(RuleBreaches);
		//System.out.println(Breaches);
		navigateBreachesTab();
		SelectDropDownValue(RulesDD,RulesDDValues);

		sleep(3000);
		List<WebElement> RulesEntry = webDriver.findElements(By.xpath("//*[@id='grid']//tbody//tr"));
		if(RulesEntry.size() == Breaches)
		{
			Report.LogInfo("RulesEntry", "Rules Entry count found expected", "PASS");
		}
		else
		{
			Report.LogInfo("RulesEntry", "Rules Entry count is wrong", "FAIL");
		}
	}

	//3649 Edit Bespoke Contract Rule and delete Rule Condition
	public void editAndDeleteBespokeContractRule() throws Exception
	{
		navigateMainRulesTab();
		navigateBespokeTab();
		deleteBespokeRule();
	}

	//3647 Add Bespoke Information Rule
	public void addBespokeInformationRule() throws Exception
	{
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		String InceptionDate = "01/01/2017";
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		//loginPage.tideLogin();
		navigationOnPolicyTab();
		navigationOnAddContractPage();
		navigationOnSelectPolicyPopUp();
		navigationOnAddPolicyPopUp();
		addContractBinderDetails();
		addPolicyContractDetails(UniqueReferenceVal1, InceptionDate, Status1, Broker1, Bline1, Underline1);
		//sleep(3000);
		waitForElementToAppear(DraftBtn,10);
		verifyExists(DraftBtn,"Draft Status Button");
		changeStatusToQuote();
		changeStatusToWritten();
		changeStatusToSigned();
		/*BordereauProcess.applyFilterPolicy("206163AC");
		openSelectedPolicy();*/
		navigationOnBordereauxTab();
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		navigateMainRulesTab();
		navigateBespokeTab();
		addBespokeInformationRules();
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		String subSheet = "Bordereau Processing (kruthika test schema)";

		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		navigationOnBordereauxTab();
		BordereauProcess.SubmitBordereaux(subSheet);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			FinancialCalculation = fpath+"\\src\\test\\resources\\testdata\\Financial Calculation_3647.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(allSheetsPath);
		File excelFile = new File(FinancialCalculation);
		contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculation_3647.xlsx\",\"UniqueFileName\":\"S18575320171105.xlsx\",\"BordereauFormatId\":\"c1cd77c2-d430-4fe8-851d-15ce8049171b\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S18575320171105.xlsx\",\"Filesize\":18536,\"Path\":null,\"size\":18536,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);

		sleep(3000);
		//UploadFile(allSheets);
		BordereauProcess.refreshUploadedFile();
		if(isVisible(BordereauProcess.ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			verifyMustExists(BordereauProcess.ReviewBtn,"Review button");
			click(BordereauProcess.ReviewBtn,"Review button");
			BordereauProcess.clickOnSubProcessRcdBtn();
			//BordereauProcess.clickOnSubAssesmntBtn();
			sleep(3000);
			waitForElementToAppear(FrApprovalbtn,10);
			verifyMustExists(FrApprovalbtn,"For Approval button");
			click(FrApprovalbtn,"For Approval button");
			BordereauProcess.clickOnApproveBordBtn();		
		}else{
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not displayed.", "FAIL");				
			BordereauProcess.deleteBorderEAUX();
		}
		navigateMainRulesTab();		
	}

	//3661 Edit Bespoke Information Rule and delete Rule Condition
	public void editAndDeleteBespokeInformationRule() throws Exception
	{
		navigateMainRulesTab();
		navigateBespokeTab();
		deleteInformationRule();
	}

	//3679 Process Bordereau with Supplementary Files
	public void processBordereauWithSupplementaryFiles() throws Exception
	{
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		String InceptionDate = "01/01/2017";
		//loginPage.tideLogin();
		navigationOnPolicyTab();
		navigationOnAddContractPage();
		navigationOnSelectPolicyPopUp();
		navigationOnAddPolicyPopUp();
		addContractBinderDetails();
		addPolicyContractDetails(UniqueReferenceVal1, InceptionDate, Status1, Broker1, Bline1, Underline1);
		//sleep(3000);
		waitForElementToAppear(DraftBtn,10);
		verifyExists(DraftBtn,"Draft Status Button");
		changeStatusToQuote();
		changeStatusToWritten();
		changeStatusToSigned();

		waitForElementToAppear(BordereauProcess.BORDEREAUXLink,5);
		verifyMustExists(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
		click(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");

		verifyMustExists(SubmitBordereauxDownArrow,"Submit Bordereaux Down Arrow");
		click(SubmitBordereauxDownArrow,"Submit Bordereaux Down Arrow");
		verifyMustExists(RiskOption,"Risk Option");
		click(RiskOption,"Risk Option");
		sleep(5000);
		String requestURL = Configuration.url+"/api/FileStorage/UploadFile/8";
		String URLname = Configuration.url+"/api/SupplementaryFiles/AddSupplementaryFile";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			SupplementaryFile = fpath+"\\src\\test\\resources\\testdata\\January 2017_SupplementaryFiles_3679.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(SupplementaryFile);

		String getURL = getURLFromPage();
		String[] rd1 = getURL.split("/1/0/");
		String ID = rd1[1];
		
        
		String payload = "{\"FileType\":\"6d33722c-b043-4cdc-9c9a-d902f8476af8\",\"FileName\":\"January_2017\",\"OriginalFileName\":\"January 2017_SupplementaryFiles_3679.xlsx\",\"UniqueFileName\":\"S58197120171107.xlsx\",\"UploadPath\":null,\"BordereauxId\":\"00000000-0000-0000-0000-000000000000\",\"InitialBordereauxId\":\""+ID+"\"}";
		String SupplementaryPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20}";
		String SupplementaryURL = Configuration.url+"/api/SupplementaryFiles/GetSupplementaryFilesByBordereauId/"+ID+"/1";

		uploadSupplementaryFile(requestURL, excelFile, payload, URLname, SupplementaryPayload, SupplementaryURL);

		sleep(5000);
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3679Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_3679.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile1 = new File(sheet3679Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//System.out.println(contractId);
		String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_3679.xlsx\",\"UniqueFileName\":\"S70181020171107.xlsx\",\"BordereauFormatId\":\"4ec20038-7ea9-4f10-845e-dac6477f02f7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S70181020171107.xlsx\",\"Filesize\":23607,\"Path\":null,\"size\":23607,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		String requestURL3 = Configuration.url+"/api/SupplementaryFiles/UpdateBordereauxId/";
		String payload3 = "{\"timeout\":{\"isGloballyCancelled\":true}}";

		uploadFileWithSupplementary(ReqUrl, excelFile1, payload2, DraftUrl, requestURL3, payload3, ID);
		sleep(5000);
		goBack();
		BordereauProcess.refreshUploadedFile();
		verifyMustExists(Supplementary1,"Supplementary File");
		click(Supplementary1,"Supplementary File");
		waitForElementToAppear(AddFilePopUp1,10);
		verifyMustExists(AddFilePopUp1,"Add File Pop Up");
		//click(AddFilePopUp1,"Add File Pop Up");
		verifyMustExists(EndorsementFile,"Endorsement File");
		//click(EndorsementFile,"Endorsement File");
		verifyMustExists(OkBtn,"Ok Button");
		click(OkBtn,"Ok Button");
		sleep(3000);
		BordereauProcess.deleteBorderEAUX();
		sleep(2000);
	}

	//Tc 3680
	public void nilBordereau() throws Exception
	{
		BProcessingRiskPremiumClaimPage Bprocessing = new BProcessingRiskPremiumClaimPage();
		BordereauProcessPage BordereauPage = new BordereauProcessPage();
		BordereauPage.applyFilterPolicy(PolicyNumber);
		BordereauPage.openSelectedPolicy();
		navigationOnBordereauxTab();
		Bprocessing.NavigateOnExpected();
		waitForElementToAppear(Bprocessing.Overduebtn,3);
		verifyExists(Bprocessing.Overduebtn,"overdue button");
		click(Bprocessing.Overduebtn,"overdue button");
		if(isVisible(Bprocessing.NilReturnPopUP)==true){
			Report.LogInfo("Checkbutton", "overdue button clickable", "PASS");
			verifyExists(Bprocessing.NilReturnPopUP,"Nil Return pop up");
			verifyExists(Bprocessing.OverdueNobtn,"No Button");
			click(Bprocessing.OverdueNobtn,"No Button");
			waitForElementToAppear(Bprocessing.Overduebtn,3);
			verifyExists(Bprocessing.Overduebtn,"overdue button");
			click(Bprocessing.Overduebtn,"overdue button");
				if(isVisible(Bprocessing.NilReturnPopUP)==true){
				Report.LogInfo("Checkbutton", "overdue button clickable", "PASS");
				verifyExists(Bprocessing.NilReturnPopUP,"Nil Return pop up");
				verifyExists(Bprocessing.OverdueYesbtn,"Yes Button");
				click(Bprocessing.OverdueYesbtn,"Yes Button");
				sleep(2000);
				BordereauPage.navigateToApprovedTab();
				waitForElementToAppear(Bprocessing.NilBordereaubtn,3);
				verifyExists(Bprocessing.NilBordereaubtn,"Ni Bordereau button");		
				}else{
					Report.LogInfo("CheckNilReturnPopUp", "expected Screen not displayed", "Fail");
				}
			}else{
				Report.LogInfo("CheckNilReturnPopUp", "expected Screen not displayed", "Fail");
			}
	}


	public void ContractRoleEdit_TC3527() throws Exception
	{
		BordereauProcessPage BordereauPage = new BordereauProcessPage();
		BordereauPage.applyFilterPolicy(PolicyNumber);
		BordereauPage.openSelectedPolicy();
		scrollUp();
		waitForElementToAppear(Roletab,5);
		verifyMustExists(Roletab,"Verify Role Tab");
		click(Roletab,"Role Tab");
		waitForElementToAppear(CompanyRole,5);
		verifyMustExists(CompanyRole,"Verify Company Role");
		click(CompanyRole,"Select Comapany Role");
		waitForElementToAppear(ContractAdministratorPopup,5);
		verifyMustExists(ContractAdministratorPopup,"Verify Contract Administrator Popup");
		SelectDropDownValue(CompanyAdministratoropdwn,CompanyAdministratoroddvalue);
		waitForElementToAppear(SaveCompany,3);
		verifyMustExists(SaveCompany,"Save Contract Administrator");
		click(SaveCompany,"Save Contract Administrator");
		sleep(3000);
		if(isVisible(ConSettingPopUp) == true)
		{
			sleep(1000);
			verifyExists(SaveBtn4,"Save Button");
			click(SaveBtn4,"Save Button");
			sleep(3000);
		}

	}

	public void ContractClaimAuthority_Edit_4034() throws Exception
	{
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		BordereauProcessPage BordPage = new BordereauProcessPage();
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		//loginPage.tideLogin();
		navigationOnPolicyTab();
		navigationOnAddContractPage();
		navigationOnSelectPolicyPopUp();
		navigationOnAddPolicyPopUp();
		addContractBinderDetails();
		addPolicyContractDetails1(UniqueReferenceVal1, IncDate,ExpDate,BordPage.Status1, Broker1, Bline1, Underline1);
		//sleep(3000);
		waitForElementToAppear(DraftBtn,10);
		verifyExists(DraftBtn,"Draft Status Button");
		changeStatusToQuote();
		changeStatusToWritten();
		changeStatusToSigned();
		scrollUp();
		waitForElementToAppear(ClaimAuthorityTab,5);
		verifyMustExists(ClaimAuthorityTab,"Verify ClaimAuthorityTab");
		click(ClaimAuthorityTab,"Click on ClaimAuthority Tab"); 
		waitForElementToAppear(EditClaimAuthorityTab,5);
		verifyMustExists(EditClaimAuthorityTab,"Verify EditClaimAuthority Tab");
		click(EditClaimAuthorityTab,"Click on EditClaimAuthorityTab");
		verifyMustExists(EditClaimAuthorityBtn,"Verify EditClaimAuthority Button");
		click(EditClaimAuthorityBtn,"Click on EditClaimAuthority Button");
		sleep(5000);
		waitForElementToAppear(VerifyAddClaimsAuthority,5);
		verifyMustExists(VerifyAddClaimsAuthority,"Verify Add Claim Authority Popup");
		waitForElementToAppear(ClaimAuthoritydropdwn,5);
		verifyMustExists(ClaimAuthoritydropdwn,"Verify Claim Authority drop dwn");
		click(ClaimAuthoritydropdwn,"Click on Claim Authority drop dwn");
		verifyMustExists(ClaimAuthorityddvalue,"Verify Claim Authority drop dwn value");
		click(ClaimAuthorityddvalue,"Click on Claim Authority drop dwn value");
		verifyMustExists(ClaimsAuthorityLimit,"Verify ClaimsAuthorityLimit");
		sendKeys(ClaimsAuthorityLimit,"5");
		verifyMustExists(ClaimAuthorityCurrencydropdwn,"Verify Claim Authority Currency drop dwn");
		click(ClaimAuthorityCurrencydropdwn,"Click on Claim Authority Currency drop dwn");
		verifyMustExists(ClaimAuthorityCurrencyddvalue,"Verify Claim Authority Currency drop dwn value");
		click(ClaimAuthorityCurrencyddvalue,"Click on Claim Authority Currency drop dwn value");
		verifyMustExists(ClaimsAuthoritySavechanges,"Verify Claim Authority save button");
		click(ClaimsAuthoritySavechanges,"Click on Claim Authority save button");
		sleep(5000);
		verifyMustExists(ClaimsAuthorityEndorsementSavechanges,"Save contract endorsement");
		click(ClaimsAuthorityEndorsementSavechanges,"Save contract endorsement");
		verifyMustExists(VerifyClaimsAuthority,"Verify Claim Authority");
		sleep(1000);
		verifyMustExists(VerifyClaimsAuthorityLimit,"Verify Claim Authority Limit & Currency");
		sleep(5000);
	}

	public void ContractCoverHolder_AddOrEdit_TC3801() throws Exception
	{
		BordereauProcessPage BordPage = new BordereauProcessPage();
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();

		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		navigationOnPolicyTab();
		navigationOnAddContractPage();
		navigationOnSelectPolicyPopUp();
		navigationOnAddPolicyPopUp();
		addContractBinderDetails_Multiple();
		addPolicyContractDetails1(UniqueReferenceVal1, IncDate,ExpDate,BordPage.Status1, Broker1, Bline1, Underline1);
		waitForElementToAppear(BordPage.DraftBtn,5);
		verifyExists(BordPage.DraftBtn,"Draft Status Button");
		changeStatusToQuote();
		changeStatusToWritten();
		changeStatusToSigned();
		scrollUp();
		waitForElementToAppear(Coverholdertab,5);
		verifyMustExists(Coverholdertab,"Cover holder tab");
		click(Coverholdertab,"Cover holder tab");
		//verifyMustExists(AddCoverholderBtn,"Add Cover holder button");
		//click(AddCoverholderBtn,"Add Cover holder button");
		//waitForElementToAppear(VerifyAddCoverholder,5);
		//verifyMustExists(VerifyAddCoverholder," Verify Add Cover holder");
		//waitForElementToAppear(coverholderdropdwn,5);
		//SelectDropDownValue(coverholderdropdwn,coverholderddValue);	
		//SelectDropDownValue(CoverholderContactdropdwn,CoverholderContactddvalue);
		//verifyMustExists(PrimarycoverholderYes,"Primary Coverholder Yes");
		//click(PrimarycoverholderYes,"Primary Coverholder Yes");
		//sleep(1000);
		//verifyMustExists(coverholderSave,"Cover holder Save");
		//click(coverholderSave,"Cover holder Save");
		
		waitForElementToAppear(EditCoverholder,5);
		verifyMustExists(EditCoverholder,"Edit Cover holder");
		click(EditCoverholder,"Edit Cover holder");
		waitForElementToAppear(EditCoverholderPopup,5);
		verifyMustExists(EditCoverholderPopup,"Edit Cover holder Popup");
		SelectDropDownValue(EditCoverholderContactdropdwn,EditCoverholderContactddvalue);
		verifyMustExists(SaveChangesCoverholder,"Save Edited Cover holder");
		click(SaveChangesCoverholder,"Save Edited Cover holder");
		verifyMustExists(SignedStatusPopup,"Contract settings update popup");
		sendKeys(ContractSettingsNotes, "Test1");
		verifyMustExists(SignedPopupSaveButton,"Save contract change");
		click(SignedPopupSaveButton,"Save contract changer");
		sleep(5000);
	}
	public void EditCoverholder() throws Exception
	{   
		waitForElementToAppear(Coverholdertab,5);
        verifyMustExists(Coverholdertab,"Add Coverholder Button");
        click(Coverholdertab,"Add Coverholder Button");
		waitForElementToAppear(EditCoverholder2,5);
		verifyMustExists(EditCoverholder2,"Edit Cover holder");
		click(EditCoverholder2,"Edit Cover holder");
		waitForElementToAppear(EditCoverholderPopup,5);
		verifyMustExists(EditCoverholderPopup,"Edit Cover holder Popup");
		verifyMustExists(PrimarycoverholderYes,"Primary Coverholder Yes");
        click(PrimarycoverholderYes,"Primary Coverholder Yes");
		//(EditCoverholderContactdropdwn,EditCoverholderContactddvalue);
		//verifyMustExists(SaveChangesCoverholder,"Save Edited Cover holder");
		click(SaveChangesCoverholder,"Save Edited Cover holder");
		verifyMustExists(SignedStatusPopup,"Contract settings update popup");
		sendKeys(ContractSettingsNotes, "Test1");
		verifyMustExists(SignedPopupSaveButton,"Save contract change");
		click(SignedPopupSaveButton,"Save contract changer");
		sleep(5000);
	   
	}
	
	
	public void Contract_Link_TC3804() throws Exception
	{   
		BordereauProcessPage BordereauPage = new BordereauProcessPage();
		BordereauPage.applyFilterPolicy(PolicyNumber);
		BordereauPage.openSelectedPolicy();
		scrollUp();
		verifyMustExists(ContractLink,"Contract link button");
		click(ContractLink,"Contract link button");
		waitForElementToAppear(ContractLinkpopup,5);
		verifyMustExists(ContractLinkpopup,"Contract link Popup");
		click(ContractLinkpopup,"Contract link Popup");
		sleep(1000);
		SelectDropDownValue(ParentContractdropdwn,ParentContractddvalue);

		verifyMustExists(Saveparent,"Save Contract link");
		click(Saveparent,"Save Contract link");
		sleep(5000);
	}

	public void Contract_MetaData_TC3803() throws Exception
	{
		BordereauProcessPage BordPage = new BordereauProcessPage();
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		navigationOnPolicyTab();
		navigationOnAddContractPage();
		navigationOnSelectPolicyPopUp();
		navigationOnAddPolicyPopUp();
		addContractBinderDetails_Multiple();
		addPolicyContractDetails1(UniqueReferenceVal1, IncDate,ExpDate,BordPage.Status1, Broker1, Bline1, Underline1);
		waitForElementToAppear(BordPage.DraftBtn,5);
		verifyExists(BordPage.DraftBtn,"Draft Status Button");
		scrollUp();
		if(isVisible(CompanySpecificTab) == true)
		{
			verifyMustExists(CompanySpecificTab,"Company Specific Tab");
			click(CompanySpecificTab,"Company Specific Tab");
			waitForElementToAppear(ContractMetaDataField,5);
			verifyMustExists(ContractMetaDataField,"Contract MetaData Field");
			click(ContractMetaDataField,"Contract MetaData Field");
		}
		else
		{
			Report.LogInfo("CompanySpecificTab", "Company Specific Tab is not displayed", "FAIL");
		}
	}

	public void Edit_Company_SpecificTab_TC4041() throws Exception
	{
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		BordereauProcessPage BordereauPage = new BordereauProcessPage();
		BordereauPage.applyFilterPolicy(PolicyNumber);
		//BordereauPage.applyFilterPolicy("157707XN");
		BordereauPage.openSelectedPolicy();
		scrollUp();
		if(isVisible(CompanySpecificTab) == true)
		{
			waitForElementToAppear(CompanySpecificTab,5);
			verifyMustExists(CompanySpecificTab,"Company Specific Tab");
			click(CompanySpecificTab,"Company Specific Tab");
			waitForElementToAppear(EditCompanySpecificTab,3);
			verifyMustExists(EditCompanySpecificTab,"Edit Company Specific Tab");
			click(EditCompanySpecificTab,"Edit Company Specific Tab");
			verifyMustExists(EditCompanySpecificBtn,"Verify Edit Company Specific Button");
			click(EditCompanySpecificBtn,"Edit Company Specific Button");
			jse.executeScript("scroll(0,5000);");
			verifyMustExists(underwritingtab,"Verify Underwritting");
			sleep(3000);
			verifyMustExists(Editfield1,"Edit Company Specific field1");
			sendKeys(Editfield1,"10","Enter field value");
			//sendKeys(Editfield1,"10");
			waitForElementToAppear(Editfield2,5);
			verifyMustExists(Editfield2,"Edit Company Specific Field2");
			sendKeys(Editfield2,"19");
			verifyMustExists(Editfield3,"Edit Company Specific Field3");
			sendKeys(Editfield3,"2");
			verifyMustExists(SaveEditChanges,"Save Company Specific");
			click(SaveEditChanges,"Save Company Specific");
			waitForElementToAppear(ErrorMsg,5);
			if(isVisible(ErrorMsg))
			{
				Report.LogInfo("ValidateRuleBrachesValue", "Display Error Message", "FAIL");
			}
			else
			{
				Report.LogInfo("ValidateRuleBrachesValue", "Not Display Error Message", "Pass");
			}
			sleep(3000);
		}
		else
		{
			Report.LogInfo("CompanySpecificTab", "Company Specific Tab is not displayed", "FAIL");
		}
	}
	
	public void Edit_Additional_Tab_For_Contract_TC4042() throws Exception
	{
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		BordereauProcessPage BordereauPage = new BordereauProcessPage();
		BordereauPage.applyFilterPolicy(PolicyNumber);
		BordereauPage.openSelectedPolicy();
		scrollUp();
		if(isVisible(AdditionalTab) == true)
		{
			waitForElementToAppear(AdditionalTab,5);
			verifyMustExists(AdditionalTab,"Additional Tab");
			click(AdditionalTab,"Additional Tab");	
			verifyMustExists(EditAdditionalTab,"Edit Additional Tab");
			click(EditAdditionalTab,"Click Additional Tab");	
			verifyMustExists(EditAddtionalBtn,"Verify Edit Additional Button");
			click(EditAddtionalBtn,"Edit Additional Button");
			SelectDropDownValue(ManagedBydropdwn,ManagedByddvalue);
			verifyMustExists(VerifyUnderwriting,"Verify Underwriting");
			verifyMustExists(EditAutomationfield,"Edit Automation Field");
			sendKeys(EditAutomationfield,"100");
			verifyMustExists(VerifyClaim,"Verify Claim");
			verifyMustExists(EditClaimAuthorityLimit,"Edit Claim Authority Limit Field");
			sendKeys(EditClaimAuthorityLimit,"100");
			verifyMustExists(SaveAdditionalChanges,"Save Additional Changes");
			click(SaveAdditionalChanges,"Save Additional Changes");
			sleep(10000);
		}
		else
		{
			Report.LogInfo("AdditionalTab", "Additional Tab is not displayed", "FAIL");
		}
	}
	
	
	public void SectionMarket_AddEditDelete_TC5283() throws Exception
	{
		BordereauProcessPage BorProc = new BordereauProcessPage();
		String IncDate = "01/01/2017";
		String ExpDate = "01/01/2018";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		addPolicy2(IncDate,ExpDate);
		verifyExists(BorProc.DraftBtn,"Draft Status Button");
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\"596023CT\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		changeStatusToQuote();
		changeStatusToWritten();
		changeStatusToSigned();
		BorProc.applyFilterPolicy(PolicyNumber);
		BorProc.openSelectedPolicy();
		addSection2("Section2","10","Property D&F (US binder)","GBP - British Pound","10","10","10","Low");
		navigateToSectionTab2();
		navigateToMarketsTabOnSection();

		sleep(2000);
		addMarketOnSection();
		verifyMustExists(EditMarket,"Edit Market");
		click(EditMarket,"Edit Market");
		editMarketPopup1();
		verifyMustExists(EditMarket,"Edit Market");
		click(EditMarket,"Edit Market");
		sleep(1000);
		verifyExists(DeleteBtn,"Delete button");
		click(DeleteBtn,"Delete button");
		sleep(3000);
		if(isVisible(secondSectionPopUp) == true)
		{
			verifyExists(SaveBtn1,"Save Button");
			click(SaveBtn1,"Save Button");
			sleep(1000);
			
		}				
		waitForElementToAppear(YesDeleteBtn,5);
		verifyMustExists(YesDeleteBtn,"Yes, Delete it! button");
		click(YesDeleteBtn,"Yes, Delete it! button");
		sleep(1000);
		if(isVisible(ConEndrsmntPopUp) == true)
		{
			sleep(1000);
			verifyExists(SaveBtn3,"Save Button");
			click(SaveBtn3,"Save Button");
				sleep(3000);
		}
	}

	/*************************************************************/

	public void navigateToFilesTab()
	{
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(-250,0 );");
		sleep(1000);
		if(isVisible(FilesTab)==true){
			verifyMustExists(FilesTab,"Files Tab");
			sleep(1000);
			click(FilesTab,"Files Tab");
		}else{
			Report.LogInfo("ElementCheck", "FilesTab Expected element not found", "FAIL");
		}
	}
	
	public void verifyContractFilesTab()
	{
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(-250,0 );");
		sleep(1000);
		if(isVisible(FilesTab)==true){
			verifyMustExists(FilesTab,"Files Tab");
			sleep(1000);
			click(FilesTab,"Files Tab");
		}else{
			Report.LogInfo("ElementCheck", "FilesTab Expected element not found", "FAIL");
		}
		waitForElementToAppear(AddFileBtn,5);
		verifyMustExists(AddFileBtn,"Add File button");
	}

	public void addFileButton()
	{
		//sleep(3000);
		waitForElementToAppear(AddFileBtn,5);
		verifyMustExists(AddFileBtn,"Add File button");
		click(AddFileBtn,"Add File button");
	}

	public void addFile() throws AWTException, ClientProtocolException, IOException
	{
		sleep(3000);
		verifyExists(Filetype, "Filetype column exists");
		verifyExists(Filename, "Filename column exists");
		verifyExists(FileTitle, "FileTitle column exists");
		verifyExists(DateTimeUploaded, "Date Time Uploaded column exists");
		click(AddFileRefresh,"Refresh button");
		sleep(3000);
		String requestURL = Configuration.url+"/api/FileStorage/UploadFile/3";
		String URLname = Configuration.url+"/api/Files/AddContractFile";
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			addFile = fpath+"\\src\\test\\resources\\testdata\\AddFile.xlsx";
			File excelFile = new File(addFile);
			sleep(4000);
			String contractId = addNewBordereauFormatPolicy(payload1, GetData);
			//System.out.println(contractId);
			
			String payload = "{\"ContractId\":\""+contractId+"\",\"FileType\":\"e5e3b289-a058-45fc-b28f-53be1a650d80\",\"FileName\":\"Endorsement\",\"OriginalFileName\":\"AddFile.xlsx\",\"UniqueFileName\":\"S29571020180231.xlsx\",\"UploadPath\":null,\"BordereauxId\":\"00000000-0000-0000-0000-000000000000\",\"InitialBordereauxId\":null}";
					uploadFilePolicy(requestURL, excelFile, payload, URLname);
			sleep(4000);
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(AddFileRefresh,"Refresh button");
		sleep(2000);
		if(isVisible(VerifyAddedFile)==true){
			verifyOptionalExists(VerifyAddedFile,"Verify Added File");
		}else{
			Report.LogInfo("FileUpload", "File not uploaded successfully.", "FAIL");
		}
	}

	public void applyFilterPolicy()
	{
		sleep(3000);
		verifyExists(PolicyLink,"Policy Link");
		click(PolicyLink,"Policy Link");
		webDriver.navigate().refresh();
		sleep(3000);
		click(PolicyReferenceFilterIcon,"Policy Link");
		sleep(3000);
		sendKeys(SearchText,PolicyNumber,"Policy Number field.");
		sleep(2000);
		webDriver.findElement(By.xpath("//label/span[text()='"+PolicyNumber+"']")).click();
		sleep(2000);
		verifyExists(FilterButton,"Filter Button");
		click(FilterButton,"Filter Button");
	}

	public void openSelectedPolicy()
	{
		//sleep(3000);
		waitForElementToAppear(SelectedPolicy,5);
		verifyMustExists(SelectedPolicy,"Selected Policy");
		click(SelectedPolicy,"Selected Policy");
	}

	public void navigationOnPolicyTab() throws InterruptedException
	{
		Thread.sleep(2000);
		if(isVisible(PolicyTab)==true){
			waitForElementToAppear(PolicyTab,5);
			verifyMustExists(PolicyTab,"Policy tab");
			javaScriptclick(PolicyTab,"Policy tab");
		}else{
			Report.LogInfo("ElementCheck", "PolicyTab Expected element not found", "FAIL");
		}

	}

	public void navigationOnRuleTab() throws InterruptedException
	{
		Thread.sleep(2000);
		if(isVisible(RuleTab)==true){
			waitForElementToAppear(RuleTab,5);
			verifyMustExists(RuleTab,"Policy tab");
			javaScriptclick(RuleTab,"Policy tab");
		}else{
			Report.LogInfo("ElementCheck", "RuleTab Expected element not found", "FAIL");
		}
	}
	public void openExistingPolicy() throws InterruptedException
	{
		Thread.sleep(2000);
		if(isVisible(Existingpolcy)==true){
			waitForElementToAppear(Existingpolcy,5);
			verifyMustExists(Existingpolcy,"Existing policy");
			javaScriptclick(Existingpolcy,"Existing policy");
		}else{
			Report.LogInfo("ElementCheck", "Existingpolcy Expected element not found", "FAIL");
		}
	}



	public void navigationOnAddContractPage() throws InterruptedException
	{
		//sleep(3000);
		if(isVisible(AddContractBtn)==true){
			waitForElementToAppear(AddContractBtn,5);
			verifyMustExists(AddContractBtn,"Add Contract button");
			click(AddContractBtn,"Add Contract button");
		}else{
			Report.LogInfo("ElementCheck", "AddContractBtn Expected element not found", "FAIL");
		}

		//Thread.sleep(2000);
	}

	public void navigationOnSelectPolicyPopUp() throws InterruptedException
	{
		if(isVisible(SelectPolicyBtn)==true){
			waitForElementToAppear(SelectPolicyBtn,5);
			verifyMustExists(SelectPolicyBtn,"Select Policy button");
			javaScriptclick(SelectPolicyBtn,"Select Policy button");
		}else{
			Report.LogInfo("ElementCheck", "SelectPolicyBtn Expected element not found", "FAIL");
		}
	}

	public void navigationOnAddPolicyPopUp() throws InterruptedException
	{
		/*if(isVisible(AddPolicyBtn)==true){
			waitForElementToAppear(AddPolicyBtn,5);
			verifyMustExists(AddPolicyBtn,"Add Policy button");
			click(AddPolicyBtn,"Add Policy button");
		}else{
			Report.LogInfo("ElementCheck", "AddPolicyBtn Expected element not found", "FAIL");
		}*/
	}

	public void navigateToContractDetailsTab() throws InterruptedException
	{
		//sleep(3000);
		if(isVisible(contractDetailsTab)==true){
			waitForElementToAppear(contractDetailsTab,5);
			verifyMustExists(contractDetailsTab,"Contract Details Tab");
			click(contractDetailsTab,"Contract Details Tab");
			//sleep(2000);
		}else{
			Report.LogInfo("ElementCheck", "Expected element not found", "FAIL");
		}

	}

	public void navigateToSectionTab() throws InterruptedException
	{
		if(isVisible(sectionTab)==true){
			waitForElementToAppear(sectionTab,5);
			verifyMustExists(sectionTab,"Section Tab");
			javaScriptclick(sectionTab,"Section Tab");
			//sleep(2000);
		}else{
			Report.LogInfo("ElementCheck", "SectionTab Expected element not found", "FAIL");
		}

	}

	public void navigateToAddSectionTab() throws InterruptedException
	{
		waitForElementToAppear(AddSectionTab,5);
		verifyMustExists(AddSectionTab,"Add Section Tab");
		click(AddSectionTab,"Add Section Tab");
		//sleep(2000);
	}

	public void navigateToMarketsTabOnSection() throws InterruptedException
	{
		if(isVisible(MarketsTab)==true){
			waitForElementToAppear(MarketsTab,5);
			verifyMustExists(MarketsTab,"Markets Tab on Section");
			click(MarketsTab,"Markets Tab on Section");
		}else{
			Report.LogInfo("ElementCheck", "MarketsTab expected element not found", "FAIL");
		}
	}

	public void EditExistingMarket()
	{		
		if(isVisible(ExistingMarket)==true){
			waitForElementToAppear(ExistingMarket,5);
			verifyMustExists(ExistingMarket,"Market record");
			click(ExistingMarket,"Market record");
		}else{
			Report.LogInfo("ElementCheck", "MarketsTab expected element not found", "PASS");
		}
	}

	public void navigateToRiskCodesTabOnSection() throws InterruptedException
	{
		if(isVisible(RiskCodesTab)==true){
			waitForElementToAppear(RiskCodesTab,5);
			verifyMustExists(RiskCodesTab,"Risk Codes Tab on Section");
			click(RiskCodesTab,"Risk Codes Tab on Section");
		}else{
			Report.LogInfo("ElementCheck", "RiskCodesTab expected element not found", "FAIL");
		}

	}

	public void navigateToReportingChannelsTab() throws InterruptedException
	{		
		if(isVisible(ReportingChannelsTab)==true){
			waitForElementToAppear(ReportingChannelsTab,5);
			verifyMustExists(ReportingChannelsTab,"Reporting Channels Tab");
			click(ReportingChannelsTab,"Reporting Channels Tab");
		}else{
			Report.LogInfo("ElementCheck", "ReportingChannelsTab expected element not found", "FAIL");
		}
	}

	public void navigateToSectionDotEdit() throws InterruptedException
	{
		sleep(1000);
		if(isVisible(ThreeDots)==true){
			waitForElementToAppear(ThreeDots,5);
			verifyMustExists(ThreeDots,"Edit Dots");
			click(ThreeDots,"Edit Dots");
			//sleep(2000);
			if(isVisible(EditOption)==true){
				waitForElementToAppear(EditOption,5);
				verifyMustExists(EditOption,"Edit Option");
				click(EditOption,"Edit Option");
			}else{
				Report.LogInfo("ElementCheck", "EditOption Expected element not found", "FAIL");

			}
		}else{
			Report.LogInfo("ElementCheck", "ThreeDots Expected element not found", "FAIL");
		}
	}

	public void navigateToSectionRefDotEdit() throws InterruptedException
	{
		if(isVisible(ThreeDotsRef)==true){
			waitForElementToAppear(ThreeDotsRef,5);
			verifyMustExists(ThreeDotsRef,"Edit Dots");
			click(ThreeDotsRef,"Edit Dots");
			//sleep(2000);
			waitForElementToAppear(EditOptionRef,5);
			verifyMustExists(EditOptionRef,"Edit Option");
			click(EditOptionRef,"Edit Option");
		}else{
			Report.LogInfo("ElementCheck", "ThreeDotsRef Expected element not found", "FAIL");
		}

	}
	
	public void ReadonlyusernavigateToSectionRefDotEdit() throws InterruptedException
	{
		if(isVisible(ThreeDotsRef)==true){
			Report.LogInfo("ElementCheck", "ThreeDotsRef Expected element  found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "ThreeDotsRef  element not found", "PASS");
		}

	}
	public void addReportingChannel(String Identifier) throws InterruptedException
	{
		if(isVisible(AddReportingChannelBtn)==true){
			waitForElementToAppear(AddReportingChannelBtn,5);
			verifyMustExists(AddReportingChannelBtn,"Add Reporting Channel Button");
			javaScriptclick(AddReportingChannelBtn,"Add Reporting Channel Button");
			sleep(2000);
			if(isVisible(ChannelTypeDropdown1)==true){
				waitForElementToAppear(ChannelTypeDropdown,5);
				SelectDropDownValue(ChannelTypeDropdown,ChannelTypeDDValue);

				SelectDropDownValue(TypeDropdown,TypeDDValue);

				SelectDropDownValue(FrequencyDropdown,FrequencyDDValue);

				verifyMustExists(ReportingChannelIdTBox,"Reporting Channel Identifier Textbox");
				sendKeys(ReportingChannelIdTBox, Identifier, "Reporting Channel Identifier Textbox.");
				sleep(1000);

				verifyMustExists(SaveBtn,"Reporting Channel Save Button");
				click(SaveBtn,"Reporting Channel Save Button");
				/*sleep(2000);
				if(isVisible(secondSectionPopUp) == true)
				{
					verifyExists(SaveBtn1,"Save Button");
					click(SaveBtn1,"Save Button");
					sleep(1000);
				}*/
				ContSettingPopUpAccept();
				waitForElementToAppear(ReportingChannelRecord,5);
				verifyOptionalExists(ReportingChannelRecord,"Reporting Channel Record in List");
				verifyOptionalExists(BordereauxTab,"Bordereaux Tab");
			}else{
				Report.LogInfo("ElementCheck", "ChannelTypeDropdown Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "AddReportingChannelBtn Expected element not found", "FAIL");
		}

	}

	public void addContractBinderDetails() throws InterruptedException
	{
		//sleep(3000);
		if(isVisible(PolicySaveBtn)==true){
			waitForElementToAppear(PolicyDrpDown,5);
			SelectDropDownValue(PolicyDrpDown,BinderDrpValue);
			verifyMustExists(LoyldYesBtn,"Loyld Yes button");
			click(LoyldYesBtn,"Loyld Yes button");
			Thread.sleep(1000);
			SelectDropDownValue(DivisionDrpDown,DivisionDrpValue);

			//verifyMustExists(CashHoldrSingleBtn,"Coverholder single button");
			//click(CashHoldrSingleBtn,"Coverholder single button");
			//Thread.sleep(1000); 

		//	SelectDropDownValue(CoverholderDrpDown,CoverholderDrpValue);

			verifyMustExists(PolicySaveBtn,"Save button");
			click(PolicySaveBtn,"Save button");
			sleep(3000);
		}else{
			Report.LogInfo("ElementCheck", "PolicyDrpDown Expected element not found", "FAIL");
		}
	}

	public void addContractOpenMarketDetails() throws InterruptedException
	{
		//sleep(3000);
		waitForElementToAppear(PolicyDrpDown,5);
		SelectDropDownValue(PolicyDrpDown,OpenMarketValue);
		verifyMustExists(LoyldYesBtn,"Loyld Yes button");
		click(LoyldYesBtn,"Loyld Yes button");
		SelectDropDownValue(DivisionDrpDown,DivisionDrpValue);
		verifyMustExists(InsuredTxt,"Insured textbox");
		sendKeys(InsuredTxt,"testtest","Insured textbox");
		Thread.sleep(1000);

		verifyMustExists(PolicySaveBtn,"Save button");
		click(PolicySaveBtn,"Save button");
		Thread.sleep(4000);
	}


	public void addPolicyContractDetails(String UniqueReferenceName, String InceptionDates, String Status, String Broker, String Bline, String Underline ) throws InterruptedException
	{
		sleep(3000);
		waitForElementToAppear(Policytitle,5);
		sleep(3000);
		PolicyNumber = getTextFrom(Policytitle);
		//System.out.println(PolicyNumber);
		verifyMustExists(UniqueReference,"Unique Reference textbox");
		sendKeys(UniqueReference,PolicyNumber,"Unique Reference textbox.");

		SelectDropDownValue(ContractCurrencyDrpDown,ContractCurrencyDrpDownValue);
		Thread.sleep(2000);
	//	List<WebElement> SettlementCurrencyDrpDownValueList = webDriver.findElements(By.xpath("//ul[@class='k-list k-reset']//*[contains(.,'GBP - British Pound')]"));
	//	String SettlementCurrencyDrpDownValueFull = SettlementCurrencyDrpDownValueList.get(1).toString();
	//	String SettlementCurrencyDrpDownValue = SettlementCurrencyDrpDownValueFull.substring(beginIndex, endIndex);
		SelectDropDownValue(SettlementCurrencyDrpDown,SettlementCurrencyDrpDownValue);
		
		

		verifyMustExists(CompanyReference,"Company Reference textbox");
		
		sendKeys(CompanyReference,CompanyReferenceval,"Company Reference textbox.");

		//SelectDropDownValue(ContractStatusDrpDown,ContractCurrencyDrpDownValue);

		verifyMustExists(ContractStatusDrpDown,"Contract Status Drop Down");
		click(ContractStatusDrpDown,"Contract Status Drop Down");
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//ul[@class='k-list k-reset']//*[text()='"+Status+"']")).click();
		SelectDropDownValue(BrokerDrpDown,BrokerDrpDownValue1);
		verifyMustExists(InceptionDateIcon,"Inception Date");
		sendKeys(InceptionDateIcon,InceptionDates,"Inception Date field.");		
		verifyMustExists(LineofBusinessDrpDown,"Line of Business Drop Down");
		click(LineofBusinessDrpDown,"Line of Business Drop Down");
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//ul[@class='k-list k-reset']//*[text()='"+Bline+"']")).click();

		//SelectDropDownValue(UnderwriterDrpDown,UnderwriterDrpDownValue);

		//SelectDropDownValue(TechnicianDrpDown,TechnicianDrpDownValue);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("window.scrollBy(0,250)", "");
		sleep(1000);
		verifyMustExists(SaveBtn,"Save Button");
		click(SaveBtn,"Save button");
		//Thread.sleep(5000);
		waitForElementToAppear(PolicytitleOnCotractDetails,5);
		if(isVisible(PolicytitleOnCotractDetails)== true)
		{
			Report.LogInfo("ContractDetailsNav", "User is successfully navigated on Contract Details page.", "PASS");
		}else{
			Report.LogInfo("ContractDetailsNav", "User is not successfully navigated on Contract Details page.", "FAIL");
		}	
		sleep(1000);

	}

	public void addPolicyContractDetails1(String UniqueReferenceName, String InceptionDates, String InceptionExp, String Status, String Broker, String Bline, String Underline ) throws InterruptedException
	{
		//sleep(3000);
		waitForElementToAppear(Policytitle,5);
		PolicyNumber = getTextFrom(Policytitle);
		verifyMustExists(UniqueReference,"Unique Reference textbox");
		sendKeys(UniqueReference,UniqueReferenceName,"Unique Reference textbox.");

		SelectDropDownValue(ContractCurrencyDrpDown,ContractCurrencyDrpDownValue);
		Thread.sleep(2000);
		SelectDropDownValue(SettlementCurrencyDrpDown,SettlementCurrencyDrpDownValue);
		
		verifyMustExists(CompanyReference,"Company Reference textbox");
		sendKeys(CompanyReference,CompanyReferenceval,"Company Reference textbox.");
		verifyMustExists(ContractStatusDrpDown,"Contract Status Drop Down");
		click(ContractStatusDrpDown,"Contract Status Drop Down");
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//ul[@class='k-list k-reset']//*[text()='"+Status+"']")).click();
		//verifyMustExists(BrokerDrpDown,"Broker Drop Down");
		//click(BrokerDrpDown,"Broker Drop Down");
		//Thread.sleep(1000);
		//webDriver.findElement(By.xpath("//ul[@class='k-list k-reset']//*[text()='"+Broker+"']")).click();
		SelectDropDownValue(BrokerDrpDown,BrokerDrpDownValue1);
		verifyMustExists(InceptionDateIcon,"Inception Date");
		sendKeys(InceptionDateIcon,InceptionDates,"Inception Date field.");	
		if(isVisible(ExpDtpop)==true)
		{

			verifyMustExists(ErrorPopUpOKbtn,"Error Pop Up OK button");
			click(ErrorPopUpOKbtn,"Error Pop Up OK buttonn");
			waitForElementToAppear(ExpiryDateIcon,5);
			sendKeys(ExpiryDateIcon,InceptionExp,"Expiry date");
		}else{
			waitForElementToAppear(ExpiryDateIcon,5);
			sendKeys(ExpiryDateIcon,InceptionExp,"Expiry date");
		}
		verifyMustExists(LineofBusinessDrpDown,"Line of Business Drop Down");
		click(LineofBusinessDrpDown,"Line of Business Drop Down");
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//ul[@class='k-list k-reset']//*[text()='"+Bline+"']")).click();
		//SelectDropDownValue(UnderwriterDrpDown,UnderwriterDrpDownValue);
		//SelectDropDownValue(TechnicianDrpDown,TechnicianDrpDownValue);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("window.scrollBy(0,250)", "");
		sleep(1000);
		verifyMustExists(SaveBtn,"Save Button");
		click(SaveBtn,"Save button");
		//Thread.sleep(5000);
		waitForElementToAppear(PolicytitleOnCotractDetails,5);
		if(isVisible(PolicytitleOnCotractDetails)== true)
		{
			Report.LogInfo("ContractDetailsNav", "User is successfully navigated on Contract Details page.", "PASS");
		}else{
			Report.LogInfo("ContractDetailsNav", "User is not successfully navigated on Contract Details page.", "FAIL");
		}	
		sleep(1000);

	}

	public void addContractBinderDetails_Multiple() throws InterruptedException
	{
		//sleep(3000);
		if(isVisible(PolicySaveBtn)==true){
			waitForElementToAppear(PolicyDrpDown,5);

			SelectDropDownValue(PolicyDrpDown,BinderDrpValue);
			Thread.sleep(1000); 
			verifyMustExists(LoyldYesBtn,"Loyld Yes button");
			click(LoyldYesBtn,"Loyld Yes button");
			SelectDropDownValue(DivisionDrpDown,DivisionDrpValue);

		//	verifyMustExists(CashHoldrmultipleBtn,"Coverholder single button");
			//click(CashHoldrmultipleBtn,"Coverholder single button");

			Thread.sleep(1000);
			verifyMustExists(PolicySaveBtn,"Save button");
			click(PolicySaveBtn,"Save button");
			Thread.sleep(4000);
		}else{
			Report.LogInfo("ElementCheck", "PolicyDrpDown Expected element not found", "FAIL");
		}
	}

	public void addSection()
	{	
		//sleep(5000);
		waitForElementToAppear(AddSectionTab,5);
		scrollUp();
		verifyMustExists(AddSectionTab,"Add Section Tab");
		click(AddSectionTab,"Add Section Tab");
		sleep(2000);
		if(isVisible(AddSectionPopup)==true){
			verifyMustExists(AddSectionPopup,"Add Section Pop up");
			//click(AddSectionPopup,"Add Section Pop up");
			verifyMustExists(SectionReferenceTxt,"Section Reference Textbox");
			sendKeys(SectionReferenceTxt,"Automation section","Section Reference Textbox.");
			verifyMustExists(MarketSectionDescriptionTxt,"Market Section Description Textbox");
			sendKeys(MarketSectionDescriptionTxt,"section created by automation script","Market Section Description Textbox.");
			verifyExists(Brokerage,"Brokerage textbox");
			sendKeys(Brokerage,BrokerageVal,"Brokerage textbox.");
			verifyMustExists(ComissionTxt,"Comission Textbox");
			sendKeys(ComissionTxt,"10","Comission Textbox.");
			verifyMustExists(AdditionalDeductionTxt,"Additional Deduction Textbox");
			sendKeys(AdditionalDeductionTxt,"20","Additional Deduction Textbox.");

			SelectDropDownValue(ClassOfBusinessDD,PropertyRiskValue);

			SelectDropDownValue(SectionCurrencyDD,SectionCurrencyValue);

			verifyMustExists(MaximumLimitOfLiability,"Maximum Limit Of Liability Textbox");
			sendKeys(MaximumLimitOfLiability,"1000000","Maximum Limit Of Liability Textbox.");
			
			verifyMustExists(EstimatedPremiumIncome,"Estimated Premium Income");
			sendKeys(EstimatedPremiumIncome,"100","Estimated Premium Income");
			
			verifyMustExists(GrossPermiumIncomeTxt,"Gross Premium Income Limit Textbox");
			sendKeys(GrossPermiumIncomeTxt,"100","Gross Premium Income Limit Textbox.");
			verifyMustExists(GrossPermiumLimitTxt,"Gross Premium Income Limit Notification Percentage Textbox");
			sendKeys(GrossPermiumLimitTxt,"10","Gross Premium Income Limit Notification Percentage Textbox.");

			SelectDropDownValue(ConductRiskRatingDD,ConductRiskRatingValue);

			verifyExists(SaveBtn,"Save Button");
			click(SaveBtn,"Save Button");
			sleep(2000);
			if(isVisible(secondSectionPopUp) == true)
			{
				verifyExists(SaveBtn1,"Save Button");
				click(SaveBtn1,"Save Button");
				sleep(1000);
			}
			//sleep(3000);
			waitForElementToAppear(sectionTab,5);
			verifyExists(sectionTab,"Section Tab");
			//verifyExists(sectionDetails,"Added Section Details");
		}else{
			Report.LogInfo("ElementCheck", "Expected element not found", "FAIL");
		}

	}

	public void EditSection()
	{
		if(isVisible(SectionCurrencyDD)==true){
			waitForElementToAppear(SectionCurrencyDD,5);
			SelectDropDownValue(SectionCurrencyDD,SectionCurrencyDKKValue);

			//verifyMustExists(EstimatedPermiumIncomeTxt,"Estimated Permium Income Textbox");
			//sendKeys(EstimatedPermiumIncomeTxt,"99999999","Estimated Permium Income Textbox.");
			verifyMustExists(SaveChangesBtn,"Save Changes Button");
			click(SaveChangesBtn,"Save Changes Button");
			sleep(2000);
			verifyMustExists(VerifyEditedSection,"Edited Section");
		}else{
			Report.LogInfo("ElementCheck", "SectionCurrencyDD Expected element not found", "FAIL");
		}
	}

	public void EditRefSection()
	{
		//sleep(3000);
		if(isVisible(EditSectionPopup)==true){
			waitForElementToAppear(EditSectionPopup,5);
			verifyMustExists(EditSectionPopup,"Edit Section Pop up");
			click(EditSectionPopup,"Edit Section Pop up");
			if(isVisible(SectionReferenceTxt)==true){
				verifyMustExists(SectionReferenceTxt,"Section Reference Textbox");
				sendKeys(SectionReferenceTxt,"Test edit","Section Reference Textbox.");
				verifyMustExists(MarketSectionDescriptionTxt,"Market Section Description Textbox");
				sendKeys(MarketSectionDescriptionTxt,"Automation","Market Section Description Textbox.");
				verifyMustExists(SaveChangesBtn,"Save Changes Button");
				click(SaveChangesBtn,"Save Changes Button");
				sleep(2000);
				verifyMustExists(VerifyEditedRefSection,"Edited Reference Section");
			}else{
				Report.LogInfo("ElementCheck", "SectionReferenceTxt Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "EditSectionPopup Expected element not found", "FAIL");
		}
	}

	public void EditSubDivisionSection()
	{
		//sleep(3000);
		if(isVisible(EditSectionPopup)==true){
			waitForElementToAppear(EditSectionPopup,5);
			verifyMustExists(EditSectionPopup,"Edit Section Pop up");
			click(EditSectionPopup,"Edit Section Pop up");
			//SubDiviDrp
			if(isVisible(SubDiviDrp)==true){
				SelectDropDownValue(SubDiviDrp,SubDiviDrpval);
				verifyMustExists(SaveChangesBtn,"Save Changes Button");
				click(SaveChangesBtn,"Save Changes Button");
				sleep(2000);
				//verifyMustExists(VerifyEditedRefSection,"Edited Reference Section");
			}else{
				Report.LogInfo("ElementCheck", "Sub division Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "EditSectionPopup Expected element not found", "FAIL");
		}
	}

	public void writtenToSignedStatus() throws InterruptedException
	{
		if(isVisible(WrittenBtn)==true){
			waitForElementToAppear(WrittenBtn,5);
			click(WrittenBtn,"Written Status");
			waitForElementToAppear(ContractStatusPopUp, 5);
			SelectDropDownValue(ContractStatusDD,ContractStatusSignedValue);
			verifyMustExists(SignedPopupValidation, "Validation text correct");
			sleep(3000);
		}else{
			Report.LogInfo("ElementCheck", "Expected element not found", "FAIL");
		}
	}
	
	public void EditMarketonSection_2() throws InterruptedException
	{
		waitForElementToAppear(ExistingMarketDetails1,5);
		verifyMustExists(ExistingMarketDetails1,"Add Market Button Exista");
		click(ExistingMarketDetails1,"Add Market Button Exista");
		
		if(isVisible(Underwriter)==true){
		waitForElementToAppear(Underwriter,5);
		verifyMustExists(Underwriter,"Underwriter Visible");
		
		Report.LogInfo("ElementCheck", "User can edit underwriter and company reference", "FAIL");
		
		
	
		
	}else{
		Report.LogInfo("ElementCheck", "User cannot edit Underwriter and company reference", "PASS");
	}
	}
	
	public void addMarketOnSectionExists_1() throws InterruptedException
	{
		if(isVisible(AddMarketButton)==true){
			waitForElementToAppear(AddMarketButton,5);
			verifyMustExists(AddMarketButton,"Add Market Button Exista");
			
			
			Report.LogInfo("ElementCheck", "User can add marketr", "FAIL");
			
			}else {
				Report.LogInfo("ElementCheck", " Expected element not found", "PASS");
				
			}
			
			
	
	}
	public void editMarketOnSectionE() throws InterruptedException{
		
			waitForElementToAppear(ExistingMarketDetails,5);
			verifyMustExists(ExistingMarketDetails,"Add Market Button Exista");
			click(ExistingMarketDetails,"Add Market Button Exista");
			
			if(isVisible(Underwriter)==true){
				verifyMustExists(Underwriter,"Underwriter is editable");
			
			Report.LogInfo("ElementCheck", "User can edit underwriter and company reference", "PASS");
			}else{
			Report.LogInfo("ElementCheck", "User cannot edit Underwriter and company reference", "FAIL");
		}
	}
	
	public void addMarketOnSectionExists() throws InterruptedException
	{
		if(isVisible(AddMarketButton)==true){
			
			
			Report.LogInfo("ElementCheck", "User can add Market", "PASS");
			
			}else {
				Report.LogInfo("ElementCheck", " Expected element not found", "FAIL");
				
			}
		
		
	}

	public void addMarketOnSection() throws InterruptedException
	{
		//sleep(3000);
		if(isVisible(AddMarketButton)==true){
			waitForElementToAppear(AddMarketButton,5);
			verifyMustExists(AddMarketButton,"Add Market Button");
			click(AddMarketButton,"Add Market Button");
			sleep(2000);

			if(isVisible(InsurerDropdown)==true){
				verifyMustExists(InsurerDropdown,"Insurer Dropdown");
				click(InsurerDropdown,"Insurer Dropdown");
				sleep(2000);
				if(isVisible(InsurerDDValue)==true){
					waitForElementToAppear(InsurerDDValue,5);
					verifyMustExists(InsurerDDValue,"Insurer Dropdown Value");
					click(InsurerDDValue,"Insurer Dropdown Value");
					sleep(2000);
				}else{
					refreshPage();
					sleep(1000);
					waitForElementToAppear(AddMarketButton,5);
					verifyMustExists(AddMarketButton,"Add Market Button");
					click(AddMarketButton,"Add Market Button");
					sleep(2000);
					SelectDropDownValue(InsurerDropdown,InsurerDDValue);
				}

				//verifyMustExists(WrittenLinePercentTBox,"Written Line Percent Textbox");
				//sendKeys(WrittenLinePercentTBox, "50", "Written Line Percent Textbox");

				verifyMustExists(SignedLinePercentTBox,"Signed Line Percent Textbox");
				sendKeys(SignedLinePercentTBox, "50", "Signed Line Percent Textbox");

				verifyMustExists(IsLeadYesRadioBtn,"Is Lead Yes Radio Button");
				click(IsLeadYesRadioBtn,"Is Lead Yes Radio Button");

				verifyMustExists(SaveBtn,"Market Save Button");
				click(SaveBtn,"Market Save Button");
				sleep(3000);
				if(isVisible(ConEndrsmntPopUp) == true)
				{
					sleep(1000);
					verifyExists(SaveBtn3,"Save Button");
					click(SaveBtn3,"Save Button");
					sleep(3000);
				}
			}
			else{
				Report.LogInfo("ElementCheck", "InsurerDropdown Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "AddMarketButton Expected element not found", "FAIL");
		}
	}
	
	public void RiskCodesExistsOnSection() throws InterruptedException
	{
		if(isVisible(AddRiskCodeButton)==true){
			waitForElementToAppear(AddRiskCodeButton,5);
			verifyMustExists(AddRiskCodeButton,"Add Risk Code Button");
			click(AddRiskCodeButton,"Add Risk Code Button");
			sleep(2000);
			Report.LogInfo("ElementCheck", "RiskCodeDropdown expected element  found", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "RiskCodeDropdown expected element not found", "FAIL");
		}
	}

	public void addRiskCodesOnSection() throws InterruptedException
	{
		//sleep(3000);
		if(isVisible(AddRiskCodeButton)==true){
			waitForElementToAppear(AddRiskCodeButton,5);
			verifyMustExists(AddRiskCodeButton,"Add Risk Code Button");
			click(AddRiskCodeButton,"Add Risk Code Button");
			sleep(2000);

			if(isVisible(RiskCodeDropdown)==true){
				click(RiskCodeDropdown,"Insurer Dropdown");
				sleep(2000);
				if(isVisible(RiskCodeDDValue)==true){
					waitForElementToAppear(RiskCodeDDValue,5);
					verifyMustExists(RiskCodeDDValue,"Risk Code Dropdown Value");
					click(RiskCodeDDValue,"Risk Code Dropdown Value");
				}else{
					refreshPage();
					sleep(1000);
					waitForElementToAppear(AddRiskCodeButton,5);
					verifyMustExists(AddRiskCodeButton,"Add Risk Code Button");
					click(AddRiskCodeButton,"Add Risk Code Button");
					sleep(2000);
					SelectDropDownValue(RiskCodeDropdown,RiskCodeDDValue);
				}
				verifyMustExists(SplitPercentTBox,"Split Percent Textbox");
				sendKeys(SplitPercentTBox, "90", "Split Percent Textbox.");

				verifyMustExists(SaveBtn,"Risk Code Save Button");
				click(SaveBtn,"Risk Code Save Button");
				sleep(2000);
				if(isVisible(SecondRuleSectionPopUp) == true)
				{
					verifyMustExists(SaveBtn4,"Save button");
					click(SaveBtn4,"Save button");
					sleep(1000);
				}

			}else{
				Report.LogInfo("ElementCheck", "RiskCodeDropdown expected element not found", "FAIL");
			}

		}else{
			Report.LogInfo("ElementCheck", "AddRiskCodeButton expected element not found", "FAIL");
		}

	}
	
	public void addCoverholder() throws InterruptedException
    {
            navigateToContractDetailsTab();
            if(isVisible(Coverholdertab)==true){
                    waitForElementToAppear(Coverholdertab,5);
                    verifyMustExists(Coverholdertab,"Add Coverholder Button");
                    click(Coverholdertab,"Add Coverholder Button");
                    verifyMustExists(AddCoverholderBtn,"Add Cover holder button");
                    click(AddCoverholderBtn,"Add Cover holder button");
                    waitForElementToAppear(VerifyAddCoverholder,5);
                    verifyMustExists(VerifyAddCoverholder," Verify Add Cover holder");
                    waitForElementToAppear(coverholderdropdwn,5);
                    SelectDropDownValue(coverholderdropdwn,coverholderddValue);        
                    //SelectDropDownValue(CoverholderContactdropdwn,CoverholderContactddvalue);
                    verifyMustExists(PrimarycoverholderYes,"Primary Coverholder Yes");
                    //click(PrimarycoverholderYes,"Primary Coverholder Yes");
                    sleep(1000);
                    verifyMustExists(coverholderSave,"Cover holder Save");
                    click(coverholderSave,"Cover holder Save");
                    sleep(5000);
            }else{
                    Report.LogInfo("ElementCheck", "Add coverholder Expected element not found", "FAIL");
            }
            
    }

	public void addReportingChannel() throws InterruptedException
	{
		//sleep(3000);
		if(isVisible(AddReportingChannelBtn)==true){
			waitForElementToAppear(AddReportingChannelBtn,5);
			verifyMustExists(AddReportingChannelBtn,"Add Reporting Channel Button");
			click(AddReportingChannelBtn,"Add Reporting Channel Button");
			sleep(2000);
			if(isVisible(ChannelTypeDropdown1)==true){
				SelectDropDownValue(ChannelTypeDropdown,ChannelTypeDDValue);

				SelectDropDownValue(TypeDropdown,TypeDDValue);

				SelectDropDownValue(FrequencyDropdown,FrequencyDDValue);

				verifyMustExists(ReportingChannelIdTBox,"Reporting Channel Identifier Textbox");
				sendKeys(ReportingChannelIdTBox, "Risk Bordereaux", "Reporting Channel Identifier Textbox.");
				verifyMustExists(SaveBtn,"Reporting Channel Save Button");
				click(SaveBtn,"Reporting Channel Save Button");
				sleep(2000);
				if(isVisible(secondSectionPopUp) == true)
				{
					verifyExists(SaveBtn1,"Save Button");
					click(SaveBtn1,"Save Button");
					sleep(1000);
				}
				
				ContSettingPopUpAccept();
				waitForElementToAppear(ReportingChannelRecord,5);
				verifyExists(ReportingChannelRecord,"Reporting Channel Record in List");
				verifyExists(BordereauxTab,"Bordereaux Tab");
			}else{
				Report.LogInfo("ElementCheck", "ChannelTypeDropdown Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "AddReportingChannelBtn Expected element not found", "FAIL");
		}
	}
	
	public void addReportingChannelPer() throws InterruptedException
	{
		//sleep(3000);
		if(isVisible(AddReportingChannelBtn)==true){
			waitForElementToAppear(AddReportingChannelBtn,5);
			verifyMustExists(AddReportingChannelBtn,"Add Reporting Channel Button");
			click(AddReportingChannelBtn,"Add Reporting Channel Button");
			sleep(2000);
			if(isVisible(ChannelTypeDropdown1)==true){
				SelectDropDownValue(ChannelTypeDropdown,ChannelTypeDDValue);

				SelectDropDownValue(TypeDropdown,TypeDDValue);

				SelectDropDownValue(FrequencyDropdown,FrequencyDDValue);

				verifyMustExists(ReportingChannelIdTBox,"Reporting Channel Identifier Textbox");
				sendKeys(ReportingChannelIdTBox, "Risk Bordereaux Test", "Reporting Channel Identifier Textbox.");
				verifyMustExists(SaveBtn,"Reporting Channel Save Button");
				click(SaveBtn,"Reporting Channel Save Button");
				sleep(2000);
				if(isVisible(secondSectionPopUp) == true)
				{
					verifyExists(SaveBtn1,"Save Button");
					click(SaveBtn1,"Save Button");
					sleep(1000);
				}
				
				ContSettingPopUpAccept();
				waitForElementToAppear(ReportingChannelRecord,5);
				verifyExists(ReportingChannelRecord,"Reporting Channel Record in List");
				verifyExists(BordereauxTab,"Bordereaux Tab");
			}else{
				Report.LogInfo("ElementCheck", "ChannelTypeDropdown Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "AddReportingChannelBtn Expected element not found", "FAIL");
		}
	}

	public void selectPolicyFilter(String PolicyNumber)
	{
		int i=0;
		String RecordCheckbox = "@xpath=//ul[@class='k-reset k-multicheck-wrap']//li//span[contains(text(),'"+PolicyNumber+"')]";
		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			waitForElementToAppear(PolicyNumberFilter,5);
			click(PolicyNumberFilter, "Company Name Filter");
			sleep(2000);
			if(isVisible(SearchByTextFilter))
			{
				verifyMustExists(SearchByTextFilter,"Search Filter Textbox");	
				sendKeys(SearchByTextFilter,PolicyNumber,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);

		click(RecordCheckbox, "Searched Record Checkbox");
		verifyMustExists(FilterBtn,"Filter Button");	
		click(FilterBtn,"Filter Button");
	}

	public void navigationOnBordereauxTab() throws InterruptedException
	{
		//sleep(3000);
		if(isVisible(BordereauxTab)==true){
			waitForElementToAppear(BordereauxTab,5);
			verifyMustExists(BordereauxTab,"Bordereaux Tab");
			click(BordereauxTab,"Bordereaux Tab");
			Thread.sleep(2000);
			waitForElementToAppear(Processingtab,5);
			verifyExists(Processingtab,"Processing Link");
			click(Processingtab,"Processing Link");
			sleep(2000);

		}else{
			Report.LogInfo("ElementCheck", "BordereauxTab Expected element not found", "FAIL");
		}
	}

	public void selectPolicy()
	{
		//sleep(3000);(SelectPolicy,30);
		//sleep(3000);
		waitForElementToAppear(SelectPolicy,5);
		verifyMustExists(SelectPolicy,"Policy");
		click(SelectPolicy,"Policy");
		sleep(3000);
	}

	/********************Add Edit Delete *********************/


	public void navigateToVesrionTab() throws InterruptedException
	{
		sleep(2000);
		if(isVisible(VersionTab)==true){
			waitForElementToAppear(VersionTab,5);
			verifyMustExists(VersionTab,"Version Tab");
			click(VersionTab,"Version Tab");
			sleep(2000);
			waitForElementToAppear(VerifySignedVerion,5);
			verifyOptionalExists(VerifySignedVerion,"Signed Verion");
		}else{
			Report.LogInfo("ElementCheck", "VersionTab Expected element not found", "FAIL");
		}
	}

	public void addInterestTab()
	{
		if(isVisible(InterestsTab)==true){
			waitForElementToAppear(InterestsTab,50);
			verifyMustExists(InterestsTab,"Interests tab");
			click(InterestsTab,"Interests tab");
		}else{
			Report.LogInfo("ElementCheck", "Expected element not found", "FAIL");
		}
	}

	public void addInterest()
	{
		if(isVisible(AddIntrestBtn)==true){
			waitForElementToAppear(AddIntrestBtn,5);
			verifyMustExists(AddIntrestBtn,"Add Intrest button");
			click(AddIntrestBtn,"Add Intrest button");
			//sleep(3000);
			if(isVisible(AddInterestPopup)==true){
				waitForElementToAppear(AddInterestPopup,5);
				verifyMustExists(AddInterestPopup,"Add Interest popup");
				SelectDropDownValue(SelectInterestDD,BuildingsValue);

				/*verifyMustExists(SelectInterestDD,"Interest dropdown");
				click(SelectInterestDD,"Interest dropdown");
				verifyMustExists(BuildingsValue,"Buildings value");
				click(BuildingsValue,"Buildings value");*/
				verifyMustExists(SaveBtn,"Save button");
				click(SaveBtn,"Save button");
				//sleep(3000);
				waitForElementToAppear(VerifyAddedInterest,5);
				verifyOptionalExists(VerifyAddedInterest,"Intrest Added");
			}else{
				Report.LogInfo("ElementCheck", "AddInterestPopup Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "AddIntrestBtn Expected element not found", "FAIL");
		}

	}

	public void editInterest()
	{
		if(isVisible(VerifyAddedInterest)==true){
			waitForElementToAppear(VerifyAddedInterest,5);
			verifyMustExists(VerifyAddedInterest,"Intrest Added");
			click(VerifyAddedInterest,"Intrest Added");
			if(isVisible(AddInterestPopup)==true){
				waitForElementToAppear(AddInterestPopup,5);
				verifyMustExists(AddInterestPopup,"Add Interest popup");
				SelectDropDownValue(SelectInterestDD,ContentsValue);

				/*verifyMustExists(SelectInterestDD,"Interest dropdown");
				click(SelectInterestDD,"Interest dropdown");
				verifyMustExists(ContentsValue,"Contents value");
				click(ContentsValue,"Contents value");*/
				verifyMustExists(SaveChangesBtn,"Save Changes button");
				click(SaveChangesBtn,"Save Changes button");
				//sleep(3000);
				waitForElementToAppear(VerifyEditedIntrest,5);
				verifyOptionalExists(VerifyEditedIntrest,"Intrest Added");
			}else{
				Report.LogInfo("ElementCheck", "AddInterestPopup Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "VerifyAddedInterest Expected element not found", "FAIL");
		}
	}

	public void deleteInterest()
	{
		if(isVisible(VerifyEditedIntrest)==true){
			waitForElementToAppear(VerifyEditedIntrest,5);
			verifyMustExists(VerifyEditedIntrest,"Intrest Added");
			click(VerifyEditedIntrest,"Intrest Added");
			verifyMustExists(DeleteBtn,"Delete button");
			click(DeleteBtn,"Delete button");
			//sleep(3000);
			waitForElementToAppear(YesDeleteBtn,50);
			verifyMustExists(YesDeleteBtn,"Yes, Delete it! button");
			click(YesDeleteBtn,"Yes, Delete it! button");
			sleep(2000);
			//waitForElementToAppear(VerifyEditedIntrest,30);
			if(isVisible(VerifyEditedIntrest)== true)
			{
				Report.LogInfo("VerifyDeletedInterest", "Interest not deleted successfully", "FAIL");
			}else{
				Report.LogInfo("VerifyDeletedInterest", "Interest deleted successfully", "PASS");
			}
		}else{
			Report.LogInfo("ElementCheck", "VerifyEditedIntrest Expected element not found", "FAIL");
		}
	}

	public void deleteExistingInterest()
	{
		sleep(3000);
		//waitForElementToAppear(VerifyEditedIntrest,50);
		if(isVisible(VerifyEditedIntrest) == true)
		{
			verifyMustExists(VerifyEditedIntrest,"Intrest Added");
			click(VerifyEditedIntrest,"Intrest Added");
			verifyMustExists(DeleteBtn,"Delete button");
			click(DeleteBtn,"Delete button");
			sleep(3000);
			verifyMustExists(YesDeleteBtn,"Yes, Delete it! button");
			click(YesDeleteBtn,"Yes, Delete it! button");
		}
		if(isVisible(VerifyAddedInterest) == true)
		{
			verifyMustExists(VerifyAddedInterest,"Intrest Added");
			click(VerifyAddedInterest,"Intrest Added");
			verifyMustExists(DeleteBtn,"Delete button");
			click(DeleteBtn,"Delete button");
			sleep(3000);
			verifyMustExists(YesDeleteBtn,"Yes, Delete it! button");
			click(YesDeleteBtn,"Yes, Delete it! button");
		}
	}

	public void perilTab()
	{
		if(isVisible(PerilsTab)==true){
			waitForElementToAppear(PerilsTab,5);
			verifyMustExists(PerilsTab,"Perils Tab");
			click(PerilsTab,"Perils Tab");
		}else{
			Report.LogInfo("ElementCheck", "Expected element not found", "FAIL");
		}
	}

	public void addPeril()
	{
		if(isVisible(AddPerilsBtn)==true){
			waitForElementToAppear(AddPerilsBtn,5);
			verifyMustExists(AddPerilsBtn,"Add Perils button");
			click(AddPerilsBtn,"Add Perils button");
			//sleep(3000);
			if(isVisible(AddPerilsPopup)==true){
				waitForElementToAppear(AddPerilsPopup,5);
				verifyMustExists(AddPerilsPopup,"Add Perils popup");
				SelectDropDownValue(SelectPerilsDD,EarthquakeValue);

				/*verifyMustExists(SelectPerilsDD,"Perils dropdown");
				click(SelectPerilsDD,"Perils dropdown");
				verifyMustExists(EarthquakeValue,"Earthquake value");
				click(EarthquakeValue,"Earthquake value");*/
				verifyMustExists(SaveBtn,"Save button");
				click(SaveBtn,"Save button");
				//sleep(3000);
				waitForElementToAppear(VerifyAddedPerils,5);
				verifyOptionalExists(VerifyAddedPerils,"Perils Added");
			}else{
				Report.LogInfo("ElementCheck", "AddPerilsPopup Expected element not found", "FAIL");
			}

		}else{
			Report.LogInfo("ElementCheck", "AddPerilsBtn Expected element not found", "FAIL");
		}
	}

	public void editPeril()
	{
		if(isVisible(VerifyAddedPerils)==true){
			waitForElementToAppear(VerifyAddedPerils,5);
			verifyMustExists(VerifyAddedPerils,"Perils Added");
			click(VerifyAddedPerils,"Perils Added");
			//sleep(3000);
			if(isVisible(AddPerilsPopup)==true){
				waitForElementToAppear(AddPerilsPopup,5);
				verifyMustExists(AddPerilsPopup,"Add Perils popup");
				SelectDropDownValue(SelectPerilsDD,FireValue);

				/*verifyMustExists(SelectPerilsDD,"Perils dropdown");
				click(SelectPerilsDD,"Perils dropdown");
				verifyMustExists(FireValue,"Fire value");
				click(FireValue,"Fire value");*/
				verifyMustExists(SaveChangesBtn,"Save Changes button");
				click(SaveChangesBtn,"Save Changes button");
				//sleep(3000);
				waitForElementToAppear(VerifyEditedPerils,5);
				verifyOptionalExists(VerifyEditedPerils,"Perils Added");
			}else{
				Report.LogInfo("ElementCheck", "AddPerilsPopup Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "VerifyAddedPerils Expected element not found", "FAIL");
		}
	}

	public void deletePeril()
	{
		if(isVisible(VerifyEditedPerils)==true){
			waitForElementToAppear(VerifyEditedPerils,5);
			verifyMustExists(VerifyEditedPerils,"Perils Edited");
			click(VerifyEditedPerils,"Perils Edited");
			verifyMustExists(DeleteBtn,"Delete button");
			click(DeleteBtn,"Delete button");
			//sleep(3000);
			waitForElementToAppear(YesDeleteBtn,5);
			verifyMustExists(YesDeleteBtn,"Yes, Delete it! button");
			click(YesDeleteBtn,"Yes, Delete it! button");
			sleep(2000);
			if(isVisible(VerifyEditedPerils)== true)
			{
				Report.LogInfo("VerifyDeletedPerils", "Perils not deleted successfully", "FAIL");
			}else{
				Report.LogInfo("VerifyDeletedPerils", "Perils deleted successfully", "PASS");
			}
		}else{
			Report.LogInfo("ElementCheck", "VerifyEditedPerils Expected element not found", "FAIL");
		}
	}

	public void deleteExistingPeril()
	{
		sleep(3000);		
		if(isVisible(VerifyEditedPerils) == true)
		{
			verifyMustExists(VerifyEditedPerils,"Perils Added");
			click(VerifyEditedPerils,"Perils Added");
			verifyMustExists(DeleteBtn,"Delete button");
			click(DeleteBtn,"Delete button");
			sleep(3000);
			verifyMustExists(YesDeleteBtn,"Yes, Delete it! button");
			click(YesDeleteBtn,"Yes, Delete it! button");
		}
		if(isVisible(VerifyAddedPerils) == true)
		{
			verifyMustExists(VerifyAddedPerils,"Perils Added");
			click(VerifyAddedPerils,"Perils Added");
			verifyMustExists(DeleteBtn,"Delete button");
			click(DeleteBtn,"Delete button");
			sleep(3000);
			verifyMustExists(YesDeleteBtn,"Yes, Delete it! button");
			click(YesDeleteBtn,"Yes, Delete it! button");
		}
	}


	public void limitTab()
	{
		if(isVisible(LimitTab)==true){
			waitForElementToAppear(LimitTab,5);
			verifyMustExists(LimitTab,"Limit Tab");
			click(LimitTab,"Limit Tab");
		}else{
			Report.LogInfo("ElementCheck", "LimitTab Expected element not found", "FAIL");
		}

	}

	public void addLimit()
	{
		String LimitName = "Test open market limit field";
		String ExcessLimit = "0";
		String Limit = "10000";
		String Deductible = "10";

		//sleep(3000);
		if(isVisible(AddLimitBtn)==true){
			waitForElementToAppear(AddLimitBtn,5);
			verifyMustExists(AddLimitBtn,"Add Limit button");
			click(AddLimitBtn,"Add Limit button");
			//sleep(3000);
			if(isVisible(AddLimitPopup)==true){
				waitForElementToAppear(AddLimitPopup,5);
				verifyMustExists(AddLimitPopup,"Add Limit popup");
				verifyMustExists(LimitNameTxt,"Limit Name textbox");
				sendKeys(LimitNameTxt,LimitName,"Limit Name");
				SelectDropDownValue(LimitBasisDD,AnyOneEventValue);

				/*verifyMustExists(LimitBasisDD,"Limit Basis dropdown");
				click(LimitBasisDD,"Limit Basis dropdown");
				verifyMustExists(AnyOneEventValue,"Any One Event value");
				click(AnyOneEventValue,"Any One Event value");*/

				SelectDropDownValue(LimitCurrencyDD,INRValue);

				/*verifyMustExists(LimitCurrencyDD,"Limit Currency dropdown");
				click(LimitCurrencyDD,"Limit Currency dropdown");
				verifyMustExists(INRValue,"INR value");
				click(INRValue,"INR value");*/

				verifyMustExists(LimitTxt,"Limit textbox");
				sendKeys(LimitTxt,Limit,"Limit textbox");
				verifyMustExists(ExcessTxt ,"Excess textbox");
				sendKeys(ExcessTxt ,ExcessLimit,"Excess textbox");
				verifyMustExists(DeductibleTxt ,"Deductible textbox");
				sendKeys(DeductibleTxt ,Deductible,"Deductible textbox");

				SelectDropDownValue(DeductibleTypeDD,AmountValue);

				/*verifyMustExists(DeductibleTypeDD,"Deductible Type dropdown");
				click(DeductibleTypeDD ,"Limit Currency dropdown");
				verifyMustExists(AmountValue,"Amount value");
				click(AmountValue,"Amount value");*/

				verifyMustExists(SaveBtn,"Save button");
				click(SaveBtn,"Save button");
				//sleep(3000);
				waitForElementToAppear(VerifyAddedLimit,5);
				verifyOptionalExists(VerifyAddedLimit,"Limit Added");
			}else{
				Report.LogInfo("ElementCheck", "AddLimitPopup Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "AddLimitBtn Expected element not found", "FAIL");
		}

	}

	public void editLimit()
	{
		if(isVisible(VerifyAddedLimit)==true){
			waitForElementToAppear(VerifyAddedLimit,5);
			verifyMustExists(VerifyAddedLimit,"Limit Added");
			click(VerifyAddedLimit,"Limit Added");
			//sleep(3000);
			if(isVisible(AddLimitPopup)==true){
				waitForElementToAppear(AddLimitPopup,5);
				verifyMustExists(AddLimitPopup,"Add Limit popup");
				SelectDropDownValue(DeductibleTypeDD,PercentageValue);

				/*verifyMustExists(DeductibleTypeDD,"Deductible Type dropdown");
				click(DeductibleTypeDD,"Deductible Type dropdown");
				verifyMustExists(PercentageValue,"Percentage value");
				click(PercentageValue,"Percentage value");*/
				verifyMustExists(SaveChangesBtn,"Save Changes button");
				click(SaveChangesBtn,"Save Changes button");
				//sleep(3000);
				waitForElementToAppear(VerifyEditedLimit,5);
				verifyOptionalExists(VerifyEditedLimit,"Limit Added");
			}else{
				Report.LogInfo("ElementCheck", "AddLimitPopup Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "VerifyAddedLimit Expected element not found", "FAIL");
		}

	}

	public void deleteLimit()
	{
		if(isVisible(VerifyEditedLimit)==true){
			waitForElementToAppear(VerifyEditedLimit,5);
			click(VerifyEditedLimit,"Limit Edited");
			verifyMustExists(DeleteBtn,"Delete button");
			click(DeleteBtn,"Delete button");
			//sleep(3000);
			waitForElementToAppear(YesDeleteBtn,5);
			verifyMustExists(YesDeleteBtn,"Yes, Delete it! button");
			click(YesDeleteBtn,"Yes, Delete it! button");
			sleep(2000);
			if(isVisible(VerifyEditedPerils)== true)
			{
				Report.LogInfo("VerifyDeletedLimit", "Limit not deleted successfully", "FAIL");
			}else{
				Report.LogInfo("VerifyDeletedLimit", "Limit deleted successfully", "PASS");
			}
		}else{
			Report.LogInfo("ElementCheck", "Expected element not found", "FAIL");
		}

	}

	public void deleteExistingLimit()
	{
		sleep(3000);
		if(isVisible(VerifyEditedLimit) == true)
		{
			verifyMustExists(VerifyEditedLimit,"Limit Added");
			click(VerifyEditedLimit,"Limit Added");
			verifyMustExists(DeleteBtn,"Delete button");
			click(DeleteBtn,"Delete button");
			//sleep(3000);
			waitForElementToAppear(YesDeleteBtn,5);
			verifyMustExists(YesDeleteBtn,"Yes, Delete it! button");
			click(YesDeleteBtn,"Yes, Delete it! button");
		}
		if(isVisible(VerifyAddedLimit) == true)
		{
			verifyMustExists(VerifyAddedLimit,"Limit Added");
			click(VerifyAddedLimit,"Limit Added");
			verifyMustExists(DeleteBtn,"Delete button");
			click(DeleteBtn,"Delete button");
			//sleep(3000);
			waitForElementToAppear(YesDeleteBtn,5);
			verifyMustExists(YesDeleteBtn,"Yes, Delete it! button");
			click(YesDeleteBtn,"Yes, Delete it! button");
		}
	}
  public void navigateSectionRulesTab()
  {
	  if(isVisible(SectionRulesTab)==true){
		  waitForElementToAppear(SectionRulesTab,5);
		verifyMustExists(SectionRulesTab,"Rules Tab");
		click(SectionRulesTab,"Rules Tab");
	  } else {
		  Report.LogInfo("ElementCheck", "RulesTab Expected element not found", "FAIL");  
	  }
  }
  public void VerifyRulesTab()
	{
		if(isVisible(RulesTab)==true){
			waitForElementToAppear(RulesTab,5);
			verifyMustExists(RulesTab,"Rules Tab");
			click(RulesTab,"Rules Tab");
			verifyMustExists(AddRuleButton,"Add Rule Button");
			verifyMustExists(EditRulebtn1,"Edit Rule buttin exists");
			
			Report.LogInfo("ElementCheck", "RulesTab Expected element  found", "PASS");
			
		}else{
			Report.LogInfo("ElementCheck", "RulesTab Expected element not found", "FAIL");
		}
	}
  
	public void navigateRulesTab_1()
	{
		if(isVisible(RulesTab)==true){
			waitForElementToAppear(RulesTab,5);
			verifyMustExists(RulesTab,"Rules Tab");
			click(RulesTab,"Rules Tab");
			verifyMustExists(RulesTabHeader3,"Rule Name");
			verifyMustExists(RulesTabHeader4,"Schema");
			verifyMustExists(RulesTabHeader5,"Rule condition");
			verifyMustExists(RulesTabHeader6,"Rule Breaches");
			verifyMustExists(RulesTabHeader7,"Status");
			verifyMustExists(RulesTabHeader8,"Created By");
			verifyMustExists(RulesTabHeader9,"Created Date");
			verifyMustExists(AddRuleButton,"Created Date");
			Report.LogInfo("ElementCheck", "RulesTab Expected element  found", "PASS");
			
		}else{
			Report.LogInfo("ElementCheck", "RulesTab Expected element not found", "FAIL");
		}
	}
	public void navigateRulesTab()
	{
		if(isVisible(RulesTab)==true){
			waitForElementToAppear(RulesTab,5);
			verifyMustExists(RulesTab,"Rules Tab");
			click(RulesTab,"Rules Tab");
			verifyMustExists(RulesTabHeader3,"Rule Name");
			verifyMustExists(RulesTabHeader4,"Schema");
			verifyMustExists(RulesTabHeader5,"Rule condition");
			verifyMustExists(RulesTabHeader6,"Rule Breaches");
			verifyMustExists(RulesTabHeader7,"Status");
			verifyMustExists(RulesTabHeader8,"Created By");
			verifyMustExists(RulesTabHeader9,"Created Date");
			//verifyMustExists(AddRuleButton,"Created Date");
			Report.LogInfo("ElementCheck", "RulesTab Expected element  found", "PASS");
			
		}else{
			Report.LogInfo("ElementCheck", "RulesTab Expected element not found", "FAIL");
		}
	}

	public void navigateRulesGeneralTab()
	{
		if(isVisible(RulesGeneralTab)==true){
			waitForElementToAppear(RulesGeneralTab,5);
			verifyMustExists(RulesGeneralTab,"Rules Tab");
			click(RulesGeneralTab,"Rules Tab");

			if(isVisible(EditRulebtn)==true){
				verifyMustExists(EditRulebtn,"Edit Rules button");
				click(EditRulebtn,"Edit Rules button");
			}else{
				Report.LogInfo("ElementCheck", "Edit rule Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "RulesTab Expected element not found", "FAIL");
		}
	}
	
	public void TransformationnavigateRulesGeneralTab()
	{
		if(isVisible(RulesGeneralTab)==true){
			waitForElementToAppear(RulesGeneralTab,5);
			verifyMustExists(RulesGeneralTab,"Rules Tab");
			click(RulesGeneralTab,"Rules Tab");

			if(isVisible(EditRulebtn)==true){
				verifyMustExists(EditRulebtn,"Edit Rules button");
				click(EditRulebtn,"Edit Rules button");
				Report.LogInfo("ElementCheck", "RulesTab Expected element  found", "FAIL");
			}else{
				Report.LogInfo("ElementCheck", "Edit rule Expected element not found", "PASS");
			}
		}else{
			Report.LogInfo("ElementCheck", "RulesTab Expected element not found", "FAIL");
		}
	}
	
	public void navigateRulesGeneralTabNoEditBtn()
	{
		if(isVisible(RulesGeneralTab)==true){
			waitForElementToAppear(RulesGeneralTab,5);
			verifyMustExists(RulesGeneralTab,"Rules Tab");
			click(RulesGeneralTab,"Rules Tab");

			if(isVisible(EditRulebtn)==true){
				/*verifyMustExists(EditRulebtn,"Edit Rules button");
				click(EditRulebtn,"Edit Rules button");*/
				Report.LogInfo("ElementCheck", "Edit rule Expected element not found", "FAIL");

			}else{
				Report.LogInfo("ElementCheck", "Edit rule Expected element not found", "PASS");
			}
		}else{
			Report.LogInfo("ElementCheck", "RulesTab Expected element not found", "FAIL");
		}
	}
	
	public void navigateRulesGeneralTab1()
	{
		if(isVisible(RulesGeneralTab)==true){
			waitForElementToAppear(RulesGeneralTab,5);
			verifyMustExists(RulesGeneralTab,"Rules Tab");
			click(RulesGeneralTab,"Rules Tab");

			if(isVisible(EditRulebtn)==true){
				/*verifyMustExists(EditRulebtn,"Edit Rules button");
				click(EditRulebtn,"Edit Rules button");*/
				Report.LogInfo("ElementCheck", "Edit rule Expected element found", "FAIL");

			}else{
				Report.LogInfo("ElementCheck", "Edit rule Expected element not found", "PASS");
			}
		}else{
			Report.LogInfo("ElementCheck", "RulesTab Expected element not found", "FAIL");
		}
	}

	public void navigateContarctDetailsTab()
	{
		if(isVisible(contractDetailsTab)==true){
			waitForElementToAppear(contractDetailsTab,5);
			verifyMustExists(contractDetailsTab,"contract Details Tab");
			click(contractDetailsTab,"contract Details Tab");
		}else{
			Report.LogInfo("ElementCheck", "Contract Details Expected element not found", "FAIL");
		}
	}

	public void navigateClaimsAuthorityTab()
	{
		if(isVisible(ClaimsAuthorityTab)==true){
			waitForElementToAppear(ClaimsAuthorityTab,7);
			verifyMustExists(ClaimsAuthorityTab,"contract Details Tab");
			click(ClaimsAuthorityTab,"contract Details Tab");
		}else{
			Report.LogInfo("ElementCheck", "Contract Details Expected element not found", "FAIL");
		}

		if(isVisible(EditRulebtn)==true){
			
			Report.LogInfo("ElementCheck", "Edit Claims Expected element  found", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Edit Claims Expected element not found", "FAIL");
		}
	}
	
	public void ReadonlyUsernavigateClaimsAuthorityTab()
	{
		if(isVisible(ClaimsAuthorityTab)==true){
			waitForElementToAppear(ClaimsAuthorityTab,5);
			verifyMustExists(ClaimsAuthorityTab,"contract Details Tab");
			click(ClaimsAuthorityTab,"contract Details Tab");
		}else{
			Report.LogInfo("ElementCheck", "Contract Details Expected element not found", "FAIL");
		}

		if(isVisible(EditRulebtn)==true){
			verifyExists(EditRulebtn,"Edit Claims button");
			Report.LogInfo("ElementCheck", "Edit Claims Expected element  found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit Claims Expected element not found", "PASS");
		}
	}
	
	public void navigateClaimsAuthorityTab1()
	{
		if(isVisible(ClaimsAuthorityTab)==true){
			waitForElementToAppear(ClaimsAuthorityTab,5);
			verifyMustExists(ClaimsAuthorityTab,"contract Details Tab");
			click(ClaimsAuthorityTab,"contract Details Tab");
		}else{
			Report.LogInfo("ElementCheck", "Contract Details Expected element not found", "FAIL");
		}
      sleep(3000);
		if(isVisible(EditRulebtn)==true){
			//verifyExists(EditRulebtn,"Edit Claims button");
			//click(EditRulebtn,"Edit Claims button");
			Report.LogInfo("ElementCheck", "Edit Claims element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit Claims element not found", "PASS");
		}
	}


	public void navigateMainRulesTab()
	{
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(-250,0 );");
		sleep(1000);
		waitForElementToAppear(MainRule,5);
		verifyMustExists(MainRule,"Rules Tab");
		click(MainRule,"Rules Tab");
	}
	public void navigateBreachesTab()
	{
		waitForElementToAppear(BreachesTab,5);
		verifyMustExists(BreachesTab,"Breaches Tab");
		click(BreachesTab,"Breaches Tab");
	}


	public void navigateGeneralTab()
	{
		waitForElementToAppear(GeneralTab,5);
		verifyMustExists(GeneralTab,"General Tab");
		click(GeneralTab,"General Tab");
	}

	public void navigateLocationTab()
	{
		if(isVisible(LocationTab)==true){
			waitForElementToAppear(LocationTab,5);
			verifyMustExists(LocationTab,"Location Tab");
			click(LocationTab,"Location Tab");
		}else{
			Report.LogInfo("ElementCheck", "Location tab expected element not found", "FAIL");
		}
	}
	
	public void verifyLocationEdit()
	{
		navigateLocationTab();
		
		
	}

	public void navigateBespokeTab()
	{
		waitForElementToAppear(BespokeTab,5);
		verifyMustExists(BespokeTab,"Bespoke Tab");
		click(BespokeTab,"Bespoke Tab");
	}











	/****************************************************/

	public void addRules()
	{
		if(isVisible(AddRulesBtn)==true){
			waitForElementToAppear(AddRulesBtn,5);
			verifyMustExists(AddRulesBtn,"Add Rules button");
			click(AddRulesBtn,"Add Rules button");
			//sleep(3000);
			if(isVisible(AddRulesPopup)==true){
				waitForElementToAppear(AddRulesPopup,5);
				verifyMustExists(AddRulesPopup,"Add Rules popup");
				verifyMustExists(RuleNameTxt,"Rules Name textbox");
				sendKeys(RuleNameTxt,Rule,"Rules Name");
				SelectDropDownValue(DatasetTypeDD,RiskValue);

				SelectDropDownValue(ApplicationConditionDD,ConditionMetValue);

				SelectDropDownValue(CurrencyDD,CurrencyINRValue);				
				sleep(2000);
				//SelectDropDownValue(ApplicableSecDD,ApplicableSecVal);
				verifyMustExists(ApplicableSection,"Applicable Section");
				click(ApplicableSection,"Applicable Section");
				sleep(1000);
				verifyMustExists(ApplicableSectionvalue,"Applicable Section");
				click(ApplicableSectionvalue,"Applicable Section");
				sleep(1000);
				verifyMustExists(ROEToleranceTxt,"ROE Tolerance textbox");
				sendKeys(ROEToleranceTxt,"5","ROE Tolerance textbox");
				verifyMustExists(AddRuleConditionBtn,"Add Rule Condition button");
				click(AddRuleConditionBtn,"Add Rule Condition button");
				sleep(3000);
				scrollDown();
				SelectDropDownValue(FieldNameDD,YOAValue);
				sleep(2000);
				SelectDropDownValue(OperatorDD,EqualToValue);
				sleep(2000);
				SelectDropDownValue(AppliedToDD,Value);
				sleep(2000);
				verifyMustExists(EntryOrSelectionTxt ,"Entry Or Selection textbox");
				sendKeys(EntryOrSelectionTxt ,"5","Entry Or Selection textbox");
				sleep(2000);
				verifyMustExists(CheckBtn,"Check button");
				click(CheckBtn,"Check button");
				//sleep(3000);
				waitForElementToAppear(SaveBtn,5);
				verifyMustExists(SaveBtn,"Save button");
				click(SaveBtn,"Save button");
				sleep(3000);
			}else{
				Report.LogInfo("ElementCheck", "AddRulesPopup Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "AddRulesBtn Expected element not found", "FAIL");
		}
	}

	public void editRules()
	{
		JavascriptExecutor js = (JavascriptExecutor)webDriver;
		js.executeScript("arguments[0].click();", webDriver.findElement(By.xpath("//*[text()='"+Rule+"']//preceding-sibling::td/div")));
		//sleep(3000);
		if(isVisible(AddRulesPopup)==true){
			waitForElementToAppear(AddRulesPopup,5);
			verifyMustExists(AddRulesPopup,"Add Rules popup");
			if(isVisible(RuleNameTxt)==true){
				verifyMustExists(RuleNameTxt,"Rules Name textbox");
				sendKeys(RuleNameTxt,Rule1,"Rules Name");
				verifyMustExists(ROEToleranceTxt,"ROE Tolerance textbox");
				sendKeys(ROEToleranceTxt,"2","ROE Tolerance textbox");
				verifyMustExists(AddRuleConditionBtn,"Add Rule Condition button");
				click(AddRuleConditionBtn,"Add Rule Condition button");
				scrollDown();
				sleep(2000);
				WebElement Section = webDriver.findElement(By.xpath("//dt//span[contains(.,'Applicable Section')]//following::input[1]"));
				//WebElement SectionRemove = webDriver.findElement(By.xpath("//dt//span[contains(.,'Applicable Section')]//following::input[1]//following::span[1]"));
				Actions a = new Actions(webDriver);
				sleep(1000);
				a.click(Section).build().perform();
				a.sendKeys(Section, Keys.BACK_SPACE).build().perform();
				sleep(1000);
				verifyMustExists(ApplicableSection,"Applicable Section");
				click(ApplicableSection,"Applicable Section");
				sleep(1000);
				verifyMustExists(ApplicableSectionvalue,"Applicable Section");
				click(ApplicableSectionvalue,"Applicable Section");
				sleep(1000);
				SelectDropDownValue(MethodDD,AndValue);
				sleep(1000);
				SelectDropDownValue(FieldNameDD,TransactionTypeValue);
				sleep(1000);
				SelectDropDownValue(OperatorDD,EqualToValue);
				sleep(1000);
				SelectDropDownValue(AppliedToDD,Value);
				sleep(1000);
				SelectDropDownValue(EntryOrSelectionDD,EntryOrSelectionValue);
				sleep(1000);
				verifyMustExists(CheckBtn,"Check button");
				click(CheckBtn,"Check button");
				verifyMustExists(SaveChangesBtn,"Save Changes button");
				click(SaveChangesBtn,"Save Changes button");
				sleep(3000);
				if(isVisible(secondSectionPopUp) == true)
				{
					verifyExists(SaveBtn1,"Save Button");
					click(SaveBtn1,"Save Button");
					sleep(1000);
				}
			}else{
				Report.LogInfo("ElementCheck", "RuleNameTxt Expected element not found", "FAIL");
			}

		}else{
			Report.LogInfo("ElementCheck", "AddRulesPopup Expected element not found", "FAIL");
		}

	}

	public void deleteRules()
	{
		JavascriptExecutor js = (JavascriptExecutor)webDriver;
		js.executeScript("arguments[0].click();", webDriver.findElement(By.xpath("//*[text()='"+Rule1+"']//preceding-sibling::td/div")));
		sleep(5000);
		//sleep(2000);

		WebElement Section = webDriver.findElement(By.xpath("//dt//span[contains(.,'Applicable Section')]//following::input[1]"));
		//WebElement SectionRemove = webDriver.findElement(By.xpath("//dt//span[contains(.,'Applicable Section')]//following::input[1]//following::span[1]"));
		Actions a = new Actions(webDriver);
		sleep(1000);
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.BACK_SPACE).build().perform();
		sleep(1000);
		verifyMustExists(ApplicableSection,"Applicable Section");
		click(ApplicableSection,"Applicable Section");
		sleep(1000);
		verifyMustExists(ApplicableSectionvalue,"Applicable Section");
		click(ApplicableSectionvalue,"Applicable Section");
		if(isVisible(RuleDeleteBtn) == true)
		{
			verifyMustExists(RuleDeleteBtn,"Delete button");
			click(RuleDeleteBtn,"Delete button");
			sleep(3000);
			verifyMustExists(YesDeleteBtn,"Yes, Delete it! button");
			click(YesDeleteBtn,"Yes, Delete it! button");
		}
		if(isVisible(RuleDeleteBtn1) == true)
		{
			verifyMustExists(RuleDeleteBtn1,"Delete button");
			click(RuleDeleteBtn1,"Delete button");
			waitForElementToAppear(YesDeleteBtn,5);
			verifyMustExists(YesDeleteBtn,"Yes, Delete it! button");
			click(YesDeleteBtn,"Yes, Delete it! button");
		}
		sleep(2000);
		if(isVisible(RuleDeleteBtn) || isVisible(RuleDeleteBtn1) == true)
		{
			Report.LogInfo("VerifyDeletedRules", "Rules not deleted successfully", "FAIL");
		}else{
			Report.LogInfo("VerifyDeletedRules", "Rules deleted successfully", "PASS");
		}
		verifyMustExists(SaveChangesBtn,"Save Changes button");
		click(SaveChangesBtn,"Save Changes button");
		sleep(2000);
	}

	public void addGeneralRule(String SetelmentDays)
	{
		waitForElementToAppear(EditDot,5);
		verifyMustExists(EditDot,"Edit Dots");
		click(EditDot,"Edit Dots");
		verifyMustExists(GeneralEdit,"Edit label");
		click(GeneralEdit,"Edit label");
		
		verifyMustExists(TypicalPolicyPeriodMonths,"TypicalPolicyPeriodMonths");
		sendKeys(TypicalPolicyPeriodMonths,"1","TypicalPolicyPeriodMonths textbox");
		verifyMustExists(MaxPolicyPeriodMonthsTxt,"Maximum Policy Period Months textbox");
		sendKeys(MaxPolicyPeriodMonthsTxt,"7","Maximum Policy Period Months textbox");
		verifyMustExists(DaysPolicyIssuedTxt,"Days Policy Issued Prior to Inception textbox");
		sendKeys(DaysPolicyIssuedTxt,"90","Days Policy Issued Prior to Inception textbox");
		verifyMustExists(SettlementDueDaysTxt,"Settlement Due Days textbox");
		sendKeys(SettlementDueDaysTxt,SetelmentDays,"Settlement Due Days textbox");
		verifyMustExists(SaveBtn,"Save button");
		click(SaveBtn,"Save button");
		sleep(3000);
		if(isVisible(ConEndrsmntPopUp) == true)
		{
			sleep(1000);
			verifyExists(SaveBtn3,"Save Button");
			click(SaveBtn3,"Save Button");
			sleep(3000);
		}
		if(isVisible(GeneralTabError)== true)
		{
			Report.LogInfo("GeneralTabError", "Invalid column name 'GPIncomeLimit'. Invalid column name 'GPILNotificationPercentage'. ", "FAIL");
		}
	}

	public void addLocationRule()
	{
		waitForElementToAppear(EditDotsLocation,5);
		verifyMustExists(EditDotsLocation,"Edit dots button");
		click(EditDotsLocation,"Edit dots button");
		verifyMustExists(EditLocationBtn,"Edit button");
		click(EditLocationBtn,"Edit button");
		verifyMustExists(NorthAmericaExpandArrow,"North America Expand Arrow");
		click(NorthAmericaExpandArrow,"North America Expand Arrow");
		verifyMustExists(UnitedStatesChk,"United States checkbox");
		click(UnitedStatesChk,"United States checkbox");
		verifyMustExists(SaveBtn,"Save button");
		javaScriptclick(SaveBtn,"Save button");
		sleep(1000);
		if(isVisible(ConEndrsmntPopUp) == true)
		{
			sleep(1000);
			verifyExists(SaveBtn3,"Save Button");
			click(SaveBtn3,"Save Button");
			sleep(3000);
		}
	}

	public void verifyBrancesDDValues()
	{
		waitForElementToAppear(RulesDD,3);
		if(isVisible(RulesDD)==true){		
			verifyMustExists(RulesDD,"Rules dropdown");
			click(RulesDD,"Rules dropdown");
			List<WebElement> Rules = webDriver.findElements(By.xpath("//ul[@aria-hidden='false']//li"));
			if(Rules.size() == 4)
			{
				Report.LogInfo("BranchesRules", "Branches Rules available in dropdown list", "PASS");
			}
			else
			{
				Report.LogInfo("BranchesRules", "Branches Rules not available in dropdown list", "FAIL");
			}
		}else{
			Report.LogInfo("DropDownCheck", "Rule dropdown is not visible", "FAIL");
		}
		
		click(RulesDD,"Rules dropdown");
	}

	public void addBespokeContractRules()
	{
		verifyMustExists(AddRulesBtn,"Add Rule button");
		click(AddRulesBtn,"Add Rule button");
		waitForElementToAppear(AddRulesPopup,5);
		verifyMustExists(AddRulesPopup,"Add Rules popup");
		verifyMustExists(RuleNameTxt,"Rules Name textbox");
		sendKeys(RuleNameTxt,"Test Rule","Rules Name");
		SelectDropDownValue(DatasetTypeDD,RiskValue);
		SelectDropDownValue(ApplicationConditionDD,ConditionMetValue1);
		SelectDropDownValue(CurrencyDD,CurrencyGBPValue);
		verifyMustExists(ROEToleranceTxt,"ROE Tolerance textbox");
		sendKeys(ROEToleranceTxt,"4","ROE Tolerance textbox");
		WebElement Section = webDriver.findElement(By.xpath("//dt//span[contains(.,'Applicable Section')]//following::input[1]"));
		Actions a = new Actions(webDriver);
		sleep(1000);
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.BACK_SPACE).build().perform();
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.ENTER).build().perform();
		sleep(1000);
		verifyMustExists(AddRuleConditionBtn,"Add Rule Condition button");
		click(AddRuleConditionBtn,"Add Rule Condition button");
		scrollDown();
		SelectDropDownValue(FieldNameDD,YOAValue);
		SelectDropDownValue(OperatorDD,GreaterThan);
		SelectDropDownValue(AppliedToDD,Value);
		verifyMustExists(EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(EntryOrSelectionTxt ,"10","Entry Or Selection textbox");
		verifyMustExists(CheckBtn,"Check button");
		click(CheckBtn,"Check button");
		waitForElementToAppear(SaveBtn,5);
		verifyMustExists(SaveBtn,"Save button");
		click(SaveBtn,"Save button");
		sleep(3000);
		if(isVisible(ConEndrsmntPopUp) == true)
		{
			sleep(1000);
			verifyExists(SaveBtn3,"Save Button");
			click(SaveBtn3,"Save Button");
			sleep(3000);
		}
		/*if(isVisible(secondSectionPopUp) == true)
	  {
	   verifyExists(SaveBtn1,"Save Button");
	   click(SaveBtn1,"Save Button");
	   sleep(2000);
	  }*/
	}

	public void editBespokeRules()
	{
		waitForElementToAppear(EditBespokeRuleBtn,5);
		verifyExists(EditBespokeRuleBtn,"Edit Button");
		click(EditBespokeRuleBtn,"Edit Button");
		waitForElementToAppear(AddRulesPopup,5);
		verifyMustExists(AddRulesPopup,"Add Rules popup");
		verifyMustExists(RuleNameTxt,"Rules Name textbox");
		sendKeys(RuleNameTxt,"Test","Rules Name");
		//verifyMustExists(ROEToleranceTxt,"ROE Tolerance textbox");
		//sendKeys(ROEToleranceTxt,"2","ROE Tolerance textbox");
		verifyMustExists(AddRuleConditionBtn,"Add Rule Condition button");
		click(AddRuleConditionBtn,"Add Rule Condition button");
		scrollDown();
		sleep(2000);
		WebElement Section = webDriver.findElement(By.xpath("//dt//span[contains(.,'Applicable Section')]//following::input[1]"));
		//WebElement SectionRemove = webDriver.findElement(By.xpath("//dt//span[contains(.,'Applicable Section')]//following::input[1]//following::span[1]"));
		Actions a = new Actions(webDriver);
		sleep(1000);
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.BACK_SPACE).build().perform();
		sleep(1000);
		verifyMustExists(ApplicableSection,"Applicable Section");
		click(ApplicableSection,"Applicable Section");
		sleep(1000);
		verifyMustExists(ApplicableSectionvalue,"Applicable Section");
		click(ApplicableSectionvalue,"Applicable Section");
		SelectDropDownValue(MethodDD,AndValue);

		SelectDropDownValue(FieldNameDD,TransactionTypeValue);

		SelectDropDownValue(OperatorDD,EqualToValue);

		SelectDropDownValue(AppliedToDD,Value);

		SelectDropDownValue(EntryOrSelectionDD,EntryOrSelectionValue);

		verifyMustExists(CheckBtn,"Check button");
		click(CheckBtn,"Check button");
		verifyMustExists(SaveChangesBtn,"Save Changes button");
		click(SaveChangesBtn,"Save Changes button");
		sleep(3000);
		if(isVisible(ConEndrsmntPopUp) == true)
		{
			sleep(1000);
			verifyExists(SaveBtn3,"Save Button");
			click(SaveBtn3,"Save Button");
			sleep(3000);
		}
	}

	public void deleteBespokeRule()
	{
		verifyMustExists(EditBespokeRuleBtn,"Edit Button");
		click(EditBespokeRuleBtn,"Edit Button");
		waitForElementToAppear(AddRulesPopup,5);
		WebElement Section = webDriver.findElement(By.xpath("//dt//span[contains(.,'Applicable Section')]//following::input[1]"));
		//WebElement SectionRemove = webDriver.findElement(By.xpath("//dt//span[contains(.,'Applicable Section')]//following::input[1]//following::span[1]"));
		Actions a = new Actions(webDriver);
		sleep(1000);
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.BACK_SPACE).build().perform();
		sleep(1000);
		verifyMustExists(ApplicableSection,"Applicable Section");
		click(ApplicableSection,"Applicable Section");
		sleep(1000);
		verifyMustExists(ApplicableSectionvalue,"Applicable Section");
		click(ApplicableSectionvalue,"Applicable Section");
		if(isVisible(RuleDeleteBtn) == true)
		{
			verifyMustExists(RuleDeleteBtn,"Delete button");
			click(RuleDeleteBtn,"Delete button");
			sleep(3000);
			verifyMustExists(YesDeleteBtn,"Yes, Delete it! button");
			click(YesDeleteBtn,"Yes, Delete it! button");
		}
		if(isVisible(RuleDeleteBtn1) == true)
		{
			verifyMustExists(RuleDeleteBtn1,"Delete button");
			click(RuleDeleteBtn1,"Delete button");
			waitForElementToAppear(YesDeleteBtn,5);
			verifyMustExists(YesDeleteBtn,"Yes, Delete it! button");
			click(YesDeleteBtn,"Yes, Delete it! button");
		}
		sleep(2000);
		if(isVisible(RuleDeleteBtn) || isVisible(RuleDeleteBtn1) == true)
		{
			Report.LogInfo("VerifyDeletedRules", "Rules not deleted successfully", "FAIL");
		}else{
			Report.LogInfo("VerifyDeletedRules", "Rules deleted successfully", "PASS");
		}
		verifyMustExists(SaveChangesBtn,"Save Changes button");
		click(SaveChangesBtn,"Save Changes button");
		sleep(2000);
		if(isVisible(secondSectionPopUp) == true)
		{
			verifyExists(SaveBtn1,"Save Button");
			click(SaveBtn1,"Save Button");
			sleep(1000);
		}
	}

	public void addBespokeInformationRules()
	{
		verifyMustExists(AddRuleDownArrow,"AddRule Down Arrow");
		click(AddRuleDownArrow,"AddRule Down Arrow");
		verifyMustExists(InformationOption,"Information Option");
		click(InformationOption,"Information Option");
		//sleep(3000);
		waitForElementToAppear(AddRulesPopup,5);
		verifyMustExists(AddRulesPopup,"Add Rules popup");
		verifyMustExists(RuleNameTxt,"Rules Name textbox");
		sendKeys(RuleNameTxt,"Information Rule","Rules textbox");
		verifyMustExists(ErrorMessageTxt,"Error Message textbox");
		sendKeys(ErrorMessageTxt,"Premium amount error","Error Message textbox");
		SelectDropDownValue(DatasetTypeDD,PremiumValue);

		/*verifyMustExists(DatasetTypeDD,"Dateset dropdown");
		click(DatasetTypeDD,"Dateset dropdown");
		verifyMustExists(PremiumValue,"Premium value");
		click(PremiumValue,"Premium value");*/
		SelectDropDownValue(SchemaDD,SchemaValue);

		/*verifyMustExists(SchemaDD,"Schema dropdown");
		click(SchemaDD,"Schema dropdown");
		verifyMustExists(SchemaValue,"Schema value");
		click(SchemaValue,"Schema value");*/
		SelectDropDownValue(ApplicationConditionDD,ConditionMetValue1);

		/*verifyMustExists(ApplicationConditionDD,"Application Condition dropdown");
		click(ApplicationConditionDD,"Application Condition dropdown");
		verifyMustExists(ConditionMetValue1,"Condition Met value");
		click(ConditionMetValue1,"Condition Met value");*/
		verifyMustExists(AddRuleConditionBtn,"Add Rule Condition button");
		click(AddRuleConditionBtn,"Add Rule Condition button");
		scrollDown();
		SelectDropDownValue(FieldNameDD,GrossPremiumValue);

		/*verifyMustExists(FieldNameDD,"Field Name dropdown");
		click(FieldNameDD,"Field Name dropdown");
		verifyMustExists(GrossPremiumValue,"Gross Premium value");
		click(GrossPremiumValue,"Gross Premium value");*/
		SelectDropDownValue(OperatorDD,GreaterThan);

		/*verifyMustExists(OperatorDD,"Operator dropdown");
		click(OperatorDD,"Operator dropdown");
		verifyMustExists(GreaterThan,"Greater Than Value");
		click(GreaterThan,"Greater Than Value");*/
		SelectDropDownValue(AppliedToDD,Value);

		/*verifyMustExists(AppliedToDD,"Applied To dropdown");
		click(AppliedToDD,"Applied To dropdown");
		verifyMustExists(Value,"Value");
		click(Value,"Value");*/
		verifyMustExists(EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(EntryOrSelectionTxt ,"10000000","Entry Or Selection textbox");
		verifyMustExists(CheckBtn,"Check button");
		click(CheckBtn,"Check button");

		verifyMustExists(AddRuleConditionBtn,"Add Rule Condition button");
		click(AddRuleConditionBtn,"Add Rule Condition button");
		scrollDown();
		sleep(2000);
		SelectDropDownValue(MethodDD,AndValue);
		SelectDropDownValue(FieldNameDD,NetPremiumValue);
		SelectDropDownValue(OperatorDD,GreaterThan);
		SelectDropDownValue(AppliedToDD,Value);
		verifyMustExists(EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(EntryOrSelectionTxt ,"10000000","Entry Or Selection textbox");
		verifyMustExists(CheckBtn,"Check button");
		click(CheckBtn,"Check button");
		waitForElementToAppear(SaveBtn,5);
		verifyMustExists(SaveBtn,"Save button");
		click(SaveBtn,"Save button");
		sleep(3000);
		if(isVisible(secondSectionPopUp) == true)
		{
			verifyExists(SaveBtn1,"Save Button");
			click(SaveBtn1,"Save Button");
			sleep(1000);
		}
		sleep(2000);
	}
	public void deleteInformationRule()
	{
		verifyMustExists(EditBespokeRuleBtn,"Edit Button");
		click(EditBespokeRuleBtn,"Edit Button");
		waitForElementToAppear(AddRulesPopup,5);
		sleep(1000);
		SelectDropDownValue(SchemaDD,SchemaValue);

		/*verifyMustExists(SchemaDD,"Schema dropdown");
		click(SchemaDD,"Schema dropdown");
		verifyMustExists(SchemaValue,"Schema value");
		click(SchemaValue,"Schema value");*/
		if(isVisible(YesChangeItBtn) == true)
		{
			verifyMustExists(YesChangeItBtn,"Yes Channge It button");
			click(YesChangeItBtn,"Yes Channge It button");
		}

		if(isVisible(RuleDeleteBtn) == true)
		{
			verifyMustExists(RuleDeleteBtn,"Delete button");
			click(RuleDeleteBtn,"Delete button");
			sleep(3000);
			verifyMustExists(YesDeleteBtn,"Yes, Delete it! button");
			click(YesDeleteBtn,"Yes, Delete it! button");
		}
		if(isVisible(RuleDeleteBtn1) == true)
		{
			verifyMustExists(RuleDeleteBtn1,"Delete button");
			click(RuleDeleteBtn1,"Delete button");
			waitForElementToAppear(YesDeleteBtn,5);
			verifyMustExists(YesDeleteBtn,"Yes, Delete it! button");
			click(YesDeleteBtn,"Yes, Delete it! button");
		}
		sleep(2000);
		if(isVisible(RuleDeleteBtn) || isVisible(RuleDeleteBtn1) == true)
		{
			Report.LogInfo("VerifyDeletedRules", "Rules not deleted successfully", "FAIL");
		}else{
			Report.LogInfo("VerifyDeletedRules", "Rules deleted successfully", "PASS");
		}
		verifyMustExists(SaveChangesBtn,"Save Changes button");
		click(SaveChangesBtn,"Save Changes button");
		sleep(2000);
		if(isVisible(secondSectionPopUp) == true)
		{
			verifyExists(SaveBtn1,"Save Button");
			click(SaveBtn1,"Save Button");
			sleep(1000);
		}
	}

	public void addPolicy2(String InceptionDate, String InceptionDateExp) throws InterruptedException
	{
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		//loginPage.tideLogin();
		navigationOnPolicyTab();
		navigationOnAddContractPage();
		navigationOnSelectPolicyPopUp();
		navigationOnAddPolicyPopUp();
		addContractBinderDetails();
		addPolicyContractDetails1(UniqueReferenceVal1, InceptionDate, InceptionDateExp, Status1, Broker2, Bline2, Underline2);

		//sleep(3000);
		waitForElementToAppear(DraftBtn,5);
		verifyExists(DraftBtn,"Draft Status Button");
	}

	public void addPolicyContractDetails2(String UniqueReferenceName, String InceptionDates, String InceptionExp, String Status, String Broker, String Bline, String Underline ) throws InterruptedException
	{
		//sleep(3000);
		waitForElementToAppear(Policytitle,5);
		PolicyNumber = getTextFrom(Policytitle);
		verifyMustExists(UniqueReference,"Unique Reference textbox");
		sendKeys(UniqueReference,UniqueReferenceName,"Unique Reference textbox.");
		SelectDropDownValue(ContractCurrencyDrpDown,ContractCurrencyDrpDownValue1);
		verifyMustExists(CompanyReference,"Company Reference textbox");
		sendKeys(CompanyReference,CompanyReferenceval,"Company Reference textbox.");
		verifyMustExists(ContractStatusDrpDown,"Contract Status Drop Down");
		click(ContractStatusDrpDown,"Contract Status Drop Down");
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//ul[@class='k-list k-reset']//*[text()='"+Status+"']")).click();
		verifyMustExists(BrokerDrpDown,"Broker Drop Down");
		click(BrokerDrpDown,"Broker Drop Down");
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//ul[@class='k-list k-reset']//*[text()='"+Broker+"']")).click();
		verifyMustExists(InceptionDateIcon,"Inception Date");
		sendKeys(InceptionDateIcon,InceptionDates,"Inception Date field."); 
		if(isVisible(ExpDtpop)==true)
		{

			verifyMustExists(ErrorPopUpOKbtn,"Error Pop Up OK button");
			click(ErrorPopUpOKbtn,"Error Pop Up OK buttonn");
			waitForElementToAppear(ExpiryDateIcon,5);
			sendKeys(ExpiryDateIcon,InceptionExp,"Expiry date");
		}else{
			waitForElementToAppear(ExpiryDateIcon,5);
			sendKeys(ExpiryDateIcon,InceptionExp,"Expiry date");
		}
		verifyMustExists(LineofBusinessDrpDown,"Line of Business Drop Down");
		click(LineofBusinessDrpDown,"Line of Business Drop Down");
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//ul[@class='k-list k-reset']//*[text()='"+Bline+"']")).click();
		SelectDropDownValue(UnderwriterDrpDown,UnderwriterDrpDownValue);

		SelectDropDownValue(TechnicianDrpDown,TechnicianDrpDownValue);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("window.scrollBy(0,250)", "");
		sleep(1000);
		verifyMustExists(SaveBtn,"Save Button");
		click(SaveBtn,"Save button");
		//Thread.sleep(5000);
		waitForElementToAppear(PolicytitleOnCotractDetails,5);
		if(isVisible(PolicytitleOnCotractDetails)== true)
		{
			Report.LogInfo("ContractDetailsNav", "User is successfully navigated on Contract Details page.", "PASS");
		}else{
			Report.LogInfo("ContractDetailsNav", "User is not successfully navigated on Contract Details page.", "FAIL");
		} 
		sleep(1000);
	}

	public void addReportingChannelForpremium() throws InterruptedException
	{
		//sleep(3000);
		waitForElementToAppear(AddReportingChannelBtn,5);
		verifyMustExists(AddReportingChannelBtn,"Add Reporting Channel Button");
		click(AddReportingChannelBtn,"Add Reporting Channel Button");
		SelectDropDownValue(ChannelTypeDropdown,ChannelTypeDDValue);

		SelectDropDownValue(TypeDropdown,TypeDDValuePrem);

		SelectDropDownValue(FrequencyDropdown,FrequencyDDValue);

		verifyMustExists(ReportingChannelIdTBox,"Reporting Channel Identifier Textbox");
		sendKeys(ReportingChannelIdTBox, "Premium Bordereaux", "Reporting Channel Identifier Textbox.");
		verifyMustExists(SaveBtn,"Reporting Channel Save Button");
		click(SaveBtn,"Reporting Channel Save Button");
		sleep(2000);
		if(isVisible(secondSectionPopUp) == true)
		{
			verifyExists(SaveBtn1,"Save Button");
			click(SaveBtn1,"Save Button");
			sleep(1000);
		}
		ContSettingPopUpAccept();		
		verifyExists(ReportingChannelRecord,"Reporting Channel Record in List");
		verifyExists(BordereauxTab,"Bordereaux Tab");
	}

	public void addReportingChannelForAnyComb(String TypeVal, String FreqDDval) throws InterruptedException
	{
		String TypeDDValuePrem ="@xpath=//ul[@class='k-list k-reset']//li[text()='"+TypeVal+"']";
		String FrequencyDDValue ="@xpath=//ul[@class='k-list k-reset']//li[text()='"+FreqDDval+"']";

		//sleep(3000);
		waitForElementToAppear(AddReportingChannelBtn,5);
		verifyMustExists(AddReportingChannelBtn,"Add Reporting Channel Button");
		click(AddReportingChannelBtn,"Add Reporting Channel Button");
		SelectDropDownValue(ChannelTypeDropdown,ChannelTypeDDValue);

		SelectDropDownValue(TypeDropdown,TypeDDValuePrem);

		SelectDropDownValue(FrequencyDropdown,FrequencyDDValue);

		verifyMustExists(ReportingChannelIdTBox,"Reporting Channel Identifier Textbox");
		sendKeys(ReportingChannelIdTBox, "Premium Bordereaux", "Reporting Channel Identifier Textbox.");
		verifyMustExists(SaveBtn,"Reporting Channel Save Button");
		click(SaveBtn,"Reporting Channel Save Button");
		sleep(2000);
		if(isVisible(secondSectionPopUp) == true)
		{
			verifyExists(SaveBtn1,"Save Button");
			click(SaveBtn1,"Save Button");
			sleep(1000);
		}
		ContSettingPopUpAccept();		
		verifyExists(ReportingChannelRecord,"Reporting Channel Record in List");
		verifyExists(BordereauxTab,"Bordereaux Tab");
	}

	public void addReportingChannelForclaim() throws InterruptedException
	{
		//sleep(3000);
		waitForElementToAppear(AddReportingChannelBtn,5);
		verifyMustExists(AddReportingChannelBtn,"Add Reporting Channel Button");
		click(AddReportingChannelBtn,"Add Reporting Channel Button");
		SelectDropDownValue(ChannelTypeDropdown,ChannelTypeDDValue);

		SelectDropDownValue(TypeDropdown,TypeDDValuePrem);

		SelectDropDownValue(FrequencyDropdown,FrequencyDDValue);

		verifyMustExists(ReportingChannelIdTBox,"Reporting Channel Identifier Textbox");
		sendKeys(ReportingChannelIdTBox, "Premium Bordereaux", "Reporting Channel Identifier Textbox.");
		verifyMustExists(SaveBtn,"Reporting Channel Save Button");
		click(SaveBtn,"Reporting Channel Save Button");
		sleep(2000);
		if(isVisible(secondSectionPopUp) == true)
		{
			verifyExists(SaveBtn1,"Save Button");
			click(SaveBtn1,"Save Button");
			sleep(1000);
		}
		ContSettingPopUpAccept();		
		verifyExists(ReportingChannelRecord,"Reporting Channel Record in List");
		verifyExists(BordereauxTab,"Bordereaux Tab");
	}

	public void addPolicyContractDetails1(String UniqueReferenceName, String InceptionDates, String Status, String Broker, String Bline, String Underline ) throws InterruptedException
	{
		//sleep(3000);
		waitForElementToAppear(Policytitle,5);
		PolicyNumber = getTextFrom(Policytitle);
		//System.out.println(PolicyNumber);
		verifyMustExists(UniqueReference,"Unique Reference textbox");
		sendKeys(UniqueReference,PolicyNumber,"Unique Reference textbox.");
		SelectDropDownValue(ContractCurrencyDrpDown,ContractCurrencyDrpDownValue);

		verifyMustExists(CompanyReference,"Company Reference textbox");
		sendKeys(CompanyReference,CompanyReferenceval,"Company Reference textbox.");

		verifyMustExists(ContractStatusDrpDown,"Contract Status Drop Down");
		click(ContractStatusDrpDown,"Contract Status Drop Down");
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//ul[@class='k-list k-reset']//*[text()='"+Status+"']")).click();
		verifyMustExists(BrokerDrpDown,"Broker Drop Down");
		click(BrokerDrpDown,"Broker Drop Down");
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//ul[@class='k-list k-reset']//*[text()='"+Broker+"']")).click();
		verifyMustExists(InceptionDateIcon,"Inception Date");
		sendKeys(InceptionDateIcon,InceptionDates,"Inception Date field.");  
		verifyMustExists(LineofBusinessDrpDown,"Line of Business Drop Down");
		click(LineofBusinessDrpDown,"Line of Business Drop Down");
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//ul[@class='k-list k-reset']//*[text()='"+Bline+"']")).click();
		SelectDropDownValue(UnderwriterDrpDown,UnderwriterDrpDownValue);
		SelectDropDownValue(TechnicianDrpDown,TechnicianDrpDownValue);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("window.scrollBy(0,250)", "");
		sleep(1000);
		verifyMustExists(SaveBtn,"Save Button");
		click(SaveBtn,"Save button");
		sleep(1000);
	}

	public void createAnotherContractForSamePolicy1() throws Exception
	{
		//String PolicyNo = "746052UY";
		OpenPolicy = "@xpath=//*[@id='FolderListGrid']//tr//td[contains(.,'"+PolicyNumber+"')]";
		//OpenPolicy = "@xpath=//*[@id='FolderListGrid']//tr//td[contains(.,'"+PolicyNo+"')]";
		navigationOnPolicyTab();
		navigationOnAddContractPage();
		navigationOnSelectPolicyPopUp();
		selectPolicyFilter1(PolicyNumber);
		sleep(3000); 
	}

	public void addReportingChannelClaim() throws InterruptedException
	{
		//sleep(3000);
		if(isVisible(AddReportingChannelBtn)==true){
			waitForElementToAppear(AddReportingChannelBtn,5);
			verifyMustExists(AddReportingChannelBtn,"Add Reporting Channel Button");
			click(AddReportingChannelBtn,"Add Reporting Channel Button");
			sleep(2000);
			if(isVisible(ChannelTypeDropdown1)==true){
				SelectDropDownValue(ChannelTypeDropdown,ChannelTypeDDValue);

				SelectDropDownValue(TypeDropdown,TypeDDValueClaim);

				SelectDropDownValue(FrequencyDropdown,FrequencyDDValue);

				verifyMustExists(ReportingChannelIdTBox,"Reporting Channel Identifier Textbox");
				sendKeys(ReportingChannelIdTBox, "Claim Bordereaux", "Reporting Channel Identifier Textbox.");
				verifyMustExists(SaveBtn,"Reporting Channel Save Button");
				click(SaveBtn,"Reporting Channel Save Button");
				sleep(2000);
				if(isVisible(secondSectionPopUp) == true)
				{
					verifyExists(SaveBtn1,"Save Button");
					click(SaveBtn1,"Save Button");
					sleep(1000);
				}
				ContSettingPopUpAccept();
				waitForElementToAppear(ReportingChannelRecord,5);
				verifyExists(ReportingChannelRecord,"Reporting Channel Record in List");
				verifyExists(BordereauxTab,"Bordereaux Tab");
			}else{
				Report.LogInfo("ElementCheck", "ChannelTypeDropdown Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "AddReportingChannelBtn Expected element not found", "FAIL");
		}
	}

	public void selectPolicyFilter1(String PolicyNumber) throws Exception
	{
		String UniqueReferenceVal3 = "Automation Policy"+getCurrentTime();
		int i=0;
		String RecordCheckbox = "@xpath=//ul[@class='k-reset k-multicheck-wrap']//li//span[contains(text(),'"+PolicyNumber+"')]";
		javaScriptWait();


		do
		{
			if(i>0)
			{
				refreshPage();


				javaScriptWait();
			}
			if(isVisible(PolicyNumberFilter)==true){
				//waitForElementToAppear(PolicyNumberFilter,5);
				click(PolicyNumberFilter, "Company Name Filter");
				sleep(2000);
				//navigationOnSelectPolicyPopUp();
				//waitForElementToAppear(PolicyNumberFilter,5);
				//click(PolicyNumberFilter, "Company Name Filter");
				//sleep(2000);
			}


			if(isVisible(SearchByTextFilter))
			{

				verifyMustExists(SearchByTextFilter,"Search Filter Textbox");	
				sendKeys(SearchByTextFilter,PolicyNumber,"Search Filter Textbox.");		
				if(isVisible(RecordCheckbox)==true){
					Report.LogInfo("ValidateRecord", "Record Found successfully", "PASS");
					click(RecordCheckbox, "Searched Record Checkbox");
					verifyMustExists(FilterBtn,"Filter Button");	
					click(FilterBtn,"Filter Button");
					waitForElementToAppear(OpenPolicy,5);
					click(OpenPolicy,"Policy");
					click(SelectBtn,"Select button");
					//sleep(3000);		
					addPolicyContractDetails1(UniqueReferenceVal3, InceptionDate2, Status1, Broker2, Bline2, Underline2);
					verifyExists(DraftBtn,"Draft Status Button");

				}else{
					Report.LogInfo("ValidateRecord", "Created Policy Record not Found.", "FAIL");
					//refreshPage();
					sleep(1000);
				}
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<1);		
		//refreshPage();		
	}

	public String getCurrentTime(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmssSS");
		String strDate = sdf.format(cal.getTime());
		//System.out.println("Current date in String Format: "+strDate); 
		return strDate;
	}

	public void EditBrekaregeSection(String value)
	{
		sleep(3000);
		if(isVisible(BrokerageDD)==true){
			waitForElementToAppear(BrokerageDD,5);

			verifyMustExists(BrokerageDD,"Brokerage field");
			sendKeys(BrokerageDD,value,"Brokerage value");
			verifyMustExists(ConductRiskRatingDD,"Conduct Risk Rating");
			click(ConductRiskRatingDD,"Conduct Risk Rating");
			sleep(1000);
			click(ConductRiskRatingValue,"Low Value");
			sleep(1000);	
			verifyMustExists(SaveChangesBtn,"Save Changes Button");
			click(SaveChangesBtn,"Save Changes Button");
			waitForElementToAppear(Savebtn,10);
			verifyMustExists(Savebtn,"Save Changes Button");
			click(Savebtn,"Save Changes Button");
			waitForElementToAppear(VerifyEditedBrokerageSection,10);
			verifyMustExists(VerifyEditedBrokerageSection,"Edited brokerage Section");
		}else{
			Report.LogInfo("ElementCheck", " Expected brokerage element not found", "FAIL");
		}

	}

	/*******************************Sprint 5 Reusable*************************************/

	public void addContractBinderDetails1(String Division, String Cardholder) throws InterruptedException
	{
		String DivisionDrpValue1 = "@xpath=//ul[@aria-hidden='false']//li[contains(.,'"+Division+"')]";
		String CardholderName = "@xpath=//ul[@aria-hidden='false']//li[contains(.,'"+Cardholder+"')]";

		if(isVisible(PolicySaveBtn)==true){
			waitForElementToAppear(PolicyDrpDown,5);
			SelectDropDownValue(PolicyDrpDown,BinderDrpValue);
			SelectDropDownValue(DivisionDrpDown,DivisionDrpValue1);
			verifyMustExists(CashHoldrSingleBtn,"Coverholder single button");
			click(CashHoldrSingleBtn,"Coverholder single button");
			Thread.sleep(1000);
			SelectDropDownValue(CoverholderDrpDown,CardholderName);
			verifyMustExists(PolicySaveBtn,"Save button");
			click(PolicySaveBtn,"Save button");
			Thread.sleep(4000);
		}else{
			Report.LogInfo("ElementCheck", "PolicyDrpDown Expected element not found", "FAIL");
		}
	}

	public void addReportingChannel1(String Type, String DueDays, String NumberExpected, String Identifier) throws InterruptedException
	{
		if(isVisible(AddReportingChannelBtn)==true){
			verifyMustExists(AddReportingChannelBtn,"Add Reporting Channel Button");
			click(AddReportingChannelBtn,"Add Reporting Channel Button");
			sleep(2000);
			if(isVisible(ChannelTypeDropdown1)==true){
				SelectDropDownValue(ChannelTypeDropdown,ChannelTypeDDValue);
				SelectDropDownValue(TypeDropdown,Type);
				SelectDropDownValue(FrequencyDropdown,FrequencyDDValue);
				verifyMustExists(DueDaysTxt,"Due Days Textbox");
				sendKeys(DueDaysTxt, DueDays, "Due Days Textbox.");
				verifyMustExists(NumberExpectedTxt,"Number Expected Textbox");
				sendKeys(NumberExpectedTxt, NumberExpected, "Number Expected Textbox.");
				verifyMustExists(ReportingChannelIdTBox,"Reporting Channel Identifier Textbox");
				sendKeys(ReportingChannelIdTBox, Identifier, "Reporting Channel Identifier Textbox.");
				verifyMustExists(SaveBtn,"Reporting Channel Save Button");
				click(SaveBtn,"Reporting Channel Save Button");
				sleep(2000);
				if(isVisible(secondSectionPopUp) == true)
				{
					verifyExists(SaveBtn1,"Save Button");
					click(SaveBtn1,"Save Button");
					sleep(1000);
				}
				AcceptConSettUpdate();
				waitForElementToAppear(ReportingChannelRecord,5);
				verifyExists(ReportingChannelRecord,"Reporting Channel Record in List");
				verifyExists(BordereauxTab,"Bordereaux Tab");
			}else{
				Report.LogInfo("ElementCheck", "ChannelTypeDropdown Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "AddReportingChannelBtn Expected element not found", "FAIL");
		}
	}

	public void addSection1(String SectionRef, String BrokerageVal, String ClassOfBVal, String EPermiumIncome, String GPermiumIncome, String GPermiumLimit)
	{	
		waitForElementToAppear(AddSectionTab,5);
		verifyMustExists(AddSectionTab,"Add Section Tab");
		click(AddSectionTab,"Add Section Tab");
		sleep(2000);
		if(isVisible(AddSectionPopup)==true){
			verifyMustExists(SectionReferenceTxt,"Section Reference Textbox");
			sendKeys(SectionReferenceTxt,SectionRef,"Section Reference Textbox.");
			verifyMustExists(MarketSectionDescriptionTxt,"Market Section Description Textbox");
			sendKeys(MarketSectionDescriptionTxt,SectionRef,"Market Section Description Textbox.");
			verifyExists(Brokerage,"Brokerage textbox");
			sendKeys(Brokerage,BrokerageVal,"Brokerage textbox.");
			verifyMustExists(ComissionTxt,"Comission Textbox");
			sendKeys(ComissionTxt,"10","Comission Textbox.");
			verifyMustExists(AdditionalDeductionTxt,"Additional Deduction Textbox");
			sendKeys(AdditionalDeductionTxt,"10","Additional Deduction Textbox.");
			SelectDropDownValue(ClassOfBusinessDD,ClassOfBVal);
			SelectDropDownValue(SectionCurrencyDD,SectionCurrencyValue1);
			if(isVisible(MaximumLimitofLiabilityTxt) == true)
			{
				verifyMustExists(MaximumLimitofLiabilityTxt,"Estimated Permium Income Textbox");
				sendKeys(MaximumLimitofLiabilityTxt,EPermiumIncome,"Estimated Permium Income Textbox.");
			}
			if(isVisible(EstimatedPermiumIncomeTxt) == true)
			{
				verifyMustExists(EstimatedPermiumIncomeTxt,"Estimated Permium Income Textbox");
				sendKeys(EstimatedPermiumIncomeTxt,EPermiumIncome,"Estimated Permium Income Textbox.");
			}
			verifyMustExists(GrossPermiumIncomeTxt,"Gross Premium Income Limit Textbox");
			sendKeys(GrossPermiumIncomeTxt,GPermiumIncome,"Gross Premium Income Limit Textbox.");
			verifyMustExists(GrossPermiumLimitTxt,"Gross Premium Income Limit Notification Percentage Textbox");
			sendKeys(GrossPermiumLimitTxt,GPermiumLimit,"Gross Premium Income Limit Notification Percentage Textbox.");
			SelectDropDownValue(ConductRiskRatingDD,ConductRiskRatingValue);
			verifyExists(SaveBtn,"Save Button");
			click(SaveBtn,"Save Button");
			sleep(2000);
			if(isVisible(secondSectionPopUp) == true)
			{
				verifyExists(SaveBtn1,"Save Button");
				click(SaveBtn1,"Save Button");
				sleep(1000);
			}
			waitForElementToAppear(sectionTab,5);
			verifyExists(sectionTab,"Section Tab");
		}
		else{
			Report.LogInfo("ElementCheck", "Expected element not found", "FAIL");
		}
	}

	public void addSection2(String SectionRef, String BrokerageVal, String ClassOfBVal, String Currncy, String EPermiumIncome, String GPermiumIncome, String GPermiumLimit, String RiskRatting)
	{	
		String CurrencyVal = "@xpath=//ul[@aria-hidden='false']//li[contains(.,'"+Currncy+"')]";
		String ConductRiskRatingValue="@xpath=//ul//li[contains(.,'"+RiskRatting+"')]";
		String CBVal = "@xpath=//ul//li[contains(.,'"+ClassOfBVal+"')]";

		waitForElementToAppear(AddSectionTab,5);
		verifyMustExists(AddSectionTab,"Add Section Tab");
		javaScriptclick(AddSectionTab,"Add Section Tab");
		sleep(2000);
		if(isVisible(AddSectionPopup)==true){
			verifyMustExists(SectionReferenceTxt,"Section Reference Textbox");
			sendKeys(SectionReferenceTxt,SectionRef,"Section Reference Textbox.");
			verifyMustExists(MarketSectionDescriptionTxt,"Market Section Description Textbox");
			sendKeys(MarketSectionDescriptionTxt,SectionRef,"Market Section Description Textbox.");
			verifyExists(Brokerage,"Brokerage textbox");
			sendKeys(Brokerage,BrokerageVal,"Brokerage textbox.");
			verifyMustExists(ComissionTxt,"Comission Textbox");
			sendKeys(ComissionTxt,"10","Comission Textbox.");
			verifyMustExists(AdditionalDeductionTxt,"Additional Deduction Textbox");
			sendKeys(AdditionalDeductionTxt,"10","Additional Deduction Textbox.");
			SelectDropDownValue(ClassOfBusinessDD,CBVal);
			SelectDropDownValue(SectionCurrencyDD,CurrencyVal);
			if(isVisible(MaximumLimitofLiabilityTxt) == true)
			{
				verifyMustExists(MaximumLimitofLiabilityTxt,"Estimated Permium Income Textbox");
				sendKeys(MaximumLimitofLiabilityTxt,EPermiumIncome,"Estimated Permium Income Textbox.");
			}
			if(isVisible(EstimatedPermiumIncomeTxt) == true)
			{
				verifyMustExists(EstimatedPermiumIncomeTxt,"Estimated Permium Income Textbox");
				sendKeys(EstimatedPermiumIncomeTxt,EPermiumIncome,"Estimated Permium Income Textbox.");
			}
			verifyMustExists(GrossPermiumIncomeTxt,"Gross Premium Income Limit Textbox");
			sendKeys(GrossPermiumIncomeTxt,GPermiumIncome,"Gross Premium Income Limit Textbox.");
			verifyMustExists(GrossPermiumLimitTxt,"Gross Premium Income Limit Notification Percentage Textbox");
			sendKeys(GrossPermiumLimitTxt,GPermiumLimit,"Gross Premium Income Limit Notification Percentage Textbox.");
			SelectDropDownValue(ConductRiskRatingDD,ConductRiskRatingValue);
			verifyExists(SaveBtn,"Save Button");
			javaScriptclick(SaveBtn,"Save Button");
			sleep(2000);
			if(isVisible(secondSectionPopUp) == true)
			{
				verifyExists(SaveBtn1,"Save Button");
				javaScriptclick(SaveBtn1,"Save Button");
				sleep(1000);
			}
			if(isVisible(ConEndrsmntPopUp) == true)
			{
				sleep(1000);
				verifyExists(SaveBtn3,"Save Button");
				javaScriptclick(SaveBtn3,"Save Button");
				sleep(3000);
			}
			waitForElementToAppear(sectionTab,5);
			verifyExists(sectionTab,"Section Tab");
		}
		else{
			Report.LogInfo("ElementCheck", "Expected element not found", "FAIL");
		}
	}
	public void navigateToSectionTab1() throws InterruptedException
	{
		if(isVisible(sectionTab)==true){
			verifyMustExists(sectionTab,"Section Tab");
			click(sectionTab,"Section Tab");
		}else{
			Report.LogInfo("ElementCheck", "SectionTab Expected element not found", "FAIL");
		}
	}
	public void navigateToSectionTab2() throws InterruptedException
	{
		if(isVisible(sectionTab1)==true){
			verifyMustExists(sectionTab1,"Section Tab");
			click(sectionTab1," Click on Section Tab");
		}else{
			Report.LogInfo("ElementCheck", "SectionTab Expected element not found", "FAIL");
		}
	}

	public void addMarketOnSection1(String Insurer, String WLinePercent, String SLinePercent) throws InterruptedException
	{
		String InsurerDDValue1 ="@xpath=//ul[@aria-hidden='false']//li[contains(.,'"+Insurer+"')]";

		if(isVisible(AddMarketButton)==true){
			waitForElementToAppear(AddMarketButton,5);
			verifyMustExists(AddMarketButton,"Add Market Button");
			click(AddMarketButton,"Add Market Button");
			sleep(2000);
			SelectDropDownValue(InsurerDropdown,InsurerDDValue1);
			verifyMustExists(SignedLinePercentTBox,"Signed Line Percent Textbox");
			sendKeys(SignedLinePercentTBox, SLinePercent, "Signed Line Percent Textbox");
			verifyMustExists(IsLeadYesRadioBtn,"Is Lead Yes Radio Button");
			click(IsLeadYesRadioBtn,"Is Lead Yes Radio Button");
			verifyMustExists(SaveBtn,"Market Save Button");
			click(SaveBtn,"Market Save Button");
			sleep(3000);
		}
		else{
			Report.LogInfo("ElementCheck", "InsurerDropdown Expected element not found", "FAIL");
		}
	}

	public void addRiskCodesOnSection(String RiskCode) throws InterruptedException
	{
		String RiskCodeDDValue ="@xpath=//ul[@aria-hidden='false']//li[contains(.,'"+RiskCode+"')]";
		if(isVisible(AddRiskCodeButton)==true){
			verifyMustExists(AddRiskCodeButton,"Add Risk Code Button");
			click(AddRiskCodeButton,"Add Risk Code Button");
			sleep(2000);
			if(isVisible(RiskCodeDropdown)==false){
				javaScriptclick(AddRiskCodeButton,"Add Risk Code Button");
				sleep(2000);
			}
			SelectDropDownValue(RiskCodeDropdown,RiskCodeDDValue);
			verifyMustExists(SplitPercentTBox,"Split Percent Textbox");
			sendKeys(SplitPercentTBox, "100", "Split Percent Textbox.");
			verifyMustExists(SaveBtn,"Risk Code Save Button");
			click(SaveBtn,"Risk Code Save Button");
			sleep(5000);
			if(isVisible(ConEndrsmntPopUp) == true)
			{
				sleep(1000);
				verifyExists(SaveBtn3,"Save Button");
				javaScriptclick(SaveBtn3,"Save Button");
				sleep(3000);
			}

		}else{
			Report.LogInfo("ElementCheck", "RiskCodeDropdown expected element not found", "FAIL");
		}
	}

	public void addRiskCodesOnSection(String RiskCode, String Percntg) throws InterruptedException
	{
		String RiskCodeDDValue ="@xpath=//ul[@aria-hidden='false']//li[contains(.,'"+RiskCode+"')]";
		if(isVisible(AddRiskCodeButton)==true){
			verifyMustExists(AddRiskCodeButton,"Add Risk Code Button");
			click(AddRiskCodeButton,"Add Risk Code Button");
			sleep(2000);
			if(isVisible(RiskCodeDropdown)==false){
				javaScriptclick(AddRiskCodeButton,"Add Risk Code Button");
				sleep(2000);
			}
			SelectDropDownValue(RiskCodeDropdown,RiskCodeDDValue);
			verifyMustExists(SplitPercentTBox,"Split Percent Textbox");
			sendKeys(SplitPercentTBox, Percntg, "Split Percent Textbox.");
			verifyMustExists(SaveBtn,"Risk Code Save Button");
			click(SaveBtn,"Risk Code Save Button");
			sleep(5000);
			if(isVisible(ConEndrsmntPopUp) == true)
			{
				sleep(1000);
				verifyExists(SaveBtn3,"Save Button");
				javaScriptclick(SaveBtn3,"Save Button");
				sleep(3000);
			}

		}else{
			Report.LogInfo("ElementCheck", "RiskCodeDropdown expected element not found", "FAIL");
		}
	}

	public void changeStatusToSigned1() throws InterruptedException
	{
		navigateToContractDetailsTab();
		writtenToSignedStatus();
		verifyExists(SaveBtn,"Save Button");
		click(SaveBtn,"Save Button");
		sleep(3000);
		verifyExists(SignedBtn,"Signed Status Button");
	}

	public void AcceptConSettUpdate() throws InterruptedException
	{
		if(isVisible(ConSettUpdate)==true){
			verifyMustExists(ConSettUpdate,"Contract Setting Update");
			click(ConSettUpdate,"Contract Setting Update");
			sleep(2000);
		}

	}

	public void ContSettingPopUpAccept(){
		if(isVisible(ThirdSectionPopUp) == true)
		{
			verifyExists(SaveBtn1,"Save Button");
			click(SaveBtn1,"Save Button");
			sleep(1000);
		}
	}

	public void selectRuleFilter(String CheckName) throws Exception
	{
		//String UniqueReferenceVal3 = "Automation Policy"+getCurrentTime();
		int i=0;
		String RecordCheckbox = "@xpath=//input[@value='"+CheckName+"']";
		javaScriptWait();
		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			if(isVisible(RuleTypeFilter)==true){
				//waitForElementToAppear(PolicyNumberFilter,5);
				click(RuleTypeFilter, "Rule Type Filter");
				sleep(2000);
			}
			if(isVisible(RecordCheckbox))
			{
				click(RecordCheckbox, CheckName);
				verifyMustExists(FilterBtn,"Filter Button");	
				click(FilterBtn,"Filter Button");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<1);		
		//refreshPage();		
	}
	public void RiskCode_AddEditDelete_TC4351() throws InterruptedException
	{
		navigateToSectionTab();
		navigateToRiskCodesTabOnSection();
		addRiskCodesOnSection();
		editRiskCode();
	}
	public void editRiskCode() throws InterruptedException
	{
		waitForElementToAppear(Edit1stRiskCode,5);
		verifyMustExists(Edit1stRiskCode,"Edit Risk Code Button");
		click(Edit1stRiskCode,"Edit Risk Code");
		sleep(2000);
		waitForElementToAppear(VerifyEditRiskCodePopup,5);
		verifyMustExists(VerifyEditRiskCodePopup,"Verify Edit Risk Code Popup");
		verifyMustExists(SplitPercentTBox,"Split Percent Textbox");
		sendKeys(SplitPercentTBox, "50", "Split Percent Textbox.");

		verifyMustExists(SaveEditedChanges,"Risk Code Save Button");
		click(SaveEditedChanges,"Risk Code Save Button");
		sleep(5000);
		if(isVisible(SecondRuleSectionPopUp) == true)
		{
			verifyMustExists(SaveBtn4,"Save button");
			click(SaveBtn4,"Save button");
			sleep(1000);
		}
		verifyMustExists(VerifyEditedvalue,"Verify Edited value");
		verifyMustExists(Edit1stRiskCode,"Edit Risk Code Button");
		click(Edit1stRiskCode,"Edit Risk Code");
		sleep(2000);
		waitForElementToAppear(VerifyEditRiskCodePopup,5);
		verifyMustExists(VerifyEditRiskCodePopup,"Verify Edit Risk Code Popup");

		verifyMustExists(DeleteRiskCode,"Delete Risk Code Button");
		click(DeleteRiskCode,"Delete Risk Code");
		sleep(2000);

		verifyExists(ConfirmDeleteRiskCode,"Confirm Delete Risk Code");
		click(ConfirmDeleteRiskCode,"Confirm Delete Risk Code");
		sleep(1000);
		if(isVisible(SecondRuleSectionPopUp) == true)
		{
			verifyMustExists(SaveBtn4,"Save button");
			click(SaveBtn4,"Save button");
			sleep(1000);
		}

	}

	public void addReportingChannelClaim1() throws InterruptedException
	{
		//sleep(3000);
		if(isVisible(AddReportingChannelBtn)==true){
			waitForElementToAppear(AddReportingChannelBtn,5);
			verifyMustExists(AddReportingChannelBtn,"Add Reporting Channel Button");
			click(AddReportingChannelBtn,"Add Reporting Channel Button");
			sleep(2000);
			if(isVisible(ChannelTypeDropdown1)==true){
				SelectDropDownValue(ChannelTypeDropdown,ChannelTypeDDValue);

				SelectDropDownValue(TypeDropdown,TypeDDValueClaim);

				SelectDropDownValue(FrequencyDropdown,FrequencyDDValue);

				verifyMustExists(ReportingChannelIdTBox,"Reporting Channel Identifier Textbox");
				sendKeys(ReportingChannelIdTBox, "Claim Bordereaux", "Reporting Channel Identifier Textbox.");
				verifyMustExists(SaveBtn,"Reporting Channel Save Button");
				click(SaveBtn,"Reporting Channel Save Button");
				sleep(2000);
				if(isVisible(SecondContractUpdatePopUp) == true)
				{
					verifyMustExists(AddNoteIForClaim,"Add Note For Claim");
					sendKeys(AddNoteIForClaim, "Test", "Add Note For Claim");
					verifyExists(PopUpSaveBtn,"Save Button");
					click(PopUpSaveBtn,"Save Button");
					sleep(1000);
				}
				waitForElementToAppear(ReportingChannelRecord,5);
				verifyExists(ReportingChannelRecord,"Reporting Channel Record in List");
				verifyExists(BordereauxTab,"Bordereaux Tab");
			}else{
				Report.LogInfo("ElementCheck", "ChannelTypeDropdown Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "AddReportingChannelBtn Expected element not found", "FAIL");
		}
	}
	
	public void addRules1()
	{
		if(isVisible(AddRulesBtn)==true){
			waitForElementToAppear(AddRulesBtn,5);
			verifyMustExists(AddRulesBtn,"Add Rules button");
			click(AddRulesBtn,"Add Rules button");
			//sleep(3000);
			if(isVisible(AddRulesPopup)==true){
				waitForElementToAppear(AddRulesPopup,5);
				verifyMustExists(AddRulesPopup,"Add Rules popup");
				verifyMustExists(RuleNameTxt,"Rules Name textbox");
				sendKeys(RuleNameTxt,Rule,"Rules Name");
				SelectDropDownValue(DatasetTypeDD,RiskValue);

				SelectDropDownValue(ApplicationConditionDD,ConditionMetValue);
				
				SelectDropDownValue(CurrencyDD,CurrencyGBPValue);
			
				SelectDropDownValue1(ApplicableSectionDD,ApplicableSectionvalue);
				
				verifyMustExists(ROEToleranceTxt,"ROE Tolerance textbox");
				sendKeys(ROEToleranceTxt,"4","ROE Tolerance textbox");
				
				verifyMustExists(AddRuleConditionBtn,"Add Rule Condition button");
				click(AddRuleConditionBtn,"Add Rule Condition button");
				
				SelectDropDownValue1(FieldNameDD,YOAValue);

				SelectDropDownValue1(OperatorDD,NotBetween);

				SelectDropDownValue1(AppliedToDD,Value);
	
				verifyMustExists(EntryOrSelectionTxt ,"Entry Or Selection textbox");
				sendKeys(EntryOrSelectionTxt ,"50","Entry Or Selection textbox");
				
				verifyMustExists(EntryOrSelectionTxt2 ,"Entry Or Selection textbox");
				sendKeys(EntryOrSelectionTxt2 ,"99","Entry Or Selection textbox");

				verifyMustExists(CheckBtn,"Check button");
				click(CheckBtn,"Check button");
				//sleep(3000);
				waitForElementToAppear(SaveBtn,5);
				verifyMustExists(SaveBtn,"Save button");
				click(SaveBtn,"Save button");
				sleep(3000);
				if(isVisible(SecondRuleSectionPopUp) == true)
				{
					verifyMustExists(FirstEnterText ,"FirstEnterText textbox");
					sendKeys(FirstEnterText ,"Test4","FirstEnterText textbox");
					verifyMustExists(SaveBtn4,"Save button");
					click(SaveBtn4,"Save button");
					sleep(1000);
				
			    }
				
			}else{
				Report.LogInfo("ElementCheck", "AddRulesPopup Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "AddRulesBtn Expected element not found", "FAIL");
		}
	}
	
	public void addMarketOnSection1() throws InterruptedException
	{
		//sleep(3000);
		if(isVisible(AddMarketButton)==true){
			waitForElementToAppear(AddMarketButton,5);
			verifyMustExists(AddMarketButton,"Add Market Button");
			javaScriptclick(AddMarketButton,"Add Market Button");
			sleep(2000);
			if(isVisible(InsurerDropdown)==true){
				verifyMustExists(InsurerDropdown,"Insurer Dropdown");
				javaScriptclick(InsurerDropdown,"Insurer Dropdown");
				sleep(2000);
				if(isVisible(InsurerDDValue2)==true){
					waitForElementToAppear(InsurerDDValue2,5);
					verifyMustExists(InsurerDDValue2,"Insurer Dropdown Value");
					javaScriptclick(InsurerDDValue2,"Insurer Dropdown Value");
					sleep(2000);
				}else{
					refreshPage();
					sleep(1000);
					waitForElementToAppear(AddMarketButton,5);
					verifyMustExists(AddMarketButton,"Add Market Button");
					javaScriptclick(AddMarketButton,"Add Market Button");
					sleep(2000);
					SelectDropDownValue(InsurerDropdown,InsurerDDValue2);
				}
				verifyMustExists(SignedLinePercentTBox,"Signed Line Percent Textbox");
				sendKeys(SignedLinePercentTBox, "4", "Signed Line Percent Textbox");

				verifyMustExists(IsLeadYesRadioBtn,"Is Lead Yes Radio Button");
				javaScriptclick(IsLeadYesRadioBtn,"Is Lead Yes Radio Button");

				verifyMustExists(SaveBtn,"Market Save Button");
				javaScriptclick(SaveBtn,"Market Save Button");
				sleep(3000);
				waitForElementToAppear(secondContractEndorsementPopUp,5);
				if(isVisible(secondContractEndorsementPopUp) == true)
				{
					sleep(1000);
					verifyMustExists(YesRadioBtn,"Yes Radio Button");
					javaScriptclick(YesRadioBtn,"Yes Radio Button");
					sleep(1000);
					verifyMustExists(FirstEnterText,"First Enter Text");
					sendKeys(FirstEnterText,"Test1","First Enter Text");
					sleep(1000);
					verifyMustExists(firstYesBtn,"Yes Radio Button");
					javaScriptclick(firstYesBtn,"Yes Radio Button");
					sleep(1000);
					if(isVisible(SecondDraftEndoresmentPopUp) == true)
					{
					verifyMustExists(SecondDraftEndoresmentPopUp,"Second Draft Endoresment PopUp");
					sleep(1000);
				
					 verifyMustExists(SecondPopUpSaveBtn,"Second PopUp Save Button");
					 javaScriptclick(SecondPopUpSaveBtn,"Second PopUp Save Button");
					 sleep(1000);
				
					}
			    }
			}
			else{
				Report.LogInfo("ElementCheck", "InsurerDropdown Expected element not found", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "AddMarketButton Expected element not found", "FAIL");
		}		
	}
	
	public void editMarketPopup() throws InterruptedException
	 {
	   verifyMustExists(SignedLinePercentTBox,"Signed Line Percent Textbox");
	   sendKeys(SignedLinePercentTBox, "4", "Signed Line Percent Textbox");
	   verifyMustExists(IsLeadYesRadioBtn,"Is Lead Yes Radio Button");
	   click(IsLeadYesRadioBtn,"Is Lead Yes Radio Button");
	   verifyMustExists(SaveEditedMarket,"Market Save Button");
	   click(SaveEditedMarket,"Market Save Button");
	   sleep(3000);
	   if(isVisible(secondContractEndorsementPopUp) == true)
	   {
	    verifyMustExists(YesRadioBtn,"Save Button");
	    click(YesRadioBtn,"Save Button");
	    verifyMustExists(FirstEnterText,"Save Button");
	    sendKeys(FirstEnterText,"Test2","FirstEnterText");
	    
	    verifyMustExists(SaveBtn4,"Save Button");
	    click(SaveBtn4,"Save Button");
	    sleep(1000);
	    if(isVisible(FirstNoRadioBtn) == true)
	    {
	    verifyMustExists(FirstNoRadioBtn,"First No Button");
	    click(FirstNoRadioBtn,"First No Button");
	    verifyMustExists(SaveFirstYesRadioBtn,"Save Button");
	    click(SaveFirstYesRadioBtn,"Save Button");
	    sleep(1000);
	    }
	      }	    
	 }
	
	public void addPolicy3(String InceptionDate, String InceptionDateExp) throws InterruptedException
	 {
	  String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
	  //loginPage.tideLogin();
	  navigationOnPolicyTab();
	  navigationOnAddContractPage();
	  navigationOnSelectPolicyPopUp();
	  navigationOnAddPolicyPopUp();
	  addContractBinderDetails();
	  //addPolicyContractDetails(UniqueReferenceVal1, InceptionDate, Status1, Broker1, Bline1, Underline1);
	  addPolicyContractDetails3(UniqueReferenceVal1, InceptionDate, InceptionDateExp, Status1, Broker3, Bline1, Underline2);

	  //sleep(3000);
	  waitForElementToAppear(DraftBtn,5);
	  verifyExists(DraftBtn,"Draft Status Button");
	 }
	
	public void addPolicyContractDetails3(String UniqueReferenceName, String InceptionDates, String InceptionExp, String Status, String Broker, String Bline, String Underline ) throws InterruptedException
	 {
	  //sleep(3000);
	  waitForElementToAppear(Policytitle,5);
	  PolicyNumber = getTextFrom(Policytitle);
	  verifyMustExists(UniqueReference,"Unique Reference textbox");
	  sendKeys(UniqueReference,PolicyNumber,"Unique Reference textbox.");

	  SelectDropDownValue(ContractCurrencyDrpDown,ContractCurrencyDrpDownValue);

	  verifyMustExists(CompanyReference,"Company Reference textbox");
	  sendKeys(CompanyReference,CompanyReferenceval,"Company Reference textbox.");
	  verifyMustExists(ContractStatusDrpDown,"Contract Status Drop Down");
	  click(ContractStatusDrpDown,"Contract Status Drop Down");
	  Thread.sleep(1000);
	  webDriver.findElement(By.xpath("//ul[@class='k-list k-reset']//*[text()='"+Status+"']")).click();
	  verifyMustExists(BrokerDrpDown,"Broker Drop Down");
	  click(BrokerDrpDown,"Broker Drop Down");
	  Thread.sleep(1000);
	  webDriver.findElement(By.xpath("//ul[@class='k-list k-reset']//*[text()='"+Broker+"']")).click();
	  verifyMustExists(InceptionDateIcon,"Inception Date");
	  sendKeys(InceptionDateIcon,InceptionDates,"Inception Date field."); 
	  if(isVisible(ExpDtpop)==true)
	  {

	   verifyMustExists(ErrorPopUpOKbtn,"Error Pop Up OK button");
	   click(ErrorPopUpOKbtn,"Error Pop Up OK buttonn");
	   waitForElementToAppear(ExpiryDateIcon,5);
	   sendKeys(ExpiryDateIcon,InceptionExp,"Expiry date");
	  }else{
	   waitForElementToAppear(ExpiryDateIcon,5);
	   sendKeys(ExpiryDateIcon,InceptionExp,"Expiry date");
	  }
	  verifyMustExists(LineofBusinessDrpDown,"Line of Business Drop Down");
	  click(LineofBusinessDrpDown,"Line of Business Drop Down");
	  Thread.sleep(1000);
	  webDriver.findElement(By.xpath("//ul[@class='k-list k-reset']//*[text()='"+Bline+"']")).click();
	  SelectDropDownValue(UnderwriterDrpDown,UnderwriterDrpDownValue);

	  SelectDropDownValue(TechnicianDrpDown,TechnicianDrpDownValue1);
	  JavascriptExecutor jse = (JavascriptExecutor)webDriver;
	  jse.executeScript("window.scrollBy(0,250)", "");
	  sleep(1000);
	  verifyMustExists(SaveBtn,"Save Button");
	  click(SaveBtn,"Save button");
	  //Thread.sleep(5000);
	  waitForElementToAppear(PolicytitleOnCotractDetails,5);
	  if(isVisible(PolicytitleOnCotractDetails)== true)
	  {
	   Report.LogInfo("ContractDetailsNav", "User is successfully navigated on Contract Details page.", "PASS");
	  }else{
	   Report.LogInfo("ContractDetailsNav", "User is not successfully navigated on Contract Details page.", "FAIL");
	  } 
	  sleep(1000);

	 }
	public void addSection2(String SectionReference)
	{	
		//sleep(5000);
		waitForElementToAppear(AddSectionTab,5);
		scrollUp();
		verifyMustExists(AddSectionTab,"Add Section Tab");
		click(AddSectionTab,"Add Section Tab");
		sleep(2000);
		if(isVisible(AddSectionPopup)==true){
			verifyMustExists(AddSectionPopup,"Add Section Pop up");
			//click(AddSectionPopup,"Add Section Pop up");
			verifyMustExists(SectionReferenceTxt,"Section Reference Textbox");
			sendKeys(SectionReferenceTxt,SectionReference,"Section Reference Textbox.");
			verifyMustExists(MarketSectionDescriptionTxt,"Market Section Description Textbox");
			sendKeys(MarketSectionDescriptionTxt,"section created by automation script","Market Section Description Textbox.");
			verifyExists(Brokerage,"Brokerage textbox");
			sendKeys(Brokerage,BrokerageVal,"Brokerage textbox.");
			verifyMustExists(ComissionTxt,"Comission Textbox");
			sendKeys(ComissionTxt,"10","Comission Textbox.");
			verifyMustExists(AdditionalDeductionTxt,"Additional Deduction Textbox");
			sendKeys(AdditionalDeductionTxt,"20","Additional Deduction Textbox.");

			SelectDropDownValue(ClassOfBusinessDD,PropertyRiskValue);

			SelectDropDownValue(SectionCurrencyDD,SectionCurrencyValue);

			verifyMustExists(MaximumLimitOfLiability,"Maximum Limit Of Liability Textbox");
			sendKeys(MaximumLimitOfLiability,"1000000","Maximum Limit Of Liability Textbox.");
			verifyMustExists(GrossPermiumIncomeTxt,"Gross Premium Income Limit Textbox");
			sendKeys(GrossPermiumIncomeTxt,"100","Gross Premium Income Limit Textbox.");
			verifyMustExists(GrossPermiumLimitTxt,"Gross Premium Income Limit Notification Percentage Textbox");
			sendKeys(GrossPermiumLimitTxt,"10","Gross Premium Income Limit Notification Percentage Textbox.");

			SelectDropDownValue(ConductRiskRatingDD,ConductRiskRatingValue);

			verifyExists(SaveBtn,"Save Button");
			click(SaveBtn,"Save Button");
			sleep(2000);
			if(isVisible(ConEndrsmntPopUp) == true)
			{
				sleep(1000);
				verifyExists(SaveBtn3,"Save Button");
				click(SaveBtn3,"Save Button");
				sleep(3000);
			}
			//sleep(3000);
			waitForElementToAppear(sectionTab,5);
			verifyExists(sectionTab,"Section Tab");
			//verifyExists(sectionDetails,"Added Section Details");
		}else{
			Report.LogInfo("ElementCheck", "Expected element not found", "FAIL");
		}

	}
	
	public void navigateToSection2Tab() throws InterruptedException
	{
		if(isVisible(section2Tab)==true){
			waitForElementToAppear(section2Tab,5);
			verifyMustExists(section2Tab,"Section Tab");
			javaScriptclick(section2Tab,"Section Tab");
			//sleep(2000);
		}else{
			Report.LogInfo("ElementCheck", "SectionTab Expected element not found", "FAIL");
		}

	}

	public void addRiskCodesOnSection2(String RsikCodeDropdownValue,String SplitPercent) throws InterruptedException
	{
		//sleep(3000);
		if(isVisible(AddRiskCodeButton)==true){
			waitForElementToAppear(AddRiskCodeButton,5);
			verifyMustExists(AddRiskCodeButton,"Add Risk Code Button");
			click(AddRiskCodeButton,"Add Risk Code Button");
			sleep(2000);

			if(isVisible(RiskCodeDropdown)==true){
				click(RiskCodeDropdown,"Insurer Dropdown");
				sleep(2000);
				if(isVisible(RsikCodeDropdownValue)==true){
					waitForElementToAppear(RsikCodeDropdownValue,5);
					verifyMustExists(RsikCodeDropdownValue,"Risk Code Dropdown Value");
					click(RsikCodeDropdownValue,"Risk Code Dropdown Value");
				}else{
				refreshPage();
				sleep(1000);
				waitForElementToAppear(AddRiskCodeButton,5);
				verifyMustExists(AddRiskCodeButton,"Add Risk Code Button");
				click(AddRiskCodeButton,"Add Risk Code Button");
				sleep(2000);
				SelectDropDownValue(RiskCodeDropdown,RiskCodeDDValue);
				}
				verifyMustExists(SplitPercentTBox,"Split Percent Textbox");
				sendKeys(SplitPercentTBox,SplitPercent, "Split Percent Textbox.");

				verifyMustExists(SaveBtn,"Risk Code Save Button");
				click(SaveBtn,"Risk Code Save Button");
				sleep(2000);
				if(isVisible(SecondRuleSectionPopUp) == true)
				{
					verifyMustExists(SaveBtn4,"Save button");
					click(SaveBtn4,"Save button");
					sleep(1000);
				}
				
			}else{
				Report.LogInfo("ElementCheck", "RiskCodeDropdown expected element not found", "FAIL");
			}

		}else{
			Report.LogInfo("ElementCheck", "AddRiskCodeButton expected element not found", "FAIL");
		}

	}
	
	/*public void navigateRulesGeneralTab1()
	 {
	  if(isVisible(RulesGeneralTab)==true){
	   waitForElementToAppear(RulesGeneralTab,5);
	   verifyMustExists(RulesGeneralTab,"Rules Tab");
	   click(RulesGeneralTab,"Rules Tab");
	  }else{
	   Report.LogInfo("ElementCheck", "RulesTab Expected element not found", "FAIL");
	  }
	 }*/
	 
	 public void navigateRulesonsection1() throws InterruptedException
	 {
	  waitForElementToAppear(RuleTabOnSection,5);
	  if(isVisible(RuleTabOnSection)==true){
	   click(RuleTabOnSection,"Rule Tab");
	   //sleep(2000);
	  }else{
	   Report.LogInfo("ElementCheck", "Rule Tab Expected element not found", "FAIL");
	  }

	 }
	 
	 public void editMarketPopup1() throws InterruptedException
	  {
	    verifyMustExists(SignedLinePercentTBox,"Signed Line Percent Textbox");
	    sendKeys(SignedLinePercentTBox, "5", "Signed Line Percent Textbox");
	    verifyMustExists(IsLeadYesRadioBtn,"Is Lead Yes Radio Button");
	    click(IsLeadYesRadioBtn,"Is Lead Yes Radio Button");
	    verifyMustExists(SaveEditedMarket,"Market Save Button");
	    click(SaveEditedMarket,"Market Save Button");
	    sleep(3000);
	    if(isVisible(secondContractEndorsementPopUp) == true)
	    {
	      verifyMustExists(SaveBtn4,"Save Button");
	     click(SaveBtn4,"Save Button");
	     sleep(1000);
	     }     
	  }
		
}
