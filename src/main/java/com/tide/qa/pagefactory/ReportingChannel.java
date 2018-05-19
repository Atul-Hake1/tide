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
import com.tide.qa.pagefactory.BordereauProcessPage;

public class ReportingChannel extends PageBase {
	LoginPage loginPage = new LoginPage();
	PolicyPage policy = new PolicyPage();
	BordereauProcessPage Br = new BordereauProcessPage();
	BordereauQuePage BQPage = new BordereauQuePage();
	HomePage homePage = new HomePage();
	Stage1Page st2 = new Stage1Page();
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
	String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
	String UniqueReferenceVal3 = "Automation Policy1"+getCurrentDateTimeMS();
	String CompanyReferenceval = "Automation Policy1"+getCurrentDateTimeMS();
	String UniqueReferenceVal2 = "Contract 2"+getCurrentDateTimeMS();
	static String  Rule = "AutoRule"+getCurrentDateTimeMS();
	static String  Rule1 = "AutoRule1"+getCurrentDateTimeMS();
	String BrokerageVal = "10";
	String Status1 = "Draft";
	String Broker1 = "ACE Underwriting Agencies Limited - 2488";
	String Bline1 = "Property (D&F)";
	String Underline1 = "Abhi, Standard";
	String InceptionDate1 = "01/09/2017";
	String InceptionDate2 = "01/09/2018";
	public static String contractId;

	public static String allSheetsPath = "";
	public static String firstSheetPath = "";
	public static String lastSheetPath = "";
	public static String sheet3160Path = "";
	public static String sheet3161Path = "";
	public static String sheet3165Path = "";
	public static String sheet3166Path = "";
	public static String sheet3186Path = "";
	public static String sheet3192Path = "";
	public static String sheet3193Path = "";
	public static String sheet3194Path = "";
	public static String sheet3195Path = "";
	public static String sheet3196Path = "";
	public static String sheet3197Path = "";
	public static String sheet3198Path = "";
	public static String sheet3199Path = "";
	public static String sheet3200Path = "";
	public static String sheet3201Path = "";
	public static String sheet3202Path = "";
	public static String sheet3203Path = "";
	public static String sheet3204Path = "";
	public static String sheet3207Path = "";
	public static String sheet3209Path = "";
	public static String sheet3211Path = "";
	public static String sheet3212Path = "";
	public static String sheet3213Path = "";
	public static String sheet3214Path = "";
	public static String sheet3210Path = "";
	public static String sheet3216Path = "";
	public static String sheet3244Path = "";
	public static String sheet3245Path = "";
	public static String sheet3480Path = "";
	public static String sheet3479Path = "";
	public static String sheet3372Path = "";
	public static String sheet3371Path = "";
	public static String sheet3437Path = "";
	public static String sheet3448Path = "";
	public static String sheet3449Path = "";
	public static String sheet3450Path = "";
	public static String sheet3500Path = "";

	//Locators for apply filter on policies
	public static final String PolicyLink = "@xpath=//a[text()='POLICIES']";
	public static final String PolicyReferenceFilterIcon = "@css=thead[role=rowgroup] th:nth-child(1) span";
	public static final String SearchText = "@css=.k-textbox.k-space-right>input";
	public static final String FilterButton = "@css=.k-button.k-primary";

	//Open Selected policy
	public static final String SelectedPolicy = "@css=tbody[role='rowgroup'] td:nth-child(1)";
	public static final String DraftBtn = "@buttonText=Draft";
	public static final String RefreshBordereauxAfterUpload= "@xpath=//span[contains(.,'1 - 20')]//preceding-sibling::a[@title='Refresh']/span";
	public static final String OpenBordereauxAfterUpload= "@xpath=//tr[1]//td[contains(@ng-click,'goToFolderRecord')][text()='-']//preceding-sibling::td[1]//button[text()='Review Errors']";
	
	// Submit Borderaux
	public static final String BORDEREAUXLink = "@xpath=.//*[@ng-if='IsBinder && IsBordereauTabDisplay']";
	public static final String SubmitBordereauxDropdown = "@xpath=//*[text()='Submit Bordereaux']//following-sibling::button[1]";
	public static final String SelectOptionRisk = "@css=[data-ng-repeat='w in dataSetList']:nth-child(1)";
	public static final String SelectNewquestionnaire = "@xpath=//*[@ng-model='ProcessingUploadData.FormatId']//preceding-sibling::span[1]";
	public static final String EnterOptionToSelect = "@xpath=//*[@id='formatUL-list']/span/input";
	public static final String Calender = "@css=.k-icon.k-i-calendar";
	public static final String DateJan = "@xpath=//a[text()='Jan']";
	public static final String datefield= "@id=Data0";
	public static final String PreviousAnsNoRadioBtn = "@xpath=//div[@class='form-group p-r-0 m-t-10']//descendant::label[@class='radio radio-inline m-r-20'][2]";
	public static final String BlankDetailsMsg = "@css=.c-black.f-500";

	//File upload
	public static final String ClickDragDrop = "@css=.dz-default.dz-message.col-sm-12.col-xs-12.ng-scope";
	public static final String UploadSection ="@xpath=//div[contains(@ng-model,'picFile')]";
	public static final String PicFile = "@model=picFile";
	public static final String ReviewButton ="@buttonText=Review";
	public static final String RefreshAfterUpload= "@css=.k-pager-refresh.k-link";
	public static final String Alert = "@css=.sweet-alert.BordereauxCss";
	public static final String AlertOKButton = "@xpath=//*[@id='mainPage']/div[2]/div[2]/p/button[1]";

	//to verify counts on sheets
	public static final String RiskTab ="@css=.k-master-row.ng-scope>td:nth-child(4)";
	public static final String SelectedPageCount ="@css=.k-input";
	public static final String TotalCount = "@css=.k-selectable .ng-scope";
	public static final String ChangePageCountDropDn = "@css=.k-icon.k-i-arrow-60-down";
	public static final String ChangePageCountTo = "@xpath=//li[text()='20']";
	public static final String ActualExpectedRowCount = "@css=.k-selectable .ng-scope";
	public static final String ActualCountPolicyRefrence = "@css=.k-selectable .ng-scope td:nth-child(13)";
	public static final String RiskTabAfterReview ="@xpath=//*[@id='grid']//preceding::td//button[contains(text(),'Review')]//following::td[contains(text(),'Risk')][1]";

	//Delete created BorderEAUX
	public static final String DeleteButton = "@css=.c-red.glyphicon.glyphicon-trash";
	public static final String DeleteYESButton = "@xpath=//button[@ng-click='onYes()']";
	public static final String PolicyHome = "@css=a[href='#!/app/contractlist']";

	//You can select the sheet for processing this time (the expected sheet text for future processing will remain unchanged)
	public static final String ProcessingTiem = "@css=.k-input.k-readonly";
	public static final String ProcessingTimeSecond = "@css=.k-input";
	public static final String May2017 = "@css=.k-list.k-reset li:nth-child(3)";
	public static final String June2017 = "@css=.k-list.k-reset li:nth-child(1)";

	//CANCEL PROCESSING AND DELETE BORDEREAU
	public static final String cancelAndDeleteProBtn = "@xpath=//div[@ng-click='cancel(data.BordereauxId)']";
	public static final String cancelAndDeleteProBtnYes = "@xpath=//button[@ng-click='onYes()']";
	public static final String ReviewBtn ="@xpath=//button[text()='Review']";

	//Loactors for SubmitBordereauxFIrstSheet
	public static final String BorderEAUXFirst ="@css=[href='#!/app/contract/253fe192-ba5e-4586-b3d2-c13dbf40e802/bordereaux/2']";
	public static final String BorderEAUXLast ="@css=[href='#!/app/contract/7807ee46-ba51-445d-b5fa-69d71dc08856/bordereaux/2']";
	public static final String CalenderLastST ="@css=.k-icon.k-i-calendar";
	public static final String CalenderFirstST ="@css=.k-icon.k-i-calendar";

	//1] Processing for BorderEAUX
	public static final String ReviewError ="@xpath=//*[@id='grid']//button[contains(.,'Review Errors')]";
	public static final String ErrorScreen ="@css=.f-400.c-red.normalWhiteSpace.ng-binding.ng-scope";
	public static final String ErrorScreen1 ="@xpath=//h2[contains(.,'Transaction Type Field Errors Identified')]";

	public static final String ProcessBorderEAuButton ="@xpath=//button[@ng-click='nextStep()']";
	public static final String SheetNameErrorMsg ="@css=[name='form.bordereauxIdentifySheet'] .row dl:nth-child(4) dt";
	//2] Edit Specific Text
	public static final String ToEditSpecificText = "@css=.form-control.ng-pristine.ng-untouched.ng-valid.ng-not-empty";
	public static final String RemainUnchangedRadioButton = "@xpath=//label[@class='radio radio-inline ng-scope']";
	public static final String NoSingelContainProcessingTime = "@css=.k-input.ng-scope";
	public static final String Mar2017 = "@css=.k-list.k-reset li:nth-child(1)";
	public static final String ReportingChannelsTab1 ="@xpath=//li[@ng-if='IsBinder && viewReportingChannelsTab']/a[@data-ui-sref='app.contract.reportingChannelParent.reportingChannel']";

