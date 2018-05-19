package com.tide.qa.pagefactory;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;

public class CompanyPermissionPage extends PageBase{
	LoginPage loginPage = new LoginPage();
	CompanyPage Compny = new CompanyPage();
	PolicyPage policy = new PolicyPage();
	HomePage homePage = new HomePage();

	BordereauQuePage BQPage = new BordereauQuePage();

	BordereauProcessPage BordereauProcess = new BordereauProcessPage();
	ContractMetadataPage ConMeta = new ContractMetadataPage();
	DatasetReferenceDataPage DRD = new DatasetReferenceDataPage();
	RateOfExchangePage REX = new RateOfExchangePage();
	TasksPage Task = new TasksPage();
	DatasetReferenceDataPage DR = new DatasetReferenceDataPage();

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

	String CompanyReferenceval = "Automation Policy1"+getCurrentDateTimeMS();
	String ContractAdminName ="Aspen Managing Agency Limited - 4711";

	public static final String ContractFstRcd = "@xpath=.//*[@id='grid']//tr[1]//td//span[@ng-bind='dataItem.FolderRandomNumber']";
	public static final String Coverholder = "@xpath=.//*[@id='profile-main']//dl[1]//dd//a[contains(@data-ui-sref,'app.division.about')]";
	public static final String CoverholderPage = "@xpath=.//*[@id='profile-main']//div[@class='card-header']";
	public static final String Broker = "@xpath=.//*[@id='profile-main']//dl[3]//dd//a[contains(@data-ui-sref,'app.division.about')]";
	public static final String CompanyDetails = "@linkText=Company Detail";
	public static final String CompanyDetailsPage = "@xpath=.//*[@id='content']//div[@class='card']//div[@class='card-header']";
	public static final String EditDots = "@xpath=.//*[@id='profile-main']//li/a[@class='dropdown-toggle']";
	public static final String Editlink = "@xpath=.//*[@id='profile-main']//li/ul";
	public static final String CountryDrp = "@xpath=//*[@ng-model='companyData.Country']//preceding-sibling::span";
	public static final String CountryDrpVal = "@xpath=//*[@class='k-animation-container']//ul//li[text()='India']";
	public static final String SaveChangesbtn = "@xpath=//button[@ng-click='update()']";
	public static final String BackCom = "@xpath=.//*[@id='content']//div[@ng-click='BackToCompany()']";
	//-------------------------------------------------------- ---------------------------------------------------------------------//
	public static final String ContractAdministratorFstRcd = "@xpath=//*[@id='grid']//tr[1]//td//span[@ng-bind='dataItem.BrokerCompanyIdString']";
	

	public void CompanyPermissionTideAdmin_4050() throws Exception{
		Compny.addCompany();
		Compny.editCompany();
		Compny.addDivision();
		Compny.editDivision();
		Compny.addNewSubDivision();
		Compny.editSubDivision();
		Compny.addNewUserForCompany();
		if(isVisible(Compny.EditSelectedUserLink)==true){
			Compny.editNewUser();
		}else{
			Report.LogInfo("ElementCheck", "User is not available for edit", "FAIL");
		}
		Compny.addUserToDivision();
		Compny.removeAddedUserToDivision();
		Compny.addUserToSubDivision();
		Compny.removeUserToSubDivision();
		Compny.Edit_UserProfile_Of_User_4062();
	}

