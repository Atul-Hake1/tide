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

public class BordereauProcessPage extends PageBase{
	LoginPage loginPage = new LoginPage();
	BordereauQuePage BQPage = new BordereauQuePage();
	HomePage homePage = new HomePage();
	DatasetReferenceDataPage datasetPage = new DatasetReferenceDataPage();
	PolicyPage policy = new PolicyPage();
	Stage1Page St1 = new Stage1Page();
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
	//String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
	//String UniqueReferenceVal3 = "Automation Policy1"+getCurrentDateTimeMS();
	String CompanyReferenceval = "Automation Policy1"+getCurrentDateTimeMS();
	String UniqueReferenceVal2 = "Contract 2"+getCurrentDateTimeMS();
	static String  Rule = "AutoRule"+getCurrentDateTimeMS();
	static String  Rule1 = "AutoRule1"+getCurrentDateTimeMS();
	String BrokerageVal = "10";
	String Status1 = "Draft";
	String Broker1 = "Alwen Hough Johnson Ltd - TBC";
	String Bline1 = "Property (D&F)";
	String Underline1 = "Abhi, Standard";
	String InceptionDate1 = "01/09/2017";
	String InceptionDate2 = "01/09/2018";
	public static String contractId;
	String QueName = "Test Automation_"+getCurrentDateTimeMS();
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
	public static String sheet3451Path = "";
	public static String sheet3452Path = "";
	public static String sheet3452ScndPath = "";
	public static String sheet3453Path = "";
	public static String sheet3455Path = "";
	public static String sheet3456Path = "";
	public static String sheet3480Path = "";
	public static String sheet3479Path = "";
	public static String sheet3458Path = "";
	public static String sheet3463Path = "";
	public static String sheet3469Path = "";
	public static String sheet3471Path = "";
	public static String sheet3471ScndPath = "";
	public static String sheet3474Path = "";
	public static String sheet3472Path = "";
	public static String sheet3476Path = "";
	public static String sheet3475Path = "";
	public static String sheet34752Path = "";
	public static String sheet3477Path = "";
	public static String sheet34772Path = "";
	public static String sheet3373Path = "";
	public static String sheet3429Path = "";
	public static String sheet3430Path = "";
	public static String sheet3424Path = "";
	public static String sheet3425Path = "";
	public static String sheet3340Path = "";
	public static String sheet3361Path = "";
	public static String sheet3344Path = "";
	public static String sheet3349Path = "";
	public static String sheet3345Path = "";
	public static String sheet3346Path = "";
	public static String sheet3347Path = "";
	public static String sheet3348Path = "";
	public static String sheet3352Path = "";
	public static String sheet3359Path = "";
	public static String sheet3360Path = "";
	public static String sheet3441Path = "";
	public static String sheet3448Path = "";
	public static String sheet3449Path = "";
	public static String sheet3450Path = "";
	public static String sheet3500Path = "";
	public static String sheet3523Path = "";
	public static String sheet3759Path = "";
	public static String sheet3759PathFirst = "";
	public static String sheet3760Path = "";
	public static String sheet3773Path = "";
	public static String sheet3754Path = "";
	public static String sheet3755Path = "";	
	public static String sheet3714Path = "";
	public static String sheet3717Path = "";
	public static String sheet3719Path = "";
	public static String sheet3727Path = "";
	public static String sheet3728Path = "";
	public static String sheet4470Path = "";
	public static String sheet4470SecondPath = "";
	public static String sheet4472Path = "";
	public static String sheet4473Path = "";
	public static String sheet4474Path = "";
	public static String sheet4474SecondPath = "";
	public static String sheet4481Path = "";
	public static String sheet4476Path = "";
	public static String sheet4477Path = "";
	public static String sheet4478Path ="";
	public static String sheet4475Path = "";
	public static String sheet5308Path = "";
	public static String SheetPath5282 ="";
	public static String Sheet5675Path ="";
	static String Count;
	static int ActualCount;

	//Locators for apply filter on policies
	public static final String PolicyLink = "@xpath=//a[text()='POLICIES']";
	public static final String PolicyReferenceFilterIcon = "@css=thead[role=rowgroup] th:nth-child(1) span";
	public static final String SearchText = "@xpath=//form[@class='k-filter-menu k-popup k-group k-reset k-state-border-up']//input[@placeholder='Search']";
	public static final String SearchTextBDType = "@xpath=//input[@placeholder='Search']";
	public static final String FilterButton = "@css=.k-button.k-primary";
	public static final String ApprovedTab ="@xpath=//a[text()='Approved']";
	//Open Selected policy
	public static final String SelectedPolicy = "@css=tbody[role='rowgroup'] td:nth-child(1)";

	public static final String DraftBtn = "@buttonText=Draft";

	// Submit Borderaux
	public static final String BORDEREAUXLink = "@xpath=.//*[@ng-if='IsBinder && IsBordereauTabDisplay']";
	public static final String Processingtab = "@xpath=.//*[@data-ui-sref='app.contract.bordereauxParent.bordereauxTabs({BordereauxTypeEnum: 2})']";
	public static final String SubmitBordereauxDropdown = "@xpath=//*[text()='Submit Bordereaux']//following-sibling::button[1]";
	public static final String SelectOptionRisk = "@css=[data-ng-repeat='w in dataSetList']:nth-child(1)";
	public static final String SelectNewquestionnaire = "@xpath=//*[@ng-model='ProcessingUploadData.FormatId']//preceding-sibling::span[1]";
	public static final String EnterOptionToSelect = "@xpath=//*[@id='formatUL-list']/span/input";
	public static final String PreviousAnsYesRadioBtn ="@css=.form-group.p-r-0.m-t-10>label:nth-child(1)";
	public static final String Calender = "@css=.k-icon.k-i-calendar";
	public static final String CalenderInputBox = "@css=.form-control.calTextHgt.full-width.k-input";
	public static final String DateJan = "@xpath=//a[text()='Jan']";
	public static final String datefield= "@id=Data0";
	public static final String PreviousAnsNoRadioBtn = "@xpath=//div[@class='form-group p-r-0 m-t-10']//descendant::label[@class='radio radio-inline m-r-20'][2]";
	public static final String BlankDetailsMsg = "@xpath=//*[@kendo-grid='grid']//td[text()='No result returned']";
	public static final String BlankDetailsMsgRiskTab = "@xpath=//*[@id='grid']//td[text()='No result returned']";
	public static final String ProcessAgainstSelectedPeriodBtn ="@xpath=//*[@id='content']//button[@ng-click='validateAndCheck()']";
	public static final String ProcessBordereauPage = "@css=.card-body.p-30.m-b-30";
	public static final String ProcessAsAdditionalBtn ="@xpath=//*[@id='content']//button[@ng-click='UpdateBordereauxStatus()']";
	public static final String ProcessAsCorrectionBtn ="@xpath=//*[@id='content']//button[@ng-click='CorrectionBordereaux()']";


	//File upload
	public static final String ClickDragDrop = "@css=.dz-default.dz-message.col-sm-12.col-xs-12.ng-scope";
	public static final String UploadSection ="@xpath=//div[contains(@ng-model,'picFile')]";
	public static final String PicFile = "@model=picFile";
	public static final String ReviewButton ="@buttonText=Review";
	public static final String RefreshAfterUpload= "@xpath=//a[@aria-label='Refresh']/span";
	public static final String Alert = "@css=.sweet-alert.BordereauxCss";
	public static final String AlertOKButton = "@xpath=//*[@id='mainPage']/div[2]/div[2]/p/button[1]";

	//to verify counts on sheets
	public static final String RiskTab ="@css=.k-master-row.ng-scope>td:nth-child(4)";
	public static final String SelectedPageCount ="@css=.k-input";
	public static final String TotalCount = "@css=.k-selectable .ng-scope";
	public static final String ChangePageCountDropDn = "@css=.k-icon.k-i-arrow-60-down";
	public static final String ChangePageCountTo = "@xpath=//li[text()='20']";
	public static final String ActualExpectedRowCount = "@css=.k-selectable .ng-scope";
	public static final String RiskRefrance = "@xpath=//td[@title='RiskReference_Mapped'][1]//a[@ng-click='openRiskReference(dataItem)'][text()='3']";
	public static final String RiskRefranceA2 = "@xpath=//td[@title='RiskReference_Mapped'][1]//a[@ng-click='openRiskReference(dataItem)'][text()='2']";
	public static final String RiskRefranceA1 = "@xpath=//td[@title='RiskReference_Mapped'][1]//a[@ng-click='openRiskReference(dataItem)'][text()='1']";
	
	public static final String RiskRefrance2 = "@xpath=//td[@title='RiskReference_Mapped'][1]//a[@ng-click='openRiskReference(dataItem)'][text()='2']";
	public static final String Version1 = "@xpath=//tr[1]//td[@title='BreachReference']//following-sibling::td[1][text()='2']";
	public static final String Version2 = "@xpath=//tr[2]//td[@title='BreachReference']//following-sibling::td[1][text()='2']";
	public static final String  RuleConditionExists = "@xpath=//dl/dd[contains(.,'if the rule conditions are met')]";
	public static final String ActualCountPolicyRefrence = "@css=.k-selectable .ng-scope td:nth-child(13)";
	public static final String RiskTabAfterReview ="@xpath=//*[@id='grid']//preceding::td//button[contains(text(),'Review')]//following::td[contains(text(),'Risk')][1]";

	//Delete created BorderEAUX
	public static final String DeleteButton = "@css=.c-red.glyphicon.glyphicon-trash";
	public static final String DeleteYESButton = "@xpath=//button[@ng-click='onYes()']";
	public static final String DeleteCancelButton = "@xpath=//button[@ng-click='onNo()']";
	public static final String PolicyHome = "@css=a[href='#!/app/contractlist']";

	//You can select the sheet for processing this time (the expected sheet text for future processing will remain unchanged)
	public static final String ProcessingTiem = "@css=.k-input.k-readonly";
	public static final String ProcessingTimeSecond = "@css=.k-input";
	public static final String May2017 = "@xpath=//ul[@class='k-list k-reset']//li[text()='May 2017']";
	public static final String June2017 = "@xpath=//ul[@class='k-list k-reset']//li[text()='June 2017']";

	//CANCEL PROCESSING AND DELETE BORDEREAU   //div[@class="btn btn-danger ng-scope"][contains(.,'Resolve Errors')]
	public static final String NegativePremiumResolveErrors = "@xpath=//div[@class=\"btn btn-danger ng-scope\"][contains(.,'Resolve Errors')]";
	public static final String ErrorsAndWarningTab = "@xpath=//*[@id=\"content\"]//a[contains(.,'Errors & Warnings')]";
	public static final String cancelAndDeleteProBtn = "@xpath=//*[@id='content']//button[@ng-click='cancel()']";  
	public static final String ErrorsAndWarnings = "@xpath=//*[@id='content']//a[contains(text(),'Errors & Warnings']"; 
	public static final String ResolveError = "@xpath=//*[@id='content']//div[contains(text(),'Resolve Errors']";
	public static final String NegativeGrossPremium = "@xpath=//*[@id='multiReference_Id']//input[@model ='item.Gross_Premium']";
	
	
	public static final String cancelAndDeleteProBtn1 = "@xpath=//div[@ng-click='cancel(data.BordereauxId)']";
	public static final String ReviewBtn ="@xpath=//button[text()='Review']";
	public static final String ApprvedBtn ="@xpath=//button[text()='Approved']";
	public static final String SuRcdAssmnt ="@xpath=//*[@id='content']//button[@ng-click='submitBordereau()']";
	public static final String FrApprovalbtn ="@xpath=//*[@id='grid']//button[@ng-click='GoToBordereauSummaryScreen(dataItem, false)']";
	public static final String FrApprovalbtn1 ="@xpath=//button[text()='For Approval']";
	public static final String PartialSubmission ="@xpath=//a[2][contains(.,'Partial Submission')]//following::span[contains(.,'Yes')]";
	//Loactors for SubmitBordereauxFIrstSheet
	public static final String BorderEAUXFirst ="@css=[href='#!/app/contract/253fe192-ba5e-4586-b3d2-c13dbf40e802/bordereaux/2']";
	public static final String BorderEAUXLast ="@css=[href='#!/app/contract/7807ee46-ba51-445d-b5fa-69d71dc08856/bordereaux/2']";
	public static final String CalenderLastST ="@css=.k-icon.k-i-calendar";
	public static final String CalenderFirstST ="@css=.k-icon.k-i-calendar";

	//1] Processing for BorderEAUX
	public static final String ReviewError ="@xpath=//*[@id='grid']//button[contains(.,'Review Errors')]";
	public static final String ForAssigmnentButton ="@xpath=//*[@id='grid']//button[contains(.,'For Assignment')]";
	public static final String ErrorScreen ="@css=.f-400.c-red.normalWhiteSpace.ng-binding.ng-scope";
	public static final String ErrorScreen1 ="@xpath=//h2[contains(.,'Transaction Type')]";
	public static final String RefreshAfterUpload1="@xpath=//*[@options='mainGridOptions']//*[@title='Refresh']//span";
	public static final String ContinueProc ="@xpath=.//*[@ng-click='processBordereau()']";
	public static final String ProcessBorderEAuButton ="@xpath=//button[@ng-click='nextStep()']";
	public static final String SheetNameErrorMsg ="@css=[name='form.bordereauxIdentifySheet'] .row dl:nth-child(4) dt";
	//2] Edit Specific Text
	public static final String ToEditSpecificText = "@css=.form-control.ng-pristine.ng-untouched.ng-valid.ng-not-empty";
	public static final String RemainUnchangedRadioButton = "@xpath=//label[@class='radio radio-inline ng-scope']";
	public static final String NoSingelContainProcessingTime = "@css=.k-input.ng-scope";
	public static final String Mar2017 = "@xpath=//div[@class='k-list-scroller']//li[1]";

	//1] Sheet Processing
	public static final String SelectDropDown = "@xpath=//*[@ng-model='form.newSheetIndex']//preceding-sibling::span[1]";
	public static final String SelectOptionJune = "@xpath=//li[contains(text(),'May 2017')]";

	//1] To cancel Bordereau process
	public static final String CancelAndDeleteBordereaux ="@xpath=//button[@ng-click='cancel()']";
	public static final String CancelAndDeleteBordereauxSp2 ="@xpath=//*[@id='content']//div[@ng-click='cancel(data.BordereauxId)']";
	public static final String pausebtn ="@xpath=.//*[@ng-click='pause()']";
	public static final String YesCancelProcessing ="@xpath=//p[@class='ng-scope']//button[@ng-click='onYes()']";
	public static final String ContinueProcessingBodrBtn ="@xpath=//*[@id='content']//button[@ng-click='UpdateSequence()']";
	public static final String ContinueProcessing= "@xpath = //*[@id='multiReference_Id']//button[@type='submit']";
	//Locators:-TC-3245
	public static final String continuebtx= "@xpath=//button[@ng-click='save()']|//button[@ng-click='continue()']";
	public static final String continuebtx2= "@xpath=//*[@id='RID_Id']//button[@type='submit']";
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
	public static final String RecordsNotImported ="@xpath=//table/tbody/tr/td[3]/label[contains(.,'Records will not be imported')]";
	public static final String ContractIndentifiedText ="@xpath=//table/tbody/tr/td[3]/label[contains(.,'Contract identified - records will be imported')]";
	public static final String yearAccount ="@css=#Data0";
	public static final String yearAccount1 ="@css=#Data1";
	public static final String inceptionDate ="@xpath=//*[@ng-model='item.RiskInceptionDate']";

	public static final String SuccessNotificationMsgAfterUpload="@xpath=//*[@id='mainPage']/descendant::div[@class='sweet-alert BordereauxCss']/h2[1][contains(text(),'Good job!')]";
	public static final String FailureNotificationMsgAfterUpload="@xpath=//*[@id='mainPage']/descendant::div[@class='sweet-alert BordereauxCss']/h2[1][contains(text(),'Errors identified!')]";

	public static final String OkButtonOnSuccessNotification="@xpath=//*[@id='mainPage']/descendant::div[@ng-show='BordereauSuccess']/descendant::button[contains(text(),'Ok')]";
	public static final String CancelButtonOnFailureNotification="@xpath=//*[@id='mainPage']/descendant::div[@ng-show='BordereauError || BordereauLargeUpload']/descendant::button[contains(text(),'Cancel')]";

	public static final String ErrorScreenMsg ="@xpath=//*[@ng-hide='checkProgressVisible()']//h2";
	public static final String ContractStatusMsg ="@css=.col-sm-7 .font-bold.lead";
	//public static final String YesCancelProcessing ="@css=.confirm.btn.btn-lg.btn-danger.waves-effect.waves-light[ng-click='onYes()']";

	public static final String continuebtn= "@xpath=//*[@ng-focus='Focused = true']";
	public static final String ForApprovalBtn = "@xpath=//button[contains(.,'For Approval')]";
	public static final String ForAssignmentBtn = "@xpath=//button[contains(.,'For Assignment')]";

	// Locators for checkRecordsAndDeleteRecord
	public static final String filterIconRecords = "@css=[data-field='StatusString'] span";
	public static final String filterIconRecordsBodrTyp = "@xpath=//th[@data-field='BordereauxType']//span[@class='k-icon k-i-filter']";
	public static final String filterIconRecordsMonth = "@xpath=//th[@data-field='MonthString']//span[@class='k-icon k-i-filter']";

	public static final String BodrTypFilterIcon ="@xpath=.//*[@data-title='Bordereau Type']/a[1]";
	public static final String RiskChckBx ="@xpath=//input[@name='BordereauxType'][@value='Risk']";
	public static final String ClaimChckBx ="@xpath=//input[@name='BordereauxType'][@value='Claim']";
	public static final String PremiumChckBx ="@xpath=//input[@name='BordereauxType'][@value='Premium']";
	public static final String ReviewErrorCheckBox = "@css=input[value='Review Errors']";
	public static final String ReviewCheckBox = "@css=input[value='Review']";
	public static final String UploadCheckBox = "@css=input[value='Uploaded']";
	public static final String ApproveCheckBox = "@css=input[value='Approved']";
	public static final String FilterButtonRecords = "@css=.k-button.k-primary";
	public static final String BodrFilterBtn ="@xpath=//input[@value='Risk']//following::button[@type='submit']";
	public static final String TotalRowCountAfterFiltered = "@css=tbody[role='rowgroup'] tr";
	public static final String CancelBtn ="@xpath=//*[@class='sweet-alert ']//p//button[contains(.,'Cancel')][1]";
	public static final String UnApprvBdrBtn ="@xpath=.//*[@ng-click='approveUnApproveBordereau(bordereauxData.Id)']";

	//Locators for Due date filter
	public static final String DuteDatefilterIcon = "@css=[data-title='Due Date'] .k-icon.k-i-filter";
	public static final String DuteDatefilterIconInputBox = "@css=.k-textbox.k-space-right>input";
	public static final String DueDateFiterBtn = "@css=.k-button.k-primary";
	public static final String DueDateCheckbx = "@xpath=//input[@name='DueDate']";

	//Skip All Error button click
	public static final String SkippAllErroBtn = "@xpath=//*[@id='multiReference_Id']//button[@ng-click='skipAllErrros()']";
	public static final String SubProcessRcdBtn = "@xpath=//*[@id='content']//button[@ng-click='submitBordereau()']";
	public static final String SubAssesmntBtn = "@xpath=//*[@id='grid']//button[@ng-click='GoToSRAssignment(dataItem, false)']";
	public static final String ApproveBordBtn = "@xpath=//*[@id='content']//button[@ng-click='approveUnApproveBordereau(bordereauxData.Id)']";
	public static final String SkippAllErroBtn1 = "@xpath=//*[@id='content']/div/div/div[1]/div[5]/div[2]/div[4]/button";
	public static final String Cancelbtn1 ="@xpath=//*[@ng-click='cancel()']";
	
	//Finantial calculations
	public static final String DATAClaimTab="@xpath=//*[text()='Claim']";
	public static final String DATAPremiumTab="@xpath=//*[text()='Premium']";
	public static final String CorrectedVal = "@id=Data0";
	public static final String DATAlink ="@xpath=//*[@ng-click='clickedContractData()']";
	public static final String DATARiskTab="@xpath=//*[text()='Risk']";
	public static final String RowNumber="@xpath=//*[@data-field='RowNumber']";
	public static final String RowNumberAscIcon ="@xpath=//*[@data-field='RowNumber']//*[@class='k-icon k-i-sort-asc-sm']";
	public static final String GrossPremiumIncludingTax="@xpath=//*[@data-field='Gross_Premium_including_Tax']";
	public static final String GrossPremium="@xpath=//*[@data-field='Gross_Premium']";
	public static final String CoverholderCommission="@xpath=//*[@data-field='Coverholder_Commission']";
	public static final String CoverholderCommissionPercent="@xpath=//*[@data-field='Coverholder_Commission_Percent']";
	public static final String NetPremium="@xpath=//*[@data-field='Net_Premium']";
	public static final String LondonBrokerage="@xpath=//*[@data-field='London_Brokerage']";
	public static final String LondonBrokeragePercent="@xpath=//*[@data-field='London_Brokerage_Percent']";
	public static final String FinalNetPremium="@xpath=//*[@data-field='Final_Net_Premium']";
	public static final String DataLinkNoResult="@xpath=//*[text()='No result returned']";
	public static final String GrossPremiumTaxFirstRow="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[1]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='105.00']";
	public static final String GrossPremiumTaxSecondRow="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[2]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='100.00']";
	public static final String GrossPremiumTaxThirdRow="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[3]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='0.00']";
	public static final String GrossPremiumTaxFourthRow="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[4]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='0.00']";
	public static final String GrossPremiumFirstRow="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][text()='100.00']";
	public static final String GrossPremiumSecondRow="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][text()='100.00']";
	public static final String CoverholderCommissionFirstRow="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[1]//td[31][text()='124.50']";
	public static final String CoverholderCommissionThirdRow="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[3]//td[31][text()='124.50']";
	public static final String CoverholderCommissionFourthRow="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[4]//td[31][text()='0.00']";
	public static final String CoverholderCommissionFifthRow="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[5]//td[31][text()='0.00']";
	public static final String CoverholderCommissionPercentFirstRow="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='124.50']";
	public static final String CoverholderCommissionPercentThirdRow="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='0.00 %']";
	public static final String CoverholderCommissionPercentFourthRow="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='0.00 %']";
	public static final String CoverholderCommissionPercentFifthRow="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[5]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='0.00 %']";
	public static final String NetPreiumSixthRow="@xpath=//*[@data-field='Net_Premium']//following::tr[6]//td[contains(@ng-click,'Net_Premium')][text()='75.50']";
	public static final String NetPreiumSeventhRow="@xpath=//*[@data-field='Net_Premium']//following::tr[7]//td[contains(@ng-click,'Net_Premium')][text()='100.00']";
	public static final String NetPreiumEighthRow="@xpath=//*[@data-field='Net_Premium']//following::tr[8]//td[contains(@ng-click,'Net_Premium')][text()='0.00']";
	public static final String LondonBrokerageLastRow="@xpath=//*[@data-field='London_Brokerage']//following::tr[10]//td[contains(@ng-click,'London_Brokerage')][text()='0.00']";
	public static final String LondonBrokerageSecondlastRow="@xpath=//*[@data-field='London_Brokerage']//following::tr[9]//td[contains(@ng-click,'London_Brokerage')][text()='5.00']";
	public static final String LondonBrokerageThirdLastRow="@xpath=//*[@data-field='London_Brokerage']//following::tr[8]//td[contains(@ng-click,'London_Brokerage')][text()='20.00']";
	public static final String BrokeragePercentLastRow="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[10]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='10.00 %']";
	public static final String BrokeragePercentSecondLastRow="@xpath=//*[@data-field='London_Brokerage']//following::tr[9]//td[contains(@ng-click,'London_Brokerage')][text()='5.00 %']";
	public static final String BrokeragePercentThirdLastRow="@xpath=//*[@data-field='London_Brokerage']//following::tr[8]//td[contains(@ng-click,'London_Brokerage')][text()='10.00 %']";
	public static final String FinalNetPremiumLastRow="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[10]//td[contains(@ng-click,'Final_Net_Premium')][text()='-24.50']";
	public static final String FinalNetPremiumSecondLastRow="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[9]//td[contains(@ng-click,'Final_Net_Premium')][text()='-29.50']";
	public static final String FinalNetPremiumThirdLastRow="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[8]//td[contains(@ng-click,'Final_Net_Premium')][text()='-20.00']";

	public static final String TaxHeader = "@xpath=//th[@data-field='Tax_1']";
	public static final String TotalTaxRecords ="@xpath=//*[@role='rowgroup']//tr[7]//td[48]";
	public static final String TaxFirstRow = "@xpath=//*[@data-field='Tax_Total']//following::tr[8]//td[contains(@ng-click,'Tax_Total')][text()='0.00']";
	public static final String TaxSecondRow = "@xpath=//*[@data-field='Tax_Total']//following::tr[9]//td[contains(@ng-click,'Tax_Total')][text()='5.00']";
	public static final String TaxThirdRow = "@xpath=//*[@data-field='Tax_Total']//following::tr[10]//td[contains(@ng-click,'Tax_Total')][text()='5.00']";
	public static final String TaxPercentFirstRow = "@xpath=//*[@data-field='Tax_Total_Percent']//following::tr[8]//td[contains(@ng-click,'Tax_Total_Percent')][text()='5.00 %']";
	public static final String TaxPercentSecondRow = "@xpath=//*[@data-field='Tax_Total_Percent']//following::tr[9]//td[contains(@ng-click,'Tax_Total_Percent')][text()='5.00 %']";
	public static final String TaxPercentThirdRow = "@xpath=//*[@data-field='Tax_Total_Percent']//following::tr[10]//td[contains(@ng-click,'Tax_Total_Percent')][text()='5.00 %']";
	
	//Reference,Cell,Original Value,Enriched ValueText 
	public static final String RiskReferenceTxt = "@xpath=//*[@id=\"content\"]/div/div/div[1]/div[3]/table/thead/tr/th[1]";
	public static final String CellTxt = "@xpath=//*[@id=\"content\"]/div/div/div[1]/div[3]/table/thead/tr/th[2]";
	public static final String ORIGINALVALUETxt = "@xpath=//*[@id=\"content\"]/div/div/div[1]/div[3]/table/thead/tr/th[3]";
	public static final String Enrichedvaluetxt = "@xpath=//*[@id=\"Data0\"]";
	
	//TC 3430 Sprint 3
	public static final String EnrichedValueTxt = "@id=Data0";
	public static final String CanBtn = "@xpath=//*[@id='content']//button[@ng-click='cancel()']";
	public static final String RiskOrderFirstRow100 = "@xpath=//*[@id=\"grid\"]/div[3]/table/tbody/tr[1]/td[25]";
	public static final String RiskOrderSecondRow50 = "@xpath=//*[@id=\"grid\"]/div[3]/table/tbody/tr[2]/td[25]";
	public static final String RiskOrderThirdRow80 = "@xpath=//*[@id=\"grid\"]/div[3]/table/tbody/tr[3]/td[25]";

	public static final String GrossPremFirstRow = "@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][2]";
	public static final String GrossPremSecondRow = "@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][2]";
	public static final String GrossPremThirdRow = "@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium')][2]";

	public static final String CCFirstRow = "@xpath=//*[@data-field='Coverholder_Commission']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission')][1]";
	public static final String CCSecondRow = "@xpath=//*[@data-field='Coverholder_Commission']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission')][1]";
	public static final String CCThirdRow = "@xpath=//*[@data-field='Coverholder_Commission']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission')][1]";

	public static final String NPFirstRow = "@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][1]";
	public static final String NPSecondRow = "@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][1]";
	public static final String NPThirdRow = "@xpath=//*[@data-field='Net_Premium']//following::tr[3]//td[contains(@ng-click,'Net_Premium')][1]";

	public static final String FNPFirstRow = "@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][2][text()='3,627.80']";
	public static final String FNPSecondRow = "@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][2][text()='45,160.50']";
	public static final String FNPThirdRow = "@xpath=//*[@data-field='Net_Premium']//following::tr[3]//td[contains(@ng-click,'Net_Premium')][2][text()='2,121.63']";

	//Loactors TC_3448
	public static final String CancelStatusAndLeaveUploadingStatusButton = "@xpath=//div[@ng-click='UpdateStatusToPreSequenceRule()']";
	public static final String UploadedButton = "@xpath=//button[text()='Uploaded']";
	public static final String AnotherBordereauSamePeriodNotYetApprovedPage = "@css=h2.font-bold.lead";
	public static final String UploadedDeleteButton = "@xpath=//button[text()='Uploaded']//following-sibling::span[1]/i";
	public static final String UploadedDeleteYESButton = "@xpath=//button[@ng-click='onYes()']";
	public static final String cancelAndDeleteProBtnYes = "@xpath=//button[@ng-click='onYes()']";
	public static final String CancelAndDeleteBtn ="@xpath=//*[@ng-click='cancel()']";

	//public static final String MappingTotalCount="@xpath=//*[@ng-bind='dataItem.MatchCount']";

	//==================================================
	public static final String discardRecords="@xpath=//*[@ng-click='DiscardRecords(item)']";
	public static final String inceptionDate1 ="@xpath=//*[text()='D2']/..//*[@ng-model='item.RiskInceptionDate']";
	public static final String inceptionDate2 ="@xpath=//*[text()='D3']/..//*[@ng-model='item.RiskInceptionDate']";
	//public static final String tidevalueUSD ="@xpath=//*[@id='Data0_listbox']/li[3]";
	public static final String tidevalueUSD ="@xpath=//*[@id='Data0-list']//li[text()='USD']";

	public static final String Approvedbtn="@xpath=//*[@ ng-click='GoToBordereauSummaryScreen(dataItem, false)'][text()='Approved']";
	public static final String ApprovedbtnSncdRw="@xpath=//tr[2]//*[@ ng-click='GoToBordereauSummaryScreen(dataItem, false)'][text()='Approved']";
	public static final String ApprovedbtnThirdRw="@xpath=//tr[3]//*[@ ng-click='GoToBordereauSummaryScreen(dataItem, false)'][text()='Approved']";

	public static final String PremiumCurrency="@xpath=//*[@data-field='Premium_Currency']";
	public static final String RiskCurrency="@xpath=//*[@data-field='Risk_Currency']";
	public static final String PremiumCurrencyfirstRow="@xpath=//*[@role='rowgroup']//tr[1]//td[32]";
	public static final String PremiumCurrencysecondRow="@xpath=//*[@role='rowgroup']//tr[2]//td[32]";
	public static final String RiskCurrencyfirstRow="@xpath=//*[@role='rowgroup']//tr[1]//td[33]";
	public static final String RiskCurrencySecondRow="@xpath=//*[@role='rowgroup']//tr[2]//td[33]";
	//public static final String BooleanName="@xpath=//*[text()='Boolean'][1]";
	public static final String MappingTotalCount="@xpath=//*[@ng-bind='dataItem.MatchCount']";
	public static final String SignedBtn = "@buttonText=Signed";

	//Loactors TC_3717
	public static final String EnrichedTxt ="@model=item.EnrichData";
	public static final String ContinueBtn ="@xpath=//button[contains(.,'Continue')]";
	public static final String NewOrRenewal ="@xpath=//*[@id='DiscardRisk_listbox']//li[text()='New or Renewal']";
	public static final String PolicyNum ="@xpath=//*[@id='DiscardRisk_listbox'][@aria-hidden='false']//li[text()='Policy Number']";
	public static final String NoStories ="@xpath=//*[@id='DiscardRisk_listbox']//li[text()='No. Stories']";
	public static final String RiskTxt ="@xpath=//*[@id='DiscardRisk_taglist']/following-sibling::input";
	public static final String ClearValues ="@xpath=//span[@title='clear']";

	//
	public static final String AddContractForPolicy="@xpath=//*[@ng-if='PermissionContract.Add']"; 
	public static final String ContractStatusMsg1 ="@xpath=//h2[text()='Contract Status not Signed']";

	public static final String VerifyErrorpage ="@xpath=//h2[text()='Sprinklers (Y/N) reference data translation required']";
	public static final String SkipAllErrorsBtn="@xpath=//*[@ng-click='SkipAllErrros()']";
	public static final String CancelProcessingButton="@xpath=//*[@ng-click='cancel(data.BordereauxId)']";
	public static final String PauseButton="@xpath=//*[@ng-click='pause()']";
	public static final String ViewDiscardedRecordsIcon="@xpath=//label[text()='View Discarded Records']/../label[2]";
	public static final String BlankRecordsMsg = "@xpath=//*[@kendo-grid='form.grid']//td[text()='No result returned']";

	public static final String BooleanName="@xpath=//*[@ng-bind='dataItem.Name']";
	public static final String ReferenceDataFilterIcon ="@xpath=//*[@data-field='Name']//span";


	public static final String ContinueProcessingbtn ="@xpath=//*[@ng-click='ContinueProcessing()']";
	public static final String columnTab ="@xpath=//button[contains(.,'Column')]";	
	public static final String Version ="@xpath=//*[@data-field='FormatVersion']//following::tr[1]//td[8]";
	public static final String EditQuestionNairebtn ="@xpath=//*[@ng-click='EditQuestionnaire()']";
	public static final String SaveAndReprocessBtn ="@xpath=//*[@ng-if='saveAndReprocess']";
	public static final String ContinuebtnOnErrorScreen ="@xpath=//*[@ng-click='processBordereau()']";
	public static final String DownloadBorderEAU ="@xpath=//*[@ng-click='DownloadFile()']";
	public static final String TideField= "@css=.k-dropdown-wrap";
	public static final String ContentsValue ="@xpath=//li[contains(.,'Contents Value')]";
	public static final String ForApprovalButton= "@xpath=//button[contains(.,'For Approval')]";

	public static final String Okbtn="@xpath=//*[@ng-click='cancel()']";
	public static final String RuleNameField="@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[6]";
	public static final String RuleNameRiskExpiryDate="@xpath=//*[@uib-popover='Risk Expiry Date defaulted from the Risk Inception Date plus 1 year']";
	public static final String OriginalValue="@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[3]";
	public static final String ChangedValue="@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[4]";

	public static final String Roletab="@xpath=//a[text()='Roles']";

	public static final String MainEditdot= "@xpath=//ul[@class='actions ng-scope']//a[@class='dropdown-toggle']";
	public static final String CreateContract= "@xpath=//*[@ng-if='PermissionContract.Add']";
	public static final String TransformationErrorScreen= "@xpath=//*[text()='Bordereau Transformation']";
	public static final String YesBtn = "@xpath=//*[@value='true']/parent::label";
	public static final String MultiContractBtn = "@xpath=//*[@ng-if='!Loading1 && contractList.length']//button";
	public static final String Contract2017 = "@xpath=//*[@ng-click='GetSelectedContract(w)']/a[contains(.,'2017')]";

	public static final String SectionIdDropDwn1Risk1 = "@xpath=//tr[1]//select[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String SectionIdDropDwn1Risk2= "@xpath=//tr[2]//select[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String SectionIdDropDwn1Risk3 = "@xpath=//tr[3]//select[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String SectionIdDropDwn1Risk4 = "@xpath=//tr[4]//select[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String SectionIdDropDwn1Risk5 = "@xpath=//tr[5]//select[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String SectionIdDropDwnOption3 = "@xpath=//ul[@aria-hidden='false']//li[contains(.,'D8')]";
	public static final String BordereauAssignmentSectionDropDwnOptionRiskCode = "@xpath=//li[text()='Data in the bordereau will specify the Risk Code']";
	
	 public static final String SectionAssignmentRuleScreenFor2017 ="@xpath=//h2[text()='Section Assignment Rule - 2017 Year of Account Contract (01/01/2017 - 31/12/2017)']";
	  public static final String  SectionIdDropDwn1="@xpath=//tr[1]//select[@ng-model='data.SectionId']//preceding-sibling::span";
	  public static final String  SectionIdDropDwn2="@xpath=//tr[2]//select[@ng-model='data.SectionId']//preceding-sibling::span";
	  public static final String  SectionIdDropDwn3="@xpath=//tr[3]//select[@ng-model='data.SectionId']//preceding-sibling::span";
	  public static final String  SectionIdDropDwn4="@xpath=//tr[4]//select[@ng-model='data.SectionId']//preceding-sibling::span";
	  public static final String  SectionIdDropDwn5="@xpath=//tr[5]//select[@ng-model='data.SectionId']//preceding-sibling::span";
	  public static final String SectionIdDropDwnOption1 = "@xpath=//ul[@aria-hidden='false']//li[contains(.,'Section 1 (Primary Risk Code: 1T)')]";
	  public static final String SectionIdDropDwnOption2 = "@xpath=//ul[@aria-hidden='false']//li[contains(.,'Section 2 (Primary Risk Code: 1T)')]";
	//-------------------------------------------------------- BordereauProcessIdentifySheetTests ---------------------------------------------------------------------//