	//1] Sheet Processing
	public static final String SelectDropDown = "@xpath=//*[@ng-model='form.newSheetIndex']//preceding-sibling::span[1]";
	public static final String SelectOptionJune = "@xpath=//li[contains(text(),'May 2017')]";

	//1] To cancel Bordereau process
	public static final String CancelAndDeleteBordereaux ="@xpath=//button[@ng-click='cancel()']";

	//Locators:-TC-3245
	public static final String continuebtx= "@xpath=//button[@ng-click='save()']";
	public static final String DateTextBox= "@css=#Data0";

	//One or more error pop up
	public static final String OneMoreError ="@xpath=//h2[contains(text(),'One or more ')]";
	public static final String CancelProcessingBtn ="@xpath=//button[contains(.,'CANCEL PROCESSING AND DELETE BORDEREAU')]";
	public static final String ContinueProcessingBtn ="@xpath=//button[contains(.,'Process Bordereau')]";
	public static final String DuplicateColumn ="@xpath=//h2[contains(text(),'Duplicate bordereau column')]";
	public static final String SheetNameRadioBtx ="@css=[name='form.bordereauxIdentifySheet'] .row dl:nth-child(4) dt label";
	public static final String sheetdropdown ="@css=.k-input.ng-scope";
	//public static final String April2017 ="@css=.k-list.k-reset li:nth-child(2)";
	public static final String April2017 ="@xpath=//*[@class='k-item ng-scope'][2]";
	public static final String tidevaluedropdown ="@css=.k-widget.k-dropdown.k-header.m-b.form-control.ng-pristine.ng-untouched.ng-valid.ng-not-empty";
	public static final String tidevalueNew ="@css=body>div:nth-of-type(2) li:nth-child(4)";

	public static final String discardRecord="@css=tbody tr:nth-child(2) .btn";
	public static final String yearAccount ="@css=#Data0";
	public static final String inceptionDate ="@css=.k-picker-wrap.k-state-default.k-state-hover";

	public static final String SuccessNotificationMsgAfterUpload="@xpath=//*[@id='mainPage']/descendant::div[@class='sweet-alert BordereauxCss']/h2[1][contains(text(),'Good job!')]";
	public static final String FailureNotificationMsgAfterUpload="@xpath=//*[@id='mainPage']/descendant::div[@class='sweet-alert BordereauxCss']/h2[1][contains(text(),'Errors identified!')]";

	public static final String OkButtonOnSuccessNotification="@xpath=//*[@id='mainPage']/descendant::div[@ng-show='BordereauSuccess']/descendant::button[contains(text(),'Ok')]";
	public static final String CancelButtonOnFailureNotification="@xpath=//*[@id='mainPage']/descendant::div[@ng-show='BordereauError || BordereauLargeUpload']/descendant::button[contains(text(),'Cancel')]";

	// Locators for checkRecordsAndDeleteRecord
	public static final String filterIconRecords = "@css=[data-field='StatusString'] span";
	public static final String ReviewErrorCheckBox = "@css=input[value='Review Errors']";
	public static final String ReviewCheckBox = "@css=input[value='Review']";
	public static final String FilterButtonRecords = "@css=.k-button.k-primary";
	public static final String FilterButtonRecords1 = "@xpath=//div[@class='k-animation-container'][3]//button[@type='submit']";
	public static final String TotalRowCountAfterFiltered = "@css=tbody[role='rowgroup'] tr";
	public static final String CancelBtn ="@xpath=//*[@class='sweet-alert ']//p//button[contains(.,'Cancel')][1]";
	//public static final String BlankDetailsMsg = "@css=.c-black.f-500";

	//Locators for Due date filter
	public static final String DuteDatefilterIcon = "@css=[data-title='Due Date'] .k-icon.k-i-filter";
	public static final String DuteDatefilterIconInputBox = "@css=.k-textbox.k-space-right>input";
	public static final String DueDateFiterBtn = "@css=.k-button.k-primary";

	//Navigation BordereauxHeaderLink
	public static final String BordereauHeaderLink = "@xpath=//*[@id='header']//li[@ng-if='authentication.userId && showBordereauxMenu']";

	// Navigate to ReportingChannel on contract details page
	public static final String ReportingChannelLink = "@xpath=//*[@id='content']//li[@ng-if='IsBinder && viewReportingChannelsTab']";

	//Lacators for add reporting Channel

	public static final String AddReportingChannelButton = "@xpath=.//*[@ng-click='add()']";
	public static final String ChannelTypeSelection = "@xpath=//span[text()='Channel Type']//parent::dt[1]//following-sibling::dd//span[@role='listbox']";
	public static final String ChannelTypeOption = "@xpath=//li[text()='Bordereaux']";
	public static final String ChannelTypeOption1 = "@xpath=//li[text()='Bordereaux']";

	public static final String TypeSelection = "@xpath=//span[text()='Type']//parent::dt[1]//following-sibling::dd//span[@role='listbox']";
	public static final String TypeOption = "@xpath=//li[text()='Risk']";
	public static final String TypeOption1 = "@xpath=//li[text()='Risk']";

	public static final String FrequencySelection = "@xpath=//span[text()='Frequency']//parent::dt[1]//following-sibling::dd//span[@role='listbox']";
	public static final String FrequencySelectedOption = "@xpath=//li[text()='Monthly']";
	public static final String FrequencySelectedOption1 = "@xpath=//li[text()='Monthly']";
	public static final String FrequencySelectedOption2 = "@xpath=//li[text()='Quarterly']";
	public static final String FrequencySelectedOption3 = "@xpath=//li[text()='Annually']";


	public static final String DueDaysTextBox = "@xpath=//input[@ng-model='data.DueDays']";
	public static final String ReportingIdentifierTextBox = "@xpath=//input[@ng-model='data.ReportingChannelIdentifier']";
	public static final String NumberExpectedTextBox = "@xpath=//span[text()='Number Expected']//parent::dt//following-sibling::dd//input";
	public static final String SaveButtonReportChannel = "@xpath=//button[@ng-click='save()']";
	public static final String EnterTextOption = "@css=.k-textbox";
	public static final String VerifyReportingChannelIdentifier = "@xpath=//td[contains(text(),'Reporting channel- RISK')]";
	public static final String PreviousAnsYesRadioBtn ="@css=.form-group.p-r-0.m-t-10>label:nth-child(1)";
	public static final String CalenderInputBox ="@css=.form-control.calTextHgt.full-width.k-input";

	// Locators TC_3440 for DeleteCreatedReportingChannel method

	public static final String PremiumOption = "@xpath=.//a[text()='Premium']";
	public static final String EditReportingChannel = "@xpath=//td[contains(text(),'Reporting channel- RISK')]//preceding-sibling::td[5]//descendant::i";
	public static final String EditReportingChannel1 = "@xpath=//td[contains(text(),'osk Quarterly')]//preceding-sibling::td[5]//descendant::i";

	public static final String ReportingChannelDeleteButton = "@xpath=//button[@title='Delete'][@ng-click='callDeleteReportingChannel(data)']";
	public static final String ReportingChannelDeleteButtonConfirm = "@xpath=//button[text()='Yes, Delete it!']";

	// Locator for navigateToDetailsPolicyPage
	public static final String DetailPolicyLink = "@xpath=//a[text()='Details']";

	//Locators for TC_3480
	public static final String SelectReportingChannel = "@css=.k-input.ng-scope";
	public static final String ReportingChannelOption = "@xpath=//li[text()='RISK2']";
	public static final String ContinueReportingChannelProcessButton = "@xpath=//*[@ng-click='cancel()']//following::button[1]";

	// Locators for TestCase 3479

	public static final String CancelButtonProcessBordereau = "@xpath=//*[@ng-click='cancel()']";
	public static final String NavigateOnPopUpReportingChannelIdentified = "@xpath=//h2[text()='More than one Reporting Channel identified']";
	//Locators for TC_3481
	public static final String VerifyAddedReportingChannelIdentifier = "@xpath=//td[contains(text(),'osk Quarterly')]";

	//Locators for TC_3372

	public static final String VerifyReportingChannelIdentifierRisk = "@xpath=//td[contains(text(),'Risk2')]";
	public static final String SelectBordereauReportingChannel = "@css=.k-input.ng-scope";
	public static final String MoreThanOneReportingChannelIdentifiedHeader = "@css=h2.font-bold.lead";
	public static final String ContinueProcessingBordereauButton = "@css=.btn.btn-primary.p-lr-lg.waves-effect.waves-light";
	public static final String SelectBordereauReportingChannelOption = "@xpath=//li[text()='Risk2']";

	//Locators for TC_3437