	public void CompanyUserComAdmin_4051() throws Exception{
		homePage.adminMenu();
		NavigateCompanyDetails();
		waitForElementToAppear(CompanyDetailsPage,5);
		verifyMustExists(CompanyDetailsPage,"Contract first record");
		OpenDetailInEditmode();		
		Compny.NavigateToDivision();
		Compny.openExistingDivisionWithIsLloyds();
		Compny.BackToComBtn();
		Compny.NavigateToDivision();
		Compny.openExistingDivisionWithIsLloydsNo();
		Compny.navigationOnUserTab();
		Compny.createNewUserUnderDivisionPermission();//remove navigation needed
		Compny.removeAddedUserToExistingDivision();
		Compny.addNewSubDivision1();
		Compny.navigationOnSubDivision();
		Compny.openRecordInEditModeSubDivision();
		Compny.EditSubDivisionFields();
		Compny.SaveAndVerifyEditOperationSubDivision();
		JavascriptExecutor jse1 = (JavascriptExecutor)webDriver;
		jse1.executeScript("scroll(0, -250);");
		waitForElementToAppear(BackCom,5);
		verifyMustExists(BackCom,"Back To Company Button");
		javaScriptclick(BackCom,"Back To Company Button");
		Compny.NavigateToDivision();
		Compny.openExistingDivision();
		Compny.navigationOnUserTab();
		Compny.createNewUserUnderDivisionPermission();
		Compny.removeAddedUserToExistingDivision();
		Compny.navigationOnUserTab();
		Compny.addNewUserForCompany1();
		//goBack();
		if(isVisible(Compny.UserTab)==false){
			goBack();
		}
		Compny.navigationOnUserTab();

		Compny.activateNewUser();
		Compny.deactivateNewUser();
		Compny.Edit_UserProfile_Of_User_4062();
		policy.navigationOnPolicyTab();
		OpenFirstContract();
		//OpenCoverHolder();
		OpenBroker();
		
	}