	public void allSheets_3145() throws Exception{
		//login.tideLogin();
		String OnlySpPoliCyNum = "824234DU";
		String subSheet = "SP - All Sheet(s) (Automation Schema)";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_AllSheet_3145.xlsx\",\"UniqueFileName\":\"S66159920171024.xlsx\",\"BordereauFormatId\":\"93f99891-5ddb-4afe-b363-fce57e73eea3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S66159920171024.xlsx\",\"Filesize\":25257,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		//loginPage.tideLogin();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			allSheetsPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_AllSheet_3145.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(allSheetsPath);
		File excelFile = new File(allSheetsPath);
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		//UploadFile(allSheets);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			VerificationCounts(20);
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}else{
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not displayed.", "FAIL");				
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}

	public void FirstSheet_3149() throws Exception{
		String OnlySpPoliCyNum = "154895JO";
		String subSheet = "SP - First Sheet (Automation Schema)";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_FirstSheet_3149.xlsx\",\"UniqueFileName\":\"S90677320171027.xlsx\",\"BordereauFormatId\":\"4ec20038-7ea9-4f10-845e-dac6477f02f7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S90677320171027.xlsx\",\"Filesize\":25236,\"Path\":null,\"size\":25236,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		//FilterPolicy();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_FirstSheet_3149.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//StringSelection FirstSheet = new StringSelection(firstSheetPath);
		//UploadFile(FirstSheet);
		File excelFile = new File(firstSheetPath);
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);

		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			VerificationCounts(5);
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}else{
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}

	public void LastSheet_3150() throws Exception{
		String OnlySpPoliCyNum = "288441II";
		String subSheet = "SP - Last Sheet (Automation Schema)";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_LastSheet_3150.xlsx\",\"UniqueFileName\":\"S93194520171027.xlsx\",\"BordereauFormatId\":\"ae4b0a81-ee4b-4d94-ae08-c48e8f15ffac\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S93194520171027.xlsx\",\"Filesize\":25236,\"Path\":null,\"size\":25236,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		//FilterPolicyLast();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			lastSheetPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_LastSheet_3150.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection LastSheet = new StringSelection(lastSheetPath);
		//UploadFile(LastSheet);
		File excelFile = new File(lastSheetPath);
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);

		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed.", "PASS");
			sleep(2000);
			VerificationCounts(5);
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}else{
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}

	public void onlySheet_3160() throws Exception{
		String OnlySpPoliCyNum = "529898HX";
		String subSheet = "SP - The only sheet that contains specific text (Automation Schema)";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3160.xlsx\",\"UniqueFileName\":\"S27034820171027.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S27034820171027.xlsx\",\"Filesize\":25233,\"Path\":null,\"size\":25233,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		//applyFilterSheetContainsSpecificText();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3160Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3160.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection OnlySheet = new StringSelection(sheet3160Path);
		//UploadFile(OnlySheet);
		File excelFile = new File(sheet3160Path);
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);

		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			VerificationCounts(5);
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}else{
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not displayed.", "FAIL");				
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}

	public void sheetIdentification_3161() throws Exception{
		String OnlySpPoliCyNum = "529898HX";
		String subSheet = "SP - The only sheet that contains specific text (Automation Schema)";
		String EditingText = "May 2017";
		String ValMsg = "This format expects to find a single sheet containing ‘June’. This sheet contains no sheets that contain this text.";
		String ExpectedSHNameError = "This format expects to find a single sheet containing ‘June’. This sheet contains no sheets that contain this text.";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_OnlySheetSpecificText_3161.xlsx\",\"UniqueFileName\":\"S47932020171027.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S47932020171027.xlsx\",\"Filesize\":25251,\"Path\":null,\"size\":25251,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3161Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_OnlySheetSpecificText_3161.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection IdentificationSheet = new StringSelection(sheet3161Path);
		//UploadFile(IdentificationSheet);

		File excelFile = new File(sheet3161Path);
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true)
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
			if(isVisible(ErrorScreen)== true){
				bordereauxProcessing(ValMsg, ExpectedSHNameError);
				EditSpecificText(EditingText);
				refreshUploadedFile();
				if(isVisible(ReviewBtn)==true){
					VerificationCounts(5);
					deleteBorderEAUX();
				}else{
					Report.LogInfo("ReviewStatusCheck", "Review status not displayed.", "FAIL");
					deleteBorderEAUX();
				}
				//VerifyNotificationPopupAfterUpload();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}else
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status didn't change Review Error", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}

	public void processingSelectingSheetUnchanged_3165() throws Exception{
		String OnlySpPoliCyNum = "529898HX";
		String subSheet = "SP - The only sheet that contains specific text (Automation Schema)";
		String ExpValMsg = "This format expects to find a single sheet containing ‘June’. This sheet contains no sheets that contain this text.";
		String SheetYear = "May 2017";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_SheetSpecificTextUnchanged_3165.xlsx\",\"UniqueFileName\":\"S19004820171027.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S19004820171027.xlsx\",\"Filesize\":25251,\"Path\":null,\"size\":25251,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3165Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_SheetSpecificTextUnchanged_3165.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//StringSelection IdentificationSheet = new StringSelection(sheet3165Path);
		//UploadFile(IdentificationSheet);

		File excelFile = new File(sheet3165Path);
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				bordereauxProcessRemainUnchanged(ExpValMsg, SheetYear);
				refreshUploadedFile();
				if(isVisible(ReviewBtn)==true){
					VerificationCounts(5);
					deleteBorderEAUX();
				}else{
					Report.LogInfo("ReviewStatusCheck", "Review status not displayed.", "FAIL");
					deleteBorderEAUX();
				}
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
			//VerifyNotificationPopupAfterUpload();
		}
	}

	public void cancelBordereauProcess_3166() throws Exception{
		String OnlySpPoliCyNum = "529898HX";
		String subSheet = "SP - The only sheet that contains specific text (Automation Schema)";
		String ExpvalMsg = "This format expects to find a single sheet containing ‘June’. This sheet contains no sheets that contain this text.";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3166.xlsx\",\"UniqueFileName\":\"S35472620171027.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S35472620171027.xlsx\",\"Filesize\":25251,\"Path\":null,\"size\":25251,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3166Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3166.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//StringSelection IdentificationSheet = new StringSelection(sheet3166Path);
		//UploadFile(IdentificationSheet);
		File excelFile = new File(sheet3166Path);
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);

		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				cancelAndDeleteBoredereauByCatchingValidation(ExpvalMsg);
				//VerifyNotificationPopupAfterUpload();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}else
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}

	public void multiplesheetProcessing_3186() throws Exception{
		String OnlySpPoliCyNum = "529898HX";
		//String FormtFiltr = "Format Filter";
		String subSheet = "SP - The only sheet that contains specific text";
		String EditingTextMultiSheet ="June";
		String Valmsg = "This format expects to find a single sheet containing ‘May’. This sheet contains two or more sheets that contain this text.";
		String ExpectedSHNameError = "This format expects to find a single sheet containing ‘June’. This sheet contains no sheets that contain this text.";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(subSheet);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		if(isVisible(BQPage.sheetsContainTxt)==true){
			waitForElementToAppear(BQPage.sheetsContainTxt,2);
			verifyMustExists(BQPage.sheetsContainTxt,"Questionnaire Name Textbox");
			sendKeys(BQPage.sheetsContainTxt,"May");
		}
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		//System.out.println(BQPage.FormatId);
		applyFilterPolicy(policy.PolicyNumber);
		//applyFilterPolicy("202576ZN");
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3186Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_MultipleSheets_3186.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//StringSelection IdentificationSheet = new StringSelection(sheet3186Path);
		//UploadFile(IdentificationSheet);
		File excelFile = new File(sheet3186Path);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_MultipleSheets_3186.xlsx\",\"UniqueFileName\":\"S84674220171027.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S84674220171027.xlsx\",\"Filesize\":25227,\"Path\":null,\"size\":25227,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);

		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				bordereauxProcessing(Valmsg, ExpectedSHNameError);
				EditSpecificText(EditingTextMultiSheet);
				refreshUploadedFile();
				if(isVisible(ReviewBtn)==true){
					VerificationCounts(5);
					deleteBorderEAUX();
				}else{
					Report.LogInfo("ReviewStatusCheck", "Review status not displayed.", "FAIL");
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}else
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}

	}

	public void multiplesheet_3192() throws Exception{
		String PolicyNumber1="529898HX";
		String BordereauxValue ="SP - The only sheet that contains specific text (Automation Schema)";
		String errorMsg="This format expects to find a single sheet containing ‘May’. This sheet contains two or more sheets that contain this text.";
		String errorsheetmsg="This format expects to find a single sheet containing ‘May’. This sheet contains two or more sheets that contain this text.";
		String BordFilter = "SP - The only sheet that contains specific text";
		String EditYear = "May";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		//Precondition so used TC 3608
		BQPage.editBordereauFormat(BordFilter, EditYear);
		BQPage.FormatId = ReturnFormatID();
		sleep(4000);
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(BordereauxValue);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3192Path = fpath+"\\src\\test\\resources\\testdata\\January_2017_3192.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3192Path);
		//UploadFile(filePath);

		File excelFile = new File(sheet3192Path);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January_2017_3192.xlsx\",\"UniqueFileName\":\"S53918820171129.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S53918820171129.xlsx\",\"Filesize\":25209,\"Path\":null,\"size\":25209,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)== true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				verifyErrormessage(errorMsg);
				selectSheetRadioAndVerifyErrorMessage(errorsheetmsg);
				monthselection();
				verifyandClickProcessBorderEAuButton();
				refreshUploadedFile();
				if(isVisible(ReviewBtn)==true){
					VerificationCounts(5);
					deleteBorderEAUX();
				}else{
					Report.LogInfo("ButtonCheck", "Review button not displayed.", "FAIL");
				}
				//VerifyNotificationPopupAfterUpload();
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
			//VerifyNotificationPopupAfterUpload();
		}
	}

	public void multiplesheetCancelProcessing_3193() throws Exception{
		String BordereauxValue ="SP - The only sheet that contains specific text (Automation Schema)";
		String errorMsg="This format expects to find a single sheet containing ‘May’. This sheet contains two or more sheets that contain this text.";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January_2017_3193.xlsx\",\"UniqueFileName\":\"S28564620171027.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S28564620171027.xlsx\",\"Filesize\":25209,\"Path\":null,\"size\":25209,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(BordereauxValue);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3193Path = fpath+"\\src\\test\\resources\\testdata\\January_2017_3193.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3193Path);
		//UploadFile(filePath);
		File excelFile = new File(sheet3193Path);
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();

		if(checkErrorReviewButton(ReviewError)== true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				verifyErrormessage(errorMsg);
				verifyMustExists(CancelAndDeleteBordereaux,"Cancel And Delete Bordereaux");
				click(CancelAndDeleteBordereaux,"Cancel And Delete Bordereaux");
				sleep(4000);	
				//VerifyNotificationPopupAfterUpload();
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
			//VerifyNotificationPopupAfterUpload();
		}

	}

	/*------- TC-ID:- 3194 ----------------- */
	public void verifyOnlySheetThatEqualsSpecificText_3194() throws Exception{
		String OnlySpPoliCyNum = "666204QF";
		String subSheet = "SP - The only sheet that equals specific text";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

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
		//System.out.println(BQPage.FormatId);
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3194Path = fpath+"\\src\\test\\resources\\testdata\\OnlySheetWithequalText_3194.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(sheet3194Path);
		//UploadFile(allSheets);
		File excelFile = new File(sheet3194Path);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"OnlySheetWithequalText_3194.xlsx\",\"UniqueFileName\":\"S81258820171027.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S81258820171027.xlsx\",\"Filesize\":25229,\"Path\":null,\"size\":25229,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			VerificationCounts(5);
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}else{
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not displayed.", "FAIL");				
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}

	/*------- TC-ID:- 3195 ----------------- */
	public void verifySpecificTextAndObserveReviewBtn_3195() throws Exception{
		String OnlySpPoliCyNum = "666204QF";
		String subSheet = "SP - The only sheet that equals specific text (Automation Schema)";
		String year = "April 2016";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"onlysheetWithequalText2_3195.xlsx\",\"UniqueFileName\":\"S95901520171027.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S95901520171027.xlsx\",\"Filesize\":25215,\"Path\":null,\"size\":25215,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3195Path = fpath+"\\src\\test\\resources\\testdata\\onlysheetWithequalText2_3195.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(sheet3195Path);
		//UploadFile(allSheets);
		File excelFile = new File(sheet3195Path);
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);

		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError) == true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				EditSpecificText(year);
				refreshUploadedFile();
				if(isVisible(ReviewBtn)== true)
				{
					Report.LogInfo("CheckReviewStatus", "Review Status button displayed.", "PASS");
				}else{
					Report.LogInfo("CheckReviewStatus", "Review Status button not displayed.", "FAIL");
				}
				deleteBorderEAUX();
				//VerifyNotificationPopupAfterUpload();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}		
	}

	/*------- TC-ID:- 3196 ----------------- */
	public void verifySpecificTextAndObserveDataRecord_3196() throws Exception{
		String OnlySpPoliCyNum = "666204QF";
		String subSheet = "SP - The only sheet that equals specific text (Automation Schema)";
		String YearSel = "March 2017";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"onlysheetWithequalText2_3196.xlsx\",\"UniqueFileName\":\"S11582220171027.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S11582220171027.xlsx\",\"Filesize\":25211,\"Path\":null,\"size\":25211,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3196Path = fpath+"\\src\\test\\resources\\testdata\\onlysheetWithequalText2_3196.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(sheet3196Path);
		//UploadFile(allSheets);

		File excelFile = new File(sheet3196Path);
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError) == true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				selectSheetForProcessingRadioAndDate(YearSel);
				verifyandClickProcessBorderEAuButton();
				refreshUploadedFile();
				if(isVisible(ReviewBtn)== true)
				{
					VerificationCounts(5);
					Report.LogInfo("CheckReviewStatus", "Review Status button displayed successfully.", "PASS");								
				}else{
					Report.LogInfo("CheckReviewStatus", "Review Status button not displayed.", "FAIL");
				}
				deleteBorderEAUX();
				//VerifyNotificationPopupAfterUpload();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}		
	}

	/*------- TC-ID:- 3197 ----------------- */
	public void cancelProcessing_3197() throws Exception{
		String OnlySpPoliCyNum = "666204QF";
		String subSheet = "SP - The only sheet that equals specific text (Automation Schema)";
		String expectedErrorMsg = "This format expects to find a single sheet which is named ‘April 2016’. This sheet contains no sheets that is named ‘April 2016’.";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_3197.xlsx\",\"UniqueFileName\":\"S48895320171027.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S48895320171027.xlsx\",\"Filesize\":25207,\"Path\":null,\"size\":25207,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3197Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_3197.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File excelFile = new File(sheet3197Path);
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError) == true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				verifyErrormessage(expectedErrorMsg);
				verifyandClickCancelAndDeleteProButton();
				sleep(2000);
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}		
	}

	/*------- TC-ID:- 3198 ----------------- */
	public void containsSpecificTextMatchRecords_3198() throws Exception{
		String OnlySpPoliCyNum = "970768ED";
		String subSheet = "SP - Any sheets that contains specific text";
		String BordFilter = "SP - The only sheet that equals specific text";
		String EditYear = "April 2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		//Precondition so used TC 3610
		BQPage.editBordereauFormat(BordFilter, EditYear);
		BQPage.FormatId = ReturnFormatID();
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
		//System.out.println(BQPage.FormatId);

		sleep(4000);
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3198Path = fpath+"\\src\\test\\resources\\testdata\\AnysheetWithSpecificText_3198.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(sheet3198Path);
		//UploadFile(allSheets);
		File excelFile = new File(sheet3198Path);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"AnysheetWithSpecificText_3198.xlsx\",\"UniqueFileName\":\"S71524720171027.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S71524720171027.xlsx\",\"Filesize\":25200,\"Path\":null,\"size\":25200,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			VerificationCounts(20);
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}

	/*------- TC-ID:- 3199----------------- */
	public void editContainsSpecificText_3199() throws Exception{
		String OnlySpPoliCyNum = "970768ED";
		String subSheet = "SP - Any sheets that contains specific text (Automation Schema)";
		String year = "2016";
		String BordFilter = "SP - Any sheets that contains specific text";
		String EditYear = "2017";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Anysheetwithspecifictext2_3199.xlsx\",\"UniqueFileName\":\"S36770120171027.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S36770120171027.xlsx\",\"Filesize\":25199,\"Path\":null,\"size\":25199,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		//loginPage.tideLogin();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3199Path = fpath+"\\src\\test\\resources\\testdata\\Anysheetwithspecifictext2_3199.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(sheet3199Path);
		//UploadFile(allSheets);
		File excelFile = new File(sheet3199Path);
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError) == true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				EditSpecificText(year);
				refreshUploadedFile();
				if(isVisible(ReviewBtn)== true)
				{
					Report.LogInfo("CheckReviewStatus", "Review Status displayed successfully after editing year.", "PASS");
					VerificationCounts(20);
				}else{
					Report.LogInfo("CheckReviewStatus", "Review Status not displayed after editing year.", "FAIL");
				}
				deleteBorderEAUX();
				//VerifyNotificationPopupAfterUpload();
				//Precondition so used TC 3609
				BQPage.editBordereauFormat(BordFilter, EditYear);
				BQPage.FormatId = ReturnFormatID();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();	
				//Precondition so used TC 3609
				BQPage.editBordereauFormat(BordFilter, EditYear);
				BQPage.FormatId = ReturnFormatID();
			}
		}else{
			Report.LogInfo("ReviewErrorStatus", "There are no review errors after initial upload.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
			//Precondition so used TC 3609
			BQPage.editBordereauFormat(BordFilter, EditYear);
			BQPage.FormatId = ReturnFormatID();
		}	
	}

	/*------- TC-ID:- 3200----------------- */
	public void verifyContainsSpecificTextAndObserveDataRecord_3200() throws Exception{
		String OnlySpPoliCyNum = "970768ED";
		String subSheet = "SP - Any sheets that contains specific text (Automation Schema)";
		String YearSel = "March 2016";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Anysheetwithspecifictext2_3200.xlsx\",\"UniqueFileName\":\"S26578720171027.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S26578720171027.xlsx\",\"Filesize\":25199,\"Path\":null,\"size\":25199,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		///loginPage.tideLogin();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3200Path = fpath+"\\src\\test\\resources\\testdata\\Anysheetwithspecifictext2_3200.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(sheet3200Path);
		//UploadFile(allSheets);
		File excelFile = new File(sheet3200Path);		
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError) == true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				selectSheetForProcessingRadioAndDate(YearSel);
				verifyandClickProcessBorderEAuButton();
				refreshUploadedFile();
				if(isVisible(ReviewBtn)== true)
				{
					VerificationCounts(5);
					Report.LogInfo("CheckReviewBTN", "Review button display successfully.", "PASS");								
				}else{
					Report.LogInfo("CheckReviewBTN", "Review button not display successfully.", "FAIL");
				}
				deleteBorderEAUX();
				//VerifyNotificationPopupAfterUpload();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}		
	}

	/*------- TC-ID:- 3201 ----------------- */
	public void cancelProcessing_3201() throws Exception{
		String OnlySpPoliCyNum = "970768ED";
		String subSheet = "SP - Any sheets that contains specific text (Automation Schema)";
		String expectedErrorMsg = "This format expects to find a one or many sheets containing ‘2017’. This sheet contains no sheets that contain this text.";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Anysheetwithspecifictext2_3201.xlsx\",\"UniqueFileName\":\"S24850620171027.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S24850620171027.xlsx\",\"Filesize\":25199,\"Path\":null,\"size\":25199,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3201Path = fpath+"\\src\\test\\resources\\testdata\\Anysheetwithspecifictext2_3201.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(sheet3201Path);
		//UploadFile(allSheets);
		File excelFile = new File(sheet3201Path);		
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError) == true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				verifyErrormessage(expectedErrorMsg);
				verifyandClickCancelAndDeleteProButton();
				sleep(2000);
				//VerifyNotificationPopupAfterUpload();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}		
	}

	/*------- TC-ID:- 3202 ----------------- */
	public void OnlySpecifiedSheet_3202() throws Exception{
		String OnlySpPoliCyNum = "640522OY";
		String subSheet = "SP - Only Specified Sheet(s) (Automation Schema)";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_3202.xlsx\",\"UniqueFileName\":\"S44389320171027.xlsx\",\"BordereauFormatId\":\"3a5fc977-d55b-4a3d-873e-af7e2c68d269\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S44389320171027.xlsx\",\"Filesize\":25208,\"Path\":null,\"size\":25208,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3202Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_3202.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(sheet3202Path);
		//UploadFile(allSheets);
		File excelFile = new File(sheet3202Path);		
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)== true){
			Report.LogInfo("CheckReviewBTN", "Review button display successfully.", "PASS");								
			VerificationCounts(10);
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}else{
			Report.LogInfo("CheckReviewBTN", "Review button not display successfully.", "FAIL");								
			deleteBorderEAUX();
		}
	}

	/*------- TC-ID:- 3203 ----------------- */
	public void OnlySpecifiedSheetCanNotBeIdentified_3203() throws Exception{
		String OnlySpPoliCyNum = "640522OY";
		String subSheet = "SP - Only Specified Sheet(s) (Automation Schema)";
		String ExpectedErrorMsg = "This format expects to find sheets which are named ‘March 2017,April 2017’. This sheet contains no sheets that are named ‘March 2017,April 2017’.";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_3203.xlsx\",\"UniqueFileName\":\"S72401620171027.xlsx\",\"BordereauFormatId\":\"3a5fc977-d55b-4a3d-873e-af7e2c68d269\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S72401620171027.xlsx\",\"Filesize\":25207,\"Path\":null,\"size\":25207,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3203Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_3203.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(sheet3203Path);
		//UploadFile(allSheets);
		File excelFile = new File(sheet3203Path);		
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError) == true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				verifyErrormessage(ExpectedErrorMsg);
				monthSelection();
				verifyandClickProcessBorderEAuButton();
				refreshUploadedFile();
				if(isVisible(ReviewBtn)== true){
					VerificationCounts(10);
					deleteBorderEAUX();
				}else{
					Report.LogInfo("CheckReviewBTN", "Review button not display successfully.", "FAIL");								
					deleteBorderEAUX();
				}
				//VerifyNotificationPopupAfterUpload();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}else
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}

	/*------- TC-ID:- 3204 ----------------- */
	public void OnlySpecifiedSheetCancelProcessing_3204() throws Exception{
		String OnlySpPoliCyNum = "640522OY";
		String subSheet = "SP - Only Specified Sheet(s) (Automation Schema)";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_3204.xlsx\",\"UniqueFileName\":\"S56180420171027.xlsx\",\"BordereauFormatId\":\"3a5fc977-d55b-4a3d-873e-af7e2c68d269\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S56180420171027.xlsx\",\"Filesize\":25207,\"Path\":null,\"size\":25207,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3204Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_3204.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(sheet3204Path);
		//UploadFile(allSheets);
		File excelFile = new File(sheet3204Path);		
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError) == true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				verifyandClickCancelAndDeleteProButton();
				sleep(2000);
				//VerifyNotificationPopupAfterUpload();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();			
			}
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}

	//==================================================BordereauProcessIdentifyHeaderTests=======================================================

	/*------- TC-ID:- 3207 ----------------- */
	public void verifyNormalAndExpectedHeader_3207() throws Exception{
		String IncDate = "01/01/2017";
		String UnderlineVal = "Childs, Andy";
		String subSheet = "Bordereau Processing (kruthika test schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		policy.addPolicy1(IncDate);
		verifyExists(DraftBtn,"Draft Status Button");
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\"913035BD\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();

		applyFilterPolicy(policy.PolicyNumber);
		//applyFilterPolicy("913035BD");
		openSelectedPolicy();
		SubmitBordereaux(subSheet);	

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3207Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_3207.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3207Path);	
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_3207.xlsx\",\"UniqueFileName\":\"S69435120180024.xlsx\",\"BordereauFormatId\":\"78c4312c-a24f-4223-9538-bc709f5a67b1\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S69435120180024.xlsx\",\"Filesize\":19400,\"Path\":null,\"size\":19400,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);

		refreshUploadedFile();
		if(isVisible(ReviewError) == true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed instead of Review only.", "FAIL");
			deleteBorderEAUX();
		}else if(isVisible(ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			verificationCountsAfterReviewButton(10);
			deleteBorderEAUX();
		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status displayed not displayed and bordereaux processing.", "FAIL");
		}
	}

	/*------- TC-ID:- 3209 ----------------- */
	public void newColumnFieldAdded_3209() throws Exception
	{
		String PolicyNumber1FirstSheet="154895JO";
		String NewColumnFieldDDOption ="Bordereau Processing (kruthika test schema)";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January_2017_New_Column_Field_Added.xlsx\",\"UniqueFileName\":\"S28582120171024.xlsx\",\"BordereauFormatId\":\"78c4312c-a24f-4223-9538-bc709f5a67b1\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S28582120171024.xlsx\",\"Filesize\":19554,\"Path\":null,\"size\":19554,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(NewColumnFieldDDOption);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3209Path = fpath+"\\src\\test\\resources\\testdata\\January_2017_New_Column_Field_Added.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(sheet3209Path);
		//UploadFile(allSheets);
		File excelFile = new File(sheet3209Path);		
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewError) == true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed instead of Review only.", "FAIL");
			deleteBorderEAUX();
		}else if(isVisible(ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			verificationCountsAfterReviewButton(10);
			deleteBorderEAUX();


		}else{

			Report.LogInfo("ValidateReviewStatus", "Review status displayed not displayed and bordereaux processing.", "FAIL");

		}
	}

	/*------- TC-ID:- 3211 ----------------- */
	public void continueProcessing_3211() throws Exception
	{
		//String PolicyNumber1FirstSheet="154895JO";
		String NewColumnFieldDDOption ="Bordereau Processing (kruthika test schema)";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January_2017_Continue Processing.xlsx\",\"UniqueFileName\":\"S84630020171024.xlsx\",\"BordereauFormatId\":\"9ce6c848-4e50-400b-a7f0-39889251f59a\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S84630020171024.xlsx\",\"Filesize\":19345,\"Path\":null,\"size\":19345,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(NewColumnFieldDDOption);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3211Path = fpath+"\\src\\test\\resources\\testdata\\January_2017_Continue Processing.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection ContinueProcessing = new StringSelection(sheet3211Path);
		//UploadFile(ContinueProcessing);
		File excelFile = new File(sheet3211Path);		
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();	

		if(checkErrorReviewButton(ReviewError)==true){
			if(isVisible(OneMoreError)==true){
				verifyMustExists(OneMoreError,"Error Screen");
				sleep(3000);
				verifyMustExists(ContinueProcessingBtn,"Continue Processing Button");
				click(ContinueProcessingBtn,"Continue Processing Button");
				refreshUploadedFile();
				checkReviewButton(ReviewBtn);
				deleteBorderEAUX();
			}else{
				Report.LogInfo("ErroScreenCheck", "Expected error not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateStatus", "Review error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
		//VerifyNotificationPopupAfterUpload();
	}

	/*------- TC-ID:- 3212 ----------------- */
	public void cancelProcessing_3212() throws Exception
	{
		String PolicyNumber1FirstSheet="154895JO";
		String NewColumnFieldDDOption ="Bordereau Processing (kruthika test schema)";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January_2017_Continue Processing.xlsx\",\"UniqueFileName\":\"S50127420171024.xlsx\",\"BordereauFormatId\":\"9ce6c848-4e50-400b-a7f0-39889251f59a\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S50127420171024.xlsx\",\"Filesize\":19345,\"Path\":null,\"size\":19345,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(NewColumnFieldDDOption);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3212Path = fpath+"\\src\\test\\resources\\testdata\\January_2017_Continue Processing.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection CancelProcessing = new StringSelection(sheet3212Path);
		//UploadFile(CancelProcessing);
		File excelFile = new File(sheet3212Path);		
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			if(isVisible(OneMoreError)==true){
				verifyMustExists(OneMoreError,"Error Screen");
				verifyMustExists(CancelProcessingBtn,"Cancel Processing Button");
				click(CancelProcessingBtn,"Cancel Processing Button");
				sleep(2000);
			}else{
				Report.LogInfo("ErroScreenCheck", "Expected error not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateStatus", "Review error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
		//VerifyNotificationPopupAfterUpload();
	}

	/*------- TC-ID:- 3213 ----------------- */
	public void identifyDuplicateColumn_3213() throws Exception
	{
		String PolicyNumber1FirstSheet="154895JO";
		String NewColumnFieldDDOption ="Bordereau Processing (kruthika test schema)";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_Duplicate_Column.xlsx\",\"UniqueFileName\":\"S39854420171024.xlsx\",\"BordereauFormatId\":\"78c4312c-a24f-4223-9538-bc709f5a67b1\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S39854420171024.xlsx\",\"Filesize\":19448,\"Path\":null,\"size\":19448,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(NewColumnFieldDDOption);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3213Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_Duplicate_Column.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection IdentifyDuplicate = new StringSelection(sheet3213Path);
		//UploadFile(IdentifyDuplicate);
		File excelFile = new File(sheet3213Path);		
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			if(isVisible(DuplicateColumn)==true){
				verifyExists(DuplicateColumn,"Error Screen");
				verifyMustExists(CancelProcessingBtn,"Cancel Processing Button");
				click(CancelProcessingBtn,"Cancel Processing Button");
				sleep(3000);
			}else{
				Report.LogInfo("ErroScreenCheck", "Expected error not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateStatus", "Review error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
		//VerifyNotificationPopupAfterUpload();
	}

	/*------- TC-ID:- 3214 ----------------- */
	public void changeColumnPosition_3214() throws Exception
	{
		String PolicyNumber1FirstSheet="154895JO";
		String NewColumnFieldDDOption ="Bordereau Processing (kruthika test schema)";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_Change_Column_Possition.xlsx\",\"UniqueFileName\":\"S73719520171024.xlsx\",\"BordereauFormatId\":\"78c4312c-a24f-4223-9538-bc709f5a67b1\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S73719520171024.xlsx\",\"Filesize\":19382,\"Path\":null,\"size\":19382,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(NewColumnFieldDDOption);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3214Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_Change_Column_Possition.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection IdentifyDuplicate = new StringSelection(sheet3214Path);
		//UploadFile(IdentifyDuplicate);
		File excelFile = new File(sheet3214Path);		
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		checkReviewButton(ReviewBtn);
		deleteBorderEAUX();
		//VerifyNotificationPopupAfterUpload();
	}

	/*	public void columnsMissingFromOneSheet() throws Exception
	{
		String ExpectedErrorMsg="Header columns are not in the correct sequence";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");

		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3340.xlsx\",\"UniqueFileName\":\"S71238720171024.xlsx\",\"BordereauFormatId\":\"93f99891-5ddb-4afe-b363-fce57e73eea3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S71238720171024.xlsx\",\"Filesize\":22396,\"Path\":null,\"size\":22396,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3340Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3340.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3340Path);
		//UploadFile(filePath);
		File excelFile = new File(sheet3340Path);  
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			verifyErrorScreen(ExpectedErrorMsg);			
		}
		else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
		sleep(3000);
	}
	 */
	public void moreThanOneColumnMissing() throws Exception
	{
		String ExpectedErrorMsg="One or more (but not all) of the expected fields by this bordereau questionnaire were not found in this bordereau.";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3361.xlsx\",\"UniqueFileName\":\"S51455620171024.xlsx\",\"BordereauFormatId\":\"93f99891-5ddb-4afe-b363-fce57e73eea3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S51455620171024.xlsx\",\"Filesize\":23312,\"Path\":null,\"size\":23312,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3361Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3361.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3361Path);
		//UploadFile(filePath);
		File excelFile = new File(sheet3361Path);  
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			verifyErrorScreen(ExpectedErrorMsg);				
		}
		else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
		sleep(3000);
	}

	public void removeHeaderRow() throws Exception
	{
		String ExpectedErrorMsg="Header columns are not in the correct sequence";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3344.xlsx\",\"UniqueFileName\":\"S14873720171024.xlsx\",\"BordereauFormatId\":\"93f99891-5ddb-4afe-b363-fce57e73eea3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S14873720171024.xlsx\",\"Filesize\":23336,\"Path\":null,\"size\":23336,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3344Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3344.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3344Path);
		//UploadFile(filePath);
		File excelFile = new File(sheet3344Path);  
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			verifyErrorScreen(ExpectedErrorMsg);

		}
		else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
		sleep(3000);
	}

	public void removeHeaderFromAllSheets() throws Exception
	{
		String ExpectedErrorMsg="Header columns are not in the correct sequence";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3349.xlsx\",\"UniqueFileName\":\"S88753720171024.xlsx\",\"BordereauFormatId\":\"93f99891-5ddb-4afe-b363-fce57e73eea3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S88753720171024.xlsx\",\"Filesize\":22850,\"Path\":null,\"size\":22850,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3349Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3349.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3349Path);
		//UploadFile(filePath);
		File excelFile = new File(sheet3349Path);  
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			verifyErrorScreen(ExpectedErrorMsg);

		}
		else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
		sleep(3000);
	}

	public void wrongHeaderRowNumberOneSheet() throws Exception
	{
		applyFilterPolicy(policy.PolicyNumber);
		//applyFilterPolicy("599783KS");
		openSelectedPolicy();
		SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3345.xlsx\",\"UniqueFileName\":\"S44750820180025.xlsx\",\"BordereauFormatId\":\"93f99891-5ddb-4afe-b363-fce57e73eea3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S44750820180025.xlsx\",\"Filesize\":23309,\"Path\":null,\"size\":23309,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3345Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3345.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3345Path);
		//UploadFile(filePath);
		File excelFile = new File(sheet3345Path);  
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			deleteBorderEAUX();
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail");
			deleteBorderEAUX();
			sleep(3000);
		}
		sleep(3000);
	}

	public void wrongHeaderRowNumberAllSheet() throws Exception
	{
		applyFilterPolicy(policy.PolicyNumber);
		//applyFilterPolicy("599783KS");
		openSelectedPolicy();
		SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3346.xlsx\",\"UniqueFileName\":\"S33280020180025.xlsx\",\"BordereauFormatId\":\"93f99891-5ddb-4afe-b363-fce57e73eea3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S33280020180025.xlsx\",\"Filesize\":23348,\"Path\":null,\"size\":23348,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3346Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3346.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3346Path);
		//UploadFile(filePath);
		File excelFile = new File(sheet3346Path);  
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			deleteBorderEAUX();

		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail");
			deleteBorderEAUX();	
		}
		sleep(3000);
	}

	public void changeColumnPosition() throws Exception
	{
		String ExpectedErrorMsg="Header columns are not in the correct sequence";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3347.xlsx\",\"UniqueFileName\":\"S28470220171024.xlsx\",\"BordereauFormatId\":\"93f99891-5ddb-4afe-b363-fce57e73eea3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S28470220171024.xlsx\",\"Filesize\":23419,\"Path\":null,\"size\":23419,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3347Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3347.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3347Path);
		//UploadFile(filePath);
		File excelFile = new File(sheet3347Path);  
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			verifyErrorScreen(ExpectedErrorMsg);
		}
		else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
		sleep(3000);
	}

	public void duplicateColumn() throws Exception
	{
		String ExpectedErrorMsg="Header columns are not in the correct sequence";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3348.xlsx\",\"UniqueFileName\":\"S90713120171024.xlsx\",\"BordereauFormatId\":\"93f99891-5ddb-4afe-b363-fce57e73eea3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S90713120171024.xlsx\",\"Filesize\":23463,\"Path\":null,\"size\":23463,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3348Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3348.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3348Path);
		//UploadFile(filePath);
		File excelFile = new File(sheet3348Path);  
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			verifyErrorScreen(ExpectedErrorMsg);		
		}
		else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			goBack();
			deleteBorderEAUX();
		}
		sleep(3000);
	}

	public void duplicateColumnAllSheet() throws Exception
	{
		String ExpectedErrorMsg="Duplicate bordereau column names identified";
		applyFilterPolicy(policy.PolicyNumber);
		//applyFilterPolicy("599783KS");
		openSelectedPolicy();
		SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3352.xlsx\",\"UniqueFileName\":\"S74257620180025.xlsx\",\"BordereauFormatId\":\"93f99891-5ddb-4afe-b363-fce57e73eea3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S74257620180025.xlsx\",\"Filesize\":23620,\"Path\":null,\"size\":23620,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3352Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3352.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3352Path);
		//UploadFile(filePath);
		File excelFile = new File(sheet3352Path);  
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			verifyErrorScreen(ExpectedErrorMsg);
		}
		else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
		sleep(3000);
	}

	public void deleteMappedColumn() throws Exception
	{
		String ExpectedErrorMsg="One or more (but not all) of the expected fields by this bordereau questionnaire were not found in this bordereau.";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3359.xlsx\",\"UniqueFileName\":\"S13864120171024.xlsx\",\"BordereauFormatId\":\"93f99891-5ddb-4afe-b363-fce57e73eea3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S13864120171024.xlsx\",\"Filesize\":23312,\"Path\":null,\"size\":23312,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3359Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3359.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3359Path);
		//UploadFile(filePath);
		File excelFile = new File(sheet3359Path);  
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			verifyErrorScreen(ExpectedErrorMsg);

		}
		else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
		sleep(3000);
	}

	public void allHeaderMissing() throws Exception
	{
		String ExpectedErrorMsg="One or more (but not all) of the expected fields by this bordereau questionnaire were not found in this bordereau.";
		applyFilterPolicy("380703UT");
		openSelectedPolicy();
		SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3360.xlsx\",\"UniqueFileName\":\"S79574620171010.xlsx\",\"BordereauFormatId\":\"7b7d342f-a02c-4c18-8336-11b2606b2499\",\"FolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S79574620171010.xlsx\",\"Filesize\":24172,\"Path\":null,\"size\":24172,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3360Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3360.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3360Path);
		//UploadFile(filePath);
		File excelFile = new File(sheet3360Path);  
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			verifyErrorScreen(ExpectedErrorMsg);	
		}
		else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
		sleep(3000);
	}




	//==========================================================BordereauProcessOtherTests======================================================================

	public void addInvalidInceptionDataFiled_3210() throws Exception
	{	
		String IncDate = "01/01/2017";
		String UnderlineVal = "Childs, Andy";
		//String payload = "{\"Bordereaux\":{\"ContractId\":\"7807ee46-ba51-445d-b5fa-69d71dc08856\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"PolicyId\":\"0\",\"OriginalFileName\":\"DatraClensingJanuary_3210.xlsx\",\"UniqueFileName\":\"S23018020171010.xlsx\",\"BordereauFormatId\":\"f3d9edd1-9335-4e0c-bc14-b7dcc6f3771f\",\"IsPolicyRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S23018020171010.xlsx\",\"Filesize\":17660,\"Path\":null,\"size\":17660,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauPolicy\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		//loginPage.tideLogin();
		//applyFilterPolicy("288441II");
		policy.addPolicy1(IncDate);
		verifyExists(DraftBtn,"Draft Status Button");
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		applyFilterPolicy(policy.PolicyNumber);

		openSelectedPolicy();
		SubmitBordereaux("SP - First Sheet (Automation Schema)");

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3210Path = fpath+"\\src\\test\\resources\\testdata\\DatraClensingJanuary_3210.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3210Path);
		//UploadFile(filePath);
		File excelFile = new File(sheet3210Path); 
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"DatraClensingJanuary_3210.xlsx\",\"UniqueFileName\":\"S11601520171027.xlsx\",\"BordereauFormatId\":\"4ec20038-7ea9-4f10-845e-dac6477f02f7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S11601520171027.xlsx\",\"Filesize\":17660,\"Path\":null,\"size\":17660,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)== true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(2000);
			//VerifyNotificationPopupAfterUpload();
			if(isVisible(datefield)==true){
				sleep(2000);
				verifyMustExists(datefield,"Date Field");
				verifyBackground(datefield,"rgba(156, 0, 6, 1)");
				verifyvalidDateAndBackground();
				refreshUploadedFile();
				sleep(2000);
				//verifyMustExists(ReviewBtn,"Review Status Button");
				if(checkErrorReviewButton(ReviewError)== true){
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
					//deleteBorderEAUX();
					if(isVisible(datefield)==true){
						sleep(2000);
						verifyMustExists(datefield,"Date Field");
						verifyBackground(datefield,"rgba(156, 0, 6, 1)");
						verifyvalidDateAndBackground();
						waitForElementToAppear(CanBtn,5);
						verifyMustExists(CanBtn,"Cancel button");
						click(CanBtn, "Cancel button");
						refreshUploadedFile();	
						//refreshUploadedFile();
						sleep(2000); 
						if(isVisible(ReviewBtn)== true){
							Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
							deleteBorderEAUX();
						}
				}
			}else{
				Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
			}
			//VerifyNotificationPopupAfterUpload();
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
		}
	}

	public void invalidTransactionTypeError_3216() throws Exception
	{	
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"TransactionType_3216.xlsx\",\"UniqueFileName\":\"S57270120171027.xlsx\",\"BordereauFormatId\":\"4ec20038-7ea9-4f10-845e-dac6477f02f7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S57270120171027.xlsx\",\"Filesize\":17647,\"Path\":null,\"size\":17647,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereaux("SP - First Sheet (Automation Schema)");

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3216Path = fpath+"\\src\\test\\resources\\testdata\\TransactionType_3216.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//StringSelection filePath = new StringSelection(sheet3216Path);
			//UploadFile(filePath);
			File excelFile = new File(sheet3216Path);  
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				//VerifyNotificationPopupAfterUpload();
				//sleep(2000);
				if(isVisible(ErrorScreen1)== true){
					verifyMustExists(tidevaluedropdown,"Tide Value drop down");
					verifyBackground(tidevaluedropdown,"rgba(156, 0, 6, 1)");
					click(tidevaluedropdown,"Tide Value drop down");
					sleep(2000);
					webDriver.findElement(By.xpath("//li[contains(text(),'New')]")).click();
					sleep(2000);
					verifyBackground(tidevaluedropdown,"rgba(0, 97, 0, 1)");
					verifyMustExists(continuebtx,"Continue button");
					click(continuebtx,"Continue button");
					refreshUploadedFile();
					sleep(2000);
					if(isVisible(ReviewBtn)== true){
						Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
						deleteBorderEAUX();
					}
					//VerifyNotificationPopupAfterUpload();
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
				//VerifyNotificationPopupAfterUpload();
			}
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}
	}

	public void yoaError_3244() throws Exception
	{	
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"YOAError_3244.xlsx\",\"UniqueFileName\":\"S78215620171027.xlsx\",\"BordereauFormatId\":\"93f99891-5ddb-4afe-b363-fce57e73eea3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S78215620171027.xlsx\",\"Filesize\":22256,\"Path\":null,\"size\":22256,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3244Path = fpath+"\\src\\test\\resources\\testdata\\YOAError_3244.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//StringSelection filePath = new StringSelection(sheet3244Path);
			//UploadFile(filePath);
			File excelFile = new File(sheet3244Path);  
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			processBordereauAccounterror();
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}

	}

	public void contractPeriodIdentification_3245() throws Exception
	{
		//String OnlySpPoliCyNum = "288441II";
		String subSheet = "SP - First Sheet (Automation Schema)";
		String RequireDate = "02/01/2017";
		String ExpectedColor = "rgba(0, 97, 0, 1)";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"ContractPeriodOutside_3245.xlsx\",\"UniqueFileName\":\"S64328020171027.xlsx\",\"BordereauFormatId\":\"4ec20038-7ea9-4f10-845e-dac6477f02f7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S64328020171027.xlsx\",\"Filesize\":22347,\"Path\":null,\"size\":22347,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereaux(subSheet);

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3245Path = fpath+"\\src\\test\\resources\\testdata\\ContractPeriodOutside_3245.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//StringSelection IdentificationSheet = new StringSelection(sheet3245Path);
			//UploadFile(IdentificationSheet);
			File excelFile = new File(sheet3245Path);  
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)==true){
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				//VerifyNotificationPopupAfterUpload();
				//sleep(2000);
				if(isVisible(continuebtx)==true){
					verifyMustExists(continuebtx,"Continue Button");
					click(continuebtx,"Continue Button");
					sleep(2000);
					passDate(RequireDate);
					verifyBackground(DateTextBox,ExpectedColor);
					sleep(2000);
					click(continuebtx2,"Continue Button");
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
						sleep(3000);
						deleteBorderEAUX();
						//VerifyNotificationPopupAfterUpload();
					}else{
						Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
					}
				}else{
					Report.LogInfo("ErroScreen", "Expected error not displayed.", "FAIL");
				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				deleteBorderEAUX();
				//VerifyNotificationPopupAfterUpload();
			}
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}
	}
	//============================================================Bordereau processed missing future sequentially=========================
	public void missingFutureSequentiallyNilBordereaux_3452() throws Exception
	{
		String OnlySpPoliCyNum = "356394GI";
		String IncDate = "01/01/2017";
		String ExpDate = "31/12/2017";
		String UnderlineVal = "Childs, Andy";
		String MonthDate = "April 2017";
		String DueDate = "30/05/2017";
		String Valuedate = "30/05/2017";
		String NoRadioBtn = "2";
		//String payload = "{\"Bordereaux\":{\"ContractId\":\"830c9438-85a5-4162-b5c8-30b9e73fb075\",\"Id\":\"0\",\"BordereauMonth\":4,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"PolicyId\":\"0\",\"OriginalFileName\":\"January 2017_CancelProcessing_3452.xlsx\",\"UniqueFileName\":\"S11726320171010.xlsx\",\"BordereauFormatId\":\"f3d9edd1-9335-4e0c-bc14-b7dcc6f3771f\",\"IsPolicyRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S11726320171010.xlsx\",\"Filesize\":25020,\"Path\":null,\"size\":25020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauPolicy\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		policy.addPolicy2(IncDate,ExpDate);
		verifyExists(DraftBtn,"Draft Status Button");
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		applyFilterPolicy(policy.PolicyNumber);
		//applyFilterPolicy("837872SO");
		openSelectedPolicy();
		SubmitBordereauxWithYesnoButtons(MonthDate);		
		DeleteError();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3452Path = fpath+"\\src\\test\\resources\\testdata\\Financial Calculation_TC_3613.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3452Path); 

		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculation_TC_3613.xlsx\",\"UniqueFileName\":\"S36582220180025.xlsx\",\"BordereauFormatId\":\"c691dc97-46d0-4b0f-8dd2-cc143c764386\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S36582220180025.xlsx\",\"Filesize\":107398,\"Path\":null,\"size\":107398,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			click(ReviewBtn,"Reviwe button");
			waitForElementToAppear(SuRcdAssmnt,10);
			verifyMustExists(SuRcdAssmnt,"Submit record assesment button");
			click(SuRcdAssmnt,"Submit record assesment button");
			waitForElementToAppear(FrApprovalbtn,10);
			verifyMustExists(FrApprovalbtn,"For Approval button");
			click(FrApprovalbtn,"For Approval button");
			clickOnApproveBordBtn();

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3452ScndPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_CancelProcessing_3452.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile1 = new File(sheet3452ScndPath); 

			String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":4,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_CancelProcessing_3452.xlsx\",\"UniqueFileName\":\"S83729920180302.xlsx\",\"BordereauFormatId\":\"c691dc97-46d0-4b0f-8dd2-cc143c764386\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S83729920180302.xlsx\",\"Filesize\":25020,\"Path\":null,\"size\":25020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				SelectPauseButton();
			//	SelectYesNoAndDeleteProcessing(NoRadioBtn);
				deleteBorderEAUX();
				//sleep(3000);
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				goBack();
				ApplyDueDateFilter(DueDate, Valuedate);
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
		}
	}

	public void missingFutureSequentiallyNilBordereaux_3451() throws Exception
	{
		String OnlySpPoliCyNum = "356394GI";
		String MonthDate = "April 2017";
		String DueDate = "30/05/2017";
		String Valuedate = "30/05/2017";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":4,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_NilBordereau_3451.xlsx\",\"UniqueFileName\":\"S81295420180114.xlsx\",\"BordereauFormatId\":\"e1f3d92f-bd74-4e8a-b3c2-2eb5f4d3bb9c\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S81295420180114.xlsx\",\"Filesize\":23092,\"Path\":null,\"size\":23092,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String NoRadioBtn = "2";

		applyFilterPolicy(policy.PolicyNumber);
		//applyFilterPolicy("838003TL");
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereauxWithYesnoButtons(MonthDate);
			DeleteError();
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3451Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_NilBordereau_3451.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//StringSelection IdentificationSheet = new StringSelection(sheet3451Path);
			//UploadFile(IdentificationSheet);
			File excelFile = new File(sheet3451Path);  
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				String ErrorScreen = "@xpath=.//h2[text()='Missing Bordereau periods']";
				String YesBtn = "@xpath=.//*[@value='true']";
				if(isVisible(ErrorScreen)== true){							
					if(isVisible(ContinueProcessingBodrBtn)== true){
						javaScriptclick(YesBtn,"Yes button");
						verifyMustExists(ContinueProcessingBodrBtn,"Continue Processing button");
						javaScriptclick(ContinueProcessingBodrBtn,"Continue Processing button");
						sleep(3000);
						refreshUploadedFile();
						if(isVisible(ReviewBtn)==true){
							Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
							ApplyDueDateFilter(DueDate, Valuedate);
							deleteBorderEAUX();
						}else{
							Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
							ApplyDueDateFilter(DueDate, Valuedate);
							deleteBorderEAUX();
						}
						Report.LogInfo("StepCheck", "Steps 4,5 completed", "PASS");
					}else{
						goBack();
					}
				}else{
					goBack();
				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				ApplyDueDateFilter(DueDate, Valuedate);
				deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}
	}

	//============================================ Bordereau processed Already approved ====================================== 	

	public void AlreadyApprovedCancelProcessing_3453() throws Exception
	{
		String OnlySpPoliCyNum = "356394GI";
		String MonthDate = "January 2017";
		String DueDate = "Blanks";
		String Valuedate = "null";
		String NoRadioBtn = "1";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_AlreadyApprove_CancelProcessing_3453.xlsx\",\"UniqueFileName\":\"S83889520171027.xlsx\",\"BordereauFormatId\":\"c691dc97-46d0-4b0f-8dd2-cc143c764386\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S83889520171027.xlsx\",\"Filesize\":25020,\"Path\":null,\"size\":25020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereauxWithYesnoButtons(MonthDate);
			DeleteError();
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3453Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_AlreadyApprove_CancelProcessing_3453.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//StringSelection IdentificationSheet = new StringSelection(sheet3451Path);
			//UploadFile(IdentificationSheet);
			File excelFile = new File(sheet3453Path);  
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				//VerifyNotificationPopupAfterUpload();
				SelectPauseButton(); 
				deleteBorderEAUX();
				//sleep(3000);
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				ApplyDueDateFilter(DueDate, Valuedate);
				deleteBorderEAUX();
			}}else{
				Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
				policy.changeStatusToSigned();
			}
	}

	public void AlreadyApprovedIncorrectPeriod_3455() throws Exception
	{
		String OnlySpPoliCyNum = "356394GI";
		String MonthDate = "January 2017";
		String DueDate = "02/03/2017";
		String Valuedate = "02/03/2017";
		String IncorrectPerDate = "February 2017";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_IncorrectPeriod_3455.xlsx\",\"UniqueFileName\":\"S61383520171027.xlsx\",\"BordereauFormatId\":\"c691dc97-46d0-4b0f-8dd2-cc143c764386\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S61383520171027.xlsx\",\"Filesize\":23092,\"Path\":null,\"size\":23092,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereauxWithYesnoButtons(MonthDate);
			DeleteError();
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3455Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_IncorrectPeriod_3455.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//StringSelection IdentificationSheet = new StringSelection(sheet3451Path);
			//UploadFile(IdentificationSheet);
			File excelFile = new File(sheet3455Path);  
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				//VerifyNotificationPopupAfterUpload();
				if(isVisible(ProcessBordereauPage)==true){
					CalDateSelection(IncorrectPerDate);
					verifyMustExists(ProcessBordereauPage,"Process Against Selected Period Button");
					click(ProcessBordereauPage,"Process Against Selected Period Button");
					waitForElementToAppear(ProcessAgainstSelectedPeriodBtn,5);
					verifyMustExists(ProcessAgainstSelectedPeriodBtn,"Process Against Selected Period Button");
					click(ProcessAgainstSelectedPeriodBtn,"Process Against Selected Period Button");
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
						ApplyDueDateFilter(DueDate, Valuedate);
						deleteBorderEAUX();
					}else{
						Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
						ApplyDueDateFilter(DueDate, Valuedate);
						deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ErrorScreenCheck", "Expected error screen not displayed.", "FAIL");
				}			
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				ApplyDueDateFilter(DueDate, Valuedate);
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}
	}

	public void AlreadyApprovedAdditionalBordereaux_3456() throws Exception
	{
		String OnlySpPoliCyNum = "356394GI";
		String MonthDate = "January 2017";
		String DueDate = "02/03/2017";
		String Valuedate = "02/03/2017";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_AdditionalBordereaux_3456.xlsx\",\"UniqueFileName\":\"S38923220171027.xlsx\",\"BordereauFormatId\":\"c691dc97-46d0-4b0f-8dd2-cc143c764386\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S38923220171027.xlsx\",\"Filesize\":23092,\"Path\":null,\"size\":23092,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereauxWithYesnoButtons(MonthDate);
			DeleteError();
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3456Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_AdditionalBordereaux_3456.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//StringSelection IdentificationSheet = new StringSelection(sheet3451Path);
			//UploadFile(IdentificationSheet);
			File excelFile = new File(sheet3456Path);  
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				//VerifyNotificationPopupAfterUpload();
				if(isVisible(ProcessAsAdditionalBtn)==true){
					waitForElementToAppear(ProcessAsAdditionalBtn,5);
					verifyMustExists(ProcessAsAdditionalBtn,"Process Against Selected Period Button");
					click(ProcessAsAdditionalBtn,"Process Against Selected Period Button");
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
						ApplyDueDateFilter(DueDate, Valuedate);
						deleteBorderEAUX();
					}else{
						Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
						ApplyDueDateFilter(DueDate, Valuedate);
						deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ErrorScreenCheck", "Expected error screen not displayed.", "FAIL");
				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				ApplyDueDateFilter(DueDate, Valuedate);
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}
	}

	public void CorrectionBordereau_3458() throws Exception
	{
		String OnlySpPoliCyNum = "356394GI";
		String MonthDate = "January 2017";
		String DueDate = "02/03/2017";
		String Valuedate = "02/03/2017";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3458.xlsx\",\"UniqueFileName\":\"S33618320171027.xlsx\",\"BordereauFormatId\":\"c691dc97-46d0-4b0f-8dd2-cc143c764386\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S33618320171027.xlsx\",\"Filesize\":23092,\"Path\":null,\"size\":23092,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereauxWithYesnoButtons(MonthDate);
			DeleteError();
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3458Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3458.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			File excelFile = new File(sheet3458Path);  
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);

			//StringSelection IdentificationSheet = new StringSelection(sheet3458Path);
			//UploadFile(IdentificationSheet);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				if(isVisible(ProcessAsCorrectionBtn)==true){
					waitForElementToAppear(ProcessAsCorrectionBtn,5);
					verifyMustExists(ProcessAsCorrectionBtn,"Process Against Selected Period Button");
					click(ProcessAsCorrectionBtn,"Process Against Selected Period Button");
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
						ApplyDueDateFilter(DueDate, Valuedate);
						deleteBorderEAUX();
					}else{
						Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
						ApplyDueDateFilter(DueDate, Valuedate);
						deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ErrorScrenCheck", "Expected error screen not displayed.", "FAIL");
					goBack();
					ApplyDueDateFilter(DueDate, Valuedate);
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				ApplyDueDateFilter(DueDate, Valuedate);
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}
	}

	public void MissingBordereauPeriod_3463() throws Exception
	{
		BProcessingRiskPremiumClaimPage BPProcessng = new BProcessingRiskPremiumClaimPage();

		String IncDate = "01/01/2017";
		String InceptionDate = "01/01/2018";
		String InceptionDateExp = "31/12/2018";
		String InceptionDateExp1 = "31/12/2017";
		String UnderlineVal = "Childs, Andy";
		String MonthDate = "January 2018";
		String NoRadioBtn = "2";
		String UniqueReferenceVal2 = "Contract 2"+getCurrentDateTimeMS();
		String subSheet = "SP - First Sheet (Automation Schema)";
		//String payload = "{\"Bordereaux\":{\"ContractId\":\"4937eb53-88f5-4e75-8b4a-c80b5845d353\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"PolicyId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3463.xlsx\",\"UniqueFileName\":\"S56695420171010.xlsx\",\"BordereauFormatId\":\"f3d9edd1-9335-4e0c-bc14-b7dcc6f3771f\",\"IsPolicyRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S56695420171010.xlsx\",\"Filesize\":24610,\"Path\":null,\"size\":24610,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauPolicy\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		policy.addPolicy2(IncDate, InceptionDateExp1);
		verifyExists(DraftBtn,"Draft Status Button");
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();	


		/*String OpenPolicy = "@xpath=//*[@id='FolderListGrid']//tr//td[contains(.,'"+policy.PolicyNumber+"')]";
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.selectPolicyFilter(policy.PolicyNumber);
		sleep(3000);
		waitForElementToAppear(OpenPolicy,5);
		click(OpenPolicy,"Policy");*/
		BPProcessng.openPolicyCreateContract();
		//click(policy.SelectBtn,"Select button");
		//sleep(3000);		
		policy.addPolicyContractDetails1(UniqueReferenceVal2, InceptionDate, InceptionDateExp, policy.Status1, policy.Broker2, policy.Bline2, policy.Underline2);
		//policy.addPolicyContractDetails(UniqueReferenceVal2, InceptionDate, policy.Status1, policy.Broker2, policy.Bline2, policy.Underline2);

		verifyExists(DraftBtn,"Draft Status Button");
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);
		//CalDateSelection(MonthDate);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3463Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3463.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection IdentificationSheet = new StringSelection(sheet3451Path);
		//UploadFile(IdentificationSheet);
		File excelFile = new File(sheet3463Path);

		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3463.xlsx\",\"UniqueFileName\":\"S39017020171027.xlsx\",\"BordereauFormatId\":\"c691dc97-46d0-4b0f-8dd2-cc143c764386\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S39017020171027.xlsx\",\"Filesize\":24610,\"Path\":null,\"size\":24610,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)== true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(2000);
			//VerifyNotificationPopupAfterUpload();
			SelectPauseButton();
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
	}

	public void MissingBordereauPeriodContinueNillBordereau_3469() throws Exception
	{
		String OnlySpPoliCyNum = "412478QC";
		String MonthDate = "January 2018";
		String YesRadioBtn = "1";
		String subSheet = "SP - First Sheet (Automation Schema)";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3469.xlsx\",\"UniqueFileName\":\"S41253820171027.xlsx\",\"BordereauFormatId\":\"c691dc97-46d0-4b0f-8dd2-cc143c764386\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S41253820171027.xlsx\",\"Filesize\":24610,\"Path\":null,\"size\":24610,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereaux(subSheet);
			//CalDateSelection(MonthDate);

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3469Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3469.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//StringSelection IdentificationSheet = new StringSelection(sheet3451Path);
			//UploadFile(IdentificationSheet);
			File excelFile = new File(sheet3469Path);  
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				//VerifyNotificationPopupAfterUpload();
				SelectYesNoAndContinueProcessing(YesRadioBtn);
				refreshUploadedFile();
				if(isVisible(ReviewBtn)==true){
					Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
					//ApplyDueDateFilter(DueDate, Valuedate);
					deleteBorderEAUX();
				}else{
					Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
					//ApplyDueDateFilter(DueDate, Valuedate);
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}
	}

	public void ErrorRemainingCancelProcessing_3471() throws Exception
	{
		String OnlySpPoliCyNum = "434779QW";
		String IncDate = "01/01/2017";
		String ExpDate = "31/12/2017";
		String UnderlineVal = "Childs, Andy";
		String MonthDate = "February 2017";
		String DueDate = "30/03/2017";
		String Valuedate = "30/03/2017";
		String NoRadioBtn = "2";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		policy.addPolicy2(IncDate,ExpDate);
		verifyExists(DraftBtn,"Draft Status Button");
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		applyFilterPolicy(policy.PolicyNumber);

		openSelectedPolicy();
		SubmitBordereauxWithYesnoButtons(MonthDate);
		DeleteError();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3471Path = fpath+"\\src\\test\\resources\\testdata\\Financial Calculation_TC_3613.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3471Path); 

		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculation_TC_3613.xlsx\",\"UniqueFileName\":\"S89714220180115.xlsx\",\"BordereauFormatId\":\"e1f3d92f-bd74-4e8a-b3c2-2eb5f4d3bb9c\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S89714220180115.xlsx\",\"Filesize\":107422,\"Path\":null,\"size\":107422,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewError)==true){
			click(ReviewError,"Review button");
			waitForElementToAppear(VerifyErrorpage,10);
			verifyMustExists(VerifyErrorpage,"Verify Error page");
			waitForElementToAppear(SkipAllErrorsBtn,10);
			verifyMustExists(SkipAllErrorsBtn,"Skip All Error");
			click(SkipAllErrorsBtn,"Skip All Error");
			sleep(1000);
			waitForElementToAppear(SuRcdAssmnt,10);
			verifyMustExists(SuRcdAssmnt,"Submit record assesment button");
			click(SuRcdAssmnt,"Submit record assesment button");
			waitForElementToAppear(FrApprovalbtn,10);
			verifyMustExists(FrApprovalbtn,"For Approval button");
			click(FrApprovalbtn,"For Approval button");
			clickOnApproveBordBtn();
			refreshUploadedFileApprovedStatus();
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3471ScndPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3471.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile1 = new File(sheet3471ScndPath); 

			//String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC3371.xlsx\",\"UniqueFileName\":\"S47871320171027.xlsx\",\"BordereauFormatId\":\"4ec20038-7ea9-4f10-845e-dac6477f02f7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S47871320171027.xlsx\",\"Filesize\":23550,\"Path\":null,\"size\":23550,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3471.xlsx\",\"UniqueFileName\":\"S64524020180115.xlsx\",\"BordereauFormatId\":\"e1f3d92f-bd74-4e8a-b3c2-2eb5f4d3bb9c\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S64524020180115.xlsx\",\"Filesize\":23081,\"Path\":null,\"size\":23081,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);

				SelectPauseButton();
				//sleep(3000);
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				ApplyDueDateFilter(DueDate, Valuedate);
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
		}
	}


	public void ErrorRemainingCancelProcessing_3472() throws Exception
	{
		String OnlySpPoliCyNum = "434779QW";
		String MonthDate = "January 2017";
		String DueDate = "Blanks";
		String Valuedate = "null";
		String NoRadioBtn = "2";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3472.xlsx\",\"UniqueFileName\":\"S10698920171027.xlsx\",\"BordereauFormatId\":\"4ec20038-7ea9-4f10-845e-dac6477f02f7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S10698920171027.xlsx\",\"Filesize\":23081,\"Path\":null,\"size\":23081,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereauxWithYesnoButtons(MonthDate);
			DeleteError();
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3472Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3472.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			File excelFile = new File(sheet3472Path);  
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				SelectPauseButton();
				//sleep(3000);
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				ApplyDueDateFilter(DueDate, Valuedate);
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}
	}

	public void DatePresentationCannotIdentified_4475() throws Exception
	{

		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		//TC 3532
		BQPage.addBordereauFormatClaim1();
		String SubSheet = BQPage.ClaimBordereauText;
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(SubSheet);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn, 5);
		verifyMustExists(BQPage.EditBtn, "Edit button");
		click(BQPage.EditBtn, "Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		//applyFilterPolicy("142006MC");
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.navigationOnBordereauxTab();
		SubmitBordereaux(SubSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4475Path = fpath+"\\src\\test\\resources\\testdata\\Jan-All sheets_TC4475.xlsx";
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
		File excelFile = new File(sheet4475Path);  
		//contractId = addNewBordereauFormatPolicy(payload1, GetData);

		String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Jan-All sheets_TC4475.xlsx\",\"UniqueFileName\":\"S41399620180120.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S41399620180120.xlsx\",\"Filesize\":14102,\"Path\":null,\"size\":14102,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			verifyMustExists(ReviewBtn,"Review button");
			openDATALink();
			navigateToDATAClaimTab();
			//Verify Inception date format
			String RiskInceptionDatecolumn="@xpath=//*[@data-field='RiskInceptionDate']";
			String RiskInceptionDate1="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[1]//td[contains(@ng-click,'RiskInceptionDate')][text()='01/01/2017']";
			waitForElementToAppear(RiskInceptionDatecolumn,20);
			mouseOverAction(RiskInceptionDatecolumn);
			verifyMustExists(RiskInceptionDatecolumn,"Risk Inception Date column");
			sleep(2000);
			verifyExists(RiskInceptionDate1,"Inception Date is displayed in MM-DD-YYYY format");
		}
		else{

			Report.LogInfo("ValidateReviewErrorStatus", "Review status not displayed", "FAIL");
			deleteBorderEAUX();
		}
	}

	public void ErrorRemainingContinueProcessing_3475() throws Exception
	{			
		String NewColumnFieldDDOption = "Sequence Rule Format (Automation Schema)";
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		String MonthDate = "September 2017";
		String DateMonth = "October 2017";
		String YesRadioBtn = "1";
		String DueDate = "30/11/2017";
		String Valuedate = "30/11/2017";
		String InceptionDate="01/09/2017";
		String InceptionDateExp="01/09/2018";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String QueName = "Sequence Rule Format";
		policy.addPolicy2(InceptionDate, InceptionDateExp);
		verifyExists(DraftBtn,"Draft Status Button");
		policy.contractId = ReturnContractID();
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(QueName);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();

		SubmitBordereaux(NewColumnFieldDDOption);
		//CalDateSelection(MonthDate);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3475Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_3475.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File excelFile = new File(sheet3475Path);

	//	String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":9,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_3475.xlsx\",\"UniqueFileName\":\"S74017420180119.xlsx\",\"BordereauFormatId\":\"24fce8fd-bdf6-49e0-b56c-53e0e019e7b5\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S74017420180119.xlsx\",\"Filesize\":25042,\"Path\":null,\"size\":25042,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
	//	String payload2 ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":10,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_Second_TC3475.xlsx\",\"UniqueFileName\":\"S86289120180119.xlsx\",\"BordereauFormatId\":\"24fce8fd-bdf6-49e0-b56c-53e0e019e7b5\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S86289120180119.xlsx\",\"Filesize\":23081,\"Path\":null,\"size\":23081,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":9,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_3475.xlsx\",\"UniqueFileName\":\"S74017420180119.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S74017420180119.xlsx\",\"Filesize\":25042,\"Path\":null,\"size\":25042,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String payload2 ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":10,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_Second_TC3475.xlsx\",\"UniqueFileName\":\"S86289120180119.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S86289120180119.xlsx\",\"Filesize\":23081,\"Path\":null,\"size\":23081,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)== true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			if(isVisible(SkippAllErroBtn)== true && isEnable(SkippAllErroBtn)==true){
				clickOnSkipAllErrorBTN();
				clickOnSubProcessRcdBtn();
				//clickOnSubAssesmntBtn();
				sleep(5000);
				waitForElementToAppear(FrApprovalbtn,10);
				verifyMustExists(FrApprovalbtn,"For Approval button");
				click(FrApprovalbtn,"For Approval button");
				clickOnApproveBordBtn();
				refreshUploadedFileApprovedStatus();
				SubmitBordereauxWithYesnoButtons(DateMonth);

				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet34752Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_Second_TC3475.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//StringSelection IdentificationSheet = new StringSelection(sheet3451Path);
				//UploadFile(IdentificationSheet);
				File excelFile1 = new File(sheet34752Path);  
				uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
				refreshUploadedFile();
				if(checkErrorReviewButton(ReviewError)== true)
				{
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
					sleep(2000);
					if(isVisible(CancelAndDeleteBordereauxSp2)==true){
						SelectYesNoAndContinueProcessing(YesRadioBtn);
						refreshUploadedFile();
						if(isVisible(ReviewBtn)==true){
							Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
							openDATALink();
							navigateToDATARiskTab();
							//OnViewDiscardedRecordsIcon();
							verifyExists(RowNumber,"Row Number column");
							sleep(2000);
							List<WebElement> RowCount = webDriver.findElements(By.xpath("//*[@data-field='RowNumber']//following::tr"));

							if((RowCount.size())== 8){
								Report.LogInfo("ValidationReviewStatus", "Record count is 8", "Pass");	
								sleep(1000);
							}
							else{
								Report.LogInfo("ValidationReviewStatus", "Record count is not 8", "FAIL");
							}
							verifyMustExists(BORDEREAUXLink,"BORDEREAUX Link");
							click(BORDEREAUXLink,"BORDEREAUX Link");
							sleep(3000);
							navigateOnProcessingTab();
							deleteBorderEAUX();
						}else{
							Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
							ApplyDueDateFilter(DueDate, Valuedate);

							deleteBorderEAUX();
						}
					}else{
						Report.LogInfo("ErrorScreenCheck", "Expected error screen not displayed.", "FAIL");
					}
				}else{
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
					ApplyDueDateFilter(DueDate, Valuedate);
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ErrorScreen", "Expected error screen not displayed or button is not clickable.", "FAIL");
			}
		}
		else
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}		
	}

	public void SamebordorErrorRemainingContinueProcessing_3477() throws Exception
	{
		String NewColumnFieldDDOption = "Sequence Rule Format (Automation Schema)";
		String UniqueReferenceVal3 = "Automation Policy"+getCurrentDateTimeMS1();
		String QueName = "Sequence Rule Format";
		String MonthDate = "September 2017";
		String DateMonth = "September 2017";
		String YesRadioBtn = "1";
		String DueDate = "30/10/2017";
		String Valuedate = "null";
		String InceptionDate="01/09/2017";
		String InceptionDateExp="01/09/2018";
		String QueName1 = "Sequence Rule Format";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(QueName);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		policy.addPolicy2(InceptionDate, InceptionDateExp);
		verifyExists(DraftBtn,"Draft Status Button");
		policy.contractId = ReturnContractID();
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();			

		applyFilterPolicy(policy.PolicyNumber);
		//applyFilterPolicy("970979BW");
		openSelectedPolicy();
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		SubmitBordereaux(NewColumnFieldDDOption);
		//CalDateSelection(MonthDate);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3477Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_3477.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File excelFile = new File(sheet3477Path); 

		String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":9,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_3477.xlsx\",\"UniqueFileName\":\"S37594920180119.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S37594920180119.xlsx\",\"Filesize\":25042,\"Path\":null,\"size\":25042,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)== true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			if(isVisible(SkippAllErroBtn)== true && isEnable(SkippAllErroBtn)==true){
				clickOnSkipAllErrorBTN();
				clickOnSubProcessRcdBtn();
				//clickOnSubAssesmntBtn();
				sleep(5000);
				waitForElementToAppear(FrApprovalbtn,10);
				verifyMustExists(FrApprovalbtn,"For Approval button");
				click(FrApprovalbtn,"For Approval button");
				clickOnApproveBordBtn();
				refreshUploadedFileApprovedStatus();
				SubmitBordereauxWithYesnoButtons(DateMonth);

				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet34772Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_Second_TC3477.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//StringSelection IdentificationSheet = new StringSelection(sheet3451Path);
				//UploadFile(IdentificationSheet);
				File excelFile1 = new File(sheet34772Path);  
				String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":9,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_Second_TC3477.xlsx\",\"UniqueFileName\":\"S83310320180119.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S83310320180119.xlsx\",\"Filesize\":23081,\"Path\":null,\"size\":23081,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
				refreshUploadedFile();
				if(checkErrorReviewButton(ReviewError)== true)
				{
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
					sleep(2000);
					SelectYesNoAndContinueProcessing(YesRadioBtn);
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
						//ApplyDueDateFilter(DueDate, Valuedate);
						openDATALink();
						navigateToDATARiskTab();
						//	OnViewDiscardedRecordsIcon();
						waitForElementToAppear(BlankRecordsMsg,5);
						if (isVisible(BlankRecordsMsg)==true)
						{
							Report.LogInfo("DataValidation", "No records found", "Fail");
						}
						else{
							Report.LogInfo("DataValidation", "Data displayed successfully.", "PASS");
						}
						verifyMustExists(BORDEREAUXLink,"BORDEREAUX Link");
						click(BORDEREAUXLink,"BORDEREAUX Link");
						sleep(3000);
						navigateOnProcessingTab();
						deleteBorderEAUX();
					}else{
						Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
						//ApplyDueDateFilter(DueDate, Valuedate);
						deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
					//ApplyDueDateFilter(DueDate, Valuedate);
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ErrorScreen", "Expected error screen not displayed or button is not clickable", "FAIL");
			}
		}
		else
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}		
	}

	public void contractStatusCheck_3523() throws Exception
	{
		String ExpectedContractStatus="Contract Status not Signed";
		//String UniqueReferenceVal2 = "Automation Policy"+getCurrentDateTimeMS1();
		String UniqueReferenceVal2 = "Contract 2"+getCurrentDateTimeMS();
		String IncDate = "01/01/2017";
		String IncepDate2 = "01/01/2016";
		String ExpDate="31/12/2016";
		String UnderlineVal = "Childs, Andy";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		policy.addPolicy1(IncDate);
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		String OpenPolicy = "@xpath=//*[@id='FolderListGrid']//tr//td[contains(.,'"+policy.PolicyNumber+"')]";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();

		sleep(2000);
		verifyExists(policy.PolicyEditDot,"Edit Policy");
		click(policy.PolicyEditDot,"Edit Policy");

		verifyExists(AddContractForPolicy,"Edit Policy");
		click(AddContractForPolicy,"Edit Policy");

		verifyExists(policy.Policytitle,"Verify Policy Title");	
		policy.addPolicyContractDetails1(UniqueReferenceVal2, IncepDate2, ExpDate, Status1,policy.Broker2, policy.Bline2, policy.Underline2);
		verifyExists(DraftBtn,"Draft Status Button");
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");

		//String payload = "{\"Bordereaux\":{\"ContractId\":\"cd9cf514-81ee-4727-ac3c-60392e0bbe94\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"PolicyId\":\"0\",\"OriginalFileName\":\"ContractStatusCheck_TC_3523.xlsx\",\"UniqueFileName\":\"S98008620171014.xlsx\",\"BordereauFormatId\":\"360bbefa-2ed6-47cb-bbf5-9791c078764a\",\"IsPolicyRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S98008620171014.xlsx\",\"Filesize\":19610,\"Path\":null,\"size\":19610,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauPolicy\":[]}";
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";


		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3523Path = fpath+"\\src\\test\\resources\\testdata\\ContractStatusCheck_TC_3523.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3523Path);
		//UploadFile(filePath);
		File excelFile = new File(sheet3523Path);  

		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//System.out.println(contractId);
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"ContractStatusCheck_TC_3523.xlsx\",\"UniqueFileName\":\"S85708820171030.xlsx\",\"BordereauFormatId\":\"93f99891-5ddb-4afe-b363-fce57e73eea3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S85708820171030.xlsx\",\"Filesize\":19610,\"Path\":null,\"size\":19610,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);

		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);

			if(isVisible(CancelAndDeleteBtn)==true)
			{
				Report.LogInfo("ValidateErrorScreen", "expected Error screen displayed ", "PASS");
				verifyOptionalExists(ContractStatusMsg1,"Contract Status not Signed Message");
				String ActualContractStatus=getTextFrom(ContractStatusMsg1);
				if(ActualContractStatus.equals(ExpectedContractStatus))
				{
					Report.LogInfo("ValidateContractStatusMsg", "Contract status message validate successfully", "PASS");	
				}
				else
				{
					Report.LogInfo("ValidateContractStatusMsg", "Contract status message not validate successfully", "FAIL");
				}
				verifyMustExists(CancelAndDeleteBtn,"Cancel Processing And Delete Bordereau");
				click(CancelAndDeleteBtn," Click on Cancel Processing And Delete Bordereau");	
				sleep(3000);
				if(isVisible(DeleteYESButton)==true){
					verifyMustExists(DeleteYESButton," Yes and Cancel Processing ");
					click(DeleteYESButton," Click on Yes and Cancel Processing");
				}else{
					Report.LogInfo("ValidateErrorScreen", "expected Error screen not displayed ", "FAIL");
					deleteBorderEAUX();
				}
			}
			else{
				Report.LogInfo("ValidateErrorScreen", "expected Error screen not displayed ", "FAIL");
				goBack();
				deleteBorderEAUX();
			}
		}
		else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
		sleep(3000);
	}
	public void ZeroPassRecord_TC5675() throws Exception
	{
		String IncDate = "01/01/2017";
		String ExpDate = "01/01/2018";
		String subSheet = "SP - First Sheet (Automation Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String QueName = "SP - First Sheet";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(QueName);
		//sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		policy.addPolicy2(IncDate,ExpDate);
		verifyExists(DraftBtn,"Draft Status Button");
    	policy.changeStatusToQuote();
		policy.changeStatusToWritten();
	    policy.changeStatusToSigned();
		
	   /* applyFilterPolicy(policy.PolicyNumber);
		//applyFilterPolicy("783825FW");
		openSelectedPolicy();*/
		SubmitBordereaux(subSheet);
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
    	String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			Sheet5675Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_5675.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(Sheet5675Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_5675.xlsx\",\"UniqueFileName\":\"S37792120180316.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S37792120180316.xlsx\",\"Filesize\":24555,\"Path\":null,\"size\":24555,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_5675.xlsx\",\"UniqueFileName\":\"S61420320180316.xlsx\",\"BordereauFormatId\":\"c639abe2-7646-4905-983a-aa026c9c24cd\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S61420320180316.xlsx\",\"Filesize\":24555,\"Path\":null,\"size\":24555,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_5675.xlsx\",\"UniqueFileName\":\"S35931620180317.xlsx\",\"BordereauFormatId\":\"c639abe2-7646-4905-983a-aa026c9c24cd\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S35931620180317.xlsx\",\"Filesize\":24555,\"Path\":null,\"size\":24555,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		
		if(checkErrorReviewButton(ReviewError)== true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			if(isVisible(SkippAllErroBtn1)== true && isEnable(SkippAllErroBtn1)==true){
				 clickOnSkipAllErrorBTN1();
			
				waitForElementToAppear(Cancelbtn1,10);
				verifyMustExists(Cancelbtn1,"Cancel button");
				click(Cancelbtn1,"Cancel button");
				refreshUploadedFile();
				waitForElementToAppear(ReviewError,10);
				if(isVisible(ReviewError)==true){
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error Status Button Displayed", "PASS");
					deleteBorderEAUX();
				}
				else{
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error Status Button not Displayed", "FAIL");
				}	
				//3477
			
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					Sheet5675Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_5675.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				else{
					Report.LogInfo("ErrorScreen", "Expected error screen not displayed or button is not clickable", "FAIL");
				}
			}
			else
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				deleteBorderEAUX();
				//VerifyNotificationPopupAfterUpload();
			}
	}
	
	

	//---------------------------------------------------------Financial Fields------------------------------------------------------
	public void EnterCharacterFinantialfields_3373() throws Exception
	{
		String IncDate = "01/01/2017";
		String ExpDate = "31/12/2017";
		String subSheet = "SP - First Sheet (Automation Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String SubmitSheet="SP - First Sheet";
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
		policy.addPolicy2(IncDate,ExpDate);
		verifyExists(DraftBtn,"Draft Status Button");
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3373Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3373.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3373Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3373.xlsx\",\"UniqueFileName\":\"S65411920171027.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S65411920171027.xlsx\",\"Filesize\":23551,\"Path\":null,\"size\":23551,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)== true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(2000);
			if(isVisible(CorrectedVal)==true){
				verifyMustExists(CorrectedVal,"Corrected Value textbox");
				sendKeys(CorrectedVal, "1000", "Corrected Value");
				verifyMustExists(continuebtx,"Continue button");
				click(continuebtx, "Continue button");
				refreshUploadedFile();
				if(isVisible(ReviewBtn)==true){
					Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
					deleteBorderEAUX();
				}else{
					Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ErrorScreen", "Expected error screen not displayed.", "FAIL");
			}
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
	}

	public void AlphaNumericFinantialfields_3424() throws Exception
	{
		String subSheet = "SP - First Sheet (Automation Schema)";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial_TC2_3424.xlsx\",\"UniqueFileName\":\"S12850420171027.xlsx\",\"BordereauFormatId\":\"4ec20038-7ea9-4f10-845e-dac6477f02f7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S12850420171027.xlsx\",\"Filesize\":23551,\"Path\":null,\"size\":23551,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereaux(subSheet);
			//CalDateSelection(MonthDate);

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3424Path = fpath+"\\src\\test\\resources\\testdata\\Financial_TC2_3424.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//StringSelection IdentificationSheet = new StringSelection(sheet3451Path);
			//UploadFile(IdentificationSheet);
			File excelFile = new File(sheet3424Path);  
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				if(isVisible(CorrectedVal)==true){
					verifyMustExists(CorrectedVal,"Corrected Value textbox");
					sendKeys(CorrectedVal, "1000", "Corrected Value");
					verifyMustExists(continuebtx,"Continue button");
					click(continuebtx, "Continue button");
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
						deleteBorderEAUX();
					}else{
						Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
						deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ErrorScreen", "Expected error screen not displayed.", "FAIL");
				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}
	}

	public void SpecialCharFinantialfields_3425() throws Exception
	{
		String subSheet = "SP - First Sheet (Automation Schema)";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial_TC3_3425.xlsx\",\"UniqueFileName\":\"S58286820171027.xlsx\",\"BordereauFormatId\":\"4ec20038-7ea9-4f10-845e-dac6477f02f7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S58286820171027.xlsx\",\"Filesize\":23554,\"Path\":null,\"size\":23554,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereaux(subSheet);
			//CalDateSelection(MonthDate);

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3425Path = fpath+"\\src\\test\\resources\\testdata\\Financial_TC3_3425.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//StringSelection IdentificationSheet = new StringSelection(sheet3451Path);
			//UploadFile(IdentificationSheet);
			File excelFile = new File(sheet3425Path);  
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				if(isVisible(CorrectedVal)==true){
					verifyMustExists(CorrectedVal,"Corrected Value textbox");
					sendKeys(CorrectedVal, "1000", "Corrected Value");
					verifyMustExists(continuebtx,"Continue button");
					click(continuebtx, "Continue button");
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
						deleteBorderEAUX();
					}else{
						Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
						deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ErrorScreen", "Expected error screen not displayed.", "FAIL");
				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}
	}

	public void financialCalculation_GrossPremiumIncludingTax() throws Exception{
		String SubmitSheet="Bordereau Processing";
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
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux("Bordereau Processing (kruthika test schema)");
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculation_TC_3441.xlsx\",\"UniqueFileName\":\"S32813620171028.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S32813620171028.xlsx\",\"Filesize\":107398,\"Path\":null,\"size\":107398,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3441Path = fpath+"\\src\\test\\resources\\testdata\\Financial Calculation_TC_3441.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3441Path);
		//UploadFile(filePath);
		File excelFile = new File(sheet3441Path);  
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			selectRowNumberAscOrder();
			String GrossPremiumIncludingTax="@xpath=//*[@data-field='Gross_Premium_including_Tax']";
			String GrossPremiumTax1Row="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[1]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='105.00']";
			String GrossPremiumTax2Row="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[2]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='100.00']";
			String GrossPremiumTax3Row="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[3]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='0.00']";
			String GrossPremiumTax4Row="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[4]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='0.00']";
			//String GrossPremiumTax5Row="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[5]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,613.85']";
			//String GrossPremiumTax6Row="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[6]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='105.00']";
			//String GrossPremiumTax7Row="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[7]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='105.00']";
			//String GrossPremiumTax8Row="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[8]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='0.00']";
			//String GrossPremiumTax9Row="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[9]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='105.00']";
			//String GrossPremiumTax10Row="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[10]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='105.00']";
			waitForElementToAppear(GrossPremiumIncludingTax,5);
			mouseOverAction(GrossPremiumIncludingTax);
			verifyMustExists(GrossPremiumIncludingTax,"Gross Premium Including Tax column");
			sleep(2000);
			verifyExists(GrossPremiumTax1Row,"Gross Premium Including Tax-1 Value");
			verifyExists(GrossPremiumTax2Row,"Gross Premium Including Tax-2 Value");
			verifyExists(GrossPremiumTax3Row,"Gross Premium Including Tax-3 Value");
			verifyExists(GrossPremiumTax4Row,"Gross Premium Including Tax-4 Value");
			/*verifyExists(GrossPremiumTax5Row,"Gross Premium Including Tax-5 Value");
			verifyExists(GrossPremiumTax6Row,"Gross Premium Including Tax-6 Value");
			verifyExists(GrossPremiumTax7Row,"Gross Premium Including Tax-7 Value");
			verifyExists(GrossPremiumTax8Row,"Gross Premium Including Tax-8 Value");
			verifyExists(GrossPremiumTax9Row,"Gross Premium Including Tax-9 Value");
			verifyExists(GrossPremiumTax10Row,"Gross Premium Including Tax-10 Value");	*/
			sleep(2000);
		} 
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
		}		
	}

	public void financialCalculation_GrossPremium() throws Exception{
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.navigationOnBordereauxTab();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			if(isVisible(DataLinkNoResult)==true)
			{
				Report.LogInfo("ValidateResult", "Result not display", "Fail");
			}
			else
			{
				selectRowNumberAscOrder();
				String GrossPremium1Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][2][text()='100.00']";
				String GrossPremium2Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][2][text()='100.00']";
				String GrossPremium3Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium')][2][text()='0.00']";
				String GrossPremium4Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium')][2][text()='0.00']";
				String GrossPremium5Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[5]//td[contains(@ng-click,'Gross_Premium')][2][text()='1,537.00']";
				String GrossPremium6Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[6]//td[contains(@ng-click,'Gross_Premium')][2][text()='100.00']";
				String GrossPremium7Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[7]//td[contains(@ng-click,'Gross_Premium')][2][text()='100.00']";
				String GrossPremium8Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[8]//td[contains(@ng-click,'Gross_Premium')][2][text()='0.00']";
				String GrossPremium9Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[9]//td[contains(@ng-click,'Gross_Premium')][2][text()='100.00']";
				String GrossPremium10Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[10]//td[contains(@ng-click,'Gross_Premium')][2][text()='100.00']";
				waitForElementToAppear(GrossPremium,5);
				mouseOverAction(GrossPremium);
				verifyMustExists(GrossPremium,"Gross Premium column");
				sleep(2000);
				verifyExists(GrossPremium1Row,"Gross Premium 1 Value");
				verifyExists(GrossPremium2Row,"Gross Premium 2 Value");
				verifyExists(GrossPremium3Row,"Gross Premium 3 Value");
				verifyExists(GrossPremium4Row,"Gross Premium 4 Value");
			//	verifyExists(GrossPremium5Row,"Gross Premium 5 Value");
			//	verifyExists(GrossPremium6Row,"Gross Premium 6 Value");
			//	verifyExists(GrossPremium7Row,"Gross Premium 7 Value");
			//	verifyExists(GrossPremium8Row,"Gross Premium 8 Value");
			//	verifyExists(GrossPremium9Row,"Gross Premium 9 Value");
			//	verifyExists(GrossPremium10Row,"Gross Premium 10 Value");
				sleep(2000); 
			}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
		}
	}

	public void financialCalculation_CoverholderCommission() throws Exception{
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.navigationOnBordereauxTab();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			if(isVisible(DataLinkNoResult)==true)
			{
				Report.LogInfo("ValidateResult", "Result not display", "Fail");
			}
			else
			{
				selectRowNumberAscOrder();
				String CoverholderCommission1Row="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='124.50']";
				String CoverholderCommission2Row="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='124.50']";
				String CoverholderCommission3Row="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='124.50']";
				String CoverholderCommission4Row="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='0.00']";
				String CoverholderCommission5Row="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[5]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='0.00']";
				String CoverholderCommission6Row="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[6]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='24.50']";
				String CoverholderCommission7Row="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[7]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='0.00']";
				String CoverholderCommission8Row="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[8]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='0.00']";
				String CoverholderCommission9Row="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[9]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='124.50']";
				String CoverholderCommission10Row="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[10]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='124.50']";							
				waitForElementToAppear(CoverholderCommission,5);
				mouseOverAction(CoverholderCommission);
				verifyMustExists(CoverholderCommission,"Coverholder Commission column");
				sleep(2000);
				verifyExists(CoverholderCommission1Row,"Coverholder Commission 1 Value");
			//	verifyExists(CoverholderCommission2Row,"Coverholder Commission 2 Value");
				verifyExists(CoverholderCommission3Row,"Coverholder Commission 3 Value");
				verifyExists(CoverholderCommission4Row,"Coverholder Commission 4 Value");
				verifyExists(CoverholderCommission5Row,"Coverholder Commission 5 Value");
			//	verifyExists(CoverholderCommission6Row,"Coverholder Commission 6 Value");
			//	verifyExists(CoverholderCommission7Row,"Coverholder Commission 7 Value");
			//	verifyExists(CoverholderCommission8Row,"Coverholder Commission 8 Value");
			//	verifyExists(CoverholderCommission9Row,"Coverholder Commission 9 Value");
			//	verifyExists(CoverholderCommission10Row,"Coverholder Commission 10 Value");
				sleep(2000); 
			}
		}
		else
		{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
		}
	}

	public void financialCalculation_CoverholderCommission_Percent() throws Exception{
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.navigationOnBordereauxTab();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			if(isVisible(DataLinkNoResult)==true)
			{
				Report.LogInfo("ValidateResult", "Result not display", "Fail");
			}
			else
			{
				selectRowNumberAscOrder();
				String CoverholderCommissionPercent1Row="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='124.50']";
				String CoverholderCommissionPercent2Row="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='124.50']";
				String CoverholderCommissionPercent3Row="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='0.00 %']";
				String CoverholderCommissionPercent4Row="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='0.00 %']";
				String CoverholderCommissionPercent5Row="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[5]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='0.00 %']";
			//	String CoverholderCommissionPercent6Row="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[6]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='24.50 %']";
			//	String CoverholderCommissionPercent7Row="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[7]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='0.00 %']";
			//	String CoverholderCommissionPercent8Row="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[8]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='0.00 %']";
			//	String CoverholderCommissionPercent9Row="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[9]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='124.50']";
			//	String CoverholderCommissionPercent10Row="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[10]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='124.50']";					
				waitForElementToAppear(CoverholderCommissionPercent,5);
				mouseOverAction(CoverholderCommissionPercent);
				verifyMustExists(CoverholderCommissionPercent,"Coverholder Commission % column");
				sleep(2000);
				verifyExists(CoverholderCommissionPercent1Row,"Coverholder Commission % 1 Value");
				verifyExists(CoverholderCommissionPercent2Row,"Coverholder Commission % 2 Value");
				verifyExists(CoverholderCommissionPercent3Row,"Coverholder Commission % 3 Value");
				verifyExists(CoverholderCommissionPercent4Row,"Coverholder Commission % 4 Value");
				verifyExists(CoverholderCommissionPercent5Row,"Coverholder Commission % 5 Value");
			//	verifyExists(CoverholderCommissionPercent6Row,"Coverholder Commission % 6 Value");
			//	verifyExists(CoverholderCommissionPercent7Row,"Coverholder Commission % 7 Value");
			//	verifyExists(CoverholderCommissionPercent8Row,"Coverholder Commission % 8 Value");
			//	verifyExists(CoverholderCommissionPercent9Row,"Coverholder Commission % 9 Value");
			//	verifyExists(CoverholderCommissionPercent10Row,"Coverholder Commission % 10 Value");
				sleep(2000); 
			}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
		}
	}

	public void financialCalculation_NetPremium() throws Exception{
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.navigationOnBordereauxTab();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			if(isVisible(DataLinkNoResult)==true)
			{
				Report.LogInfo("ValidateResult", "Result not display", "Fail");
			}
			else
			{
				selectRowNumberAscOrder();
				String NetPreium1Row="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][text()='-24.50']";
				String NetPreium2Row="@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][text()='-24.50']";
				String NetPreium3Row="@xpath=//*[@data-field='Net_Premium']//following::tr[3]//td[contains(@ng-click,'Net_Premium')][text()='-124.50']";
				String NetPreium4Row="@xpath=//*[@data-field='Net_Premium']//following::tr[4]//td[contains(@ng-click,'Net_Premium')][text()='0.00']";
				String NetPreium5Row="@xpath=//*[@data-field='Net_Premium']//following::tr[5]//td[contains(@ng-click,'Net_Premium')][text()='1,537.00']";
				String NetPreium6Row="@xpath=//*[@data-field='Net_Premium']//following::tr[6]//td[contains(@ng-click,'Net_Premium')][text()='75.50']";
				String NetPreium7Row="@xpath=//*[@data-field='Net_Premium']//following::tr[7]//td[contains(@ng-click,'Net_Premium')][text()='100.00']";
				String NetPreium8Row="@xpath=//*[@data-field='Net_Premium']//following::tr[8]//td[contains(@ng-click,'Net_Premium')][text()='0.00']";
				String NetPreium9Row="@xpath=//*[@data-field='Net_Premium']//following::tr[9]//td[contains(@ng-click,'Net_Premium')][text()='-24.50']";
				String NetPreium10Row="@xpath=//*[@data-field='Net_Premium']//following::tr[10]//td[contains(@ng-click,'Net_Premium')][text()='-24.50']";
				waitForElementToAppear(NetPremium,5);
				mouseOverAction(NetPremium);
				verifyMustExists(NetPremium,"Net Premium column");
				sleep(2000);
				verifyExists(NetPreium1Row,"Net Premium 1 Value");
				verifyExists(NetPreium2Row,"Net Premium 2 Value");
				verifyExists(NetPreium3Row,"Net Premium 3 Value");
				verifyExists(NetPreium4Row,"Net Premium 4 Value");
				verifyExists(NetPreium5Row,"Net Premium 5 Value");
				verifyExists(NetPreium6Row,"Net Premium 6 Value");
				verifyExists(NetPreium7Row,"Net Premium 7 Value");
				verifyExists(NetPreium8Row,"Net Premium 8 Value");
				verifyExists(NetPreium9Row,"Net Premium 9 Value");
				verifyExists(NetPreium10Row,"Net Premium 10 Value");
				sleep(2000); 
			}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
		}

	}


	public void financialCalculation_Brokerage() throws Exception{	
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.navigationOnBordereauxTab();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			if(isVisible(DataLinkNoResult)==true)
			{
				Report.LogInfo("ValidateResult", "Result not display", "Fail");
			}
			else
			{
				selectRowNumberAscOrder();
				String LondonBrokerage1Row="@xpath=//*[@data-field='London_Brokerage']//following::tr[1]//td[contains(@ng-click,'London_Brokerage')][text()='5.00']";
				String LondonBrokerage2Row="@xpath=//*[@data-field='London_Brokerage']//following::tr[2]//td[contains(@ng-click,'London_Brokerage')][text()='5.00']";
				String LondonBrokerage3Row="@xpath=//*[@data-field='London_Brokerage']//following::tr[3]//td[contains(@ng-click,'London_Brokerage')][text()='5.00']";
				String LondonBrokerage4Row="@xpath=//*[@data-field='London_Brokerage']//following::tr[4]//td[contains(@ng-click,'London_Brokerage')][text()='5.00']";
				String LondonBrokerage5Row="@xpath=//*[@data-field='London_Brokerage']//following::tr[5]//td[contains(@ng-click,'London_Brokerage')][text()='76.85']";
				String LondonBrokerage6Row="@xpath=//*[@data-field='London_Brokerage']//following::tr[6]//td[contains(@ng-click,'London_Brokerage')][text()='5.00']";
				String LondonBrokerage7Row="@xpath=//*[@data-field='London_Brokerage']//following::tr[7]//td[contains(@ng-click,'London_Brokerage')][text()='5.00']";
				String LondonBrokerage8Row="@xpath=//*[@data-field='London_Brokerage']//following::tr[8]//td[contains(@ng-click,'London_Brokerage')][text()='20.00']";
				String LondonBrokerage9Row="@xpath=//*[@data-field='London_Brokerage']//following::tr[9]//td[contains(@ng-click,'London_Brokerage')][text()='5.00']";
				String LondonBrokerage10Row="@xpath=//*[@data-field='London_Brokerage']//following::tr[10]//td[contains(@ng-click,'London_Brokerage')][text()='0.00']";
				waitForElementToAppear(LondonBrokerage,5);
				mouseOverAction(LondonBrokerage);
				verifyMustExists(LondonBrokerage,"London Brokerage column");
				sleep(2000);
				verifyExists(LondonBrokerage1Row,"London Brokerage 1 Value");
				verifyExists(LondonBrokerage2Row,"London Brokerage 2 Value");
				verifyExists(LondonBrokerage3Row,"London Brokerage 3 Value");
				verifyExists(LondonBrokerage4Row,"London Brokerage 4 Value");
				verifyExists(LondonBrokerage5Row,"London Brokerage 5 Value");
				verifyExists(LondonBrokerage6Row,"London Brokerage 6 Value");
				verifyExists(LondonBrokerage7Row,"London Brokerage 7 Value");
				verifyExists(LondonBrokerage8Row,"London Brokerage 8 Value");
				verifyExists(LondonBrokerage9Row,"London Brokerage 9 Value");
				verifyExists(LondonBrokerage10Row,"London Brokerage 10 Value");
				sleep(2000); 
			}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
		}
	}

	public void financialCalculation_BrokeragePercent() throws Exception{	
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.navigationOnBordereauxTab();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			if(isVisible(DataLinkNoResult)==true)
			{
				Report.LogInfo("ValidateResult", "Result not display", "Fail");
			}
			else
			{
				selectRowNumberAscOrder();
				String BrokeragePercent1Row="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[1]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='5.00 %']";
				String BrokeragePercent2Row="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[2]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='5.00 %']";
				String BrokeragePercent3Row="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[3]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='0.00 %']";
				String BrokeragePercent4Row="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[4]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='0.00 %']";
				String BrokeragePercent5Row="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[5]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='5.00 %']";
				String BrokeragePercent6Row="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[6]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='5.00 %']";
				String BrokeragePercent7Row="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[7]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='5.00 %']";
				String BrokeragePercent8Row="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[8]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='0.00 %']";
				String BrokeragePercent9Row="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[9]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='5.00 %']";
				String BrokeragePercent10Row="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[10]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='0.00 %']";
				waitForElementToAppear(LondonBrokeragePercent,5);
				mouseOverAction(LondonBrokeragePercent);
				verifyMustExists(LondonBrokeragePercent,"London Brokerage percent column");
				sleep(2000);
				verifyExists(BrokeragePercent1Row,"London Brokerage percent 1 Value");
				verifyExists(BrokeragePercent2Row,"London Brokerage percent 2 Value");
				verifyExists(BrokeragePercent3Row,"London Brokerage percent 3 Value");
				verifyExists(BrokeragePercent4Row,"London Brokerage percent 4 Value");
				verifyExists(BrokeragePercent5Row,"London Brokerage percent 5 Value");
				verifyExists(BrokeragePercent6Row,"London Brokerage percent 6 Value");
				verifyExists(BrokeragePercent7Row,"London Brokerage percent 7 Value");
				verifyExists(BrokeragePercent8Row,"London Brokerage percent 8 Value");
				verifyExists(BrokeragePercent9Row,"London Brokerage percent 9 Value");
				verifyExists(BrokeragePercent10Row,"London Brokerage percent 10 Value");
				sleep(2000); 
			}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
		}
	}

	public void financialCalculation_FinalNetPremium() throws Exception{	
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.navigationOnBordereauxTab();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			if(isVisible(DataLinkNoResult)==true)
			{
				Report.LogInfo("ValidateResult", "Result not display", "Fail");
			}
			else
			{
				selectRowNumberAscOrder();
				String FinalNetPremium1Row="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[1]//td[contains(@ng-click,'Final_Net_Premium')][text()='-29.50']";
				String FinalNetPremium2Row="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[2]//td[contains(@ng-click,'Final_Net_Premium')][text()='-29.50']";
				String FinalNetPremium3Row="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[3]//td[contains(@ng-click,'Final_Net_Premium')][text()='-129.50']";
				String FinalNetPremium4Row="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[4]//td[contains(@ng-click,'Final_Net_Premium')][text()='-5.00']";
				String FinalNetPremium5Row="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[5]//td[contains(@ng-click,'Final_Net_Premium')][text()='1,460.15']";
				String FinalNetPremium6Row="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[6]//td[contains(@ng-click,'Final_Net_Premium')][text()='70.50']";
				String FinalNetPremium7Row="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[7]//td[contains(@ng-click,'Final_Net_Premium')][text()='95.00']";
				String FinalNetPremium8Row="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[8]//td[contains(@ng-click,'Final_Net_Premium')][text()='-20.00']";
				String FinalNetPremium9Row="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[9]//td[contains(@ng-click,'Final_Net_Premium')][text()='-29.50']";
				String FinalNetPremium10Row="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[10]//td[contains(@ng-click,'Final_Net_Premium')][text()='-24.50']";
				waitForElementToAppear(FinalNetPremium,5);
				mouseOverAction(FinalNetPremium);
				verifyMustExists(FinalNetPremium,"Final Net Premium column");
				sleep(2000);
				verifyExists(FinalNetPremium1Row,"Final Net Premium 1 Value");
				verifyExists(FinalNetPremium2Row,"Final Net Premium 2 Value");
				verifyExists(FinalNetPremium3Row,"Final Net Premium 3 Value");
				verifyExists(FinalNetPremium4Row,"Final Net Premium 4 Value");
				verifyExists(FinalNetPremium5Row,"Final Net Premium 5 Value");
				verifyExists(FinalNetPremium6Row,"Final Net Premium 6 Value");
				verifyExists(FinalNetPremium7Row,"Final Net Premium 7 Value");
				verifyExists(FinalNetPremium8Row,"Final Net Premium 8 Value");
				verifyExists(FinalNetPremium9Row,"Final Net Premium 9 Value");
				verifyExists(FinalNetPremium10Row,"Final Net Premium 10 Value");
				sleep(2000); 
			}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
		}
	}


	public void financialCalculationGrossPremium() throws Exception{
		String ExpectedFirstRow ="0.00";
		String ExpectedSecondRow ="5.00";
		String ExpectedThirdRow ="5.00";

		//loginPage.tideLogin();
		sleep(3000);
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.navigationOnBordereauxTab();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			//sleep(2000);
			if(isVisible(DataLinkNoResult)==true)
			{
				Report.LogInfo("ValidateResult", "Result not display", "Fail");
			}
			else{
				selectRowNumberAscOrder();
				verifyMustExists(TaxFirstRow,"TaxFirstRow");        
				//String ActualFirstRow = webDriver.findElement(By.xpath("//*[@id='grid']//tr[8]//td[48][@class='bgm-green']")).getText();
				String ActualFirstRow = getTextFrom(TaxFirstRow);
				sleep(2000);
				verifyMustExists(TaxSecondRow,"TaxSecondRow");
				//String ActualSecondRow = webDriver.findElement(By.xpath("//*[@id='grid']//tr[9]//td[48][@class='bgm-green']")).getText();
				String ActualSecondRow = getTextFrom(TaxSecondRow);
				sleep(2000);
				verifyMustExists(TaxThirdRow,"TaxThirdRow");
				//String ActualThirdRow = webDriver.findElement(By.xpath("//*[@id='grid']//tr[10]//td[48][@class='bgm-green']")).getText();
				String ActualThirdRow = getTextFrom(TaxThirdRow);
				sleep(2000);
				if(ActualFirstRow.equals(ExpectedFirstRow))
				{
					Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row from last three records validate successfully", "PASS"); 
				}
				else
				{
					Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row from last three records not validate successfully", "FAIL");
				}

				sleep(2000);
				if(ActualSecondRow.equals(ExpectedSecondRow))
				{
					Report.LogInfo("ValidateExpectedSecondRow", "Expected Second Row from last three records validate successfully", "PASS"); 
				}
				else
				{
					Report.LogInfo("ValidateExpectedSecondRow", "Expected Second Row from last three records not validate successfully", "FAIL");
				} 

				sleep(2000);
				if(ActualThirdRow.equals(ExpectedThirdRow))
				{
					Report.LogInfo("ValidateExpectedThirdRow", "Expected Third Row from last three records validate successfully", "PASS"); 
				}
				else
				{
					Report.LogInfo("ValidateExpectedThirdRow", "Expected Third Row from last three records not validate successfully", "FAIL");
				} 
			}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
		}
	}

	public void CoreFinancialCalculationValidationTax() throws Exception{
		String ExpectedFirstRow ="5.00 %";
		String ExpectedSecondRow ="5.00 %";
		String ExpectedThirdRow ="5.00 %";
		sleep(3000);
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.navigationOnBordereauxTab();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			//sleep(2000);
			if(isVisible(DataLinkNoResult)==true)
			{
				Report.LogInfo("ValidateResult", "Result not display", "Fail");
				policy.navigationOnBordereauxTab();
				deleteBorderEAUX();			   
			}else{
				selectRowNumberAscOrder();

				verifyMustExists(TaxPercentFirstRow,"TaxPercentFirstRow");
				//String ActualFirstRow = webDriver.findElement(By.xpath("//*[@id='grid']//tr[8]//td[49][@class='bgm-green']")).getText();
				String ActualFirstRow = getTextFrom(TaxPercentFirstRow);
				sleep(2000);
				verifyMustExists(TaxPercentSecondRow,"TaxPercentSecondRow");
				//String ActualSecondRow = webDriver.findElement(By.xpath("//*[@id='grid']//tr[9]//td[49][@class='bgm-green']")).getText();
				String ActualSecondRow = getTextFrom(TaxPercentSecondRow);
				sleep(2000);
				verifyMustExists(TaxPercentThirdRow,"TaxPercentSecondRow");
				//String ActualThirdRow = webDriver.findElement(By.xpath("//*[@id='grid']//tr[10]//td[49][@class='bgm-green']")).getText();
				String ActualThirdRow = getTextFrom(TaxPercentThirdRow);
				sleep(2000);
				if(ActualFirstRow.equals(ExpectedFirstRow))
				{
					Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row from last three records validate successfully", "PASS"); 
				}
				else
				{
					Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row from last three records not validate successfully", "FAIL");
				}
				sleep(2000);
				if(ActualSecondRow.equals(ExpectedSecondRow))
				{
					Report.LogInfo("ValidateExpectedSecondRow", "Expected Second Row from last three records validate successfully", "PASS"); 
				}
				else
				{
					Report.LogInfo("ValidateExpectedSecondRow", "Expected Second Row from last three records not validate successfully", "FAIL");
				} 
				sleep(2000);
				if(ActualThirdRow.equals(ExpectedThirdRow))
				{
					Report.LogInfo("ValidateExpectedThirdRow", "Expected Third Row from last three records validate successfully", "PASS"); 
				}
				else
				{
					Report.LogInfo("ValidateExpectedThirdRow", "Expected Third Row from last three records not validate successfully", "FAIL");
				} 

				policy.navigationOnBordereauxTab();
				deleteBorderEAUX();
			}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
			policy.navigationOnBordereauxTab();
			deleteBorderEAUX();
		}
	}

	public void ProcessBorderoWithDefaulstRisk_3429() throws Exception
	{
		String ExpectedFirstRow ="529.13";
		String ExpectedSecondRow ="529.13";
		String ExpectedFirstRowGross ="622.50";
		String ExpectedSecondRowGross ="622.50";		
		String ExpectedFirstRowCC ="62.25";
		String ExpectedSecondRowCC ="62.25";
		String ExpectedFirstRowNP ="560.25";
		String ExpectedSecondRowNP ="560.25";
		String ExpectedFirstRowLB ="31.13";
		String ExpectedSecondRowLB ="31.13";
		String FinalNetPremimumFirstRow = "@xpath=//*[@data-field='Final_Net_Premium']//following::tr[1]//td[contains(@ng-click,'Final_Net_Premium')]";
		String FinalNetPremimumSecondRow = "@xpath=//*[@data-field='Final_Net_Premium']//following::tr[2]//td[contains(@ng-click,'Final_Net_Premium')]";
		String GrossPremimumFirstRow = "@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][2]";
		String GrossPremimumSecondRow = "@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][2]";
		String CovCFirstRow = "@xpath=//*[@data-field='Coverholder_Commission']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission')][1]";
		String CovCSecondRow = "@xpath=//*[@data-field='Coverholder_Commission']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission')][1]";
		String NetPFirstRow = "@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][1]";
		String NetPSecondRow = "@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][1]";
		String LBFirstRow = "@xpath=//*[@data-field='London_Brokerage']//following::tr[1]//td[contains(@ng-click,'London_Brokerage')][1]";
		String LBSecondRow = "@xpath=//*[@data-field='London_Brokerage']//following::tr[2]//td[contains(@ng-click,'London_Brokerage')][1]";	
		String IncDate = "01/01/2017";
		String ExpDate = "01/01/2018";
		String subSheet = "SP - First Sheet (Automation Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String QueName = "Risk Order Tesing";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(QueName);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		policy.addPolicy2(IncDate,ExpDate);
		verifyExists(DraftBtn,"Draft Status Button");
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		//String pol="692166EX";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.EditCoverholder();
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3429Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3429.xlsx";
		} 

		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3429Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3429.xlsx\",\"UniqueFileName\":\"S67990220171106.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S67990220171106.xlsx\",\"Filesize\":23362,\"Path\":null,\"size\":23362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			sleep(2000);
			if(isVisible(DataLinkNoResult)==true)
			{
				Report.LogInfo("ValidateResult", "Result not display", "Fail");
				policy.navigationOnBordereauxTab();
				deleteBorderEAUX();			   
			}else{
				selectRowNumberAscOrder();
				if(isVisible(FinalNetPremimumFirstRow)==true){
					verifyMustExists(FinalNetPremimumFirstRow,"Final Net Premimum First Row");
					String ActualFirstRow = getTextFrom(FinalNetPremimumFirstRow,"Final Net Premimum FirstRow");
					sleep(2000);
					verifyMustExists(FinalNetPremimumSecondRow,"Final Net Premimum First Row");
					String ActualSecondRow = getTextFrom(FinalNetPremimumSecondRow,"Final Net Premimum FirstRow");
					sleep(2000);
					verifyMustExists(GrossPremimumFirstRow,"Gross Premimum First Row");
					String ActualFirstRowGross = getTextFrom(GrossPremimumFirstRow,"Gross Premimum First Row");
					sleep(2000);
					verifyMustExists(GrossPremimumSecondRow,"Gross Premimum First Row");
					String ActualSecondRowGross = getTextFrom(GrossPremimumSecondRow,"Gross Premimum FirstRow");
					sleep(2000);

					if(ActualFirstRow.equals(ExpectedFirstRow))
					{
						Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row record validate successfully", "PASS"); 
					}
					else
					{
						Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row record not validate successfully", "FAIL");
					}
					sleep(2000);
					if(ActualSecondRow.equals(ExpectedSecondRow))
					{
						Report.LogInfo("ValidateExpectedSecondRow", "Expected Second Row record validate successfully", "PASS"); 
					}
					else
					{
						Report.LogInfo("ValidateExpectedSecondRow", "Expected Second record not validate successfully", "FAIL");
					} 
					sleep(2000);
					if(ActualFirstRowGross.equals(ExpectedFirstRowGross))
					{
						Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row record validate successfully", "PASS"); 
					}
					else
					{
						Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row record not validate successfully", "FAIL");
					}
					sleep(2000);
					if(ActualSecondRowGross.equals(ExpectedSecondRowGross))
					{
						Report.LogInfo("ValidateExpectedSecondRow", "Expected Second Row record validate successfully", "PASS"); 
					}
					else
					{
						Report.LogInfo("ValidateExpectedSecondRow", "Expected Second record not validate successfully", "FAIL");
					} 

					verifyMustExists(CovCFirstRow,"Commission First Row");
					String ActualFirstRowCC = getTextFrom(CovCFirstRow,"Commission First Row");
					sleep(2000);
					verifyMustExists(CovCSecondRow,"Commission second Row");
					String ActualSecondRowCC = getTextFrom(CovCSecondRow,"Commission second Row");
					sleep(2000);

					if(ActualFirstRowCC.equals(ExpectedFirstRowCC))
					{
						Report.LogInfo("ValidateExpectedFirstRow", "Expected Commission First Row record validate successfully", "PASS"); 
					}
					else
					{
						Report.LogInfo("ValidateExpectedFirstRow", "Expected Commission First Row record not validate successfully", "FAIL");
					}
					sleep(2000);
					if(ActualSecondRowCC.equals(ExpectedSecondRowCC))
					{
						Report.LogInfo("ValidateExpectedSecondRow", "Expected Commission Second Row record validate successfully", "PASS"); 
					}
					else
					{
						Report.LogInfo("ValidateExpectedSecondRow", "Expected Commission Second record not validate successfully", "FAIL");
					} 

					verifyMustExists(NetPFirstRow,"Net Premium First Row");
					String ActualFirstRowNP = getTextFrom(NetPFirstRow,"Net Premium First Row");
					sleep(2000);
					verifyMustExists(NetPSecondRow,"Net Premium second Row");
					String ActualSecondRowNP = getTextFrom(NetPSecondRow,"Net Premium second Row");
					sleep(2000);

					if(ActualFirstRowNP.equals(ExpectedFirstRowNP))
					{
						Report.LogInfo("ValidateExpectedFirstRow", "Expected Net Premium First Row record validate successfully", "PASS"); 
					}
					else
					{
						Report.LogInfo("ValidateExpectedFirstRow", "Expected Net Premium First Row record not validate successfully", "FAIL");
					}
					sleep(2000);
					if(ActualSecondRowNP.equals(ExpectedSecondRowNP))
					{
						Report.LogInfo("ValidateExpectedSecondRow", "Expected Net Premium Second Row record validate successfully", "PASS"); 
					}
					else
					{
						Report.LogInfo("ValidateExpectedSecondRow", "Expected Net Premium Second record not validate successfully", "FAIL");
					} 

					verifyMustExists(LBFirstRow,"Brockerage First Row");
					String ActualFirstRowLB = getTextFrom(LBFirstRow,"Brockerage First Row");
					sleep(2000);
					verifyMustExists(LBSecondRow,"Brockerage second Row");
					String ActualSecondRowLB = getTextFrom(LBSecondRow,"Brockerage second Row");
					sleep(2000);

					if(ActualFirstRowLB.equals(ExpectedFirstRowLB))
					{
						Report.LogInfo("ValidateExpectedFirstRow", "Expected Net Premium First Row record validate successfully", "PASS"); 
					}
					else
					{
						Report.LogInfo("ValidateExpectedFirstRow", "Expected Net Premium First Row record not validate successfully", "FAIL");
					}
					sleep(2000);
					if(ActualSecondRowLB.equals(ExpectedSecondRowLB))
					{
						Report.LogInfo("ValidateExpectedSecondRow", "Expected Net Premium Second Row record validate successfully", "PASS"); 
					}
					else
					{
						Report.LogInfo("ValidateExpectedSecondRow", "Expected Net Premium Second record not validate successfully", "FAIL");
					}

					sleep(2000);
					policy.navigationOnBordereauxTab();
					deleteBorderEAUX();
				}else{
					Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row record not validate successfully", "FAIL");
					policy.navigationOnBordereauxTab();
					deleteBorderEAUX();
				}
			}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
			policy.navigationOnBordereauxTab();
			deleteBorderEAUX();
		}
	}

	public void ProcessBorderoWithRisk_3430() throws Exception
	{
		String ExpectedFirstRowRiskOrder ="100.00 %";
		String ExpectedSecondRowRiskOrder ="60.00 %";
		String ExpectedThirddRowRiskOrder ="80.00 %";

		String ExpectedFirstRowGrossPrem ="4,268.00";
		String ExpectedSecondRowGrossPrem ="53,130.00";
		//String ExpectedSecondRowGrossPrem ="106,260.00";
		String ExpectedThirddRowGrossPrem ="996.00";

		String ExpectedFirstRowCC ="426.80";
		String ExpectedSecondRowCC ="5,313.00";
		//String ExpectedSecondRowCC ="10,626.00";
		String ExpectedThirddRowCC ="99.60";

		String ExpectedFirstRowNP ="3,841.20";
		String ExpectedSecondRowNP ="47,817.00";
		//String ExpectedSecondRowNP ="95,634.00";
		String ExpectedThirddRowNP ="2,246.47";

		String subSheet = "SP - First Sheet (Automation Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String QueName = "Risk Order mapped field";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(QueName);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		applyFilterPolicy(policy.PolicyNumber);
		//applyFilterPolicy("327517ZY");
		openSelectedPolicy();
		policy.contractId = ReturnContractID();
		SubmitBordereaux(subSheet);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3430Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3430.xlsx";
		} 

		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3430Path); 
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3430.xlsx\",\"UniqueFileName\":\"S50832220180219.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S50832220180219.xlsx\",\"Filesize\":23607,\"Path\":null,\"size\":23607,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}                                                        ";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)== true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(2000);

			VerifyReferenceColumn();
			
			if(isVisible(EnrichedValueTxt)==true){
				verifyMustExists(EnrichedValueTxt,"Enriched Value textbox");
				sendKeys(EnrichedValueTxt, "60", "Enriched Value textbox");
				verifyMustExists(continuebtx,"Continue button");
				click(continuebtx, "Continue button");
				waitForElementToAppear(CanBtn,5);
				verifyMustExists(CanBtn,"Cancel button");
				click(CanBtn, "Cancel button");
				refreshUploadedFile();				
				openDATALink();
				//javaScriptclick(DATAlink,"Click on DATA link");
				navigateToDATARiskTab();
				sleep(2000);
				if(isVisible(DataLinkNoResult)==true)
				{
					Report.LogInfo("ValidateResult", "Result not display", "Fail");
					policy.navigationOnBordereauxTab();
					deleteBorderEAUX();			   
				}else{
					//selectRowNumberAscOrder();
					if(isVisible(RiskOrderFirstRow100)==true){
						verifyMustExists(RiskOrderFirstRow100,"Risk order First Row");
						String ActualFirstRowRO = getTextFrom(RiskOrderFirstRow100,"Risk order First Row");
						sleep(2000);
						verifyMustExists(RiskOrderSecondRow50,"Risk order second Row");
						String ActualSecondRowRO = getTextFrom(RiskOrderSecondRow50,"Risk order second Row");
						sleep(2000);
						verifyMustExists(RiskOrderThirdRow80,"Risk order Third Row");
						String ActualThirdRowRO = getTextFrom(RiskOrderThirdRow80,"Risk order Third Row");
						sleep(2000);

						if(ActualFirstRowRO.equals(ExpectedFirstRowRiskOrder))
						{
							Report.LogInfo("ValidateExpectedFirstRow", "Expected Risk order First Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedFirstRow", "Expected Risk order First Row record not validate successfully", "FAIL");
						}
						sleep(2000);
						if(ActualSecondRowRO.equals(ExpectedSecondRowRiskOrder))
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Risk order Second Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Risk order Second record not validate successfully", "FAIL");
						} 
						sleep(2000);
						if(ActualThirdRowRO.equals(ExpectedThirddRowRiskOrder))
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Risk order Third Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Risk order Third record not validate successfully", "FAIL");
						} 

						verifyMustExists(GrossPremFirstRow,"Gross Prem First Row");
						String ActualFirstRowGP = getTextFrom(GrossPremFirstRow,"Gross Prem First Row");
						sleep(2000);
						verifyMustExists(GrossPremSecondRow,"Gross Prem second Row");
						String ActualSecondRowGP = getTextFrom(GrossPremSecondRow,"Gross Prem second Row");
						sleep(2000);
						verifyMustExists(GrossPremThirdRow,"Gross Prem Third Row");
						String ActualThirdRowGP = getTextFrom(GrossPremThirdRow,"Gross Prem Third Row");
						sleep(2000);

						if(ActualFirstRowGP.equals(ExpectedFirstRowGrossPrem))
						{
							Report.LogInfo("ValidateExpectedFirstRow", "Expected Gross Prem First Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedFirstRow", "Expected Gross Prem First Row record not validate successfully", "FAIL");
						}
						sleep(2000);
						if(ActualSecondRowGP.equals(ExpectedSecondRowGrossPrem))
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Gross Prem Second Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Gross Prem Second record not validate successfully", "FAIL");
						} 
						sleep(2000);
						if(ActualThirdRowGP.equals(ExpectedThirddRowGrossPrem))
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Gross Prem Third Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Gross Prem Third record not validate successfully", "FAIL");
						} 

						verifyMustExists(CCFirstRow,"Commission First Row");
						String ActualFirstRowCC = getTextFrom(CCFirstRow,"Commission First Row");
						sleep(2000);
						verifyMustExists(CCSecondRow,"Commission second Row");
						String ActualSecondRowCC = getTextFrom(CCSecondRow,"Commission second Row");
						sleep(2000);
						verifyMustExists(CCThirdRow,"Commission Third Row");
						String ActualThirdRowCC = getTextFrom(CCThirdRow,"Commission Third Row");
						sleep(2000);

						if(ActualFirstRowCC.equals(ExpectedFirstRowCC))
						{
							Report.LogInfo("ValidateExpectedFirstRow", "Expected Commission First Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedFirstRow", "Expected Commission First Row record not validate successfully", "FAIL");
						}
						sleep(2000);
						if(ActualSecondRowCC.equals(ExpectedSecondRowCC))
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Commission Second Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Commission Second record not validate successfully", "FAIL");
						} 
						sleep(2000);
						if(ActualThirdRowCC.equals(ExpectedThirddRowCC))
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Commission Third Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Commission Third record not validate successfully", "FAIL");
						} 

						verifyMustExists(NPFirstRow,"Net Premium First Row");
						String ActualFirstRowNP = getTextFrom(NPFirstRow,"Net Premium First Row");
						sleep(2000);
						verifyMustExists(NPSecondRow,"Net Premium second Row");
						String ActualSecondRowNP = getTextFrom(NPSecondRow,"Net Premium second Row");
						sleep(2000);
						verifyMustExists(NPThirdRow,"Net Premium Third Row");
						String ActualThirdRowNP = getTextFrom(NPThirdRow,"Net Premium Third Row");
						sleep(2000);

						if(ActualFirstRowNP.equals(ExpectedFirstRowNP))
						{
							Report.LogInfo("ValidateExpectedFirstRow", "Expected Commission First Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedFirstRow", "Expected Commission First Row record not validate successfully", "FAIL");
						}
						sleep(2000);
						if(ActualSecondRowNP.equals(ExpectedSecondRowNP))
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Commission Second Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Commission Second record not validate successfully", "FAIL");
						} 
						sleep(2000);
						if(ActualThirdRowNP.equals(ExpectedThirddRowNP))
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Commission Third Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Commission Third record not validate successfully", "FAIL");
						} 

						verifyExists(FNPFirstRow,"FNP First Row");
						verifyExists(FNPSecondRow,"FNP Second Row");
						verifyExists(FNPThirdRow,"FNP Third Row");

						sleep(2000);

					}else{
						Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row record not validate successfully", "FAIL");
						policy.navigationOnBordereauxTab();
						deleteBorderEAUX();
					}
				}
				//deleteBorderEAUX();

			}else{
				Report.LogInfo("ErrorScreen", "Expected error screen not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}		

	}

	//===========================================================YOA Sheet Processing===============================================================//

	public void yoaSheetProcessing_3754() throws Exception
	{
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		String ExpectedRow="USD";
		String IncDate = "01/01/2017";
		String subSheet = "YOA and Currency Auto Map (Automation Schema)";
		String ExpDate="31/12/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.addPolicy2(IncDate, ExpDate);

		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		applyFilterPolicy(policy.PolicyNumber);
		//applyFilterPolicy("913035BD");
		openSelectedPolicy();
		policy.contractId = ReturnContractID();
		SubmitBordereaux(subSheet);	

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3754Path = fpath+"\\src\\test\\resources\\testdata\\YOA_Currency_TC3754.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3754Path);  

		String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"YOA_Currency_TC3754.xlsx\",\"UniqueFileName\":\"S98715220180004.xlsx\",\"BordereauFormatId\":\"3a683cf5-3960-45ce-a2d4-cfc02977d62b\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S98715220180004.xlsx\",\"Filesize\":19040,\"Path\":null,\"size\":19040,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			if(isVisible(tidevaluedropdown)== true){
				verifyMustExists(tidevaluedropdown,"Tide value drop down");
				click(tidevaluedropdown,"Tide value drop down");
				javaScriptWait();
				verifyMustExists(tidevalueUSD,"USD dropdown value");	
				click(tidevalueUSD,"USD dropdown value");
				verifyMustExists(continuebtx,"Continue button");
				click(continuebtx,"Continue button");
				waitForElementToAppear(tidevaluedropdown,5);
				verifyMustExists(tidevaluedropdown,"Tide value drop down");

				verifyMustExists(continuebtx,"Continue button");
				click(continuebtx,"Continue button");
				waitForElementToAppear(Cancelbtn1,10);
				verifyMustExists(Cancelbtn1,"Cancel button");
				click(Cancelbtn1,"Cancel button");
				refreshUploadedFile();
				waitForElementToAppear(ReviewBtn,10);
				if(isVisible(ReviewBtn)==true){
					Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
					deleteBorderEAUX();
				}
				else{
					Report.LogInfo("ReviewStatusValidation", "Review Status Button not Displayed", "FAIL");
				}	
			}			
			else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}	

	}




	/*****************************************************************/

	//3714 Use set number of left characters from Risk Reference
	public void useLeftCharactersRiskReference() throws Exception
	{
		String IncDate = "01/01/2017";
		String ExpDate="01/01/2018";
		String subSheet = "Step-4 Bordereau format (Automation Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		//loginPage.tideLogin();
		policy.addPolicy2(IncDate, ExpDate);
		//policy.addPolicy1(IncDate);
		System.out.println(policy.PolicyNumber);
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		verifyExists(DraftBtn,"Draft Status Button");
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		waitForElementToAppear(SignedBtn,8);
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");
			SubmitBordereaux(subSheet); 

			/*applyFilterPolicy("581870RT");
	   openSelectedPolicy();
	   policy.navigationOnBordereauxTab();*/
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3714Path = fpath+"\\src\\test\\resources\\testdata\\UseLeftCharactersRiskReference_3714.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//StringSelection IdentificationSheet = new StringSelection(sheet3451Path);
			//UploadFile(IdentificationSheet);
			File excelFile = new File(sheet3714Path);  
			policy.contractId = addNewBordereauFormatPolicy(payload1, GetData); 
			System.out.println(policy.contractId);
			String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"UseLeftCharactersRiskReference_3714.xlsx\",\"UniqueFileName\":\"S32755420171113.xlsx\",\"BordereauFormatId\":\"8bc73d12-4d7a-4844-9489-58a2ab196f34\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S32755420171113.xlsx\",\"Filesize\":21008,\"Path\":null,\"size\":21008,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(isVisible(ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				openDATALink();
				navigateToDATARiskTab();
				selectRowNumberAscOrder();
				//Locators
				String RiskReferenceColumn ="@xpath=//*[@data-field='RiskReference']";
				String RiskReference1 ="@xpath=//*[@data-field='RiskReference']//following::tr[1]//td[contains(@ng-click,'RiskReference')]";
				String RiskReference2 ="@xpath=//*[@data-field='RiskReference']//following::tr[2]//td[contains(@ng-click,'RiskReference')]";
				String RiskReference3 ="@xpath=//*[@data-field='RiskReference']//following::tr[3]//td[contains(@ng-click,'RiskReference')]";
				String RiskReference4 ="@xpath=//*[@data-field='RiskReference']//following::tr[4]//td[contains(@ng-click,'RiskReference')]";
				String RiskReference5 ="@xpath=//*[@data-field='RiskReference']//following::tr[5]//td[contains(@ng-click,'RiskReference')]";
				String RiskReference6 ="@xpath=//*[@data-field='RiskReference']//following::tr[6]//td[contains(@ng-click,'RiskReference')]";
				String RiskReference7 ="@xpath=//*[@data-field='RiskReference']//following::tr[7]//td[contains(@ng-click,'RiskReference')]";
				String RiskReference8 ="@xpath=//*[@data-field='RiskReference']//following::tr[8]//td[contains(@ng-click,'RiskReference')]";
				String RiskReference9 ="@xpath=//*[@data-field='RiskReference']//following::tr[9]//td[contains(@ng-click,'RiskReference')]";
				String RiskReference10 ="@xpath=//*[@data-field='RiskReference']//following::tr[10]//td[contains(@ng-click,'RiskReference')]";
				waitForElementToAppear(RiskReferenceColumn,20);
				mouseOverAction(RiskReferenceColumn);
				verifyMustExists(RiskReferenceColumn,"Risk Reference Column");
				sleep(2000);

				List<WebElement> YearOfAccount = webDriver.findElements(By.xpath("//*[@data-field='BordereauYear']//following::td[contains(@ng-click,'BordereauYear')][text()='2017']"));
				sleep(2000);
				if(YearOfAccount.size() == 10)
				{
					Report.LogInfo("YearOfAccount", "Year Of Account is Displayed properly", "PASS");
				}
				else
				{
					Report.LogInfo("YearOfAccount", "Year Of Account is Displayed wrong", "FAIL");
				}
				sleep(1000);

				verifyExists(RiskReference1,"1st value");
				verifyExists(RiskReference2,"2nd value");
				verifyExists(RiskReference3,"3rd value");
				verifyExists(RiskReference4,"4th value");
				verifyExists(RiskReference5,"5th value");
				verifyExists(RiskReference6,"6th value");
				verifyExists(RiskReference7,"7th value");
				verifyExists(RiskReference8,"8th value");
				verifyExists(RiskReference9,"9th value");
				verifyExists(RiskReference10,"10th value");
				sleep(1000);
				click(RiskReference1,"1st field ");
				waitForElementToAppear(Okbtn,10);
				verifyExists(RuleNameField,"Rule Name Field");
				verifyExists(OriginalValue,"Original Value Field");
				verifyExists(ChangedValue,"Changed Value Field");
				click(Okbtn,"ok Buttton");
				sleep(3000);
				policy.navigationOnBordereauxTab();
				refreshUploadedFile();
				deleteBorderEAUX();
			}else{
				Report.LogInfo("reviewbuttonvalidation", "review Button not Displayed", "FAIL");
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}
	//3717 Delete rows based on single column being blank
	public void deleteRowsBasedSingleColumn() throws Exception
	{
		HomePage homePage = new HomePage();
		BordereauQuePage bordereauQue = new BordereauQuePage();
		String IncDate = "01/01/2017";
		String subSheet = "Step-4 Bordereau format (Automation Schema)";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		waitForElementToAppear(SignedBtn,8);
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");
			SubmitBordereaux(subSheet);	
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			//String GetData = Configuration.url+"/api/Contract/GetAllPage";
			//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\"581870RT\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3717Path = fpath+"\\src\\test\\resources\\testdata\\DeleteRowsBasedSingleColumn_3717.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//StringSelection IdentificationSheet = new StringSelection(sheet3451Path);
			//UploadFile(IdentificationSheet);
			File excelFile = new File(sheet3717Path); 
			//policy.contractId = addNewBordereauFormatPolicy(payload1, GetData);
			//System.out.println(policy.contractId);b3ebed40-e04b-4e86-a161-1fbf413669e2
			String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"DeleteRowsBasedSingleColumn_3717.xlsx\",\"UniqueFileName\":\"S34446720180303.xlsx\",\"BordereauFormatId\":\"851cf3ce-e0e2-4126-90c2-6d0dd3fcba1a\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S34446720180303.xlsx\",\"Filesize\":20536,\"Path\":null,\"size\":20536,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"DeleteRowsBasedSingleColumn_3717.xlsx\",\"UniqueFileName\":\"S38813920171114.xlsx\",\"BordereauFormatId\":\"784602cb-d234-4d73-8ebf-b002b98832a9\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S38813920171114.xlsx\",\"Filesize\":21005,\"Path\":null,\"size\":21005,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(isVisible(ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				openDATALink();
				navigateToDATARiskTab();
				List<WebElement> RowCount = webDriver.findElements(By.xpath("//*[@data-field='RowNumber']//following::tr"));
				sleep(2000);
				if(RowCount.size() == 9)
				{
					Report.LogInfo("RowCount", "Row Count is Displayed properly", "PASS");
				}
				else
				{
					Report.LogInfo("RowCount", "Row Count is Displayed wrong", "FAIL");
				}
				sleep(1000);
				policy.navigationOnBordereauxTab();
				refreshUploadedFile();
				deleteBorderEAUX();
				//String VerifyVersion1 ="@xpath=//*[@id='content']//td[contains(.,'Step-4 Bordereau format')]//following-sibling::td[1]";
				String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'Step-4 Bordereau format')][1]";
				homePage.adminMenu();
				bordereauQue.bordereauQueLink();
				bordereauQue.filterBordereauQuestionnaire("Step-4 Bordereau format",SelectQuestionnaire);
				sleep(3000);
				verifyMustExists(bordereauQue.EditBtn,"Edit button");
				click(bordereauQue.EditBtn,"Edit button");
				sleep(2000);
				bordereauQue.nextStapeClick();
				bordereauQue.nextStapeClick();
				sleep(2000);
				JavascriptExecutor jse = (JavascriptExecutor)webDriver;
				jse.executeScript("scroll(0, 250);");
				WebElement RiskTextbox = webDriver.findElement(By.xpath("//*[@id='DiscardRisk_taglist']/following-sibling::input"));
				sleep(1000);
				Actions a = new Actions(webDriver);
				sleep(1000);
				a.click(RiskTextbox).build().perform();
				a.sendKeys(RiskTextbox, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE).build().perform();
				//a.sendKeys(RiskTextbox, Keys.BACK_SPACE).build().perform();
				sleep(1000);
				//click(ClearValues,"Clear Values (X) icon");
				//sleep(1000);
				click(RiskTxt,"Risk textbox");
				sleep(1000);
				click(NewOrRenewal,"New or Renewal");
				sleep(1000);
				click(RiskTxt,"Risk textbox");	
				sleep(1000);
				click(NoStories,"No. Stories");
				sleep(2000);
				bordereauQue.nextStapeClick();
				bordereauQue.FormatId = ReturnFormatID();
				verifyMustExists(bordereauQue.CancelBtn,"Cancel button");
				click(bordereauQue.CancelBtn,"Cancel button");

			}

			else
			{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
				deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}

	//3719 Delete rows based on multiple columns being blank
	public void deleteRowsBasedMultipleColumn() throws Exception
	{
		HomePage homePage = new HomePage();
		BordereauQuePage bordereauQue = new BordereauQuePage();
		String subSheet = "Step-4 Bordereau format (Automation Schema)";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		waitForElementToAppear(SignedBtn,8);
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");
			policy.navigationOnBordereauxTab();
			SubmitBordereaux(subSheet);	

			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			//String GetData = Configuration.url+"/api/Contract/GetAllPage";
			//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\"581870RT\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3719Path = fpath+"\\src\\test\\resources\\testdata\\DeleteRowsBasedMultipleColumn_3719.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			File excelFile = new File(sheet3719Path);
			//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"DeleteRowsBasedMultipleColumn_3719.xlsx\",\"UniqueFileName\":\"S53956220180303.xlsx\",\"BordereauFormatId\":\""+bordereauQue.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S53956220180303.xlsx\",\"Filesize\":20526,\"Path\":null,\"size\":20526,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"DeleteRowsBasedMultipleColumn_3719.xlsx\",\"UniqueFileName\":\"S70767720180303.xlsx\",\"BordereauFormatId\":\"3f6e606b-c50a-4c06-88db-d6e977df01ca\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S70767720180303.xlsx\",\"Filesize\":20532,\"Path\":null,\"size\":20532,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";			
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(isVisible(ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				openDATALink();
				navigateToDATARiskTab();
				//Locators
				String RiskReferenceColumn ="@xpath=//*[@data-field='RiskReference']";
				String RiskReference1 ="@xpath=//*[@data-field='RiskReference']//following::tr[1]//td[contains(@ng-click,'RiskReference')][text()='11']";
				String RiskReference2 ="@xpath=//*[@data-field='RiskReference']//following::tr[2]//td[contains(@ng-click,'RiskReference')][text()='22']";
				String RiskReference3 ="@xpath=//*[@data-field='RiskReference']//following::tr[3]//td[contains(@ng-click,'RiskReference')][text()='33']";
				String RiskReference4 ="@xpath=//*[@data-field='RiskReference']//following::tr[4]//td[contains(@ng-click,'RiskReference')][text()='36']";
				String RiskReference5 ="@xpath=//*[@data-field='RiskReference']//following::tr[5]//td[contains(@ng-click,'RiskReference')][text()='44']";
				String RiskReference6 ="@xpath=//*[@data-field='RiskReference']//following::tr[6]//td[contains(@ng-click,'RiskReference')][text()='55']";
				String RiskReference7 ="@xpath=//*[@data-field='RiskReference']//following::tr[7]//td[contains(@ng-click,'RiskReference')][text()='66']";
				String RiskReference8 ="@xpath=//*[@data-field='RiskReference']//following::tr[8]//td[contains(@ng-click,'RiskReference')][text()='77']";
				String RiskReference9 ="@xpath=//*[@data-field='RiskReference']//following::tr[9]//td[contains(@ng-click,'RiskReference')][text()='88']";
				waitForElementToAppear(RiskReferenceColumn,20);
				sleep(2000);
				mouseOverAction(RiskReferenceColumn);
				verifyMustExists(RiskReferenceColumn,"Risk Reference Column");
				sleep(2000);
				verifyExists(RiskReference1,"1st value");
				verifyExists(RiskReference2,"2nd value");
				verifyExists(RiskReference3,"3rd value");
				verifyExists(RiskReference4,"4th value");
				verifyExists(RiskReference5,"5th value");
				verifyExists(RiskReference6,"6th value");
				verifyExists(RiskReference7,"7th value");
				verifyExists(RiskReference8,"8th value");
				verifyExists(RiskReference9,"9th value");
				sleep(1000);
				policy.navigationOnBordereauxTab();
				refreshUploadedFile();
				deleteBorderEAUX();
				String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'Step-4 Bordereau format')][1]";
				homePage.adminMenu();
				bordereauQue.bordereauQueLink();
				bordereauQue.filterBordereauQuestionnaire("Step-4 Bordereau format",SelectQuestionnaire);
				sleep(3000);
				verifyMustExists(bordereauQue.EditBtn,"Edit button");
				click(bordereauQue.EditBtn,"Edit button");
				sleep(2000);
				bordereauQue.nextStapeClick();
				bordereauQue.nextStapeClick();
				sleep(2000);
				JavascriptExecutor jse = (JavascriptExecutor)webDriver;
				jse.executeScript("scroll(0, 250);");
				WebElement RiskTextbox = webDriver.findElement(By.xpath("//*[@id='DiscardRisk_taglist']/following-sibling::input"));
				sleep(1000);
				Actions a = new Actions(webDriver);
				sleep(1000);
				a.click(RiskTextbox).build().perform();
				a.sendKeys(RiskTextbox, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE).build().perform();
				sleep(1000);
				click(RiskTxt,"Risk textbox");
				sleep(1000);
				click(PolicyNum,"Policy Number");
				bordereauQue.nextStapeClick();
				verifyMustExists(bordereauQue.CancelBtn,"Cancel button");
				click(bordereauQue.CancelBtn,"Cancel button");
			}else{
				Report.LogInfo("reviewbuttonvalidation", "review Button not Displayed", "FAIL");
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}	
	}

	//3727 Risk Bordereaux Currency based on Contract Currency lookup
	public void riskBordereauxonContractCurrencyLookup() throws Exception
	{
		HomePage homePage = new HomePage();
		BordereauQuePage bordereauQue = new BordereauQuePage();

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		//policy.navigationOnBordereauxTab();
		String subSheet = "Contract currency lookup (Automation Schema)";
		waitForElementToAppear(SignedBtn,5);
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");
			policy.navigationOnBordereauxTab();
			SubmitBordereaux(subSheet);
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			try
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3727Path = fpath+"\\src\\test\\resources\\testdata\\Currency_Contract_Lookup_3727.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			File excelFile = new File(sheet3727Path);
			String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Currency_Contract_Lookup_3727.xlsx\",\"UniqueFileName\":\"S73227520180216.xlsx\",\"BordereauFormatId\":\"e0a54385-b3dd-4183-834e-5f99227e4b2d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S73227520180216.xlsx\",\"Filesize\":18605,\"Path\":null,\"size\":18605,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(isVisible(ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				openDATALink();
				navigateToDATARiskTab();
				String PremiumCurrencyColumn ="@xpath=//*[@data-field='Premium_Currency']";
				waitForElementToAppear(PremiumCurrencyColumn, 20);
				mouseOverAction(PremiumCurrencyColumn);
				sleep(2000);
				List<WebElement> PremiumCurrency = webDriver.findElements(By.xpath("//*[@id='notification']//following::td[contains(@ng-click,'Premium_Currency')][text()='GBP']"));
				sleep(2000);
				if(PremiumCurrency.size() == 5)
				{
					Report.LogInfo("PremiumCurrency", "Premium Currency is Displayed properly", "PASS");
				}
				else
				{
					Report.LogInfo("PremiumCurrency", "Premium Currency is Displayed wrong", "FAIL");
				}
				sleep(1000);	
				String GrossPremium ="@xpath=//th[text()='Gross Premium']";
				String NetPremium ="@xpath=//th[text()='Net Premium']";
				mouseOverAction(GrossPremium);
				List<WebElement> RiskCurrency = webDriver.findElements(By.xpath("//*[@id='notification']//following::td[contains(@ng-click,'Risk_Currency')][text()='GBP']"));
				sleep(2000);
				if(RiskCurrency.size() == 5)
				{
					Report.LogInfo("RiskCurrency", "Risk Currency is Displayed properly", "PASS");
				}
				else
				{
					Report.LogInfo("RiskCurrency", "Risk Currency is Displayed wrong", "FAIL");
				}
				sleep(1000);	
				policy.navigationOnBordereauxTab();
				refreshUploadedFile();
				deleteBorderEAUX();
			}else{
				Report.LogInfo("reviewbuttonvalidation", "review Button not Displayed", "FAIL");
			}
		}
		else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}

	}

	//3728 Advanced Options
	public void advancedOption() throws Exception
	{
		String SubmitSheet="Inherit from above";
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
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		String subSheet = "Inherit from above (Automation Schema)";
		waitForElementToAppear(SignedBtn,8);
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");
			SubmitBordereaux(subSheet);
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			try
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3728Path = fpath+"\\src\\test\\resources\\testdata\\Period_of_cover_3728.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//StringSelection IdentificationSheet = new StringSelection(sheet3451Path);
			//UploadFile(IdentificationSheet);
			File excelFile = new File(sheet3728Path);
			String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Period_of_cover_3728.xlsx\",\"UniqueFileName\":\"S70690020180303.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S70690020180303.xlsx\",\"Filesize\":18554,\"Path\":null,\"size\":18554,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Period_of_cover_3728.xlsx\",\"UniqueFileName\":\"S35146320180303.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S35146320180303.xlsx\",\"Filesize\":18019,\"Path\":null,\"size\":18019,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(isVisible(ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				openDATALink();
				navigateToDATARiskTab();
				//Gross Premium locators
				String GrossPremiumColumn ="@xpath=//*[@data-field='Gross_Premium']";
				String GrossPremium1 ="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][2][text()='100.00']";
				String GrossPremium2 ="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][2][text()='100.00']";
				String GrossPremium3 ="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium')][2][text()='100.00']";
				String GrossPremium4 ="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium')][2][text()='100.00']";
				String GrossPremium5 ="@xpath=//*[@data-field='Gross_Premium']//following::tr[5]//td[contains(@ng-click,'Gross_Premium')][2][text()='100.00']";
				waitForElementToAppear(GrossPremiumColumn,8);
				mouseOverAction(GrossPremiumColumn);
				verifyMustExists(GrossPremiumColumn,"Gross Premium Column");
				sleep(2000);
				verifyExists(GrossPremium1,"1st value");
				verifyExists(GrossPremium2,"2nd value");
				verifyExists(GrossPremium3,"3rd value");
				verifyExists(GrossPremium4,"4th value");
				verifyExists(GrossPremium5,"5th value");
				sleep(2000);
				String TransationType2Row ="@xpath=//*[@data-field='Transaction_Type']//following::tr[2]//td[contains(@ng-click,'Transaction_Type')]";
				waitForElementToAppear(TransationType2Row,8);
				verifyExists(TransationType2Row,"Renewal value");
				verifyBackground(TransationType2Row,"rgba(0, 97, 0, 1)");
				sleep(2000);
				click(TransationType2Row,"Transation Type");
				String TransactionTypePopUp="@xpath=//*[@name='form.Enrichment']/preceding-sibling::h2";
				String RuleNameField="@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[6]";
				String OKbtn="@xpath=//*[@ng-click='cancel()']";
				if(isVisible(TransactionTypePopUp)== true){
					Report.LogInfo("ValidateTransactionType","TransactionType pop Up displayed", "PASS");
					waitForElementToAppear(RuleNameField,8);
					verifyMustExists(RuleNameField,"Rule Name Field");
					verifyMustExists(OKbtn,"Ok Button");
					click(OKbtn,"Ok Button");
					sleep(2000);	
				}else{
					Report.LogInfo("ValidateTransactionType","TransactionType pop Up not displayed", "Fail");	
				}
				//Net Premium locators
				String NetPremiumColumn ="@xpath=//*[@data-field='Gross_Premium']";
				String NetPremium1 ="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][1][text()='212.10']";
				String NetPremium2 ="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][1][text()='326.80']";
				String NetPremium3 ="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][1][text()='8,755.00']";
				String NetPremium4 ="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][1][text()='9,765.20']";
				String NetPremium5 ="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][1][text()='24.50']";
				waitForElementToAppear(NetPremiumColumn,8);
				mouseOverAction(NetPremiumColumn);
				verifyMustExists(NetPremiumColumn,"Net Premium Column");
				sleep(2000);
				verifyExists(NetPremium1,"1st value");
				verifyBackground(NetPremium1,"rgba(0, 97, 0, 1)");
				sleep(2000);
				click(NetPremium1,"Net Premium 1 value");
				String NetPremiumPopUp="@xpath=//*[@name='form.Enrichment']/preceding-sibling::h2";
				if(isVisible(NetPremiumPopUp)== true){
					Report.LogInfo("ValidateTransactionType","TransactionType pop Up displayed", "PASS");
					waitForElementToAppear(RuleNameField,8);
					verifyMustExists(RuleNameField,"Rule Name Field");
					verifyMustExists(OKbtn,"Ok Button");
					click(OKbtn,"Ok Button");
					sleep(2000);	
				}else{
					Report.LogInfo("ValidateTransactionType","TransactionType pop Up not displayed", "Fail");	
				}
				policy.navigationOnBordereauxTab();
				refreshUploadedFile();
				deleteBorderEAUX();
			}else{
				Report.LogInfo("reviewbuttonvalidation", "review Button not Displayed", "FAIL");
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}
	
	public void MultiContractbordereaux_TC5282() throws Exception
	{
		BProcessingRiskPremiumClaimPage BPRiskandPreClaim = new BProcessingRiskPremiumClaimPage();
		BordereauProcessPage BorProc = new  BordereauProcessPage();
			  String UniqueReferenceVal1 = "Automation 0145"+getCurrentDateTimeMS();
			  String UniqueReferenceVal2 = "Automation 0142"+getCurrentDateTimeMS();
			  String IncDate = "01/01/2017";
			  String ExpDate="31/12/2017";
			  String IncDate1 = "01/01/2018";
			  String ExpDate1="31/12/2018";
			  String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			  String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			  String subSheet = "SP - First Sheet";
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
			  policy.navigationOnPolicyTab();
			  policy.navigationOnAddContractPage();
			  policy.navigationOnSelectPolicyPopUp();
			  policy.navigationOnAddPolicyPopUp();
			  policy.addContractBinderDetails();
			  policy.addPolicyContractDetails1(UniqueReferenceVal1, IncDate,ExpDate, Status1, policy.Broker1, policy.Bline1, policy.Underline1);
			  waitForElementToAppear(DraftBtn,5);
			  verifyExists(DraftBtn,"Draft Status Button");
			  policy.changeStatusToQuote();
			  policy.contractId = ReturnContractID();
			  policy.changeStatusToWritten();
			  policy.changeStatusToSigned();
			  applyFilterPolicy(policy.PolicyNumber);
			  openSelectedPolicy();
			  policy.addSection2("Section_2_17","10","Property D&F (US binder)","GBP - British Pound","10","10","10","Low");
			  policy.navigateToSectionTab2();
			  policy.navigateToRiskCodesTabOnSection();
			  policy.addRiskCodesOnSection2("D8 - Transactional Liability insurance Incl. US","100");
			  policy.navigateToMarketsTabOnSection();
			  policy.addMarketOnSection();
			  policy.navigateToContractDetailsTab();
			  waitForElementToAppear(MainEditdot,3);
			  verifyMustExists(MainEditdot,"Edit dot");
			  click(MainEditdot,"Edit dot");
			  waitForElementToAppear(CreateContract,3);
			  verifyMustExists(CreateContract,"Create Contract");
			  click(CreateContract,"Create Contract");
			  sleep(2000);
			  policy.addPolicyContractDetails1(UniqueReferenceVal2, IncDate1,ExpDate1, Status1, policy.Broker1, policy.Bline1, policy.Underline1);
			  waitForElementToAppear(DraftBtn,5);
			  verifyExists(DraftBtn,"Draft Status Button");
			  policy.changeStatusToQuote();
			  policy.changeStatusToWritten();
			  policy.changeStatusToSigned();
			  scrollUp();
			  policy.addSection2("Section_2_18","10","Property D&F (US binder)","GBP - British Pound","10","10","10","Low");
			  policy.navigateToRiskCodesTabOnSection();
			  policy.addRiskCodesOnSection2("2T - OVERSEAS LEG TERRORISM AVIATION","100");
			  policy.navigateToMarketsTabOnSection();
			  policy.addMarketOnSection();
			 
			//  policy.navigationOnBordereauxTab();
			 
					//FilterPolicyLast();
				applyFilterPolicy(policy.PolicyNumber);
				openSelectedPolicy();
				SubmitBordereaux(subSheet);
				String payload  ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017 - Copy_TC5282.xlsx\",\"UniqueFileName\":\"S13412120180226.xlsx\",\"BordereauFormatId\":\"e1f3d92f-bd74-4e8a-b3c2-2eb5f4d3bb9c\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S13412120180226.xlsx\",\"Filesize\":25537,\"Path\":null,\"size\":25537,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					SheetPath5282 = fpath+"\\src\\test\\resources\\testdata\\January 2017 - Copy_TC5282.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//StringSelection LastSheet = new StringSelection(lastSheetPath);
				//UploadFile(LastSheet);
				File excelFile = new File(SheetPath5282);
				uploadFile(ReqUrl, excelFile, payload, DraftUrl);

				refreshUploadedFile();
				if(checkErrorReviewButton(ReviewError)== true)
				{
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
					sleep(2000);
					if(isVisible(TransformationErrorScreen)== true){
					    Report.LogInfo("ValidateExpectedScreen", "Expected Error Screen Displayed", "PASS");
					    verifyMustExists(TransformationErrorScreen,"Transformation Error Screen");
					    waitForElementToAppear(YesBtn,3);
					    click(YesBtn,"Yes Radio button");
					    sleep(2000);
					    waitForElementToAppear(ContinueProcessingBodrBtn,3);
					    verifyMustExists(ContinueProcessingBodrBtn,"Continue Processing Bordereau");
					    click(ContinueProcessingBodrBtn,"Continue Processing Bordereau");
					    refreshUploadedFile();
					}
					if(isVisible(ReviewBtn)==true){
						Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
						click(ReviewBtn,"Review Button");
						sleep(3000);
						waitForElementToAppear(SuRcdAssmnt,10);
						verifyMustExists(SuRcdAssmnt,"Submit recor for Assignment button");
						click(SuRcdAssmnt,"Submit recor for Assignment button");
						sleep(2000);
						if(isVisible(SectionAssignmentRuleScreenFor2017)==true){
							Report.LogInfo("ValidateScreen", "Expected screen page displayed.", "PASS");			
							SelectDropDownValue(BPRiskandPreClaim.BordereauAssignmentSectionDropDwn,BPRiskandPreClaim. BordereauAssignmentSectionDropDwnOption);
							BPRiskandPreClaim.SetMapping("Risk Reference");
							SelectDropDownValue(SectionIdDropDwn1,SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn2,SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn3,SectionIdDropDwnOption2);
							SelectDropDownValue(SectionIdDropDwn4,SectionIdDropDwnOption2);
							SelectDropDownValue(SectionIdDropDwn5,SectionIdDropDwnOption2);
							click(BPRiskandPreClaim.CompleteAssignmentBtn,"Complete Assignment button");
							sleep(2000);//
							SelectDropDownValue(BPRiskandPreClaim.BordereauAssignmentSectionDropDwn,BordereauAssignmentSectionDropDwnOptionRiskCode);
							BPRiskandPreClaim.SetMapping("Risk Reference");
							scrollDown();
							SelectDropDownValue(SectionIdDropDwn1Risk1,BPRiskandPreClaim.SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn1Risk2,BPRiskandPreClaim.SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn1Risk3,BPRiskandPreClaim.SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn1Risk4,BPRiskandPreClaim.SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn1Risk5,BPRiskandPreClaim.SectionIdDropDwnOption1);
							click(BPRiskandPreClaim.CompleteAssignmentBtn,"Complete Assignment button");
							sleep(2000);
							SelectDropDownValue(BPRiskandPreClaim.BordereauAssignmentSectionDropDwn,BPRiskandPreClaim. BordereauAssignmentSectionDropDwnOption);
							BPRiskandPreClaim.SetMapping("Risk Reference");
							scrollDown();
							SelectDropDownValue(SectionIdDropDwn1,SectionIdDropDwnOption2);
							SelectDropDownValue(SectionIdDropDwn2,SectionIdDropDwnOption2);
							SelectDropDownValue(SectionIdDropDwn3,SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn4,SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn5,SectionIdDropDwnOption1);
							click(BPRiskandPreClaim.CompleteAssignmentBtn,"Complete Assignment button");
							sleep(2000);
							SelectDropDownValue(BPRiskandPreClaim.BordereauAssignmentSectionDropDwn,BordereauAssignmentSectionDropDwnOptionRiskCode);
							BPRiskandPreClaim.SetMapping("Risk Reference");
							if(isVisible(BPRiskandPreClaim.SetMappingRuleButton)==true){
								click(BPRiskandPreClaim.SetMappingRuleButton,"SetMappingRuleButton");
							}
							else{
								click(BPRiskandPreClaim.CompleteAssignmentBtn,"Complete Assignment button");
							}
							scrollDown();
							SelectDropDownValue(SectionIdDropDwn1Risk1,BPRiskandPreClaim.SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn1Risk2,BPRiskandPreClaim.SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn1Risk3,BPRiskandPreClaim.SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn1Risk4,BPRiskandPreClaim.SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn1Risk5,BPRiskandPreClaim.SectionIdDropDwnOption1);
							click(BPRiskandPreClaim.CompleteAssignmentBtn,"Complete Assignment button");	
							sleep(2000);
							BorProc.clickOnApproveBordBtn();
							BorProc.refreshUploadedFileApprovedStatus();

						}else{
							Report.LogInfo("ValidateScreen", "Expected screen page not displayed.", "FAIL");
						}
					}
						//deleteBorderEAUX();
					
				}else{
					Report.LogInfo("ReviewStatusValidation", "Review Status Button not displayed.", "FAIL");
					deleteBorderEAUX();
					//VerifyNotificationPopupAfterUpload();
				}
			  
	}


	//--------------------------SequenceRule-------------------------------------------------------------//
	//----------------------------------------------------------------------------------------------------//

	// TC_3448
	public void AnotherBordereauSamePeriodNotYetApproved() throws Exception{
		String OnlySpPoliCyNum = "674931TI";
		String IncDate = "01/01/2017";
		String ExpDate = "31/12/2017";
		String UnderlineVal = "Childs, Andy";
		String StatusValue="Uploaded";
		//String payload = "{\"Bordereaux\":{\"ContractId\":\"6ab2b6ad-0e27-4a68-811d-0e3265de573c\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"PolicyId\":\"0\",\"OriginalFileName\":\"January 2017_TC3448.xlsx\",\"UniqueFileName\":\"S49529720171013.xlsx\",\"BordereauFormatId\":\"360bbefa-2ed6-47cb-bbf5-9791c078764a\",\"IsPolicyRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S49529720171013.xlsx\",\"Filesize\":25020,\"Path\":null,\"size\":25020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauPolicy\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		policy.addPolicy2(IncDate,ExpDate);
		verifyExists(DraftBtn,"Draft Status Button");
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		applyFilterPolicy(policy.PolicyNumber);

		openSelectedPolicy();
		SubmitBordereauxWithYesnoButtons1();

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3448Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC3448.xlsx";
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
		File excelFile = new File(sheet3448Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//System.out.println(contractId);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC3448.xlsx\",\"UniqueFileName\":\"S25502220171027.xlsx\",\"BordereauFormatId\":\"4ec20038-7ea9-4f10-845e-dac6477f02f7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S25502220171027.xlsx\",\"Filesize\":25020,\"Path\":null,\"size\":25020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		sleep(2000);
		String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_3448_Second.xlsx\",\"UniqueFileName\":\"S25502220171027.xlsx\",\"BordereauFormatId\":\"4ec20038-7ea9-4f10-845e-dac6477f02f7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S25502220171027.xlsx\",\"Filesize\":25020,\"Path\":null,\"size\":25020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload2, DraftUrl);

		refreshAfterUploadedFileForReviewSatusAndUploadStatus();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed", "PASS");

			if(isVisible(CancelStatusAndLeaveUploadingStatusButton)==true){
				Report.LogInfo("ValidateUploadedStatus", "Another bordereau of the same period is not yet approved Page opened ", "PASS");
				waitForElementToAppear(CancelStatusAndLeaveUploadingStatusButton,3);
				verifyMustExists(CancelStatusAndLeaveUploadingStatusButton,"CancelStatusAndLeaveUploadingStatusButton");
				click(CancelStatusAndLeaveUploadingStatusButton,"CancelStatusAndLeaveUploadingStatusButton");
				sleep(2000);
				refreshAfterUploadedFileForReviewSatusAndUploadStatus();
				if(isVisible(UploadedButton)==true){
					Report.LogInfo("ValidateUploadedStatus", "UPLOADED status displayed", "PASS");
					uploadedDeleteButton(StatusValue);
				}else{
					Report.LogInfo("ValidateUploadedStatus", "UPLOADED status not displayed", "FAIL");
					//deleteBorderEAUX();
				}

			}else{
				Report.LogInfo("ValidateUploadedStatus", "Another bordereau of the same period is not yet approved Page not opened ", "FAIL");
				goBack();				
			}
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed", "FAIL");
			//deleteBorderEAUX();
		}
	}

	// TC-3449


	public void PreviousBordereauNotYetApproved() throws Exception{
		String OnlySpPoliCyNum = "674931TI";

		String StatusValue="Uploaded";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC3449.xlsx\",\"UniqueFileName\":\"S67938720171027.xlsx\",\"BordereauFormatId\":\"4ec20038-7ea9-4f10-845e-dac6477f02f7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S67938720171027.xlsx\",\"Filesize\":25020,\"Path\":null,\"size\":25020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";


		//loginPage.tideLogin();
		sleep(3000);
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereauxWithYesnoButtons1();

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3449Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC3449.xlsx";
			} 
			catch (IOException e) 
			{

				e.printStackTrace();
			}
			File excelFile = new File(sheet3449Path);  
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			sleep(2000);
			refreshAfterUploadedFileForReviewSatusAndUploadStatus();
			if(checkErrorReviewButton(ReviewError)==true){
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed", "PASS");

				if(isVisible(CancelStatusAndLeaveUploadingStatusButton)==true){
					Report.LogInfo("ValidatePreviousBordereauNotApprovedPage", "Previous bordereau not Approved page opened ", "PASS");
					waitForElementToAppear(CancelStatusAndLeaveUploadingStatusButton,3);
					verifyMustExists(CancelStatusAndLeaveUploadingStatusButton,"CancelStatusAndLeaveUploadingStatusButton");
					click(CancelStatusAndLeaveUploadingStatusButton,"CancelStatusAndLeaveUploadingStatusButton");
					refreshAfterUploadedFileForReviewSatusAndUploadStatus();
					if(isVisible(UploadedButton)==true){
						Report.LogInfo("ValidateUploadedStatus", "UPLOADED status displayed", "PASS");
						uploadedDeleteButton(StatusValue);
					}else{
						Report.LogInfo("ValidateUploadedStatus", "UPLOADED status not displayed", "FAIL");
					}

				}else{
					Report.LogInfo("ValidatePreviousBordereau", "Previous bordereau not Approved page not opened ", "FAIL");
					goBack();

				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed", "FAIL");

			}
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}
	}


	// TC-3450 - START

	public void BordereauPeriodPriorToContractInception() throws Exception{
		String OnlySpPoliCyNum = "674931TI";
		String StatusValue="Uploaded";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC3450.xlsx\",\"UniqueFileName\":\"S39513720171027.xlsx\",\"BordereauFormatId\":\"4ec20038-7ea9-4f10-845e-dac6477f02f7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S39513720171027.xlsx\",\"Filesize\":25020,\"Path\":null,\"size\":25020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//String payload = "{\"Bordereaux\":{\"ContractId\":\"129226d1-85fa-402f-99aa-ad3390e4eec3\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC3450.xlsx\",\"UniqueFileName\":\"S39513720171027.xlsx\",\"BordereauFormatId\":\"4ec20038-7ea9-4f10-845e-dac6477f02f7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S39513720171027.xlsx\",\"Filesize\":25020,\"Path\":null,\"size\":25020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";


		//loginPage.tideLogin();
		applyFilterPolicy(policy.PolicyNumber);
		//applyFilterPolicy("721786TG");

		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereauxWithYesnoButtons1();

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3450Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC3450.xlsx";
			} 
			catch (IOException e) 
			{

				e.printStackTrace();
			}
			File excelFile = new File(sheet3450Path);  
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			sleep(2000);
			refreshAfterUploadedFileForReviewSatusAndUploadStatus();
			if(checkErrorReviewButton(ReviewError)==true){
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed", "PASS");

				if(isVisible(CancelStatusAndLeaveUploadingStatusButton)==true){
					Report.LogInfo("ValidateApprovedPage", "Previous bordereau not Approved page opened ", "PASS");
					waitForElementToAppear(CancelStatusAndLeaveUploadingStatusButton,3);
					verifyMustExists(CancelStatusAndLeaveUploadingStatusButton,"CancelStatusAndLeaveUploadingStatusButton");
					click(CancelStatusAndLeaveUploadingStatusButton,"CancelStatusAndLeaveUploadingStatusButton");
					refreshAfterUploadedFileForReviewSatusAndUploadStatus();
					if(isVisible(UploadedButton)==true){
						Report.LogInfo("ValidateUploadedStatus", "UPLOADED status displayed", "PASS");
						uploadedDeleteButton(StatusValue);
					}else{
						Report.LogInfo("ValidateUploadedStatus", "UPLOADED status not displayed", "FAIL");
					}

				}else{
					Report.LogInfo("ValidatePreviousBordereau", "Previous bordereau not Approved page not opened ", "FAIL");
					goBack();

				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed", "FAIL");

			}
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}

	}

	public static final String ContinueProcessingBtn1 ="@xpath=//button[contains(.,'Process Bordereau')]";

	public void  newcolumnsidentified_4470() throws Exception
	{
		String RiskSchemaName = "Schema Test1";
		PolicyPage policy = new PolicyPage();
		BordereauQuePage QuePage = new BordereauQuePage();
		QuePage.sheetProcessingFirstSheet5(RiskSchemaName,QueName);
		String subSheet=QueName;
		String IncDate ="01/01/2017";
		String ExpDate="01/01/2018";
		String MonthDate="February 2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.addPolicy2(IncDate, ExpDate);
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");
			SubmitBordereaux(subSheet);	
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4470Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_4470.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4470Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_4470.xlsx\",\"UniqueFileName\":\"S14240720180112.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S14240720180112.xlsx\",\"Filesize\":24675,\"Path\":null,\"size\":24675,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)==true){
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(3000);
				if(isVisible(ContinueProcessingbtn)==true){
					verifyMustExists(ContinueProcessingbtn,"Continue Processing button");
					click(ContinueProcessingbtn,"Continue Processing button");
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
						click(ReviewBtn,"Reviwe button");
						waitForElementToAppear(SuRcdAssmnt,10);
						verifyMustExists(SuRcdAssmnt,"Submit record assesment button");
						click(SuRcdAssmnt,"Submit record assesment button");
						waitForElementToAppear(FrApprovalbtn,10);
						verifyMustExists(FrApprovalbtn,"For Approval button");
						click(FrApprovalbtn,"For Approval button");
						clickOnApproveBordBtn();
						refreshUploadedFileForApproved();
						if(isVisible(Approvedbtn)==true)
						{
							Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed", "PASS");
							SubmitBordereauxWithYesnoButtons(MonthDate);
							try 
							{
								String fpath = new File(".").getCanonicalPath();
								sheet4470SecondPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_4470second.xlsx";
							} 
							catch (IOException e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							File excelFile1 = new File(sheet4470SecondPath);
							String payload2 ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_4470second.xlsx\",\"UniqueFileName\":\"S69052720180112.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S69052720180112.xlsx\",\"Filesize\":24702,\"Path\":null,\"size\":24702,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
							uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
							refreshUploadedFile();
							if(isVisible(ReviewBtn)==true){
								Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
								homePage.adminMenu();
								QuePage.bordereauQueLink();
								QuePage.bordereauQuePage();
								String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+QueName+"')][1]";
								sleep(2000);
								QuePage.filterBordereauQuestionnaire(QueName, SelectQuestionnaire);
								//BQPage.filterBordereauQuestionnaire1(QueName);
								waitForElementToAppear(QuePage.EditBtn,5);
								verifyMustExists(QuePage.EditBtn,"Edit button");
								click(QuePage.EditBtn,"Edit button");
								waitForElementToAppear(QuePage.nextStepBtn,5);
								QuePage.gotostep11();
								waitForElementToAppear(columnTab,5);
								verifyMustExists(columnTab,"Column Field");
								verifyMustExists(Cancelbtn1,"Cancel button");
								click(Cancelbtn1,"Edit button");	
							}else{
								Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");		
							}	
						}else{
							Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
						}
					}else{
						Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
						deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ValidateErrrorScreen", "expected Error Screen Not Displayed", "FAIL");
					goBack();
					deleteBorderEAUX();
				}
			}
			else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				deleteBorderEAUX();
			}	
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}	
	}

	public void newColumnsIdentified_4472() throws Exception{
		PolicyPage policy = new PolicyPage();
		BordereauQuePage QuePage = new BordereauQuePage();
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		sleep(2000);
		BQPage.filterBordereauQuestionnaire1(QueName);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		verifyMustExists(Version,"version number");
		String version1= getTextFrom(Version,"version number");
		if(version1.equals("1"))
		{
			Report.LogInfo("ValidateVersion", "First version validate successfully", "PASS");	
		}
		else
		{
			Report.LogInfo("ValidateVersion", "First version validate successfully", "Fail");
		}
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		String IncDate = "01/01/2017";
		String ExpDate = "01/01/2018";
		String subSheet1=QueName;
		policy.addPolicy2(IncDate,ExpDate);
		verifyExists(DraftBtn,"Draft Status Button");
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(SignedBtn)==true){
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			SubmitBordereaux(subSheet1);
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4472Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_4472.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4472Path);  
			policy.contractId = addNewBordereauFormatPolicy(payload1, GetData); 
			String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_4472.xlsx\",\"UniqueFileName\":\"S42541820180112.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S42541820180112.xlsx\",\"Filesize\":24744,\"Path\":null,\"size\":24744,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError) == true){
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				if(isVisible(EditQuestionNairebtn)== true){
					verifyMustExists(EditQuestionNairebtn,"EditQuestionnaire button");
					click(EditQuestionNairebtn,"EditQuestionnaire button");
					sleep(3000);
					QuePage.waitForElementToAppear(QuePage.nextStepBtn,5);
					QuePage.gotostep11();
					sleep(2000);
					String Test1Drag="@xpath=//button[contains(.,'Test1')]";
					String BuildingsValueDrop = "@xpath=//td[contains(.,'Buildings Value')]//preceding-sibling::td/div/div";
					String Test2RemoveIcon="@xpath=//td[contains(.,'Contents Value')]//preceding-sibling::td/div/span//i";
					click(Test2RemoveIcon,"contents Remove Icon");
					sleep(2000);	
					String Test2Drag="@xpath=//button[contains(.,'Test2')]";
					String ContentsDrop = "@xpath=//td[contains(.,'Contents Value')]//preceding-sibling::td/div/div";
					dragDropElement(Test1Drag,BuildingsValueDrop);
					sleep(1000);
					dragDropElement(Test2Drag,ContentsDrop);
					QuePage.step11();
					waitForElementToAppear(SaveAndReprocessBtn,8);
					verifyMustExists(SaveAndReprocessBtn,"Save And Reprocess button");
					click(SaveAndReprocessBtn,"Save And Reprocess button");
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
						homePage.adminMenu();
						BQPage.bordereauQueLink();
						BQPage.bordereauQuePage();
						sleep(3000);
						BQPage.filterBordereauQuestionnaire1(QueName);
						waitForElementToAppear(BQPage.EditBtn,5);
						verifyMustExists(BQPage.EditBtn,"Edit button");
						verifyMustExists(Version,"version number");
						String version2= getTextFrom(Version,"version number");
						if(version2.equals("2"))
						{
							Report.LogInfo("ValidateVersion", "Second version validate successfully", "PASS");	
						}
						else
						{
							Report.LogInfo("ValidateVersion", "Second version validate successfully", "Fail");
						}
					}else{
						Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
						deleteBorderEAUX();
					}	
				}else{
					Report.LogInfo("ValidateErrrorScreen", "expected Error Screen Not Displayed", "FAIL");
					goBack();
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				deleteBorderEAUX();
			}	
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}


	public void expectedColumnsMissing_4473() throws Exception{

		PolicyPage policy = new PolicyPage();
		BordereauQuePage QuePage = new BordereauQuePage();
		String IncDate = "01/01/2017";
		String ExpDate = "01/01/2018";
		String subSheet=QueName;
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		sleep(2000);
		BQPage.filterBordereauQuestionnaire1(subSheet);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		policy.addPolicy2(IncDate,ExpDate);
		verifyExists(DraftBtn,"Draft Status Button");
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");
			SubmitBordereaux(subSheet);	
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4473Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_4473.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4473Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_4473.xlsx\",\"UniqueFileName\":\"S98407120180112.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S98407120180112.xlsx\",\"Filesize\":24682,\"Path\":null,\"size\":24682,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)==true){
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(3000);
				if(isVisible(ContinuebtnOnErrorScreen)==true){
					verifyMustExists(ContinuebtnOnErrorScreen,"Continue Processing button");
					click(ContinuebtnOnErrorScreen,"Continue Processing button");
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
						deleteBorderEAUX();
					}else{
						Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
						deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ValidateErrrorScreen", "expected Error Screen Not Displayed", "FAIL");
					goBack();
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}


	public void oneExpectedColumnsMissing_4474() throws Exception{

		PolicyPage policy = new PolicyPage();
		BordereauQuePage QuePage = new BordereauQuePage();
		String IncDate = "01/01/2017";
		String ExpDate = "01/01/2018";
		String MonthDate="February 2017";
		String subSheet=QueName;
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		sleep(2000);
		BQPage.filterBordereauQuestionnaire1(subSheet);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		policy.addPolicy2(IncDate,ExpDate);
		verifyExists(DraftBtn,"Draft Status Button");
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");
			SubmitBordereaux(subSheet);	
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4474Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_4474.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4474Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_4474.xlsx\",\"UniqueFileName\":\"S15107520180109.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S15107520180109.xlsx\",\"Filesize\":24682,\"Path\":null,\"size\":24682,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)==true){
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				if(isVisible(EditQuestionNairebtn)==true){
					verifyMustExists(EditQuestionNairebtn,"Continue Processing button");
					click(EditQuestionNairebtn,"Continue Processing button");
					sleep(2000);
					QuePage.waitForElementToAppear(QuePage.nextStepBtn,5);
					QuePage.gotostep11();
					sleep(2000);
					String Test1RemoveIcon="@xpath=//td[contains(.,'Buildings Value')]//preceding-sibling::td/div/span//i";
					String Test2RemoveIcon="@xpath=//td[contains(.,'Contents Value')]//preceding-sibling::td/div/span//i";
					click(Test1RemoveIcon,"Test 1 Remove Icon");
					sleep(1000);
					click(Test2RemoveIcon,"Test 2 Remove Icon");
					sleep(1000);
					QuePage.step11();
					waitForElementToAppear(SaveAndReprocessBtn,8);
					verifyMustExists(SaveAndReprocessBtn,"Save And Reprocess button");
					click(SaveAndReprocessBtn,"Save And Reprocess button");
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
						click(ReviewBtn,"Reviwe button");
						waitForElementToAppear(SuRcdAssmnt,10);
						verifyMustExists(SuRcdAssmnt,"Submit record assesment button");
						click(SuRcdAssmnt,"Submit record assesment button");
						waitForElementToAppear(FrApprovalbtn,10);
						verifyMustExists(FrApprovalbtn,"For Approval button");
						click(FrApprovalbtn,"For Approval button");
						clickOnApproveBordBtn();
						refreshUploadedFileForApproved();
						if(isVisible(Approvedbtn)==true)
						{
							Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
							homePage.adminMenu();
							BQPage.bordereauQueLink();
							BQPage.bordereauQuePage();
							sleep(2000);
							BQPage.filterBordereauQuestionnaire1(subSheet);
							waitForElementToAppear(BQPage.EditBtn,5);
							verifyMustExists(BQPage.EditBtn,"Edit button");
							click(BQPage.EditBtn,"Edit button");
							BQPage.nextStapeClick();
							BQPage.FormatId = ReturnFormatID();
							applyFilterPolicy(policy.PolicyNumber);
							openSelectedPolicy();
							SubmitBordereauxWithYesnoButtons(MonthDate);
							try 
							{
								String fpath = new File(".").getCanonicalPath();
								sheet4474SecondPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_4474Second.xlsx";
							} 
							catch (IOException e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							File excelFile1 = new File(sheet4474SecondPath); 
							String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_4474Second.xlsx\",\"UniqueFileName\":\"S91496720180112.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S91496720180112.xlsx\",\"Filesize\":24715,\"Path\":null,\"size\":24715,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
							uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
							refreshUploadedFile();
							if(isVisible(ReviewBtn)==true){
								Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
							}else{
								Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail");
							}			
						}else{
							Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
						}
					}else{
						Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
						deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ValidateErrrorScreen", "expected Error Screen Not Displayed", "FAIL");
					goBack();
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}


	public void downloadBordereaufile_4481() throws Exception{

		PolicyPage policy = new PolicyPage();
		BordereauQuePage QuePage = new BordereauQuePage();
		String IncDate = "01/01/2017";
		String ExpDate = "01/01/2018";
		String subSheet=QueName;
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		sleep(2000);
		BQPage.filterBordereauQuestionnaire1(subSheet);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		verifyMustExists(Version,"version number");
		String version3= getTextFrom(Version,"version number");
		if(version3.equals("3"))
		{
			Report.LogInfo("ValidateVersion", "Third version validate successfully", "PASS");	
		}
		else
		{
			Report.LogInfo("ValidateVersion", "Third version validate successfully", "Fail");
		}
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		policy.addPolicy2(IncDate,ExpDate);
		verifyExists(DraftBtn,"Draft Status Button");
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");
			SubmitBordereaux(subSheet);	
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4481Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_4481.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4481Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_4481.xlsx\",\"UniqueFileName\":\"S73174320180113.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S73174320180113.xlsx\",\"Filesize\":24781,\"Path\":null,\"size\":24781,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)==true){
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(3000);
				if(isVisible(DownloadBorderEAU)==true){
					verifyMustExists(DownloadBorderEAU,"Download Bordereau button");
					if(isEnable(DownloadBorderEAU)==true){
						Report.LogInfo("ValidateDownloadBordereau", "Download Bordereau button is Enable", "PASS");
					}
					else
					{
						Report.LogInfo("ValidateDownloadBordereau", "Download Bordereau button is not Enable", "FAIL");	
					}
					waitForElementToAppear(TideField,3);
					SelectDropDownValue(TideField,ContentsValue);
					verifyMustExists(ContinueProcessingbtn,"Continue Processing button");
					click(ContinueProcessingbtn,"Continue Processing button");
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
						homePage.adminMenu();
						BQPage.bordereauQueLink();
						BQPage.bordereauQuePage();
						sleep(2000);
						BQPage.filterBordereauQuestionnaire1(subSheet);
						waitForElementToAppear(BQPage.EditBtn,5);
						verifyMustExists(BQPage.EditBtn,"Edit button");
						verifyMustExists(Version,"version number");
						String version4= getTextFrom(Version,"version number");
						if(version4.equals("4"))
						{
							Report.LogInfo("ValidateVersion", "fourth version validate successfully", "PASS");	
						}
						else
						{
							Report.LogInfo("ValidateVersion", "Fourth version validate successfully", "Fail");
						}	
					}else{
						Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail");
					}		
				}else{
					Report.LogInfo("ValidateErrrorScreen", "expected Error Screen Not Displayed", "FAIL");
					goBack();
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}
	//---------FEATURE- Date Format Not Identified----START--------------------------------------------------------//
	//_____________________________________________________DateFormat-TC-3500-START___________________________//

	public void  DataFormatNotIdentified () throws Exception{
		String OnlySpPoliCyNum = "579652YC";
		String IncDate = "01/01/2017";
		String ExpDate = "31/12/2017";
		String UnderlineVal = "Childs, Andy";
		String SubmitSheet = "SP - First Sheet (Automation Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		policy.addPolicy2(IncDate,ExpDate);
		verifyExists(DraftBtn,"Draft Status Button");
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSignedWithClaim();
		//TC 3532
		BQPage.addBordereauFormatClaim();
		String SubSheet = BQPage.ClaimBordereauText;
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(SubSheet);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn, 5);
		verifyMustExists(BQPage.EditBtn, "Edit button");
		click(BQPage.EditBtn, "Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(SubSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3500Path = fpath+"\\src\\test\\resources\\testdata\\Jan-All sheets_TC3500.xlsx";
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
		File excelFile = new File(sheet3500Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Jan-All sheets_TC3500.xlsx\",\"UniqueFileName\":\"S51792820180115.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S51792820180115.xlsx\",\"Filesize\":14102,\"Path\":null,\"size\":14102,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			verifyMustExists(ReviewBtn,"Review button");
			openDATALink();
			navigateToDATAClaimTab();
			//Verify Inception date format
			String RiskInceptionDatecolumn="@xpath=//*[@data-field='RiskInceptionDate']";
			String RiskInceptionDate1="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[1]//td[contains(@ng-click,'RiskInceptionDate')][text()='01/01/2017']";
			waitForElementToAppear(RiskInceptionDatecolumn,20);
			mouseOverAction(RiskInceptionDatecolumn);
			verifyMustExists(RiskInceptionDatecolumn,"Risk Inception Date column");
			sleep(2000);
			verifyExists(RiskInceptionDate1,"Inception Date is displayed in DD-MM-YYYY format");

			//Verify Expiry date format
			String RiskExpiryDatecolumn="@xpath=//*[@data-field='RiskExpiryDate']";
			String RiskExpiryDate1="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[1]//td[contains(@ng-click,'RiskExpiryDate')][text()='28/04/2017']";
			waitForElementToAppear(RiskExpiryDatecolumn,20);
			mouseOverAction(RiskExpiryDatecolumn);
			verifyMustExists(RiskExpiryDatecolumn,"RiskExpiryDate column");
			sleep(2000);
			verifyExists(RiskExpiryDate1,"Expiry Date is displayed in DD-MM-YYYY format");
			//goBack();
			policy.navigationOnBordereauxTab();
			deleteBorderEAUX();

		}else{

			Report.LogInfo("ValidateReviewErrorStatus", "Review status not displayed", "FAIL");
			deleteBorderEAUX();
		}
	}

	//---------FEATURE- Date Format Not Identified----END--------------------------------------------------------//

	//============================================Renewal (Y/N) from Transaction Type =============================================================//


	public void renewalYNTransactionType_January_3759() throws Exception{
		String subSheet = "SP - First Sheet (Automation Schema)";
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String SubmitSheet="SP - First Sheet";
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
		policy.addPolicyContractDetails1(UniqueReferenceVal1, IncDate,ExpDate, Status1, policy.Broker1, policy.Bline1, policy.Underline1);
		waitForElementToAppear(DraftBtn,5);
		verifyExists(DraftBtn,"Draft Status Button");
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);	
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3759PathFirst = fpath+"\\src\\test\\resources\\testdata\\Renewal_jan_3759First.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile1 = new File(sheet3759PathFirst);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String payload2 ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Renewal_jan_3759First.xlsx\",\"UniqueFileName\":\"S30125720180127.xlsx\",\"BordereauFormatId\":\"eec96ded-631b-446f-a9fa-d48fc8cbe4b2\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S30125720180127.xlsx\",\"Filesize\":18592,\"Path\":null,\"size\":18592,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			navigateToDATATab();
			navigateToDATARiskTab();
			String RenevalFirst = "@xpath=//tr[1]//td[contains(@ng-click,'IsRenewal')][text()='Yes']";
			String RuleName = "@xpath=//td//div[text()='New/Renewal (Y/N) completed based on the first Transaction Type reported for the risk.']";
			String Okbtn = "@xpath=//div[@ng-click='cancel()']";
			waitForElementToAppear(RenevalFirst,5);
			verifyExists(RenevalFirst,"Renewal Y/N first record");
			click(RenevalFirst,"Renewal Y/N first record");
			sleep(2000);
			waitForElementToAppear(RuleName,5);
			verifyExists(RuleName,"Rule name");
			waitForElementToAppear(Okbtn,5);
			verifyExists(Okbtn,"Ok button");
			click(Okbtn,"Ok button");
			sleep(2000);
		}else{
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not Displayed", "FAIL");
		}

		SubmitBordereaux(subSheet);	
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3759Path = fpath+"\\src\\test\\resources\\testdata\\Renewal_jan (1)_TC_3759.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3759Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Renewal_jan (1)_TC_3759.xlsx\",\"UniqueFileName\":\"S13271620171107.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S13271620171107.xlsx\",\"Filesize\":18592,\"Path\":null,\"size\":18592,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			click(ReviewBtn,"Review Button");
			sleep(3000);
			waitForElementToAppear(SuRcdAssmnt,10);
			verifyMustExists(SuRcdAssmnt,"Submit recor for Assignment button");
			click(SuRcdAssmnt,"Submit recor for Assignment button");
			waitForElementToAppear(FrApprovalbtn,10);
			verifyMustExists(FrApprovalbtn,"For Approval button");
			click(FrApprovalbtn,"For Approval button");
			clickOnApproveBordBtn();
			refreshUploadedFileApprovedStatus();
			if(isVisible(Approvedbtn)==true)
			{
				Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
			}else{
				Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
			}	
		}
		else{
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not Displayed", "FAIL");
		}		
	}

	public void mappingCount_3761() throws Exception{
		String OriginalValueName="Endorsement";		
		homePage.adminMenu();
		datasetPage.DatasetReferenceDataLink();
		datasetPage.DatasetReferenceDatapage();
		applyReferenceDataFilter("Boolean");
		waitForElementToAppear(BooleanName,5);
		verifyExists(BooleanName,"Boolean Name");
		click(BooleanName,"Boolean Name");
		datasetPage.selectMappingsTab();
		datasetPage.applyOriginalNameFilter(OriginalValueName);
		waitForElementToAppear(MappingTotalCount,5);
		verifyExists(MappingTotalCount,"Mapping Total Count");
		Count = getTextFrom(MappingTotalCount);
		ActualCount = Integer.parseInt(Count);		
	}

	public void PasswordProtectedFiles_3773() throws Exception
	{
		String SubmitSheet = "SP - First Sheet (Automation Schema)";
		String Expectedresp = "\"ReturnData\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":null,\"Filesize\":0,\"Path\":null,\"size\":0,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":true},\"Status\":0,\"ReturnMessage\":[],\"Permissions\":[]}";
		String ReqURL = Configuration.url+"/api/FileStorage/UploadFile/1";
		applyFilterPolicy(policy.PolicyNumber);
		//applyFilterPolicy("609520TC");
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereaux(SubmitSheet);

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3773Path = fpath+"\\src\\test\\resources\\testdata\\Password_Protected_TC_3773.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			File excelFile = new File(sheet3773Path);
			String ErrorRes = uploadFileAndCheckError(ReqURL,excelFile);
			if(Expectedresp.equalsIgnoreCase(ErrorRes))
			{
				Report.LogInfo("ErrorCheck", "Expected response message displayed", "PASS");
			}else{
				Report.LogInfo("ErrorCheck", "Expected response message not displayed", "PASS");
			}
		}
	}


	//--------------------------------------------------------------------------------------------------------------------------------------------//	
	//------------------------------------------------------- Reusable functions -----------------------------------------------------------------//
	//--------------------------------------------------------------------------------------------------------------------------------------------//	

	public void deleteBorderEAUX(){
		navigateOnProcessingTab();

		//sleep(2000);  
		waitForElementToAppear(DeleteButton,6);
		if(isVisible(DeleteButton)==true){
			verifyMustExists(DeleteButton,"Delete Button");
			click(DeleteButton,"Delete Button");
			//sleep(4000);
			//if(isVisible(DeleteCancelButton)==false){
			waitForElementToAppear(DeleteYESButton,5);
			if(isVisible(DeleteYESButton)== true){
				verifyMustExists(DeleteYESButton,"Delete YES Button");
				click(DeleteYESButton,"Delete YES Button");
				sleep(3000);
			}
			else{
				Report.LogInfo("DeleteYesBTN", "Yes button is not displayed", "FAIL");
				click(DeleteCancelButton,"Delete Cancel Button");   
			}
			//}else{
			//sleep(1000);
			//click(DeleteCancelButton,"Cancel button");
			//}
		}else{
			Report.LogInfo("DeleteBTN", "Delete button is not displayed", "FAIL");
		}
	}

	public void gotopolicy()
	{
		webDriver.navigate().refresh();
		click(PolicyHome,"Policy link");
		sleep(2000);
	}
	public void VerificationRcddCounts (int expectedCount){
		sleep(2000);

		waitForElementToAppear(ActualExpectedRowCount,5);
		List <WebElement> list = findWebElements(ActualExpectedRowCount);
		int count = list.size();
		sleep(2000);
		if(count == expectedCount)
		{
			Report.LogInfo("ValidateRecords", "Records count matches with the records in the excel file. Actual records count is: "+count, "PASS");
		}else{
			Report.LogInfo("ValidateRecords", "Records count does not match with the records in the excel file. Actual records count is: "+count, "FAIL");
		}
		sleep(2000);
		goBack();
	}
	public void VerificationCounts (int expectedCount){
		sleep(2000);
		waitForElementToAppear(RiskTab,5);
		verifyMustExists(RiskTab,"Risk Tab");
		click(RiskTab,"Risk Tab");
		sleep(4000);
		waitForElementToAppear(ChangePageCountDropDn,4);
		verifyMustExists(ChangePageCountDropDn,"Change Page Count Dropdown");
		click(ChangePageCountDropDn,"Change Page Count Dropdown");
		sleep(2000);
		click(ChangePageCountTo,"Change Page Count To");
		sleep(4000);
		waitForElementToAppear(ActualExpectedRowCount,5);
		List <WebElement> list = findWebElements(ActualExpectedRowCount);
		int count = list.size();
		sleep(2000);
		if(count == expectedCount)
		{
			Report.LogInfo("ValidateRecords", "Records count matches with the records in the excel file. Actual records count is: "+count, "PASS");
		}else{
			Report.LogInfo("ValidateRecords", "Records count does not match with the records in the excel file. Actual records count is: "+count, "FAIL");
		}
		sleep(2000);
		goBack();
	}

	public void applyFilterPolicy(String PolicyNumber) throws InterruptedException{

		int i=0;
		String RecordCheckbox ="@css=[value='"+PolicyNumber+"']";

		waitForElementToAppear(PolicyHome,5);
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
			clickAndWait(PolicyReferenceFilterIcon, "Policy Reference Filter Icon");
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

	public void applyFilterPolicy1(String PolicyNumber) throws InterruptedException{

		int i=0;
		String RecordCheckbox ="@css=[value='"+PolicyNumber+"']";

		waitForElementToAppear(PolicyHome,5);
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
			clickAndWait(PolicyReferenceFilterIcon, "Policy Reference Filter Icon");
			sleep(2000);
			if(isVisible(SearchText))
			{
				verifyMustExists(SearchText,"Search Filter Textbox");	
				sendKeys(SearchText,PolicyNumber,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<1);

		click(RecordCheckbox, "Searched Record Checkbox");
		verifyMustExists(FilterButton,"Filter Button");
		click(FilterButton,"Filter Button");
		sleep(3000);
	}

	public void openSelectedPolicy(){
		waitForElementToAppear(SelectedPolicy,3);
		verifyMustExists(SelectedPolicy,"Selected Policy");
		click(SelectedPolicy,"Selected Policy");
		sleep(2500);
	}

	public void SubmitBordereaux(String SubmitSheet) throws Exception{
		waitForElementToAppear(BORDEREAUXLink,5);
		sleep(1500);
		verifyMustExists(BORDEREAUXLink,"BORDEREAUX Link");
		click(BORDEREAUXLink,"BORDEREAUX Link");
		sleep(2000);
		navigateOnProcessingTab();
		if (isVisible(BlankDetailsMsg)==true)
		{
			Report.LogInfo("StatusCheck", "No status records found", "PASS");
		}else{
			//sleep(2000);
			checkRecordsAndDeleteReviewError();
			sleep(2000);
			checkRecordsAndDeleteReview();
		}
		sleep(2000);
	}

	public void DeleteError(){
		if (isVisible(BlankDetailsMsg)==true)
		{
			Report.LogInfo("StatusCheck", "No status records found", "PASS");
		}else{
			checkRecordsAndDeleteReviewError();
			sleep(2000);
			checkRecordsAndDeleteReview();
			sleep(3000);
			refreshPage();
		}
	}

	public void FilterPolicy(String PolicyNumber1FirstSheet){
		waitForElementToAppear(PolicyHome,2);
		verifyMustExists(PolicyHome,"Policy Link");
		click(PolicyHome,"Policy Link");
		verifyMustExists(PolicyReferenceFilterIcon,"Policy Reference Filter Icon");
		click(PolicyReferenceFilterIcon,"Policy Link");
		verifyMustExists(SearchText,"Search Textbox");
		sendKeys(SearchText,PolicyNumber1FirstSheet,"Search Textbox field.");
		sleep(2000);
		webDriver.findElement(By.cssSelector("[value='"+PolicyNumber1FirstSheet+"']")).click();
		sleep(2000);
		verifyMustExists(FilterButton,"Filter Button");
		click(FilterButton,"Filter Button");
		sleep(3000);
	}

	public void SubmitBordereauxFirstSheet(String FirstSheet) throws Exception{
		waitForElementToAppear(BorderEAUXFirst,5);
		verifyMustExists(BorderEAUXFirst,"BorderEAUX First");
		click(BorderEAUXFirst,"BorderEAUX First");
		verifyMustExists(SubmitBordereauxDropdown,"Submit Bordereaux Dropdown");
		click(SubmitBordereauxDropdown,"Submit Bordereaux Dropdown");
		sleep(2000);
		verifyMustExists(SelectOptionRisk,"Select Option Risk");
		click(SelectOptionRisk,"Select Option Risk");
		sleep(2000);
		verifyMustExists(SelectNewquestionnaire,"Select New Questionnaire");
		javaScriptclick(SelectNewquestionnaire);
		sendKeys(EnterOptionToSelect,Questionnaire,"Option to select questionnaire.");
		sleep(4000);
		webDriver.findElement(By.xpath("//li[contains(text(),'"+FirstSheet+"')]")).click();
		verifyMustExists(CalenderFirstST,"Calender");
		click(CalenderFirstST,"Calender");
		sleep(4000);
		verifyMustExists(DateJan,"Date Jan");
		javaScriptclick(DateJan);
		sleep(2000);
	}

	public void UploadFile(StringSelection filePath) throws AWTException
	{
		verifyMustExists(UploadSection,"Upload File Section");
		click(UploadSection,"Upload File Section link");
		Robot robot = new Robot();
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath,null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		sleep(1000);
		robot.keyPress(KeyEvent.VK_V);
		sleep(1000);
		robot.keyRelease(KeyEvent.VK_V);
		sleep(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		sleep(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);		
	}

	public void refreshUploadedFile() throws Exception
	{
		navigateOnProcessingTab();
		sleep(2000);

		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;		
		do
		{
			sleep(3000);
			javaScriptclick(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;			
		}while((isVisible(ReviewError)==false) && (isVisible(ReviewBtn)==false) && (totalTime < 180000));
	}

	public void refreshUploadedFile(String Error) throws Exception
	{
		navigateOnProcessingTab();

		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;		
		do
		{
			sleep(3000);
			click(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;			
		}while((isVisible(Error)==false) && (isVisible(ReviewBtn)==false) && (totalTime < 180000));
	}

	public void refreshUploadedFileError() throws Exception
	{
		navigateOnProcessingTab();

		for(int i= 0; i<=15; i++)
		{
			sleep(3000);
			click(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			if(isVisible(ReviewError)){
				//VerifyNotificationPopupAfterUpload();
				break;
			}
		}
	}

	public void EditSpecificText(String text){
		waitForElementToAppear(ToEditSpecificText,3);
		verifyMustExists(ToEditSpecificText,"To Edit Specific Text");
		sendKeys(ToEditSpecificText,text,"Textbox to Edit the Sheet.");
		sleep(2000);
		click(ProcessBorderEAuButton,"Process Bordereau Button");
		sleep(3000);
	}

	public void monthSelection()
	{		
		verifyMustExists(ProcessingTiem,"Processing time field");
		click(ProcessingTiem,"Processing time field");
		sleep(1000);
		verifyMustExists(May2017,"May 2017 option");
		click(May2017,"May 2017 option");
		sleep(1000);
		click(ErrorScreen,"Error Screen");
		sleep(2000);
		javaScriptclick(ProcessingTimeSecond,"Processing time field");
		sendKeys(ProcessingTimeSecond,"June 2017","Processing time field.");
		sleep(1000);
		verifyMustExists(June2017,"May 2017 option");
		click(June2017,"May 2017 option");
	}

	public void selectSheetForProcessingRadioAndDate(String year){
		verifyMustExists(RemainUnchangedRadioButton,"Remain Unchanged Radio Button");
		click(RemainUnchangedRadioButton,"Remain Unchanged Radio Button");
		sleep(1000);
		verifyMustExists(NoSingelContainProcessingTime,"No Singel Contain Processing Time drop down");
		click(NoSingelContainProcessingTime,"No Singel Contain Processing Time drop down");
		sleep(3000);
		webDriver.findElement(By.xpath("//div[@class='k-list-scroller']//li[text()='"+year+"']")).click();
		//verifyMustExists(Mar2017,"March value");
		//click(Mar2017,"March value");
		sleep(1000);
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
					verifyMustExists(locator,"Review Error Status");
					javaScriptclick(locator,"Review Error Status");
					sleep(2000);
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
		sleep(2000);
	}

	public void verifyandClickProcessBorderEAuButton(){	
		waitForElementToAppear(ProcessBorderEAuButton,5);
		verifyMustExists(ProcessBorderEAuButton,"Process Bordereau Button");
		click(ProcessBorderEAuButton,"Process Bordereau Button");
		sleep(1000);
	}

	public void verifyandClickCancelAndDeleteProButton(){	
		verifyMustExists(cancelAndDeleteProBtn,"Cancel And Delete Processing button");
		click(cancelAndDeleteProBtn,"Cancel And Delete Processing button");
		sleep(4000);
	}	

	public void bordereauxProcessing(String ExpectedErrorMsg, String ExpSecondErrorMsg){
		sleep(3000);

		verifyMustExists(ErrorScreen,"Error Screen");
		String AcualErrorMsg = getTextFrom(ErrorScreen);

		if(AcualErrorMsg.equalsIgnoreCase(ExpectedErrorMsg)){
			Report.LogInfo("ValidateErrorMessage", "Validation Message displayed as expected. Actual message displayed is: "+AcualErrorMsg, "PASS");
		}else{
			Report.LogInfo("ValidateErrorMessage", "Validation Message not displayed as expected. Actual message displayed is: "+AcualErrorMsg, "FAIL");
		}
		sleep(2000);
	}

	public void bordereauxProcessRemainUnchanged(String ExpectedErrorMsg, String year) {
		verifyMustExists(ErrorScreen,"Error Screen");
		String AcualErrorMsg = getTextFrom(ErrorScreen);
		if(AcualErrorMsg.equalsIgnoreCase(ExpectedErrorMsg)){

			Report.LogInfo("ValidateErrorMessage", "Validation Message displayed as expected. Actual message displayed is: "+AcualErrorMsg, "PASS");
		}else{
			Report.LogInfo("ValidateErrorMessage", "Validation Message not displayed as expected. Actual message displayed is: "+AcualErrorMsg, "FAIL");
		}
		sleep(2000);
		verifyMustExists(RemainUnchangedRadioButton,"Remain Unchanged Radio Button");
		click(RemainUnchangedRadioButton,"Remain Unchanged Radio Button");
		verifyMustExists(SelectDropDown,"Select DropDown");
		click(SelectDropDown,"Select DropDown");
		sleep(3000);
		webDriver.findElement(By.xpath("//li[contains(text(),'"+year+"')]")).click();
		sleep(3000);
		verifyMustExists(ProcessBorderEAuButton,"Process Bordereau Button");
		click(ProcessBorderEAuButton,"Process Bordereau Button");
	}

	public void cancelAndDeleteBoredereauByCatchingValidation(String ExpectedErrorMsg){
		//sleep(3000);
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
			sleep(4000);
		}else{
			Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
		}
	}
	public void passDate(String Date){
		verifyMustExists(DateTextBox,"Date Textbox");
		sendKeys(DateTextBox,Date,"Date Textbox.");
		sleep(2000);

	}
	public void verifyBackground(String locator,String colorcode ){
		String actuallcolor= findWebElement(locator).getCssValue("color"); 
		if(actuallcolor.equalsIgnoreCase(colorcode)){

			Report.LogInfo("Validatebackrgound", "Validation background displayed to green successfully.", "PASS");
		}else{
			Report.LogInfo("Validatebackrgound", "Validation background not displayed to green successfully.", "FAIL");
		}
		sleep(3000);
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
					sleep(2000);
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
		sleep(1000);
		verifyMustExists(ErrorScreen,"Error Screen");
		String AcualErrorMsg = getTextFrom(ErrorScreen);
		if(AcualErrorMsg.equalsIgnoreCase(errorsheetmsg)){

			Report.LogInfo("ValidateErrorMessage", "Validation Message is displayed as expected. Actual message displayed is: "+AcualErrorMsg, "PASS");
		}else{
			Report.LogInfo("ValidateErrorMessage", "Validation Message is not displayed as expected. Actual message displayed is: "+AcualErrorMsg, "FAIL");
		}
		sleep(2000);	 
	}
	public void monthselection() {
		verifyMustExists(sheetdropdown,"Sheet Dropdown");
		click(sheetdropdown,"Sheet Dropdown");
		sleep(3000);
		//waitForElementToAppear(April2017,5);
		verifyMustExists(April2017,"April 2017 Option");
		javaScriptclick(April2017,"April 2017 Option");
		sleep(3000);
	}   
	public void verifyvalidDateAndBackground()
	{
		clearTextBox(datefield);
		sendKeys(datefield,"11/01/2017","Date field.");  
		verifyMustExists(datefield,"Date field");
		verifyBackground(datefield,"rgba(0, 97, 0, 1)");
		sleep(2000);
		verifyMustExists(continuebtx,"Continue button");
		click(continuebtx,"Continue button");
	}
	public void processBordereauAccounterror() throws Exception
	{
		if(checkErrorReviewButton(ReviewError)== true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(2000);
			//VerifyNotificationPopupAfterUpload();
			sleep(2000);
			if(isVisible(discardRecord)== true){
				verifyMustExists(discardRecord,"First discard record");
				click(discardRecord,"Discard record");
				
				verifyMustExists(RecordsNotImported,"Records did not import");
				verifyMustExists(ContractIndentifiedText,"Contract identified text verified");
				
				verifyMustExists(continuebtx,"Continue button");
				click(continuebtx,"Continue button");
				sleep(3000);
				verifyBackground(yearAccount,"rgba(156, 0, 6, 1)");
				verifyBackground(inceptionDate,"rgba(156, 0, 6, 1)");
				clearTextBox(yearAccount);
				sendKeys(yearAccount,"2017","Year Account field.");
				sleep(3000);
				verifyBackground(yearAccount,"rgba(0, 97, 0, 1)");
				verifyBackground(inceptionDate,"rgba(0, 97, 0, 1)");
				verifyMustExists(continuebtn,"Continue button");
				click(continuebtn,"Continue button");
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
			//VerifyNotificationPopupAfterUpload();
		}
	}

	public void VerifyNotificationPopupAfterUpload() throws Exception{

		if(isVisible(SuccessNotificationMsgAfterUpload))
		{
			//Report.LogInfo("NotificationAfterUpload", "Success notification displayed after uploading bordereau.", "PASS");
			sleep(1000);
			click(OkButtonOnSuccessNotification,"Ok Button On Success Notification");
		}
		else if(isVisible(FailureNotificationMsgAfterUpload))
		{
			//Report.LogInfo("NotificationAfterUpload", "Failure notification displayed after uploading bordereau.", "PASS");
			sleep(1000);
			click(CancelButtonOnFailureNotification,"Cancel Button On Failure Notification");
		}
		/*else
		{
			Report.LogInfo("NotificationAfterUpload", "Success or Failure Notification not displayed after uploading bordereau.", "FAIL");
		}*/

	}

	public void checkRecordsAndDeleteReviewError(){
		navigateOnProcessingTab();

		waitForElementToAppear(filterIconRecords,3);
		verifyMustExists(filterIconRecords,"filterIconRecords");
		click(filterIconRecords,"filterIconRecords");
		if(isVisible(ReviewErrorCheckBox)==true){
			click(ReviewErrorCheckBox,"ReviewErrorCheckBox");
			verifyMustExists(FilterButtonRecords,"FilterButtonRecords");
			click(FilterButtonRecords,"FilterButtonRecords");
			sleep(4000);
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
		navigateOnProcessingTab();
		refreshPage();
		sleep(4000);
		waitForElementToAppear(filterIconRecords,8);
		verifyMustExists(filterIconRecords,"filterIconRecords");
		click(filterIconRecords,"filterIconRecords");
		if(isVisible(ReviewCheckBox)==true){
			click(ReviewCheckBox,"ReviewCheckBox");
			verifyMustExists(FilterButtonRecords,"FilterButtonRecords");
			click(FilterButtonRecords,"FilterButtonRecords");
			sleep(2000);
			List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
			int recordsCount = totatRecords.size();
			for(int i=1;i<=recordsCount;i++){				
				deleteBorderEAUX();
			}
			refreshPage();
			sleep(4000);
		}else{
			Report.LogInfo("ValidateRecords", "No older records found", "PASS");
		}
	}

	public void DeleteButtonCheckRowwise(){
		List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
		int recordsCount = totatRecords.size();
		for(int a=1;a<=recordsCount;a++){	
			String uploadDeletebtn = "@xpath=//tr["+a+"]//button[text()='Uploaded']//following-sibling::span[1]/i";
			if(isVisible(uploadDeletebtn)==true)
			{
				Report.LogInfo("ButtonCheck", "Delete button display for updload status", "PASS");
			}else{
				Report.LogInfo("ButtonCheck", "Delete button is not display for updload status", "FAIL");
			}
		}
	}

	public void DeleteButtonCheckRowwiseforAllStatus(){
		List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
		int recordsCount = totatRecords.size();
		for(int a=1;a<=recordsCount;a++){	
			String Deletebtn = "@xpath=//tr["+a+"]//*[contains(@ng-click,'CanDelete')]";
			if(isVisible(Deletebtn)==true)
			{
				Report.LogInfo("ButtonCheck", "Delete button display for status", "PASS");
			}else{
				Report.LogInfo("ButtonCheck", "Delete button is not display for status", "FAIL");
			}
		}
	}

	public void DeleteButtonCheckRowwiseforAllStatus1(){
		sleep(2000);
		List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
		int recordsCount = totatRecords.size();
		for(int a=1;a<=recordsCount;a++){	
			String Deletebtn = "@xpath=//tr["+a+"]//*[contains(@ng-click,'CanDelete')]";
			if(isVisible(Deletebtn)==true)
			{
				Report.LogInfo("ButtonCheck", "Delete button display for status", "FAIL");
			}else{
				Report.LogInfo("ButtonCheck", "Delete button is not display for updload status", "PASS");
			}
		}
	}



	public void applyStatusFilter(String Status) throws InterruptedException{
		sleep(1000);
		int i=0;
		String RecordCheckbox ="@css=input[value='"+Status+"']";

		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			waitForElementToAppear(filterIconRecords,5);
			click(filterIconRecords, "Status Filter Icon");
			sleep(2000);
			waitForElementToAppear(SearchText,5);
			if(isVisible(SearchText))
			{
				verifyMustExists(SearchText,"Search Filter Textbox");	
				sendKeys(SearchText,Status,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);
		waitForElementToAppear(RecordCheckbox,5);
		click(RecordCheckbox, "Searched Record Checkbox");
		String StatusfilterBtn = "@xpath=//input[@value='"+Status+"']//following::button[@type='submit']";
		verifyExists(StatusfilterBtn,"Filter Button");
		click(StatusfilterBtn,"Filter Button");
		sleep(3000);
		//sleep(2000);
	}

	public void applyBordereauTypeFilter(String Status) throws InterruptedException{
		sleep(1000);
		int i=0;
		String RecordCheckbox ="@css=input[value='"+Status+"']";

		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			waitForElementToAppear(filterIconRecordsBodrTyp,5);
			click(filterIconRecordsBodrTyp, "Status Filter Icon");
			sleep(2000);
			waitForElementToAppear(SearchTextBDType,5);
			if(isVisible(SearchTextBDType))
			{
				verifyMustExists(SearchTextBDType,"Search Filter Textbox");	
				sendKeys(SearchTextBDType,Status,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);
		waitForElementToAppear(RecordCheckbox,5);
		click(RecordCheckbox, "Searched Record Checkbox");
		String StatusfilterBtn = "@xpath=//input[@value='"+Status+"']//following::button[@type='submit']";
		verifyExists(StatusfilterBtn,"Filter Button");
		click(StatusfilterBtn,"Filter Button");
		sleep(3000);
		//sleep(2000);
	}

	public void refreshUploadedFileApprovedStatus1(String ApproveBtn) throws Exception
	{
		waitForElementToAppear(ApprovedTab,5);
		verifyMustExists(ApprovedTab,"Approve Tab");
		click(ApprovedTab,"Approve Tab");

		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;  
		do
		{
			sleep(3000);
			click(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;   
		}while((isVisible(ApproveBtn)==false) && (totalTime < 180000));
	}

	public void applyMonthFilter(String Status) throws InterruptedException{

		int i=0;
		String RecordCheckbox ="@css=input[value='"+Status+"']";

		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			waitForElementToAppear(filterIconRecordsMonth,5);
			click(filterIconRecordsMonth, "Status Filter Icon");
			sleep(2000);
			waitForElementToAppear(SearchTextBDType,5);
			if(isVisible(SearchTextBDType))
			{
				verifyMustExists(SearchTextBDType,"Search Filter Textbox");	
				sendKeys(SearchTextBDType,Status,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);
		waitForElementToAppear(RecordCheckbox,5);
		click(RecordCheckbox, "Searched Record Checkbox");
		String StatusfilterBtn = "@xpath=//input[@value='"+Status+"']//following::button[@type='submit']";
		verifyExists(StatusfilterBtn,"Filter Button");
		click(StatusfilterBtn,"Filter Button");
		sleep(3000);
		//sleep(2000);
	}

	public void applyTypefilterAndVerifyApprov(String Type, String Status) throws InterruptedException{
		waitForElementToAppear(ApprovedTab,5);
		verifyMustExists(ApprovedTab,"Approve Tab");
		click(ApprovedTab,"Approve Tab");

		int i=0;
		javaScriptWait();
		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			waitForElementToAppear(BodrTypFilterIcon,5);
			click(BodrTypFilterIcon, "Status Filter Icon");
			sleep(2000);
			if(isVisible(Type))
			{
				verifyMustExists(Type,"Type Textbox");	
				click(Type, "Type Checkbox");
				//sendKeys(SearchText,Status,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(Type) && i<5);
		waitForElementToAppear(BodrFilterBtn,5);
		verifyMustExists(BodrFilterBtn,"Filter Button");
		click(BodrFilterBtn,"Filter Button");
		sleep(3000);
		applyStatusFilter(Status);
		List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
		int recordsCount = totatRecords.size();
		for(int a=1;a<=recordsCount;a++){	
			click(FrApprovalbtn,"For Approval btn");
			sleep(2000);
			if(isEnable(UnApprvBdrBtn)==false){
				Report.LogInfo("ButtonCheck", "Button is disable", "PASS");
			}else{
				Report.LogInfo("ButtonCheck", "Button is enable", "FAIL");
			}
			goBack();
		}	
	}

	public void verificationCountsAfterReviewButton(int expectedCount){

		waitForElementToAppear(RiskTabAfterReview,3);
		verifyMustExists(RiskTabAfterReview,"Risk Tab");
		click(RiskTabAfterReview,"Risk Tab");
		sleep(4000);
		waitForElementToAppear(ChangePageCountDropDn,4);
		verifyMustExists(ChangePageCountDropDn,"Change Page Count Dropdown");
		click(ChangePageCountDropDn,"Change Page Count Dropdown");
		sleep(2000);
		click(ChangePageCountTo,"Change Page Count To");
		sleep(3000);
		List <WebElement> list = findWebElements(ActualExpectedRowCount);
		int count = list.size();
		sleep(2000);
		if(count == expectedCount)
		{
			Report.LogInfo("ValidateRecords", "Records count matches with the records in the excel file. Actual records count is: "+count, "PASS");
		}else{
			Report.LogInfo("ValidateRecords", "Records count does not match with the records in the excel file. Actual records count is: "+count, "FAIL");
		}
		sleep(2000);
		goBack();		
	}
	public void CalDateSelection (String Date)
	{
		waitForElementToAppear(Calender,5);
		verifyMustExists(Calender,"Calender");
		click(Calender,"Calender");
		sleep(2000);
		sendKeys(CalenderInputBox,Date,"Select period of date");
		sleep(1000);
		click(Calender,"Calender");
		sleep(2000);
	}

	public void SubmitBordereauxWithYesnoButtons(String Date) throws Exception{
		//navigateOnProcessingTab();
		String SubBdrwBtn = "@xpath=//div[@ng-if='!isProcessingDisabled']";
		waitForElementToAppear(BORDEREAUXLink,5);
		verifyMustExists(BORDEREAUXLink,"BORDEREAUX Link");
		click(BORDEREAUXLink,"BORDEREAUX Link");		
		sleep(3000);
		navigateOnProcessingTab();
		if(isVisible(SubBdrwBtn)==false){
			verifyMustExists(BORDEREAUXLink,"BORDEREAUX Link");
			javaScriptclick(BORDEREAUXLink,"BORDEREAUX Link");
			sleep(2000);
			navigateOnProcessingTab();
		}
	}

	public void SubmitBordereauxWithYesnoButtons1() throws Exception{
		//navigateOnProcessingTab();
		waitForElementToAppear(BORDEREAUXLink,5);
		verifyMustExists(BORDEREAUXLink,"BORDEREAUX Link");
		click(BORDEREAUXLink,"BORDEREAUX Link");
		sleep(3000);
		navigateOnProcessingTab();
		if (isVisible(BlankDetailsMsg)==true)
		{
			Report.LogInfo("StatusCheck", "No status records found", "PASS");
		}else{
			//sleep(2000);
			checkRecordsAndDeleteReviewError();
			refreshPage();
			//sleep(2000;);
			//checkRecordsAndDeleteReview();
		}
		sleep(2000);
	}
     public void SelectPauseButton() {
    		waitForElementToAppear(PauseButton,3);
    		if(isVisible(PauseButton)== true){

    			verifyMustExists(PauseButton,"Pause Button Button");
    			click(PauseButton,"Pause Button");
    			//waitForElementToAppear(YesCancelProcessing,5);
    		//verifyMustExists(YesCancelProcessing,"Yes Cancel Processing button");
    			//click(YesCancelProcessing,"Yes Cancel Processing button");
    			sleep(3000); 
    		}else{
    			Report.LogInfo("ErrorScreen", "Expected error screen not displayed.", "FAIL");
    			goBack();
    		} 
     }
	public void SelectYesNoAndDeleteProcessing(String YesNo){
		waitForElementToAppear(CancelProcessingButton,3);
		if(isVisible(CancelProcessingButton)== true){

			verifyMustExists(CancelProcessingButton,"Cancel Processing Button");
			click(CancelProcessingButton,"Cancel Processing Button");
			waitForElementToAppear(YesCancelProcessing,5);
		verifyMustExists(YesCancelProcessing,"Yes Cancel Processing button");
			click(YesCancelProcessing,"Yes Cancel Processing button");
			sleep(3000);
		}else{
			Report.LogInfo("ErrorScreen", "Expected error screen not displayed.", "FAIL");
			goBack();
		}
	}



	public void ApplyDueDateFilter(String Date, String DateValue){
		waitForElementToAppear(DuteDatefilterIcon,8);
		verifyMustExists(DuteDatefilterIcon,"Due Date filter");
		click(DuteDatefilterIcon,"Due Date filter");
		waitForElementToAppear(DuteDatefilterIconInputBox,5);
		verifyMustExists(DuteDatefilterIconInputBox,"Due Date filter Icon Input Box");
		sendKeys(DuteDatefilterIconInputBox,Date,"Due Date filter Icon Input Box");
		sleep(2000);
		if(isVisible(DueDateCheckbx)==true){
			webDriver.findElement(By.cssSelector(".k-reset.k-multicheck-wrap>li>label>input[value='"+DateValue+"']")).click();
			verifyMustExists(DueDateFiterBtn,"Due Date filter Button");
			click(DueDateFiterBtn,"Due Date filter Button");
			sleep(2000);
		}
	}

	public void SelectYesNoAndContinueProcessing(String YesNo){
		waitForElementToAppear(CancelAndDeleteBordereauxSp2,8);
		if(isVisible(By.xpath("//*[@id='content']//div[@class='top_error']//label["+YesNo+"]"))== true)
		{
			webDriver.findElement(By.xpath("//*[@id='content']//div[@class='top_error']//label["+YesNo+"]")).click();
		}else{
			Report.LogInfo("YesNoButtonsCheck", "Yes button is not present on screen", "PASS");
		}
		if(isVisible(ContinueProcessingBodrBtn)== true){
			verifyMustExists(ContinueProcessingBodrBtn,"Continue Processing button");
			click(ContinueProcessingBodrBtn,"Continue Processing button");
		}else{
			goBack();
		}
	}
	public void clickOnSkipAllErrorBTN1(){
		waitForElementToAppear(SkippAllErroBtn1,10);
		verifyMustExists(SkippAllErroBtn1,"Skipp All Error Button");
		click(SkippAllErroBtn1,"Skipp All Error Button");
	}


	public void clickOnSkipAllErrorBTN(){
		waitForElementToAppear(SkippAllErroBtn,10);
		verifyMustExists(SkippAllErroBtn,"Skipp All Error Button");
		click(SkippAllErroBtn,"Skipp All Error Button");
	}

	public void clickOnSubProcessRcdBtn(){
		waitForElementToAppear(SubProcessRcdBtn,10);
		verifyMustExists(SubProcessRcdBtn,"Submit process record Button");
		click(SubProcessRcdBtn,"Submit process record Button");
	}

	public void clickOnSubAssesmntBtn(){
		waitForElementToAppear(SubAssesmntBtn,10);
		verifyMustExists(SubAssesmntBtn,"Submit Assesment Button");
		click(SubAssesmntBtn,"Submit Assesment Button");
	}

	public void clickOnApproveBordBtn(){
		waitForElementToAppear(ApproveBordBtn,10);
		verifyMustExists(ApproveBordBtn,"Approve Bordereau Button");
		
		click(ApproveBordBtn,"Approve Bordereau Button");
		sleep(2000);
	}

	public void clickOnApproveBordBtn1(){
		waitForElementToAppear(ApproveBordBtn,10);
		verifyMustExists(ApproveBordBtn,"Approve Bordereau Button");
		javaScriptclick(ApproveBordBtn,"Approve Bordereau Button");
		sleep(2000);
	}

	public static final String refFilter ="@xpath=//*[@id='grid']//tr[7]//td[39][@class='bgm-green']";

	public void verifyErrorScreen(String ExpectedErrorMsg )
	{
		verifyExists(ErrorScreenMsg,"Error Screen Message");
		String ActualErrorMsg=getTextFrom(ErrorScreenMsg);
		if(ActualErrorMsg.equals(ExpectedErrorMsg))
		{
			Report.LogInfo("ValidateErrorMsg", "Error Message validate successfully", "PASS");	
			verifyMustExists(CancelProcessingBtn,"Cancel Processing And Delete Bordereau");
			click(CancelProcessingBtn," Click on Cancel Processing And Delete Bordereau");	
			sleep(3000);
		}
		else
		{
			Report.LogInfo("ValidateErrorMsg", "Error Message not validate successfully", "Fail");
			goBack();
			sleep(3000);
			deleteBorderEAUX();				
		}

	}

	public void openDATALink()
	{
		waitForElementToAppear(DATAlink,5);
		verifyMustExists(DATAlink,"DATA Link");
		for(int i= 0; i<=5; i++)
		{
			click(DATAlink,"Data link");
			sleep(2000);
			if(isVisible(DATARiskTab)==true)
			{
				break;
			}
		}
	}

	public void navigateToDATATab()
	{
		String Summary = "@xpath=.//a[text()='Summary']";
		waitForElementToAppear(DATAlink,5);
		verifyMustExists(DATAlink,"Data Tab");
		click(DATAlink,"Click on Data Tab");
		sleep(3000);
		if(isVisible(Summary)==false){
			verifyMustExists(DATAlink,"Data Tab");
			javaScriptclick(DATAlink,"Click on Data Tab");
		}

	}

	public void navigateToDATAClaimTab()
	{
		waitForElementToAppear(DATAClaimTab,5);
		verifyMustExists(DATAClaimTab,"Claim Tab");
		click(DATAClaimTab,"Click on Claim Tab");
		sleep(3000);
	}

	public void navigateToDATAPremiumTab()
	{
		waitForElementToAppear(DATAPremiumTab,5);
		verifyMustExists(DATAPremiumTab,"Claim Tab");
		click(DATAPremiumTab,"Click on Claim Tab");
		sleep(3000);
	}

	public void  selectRowNumberAscOrder()
	{
		verifyMustExists(RowNumber,"Row Number");
		click(RowNumber,"Click on Row Number");
		sleep(3000);
		verifyMustExists(RowNumberAscIcon,"Row Number Ascending icon");  
		sleep(3000);
	}

	public void renewalYNTransactionType_February_3760() throws Exception{
		String DateMonth = "February 2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");	
			SubmitBordereauxWithYesnoButtons(DateMonth);
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3760Path = fpath+"\\src\\test\\resources\\testdata\\February 2017_TC_3760.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3760Path);  
			String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"February 2017_TC_3760.xlsx\",\"UniqueFileName\":\"S46528420171113.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S46528420171113.xlsx\",\"Filesize\":20276,\"Path\":null,\"size\":20276,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(isVisible(ReviewBtn)==true){
				Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			}
			else{
				Report.LogInfo("ReviewStatusValidation", "Review Status Button not Displayed", "FAIL");
			}
		}else{
			Report.LogInfo("SignedStatusValidation", "Signed Status not displayed", "FAIL");
		}	
	}

	public void mappingIncrementalIncrease_3762() throws Exception{
		ActualCount=ActualCount+1;
		System.out.println(ActualCount);
		String OriginalValueName="Endorsement";	
		homePage.adminMenu();
		datasetPage.DatasetReferenceDataLink();
		datasetPage.DatasetReferenceDatapage();
		applyReferenceDataFilter("Boolean");
		waitForElementToAppear(BooleanName,5);
		verifyExists(BooleanName,"Boolean Name");
		click(BooleanName,"Boolean Name");
		datasetPage.selectMappingsTab();
		datasetPage.applyOriginalNameFilter(OriginalValueName);
		waitForElementToAppear(MappingTotalCount,5);
		verifyExists(MappingTotalCount,"Mapping Total Count");
		String ActualCount1 = getTextFrom(MappingTotalCount);
		int ActualCount2 = Integer.parseInt(ActualCount1);
		if(ActualCount2 == ActualCount)
		{
			Report.LogInfo("ValidateCount", "Increment Count validate successfully", "PASS");	
		}
		else
		{
			Report.LogInfo("ValidateCount", "Increment Count not validate successfully", "FAIL");
		}
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(SignedBtn)== true){
			waitForElementToAppear(BORDEREAUXLink,5);
			verifyMustExists(BORDEREAUXLink,"BORDEREAUX Link");
			click(BORDEREAUXLink,"BORDEREAUX Link");
			sleep(3000);
			deleteBorderEAUX();
		}
	}

	public void TC4476_CalculateTaxBySelecting_Yes_OnlyOne_option() throws Exception
	{
		String subSheet = "Tax calculations";
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

		String IncDate = "01/01/2017";
		String ExpDate = "31/12/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.addPolicy2(IncDate,ExpDate);
		verifyExists(DraftBtn,"Draft Status Button");
		policy.contractId = ReturnContractID();
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();

		//String GetData = Configuration.url+"/api/Contract/GetAllPage";
		//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		SubmitBordereaux(subSheet);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4476Path = fpath+"\\src\\test\\resources\\testdata\\Taxes calculation_4476.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4476Path);  
		//contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Taxes calculation_4476.xlsx\",\"UniqueFileName\":\"S88205320180303.xlsx\",\"BordereauFormatId\":\"853fa27f-daa6-4f53-9f2b-56ea7d39b969\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S88205320180303.xlsx\",\"Filesize\":23447,\"Path\":null,\"size\":23447,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Taxes calculation_4476.xlsx\",\"UniqueFileName\":\"S56207520180303.xlsx\",\"BordereauFormatId\":\"1946382b-1d38-4da4-9c80-7cabf9cf51d7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S56207520180303.xlsx\",\"Filesize\":23447,\"Path\":null,\"size\":23447,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)== true){
			Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			sleep(2000);
			selectRowNumberAscOrder();

			//Total Tax % Column 
			String TotalTax_Percolumn="@xpath=//*[@data-field='Tax_Total_Percent']";
			String TotalTaxcolumn_Value1="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][1]";
			String TotalTaxcolumn_Value2="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][2]";
			String TotalTaxcolumn_Value3="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][3]";
			String TotalTaxcolumn_Value4="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][4]";
			String TotalTaxcolumn_Value5="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][5]";
			String TotalTaxcolumn_Value6="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][6]";
			String TotalTaxcolumn_Value7="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][7]";
			String TotalTaxcolumn_Value8="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][8]";
			String TotalTaxcolumn_Value9="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][9]";
			String TotalTaxcolumn_Value10="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][10]";
			String TotalTaxcolumn_Value11="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][11]";
			waitForElementToAppear(TotalTax_Percolumn,20);
			mouseOverAction(TotalTax_Percolumn);
			verifyMustExists(TotalTax_Percolumn,"Total Tax Percentage column");
			sleep(2000);
			verifyExists(TotalTaxcolumn_Value1,"1st value");
			verifyExists(TotalTaxcolumn_Value2,"2nd value");
			verifyExists(TotalTaxcolumn_Value3,"3rd value");
			verifyExists(TotalTaxcolumn_Value4,"4th value");
			verifyExists(TotalTaxcolumn_Value5,"5th value");
			verifyExists(TotalTaxcolumn_Value6,"6th value");
			verifyExists(TotalTaxcolumn_Value7,"7th value");
			verifyExists(TotalTaxcolumn_Value8,"8th value");
			verifyExists(TotalTaxcolumn_Value9,"9th value");
			verifyExists(TotalTaxcolumn_Value10,"10th value");
			verifyExists(TotalTaxcolumn_Value11,"11th value");
			sleep(2000);

			//Tax Fixed Rate 1 Column
			String Tax_FixedRateColumn="@xpath=//*[@data-field='Tax_Fixed_Rate_1']";
			String Tax_FixedRateColumn_Value1="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][1]";
			String Tax_FixedRateColumn_Value2="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][2]";
			String Tax_FixedRateColumn_Value3="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][3]";
			String Tax_FixedRateColumn_Value4="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][4]";
			String Tax_FixedRateColumn_Value5="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][5]";
			String Tax_FixedRateColumn_Value6="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][6]";
			String Tax_FixedRateColumn_Value7="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][7]";
			String Tax_FixedRateColumn_Value8="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][8]";
			String Tax_FixedRateColumn_Value9="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][9]";
			String Tax_FixedRateColumn_Value10="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][10]";
			String Tax_FixedRateColumn_Value11="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][11]";
			waitForElementToAppear(Tax_FixedRateColumn,20);
			mouseOverAction(Tax_FixedRateColumn);
			verifyMustExists(Tax_FixedRateColumn,"Tax Fixed Rate 1 column");
			sleep(2000);
			verifyExists(Tax_FixedRateColumn_Value1,"1st value");
			verifyExists(Tax_FixedRateColumn_Value2,"2nd value");
			verifyExists(Tax_FixedRateColumn_Value3,"3rd value");
			verifyExists(Tax_FixedRateColumn_Value4,"4th value");
			verifyExists(Tax_FixedRateColumn_Value5,"5th value");
			verifyExists(Tax_FixedRateColumn_Value6,"6th value");
			verifyExists(Tax_FixedRateColumn_Value7,"7th value");
			verifyExists(Tax_FixedRateColumn_Value8,"8th value");
			verifyExists(Tax_FixedRateColumn_Value9,"9th value");
			verifyExists(Tax_FixedRateColumn_Value10,"10th value");
			verifyExists(Tax_FixedRateColumn_Value11,"11th value");
			sleep(2000);

			//Tax Multiplier 1 Column
			String Tax_MultiplierColumn="@xpath=//*[@data-field='Tax_Multiplier_1']";
			String Tax_MultiplierColumn_Value1="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][1]";
			String Tax_MultiplierColumn_Value2="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][2]";
			String Tax_MultiplierColumn_Value3="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][3]";
			String Tax_MultiplierColumn_Value4="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][4]";
			String Tax_MultiplierColumn_Value5="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][5]";
			String Tax_MultiplierColumn_Value6="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][6]";
			String Tax_MultiplierColumn_Value7="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][7]";
			String Tax_MultiplierColumn_Value8="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][8]";
			String Tax_MultiplierColumn_Value9="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][9]";
			String Tax_MultiplierColumn_Value10="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][10]";
			String Tax_MultiplierColumn_Value11="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][11]";
			waitForElementToAppear(Tax_MultiplierColumn,20);
			mouseOverAction(Tax_MultiplierColumn);
			verifyMustExists(Tax_MultiplierColumn,"Tax Multiplier 1 column");
			sleep(2000);
			verifyExists(Tax_MultiplierColumn_Value1,"1st value");
			verifyExists(Tax_MultiplierColumn_Value2,"2nd value");
			verifyExists(Tax_MultiplierColumn_Value3,"3rd value");
			verifyExists(Tax_MultiplierColumn_Value4,"4th value");
			verifyExists(Tax_MultiplierColumn_Value5,"5th value");
			verifyExists(Tax_MultiplierColumn_Value6,"6th value");
			verifyExists(Tax_MultiplierColumn_Value7,"7th value");
			verifyExists(Tax_MultiplierColumn_Value8,"8th value");
			verifyExists(Tax_MultiplierColumn_Value9,"9th value");
			verifyExists(Tax_MultiplierColumn_Value10,"10th value");
			verifyExists(Tax_MultiplierColumn_Value11,"11th value");
			sleep(2000);

			//Taxable_Premium_1 Column
			String Taxable_Premium_Column="@xpath=//*[@data-field='Taxable_Premium_1']";
			String Taxable_Premium_1_Value1="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][1]";
			String Taxable_Premium_1_Value2="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][2]";
			String Taxable_Premium_1_Value3="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][3]";
			String Taxable_Premium_1_Value4="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][4]";
			String Taxable_Premium_1_Value5="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][5]";
			String Taxable_Premium_1_Value6="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][6]";
			String Taxable_Premium_1_Value7="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][7]";
			String Taxable_Premium_1_Value8="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][8]";
			String Taxable_Premium_1_Value9="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][9]";
			String Taxable_Premium_1_Value10="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][10]";
			String Taxable_Premium_1_Value11="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][11]";
			waitForElementToAppear(Taxable_Premium_Column,20);
			mouseOverAction(Taxable_Premium_Column);
			verifyMustExists(Taxable_Premium_Column,"Taxable Premium Column");
			sleep(2000);
			verifyExists(Taxable_Premium_1_Value1,"1st value");
			verifyExists(Taxable_Premium_1_Value2,"2nd value");
			verifyExists(Taxable_Premium_1_Value3,"3rd value");
			verifyExists(Taxable_Premium_1_Value4,"4th value");
			verifyExists(Taxable_Premium_1_Value5,"5th value");
			verifyExists(Taxable_Premium_1_Value6,"6th value");
			verifyExists(Taxable_Premium_1_Value7,"7th value");
			verifyExists(Taxable_Premium_1_Value8,"8th value");
			verifyExists(Taxable_Premium_1_Value9,"9th value");
			verifyExists(Taxable_Premium_1_Value10,"10th value");
			verifyExists(Taxable_Premium_1_Value11,"11th value");
			sleep(2000);
			policy.navigationOnBordereauxTab();
			refreshUploadedFile();
			deleteBorderEAUX();
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
			//goBack();
			deleteBorderEAUX();				
		}
	}

	public void TC4477_CalculateTaxWithOutadditonalTax() throws Exception
	{
		String subSheet = "Tax calculation multiple";
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

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.contractId = ReturnContractID();
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Taxes calculation_4477.xlsx\",\"UniqueFileName\":\"S14012520180126.xlsx\",\"BordereauFormatId\":\"9702db79-ebea-4548-aa1e-7d1da9e07f23\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S14012520180126.xlsx\",\"Filesize\":23453,\"Path\":null,\"size\":23453,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4477Path = fpath+"\\src\\test\\resources\\testdata\\Taxes calculation_4477.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3216Path);
		//UploadFile(filePath);
		File excelFile = new File(sheet4477Path);  
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)== true){
			Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
			openDATALink();
			navigateToDATARiskTab();

			//Total Tax % Column 
			String TotalTax_Percolumn="@xpath=//*[@data-field='Tax_Total_Percent']";
			String TotalTaxcolumn_Value1="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][1]";
			String TotalTaxcolumn_Value2="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][2]";
			String TotalTaxcolumn_Value3="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][3]";
			String TotalTaxcolumn_Value4="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][4]";
			String TotalTaxcolumn_Value5="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][5]";
			String TotalTaxcolumn_Value6="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][6]";
			String TotalTaxcolumn_Value7="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][7]";
			String TotalTaxcolumn_Value8="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][8]";
			String TotalTaxcolumn_Value9="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][9]";
			String TotalTaxcolumn_Value10="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][10]";
			String TotalTaxcolumn_Value11="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][11]";
			waitForElementToAppear(TotalTax_Percolumn,20);
			mouseOverAction(TotalTax_Percolumn);
			verifyMustExists(TotalTax_Percolumn,"Total Tax Percentage column");
			sleep(2000);
			verifyExists(TotalTaxcolumn_Value1,"1st value");
			verifyExists(TotalTaxcolumn_Value2,"2nd value");
			verifyExists(TotalTaxcolumn_Value3,"3rd value");
			verifyExists(TotalTaxcolumn_Value4,"4th value");
			verifyExists(TotalTaxcolumn_Value5,"5th value");
			verifyExists(TotalTaxcolumn_Value6,"6th value");
			verifyExists(TotalTaxcolumn_Value7,"7th value");
			verifyExists(TotalTaxcolumn_Value8,"8th value");
			verifyExists(TotalTaxcolumn_Value9,"9th value");
			verifyExists(TotalTaxcolumn_Value10,"10th value");
			verifyExists(TotalTaxcolumn_Value11,"11th value");
			sleep(2000);
			policy.navigationOnBordereauxTab();
			refreshUploadedFile();
			deleteBorderEAUX();
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
			goBack();
			deleteBorderEAUX();				
		}
	}

	public void CalculateTaxWithadditonalTax_TC4478() throws Exception
	{
		String subSheet = "Tax calculation multiple yes";

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

		applyFilterPolicy(policy.PolicyNumber);
		//applyFilterPolicy("754992RB");

		openSelectedPolicy();
		policy.contractId = ReturnContractID();
		//String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Taxes calculation -TC_4478.xlsx\",\"UniqueFileName\":\"S69964620180105.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S69964620180105.xlsx\",\"Filesize\":24013,\"Path\":null,\"size\":24013,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Taxes calculation -TC_4478.xlsx\",\"UniqueFileName\":\"S34946220180219.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S34946220180219.xlsx\",\"Filesize\":23460,\"Path\":null,\"size\":23460,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4478Path = fpath+"\\src\\test\\resources\\testdata\\Taxes calculation -TC_4478.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3216Path);
		//UploadFile(filePath);
		File excelFile = new File(sheet4478Path);  
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)== true){
			Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
			openDATALink();
			navigateToDATARiskTab();

			//Tax 1 Column 
			String Tax_1column="@xpath=//*[@data-field='Tax_1']";
			String Tax_1columnValue="@xpath=//*[@data-field='Tax_1']//following::tr[1]//td[contains(@ng-click,'Tax_1')]";
			String Tax_2columnValue="@xpath=//*[@data-field='Tax_2']//following::tr[1]//td[contains(@ng-click,'Tax_2')]";
			String TotalTaxcolumn_Value="@xpath=//*[@data-field='Tax_Total']//following::tr[1]//td[contains(@ng-click,'Tax_Total')]";

			sleep(2000);
			mouseOverAction(Tax_1columnValue);
			String Tax1 = getTextFrom(Tax_1columnValue).replace(".00", "");
			mouseOverAction(Tax_2columnValue);
			String Tax2 = getTextFrom(Tax_2columnValue).replace(".00", "");
			int Total_Tax = Integer.parseInt(Tax1)+Integer.parseInt(Tax2);
			//System.out.println(Tax1);
			//System.out.println(Tax2);
			//System.out.println(Total_Tax);
			mouseOverAction(TotalTaxcolumn_Value);
			String Total_TaxActualValue = getTextFrom(TotalTaxcolumn_Value).replace(".00", "");
			//System.out.println(Total_TaxActualValue);
			if(Integer.toString(Total_Tax).equals(Total_TaxActualValue))
			{
				Report.LogInfo("ValidateTotalTax", "Total Tax value is correct", "Pass");
			}
			else{
				Report.LogInfo("ValidateTotalTax", "Total Tax value is not correct", "Fail");
			}


			String Tax_1_Percentage_columnValue="@xpath=//*[@data-field='Tax_Percent_1']//following::tr[1]//td[contains(@ng-click,'Tax_Percent_1')]";
			String Tax_2_Percentage_columnValue="@xpath=//*[@data-field='Tax_Percent_2']//following::tr[1]//td[contains(@ng-click,'Tax_Percent_2')]";
			String TotalTax_Percent_columnValue="@xpath=//*[@data-field='Tax_Total_Percent']//following::tr[1]//td[contains(@ng-click,'Tax_Total_Percent')][text()='11.00 %']";

			mouseOverAction(Tax_1_Percentage_columnValue);
			String Tax1_per =getTextFrom(Tax_1_Percentage_columnValue).replace("%", "");
			mouseOverAction(Tax_2_Percentage_columnValue);
			String Tax2_per = getTextFrom(Tax_2_Percentage_columnValue).replace("%", "");
			float Total_Tax_per =Float.parseFloat(Tax1_per)+Float.parseFloat(Tax2_per);
			mouseOverAction(TotalTax_Percent_columnValue);
			String Total_Per_Tax = Float.toString(Total_Tax_per);
			String Total_Tax_perActualValue = getTextFrom(TotalTax_Percent_columnValue).replace("0 %", "");

			if(Total_Per_Tax.equals(Total_Tax_perActualValue))
			{
				Report.LogInfo("ValidateTotalTax", "Total Tax % value is correct", "Pass");
			}
			else{
				Report.LogInfo("ValidateTotalTax", "Total Tax % value is not correct", "Fail");
			}
			policy.navigationOnBordereauxTab();
			refreshUploadedFile();
			deleteBorderEAUX();				
		}

		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
			policy.navigationOnBordereauxTab();
			refreshUploadedFile();
			deleteBorderEAUX();				
		}		
	}


	public void recordsinContract_5308() throws Exception{
		String UniqueReferenceVal1 = "Automation 11"+getCurrentDateTimeMS();
		String UniqueReferenceVal2 = "Automation 22"+getCurrentDateTimeMS();
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String IncDate1 = "01/01/2018";
		String ExpDate1="31/12/2018";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String subSheet = "SP - First Sheet";
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
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails1(UniqueReferenceVal1, IncDate,ExpDate, Status1, policy.Broker1, policy.Bline1, policy.Underline1);
		waitForElementToAppear(DraftBtn,5);
		verifyExists(DraftBtn,"Draft Status Button");
		policy.changeStatusToQuote();
		policy.contractId = ReturnContractID();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		waitForElementToAppear(MainEditdot,3);
		verifyMustExists(MainEditdot,"Edit dot");
		click(MainEditdot,"Edit dot");
		waitForElementToAppear(CreateContract,3);
		verifyMustExists(CreateContract,"Create Contract");
		click(CreateContract,"Create Contract");
		sleep(2000);
		policy.addPolicyContractDetails1(UniqueReferenceVal2, IncDate1,ExpDate1, Status1, policy.Broker1, policy.Bline1, policy.Underline1);
		waitForElementToAppear(DraftBtn,5);
		verifyExists(DraftBtn,"Draft Status Button");
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		scrollUp();
		policy.navigationOnBordereauxTab();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet5308Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_5308.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet5308Path);  

		String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_5308.xlsx\",\"UniqueFileName\":\"S79708620180320.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S79708620180320.xlsx\",\"Filesize\":25551,\"Path\":null,\"size\":25551,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true)
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error", "PASS");
			if(isVisible(TransformationErrorScreen)== true){
				Report.LogInfo("ValidateExpectedScreen", "Expected Error Screen Displayed", "PASS");
				verifyMustExists(TransformationErrorScreen,"Transformation Error Screen");
				waitForElementToAppear(YesBtn,3);
				click(YesBtn,"Yes Radio button");
				sleep(2000);
				waitForElementToAppear(ContinueProcessingBodrBtn,3);
				verifyMustExists(ContinueProcessingBodrBtn,"Continue Processing Bordereau");
				click(ContinueProcessingBodrBtn,"Continue Processing Bordereau");
				refreshUploadedFile();
				if(isVisible(ReviewBtn)== true){
					Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
					openDATALink();
					navigateToDATARiskTab();
					//Year OF Account
					String YearOfAccountColumn ="@xpath=//*[@data-field='YearOfAccount']";
					String YearOfAccountValue1 ="@xpath=//*[@data-field='YearOfAccount']//following::tr[1]//td[contains(@ng-click,'YearOfAccount')][text()='2018']";
					String YearOfAccountValue2 ="@xpath=//*[@data-field='YearOfAccount']//following::tr[2]//td[contains(@ng-click,'YearOfAccount')][text()='2018']";
					String YearOfAccountValue3 ="@xpath=//*[@data-field='YearOfAccount']//following::tr[3]//td[contains(@ng-click,'YearOfAccount')][text()='2018']";
					String YearOfAccountValue4 ="@xpath=//*[@data-field='YearOfAccount']//following::tr[4]//td[contains(@ng-click,'YearOfAccount')][text()='2018']";
					String YearOfAccountValue5 ="@xpath=//*[@data-field='YearOfAccount']//following::tr[5]//td[contains(@ng-click,'YearOfAccount')][text()='2018']";
					waitForElementToAppear(YearOfAccountColumn,5);
					mouseOverAction(YearOfAccountColumn);
					verifyMustExists(YearOfAccountColumn,"Total Tax Percentage column");
					sleep(2000);
					verifyExists(YearOfAccountValue1,"1st value");
					verifyExists(YearOfAccountValue2,"2st value");
					verifyExists(YearOfAccountValue3,"3st value");
					verifyExists(YearOfAccountValue4,"4st value");
					verifyExists(YearOfAccountValue5,"5st value");
					sleep(2000);
					//Risk Reference 
					String RiskReferenceColumn ="@xpath=//*[@data-field='RiskReference']";
					String RiskReference1 ="@xpath=//*[@data-field='RiskReference']//following::tr[1]//td[contains(@ng-click,'RiskReference')][text()='10']";
					String RiskReference2 ="@xpath=//*[@data-field='RiskReference']//following::tr[2]//td[contains(@ng-click,'RiskReference')][text()='6']";
					String RiskReference3 ="@xpath=//*[@data-field='RiskReference']//following::tr[3]//td[contains(@ng-click,'RiskReference')][text()='7']";
					String RiskReference4 ="@xpath=//*[@data-field='RiskReference']//following::tr[4]//td[contains(@ng-click,'RiskReference')][text()='8']";
					String RiskReference5 ="@xpath=//*[@data-field='RiskReference']//following::tr[5]//td[contains(@ng-click,'RiskReference')][text()='9']";
					waitForElementToAppear(RiskReferenceColumn,5);
					mouseOverAction(RiskReferenceColumn);
					verifyMustExists(RiskReferenceColumn,"Total Tax Percentage column");
					sleep(2000);
					verifyExists(RiskReference1,"1st value");
					verifyExists(RiskReference2,"2st value");
					verifyExists(RiskReference3,"3st value");
					verifyExists(RiskReference4,"4st value");
					verifyExists(RiskReference5,"5st value");
					sleep(2000);
					policy.navigateContarctDetailsTab();
					sleep(2000);
					waitForElementToAppear(MultiContractBtn,5);
					verifyMustExists(MultiContractBtn,"Multicontract selection btn");
					click(MultiContractBtn,"Multicontract selection btn");
					waitForElementToAppear(Contract2017,5);
					verifyMustExists(Contract2017,"2017 contract option");
					click(Contract2017,"2017 contract option");
					sleep(2000);
					openDATALink();
					navigateToDATARiskTab();
					//Year OF Account
					String YearOfAccount2017Value1 ="@xpath=//*[@data-field='YearOfAccount']//following::tr[1]//td[contains(@ng-click,'YearOfAccount')][text()='2017']";
					String YearOfAccount2017Value2 ="@xpath=//*[@data-field='YearOfAccount']//following::tr[2]//td[contains(@ng-click,'YearOfAccount')][text()='2017']";
					String YearOfAccount2017Value3 ="@xpath=//*[@data-field='YearOfAccount']//following::tr[3]//td[contains(@ng-click,'YearOfAccount')][text()='2017']";
					String YearOfAccount2017Value4 ="@xpath=//*[@data-field='YearOfAccount']//following::tr[4]//td[contains(@ng-click,'YearOfAccount')][text()='2017']";
					String YearOfAccount2017Value5 ="@xpath=//*[@data-field='YearOfAccount']//following::tr[5]//td[contains(@ng-click,'YearOfAccount')][text()='2017']";
					waitForElementToAppear(YearOfAccountColumn,5);
					mouseOverAction(YearOfAccountColumn);
					verifyMustExists(YearOfAccountColumn,"Total Tax Percentage column");
					sleep(2000);
					verifyExists(YearOfAccount2017Value1,"1st value");
					verifyExists(YearOfAccount2017Value2,"2st value");
					verifyExists(YearOfAccount2017Value3,"3st value");
					verifyExists(YearOfAccount2017Value4,"4st value");
					verifyExists(YearOfAccount2017Value5,"5st value");
					sleep(2000);
					//Risk Reference 
					String RiskReference2017value1 ="@xpath=//*[@data-field='RiskReference']//following::tr[1]//td[contains(@ng-click,'RiskReference')][text()='1']";
					String RiskReference2017value2 ="@xpath=//*[@data-field='RiskReference']//following::tr[2]//td[contains(@ng-click,'RiskReference')][text()='2']";
					String RiskReference2017value3 ="@xpath=//*[@data-field='RiskReference']//following::tr[3]//td[contains(@ng-click,'RiskReference')][text()='3']";
					String RiskReference2017value4 ="@xpath=//*[@data-field='RiskReference']//following::tr[4]//td[contains(@ng-click,'RiskReference')][text()='4']";
					String RiskReference2017value5 ="@xpath=//*[@data-field='RiskReference']//following::tr[5]//td[contains(@ng-click,'RiskReference')][text()='5']";
					waitForElementToAppear(RiskReferenceColumn,5);
					mouseOverAction(RiskReferenceColumn);
					verifyMustExists(RiskReferenceColumn,"Total Tax Percentage column");
					sleep(2000);
					verifyExists(RiskReference2017value1,"1st value");
					verifyExists(RiskReference2017value2,"2st value");
					verifyExists(RiskReference2017value3,"3st value");
					verifyExists(RiskReference2017value4,"4st value");
					verifyExists(RiskReference2017value5,"5st value");
					sleep(2000);
				}else{
					Report.LogInfo("StatusCheck", "Review status not displayed.", "FAIL");
				}
			}else{
				Report.LogInfo("ValidateExpectedScreen", "Expected Error Screen not Displayed", "FAIL");
				goBack();	
			}
		}else{
			Report.LogInfo("ValidateReviewError", "Review Error Status not displayed.", "FAIL");				
		}
	}

	//----------------------------------Reusable fuctions for Sequence Rule---------------------------------//
	//-------------------------------------------------------------------------------------------------------//


	public void refreshAfterUploadedFileForReviewSatusAndUploadStatus() throws Exception
	{
		navigateOnProcessingTab(); 

		for(int i= 0; i<=25; i++)
		{
			sleep(3000);
			click(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			if(isVisible(ReviewError) || isVisible(UploadedButton)){
				//VerifyNotificationPopupAfterUpload();
				break;
			}
		}
	}

	public void uploadedDeleteButton(String status){
		verifyMustExists(UploadedDeleteButton,"UploadedDeleteButton");
		sleep(1500);
		webDriver.findElement(By.xpath("//button[text()='"+status+"']//following-sibling::span[1]/i")).click();
		waitForElementToAppear(UploadedDeleteYESButton,2);
		verifyMustExists(UploadedDeleteYESButton,"UploadedDeleteYESButton");
		click(UploadedDeleteYESButton,"UploadedDeleteYESButton");
		sleep(2000);
		Report.LogInfo("UploadedDeleteStatus", "UPLOADED status deleted successfully", "PASS");

	}

	public void navigateToDATARiskTab()
	{

		waitForElementToAppear(DATARiskTab,5);
		verifyMustExists(DATARiskTab,"Risk Tab");
		click(DATARiskTab,"Click on Risk Tab");
		sleep(3000);

	}

	public void yoaErrorScreenProcessing()
	{

		if(isVisible(discardRecords)== true){
			//verifyMustExists(discardRecords,"discard records button");
			verifyOptionalExists(ErrorScreenMsg,"Year of Account Errors");
			verifyMustExists(continuebtx,"Continue button");
			click(continuebtx,"Continue button");
			waitForElementToAppear(yearAccount,5);
			verifyMustExists(yearAccount,"Year Account field.");
			clearTextBox(yearAccount);//1 row
			sendKeys(yearAccount,"2017","Year Account field.");//1 row
			verifyMustExists(yearAccount1,"Year Account1 field.");
			clearTextBox(yearAccount1);//2 row
			sendKeys(yearAccount1,"2017","Year Account1 field.");//2 row
			sleep(2000);
			verifyBackground(yearAccount,"rgba(0, 97, 0, 1)");// 1 row
			verifyBackground(inceptionDate1,"rgba(0, 97, 0, 1)");
			verifyBackground(yearAccount1,"rgba(0, 97, 0, 1)");// 2 row
			verifyBackground(inceptionDate2,"rgba(0, 97, 0, 1)");
			verifyMustExists(continuebtn,"Continue button");
			click(continuebtn,"Continue button");
		}else{
			Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
			goBack();
			deleteBorderEAUX();		
		}

	}

	public static final String ApprovedButton = "@xpath=//button[text()='Approved']";
	public void refreshUploadedFileApprovedStatus() throws Exception
	{
		waitForElementToAppear(ApprovedTab,5);
		verifyMustExists(ApprovedTab,"Approve Tab");
		click(ApprovedTab,"Approve Tab");

		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;		
		do
		{
			sleep(3000);
			click(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;			
		}while((isVisible(ApprovedButton)==false) && (totalTime < 180000));
	}

	public void refreshUploadedFileForApproved() throws Exception
	{
		waitForElementToAppear(ApprovedTab,5);
		verifyMustExists(ApprovedTab,"Approve Tab");
		click(ApprovedTab,"Approve Tab");

		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;  
		do
		{
			sleep(3000);
			javaScriptclick(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;   
		}while((isVisible(Approvedbtn)==false) && (totalTime < 90000));
	}

	public void refreshUploadedFileForApprovedScndRw() throws Exception
	{
		waitForElementToAppear(ApprovedTab,5);
		verifyMustExists(ApprovedTab,"Approve Tab");
		click(ApprovedTab,"Approve Tab");

		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;  
		do
		{
			sleep(3000);
			javaScriptclick(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;   
		}while((isVisible(ApprovedbtnSncdRw)==false) && (totalTime < 90000));
	}

	public void refreshUploadedFileForApprovedthirdRw() throws Exception
	{
		waitForElementToAppear(ApprovedTab,5);
		verifyMustExists(ApprovedTab,"Approve Tab");
		click(ApprovedTab,"Approve Tab");

		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;  
		do
		{
			sleep(3000);
			click(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;   
		}while((isVisible(ApprovedbtnThirdRw)==false) && (totalTime < 90000));
	}


	public void refreshUploadedFile1() throws Exception
	{
		St1.navigateOnProcessingTab();

		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;		
		do
		{
			sleep(3000);
			click(RefreshAfterUpload1,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;			
		}while((isVisible(ReviewError)==false) && (isVisible(ReviewBtn)==false) && (totalTime < 180000));
	}

	public void OnViewDiscardedRecordsIcon()
	{
		waitForElementToAppear(ViewDiscardedRecordsIcon,10);
		verifyMustExists(ViewDiscardedRecordsIcon,"View Discarded Record's Icon");
		click(ViewDiscardedRecordsIcon,"View Discarded Record's Icon");
		sleep(3000); 
	}

	public void applyReferenceDataFilter(String DataName) throws InterruptedException{

		int i=0;
		String RecordCheckbox ="@css=[value='"+DataName+"']";
		sleep(2000);
		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(ReferenceDataFilterIcon, "Reference Data Filter Icon");
			sleep(2000);
			if(isVisible(SearchText))
			{
				verifyMustExists(SearchText,"Search Filter Textbox");	
				sendKeys(SearchText,DataName,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);

		click(RecordCheckbox, "Searched Record Checkbox");
		verifyMustExists(FilterButton,"Filter Button");
		click(FilterButton,"Filter Button");
		sleep(3000);
	}

	public void navigateOnProcessingTab(){
		waitForElementToAppear(Processingtab,5);
		verifyExists(Processingtab,"Processing Link");
		click(Processingtab,"Processing Link");
		sleep(2000); 
	}

	public void refreshAfterApproveFile(String ExpectedLocator) throws Exception
	{
		verifyExists(ApprovedTab,"Approved Tab");
		click(ApprovedTab,"Approved Tab");
		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;  
		do
		{
			sleep(3000);
			javaScriptclick(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;   
		}while((isVisible(ExpectedLocator)==false) && (totalTime < 180000));

	}


	public void refreshUploadedFileForApprovalStatus() throws Exception{
		waitForElementToAppear(Processingtab,5);
		verifyExists(Processingtab,"Processing Link");
		click(Processingtab,"Processing Link");
		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;		
		do
		{
			sleep(3000);
			click(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;			
		}while((isVisible(ForApprovalButton)==false) && (totalTime < 180000));
	}

	public void refreshUploadedFileForUploadedStatus() throws Exception{
		waitForElementToAppear(Processingtab,5);
		verifyExists(Processingtab,"Processing Link");
		click(Processingtab,"Processing Link");
		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;		
		do
		{
			sleep(3000);
			click(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;			
		}while((isVisible(UploadedButton)==false) && (totalTime < 180000));
	}

	public void navigationOnRoleTab()
	{
		waitForElementToAppear(Roletab,5);
		verifyMustExists(Roletab,"Role Tab");
		click(Roletab,"Role Tab");
	}

	public static final String ReportingChannelfilterIcon="@xpath=//th[@data-field='ReportingChannelIdentifier']//span[@class='k-icon k-i-filter']";
	/*public void applyReportingChannelIdentifyFilter(String Channel) throws InterruptedException{
		 	sleep(1500);
		   int i=0;
		   String RecordCheckbox ="@css=input[value='"+Channel+"']";
		   javaScriptWait();
		   do
		   {
		    if(i>0)
		    {
		     refreshPage();
		     javaScriptWait();
		    }
		    clickAndWait(ReportingChannelfilterIcon, "Reporting Channel Identify Filter Icon");
		    sleep(2000);
		    if(isVisible(SearchText))
		    {
		     verifyMustExists(SearchText,"Search Filter Textbox"); 
		     sendKeys(SearchText,Channel,"Search Filter Textbox.");
		     sleep(2000);
		    }
		    i++;
		   }while(!isVisible(RecordCheckbox) && i<5);
		   click(RecordCheckbox, "Searched Record Checkbox");
		   String StatusfilterBtn = "@xpath=//input[@value='"+Channel+"']//following::button[@type='submit']";
		   verifyExists(StatusfilterBtn,"Filter Button");
		   click(StatusfilterBtn,"Filter Button");
		   sleep(3000);
		  }*/

	//public static final String ReportingChannelfilterIcon="@xpath=//th[@data-field='ReportingChannelIdentifier']//span[@class='k-icon k-i-filter']";
	public static final String DATACreditControlTab="@xpath=//*[text()='Credit Control']";



	public void checkDeleteButtonMissingRowwise(){
		List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
		int recordsCount = totatRecords.size();
		for(int a=1;a<=recordsCount;a++){	
			String Deletebtn = "@xpath=//tr["+a+"]//button//following-sibling::span[1]/i";
			if(isVisible(Deletebtn)==false)
			{
				Report.LogInfo("ButtonCheck", "Delete button not displayed", "PASS");
			}else{
				Report.LogInfo("ButtonCheck", "Delete button displayed", "FAIL");
			}
		}
	}

	public void checkDeleteButtonpresentRowwise(){
		List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
		int recordsCount = totatRecords.size();
		for(int a=1;a<=recordsCount;a++){	
			String Deletebtn = "@xpath=//tr["+a+"]//button//following-sibling::span[1]/i";
			if(isVisible(Deletebtn)==true)
			{
				Report.LogInfo("ButtonCheck", "Delete button displayed", "PASS");
			}else{
				Report.LogInfo("ButtonCheck", "Delete button not displayed", "FAIL");
			}
		}
	}

	public void statusButtonNotclickableCheckRowwise() throws InterruptedException{
		List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
		int recordsCount = totatRecords.size();
		for(int a=1;a<=recordsCount;a++){	
			String statusbtn = "@xpath=//tr["+a+"]//td[2]//button";
			click(statusbtn,"Status button");
			sleep(2000);
			if(isVisible(statusbtn)==true)
			{
				Report.LogInfo("ButtonCheck", "status button not clickable", "PASS");
			}else{
				Report.LogInfo("ButtonCheck", "status button clickable", "FAIL");
				goBack();
				//applyBordereauTypeFilter(type);
			}
		}
	}

	public void applyReportingChannelIdentifyFilter(String Channel) throws InterruptedException{

		int i=0;
		String RecordCheckbox ="@css=input[value='"+Channel+"']";
		javaScriptWait();
		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(ReportingChannelfilterIcon, "Reporting Channel Identify Filter Icon");
			sleep(2000);
			if(isVisible(SearchText))
			{
				verifyMustExists(SearchText,"Search Filter Textbox");	
				sendKeys(SearchText,Channel,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);
		click(RecordCheckbox, "Searched Record Checkbox");
		String StatusfilterBtn = "@xpath=//input[@value='"+Channel+"']//following::button[@type='submit']";
		verifyExists(StatusfilterBtn,"Filter Button");
		click(StatusfilterBtn,"Filter Button");
		sleep(3000);
	}

	public void navigateToDATACreditControlTab()
	{
		waitForElementToAppear(DATACreditControlTab,5);
		verifyMustExists(DATACreditControlTab,"Credit control Tab");
		click(DATACreditControlTab,"Click on credit control Tab");
		sleep(3000);
	}

	public void navigateToApprovedTab()
	{
		waitForElementToAppear(ApprovedTab,5);
		verifyMustExists(ApprovedTab,"Approve Tab");
		click(ApprovedTab,"Approve Tab");
		sleep(2000);
	}
	public void VerifyReferenceColumn(){
		
		verifyMustExists(RiskReferenceTxt,"Risk Reference");
		verifyMustExists(CellTxt,"Cell");
		verifyMustExists(ORIGINALVALUETxt,"ORIGINAL VALUE");
		verifyMustExists(Enrichedvaluetxt,"Enriched Value");
		
	}
	

}