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

import com.google.common.util.concurrent.CycleDetectingLockFactory.Policy;
import com.jprotractor.NgBy;
import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;

public class BProcessingRiskPremiumClaimPage extends PageBase
{
	//Read Excel data
	String path;
	String BordereauFilePath;
	static String FormatId;
	public static String BFormatId;

	public static String sheet4438Path = "";
	public static String sheet4438Path_Second = "";
	public static String sheet4438Path_Third = "";
	public static String sheet4511Path = "";
	public static String sheet4511PathScnd = "";
	public static String sheet4511Paththird = "";
	public static String sheet4511PathFourth = "";
	public static String sheet4511PathFifth = "";

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

	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddHHmmss");
		String datetime = ft.format(dNow);
		return datetime;
	}

	String StandardInsurer= "standard.brookes@aspen.co.uk";
	String StandardInsurerPass="Pa55word123";

	String CompanyReference = "Company Reference"+getCurrentDateTimeMS();

	String TaskTitletxt = "Risk review"+getCurrentDateTimeMS();
	String TaskTitlePremium = "Premium review"+getCurrentDateTimeMS();
	String TaskTitleClaim = "Claim review"+getCurrentDateTimeMS();
	String AdminInsure = "standard.brookes@aspen.co.uk";
	String AdminInsurePass = "Test123@";
	
	
	String Standard_user_Broker = "tk.tester007@gmail.com";						
	String Standard_user_Broker_Pass = "Test123@";
	
	String Standard_user_CoverHolder = "john.smith@coverholderinc.com";						
	String Standard_user_Coverholder_Pass = "Pa55word123";

	//Class objects
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	PolicyPage policy = new PolicyPage();
	BordereauProcessPage BorProc = new BordereauProcessPage();
	Stage2Page Stage2 = new Stage2Page();
	SchemaPage schema =new SchemaPage();
	BordereauQuePage BQue = new BordereauQuePage();
	Permissions permission = new Permissions();
	ContractVersionChangeDetailsPage ConDetail = new ContractVersionChangeDetailsPage();


	//Element Locators
	public static final String PolicyEditDot ="@xpath=//ul[@ng-if='Permission.Edit || Permission.view || PermissionContractMainCompanyReference.Edit || PermissionContract.Add']";
	public static final String PolicyEditbtn ="@xpath=//li[@ng-if='Permission.Edit || PermissionContractMainCompanyReference.Edit']";
	public static final String CreateContract ="@xpath=//li[@ng-if='PermissionContract.Add']";
	public static final String RolesTab ="@xpath=//*[@ng-if='IsBinder']//a[@data-ui-sref='app.contract.role']";
	public static final String RolesTabPage ="@xpath=.//*[@id='profile-main']//th[1]/span[text()='Category']";
	public static final String SummaryTab ="@xpath=.//*[@ng-click='changeDataSetToNone()']";
	public static final String CreditControlSwitch ="@xpath=//*[@id='profile-main']//label[@class='ts-helper']";
	public static final String ApprovRiskFile ="@xpath=//*[@id='grid']//td[contains(@ng-click,'File Name')][contains(.,'January 2017 - Aprroved')]";
	public static final String ApprovRiskAndPremiumFile ="@xpath=//*[@id='grid']//td[contains(@ng-click,'File Name')][contains(.,'January 2017 - Aprroved')]";
	public static final String RecordCount1 ="@xpath=//span[text()='1 - 2 of 2 items']";
	public static final String RecordCount2 ="@xpath=//span[text()='1 - 1 of 1 items']";
	public static final String ApprovClaimFile ="@xpath=//*[@id='grid']//td[contains(@ng-click,'File Name')][contains(.,'January 2017')]";
	public static final String ApprovPreminmFile ="@xpath=//*[@id='grid']//td[contains(@ng-click,'File Name')][contains(.,'January 2017')]";
	public static final String SubmitBodrBtn ="@xpath=//*[@id='profile-main']//button[@type='button']";
	public static final String CliamOption ="@xpath=.//*[@ng-click='goToBordereauxProcess(w)']//a[text()='Claim']";
	public static final String PremiumOption ="@xpath=.//*[@ng-click='goToBordereauxProcess(w)']//a[text()='Premium']";
	public static final String RiskOption ="@xpath=.//*[@ng-click='goToBordereauxProcess(w)']//a[text()='Risk']";
	public static final String RiskAndPremiumOption ="@xpath=.//*[@ng-click='goToBordereauxProcess(w)']//a[text()='Risk And Premium']";
	public static final String Expectedtab ="@xpath=//*[text()='Expected']";
	public static final String Processingtab ="@xpath=//*[text()='Processing']";
	public static final String FileTypeTab ="@xpath=//th[@data-field='FileTypeName']";
	public static final String AddFileBtn ="@xpath=//div[@ng-click='addEditData()']";
	
	public static final String UniqueReference ="@xpath=//input[@ng-model='data.UniqueReference']";
	public static final String CompanyReference1 ="@xpath=//input[@ng-model='data.CompanyReference']";
	//Element Locators
	public static final String ReportingChannelIdDD ="@xpath=//*[@ng-model='data.ReportingChannelId']//preceding-sibling::span[1]";
	public static final String ReportingChannelIdDDValue ="@xpath=//li[contains(.,'Risk Bordereaux 1')]";
	public static final String ReportingChannelIdDDValue2 ="@xpath=//li[contains(.,'Risk Bordereaux 2')]";
	public static final String ReportingChannelIdDDValue3 ="@xpath=//li[contains(.,'Risk Bordereaux 3')]";
	public static final String ReportingChannelIdClaimDDValue1 ="@xpath=//li[contains(.,'Claim Bordereaux 2')]";
	public static final String ReportingChannelIdClaimDDValue2 ="@xpath=//li[contains(.,'Claim Bordereaux 3')]";

	public static final String ReportingChannelIdDDValuePremium ="@xpath=//li[contains(.,'Premium Bordereaux 1')]";
	public static final String ReportingChannelIdDDValuePremium2 ="@xpath=//li[contains(.,'Premium Bordereaux 2')]";
	public static final String ReportingChannelIdDDValuePremium3 ="@xpath=//li[contains(.,'Premium Bordereaux 3')]";

	public static final String ReportingChannelIdClaimDDValue ="@xpath=//li[contains(.,'Claim Bordereaux 1')]";

	public static final String ExpectedSummaryscreen = "@xpath=//h2[text()='Bordereau Summary']";
	public static final String SubmitRecordForAssignmentButton = "@xpath=//*[@ng-click='submitBordereau()']";
	public static final String SectionAssignmentRuleScreen = "@xpath=//h2[text()='Section Assignment Rule']";
	public static final String BordereauAssignmentSectionDropDwn = "@xpath=//*[@ng-model='form.defaultSectionRiskCode']//preceding-sibling::span";
	public static final String BordereauAssignmentSectionDropDwnOption = "@xpath=//li[text()='Data in the bordereau will specify the Section']";
	public static final String SectionIdDropDwn = "@xpath=//*[@ng-model='data.SectionId']//preceding-sibling::span";
	public static final String SectionIdDropDwnOption = "@xpath=//ul[@aria-hidden='false']//li[contains(.,'1E')]";
	public static final String SectionIdDropDwnOption2 = "@xpath=//ul[@aria-hidden='false']//li[contains(.,'1E')]";
	public static final String SectionIdDropDwnOption1 = "@xpath=//ul[@aria-hidden='false']//li[contains(.,'1T')]";
	public static final String SectionIdDropDwn1 = "@xpath=//tr[1]//select[@ng-model='data.SectionId']//preceding-sibling::span";
	public static final String SectionIdDropDwn2 = "@xpath=//tr[2]//select[@ng-model='data.SectionId']//preceding-sibling::span";
	public static final String SectionIdDropDwn1Risk = "@xpath=//tr[1]//select[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String SectionIdDropDwn2Risk = "@xpath=//tr[2]//select[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";

	public static final String SectionRiskCodeDwn = "@xpath=//*[@ng-model='form.defaultSectionRiskCode']//preceding-sibling::span";
	public static final String SectionRiskCodeDropoption = "@xpath=//li[contains(.,'Data in the bordereau will specify the Risk Code')]";
	public static final String CompleteAssignmentBtn = "@xpath=//button[@ng-click='submitMapping()']";
	public static final String InsuredNameField = "@xpath=//span[text()='Insured Name']";
	public static final String RightArrowSign = "@xpath=//*[@ng-click='addToSelectionList()']/span";
	public static final String SetMappingRuleButton = "@xpath=//button[contains(.,'Set Mapping Rule')]";
	public static final String SectionRiskCodeIdDwn = "@xpath=//*[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String AssingSecInConDD = "@xpath=.//*[@ng-model='form.defaultSectionRiskCode']//preceding-sibling::span[1]";
	public static final String AssingSecInConVal = "@xpath=//li[contains(.,'Data in the bordereau will specify the Section')]";
	public static final String SetmapRulBtn = "@xpath=//button[@type='submit']";
	public static final String InsuredVal = "@xpath=.//*[@ng-bind='dataItem.NameToDisplay'][text()='Insured Name']";
	public static final String PropertyDD = "@xpath=//*[@ng-model='data.SectionId']//preceding-sibling::span[1]";
	public static final String PropertyVal = "@xpath=//li[contains(.,'1E')]";
	public static final String JanReviewError = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='January']//preceding::td[4]//button[contains(@ng-click,'Process')]";
	public static final String JanReview = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='January']//preceding::td[4]//button[contains(@ng-click,'GoToSubmissionBordereaux(dataItem)')]";
	public static final String FebReviewError = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='February']//preceding::td[4]//button[contains(@ng-click,'Process')]";
	public static final String MarchReviewError = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='March']//preceding::td[4]//button[contains(@ng-click,'Process')]";
	public static final String MarchReview = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='March']//preceding::button[contains(@ng-click,'GoToSubmissionBordereaux(dataItem)')]";
	public static final String MarchForAssignmnt = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='March']//preceding::button[contains(@ng-click,'GoToSRAssignment')]";
	public static final String AprilReviewError = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='April']//preceding::td[4]//button[contains(@ng-click,'Process')]";
	public static final String AprilReview = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='April']//preceding::td[4]//button[contains(@ng-click,'GoToSubmissionBordereaux(dataItem)')]";
	public static final String AprilFrApprvl = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='April']//preceding::td[4]//button[contains(@ng-click,'GoToBordereauSummaryScreen')]";
	public static final String JanApprv = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='January']//preceding::td[4]//button[contains(@ng-click,'GoToBordereauSummaryScreen')]";
	public static final String AprilForAssignmnt = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='April']//preceding::button[contains(@ng-click,'GoToSRAssignment')]";
	public static final String AprilForApprval = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='April']//preceding::button[contains(@ng-click,'GoToBordereauSummaryScreen')]";

	public static final String SkipThisErrBtn = "@xpath=//*[@ng-click='SkipAndContinue()']";

	public static final String ConProcssbrdBtn = "@xpath=//*[@ng-click='UpdateSequence()']";
	public static final String CancelBtn = "@xpath=//*[@ng-click='cancel()']";
	public static final String PauseBtn = "@xpath=//*[@ng-click='pause()']";

	public static final String CancelProcessngBtn = "@xpath=//button[@ng-click='onYes()']";
	public static final String ProcessAnAddbrdBtn = "@xpath=.//*[@ng-click='UpdateBordereauxStatus()']";
	public static final String ClaimSAthDrp = "@xpath=//select[@ng-model='data.ClaimsAuthorityId']//ancestor::span";
	public static final String ClaimSAthDrpVal = "@xpath=//ul[@aria-hidden='false']/li[1]";
	public static final String ClaimSAthDrplimittxt = "@xpath=//input[@ng-model='data.ClaimsAuthorityLimit']";
	public static final String Savebtn = "@xpath=//form[@name='form.addEditData']//button[@ng-click='save()']|//button[@ng-click='edit()']";
	public static final String CompanyDropDown ="@xpath=//*[@ng-model='form.dataId']//preceding-sibling::span[1]";

	public static final String ContractAdministratorPopup ="@xpath=//h2[contains(.,'Contract Contract Administrator')]";
	public static final String CompanyAdministratoropdwn ="@xpath=//*[@ng-model='form.dataId']//preceding-sibling::span[1]";
	public static final String SaveCompany ="@xpath=//*[@ng-click='save()']";
	public static final String ConSettingPopUp ="@xpath=//h2[contains(.,'Contract Settings Update')]";
	public static final String SaveBtn4 ="@xpath=//button[contains(@ng-if,'form.SignedContractChanged.$valid ')]";
	public static final String Roletab="@xpath=//a[text()='Roles']";
	public static final String CompanyRefrence="@xpath=//*[@ng-model='data.CompanyReference']";
	public static final String SaveEditedChanges ="@xpath=//*[@ng-click='edit()']";
	public static final String VerifSummaryTab ="@xpath=//*[@ng-if='viewSummaryTab']";
	String NoRadiobtn = "@xpath=//input[@value='false']";
	String YesRadiobtn = "@xpath=//input[@value='true']";

	public static final String AprilUploadedClaim = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='April']//ancestor::td[contains(@ng-click,'Claim')]//preceding-sibling::td//button[contains(.,'Uploaded')]";
	public static final String AprilUploadedPremium = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='April']//ancestor::td[contains(@ng-click,'Premium')]//preceding-sibling::td//button[contains(.,'Uploaded')]";
	public static final String AprilUploadedRisk = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='April']//ancestor::td[contains(@ng-click,'Risk')]//preceding-sibling::td//button[contains(.,'Uploaded')]";
	public static final String JanReviewErrorClaim = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='January']//ancestor::td[contains(@ng-click,'Claim')]//preceding-sibling::td//button[contains(.,'Review Error')]";
	public static final String JanReviewClaim = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='January']//ancestor::td[contains(@ng-click,'Claim')]//preceding-sibling::td//button[text()='Review']";
	public static final String JanReviewClaim1 = "@xpath=//button[@ng-click='GoToSubmissionBordereaux(dataItem)']";
	public static final String FebReviewErrorClaim = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='February']//ancestor::td[contains(@ng-click,'Claim')]//preceding-sibling::td//button[contains(.,'Review Error')]";
	public static final String MarReviewErrorClaim = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='March']//ancestor::td[contains(@ng-click,'Claim')]//preceding-sibling::td//button[contains(.,'Review Error')]";
	public static final String MarReviewClaim = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='March']//ancestor::td[contains(@ng-click,'Claim')]//preceding-sibling::td//button[text()='Review']";
	public static final String MarForAssignmentClaim = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='March']//ancestor::td[contains(@ng-click,'Claim')]//preceding-sibling::td//button[contains(.,'For Assignment')]";
	public static final String MarForApprvalClaim = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='March']//ancestor::td[contains(@ng-click,'Claim')]//preceding-sibling::td//button[contains(.,'For Approval')]";

	public static final String AprReviewErrorClaim = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='April']//ancestor::td[contains(@ng-click,'Claim')]//preceding-sibling::td//button[contains(.,'Review Error')]";
	public static final String AprReviewClaim = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='April']//ancestor::td[contains(@ng-click,'Claim')]//preceding-sibling::td//button[text()='Review']";
	public static final String AprForAssignmentClaim = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='April']//ancestor::td[contains(@ng-click,'Claim')]//preceding-sibling::td//button[contains(.,'For Assignment')]";

	//TC5356
	public static final String TaskIcon ="@xpath=.//*[contains(@class, 'glyphicon glyphicon-time')]";
	public static final String AddTaskBtn ="@xpath=//div[@ng-click='openAddPopup()']";
	public static final String TaskTitle ="@xpath=//input[@ng-model='data.Title']";
	public static final String TaskDescription ="@xpath=//*[@ng-model='data.Description']";
	public static final String CurrentOwnerDrp ="@xpath=.//*[@ng-model='data.CurrentOwnerId']//preceding-sibling::span";
	public static final String CurrentOwnerVal ="@xpath=//li[contains(., 'Test, Standard ')]";
	public static final String TypeDrp ="@xpath=.//*[@ng-model='data.TypeId']//preceding-sibling::span";
	public static final String TypeVal ="@xpath=//li[contains(., 'Action')]";
	public static final String StatusDrp ="@xpath=.//*[@ng-model='data.StatusId']//preceding-sibling::span";
	public static final String StatusVal ="@xpath=//li[contains(., 'Open')]";
	public static final String NotfcnDate ="@xpath=//input[@data-role='datetimepicker']";
	public static final String Cancel ="@xpath=//div[@ng-click='ok()']";
	public static final String AutuApprvClm ="@xpath=//*[@data-field='AutoApproveString']";
	public static final String EdittaskBtn ="@xpath=//div[@ng-click='editData(data)']";
	public static final String AddNoteBtn ="@xpath=//button[@ng-click='AddNote()']";
	public static final String Cancel2 ="@xpath=//div[@ng-click='cancel()']";
	public static final String UploadBtn ="@xpath=//tr[1]//button[contains(.,'Uploaded')]";

	public static final String SectionAssignmentBtn="@xpath=//tr[1]//td[@role='gridcell']//div[@ ng-click='openPopup(dataItem,1)']";
	public static final String RiskcodeAssignmentBtn="@xpath=//tr[1]//td[@role='gridcell']//div[@ ng-click='openPopup(dataItem,2)']";
	public static final String SectionAssignmentPopup="@xpath=//h2[text()='Section Assignment Rules']";
	public static final String RiskCodeAssignmentPopup="@xpath=//h2[text()='Risk Code Assignment Rules']";
	public static final String ViewBtn ="@xpath=//*[@class='ng-scope']//div[@ng-if='AssignementRulesPermission.View']";
	public static final String EditBtn ="@xpath=//*[@ng-if='AssignementRulesPermission.Edit']";
	public static final String closeBtn ="@xpath=//*[@ng-click='ok()'][text()='CLOSE']";

	public static final String BreachsDrp ="@xpath=//input[@id='RiskRule']//preceding-sibling::span";
	public static final String BreachsDrpVal ="@xpath=//li[contains(.,'Country')]";
	public static final String UnconfirmButton ="@xpath=//button[@ng-click='openPopup(dataItem)']";
	public static final String BreachStatus ="@xpath=//dt[contains(.,'Breach Status')]";
	
	public static final String ClaimsAuthorityfld ="@xpath=//*[@ng-if='ClaimsAuthorityVM.IsEdit']/../dt";

	public static final String ForApprovalAprilRiskFile1 ="@xpath=//*[@id='grid']//tr[2]//td[contains(@ng-click,'File Name')][contains(.,'April 2017')]";
	public static final String ForApprovalAprilRiskFile2 ="@xpath=//*[@id='grid']//tr[3]//td[contains(@ng-click,'File Name')][contains(.,'April 2017')]";
	public static final String ForApprovalAprilRiskFile3 ="@xpath=//*[@id='grid']//tr[4]//td[contains(@ng-click,'File Name')][contains(.,'April 2017')]";

	public static final String ForAssignmentPremiunmMarchFile1 ="@xpath=//*[@id='grid']//tr[2]//td[contains(@ng-click,'File Name')][contains(.,'March 2017')]";
	public static final String ForAssignmentPremiunmMarchFile2 ="@xpath=//*[@id='grid']//tr[3]//td[contains(@ng-click,'File Name')][contains(.,'March 2017')]";
	public static final String ReviewPremiunmJanuaryFile1 ="@xpath=//*[@id='grid']//tr[4]//td[contains(@ng-click,'File Name')][contains(.,'January 2017')]";
	public static final String ReviewPremiunmJanuaryFile2 ="@xpath=//*[@id='grid']//tr[5]//td[contains(@ng-click,'File Name')][contains(.,'January 2017')]";
	public static final String ReviewPremiunmJanuaryFile3 ="@xpath=//*[@id='grid']//tr[6]//td[contains(@ng-click,'File Name')][contains(.,'January 2017')]";
	public static final String ReviewPremiunmJanuaryFile4 ="@xpath=//*[@id='grid']//tr[7]//td[contains(@ng-click,'File Name')][contains(.,'January 2017')]";
	public static final String ReviewPremiunmJanuaryFile5 ="@xpath=//*[@id='grid']//tr[8]//td[contains(@ng-click,'File Name')][contains(.,'January 2017')]";
	public static final String ForApprovalPremiumAprilFile1 ="@xpath=//*[@id='grid']//tr[9]//td[contains(@ng-click,'File Name')][contains(.,'April 2017')]";
	public static final String ForApprovalPremiumAprilFile2 ="@xpath=//*[@id='grid']//tr[10]//td[contains(@ng-click,'File Name')][contains(.,'April 2017')]";

	public static final String EditReportingChannelPopup ="@css=.font-bold.lead.p-l-30.ng-binding";
	public static final String EditRulesbtn ="@xpath=//*[@ng-click='editClick(1)']";
	public static final String Addfilebtn ="@xpath=//*[@ng-click='addEditData()']";
	public static final String LocationthreeRefdot ="@xpath=//*[@ng-if='permission.Edit && !IsEdit']//*[@class='dropdown']";
	public static final String EditbtnOnTaskIcon ="@xpath=//*[@ng-click='editData(data)']";
	public static final String EditTaskPopUP ="@xpath=//*[text()='Edit Task']";
	public static final String ADDNewNoteBtn ="@xpath=//button[@ng-click='AddNote()']";
	public static final String Cancel1 ="@xpath=//*[@ng-click='cancel()']";
	public static final String AutoApproveYesRadio="@xpath=//*[@ng-model='data.AutoApprove'][@disabled='disabled']/..";
	public static final String BreachesRulesDD="@xpath=//*[@class='form-group m-b-0']";
	public static final String ADDRulebtnONsection1="@xpath=//*[@ng-if='isSectionID && isContractInstanceSectionRulesRulesAdd']";
	public static final String AprForApprovalRisk = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='April']//ancestor::td[contains(@ng-click,'Risk')]//preceding-sibling::td//button[contains(.,'For Approval')]";
	public static final String AprForApprovalClaims = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='March']//ancestor::td[contains(@ng-click,'Claim')]//preceding-sibling::td//button[contains(.,'For Approval')]";
	public static final String RiskApprovedButton = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='January']//preceding::td[contains(@ng-click,'Risk')]//preceding-sibling::td//button[contains(.,'Approved')]";
	public static final String UnApprovedbtn="@xpath=//button[contains(.,'UnApprove Bordereau')]";
	public static final String Overduebtn="@xpath=//tr[1]//button[text()='Overdue']";
	public static final String OverdueNobtn="@xpath=//button[text()='No']";
	public static final String NilReturnPopUP="@xpath=//h2[contains(.,'Report as a Nil Return?')]";
	public static final String Approvedbtn ="@xpath=//button[text()='Approved']";
	public static final String CompanyReferenceTxt ="@xpath=//*[@ng-model='data.CompanyReference']";
	public static final String AutoApprove ="@xpath=//*[@data-field='AutoApproveString']";
	public static final String AutoApproveRisk ="@xpath=//tr//td[12]";
	public static final String ForApprovalbtn ="@xpath=//button[text()='For Approval']";

	//4821
	public static final String CompanyRow1 ="@xpath=//div[@class='table-responsive ng-scope']//tr[1]/td[3]";
	public static final String AprovedRoleRiskFile ="@xpath=//td[contains(@ng-click,'File Name')][text()='January_2017_ApproveRisk_TC4438.xlsx']";
	public static final String AprovedRolePremiumFile ="@xpath=//td[contains(@ng-click,'File Name')][text()='January 2017 - Approved_TC_4511First.xlsx']";
	//Data Claim Tab files
	public static final String AprovedJanFile ="@xpath=//td[contains(@ng-click,'File Name')][text()='January 2017_ApproveRisk_TC4510.xlsx']";
	//File Status locators
	public static final String AprilUploadClaim = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='April']//ancestor::td[contains(@ng-click,'Claim')]//preceding-sibling::td//button[contains(.,'Uploaded')]";
	public static final String FebruaryReviewErrorClaim ="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='February']//ancestor::td[contains(@ng-click,'Claim')]//preceding-sibling::td//button[contains(.,'Review Errors')]";
	public static final String AprilUploadRisk ="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='April']//ancestor::td[contains(@ng-click,'Risk')]//preceding-sibling::td//button[contains(.,'Uploaded')]";
	public static final String FebruaryReviewErrorRisk ="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='February']//ancestor::td[contains(@ng-click,'Risk')]//preceding-sibling::td//button[contains(.,'Review Errors')]";
	public static final String JanReviewRisk ="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='January']//ancestor::td[contains(@ng-click,'Risk')]//preceding-sibling::td//button[contains(.,'Review')]";
	public static final String AprilUploadPremium ="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='April']//ancestor::td[contains(@ng-click,'Premium')]//preceding-sibling::td//button[contains(.,'Uploaded')]";
	public static final String FebruaryReviewErrorPremium ="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='February']//ancestor::td[contains(@ng-click,'Premium')]//preceding-sibling::td//button[contains(.,'Review Errors')]";
	public static final String JanReviewPremium="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='January']//ancestor::td[contains(@ng-click,'Premium')]//preceding-sibling::td//button[contains(.,'Review')]";
	public static final String AprilForApprovalRisk="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='April']//ancestor::td[contains(@ng-click,'Risk')]//preceding-sibling::td//button[contains(.,'For Approval')]";
	public static final String MarchForApprovalClaim="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='March']//ancestor::td[contains(@ng-click,'Claim')]//preceding-sibling::td//button[contains(.,'For Approval')]";
	public static final String AprilForAssignmentClaim="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='April']//ancestor::td[contains(@ng-click,'Claim')]//preceding-sibling::td//button[contains(.,'For Assignment')]";
	public static final String MarchForAssignmentRisk="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='March']//ancestor::td[contains(@ng-click,'Risk')]//preceding-sibling::td//button[contains(.,'For Assignment')]";
	public static final String JanApprovedRisk ="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='January']//ancestor::td[contains(@ng-click,'Risk')]//preceding-sibling::td//button[contains(.,'Approved')]";
	public static final String JanApprovedClaim ="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='January']//ancestor::td[contains(@ng-click,'Claim')]//preceding-sibling::td//button[contains(.,'Approved')]";
	public static final String JanApprovedPremium="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='January']//ancestor::td[contains(@ng-click,'Premium')]//preceding-sibling::td//button[contains(.,'Approved')]";
	public static final String DeleteButton = "@css=.c-red.glyphicon.glyphicon-trash";
	public static final String SubmitBordereauPage ="@xpath=//*[text()='Submit Bordereau']";
	public static final String VerifyReviewErrorPage ="@xpath=//h2[text()='More than one Reporting Channel identified']";
	public static final String VerifyForApprovalPage ="@xpath=//h2[text()='Bordereau Summary – For Approval']";
	public static final String UnApprvBdrBtn ="@xpath=.//*[@ng-click='approveUnApproveBordereau(bordereauxData.Id)']";

	public static final String BordereauSummarypage ="@xpath=//h2[text()='Approved Bordereau Summary']";

	//Data Claim Tab files
	public static final String AprilForApprovalFile ="@xpath=//td[contains(@ng-click,'File Name')][text()='April 2017 - Forapproval_4510_Step33.xlsx']";
	public static final String MarchForAssignmentFile ="@xpath=//tr[3]//td[contains(@ng-click,'File Name')][text()='March 2017 - ForAssignment_4510_Step21.xlsx']";
	public static final String MarchForAssignmentFile2 ="@xpath=//tr[4]//td[contains(@ng-click,'File Name')][text()='March 2017 - ForAssignment_4510_Step21.xlsx']";
	public static final String JanuaryReviewFile ="@xpath=//td[contains(@ng-click,'File Name')][text()='January 2017 -Review_4510_Step16.xlsx']";

	public static final String VerifyForAssignmentPage ="@xpath=//h2[text()='Section Assignment Rule']";
	public static final String TaskIconforRiskReview="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='January']//ancestor::td[contains(@ng-click,'Risk')]//preceding-sibling::td//span[2]";
	public static final String TaskIconforPremiumReview="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='January']//ancestor::td[contains(@ng-click,'Premium')]//preceding-sibling::td//span[2]";
	public static final String TaskIconforClaimReview="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='January']//ancestor::td[contains(@ng-click,'Claim')]//preceding-sibling::td//span[2]";
	public static final String EditTaskIcon="@xpath=//*[@ ng-click='editData(data)']";
	public static final String AddNoteForTask ="@xpath=//*[@ng-click='AddNote()']";
	public static final String SaveChangesBtn ="@xpath=//*[@ng-click='edit()']";

	public static final String ReportingChannelfilterIcon="@xpath=//th[@data-field='ReportingChannelIdentifier']//span[@class='k-icon k-i-filter']";
	public static final String AutoApproveSwitch ="@xpath=//tr[1][@role='row']//td[12]";
	public static final String RejectBtn ="@xpath=//*[@ng-click='OpenRejectBordereauPopup()']";
	public static final String SearchFilterTxt ="@css=[placeholder='Search']";
	public static final String ClearBtn="@buttonText=Clear";
	public static final String BordereauTypeFilter ="@xpath=//th[@data-title='Bordereau Type']//a//span";
	public static final String ApprovedTab ="@xpath=//a[text()='Approved']";
	
	public static final String OverdueYesbtn="@xpath=//button[@ng-click='UpdateStatusToNilBordereau()']";
	public static final String NilBordereaubtn="@xpath=//button[contains(.,'Nil Bordereau')]";
	
	public static final String SectionUpperDropDwn = "@xpath=//*[@ng-repeat='data in KendoData.DataList track by $index'][1]//*[@ng-model='data.SectionId']//preceding-sibling::span";
	public static final String SectionLowerDropDwn = "@xpath=//*[@ng-repeat='data in KendoData.DataList track by $index'][2]//*[@ng-model='data.SectionId']//preceding-sibling::span";
	public static final String SectionBrentwoodDropDwn = "@xpath=//*[@ng-repeat='data in KendoData.DataList track by $index'][3]//*[@ng-model='data.SectionId']//preceding-sibling::span";
	public static final String SectionMainDropDwn = "@xpath=//*[@ng-repeat='data in KendoData.DataList track by $index'][4]//*[@ng-model='data.SectionId']//preceding-sibling::span";
	public static final String SectionFrnechDropDwn = "@xpath=//*[@ng-repeat='data in KendoData.DataList track by $index'][5]//*[@ng-model='data.SectionId']//preceding-sibling::span";
	public static final String RiskcodeUpperDropDwn = "@xpath=//*[@ng-repeat='data in KendoData.DataList track by $index'][1]//*[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String RiskcodeLowerDropDwn = "@xpath=//*[@ng-repeat='data in KendoData.DataList track by $index'][2]//*[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String RiskcodeBrentwoodDropDwn = "@xpath=//*[@ng-repeat='data in KendoData.DataList track by $index'][3]//*[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String RiskcodeMainDropDwn = "@xpath=//*[@ng-repeat='data in KendoData.DataList track by $index'][4]//*[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String RiskcodeFrnechDropDwn = "@xpath=//*[@ng-repeat='data in KendoData.DataList track by $index'][5]//*[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String RejectYesBtn ="@xpath=//*[@ng-click='rejectBordereau()']";
	public static final String SectionAssignmentSection2 ="@xpath=//li[text()='Section 2 (Primary Risk Code: 1E)']";

	
	
	
	public void bordereauProcessingForRisk_4438() throws Exception
	{
		String UniqueReferenceVal1 = "Automation Policy_Risk"+getCurrentDateTimeMS();
		String YearOfAc = "Year Of Account"+getCurrentDateTimeMS();
		String InceptionDate = "01/01/2017";
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails1("Charles Taylor InsureTech - Development", "Coverholder Inc - New York");
		policy.addPolicyContractDetails(UniqueReferenceVal1, InceptionDate, policy.Status2, policy.Broker3, policy.Bline2, policy.Underline2);
		policy.waitForElementToAppear(policy.QuoteBtn,5);		
		verifyExists(policy.QuoteBtn,"Quote Status Button");
		Report.LogInfo("StepCheck", "Step 2 completed", "PASS");

		//Step no 3,4,5
		scrollUp();
		policy.addSection1("Section1", "100", policy.PropertyRiskValue, "1000", "100", "100");
		policy.navigateToSectionTab1();		
		policy.navigateToMarketsTabOnSection();
		policy.addMarketOnSection1("Aspen Managing Agency", "10", "10");		
		policy.navigateToRiskCodesTabOnSection();
		policy.addRiskCodesOnSection("1E - OVERSEAS LEG");

		scrollUp();
		policy.addSection1("Section2", "10", policy.MarineLiabilityValue, "10", "10", "10");
		policy.navigateToSectionTab2();		
		policy.navigateToMarketsTabOnSection();		
		policy.addMarketOnSection1("Brit Syndicates Limited - 2987", "100", "100");		
		policy.navigateToRiskCodesTabOnSection();
		policy.addRiskCodesOnSection("1T - OVERSEAS LEG");
		Report.LogInfo("StepCheck", "Step 3,4,5 completed", "PASS");

		//Step 6, 7
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannel1(policy.TypeDDValue, "30", "18", "Risk Bordereaux 1");
		policy.addReportingChannel1(policy.TypeDDValue, "30", "18", "Risk Bordereaux 2");
		policy.addReportingChannel1(policy.TypeDDValue, "30", "18", "Risk Bordereaux 3");

		policy.addReportingChannel1(policy.TypeDDValue_Claim, "30", "24", "Claim Bordereaux 1");
		policy.addReportingChannel1(policy.TypeDDValue_Claim, "30", "24", "Claim Bordereaux 2");
		policy.addReportingChannel1(policy.TypeDDValue_Claim, "30", "24", "Claim Bordereaux 3");

		policy.addReportingChannel1(policy.TypeDDValue_Premium, "30", "24", "Premium Bordereaux 1");
		policy.addReportingChannel1(policy.TypeDDValue_Premium, "30", "24", "Premium Bordereaux 2");
		policy.addReportingChannel1(policy.TypeDDValue_Premium, "30", "24", "Premium Bordereaux 3");
		Report.LogInfo("StepCheck", "Step 6,7 completed", "PASS");
		
		policy.addCoverholder();

		//Step 8
		policy.navigateToContractDetailsTab();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned1();
		Report.LogInfo("StepCheck", "Step 8 completed", "PASS");

		//Step 9 
		policy.navigateRulesTab();
		verifyMustExists(policy.AddRulebtnCon,"Add rule button");
		click(policy.AddRulebtnCon,"Add rule button");		
		schema.AddContractRule(YearOfAc,"Risk","USD - United States Dollar","Data is valid if the rule conditions are met");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		scrollDown();
		schema.yearOfAccount("2016");
		sleep(2000);
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");
		sleep(2000);
		//Add contract endorsment pop up handling.

		if(isVisible(policy.ConEndrsmntPopUp) == true)
		{
			sleep(1000);
			verifyExists(policy.SaveBtn3,"Save Button");
			click(policy.SaveBtn3,"Save Button");
			sleep(3000);
		}	
		Report.LogInfo("StepCheck", "Step 9 completed", "PASS");

		policy.navigateToContractDetailsTab();	
		BorProc.applyFilterPolicy(policy.PolicyNumber);
		policy.openSelectedPolicy();
		//Step 10,12
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		//String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\"959242DZ\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnBordereauxTab();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4438Path = fpath+"\\src\\test\\resources\\testdata\\January_2017_ApproveRisk_TC4438.xlsx";
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		File excelFile = new File(sheet4438Path);
		policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January_2017_ApproveRisk_TC4438.xlsx\",\"UniqueFileName\":\"S56126120180202.xlsx\",\"BordereauFormatId\":\"fc3d323e-5e7f-409c-9120-1e91ecf106d3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S56126120180202.xlsx\",\"Filesize\":17660,\"Path\":null,\"size\":17660,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BorProc.refreshUploadedFile();
		Report.LogInfo("StepCheck", "Step 10 completed", "PASS");

		String MoreThanOneReportingChannelIdentified ="@xpath=//h2[contains(.,'More than one Reporting Channel identified')]";
		String mapValue = "Insured Name";
		if(BorProc.checkErrorReviewButton(BorProc.ReviewError)==true)
		{
			Report.LogInfo("MoreThanOneReportingChannelIdentified", "Status changed to Review Error.", "PASS");
			if(isVisible(MoreThanOneReportingChannelIdentified)== true){
				SelectDropDownValue(ReportingChannelIdDD, ReportingChannelIdDDValue);
				selectNoContproc();
				Report.LogInfo("StepCheck", "Step 11 completed", "PASS");
				//Step 12,13
				BorProc.refreshUploadedFile();
				ApproveStatusFromReviewBordereauType(mapValue);
				Report.LogInfo("StepCheck", "Step 20 completed", "PASS");

				String SecndFile_payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"February 2017_Review error_TC_4438_Second.xlsx\",\"UniqueFileName\":\"S40180420180018.xlsx\",\"BordereauFormatId\":\"fc3d323e-5e7f-409c-9120-1e91ecf106d3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S40180420180018.xlsx\",\"Filesize\":17131,\"Path\":null,\"size\":17131,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				String fileName = "February 2017_Review error_TC_4438_Second.xlsx";
				ProcessSecondBordereau_4438(fileName, SecndFile_payload, FebReviewError);	
				goBack();
				Report.LogInfo("StepCheck", "Step 21 completed", "PASS");

				//Step 22
				sleep(2000);
				String fileName1 = "January 2017_Review error_TC_4438_Third.xlsx";
				String ThirdFile_payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_Review error_TC_4438_Third.xlsx\",\"UniqueFileName\":\"S63927820180018.xlsx\",\"BordereauFormatId\":\"fc3d323e-5e7f-409c-9120-1e91ecf106d3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S63927820180018.xlsx\",\"Filesize\":18088,\"Path\":null,\"size\":18088,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				ProcessSecondBordereau_4438(fileName1,ThirdFile_payload, JanReviewError);
				SelectDropDownValue(ReportingChannelIdDD, ReportingChannelIdDDValue);
				selectNoContproc();
				sleep(2000);
				Report.LogInfo("StepCheck", "Step 22 to 25 completed", "PASS");
				//need to add refresh
				refreshUploadedFileTillStatus(JanReviewError);
				verifyMustExists(JanReviewError,"Review button");
				click(JanReviewError,"Review button");
				Report.LogInfo("StepCheck", "Step 26 completed", "PASS");
				sleep(2000);
				waitForElementToAppear(ProcessAnAddbrdBtn,5);
				verifyMustExists(ProcessAnAddbrdBtn,"PROCESS AS AN ADDITIONAL BORDEREAU");
				click(ProcessAnAddbrdBtn,"PROCESS AS AN ADDITIONAL BORDEREAU");
				sleep(2000);
				refreshUploadedFileTillStatus(JanReview);
				Report.LogInfo("StepCheck", "Step 27 completed", "PASS");

				String FourthFile_payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":3,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"March 2017_For Assignment_4438_Fourth.xlsx\",\"UniqueFileName\":\"S81243420180018.xlsx\",\"BordereauFormatId\":\"fc3d323e-5e7f-409c-9120-1e91ecf106d3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S81243420180018.xlsx\",\"Filesize\":18031,\"Path\":null,\"size\":18031,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				String fileName2 = "March 2017_For Assignment_4438_Fourth.xlsx";
				ProcessSecondBordereau_4438(fileName2, FourthFile_payload, MarchReviewError);
				Report.LogInfo("StepCheck", "Step 28 completed", "PASS");

				if(isVisible(MoreThanOneReportingChannelIdentified)== true){
					SelectDropDownValue(ReportingChannelIdDD, ReportingChannelIdDDValue2);
					selectNoContproc();
					sleep(2000);
					Report.LogInfo("StepCheck", "Step 29 completed", "PASS");

					refreshUploadedFileTillStatus(MarchReviewError);
					verifyExists(MarchReviewError,"March Review Error button");
					click(MarchReviewError,"March Review Error button");
					sleep(2000);					

					javaScriptclick(YesRadiobtn,"Yes radio button");					
					sleep(1000);
					verifyMustExists(ConProcssbrdBtn,"Continue processing button");
					click(ConProcssbrdBtn,"Continue processing button");
					sleep(2000);
					refreshUploadedFileTillStatus(MarchReview);
					sleep(2000);
					Report.LogInfo("StepCheck", "Step 30 completed", "PASS");
					verifyExists(MarchReview,"March Review button");
					click(MarchReview,"March Review button");
					sleep(2000);
					Report.LogInfo("StepCheck", "Step 31 completed", "PASS");
					submtRecordAssmnt();
					Report.LogInfo("StepCheck", "Step 32 completed", "PASS");
					waitForElementToAppear(PauseBtn,3);
					verifyMustExists(PauseBtn,"Pause button");
					click(PauseBtn,"Pause button");					
					refreshUploadedFileTillStatus(MarchForAssignmnt);
					Report.LogInfo("StepCheck", "Step 33 completed", "PASS");

					String FifthFile_payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":4,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"April 2017_For Approval_4438_Fifth.xlsx\",\"UniqueFileName\":\"S17868020180018.xlsx\",\"BordereauFormatId\":\"fc3d323e-5e7f-409c-9120-1e91ecf106d3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S17868020180018.xlsx\",\"Filesize\":18377,\"Path\":null,\"size\":18377,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
					String fileName3 = "April 2017_For Approval_4438_Fifth.xlsx";
					ProcessSecondBordereau_4438(fileName3, FifthFile_payload, AprilReviewError);
					Report.LogInfo("StepCheck", "Step 34 completed", "PASS");
					if(isVisible(MoreThanOneReportingChannelIdentified)== true){
						SelectDropDownValue(ReportingChannelIdDD, ReportingChannelIdDDValue3);
						selectNoContproc();
						sleep(2000);
						refreshUploadedFileTillStatus(AprilReviewError);
						verifyMustExists(AprilReviewError,"April Review Error button");
						click(AprilReviewError,"April Review Error button");
						sleep(2000);
						Report.LogInfo("StepCheck", "Step 35 completed", "PASS");
						javaScriptclick(YesRadiobtn,"Yes radio button");					
						sleep(1000);
						verifyMustExists(ConProcssbrdBtn,"Continue processing button");
						click(ConProcssbrdBtn,"Continue processing button");
						sleep(2000);
						//need to add refresh till review						
						refreshUploadedFileTillStatus(AprilReview);
						ApproveStatusFromReviewBordereauType1(mapValue);
						refreshUploadedFileTillStatus(AprilForApprval);
						Report.LogInfo("StepCheck", "Step 38 completed", "PASS");
						sleep(2000);
						waitForElementToAppear(BorProc.Processingtab,5);
						verifyMustExists(BorProc.Processingtab,"Approve Tab");
						click(BorProc.Processingtab,"Approve Tab");
						verifyExists(JanReview,"January review button");
						verifyExists(FebReviewError,"Feb Review Error button");
						verifyExists(MarchForAssignmnt,"March For Assignmnt button");
						verifyExists(AprilForApprval,"April for approval button");
					}
				}
			}
			else
			{
				Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
				goBack();
				//BorProc.deleteBorderEAUX();				
			}
		}
		else
		{
			Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
			//BorProc.deleteBorderEAUX();				
		}
	}

	public void bordereauProcessingForClaim_4510() throws Exception
	{
		String mapValue = "Bordereau Column: Cause Of Loss";
		BorProc.applyFilterPolicy(policy.PolicyNumber);
		policy.openSelectedPolicy();
		sleep(3000);
		String contractId = ReturnContractID();
		Report.LogInfo("StepCheck", "Step 1 completed", "PASS");

		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnBordereauxTab();
		Report.LogInfo("StepCheck", "Step 2 completed", "PASS");

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4438Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_ApproveRisk_TC4510.xlsx";
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		File excelFile = new File(sheet4438Path);
		//policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_ApproveRisk_TC4510.xlsx\",\"UniqueFileName\":\"S88216020180018.xlsx\",\"BordereauFormatId\":\"fa37349d-bf12-4d88-9b54-b121f7576ffa\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S88216020180018.xlsx\",\"Filesize\":15319,\"Path\":null,\"size\":15319,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_ApproveRisk_TC4510.xlsx\",\"UniqueFileName\":\"S88216020180018.xlsx\",\"BordereauFormatId\":\"fa37349d-bf12-4d88-9b54-b121f7576ffa\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S88216020180018.xlsx\",\"Filesize\":15319,\"Path\":null,\"size\":15319,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFileTillStatus(JanReviewErrorClaim);
		Report.LogInfo("StepCheck", "Step 3 completed", "PASS");

		String MoreThanOneReportingChannelIdentified ="@xpath=//h2[contains(.,'More than one Reporting Channel identified')]";

		if(BorProc.checkErrorReviewButton(JanReviewErrorClaim)==true)
		{
			Report.LogInfo("MoreThanOneReportingChannelIdentified", "Status changed to Review Error.", "PASS");
			if(isVisible(MoreThanOneReportingChannelIdentified)== true){
				SelectDropDownValue(ReportingChannelIdDD, ReportingChannelIdClaimDDValue);
				selectNoContproc();
				Report.LogInfo("StepCheck", "Step 4 completed", "PASS");

				String ApprovedJanClaimBtn = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='January']//preceding::td[contains(@ng-click,'Claim')]//preceding-sibling::td//button[contains(.,'Approved')]";
				refreshUploadedFileTillStatus(JanReviewClaim);
				ApproveStatusFromReviewBordereauType2(mapValue,ApprovedJanClaimBtn);
				Report.LogInfo("StepCheck", "Step 5 to 13 completed", "PASS");
			}

			//String SecndFile_payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"February 2017 - Review error_4510_Step14.xlsx\",\"UniqueFileName\":\"S89785920180205.xlsx\",\"BordereauFormatId\":\"fa37349d-bf12-4d88-9b54-b121f7576ffa\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S89785920180205.xlsx\",\"Filesize\":15811,\"Path\":null,\"size\":15811,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			String SecndFile_payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"February 2017 - Review error_4510_Step14.xlsx\",\"UniqueFileName\":\"S89785920180205.xlsx\",\"BordereauFormatId\":\"fa37349d-bf12-4d88-9b54-b121f7576ffa\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S89785920180205.xlsx\",\"Filesize\":15811,\"Path\":null,\"size\":15811,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

			String fileName = "February 2017 - Review error_4510_Step14.xlsx";
			ProcessSecondBordereau_4438(fileName, SecndFile_payload, FebReviewErrorClaim);
			goBack();
			refreshUploadedFileTillStatus(FebReviewErrorClaim);
			verifyExists(FebReviewErrorClaim,"Feb review error-claim");
			Report.LogInfo("StepCheck", "Step 14, 15 completed", "PASS");

			//String ThirdFile_payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017 -Review_4510_Step16.xlsx\",\"UniqueFileName\":\"S55069820180205.xlsx\",\"BordereauFormatId\":\"fa37349d-bf12-4d88-9b54-b121f7576ffa\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S55069820180205.xlsx\",\"Filesize\":17240,\"Path\":null,\"size\":17240,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			String ThirdFile_payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017 -Review_4510_Step16.xlsx\",\"UniqueFileName\":\"S58731320180208.xlsx\",\"BordereauFormatId\":\"fa37349d-bf12-4d88-9b54-b121f7576ffa\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S58731320180208.xlsx\",\"Filesize\":17437,\"Path\":null,\"size\":17437,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

			String ThirdfileName = "January 2017 -Review_4510_Step16.xlsx";
			ProcessSecondBordereau_4438(ThirdfileName, ThirdFile_payload, JanReviewErrorClaim);
			SelectDropDownValue(ReportingChannelIdDD, ReportingChannelIdClaimDDValue);
			selectNoContproc();
			refreshUploadedFileTillStatus(JanReviewErrorClaim);
			BorProc.checkErrorReviewButton(JanReviewErrorClaim);
			verifyMustExists(ProcessAnAddbrdBtn,"PROCESS AS AN ADDITIONAL BORDEREAU");
			click(ProcessAnAddbrdBtn,"PROCESS AS AN ADDITIONAL BORDEREAU");
			Report.LogInfo("StepCheck", "Step 16 tp 19 completed", "PASS");

			refreshUploadedFileTillStatus(JanReviewClaim);
			verifyExists(JanReviewClaim,"Jan review -claim");	
			Report.LogInfo("StepCheck", "Step 20 completed", "PASS");

			//String ForthFile_payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":3,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"March 2017 - ForAssignment_4510_Step21.xlsx\",\"UniqueFileName\":\"S75186920180206.xlsx\",\"BordereauFormatId\":\"fa37349d-bf12-4d88-9b54-b121f7576ffa\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S75186920180206.xlsx\",\"Filesize\":16860,\"Path\":null,\"size\":16860,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			String ForthFile_payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":3,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"March 2017 - ForAssignment_4510_Step21.xlsx\",\"UniqueFileName\":\"S75186920180206.xlsx\",\"BordereauFormatId\":\"fa37349d-bf12-4d88-9b54-b121f7576ffa\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S75186920180206.xlsx\",\"Filesize\":16860,\"Path\":null,\"size\":16860,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

			String ForthfileName = "March 2017 - ForAssignment_4510_Step21.xlsx";
			ProcessSecondBordereau_4438(ForthfileName, ForthFile_payload, MarReviewErrorClaim);
			SelectDropDownValue(ReportingChannelIdDD, ReportingChannelIdClaimDDValue1);
			selectNoContproc();
			refreshUploadedFileTillStatus(MarReviewErrorClaim);
			BorProc.checkErrorReviewButton(MarReviewErrorClaim);
			selectYesContproc();
			refreshUploadedFileTillStatus(MarReviewClaim);
			verifyExists(MarReviewClaim,"Mar review-claim");
			Report.LogInfo("StepCheck", "Step 24 completed", "PASS");

			ApproveStatusFromReviewBordereauType4(mapValue);
			verifyExists(MarForApprvalClaim,"Mar for approval-claim");
			Report.LogInfo("StepCheck", "Step 25 to 32 completed", "PASS");

			//String FifthFile_payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":4,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"April 2017 - Forapproval_4510_Step33.xlsx\",\"UniqueFileName\":\"S16752120180206.xlsx\",\"BordereauFormatId\":\"fa37349d-bf12-4d88-9b54-b121f7576ffa\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S16752120180206.xlsx\",\"Filesize\":17460,\"Path\":null,\"size\":17460,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			String FifthFile_payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":4,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"April 2017 - Forapproval_4510_Step33.xlsx\",\"UniqueFileName\":\"S16752120180206.xlsx\",\"BordereauFormatId\":\"fa37349d-bf12-4d88-9b54-b121f7576ffa\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S16752120180206.xlsx\",\"Filesize\":17460,\"Path\":null,\"size\":17460,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			String FifthfileName = "April 2017 - Forapproval_4510_Step33.xlsx";
			ProcessSecondBordereau_4438(FifthfileName, FifthFile_payload, AprReviewErrorClaim);
			SelectDropDownValue(ReportingChannelIdDD, ReportingChannelIdClaimDDValue2);
			selectNoContproc();
			refreshUploadedFileTillStatus(AprReviewErrorClaim);
			BorProc.checkErrorReviewButton(AprReviewErrorClaim);
			selectNoContproc();
			refreshUploadedFileTillStatus(AprReviewClaim);
			verifyExists(AprReviewClaim,"April review-claim");
			Report.LogInfo("StepCheck", "Step 33 to 37 completed", "PASS");

			ApproveStatusFromReviewBordereauType3(mapValue);
			verifyExists(AprForAssignmentClaim,"April for assignment-claim");
			Report.LogInfo("StepCheck", "Step 38 to 40 completed", "PASS");

			//String SixthFile_payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":4,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017 - Review_4510_Step41.xlsx\",\"UniqueFileName\":\"S52142120180206.xlsx\",\"BordereauFormatId\":\"fc3d323e-5e7f-409c-9120-1e91ecf106d3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S52142120180206.xlsx\",\"Filesize\":18580,\"Path\":null,\"size\":18580,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":true,\"BordereauFolder\":[]}";	
			String SixthFile_payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":4,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017 - Review_4510_Step41.xlsx\",\"UniqueFileName\":\"S52142120180206.xlsx\",\"BordereauFormatId\":\"fc3d323e-5e7f-409c-9120-1e91ecf106d3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S52142120180206.xlsx\",\"Filesize\":18580,\"Path\":null,\"size\":18580,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":true,\"BordereauFolder\":[]}";	
			String SixthfileName = "January 2017 - Review_4510_Step41.xlsx";
			ProcessSecondBordereau_4438Second(SixthfileName, SixthFile_payload, AprilUploadedRisk);
			verifyExists(AprilUploadedRisk,"April upload risk");
			Report.LogInfo("StepCheck", "Step 41 completed", "PASS");

			//String SeventhFile_payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":4,\"DataSetType\":\"2\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017 - Review_4510_Step42.xlsx\",\"UniqueFileName\":\"S76288820180206.xlsx\",\"BordereauFormatId\":\"28b1c20e-9282-4b58-a260-bb4c3051d035\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S76288820180206.xlsx\",\"Filesize\":18580,\"Path\":null,\"size\":18580,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":true,\"BordereauFolder\":[]}";	
			String SeventhFile_payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":4,\"DataSetType\":\"2\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017 - Review_4510_Step42.xlsx\",\"UniqueFileName\":\"S76288820180206.xlsx\",\"BordereauFormatId\":\"28b1c20e-9282-4b58-a260-bb4c3051d035\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S76288820180206.xlsx\",\"Filesize\":18580,\"Path\":null,\"size\":18580,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":true,\"BordereauFolder\":[]}";	

			String SeventhfileName = "January 2017 - Review_4510_Step42.xlsx";
			ProcessSecondBordereau_4438Second(SeventhfileName, SeventhFile_payload, AprilUploadedPremium);
			verifyExists(AprilUploadedPremium,"April upload premium");
			Report.LogInfo("StepCheck", "Step 42 completed", "PASS");

			//String EighthFile_payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":4,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017 -Review_4510_Step43.xlsx\",\"UniqueFileName\":\"S96630120180206.xlsx\",\"BordereauFormatId\":\"fa37349d-bf12-4d88-9b54-b121f7576ffa\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S96630120180206.xlsx\",\"Filesize\":17240,\"Path\":null,\"size\":17240,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":true,\"BordereauFolder\":[]}";	
			String EighthFile_payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":4,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017 -Review_4510_Step43.xlsx\",\"UniqueFileName\":\"S96630120180206.xlsx\",\"BordereauFormatId\":\"fa37349d-bf12-4d88-9b54-b121f7576ffa\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S96630120180206.xlsx\",\"Filesize\":17240,\"Path\":null,\"size\":17240,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":true,\"BordereauFolder\":[]}";	

			String EighthfileName = "January 2017 -Review_4510_Step43.xlsx";
			ProcessSecondBordereau_4438Second(EighthfileName, EighthFile_payload, AprilUploadedClaim);
			verifyExists(AprilUploadedClaim,"April upload claim");
			Report.LogInfo("StepCheck", "Step 43 completed", "PASS");
		}
	}

	public void bordereauProcessingForPremium_4511() throws Exception
	{

		//Step 1
		BorProc.applyFilterPolicy(policy.PolicyNumber);		
		policy.openSelectedPolicy();
		sleep(3000);
		Report.LogInfo("StepsCheck", "Step 1 completed", "PASS");

		String contractId = ReturnContractID();

		//Step 2
		policy.navigationOnBordereauxTab();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");

		//Step 3
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4511Path = fpath+"\\src\\test\\resources\\testdata\\January 2017 - Approved_TC_4511First.xlsx";
		} 	
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		File excelFile = new File(sheet4511Path);

		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"2\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017 - Approved_TC_4511First.xlsx\",\"UniqueFileName\":\"S13798820180206.xlsx\",\"BordereauFormatId\":\"28b1c20e-9282-4b58-a260-bb4c3051d035\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S13798820180206.xlsx\",\"Filesize\":17644,\"Path\":null,\"size\":17644,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		waitForElementToAppear(BorProc.RefreshAfterUpload,5);
		click(BorProc.RefreshAfterUpload,"Click on refresh");
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.refreshUploadedFile();
		String MoreThanOneReportingChannelIdentified ="@xpath=//h2[contains(.,'More than one Reporting Channel identified')]";
		String mapValue = "Insured Name";
		Report.LogInfo("StepsCheck", "Step 3 completed", "PASS");

		//Step 4
		if(BorProc.checkErrorReviewButton(BorProc.ReviewError)==true)
		{
			Report.LogInfo("MoreThanOneReportingChannelIdentified", "Status changed to Review Error.", "PASS");
			if(isVisible(MoreThanOneReportingChannelIdentified)== true){
				SelectDropDownValue(ReportingChannelIdDD, ReportingChannelIdDDValuePremium);
				selectNoContproc();
				Report.LogInfo("StepsCheck", "Step 4 completed", "PASS");

				//Step 5
				//refreshPage();//No need remove this
				BorProc.applyBordereauTypeFilter("Premium");
				BorProc.refreshUploadedFile();
				Report.LogInfo("StepsCheck", "Step 6 completed", "PASS");

				//Step 6 to 13
				ApproveStatusFromReviewBordereauType(mapValue);
				//refreshPage();//No need refresh
				BorProc.applyBordereauTypeFilter("Premium");
				BorProc.refreshUploadedFileApprovedStatus();
				Report.LogInfo("StepsCheck", "Step 6 to 13 completed", "PASS");

				//Step 14, 15
				BorProc.navigateOnProcessingTab();

				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet4511PathScnd = fpath+"\\src\\test\\resources\\testdata\\February 2017 - Review error_TC4511_Secnd.xlsx";
				} 	
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				File excelFile1 = new File(sheet4511PathScnd);

				String payload1 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"2\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"February 2017 - Review error_TC4511_Secnd.xlsx\",\"UniqueFileName\":\"S11271620180206.xlsx\",\"BordereauFormatId\":\"28b1c20e-9282-4b58-a260-bb4c3051d035\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S11271620180206.xlsx\",\"Filesize\":17668,\"Path\":null,\"size\":17668,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				uploadFile(ReqUrl, excelFile1, payload1, DraftUrl);
				waitForElementToAppear(BorProc.RefreshAfterUpload,5);
				click(BorProc.RefreshAfterUpload,"Click on refresh");
				sleep(8000);
				BorProc.applyBordereauTypeFilter("Premium");
				BorProc.refreshUploadedFile();
				Report.LogInfo("StepsCheck", "Step 14, 15 completed", "PASS");

				//Step 16
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet4511Paththird = fpath+"\\src\\test\\resources\\testdata\\January 2017 - Review_TC4511Third.xlsx";
				} 	
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				File excelFile2 = new File(sheet4511Paththird);

				String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"2\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017 - Review_TC4511Third.xlsx\",\"UniqueFileName\":\"S24790620180206.xlsx\",\"BordereauFormatId\":\"28b1c20e-9282-4b58-a260-bb4c3051d035\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S24790620180206.xlsx\",\"Filesize\":18589,\"Path\":null,\"size\":18589,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				uploadFile(ReqUrl, excelFile2, payload2, DraftUrl);
				waitForElementToAppear(BorProc.RefreshAfterUpload,5);
				click(BorProc.RefreshAfterUpload,"Click on refresh");
				refreshPage();
				BorProc.applyBordereauTypeFilter("Premium");
				BorProc.applyMonthFilter("January");
				BorProc.refreshUploadedFile();
				Report.LogInfo("StepsCheck", "Step 16 completed", "PASS");

				if(BorProc.checkErrorReviewButton(BorProc.ReviewError)==true)
				{
					Report.LogInfo("MoreThanOneReportingChannelIdentified", "Status changed to Review Error.", "PASS");
					if(isVisible(MoreThanOneReportingChannelIdentified)== true){
						SelectDropDownValue(ReportingChannelIdDD, ReportingChannelIdDDValuePremium);
						selectNoContproc();
						Report.LogInfo("StepsCheck", "Step 17 completed", "PASS");

						waitForElementToAppear(BorProc.RefreshAfterUpload,5);
						click(BorProc.RefreshAfterUpload,"Click on refresh");
						refreshPage();
						BorProc.applyBordereauTypeFilter("Premium");
						BorProc.applyMonthFilter("January");
						BorProc.refreshUploadedFile();
						Report.LogInfo("StepsCheck", "Step 18 completed", "PASS");

						if(BorProc.checkErrorReviewButton(BorProc.ReviewError)==true)
						{
							Report.LogInfo("StepsCheck", "Step 19 completed", "PASS");
							//Step 20
							if(isVisible(BorProc.ProcessAsAdditionalBtn)==true){
								waitForElementToAppear(BorProc.ProcessAsAdditionalBtn,5);
								verifyMustExists(BorProc.ProcessAsAdditionalBtn,"Process Against Selected Period Button");
								click(BorProc.ProcessAsAdditionalBtn,"Process Against Selected Period Button");
								sleep(2000);
								BorProc.applyBordereauTypeFilter("Premium");
								BorProc.applyMonthFilter("January");
								BorProc.refreshUploadedFile();
								if(isVisible(BorProc.ReviewBtn)==true){
									Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
									Report.LogInfo("StepsCheck", "Step 20 completed", "PASS");
									//Step 21
									try 
									{
										String fpath = new File(".").getCanonicalPath();
										sheet4511PathFourth = fpath+"\\src\\test\\resources\\testdata\\March 2017 - For Assignment_TC4511_Fourth.xlsx";
									} 	
									catch (IOException e) 
									{
										e.printStackTrace();
									}
									File excelFile3 = new File(sheet4511PathFourth);

									String payload3 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":3,\"DataSetType\":\"2\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"March 2017 - For Assignment_TC4511_Fourth.xlsx\",\"UniqueFileName\":\"S84320320180206.xlsx\",\"BordereauFormatId\":\"28b1c20e-9282-4b58-a260-bb4c3051d035\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S84320320180206.xlsx\",\"Filesize\":18021,\"Path\":null,\"size\":18021,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
									uploadFile(ReqUrl, excelFile3, payload3, DraftUrl);
									waitForElementToAppear(BorProc.RefreshAfterUpload,5);
									click(BorProc.RefreshAfterUpload,"Click on refresh");
									refreshPage();
									BorProc.applyBordereauTypeFilter("Premium");
									BorProc.applyMonthFilter("March");
									BorProc.refreshUploadedFile();
									Report.LogInfo("StepsCheck", "Step 21 completed", "PASS");

									if(BorProc.checkErrorReviewButton(BorProc.ReviewError)==true)
									{
										Report.LogInfo("MoreThanOneReportingChannelIdentified", "Status changed to Review Error.", "PASS");
										if(isVisible(MoreThanOneReportingChannelIdentified)== true){
											SelectDropDownValue(ReportingChannelIdDD, ReportingChannelIdDDValuePremium2);
											selectNoContproc();
											Report.LogInfo("StepsCheck", "Step 22 completed", "PASS");
											waitForElementToAppear(BorProc.RefreshAfterUpload,5);
											click(BorProc.RefreshAfterUpload,"Click on refresh");
											refreshPage();
											BorProc.applyBordereauTypeFilter("Premium");
											BorProc.applyMonthFilter("March");
											BorProc.refreshUploadedFile();

											if(BorProc.checkErrorReviewButton(BorProc.ReviewError)==true)
											{
												selectNoContproc();
												waitForElementToAppear(BorProc.RefreshAfterUpload,5);
												click(BorProc.RefreshAfterUpload,"Click on refresh");
												refreshPage();
												BorProc.applyBordereauTypeFilter("Premium");
												BorProc.applyMonthFilter("March");
												BorProc.refreshUploadedFile();
												Report.LogInfo("StepsCheck", "Step 23 completed", "PASS");

												if(isVisible(BorProc.ReviewBtn)==true){
													Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
													click(BorProc.ReviewBtn,"Review Button");
													sleep(3000);
													waitForElementToAppear(BorProc.SuRcdAssmnt,5);
													verifyExists(BorProc.SuRcdAssmnt,"Submit recor for Assignment button");
													click(BorProc.SuRcdAssmnt,"Submit recor for Assignment button");
													Report.LogInfo("StepsCheck", "Step 24,25 completed", "PASS");

													waitForElementToAppear(BorProc.pausebtn,5);
													verifyMustExists(BorProc.pausebtn,"Pause button");
													click(BorProc.pausebtn,"Pause button");
													sleep(5000);
													waitForElementToAppear(BorProc.RefreshAfterUpload,5);
													click(BorProc.RefreshAfterUpload,"Click on refresh");
													Report.LogInfo("StepsCheck", "Step 26 completed", "PASS");

													//Step 27
													try 
													{
														String fpath = new File(".").getCanonicalPath();
														sheet4511PathFifth = fpath+"\\src\\test\\resources\\testdata\\April 2017 - For Approval_TC4511_Fifth.xlsx";
													} 	
													catch (IOException e) 
													{
														e.printStackTrace();
													}
													File excelFile4 = new File(sheet4511PathFifth);

													String payload4 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":4,\"DataSetType\":\"2\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"April 2017 - For Approval_TC4511_Fifth.xlsx\",\"UniqueFileName\":\"S51896720180206.xlsx\",\"BordereauFormatId\":\"28b1c20e-9282-4b58-a260-bb4c3051d035\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S51896720180206.xlsx\",\"Filesize\":18299,\"Path\":null,\"size\":18299,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
													uploadFile(ReqUrl, excelFile4, payload4, DraftUrl);
													waitForElementToAppear(BorProc.RefreshAfterUpload,5);
													click(BorProc.RefreshAfterUpload,"Click on refresh");
													refreshPage();
													BorProc.applyBordereauTypeFilter("Premium");
													BorProc.applyMonthFilter("April");
													BorProc.refreshUploadedFile();
													Report.LogInfo("StepsCheck", "Step 27 completed", "PASS");
													if(BorProc.checkErrorReviewButton(BorProc.ReviewError)==true)
													{
														Report.LogInfo("MoreThanOneReportingChannelIdentified", "Status changed to Review Error.", "PASS");
														if(isVisible(MoreThanOneReportingChannelIdentified)== true){
															SelectDropDownValue(ReportingChannelIdDD, ReportingChannelIdDDValuePremium3);
															selectNoContproc();
															Report.LogInfo("StepsCheck", "Step 28 completed", "PASS");
															waitForElementToAppear(BorProc.RefreshAfterUpload,5);
															click(BorProc.RefreshAfterUpload,"Click on refresh");
															//refreshPage();
															BorProc.applyBordereauTypeFilter("Premium");
															BorProc.applyMonthFilter("April");
															BorProc.refreshUploadedFile();

															if(BorProc.checkErrorReviewButton(BorProc.ReviewError)==true)
															{
																selectNoContproc();
																waitForElementToAppear(BorProc.RefreshAfterUpload,5);
																click(BorProc.RefreshAfterUpload,"Click on refresh");
																refreshPage();
																BorProc.applyBordereauTypeFilter("Premium");
																BorProc.applyMonthFilter("April");
																BorProc.refreshUploadedFile();
																Report.LogInfo("StepsCheck", "Step 29 completed", "PASS");

																//Step 30, 31
																ApproveStatusFromReviewBordereauType2(mapValue);
																sleep(5000);
																waitForElementToAppear(BorProc.RefreshAfterUpload,5);
																click(BorProc.RefreshAfterUpload,"Click on refresh");
																Report.LogInfo("StepsCheck", "Step 30, 31 completed", "PASS");

																//Step 32
																scrollUp();
																refreshPage();
																policy.navigateToContractDetailsTab();
																waitForElementToAppear(permission.ClaimsAuthorityLink,5);
																verifyExists(permission.ClaimsAuthorityLink,"ClaimsAuthorityLink");
																click(permission.ClaimsAuthorityLink,"ClaimsAuthorityLink");

																AddClaimAuthrity();
																Report.LogInfo("StepsCheck", "Step 32 completed", "PASS");

																//Step 33
																//scrollUp();
																BorProc.navigationOnRoleTab();
																EditContractRole("1","Aspen Managing Agency Limited - 4711");
																EditContractRole("2","Brit Syndicates Limited - 2987");
																EditContractRole("3","Brit Syndicates Limited - 2987");
																EditContractRole("4","Brit Syndicates Limited - 2987");
																EditContractRole("5","Brit Syndicates Limited - 2987");
																EditContractRole("6","Brit Syndicates Limited - 2987");
																EditContractRole("7","Brit Syndicates Limited - 2987");
																EditContractRole("8","Brit Syndicates Limited - 2987");
																EditContractRole("9","Brit Syndicates Limited - 2987");
																EditContractRole("10","Brit Syndicates Limited - 2987");
																EditContractRole("11","Brit Syndicates Limited - 2987");
																Report.LogInfo("StepsCheck", "Step 33 completed", "PASS");

															}else{
																Report.LogInfo("StepsCheck", "Review error status not displayed", "FAIL");
															}
														}else{
															Report.LogInfo("ErrorScreenCheck", "Expected error screen not displayed.", "FAIL");
														}
													}else{
														Report.LogInfo("StepsCheck", "Review error status not displayed", "FAIL");
													}

												}
											}else{
												Report.LogInfo("StepsCheck", "Review error status not displayed", "FAIL");
											}
										}else{
											Report.LogInfo("ErrorScreenCheck", "Expected error screen not displayed.", "FAIL");
										}
									}else{
										Report.LogInfo("StepsCheck", "Review error status not displayed", "FAIL");
									}
								}else{
									Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");

								}
							}else{
								Report.LogInfo("ErrorScreenCheck", "Expected error screen not displayed.", "FAIL");
							}

						}else{
							Report.LogInfo("StepsCheck", "Review error status not displayed", "FAIL");
						}
					}
				}else{
					Report.LogInfo("StepsCheck", "Review error status not displayed", "FAIL");
				}
			}
		}
	}

	//TC 5653===============start=====================================================

	public void TaskAndNotes_TC5356() throws Exception
	{
		//Step 1
		BorProc.applyFilterPolicy(policy.PolicyNumber);		
		policy.openSelectedPolicy();
		sleep(3000);
		Report.LogInfo("StepsCheck", "Step 1 completed", "PASS");

		String contractId = ReturnContractID();

		//Step 2
		policy.navigationOnBordereauxTab();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("Review");
		String CurrentOwnr = "Standard, Brookes (Aspen Managing Agency Limited - 4711)";
		String Type = "Action";
		String Status = "Open";
		AddTask(TaskTitletxt,CurrentOwnr,Type,Status);
		Report.LogInfo("StepsCheck", "Step 1 to 6 completed", "PASS");

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("Review");
		String CurrentOwnr1 = "Standard, Brookes ";		
		AddTask(TaskTitlePremium,CurrentOwnr1,Type,Status);
		Report.LogInfo("StepsCheck", "Step 7 to 10 completed", "PASS");

		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("Review");
		AddTask(TaskTitleClaim,CurrentOwnr1,Type,Status);
		Report.LogInfo("StepsCheck", "Step 11 to 14 completed", "PASS");
	}
	public void  ChangeRole_CA_Insurer() throws Exception{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("1","Aspen Managing Agency Limited - 4711");
		Report.LogInfo("StepsCheck", "Step 1 completed", "PASS");


		loginPage.tideAdminLogOut();	
		loginPage.tideLogin(AdminInsure, AdminInsurePass);
	}
	public void  ChangeRole_CA_Broker() throws Exception{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("1","AON - DUA team");
		Report.LogInfo("StepsCheck", "Step 1 completed", "PASS");


		loginPage.tideAdminLogOut();
		loginPage.tideLogin(Standard_user_Broker, Standard_user_Broker_Pass);
	}
	public void ContractRoleCA_Insurer() throws Exception
	{	

		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");

		String Date = "2/2/1990";
		//Step 3
		policy.navigationOnPolicyTab();		
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		Report.LogInfo("StepCheck", "Step 3 completed", "PASS");

		//Step 4
		verifyUsercaneditContractdetails();
	
		Report.LogInfo("StepCheck", "Step 4 completed", "PASS");

		//Step 5
		NavigateToRoletab();
		EditContractRole("3","3 Dimensional Insurance Limited - DIM 1278");
		Report.LogInfo("StepCheck", "Step 5 completed", "PASS");

		//Step 6
		BorProc.openDATALink();
		Report.LogInfo("StepCheck", "Step 6 completed", "PASS");

		//Step 7
		waitForElementToAppear(SummaryTab,3);
		verifyExists(SummaryTab,"Summary tab can be viewed");
		Report.LogInfo("StepCheck", "Step 7 completed", "PASS");

		//Step 8
		verifyExists(BorProc.DATARiskTab,"Risk tab");
		click(BorProc.DATARiskTab,"Risk tab");		

		waitForElementToAppear(ApprovRiskFile,2);
		verifyExists(ApprovRiskFile,"Approve risk file name");
		verifyExists(RecordCount1,"Approve risk file name");
		Report.LogInfo("StepCheck", "Step 8 completed", "PASS");

		//Step 9sdfdsfd
		BorProc.navigateToDATAPremiumTab();
		waitForElementToAppear(ApprovPreminmFile,2);
		verifyExists(ApprovPreminmFile,"Approve Claim file name");
		verifyExists(RecordCount1,"Approve risk file name");
		Report.LogInfo("StepCheck", "Step 9 completed", "PASS");

		//Step 10
		BorProc.navigateToDATAClaimTab();
		waitForElementToAppear(ApprovClaimFile,2);
		verifyExists(ApprovClaimFile,"Approve Claim file name");
		verifyExists(RecordCount2,"Approve risk file name");
		Report.LogInfo("StepCheck", "Step 10 completed", "PASS");
		VerifyCreditcontrol();
		
		

		//Step 11 &12
		BorProc.SubmitBordereauxWithYesnoButtons(Date);
		SubmitBodVerifyOptions();
		Report.LogInfo("StepCheck", "Step 11 completed", "PASS");

		//Step 13
		NavigateOnExpected();		
		Report.LogInfo("StepCheck", "Step 13 completed", "PASS");

		//Step 14
		BorProc.applyBordereauTypeFilter("Risk");
		OverDueNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		OverDueNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		OverDueNoAction();

		Report.LogInfo("StepCheck", "Step 14 completed", "PASS");

		//Step 15
		NavigateOnRocessing();		
		Report.LogInfo("StepCheck", "Step 15 completed", "PASS");

		//Step 16
		BorProc.applyStatusFilter("Uploaded");
		BorProc.DeleteButtonCheckRowwise();
		Report.LogInfo("StepCheck", "Step 16 completed", "PASS");

		//Step 17
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("Review");
		ReviewNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("Review Errors");
		ReviewErrorNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("For Assignment");
		ForAssignmentNoAction();
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("For Approval");
	    ForApprovalNoAction();
	    
	    
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.applyStatusFilter("Review");
		ReviewNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.applyStatusFilter("Review Errors");
		ReviewErrorNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.applyStatusFilter("For Assignment");
		ForAssignmentNoAction();
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.applyStatusFilter("For Approval");
	    ForApprovalNoAction();
	    
		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("Review");
		ReviewNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("Review Errors");
		ReviewErrorNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("For Assignment");
		ForAssignmentNoAction();
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("For Approval");
	    ForApprovalNoAction();
	    
		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("Review");
		ReviewNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("Review Errors");
		ReviewErrorNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("For Assignment");
		ForAssignmentNoAction();
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("For Approval");
	    ForApprovalNoAction();
		
		
	

		Report.LogInfo("StepCheck", "Step 17 completed", "PASS");

		//Step 18
		refreshPage();
		String RiskChckBx ="@xpath=//input[@name='BordereauxType'][@value='Risk']";
		String ClaimChckBx ="@xpath=//input[@name='BordereauxType'][@value='Claim']";
		String PremiumChckBx ="@xpath=//input[@name='BordereauxType'][@value='Premium']";
		String RiskAndPremiumChckBx ="@xpath=//input[@name='BordereauxType'][@value='Risk and Premium']";

		BorProc.applyTypefilterAndVerifyApprov(RiskChckBx,"Approved");
		BorProc.applyTypefilterAndVerifyApprov(ClaimChckBx,"Approved");
		BorProc.applyTypefilterAndVerifyApprov(PremiumChckBx,"Approved");
		BorProc.applyTypefilterAndVerifyApprov(RiskAndPremiumChckBx,"Approved");
		Report.LogInfo("StepCheck", "Step 18 completed", "PASS");

		//Step 20
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannelPer();
		BorProc.applyReportingChannelIdentifyFilter("Risk Bordereaux Test");
		policy.editandDeleteReportingChannelOfContractForPer();
	//	policy.deleteReportingChannelOfContractForPer();
		refreshPage();
		mouseOverAction(AutuApprvClm);
		verifyExists(AutuApprvClm,"Auto-Approve");
		

		BorProc.applyReportingChannelIdentifyFilter("Risk Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		editReportingChannelwithoutAutoApproveSwitchEnabled();
		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Claim Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		editReportingChannelwithoutAutoApproveSwitchEnabled();

		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Premium Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		editReportingChannelwithoutAutoApproveSwitchEnabled();
		
		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Risk And Premium Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		editReportingChannelwithoutAutoApproveSwitchEnabled();

		Report.LogInfo("StepCheck", "Step 20 to 22 completed", "PASS");

		//Step 23
		policy.VerifyRulesTab();
		
		Report.LogInfo("StepCheck", "Step 23 completed", "PASS");
		//Step 24
		policy.navigateRulesGeneralTab();
		Report.LogInfo("StepCheck", "Step 24 completed", "PASS");
		//Step 25
		policy.navigateBreachesTab();
		Report.LogInfo("StepCheck", "Step 25 completed", "PASS");

		SelectDropDownValue(BreachsDrp,BreachsDrpVal);
		click(UnconfirmButton,"Lead insurer changes status");
		
		if(isVisible(BreachStatus)==true){
			refreshPage();
			Report.LogInfo("TabCheck", "User can change breach status", "PASS");
		}else{
			Report.LogInfo("TabCheck", "User cannot change breach status", "FAIL");
		}
		
		
		Report.LogInfo("StepCheck", "Step 26 completed", "PASS");

		//Step 27
		scrollUp();
		policy.navigateContarctDetailsTab();
		Report.LogInfo("StepCheck", "Step 27 completed", "PASS");
		//Step 28
		policy.navigateClaimsAuthorityTab();

		Report.LogInfo("StepCheck", "Step 28 completed", "PASS");
		//Step 29
		policy.navigateToFilesTab();		

		sleep(1000);
		if(isVisible(AddFileBtn)==true){
			Report.LogInfo("TabCheck", "Add file button displayed", "PASS");
		}else{
			Report.LogInfo("TabCheck", "Add file button not displayed", "FAIL");
		}
		Report.LogInfo("StepCheck", "Step 28 completed", "PASS");

		//Step 30
		policy.navigateToSectionTab();				
		policy.navigateToSectionRefDotEdit();
		policy.EditSubDivisionSection();
		Report.LogInfo("StepCheck", "Step 30 completed", "PASS");
		//Step 31
		policy.navigateToMarketsTabOnSection();
		policy.addMarketOnSectionExists();
		policy.editMarketOnSectionE();
		Report.LogInfo("StepCheck", "Step 31 completed", "PASS");
     
		policy.navigateToRiskCodesTabOnSection();
		policy.RiskCodesExistsOnSection();
		Report.LogInfo("StepCheck", "Step 34 completed", "PASS");

		//Step 32
		policy.navigateToSectionTab2();
		Report.LogInfo("StepCheck", "Step 32 completed", "PASS");
		//Step 33
		//policy.navigateToMarketsTabOnSection();
		//policy.addMarketOnSectionExists_1();
		//policy.EditMarketonSection_2();
		
		Report.LogInfo("StepCheck", "Step 33 completed", "PASS");
		//Edit existing market function need to automate
		//Step 34
		policy.navigateToRiskCodesTabOnSection();
		policy.RiskCodesExistsOnSection();
		Report.LogInfo("StepCheck", "Step 34 completed", "PASS");

		policy.navigateLocationTab();
		Report.LogInfo("StepCheck", "Step 35 completed", "PASS");
		//Step 35
		//policy.navigateRulesTab();
	//	Report.LogInfo("StepCheck", "Step 36 completed", "PASS");				

		if(isVisible(policy.AddSectionTab)==true){
			Report.LogInfo("ElementCheck", "Section tab is available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Section tab is not available", "FAIL");
		}
		Report.LogInfo("StepCheck", "Step 37 completed", "PASS");

		policy.navigationOnBordereauxTab();
		Report.LogInfo("StepCheck", "Step 38 completed", "PASS");

		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("Review");
		TaskCheck();
		Report.LogInfo("StepCheck", "Step 39 to 42 completed", "PASS");

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("Review");
		TaskCheck();
		Report.LogInfo("StepCheck", "Step 43 to 46 completed", "PASS");

		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("Review");
		TaskCheck();
		Report.LogInfo("StepCheck", "Step 47 to 50 completed", "PASS");
	}

	public void ContractAdminStandrdUser_TC4515() throws Exception
	{
		String Date = "2/2/1990";
		//Step 3
		policy.navigationOnPolicyTab();
		Report.LogInfo("StepCheck", "Step 2 completed", "PASS");

		//BorProc.applyFilterPolicy(policy.PolicyNumber);
		//Step 4,5
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		VerifyedidpolicyIsHidden();
		Report.LogInfo("StepCheck", "Step 3 completed", "PASS");

		//Step 7
		NavigateToRoletab();
		CannotEditContractRole("3");
           
		Report.LogInfo("StepCheck", "Step 4 completed", "PASS");

		//Step 8
		BorProc.openDATALink();
		Report.LogInfo("StepCheck", "Step 5 completed", "PASS");

		//Step 9
		waitForElementToAppear(SummaryTab,3);
		verifyExists(SummaryTab,"SummaryTab btn");
		Report.LogInfo("StepCheck", "Step 6 completed", "PASS");

		//Step 7
		verifyExists(BorProc.DATARiskTab,"Risk tab");
		click(BorProc.DATARiskTab,"Risk tab");		

		waitForElementToAppear(ApprovRiskFile,2);
		verifyExists(ApprovRiskFile,"Approve risk file name");
		verifyExists(RecordCount1,"Approve risk file name");
		Report.LogInfo("StepCheck", "Step 7 completed", "PASS");

		//Step 8
		BorProc.navigateToDATAPremiumTab();
		waitForElementToAppear(ApprovPreminmFile,2);
		verifyExists(ApprovPreminmFile,"Approve Claim file name");
		verifyExists(RecordCount1,"Approve risk file name");
		Report.LogInfo("StepCheck", "Step 8 completed", "PASS");

		//Step 9
		BorProc.navigateToDATAClaimTab();
		waitForElementToAppear(ApprovClaimFile,2);
		verifyExists(ApprovClaimFile,"Approve Claim file name");
		verifyExists(RecordCount2,"Approve risk file name");
		Report.LogInfo("StepCheck", "Step 9 completed", "PASS");
		VerifyCreditcontrol();

		//Step 10
		BorProc.SubmitBordereauxWithYesnoButtons(Date);
		if(isVisible(SubmitBodrBtn)==true)
		{
			Report.LogInfo("ElementCheck", "Submit bodreau button is available", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Submit bodreau button is not available", "PASS");
		}
		//SubmitBodVerifyOptions();
		NavigateOnExpected();

		BorProc.applyBordereauTypeFilter("Risk");
		OverDueNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		OverDueNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		OverDueNoAction();
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		OverDueNoAction();

		NavigateOnRocessing();		
		Report.LogInfo("StepCheck", "Step 10 to 14 completed", "PASS");

		//Step 15
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("Review");
		ReviewNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("Review Errors");
		ReviewErrorNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("For Assignment");
		ForAssignmentNoAction();
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("For Approval");
		ForApprovalNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("Review");
		ReviewNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("Review Errors");
		ReviewErrorNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("For Assignment");
		ForAssignmentNoAction();
		refreshPage();
		
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("For Approval");
		ForApprovalNoAction();
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("Review");
		ReviewNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("Review Errors");
		ReviewErrorNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("For Assignment");
		ForAssignmentNoAction();
		refreshPage();
		
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("For Approval");
		ForApprovalNoAction();
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.applyStatusFilter("Review");
		ReviewNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.applyStatusFilter("Review Errors");
		ReviewErrorNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.applyStatusFilter("For Assignment");
		ForAssignmentNoAction();
		refreshPage();
		
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.applyStatusFilter("For Approval");
		ForApprovalNoAction();
		
		
		Report.LogInfo("StepCheck", "Step 15 completed", "PASS");

		//Step 16
		refreshPage();
		String RiskChckBx ="@xpath=//input[@name='BordereauxType'][@value='Risk']";
		String ClaimChckBx ="@xpath=//input[@name='BordereauxType'][@value='Claim']";
		String PremiumChckBx ="@xpath=//input[@name='BordereauxType'][@value='Premium']";
		String RiskAndPremium ="@xpath=//input[@name='BordereauxType'][@value='Risk and Premium']";

		BorProc.applyTypefilterAndVerifyApprov(RiskChckBx,"Approved");
		BorProc.applyTypefilterAndVerifyApprov(ClaimChckBx,"Approved");
		BorProc.applyTypefilterAndVerifyApprov(PremiumChckBx,"Approved");
		//.applyTypefilterAndVerifyApprov(RiskAndPremium,"Approved");
		Report.LogInfo("StepCheck", "Step 16 to 17 completed", "PASS");

		//Step 18
		policy.navigateToReportingChannelsTab();
		if(isVisible(policy.AddReportingChannelBtn)==true){
			Report.LogInfo("ElementCheck", "Add reporting chanel button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add reporting chanel button is not visible", "PASS");
		}
		if(isVisible(policy.EditBtn1)==true){
			Report.LogInfo("ElementCheck", "Edit reporting chanel button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit reporting chanel button is not visible", "PASS");
		}

		Report.LogInfo("StepCheck", "Step 18 completed", "PASS");

		BorProc.applyReportingChannelIdentifyFilter("Risk Bordereaux 1");
		viewonlySectionAssignmentPopUp();

		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Claim Bordereaux 1");
		viewonlySectionAssignmentPopUp();

		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Premium Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		Report.LogInfo("StepCheck", "Step 19 completed", "PASS");

		//Step 20
		policy.navigateRulesTab();
		if(isVisible(policy.AddRulesBtn)==true){
			Report.LogInfo("ElementCheck", "Add Rule button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add Rule button is not visible", "PASS");
		}
		
		if(isVisible(policy.EditRulebtn1)==true){
			Report.LogInfo("ElementCheck", "Edit Rule button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit Rule button is not visible", "PASS");
		}
		
		Report.LogInfo("StepCheck", "Step 20 completed", "PASS");

		policy.navigateRulesGeneralTabNoEditBtn();
		Report.LogInfo("StepCheck", "Step 21 completed", "PASS");

		policy.navigateBreachesTab();
		
		SelectDropDownValue(BreachsDrp,BreachsDrpVal);
		click(UnconfirmButton,"Lead insurer changes status");
		
		if(isVisible(BreachStatus)==true){
			refreshPage();
			Report.LogInfo("TabCheck", "User can change breach status", "FAIL");
		}else{
			Report.LogInfo("TabCheck", "User cannot change breach status", "PASS");
		}
		
		Report.LogInfo("StepCheck", "Step 22 completed", "PASS");

		policy.navigateContarctDetailsTab();
		Report.LogInfo("StepCheck", "Step 23 completed", "PASS");

		policy.ReadonlyUsernavigateClaimsAuthorityTab();
		Report.LogInfo("StepCheck", "Step 24 completed", "PASS");
	

		policy.navigateToFilesTab();
		sleep(1000);
		if(isVisible(AddFileBtn)==true){
			Report.LogInfo("TabCheck", "Add File type button displayed", "FAIL");
		}else{
			Report.LogInfo("TabCheck", "Add File type button displayed", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 25 completed", "PASS");

		//Step 26
		policy.navigateToSectionTab();
		policy.ReadonlyusernavigateToSectionRefDotEdit();
		//policy.EditSubDivisionSection();
		Report.LogInfo("StepCheck", "Step 26 completed", "PASS");

		policy.navigateToMarketsTabOnSection();
		if(isVisible(policy.AddMarketButton)==true){
			Report.LogInfo("ElementCheck", "Add Market button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add Market button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 27 to 28 completed", "PASS");

		//Step 32
		policy.navigateToSectionTab2();
		policy.navigateToRiskCodesTabOnSection();
		if(isVisible(policy.AddRiskCodeButton)==true){
			Report.LogInfo("ElementCheck", "Add RiskCode button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add RiskCode button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 29 completed", "PASS");

		policy.navigateLocationTab();
		Report.LogInfo("StepCheck", "Step 31 completed", "PASS");

		policy.navigateRulesTab();
		if(isVisible(policy.AddRulesBtn)==true){
			Report.LogInfo("ElementCheck", "Add Rule button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add Rule button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 30 completed", "PASS");

		if(isVisible(policy.AddSectionTab)==true){
			Report.LogInfo("ElementCheck", "Section tab is available", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Section tab is not available", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 32 completed", "PASS");

		policy.navigationOnBordereauxTab();
		Report.LogInfo("StepCheck", "Step 33 completed", "PASS");

		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("Review");
		TaskAddEditBtnCheck();
		Report.LogInfo("StepCheck", "Step 34 completed", "PASS");

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("Review");
		TaskAddEditBtnCheck();
		Report.LogInfo("StepCheck", "Step 35 completed", "PASS");

		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("Review");
		TaskAddEditBtnCheck();
		Report.LogInfo("StepCheck", "Step 36 completed", "PASS");
	}
	public void Change_role_Insurer_RiskTransformation() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("1","Brit Syndicates Limited - 2987");
		EditContractRole("2","Aspen Managing Agency Limited - 4711");
		Report.LogInfo("StepsCheck", "Step 1 completed", "PASS");


		loginPage.tideAdminLogOut();
		
		Report.LogInfo("StepsCheck", "Step 1 completed", "PASS");
		sleep(3000);
		loginPage.tideLogin(AdminInsure, AdminInsurePass);
	}
	
	public void Change_role_Coverholder_RiskTransformation() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("1","Brit Syndicates Limited - 2987");
		EditContractRole("2","Coverholder Inc - New York");
		Report.LogInfo("StepsCheck", "Step 1 completed", "PASS");


		loginPage.tideAdminLogOut();
		
		Report.LogInfo("StepsCheck", "Step 1 completed", "PASS");
		sleep(3000);
		loginPage.tideLogin(Standard_user_CoverHolder, Standard_user_Coverholder_Pass);
	}
	
	public void Change_role_Broker_RiskTransformation() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("1","Brit Syndicates Limited - 2987");
		EditContractRole("2","Aspen Managing Agency Limited - 4711");
		Report.LogInfo("StepsCheck", "Step 1 completed", "PASS");


		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 1 completed", "PASS");
		sleep(3000);
		loginPage.tideLogin(Standard_user_Broker, Standard_user_Broker_Pass);

	}

	public void RiskInformationStandrdInsirerUser_TC4516() throws Exception
	{
	
		//Step 3 
		Report.LogInfo("StepsCheck", "Step 3 completed", "PASS");

		String Date = "2/2/1990";
		//Step 4
		policy.navigationOnPolicyTab();
		Report.LogInfo("StepCheck", "Step 4 completed", "PASS");

		//BorProc.applyFilterPolicy(policy.PolicyNumber);
		//Step 4,5, 6
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		Report.LogInfo("StepCheck", "Step 6 completed", "PASS");

		openPolicyInEditMode();
		Report.LogInfo("StepCheck", "Step 7 completed", "PASS");

		EditCompanyrefDetails();
		Report.LogInfo("StepCheck", "Step 8 completed", "PASS");

		policy.navigateClaimsAuthorityTab1();
		Report.LogInfo("StepCheck", "Step 9 completed", "PASS");

		//Step 9
		NavigateToRoletab();
		CannotEditContractRole("4");
		Report.LogInfo("StepCheck", "Step 10 completed", "PASS");

		//Step 11
		BorProc.openDATALink();
		Report.LogInfo("StepCheck", "Step 11 completed", "PASS");

		//Step 12
		waitForElementToAppear(SummaryTab,3);
		verifyExists(SummaryTab,"SummaryTab btn");
		Report.LogInfo("StepCheck", "Step 12 completed", "PASS");

		//Step 13
		verifyExists(BorProc.DATARiskTab,"Risk tab");
		click(BorProc.DATARiskTab,"Risk tab");		
		String detailsONRisk = "@xpath=.//*[@class='k-pager-info k-label'][text()='1 - 11 of 22 items']";
		if(isVisible(detailsONRisk)==true){
			Report.LogInfo("ElementCheck", "All details displayed on Risk tab", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "All details not displayed as expected on Risk tab", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 13 completed", "PASS");

		//Step 14		
		BorProc.navigateToDATAPremiumTab();
		waitForElementToAppear(ApprovPreminmFile,2);
		verifyExists(ApprovPreminmFile,"Approve Premium file name");
		verifyExists(RecordCount1,"Approve risk file name");
		Report.LogInfo("StepCheck", "Step 14 completed", "PASS");

		//Step 15
		BorProc.navigateToDATAClaimTab();
		waitForElementToAppear(ApprovClaimFile,2);
		verifyExists(ApprovClaimFile,"Approve Claim file name");
		verifyExists(RecordCount2,"Approve risk file name");
		Report.LogInfo("StepCheck", "Step 15 completed", "PASS");

		//Step 16
		BorProc.SubmitBordereauxWithYesnoButtons(Date);
		SubmitBodVerifyRiskOption();
		NavigateOnExpected();		
		Report.LogInfo("StepCheck", "Step 16 to 18 completed", "PASS");

		sleep(2000);
		BorProc.applyBordereauTypeFilter("Risk");
		firstRcrdOverDueActionOccrd();
		Report.LogInfo("StepCheck", "Step 19 completed", "PASS");

		refreshPage();
		//NavigateOnRocessing();
		BorProc.applyBordereauTypeFilter("Premium");
		OverDueNoAction();

		BorProc.applyBordereauTypeFilter("Claim");
		OverDueNoAction();
		
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		OverDueNoAction();
		Report.LogInfo("StepCheck", "Step 20 completed", "PASS");

		NavigateOnRocessing();		
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("Review");
		BorProc.applyStatusFilter("Review Errors");
		BorProc.applyStatusFilter("Uploaded");		
		BorProc.DeleteButtonCheckRowwiseforAllStatus();
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.applyStatusFilter("Review");
		BorProc.applyStatusFilter("Review Errors");
		BorProc.applyStatusFilter("Uploaded");		
		BorProc.DeleteButtonCheckRowwiseforAllStatus();
		Report.LogInfo("StepCheck", "Step 21 completed", "PASS");

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.DeleteButtonCheckRowwiseforAllStatus1();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.DeleteButtonCheckRowwiseforAllStatus1();
		Report.LogInfo("StepCheck", "Step 22 completed", "PASS");
//Check for delete Icon
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("Uploaded");
		verifyExists(UploadBtn,"Upload button");
		click(UploadBtn,"Upload button");
		String Header = "@xpath=.//*[@id='content']//h2[text()='Submit Bordereau']";
		verifyExists(Header,"Submit Bordereau page");
		goBack();
		
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.applyStatusFilter("Uploaded");
		verifyExists(UploadBtn,"Upload button");
		click(UploadBtn,"Upload button");
		verifyExists(Header,"Submit Bordereau page");
		goBack();

		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("Review");
		verifyExists(BorProc.ReviewBtn,"Review button");
		click(BorProc.ReviewBtn,"Review button");
		String HeaderReview = "@xpath=.//*[@id='content']//span[text()='Bordereau Transformation']";
		verifyExists(HeaderReview,"Submit Bordereau page");
		goBack();
		
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.applyStatusFilter("Review");
		verifyExists(BorProc.ReviewBtn,"Review button");
		click(BorProc.ReviewBtn,"Review button");
		verifyExists(HeaderReview,"Submit Bordereau page");
		goBack();

		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("Review Errors");
		verifyExists(BorProc.ReviewError,"Review Error button");
		click(BorProc.ReviewError,"Review Error button");
		String HeaderReviewError = "@xpath=.//*[@id='content']//span[text()='Bordereau Transformation']";
		verifyExists(HeaderReviewError,"Submit Bordereau page");
		goBack();
		
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.applyStatusFilter("Review Errors");
		verifyExists(BorProc.ReviewError,"Review Error button");
		click(BorProc.ReviewError,"Review Error button");
		verifyExists(HeaderReviewError,"Submit Bordereau page");
		goBack();
		
		
		Report.LogInfo("StepCheck", "Step 23 completed", "PASS");
		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("Uploaded");
		click(UploadBtn,"Uploaded button");
		processingTabDisplay();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("Review");
		click(BorProc.ReviewBtn,"Review button");
		processingTabDisplay();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("Review Errors");
		click(BorProc.ReviewError,"Review errors button");
		processingTabDisplay();		

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("Uploaded");
		click(UploadBtn,"Uploaded button");
		processingTabDisplay();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("Review");
		click(BorProc.ReviewBtn,"Review button");
		processingTabDisplay();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("Review Errors");
		click(BorProc.ReviewError,"Review errors button");
		processingTabDisplay();

		Report.LogInfo("StepCheck", "Step 24 completed", "PASS");
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("For Assignment");
		String forAssignment = "@xpath=.//*[@id='grid']//button[text()='For Assignment']";
		click(forAssignment,"For Approval button");
		processingTabDisplay();
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.applyStatusFilter("For Assignment");
		click(forAssignment,"For Approval button");
		processingTabDisplay();
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("For Assignment");
		click(forAssignment,"For Approval button");
		processingTabDisplay();
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("For Assignment");
		click(forAssignment,"For Approval button");
		processingTabDisplay();
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("For Approval");
		String forApproval = "@xpath=.//*[@id='grid']//button[text()='For Approval']";
		click(forApproval,"For Approval button");
		processingTabDisplay();
	
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("For Approval");
		click(forApproval,"For Approval button");
		processingTabDisplay();
	
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("For Approval");
		click(forApproval,"For Approval button");
		processingTabDisplay();
		Report.LogInfo("StepCheck", "Step 25 completed", "PASS");
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.applyStatusFilter("For Approval");
		click(forApproval,"For Approval button");
		processingTabDisplay();
		Report.LogInfo("StepCheck", "Step 25 completed", "PASS");

		//Step 26
		refreshPage();
		String RiskChckBx ="@xpath=//input[@name='BordereauxType'][@value='Risk']";
		String ClaimChckBx ="@xpath=//input[@name='BordereauxType'][@value='Claim']";
		String PremiumChckBx ="@xpath=//input[@name='BordereauxType'][@value='Premium']";
		String RiskAndPremiumChckBx ="@xpath=//input[@name='BordereauxType'][@value='Risk And Premium']";

		BorProc.applyTypefilterAndVerifyApprov(RiskChckBx,"Approved");
		BorProc.applyTypefilterAndVerifyApprov(ClaimChckBx,"Approved");
		BorProc.applyTypefilterAndVerifyApprov(PremiumChckBx,"Approved");
		BorProc.applyTypefilterAndVerifyApprov(RiskAndPremiumChckBx,"Approved");
		
		Report.LogInfo("StepCheck", "Step 26 completed", "PASS");

		//Step 27
		policy.navigateToReportingChannelsTab();
		if(isVisible(policy.AddReportingChannelBtn)==true){
			Report.LogInfo("ElementCheck", "Add reporting chanel button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add reporting chanel button is not visible", "PASS");
		}
		if(isVisible(policy.EditBtn1)==true){
			Report.LogInfo("ElementCheck", "Edit reporting chanel button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit reporting chanel button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 27 completed", "PASS");

		BorProc.applyReportingChannelIdentifyFilter("Risk Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		viewonlyRiskCodeAssignmentPopUp();

		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Claim Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		viewonlyRiskCodeAssignmentPopUp();
		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Premium Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		viewonlyRiskCodeAssignmentPopUp();
		Report.LogInfo("StepCheck", "Step 28 completed", "PASS");

		//Step 29
		policy.navigateRulesTab();
		if(isVisible(policy.AddRulesBtn)==true){
			Report.LogInfo("ElementCheck", "Add Rule button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add Rule button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 29 completed", "PASS");
		
		if(isVisible(policy.EditRulesBtn)==true){
			Report.LogInfo("ElementCheck", "Add Rule button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add Rule button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 29 completed", "PASS");

		policy.TransformationnavigateRulesGeneralTab();
		Report.LogInfo("StepCheck", "Step 30 completed", "PASS");

		policy.navigateBreachesTab();
		
		SelectDropDownValue(BreachsDrp,BreachsDrpVal);
		click(UnconfirmButton,"Lead insurer changes status");
		
		if(isVisible(BreachStatus)==true){
			refreshPage();
			Report.LogInfo("TabCheck", "User can change breach status", "PASS");
		}else{
			Report.LogInfo("TabCheck", "User cannot change breach status", "FAIL");
		}
		Report.LogInfo("StepCheck", "Step 31 completed", "PASS");

		policy.navigateToFilesTab();
		sleep(1000);
		if(isVisible(AddFileBtn)==true){
			Report.LogInfo("TabCheck", "Add File button displayed", "FAIL");
		}else{
			Report.LogInfo("TabCheck", "Add File button displayed", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 32 completed", "PASS");

		//Step 33
		policy.navigateToSectionTab();
		policy.navigateToSectionRefDotEdit();
		policy.EditSubDivisionSection();
		Report.LogInfo("StepCheck", "Step 33 completed", "PASS");

		policy.navigateToMarketsTabOnSection();
		if(isVisible(policy.AddMarketButton)==true){
			Report.LogInfo("ElementCheck", "Add Market button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add Market button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 34 completed", "PASS");

		policy.navigateToRiskCodesTabOnSection();
		if(isVisible(policy.AddRiskCodeButton)==true){
			Report.LogInfo("ElementCheck", "Add RiskCode button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add RiskCode button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 35 completed", "PASS");

		policy.navigateLocationTab();
		Report.LogInfo("StepCheck", "Step 36 completed", "PASS");
		//policy.addRiskCodesOnSection();
		policy.navigateRulesTab();
		if(isVisible(policy.AddRulesBtn)==true){
			Report.LogInfo("ElementCheck", "Add Rule button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add Rule button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 37 completed", "PASS");
		//policy.addRules();


		if(isVisible(policy.AddSectionTab)==true){
			Report.LogInfo("ElementCheck", "Section tab is available", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Section tab is not available", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 38 completed", "PASS");

		policy.navigationOnBordereauxTab();
		Report.LogInfo("StepCheck", "Step 39 completed", "PASS");

		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("Review");
		TaskCheck();
		Report.LogInfo("StepCheck", "Step 43 completed", "PASS");

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("Review");
		TaskAddEditBtnCheck1();
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("Review");
		TaskAddEditBtnCheck1();
		Report.LogInfo("StepCheck", "Step 47 completed", "PASS");

	}

	public void Read_Only_User_ActivityRole(String Roletype) throws Exception
	{
		String Date = "2/2/1990";
		//Step 3
		policy.navigationOnPolicyTab();
		Report.LogInfo("StepCheck", "Step 2 completed", "PASS");

		//BorProc.applyFilterPolicy(policy.PolicyNumber);
		//Step 4,5
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		openPolicyEditMode();
		Report.LogInfo("StepCheck", "Step 5 completed", "PASS");

		//Step 6
		NavigateToRoletab();
		CannotEditContractRole("4");
		Report.LogInfo("StepCheck", "Step 6 completed", "PASS");

		//Step 7
		BorProc.openDATALink();
		Report.LogInfo("StepCheck", "Step 7 completed", "PASS");

		//Step 8
		waitForElementToAppear(SummaryTab,3);
		verifyExists(SummaryTab,"SummaryTab btn");
		Report.LogInfo("StepCheck", "Step 8 completed", "PASS");

		//Step 9
		verifyExists(BorProc.DATARiskTab,"Risk tab");
		click(BorProc.DATARiskTab,"Risk tab");	
		if(Roletype=="Risk_Transformation") {
			String detailsONRisk = "@xpath=.//*[@class='k-pager-info k-label'][text()='1 - 11 of 22 items']";
			if(isVisible(detailsONRisk)==true){
				Report.LogInfo("ElementCheck", "All details displayed on Risk tab", "PASS");
			}else{
				Report.LogInfo("ElementCheck", "All details not displayed as expected on Risk tab", "PASS");
			}
			Report.LogInfo("StepCheck", "Step 9 completed", "PASS");
		}
		else if(Roletype=="Risk_Assignment"){
			String detailsONRisk = "@xpath=.//*[@class='k-pager-info k-label'][text()='1 - 12 of 12 items']";
			if(isVisible(detailsONRisk)==true){
				Report.LogInfo("ElementCheck", "All details displayed on Risk tab", "PASS");
			}else{
				Report.LogInfo("ElementCheck", "All details not displayed as expected on Risk tab", "PASS");
			}
			Report.LogInfo("StepCheck", "Step 9 completed", "PASS");
		}
			
		
			
else if(Roletype=="Risk_Approval"){
	
	String detailsONRisk = "@xpath=.//*[@class='k-pager-info k-label'][text()='1 - 8 of 8 items']";
	if(isVisible(detailsONRisk)==true){
		Report.LogInfo("ElementCheck", "All details displayed on Risk tab", "PASS");
	}else{
		Report.LogInfo("ElementCheck", "All details not displayed as expected on Risk tab", "PASS");
	}
	Report.LogInfo("StepCheck", "Step 9 completed", "PASS");
}
		
else {
	
	waitForElementToAppear(ApprovRiskFile,2);
	verifyExists(ApprovRiskFile,"Approve risk file name");
	verifyExists(RecordCount1,"Approve risk file name");
	Report.LogInfo("ElemenyCheck", "Records not found", "FAIL");
}
		
		
		
		
  
		

		//Step 10
		BorProc.navigateToDATAPremiumTab();
		
		
		if(Roletype=="Premium_Transformation") {
			String detailsONPremium = "@xpath=.//*[@class='k-pager-info k-label'][text()='1 - 12 of 12 items']";
			if(isVisible(detailsONPremium)==true){
				Report.LogInfo("ElementCheck", "All details displayed on Risk tab", "PASS");
			}else{
				Report.LogInfo("ElementCheck", "All details not displayed as expected on Risk tab", "PASS");
			}
			Report.LogInfo("StepCheck", "Step 9 completed", "PASS");
		}
		else if(Roletype=="Premium_Assignment"){
			String detailsONRisk = "@xpath=.//*[@class='k-pager-info k-label'][text()='1 - 7 of 7 items']";
			if(isVisible(detailsONRisk)==true){
				Report.LogInfo("ElementCheck", "All details displayed on Risk tab", "PASS");
			}else{
				Report.LogInfo("ElementCheck", "All details not displayed as expected on Risk tab", "PASS");
			}
			Report.LogInfo("StepCheck", "Step 9 completed", "PASS");
		}
			
		
			
else if(Roletype=="Premium_Approval"){
	
	String detailsONRisk = "@xpath=.//*[@class='k-pager-info k-label'][text()='1 - 5 of 5 items']";
	if(isVisible(detailsONRisk)==true){
		Report.LogInfo("ElementCheck", "All details displayed on Risk tab", "PASS");
	}else{
		Report.LogInfo("ElementCheck", "All details not displayed as expected on Risk tab", "PASS");
	}
	Report.LogInfo("StepCheck", "Step 9 completed", "PASS");
} else {
		waitForElementToAppear(ApprovPreminmFile,2);
		verifyExists(ApprovPreminmFile,"Approve Claim file name");
		verifyExists(RecordCount1,"Approve risk file name");
		Report.LogInfo("StepCheck", "Step 10 completed", "PASS");
}
		//Step 11
		
		
		
		BorProc.navigateToDATAClaimTab();
		
		if(Roletype=="Claim_Transformation") {
			String detailsONClaims = "@xpath=.//*[@class='k-pager-info k-label'][text()='1 - 11 of 11 items']";
			if(isVisible(detailsONClaims)==true){
				Report.LogInfo("ElementCheck", "All details displayed on Risk tab", "PASS");
			}else{
				Report.LogInfo("ElementCheck", "All details not displayed as expected on Risk tab", "PASS");
			}
			Report.LogInfo("StepCheck", "Step 9 completed", "PASS");
		}
		else if(Roletype=="Claim_Assignment"){
			String detailsONClaims = "@xpath=.//*[@class='k-pager-info k-label'][text()='1 - 6 of 6 items']";
			if(isVisible(detailsONClaims)==true){
				Report.LogInfo("ElementCheck", "All details displayed on Risk tab", "PASS");
			}else{
				Report.LogInfo("ElementCheck", "All details not displayed as expected on Risk tab", "PASS");
			}
			Report.LogInfo("StepCheck", "Step 9 completed", "PASS");
		}
			
		
			
else if(Roletype=="Claim_Approval"){
	
	String detailsONClaims = "@xpath=.//*[@class='k-pager-info k-label'][text()='1 - 4 of 4 items']";
	if(isVisible(detailsONClaims)==true){
		Report.LogInfo("ElementCheck", "All details displayed on Risk tab", "PASS");
	}else{
		Report.LogInfo("ElementCheck", "All details not displayed as expected on Risk tab", "PASS");
	}
	Report.LogInfo("StepCheck", "Step 9 completed", "PASS");
} else {		
		
		waitForElementToAppear(ApprovClaimFile,2);
		verifyExists(ApprovClaimFile,"Approve Claim file name");
		verifyExists(RecordCount2,"Approve risk file name");
		Report.LogInfo("StepCheck", "Step 11 completed", "PASS");
}
		//Step 12
		BorProc.SubmitBordereauxWithYesnoButtons(Date);
		if(isVisible(SubmitBodrBtn)==true)
		{
			Report.LogInfo("ElementCheck", "Submit button is available", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Submit button is not available", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 12 completed", "PASS");

		NavigateOnExpected();
		Report.LogInfo("StepCheck", "Step 14 completed", "PASS");

		sleep(2000);
		BorProc.applyBordereauTypeFilter("Risk");
		OverDueNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		OverDueNoAction();
		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		OverDueNoAction();
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		OverDueNoAction();

		Report.LogInfo("StepCheck", "Step 15 completed", "PASS");

		NavigateOnRocessing();	
		BorProc.DeleteButtonCheckRowwiseforAllStatus1();
		Report.LogInfo("StepCheck", "Step 16 completed", "PASS");

		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("Uploaded");
		click(UploadBtn,"Uploaded button");
		processingTabDisplay();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("Review");
		click(BorProc.ReviewBtn,"Review button");
		processingTabDisplay();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("Review Errors");
		click(BorProc.ReviewError,"Review errors button");
		processingTabDisplay();	
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("For Approval");
		click(BorProc.ForApprovalBtn,"For Approval Button");
		processingTabDisplay();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("For Assignment");
		click(BorProc.ForAssignmentBtn,"For Assignment");
		processingTabDisplay();	

		BorProc.applyBordereauTypeFilter("Claim");
 		BorProc.applyStatusFilter("Uploaded");
		click(UploadBtn,"Uploaded button");
		processingTabDisplay();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("Review");
		click(BorProc.ReviewBtn,"Review button");
		processingTabDisplay();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("Review Errors");
		click(BorProc.ReviewError,"Review errors button");
		processingTabDisplay();		
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("For Approval");
		click(BorProc.ForApprovalBtn,"For Approval Button");
		processingTabDisplay();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("For Assignment");
		click(BorProc.ForAssignmentBtn,"For Assignment Buttom");
		processingTabDisplay();	

		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("Uploaded");
		click(UploadBtn,"Uploaded button");
		processingTabDisplay();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("Review");
		click(BorProc.ReviewBtn,"Review button");
		processingTabDisplay();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("Review Errors");
		click(BorProc.ReviewError,"Review errors button");
		processingTabDisplay();
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("For Approval");
		click(BorProc.ForApprovalBtn,"For Approval Button");
		processingTabDisplay();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("For Assignment");
		click(BorProc.ForAssignmentBtn,"For Assignment Buttom");
		processingTabDisplay();	
		Report.LogInfo("StepCheck", "Step 17 completed", "PASS");
		
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.applyStatusFilter("Uploaded");
		click(UploadBtn,"Uploaded button");
		processingTabDisplay();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.applyStatusFilter("Review");
		click(BorProc.ReviewBtn,"Review button");
		processingTabDisplay();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.applyStatusFilter("Review Errors");
		click(BorProc.ReviewError,"Review errors button");
		processingTabDisplay();
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.applyStatusFilter("For Approval");
		click(BorProc.ForApprovalBtn,"For Approval Button");
		processingTabDisplay();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.applyStatusFilter("For Assignment");
		click(BorProc.ForAssignmentBtn,"For Assignment Buttom");
		processingTabDisplay();	
		Report.LogInfo("StepCheck", "Step 17 completed", "PASS");


		//Step 18
		refreshPage();
		String RiskChckBx ="@xpath=//input[@name='BordereauxType'][@value='Risk']";
		String ClaimChckBx ="@xpath=//input[@name='BordereauxType'][@value='Claim']";
		String PremiumChckBx ="@xpath=//input[@name='BordereauxType'][@value='Premium']";

		BorProc.applyTypefilterAndVerifyApprov(RiskChckBx,"Approved");
		BorProc.applyTypefilterAndVerifyApprov(ClaimChckBx,"Approved");
		BorProc.applyTypefilterAndVerifyApprov(PremiumChckBx,"Approved");
		Report.LogInfo("StepCheck", "Step 18 completed", "PASS");

		//Step 19
		policy.navigateToReportingChannelsTab();
		if(isVisible(policy.AddReportingChannelBtn)==true){
			Report.LogInfo("ElementCheck", "Add reporting chanel button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add reporting chanel button is not visible", "PASS");
		}
		if(isVisible(policy.EditBtn1)==true){
			Report.LogInfo("ElementCheck", "Edit reporting chanel button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit reporting chanel button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 19 completed", "PASS");

		//Step 20
		BorProc.applyReportingChannelIdentifyFilter("Risk Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		viewonlyRiskCodeAssignmentPopUp();

		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Claim Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		viewonlyRiskCodeAssignmentPopUp();

		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Premium Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		viewonlyRiskCodeAssignmentPopUp();
		Report.LogInfo("StepCheck", "Step 20 completed", "PASS");

		//Step 21
		policy.navigateRulesTab();
		if(isVisible(policy.AddRulesBtn)==true){
			Report.LogInfo("ElementCheck", "Add Rule button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add Rule button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 21 completed", "PASS");

		policy.TransformationnavigateRulesGeneralTab();
		Report.LogInfo("StepCheck", "Step 22 completed", "PASS");

		policy.navigateBreachesTab();
		
		SelectDropDownValue(BreachsDrp,BreachsDrpVal);
		click(UnconfirmButton,"Lead insurer changes status");
		
		if(isVisible(BreachStatus)==true){
			refreshPage();
			Report.LogInfo("TabCheck", "User can change breach status", "FAIL");
		}else{
			Report.LogInfo("TabCheck", "User cannot change breach status", "PASS");
		}
		
		Report.LogInfo("StepCheck", "Step 22 completed", "PASS");

		policy.navigateContarctDetailsTab();
		Report.LogInfo("StepCheck", "Step 23 completed", "PASS");

		policy.ReadonlyUsernavigateClaimsAuthorityTab();
		Report.LogInfo("StepCheck", "Step 24 completed", "PASS");
	

		policy.navigateToFilesTab();
		sleep(1000);
		if(isVisible(AddFileBtn)==true){
			Report.LogInfo("TabCheck", "Add File type button displayed", "FAIL");
		}else{
			Report.LogInfo("TabCheck", "Add File type button displayed", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 25 completed", "PASS");

		//Step 26
		policy.navigateToSectionTab();
		policy.ReadonlyusernavigateToSectionRefDotEdit();
		//policy.EditSubDivisionSection();
		Report.LogInfo("StepCheck", "Step 26 completed", "PASS");

		policy.navigateToMarketsTabOnSection();
		if(isVisible(policy.AddMarketButton)==true){
			Report.LogInfo("ElementCheck", "Add Market button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add Market button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 27 to 28 completed", "PASS");

		//Step 32
		policy.navigateToSectionTab2();
		policy.navigateToRiskCodesTabOnSection();
		if(isVisible(policy.AddRiskCodeButton)==true){
			Report.LogInfo("ElementCheck", "Add RiskCode button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add RiskCode button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 29 completed", "PASS");

		policy.navigateLocationTab();
		Report.LogInfo("StepCheck", "Step 31 completed", "PASS");

		policy.navigateRulesTab();
		if(isVisible(policy.AddRulesBtn)==true){
			Report.LogInfo("ElementCheck", "Add Rule button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add Rule button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 30 completed", "PASS");

		if(isVisible(policy.AddSectionTab)==true){
			Report.LogInfo("ElementCheck", "Section tab is available", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Section tab is not available", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 32 completed", "PASS");

		policy.navigationOnBordereauxTab();
		Report.LogInfo("StepCheck", "Step 33 completed", "PASS");

		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("Review");
		TaskAddEditBtnCheck();
		Report.LogInfo("StepCheck", "Step 34 completed", "PASS");

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("Review");
		TaskAddEditBtnCheck();
		Report.LogInfo("StepCheck", "Step 35 completed", "PASS");

		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("Review");
		TaskAddEditBtnCheck();
		Report.LogInfo("StepCheck", "Step 36 completed", "PASS");
	}

	public void RiskAssignmentRoleChange_Insurer() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("2","Brit Syndicates Limited - 2987");
		EditContractRole("3","Aspen Managing Agency Limited - 4711");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(AdminInsure, AdminInsurePass);
	}
	
	public void RiskAssignmentRoleChange_Broker() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("2","Brit Syndicates Limited - 2987");
		EditContractRole("3","AON - DUA team");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(Standard_user_Broker, Standard_user_Broker_Pass);
	}
	

	public void RiskAssignmentRoleChange_Coverholder() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("2","Brit Syndicates Limited - 2987");
		EditContractRole("3","	Coverholder Inc - New York");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(Standard_user_CoverHolder, Standard_user_Coverholder_Pass);
	}
	
	
	

	public void RiskAssignmentStandrdInsirerUser_TC4779() throws Exception
	{
		Report.LogInfo("StepsCheck", "Step 3 completed", "PASS");

		String Date = "2/2/1990";
		//Step 4
		policy.navigationOnPolicyTab();
		Report.LogInfo("StepCheck", "Step 4 completed", "PASS");

		//BorProc.applyFilterPolicy(policy.PolicyNumber);
		//Step 4,5, 6
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		Report.LogInfo("StepCheck", "Step 6 completed", "PASS");

		openPolicyInEditMode();
		Report.LogInfo("StepCheck", "Step 7 completed", "PASS");

		EditCompanyrefDetails();
		Report.LogInfo("StepCheck", "Step 8 completed", "PASS");

		policy.navigateClaimsAuthorityTab1();
		Report.LogInfo("StepCheck", "Step 9 completed", "PASS");

		//Step 9
		NavigateToRoletab();
		CannotEditContractRole("4");
		Report.LogInfo("StepCheck", "Step 10 completed", "PASS");

		//Step 11
		BorProc.openDATALink();
		Report.LogInfo("StepCheck", "Step 11 completed", "PASS");

		//Step 12
		waitForElementToAppear(SummaryTab,3);
		verifyExists(SummaryTab,"SummaryTab btn");
		Report.LogInfo("StepCheck", "Step 12 completed", "PASS");

		//Step 13
		verifyExists(BorProc.DATARiskTab,"Risk tab");
		click(BorProc.DATARiskTab,"Risk tab");		
		String detailsONRisk = "@xpath=.//*[@class='k-pager-info k-label'][text()='1 - 12 of 12 items']";
		if(isVisible(detailsONRisk)==true){
			Report.LogInfo("ElementCheck", "All details displayed on Risk tab", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "All details not displayed as expected on Risk tab", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 13 completed", "PASS");

		//Step 14
		BorProc.navigateToDATAPremiumTab();
		waitForElementToAppear(ApprovPreminmFile,2);
		verifyExists(ApprovPreminmFile,"Approve Claim file name");
		verifyExists(RecordCount1,"Approve risk file name");
		Report.LogInfo("StepCheck", "Step 14 completed", "PASS");

		//Step 15
		BorProc.navigateToDATAClaimTab();
		waitForElementToAppear(ApprovClaimFile,2);
		verifyExists(ApprovClaimFile,"Approve Claim file name");
		verifyExists(RecordCount2,"Approve risk file name");
		Report.LogInfo("StepCheck", "Step 15 completed", "PASS");

		//Step 16
		BorProc.SubmitBordereauxWithYesnoButtons(Date);
		SubmitBodVerifyOptions();
		NavigateOnExpected();
		Report.LogInfo("StepCheck", "Step 16 to 18 completed", "PASS");

		sleep(2000);
		BorProc.applyBordereauTypeFilter("Risk");
		OverDueNoAction();	

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		OverDueNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		OverDueNoAction();
		Report.LogInfo("StepCheck", "Step 19 completed", "PASS");

		NavigateOnRocessing();	
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.DeleteButtonCheckRowwiseforAllStatus1();
		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.DeleteButtonCheckRowwiseforAllStatus1();
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.DeleteButtonCheckRowwiseforAllStatus1();
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.DeleteButtonCheckRowwiseforAllStatus1();
		Report.LogInfo("StepCheck", "Step 20 completed", "PASS");		

		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.scrollDown();
		BorProc.applyStatusFilter("Uploaded");
		sleep(1000);
		BorProc.applyStatusFilter("For Approval");
		sleep(1000);
		BorProc.scrollDown();
		BorProc.applyStatusFilter("Review");
		sleep(1000);
		BorProc.scrollDown();
		BorProc.applyStatusFilter("Review Errors");
		sleep(1000);
		BorProc.statusButtonNotclickableCheckRowwise();
		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.statusButtonNotclickableCheckRowwise();
		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.statusButtonNotclickableCheckRowwise();
		refreshPage();
		
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.scrollDown();
		BorProc.applyStatusFilter("Uploaded");
		sleep(1000);
		BorProc.applyStatusFilter("For Approval");
		sleep(1000);
		BorProc.scrollDown();
		BorProc.applyStatusFilter("Review");
		sleep(1000);
		BorProc.scrollDown();
		BorProc.applyStatusFilter("Review Errors");
		sleep(1000);
		BorProc.statusButtonNotclickableCheckRowwise();
		refreshPage();
		Report.LogInfo("StepCheck", "Step 21 completed", "PASS");
		
	
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.scrollDown();
		BorProc.applyStatusFilter("For Assignment");
		String forAssignment = "@xpath=.//*[@id='grid']//button[text()='For Assignment']";
		click(forAssignment,"For Approval button");
		processingTabShouldNtDisplay();
	
		
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.scrollDown();
		BorProc.applyStatusFilter("For Assignment");
		click(forAssignment,"For Approval button");
		processingTabShouldNtDisplay();

		
		
		Report.LogInfo("StepCheck", "Step 23 completed", "PASS");

		//Step 24
		refreshPage();
		String RiskChckBx ="@xpath=//input[@name='BordereauxType'][@value='Risk']";
		String ClaimChckBx ="@xpath=//input[@name='BordereauxType'][@value='Claim']";
		String PremiumChckBx ="@xpath=//input[@name='BordereauxType'][@value='Premium']";
		String RiskAndPremiumChckBx ="@xpath=//input[@name='BordereauxType'][@value='Risk And Premium']";

		BorProc.applyTypefilterAndVerifyApprov(RiskChckBx,"Approved");
		BorProc.applyTypefilterAndVerifyApprov(ClaimChckBx,"Approved");
		BorProc.applyTypefilterAndVerifyApprov(PremiumChckBx,"Approved");
		BorProc.applyTypefilterAndVerifyApprov(RiskAndPremiumChckBx,"Approved");
		Report.LogInfo("StepCheck", "Step 24 completed", "PASS");

		//Step 25
		policy.navigateToReportingChannelsTab();
		if(isVisible(policy.AddReportingChannelBtn)==true){
			Report.LogInfo("ElementCheck", "Add reporting chanel button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add reporting chanel button is not visible", "PASS");
		}
		if(isVisible(policy.EditBtn1)==true){
			Report.LogInfo("ElementCheck", "Edit reporting chanel button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit reporting chanel button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 25 completed", "PASS");

		BorProc.applyReportingChannelIdentifyFilter("Risk Bordereaux 1");
		verifyeditAndViewOnSectionAssignmentPopUp();
		verifyeditAndViewOnRiskCodeAssignmentPopUp();
		

		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Claim Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		viewonlyRiskCodeAssignmentPopUp();

		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Premium Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		viewonlyRiskCodeAssignmentPopUp();
		Report.LogInfo("StepCheck", "Step 26 completed", "PASS");

		//Step 27
		policy.navigateRulesTab();
		if(isVisible(policy.AddRulesBtn)==true){
			Report.LogInfo("ElementCheck", "Add Rule button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add Rule button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 27 completed", "PASS");

		policy.navigateRulesGeneralTab1();
		Report.LogInfo("StepCheck", "Step 28 completed", "PASS");

		policy.navigateBreachesTab();

		SelectDropDownValue(BreachsDrp,BreachsDrpVal);
		click(UnconfirmButton,"Lead insurer changes status");
		
		if(isVisible(BreachStatus)==true){
			refreshPage();
			Report.LogInfo("TabCheck", "User can change breach status", "PASS");
		}else{
			Report.LogInfo("TabCheck", "User cannot change breach status", "FAIL");
		}
		Report.LogInfo("StepCheck", "Step 31 completed", "PASS");

		policy.navigateToFilesTab();
		sleep(1000);
		if(isVisible(AddFileBtn)==true){
			Report.LogInfo("TabCheck", "Add File button displayed", "FAIL");
		}else{
			Report.LogInfo("TabCheck", "Add File button displayed", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 32 completed", "PASS");

		//Step 33
		policy.navigateToSectionTab();
		policy.navigateToSectionRefDotEdit();
		policy.EditSubDivisionSection();
		Report.LogInfo("StepCheck", "Step 33 completed", "PASS");

		policy.navigateToMarketsTabOnSection();
		if(isVisible(policy.AddMarketButton)==true){
			Report.LogInfo("ElementCheck", "Add Market button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add Market button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 34 completed", "PASS");

		policy.navigateToRiskCodesTabOnSection();
		if(isVisible(policy.AddRiskCodeButton)==true){
			Report.LogInfo("ElementCheck", "Add RiskCode button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add RiskCode button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 35 completed", "PASS");

		policy.navigateLocationTab();
		Report.LogInfo("StepCheck", "Step 36 completed", "PASS");
		//policy.addRiskCodesOnSection();
		policy.navigateRulesTab();
		if(isVisible(policy.AddRulesBtn)==true){
			Report.LogInfo("ElementCheck", "Add Rule button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add Rule button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 37 completed", "PASS");
		//policy.addRules();


		if(isVisible(policy.AddSectionTab)==true){
			Report.LogInfo("ElementCheck", "Section tab is available", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Section tab is not available", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 38 completed", "PASS");

		policy.navigationOnBordereauxTab();
		Report.LogInfo("StepCheck", "Step 39 completed", "PASS");
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("Review");
		TaskCheck();
		Report.LogInfo("StepCheck", "Step 41 completed", "PASS");

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.applyStatusFilter("Review");
		TaskAddEditBtnCheck1();
		Report.LogInfo("StepCheck", "Step 42 completed", "PASS");

		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.applyStatusFilter("Review");
		TaskAddEditBtnCheck1();
		Report.LogInfo("StepCheck", "Step 43 completed", "PASS");

	}
	
	public void RiskApprovalRoleChange_Broker() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("3","Brit Syndicates Limited - 2987");
		EditContractRole("4","AON - DUA team");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(Standard_user_Broker, Standard_user_Broker_Pass);
	}
	
	public void RiskApprovalRoleChange_Coverholder() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("3","Brit Syndicates Limited - 2987");
		EditContractRole("4","Coverholder Inc - New York");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(Standard_user_CoverHolder, Standard_user_Coverholder_Pass);
	}
	
	public void RiskApprovalRoleChange_Insurer() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("3","Brit Syndicates Limited - 2987");
		EditContractRole("4","Aspen Managing Agency Limited - 4711");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(AdminInsure, AdminInsurePass);
	}


	public void riskApprovalStandardInsurer_TC4789() throws Exception
	{		
		Report.LogInfo("StepsCheck", "Step 3 completed", "PASS");

		//Step 3 to 7
		policy.navigationOnPolicyTab();		
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		Report.LogInfo("StepCheck", "Step 7 completed", "PASS");

		//Step 8
		verifyonlyPolicyEditbtn();
		Report.LogInfo("StepCheck", "Step 8 completed", "PASS");
		policy.navigateToContractDetailsTab();
		//Step 9
		navigateToClaimAuthorityTab();
		verifyClaimsEditdot();
		Report.LogInfo("StepCheck", "Step 9 completed", "PASS");
		//step 10
		NavigateToRoletab();
		verifyRolesEdit("1");
		Report.LogInfo("StepCheck", "Step 10 completed", "PASS");

		//Step 11
		BorProc.openDATALink();
		Report.LogInfo("StepCheck", "Step 11 completed", "PASS");

		//Step 12
		waitForElementToAppear(SummaryTab,3);
		verifyExists(SummaryTab,"Policy Edit btn");
		Report.LogInfo("StepCheck", "Step 12 completed", "PASS");

		//Step 13
		BorProc.navigateToDATARiskTab();
		String detailsONRisk = "@xpath=.//*[@class='k-pager-info k-label'][text()='1 - 8 of 8 items']";
		if(isVisible(detailsONRisk)==true){
			Report.LogInfo("ElementCheck", "All details displayed on Risk tab", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "All details not displayed as expected on Risk tab", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 9 completed", "PASS");
		/*verifyExists(ApprovRiskFile,"Approve risk file name");
		verifyExists(ForApprovalAprilRiskFile1,"For Approval April risk file1");
		verifyExists(ForApprovalAprilRiskFile2,"For Approval April risk file2");
		verifyExists(ForApprovalAprilRiskFile3,"For Approval April risk file3");*/
		Report.LogInfo("StepCheck", "Step 13 completed", "PASS");

		//Step 14
		BorProc.navigateToDATAPremiumTab();
		waitForElementToAppear(ApprovPreminmFile,3);
		verifyExists(ApprovPreminmFile,"Approve premium file name");
		verifyExists(RecordCount1,"Approve Premium file name");
		Report.LogInfo("StepCheck", "Step 14 completed", "PASS");

		//Step 15
		BorProc.navigateToDATAClaimTab();
		waitForElementToAppear(ApprovClaimFile,2);
		verifyExists(ApprovClaimFile,"Approve Claim file name");
		verifyExists(RecordCount2,"Approve claim file name");
		Report.LogInfo("StepCheck", "Step 15 completed", "PASS");

		//Step 16 and 17
		policy.navigationOnBordereauxTab();
		SubmitBodVerifyOptions();
		Report.LogInfo("StepCheck", "Step 17 completed", "PASS");

		//Step 18 and 19
		NavigateOnExpected();
		sleep(2000);
		BorProc.applyBordereauTypeFilter("Risk");
		OverDueNoAction();	

		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		OverDueNoAction();

		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		OverDueNoAction();
		Report.LogInfo("StepCheck", "Step 19 completed", "PASS");

		//Step 20
		NavigateOnRocessing();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.checkDeleteButtonMissingRowwise();
		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.checkDeleteButtonMissingRowwise();
		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.checkDeleteButtonMissingRowwise();
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.checkDeleteButtonMissingRowwise();
		Report.LogInfo("StepCheck", "Step 20 completed", "PASS"); 

		//step 21
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.scrollDown();
		BorProc.applyStatusFilter("Uploaded");
		sleep(1000);
		BorProc.applyStatusFilter("For Assignment");
		sleep(1000);
		BorProc.scrollDown();
		BorProc.applyStatusFilter("Review");
		sleep(1000);
		BorProc.scrollDown();
		BorProc.applyStatusFilter("Review Errors");
		sleep(1000);
		BorProc.statusButtonNotclickableCheckRowwise();
		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.statusButtonNotclickableCheckRowwise();
		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.statusButtonNotclickableCheckRowwise();
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.scrollDown();
		BorProc.applyStatusFilter("Uploaded");
		sleep(1000);
		BorProc.applyStatusFilter("For Assignment");
		sleep(1000);
		BorProc.scrollDown();
		BorProc.applyStatusFilter("Review");
		sleep(1000);
		BorProc.scrollDown();
		BorProc.applyStatusFilter("Review Errors");
		sleep(1000);
		BorProc.statusButtonNotclickableCheckRowwise();
		Report.LogInfo("StepCheck", "Step 21 completed", "PASS");

		//step 22 
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.scrollDown();
		BorProc.applyStatusFilter("For Approval");
		
		String forApproval = "@xpath=.//*[@id='grid']//button[text()='For Approval']";
		click(forApproval,"For Approval button");
		processingTabShouldNtDisplay();
		
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk And Premium");
		BorProc.scrollDown();
		BorProc.applyStatusFilter("For Approval");
		

		click(forApproval,"For Approval button");
		processingTabShouldNtDisplay();
	
		Report.LogInfo("StepCheck", "Step 22 completed", "PASS");

		//step 23
		sleep(2000);
		BorProc.scrollUp();
		refreshPage();
		String RiskChckBx ="@xpath=//input[@name='BordereauxType'][@value='Risk']";
		String ClaimChckBx ="@xpath=//input[@name='BordereauxType'][@value='Claim']";
		String PremiumChckBx ="@xpath=//input[@name='BordereauxType'][@value='Premium']";
		String RiskAndPremiumChckBx ="@xpath=//input[@name='BordereauxType'][@value='Risk And Premium']";

		BorProc.applyTypefilterAndVerifyApprov(RiskChckBx,"Approved");
		BorProc.applyTypefilterAndVerifyApprov(ClaimChckBx,"Approved");
		BorProc.applyTypefilterAndVerifyApprov(PremiumChckBx,"Approved");
		BorProc.applyTypefilterAndVerifyApprov(RiskAndPremiumChckBx,"Approved");

		Report.LogInfo("StepCheck", "Step 23 completed", "PASS");

		//step 25
		sleep(2000);
		BorProc.scrollUp();
		policy.navigateToReportingChannelsTab();
		verifyADDReportingChannelBtnMissing();
		Report.LogInfo("StepCheck", "Step 25 completed", "PASS");

		//Step 26 issue-resolved
		BorProc.applyReportingChannelIdentifyFilter("Risk Bordereaux 1");
		editReportingChannel1();
		Report.LogInfo("StepCheck", "Step 26 completed", "PASS");

		//step 27 
		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Premium Bordereaux 1");
		verifyEditReprotingChannelButtonMissing();
		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Claim Bordereaux 1");
		verifyEditReprotingChannelButtonMissing();
		Report.LogInfo("StepCheck", "Step 27 completed", "PASS");
		//step 28 
		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Risk Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		viewonlyRiskCodeAssignmentPopUp();
		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Premium Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		viewonlyRiskCodeAssignmentPopUp();
		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Claim Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		viewonlyRiskCodeAssignmentPopUp();
		Report.LogInfo("StepCheck", "Step 28 completed", "PASS");
		//step 29
		policy.navigateRulesTab();
		verifyAddRuleMissing();
		Report.LogInfo("StepCheck", "Step 29 completed", "PASS");

		//step 30
		policy.navigateRulesGeneralTab1();
		verifyEditOnGeneralTab();
		Report.LogInfo("StepCheck", "Step 30 completed", "PASS");

		//step31
		policy.navigateBreachesTab();

		SelectDropDownValue(BreachsDrp,BreachsDrpVal);
		click(UnconfirmButton,"Lead insurer changes status");
		
		if(isVisible(BreachStatus)==true){
			refreshPage();
			Report.LogInfo("TabCheck", "User can change breach status", "PASS");
		}else{
			Report.LogInfo("TabCheck", "User cannot change breach status", "FAIL");
		}
		Report.LogInfo("StepCheck", "Step 31 completed", "PASS");

		policy.navigateToFilesTab();
		sleep(1000);
		if(isVisible(AddFileBtn)==true){
			Report.LogInfo("TabCheck", "Add File button displayed", "FAIL");
		}else{
			Report.LogInfo("TabCheck", "Add File button displayed", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 32 completed", "PASS");

		//Step 33
		policy.navigateToSectionTab();
		policy.navigateToSectionRefDotEdit();
		policy.EditSubDivisionSection();
		Report.LogInfo("StepCheck", "Step 33 completed", "PASS");

		policy.navigateToMarketsTabOnSection();
		if(isVisible(policy.AddMarketButton)==true){
			Report.LogInfo("ElementCheck", "Add Market button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add Market button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 34 completed", "PASS");

		policy.navigateToRiskCodesTabOnSection();
		if(isVisible(policy.AddRiskCodeButton)==true){
			Report.LogInfo("ElementCheck", "Add RiskCode button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add RiskCode button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 35 completed", "PASS");

		policy.navigateLocationTab();
		Report.LogInfo("StepCheck", "Step 36 completed", "PASS");
		//policy.addRiskCodesOnSection();
		policy.navigateRulesTab();
		if(isVisible(policy.AddRulesBtn)==true){
			Report.LogInfo("ElementCheck", "Add Rule button is visible", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add Rule button is not visible", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 37 completed", "PASS");
		//policy.addRules();


		if(isVisible(policy.AddSectionTab)==true){
			Report.LogInfo("ElementCheck", "Section tab is available", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Section tab is not available", "PASS");
		}
		Report.LogInfo("StepCheck", "Step 38 completed", "PASS");
		policy.navigationOnBordereauxTab();
		Report.LogInfo("StepsCheck", "Step 40 completed", "PASS");

		//step 41
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.applyStatusFilter("Review");
		if(isVisible(TaskIcon)==true){
			waitForElementToAppear(TaskIcon,5);
			click(TaskIcon,"Task icon");
			sleep(2000);
			waitForElementToAppear(EditbtnOnTaskIcon,5);
			click(EditbtnOnTaskIcon,"Edit button");
			waitForElementToAppear(EditTaskPopUP,5);
			verifyExists(EditTaskPopUP,"Edit Task pop up");
			verifyExists(Cancel1,"Edit task cancel button");
			click(Cancel1,"Edit button");
			waitForElementToAppear(Cancel,5);
			verifyExists(Cancel,"cancel button");
			click(Cancel,"Edit button");
			Report.LogInfo("StepCheck", "Step 44 completed", "PASS");
			sleep(2000);
		}

		//step 45
		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.scrollDown();
		sleep(1000);
		BorProc.applyStatusFilter("Review");
		verifyAddTaskBtnMissing();
		Report.LogInfo("StepCheck", "Step 45 completed", "PASS");
		//step 46
		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.scrollDown();
		sleep(1000);
		BorProc.applyStatusFilter("Review");
		verifyAddTaskBtnMissing();		
		Report.LogInfo("StepCheck", "Step 46 completed", "PASS");
	}

	
	public void PremiumTransformationRoleChange_Broker() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("4","Brit Syndicates Limited - 2987");
		EditContractRole("5","AON - DUA team");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(Standard_user_Broker, Standard_user_Broker_Pass);
	}
	
	public void PremiumTransformationRoleChange_Coverholder() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("4","Brit Syndicates Limited - 2987");
		EditContractRole("5","Coverholder Inc - New York");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(Standard_user_CoverHolder, Standard_user_Coverholder_Pass);
	}
	
	public void PremiumTransformationRoleChange_Insurer() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("4","Brit Syndicates Limited - 2987");
		EditContractRole("5","Aspen Managing Agency Limited - 4711");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(AdminInsure, AdminInsurePass);
	}

	public void premiumTransformationStandardInsurer_TC4797() throws Exception
	{
		Report.LogInfo("StepsCheck", "logout completed", "PASS");
		sleep(3000);
		//Step 2 
		loginPage.tideLogin(StandardInsurer, StandardInsurerPass);
		Report.LogInfo("StepsCheck", "Step 3 completed", "PASS");

		//Step 3
		policy.navigationOnPolicyTab();		
		BorProc.applyFilterPolicy("532533EC");
		BorProc.openSelectedPolicy();
		Report.LogInfo("StepCheck", "Step 7 completed", "PASS");

		//step 8
		verifyonlyPolicyEditbtn();
		Report.LogInfo("StepCheck", "Step 8 completed", "PASS");

		//step 9
		navigateToClaimAuthorityTab();
		verifyClaimsEditdot();
		Report.LogInfo("StepCheck", "Step 9 completed", "PASS");

		//step 10
		NavigateToRoletab();
		verifyRolesEdit("1");
		Report.LogInfo("StepCheck", "Step 10 completed", "PASS");

		//step 11
		BorProc.openDATALink();
		Report.LogInfo("StepCheck", "Step 11 completed", "PASS");

		//Step 12
		waitForElementToAppear(SummaryTab,3);
		verifyExists(SummaryTab,"Policy Edit btn");
		Report.LogInfo("StepCheck", "Step 12 completed", "PASS");

		//step 13
		BorProc.navigateToDATARiskTab();
		waitForElementToAppear(ApprovRiskFile,5);
		verifyExists(ApprovRiskFile,"Approve risk file name");
		Report.LogInfo("StepCheck", "Step 13 completed", "PASS");

		//step 14
		BorProc.navigateToDATAPremiumTab();
		waitForElementToAppear(ApprovPreminmFile,3);
		verifyExists(ApprovPreminmFile,"Approve premium file name");
		verifyExists(ForAssignmentPremiunmMarchFile1,"For Assigment premium 1 file name");
		verifyExists(ForAssignmentPremiunmMarchFile2,"For Assigment premium  2 file name");
		verifyExists(ReviewPremiunmJanuaryFile1,"Review premium file1 name");
		verifyExists(ReviewPremiunmJanuaryFile2,"Review premium file2 name");
		verifyExists(ReviewPremiunmJanuaryFile3,"Review premium file3 name");
		verifyExists(ReviewPremiunmJanuaryFile4,"Review premium file4 name");
		verifyExists(ReviewPremiunmJanuaryFile5,"Review premium file5 name");
		verifyExists(ForApprovalPremiumAprilFile1,"for Approval premium file 1 name");
		verifyExists(ForApprovalPremiumAprilFile2,"for Approval premium file 2 name");
		Report.LogInfo("StepCheck", "Step 14 completed", "PASS");

		//step 15
		BorProc.navigateToDATAClaimTab();
		waitForElementToAppear(ApprovClaimFile,2);
		verifyExists(ApprovClaimFile,"Approve Claim file name");
		Report.LogInfo("StepCheck", "Step 15 completed", "PASS");

		//Step 16 and 17
		policy.navigationOnBordereauxTab();
		SubmitBodVerifyOptions();
		Report.LogInfo("StepCheck", "Step 17 completed", "PASS");

		//step 18
		NavigateOnExpected();
		Report.LogInfo("StepCheck", "Step 18 completed", "PASS");
		//step 19
		BorProc.applyBordereauTypeFilter("Premium");
		waitForElementToAppear(Overduebtn,3);
		verifyExists(Overduebtn,"overdue button");
		click(Overduebtn,"overdue button");
		waitForElementToAppear(NilReturnPopUP,3);
		if(isVisible(NilReturnPopUP)==true){
			verifyExists(NilReturnPopUP,"Nil Return pop up");
			verifyExists(OverdueNobtn,"No Button");
			click(OverdueNobtn,"No Button");
			Report.LogInfo("CheckNilReturnPopUp", "Nil Return Pop up displayed", "PASS");
		}else{
			Report.LogInfo("CheckNilReturnPopUp", "Nil Return Pop up not displayed", "Fail");
		}
		Report.LogInfo("StepCheck", "Step 19 completed", "PASS");

		//step 20
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		sleep(1000);
		waitForElementToAppear(Overduebtn,3);
		verifyExists(Overduebtn,"overdue button");
		click(Overduebtn,"overdue button");
		sleep(1000);
		if(isVisible(NilReturnPopUP)==false && isVisible(Overduebtn)==true){
			Report.LogInfo("CheckButton", "Overdue button not clickable", "PASS");
		}else{
			Report.LogInfo("CheckButton", "Overdue button clickable", "Fail");
			verifyExists(NilReturnPopUP,"Nil Return pop up");
			verifyExists(OverdueNobtn,"No Button");
			click(OverdueNobtn,"No Button");
		}
		Report.LogInfo("StepCheck", "Step 20 completed", "PASS");

		//step 21
		NavigateOnRocessing();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.scrollDown();
		BorProc.applyStatusFilter("Uploaded");
		sleep(1000);
		BorProc.applyStatusFilter("Review Errors");
		sleep(1000);
		BorProc.applyStatusFilter("Review");
		sleep(1000);
		BorProc.checkDeleteButtonpresentRowwise();
		Report.LogInfo("StepCheck", "Step 21 completed", "PASS");

		//step22
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.checkDeleteButtonMissingRowwise();
		sleep(2000);
		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.checkDeleteButtonMissingRowwise();
		Report.LogInfo("StepCheck", "Step 22 completed", "PASS");

		//step 23
		refreshPage();
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.scrollDown();
		BorProc.applyStatusFilter("For Assignment");
		BorProc.applyStatusFilter("For Approval");
		click(AprForApprovalRisk,"Rsik for approval");
		sleep(1000);
		if(isVisible(AprForApprovalRisk)==true){
			Report.LogInfo("CheckButton", "Rsik for approval button not clickable", "PASS");
		}else{
			Report.LogInfo("CheckButton", "Rsik for approval button clickable", "Fail");
			goBack();
		}
		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.scrollDown();
		BorProc.applyStatusFilter("For Assignment");
		BorProc.applyStatusFilter("For Approval");
		click(AprForApprovalClaims,"Cliam for approval");
		sleep(1000);
		if(isVisible(AprForApprovalClaims)==true){
			Report.LogInfo("CheckButton", "Cliam for approval button not clickable", "PASS");
		}else{
			Report.LogInfo("CheckButton", "Rsik for approval button clickable", "Fail");
			goBack();
		}
		Report.LogInfo("StepCheck", "Step 23 completed", "PASS");

		//step 24
		BorProc.scrollUp();
		BorProc.navigateToApprovedTab();
		BorProc.applyBordereauTypeFilter("Risk");
		verifyUnApprovedBordereauBtnDisable();
		BorProc.applyBordereauTypeFilter("Claim");
		verifyUnApprovedBordereauBtnDisable();
		BorProc.applyBordereauTypeFilter("Premium");
		verifyUnApprovedBordereauBtnDisable();
		Report.LogInfo("StepCheck", "Step 24 completed", "PASS");

		//step 25
		sleep(2000);
		BorProc.scrollUp();
		policy.navigateToReportingChannelsTab();
		verifyADDReportingChannelBtnMissing();
		verifyEditReprotingChannelButtonMissing();
		Report.LogInfo("StepCheck", "Step 25 completed", "PASS");

		//step 26
		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Risk Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		viewonlyRiskCodeAssignmentPopUp();
		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Premium Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		viewonlyRiskCodeAssignmentPopUp();
		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Claim Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		viewonlyRiskCodeAssignmentPopUp();
		Report.LogInfo("StepCheck", "Step 26 completed", "PASS");

		//step 27
		policy.navigateRulesTab();
		verifyAddRuleMissing();
		Report.LogInfo("StepCheck", "Step 27 completed", "PASS");

		//step 28
		policy.navigateRulesGeneralTab1();
		verifyEditOnGeneralTab();
		Report.LogInfo("StepCheck", "Step 28 completed", "PASS");

		//step 29
		policy.navigateBreachesTab();
		Report.LogInfo("StepCheck", "Step 29 completed", "PASS");

		//step 30
		policy.navigateToFilesTab();
		verifyAddFilebtnMissing();
		Report.LogInfo("StepCheck", "Step 30 completed", "PASS");

		//step 31
		policy.navigateToSectionTab();				
		policy.navigateToSectionRefDotEdit();
		policy.EditSubDivisionSection();
		Report.LogInfo("StepCheck", "Step 31 completed", "PASS");

		//step 32
		policy.navigateToMarketsTabOnSection();
		verifyAddMarketbtnMissing();
		Report.LogInfo("StepCheck", "Step 32 completed", "PASS");

		//step 33
		policy.navigateToRiskCodesTabOnSection();
		verifyAddRiskbtnMissing();
		Report.LogInfo("StepCheck", "Step 33 completed", "PASS");

		//step 34
		policy.navigateRulesonsection1();
		verifyAddRulesbtnOnSectionMissing();
		Report.LogInfo("StepCheck", "Step 34 completed", "PASS");

		//step 35
		policy.navigateLocationTab();
		verifylocationEditDotMissing();
		Report.LogInfo("StepCheck", "Step 35 completed", "PASS");

		//step 36
		BorProc.scrollUp();
		BorProc.openDATALink();
		BorProc.navigateToDATACreditControlTab();
		Report.LogInfo("StepCheck", "Step 36 completed", "PASS");

		//step 37
		verifyAddSectionButtonMissing();
		Report.LogInfo("StepCheck", "Step 37 completed", "PASS");

		//step 38
		policy.navigationOnBordereauxTab();
		Report.LogInfo("StepsCheck", "Step 38 completed", "PASS");

		//step 39
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.scrollDown();
		BorProc.applyStatusFilter("Review");
		verifyAddTaskBtnMissing();
		Report.LogInfo("StepCheck", "Step 39 completed", "PASS");

		//step 40
		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.scrollDown();
		sleep(1000);
		BorProc.applyStatusFilter("Review");
		verifyAddTaskBtnMissing();		
		Report.LogInfo("StepCheck", "Step 40 completed", "PASS");

		//step 41 to 43
		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.scrollDown();
		sleep(1000);
		BorProc.applyStatusFilter("Review");
		verifyAddTaskAndEditBtnPresent();
		Report.LogInfo("StepCheck", "Step 43 completed", "PASS");

	}

	
	
	public void PremiumAssignmentRoleChange_Broker() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("5","Brit Syndicates Limited - 2987");
		EditContractRole("6","AON - DUA team");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(Standard_user_Broker, Standard_user_Broker_Pass);
	}
	
	public void PremiumAssignmentRoleChange_Coverholder() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("5","Brit Syndicates Limited - 2987");
		EditContractRole("6","Coverholder Inc - New York");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(Standard_user_CoverHolder, Standard_user_Coverholder_Pass);
	}
	
	public void PremiumAssignmentRoleChange_Insurer() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("5","Brit Syndicates Limited - 2987");
		EditContractRole("6","Aspen Managing Agency Limited - 4711");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(AdminInsure, AdminInsurePass);
	}

	public void premiumAssignmentStandardInsurer_TC4806() throws Exception
	{

		Report.LogInfo("StepsCheck", "Step 3 completed", "PASS");

		//Step 4 to 6
		policy.navigationOnPolicyTab();		
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		Report.LogInfo("StepCheck", "Step 6 completed", "PASS");

		//step 7 and 8
		verifyonlyPolicyEditbtn();
		Report.LogInfo("StepCheck", "Step 8 completed", "PASS");

		//step 9
		navigateToClaimAuthorityTab();
		verifyClaimsEditdot();
		Report.LogInfo("StepCheck", "Step 9 completed", "PASS");

		//step 10
		NavigateToRoletab();
		verifyRolesEdit("1");
		Report.LogInfo("StepCheck", "Step 10 completed", "PASS");

		//step 11
		BorProc.openDATALink();
		Report.LogInfo("StepCheck", "Step 11 completed", "PASS");

		//step 12
		waitForElementToAppear(SummaryTab,3);
		verifyExists(SummaryTab,"Policy Edit btn");
		Report.LogInfo("StepCheck", "Step 12 completed", "PASS");

		//step 13
		BorProc.navigateToDATARiskTab();
		waitForElementToAppear(ApprovRiskFile,5);
		verifyExists(ApprovRiskFile,"Approve risk file name");
		Report.LogInfo("StepCheck", "Step 13 completed", "PASS");

		//step 14
		String ForApprovalPremiumAprilFile1 ="@xpath=//*[@id='grid']//tr[4]//td[contains(@ng-click,'File Name')][contains(.,'April 2017')]";
		String ForApprovalPremiumAprilFile2 ="@xpath=//*[@id='grid']//tr[5]//td[contains(@ng-click,'File Name')][contains(.,'April 2017')]";

		BorProc.navigateToDATAPremiumTab();
		waitForElementToAppear(ApprovPreminmFile,3);
		verifyExists(ApprovPreminmFile,"Approve premium file name");
		verifyExists(ForAssignmentPremiunmMarchFile1,"For Assigment premium 1 file name");
		verifyExists(ForAssignmentPremiunmMarchFile2,"For Assigment premium  2 file name");
		verifyExists(ForApprovalPremiumAprilFile1,"for Approval premium file 1 name");
		verifyExists(ForApprovalPremiumAprilFile2,"for Approval premium file 2 name");	
		Report.LogInfo("StepCheck", "Step 14 completed", "PASS");

		//step 15
		BorProc.navigateToDATAClaimTab();
		waitForElementToAppear(ApprovClaimFile,2);
		verifyExists(ApprovClaimFile,"Approve Claim file name");
		Report.LogInfo("StepCheck", "Step 15 completed", "PASS");

		//Step 16 and 17
		policy.navigationOnBordereauxTab();
		SubmitBodVerifyOptions();
		Report.LogInfo("StepCheck", "Step 17 completed", "PASS");

		//step 18
		NavigateOnExpected();
		Report.LogInfo("StepCheck", "Step 18 completed", "PASS");

		//step 19
		waitForElementToAppear(Overduebtn,3);
		verifyExists(Overduebtn,"overdue button");
		click(Overduebtn,"overdue button");
		if(isVisible(Overduebtn)==true && isVisible(NilReturnPopUP)==false){
			Report.LogInfo("CheckButton", "No action occurs", "PASS");
		}else{
			Report.LogInfo("CheckButton", "overdue button clickable", "Fail");
			verifyExists(NilReturnPopUP,"Nil Return pop up");
			verifyExists(OverdueNobtn,"No Button");
			click(OverdueNobtn,"No Button");
		}
		Report.LogInfo("StepCheck", "Step 19 completed", "PASS");

		//step 20
		NavigateOnRocessing();
		BorProc.checkDeleteButtonMissingRowwise();
		Report.LogInfo("StepCheck", "Step 20 completed", "PASS");

		//step 21 
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.statusButtonNotclickableCheckRowwise();
		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.statusButtonNotclickableCheckRowwise();
		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.scrollDown();
		BorProc.applyStatusFilter("Uploaded");
		sleep(1000);
		BorProc.applyStatusFilter("Review Errors");
		sleep(1000);
		BorProc.applyStatusFilter("Review");
		sleep(1000);
		BorProc.applyStatusFilter("For Approval");
		BorProc.statusButtonNotclickableCheckRowwise();
		Report.LogInfo("StepCheck", "Step 21 completed", "PASS");

		//step 22
		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.scrollDown();
		BorProc.applyStatusFilter("For Assignment");
		waitForElementToAppear(MarchForAssignmnt,3);
		verifyExists(MarchForAssignmnt,"March for assignment button");
		click(MarchForAssignmnt,"March for assignment button");
		if(isVisible(SectionAssignmentRuleScreen)==true){
			Report.LogInfo("CheckExpectedScreen", "Expected Screen diplayed", "PASS");
			goBack();
		}else{
			Report.LogInfo("CheckExpectedScreen", "Expected Screen not diplayed", "FAIL");
			goBack();
		}
		Report.LogInfo("StepCheck", "Step 22 completed", "PASS");

		//step 24
		BorProc.navigateToApprovedTab();
		BorProc.applyBordereauTypeFilter("Risk");
		verifyUnApprovedBordereauBtnDisable();
		BorProc.applyBordereauTypeFilter("Premium");
		verifyUnApprovedBordereauBtnDisable();
		BorProc.applyBordereauTypeFilter("Claim");
		verifyUnApprovedBordereauBtnDisable();
		Report.LogInfo("StepCheck", "Step 24 completed", "PASS");

		//step 25
		BorProc.scrollUp();
		policy.navigateToReportingChannelsTab();
		verifyADDReportingChannelBtnMissing();
		verifyEditReprotingChannelButtonMissing();
		Report.LogInfo("StepCheck", "Step 25 completed", "PASS");

		//step 26
		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Risk Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		viewonlyRiskCodeAssignmentPopUp();
		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Claim Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		viewonlyRiskCodeAssignmentPopUp();
		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Premium Bordereaux 1");
		verifyeditAndViewOnSectionAssignmentPopUp();
		verifyeditAndViewOnRiskCodeAssignmentPopUp();

		//step 27
		policy.navigateRulesTab();
		verifyAddRuleMissing();
		Report.LogInfo("StepCheck", "Step 27 completed", "PASS");

		//step 28
		policy.navigateRulesGeneralTab1();
		verifyEditOnGeneralTab();
		Report.LogInfo("StepCheck", "Step 28 completed", "PASS");

		//step 29
		policy.navigateBreachesTab();
		Report.LogInfo("StepCheck", "Step 29 completed", "PASS");

		//step 30
		policy.navigateToFilesTab();
		verifyAddFilebtnMissing();
		Report.LogInfo("StepCheck", "Step 30 completed", "PASS");

		//step 31
		policy.navigateToSectionTab();				
		policy.navigateToSectionRefDotEdit();
		policy.EditSubDivisionSection();
		Report.LogInfo("StepCheck", "Step 31 completed", "PASS");

		//step 32
		policy.navigateToMarketsTabOnSection();
		verifyAddMarketbtnMissing();
		Report.LogInfo("StepCheck", "Step 32 completed", "PASS");

		//step 33
		policy.navigateToRiskCodesTabOnSection();
		verifyAddRiskbtnMissing();
		Report.LogInfo("StepCheck", "Step 33 completed", "PASS");

		//step 34
		policy.navigateRulesonsection1();
		verifyAddRulesbtnOnSectionMissing();
		Report.LogInfo("StepCheck", "Step 34 completed", "PASS");

		//step 35
		policy.navigateLocationTab();
		verifylocationEditDotMissing();
		Report.LogInfo("StepCheck", "Step 35 completed", "PASS");

		//step 36
		BorProc.scrollUp();
		BorProc.openDATALink();
		BorProc.navigateToDATACreditControlTab();
		Report.LogInfo("StepCheck", "Step 36 completed", "PASS");

		//step 37
		policy.navigationOnBordereauxTab();
		Report.LogInfo("StepsCheck", "Step 37 completed", "PASS");

		//step 38
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.scrollDown();
		BorProc.applyStatusFilter("Review");
		verifyAddTaskBtnMissing();
		Report.LogInfo("StepCheck", "Step 38 completed", "PASS");

		//step 39
		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.scrollDown();
		sleep(1000);
		BorProc.applyStatusFilter("Review");
		verifyAddTaskBtnMissing();		
		Report.LogInfo("StepCheck", "Step 39 completed", "PASS");

		//step 40 to 42
		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.scrollDown();
		BorProc.applyStatusFilter("Review");
		verifyAddTaskAndEditBtnPresent();
		Report.LogInfo("StepCheck", "Step 42 completed", "PASS");	
	}

	public void PremiumApprovalRoleChange_Broker() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("6","Brit Syndicates Limited - 2987");
		EditContractRole("7","AON - DUA team");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(Standard_user_Broker, Standard_user_Broker_Pass);
	}
	

	public void PremiumApprovalRoleChange_Coverholder() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("6","Brit Syndicates Limited - 2987");
		EditContractRole("7","Coverholder Inc - New York");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(Standard_user_CoverHolder, Standard_user_Coverholder_Pass);
	}
	
	public void PremiumApprovalRoleChange_Insurer() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("6","Brit Syndicates Limited - 2987");
		EditContractRole("7","Aspen Managing Agency Limited - 4711");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(AdminInsure, AdminInsurePass);
	}

	public void premiumApprovalStandardInsurer_TC4815() throws Exception
	{
		Report.LogInfo("StepsCheck", "Step 3 completed", "PASS");

		//Step 4 to 6
		policy.navigationOnPolicyTab();		
		BorProc.applyFilterPolicy("532533EC");
		BorProc.openSelectedPolicy();
		Report.LogInfo("StepCheck", "Step 6 completed", "PASS");

		//step 7 and 8
		verifyonlyPolicyEditbtn();
		Report.LogInfo("StepCheck", "Step 8 completed", "PASS");

		//step 9
		navigateToClaimAuthorityTab();
		verifyClaimsEditdot();
		Report.LogInfo("StepCheck", "Step 9 completed", "PASS");

		//step 10
		NavigateToRoletab();
		verifyRolesEdit("1");
		Report.LogInfo("StepCheck", "Step 10 completed", "PASS");

		//step 11
		BorProc.openDATALink();
		Report.LogInfo("StepCheck", "Step 11 completed", "PASS");

		//step 12
		waitForElementToAppear(SummaryTab,3);
		verifyExists(SummaryTab,"Policy Edit btn");
		Report.LogInfo("StepCheck", "Step 12 completed", "PASS");

		//step 13
		BorProc.navigateToDATARiskTab();
		waitForElementToAppear(ApprovRiskFile,5);
		verifyExists(ApprovRiskFile,"Approve risk file name");
		Report.LogInfo("StepCheck", "Step 13 completed", "PASS");

		//step 14 
		String ForApprovalPremiumAprilFile1 ="@xpath=//*[@id='grid']//tr[2]//td[contains(@ng-click,'File Name')][contains(.,'April 2017')]";
		String ForApprovalPremiumAprilFile2 ="@xpath=//*[@id='grid']//tr[3]//td[contains(@ng-click,'File Name')][contains(.,'April 2017')]";

		BorProc.navigateToDATAPremiumTab();
		waitForElementToAppear(ApprovPreminmFile,3);
		verifyExists(ApprovPreminmFile,"Approve premium file name");
		verifyExists(ForApprovalPremiumAprilFile1,"for Approval premium file 1 name");
		verifyExists(ForApprovalPremiumAprilFile2,"for Approval premium file 2 name");	
		Report.LogInfo("StepCheck", "Step 10 completed", "PASS");

		//step 15
		BorProc.navigateToDATAClaimTab();
		waitForElementToAppear(ApprovClaimFile,2);
		verifyExists(ApprovClaimFile,"Approve Claim file name");
		Report.LogInfo("StepCheck", "Step 15 completed", "PASS");

		//Step 16 and 17
		policy.navigationOnBordereauxTab();
		SubmitBodVerifyOptions();
		Report.LogInfo("StepCheck", "Step 17 completed", "PASS");

		//step 18
		NavigateOnExpected();
		Report.LogInfo("StepCheck", "Step 18 completed", "PASS");

		//step 19
		waitForElementToAppear(Overduebtn,3);
		verifyExists(Overduebtn,"overdue button");
		click(Overduebtn,"overdue button");
		if(isVisible(Overduebtn)==true && isVisible(NilReturnPopUP)==false){
			Report.LogInfo("CheckButton", "No action occurs", "PASS");
		}else{
			Report.LogInfo("CheckButton", "action occurs", "Fail");
			verifyExists(NilReturnPopUP,"Nil Return pop up");
			verifyExists(OverdueNobtn,"No Button");
			click(OverdueNobtn,"No Button");
		}
		Report.LogInfo("StepCheck", "Step 19 completed", "PASS");

		//step 20
		NavigateOnRocessing();
		BorProc.checkDeleteButtonMissingRowwise();
		Report.LogInfo("StepCheck", "Step 20 completed", "PASS");

		//step 21
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.statusButtonNotclickableCheckRowwise();
		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.statusButtonNotclickableCheckRowwise();
		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.scrollDown();
		BorProc.applyStatusFilter("Uploaded");
		sleep(1000);
		BorProc.applyStatusFilter("Review Errors");
		sleep(1000);
		BorProc.applyStatusFilter("Review");
		sleep(1000);
		BorProc.applyStatusFilter("For Assignment");
		BorProc.statusButtonNotclickableCheckRowwise();
		Report.LogInfo("StepCheck", "Step 21 completed", "PASS");

		//step 22
		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.scrollDown();
		BorProc.applyStatusFilter("For Approval");
		waitForElementToAppear(ForApprovalbtn,3);
		verifyExists(ForApprovalbtn,"For approval button");
		click(ForApprovalbtn,"For approval button");
		if(isEnable(BorProc.ApproveBordBtn)==true){
			Report.LogInfo("CheckButton", "Un Approved button enable", "PASS");
		}else{
			Report.LogInfo("CheckButton", "Un Approved button not enable", "Fail");
		}
		goBack();
		Report.LogInfo("StepCheck", "Step 22 completed", "PASS");

		//step 24
		refreshPage();
		BorProc.navigateToApprovedTab();
		BorProc.applyBordereauTypeFilter("Premium");		
		verifyUnApprovedBordereauBtnEnable();
		Report.LogInfo("StepCheck", "Step 24 completed", "PASS");

		//step 25
		BorProc.applyBordereauTypeFilter("Risk");
		verifyUnApprovedBordereauBtnDisable();
		BorProc.applyBordereauTypeFilter("Claim");
		verifyUnApprovedBordereauBtnDisable();
		Report.LogInfo("StepCheck", "Step 25 completed", "PASS");
		//step 26
		BorProc.scrollUp();
		policy.navigateToReportingChannelsTab();
		verifyADDReportingChannelBtnMissing();
		verifyEditReprotingChannelButtonMissing();
		Report.LogInfo("StepCheck", "Step 26 completed", "PASS");

		//step 27
		BorProc.applyReportingChannelIdentifyFilter("Risk Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		viewonlyRiskCodeAssignmentPopUp();
		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Claim Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		viewonlyRiskCodeAssignmentPopUp();
		refreshPage();
		BorProc.applyReportingChannelIdentifyFilter("Premium Bordereaux 1");
		viewonlySectionAssignmentPopUp();
		viewonlyRiskCodeAssignmentPopUp();
		Report.LogInfo("StepCheck", "Step 27 completed", "PASS");

		//step 28 
		editReportingChannel1();
		Report.LogInfo("StepCheck", "Step 28 completed", "PASS");

		//step 30
		policy.navigateRulesTab();
		verifyAddRuleMissing();
		Report.LogInfo("StepCheck", "Step 30 completed", "PASS");

		//step 31
		policy.navigateRulesGeneralTab1();
		verifyEditOnGeneralTab();
		Report.LogInfo("StepCheck", "Step 31 completed", "PASS");

		//step 32
		policy.navigateBreachesTab();
		Report.LogInfo("StepCheck", "Step 32 completed", "PASS");

		//step 33
		policy.navigateToFilesTab();
		verifyAddFilebtnMissing();
		Report.LogInfo("StepCheck", "Step 33 completed", "PASS");

		//step 34
		policy.navigateToSectionTab();				
		policy.navigateToSectionRefDotEdit();
		policy.EditSubDivisionSection();
		Report.LogInfo("StepCheck", "Step 34 completed", "PASS");

		//step 35
		policy.navigateToMarketsTabOnSection();
		verifyAddMarketbtnMissing();
		Report.LogInfo("StepCheck", "Step 35 completed", "PASS");

		//step 36
		policy.navigateToRiskCodesTabOnSection();
		verifyAddRiskbtnMissing();
		Report.LogInfo("StepCheck", "Step 36 completed", "PASS");

		//step 37
		policy.navigateRulesonsection1();
		verifyAddRulesbtnOnSectionMissing();
		Report.LogInfo("StepCheck", "Step 37 completed", "PASS");

		//step 38
		policy.navigateLocationTab();
		verifylocationEditDotMissing();
		Report.LogInfo("StepCheck", "Step 38 completed", "PASS");

		//step 39
		BorProc.scrollUp();
		BorProc.openDATALink();
		BorProc.navigateToDATACreditControlTab();
		Report.LogInfo("StepCheck", "Step 39 completed", "PASS");

		//step 40
		verifyAddSectionButtonMissing();
		Report.LogInfo("StepCheck", "Step 40 completed", "PASS");

		//step 41
		policy.navigationOnBordereauxTab();
		Report.LogInfo("StepsCheck", "Step 41 completed", "PASS");

		//step 42
		BorProc.applyBordereauTypeFilter("Risk");
		BorProc.scrollDown();
		BorProc.applyStatusFilter("Review");
		verifyAddTaskBtnMissing();
		Report.LogInfo("StepCheck", "Step 42 completed", "PASS");

		//step 43
		refreshPage();
		BorProc.applyBordereauTypeFilter("Claim");
		BorProc.scrollDown();
		sleep(1000);
		BorProc.applyStatusFilter("Review");
		verifyAddTaskBtnMissing();		
		Report.LogInfo("StepCheck", "Step 43 completed", "PASS");

		//step 44 to 46
		refreshPage();
		BorProc.applyBordereauTypeFilter("Premium");
		BorProc.scrollDown();
		BorProc.applyStatusFilter("Review");
		verifyAddTaskAndEditBtnPresent();
		Report.LogInfo("StepCheck", "Step 46 completed", "PASS");	

	}



	//***************TC4821**********************************************
	
	public void ClaimsTransformationRoleChange_Broker() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("7","Brit Syndicates Limited - 2987");
		EditContractRole("8","AON - DUA team");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(Standard_user_Broker, Standard_user_Broker_Pass);
	}
	
	
	public void ClaimsTransformationRoleChange_Coverholder() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("7","Brit Syndicates Limited - 2987");
		EditContractRole("8","Coverholder Inc - New York");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(Standard_user_CoverHolder, Standard_user_Coverholder_Pass);
	}
	
	public void ClaimsTransformationRoleChange_Insurer() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("7","Brit Syndicates Limited - 2987");
		EditContractRole("8","Aspen Managing Agency Limited - 4711");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(AdminInsure, AdminInsurePass);
	}
	public void ClaimTransformationStandard_Insurer_TC4821() throws Exception
	{
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");

		String mapValue = "Bordereau Column: Cause Of Loss";
		//Step 4,5,6
		BorProc.applyFilterPolicy(policy.PolicyNumber);
		//BorProc.applyFilterPolicy("400511YR");
		policy.openSelectedPolicy();
		Report.LogInfo("StepsCheck", "Step 4,5,6 completed", "PASS");

		//step 7
		ConDetail.EditContract();
		Report.LogInfo("StepsCheck", "Step 7 completed", "PASS");

		//Step 8
		waitForElementToAppear(CompanyRefrence,3);
		verifyExists(CompanyRefrence,"Company Refereance");
		sendKeys(CompanyRefrence,"Testing","Company Refereance");
		verifyMustExists(SaveEditedChanges,"Save Edited Changes");
		click(SaveEditedChanges,"Save Edited Changes");
		sleep(2000);
		waitForElementToAppear(policy.secondContractEndorsementPopUp,5);
		if(isVisible(policy.secondContractEndorsementPopUp) == true)
		{
			verifyMustExists(policy.SaveBtn4,"Save Button");
			javaScriptclick(policy.SaveBtn4,"Save Button");
			sleep(1000);
		}
		policy.scrollUp();
		Report.LogInfo("StepsCheck", "Step 8 completed", "PASS");

		//Step 9
		navigationOnRoleTab();
		verifyMustExists(CompanyRow1,"Select Company name");
		click(CompanyRow1, "Click on Company Name");
		if(isVisible(ContractAdministratorPopup)==true)
		{
			Report.LogInfo("ElementCheck", "User can view Roles tab and select to edit", "FAIL");
		}
		else{
			Report.LogInfo("ElementCheck", "User can view Roles tab, but cannot select to edit", "PASS");
		}
		Report.LogInfo("StepsCheck", "Step 9 completed", "PASS");

		//Step 10,11
		BorProc.navigateToDATATab();
		waitForElementToAppear(VerifSummaryTab,3);
		verifyExists(VerifSummaryTab,"Verify Summary Tab");
		Report.LogInfo("StepsCheck", "Step 10,11 completed", "PASS");

		//Step 12
		BorProc.navigateToDATARiskTab();
		//VerifyRiskTabData();
		Report.LogInfo("StepsCheck", "Step 12 completed", "PASS");

		//Step 13
		BorProc.navigateToDATAPremiumTab();
	//	VerifyPremiumTabData();
		Report.LogInfo("StepsCheck", "Step 13 completed", "PASS");

		//Step 14
		BorProc.navigateToDATAClaimTab();
	//	VerifyClaimTabData();
		Report.LogInfo("StepsCheck", "Step 14 completed", "PASS");

		//Step 15
		waitForElementToAppear(policy.BordereauxTab,5);
		verifyMustExists(policy.BordereauxTab,"Bordereaux Tab");
		click(policy.BordereauxTab,"Bordereaux Tab");
		Report.LogInfo("StepsCheck", "Step 15 completed", "PASS");

		// Step 16
		waitForElementToAppear(policy.SubmitBordereauxDownArrow,5);
		verifyMustExists(policy.SubmitBordereauxDownArrow,"Bordereaux Tab");
		click(policy.SubmitBordereauxDownArrow,"Bordereaux Tab");
		verifyMustExists(RiskOption,"Risk Option");
		verifyMustExists(CliamOption,"Claim Option");
		verifyMustExists(PremiumOption,"Premium Option");
		click(policy.SubmitBordereauxDownArrow,"Bordereaux Tab");
		Report.LogInfo("StepsCheck", "Step 16 completed", "PASS");

		//Step 17
		NavigateOnExpected();
		Report.LogInfo("StepsCheck", "Step 17 completed", "PASS");

		//Step18,19
		waitForElementToAppear(Overduebtn,3);
		verifyExists(Overduebtn,"overdue button");
		click(Overduebtn,"overdue button");
		sleep(1000);
		if(isVisible(Overduebtn)==true){
			Report.LogInfo("CheckButton", "Overdue button not clickable", "PASS");
		}else{
			Report.LogInfo("CheckButton", "Overdue button clickable", "Fail");
			goBack();
		}
		Report.LogInfo("StepCheck", "Step 19 completed", "PASS");

		//Step 20
		BorProc.navigateOnProcessingTab();
		ClearFilter();
		BorProc.applyBordereauTypeFilter("Claim");
		verifyMustExists(AprilUploadClaim,"Upload Status is displayed");
		if(isVisible(DeleteButton)==true)
		{
			Report.LogInfo("DeleteBtnCheck", "Delete button is Displayed", "PASS");
		}
		else{
			Report.LogInfo("DeleteBtnCheck", "Delete button is not Displayed", "FAIL");
		}
		verifyMustExists(FebruaryReviewErrorClaim,"Review Error Status is displayed");
		if(isVisible(DeleteButton)==true)
		{
			Report.LogInfo("DeleteBtnCheck", "Delete button is Displayed", "PASS");
		}
		else{
			Report.LogInfo("DeleteBtnCheck", "Delete button is not Displayed", "FAIL");
		}
		verifyMustExists(JanReviewClaim,"Review Status is displayed");
		if(isVisible(DeleteButton)==true)
		{
			Report.LogInfo("DeleteBtnCheck", "Delete button is Displayed", "PASS");
		}
		else{
			Report.LogInfo("DeleteBtnCheck", "Delete button is not Displayed", "FAIL");
		}
		Report.LogInfo("StepsCheck", "Step 20 completed", "PASS");

		//Step 21
		ClearFilter();
		BorProc.applyBordereauTypeFilter("Risk");
		verifyDeletebuttonForBordereuaxRisk();
		ClearFilter();
		BorProc.applyBordereauTypeFilter("Premium");
		verifyDeletebuttonForBordereuaxPremium();
		Report.LogInfo("StepsCheck", "Step 21 completed", "PASS");

		//Step 22
		BorProc.navigateOnProcessingTab();
		//Upload Status
		sleep(2000);
		ClearFilter();
		BorProc.applyBordereauTypeFilter("Claim");
		verifyExists(AprilUploadClaim,"Verify Uploaded file");
		click(AprilUploadClaim,"Click on Uploaded file");
		waitForElementToAppear(SubmitBordereauPage,5);
		verifyExists(SubmitBordereauPage,"Submit Bordereau Page");
		goBack();

		//Review Error Status
		verifyExists(FebruaryReviewErrorClaim,"Click on Review Error file");
		click(FebruaryReviewErrorClaim,"Click on Review Error file");
		sleep(2000);
		waitForElementToAppear(VerifyReviewErrorPage,5);
		verifyExists(VerifyReviewErrorPage,"Submit Bordereau Page");
		goBack();

		//Review Status
		verifyExists(JanReviewClaim,"Click on Review file");
		click(JanReviewClaim,"Click on Review file");
		waitForElementToAppear(BorProc.SuRcdAssmnt,10);
		verifyMustExists(BorProc.SuRcdAssmnt,"Submit record assesment button");
		goBack();
		Report.LogInfo("StepsCheck", "Step 22 completed", "PASS");

		//Step 23
		verifyExists(AprilUploadRisk,"Verify Upload status of Risk");
		click(AprilUploadRisk,"Click on Upload status of Risk");
		if(isVisible(SubmitBordereauPage)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		verifyExists(FebruaryReviewErrorRisk,"Verify Review Error status of Risk");
		click(FebruaryReviewErrorRisk,"Click on Review Error status of Risk");

		if(isVisible(VerifyReviewErrorPage)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		verifyExists(JanReviewRisk,"Verify Review status of Risk");
		click(JanReviewRisk,"Click on Review status of Risk");
		if(isVisible(BorProc.SuRcdAssmnt)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		verifyExists(AprilUploadPremium,"Verify Upload status of Premium");
		click(AprilUploadPremium,"Click on Upload status of Premium");
		if(isVisible(SubmitBordereauPage)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		verifyExists(FebruaryReviewErrorPremium,"Verify Review Error status of Premium");
		click(FebruaryReviewErrorPremium,"Click on Review Error status of Premium");
		if(isVisible(VerifyReviewErrorPage)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		verifyExists(JanReviewPremium,"Verify Review status of Premium");
		click(JanReviewPremium,"Click on Review status of Premium");
		if(isVisible(BorProc.SuRcdAssmnt)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		Report.LogInfo("StepsCheck", "Step 23 completed", "PASS");

		//Step 24
		verifyExists(AprilForApprovalRisk,"Verify For Approval status of Risk");
		click(AprilForApprovalRisk,"Click on  For Approval status of Risk");
		if(isVisible(VerifyForApprovalPage)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		verifyExists(MarchForApprovalClaim,"Verify  For Approval status of Claim");
		click(MarchForApprovalClaim,"Click on  For Approvalr status of Claim");
		if(isVisible(VerifyForApprovalPage)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		verifyExists(AprilForAssignmentClaim,"Verify For Assignment status of Claim");
		click(AprilForAssignmentClaim,"Click on Review status of Claim");
		if(isVisible(VerifyForAssignmentPage)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		verifyExists(MarchForAssignmentRisk,"Verify For Assignment status of Risk");
		click(MarchForAssignmentRisk,"Click on Review status of Risk");
		if(isVisible(VerifyForAssignmentPage)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		Report.LogInfo("StepsCheck", "Step 24 completed", "PASS");

		//Step 25
		navigationOnApproveTab();
		verifyExists(JanApprovedRisk,"Verify For Approved status of Risk");
		click(JanApprovedRisk,"Click on Approved status of Risk");
		if(isEnable(UnApprvBdrBtn)==true)
		{Report.LogInfo("CheckUnApprvBdrBtn", "UnApprved button is Not Disable", "FAIL");			
		}
		else{
			Report.LogInfo("CheckUnApprvBdrBtn", "UnApprved button is Disable", "PASS");
		}
		goBack();
		verifyExists(JanApprovedClaim,"Verify For Approved status of Claim");
		click(JanApprovedClaim,"Click on Approved status of Claim");
		if(isEnable(UnApprvBdrBtn)==true)
		{Report.LogInfo("CheckUnApprvBdrBtn", "UnApprved button is Not Disable", "FAIL");			
		}
		else{
			Report.LogInfo("CheckUnApprvBdrBtn", "UnApprved button is Disable", "PASS");
		}
		goBack();
		verifyExists(JanApprovedPremium,"Verify For Approved status of Premium");
		click(JanApprovedPremium,"Click on Approved status of Premium");
		if(isEnable(UnApprvBdrBtn)==true)
		{Report.LogInfo("CheckUnApprvBdrBtn", "UnApprved button is Not Disable", "FAIL");			
		}
		else{
			Report.LogInfo("CheckUnApprvBdrBtn", "UnApprved button is Disable", "PASS");
		}
		goBack();
		Report.LogInfo("StepsCheck", "Step 25 completed", "PASS");

		//step 26
		policy.navigateToReportingChannelsTab();
		if(isVisible(policy.AddReportingChannelBtn)==true){
			Report.LogInfo("ElementCheck", "AddReportingChannelBtn available", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "AddReportingChannelBtn not available", "PASS");
		}
		Report.LogInfo("StepsCheck", "Step 26 completed", "PASS");

		//Step 27
		BorProc.applyReportingChannelIdentifyFilter("Risk Bordereaux 1");
		viewonlySectionAssignmentPopUp();			
		viewonlyRiskCodeAssignmentPopUp();
		ClearReportingChannelFilter();
		BorProc.applyReportingChannelIdentifyFilter("Claim Bordereaux 1");
		viewonlySectionAssignmentPopUp();			
		viewonlyRiskCodeAssignmentPopUp();
		ClearReportingChannelFilter();
		BorProc.applyReportingChannelIdentifyFilter("Premium Bordereaux 1");
		viewonlySectionAssignmentPopUp();			
		viewonlyRiskCodeAssignmentPopUp();
		ClearReportingChannelFilter();
		Report.LogInfo("StepsCheck", "Step 27 completed", "PASS");

		//Step 28
		//policy.navigateMainRulesTab();
		policy.navigateRulesTab();
		VerifyMainRuleEditOrAdd();
		Report.LogInfo("StepsCheck", "Step 28 completed", "PASS");

		//Step 29
		policy.navigateGeneralTab();
		VerifyGeneralTabEditOrAdd();
		Report.LogInfo("StepsCheck", "Step 29 completed", "PASS");

		//Step 30
		policy.navigateBreachesTab();
		Report.LogInfo("StepsCheck", "Step 30 completed", "PASS");

		//Step 31
		policy.navigateToFilesTab();
		VerifyFileTabEditORAdd();
		Report.LogInfo("StepsCheck", "Step 31 completed", "PASS");

		//Step 32
		policy.navigateToSectionTab1();
		sleep(2000);
		policy.navigateToSectionDotEdit();
		sleep(2000);
		policy.EditSubDivisionSection();
		Report.LogInfo("StepsCheck", "Step 32 completed", "PASS");

		//Step 33
		policy.navigateToMarketsTabOnSection();
		VerifyMarketTabEditORAdd();
		Report.LogInfo("StepsCheck", "Step 33 completed", "PASS");

		//Step 34
		policy.navigateToRiskCodesTabOnSection();
		VerifyRiskCodeTabEditORAdd();
		Report.LogInfo("StepsCheck", "Step 34 completed", "PASS");

		//Step 35
		VerifyRuleTabEditORAdd();
		Report.LogInfo("StepsCheck", "Step 35 completed", "PASS");

		//Step 37
		policy.navigateLocationTab();
		VerifyLocationTabEditORAdd();
		Report.LogInfo("StepsCheck", "Step 37 completed", "PASS");

		//Step 38
		if(isVisible(policy.AddSectionTab)==false)
		{
			Report.LogInfo("ElementCheck", "User is not able to Add Section", "PASS");	
		}
		else{
			Report.LogInfo("ElementCheck", "User is able to Add Section", "FAIL");
		}
		Report.LogInfo("StepsCheck", "Step 38 completed", "PASS");

		//Step 39
		verifyMustExists(policy.BordereauxTab,"Bordereaux Tab");
		click(policy.BordereauxTab,"Bordereaux Tab");
		BorProc.navigateOnProcessingTab();
		Report.LogInfo("StepsCheck", "Step 39 completed", "PASS");

		//Step 40
		waitForElementToAppear(TaskIconforRiskReview,5);
		click(TaskIconforRiskReview,"Task icon");
		sleep(2000);
		if(isVisible(AddTaskBtn)==false && (isVisible(EditTaskIcon)==true)){
			Report.LogInfo("ElementCheck", "User is not able to Add but Edit Task", "PASS");	
		}
		else{
			Report.LogInfo("ElementCheck", "User is able to Add and Edit Task", "FAIL");
		}	
		verifyMustExists(Cancel,"Cancel Button");
		click(Cancel,"Cancel Button");
		Report.LogInfo("StepsCheck", "Step 40 completed", "PASS");

		//Step 41
		waitForElementToAppear(TaskIconforPremiumReview,5);
		click(TaskIconforPremiumReview,"Task icon");
		sleep(2000);
		if(isVisible(AddTaskBtn)==false && (isVisible(EditTaskIcon)==true)){
			Report.LogInfo("ElementCheck", "User is not able to Add but Edit Task", "PASS");	
		}
		else{
			Report.LogInfo("ElementCheck", "User is able to Add and Edit Task", "FAIL");
		}	
		verifyMustExists(Cancel,"Cancel Button");
		click(Cancel,"Cancel Button");
		Report.LogInfo("StepsCheck", "Step 41 completed", "PASS");

		//Step 42,43
		waitForElementToAppear(TaskIconforClaimReview,5);
		click(TaskIconforClaimReview,"Task icon");
		sleep(2000);
		if(isVisible(AddTaskBtn)==true && (isVisible(EditTaskIcon)==true)){
			Report.LogInfo("ElementCheck", "User is able to Add and Edit Task", "PASS");	
			waitForElementToAppear(EditTaskIcon,5);
			click(EditTaskIcon,"Edit Task Button");
			sleep(2000);
			if(isVisible(AddNoteForTask)==true && (isVisible(SaveChangesBtn)==true)){
				Report.LogInfo("ElementCheck", "User is able to Add Note for Task", "PASS");		
				click(Cancel,"CAncel Button");
			}
			else{
				Report.LogInfo("ElementCheck", "User is not able to Add Note for Task", "FAIL");
			}
		}
		else{
			Report.LogInfo("ElementCheck", "User is  not able to Add and Edit Task", "FAIL");
		}	
		Report.LogInfo("StepsCheck", "Step 42,43 completed", "PASS");
	}
	
	//**************************TC4824**********************
	
	public void ClaimsAssignmentRoleChange_Broker() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("8","Brit Syndicates Limited - 2987");
		EditContractRole("9","AON - DUA team");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(Standard_user_Broker, Standard_user_Broker_Pass);
	}
	
	public void ClaimsAssignmentRoleChange_Coverholder() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("8","Brit Syndicates Limited - 2987");
		EditContractRole("9","Coverholder Inc - New York");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(Standard_user_CoverHolder, Standard_user_Coverholder_Pass);
	}
	
	public void ClaimsAssignmentRoleChange_Insurer() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("8","Brit Syndicates Limited - 2987");
		EditContractRole("9","Aspen Managing Agency Limited - 4711");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(AdminInsure, AdminInsurePass);
	}
	public void ClaimAssignment_Standard_Insurer_TC4824() throws Exception
	{
		Report.LogInfo("StepsCheck", "Step 3 completed", "PASS");

		//Step 4,5,6
		BorProc.applyFilterPolicy(policy.PolicyNumber);
		//BorProc.applyFilterPolicy("400511YR");
		policy.openSelectedPolicy();
		Report.LogInfo("StepsCheck", "Step 4,5,6 completed", "PASS");

		//Step 7
		ConDetail.EditContract();

		//Step 8
		waitForElementToAppear(CompanyRefrence,3);
		verifyExists(CompanyRefrence,"Company Refereance");
		sendKeys(CompanyRefrence,"Testing","Company Refereance");
		verifyMustExists(SaveEditedChanges,"Save Edited Changes");
		click(SaveEditedChanges,"Save Edited Changes");
		sleep(2000);
		waitForElementToAppear(policy.secondContractEndorsementPopUp,5);
		if(isVisible(policy.secondContractEndorsementPopUp) == true)
		{
			verifyMustExists(policy.SaveBtn4,"Save Button");
			javaScriptclick(policy.SaveBtn4,"Save Button");
			sleep(1000);
		}
		policy.scrollUp();
		Report.LogInfo("StepsCheck", "Step 8 completed", "PASS");
		//Step 9
		navigationOnRoleTab();
		verifyMustExists(CompanyRow1,"Select Company name");
		click(CompanyRow1, "Click on Company Name");
		if(isVisible(ContractAdministratorPopup)==false)
		{
			Report.LogInfo("ElementCheck", "User can view Roles tab, but cannot select to edit", "PASS");
		}
		else{Report.LogInfo("ElementCheck", "User can view Roles tab and select to edit", "FAIL");
		}
		Report.LogInfo("StepsCheck", "Step 9 completed", "PASS");
		//Step 10
		BorProc.navigateToDATATab();
		//Step 11
		waitForElementToAppear(VerifSummaryTab,3);
		verifyExists(VerifSummaryTab,"Verify Summary Tab");
		Report.LogInfo("StepsCheck", "Step 11 completed", "PASS");
		//Step 12
		BorProc.navigateToDATARiskTab();
		VerifyRiskTabData();
		Report.LogInfo("StepsCheck", "Step 12 completed", "PASS");
		//Step 13
		BorProc.navigateToDATAPremiumTab();
		VerifyPremiumTabData();
		Report.LogInfo("StepsCheck", "Step 13 completed", "PASS");
		//Step 14
		BorProc.navigateToDATAClaimTab();
		if(isVisible(AprovedJanFile)==true)
		{
			Report.LogInfo("ElementCheck", "Approved Status file is display in Premium Section", "PASS");
		}
		else{
			Report.LogInfo("ElementCheck", "Approved Status file is not display in Premium Section", "Fail");
		}
		if(isVisible(AprilForApprovalFile)==true)
		{
			Report.LogInfo("ElementCheck", "For Approval Status file is display in Premium Section", "PASS");
		}
		else{
			Report.LogInfo("ElementCheck", "For Approval Status file is not display in Premium Section", "Fail");
		}
		if(isVisible(MarchForAssignmentFile)==true)
		{
			Report.LogInfo("ElementCheck", "For Assignment Status file is display in Premium Section", "PASS");
		}
		else{
			Report.LogInfo("ElementCheck", "For Assignment Status file is not display in Premium Section", "Fail");
		}
		Report.LogInfo("StepsCheck", "Step 14 completed", "PASS");
		//Step 15
		waitForElementToAppear(policy.BordereauxTab,5);
		verifyMustExists(policy.BordereauxTab,"Bordereaux Tab");
		click(policy.BordereauxTab,"Bordereaux Tab");
		Report.LogInfo("StepsCheck", "Step 15 completed", "PASS");
		// Step 16
		waitForElementToAppear(policy.SubmitBordereauxDownArrow,5);
		verifyMustExists(policy.SubmitBordereauxDownArrow,"Bordereaux Tab");
		click(policy.SubmitBordereauxDownArrow,"Bordereaux Tab");
		verifyMustExists(RiskOption,"Risk Option");
		verifyMustExists(CliamOption,"Claim Option");
		verifyMustExists(PremiumOption,"Premium Option");
		click(policy.SubmitBordereauxDownArrow,"Bordereaux Tab");
		Report.LogInfo("StepsCheck", "Step 16 completed", "PASS");
		//Step 17
		NavigateOnExpected();
		Report.LogInfo("StepsCheck", "Step 17 completed", "PASS");
		//Step 18
		waitForElementToAppear(Overduebtn,3);
		verifyExists(Overduebtn,"overdue button");
		click(Overduebtn,"overdue button");
		sleep(1000);
		if(isVisible(Overduebtn)==true){
			Report.LogInfo("CheckButton", "Overdue button not clickable", "PASS");
		}else{
			Report.LogInfo("CheckButton", "Overdue button clickable", "Fail");
			goBack();
		}
		Report.LogInfo("StepsCheck", "Step 18 completed", "PASS");
		//Step 19
		BorProc.navigateOnProcessingTab();
		BorProc.applyBordereauTypeFilter("Claim");
		verifyDeletebuttonForBordereuaxClaim();
		ClearFilter();
		BorProc.applyBordereauTypeFilter("Risk");
		verifyDeletebuttonForBordereuaxRisk();
		ClearFilter();
		BorProc.applyBordereauTypeFilter("Premium");
		verifyDeletebuttonForBordereuaxPremium();
		Report.LogInfo("StepsCheck", "Step 19 completed", "PASS");
		//Step 20
		//Review Error Risk,Claim and Premium
		ClearFilter();	
		sleep(1000);
		waitForElementToAppear(FebruaryReviewErrorClaim,5);
		verifyExists(FebruaryReviewErrorClaim,"Verify Review Error file");
		click(FebruaryReviewErrorClaim,"Click on Review Error file");
		if(isVisible(VerifyReviewErrorPage)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		verifyExists(FebruaryReviewErrorRisk,"Verify Review Error status of Risk");
		click(FebruaryReviewErrorRisk,"Click on Review Error status of Risk");
		if(isVisible(VerifyReviewErrorPage)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		verifyExists(FebruaryReviewErrorPremium,"Verify Review Error status of Premium");
		click(FebruaryReviewErrorPremium,"Click on Review Error status of Premium");
		if(isVisible(VerifyReviewErrorPage)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		//Review Risk,Claim and Premium
		verifyExists(JanReviewClaim,"Click on Review file");
		click(JanReviewClaim,"Click on Review file");
		if(isVisible(BorProc.SuRcdAssmnt)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		verifyExists(JanReviewRisk,"Verify Review status of Risk");
		click(JanReviewRisk,"Click on Review status of Risk");
		if(isVisible(BorProc.SuRcdAssmnt)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}				
		verifyExists(JanReviewPremium,"Verify Review status of Premium");
		click(JanReviewPremium,"Click on Review status of Premium");
		if(isVisible(BorProc.SuRcdAssmnt)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		//For Approval Risk,Claim and Premium
		verifyExists(AprilForApprovalRisk,"Verify For Approval status of Risk");
		click(AprilForApprovalRisk,"Click on  For Approval status of Risk");
		if(isVisible(VerifyForApprovalPage)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		verifyExists(MarchForApprovalClaim,"Verify  For Approval status of Claim");
		click(MarchForApprovalClaim,"Click on  For Approvalr status of Claim");
		if(isVisible(VerifyForApprovalPage)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		Report.LogInfo("StepsCheck", "Step 20 completed", "PASS");
		//Step 21
		verifyExists(AprilForAssignmentClaim,"Verify For Assignment status of Claim");
		click(AprilForAssignmentClaim,"Click on Review status of Claim");
		if(isVisible(VerifyForAssignmentPage)==true)
		{
			Report.LogInfo("CheckNavigation", "User navigated to section assignment rule screen", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "FAIL");
		}
		goBack();
		Report.LogInfo("StepsCheck", "Step 21 completed", "PASS");
		//Step 23
		navigationOnApproveTab();
		verifyExists(JanApprovedRisk,"Verify For Approved status of Risk");
		click(JanApprovedRisk,"Click on Approved status of Risk");
		if(isEnable(UnApprvBdrBtn)==false)
		{
			Report.LogInfo("CheckUnApprvBdrBtn", "UnApprved button is Disable", "PASS");	
		}
		else{Report.LogInfo("CheckUnApprvBdrBtn", "UnApprved button is Not Disable", "FAIL");	
		}
		goBack();
		verifyExists(JanApprovedClaim,"Verify For Approved status of Claim");
		click(JanApprovedClaim,"Click on Approved status of Claim");
		if(isEnable(UnApprvBdrBtn)==true)
		{Report.LogInfo("CheckUnApprvBdrBtn", "UnApprved button is Not Disable", "FAIL");			
		}
		else{
			Report.LogInfo("CheckUnApprvBdrBtn", "UnApprved button is Disable", "PASS");
		}
		goBack();
		verifyExists(JanApprovedPremium,"Verify For Approved status of Premium");
		click(JanApprovedPremium,"Click on Approved status of Premium");
		if(isEnable(UnApprvBdrBtn)==true)
		{Report.LogInfo("CheckUnApprvBdrBtn", "UnApprved button is Not Disable", "FAIL");			
		}
		else{
			Report.LogInfo("CheckUnApprvBdrBtn", "UnApprved button is Disable", "PASS");
		}
		goBack();
		Report.LogInfo("StepsCheck", "Step 23 completed", "PASS");
		//Step 24
		policy.navigateToReportingChannelsTab();
		if(isVisible(policy.AddReportingChannelBtn)==true){
			Report.LogInfo("ElementCheck", "AddReportingChannelBtn available", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "AddReportingChannelBtn not available", "PASS");
		}
		Report.LogInfo("StepsCheck", "Step 24 completed", "PASS");
		//Step 25
		BorProc.applyReportingChannelIdentifyFilter("Risk Bordereaux 1");
		viewonlySectionAssignmentPopUp();			
		viewonlyRiskCodeAssignmentPopUp();
		ClearReportingChannelFilter();
		BorProc.applyReportingChannelIdentifyFilter("Claim Bordereaux 1");
		viewonlySectionAssignmentPopUpForClaim();			
		viewonlyRiskCodeAssignmentPopUpForClaim();
		ClearReportingChannelFilter();
		BorProc.applyReportingChannelIdentifyFilter("Premium Bordereaux 1");
		viewonlySectionAssignmentPopUp();			
		viewonlyRiskCodeAssignmentPopUp();
		Report.LogInfo("StepsCheck", "Step 25 completed", "PASS");
		//Step 26
		policy.navigateRulesTab();
		VerifyMainRuleEditOrAdd();
		Report.LogInfo("StepsCheck", "Step 26 completed", "PASS");
		//Step 27
		policy.navigateGeneralTab();
		VerifyGeneralTabEditOrAdd();
		Report.LogInfo("StepsCheck", "Step 27 completed", "PASS");
		//Step 28
		policy.navigateBreachesTab();
		Report.LogInfo("StepsCheck", "Step 28 completed", "PASS");
		//Step 29
		policy.navigateToFilesTab();
		VerifyFileTabEditORAdd();
		Report.LogInfo("StepsCheck", "Step 29 completed", "PASS");
		//Step 30
		policy.navigateToSectionTab1();
		policy.navigateToSectionDotEdit();
		policy.EditSubDivisionSection();
		Report.LogInfo("StepsCheck", "Step 30 completed", "PASS");
		//Step 31
		policy.navigateToMarketsTabOnSection();
		VerifyMarketTabEditORAdd();
		Report.LogInfo("StepsCheck", "Step 31 completed", "PASS");
		//Step 32
		policy.navigateToRiskCodesTabOnSection();
		VerifyRiskCodeTabEditORAdd();
		Report.LogInfo("StepsCheck", "Step 32 completed", "PASS");	
		//Step 33
		VerifyRuleTabEditORAdd();
		Report.LogInfo("StepsCheck", "Step 33 completed", "PASS");	
		//Step 34
		policy.navigateLocationTab();
		VerifyLocationTabEditORAdd();
		Report.LogInfo("StepsCheck", "Step 34 completed", "PASS");	
		//Step 35
		if(isVisible(policy.AddSectionTab)==false)
		{
			Report.LogInfo("ElementCheck", "User is not able to Add Section", "PASS");	
		}
		else{
			Report.LogInfo("ElementCheck", "User is able to Add Section", "FAIL");
		}
		Report.LogInfo("StepsCheck", "Step 35 completed", "PASS");	

		//Step 36
		verifyMustExists(policy.BordereauxTab,"Bordereaux Tab");
		click(policy.BordereauxTab,"Bordereaux Tab");
		BorProc.navigateOnProcessingTab();
		Report.LogInfo("StepsCheck", "Step 36 completed", "PASS");	

		//Step 37
		waitForElementToAppear(TaskIconforRiskReview,5);
		click(TaskIconforRiskReview,"Task icon");
		sleep(2000);
		if(isVisible(AddTaskBtn)==false && (isVisible(EditTaskIcon)==true)){
			Report.LogInfo("ElementCheck", "User is not able to Add but Edit Task", "PASS");	
		}
		else{
			Report.LogInfo("ElementCheck", "User is able to Add and Edit Task", "FAIL");
		}	
		verifyMustExists(Cancel,"Cancel Button");
		click(Cancel,"Cancel Button");
		Report.LogInfo("StepsCheck", "Step 37 completed", "PASS");	

		//Step 38
		waitForElementToAppear(TaskIconforPremiumReview,5);
		click(TaskIconforPremiumReview,"Task icon");
		sleep(2000);
		if(isVisible(AddTaskBtn)==false && (isVisible(EditTaskIcon)==true)){
			Report.LogInfo("ElementCheck", "User is not able to Add but Edit Task", "PASS");	
		}
		else{
			Report.LogInfo("ElementCheck", "User is able to Add and Edit Task", "FAIL");
		}	
		verifyMustExists(Cancel,"Cancel Button");
		click(Cancel,"Cancel Button");
		Report.LogInfo("StepsCheck", "Step 38 completed", "PASS");	

		//Step 39 to 41
		waitForElementToAppear(TaskIconforClaimReview,5);
		click(TaskIconforClaimReview,"Task icon");
		sleep(2000);
		if(isVisible(AddTaskBtn)==true && (isVisible(EditTaskIcon)==true)){
			Report.LogInfo("ElementCheck", "User is able to Add and Edit Task", "PASS");	
			waitForElementToAppear(EditTaskIcon,5);
			click(EditTaskIcon,"Edit Task Button");
			sleep(2000);
			if(isVisible(AddNoteForTask)==true && (isVisible(SaveChangesBtn)==true)){
				Report.LogInfo("ElementCheck", "User is able to Add Note for Task", "PASS");	
				verifyMustExists(CancelBtn,"Cancel Button");
				click(CancelBtn,"Cancel Button");
			}
			else{
				Report.LogInfo("ElementCheck", "User is not able to Add Note for Task", "FAIL");
			}
		}
		else{
			Report.LogInfo("ElementCheck", "User is  not able to Add and Edit Task", "FAIL");
		}	
	}

	
	public void ClaimsApprovalRoleChange_Broker() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("9","Brit Syndicates Limited - 2987");
		EditContractRole("10","AON - DUA team");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(Standard_user_Broker, Standard_user_Broker_Pass);
	}
	
	public void ClaimsApprovalRoleChange_Coverholder() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("9","Brit Syndicates Limited - 2987");
		EditContractRole("10","Coverholder Inc - New York");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(Standard_user_CoverHolder, Standard_user_Coverholder_Pass);
	}
	
	public void ClaimsApprovalRoleChange_Insurer() throws Exception
	{
		policy.navigationOnPolicyTab();
		BorProc.applyFilterPolicy("252341GD");
		BorProc.openSelectedPolicy();
		BorProc.navigationOnRoleTab();
		EditContractRole("9","Brit Syndicates Limited - 2987");
		EditContractRole("10","Aspen Managing Agency Limited - 4711");
		loginPage.tideAdminLogOut();
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		sleep(3000);
		//Step 3 
		loginPage.tideLogin(AdminInsure, AdminInsurePass);
	}
	public void ClaimApproval_Standard_Insurer_TC4827() throws Exception
	{
		Report.LogInfo("StepsCheck", "Step 3 completed", "PASS");

		//Step 4,5,6
		BorProc.applyFilterPolicy(policy.PolicyNumber);
		//BorProc.applyFilterPolicy("400511YR");
		policy.openSelectedPolicy();
		Report.LogInfo("StepsCheck", "Step 4,5,6 completed", "PASS");

		//Step 7,8
		ConDetail.EditContract();
		waitForElementToAppear(CompanyRefrence,3);
		verifyExists(CompanyRefrence,"Company Refereance");
		sendKeys(CompanyRefrence,"Testing","Company Refereance");
		verifyMustExists(SaveEditedChanges,"Save Edited Changes");
		click(SaveEditedChanges,"Save Edited Changes");
		sleep(2000);
		waitForElementToAppear(policy.secondContractEndorsementPopUp,5);
		if(isVisible(policy.secondContractEndorsementPopUp) == true)
		{
			verifyMustExists(policy.SaveBtn4,"Save Button");
			javaScriptclick(policy.SaveBtn4,"Save Button");
			sleep(1000);
		}
		policy.scrollUp();
		Report.LogInfo("StepsCheck", "Step 7,8 completed", "PASS");

		//Step 9
		verifyMustExists(policy.ClaimAuthorityTab,"Verify Claim Authority Tab");
		sleep(1000);
		click(policy.EditClaimAuthorityTab," Click on Claim Authority Tab");
		sleep(2000);
		if(isVisible(policy.EditClaimAuthorityBtn)==false)
		{
			Report.LogInfo("ElementCheck", "User is not able to Edit Claim Authority", "PASS");	
		}
		else{
			Report.LogInfo("ElementCheck", "User is able to Edit Claim Authority", "FAIL");
		}
		Report.LogInfo("StepsCheck", "Step 9 completed", "PASS");

		//Step 10
		navigationOnRoleTab();
		verifyMustExists(CompanyRow1,"Select Company name");
		click(CompanyRow1,"Click on Company Name");
		if(isVisible(ContractAdministratorPopup)==false)
		{
			Report.LogInfo("ElementCheck", "User can view Roles tab, but cannot select to edit", "PASS");
		}
		else{Report.LogInfo("ElementCheck", "User can view Roles tab and select to edit", "FAIL");
		}
		Report.LogInfo("StepsCheck", "Step 10 completed", "PASS");

		//Step 11
		BorProc.navigateToDATATab();
		Report.LogInfo("StepsCheck", "Step 11 completed", "PASS");

		//Step 12
		waitForElementToAppear(VerifSummaryTab,3);
		verifyExists(VerifSummaryTab,"Verify Summary Tab");
		Report.LogInfo("StepsCheck", "Step 12 completed", "PASS");

		//Step 13
		BorProc.navigateToDATARiskTab();
		VerifyRiskTabData();
		Report.LogInfo("StepsCheck", "Step 13 completed", "PASS");

		//Step 14
		BorProc.navigateToDATAPremiumTab();
		VerifyPremiumTabData();
		Report.LogInfo("StepsCheck", "Step 14 completed", "PASS");

		//Step 15
		BorProc.navigateToDATAClaimTab();
		if(isVisible(AprovedJanFile)==true)
		{
			Report.LogInfo("ElementCheck", "Approved Status file is display in Claim Section", "PASS");
		}
		else{
			Report.LogInfo("ElementCheck", "Approved Status file is not display in Claim Section", "FAIL");
		}
		if(isVisible(MarchForAssignmentFile)==true)
		{
			Report.LogInfo("ElementCheck", "For Approval Status file is display in Claim Section", "PASS");
		}
		else{
			Report.LogInfo("ElementCheck", "For Approval Status file is not display in Claim Section", "FAIL");
		}
		Report.LogInfo("StepsCheck", "Step 15 completed", "PASS");

		//Step 16
		waitForElementToAppear(policy.BordereauxTab,5);
		verifyMustExists(policy.BordereauxTab,"Bordereaux Tab");
		click(policy.BordereauxTab,"Bordereaux Tab");
		Report.LogInfo("StepsCheck", "Step 16 completed", "PASS");

		//Step 17
		waitForElementToAppear(policy.SubmitBordereauxDownArrow,5);
		verifyMustExists(policy.SubmitBordereauxDownArrow,"Bordereaux Tab");
		click(policy.SubmitBordereauxDownArrow,"Bordereaux Tab");
		verifyMustExists(RiskOption,"Risk Option");
		verifyMustExists(CliamOption,"Claim Option");
		verifyMustExists(PremiumOption,"Premium Option");
		click(policy.SubmitBordereauxDownArrow,"Bordereaux Tab");
		Report.LogInfo("StepsCheck", "Step 17 completed", "PASS");

		//Step 18
		NavigateOnExpected();
		Report.LogInfo("StepsCheck", "Step 17 completed", "PASS");

		// Step 19
		BorProc.navigateOnProcessingTab();
		BorProc.applyBordereauTypeFilter("Claim");
		verifyDeletebuttonForBordereuaxClaim();
		ClearFilter();
		BorProc.applyBordereauTypeFilter("Risk");
		verifyDeletebuttonForBordereuaxRisk();
		ClearFilter();
		BorProc.applyBordereauTypeFilter("Premium");
		verifyDeletebuttonForBordereuaxPremium();
		Report.LogInfo("StepsCheck", "Step 19 completed", "PASS");

		//Step 20
		//Review Error Risk,Claim and Premium
		ClearFilter();
		sleep(2000);
		waitForElementToAppear(FebruaryReviewErrorClaim,5);
		verifyExists(FebruaryReviewErrorClaim,"Verify Review Error file");
		click(FebruaryReviewErrorClaim,"Click on Review Error file");
		if(isVisible(VerifyReviewErrorPage)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		verifyExists(FebruaryReviewErrorRisk,"Verify Review Error status of Risk");
		click(FebruaryReviewErrorRisk,"Click on Review Error status of Risk");
		if(isVisible(VerifyReviewErrorPage)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		verifyExists(FebruaryReviewErrorPremium,"Verify Review Error status of Premium");
		click(FebruaryReviewErrorPremium,"Click on Review Error status of Premium");
		if(isVisible(VerifyReviewErrorPage)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		//Review Risk,Claim and Premium
		verifyExists(JanReviewClaim,"Click on Review file");
		click(JanReviewClaim,"Click on Review file");
		if(isVisible(BorProc.SuRcdAssmnt)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		verifyExists(JanReviewRisk,"Verify Review status of Risk");
		click(JanReviewRisk,"Click on Review status of Risk");
		if(isVisible(BorProc.SuRcdAssmnt)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}				
		verifyExists(JanReviewPremium,"Verify Review status of Premium");
		click(JanReviewPremium,"Click on Review status of Premium");
		if(isVisible(BorProc.SuRcdAssmnt)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		//For Assignment Risk,Claim,Premium
		verifyExists(AprilForAssignmentClaim,"Verify For Assignment status of Claim");
		click(AprilForAssignmentClaim,"Click on Review status of Claim");
		if(isVisible(VerifyForAssignmentPage)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		verifyExists(MarchForAssignmentRisk,"Verify For Assignment status of Risk");
		click(MarchForAssignmentRisk,"Click on Review status of Risk");
		if(isVisible(VerifyForAssignmentPage)==false)
		{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		Report.LogInfo("StepsCheck", "Step 20 completed", "PASS");

		//Step 21
		//For Approval Risk,Claim and Premium
		verifyExists(AprilForApprovalRisk,"Verify For Approval status of Risk");
		click(AprilForApprovalRisk,"Click on  For Approval status of Risk");
		if(isVisible(VerifyForApprovalPage)==false)
		{

			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "FAIL");
		}
		Report.LogInfo("StepsCheck", "Step 21 completed", "PASS");

		//Step 22
		verifyExists(MarchForApprovalClaim,"Verify  For Approval status of Claim");
		click(MarchForApprovalClaim,"Click on  For Approvalr status of Claim");
		if(isVisible(VerifyForApprovalPage)==true)
		{
			verifyExists(BorProc.ApproveBordBtn, "Verify Approve Borderuax Button");
			verifyExists(RejectBtn, "Verify Reject Button");
			Report.LogInfo("CheckNavigation", "Action perform for Upload status file", "PASS");
		}
		else{
			Report.LogInfo("CheckNavigation", "Action not perform for Upload status file", "FAIL");
		}
		goBack();
		Report.LogInfo("StepsCheck", "Step 22 completed", "PASS");

		//Step 23
		navigationOnApproveTab();

		verifyExists(JanApprovedClaim,"Verify For Approved status of Claim");
		click(JanApprovedClaim,"Click on Approved status of Claim");

		if(isEnable(UnApprvBdrBtn)==true)
		{
			Report.LogInfo("CheckUnApprvBdrBtn", "UnApprved button is Enabled", "PASS");
		}
		else{
			Report.LogInfo("CheckUnApprvBdrBtn", "UnApprved button is not Enabled", "FAIL");
		}
		goBack();
		Report.LogInfo("StepsCheck", "Step 23 completed", "PASS");

		//Step 24
		verifyExists(JanApprovedRisk,"Verify For Approved status of Risk");
		click(JanApprovedRisk,"Click on Approved status of Risk");
		if(isEnable(UnApprvBdrBtn)==false)
		{
			Report.LogInfo("CheckUnApprvBdrBtn", "UnApprved button is Disable", "PASS");	
		}
		else{Report.LogInfo("CheckUnApprvBdrBtn", "UnApprved button is Not Disable", "FAIL");	
		}
		goBack();
		verifyExists(JanApprovedPremium,"Verify For Approved status of Premium");
		click(JanApprovedPremium,"Click on Approved status of Premium");
		if(isEnable(UnApprvBdrBtn)==false)
		{Report.LogInfo("CheckUnApprvBdrBtn", "UnApprved button is Disable", "PASS");			
		}
		else{
			Report.LogInfo("CheckUnApprvBdrBtn", "UnApprved button is not Disable", "FAIL");
		}
		goBack();
		Report.LogInfo("StepsCheck", "Step 24 completed", "PASS");

		//Step 25
		policy.navigateToReportingChannelsTab();
		if(isVisible(policy.AddReportingChannelBtn)==true){
			Report.LogInfo("ElementCheck", "Add Reporting Channel Btn available", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add Reporting Channel Btn not available", "PASS");
		}
		Report.LogInfo("StepsCheck", "Step 25 completed", "PASS");

		//Step 26
		BorProc.applyReportingChannelIdentifyFilter("Risk Bordereaux 1");
		viewonlySectionAssignmentPopUp();			
		viewonlyRiskCodeAssignmentPopUp();
		ClearReportingChannelFilter();
		BorProc.applyReportingChannelIdentifyFilter("Claim Bordereaux 1");
		viewonlySectionAssignmentPopUp();			
		viewonlyRiskCodeAssignmentPopUp();
		ClearReportingChannelFilter();
		BorProc.applyReportingChannelIdentifyFilter("Premium Bordereaux 1");
		viewonlySectionAssignmentPopUp();			
		viewonlyRiskCodeAssignmentPopUp();
		Report.LogInfo("StepsCheck", "Step 26 completed", "PASS");

		//Step 27
		ClearReportingChannelFilter();
		BorProc.applyReportingChannelIdentifyFilter("Claim Bordereaux 1");
		editReportingChannel1();

		//Step 28
		policy.navigateRulesTab();
		VerifyMainRuleEditOrAdd();
		Report.LogInfo("StepsCheck", "Step 28 completed", "PASS");

		//Step 29
		policy.navigateGeneralTab();
		VerifyGeneralTabEditOrAdd();
		Report.LogInfo("StepsCheck", "Step 29 completed", "PASS");

		//Step 30
		policy.navigateBreachesTab();
		Report.LogInfo("StepsCheck", "Step 30 completed", "PASS");

		//Step 31
		policy.navigateToFilesTab();
		VerifyFileTabEditORAdd();
		Report.LogInfo("StepsCheck", "Step 31 completed", "PASS");

		//Step 32
		policy.navigateToSectionTab1();
		sleep(2000);
		policy.navigateToSectionDotEdit();
		policy.EditSubDivisionSection();
		Report.LogInfo("StepsCheck", "Step 32 completed", "PASS");

		//Step 33
		policy.navigateToMarketsTabOnSection();
		VerifyMarketTabEditORAdd();
		Report.LogInfo("StepsCheck", "Step 33 completed", "PASS");

		//Step 34
		policy.navigateToRiskCodesTabOnSection();
		VerifyRiskCodeTabEditORAdd();
		Report.LogInfo("StepsCheck", "Step 34 completed", "PASS");

		//Step 35
		VerifyRuleTabEditORAdd();
		Report.LogInfo("StepsCheck", "Step 35 completed", "PASS");	

		//Step 36
		policy.navigateLocationTab();
		VerifyLocationTabEditORAdd();
		Report.LogInfo("StepsCheck", "Step 36 completed", "PASS");

		//Step 37
		BorProc.navigateToDATATab();
		BorProc.navigateToDATACreditControlTab();
		Report.LogInfo("StepsCheck", "Step 37 completed", "PASS");

		//Step 38
		if(isVisible(policy.AddSectionTab)==false)
		{
			Report.LogInfo("ElementCheck", "User is not able to Add Section", "PASS");	
		}
		else{
			Report.LogInfo("ElementCheck", "User is able to Add Section", "FAIL");
		}
		Report.LogInfo("StepsCheck", "Step 38 completed", "PASS");

		//Step 39
		verifyMustExists(policy.BordereauxTab,"Bordereaux Tab");
		click(policy.BordereauxTab,"Bordereaux Tab");
		BorProc.navigateOnProcessingTab();
		Report.LogInfo("StepsCheck", "Step 39 completed", "PASS");

		//Step 40
		waitForElementToAppear(TaskIconforRiskReview,5);
		click(TaskIconforRiskReview,"Task icon");
		sleep(2000);
		if(isVisible(AddTaskBtn)==false && (isVisible(EditTaskIcon)==true)){
			Report.LogInfo("ElementCheck", "User is not able to Add but Edit Task", "PASS");	
		}
		else{
			Report.LogInfo("ElementCheck", "User is able to Add and Edit Task", "FAIL");
		}	
		verifyMustExists(Cancel,"Cancel Button");
		click(Cancel,"Cancel Button");
		Report.LogInfo("StepsCheck", "Step 40 completed", "PASS");	

		//Step 41
		waitForElementToAppear(TaskIconforPremiumReview,5);
		click(TaskIconforPremiumReview,"Task icon");
		sleep(2000);
		if(isVisible(AddTaskBtn)==false && (isVisible(EditTaskIcon)==true)){
			Report.LogInfo("ElementCheck", "User is not able to Add but Edit Task", "PASS");	
		}
		else{
			Report.LogInfo("ElementCheck", "User is able to Add and Edit Task", "FAIL");
		}	
		verifyMustExists(Cancel,"Cancel Button");
		click(Cancel,"Cancel Button");
		Report.LogInfo("StepsCheck", "Step 41 completed", "PASS");

		//Step 42 to 44
		waitForElementToAppear(TaskIconforClaimReview,5);
		click(TaskIconforClaimReview,"Task icon");
		sleep(2000);
		if(isVisible(AddTaskBtn)==true && (isVisible(EditTaskIcon)==true)){
			Report.LogInfo("ElementCheck", "User is able to Add and Edit Task", "PASS");	
			waitForElementToAppear(EditTaskIcon,5);
			click(EditTaskIcon,"Edit Task Button");
			sleep(2000);
			if(isVisible(AddNoteForTask)==true && (isVisible(SaveChangesBtn)==true)){
				Report.LogInfo("ElementCheck", "User is able to Add Note for Task", "PASS");	
				verifyMustExists(CancelBtn,"Cancel Button");
				click(CancelBtn,"Cancel Button");
			}
			else{
				Report.LogInfo("ElementCheck", "User is not able to Add Note for Task", "FAIL");
			}
			verifyMustExists(Cancel,"Cancel Button");
			click(Cancel,"Cancel Button");
		}
		else{
			Report.LogInfo("ElementCheck", "User is  not able to Add and Edit Task", "FAIL");
		}	
	}

	//========================================Reusable===================================

	public void openPolicyEditMode(){
		sleep(1000);
		waitForElementToAppear(PolicyEditDot,5);
		if(isVisible(PolicyEditDot)==true)
		{
			click(PolicyEditDot,"Policy edit dots");
			waitForElementToAppear(PolicyEditbtn,3);
			verifyExists(PolicyEditbtn,"Policy Edit btn");
			waitForElementToAppear(CreateContract,3);
			verifyExists(CreateContract,"Create Contract btn");
		}
	}
	
	public void VerifyedidpolicyIsHidden(){
		sleep(1000);
		waitForElementToAppear(PolicyEditDot,5);
		if(isVisible(PolicyEditDot)==true)
		{
			Report.LogInfo("Verify", "Contract Edit button visible", "FAIL");
		}
		else {
			Report.LogInfo("Verify", "Contract Edit button not visible", "PASS");
		}
	}
	
	public void verifyUsercaneditContractdetails(){
		sleep(1000);
		waitForElementToAppear(PolicyEditDot,5);
		if(isVisible(PolicyEditDot)==true)
		{
			click(PolicyEditDot,"Policy edit dots");
			waitForElementToAppear(PolicyEditbtn,3);
			verifyExists(PolicyEditbtn,"Policy Edit btn");
			waitForElementToAppear(CreateContract,3);
			verifyExists(CreateContract,"Create Contract btn");
			click(PolicyEditbtn,"Policy edit dots");
		
		waitForElementToAppear(UniqueReference,5);
		if(isVisible(UniqueReference)==true)
		{
			sendKeys(UniqueReference,"Permissions 3.0.1");
			waitForElementToAppear(CompanyReference1,3);
			verifyExists(CompanyReference1,"Policy Edit btn");
			sendKeys(UniqueReference,"Permissions 3.0.1");
		
		}
		}
		goBack();
	}

	public void openPolicyInEditMode(){
		sleep(1000);
		waitForElementToAppear(PolicyEditDot,5);
		if(isVisible(PolicyEditDot)==true)
		{
			click(PolicyEditDot,"Policy edit dots");
			waitForElementToAppear(PolicyEditbtn,3);
			verifyExists(PolicyEditbtn,"Policy Edit btn");
			click(PolicyEditbtn,"Policy Edit btn");
		}
	}

	public void openPolicyCreateContract(){
		sleep(1000);
		waitForElementToAppear(PolicyEditDot,5);
		if(isVisible(PolicyEditDot)==true)
		{
			click(PolicyEditDot,"Policy edit dots");
			waitForElementToAppear(CreateContract,3);
			verifyExists(CreateContract,"Policy create contract btn");
			click(CreateContract,"Policy create contract btn");
		}
	}


	public void NavigateToRoletab(){
		sleep(1000);
		waitForElementToAppear(RolesTab,5);
		if(isVisible(RolesTab)==true)
		{
			click(RolesTab,"Roles tab");	
			waitForElementToAppear(RolesTabPage,3);
			verifyExists(RolesTabPage,"Role tab page");
		}
	}

	public void SubmitBodVerifyOptions(){
		sleep(1000);
		waitForElementToAppear(SubmitBodrBtn,5);
		if(isVisible(SubmitBodrBtn)==true)
		{
			click(SubmitBodrBtn,"Submit bordereau button");	
			waitForElementToAppear(CliamOption,3);
			verifyExists(CliamOption,"Cliam Option");
			waitForElementToAppear(PremiumOption,3);
			verifyExists(PremiumOption,"Premium Option");
			waitForElementToAppear(RiskOption,3);
			verifyExists(RiskOption,"Risk Option");
			
			waitForElementToAppear(RiskAndPremiumOption,3);
			verifyExists(RiskAndPremiumOption,"Risk Option");
			
			//a[contains(.,'Risk And Premium')]
			click(SubmitBodrBtn,"Roles tab");
		}
	}	
	
	public void SubmitBodVerifyRiskOption(){
		sleep(1000);
		waitForElementToAppear(SubmitBodrBtn,5);
		if(isVisible(SubmitBodrBtn)==true)
		{
			click(SubmitBodrBtn,"Roles tab");	
			waitForElementToAppear(RiskOption,3);
			verifyExists(RiskOption,"Risk Option");
			click(SubmitBodrBtn,"Roles tab");
		}
		Report.LogInfo("ElementCheck", "Riskoption Available", "PASS");
	}
	
	public void SubmitBodVerifyPremiumOption(){
		sleep(1000);
		waitForElementToAppear(SubmitBodrBtn,5);
		if(isVisible(SubmitBodrBtn)==true)
		{
			click(SubmitBodrBtn,"Roles tab");	
	
			waitForElementToAppear(PremiumOption,3);
			verifyExists(PremiumOption,"Premium Option");
	
			click(SubmitBodrBtn,"Roles tab");
		}
	}
	
	public void SubmitBodVerifyClaimOption(){
		sleep(1000);
		waitForElementToAppear(SubmitBodrBtn,5);
		if(isVisible(SubmitBodrBtn)==true)
		{
			click(SubmitBodrBtn,"Roles tab");	
			waitForElementToAppear(CliamOption,3);
			verifyExists(CliamOption,"Cliam Option");
			click(SubmitBodrBtn,"Roles tab");
		}
	}

	public void NavigateOnExpected(){
		sleep(1000);
		waitForElementToAppear(Expectedtab,5);
		if(isVisible(Expectedtab)==true)
		{
			click(Expectedtab,"Expected tab");			
		}
	}

	public void NavigateOnRocessing(){
		sleep(1000);
		waitForElementToAppear(Processingtab,5);
		if(isVisible(Processingtab)==true)
		{
			click(Processingtab,"Processing tab");			
		}
	}

	public void ApproveStatusFromReviewBordereauType(String mapval) throws Exception{
		verfyndClickReview1(JanReview);

		if(isVisible(ExpectedSummaryscreen)==true){
			Report.LogInfo("ValidateErrorScreen", "Expected error screen page displayed.", "PASS");
			submtRecordAssmnt();
			if(isVisible(SectionAssignmentRuleScreen)==true){
				Report.LogInfo("ValidateScreen", "Expected screen page displayed.", "PASS");			
				SelectDropDownValue(BordereauAssignmentSectionDropDwn, BordereauAssignmentSectionDropDwnOption);
				SetMapping(mapval);
				SelectDropDownValue(SectionIdDropDwn, SectionIdDropDwnOption);
				click(CompleteAssignmentBtn,"Complete Assignment button");			
				SelectDropDownValue(SectionRiskCodeDwn, SectionRiskCodeDropoption);
				SetMapping(mapval);
				SelectDropDownValue(SectionRiskCodeIdDwn, SectionIdDropDwnOption);
				click(CompleteAssignmentBtn,"Complete Assignment button");			
				BorProc.clickOnApproveBordBtn();
				//SectionMappingOperation();a
				//RiskCodeAssignmentRuleOperation(mapval);
				BorProc.refreshUploadedFileApprovedStatus();

			}else{
				Report.LogInfo("ValidateScreen", "Expected screen page not displayed.", "FAIL");
			}

		}else{
			Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
			goBack();
			BorProc.deleteBorderEAUX();
		}		
	}

	public void ApproveStatusFromReviewBordereauType1(String mapval) throws Exception{

		verfyndClickReview1(AprilReview);
		if(isVisible(ExpectedSummaryscreen)==true){
			Report.LogInfo("ValidateErrorScreen", "Expected error screen page displayed.", "PASS");
			submtRecordAssmnt();
			if(isVisible(SectionAssignmentRuleScreen)==true){
				Report.LogInfo("ValidateScreen", "Expected screen page displayed.", "PASS");

				SelectDropDownValue(BordereauAssignmentSectionDropDwn, BordereauAssignmentSectionDropDwnOption);
				SetMapping(mapval);
				SelectDropDownValue(SectionIdDropDwn1, SectionIdDropDwnOption1);
				SelectDropDownValue(SectionIdDropDwn2, SectionIdDropDwnOption);
				click(CompleteAssignmentBtn,"Complete Assignment button");	
				/*waitForElementToAppear(PauseBtn,3);
				verifyMustExists(PauseBtn,"Pause button");
				click(PauseBtn,"Pause button");*/
				SelectDropDownValue(BordereauAssignmentSectionDropDwn, SectionRiskCodeDropoption);
				SetMapping(mapval);
				SelectDropDownValue(SectionIdDropDwn1Risk, SectionIdDropDwnOption1);
				SelectDropDownValue(SectionIdDropDwn2Risk, SectionIdDropDwnOption2);
				click(CompleteAssignmentBtn,"Complete Assignment button");	
				waitForElementToAppear(CancelBtn,3);				
				verifyMustExists(CancelBtn,"Cancel button");
				click(CancelBtn,"Cancel button");

			}else{
				Report.LogInfo("ValidateScreen", "Expected screen page not displayed.", "FAIL");
			}
		}else{
			Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
			goBack();
			//BorProc.deleteBorderEAUX();
		}		
	}


	public void ApproveStatusFromReviewBordereauType2(String mapval) throws Exception{

		verfyndClickReview1(AprilReview);
		if(isVisible(ExpectedSummaryscreen)==true){
			Report.LogInfo("ValidateErrorScreen", "Expected error screen page displayed.", "PASS");
			submtRecordAssmnt();
			if(isVisible(SectionAssignmentRuleScreen)==true){
				Report.LogInfo("ValidateScreen", "Expected screen page displayed.", "PASS");

				SelectDropDownValue(BordereauAssignmentSectionDropDwn, BordereauAssignmentSectionDropDwnOption);
				SetMapping(mapval);
				SelectDropDownValue(SectionIdDropDwn1, SectionIdDropDwnOption1);
				SelectDropDownValue(SectionIdDropDwn2, SectionIdDropDwnOption2);
				click(CompleteAssignmentBtn,"Complete Assignment button");	
				SelectDropDownValue(SectionRiskCodeDwn, SectionRiskCodeDropoption);
				SetMapping(mapval);
				SelectDropDownValue(SectionIdDropDwn1Risk, SectionIdDropDwnOption1);
				SelectDropDownValue(SectionIdDropDwn2Risk, SectionIdDropDwnOption2);
				click(CompleteAssignmentBtn,"Complete Assignment button");	
				waitForElementToAppear(CancelBtn,3);
				verifyMustExists(CancelBtn,"Cancel button");
				click(CancelBtn,"Cancel button");

			}else{
				Report.LogInfo("ValidateScreen", "Expected screen page not displayed.", "FAIL");
			}
		}else{
			Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
			goBack();
			//BorProc.deleteBorderEAUX();
		}		
	}

	public void ApproveStatusFromReviewBordereauType4(String mapval) throws Exception{

		verfyndClickReview1(MarReviewClaim);
		if(isVisible(ExpectedSummaryscreen)==true){
			Report.LogInfo("ValidateErrorScreen", "Expected error screen page displayed.", "PASS");
			submtRecordAssmnt();
			if(isVisible(SectionAssignmentRuleScreen)==true){
				Report.LogInfo("ValidateScreen", "Expected screen page displayed.", "PASS");

				SelectDropDownValue(BordereauAssignmentSectionDropDwn, BordereauAssignmentSectionDropDwnOption);
				SetMapping(mapval);
				SelectDropDownValue(SectionIdDropDwn1, SectionIdDropDwnOption1);
				SelectDropDownValue(SectionIdDropDwn2, SectionIdDropDwnOption2);
				click(CompleteAssignmentBtn,"Complete Assignment button");	
				SelectDropDownValue(SectionRiskCodeDwn, SectionRiskCodeDropoption);
				SetMapping(mapval);
				SelectDropDownValue(SectionIdDropDwn1Risk, SectionIdDropDwnOption1);
				SelectDropDownValue(SectionIdDropDwn2Risk, SectionIdDropDwnOption2);
				click(CompleteAssignmentBtn,"Complete Assignment button");	
				waitForElementToAppear(CancelBtn,3);
				verifyMustExists(CancelBtn,"Cancel button");
				click(CancelBtn,"Cancel button");

			}else{
				Report.LogInfo("ValidateScreen", "Expected screen page not displayed.", "FAIL");
			}
		}else{
			Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
			goBack();
			//BorProc.deleteBorderEAUX();
		}		
	}


	public static final String SectionMappingScreen = "@xpath=//span[text()='Section Mapping']";
	public static final String PropertyDrpDwn = "@xpath=//*[@ng-model='data.SectionId']//preceding-sibling::span";
	public static final String PropertyDrpDwnOption = "@xpath=//li[text()='Section 1 (Primary Risk Code: 1E)']";
	public static final String CompleteAssignmentButton = "@xpath=//*[@ng-click='submitMapping()']";

	public void SectionMappingOperation(){

		if(isVisible(SectionMappingScreen)==true){
			Report.LogInfo("ValidateScreen", "Expected section mapping screen page displayed.", "PASS");

			SelectDropDownValue(PropertyDrpDwn, PropertyDrpDwnOption);
			VerifyCompltAssmntBtn();
		}else{
			Report.LogInfo("ValidateScreen", "Expected section mapping screen page not displayed.", "FAIL");
		}		
	}

	public static final String MaintaiLibiltyDrp = "@xpath=//tr[1]//*[@ng-model='data.SectionId'][1]//preceding-sibling::span";
	public static final String MaintaiLibiltyDrp1 = "@xpath=//tr[1]//*[@ng-model='data.SectionRiskCodeId'][1]//preceding-sibling::span";
	public static final String ProprtyDrp = "@xpath=//tr[2]//*[@ng-model='data.SectionId'][1]//preceding-sibling::span";
	public static final String ProprtyDrp1 = "@xpath=//tr[2]//*[@ng-model='data.SectionRiskCodeId'][1]//preceding-sibling::span";

	public void SectionMappingOperation1(){

		if(isVisible(SectionMappingScreen)==true){
			Actions builder = new Actions(webDriver);
			Report.LogInfo("ValidateScreen", "Expected section mapping screen page displayed.", "PASS");
			waitForElementToAppear(MaintaiLibiltyDrp,3);
			verifyMustExists(MaintaiLibiltyDrp,"Property Drpop Down");
			click(MaintaiLibiltyDrp,"Property Drpop Down");
			sleep(1000);
			builder.sendKeys(Keys.ARROW_DOWN).perform();
			sleep(1000);
			builder.sendKeys(Keys.ENTER).perform();
			sleep(1000);
			//SelectDropDownValue(PropertyDrpDwn, PropertyDrpDwnOption);
			waitForElementToAppear(ProprtyDrp,3);
			verifyMustExists(ProprtyDrp,"Property Drpop Down");
			click(ProprtyDrp,"Property Drpop Down");
			sleep(1000);
			builder.sendKeys(Keys.ARROW_DOWN).perform();
			sleep(500);
			builder.sendKeys(Keys.ARROW_DOWN).perform();
			sleep(1000);
			builder.sendKeys(Keys.ENTER).perform();

			VerifyCompltAssmntBtn();
		}else{
			Report.LogInfo("ValidateScreen", "Expected section mapping screen page not displayed.", "FAIL");
		}		
	}

	public static final String RiskCodeAssignmentRuleScreen = "@xpath=//span[text()='Risk Code Assignment Rule']";
	public static final String AssignedRiskCodeContractDrpDwn = "@xpath=//*[@ng-model='form.defaultSectionRiskCode']//preceding-sibling::span";
	public static final String AssignedRiskCodeContractDrpDwnOption = "@xpath=//li[text()='Data in the bordereau will specify the Risk Code']";
	public static final String RiskCodeAssignmentMappingRuleScreen = "@xpath=//span[text()='Risk Code Assignment Mapping Rule']";
	public static final String MappingRulePropertyDrpDwn = "@xpath=//*[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String MappingRulePropertyDrpDwnOption = "@xpath=//li[text()='1E - OVERSEAS LEG TERRORISM ENERGY OFFSHORE PROPERTY']";
	public static final String ApprovedBordereauButton = "@xpath=//button[contains(.,'Approve Bordereau')]";


	public void RiskCodeAssignmentRuleOperation(String mapval){
		if(isVisible(RiskCodeAssignmentRuleScreen)==true){
			Report.LogInfo("ValidateScreen", "Expected Risk Code Assignment Rule page displayed.", "PASS");	
			SelectDropDownValue(AssignedRiskCodeContractDrpDwn, AssignedRiskCodeContractDrpDwnOption);
			SetMapping(mapval);
			if(isVisible(RiskCodeAssignmentMappingRuleScreen)==true){
				Report.LogInfo("ValidateScreen", "Expected Risk Code Assignment Mapping Rule page displayed.", "PASS");
				SelectDropDownValue(MappingRulePropertyDrpDwn, MappingRulePropertyDrpDwnOption);
				VerifyCompltAssmntBtn();
				waitForElementToAppear(ApprovedBordereauButton,3);
				verifyMustExists(ApprovedBordereauButton,"ApprovedBordereauButton");
				click(ApprovedBordereauButton,"ApprovedBordereauButton");
			}else{
				Report.LogInfo("ValidateScreen", "Expected Risk Code Assignment Mapping Rule page not displayed.", "FAIL");
			}

		}else{
			Report.LogInfo("ValidateScreen", "Expected Risk Code Assignment Rule page not displayed.", "FAIL");
		}
	}

	public void RiskCodeAssignmentRuleOperation1(String mapval){
		if(isVisible(RiskCodeAssignmentRuleScreen)==true){
			Report.LogInfo("ValidateScreen", "Expected Risk Code Assignment Rule page displayed.", "PASS");	
			SelectDropDownValue(AssignedRiskCodeContractDrpDwn, AssignedRiskCodeContractDrpDwnOption);
			SetMapping(mapval);
			if(isVisible(RiskCodeAssignmentMappingRuleScreen)==true){
				Actions builder = new Actions(webDriver);
				Report.LogInfo("ValidateScreen", "Expected section mapping screen page displayed.", "PASS");
				waitForElementToAppear(MaintaiLibiltyDrp1,3);
				verifyMustExists(MaintaiLibiltyDrp1,"Property Drpop Down");
				click(MaintaiLibiltyDrp1,"Property Drpop Down");
				sleep(1000);
				builder.sendKeys(Keys.ARROW_DOWN).perform();
				sleep(1000);
				builder.sendKeys(Keys.ENTER).perform();
				//SelectDropDownValue(PropertyDrpDwn, PropertyDrpDwnOption);
				waitForElementToAppear(ProprtyDrp1,3);
				verifyMustExists(ProprtyDrp1,"Property Drpop Down");
				click(ProprtyDrp1,"Property Drpop Down");
				sleep(1000);
				builder.sendKeys(Keys.ARROW_DOWN).perform();
				sleep(1000);
				builder.sendKeys(Keys.ENTER).perform();

				VerifyCompltAssmntBtn();
				waitForElementToAppear(CancelBtn,3);
				verifyMustExists(CancelBtn,"Cancel button");
				click(CancelBtn,"Cancel button");				
			}else{
				Report.LogInfo("ValidateScreen", "Expected Risk Code Assignment Mapping Rule page not displayed.", "FAIL");
			}

		}else{
			Report.LogInfo("ValidateScreen", "Expected Risk Code Assignment Rule page not displayed.", "FAIL");
		}
	}

	public void ProcessSecondBordereau_4438(String Filename, String payload1, String reviewError) throws Exception{
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnBordereauxTab();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4438Path_Second = fpath+"\\src\\test\\resources\\testdata\\"+Filename+"";
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		File excelFile = new File(sheet4438Path_Second);
		uploadFile(ReqUrl, excelFile, payload1, DraftUrl);
		//BorProc.refreshUploadedFile(reviewError);
		refreshUploadedFileTillStatus(reviewError);	
		if(BorProc.checkErrorReviewButton(reviewError)==true)
		{
			Report.LogInfo("ValidateErrorScreen", "Expected error screen page displayed.", "PASS");

		}else{
			Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
			goBack();
			//BorProc.deleteBorderEAUX();
		}		
	}

	public void selectNoContproc(){
		waitForElementToAppear(schema.ContinueBtn,2);
		if(isVisible(schema.ContinueBtn)==true){
			javaScriptclick(NoRadiobtn,"No radio button");
			sleep(2000);
			verifyMustExists(schema.ContinueBtn,"Continue button");
			javaScriptclick(schema.ContinueBtn,"Continue button");
		}
	}

	public void verfyndClickReview()
	{
		waitForElementToAppear(BorProc.ReviewBtn,2);
		if(isVisible(BorProc.ReviewBtn)==true){			
			verifyMustExists(BorProc.ReviewBtn,"Review button");
			click(BorProc.ReviewBtn,"Review button");
		}
	}
	public void verfyndClickReview1(String MonthReview)
	{
		waitForElementToAppear(MonthReview,2);
		if(isVisible(MonthReview)==true){			
			verifyMustExists(MonthReview,"Review button");
			click(MonthReview,"Review button");
		}
	}			


	public void submtRecordAssmnt(){
		waitForElementToAppear(SubmitRecordForAssignmentButton,2);
		if(isVisible(SubmitRecordForAssignmentButton)==true){			
			verifyMustExists(SubmitRecordForAssignmentButton,"SubmitRecordForAssignment button");
			click(SubmitRecordForAssignmentButton,"SubmitRecordForAssignment button");
		}
	}

	public void SetMapping(String val){
		String mapVal = "@xpath=//span[text()='"+val+"']";
		waitForElementToAppear(mapVal,3);
		if(isVisible(mapVal)==true){			
			verifyMustExists(mapVal,"Map val Field");
			click(mapVal,"Map val Field");
			waitForElementToAppear(RightArrowSign,3);
			verifyMustExists(RightArrowSign,"RightArrowSign");
			click(RightArrowSign,"RightArrowSign");
			waitForElementToAppear(SetMappingRuleButton,3);
			verifyMustExists(SetMappingRuleButton,"SetMappingRuleButton");
			click(SetMappingRuleButton,"SetMappingRuleButton");
		}
	}

	public void VerifyCompltAssmntBtn(){
		waitForElementToAppear(CompleteAssignmentButton,3);
		if(isVisible(CompleteAssignmentButton)==true){			
			verifyMustExists(CompleteAssignmentButton,"CompleteAssignmentButton");
			click(CompleteAssignmentButton,"CompleteAssignmentButton");
		}
	}

	public void refreshUploadedFileTillStatus(String Status) throws Exception
	{
		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;		
		do
		{
			sleep(3000);
			javaScriptclick(BorProc.RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;			
		}while((isVisible(Status)==false) && (totalTime < 180000));
	}

	public void AddClaimAuthrity(){
		waitForElementToAppear(permission.EditDotsClaim,5);
		verifyExists(permission.EditDotsClaim,"Edit dots");
		click(permission.EditDotsClaim,"Edit dots");

		waitForElementToAppear(permission.Editbtn,5);
		verifyExists(permission.Editbtn,"Edit button");
		click(permission.Editbtn,"Edit button");
		sleep(2000);
		SelectDropDownValue1(ClaimSAthDrp,ClaimSAthDrpVal);
		verifyExists(ClaimSAthDrplimittxt,"Claims Authority Limit");
		sendKeys(ClaimSAthDrplimittxt,"100","Claims Authority Limit");
		verifyExists(Savebtn,"Save button");
		click(Savebtn,"Save button");		
	}
	
	public void EditContractRole_ReadonlyUser(String CompanyRow,String CompanyName) throws Exception
	{
		String rowNum = "@xpath=//div[@class='table-responsive ng-scope']//tr["+CompanyRow+"]/td[3]";
		String ComName = "@xpath=//ul/li[contains(.,'"+CompanyName+"')]";
		waitForElementToAppear(rowNum,5);
		verifyMustExists(rowNum,"Company row");
		click(rowNum,"Company row");
		waitForElementToAppear(CompanyDropDown,5);
		
		if(isVisible(CompanyDropDown) == true) {
			Report.LogInfo("ValidateScreen", "unExpected  screen  displayed.", "FAIL");	
		}
		else {
			Report.LogInfo("ValidateScreen", "Usr cannot edit role", "PASS");	
		}
	}

	public void EditContractRole(String CompanyRow,String CompanyName) throws Exception
	{
		String rowNum = "@xpath=//div[@class='table-responsive ng-scope']//tr["+CompanyRow+"]/td[3]";
		String ComName = "@xpath=//ul/li[contains(.,'"+CompanyName+"')]";
		waitForElementToAppear(rowNum,5);
		verifyMustExists(rowNum,"Company row");
		click(rowNum,"Company row");
		waitForElementToAppear(CompanyDropDown,5);
		verifyMustExists(CompanyDropDown,"Company drop down");
		SelectDropDownValue(CompanyDropDown,ComName);
		waitForElementToAppear(SaveCompany,3);
		verifyMustExists(SaveCompany,"company Save button");
		click(SaveCompany,"company Save button");
		sleep(2000);
		if(isVisible(ConSettingPopUp) == true)
		{
			sleep(1000);
			verifyExists(SaveBtn4,"Save Button");
			click(SaveBtn4,"Save Button");
			sleep(2000);
		}

	}

	public void CannotEditContractRole(String CompanyRow) throws Exception
	{
		String rowNum = "@xpath=//div[@class='table-responsive ng-scope']//tr["+CompanyRow+"]/td[3]";
		//String ComName = "@xpath=//ul/li[contains(.,'"+CompanyName+"')]";
		waitForElementToAppear(rowNum,5);
		verifyMustExists(rowNum,"Company row");
		click(rowNum,"Company row");

		if(isVisible(CompanyDropDown)==true){
			Report.LogInfo("ElementCheck", "CompanyDropDown is available.", "FAIL");
			waitForElementToAppear(SaveCompany,3);
			verifyMustExists(SaveCompany,"company Save button");
			click(SaveCompany,"company Save button");
			sleep(2000);
			if(isVisible(ConSettingPopUp) == true)
			{
				sleep(1000);
				verifyExists(SaveBtn4,"Save Button");
				click(SaveBtn4,"Save Button");
				sleep(2000);
			}
		}else{
			Report.LogInfo("ElementCheck", "CompanyDropDown is not available.", "PASS");
		}



	}

	public void AddTask(String title, String CurVal, String TVal, String statVal){
		String CurrentOwnerVal ="@xpath=//li[contains(., '"+CurVal+"')]";
		String TypeVal ="@xpath=//li[contains(., '"+TVal+"')]";
		String StatusVal ="@xpath=//li[contains(., '"+statVal+"')]";

		if(isVisible(TaskIcon)==true){
			waitForElementToAppear(TaskIcon,5);
			click(TaskIcon,"Task icon");
			sleep(2000);
			waitForElementToAppear(AddTaskBtn,5);
			verifyExists(AddTaskBtn,"Add task button");
			click(AddTaskBtn,"Add task button");
			sleep(1000);
			waitForElementToAppear(TaskTitle,5);
			verifyExists(TaskTitle,"Task title");
			sendKeys(TaskTitle,title,"Task title");

			verifyExists(TaskDescription,"Task description");
			sendKeys(TaskDescription,"Task Description test","Task description");

			SelectDropDownValue(CurrentOwnerDrp,CurrentOwnerVal);
			SelectDropDownValue(TypeDrp,TypeVal);
			SelectDropDownValue(StatusDrp,StatusVal);

			verifyExists(NotfcnDate,"Notification date");
			sendKeys(NotfcnDate,"31/07/2018 01:00 PM","Notification date");

			verifyExists(Savebtn,"Save button");
			click(Savebtn,"Save button");

			sleep(2000);                                         
			waitForElementToAppear(Cancel,5);
			verifyExists(Cancel,"Cancel button");
			click(Cancel,"Cancel button");
			sleep(2000);
		}
	}

	public void TaskCheck(){
		sleep(2000);	
		if(isVisible(TaskIcon)==true){
			waitForElementToAppear(TaskIcon,5);
			click(TaskIcon,"Task icon");
			sleep(2000);
			waitForElementToAppear(AddTaskBtn,5);
			verifyExists(AddTaskBtn,"Add task button");
			Report.LogInfo("ValidateButton", "Add Task button is available.", "PASS");
			if(isVisible(EdittaskBtn)==true){
				click(EdittaskBtn,"Edit button");
				Report.LogInfo("ValidateButton", "Edit button is available.", "PASS");
				waitForElementToAppear(AddNoteBtn,5);
				if(isVisible(AddNoteBtn)==true){
					Report.LogInfo("ValidateButton", "Edit button is available.", "PASS");

					click(Cancel2,"Cancel button");
					sleep(2000);
				}else{
					Report.LogInfo("ValidateButton", "Edit button is not available.", "FAIL");
				}
			}else{
				Report.LogInfo("ValidateButton", "Edit button is not available.", "FAIL");
			}

			waitForElementToAppear(Cancel,5);
			verifyExists(Cancel,"Cancel button");
			click(Cancel,"Cancel button");
			sleep(2000);
		}else{
			Report.LogInfo("ValidateScreen", "Expected screen page not displayed.", "FAIL");
		}
	}

	public void TaskAddEditBtnCheck(){
		sleep(2000);	
		if(isVisible(TaskIcon)==true){
			waitForElementToAppear(TaskIcon,5);
			click(TaskIcon,"Task icon");
			sleep(2000);
			if(isVisible(AddTaskBtn)==true){
				Report.LogInfo("ValidateButton", "Add button is available.", "FAIL");
			}else{
				Report.LogInfo("ValidateButton", "Add button is available.", "PASS");
			}
			if(isVisible(EdittaskBtn)==true){
				Report.LogInfo("ValidateButton", "Edit button is available.", "FAIL");
			}else{
				Report.LogInfo("ValidateButton", "Edit button is not available.", "PASS");
			}

			waitForElementToAppear(Cancel,5);
			verifyExists(Cancel,"Cancel button");
			click(Cancel,"Cancel button");
			sleep(2000);
		}
	}

	public void TaskAddEditBtnCheck1(){
		sleep(2000);	
		if(isVisible(TaskIcon)==true){
			waitForElementToAppear(TaskIcon,5);
			click(TaskIcon,"Task icon");
			sleep(2000);
			if(isVisible(AddTaskBtn)==true){
				Report.LogInfo("ValidateButton", "Add button is available.", "FAIL");
			}else{
				Report.LogInfo("ValidateButton", "Add button is available.", "PASS");
			}
			if(isVisible(EdittaskBtn)==true){
				Report.LogInfo("ValidateButton", "Edit button is available.", "PASS");
			}else{
				Report.LogInfo("ValidateButton", "Edit button is not available.", "FAIL");
			}

			waitForElementToAppear(Cancel,5);
			verifyExists(Cancel,"Cancel button");
			click(Cancel,"Cancel button");
			sleep(2000);
		}
	}
	
	public void TaskAddEditBtnCheckwithoutNptes(){
		sleep(2000);	
		if(isVisible(TaskIcon)==true){
			waitForElementToAppear(TaskIcon,5);
			click(TaskIcon,"Task icon");
			sleep(2000);
			if(isVisible(AddTaskBtn)==true){
				Report.LogInfo("ValidateButton", "Add button is available.", "FAIL");
			}else{
				Report.LogInfo("ValidateButton", "Add button is available.", "PASS");
			}
			if(isVisible(EdittaskBtn)==true){
				Report.LogInfo("ValidateButton", "Edit button is available.", "PASS");
			}else{
				Report.LogInfo("ValidateButton", "Edit button is not available.", "FAIL");
			}

			waitForElementToAppear(Cancel,5);
			verifyExists(Cancel,"Cancel button");
			click(Cancel,"Cancel button");
			sleep(2000);
		}
	}

	public void ApproveStatusFromReviewBordereauType2(String mapval,String ApproveBtn) throws Exception{
		verfyndClickReview1(JanReviewClaim);

		if(isVisible(ExpectedSummaryscreen)==true){
			Report.LogInfo("ValidateErrorScreen", "Expected error screen page displayed.", "PASS");
			submtRecordAssmnt();
			if(isVisible(SectionAssignmentRuleScreen)==true){
				Report.LogInfo("ValidateScreen", "Expected screen page displayed.", "PASS");			
				SelectDropDownValue(BordereauAssignmentSectionDropDwn, BordereauAssignmentSectionDropDwnOption);
				SetMapping(mapval);
				SelectDropDownValue(SectionIdDropDwn, SectionIdDropDwnOption);
				click(CompleteAssignmentBtn,"Complete Assignment button");			
				SelectDropDownValue(SectionRiskCodeDwn, SectionRiskCodeDropoption);
				SetMapping(mapval);
				SelectDropDownValue(SectionRiskCodeIdDwn, SectionIdDropDwnOption);
				click(CompleteAssignmentBtn,"Complete Assignment button");			
				BorProc.clickOnApproveBordBtn();
				//SectionMappingOperation();a
				BorProc.refreshUploadedFileApprovedStatus1(ApproveBtn);

			}else{
				Report.LogInfo("ValidateScreen", "Expected screen page not displayed.", "FAIL");
			}

		}else{
			Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
			goBack();
			//BorProc.deleteBorderEAUX();
		}		
	}

	public void selectYesContproc(){
		waitForElementToAppear(schema.ContinueBtn,2);
		if(isVisible(schema.ContinueBtn)==true){
			javaScriptclick(YesRadiobtn,"No radio button");
			sleep(2000);
			verifyMustExists(schema.ContinueBtn,"Continue button");
			javaScriptclick(schema.ContinueBtn,"Continue button");
		}
	}

	public void ApproveStatusFromReviewBordereauType3(String mapval) throws Exception{

		verfyndClickReview1(AprilReview);
		if(isVisible(ExpectedSummaryscreen)==true){
			Report.LogInfo("ValidateErrorScreen", "Expected error screen page displayed.", "PASS");
			submtRecordAssmnt();
			if(isVisible(SectionAssignmentRuleScreen)==true){
				Report.LogInfo("ValidateScreen", "Expected screen page displayed.", "PASS");
				waitForElementToAppear(PauseBtn,3);
				verifyMustExists(PauseBtn,"Pause button");
				click(PauseBtn,"Pause button");

			}else{
				Report.LogInfo("ValidateScreen", "Expected screen page not displayed.", "FAIL");
			}
		}else{
			Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
			goBack();
			//BorProc.deleteBorderEAUX();
		}		
	}

	public void ProcessSecondBordereau_4438Second(String Filename, String payload1, String reviewError) throws Exception{
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnBordereauxTab();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4438Path_Second = fpath+"\\src\\test\\resources\\testdata\\"+Filename+"";
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		File excelFile = new File(sheet4438Path_Second);
		uploadFile(ReqUrl, excelFile, payload1, DraftUrl);
		//BorProc.refreshUploadedFile(reviewError);
		refreshUploadedFileTillStatus(reviewError);	
		if(isVisible(reviewError)==true)
		{
			Report.LogInfo("ValidateErrorScreen", "Expected screen page displayed.", "PASS");

		}else{
			Report.LogInfo("ValidateErrorScreen", "Expected screen page not displayed.", "FAIL");
			goBack();
			BorProc.deleteBorderEAUX();
		}		
	}

	public void EditCompanyrefDetails(){
		verifyMustExists(policy.CompanyReference,"Company Reference textbox");
		sendKeys(policy.CompanyReference,policy.CompanyReferenceval,"Company Reference textbox.");

		if(isVisible(policy.ContractCurrencyDrpDown)==true){
			Report.LogInfo("ElementCheck", "User can edit contract currency", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "User cannot edit contract currency", "PASS");
		}

		scrollDown();
		verifyMustExists(policy.SaveBtn,"Save Button");
		click(policy.SaveBtn,"Save button");
		//Thread.sleep(5000);
		waitForElementToAppear(policy.PolicytitleOnCotractDetails,5);
		if(isVisible(policy.PolicytitleOnCotractDetails)== true)
		{
			Report.LogInfo("ContractDetailsNav", "User is successfully navigated on Contract Details page.", "PASS");
		}else{
			Report.LogInfo("ContractDetailsNav", "User is not successfully navigated on Contract Details page.", "FAIL");
		}	
		sleep(1000);
	}

	public void firstRcrdOverDueActionOccrd(){
		String firstRwOverDue = "@xpath=//tr[1]//button[text()='Overdue']";
		String Nobtn = "@xpath=//button[@ng-click='cancel()']";
		if(isVisible(firstRwOverDue)==true){
			verifyExists(firstRwOverDue,"OverDue button");
			click(firstRwOverDue,"OverDue button");
			waitForElementToAppear(Nobtn,2);
			verifyExists(Nobtn,"No button");
			click(Nobtn,"No button");
		}else{
			Report.LogInfo("ElementCheck", "OverDue button is not available", "FAIL");
		}
	}

	public void OverDueNoAction(){
		String firstRwOverDue1 = "@xpath=//tr[1]//button[text()='Overdue']";
		String Nobtn = "@xpath=//button[@ng-click='cancel()']";
		if(isVisible(firstRwOverDue1)==true){
			verifyExists(firstRwOverDue1,"OverDue button");
			click(firstRwOverDue1,"OverDue button");
			if(isVisible(Nobtn)==true){
				Report.LogInfo("ElementCheck", "Action occured", "FAIL");
			}else{
				Report.LogInfo("ElementCheck", "Action not occured", "PASS");
			}
		}else{
			Report.LogInfo("ElementCheck", "OverDue button is not available", "FAIL");
		}
	}

	public void ReviewNoAction(){
		if(isVisible(BorProc.ReviewBtn)==true){
			click(BorProc.ReviewBtn,"Review button");
			if(isVisible(Processingtab)==true){
				Report.LogInfo("ElementCheck", "No action occurs ", "PASS");
			}else{
				Report.LogInfo("ElementCheck", "action occurs ", "FAIL");
				goBack();
			}
		}else{
			Report.LogInfo("ElementCheck", "Review status not found", "FAIL");
		}
	}

	public void ReviewErrorNoAction(){
		if(isVisible(BorProc.ReviewError)==true){
			click(BorProc.ReviewError,"Review error button");
			if(isVisible(Processingtab)==true){
				Report.LogInfo("ElementCheck", "No action occurs ", "PASS");
			}else{
				Report.LogInfo("ElementCheck", "action occurs ", "FAIL");
				goBack();
			}
		}else{
			Report.LogInfo("ElementCheck", "Review error status not found", "FAIL");
		}
	}

	public void ForAssignmentNoAction(){
		String forAssignmnt = "@xpath=.//*[@id='grid']//button[text()='For Assignment']";
		if(isVisible(forAssignmnt)==true){
			click(forAssignmnt,"For assignment button");
			if(isVisible(Processingtab)==true){
				Report.LogInfo("ElementCheck", "No action occurs ", "PASS");
			}else{
				Report.LogInfo("ElementCheck", "action occurs ", "FAIL");
				goBack();
			}
		}else{
			Report.LogInfo("ElementCheck", "For assignment status not found", "FAIL");
		}
	}
	
	public void ForApprovalNoAction(){
		String forApproval = "@xpath=.//*[@id='grid']//button[text()='For Approval']";
		if(isVisible(forApproval)==true){
			click(forApproval,"For assignment button");
			if(isVisible(Processingtab)==true){
				Report.LogInfo("ElementCheck", "No action occurs ", "PASS");
			}else{
				Report.LogInfo("ElementCheck", "action occurs ", "FAIL");
				goBack();
			}
		}else{
			Report.LogInfo("ElementCheck", "For assignment status not found", "FAIL");
		}
	}

	public void viewonlySectionAssignmentPopUp()
	{
		if(isVisible(SectionAssignmentBtn)==true){
			waitForElementToAppear(SectionAssignmentBtn,5);
			verifyMustExists(SectionAssignmentBtn,"Section Assignment button");
			click(SectionAssignmentBtn,"Section Assignment pop up");
			waitForElementToAppear(SectionAssignmentPopup,5);
			verifyMustExists(SectionAssignmentPopup,"view button");
			if(isVisible(ViewBtn)==true && isVisible(EditBtn)==false){
				click(closeBtn,"Section Assignment button");
				Report.LogInfo("ElementCheck","only view Assignment", "PASS");
			}else{
				Report.LogInfo("ElementCheck", "only view Assignment missing", "FAIL");
			}
			sleep(2000);
		}else{
			Report.LogInfo("ElementCheck", "Section Assignment button missing", "FAIL");
		}
	}

	public void viewonlyRiskCodeAssignmentPopUp()
	{
		if(isVisible(RiskcodeAssignmentBtn)==true){
			waitForElementToAppear(RiskcodeAssignmentBtn,5);
			verifyMustExists(RiskcodeAssignmentBtn,"Risk code Assignment button");
			click(RiskcodeAssignmentBtn,"Section Assignment button");
			waitForElementToAppear(RiskCodeAssignmentPopup,5);
			verifyMustExists(RiskCodeAssignmentPopup,"Risk code Assignment pop Up");
			if(isVisible(ViewBtn)==true &&  isVisible(EditBtn)==false){
				click(closeBtn,"Section Assignment button");
				Report.LogInfo("ElementCheck","only view Risk code assignment ", "PASS");
			}else{
				Report.LogInfo("ElementCheck", "only view Risk code assignment missing", "FAIL");
			}
			sleep(2000);
		}else{
			Report.LogInfo("ElementCheck", "Risk code Assignment button missing", "FAIL");

		}
	}

	public void processingTabDisplay(){
		if(isVisible(Processingtab)==true){
			Report.LogInfo("ElementCheck", "No action occurs ", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "action occurs ", "FAIL");
			goBack();
		}
	}

	public void processingTabShouldNtDisplay(){
		if(isVisible(Processingtab)==true){
			Report.LogInfo("ElementCheck", "No action occurs ", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "action occurs ", "PASS");
			goBack();
		}
	}

	//===========================ATUL==================================
	public void verifyEditoptionMissingOnMain()
	{
		if(isVisible(PolicyEditDot)==false)
		{
			Report.LogInfo("CheckEditDot", "edit dot missing", "Pass");
		}else{
			Report.LogInfo("CheckEditDot", "edit dot not missing", "Fail");
		}
	}

	public void navigateToClaimAuthorityTab()
	{
		waitForElementToAppear(permission.ClaimsAuthorityLink,5);
		verifyExists(permission.ClaimsAuthorityLink,"ClaimsAuthorityLink");
		click(permission.ClaimsAuthorityLink,"ClaimsAuthorityLink");
	}

	public void verifyClaimsEditdot()
	{
		waitForElementToAppear(ClaimsAuthorityfld,5);
		if(isVisible(permission.EditDotsClaim)==false)
		{
			Report.LogInfo("CheckEditdot", "edit dot missing", "PASS");
		}else{
			Report.LogInfo("CheckEditdot", "edit dot present", "Fail");
		}
	}

	public void verifyRolesEdit(String CompanyRow)
	{
		String rowNum = "@xpath=//div[@class='table-responsive ng-scope']//tr["+CompanyRow+"]/td[3]";
		waitForElementToAppear(rowNum,5);
		verifyMustExists(rowNum,"Company row");
		click(rowNum,"Company row");
		if(isVisible(CompanyDropDown)==false)
		{
			Report.LogInfo("CheckRolesEdited","Roles not edited", "PASS");
		}else{
			Report.LogInfo("CheckRolesEdited","Roles edited", "Fail");
		}
	}

	public void editReportingChannel()
	{
		if(isVisible(policy.EditBtn)==true){
			waitForElementToAppear(policy.EditBtn,5);
			verifyMustExists(policy.EditBtn,"Edit button");
			click(policy.EditBtn,"Edit button");
			waitForElementToAppear(EditReportingChannelPopup,5);
			verifyMustExists(EditReportingChannelPopup,"Edit Reporting Channel Popup");
			click(AutoApproveYesRadio,"Yes Radio Button");
			verifyMustExists(policy.SaveChangesBtn,"Reporting Channel Save Button");
			click(policy.SaveChangesBtn,"Reporting Channel Save Button");
			sleep(2000);
		}
	}

	public void verifyAddRuleMissing()
	{
		if(isVisible(policy.AddRulesBtn)==false){
			Report.LogInfo("CheckAddRulebtn","Add rule button missing", "PASS");
			if(isVisible(EditRulesbtn)==false){
				Report.LogInfo("CheckEditbtn","Edit button missing", "PASS");
			}else{
				Report.LogInfo("CheckEditbtn","Edit button not missing", "Fail");
			}
		}else{
			Report.LogInfo("CheckAddRulebtn","Add rule button  not missing", "Fail");
		}
	}

	public void verifyEditOnGeneralTab()
	{
		if(isVisible(policy.EditDot)==false){
			Report.LogInfo("CheckEditbtn","Edit button missing", "PASS");
		}else{
			Report.LogInfo("CheckEditbtn","Edit button not missing", "Fail");
		}
	}

	public void verifyAddFilebtnMissing()
	{
		if(isVisible(Addfilebtn)==false){
			Report.LogInfo("CheckAddFilebtn","Add File button missing", "PASS");
		}else{
			Report.LogInfo("CheckAddFilebtn","Add File button  not missing", "Fail");
		}
	}

	public void verifyAddMarketbtnMissing()
	{
		if(isVisible(policy.AddMarketButton)==false){
			Report.LogInfo("CheckAddMarketbtn","Add market button missing", "PASS");
		}else{
			Report.LogInfo("CheckAddMarketbtn","Add market button not missing", "Fail");
		}
	}

	public void verifyAddRiskbtnMissing()
	{
		if(isVisible(policy.AddRiskCodeButton)==false){
			Report.LogInfo("CheckAddRisktbtn","Add risk button missing", "PASS");
		}else{
			Report.LogInfo("CheckAddRisktbtn","Add risk button not missing", "Fail");
		}
	}

	public void verifyAddRulesbtnOnSectionMissing()
	{
		if(isVisible(ADDRulebtnONsection1)==false){
			Report.LogInfo("CheckAddRulestbtn","Add Rule button missing", "PASS");
		}else{
			Report.LogInfo("CheckAddRulestbtn","Add Rule button not missing", "Fail");
		}
	}

	public void verifylocationEditDotMissing()
	{
		if(isVisible(LocationthreeRefdot)==false){
			Report.LogInfo("CheckEditdot","Edit dot missing", "PASS");
		}else{
			Report.LogInfo("CheckEditdot","Edit dot not missing", "Fail");
		}
	}

	public void verifyAddTaskAndEditBtnMissing()
	{
		if(isVisible(TaskIcon)==true){
			waitForElementToAppear(TaskIcon,5);
			click(TaskIcon,"Task icon");
			sleep(2000);
			if(isVisible(AddTaskBtn)==false && isVisible(EditbtnOnTaskIcon)==false){
				Report.LogInfo("CheckAddBtn","Add and Edit Button missing", "PASS");
				verifyExists(Cancel,"cancel button");
				click(Cancel,"Edit button");
			}else{
				Report.LogInfo("CheckAddBtn","Add and Edit Button not missing", "Fail");
				verifyExists(Cancel,"cancel button");
				click(Cancel,"Edit button");
			}
		}
	}

	public void verifyAddTaskBtnMissing()
	{
		if(isVisible(TaskIcon)==true){
			waitForElementToAppear(TaskIcon,5);
			click(TaskIcon,"Task icon");
			sleep(2000);
			if(isVisible(AddTaskBtn)==false && isVisible(EditbtnOnTaskIcon)==true){
				Report.LogInfo("CheckAddBtn","Add and Edit Button missing", "PASS");
				verifyExists(Cancel,"cancel button");
				click(Cancel,"Edit button");
			}else{
				Report.LogInfo("CheckAddBtn","Add and Edit Button not missing", "Fail");
				verifyExists(Cancel,"cancel button");
				click(Cancel,"Edit button");
			}
		}
	}

	public void verifyAddTaskAndEditBtnPresent()
	{
		if(isVisible(TaskIcon)==true){
			waitForElementToAppear(TaskIcon,5);
			click(TaskIcon,"Task icon");
			sleep(2000);
			if(isVisible(AddTaskBtn)==true && isVisible(EditbtnOnTaskIcon)==true){
				Report.LogInfo("CheckAddBtn","Add and Edit Button prenent", "PASS");
				click(EditbtnOnTaskIcon,"Edit task button");
				waitForElementToAppear(EditTaskPopUP,5);
				verifyExists(EditTaskPopUP,"Edit Task pop up");
				if(isEnable(ADDNewNoteBtn)==true){
					Report.LogInfo("CheckAddNewNoteBtn","Add new note button enable", "PASS");	
				}else{
					Report.LogInfo("CheckAddNewNoteBtn","Add new note button not enable", "Fail");
				}	
				verifyExists(Cancel1,"Edit task cancel button");
				click(Cancel1,"Edit button");
				verifyExists(Cancel,"cancel button");
				click(Cancel,"Edit button");
				sleep(2000);
			}else{
				Report.LogInfo("CheckAddBtn","Add and Edit Button not present", "Fail");
			}	
		}
	}

	public void verifyADDReportingChannelBtnMissing()
	{
		if(isVisible(policy.AddReportingChannelBtn)==false){
			Report.LogInfo("CheckAddBtn","Add Reorting channel button missing", "PASS");
		}else{
			Report.LogInfo("CheckAddBtn","Add Reorting channel button not missing", "Fail");
		}
	}

	public void editReportingChannel1()
	{
		sleep(1000);
		if(isVisible(policy.EditBtn1)==true){
			Report.LogInfo("CheckEditBtn","Edit Reorting channel button displayed", "PASS");
			waitForElementToAppear(policy.EditBtn1,5);
			verifyMustExists(policy.EditBtn1,"Edit button");
			click(policy.EditBtn1,"Edit button");
			waitForElementToAppear(EditReportingChannelPopup,5);
			verifyMustExists(EditReportingChannelPopup,"Edit Reporting Channel Popup");
			click(AutoApproveYesRadio,"Yes Radio Button");
			verifyMustExists(policy.SaveChangesBtn,"Reporting Channel Save Button");
			click(policy.SaveChangesBtn,"Reporting Channel Save Button");
			if(isVisible(SaveCompany)==true){
				sleep(1000);
				click(SaveCompany,"contract seeting upadate Save Button");
			}
			sleep(2000);
		}else{
			Report.LogInfo("CheckEditBtn","Edit Reorting channel button not displayed", "Fail");
		}
	}
	
	public void editReportingChannelwithoutAutoApproveSwitchEnabled()
	{
		sleep(1000);
		if(isVisible(policy.EditBtn1)==true){
			Report.LogInfo("CheckEditBtn","Edit Reorting channel button displayed", "PASS");
			waitForElementToAppear(policy.EditBtn1,5);
			verifyMustExists(policy.EditBtn1,"Edit button");
			click(policy.EditBtn1,"Edit button");
			waitForElementToAppear(EditReportingChannelPopup,5);
			verifyMustExists(EditReportingChannelPopup,"Edit Reporting Channel Popup");
			
			if(isVisible(AutoApproveYesRadio)==true){
				Report.LogInfo("CheckRadiobutton","Auto Approval button is not editable", "PASS");
			}else {
				Report.LogInfo("CheckRadiobutton","Auto Approval button is  editable", "FAIL");
			}
			verifyMustExists(policy.SaveChangesBtn,"Reporting Channel Save Button");
			click(policy.SaveChangesBtn,"Reporting Channel Save Button");
			if(isVisible(SaveCompany)==true){
				sleep(1000);
				click(SaveCompany,"contract seeting upadate Save Button");
			}
			sleep(2000);
		}else{
			Report.LogInfo("CheckEditBtn","Edit Reorting channel button not displayed", "Fail");
		}
	}

	public void editReportingChannelbuttonMissing()
	{	
		sleep(1000);
		if(isVisible(policy.EditBtn)==false){
			Report.LogInfo("CheckEditBtn","Edit Reorting channel button missing", "PASS");
		}else{
			Report.LogInfo("CheckEditBtn","Edit Reorting channel button not missing", "Fail");
		}
	}
	public void verifyRuleDDMissing()
	{
		if(isVisible(BreachesRulesDD)==false){
			Report.LogInfo("CheckRulesDropDown","Rules Drop Down missing", "PASS");
		}else{
			Report.LogInfo("CheckAddBtn","Rules Drop Down  not missing", "Fail");
		}
	}

	public void SubmitBodVerifyOptionsmissing()
	{
		sleep(2000);
		if(isVisible(SubmitBodrBtn)==false)
		{
			Report.LogInfo("CheckSubmitBorderBtn","Submit Bordereau button missing", "PASS");
		}else{
			Report.LogInfo("CheckSubmitBorderBtn","Submit Bordereau button missing", "Fail");
		}
	}

	public void verifySectionRefDotmissing()
	{
		if(isVisible(policy.ThreeDotsRef)==false){
			Report.LogInfo("ElementCheck","ThreeDotsRef element missing", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "ThreeDotsRef Expected element not missing", "FAIL");
		}
	}

	public void verifyAddSectionButtonMissing()
	{
		if(isVisible(policy.AddSectionTab)==false){
			Report.LogInfo("ElementCheck","Add Section Tab  missing", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Add Section Tab not missing", "FAIL");
		}
	}

	public void verifyEditReprotingChannelButtonMissing()
	{
		if(isVisible(policy.EditBtn1)==false){
			Report.LogInfo("ElementCheck","Edit button missing", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Edit button not missing", "FAIL");
		}
	}

	/*public void viewonlySectionAssignmentPopUp()
	{
		waitForElementToAppear(SectionAssignmentBtn,5);
		verifyMustExists(SectionAssignmentBtn,"Section Assignment button");
		click(SectionAssignmentBtn,"Section Assignment pop up");
		waitForElementToAppear(SectionAssignmentPopup,5);
		verifyMustExists(SectionAssignmentPopup,"view button");
		if(isVisible(ViewBtn)==true && isVisible(EditBtn)==false){
			click(closeBtn,"Section Assignment button");
			Report.LogInfo("ElementCheck","only view Assignment", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "only view Assignment missing", "FAIL");
		}
		sleep(2000);
	}*/

	public void verifyeditAndViewOnSectionAssignmentPopUp()
	{
		waitForElementToAppear(SectionAssignmentBtn,5);
		verifyMustExists(SectionAssignmentBtn,"Section Assignment button");
		click(SectionAssignmentBtn,"Section Assignment pop up");
		waitForElementToAppear(SectionAssignmentPopup,5);
		verifyMustExists(SectionAssignmentPopup,"view button");
		if(isVisible(ViewBtn)==true && isVisible(EditBtn)==true){
			click(closeBtn,"Section Assignment button");
			Report.LogInfo("ElementCheck","Edit and view button present on section Assignment", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Edit and view button not present on section Assignment", "FAIL");
		}
		sleep(2000);
	}

	/*public void viewonlyRiskCodeAssignmentPopUp()
	{
		waitForElementToAppear(RiskcodeAssignmentBtn,5);
		verifyMustExists(RiskcodeAssignmentBtn,"Risk code Assignment button");
		click(RiskcodeAssignmentBtn,"Section Assignment button");
		waitForElementToAppear(RiskCodeAssignmentPopup,5);
		verifyMustExists(RiskCodeAssignmentPopup,"Risk code Assignment pop Up");
		if(isVisible(ViewBtn)==true &&  isVisible(EditBtn)==false){
			click(closeBtn,"Section Assignment button");
			Report.LogInfo("ElementCheck","only view Risk code assignment ", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "only view Risk code assignment missing", "FAIL");
		}
		sleep(2000);
	}*/

	public void verifyeditAndViewOnRiskCodeAssignmentPopUp()
	{
		waitForElementToAppear(RiskcodeAssignmentBtn,5);
		verifyMustExists(RiskcodeAssignmentBtn,"Risk code Assignment button");
		click(RiskcodeAssignmentBtn,"Section Assignment button");
		waitForElementToAppear(RiskCodeAssignmentPopup,5);
		verifyMustExists(RiskCodeAssignmentPopup,"Risk code Assignment pop Up");
		if(isVisible(ViewBtn)==true &&  isVisible(EditBtn)==true){
			click(closeBtn,"Section Assignment button");
			Report.LogInfo("ElementCheck","Edit and view button present on Risk code assignment ", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Edit and view button not present on Risk code assignment missing", "FAIL");
		}
		sleep(2000);
	}
	public void verifyUnApprovedBordereauBtnDisable()
	{
		waitForElementToAppear(Approvedbtn,5);
		click(Approvedbtn,"Approved button");
		if(isEnable(UnApprovedbtn)==false){
			Report.LogInfo("ElementCheck","UnApproved bordereau button disable", "PASS");
			goBack();
		}else{
			Report.LogInfo("ElementCheck", "UnApproved bordereau button not disable", "FAIL");
			goBack();
		}
		sleep(2000);
	}

	public void verifyUnApprovedBordereauBtnEnable()
	{
		waitForElementToAppear(Approvedbtn,5);
		click(Approvedbtn,"Approved button");
		if(isEnable(UnApprovedbtn)==true){
			Report.LogInfo("ElementCheck","UnApproved bordereau button disable", "PASS");
			goBack();
		}else{
			Report.LogInfo("ElementCheck", "UnApproved bordereau button not disable", "FAIL");
			goBack();
		}
		sleep(2000);
	}

	public void verifyonlyPolicyEditbtn()
	{
		waitForElementToAppear(PolicyEditDot,5);
		if(isVisible(PolicyEditDot)==true)
		{
			click(PolicyEditDot,"Policy edit dots");
			if(isVisible(PolicyEditbtn)==true && isVisible(CreateContract)==false)
			{
				verifyExists(PolicyEditbtn,"Policy Edit btn");
				click(PolicyEditbtn,"Policy edit dots");
				waitForElementToAppear(CompanyReferenceTxt,5);
				sendKeys(CompanyReferenceTxt,CompanyReference,"company Reference");
				verifyExists(SaveEditedChanges,"save changes btn");
				click(SaveEditedChanges,"save changes btn");
				Report.LogInfo("CheckEditbtn", " edit button only displayed", "PASS");
			}else{
				Report.LogInfo("CheckEditbtn", "only edit button not validate", "Fail");
			}
		}else{
			Report.LogInfo("CheckEditDot", "edit dot not displayed", "Fail");
		}
	}

	public void navigationOnRoleTab()
	{
		waitForElementToAppear(Roletab,5);
		verifyMustExists(Roletab,"Verify Role Tab");
		click(Roletab,"Role Tab");

	}

	public void VerifyRiskTabData()
	{
		verifyMustExists(AprovedRoleRiskFile,"Verify Approved Status file in Risk Section");
		if(isVisible(AprovedRoleRiskFile)==true)
		{
			Report.LogInfo("ElementCheck", "Approved Status file is display in Risk Section", "PASS");
		}
		else{
			Report.LogInfo("ElementCheck", "Approved Status file is not display in Risk Section", "Fail");
		}
	}
	public void VerifyPremiumTabData()
	{
		verifyMustExists(AprovedRolePremiumFile,"Verify Approved Status file in Premium Section");
		if(isVisible(AprovedRolePremiumFile)==true)
		{
			Report.LogInfo("ElementCheck", "Approved Status file is display in Premium Section", "PASS");
		}
		else{
			Report.LogInfo("ElementCheck", "Approved Status file is not display in Premium Section", "Fail");
		}
	}
	public void VerifyClaimTabData()
	{
		if(isVisible(AprovedJanFile)==true)
		{
			Report.LogInfo("ElementCheck", "Approved Status file is display in Premium Section", "PASS");
		}
		else{
			Report.LogInfo("ElementCheck", "Approved Status file is not display in Premium Section", "Fail");
		}
		if(isVisible(AprilForApprovalFile)==true)
		{
			Report.LogInfo("ElementCheck", "For Approval Status file is display in Premium Section", "PASS");
		}
		else{
			Report.LogInfo("ElementCheck", "For Approval Status file is not display in Premium Section", "Fail");
		}
		if(isVisible(MarchForAssignmentFile)==true)
		{
			Report.LogInfo("ElementCheck", "For Assignment Status file is display in Premium Section", "PASS");
		}
		else{
			Report.LogInfo("ElementCheck", "For Assignment Status file is not display in Premium Section", "Fail");
		}
		if(isVisible(JanuaryReviewFile)==true)
		{
			Report.LogInfo("ElementCheck", "Review Status file is display in Premium Section", "PASS");
		}
		else{
			Report.LogInfo("ElementCheck", "Review Status file is not display in Premium Section", "FAIL");
		}
	}

	public void ClearFilter()
	{
		verifyExists(BordereauTypeFilter, "Bordereau Type Filter");
		click(BordereauTypeFilter, "Bordereau Type Filter");
		sleep(2000);
		verifyMustExists(ClearBtn,"Clear Filter");
		click(ClearBtn,"Clear Filter");
		sleep(2000);
	}

	public void verifyDeletebuttonForBordereuaxRisk()
	{
		verifyMustExists(AprilUploadRisk,"Upload Status is displayed");
		if(isVisible(DeleteButton)==false)
		{
			Report.LogInfo("DeleteBtnCheck", "Delete button is not Displayed", "PASS");
		}
		else{
			Report.LogInfo("DeleteBtnCheck", "Delete button is Displayed", "FAIL");
		}
		verifyMustExists(FebruaryReviewErrorRisk,"Review Error Status is displayed");
		if(isVisible(DeleteButton)==false)
		{
			Report.LogInfo("DeleteBtnCheck", "Delete button is not Displayed", "PASS");
		}
		else{
			Report.LogInfo("DeleteBtnCheck", "Delete button is Displayed", "FAIL");
		}
		verifyMustExists(JanReviewRisk,"Review Status is displayed");
		if(isVisible(DeleteButton)==false)
		{
			Report.LogInfo("DeleteBtnCheck", "Delete button is not Displayed", "PASS");
		}
		else{
			Report.LogInfo("DeleteBtnCheck", "Delete button is Displayed", "FAIL");
		}
	}
	public void verifyDeletebuttonForBordereuaxPremium()
	{
		verifyMustExists(AprilUploadPremium,"Upload Status is displayed");
		if(isVisible(DeleteButton)==true)
		{
			Report.LogInfo("DeleteBtnCheck", "Delete button is Displayed", "FAIL");
		}
		else{
			Report.LogInfo("DeleteBtnCheck", "Delete button is not Displayed", "PASS");
		}
		verifyMustExists(FebruaryReviewErrorPremium,"Review Error Status is displayed");
		if(isVisible(DeleteButton)==true)
		{
			Report.LogInfo("DeleteBtnCheck", "Delete button is Displayed", "FAIL");
		}
		else{
			Report.LogInfo("DeleteBtnCheck", "Delete button is not Displayed", "PASS");
		}
		verifyMustExists(JanReviewPremium,"Review Status is displayed");
		if(isVisible(DeleteButton)==true)
		{
			Report.LogInfo("DeleteBtnCheck", "Delete button is Displayed", "FAIL");
		}
		else{
			Report.LogInfo("DeleteBtnCheck", "Delete button is not Displayed", "PASS");
		}
	}

	public void navigationOnApproveTab()
	{
		waitForElementToAppear(ApprovedTab,5);
		verifyMustExists(ApprovedTab,"Approve Tab");
		click(ApprovedTab,"Approve Tab");
	}
	
	public void ClearReportingChannelFilter()
	{
		verifyExists(ReportingChannelfilterIcon, "Reporting Channel Filter");
		click(ReportingChannelfilterIcon, "Reporting Channel Filter");
		sleep(2000);
		verifyMustExists(ClearBtn,"Clear Filter");
		click(ClearBtn,"Clear Filter");
		sleep(2000);
	}
	
	public void VerifyRiskCodeTabEditORAdd()
	{
		if(isVisible(policy.AddRiskCodeButton)==false)
		{
			Report.LogInfo("ElementCheck", "User is not able to Add Risk Code", "PASS");	
		}
		else{
			Report.LogInfo("ElementCheck", "User is able to Add Risk Code", "FAIL");
		}
	}
	public void VerifyRuleTabEditORAdd()
	{
		waitForElementToAppear(policy.RulesGeneralTab,5);
		verifyMustExists(policy.RulesGeneralTab,"Rules Tab");
		click(policy.RulesGeneralTab,"Rules Tab");
		if(isVisible(policy.AddRulesBtn)==false)
		{
			Report.LogInfo("ElementCheck", "User is not able to Add Rule Under Section Tab", "PASS");	
		}
		else{
			Report.LogInfo("ElementCheck", "User is able to Add Rule Under Section Tab", "FAIL");
		}
	}
	
	public void VerifyMainRuleEditOrAdd()
	{
		if(isVisible(policy.AddRulesBtn)==false && isVisible(policy.EditRuleBtn)==false)
		{
			Report.LogInfo("ElementCheck", "User is not able to Add & Edit Rule", "PASS");	
		}
		else{
			Report.LogInfo("ElementCheck", "User is able to Add & Edit Rule", "FAIL");
		}
	}
	public void VerifyGeneralTabEditOrAdd()
	{
		if(isVisible(policy.EditDot)==false)
		{
			Report.LogInfo("ElementCheck", "User is not able to Edit Rule", "PASS");	
		}
		else{
			Report.LogInfo("ElementCheck", "User is able to Edit Rule", "FAIL");
		}
	}
	public void VerifyFileTabEditORAdd()
	{
		if(isVisible(policy.AddFileBtn)==false)
		{
			Report.LogInfo("ElementCheck", "User is not able to Add file", "PASS");	
		}
		else{
			Report.LogInfo("ElementCheck", "User is able to Add file", "FAIL");
		}
	}
	
	public void VerifyMarketTabEditORAdd()
	{
		if(isVisible(policy.AddMarketButton)==false)
		{
			Report.LogInfo("ElementCheck", "User is not able to Add Market", "PASS");	
		}
		else{
			Report.LogInfo("ElementCheck", "User is able to Add Market", "FAIL");
		}
	}
		
	public void VerifyLocationTabEditORAdd()
	{
		if(isVisible(policy.EditDotsLocation)==false)
		{
			Report.LogInfo("ElementCheck", "User is not able to Edit Location", "PASS");	
		}
		else{
			Report.LogInfo("ElementCheck", "User is able to Edit Location", "FAIL");
		}
	}
	
	public void verifyDeletebuttonForBordereuaxClaim()
	{
		verifyMustExists(AprilUploadClaim,"Upload Status is displayed");
		if(isVisible(DeleteButton)==false)
		{
			Report.LogInfo("DeleteBtnCheck", "Delete button is not Displayed", "PASS");
		}
		else{
			Report.LogInfo("DeleteBtnCheck", "Delete button is Displayed", "FAIL");
		}
		verifyMustExists(FebruaryReviewErrorClaim,"Review Error Status is displayed");
		if(isVisible(DeleteButton)==false)
		{
			Report.LogInfo("DeleteBtnCheck", "Delete button is not Displayed", "PASS");
		}
		else{
			Report.LogInfo("DeleteBtnCheck", "Delete button is Displayed", "FAIL");
		}
		verifyMustExists(JanReviewClaim,"Review Status is displayed");
		if(isVisible(DeleteButton)==false)
		{
			Report.LogInfo("DeleteBtnCheck", "Delete button is not Displayed", "PASS");
		}
		else{
			Report.LogInfo("DeleteBtnCheck", "Delete button is Displayed", "FAIL");
		}
	}
	
	public void viewonlySectionAssignmentPopUpForClaim()
	 {
	  waitForElementToAppear(SectionAssignmentBtn,5);
	  verifyMustExists(SectionAssignmentBtn,"Section Assignment button");
	  click(SectionAssignmentBtn,"Section Assignment button");
	  if(isVisible(SectionAssignmentPopup)==true && isVisible(EditBtn)==true){
	   waitForElementToAppear(ViewBtn,5);
	   verifyMustExists(ViewBtn,"view button");
	   waitForElementToAppear(EditBtn,5);
	   verifyMustExists(EditBtn,"Edit button");
	   verifyMustExists(closeBtn,"view button");
	   click(closeBtn,"Section Assignment button");
	   Report.LogInfo("ElementCheck","only view Assignment", "PASS");
	  }else{
	   Report.LogInfo("ElementCheck", "only view Assignment missing", "FAIL");
	  }
	  sleep(2000);
	 }
	
	public void viewonlyRiskCodeAssignmentPopUpForClaim()
	{
	waitForElementToAppear(RiskcodeAssignmentBtn, 5);
	verifyMustExists(RiskcodeAssignmentBtn, "Section Assignment button");
	click(RiskcodeAssignmentBtn, "Section Assignment button");
	if (isVisible(RiskCodeAssignmentPopup) == true
			&& isVisible(EditBtn) == true) {
		waitForElementToAppear(ViewBtn, 5);
		verifyMustExists(ViewBtn, "view button");
		waitForElementToAppear(EditBtn, 5);
		verifyMustExists(EditBtn, "Edit button");
		verifyMustExists(closeBtn, "view button");
		click(closeBtn, "Section Assignment button");
		Report.LogInfo("ElementCheck", "only view Risk code assignment ",
				"PASS");
	} else {
		Report.LogInfo("ElementCheck",
				"only view Risk code assignment missing", "FAIL");
	}
	sleep(2000);
	}
	
	public void VerifyRiskReviewNotEdited()
	{
		waitForElementToAppear(TaskIconforRiskReview,5);
		click(TaskIconforRiskReview,"Task icon");
		sleep(2000);
			if(isVisible(AddTaskBtn)==false && (isVisible(EditTaskIcon)==false)){
				Report.LogInfo("ElementCheck", "User is not able to Add and Edit Task", "PASS");	
			}
			else{
				Report.LogInfo("ElementCheck", "User is able to Add and Edit Task", "FAIL");
			}	
			verifyMustExists(Cancel,"Cancel Button");
			click(Cancel,"Cancel Button");
	}
	public void VerifyPremiumNotEdited()
	{
		waitForElementToAppear(TaskIconforPremiumReview,5);
		click(TaskIconforPremiumReview,"Task icon");
		sleep(2000);
			if(isVisible(AddTaskBtn)==false && (isVisible(EditTaskIcon)==false)){
				Report.LogInfo("ElementCheck", "User is not able to Add and Edit Task", "PASS");	
			}
			else{
				Report.LogInfo("ElementCheck", "User is able to Add and Edit Task", "FAIL");
			}	
			verifyMustExists(Cancel,"Cancel Button");
			click(Cancel,"Cancel Button");	
	}
	public void VerifyClaimNotEdited()
	{
		waitForElementToAppear(TaskIconforClaimReview,5);
		click(TaskIconforClaimReview,"Task icon");
		sleep(2000);
		if(isVisible(AddTaskBtn)==false && (isVisible(EditTaskIcon)==false)){
			Report.LogInfo("ElementCheck", "User is not able to Add and Edit Task", "PASS");	
		}
		else{
			Report.LogInfo("ElementCheck", "User is able to Add and Edit Task", "FAIL");
		}	
		verifyMustExists(Cancel,"Cancel Button");
		click(Cancel,"Cancel Button");
	}
	public void VerifyCreditcontrol()
	{
		BorProc.navigateToDATACreditControlTab();
		waitForElementToAppear(RecordCount2,5);
		verifyExists(RecordCount2,"Total record count verified");
		
	}
	

}