	public static final String SelectOptionPremium = "@xpath=//a[text()='Premium']";
	public static final String DropDwnSubmitBordereau = "@css=.btn.btn-primary.dropdown-toggle.waves-effect.waves-light";
	public static final String SelectPolicyBordereauProcessTextBox = "@css=.k-multiselect-wrap.k-floatwrap";
	public static final String PleaseSelectPolicyTextBox = "@css=.k-multiselect-wrap.k-floatwrap";//sendkeys
	public static final String PleaseSelectPolicyOptin = "@xpath=//li[text()='(297937DW)-Arizona MGA Arizona Office']";
	public static final String SelectToAnswerQuestionnaire = "@css=.k-input.ng-scope";
	public static final String SelectToAnswerQuestionnaireSearchBox = "@css=.k-textbox";
	public static final String SelectToAnswerQuestionnaireOption = "@xpath=//li[text()='Stage 2 Processing - Premium (Premium Schema)']";
	public static final String PolicyReferenceIcon = "@xpath=//th[@data-title='Folder Reference']//span[@class='k-icon k-i-filter']";
	public static final String PolicyReferenceIconSearchField = "@xpath=//input[@placeholder='Search']";
	public static final String FilterButtonPolicyReference = "@xpath= //button[contains(.,'Filter')]";
	//public static final String PauseButton = "@xpath=//*[@id='multiReference_Id']//div[@class='card-header']//Following-sibling::div[2]//descendant::div[2]//div";
	public static final String PauseButton = "@xpath= //*[@ng-click='cancel()']";
	public static final String ViewFilteredPolicy = "@xpath=//a[text()='297937DW']";
	public static final String ProcessingButton = "@xpath=//button[text()='Processing']";
	public static final String NoReportingChannelIdentifiedPage = "@xpath=//h2[text()='No Reporting Channel identified']";
	public static final String NoRecord = "@xpath=//div[text()='0 items selected']";

	//Loactors TC_3448
	public static final String CancelStatusAndLeaveUploadingStatusButton = "@xpath=//div[@ng-click='UpdateStatusToPreSequenceRule()']";
	public static final String UploadedButton = "@xpath=//button[text()='Uploaded']";
	public static final String AnotherBordereauSamePeriodNotYetApprovedPage = "@css=h2.font-bold.lead";
	public static final String UploadedDeleteButton = "@xpath=//button[text()='Uploaded']//following-sibling::span[1]/i";
	public static final String UploadedDeleteYESButton = "@xpath=//button[@ng-click='onYes()']";

	//Locators for TC_3490
	public static final String TaxHeader = "@xpath=//th[@data-field='Tax']";
	public static final String DATAlink ="@xpath=//*[@ng-click='clickedContractData()']";
	public static final String RowNumber="@xpath=//*[@data-field='RowNumber']";
	public static final String RowNumberAscIcon ="@xpath=//*[@data-field='RowNumber']//*[@class='k-icon k-i-sort-asc-sm']";
	public static final String TotalTaxRecords ="@xpath=//*[@role='rowgroup']//tr[8]//td[39]";
	//public static final String ExpectedTaxFirstRecord = "@xpath = //*[@id='grid']//div[3]//table//tbody//tr[8]//td[39]";
	public static final String TaxFirstRow = "@xpath=//*[@id='grid']//tr[8]//td[39][@class='bgm-green']";
	public static final String TaxSecondRow = "@xpath=//*[@id='grid']//tr[9]//td[39][@class='bgm-green']";
	public static final String TaxThirdRow = "@xpath=//*[@id='grid']//tr[10]//td[39][@class='bgm-green']";
	public static final String GrossPremiumTaxFirstRow="@xpath=//*[@class='k-grid-content k-auto-scrollable']//tr[1]//td[24]";
	public static final String DATARiskTab="@xpath=//*[text()='Risk']";
	public static final String GrossPremium="@xpath=//*[@data-field='Gross_Premium']";


	//Locators:- TC_3491
	public static final String TaxPercentFirstRow = "@xpath=//*[@id='grid']//tr[8]//td[40][@class='bgm-green']";
	public static final String TaxPercentSecondRow = "@xpath=//*[@id='grid']//tr[9]//td[40][@class='bgm-green']";
	public static final String TaxPercentThirdRow = "@xpath=//*[@id='grid']//tr[10]//td[40][@class='bgm-green']";





	//------------------------------------------------Reporting Channel-----------------------------------------------------------//
	//----------------------------------------------------------------------------------------------------------------------------//
	//TC-3439
	public void addMatchingReportingChannel() throws Exception{
		String OnlySpPoliCyNum = "297937DW";
		String DueDays1 = "30";
		String ChannelIdentifier1 ="Reporting channel- RISK";
		String NumberExpected1 ="18";
		String ChannelTypeOption1 = "Bordereaux";
		String TypeOption1 = "Risk";
		String Frequency1 = "Monthly";
		//loginPage.tideLogin();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		OpenReportchannel();
		addReportingChannel(ChannelTypeOption1,TypeOption1,Frequency1,DueDays1,ChannelIdentifier1,NumberExpected1);
		sleep(3000);
		//webDriver.navigate().refresh();
		waitForElementToAppear(VerifyReportingChannelIdentifier,3);
		String ExpectReportingChannelIdentifier = getTextFrom(VerifyReportingChannelIdentifier);
		if (ChannelIdentifier1.equalsIgnoreCase(ExpectReportingChannelIdentifier)){
			Report.LogInfo("ValidationAddedReportChannel", "Report Channel added successfully.", "PASS");
		}else{

			Report.LogInfo("ValidationAddedReportChannel", "Report Channel not added successfully.", "FAIL");
		}
		//sleep(3000);
	}


	//TC_3440
	public void DeleteCreatedReportingChannel() throws Exception{
		String ChannelIdentifier1 ="Reporting channel- RISK";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		OpenReportchannel();
		editAndDeleteReportingChanel(ChannelIdentifier1);
		//sleep(3000);
	}



	//------------------------------TC_3480-START------------------------------------------------//

	public void ProcessBordereauForMoreReportingChannel() throws Exception{
		String UniqueReferenceVal3 = "Automation Policy1"+getCurrentDateTimeMS();
		String IncDate = "01/01/2017";
		String DueDays1 = "30";
		String ChannelIdentifier1 ="RISK1";
		String ChannelIdentifier2 ="RISK2";
		String NumberExpected1 ="18";
		String ChannelTypeOption1 = "Bordereaux";
		String TypeOption1 = "Risk";
		String Frequency1 = "Monthly";
		String SubmitSheet = "SP - First Sheet";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
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
		//loginPage.tideLogin();
		//policy.addPolicy1();
		policy.addPolicy1(IncDate);
		verifyExists(DraftBtn,"Draft Status Button");
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();

		policy.navigateToReportingChannelsTab();
		addReportingChannel(ChannelTypeOption1,TypeOption1,Frequency1,DueDays1,ChannelIdentifier1,NumberExpected1);
		//waitForElementToAppear(policy.ReportingChannelsTab,3);
		policy.navigateToReportingChannelsTab();
		addReportingChannel(ChannelTypeOption1,TypeOption1,Frequency1,DueDays1,ChannelIdentifier2,NumberExpected1);
		SubmitBordereaux(SubmitSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3480Path = fpath+"\\src\\test\\resources\\testdata\\YOAError_TC3480.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3480Path);  
		String contractId = addNewBordereauFormatPolicy(payload1, GetData);

		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"YOAError_TC3480.xlsx\",\"UniqueFileName\":\"S99544320171027.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S99544320171027.xlsx\",\"Filesize\":18041,\"Path\":null,\"size\":18041,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			waitForElementToAppear(SelectReportingChannel,3);
			if(isVisible(SelectReportingChannel)==true){
				Report.LogInfo("ValidateIdentifiedPopUp", "Navigate on Reporting Channel Identified successfully", "PASS");

				SelectReportingChannelMoreThanOneReportingChannelIdentifiedPage(ChannelIdentifier1);
				refreshUploadedFile();
				//sleep(2000);
				if(isVisible(ReviewBtn)==true){
					Report.LogInfo("ValidateReviewButton", "Review Button displayed after bordereau processing", "PASS");
					deleteBorderEAUX();
				}else{

					Report.LogInfo("ValidateReviewButton", "Review Button not displayed after bordereau processing", "FAIL");
					deleteBorderEAUX();
				}


			}else{
				Report.LogInfo("ValidateReportingChannelIdentifiedPopUp", "Navigate on Reporting Channel Identified  not successfully", "FAIL");
				goBack();
				deleteBorderEAUX();
			}
		}else{
			//sleep(3000);
			Report.LogInfo("ValidateIdentifiedPopUp", "Review error screen not displayed", "FAIL");
			deleteBorderEAUX();				
		}

	}



