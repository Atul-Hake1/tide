package com.tide.qa.pagefactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;

import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;
import com.tide.qa.pagefactory.ReportingChannel;

public class Permissions extends PageBase{

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BordereauQuePage BQue = new BordereauQuePage();
	BordereauProcessPage Br = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();
	Rules rule = new Rules();
	CompanyPage compny = new CompanyPage();
	DatasetReferenceDataPage datasetReferenceData = new DatasetReferenceDataPage();
	RateOfExchangePage exchange = new RateOfExchangePage();

	//****************************************TC-4141 - Permission*************************************************//
	String reference= "Automation test"+getCurrentTime();
	
	//Locators - TC-4141

	public static final String DataSetLink = "@xpath=//a[text()='Datasets']";
	public static final String ClaimTab = "@xpath=//*[@ng-click='redirectTo(dataset.Name)']//td[text()='Claim']";

	//Locators TC-4335
	public static final String StatusFilterIcon= "@xpath=//*[@data-title='Status']//span";
	public static final String StatusFilterTextSearch= "@xpath=//input[@placeholder='Search']";
	public static final String StatusFilterButton= "@xpath=//button[text()='Filter']";
	public static final String StatusFilterButtonPolyRef= "@xpath=//*[@class='k-filter-menu k-popup k-group k-reset k-state-border-up']//button[text()='Filter']";
	public static final String StatusTab= "@xpath=//th[@data-title='Status']";
	public static final String SelectedSignedStausPolicy= "@xpath=//tbody[@role='rowgroup']//tr[1]";
	public static final String SelectedSignedStausPolicy1= "@xpath=//tbody[@role='rowgroup']//tr[2]";
	public static final String KebabEditIcon= "@xpath=//a[@class='dropdown-toggle']";
	//public static final String BrokerLinkOnDetailsPage= "@xpath=//a[contains(.,'AON - DUA team')]";
	public static final String BrokerLinkOnDetailsPage= "@xpath=//*[text()='Broker']//parent::dt//following-sibling::dd//a";
	public static final String AboutMeLink= "@xpath=//a[text()='About']";
	public static final String ClaimsAuthorityLink= "@xpath=//a[contains(.,'Claims Authority')]";
	public static final String AdditionalTab= "@xpath=//a[contains(.,'Additional')]";
	public static final String CompanySpecificTab= "@xpath=//a[contains(.,'Company Specific')]";
	public static final String RolesTab= "@xpath=//a[contains(.,'Roles')]";
	public static final String ReportingChannelsTab= "@xpath=//a[contains(.,'Reporting Channels')]";
	public static final String AddReportingChannelBtn= "@xpath=//*[@ng-click='add()']";
	public static final String NavigateFilesTab= "@xpath=//a[contains(.,'Files')]";
	public static final String AddFileBtn= "@xpath=//*[@ng-click='addEditData()']";
	public static final String NavigateSection1= "@xpath=//a[contains(.,'Section 1')]";
	public static final String KebabIconSection1= "@xpath=//*[@ng-if='(editSection1 || editSection2)']//a[@class='dropdown-toggle'][1]";
	public static final String MarketsTab= "@xpath=//a[contains(.,'Markets')]";
	public static final String EntriesMarketsTab= "@xpath=//*[@ ng-click='details(data)']//td[2]";
	public static final String RiskCodeTab= "@xpath=//a[contains(.,'Risk codes')]";
	public static final String EntriesOfRiskCodeTab= "@xpath=//*[@ng-repeat='data in dataList']//td[2]";
	public static final String LocationTab= "@xpath=//a[contains(.,'Location')]";
	public static final String RulesTabContactMenu= "@xpath=//*[@ng-if='viewRulsTab']//a[contains(.,'Rules')]";
	public static final String AddRuleButtonContractMenu= "@xpath=//*[@ng-if='isSectionID && isContractInstanceSectionRulesRulesEdit']";
	public static final String EditButtonReportingChannel= "@xpath=//tr[1]//button[@ng-click='details(dataItem)']/i";
	public static final String PolicyReferenceFilterIcon1 = "@css=thead[role=rowgroup] th:nth-child(1) span";
	public static final String PolicyRefSearchText= "@xpath=//*[@class='k-filter-menu k-popup k-group k-reset k-state-border-up']//input[@placeholder='Search']";
	public static final String NoDataFound= "@xpath=//td[contains(.,'No data to display')]";
	public static final String BrokerLinkErrorMessage= "@xpath=//*[@ng-if='hasError'][contains(.,'Internal Server Error')]";

	public static final String EditDot = "@xpath=.//*[@id='profile-main']//li[@class='dropdown']";
	public static final String EditBtn = "@xpath=.//*[@id='profile-main']//li[@ng-if='Permission.Edit || PermissionContractMainCompanyReference.Edit']";
	public static final String FolderRefernce = "@xpath=.//*[@ng-click='openFolderPopup(selectedFolder.Id)']";
	public static final String FolderDetails = "@xpath=//div[@class='modal-content']";
	public static final String OkbtnFolderDeatls = "@xpath=//button[@ng-click='ok()']";

	public static final String ViewBtn = "@xpath=//button[@ng-click='openFolderPopup(data.FolderId)']";
	public static final String FolderDetailsPop = "@xpath=//div[@class='modal-content']";
	public static final String Okbtn = "@xpath=//button[@ng-click='ok()']";
	public static final String NoRecrd = "@xpath=//div[text()='0 items selected']";
	public static final String RefRecord = "@xpath=.//*[@id='grid']/div[2]//tbody[@role='rowgroup']//tr[1]";
	
	public static final String  FolderRefeVievBtn="@xpath=//*[@ng-click='openFolderPopup(data.FolderId)']";
	public static final String  FolderDetailsPopup="@xpath=//*[@class='modal-dialog modal-md']//*[contains(text(),'Folder Details')]";
	public static final String  okbtn="@xpath=//*[@ng-click='ok()']";
	public static final String AddRuleDropDown= "@xpath=//button[contains(.,'Split button dropdowns')]";
	public static final String EditBtn1= "@xpath=//*[@ng-click='editClick(1)']";
	public static final String policyDetailsEditBtn= "@xpath=//*[@ui-sref='app.contract.edit({contractId:contractId})']";
	public static final String CompanyReferencetxt= "@xpath=//*[@ng-if='Permission.Edit']";
	public static final String EditDotsClaim= "@xpath=.//*[@id='profile-main']//li[@class='dropdown']";
	public static final String SaveChangesBtn ="@xpath=//button[contains(text(),'Save Changes')]";
	public static final String Editbtn= "@xpath=.//*[@ng-click='openEditPopup()']";

	
	public void ContractTideAdminPermission_4141() throws Exception{
		policy.addPolicy();
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();

		//step 4,5,6
		EditDetailsVerify();

		rule.AddNewSchemaRule();
		rule.EditSchemaRule();
		//Step 8
		rule.AddComplianceDataRule();
		rule.EditComplianceDataRule();
		//Step 9
		datasetReferenceData.addDatasetReference_3381();
		datasetReferenceData.addvalueDatasetReference_3382();
		datasetReferenceData.mappingReferenceDataset_3383();
		//Step 10
		exchange.editRateOfExchange_3376();
		exchange.uploadInvalidFile_3377();
		exchange.uploadvalidFile_3378();
	}