	public void CompanyStandardUser_4052() throws Exception{
		policy.navigationOnPolicyTab();
		OpenFirstContract();		
		OpenCoverHolder();
		OpenBroker();		
		if (isVisible(Compny.StandardUserProfile))
		{Compny.StandardUserProfile();
		}
		else
		{Compny.ReadOnlyUserProfile();
		}
		
		Compny.BackToComBtn();
		Compny.NavigateToDivision();
		if(isVisible(Compny.Add_new_Division_Button)==true){
			Report.LogInfo("ElementCheck", "Add_new_Division_Button available", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add_new_Division_Button not available", "PASS");
		}
		
		Compny.openExistingDivisionWithIsLloyds();
		Compny.navigationOnUserTab();
		if(isVisible(Compny.AddNewUserButton)==true){
			Report.LogInfo("ElementCheck", "AddNewUserButton available", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "AddNewUserButton not available", "PASS");
		}
		Compny.openExistingUser();
		
		Compny.BackToComBtn();
		Compny.navigationOnSubDivision();
		if(isVisible(Compny.Add_New_SubDivision_Button)==true){
			Report.LogInfo("ElementCheck", "Add_New_SubDivision_Button available", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Add_New_SubDivision_Button not available", "PASS");
		}
		
		Compny.selectExistingSubDivision();
		Compny.VerifyEditBtnHidden();
		Compny.navigationOnUserTab();
		//Select existing user		
		Compny.openExistingUserFromDivision();
		Compny.BackToComBtn();
		Compny.navigationOnUserTab();
		if(isVisible(Compny.AddNewUserButton)==true){
			Report.LogInfo("ElementCheck", "AddNewUserButton available", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "AddNewUserButton not available", "PASS");
		}
		policy.navigationOnPolicyTab();
		Compny.applyContractAdministratorFilter(ContractAdminName);
		OpenFirstContractAdmini();
		OpenCoverHolder1();
		OpenBroker1();
	}

	public void CompanyReadOnlyUser_4053() throws Exception{
		//Run TC4052
		CompanyStandardUser_4052();
		
	}

	public void CompanyAdminNotUser_4054() throws Exception{
		policy.navigationOnPolicyTab();
		OpenFirstContract();
		OpenCoverHolder();
		OpenBroker();
	}

	public void CompanyStandardUser_4055() throws Exception{
		policy.navigationOnPolicyTab();
		OpenFirstContract();		
		OpenCoverHolder();
		OpenBroker();
		homePage.adminMenu();
	}

	public void CompanyReadOnlyUser_4056() throws Exception{
		policy.navigationOnPolicyTab();
		OpenFirstContract();		
		OpenCoverHolder();
		OpenBroker();
		if(isVisible(homePage.adminDropdown)==false){
			Report.LogInfo("ElementCheck", "Admin tab not display", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Admin tab display", "FAIL");
		}
	}

	//--------------------------------------------------------------------------------------------------------------------------------------------//	
	//------------------------------------------------------- Reusable functions -----------------------------------------------------------------//
	//--------------------------------------------------------------------------------------------------------------------------------------------//	

	public String getCurrentTime(){


		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmssSS");
		String strDate = sdf.format(cal.getTime());
		//System.out.println("Current date in String Format: "+strDate); 
		return strDate;
	}	

	public void OpenFirstContract(){
		if(isVisible(ContractFstRcd)==true){
			waitForElementToAppear(ContractFstRcd,5);
			verifyMustExists(ContractFstRcd,"Contract first record");
			click(ContractFstRcd,"Contract first record");
		}
	}

	public void OpenCoverHolder(){
		if(isVisible(Coverholder)==true){
			waitForElementToAppear(Coverholder,5);
			verifyMustExists(Coverholder,"Cover holder value");
			click(Coverholder,"Cover holder value");
			if(isVisible(CoverholderPage)==true){
				Report.LogInfo("ElementCheck", "Cover holder page display", "PASS");
				goBack();
			}else{
				Report.LogInfo("ElementCheck", "Cover holder page not display", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "Cover holder link not available for contract", "PASS");
		}
	}

	public void OpenBroker(){
		if(isVisible(Broker)==true){
			waitForElementToAppear(Broker,5);
			verifyMustExists(Broker,"Cover holder value");
			click(Broker,"Cover holder value");
			if(isVisible(CoverholderPage)==true){
				Report.LogInfo("ElementCheck", "Cover holder page display", "PASS");
				goBack();
			}else{
				Report.LogInfo("ElementCheck", "Cover holder page not display", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "Cover holder link not available for contract", "PASS");
		}
	}

	public void NavigateCompanyDetails(){		
		if(isVisible(CompanyDetails)==true){
			waitForElementToAppear(CompanyDetails,5);
			verifyMustExists(CompanyDetails,"Comapny details");
			click(CompanyDetails,"Comapny details");
		}
	}

	public void OpenDetailInEditmode(){
		if(isVisible(EditDots)==true){
			verifyMustExists(EditDots,"Edit dots");
			click(EditDots,"Edit dots");
			waitForElementToAppear(Editlink,5);
			verifyMustExists(Editlink,"Edit link");
			click(Editlink,"Edit link");
		}
	}

	public void CountryUpdateNdSave(){
		waitForElementToAppear(CountryDrp,5);
		verifyMustExists(CountryDrp,"Country dropdown");
		click(CountryDrp,"Country dropdown");
		sleep(1500);
		waitForElementToAppear(CountryDrpVal,5);
		verifyMustExists(CountryDrpVal,"Country dropdown");
		click(CountryDrpVal,"Country dropdown");		
		waitForElementToAppear(SaveChangesbtn,5);
		verifyMustExists(SaveChangesbtn,"Country dropdown");
		click(SaveChangesbtn,"Country dropdown");
	}
	public void OpenCoverHolder1(){
		if(isVisible(Coverholder)==true){
			waitForElementToAppear(Coverholder,5);
			verifyMustExists(Coverholder,"Cover holder value");
			click(Coverholder,"Cover holder value");
			if(isVisible(CoverholderPage)==true){
				Report.LogInfo("ElementCheck", "Cover holder page display", "PASS");
				Compny.VerifyEditBtnHidden();
				goBack();
			}else{
				Report.LogInfo("ElementCheck", "Cover holder page not display", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "Cover holder link not available for contract", "PASS");
		}
	}

	public void OpenBroker1(){
		if(isVisible(Broker)==true){
			waitForElementToAppear(Broker,5);
			verifyMustExists(Broker,"Cover holder value");
			click(Broker,"Cover holder value");
			if(isVisible(CoverholderPage)==true){
				Report.LogInfo("ElementCheck", "Cover holder page display", "PASS");
				Compny.VerifyEditBtnHidden();
				goBack();
			}else{
				Report.LogInfo("ElementCheck", "Cover holder page not display", "FAIL");
			}
		}else{
			Report.LogInfo("ElementCheck", "Cover holder link not available for contract", "PASS");
		}
	}
	public void OpenFirstContractAdmini(){
		if(isVisible(ContractAdministratorFstRcd)==true){
			waitForElementToAppear(ContractAdministratorFstRcd,5);
			verifyMustExists(ContractAdministratorFstRcd,"Contract Administrator first record");
			click(ContractAdministratorFstRcd,"Contract Administrator first record");
		}
	}

}