	//TestCase 3479
	public void ProcessBordereauxMultipleReportingChannelCancel() throws Exception{
		String OnlySpPoliCyNum = "297937DW";
		String SubmitSheet = "SP - First Sheet (Automation Schema)";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC3479.xlsx\",\"UniqueFileName\":\"S15412120171027.xlsx\",\"BordereauFormatId\":\"4ec20038-7ea9-4f10-845e-dac6477f02f7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S15412120171027.xlsx\",\"Filesize\":25040,\"Path\":null,\"size\":25040,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(SubmitSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3479Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC3479.xlsx";
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
		File excelFile = new File(sheet3479Path);  
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			waitForElementToAppear(NavigateOnPopUpReportingChannelIdentified,3);
			verifyMustExists(NavigateOnPopUpReportingChannelIdentified,"Navigate On PopUp ReportingChannel Identified");
			if(isVisible(NavigateOnPopUpReportingChannelIdentified)==true){
				Report.LogInfo("ValidateReportingChannelIdentifiedPopUp", "Navigate on Reporting Channel Identified successfully", "PASS");
				verifyMustExists(CancelButtonProcessBordereau,"CancelButtonProcessBordereau");
				click(CancelButtonProcessBordereau,"CancelButtonProcessBordereau");
				//sleep(2000);
				deleteBorderEAUX();

			}else{
				Report.LogInfo("ValidateReportingChannelIdentifiedPopUp", "Navigate on Reporting Channel Identified  not successfully", "FAIL");
				goBack();
				deleteBorderEAUX();
			}
		}
		//sleep(3000);
	}


	//------------------------------------Testcase:-3481-START----------------------------------------------//

	public void AddReportingChannelForQuarter() throws Exception{
		String OnlySpPoliCyNum = "297937DW";
		String DueDays1 = "30";
		String ChannelIdentifier1 ="osk Quarterly";
		String NumberExpected1 ="6";
		String ChannelTypeOption1 = "Bordereaux";
		String TypeOption1 = "Risk";
		String Frequency1 = "Quarterly";

		//sleep(3000);
		if(isVisible(ReportingChannelsTab1)==true){
			policy.navigateToReportingChannelsTab();
			addReportingChannel(ChannelTypeOption1,TypeOption1,Frequency1,DueDays1,ChannelIdentifier1,NumberExpected1);
			//sleep(2000);
			webDriver.navigate().refresh();
			waitForElementToAppear(VerifyAddedReportingChannelIdentifier,3);
			String ExpectReportingChannelIdentifier = getTextFrom(VerifyAddedReportingChannelIdentifier);
			if (ChannelIdentifier1.equalsIgnoreCase(ExpectReportingChannelIdentifier)){
				Report.LogInfo("ValidationAddedReportChannel", "Report Channel added successfully.", "PASS");
			}else{

				Report.LogInfo("ValidationAddedReportChannel", "Report Channel not added successfully.", "FAIL");
			}
			//sleep(3000);
			editAndDeleteReportingChanel(ChannelIdentifier1);
			//sleep(3000);
		}else{
			Report.LogInfo("ValReportChannel", "Not navigated on Report Channel tab.", "FAIL");
		}
	}

	//---------------------------------------------- TC_3372-START----------------------------------------//

	public void ProcessBordereauMoreThanOneMatchingReportingChannel() throws Exception{
		String SubmitSheet = "SP - First Sheet";
		String ChannelIdentifier1 ="Reporting channel- RISK";
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
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC3372.xlsx\",\"UniqueFileName\":\"S72201020180030.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S72201020180030.xlsx\",\"Filesize\":23537,\"Path\":null,\"size\":23537,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//String payload ="{\"Bordereaux\":{\"ContractId\":\"8b2e0a35-eb93-4620-bb49-5403a1e6f41d\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC3372.xlsx\",\"UniqueFileName\":\"S54490020180025.xlsx\",\"BordereauFormatId\":\"9cc958cc-448f-465b-9249-a75a8e3ccc37\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S54490020180025.xlsx\",\"Filesize\":23537,\"Path\":null,\"size\":23537,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		//loginPage.tideLogin();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		//sleep(2000);
		SubmitBordereaux(SubmitSheet);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3372Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC3372.xlsx";
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
		File excelFile = new File(sheet3372Path);  
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			waitForElementToAppear(SelectReportingChannel,3);
			if(isVisible(SelectReportingChannel)==true){
				Report.LogInfo("ValidateReportingChannelIdentifiedPopUp", "Navigate on Reporting Channel Identified successfully", "PASS");
				SelectReportingChannelMoreThanOneReportingChannelIdentifiedPage(ChannelIdentifier1);
				refreshUploadedFile();
				if(isVisible(ReviewBtn)==true){
					Report.LogInfo("ValidateReviewStatus", "Status Changed to Review", "PASS");
					deleteBorderEAUX();

				}else{
					Report.LogInfo("ValidateReviewStatus", "Status  not changed to Review", "FAIL");
					deleteBorderEAUX();
				}

			}else{
				Report.LogInfo("ValidateReportingChannelIdentifiedPopUp", "Navigate on Reporting Channel Identified  not successfully", "FAIL");
				goBack();
				deleteBorderEAUX();
			}
		}else{

			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displyed after bordereau processing", "FAIL");
			deleteBorderEAUX();
		}
		//sleep(3000);
	}

	//TC_3371

	public void SingleMatchingReportingChannel() throws Exception{

		String OnlySpPoliCyNum = "297937DW";
		String IncDate = "01/01/2017";
		String ExpDate = "31/12/2017";
		String UnderlineVal = "Childs, Andy";
		String SubmitSheet = "SP - First Sheet (Automation Schema)";
		//String payload = "{\"Bordereaux\":{\"ContractId\":\"4c35414b-fe83-4b84-909b-444421cd3cd6\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"PolicyId\":\"0\",\"OriginalFileName\":\"January 2017_TC3371.xlsx\",\"UniqueFileName\":\"S90667420171010.xlsx\",\"BordereauFormatId\":\"f3d9edd1-9335-4e0c-bc14-b7dcc6f3771f\",\"IsPolicyRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S90667420171010.xlsx\",\"Filesize\":23550,\"Path\":null,\"size\":23550,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauPolicy\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		//loginPage.tideLogin();
		policy.addPolicy2(IncDate,ExpDate);
		verifyExists(DraftBtn,"Draft Status Button");
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();

		SubmitBordereaux(SubmitSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3371Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC3371.xlsx";
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
		//StringSelection IdentificationSheet = new StringSelection(sheet3371Path);
		//UploadFile(IdentificationSheet);
		File excelFile = new File(sheet3371Path); 

		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC3371.xlsx\",\"UniqueFileName\":\"S47871320171027.xlsx\",\"BordereauFormatId\":\"4ec20038-7ea9-4f10-845e-dac6477f02f7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S47871320171027.xlsx\",\"Filesize\":23550,\"Path\":null,\"size\":23550,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ValidateReviewStatus", "Bordereau Processed without error", "PASS");
			deleteBorderEAUX();

		}else{
			Report.LogInfo("ValidateReviewStatus", "Bordereau  not Processed without error", "FAIL");
			deleteBorderEAUX();
		}
		//sleep(3000);
	}

	// ------------------------------TC_3437-START-----------------------------------------//



	public void NoReportingChannelAvailable() throws Exception{
		//String OnlySpPoliCyNum ="297937DW";
		String IncDate = "01/01/2017";
		//String IncepDate2 = "01/01/2018";
		String ExpDate="31/12/2017";

		String UnderlineVal = "Childs, Andy";
		policy.addPolicy2(IncDate, ExpDate);
		//verifyExists(DraftBtn,"Draft Status Button");
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();

		String OpenPolicy = "@xpath=//*[@id='FolderListGrid']//tr//td[contains(.,'"+policy.PolicyNumber+"')]";
		//String payload = "{\"Bordereaux\":{\"ContractId\":null,\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"2\",\"BordereauYear\":2017,\"PolicyId\":\"90725e09-fb29-42b4-aacf-e9185e083549\",\"OriginalFileName\":\"January 2017_TC3437.xlsx\",\"UniqueFileName\":\"S65896920171013.xlsx\",\"BordereauFormatId\":\"ae959d5a-e8d7-4f7e-9411-3f541b31eda5\",\"IsPolicyRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S65896920171013.xlsx\",\"Filesize\":23537,\"Path\":null,\"size\":23537,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauPolicy\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		NavigateBordereauHeaderLink();
		st2.navigateOnProcessingTab();
		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3437Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC3437.xlsx";
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
		File excelFile = new File(sheet3437Path);  

		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//System.out.println(contractId);
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"2\",\"BordereauYear\":2017,\"FolderId\":\"07b8bd6a-48d3-478a-a132-deef497b4e17\",\"OriginalFileName\":\"January 2017_TC3437.xlsx\",\"UniqueFileName\":\"S88890620171028.xlsx\",\"BordereauFormatId\":\"d0a8f3b7-8a1e-4e42-86f1-dba129975ccf\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S88890620171028.xlsx\",\"Filesize\":23537,\"Path\":null,\"size\":23537,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		ApplyFilterPolicyReference(policy.PolicyNumber);

		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed", "PASS");
			if(isVisible(NoReportingChannelIdentifiedPage)==true){
				Report.LogInfo("ValidateNavigatedPage", "No ReportingChannel Identified Page get opened ", "PASS");
				waitForElementToAppear(PauseButton,2);
				javaScriptclick(PauseButton,"PauseButton");
				//sleep(2000);
				ApplyFilterPolicyReference(policy.PolicyNumber);
				deleteBorderEAUX();
			}else{
				Report.LogInfo("ValidateNavigatedPage", "No ReportingChannel Identified Page not get opened ", "FAIL");
				goBack();
				ApplyFilterPolicyReference(policy.PolicyNumber);
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed", "FAIL");
			ApplyFilterPolicyReference(policy.PolicyNumber);
			deleteBorderEAUX();

		}
		//sleep(3000);
	}


	// TC- 3482 START

	public void AddReportingchannelAnnually() throws Exception {

		String OnlySpPoliCyNum = "297937DW";
		String DueDays1 = "30";
		String ChannelIdentifier1 ="osk Anually";
		String NumberExpected1 ="2";
		String ChannelTypeOption1 = "Bordereaux";
		String TypeOption1 = "Risk";
		String Frequency1 = "Annually";

		//sleep(3000);
		if(isVisible(ReportingChannelsTab1)==true){
			policy.navigateToReportingChannelsTab();
			addReportingChannel(ChannelTypeOption1,TypeOption1,Frequency1,DueDays1,ChannelIdentifier1,NumberExpected1);
			//sleep(2000);
			webDriver.navigate().refresh();
			waitForElementToAppear(VerifyAddedReportingChannelIdentifier,5);
			String ExpectReportingChannelIdentifier = getTextFrom(VerifyAddedReportingChannelIdentifier);
			if (ChannelIdentifier1.equalsIgnoreCase(ExpectReportingChannelIdentifier)){
				Report.LogInfo("ValidationAddedReportChannel", "Report Channel added successfully.", "PASS");
			}else{

				Report.LogInfo("ValidationAddedReportChannel", "Report Channel not added successfully.", "FAIL");
			}
			//sleep(3000);
			editAndDeleteReportingChanel(ChannelIdentifier1);
			//sleep(3000);
		}else{
			Report.LogInfo("ValReportChannel", "Not navigated on Report Channel tab.", "FAIL");
		}
	} 






	//===============================Reusable - Fuctions Reporting Channel==================================================================//


	public void NavigateBordereauHeaderLink() throws Exception{
		waitForElementToAppear(BordereauHeaderLink,5);
		verifyMustExists(BordereauHeaderLink,"BordereauHeaderLink");
		click(BordereauHeaderLink,"BordereauHeaderLink");
		//sleep(3000);


	}

	public void OpenReportchannel() throws Exception{
		waitForElementToAppear(ReportingChannelLink,5);
		verifyMustExists(ReportingChannelLink,"ReportingChannelLink");
		click(ReportingChannelLink,"ReportingChannelLink");
		////sleep(3000);


	}
	public void addReportingChannel(String ChannelTypeOption, String Typeoption, String FrequencyOption,String DueDays,String ChannelIdentifier,String NumberExpected){

		waitForElementToAppear(AddReportingChannelButton,3);
		verifyMustExists(AddReportingChannelButton,"AddReportingChannelButton");
		click(AddReportingChannelButton,"AddReportingChannelButton");
		

		SelectDropDownValue(ChannelTypeSelection,ChannelTypeOption1);
	
		SelectDropDownValue(TypeSelection,TypeOption1);
		
		if(FrequencyOption == "Quartely"){
			
			SelectDropDownValue(FrequencySelection,FrequencySelectedOption2);
			
		} if(FrequencyOption == "Annually"){
			SelectDropDownValue(FrequencySelection,FrequencySelectedOption3);
		} else {
		SelectDropDownValue(FrequencySelection,FrequencySelectedOption1);
		}
		waitForElementToAppear(DueDaysTextBox,5);
		sendKeys(DueDaysTextBox,DueDays,"DueDaysTextBox");
		////sleep(2000);
		waitForElementToAppear(NumberExpectedTextBox,5);
		sendKeys(NumberExpectedTextBox,NumberExpected,"NumberExpectedTextBox");

		waitForElementToAppear(ReportingIdentifierTextBox,5);
		sendKeys(ReportingIdentifierTextBox,ChannelIdentifier,"ReportingIdentifierTextBox");

		waitForElementToAppear(SaveButtonReportChannel,5);
		click(SaveButtonReportChannel,"SaveButtonReportChannel");
		sleep(2000);
		if(isVisible(policy.secondSectionPopUp) == true)
		{
			verifyExists(policy.SaveBtn1,"Save Button");
			click(policy.SaveBtn1,"Save Button");
			sleep(1000);
		}
		policy.ContSettingPopUpAccept();
		//sleep(4000);

	}
	public void editAndDeleteReportingChanel(String CreatedFilledData){

		String ReportVal = "@xpath=//td[contains(text(),'"+CreatedFilledData+"')]//preceding-sibling::td[5]//descendant::i";
		waitForElementToAppear(ReportVal,5);
		if(isVisible(ReportVal)==true){
			click(ReportVal,"Edit Reporting Channel");
			//webDriver.findElement(By.xpath("//td[contains(text(),'"+CreatedFilledData+"')]//preceding-sibling::td[5]//descendant::i")).click();
			waitForElementToAppear(ReportingChannelDeleteButton,4);
			verifyMustExists(ReportingChannelDeleteButton,"ReportingChannelDeleteButton");
			click(ReportingChannelDeleteButton,"ReportingChannelDeleteButton");
			sleep(1500);
			if(isVisible(policy.secondSectionPopUp) == true)
			{
				verifyExists(policy.SaveBtn1,"Save Button");
				click(policy.SaveBtn1,"Save Button");
				sleep(1000);
			}
			waitForElementToAppear(ReportingChannelDeleteButtonConfirm,5);
			verifyMustExists(ReportingChannelDeleteButtonConfirm,"ReportingChannelDeleteButtonConfirm");
			if(isVisible(ReportingChannelDeleteButtonConfirm)==true){
				click(ReportingChannelDeleteButtonConfirm,"ReportingChannelDeleteButtonConfirm");
				//sleep(2000);
				Report.LogInfo("ValidationDeleteReportChannel", "Report Channel deleted successfully.", "PASS");
			}else{
				Report.LogInfo("ValidationDeleteReportChannel", "Report Channel not deleted successfully.", "FAIL");
			}
			//sleep(2000);
		}else{
			Report.LogInfo("ScreenCheck", "Expected error screen not displayed.", "FAIL");
		}

	}


	public void NavigateToDetailsPolicyPage(){
		waitForElementToAppear(DetailPolicyLink,5);
		verifyMustExists(DetailPolicyLink,"DetailPolicyLink");
		click(DetailPolicyLink,"DetailPolicyLink");
		////sleep(2000);

	}

	public void SelectReportingChannelMoreThanOneReportingChannelIdentifiedPage(String ReportingChannel){

		waitForElementToAppear(SelectReportingChannel,5);
		verifyMustExists(SelectReportingChannel,"SelectReportingChannel");
		click(SelectReportingChannel,"SelectReportingChannel");
		sleep(3000);
		//waitForElementToAppear(ReportingChannelOption,3);
		webDriver.findElement(By.xpath("//li[text()='"+ReportingChannel+"']")).click();
		////sleep(3000);
		waitForElementToAppear(ContinueReportingChannelProcessButton,5);
		click(ContinueReportingChannelProcessButton,"ContinueReportingChannelProcessButton");
		//sleep(2000);
	}



	public void SubmitBordereauWhenClickedOnBordereauHeaderLink(String selectOption,String QuestionnaireName ){

		verifyMustExists(SubmitBordereauxDropdown,"Submit Bordereaux Dropdown");
		click(SubmitBordereauxDropdown,"Submit Bordereaux Dropdown");
		//sleep(2000);
		verifyMustExists(SelectOptionPremium,"Select Option");
		webDriver.findElement(By.xpath("//a[text()='"+selectOption+"']")).click();
		//sleep(2000);		
		if(isVisible(PreviousAnsNoRadioBtn))
		{
			click(PreviousAnsNoRadioBtn,"Use Previous Answer No Radio Button");
			//sleep(2000);
		}
		waitForElementToAppear(SelectPolicyBordereauProcessTextBox,3);
		verifyMustExists(SelectPolicyBordereauProcessTextBox,"SelectPolicyBordereauProcessTextBox");
		//webDriver.navigate().refresh();
		click(SelectPolicyBordereauProcessTextBox,"SelectPolicyBordereauProcessTextBox");
		waitForElementToAppear(PleaseSelectPolicyOptin,5);
		javaScriptclick(PleaseSelectPolicyOptin,"PleaseSelectPolicyOptin");
		//webDriver.findElement(By.xpath("//li[text()='"+SubmitSheetName+"']//parent::ul[1]")).click();
		//selectByVisibleText(PleaseSelectPolicyOptin,"(297937DW)");
		waitForElementToAppear(SelectToAnswerQuestionnaire,3);
		verifyMustExists(SelectToAnswerQuestionnaire,"SelectToAnswerQuestionnaire");
		click(SelectToAnswerQuestionnaire,"SelectToAnswerQuestionnaire");
		verifyMustExists(SelectToAnswerQuestionnaireSearchBox,"SelectToAnswerQuestionnaireSearchBox");
		sendKeys(SelectToAnswerQuestionnaireSearchBox,QuestionnaireName,"SelectToAnswerQuestionnaireSearchBox");
		waitForElementToAppear(SelectToAnswerQuestionnaireOption,3);
		webDriver.findElement(By.xpath("//li[text()='"+QuestionnaireName+"']//parent::ul[1]")).click();
		//sleep(3000);
		verifyMustExists(Calender,"Calender");
		click(Calender,"Calender");
		verifyMustExists(DateJan,"Date Jan");
		javaScriptclick(DateJan,"Date Jan");

	}

	public void ApplyFilterPolicyReference(String PolicyNo){

		////sleep(3000);
		int i=0;
		String RecordCheckbox ="@css=[value='"+PolicyNo+"']";
		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			click(PolicyReferenceIcon, "Policy Reference Filter Icon is clicked");
			//sleep(2000);
			if(isVisible(PolicyReferenceIconSearchField))
			{
				verifyMustExists(PolicyReferenceIconSearchField,"Search Filter Textbox");	
				sendKeys(PolicyReferenceIconSearchField,PolicyNo,"Search Filter Textbox.");
				//sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);

		click(RecordCheckbox, "Searched Record Checkbox");
		waitForElementToAppear(FilterButtonPolicyReference,5);
		verifyMustExists(FilterButtonPolicyReference,"Filter Button");
		click(FilterButtonPolicyReference,"Filter Button");
		//sleep(3000);
	}

	public void ApplyFilterPolicyFilterToReviewErrorDelete(String PolicyNo){

		//sleep(5000);
		String RecordCheckbox ="@css=[value='"+PolicyNo+"']";
		//clickAndWait(PolicyReferenceIcon, "Policy Reference Filter Icon");
		verifyMustExists(PolicyReferenceIconSearchField,"Search Filter Textbox");	
		sendKeys(PolicyReferenceIconSearchField,PolicyNo,"Search Filter Textbox.");
		//sleep(3000);
		click(RecordCheckbox, "Searched Record Checkbox");
		waitForElementToAppear(FilterButtonPolicyReference,5);
		verifyMustExists(FilterButtonPolicyReference,"Filter Button");
		click(FilterButtonPolicyReference,"Filter Button");
		//sleep(3000);
		checkRecordsAndDeleteReviewError1();

	}

	public void ApplyFilterPolicyFilterToReviewDelete(String PolicyNo){

		//sleep(2000);
		String RecordCheckbox ="@css=[value='"+PolicyNo+"']";
		click(PolicyReferenceIcon, "Policy Reference Filter Icon");
		////sleep(6000);
		waitForElementToAppear(PolicyReferenceIconSearchField,6);
		verifyMustExists(PolicyReferenceIconSearchField,"Search Filter Textbox");	
		sendKeys(PolicyReferenceIconSearchField,PolicyNo,"Search Filter Textbox.");
		////sleep(3000);
		waitForElementToAppear(RecordCheckbox,5);
		click(RecordCheckbox, "Searched Record Checkbox");
		waitForElementToAppear(FilterButtonPolicyReference,5);
		verifyMustExists(FilterButtonPolicyReference,"Filter Button");
		click(FilterButtonPolicyReference,"Filter Button");
		//sleep(3000);
		checkRecordsAndDeleteReview1();
	}


	public void uploadedDeleteButton(String status){
		verifyMustExists(UploadedDeleteButton,"UploadedDeleteButton");
		webDriver.findElement(By.xpath("//button[text()='"+status+"']//following-sibling::span[1]/i")).click();
		waitForElementToAppear(UploadedDeleteYESButton,2);
		verifyMustExists(UploadedDeleteYESButton,"UploadedDeleteYESButton");
		click(UploadedDeleteYESButton,"UploadedDeleteYESButton");

	}
	public void SubmitBordereauxWithYesnoButtons(String Date) throws Exception{
		//sleep(2000);

		waitForElementToAppear(BORDEREAUXLink,5);
		verifyMustExists(BORDEREAUXLink,"BORDEREAUX Link");		    
		click(BORDEREAUXLink,"BORDEREAUX Link");
		//sleep(3000);
		checkRecordsAndDeleteReviewError();
		SelectDropDownValue(SubmitBordereauxDropdown,SelectOptionRisk);
		/*verifyMustExists(SubmitBordereauxDropdown,"Submit Bordereaux Dropdown");
		click(SubmitBordereauxDropdown,"Submit Bordereaux Dropdown");
		//sleep(2000);
		verifyMustExists(SelectOptionRisk,"Select Option Risk");
		click(SelectOptionRisk,"Select Option Risk");*/
		//sleep(3000);  
		if(isVisible(PreviousAnsYesRadioBtn) == true)
		{
			CalDateSelection(Date);
		}else{
			Report.LogInfo("PageCheckSubmitBordereau", "Page not available as expected", "FAIL");
		}
	}
	public void CalDateSelection (String Date)
	{
		waitForElementToAppear(Calender,5);
		verifyMustExists(Calender,"Calender");
		click(Calender,"Calender");
		//sleep(2000);
		sendKeys(CalenderInputBox,Date,"Select period of date");
		//sleep(1000);
		click(Calender,"Calender");
		//sleep(2000);
	}

	//================================Reusable Function Bordereau processing==================================================//

	//------------------------------------------------------- Reusable functions -----------------------------------------------------------------//
	//--------------------------------------------------------------------------------------------------------------------------------------------//	

	public void deleteBorderEAUX(){
		////sleep(3000);  
		waitForElementToAppear(DeleteButton,5);
		verifyMustExists(DeleteButton,"Delete Button");
		click(DeleteButton,"Delete Button");
		////sleep(4000);
		waitForElementToAppear(DeleteYESButton,5);
		if(isVisible(DeleteYESButton)== true){
			verifyMustExists(DeleteYESButton,"Delete YES Button");
			click(DeleteYESButton,"Delete YES Button");
			//sleep(3000);
		}
		else{
			Report.LogInfo("DeleteYesBTN", "Yes button is not displayed", "FAIL");
			click(CancelBtn,"Delete Cancel Button");   
		}
	}	

	public void gotopolicy()
	{
		webDriver.navigate().refresh();
		click(PolicyHome,"Policy link");
		//sleep(2000);
	}
	public void VerificationCounts (int expectedCount){
		////sleep(2000);
		waitForElementToAppear(RiskTab,5);
		verifyMustExists(RiskTab,"Risk Tab");
		click(RiskTab,"Risk Tab");
		////sleep(6000);
		waitForElementToAppear(ChangePageCountDropDn,6);
		verifyMustExists(ChangePageCountDropDn,"Change Page Count Dropdown");
		click(ChangePageCountDropDn,"Change Page Count Dropdown");
		//sleep(2000);
		click(ChangePageCountTo,"Change Page Count To");
		////sleep(4000);
		waitForElementToAppear(ActualExpectedRowCount,5);
		List <WebElement> list = findWebElements(ActualExpectedRowCount);
		int count = list.size();
		//sleep(2000);
		if(count == expectedCount)
		{
			Report.LogInfo("ValidateRecords", "Records count matches with the records in the excel file. Actual records count is: "+count, "PASS");
		}else{
			Report.LogInfo("ValidateRecords", "Records count does not match with the records in the excel file. Actual records count is: "+count, "FAIL");
		}
		//sleep(2000);
		goBack();
	}

	public void applyFilterPolicy(String PolicyNumber) throws InterruptedException{

		int i=0;
		String RecordCheckbox ="@css=[value='"+PolicyNumber+"']";

		waitForElementToAppear(PolicyHome,6);
		verifyMustExists(PolicyHome,"Policy Link");
		click(PolicyHome,"Policy Link");
		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			click(PolicyReferenceFilterIcon, "Policy Reference Filter Icon");
			sleep(2000);
			if(isVisible(SearchText))
			{
				verifyMustExists(SearchText,"Search Filter Textbox");	
				sendKeys(SearchText,PolicyNumber,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);

		click(RecordCheckbox, "Searched Record Checkbox");
		verifyMustExists(FilterButton,"Filter Button");
		click(FilterButton,"Filter Button");
		sleep(3000);
	}

	public void openSelectedPolicy(){
		waitForElementToAppear(SelectedPolicy,3);
		verifyMustExists(SelectedPolicy,"Selected Policy");
		click(SelectedPolicy,"Selected Policy");
		//sleep(2500);
	}
	public void SubmitBordereaux(String SubmitSheet) throws Exception{
		waitForElementToAppear(BORDEREAUXLink,5);
		verifyMustExists(BORDEREAUXLink,"BORDEREAUX Link");
		click(BORDEREAUXLink,"BORDEREAUX Link");
		//sleep(3000);
		Br.navigateOnProcessingTab();
		if (isVisible(BlankDetailsMsg)==true)
		{
			Report.LogInfo("StatusCheck", "No status records found", "PASS");
		}else{
			//Report.LogInfo("StatusCheck", "Status records found", "FAIL");
			//sleep(2000);
			checkRecordsAndDeleteReviewError();
			sleep(2000);
			checkRecordsAndDeleteReview();
		}		
	}

	public void FilterPolicy(String PolicyNumber1FirstSheet){
		waitForElementToAppear(PolicyHome,5);
		verifyMustExists(PolicyHome,"Policy Link");
		click(PolicyHome,"Policy Link");
		verifyMustExists(PolicyReferenceFilterIcon,"Policy Reference Filter Icon");
		click(PolicyReferenceFilterIcon,"Policy Link");
		verifyMustExists(SearchText,"Search Textbox");
		sendKeys(SearchText,PolicyNumber1FirstSheet,"Search Textbox field.");
		sleep(2000);
		webDriver.findElement(By.cssSelector("[value='"+PolicyNumber1FirstSheet+"']")).click();
		waitForElementToAppear(FilterButton,5);
		verifyMustExists(FilterButton,"Filter Button");
		click(FilterButton,"Filter Button");
		sleep(3000);
	}

	public void SubmitBordereauxFirstSheet(String FirstSheet) throws Exception{
		waitForElementToAppear(BorderEAUXFirst,5);
		verifyMustExists(BorderEAUXFirst,"BorderEAUX First");
		click(BorderEAUXFirst,"BorderEAUX First");
		SelectDropDownValue(SubmitBordereauxDropdown,SelectOptionRisk);
		/*verifyMustExists(SubmitBordereauxDropdown,"Submit Bordereaux Dropdown");
		click(SubmitBordereauxDropdown,"Submit Bordereaux Dropdown");
		//sleep(2000);
		verifyMustExists(SelectOptionRisk,"Select Option Risk");
		click(SelectOptionRisk,"Select Option Risk");*/
		//sleep(2000);
		verifyMustExists(SelectNewquestionnaire,"Select New Questionnaire");
		javaScriptclick(SelectNewquestionnaire);
		sendKeys(EnterOptionToSelect,Questionnaire,"Option to select questionnaire.");
		sleep(4000);
		webDriver.findElement(By.xpath("//li[contains(text(),'"+FirstSheet+"')]")).click();
		verifyMustExists(CalenderFirstST,"Calender");
		click(CalenderFirstST,"Calender");
		////sleep(4000);
		waitForElementToAppear(DateJan,5);
		verifyMustExists(DateJan,"Date Jan");
		javaScriptclick(DateJan);
		//sleep(2000);
	}

	public void refreshUploadedFile() throws Exception
	{
		for(int i= 0; i<=25; i++)
		{
			//sleep(3000);
			click(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			if(isVisible(ReviewError) || isVisible(ReviewBtn)){
				VerifyNotificationPopupAfterUpload();
				break;
			}
		}
	}
	public void refreshAfterUploadedFileForReviewSatusAndUploadStatus() throws Exception
	{
		for(int i= 0; i<=25; i++)
		{
			//sleep(3000);
			click(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			if(isVisible(ReviewError) || isVisible(UploadedButton)){
				VerifyNotificationPopupAfterUpload();
				break;
			}
		}
	}

	public void EditSpecificText(String text){
		waitForElementToAppear(ToEditSpecificText,3);
		verifyMustExists(ToEditSpecificText,"To Edit Specific Text");
		sendKeys(ToEditSpecificText,text,"Textbox to Edit the Sheet.");
		//sleep(2000);
		click(ProcessBorderEAuButton,"Process Bordereau Button");
		//sleep(5000);
	}

	public void monthSelection()
	{		
		verifyMustExists(ProcessingTiem,"Processing time field");
		click(ProcessingTiem,"Processing time field");
		//sleep(1000);
		verifyMustExists(May2017,"May 2017 option");
		click(May2017,"May 2017 option");
		//sleep(1000);
		click(ErrorScreen,"Error Screen");
		//sleep(2000);
		javaScriptclick(ProcessingTimeSecond,"Processing time field");
		sendKeys(ProcessingTimeSecond,"June 2017","Processing time field.");
		//sleep(1000);
		verifyMustExists(June2017,"May 2017 option");
		click(June2017,"May 2017 option");
	}

	public void selectSheetForProcessingRadioAndDate(){
		verifyMustExists(RemainUnchangedRadioButton,"Remain Unchanged Radio Button");
		click(RemainUnchangedRadioButton,"Remain Unchanged Radio Button");
		//sleep(1000);
		verifyMustExists(NoSingelContainProcessingTime,"No Singel Contain Processing Time drop down");
		click(NoSingelContainProcessingTime,"No Singel Contain Processing Time drop down");
		//sleep(2000);
		verifyMustExists(Mar2017,"March 2016 value");
		click(Mar2017,"March 2016 value");
		//sleep(1000);
	}

	public boolean checkErrorReviewButton(String locator)
	{	
		if(!isBlankOrNull(locator))
		{
			try{
				setImplicitWaitTimeout(2);
				WebElement element=findWebElement(locator);
				setImplicitWaitTimeout(50000);
				if(element != null)
				{	
					verifyMustExists(ReviewError,"Review Error Status");
					click(ReviewError,"Review Error Status");
					//sleep(2000);
					return true;
				}else{
					return false;
				}
			}catch (Exception e){
				setImplicitWaitTimeout(50000);
				return false;			
			}
		}else{
			Report.LogInfo("verifyMustExists","verify locator : \""+locator+"\" is not present", "INFO");
			return false;
		}
	}

	public void verifyErrormessage(String msg){	
		verifyExists(ErrorScreen,"Error Screen");
		String AcualErrorMsg = getTextFrom(ErrorScreen);
		if(AcualErrorMsg.equalsIgnoreCase(msg)){

			Report.LogInfo("ValidateErrorMessage", "Validation Message is as expected. Actual message is: "+AcualErrorMsg, "PASS");
		}else{
			Report.LogInfo("ValidateErrorMessage", "Validation Message is not as expected. Actual message is: "+AcualErrorMsg, "FAIL");
		}
		//sleep(2000);
	}

	public void verifyandClickProcessBorderEAuButton(){	
		waitForElementToAppear(ProcessBorderEAuButton,5);
		verifyMustExists(ProcessBorderEAuButton,"Process Bordereau Button");
		click(ProcessBorderEAuButton,"Process Bordereau Button");
		//sleep(1000);
	}

	public void verifyandClickCancelAndDeleteProButton(){	
		verifyMustExists(cancelAndDeleteProBtn,"Cancel And Delete Processing button");
		click(cancelAndDeleteProBtn,"Cancel And Delete Processing button");
		//sleep(6000);
	}	

	public void bordereauxProcessing(String ExpectedErrorMsg, String ExpSecondErrorMsg){
		//sleep(3000);

		verifyMustExists(ErrorScreen,"Error Screen");
		String AcualErrorMsg = getTextFrom(ErrorScreen);

		if(AcualErrorMsg.equalsIgnoreCase(ExpectedErrorMsg)){
			Report.LogInfo("ValidateErrorMessage", "Validation Message displayed as expected. Actual message displayed is: "+AcualErrorMsg, "PASS");
		}else{
			Report.LogInfo("ValidateErrorMessage", "Validation Message not displayed as expected. Actual message displayed is: "+AcualErrorMsg, "FAIL");
		}
		//sleep(2000);

	}

	public void bordereauxProcessRemainUnchanged(String ExpectedErrorMsg, String year) {
		verifyMustExists(ErrorScreen,"Error Screen");
		String AcualErrorMsg = getTextFrom(ErrorScreen);
		if(AcualErrorMsg.equalsIgnoreCase(ExpectedErrorMsg)){

			Report.LogInfo("ValidateErrorMessage", "Validation Message displayed as expected. Actual message displayed is: "+AcualErrorMsg, "PASS");
		}else{
			Report.LogInfo("ValidateErrorMessage", "Validation Message not displayed as expected. Actual message displayed is: "+AcualErrorMsg, "FAIL");
		}
		//sleep(2000);
		verifyMustExists(RemainUnchangedRadioButton,"Remain Unchanged Radio Button");
		click(RemainUnchangedRadioButton,"Remain Unchanged Radio Button");
		verifyMustExists(SelectDropDown,"Select DropDown");
		click(SelectDropDown,"Select DropDown");
		sleep(3000);
		webDriver.findElement(By.xpath("//li[contains(text(),'"+year+"')]")).click();

		verifyMustExists(ProcessBorderEAuButton,"Process Bordereau Button");
		click(ProcessBorderEAuButton,"Process Bordereau Button");
	}

	public void cancelAndDeleteBoredereauByCatchingValidation(String ExpectedErrorMsg){
		////sleep(3000);
		if(isVisible(ErrorScreen)== true){
			verifyMustExists(ErrorScreen,"Error Screen");
			String AcualErrorMsg = getTextFrom(ErrorScreen);
			if(AcualErrorMsg.equalsIgnoreCase(ExpectedErrorMsg)){
				Report.LogInfo("ValidateErrorMessage", "Validation Message is displayed as expected. Actual message displayed is: "+AcualErrorMsg, "PASS");
			}else{
				Report.LogInfo("ValidateErrorMessage", "Validation Message is not displayed as expected. Actual message displayed is: "+AcualErrorMsg, "FAIL");
			}
			verifyMustExists(CancelAndDeleteBordereaux,"Cancel And Delete Bordereaux");
			click(CancelAndDeleteBordereaux,"Cancel And Delete Bordereaux");
			//sleep(4000);
		}else{
			Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
		}
	}
	public void passDate(String Date){
		verifyMustExists(DateTextBox,"Date Textbox");
		sendKeys(DateTextBox,Date,"Date Textbox.");
		//sleep(2000);

	}
	public void verifyBackground(String locator,String colorcode ){
		String actuallcolor= findWebElement(locator).getCssValue("color"); 
		if(actuallcolor.equalsIgnoreCase(colorcode)){

			Report.LogInfo("Validatebackrgound", "Validation background displayed to green successfully.", "PASS");
		}else{
			Report.LogInfo("Validatebackrgound", "Validation background not displayed to green successfully.", "FAIL");
		}
		//sleep(3000);
	}

	public boolean checkReviewButton(String locator)
	{ 
		if(!isBlankOrNull(locator))
		{
			try{
				setImplicitWaitTimeout(2);
				WebElement element=findWebElement(locator);
				setImplicitWaitTimeout(50000);
				if(element != null)
				{ 
					verifyMustExists(ReviewBtn,"Review Button");
					//sleep(2000);
					return true;
				}else{
					return false;
				}
			}catch (Exception e){
				setImplicitWaitTimeout(50000);
				return false;   
			}
		}else{
			Report.LogInfo("verifyMustExists","verify locator : \""+locator+"\" is not present", "INFO");
			return false;
		}
	}

	public void selectSheetRadioAndVerifyErrorMessage(String errorsheetmsg){
		waitForElementToAppear(SheetNameRadioBtx,5);
		verifyMustExists(SheetNameRadioBtx,"Sheet Name radio button");
		click(SheetNameRadioBtx,"Sheet Name radio button");
		//sleep(1000);
		verifyMustExists(ErrorScreen,"Error Screen");
		String AcualErrorMsg = getTextFrom(ErrorScreen);
		if(AcualErrorMsg.equalsIgnoreCase(errorsheetmsg)){

			Report.LogInfo("ValidateErrorMessage", "Validation Message is displayed as expected. Actual message displayed is: "+AcualErrorMsg, "PASS");
		}else{
			Report.LogInfo("ValidateErrorMessage", "Validation Message is not displayed as expected. Actual message displayed is: "+AcualErrorMsg, "FAIL");
		}
		//sleep(2000);	 
	}
	public void monthselection() {
		verifyMustExists(sheetdropdown,"Sheet Dropdown");
		click(sheetdropdown,"Sheet Dropdown");
		//sleep(5000);
		//waitForElementToAppear(April2017,5);
		verifyMustExists(April2017,"April 2017 Option");
		javaScriptclick(April2017,"April 2017 Option");
		//sleep(3000);
	}   
	public void verifyvalidDateAndBackground()
	{
		clearTextBox(datefield);
		sendKeys(datefield,"11/01/2017","Date field.");  
		verifyMustExists(datefield,"Date field");
		verifyBackground(datefield,"rgba(0, 97, 0, 1)");
		//sleep(2000);
		verifyMustExists(continuebtx,"Continue button");
		click(continuebtx,"Continue button");
	}
	public void processBordereauAccounterror() throws Exception
	{
		if(checkErrorReviewButton(ReviewError)== true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			//sleep(2000);
			VerifyNotificationPopupAfterUpload();
			//sleep(2000);
			if(isVisible(ErrorScreen)== true){
				verifyMustExists(discardRecord,"First discard record");
				click(discardRecord,"Discard record");
				verifyMustExists(continuebtx,"Continue button");
				click(continuebtx,"Continue button");
				//sleep(3000);
				verifyBackground(yearAccount,"rgba(156, 0, 6, 1)");
				verifyBackground(inceptionDate,"rgba(156, 0, 6, 1)");
				clearTextBox(yearAccount);
				sendKeys(yearAccount,"2017","Year Account field.");
				//sleep(3000);
				verifyBackground(yearAccount,"rgba(0, 97, 0, 1)");
				verifyBackground(inceptionDate,"rgba(0, 97, 0, 1)");
				verifyMustExists(continuebtx,"Continue button");
				click(continuebtx,"Continue button");
				refreshUploadedFile();
				verifyMustExists(ReviewBtn,"Review Status button");
				deleteBorderEAUX();
				VerifyNotificationPopupAfterUpload();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		} 
		else
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			VerifyNotificationPopupAfterUpload();
		}
	}

	public void VerifyNotificationPopupAfterUpload() throws Exception{

		if(isVisible(SuccessNotificationMsgAfterUpload))
		{
			//Report.LogInfo("NotificationAfterUpload", "Success notification displayed after uploading bordereau.", "PASS");
			//sleep(1000);
			click(OkButtonOnSuccessNotification,"Ok Button On Success Notification");
		}
		else if(isVisible(FailureNotificationMsgAfterUpload))
		{
			//Report.LogInfo("NotificationAfterUpload", "Failure notification displayed after uploading bordereau.", "PASS");
			//sleep(1000);
			click(CancelButtonOnFailureNotification,"Cancel Button On Failure Notification");
		}
		/*else
		{
			Report.LogInfo("NotificationAfterUpload", "Success or Failure Notification not displayed after uploading bordereau.", "FAIL");
		}*/

	}

	public void checkRecordsAndDeleteReviewError(){
		Br.navigateOnProcessingTab();
		waitForElementToAppear(filterIconRecords,3);
		verifyMustExists(filterIconRecords,"filterIconRecords");
		click(filterIconRecords,"filterIconRecords");
		if(isVisible(ReviewErrorCheckBox)==true){
			click(ReviewErrorCheckBox,"ReviewErrorCheckBox");
			verifyMustExists(FilterButtonRecords,"FilterButtonRecords");
			click(FilterButtonRecords,"FilterButtonRecords");
			//sleep(4000);
			List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
			int recordsCount = totatRecords.size();
			for(int i=1;i<=recordsCount;i++){
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateRecords", "No older records found", "PASS");
		}
	}

	public void checkRecordsAndDeleteReviewError1(){
		waitForElementToAppear(filterIconRecords,3);
		verifyMustExists(filterIconRecords,"filterIconRecords");
		click(filterIconRecords,"filterIconRecords");
		if(isVisible(ReviewErrorCheckBox)==true){
			click(ReviewErrorCheckBox,"ReviewErrorCheckBox");
			verifyMustExists(FilterButtonRecords1,"FilterButtonRecords");
			click(FilterButtonRecords1,"FilterButtonRecords");
			//sleep(4000);
			List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
			int recordsCount = totatRecords.size();
			for(int i=1;i<=recordsCount;i++){
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateRecords", "No older records found", "PASS");
		}
	}



	public void checkRecordsAndDeleteReview(){
		refreshPage();
		//sleep(6000);
		waitForElementToAppear(filterIconRecords,8);
		verifyMustExists(filterIconRecords,"filterIconRecords");
		click(filterIconRecords,"filterIconRecords");
		if(isVisible(ReviewCheckBox)==true){
			click(ReviewCheckBox,"ReviewCheckBox");
			verifyMustExists(FilterButtonRecords,"FilterButtonRecords");
			click(FilterButtonRecords,"FilterButtonRecords");
			//sleep(2000);
			List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
			int recordsCount = totatRecords.size();
			for(int i=1;i<=recordsCount;i++){				
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateRecords", "No older records found", "PASS");
		}
	}

	public void checkRecordsAndDeleteReview1(){
		//refreshPage();
		////sleep(6000);
		waitForElementToAppear(filterIconRecords,8);
		verifyMustExists(filterIconRecords,"filterIconRecords");
		click(filterIconRecords,"filterIconRecords");
		if(isVisible(ReviewCheckBox)==true){
			click(ReviewCheckBox,"ReviewCheckBox");
			verifyMustExists(FilterButtonRecords1,"FilterButtonRecords");
			click(FilterButtonRecords1,"FilterButtonRecords");
			//sleep(2000);
			List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
			int recordsCount = totatRecords.size();
			for(int i=1;i<=recordsCount;i++){				
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateRecords", "No older records found", "PASS");
		}
	}
	public void verificationCountsAfterReviewButton(int expectedCount){

		waitForElementToAppear(RiskTabAfterReview,3);
		verifyMustExists(RiskTabAfterReview,"Risk Tab");
		click(RiskTabAfterReview,"Risk Tab");
		////sleep(6000);
		waitForElementToAppear(ChangePageCountDropDn,6);
		verifyMustExists(ChangePageCountDropDn,"Change Page Count Dropdown");
		click(ChangePageCountDropDn,"Change Page Count Dropdown");
		//sleep(2000);
		click(ChangePageCountTo,"Change Page Count To");
		//sleep(3000);
		List <WebElement> list = findWebElements(ActualExpectedRowCount);
		int count = list.size();
		//sleep(2000);
		if(count == expectedCount)
		{
			Report.LogInfo("ValidateRecords", "Records count matches with the records in the excel file. Actual records count is: "+count, "PASS");
		}else{
			Report.LogInfo("ValidateRecords", "Records count does not match with the records in the excel file. Actual records count is: "+count, "FAIL");
		}
		//sleep(2000);
		goBack();

	}

	public void openDATALink()
	{
		waitForElementToAppear(DATAlink,5);
		verifyMustExists(DATAlink,"DATA Link");
		click(DATAlink,"Click on DATA link");
		////sleep(5000);

	}

	public void  selectRowNumberAscOrder()
	{
		verifyMustExists(RowNumber,"Row Number");
		click(RowNumber,"Click on Row Number");
		waitForElementToAppear(RowNumberAscIcon,5);
		verifyMustExists(RowNumberAscIcon,"Row Number Ascending icon");  
		////sleep(3000);
	}
	
	public void refreshBordereauxUploadedFile() throws Exception
	 {
		//Br.navigateOnProcessingTab();
	  for(int i= 0; i<=25; i++)
	  {
	   click(RefreshBordereauxAfterUpload,"Refresh After File Upload");
	   if(isVisible(OpenBordereauxAfterUpload)){
	    break;
	   }
	  }
	 }

}