	//************************************TC-4142******************************************************************//
	//------------------------------------START--------------------------------------------------------------------//

	public void CompanyAdminPermissionForCompanyTypeInsurer_4142() throws Exception{

		policy.addPolicy();
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		//step 4,5,6
		EditDetailsVerify();
		policy.navigationOnRuleTab();
		policy.selectRuleFilter("Schema");
		String Editbtn = "@xpath=//tr[1]//button[@ng-click='editClick(1)']";
		if(isVisible(Editbtn)==true){
			Report.LogInfo("ElementCheck", "Edit button element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit button element not found", "PASS");
		}

		refreshPage();
		policy.selectRuleFilter("Compliance Data");
		if(isVisible(Editbtn)==true){
			Report.LogInfo("ElementCheck", "Edit button element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit button element not found", "PASS");
		}

		policy.navigationOnPolicyTab();
		filterandCheck();
	}

	//********************************TC-4142-END*******************************************************************//



	//************************************TC-4143******************************************************************//
	//------------------------------------START--------------------------------------------------------------------//

	public void StandardUserPermissionCompanyInsurer_4143() throws Exception{

		policy.addPolicy();
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		//step 4,5,6
		EditDetailsVerify();
		policy.navigationOnRuleTab();
		policy.selectRuleFilter("Schema");
		String Editbtn = "@xpath=//tr[1]//button[@ng-click='editClick(1)']";
		if(isVisible(Editbtn)==true){
			Report.LogInfo("ElementCheck", "Edit button element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit button element not found", "PASS");
		}

		refreshPage();
		policy.selectRuleFilter("Compliance Data");
		if(isVisible(Editbtn)==true){
			Report.LogInfo("ElementCheck", "Edit button element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit button element not found", "PASS");
		}

		policy.navigationOnPolicyTab();
		sleep(2000);
		filterandCheck();
	}

	//********************************TC-4143-END*******************************************************************//
	//---------------------------------------------------------------------------------------------------------------//



	//************************************TC-4144******************************************************************//
	//------------------------------------START--------------------------------------------------------------------//

	public void ContractReadOnlyPermissionCompanyTypeInsurer_4144() throws Exception{
		String Status = "Signed";
		policy.navigationOnPolicyTab();
		if(isVisible(policy.AddContractBtn)==false){
			Report.LogInfo("ValidateAddContractButon", "Add contract button Missing", "PASS");
		}else{
			Report.LogInfo("ValidateAddContractButon", "Add contract button not Missing", "FAIL");
		}
		FilterStatusColumn(Status);
		ValidateEditOptionBySlectingSignedPolicy();
		waitForElementToAppear(ViewBtn,5);
		if(isVisible(ViewBtn)){
			verifyExists(ViewBtn,"View button");
			click(ViewBtn,"View button");

			waitForElementToAppear(FolderDetailsPop,5);
			verifyExists(FolderDetailsPop,"FolderDetails Pop up");

			waitForElementToAppear(Okbtn,5);
			verifyExists(Okbtn,"Ok button");
			click(Okbtn,"Ok button");

		}else{
			Report.LogInfo("ElementCheck", "View button element found", "FAIL");
		}

		sleep(3000);
		policy.navigationOnRuleTab();
		policy.selectRuleFilter("Schema");
		String Editbtn = "@xpath=//tr[1]//button[@ng-click='editClick(1)']";
		if(isVisible(Editbtn)==true){
			Report.LogInfo("ElementCheck", "Edit button element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit button element not found", "PASS");
		}

		policy.navigationOnPolicyTab();
		filterandCheck();
	}	

	//********************************TC-4144-END*******************************************************************//
	//---------------------------------------------------------------------------------------------------------------//





	//************************************TC-4329******************************************************************//
	//------------------------------------START--------------------------------------------------------------------//


	public void ContractStandardUserPermissionCompanyTypeCoverholder_4329() throws Exception{
		policy.navigationOnPolicyTab();
		if(isVisible(policy.AddContractBtn)==false){
			Report.LogInfo("ValidateAddContractButon", "Add contract button Missing", "PASS");
		}else{
			Report.LogInfo("ValidateAddContractButon", "Add contract button not Missing", "FAIL");
		}
		String Status = "Signed";
		FilterStatusColumn(Status);
		policy.openExistingPolicy();
		String EditDot = "@xpath=.//*[@id='profile-main']//li[@class='dropdown']";
		if(isVisible(EditDot)==true){
			Report.LogInfo("ElementCheck", "Edit dot element found", "PASS");
			click(EditDot,"Edit Button");
			waitForElementToAppear(policyDetailsEditBtn,5);
			verifyMustExists(policyDetailsEditBtn,"View Button");
			click(policyDetailsEditBtn,"Ok Button");
			waitForElementToAppear(policy.CompanyReference,5);
			verifyMustExists(policy.CompanyReference,"CompanyReference text field");
			sendKeys(policy.CompanyReference,reference,"Company Reference textbox.");
			verifyMustExists(SaveChangesBtn,"Save Changes Button");
			click(SaveChangesBtn,"Save changes Button");
		}else{
			Report.LogInfo("ElementCheck", "Edit dot element not found", "Fail");
		}
		waitForElementToAppear(FolderRefeVievBtn,5);
		verifyMustExists(FolderRefeVievBtn,"View Button");
		click(FolderRefeVievBtn,"View Button");
		if(isVisible(FolderDetailsPopup)==true){
			Report.LogInfo("CheckFolderDetailsPage", "Folder Details pop up displayed", "Pass");
			verifyMustExists(FolderDetailsPopup,"View Button");
			waitForElementToAppear(okbtn,5);
			verifyMustExists(okbtn,"Ok Button");
			click(okbtn,"Ok Button");
		}else{
			Report.LogInfo("CheckFolderDetailsPage", "Folder Details pop up not displayed", "Fail");
		}
		policy.navigationOnRuleTab();
		sleep(3000);
		if(isVisible(AddRuleDropDown)==true){
			Report.LogInfo("ElementCheck", "Add Rule button displayed", "Fail");
		}else{
			Report.LogInfo("ElementCheck", "Add Rule button not displayed", "Pass");
		}	
		policy.selectRuleFilter("Schema");
		if(isVisible(EditBtn)==true){
			Report.LogInfo("ElementCheck", "Schema Edit button not missing", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Schema Edit button missing", "PASS");
		}	
		refreshPage();
		sleep(2000);
		policy.selectRuleFilter("Compliance Data");
		if(isVisible(EditBtn)==true){
			Report.LogInfo("ElementCheck", "Compilance data Edit button not missing", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Compilance data Edit button missing", "PASS");
		}
		policy.navigationOnPolicyTab();
		filterandCheck();
	}	



	//************************************TC-4330******************************************************************//
	//------------------------------------START--------------------------------------------------------------------//
	

	public void ContractCompanyAdminPermissionCompanyTypeCoverholder_4330() throws Exception{
		policy.navigationOnPolicyTab();
		if(isVisible(policy.AddContractBtn)==false){
			Report.LogInfo("ValidateAddContractButon", "Add contract button Missing", "PASS");
		}else{
			Report.LogInfo("ValidateAddContractButon", "Add contract button not Missing", "FAIL");
		}		
		String Status = "Signed";
		FilterStatusColumn(Status);
		policy.openExistingPolicy();
		String EditDot = "@xpath=.//*[@id='profile-main']//li[@class='dropdown']";
		if(isVisible(EditDot)==true){
			Report.LogInfo("ElementCheck", "Edit dot element found", "PASS");
			click(EditDot,"Edit Button");
			waitForElementToAppear(policyDetailsEditBtn,5);
			verifyMustExists(policyDetailsEditBtn,"View Button");
			click(policyDetailsEditBtn,"Ok Button");
			waitForElementToAppear(policy.CompanyReference,5);
			verifyMustExists(policy.CompanyReference,"CompanyReference text field");
			sendKeys(policy.CompanyReference,reference,"Company Reference textbox.");
			verifyMustExists(SaveChangesBtn,"Save Changes Button");
			click(SaveChangesBtn,"Save changes Button");
		}else{
			Report.LogInfo("ElementCheck", "Edit dot element not found", "Fail");
		}
		waitForElementToAppear(FolderRefeVievBtn,5);
		verifyMustExists(FolderRefeVievBtn,"View Button");
		click(FolderRefeVievBtn,"View Button");
		if(isVisible(FolderDetailsPopup)==true){
			Report.LogInfo("CheckFolderDetailsPage", "Folder Details pop up displayed", "Pass");
			verifyMustExists(FolderDetailsPopup,"View Button");
			waitForElementToAppear(okbtn,5);
			verifyMustExists(okbtn,"Ok Button");
			click(okbtn,"Ok Button");
		}else{
			Report.LogInfo("CheckFolderDetailsPage", "Folder Details pop up not displayed", "Fail");
		}
		policy.navigationOnRuleTab();
		sleep(3000);
		if(isVisible(AddRuleDropDown)==true){
			Report.LogInfo("ElementCheck", "Add Rule button displayed", "Fail");
		}else{
			Report.LogInfo("ElementCheck", "Add Rule button not displayed", "Pass");
		}
		policy.selectRuleFilter("Schema");
		if(isVisible(EditBtn)==true){
			Report.LogInfo("ElementCheck", "Schema Edit button not missing", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Schema Edit button missing", "PASS");
		}	
		refreshPage();
		sleep(2000);
		policy.selectRuleFilter("Compliance Data");
		if(isVisible(EditBtn)==true){
			Report.LogInfo("ElementCheck", "Compilance data Edit button not missing", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Compilance data Edit button missing", "PASS");
		}
		
		policy.navigationOnPolicyTab();
		sleep(200);
		filterandCheck();
	}

	//************************************END-TC-4330***************************************************************//
	//*****************************************************************************************************************//





	//************************************TC-4325******************************************************************//
	//------------------------------------START--------------------------------------------------------------------//


	public void ContractReadOnlyPermissionCompanyTypeCoverholder_4325() throws Exception{
		policy.navigationOnPolicyTab();
		if(isVisible(policy.AddContractBtn)==false){
			Report.LogInfo("ValidateAddContractButon", "Add contract button Missing", "PASS");
		}else{
			Report.LogInfo("ValidateAddContractButon", "Add contract button not Missing", "FAIL");
		}
		String Status = "Signed";
		FilterStatusColumn(Status);
		policy.openExistingPolicy();
		String EditDot = "@xpath=.//*[@id='profile-main']//li[@class='dropdown']";
		if(isVisible(EditDot)==true){
			Report.LogInfo("ElementCheck", "Edit dot element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit dot element not found", "PASS");
		}
		waitForElementToAppear(FolderRefeVievBtn,5);
		verifyMustExists(FolderRefeVievBtn,"View Button");
		click(FolderRefeVievBtn,"View Button");
		if(isVisible(FolderDetailsPopup)==true){
			Report.LogInfo("CheckFolderDetailsPage", "Folder Details pop up displayed", "Pass");
			verifyMustExists(FolderDetailsPopup,"Folder Details Pop up");
			waitForElementToAppear(okbtn,5);
			verifyMustExists(okbtn,"Ok Button");
			click(okbtn,"Ok Button");
		}else{
			Report.LogInfo("CheckFolderDetailsPage", "Folder Details pop up not displayed", "Fail");
		}
		policy.navigationOnRuleTab();
		sleep(3000);
		if(isVisible(AddRuleDropDown)==true){
			Report.LogInfo("ElementCheck", "Add Rule button displayed", "Fail");
		}else{
			Report.LogInfo("ElementCheck", "Add Rule button not displayed", "Pass");
		}
		policy.selectRuleFilter("Schema");
		if(isVisible(EditBtn)==true){
			Report.LogInfo("ElementCheck", "Edit button element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit button element not found", "PASS");
		}	
		refreshPage();
		sleep(2000);
		policy.selectRuleFilter("Compliance Data");
		if(isVisible(EditBtn)==true){
			Report.LogInfo("ElementCheck", "Compilance data Edit button not missing", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Compilance data Edit button missing", "PASS");
		}
		policy.navigationOnPolicyTab();
		sleep(200);
		filterandCheck();
	}

	//************************************END-TC-4325***************************************************************//
	//*****************************************************************************************************************//




	//************************************TC-4327******************************************************************//
	//------------------------------------START--------------------------------------------------------------------//


	public void CompanyAdminPermissionCompanyTypeTPA_4327() throws Exception{
		policy.navigationOnPolicyTab();
		if(isVisible(policy.AddContractBtn)==false){
			Report.LogInfo("ValidateAddContractButon", "Add contract button Missing", "PASS");
		}else{
			Report.LogInfo("ValidateAddContractButon", "Add contract button not Missing", "FAIL");
		}
		String Status = "Signed";
		FilterStatusColumn(Status);
		policy.openExistingPolicy();
		String EditDot = "@xpath=.//*[@id='profile-main']//li[@class='dropdown']";
		if(isVisible(EditDot)==true){
			Report.LogInfo("ElementCheck", "Edit dot element found", "PASS");
			click(EditDot,"Edit Button");
			waitForElementToAppear(policyDetailsEditBtn,5);
			verifyMustExists(policyDetailsEditBtn,"View Button");
			click(policyDetailsEditBtn,"Ok Button");
			waitForElementToAppear(policy.CompanyReference,5);
			verifyMustExists(policy.CompanyReference,"CompanyReference text field");
			sendKeys(policy.CompanyReference,reference,"Company Reference textbox.");
			verifyMustExists(SaveChangesBtn,"Save Changes Button");
			click(SaveChangesBtn,"Save changes Button");
		}else{
			Report.LogInfo("ElementCheck", "Edit dot element not found", "Fail");
		}
		waitForElementToAppear(FolderRefeVievBtn,5);
		verifyMustExists(FolderRefeVievBtn,"View Button");
		click(FolderRefeVievBtn,"View Button");
		if(isVisible(FolderDetailsPopup)==true){
			Report.LogInfo("CheckFolderDetailsPage", "Folder Details pop up displayed", "Pass");
			verifyMustExists(FolderDetailsPopup,"View Button");
			waitForElementToAppear(okbtn,5);
			verifyMustExists(okbtn,"Ok Button");
			click(okbtn,"Ok Button");
		}else{
			Report.LogInfo("CheckFolderDetailsPage", "Folder Details pop up not displayed", "Fail");
		}
		policy.navigationOnRuleTab();
		sleep(2000);
		if(isVisible(AddRuleDropDown)==true){
			Report.LogInfo("ElementCheck", "Add Rule button displayed", "Fail");
		}else{
			Report.LogInfo("ElementCheck", "Add Rule button not displayed", "Pass");
		}
		policy.selectRuleFilter("Schema");
		if(isVisible(EditBtn)==true){
			Report.LogInfo("ElementCheck", "Edit button element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit button element not found", "PASS");
		}	
		refreshPage();
		sleep(2000);
		policy.selectRuleFilter("Compliance Data");
		if(isVisible(EditBtn)==true){
			Report.LogInfo("ElementCheck", "Compilance data Edit button not missing", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Compilance data Edit button missing", "PASS");
		}
		policy.navigationOnPolicyTab();
		sleep(200);
		filterandCheck();
	}

	//************************************END-TC-4327***************************************************************//
	//*****************************************************************************************************************//




	//************************************TC-4328******************************************************************//
	//------------------------------------START--------------------------------------------------------------------//


	public void StandardUserPermissionCompanyTypeTPA_4328() throws Exception{
		policy.navigationOnPolicyTab();
		if(isVisible(policy.AddContractBtn)==false){
			Report.LogInfo("ValidateAddContractButon", "Add contract button Missing", "PASS");
		}else{
			Report.LogInfo("ValidateAddContractButon", "Add contract button not Missing", "FAIL");
		}
		String Status = "Signed";
		FilterStatusColumn(Status);
		policy.openExistingPolicy();
		String EditDot = "@xpath=.//*[@id='profile-main']//li[@class='dropdown']";
		if(isVisible(EditDot)==true){
			Report.LogInfo("ElementCheck", "Edit dot element found", "PASS");
			click(EditDot,"Edit Button");
			waitForElementToAppear(policyDetailsEditBtn,5);
			verifyMustExists(policyDetailsEditBtn,"View Button");
			click(policyDetailsEditBtn,"Ok Button");
			waitForElementToAppear(policy.CompanyReference,5);
			verifyMustExists(policy.CompanyReference,"CompanyReference text field");
			sendKeys(policy.CompanyReference,reference,"Company Reference textbox.");
			verifyMustExists(SaveChangesBtn,"Save Changes Button");
			click(SaveChangesBtn,"Save changes Button");
		}else{
			Report.LogInfo("ElementCheck", "Edit dot element not found", "Fail");
		}
		waitForElementToAppear(FolderRefeVievBtn,5);
		verifyMustExists(FolderRefeVievBtn,"View Button");
		click(FolderRefeVievBtn,"View Button");
		if(isVisible(FolderDetailsPopup)==true){
			Report.LogInfo("CheckFolderDetailsPage", "Folder Details pop up displayed", "Pass");
			verifyMustExists(FolderDetailsPopup,"View Button");
			waitForElementToAppear(okbtn,5);
			verifyMustExists(okbtn,"Ok Button");
			click(okbtn,"Ok Button");
		}else{
			Report.LogInfo("CheckFolderDetailsPage", "Folder Details pop up not displayed", "Fail");
		}
		policy.navigationOnRuleTab();
		sleep(3000);
		if(isVisible(AddRuleDropDown)==true){
			Report.LogInfo("ElementCheck", "Add Rule button displayed", "Fail");
		}else{
			Report.LogInfo("ElementCheck", "Add Rule button not displayed", "Pass");
		}
		policy.selectRuleFilter("Schema");
		if(isVisible(EditBtn)==true){
			Report.LogInfo("ElementCheck", "Schema Edit button not missing", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Schema Edit button missing", "PASS");
		}	
		refreshPage();
		sleep(2000);
		policy.selectRuleFilter("Compliance Data");
		if(isVisible(EditBtn)==true){
			Report.LogInfo("ElementCheck", "Compilance data Edit button not missing", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Compilance data Edit button missing", "PASS");
		}
		policy.navigationOnPolicyTab();
		sleep(200);
		filterandCheck();
	}

	//************************************END-TC-4328***************************************************************//
	//*****************************************************************************************************************//




	//************************************TC-4326******************************************************************//
	//------------------------------------START--------------------------------------------------------------------//


	public void ReadOnlyPermissionForCompanyTypeTPA_4326() throws Exception{
		policy.navigationOnPolicyTab();
		if(isVisible(policy.AddContractBtn)==false){
			Report.LogInfo("ValidateAddContractButon", "Add contract button Missing", "PASS");
		}else{
			Report.LogInfo("ValidateAddContractButon", "Add contract button not Missing", "FAIL");
		}
		String Status = "Signed";
		FilterStatusColumn(Status);
		policy.openExistingPolicy();
		String EditDot = "@xpath=.//*[@id='profile-main']//li[@class='dropdown']";
		if(isVisible(EditDot)==true){
			Report.LogInfo("ElementCheck", "Edit dot element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit dot element not found", "PASS");
		}
		waitForElementToAppear(FolderRefeVievBtn,5);
		verifyMustExists(FolderRefeVievBtn,"View Button");
		click(FolderRefeVievBtn,"View Button");
		if(isVisible(FolderDetailsPopup)==true){
			Report.LogInfo("CheckFolderDetailsPage", "Folder Details pop up displayed", "Pass");
			verifyMustExists(FolderDetailsPopup,"View Button");
			waitForElementToAppear(okbtn,5);
			verifyMustExists(okbtn,"Ok Button");
			click(okbtn,"Ok Button");
		}else{
			Report.LogInfo("CheckFolderDetailsPage", "Folder Details pop up not displayed", "Fail");
		}
		policy.navigationOnRuleTab();
		sleep(3000);
		policy.selectRuleFilter("Schema");
		if(isVisible(EditBtn)==true){
			Report.LogInfo("ElementCheck", "Edit button element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit button element not found", "PASS");
		}
		policy.navigationOnPolicyTab();
		sleep(200);
		filterandCheck();
	}

	//************************************END-TC-4326***************************************************************//
	//*****************************************************************************************************************//





	//************************************TC-4331******************************************************************//
	//------------------------------------START--------------------------------------------------------------------//


	public void ContractCompanyAdminPermissionForCompanyTypeServiceProvider_4331() throws Exception{
		policy.navigationOnPolicyTab();
		if(isVisible(policy.AddContractBtn)==false){
			Report.LogInfo("ValidateAddContractButon", "Add contract button Missing", "PASS");
		}else{
			Report.LogInfo("ValidateAddContractButon", "Add contract button not Missing", "FAIL");
		}
		String Status = "Signed";
		FilterStatusColumn(Status);
		policy.openExistingPolicy();
		String EditDot = "@xpath=.//*[@id='profile-main']//li[@class='dropdown']";
		if(isVisible(EditDot)==true){
			Report.LogInfo("ElementCheck", "Edit dot element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit dot element not found", "PASS");
		}
		waitForElementToAppear(FolderRefeVievBtn,5);
		verifyMustExists(FolderRefeVievBtn,"View Button");
		click(FolderRefeVievBtn,"View Button");
		if(isVisible(FolderDetailsPopup)==true){
			Report.LogInfo("CheckFolderDetailsPage", "Folder Details pop up displayed", "Pass");
			verifyMustExists(FolderDetailsPopup,"View Button");
			waitForElementToAppear(okbtn,5);
			verifyMustExists(okbtn,"Ok Button");
			click(okbtn,"Ok Button");
		}else{
			Report.LogInfo("CheckFolderDetailsPage", "Folder Details pop up not displayed", "Fail");
		}
		policy.navigationOnRuleTab();
		sleep(3000);
		if(isVisible(AddRuleDropDown)==true){
			Report.LogInfo("ElementCheck", "Add Rule button displayed", "Fail");
		}else{
			Report.LogInfo("ElementCheck", "Add Rule button not displayed", "Pass");
		}
		policy.selectRuleFilter("Schema");
		if(isVisible(EditBtn)==true){
			Report.LogInfo("ElementCheck", "Edit button element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit button element not found", "PASS");
		}	
		refreshPage();
		sleep(2000);
		policy.selectRuleFilter("Compliance Data");
		if(isVisible(EditBtn)==true){
			Report.LogInfo("ElementCheck", "Compilance data Edit button not missing", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Compilance data Edit button missing", "PASS");
		}
		policy.navigationOnPolicyTab();
		sleep(200);
		filterandCheck();
	}

	//************************************END-TC-4331***************************************************************//
	//*****************************************************************************************************************//




	//************************************TC-4332******************************************************************//
	//------------------------------------START--------------------------------------------------------------------//


	public void StandardUserPermissionForCompanyTypeServiceProvider_4332() throws Exception{
		policy.navigationOnPolicyTab();
		if(isVisible(policy.AddContractBtn)==false){
			Report.LogInfo("ValidateAddContractButon", "Add contract button Missing", "PASS");
		}else{
			Report.LogInfo("ValidateAddContractButon", "Add contract button not Missing", "FAIL");
		}
		String Status = "Signed";
		FilterStatusColumn(Status);
		policy.openExistingPolicy();
		String EditDot = "@xpath=.//*[@id='profile-main']//li[@class='dropdown']";
		if(isVisible(EditDot)==true){
			Report.LogInfo("ElementCheck", "Edit dot element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit dot element not found", "PASS");
		}
		waitForElementToAppear(FolderRefeVievBtn,5);
		verifyMustExists(FolderRefeVievBtn,"View Button");
		click(FolderRefeVievBtn,"View Button");
		if(isVisible(FolderDetailsPopup)==true){
			Report.LogInfo("CheckFolderDetailsPage", "Folder Details pop up displayed", "Pass");
			verifyMustExists(FolderDetailsPopup,"View Button");
			waitForElementToAppear(okbtn,5);
			verifyMustExists(okbtn,"Ok Button");
			click(okbtn,"Ok Button");
		}else{
			Report.LogInfo("CheckFolderDetailsPage", "Folder Details pop up not displayed", "Fail");
		}
		policy.navigationOnRuleTab();
		sleep(3000);
		if(isVisible(AddRuleDropDown)==true){
			Report.LogInfo("ElementCheck", "Add Rule button displayed", "Fail");
		}else{
			Report.LogInfo("ElementCheck", "Add Rule button not displayed", "Pass");
		}
		policy.selectRuleFilter("Schema");
		if(isVisible(EditBtn)==true){
			Report.LogInfo("ElementCheck", "Edit button element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit button element not found", "PASS");
		}	
		refreshPage();
		sleep(2000);
		policy.selectRuleFilter("Compliance Data");
		if(isVisible(EditBtn)==true){
			Report.LogInfo("ElementCheck", "Compilance data Edit button not missing", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Compilance data Edit button missing", "PASS");
		}
		policy.navigationOnPolicyTab();
		sleep(200);
		filterandCheck();
	}

	//************************************END-TC-4332***************************************************************//
	//*****************************************************************************************************************//



	//************************************TC-4333******************************************************************//
	//------------------------------------START--------------------------------------------------------------------//


	public void ReadOnlyPermissionForCompanyTypeServiceProvider_4333() throws Exception{
		policy.navigationOnPolicyTab();
		if(isVisible(policy.AddContractBtn)==false){
			Report.LogInfo("ValidateAddContractButon", "Add contract button Missing", "PASS");
		}else{
			Report.LogInfo("ValidateAddContractButon", "Add contract button not Missing", "FAIL");
		}
		String Status = "Signed";
		FilterStatusColumn(Status);
		policy.openExistingPolicy();
		String EditDot = "@xpath=.//*[@id='profile-main']//li[@class='dropdown']";
		if(isVisible(EditDot)==true){
			Report.LogInfo("ElementCheck", "Edit dot element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit dot element not found", "PASS");
		}
		waitForElementToAppear(FolderRefeVievBtn,5);
		verifyMustExists(FolderRefeVievBtn,"View Button");
		click(FolderRefeVievBtn,"View Button");
		if(isVisible(FolderDetailsPopup)==true){
			Report.LogInfo("CheckFolderDetailsPage", "Folder Details pop up displayed", "Pass");
			verifyMustExists(FolderDetailsPopup,"View Button");
			waitForElementToAppear(okbtn,5);
			verifyMustExists(okbtn,"Ok Button");
			click(okbtn,"Ok Button");
		}else{
			Report.LogInfo("CheckFolderDetailsPage", "Folder Details pop up not displayed", "Fail");
		}
		policy.navigationOnRuleTab();
		sleep(3000);
		if(isVisible(AddRuleDropDown)==true){
			Report.LogInfo("ElementCheck", "Add Rule button displayed", "Fail");
		}else{
			Report.LogInfo("ElementCheck", "Add Rule button not displayed", "Pass");
		}
		policy.selectRuleFilter("Schema");
		if(isVisible(EditBtn)==true){
			Report.LogInfo("ElementCheck", "Edit button element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit button element not found", "PASS");
		}	
		refreshPage();
		sleep(2000);
		policy.selectRuleFilter("Compliance Data");
		if(isVisible(EditBtn)==true){
			Report.LogInfo("ElementCheck", "Compilance data Edit button not missing", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Compilance data Edit button missing", "PASS");
		}
		policy.navigationOnPolicyTab();
		sleep(200);
		filterandCheck();
	}

	//************************************END-TC-4333***************************************************************//
	//*****************************************************************************************************************//


	//************************************TC-4335******************************************************************//
	//------------------------------------START--------------------------------------------------------------------//


	public void ContractReadOnlyPermissionForCompanyTypeBroker_4335() throws Exception{
		policy.navigationOnPolicyTab();
		if(isVisible(policy.AddContractBtn)==false){
			Report.LogInfo("ValidateAddContractButon", "Add contract button Missing", "PASS");
		}else{
			Report.LogInfo("ValidateAddContractButon", "Add contract button not Missing", "FAIL");
		}
		String Status = "Signed";
		FilterStatusColumn(Status);
		policy.openExistingPolicy();
		String EditDot = "@xpath=.//*[@id='profile-main']//li[@class='dropdown']";
		if(isVisible(EditDot)==true){
			Report.LogInfo("ElementCheck", "Edit dot element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit dot element not found", "PASS");
		}
		waitForElementToAppear(FolderRefeVievBtn,5);
		verifyMustExists(FolderRefeVievBtn,"View Button");
		click(FolderRefeVievBtn,"View Button");
		if(isVisible(FolderDetailsPopup)==true){
			Report.LogInfo("CheckFolderDetailsPage", "Folder Details pop up displayed", "Pass");
			verifyMustExists(FolderDetailsPopup,"View Button");
			waitForElementToAppear(okbtn,5);
			verifyMustExists(okbtn,"Ok Button");
			click(okbtn,"Ok Button");
		}else{
			Report.LogInfo("CheckFolderDetailsPage", "Folder Details pop up not displayed", "Fail");
		}
		policy.navigationOnRuleTab();
		sleep(3000);
		if(isVisible(AddRuleDropDown)==true){
			Report.LogInfo("ElementCheck", "Add Rule button displayed", "Fail");
		}else{
			Report.LogInfo("ElementCheck", "Add Rule button not displayed", "Pass");
		}
		policy.selectRuleFilter("Schema");
		if(isVisible(EditBtn)==true){
			Report.LogInfo("ElementCheck", "Schema Edit button not missing", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Schema Edit button missing", "PASS");
		}	
		refreshPage();
		sleep(2000);
		policy.selectRuleFilter("Compliance Data");
		if(isVisible(EditBtn)==true){
			Report.LogInfo("ElementCheck", "Compilance data Edit button not missing", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Compilance data Edit button missing", "PASS");
		}
		policy.navigationOnPolicyTab();
		sleep(200);
		filterandCheck();
	}	

	//********************************TC-4335-END*******************************************************************//
	//---------------------------------------------------------------------------------------------------------------//




	//************************************TC-4148******************************************************************//
	//------------------------------------START--------------------------------------------------------------------//

	public void CompanyAdminPermissionCompanyTypeBroker_4148() throws Exception{

		policy.addPolicy();
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();

		//step 4,5,6
		EditDetailsVerify();

		policy.navigationOnRuleTab();
		policy.selectRuleFilter("Schema");
		String Editbtn = "@xpath=//tr[1]//button[@ng-click='editClick(1)']";
		if(isVisible(Editbtn)==true){
			Report.LogInfo("ElementCheck", "Edit button element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit button element not found", "PASS");
		}

		refreshPage();
		policy.selectRuleFilter("Compliance Data");
		if(isVisible(Editbtn)==true){
			Report.LogInfo("ElementCheck", "Edit button element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit button element not found", "PASS");
		}

		homePage.adminMenu();
		datasetReferenceData.DatasetReferenceDataLink();
		sleep(2000);

		if(isVisible(datasetReferenceData.AddDatasetReferenceDataBtn)==false){
			Report.LogInfo("ElementCheck", "Add Data set Reference Data Btn not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Add Data set Reference Data Btn available", "FAIL");
		}

		if(isVisible(RefRecord)==true){
			verifyExists(RefRecord,"Referance record");
			click(RefRecord,"Referance record");
			sleep(2000);

			datasetReferenceData.selectMappingsTab();
			sleep(2000);
			if(isVisible(datasetReferenceData.NewMappingBtn)==false){
				Report.LogInfo("ElementCheck", "Add mapping Btn not available", "PASS");
			}else{
				Report.LogInfo("ElementCheck", "Add mapping Btn available", "FAIL");
			}
			String Norcrd = "@xpath=.//*[@id='grid']//tbody[@role='rowgroup']//tr[1]//td[text()='No result returned']";

			if(isVisible(Norcrd)==false){
				if(isVisible(compny.Deactivatebtn)==true){
					waitForElementToAppear(compny.Deactivatebtn,5);
					verifyExists(compny.Deactivatebtn,"Deactivate Button");
					click(compny.Deactivatebtn,"Deactivate Button");
				}else{			
					verifyExists(compny.Activatebtn,"Activate Button");
					click(compny.Activatebtn,"Activate Button");
				}

				if(isVisible(compny.Activatebtn)==true){
					waitForElementToAppear(compny.Activatebtn,5);
					verifyExists(compny.Activatebtn,"Activate Button");
					click(compny.Activatebtn,"Activate Button");
				}else{			
					verifyExists(compny.Deactivatebtn,"Deactivate Button");
					click(compny.Deactivatebtn,"Deactivate Button");
				}
			}else{
				Report.LogInfo("ElementCheck", "Record is not available", "PASS");
			}
		}else{
			Report.LogInfo("ElementCheck", "Record is not available", "PASS");
		}
		sleep(2000);
		homePage.adminMenu();
		sleep(2000);
		if(isVisible(exchange.RateOfExchangeLink)==false){
			Report.LogInfo("ElementCheck", "Rate of exchange not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Rate of exchange available", "FAIL");
		}

	}

	//********************************TC-4148-END*******************************************************************//
	//---------------------------------------------------------------------------------------------------------------//


	//************************************TC-4149******************************************************************//
	//------------------------------------START--------------------------------------------------------------------//

	public void StandardUserPermissionCompanyTypeBroker_4149() throws Exception{

		policy.addPolicy();
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		
		//step 4,5,6
		EditDetailsVerify();
		policy.navigationOnRuleTab();
		policy.selectRuleFilter("Schema");
		String Editbtn = "@xpath=//tr[1]//button[@ng-click='editClick(1)']";
		if(isVisible(Editbtn)==true){
			Report.LogInfo("ElementCheck", "Edit button element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit button element not found", "PASS");
		}
		
		refreshPage();
		policy.selectRuleFilter("Compliance Data");
		if(isVisible(Editbtn)==true){
			Report.LogInfo("ElementCheck", "Edit button element found", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Edit button element not found", "PASS");
		}

		policy.navigationOnPolicyTab();
		filterandCheck();

	}

	//********************************TC-4149-END*******************************************************************//
	//---------------------------------------------------------------------------------------------------------------//






	//***********************************************************************************************************************//
	//**********************************************************************************************************************//
	//***************************************************************************************************************************//

	//*****************************************Reusable Functions***************************************************//

	public String getCurrentTime(){


		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmssSS");
		String strDate = sdf.format(cal.getTime());
		//System.out.println("Current date in String Format: "+strDate); 
		return strDate;
	}

	//*************TC-4335-Reusable Methods**********************************//
	public void FilterStatusColumn(String status){
		Actions action = new Actions(webDriver);
		WebElement Status = findWebElement(StatusTab);
		action.moveToElement(Status).build().perform();
		String StatusFilterSignedCheckBox= "@xpath=//input[@value='"+status+"']";
		waitForElementToAppear(StatusFilterIcon,5);
		verifyMustExists(StatusFilterIcon,"StatusFilterIcon");
		click(StatusFilterIcon,"StatusFilterIcon");
		waitForElementToAppear(StatusFilterTextSearch,5);
		verifyMustExists(StatusFilterTextSearch,"StatusFilterTextSearch");
		sendKeys(StatusFilterTextSearch,status,"Entered Status");
		waitForElementToAppear(StatusFilterSignedCheckBox,5);
		verifyMustExists(StatusFilterSignedCheckBox,"StatusFilterSignedCheckBox");
		click(StatusFilterSignedCheckBox,"StatusFilterSignedCheckBox");
		waitForElementToAppear(StatusFilterButton,5);
		verifyMustExists(StatusFilterButton,"StatusFilterButton");
		click(StatusFilterButton,"StatusFilterButton");		
	}	

	public void applyFilterPolicy2(String PolicyNumber) throws InterruptedException{

		int i=0;
		String RecordCheckbox ="@css=[value='"+PolicyNumber+"']";

		//waitForElementToAppear(PolicyHome,5);
		//verifyMustExists(PolicyHome,"Policy Link");
		//click(PolicyHome,"Policy Link");
		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(PolicyReferenceFilterIcon1, "Policy Reference Filter Icon");
			sleep(2000);
			if(isVisible(PolicyRefSearchText))
			{
				verifyMustExists(PolicyRefSearchText,"Search Filter Textbox");	
				sendKeys(PolicyRefSearchText,PolicyNumber,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);

		click(RecordCheckbox, "Searched Record Checkbox");
		verifyMustExists(StatusFilterButtonPolyRef,"Filter Button");
		click(StatusFilterButtonPolyRef,"Filter Button");
		sleep(3000);
	}

	public void ValidateEditOptionBySlectingSignedPolicy(){
		waitForElementToAppear(SelectedSignedStausPolicy,5);
		verifyMustExists(SelectedSignedStausPolicy,"SelectedSignedStausPolicy");
		click(SelectedSignedStausPolicy,"SelectedSignedStausPolicy");
		if(isVisible(KebabEditIcon)==true){
			Report.LogInfo("ValidateEditKebabDotsButton", "Edit option is not hidden", "FAIL");	
		}else{
			Report.LogInfo("ValidateEditKebabDotsButton", "Edit option is hidden", "PASS");
		}		
	}	

	public void ValidateEditOptionBySlectingSignedPolicy1(){
		waitForElementToAppear(SelectedSignedStausPolicy1,5);
		verifyMustExists(SelectedSignedStausPolicy1,"SelectedSignedStausPolicy");
		click(SelectedSignedStausPolicy1,"SelectedSignedStausPolicy");
		if(isVisible(KebabEditIcon)==true){
			Report.LogInfo("ValidateEditKebabDotsButton", "Edit option is not hidden", "FAIL");	
		}else{
			Report.LogInfo("ValidateEditKebabDotsButton", "Edit option is hidden", "PASS");
		}		
	}

	public void validateEditOptionOnAboutPage(){
		if(isVisible(BrokerLinkOnDetailsPage)==true){
			//waitForElementToAppear(BrokerLinkOnDetailsPage,5);
			verifyExists(BrokerLinkOnDetailsPage,"BrokerLinkOnDetailsPage");
			click(BrokerLinkOnDetailsPage,"BrokerLinkOnDetailsPage");
			if(isVisible(BrokerLinkErrorMessage)==true){
				Report.LogInfo("ValidateAboutMePage", "BrokerLink is not configured for selected policy", "FAIL");
				goBack();

			}else{
				verifyMustExists(AboutMeLink,"AboutMeLink");
				if(isVisible(KebabEditIcon)==true){
					Report.LogInfo("ValidateEditKebabDotsButton", "Edit option is not hidden", "FAIL");	
				}else{
					Report.LogInfo("ValidateEditKebabDotsButton", "Edit option is hidden", "PASS");
				}		    	 
				//JavascriptExecutor jse = (JavascriptExecutor)webDriver;
				//jse.executeScript("window.scrollBy(0,-250)", "");
			}
		}			
	}

	public void NavigateClaimsAuthority(){
		waitForElementToAppear(ClaimsAuthorityLink,5);
		verifyMustExists(ClaimsAuthorityLink,"ClaimsAuthorityLink");
		click(ClaimsAuthorityLink,"ClaimsAuthorityLink");		
	}	

	public void NavigateAdditionalTab(){
		waitForElementToAppear(AdditionalTab,5);
		verifyMustExists(AdditionalTab,"AdditionalTab");
		click(AdditionalTab,"AdditionalTab");
	}


	public void NavigateCompanySpecificTab(){
		if(isVisible(CompanySpecificTab)==true){
			Report.LogInfo("ValidateCompanySpecificTab", "Company Specific Tab is present for this selected policy", "PASS");
			verifyMustExists(CompanySpecificTab,"CompanySpecificTab");
			click(CompanySpecificTab,"CompanySpecificTab");
		}else{
			Report.LogInfo("ValidateCompanySpecificTab", "Company Specific Tab is not present for this selected policy", "FAIL");
		}		
	}	

	public void NavigateRolesTab(){
		waitForElementToAppear(RolesTab,5);
		verifyMustExists(RolesTab,"RolesTab");
		click(RolesTab,"RolesTab");		
	}	

	public void NavigateReportingChannelsTab(){
		waitForElementToAppear(ReportingChannelsTab,5);
		verifyMustExists(ReportingChannelsTab,"ReportingChannelsTab");
		click(ReportingChannelsTab,"ReportingChannelsTab");			
	}	

	public void ValidateAddReportingChannelBtn(){

		if (isVisible(AddReportingChannelBtn)==false){
			Report.LogInfo("ValidateAddReportingChannelBtn", "AddReportingChannel Button is hidden", "PASS");
		}else{
			Report.LogInfo("ValidateAddReportingChannelBtn", "AddReportingChannel Button is not hidden", "FAIL");
		}
	}	

	public void NavigateFilesTab(){
		waitForElementToAppear(NavigateFilesTab,5);
		verifyMustExists(NavigateFilesTab,"NavigateFilesTab");
		click(NavigateFilesTab,"NavigateFilesTab");
	}	

	public void ValidateAddFileButton(){
		if (isVisible(AddFileBtn)==false){
			Report.LogInfo("ValidateAddFileBtn", "AddFile Button is hidden", "PASS");
		}else{
			Report.LogInfo("ValidateAddFileBtn", "AddFile Button is not hidden", "FAIL");
		}
	}	

	public void NavigateToSection1(){
		waitForElementToAppear(NavigateSection1,5);
		verifyMustExists(NavigateSection1,"NavigateSection1");
		click(NavigateSection1,"NavigateSection1");
	}	

	public void ValidateSection1EditIcon(){
		if (isVisible(KebabIconSection1)==false){
			Report.LogInfo("ValidateKebabIconSection1", "Section 1 edit icon hidden", "PASS");
		}else{
			Report.LogInfo("ValidateKebabIconSection1", "Section 1 edit icon not hidden", "FAIL");
		}		
	}	

	public void NavigateMarketsTab(){
		waitForElementToAppear(MarketsTab,5);
		verifyMustExists(MarketsTab,"MarketsTab");
		click(MarketsTab,"MarketsTab");
	}	

	public void selectionEntriesOfMarket(){
		if(isVisible(NoDataFound)==false){
			waitForElementToAppear(EntriesMarketsTab,5);
			verifyMustExists(EntriesMarketsTab,"EntriesOfRiskCodeTab");	
		}else{
			Report.LogInfo("ValidateRecordEntries", "No Record Found", "PASS");
		}
		sleep(2000);
	}	

	public void NavigateRiskCode(){
		waitForElementToAppear(RiskCodeTab,5);
		verifyMustExists(RiskCodeTab,"RiskCodeTab");
		click(RiskCodeTab,"RiskCodeTab");		
	}	

	public void SelctionEntriesOfRiskCode(){
		if(isVisible(NoDataFound)==false){
			waitForElementToAppear(EntriesOfRiskCodeTab,5);
			verifyMustExists(EntriesOfRiskCodeTab,"EntriesOfRiskCodeTab");	
		}else{
			Report.LogInfo("ValidateRecordEntries", "No Record Found", "PASS");
		}
		sleep(2000);
	}	

	public void NavigateOnLocationAndValidate(){
		WebElement location = findWebElement(LocationTab);

		if(location.isEnabled()==true){
			Report.LogInfo("ValidateLocationTab", "Location button is enabled", "PASS");
			verifyMustExists(LocationTab,"LocationTab");
			click(LocationTab,"LocationTab");
		}else{
			Report.LogInfo("ValidateLocationTab", "Location button is not enabled", "FAIL");
		}		
	}	

	public void NavigateRulesTab(){
		waitForElementToAppear(RulesTabContactMenu,5);
		verifyMustExists(RulesTabContactMenu,"RulesTabContactMenu");
		click(RulesTabContactMenu,"RulesTabContactMenu");		
	}

	public void ValidateAddRuleButton(){
		if (isVisible(AddRuleButtonContractMenu)==false){
			Report.LogInfo("ValidateAddRuleButton", "AddRule Button hidden", "PASS");
		}else{
			Report.LogInfo("ValidateAddRuleButton", "AddRule Button not hidden", "FAIL");
		}
		sleep(2000);
	}	

	public void ValidateEditButtonReportingChannel(){
		if (isVisible(EditButtonReportingChannel)==false){
			Report.LogInfo("ValidateEditButtonReportingChannel", "Edit button is hidden", "PASS");
		}else{
			Report.LogInfo("ValidateEditButtonReportingChannel", "Edit Button is not hidden", "FAIL");
		}
	}
	//*********************************************************************************//

	public void EditDetailsVerify(){
		waitForElementToAppear(EditDot,5);
		verifyExists(EditDot,"Edit dots");
		click(EditDot,"Edit dots");

		waitForElementToAppear(EditBtn,5);
		verifyExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");

		waitForElementToAppear(FolderRefernce,5);
		verifyExists(FolderRefernce,"Folder referance button");
		click(FolderRefernce,"Folder referance button");

		waitForElementToAppear(FolderDetails,5);
		verifyExists(FolderDetails,"Folder Details pop up");
		click(FolderDetails,"Folder Details pop up");

		waitForElementToAppear(OkbtnFolderDeatls,5);
		verifyExists(OkbtnFolderDeatls,"Ok Folder Details button");
		click(OkbtnFolderDeatls,"Ok Folder Details button");
	}

	public void filterandCheck(){
		int i=0;
		String RecordCheckbox ="@css=[value='433716QA']";
		waitForElementToAppear(Br.PolicyReferenceFilterIcon,5);
		for( i= 0; i<=5; i++)
		{
		sleep(2000);
		click(Br.PolicyReferenceFilterIcon, "Policy Reference Filter Icon");
		sleep(3000);
		if(isVisible(Br.SearchText)==true)
		{
			break;
		}
		}
		if(isVisible(Br.SearchText))
		{
			verifyMustExists(Br.SearchText,"Search Filter Textbox");	
			sendKeys(Br.SearchText,"433716QA","Search Filter Textbox.");
			sleep(2000);

			if(isVisible(RecordCheckbox)==true){
				Report.LogInfo("StatusCheck", "433716QA record is available", "FAIL");
			}else{
				Report.LogInfo("StatusCheck", "433716QA record is not available", "PASS");
			}
		}else{
			Report.LogInfo("ElementCheck", "Search textbox is not available", "FAIL");
		}
	}
}
