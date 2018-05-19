package com.tide.qa.pagefactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.jprotractor.NgBy;
import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;

public class CompanyPage extends PageBase
{
	String path;
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
	}
	ReadExcelFile rd = new ReadExcelFile();

	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("ddMMssMs");
		String datetime = ft.format(dNow);
		return datetime;
	}
	String CompanyName1= "Allied World Managing Agency Limited";
	String CompanyName = "Systenics1"+getCurrentDateTimeMS();
	static String DivisionName = "Systenics INC"+getCurrentDateTimeMS();
	String DivisionRef = "Automation"+getCurrentDateTimeMS();
	String SubDivision = "Systenics Sub Division"+getCurrentDateTimeMS();
	String SubDivisionRef = "Systenics Sub Division"+getCurrentDateTimeMS();

	String UserEmail ="tboult1"+getCurrentDateTimeMS()+"@gmail.com";

	String expRefTitle = "Manual Testing";
	String expAddress1 = "Pune";
	String expCity = "Satara";
	String expPostalCode = "542211";
	String expState = "Goa";
	String expTelNo = "8586552455";

	String EditSubDivisionName = "SystenicsTest";
	String SubDivisionReference = "SubDivisionTest";
	String SubDivisionAddress1 = "MorajTest";
	String SubDivisionCity = "Mumbai";
	String SubDivisionPostalCode = "4001238";
	String SubDivisionState = "Maharashtra";
	String SubDivisionPHNumber = "9998989899";

	//Variable for Verification
	String edExpAddress1 = "MorajTest";
	String edExpCity = "Mumbai";
	String edExpPostalCode = "4001238";
	String edExpState = "Maharashtra";
	String edExpTelNo = "9998989899";
	String edExpRefTitle = "SubDivisionTest";
	String FirstName = "Time";

	String UpdateUserName = "firstTest5";
	String UpdateUserLastName = "lastTest5";
	String UpdateMobilePhone = "9898990098";
	String UpdateWorkPhone = "689905";

	//Variables for verification of edited user
	String ExpectedPhoneNumber = "9898990098";
	String ExpectedWorkPnone = "689905";
	String ExpectedFullName= "firstTest5 lastTest5";

	//Class objects
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	PolicyPage Ppage = new PolicyPage();
	//Element Locators
	//Select Company link from Admin dropdown
	public static final String CompaniesLnk = "@linkText=Companies";

	//Verify Company page
	public static final String CompanyPageLbl = "@css=.lead.f-Size-24.m-b-15";

	//Add company Button
	public static final String AddNewCompanyBtn = "@xpath=//button[contains(.,'Add New Company')]";

	//Add company Main Details section
	public static final String CompanyNameTxt="@model=companyData.DisplayName";
	public static final String TradingNameTxt="@model=companyData.TradingName";
	public static final String CompanyTypeDD="@css=.k-header.ng-scope.ng-empty";
	public static final String InsurerDDValue = "@xpath=//li[contains(text(),'Insurer')]";

	//Add company Contact Information section
	public static final String TelephoneTxt="@model=companyData.Telephone";
	public static final String Address_1Txt="@model=companyData.Address1";
	public static final String Address_2Txt="@model=companyData.Address2";
	public static final String CityTxt="@model=companyData.City";
	public static final String PostalCodeTxt="@model=companyData.PostalCode";
	public static final String StateTxt="@model=companyData.State";
	public static final String CountryDD="@xpath=//preceding::dt[text()='Country']//following::dd//span[@class='k-input ng-scope']";
	public static final String IndiaDDValue ="@css=ul > li:nth-child(96)";

	//Save company details
	public static final String SaveBtn="@buttonText=Save";
	public static final String VerifyAddedCompany ="@css=.lead.m-b-10.ng-binding";

	//Company Name Filter
	public static final String CompanyNameFilter ="@xpath=//th[@data-title='Company Name']//a//span";
	public static final String SearchFilterTxt ="@css=[placeholder='Search']";
	public static final String FilterBtn="@buttonText=Filter";

	//Contract Administrator Filter
	public static final String ContractNameFilter ="@xpath=//th[@data-title='Contract Administrator']//a//span";
	
	// company name after filter
	public static final String FiltedCompanyName="@css=.k-selectable tbody td:nth-of-type(2)";

	public static final String AddNewUserBtx="@buttonText=Add New User";
	//Add new user locator 
	public static final String FirstNameTxt="@model=userDetails.FirstName";
	public static final String LastNameTxt="@model=userDetails.LastName";
	public static final String RoleDD="@css=.k-dropdown";
	public static final String CompanyAdminRole="@css=.k-list.k-reset li:nth-child(3)";
	public static final String EmailAddresstxt="@model=userDetails.Email";
	public static final String MobilePhoneTxt="@model=userDetails.PhoneNumber";
	public static final String WorkPhonetxt="@model=userDetails.WorkPhoneNumber";
	public static final String VerificationFail="@css=.alert.alert-danger.m-15";

	public static final String EmailFiltericon="@css=.k-grid-header-wrap [data-field=Email] .k-grid-filter";
	public static final String EmailFiltersearchtxt="@css=.k-textbox.k-space-right>input";
	public static final String checkEmailID="@css=.k-reset.k-multicheck-wrap";
	public static final String selectuser="@css=.ng-scope>td:nth-child(1)";

	//Added user locator for verification
	public static final String UserDeactivatedmsg="@xpath=//div[contains(text(),'This user is deactivated')]";
	public static final String EmailnotVerifiedmsg="@xpath=//div[contains(text(),'Email is not verified by this user')]";
	public static final String FullName="@xpath=//dt[text()='Full Name']/../dd";
	public static final String Role="@xpath=//dt[text()='Role']/../dd";
	public static final String Company="@xpath=//dt[text()='Company']/../dd";
	public static final String EmailID="@xpath=//dt[text()='Email ID']/../dd";
	public static final String PhoneNumber1="@xpath=//dt[text()='Phone Number']/../dd";
	public static final String WorkPhoneNumber="@xpath=//dt[text()='Work Phone Number']/../dd";
	public static final String BacktoCompanybtn="@css=.btn-primary.pull-right.ng-scope";
	public static final String PolicyHome = "@css=a[href='#!/app/contractlist']";


	//Locators to edit the user after filtered it
	public static final String SelectedUser = "@css=[role='rowgroup'] tr:nth-child(3)>td:nth-child(1)";
	public static final String KegalButtonEdit = "@css=#profile-main .dropdown-toggle";
	public static final String EditSelectedUserLink ="@xpath=//*[@id='profile-main']//li//a//i";
	public static final String EditLink ="@xpath=//*[@id='profile-main']//li//a[contains(.,'Edit')]";
	//Locators for Edit user(Main Details) 
	public static final String UserFirstName = "@model=userDetails.FirstName";
	public static final String UserLastName = "@model=userDetails.LastName";
	//Lacators for Edit User Contact Information
	public static final String UserMobilePhoneNumber = "@model=userDetails.PhoneNumber";
	public static final String UserWorkPhone = "@model=userDetails.WorkPhoneNumber";
	// Locators for Save and Verification of edited user.
	public static final String SaveButtonUser = "@partialButtonText=Save Changes";
	public static final String EditedWorkPhoneNumber = "@xpath=//dt[text()='Work Phone Number']/../dd[@class='ng-binding']";
	public static final String EditedPhoneNumber ="@xpath=//dt[text()='Phone Number']/../dd[@class='ng-binding']";
	public static final String EditedFullName = "@xpath=//dt[text()='Full Name']/../dd[@class='ng-binding']";

	// company name after filter
	public static final String SystenicsCompanyName="@xpath=//td[@role='gridcell'][2]";
	public static final String CompanyTypeDD1="@xpath=(//div[@class='pmbb-body p-l-30']//dl)[3]//div[@class='form-group']";
	// Edit icon
	public static final String EditKebabIcon="@css=.pmbb-header .actions.hidden-xs.ng-scope";
	public static final String EditoptionLink="@css=.dropdown-menu.dropdown-menu-right";
	public static final String CompanyTypeBroker="@xpath=//li[text()='Broker']";
	public static final String UnitedStateDDValue ="@css=ul > li:nth-child(230)";
	public static final String SaveChangesBtn ="@buttonText=Save Changes";

	// locator after edit company details
	public static final String Editedcompanyname ="@xpath=//dt[text()='Company Name']/../dd[@class='ng-binding']";
	public static final String EditedTradingname ="@xpath=//dt[text()='Trading Name']/../dd[@class='ng-binding']";
	public static final String Editedcompanytype ="@xpath=//dt[text()='Company Type']/../dd[@class='ng-binding']";
	public static final String EditedTelephone ="@xpath=//dt[text()='Telephone']/../dd[@class='ng-binding']";
	public static final String Editedaddress1 ="@xpath=//dt[text()='Address 1']/../dd[@class='ng-binding']";
	public static final String Editedaddress2 ="@xpath=//dt[text()='Address 2']/../dd[@class='ng-binding']";
	public static final String Editedcity="@xpath=//dt[text()='City']/../dd[@class='ng-binding']";
	public static final String Editedpostalcode="@xpath=//dt[text()='Postal Code']/../dd[@class='ng-binding']";
	public static final String Editedstate="@xpath=//dt[text()='State']/../dd[@class='ng-binding']";
	public static final String Editedcountry="@xpath=//dt[text()='County']/../dd[@class='ng-binding']";

	//Add Division
	public static final String Division = "@css=.btn-wave.ng-scope>a[data-ui-sref='app.companydetails.companydivisions({DivisionSubDivisionType: 1})']";
	public static final String Add_new_Division_Button ="@partialButtonText=Add New Division";
	public static final String Division_Name = "@model=divisionDetail.DivisionName";
	public static final String Division_Reference= "@model=divisionDetail.DivisionReference";
	public static final String Division_Type = "@css=.k-input.ng-scope";
	public static final String EnterDivisionType = "@css=.k-animation-container span:nth-child(1)";
	public static final String Division_Insure ="@xpath=//li[text()='Insurer']";
	public static final String Address1 = "@model=divisionDetail.Address1";
	public static final String Address2 ="@model=divisionDetail.Address2";
	public static final String City = "@model=divisionDetail.City";
	public static final String PostalCode ="@model=divisionDetail.PostalCode";
	public static final String  Country_Dropdown ="@xpath=//dt[contains(text(),'Country')]/following-sibling::dd/descendant::span[@class='k-icon k-i-arrow-60-down']";
	public static final String Country_Option = "@xpath=//li[text()='India']";
	public static final String EnterOption = "@css=.k-textbox";
	public static final String PhoneNumber = "@model=divisionDetail.Telephone";
	public static final String Save_Button= "@buttonText=Save";
	public static final String State = "@model=divisionDetail.State";
	public static final String DivisionTitle ="@css=.lead.m-b-0.ng-binding";
	public static final String BackToCompanyBtn ="@xpath=//*[@id='profile-main']//div[text()='BACK TO COMPANY']";
	public static final String IsLloydsYesBtn ="@xpath=//*[@name='form.Division']//div/dl[4]/dd/label[1]";
	public static final String cancelbtn ="@xpath=//*[@data-ng-click='cancel()']";
	
	//Locators for Edit Sub-Division
	public static final String SubDivisionNameFilterIcon = "@css=[data-field='DivisionName'] span:nth-child(1)";
	public static final String SubDivisionNameSearch = "@css=.k-textbox.k-space-right>input";
	public static final String SubDivisionSearch = "@css=input[placeholder='Search']";	
	public static final String SelectCheckbox = "@css= [value='"+DivisionName+"']";
	public static final String FilterButton = "@css=.k-button.k-primary";

	//Locators to edit the subDivision after filtered it.
	public static final String FirstRecord = "@css=.k-grid-content [role=grid]";
	public static final String KegalButtonToEdit = "@css=#profile-main .dropdown-toggle";
	public static final String EditSubDivisionLink ="@css=#profile-main .dropdown-menu li.ng-scope>a";

	//Locators Edit Mode
	public static final String EdSubDivisionName = "@model=divisionDetail.DivisionName";
	public static final String EdSubDivisionReference = "@model=divisionDetail.DivisionReference";
	public static final String EdAddress1 = "@model=divisionDetail.Address1";
	public static final String EdSubDivisionCity= "@model=divisionDetail.City";
	public static final String EdSubDivisionPostalCode = "@model=divisionDetail.PostalCode";
	public static final String EdSubDivisionState = "@model=divisionDetail.State";
	public static final String EdSubDivisionTelephone = "@model=divisionDetail.Telephone";

	//Locator to SAVE edit data
	public static final String SaveButton = "@buttonText=Save";

	//Locators to verification
	public static final String RefSubDivisionTitle = "@css=.lead.m-b-0.ng-binding small:nth-child(1)";
	public static final String DivisionFilterIcon = "@css=.k-grid-header [data-field=DivisionName] a";
	public static final String DivisionSearchBox = "@css=.k-textbox.k-space-right>input";
	public static final String DivisionCheckBox = "@css=.k-label [value='"+DivisionName+"']";
	public static final String DivisionFilterLink = "@css=.k-button.k-primary";
	public static final String DivisionFirstRecrd = "@xpath=//*[@role='grid']//td[1]/span";
	public static final String EditKegelDots ="@css=#profile-main .dropdown-toggle";
	public static final String EditDivisionLink ="@css=#profile-main .dropdown-menu li.ng-scope>a";

	//Edit fields
	public static final String EdDivisionRefName = "@model=divisionDetail.DivisionReference";
	public static final String EdDivisionAdd1 = "@model=divisionDetail.Address1";
	public static final String EdDivisionCity = "@model=divisionDetail.City";
	public static final String EdDivisionPostsalCd = "@model=divisionDetail.PostalCode";
	public static final String EdDivisionState = "@model=divisionDetail.State";
	public static final String EdDivisionTelNo = "@model=divisionDetail.Telephone";

	//Save
	public static final String EditSaveBtn ="@buttonText=Save";
	public static final String DivisionRefTitle ="@css=.lead.m-b-0.ng-binding .ng-binding";
	public static final String DivisionAddLine1 ="@xpath=//*[@id='profile-main']//dl[@class='dl-horizontal'][2]//dd";
	public static final String DivisionCity ="@xpath=//*[@id='profile-main']//dl[@class='dl-horizontal'][4]//dd";
	public static final String DivisionPostalCode ="@xpath=//*[@id='profile-main']//dl[@class='dl-horizontal'][5]//dd";
	public static final String DivisionState ="@xpath=//*[@id='profile-main']//dl[@class='dl-horizontal'][6]//dd";
	public static final String DivisionTelNo ="@xpath=//*[@id='profile-main']/div[2]/data/div[2]/div[4]/div/dl/dd";

	//Add Subdivision
	public static final String SUBDivision = "@css=.btn-wave.ng-scope>a[data-ui-sref='app.companydetails.companydivisions({DivisionSubDivisionType: 2})']";
	public static final String Add_New_SubDivision_Button ="@partialButtonText=Add New Sub Division";
	public static final String SubDivisionName = "@model=divisionDetail.DivisionName";
	public static final String SubDivisionRefName = "@model=divisionDetail.DivisionReference";
	public static final String Division_Broker ="@xpath=//li[text()='Broker']";

	//Activate / Deactivate user
	public static final String SelectedCom ="@css=.ng-scope[role='row']";
	public static final String UserTab = "@xpath=//*[@id='profile-main']//li//a[contains(.,'Users')]";
	public static final String Deactivatebtn = "@xpath=//button[contains(.,'Deactivate')][1]";
	public static final String ConfirmDeactivatebtn = "@xpath=//button[contains(.,'Yes, Deactivate it')]";
	public static final String DeActiveStatus = "@css=.text-danger";
	public static final String ActiveStatus = "@css=.text-success";
	public static final String Activatebtn = "@xpath=//button[contains(.,'Activate')][1]";
	public static final String ConfirmActivatebtn = "@xpath=//button[contains(.,'Yes, Activate it')]";

	/**************Add User to Division*********************/
	public static final String SelectDivision = "@xpath=//tbody//td[1]//span";
	public static final String UsersTab = "@xpath=//*[@id='profile-main']//a[contains(.,'Users')]";
	public static final String AddNewUserButton = "@buttonText=Add New User";
	public static final String AddUsersPopUp = "@xpath=//h2[contains(.,'Add users to')]";
	public static final String AddUsersDropdown = "@xpath=//*[@ng-model='User']//preceding-sibling::span[1]";
	public static final String NoDataFoundValue = "@xpath=//div[@class='k-animation-container']//div[@class='k-nodata ng-scope']/div[contains(.,'No data found.')]";
	public static final String SelectUserValue = "@xpath=//div[@class='k-animation-container']//ul//li[1]";
	public static final String AddUserButton = "@xpath=//button[contains(.,'Add User')]";
	public static final String CancelButton = "@xpath=//div[contains(.,'Cancel')]";
	public String AddedUserToDivision = "@xpath=//tbody//tr//span[contains(.,'"+UpdateUserName+"')]";

	public static final String CompanyUser = "@xpath=//tbody//td[1]";

	//TC 4062
	public static final String TideAdminProfile = "@xpath=//li[@ng-if='authentication.authenticated']//*[text()='Tide Admin']";
	public static final String ComAdminProfile = "@xpath=//li[@ng-if='authentication.authenticated']//*[text()='Company Admin']";
	public static final String StandardUserProfile = "@xpath=//li[@ng-if='authentication.authenticated']//*[text()='Standard']";
	public static final String ReadyOnlyUserProfile = "@xpath=//li[@ng-if='authentication.authenticated']//*[text()='Read Only']";

	
	public static final String profilelink ="@xpath=//ul[@class='dropdown-menu dm-icon']//li[1]";
	public static final String EditIcondropdown ="@xpath=//ul[@class='actions hidden-xs']//li[1]//a[@class='dropdown-toggle']";
	public static final String EditIcon ="@xpath=//*[@ng-if='Permission.Edit']";
	public static final String EditMobileNo ="@xpath=//*[@data-ng-model='userDetails.PhoneNumber']";
	public static final String EditWorkPhoneNo="@xpath=//*[@data-ng-model='userDetails.WorkPhoneNumber']";
	public static final String SavechangesBtn="@xpath=//*[text()='Save Changes']";
	public static final String verifyprofileeditpage = "@xpath=//h2[contains(.,'Main Details')]";
	public static final String verifyMobileNo="@xpath=//*[@class='pm-body clearfix']/div[2]//dl[2]//dd[@class='ng-binding']";
	public static final String verifyWorkPhoneNo="@xpath=//*[@class='pm-body clearfix']/div[2]//div/dl[3]";
	
	public static final String RemoveBtnUser="@xpath=//*[@id='profile-main']//tr[1]//button[@ng-show='Permission.Delete']";
	public static final String RemoveBtn="@xpath=//button[@ng-click='removeData()']";
	
	public static final String ExistingDivision="@xpath=//*[@id='profile-main']//tr[1]//span[@ng-bind='dataItem.DivisionName']";
	public static final String ExistingDivisionWithYes="@xpath=//*[@id='profile-main']//tr//span[@ng-bind='dataItem.DivisionName'][text()='4711']";
	public static final String ExistingDivisionWithNo="@xpath=//*[@id='profile-main']//tr//span[@ng-bind='dataItem.DivisionName'][text()='4712']";
	public static final String EditDots = "@xpath=.//*[@id='profile-main']//li/a[@class='dropdown-toggle']";
	
	public static final String ExistingUser ="@xpath=//*[@id='profile-main']//tr[1]//span[@ng-bind='dataItem.FirstName']";
	public static final String SelectSubDivision ="@xpath=//*[@id='profile-main']//tr[1]//span[@ng-bind='dataItem.FirstName']";
	public static final String ExistingUserFromDivision = "@xpath=//*[@id='profile-main']//tr//span[@ng-bind='dataItem.DivisionName'][contains(.,'SystenicsTest')]";
	String expDeactive = "Inactive";
	String expActive = "Active";

	/****************************************************************************/

	public void addCompany() throws InterruptedException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		companyLink();
		addCompanyPage();
		sleep(2000);
		addNewCompany();
		sleep(2000);
		addCompanyMainDetails();
		addCompanyContactInformation();
		saveNewCompanyDetails();
		homePage.adminMenu();
		companyLink();
	}

	public void editCompany() throws InterruptedException
	{
		applyCompanyNameFilter(CompanyName);
		openRecordInEditMode();
		editCompanyNameDetails();
		SaveAndVerifyEditOperation();
	}

	public void addDivision() throws Exception{
		MainDetailsAddDivision();
		sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		waitForElementToAppear(DivisionTitle,40);
		String ActualDivisionTitle = getTextFrom(DivisionTitle);
		String ExpectedDivisionTitle = DivisionName;
		if(ActualDivisionTitle.contains(ExpectedDivisionTitle))
		{
			Report.LogInfo("CreatedDivisionTitle", "Division created successfully.", "PASS");
		}else{
			Report.LogInfo("CreatedDivisionTitle", "Division not created successfully.", "FAIL");
		}
		sleep(2000);
		verifyMustExists(BackToCompanyBtn,"Back To Company Button");
		click(BackToCompanyBtn,"Back To Company Button");
		sleep(2000);
		NavigateToDivision();
	}
	public void addDivision1() throws Exception{
		MainDetailsAddDivision();
		sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		waitForElementToAppear(DivisionTitle,40);
		String ActualDivisionTitle = getTextFrom(DivisionTitle);
		String ExpectedDivisionTitle = DivisionName;
		if(ActualDivisionTitle.contains(ExpectedDivisionTitle))
		{
			Report.LogInfo("CreatedDivisionTitle", "Division created successfully.", "PASS");
		}else{
			Report.LogInfo("CreatedDivisionTitle", "Division not created successfully.", "FAIL");
		}
		sleep(2000);
		verifyMustExists(BackToCompanyBtn,"Back To Company Button");
		click(BackToCompanyBtn,"Back To Company Button");
		sleep(2000);
		NavigateToDivision();
	}
	public void openExistingUser()
	{
		if(isVisible(ExistingUser)==true){
			waitForElementToAppear(ExistingUser,3);
			verifyMustExists(ExistingUser,"Existing User record");
			click(ExistingUser,"Existing User record");			
		}else{
			Report.LogInfo("RecordCheck", "Existing User not available.", "FAIL");
		}
	}

	
	public void openExistingDivision()
	{
		if(isVisible(ExistingDivision)==true){
			waitForElementToAppear(ExistingDivision,3);
			verifyMustExists(ExistingDivision,"Existing division record");
			click(ExistingDivision,"Existing division record");			
		}else{
			Report.LogInfo("RecordCheck", "Existing division not available.", "FAIL");
		}
	}	
	public void openExistingDivisionWithIsLloyds()
	{
		if(isVisible(ExistingDivisionWithYes)==true){
			waitForElementToAppear(ExistingDivisionWithYes,3);
			verifyMustExists(ExistingDivisionWithYes,"Existing division record");
			click(ExistingDivisionWithYes,"Existing division record");			
		}else{
			Report.LogInfo("RecordCheck", "Existing division not available.", "FAIL");
		}
		
	}
	public void openExistingDivisionWithIsLloydsNo()
	{
		if(isVisible(ExistingDivisionWithNo)==true){
			waitForElementToAppear(ExistingDivisionWithNo,3);
			verifyMustExists(ExistingDivisionWithNo,"Existing division record");
			click(ExistingDivisionWithNo,"Existing division record");			
		}else{
			Report.LogInfo("RecordCheck", "Existing division not available.", "FAIL");
		}
		if(isVisible(EditDots)==true){
			verifyMustExists(EditDots,"Edit dots");
		}
	}
	
	public void VerifyExistingDivisionWithIsLoyedYes()
	{
		waitForElementToAppear(IsLloydsYesBtn,3);
		if(isVisible(IsLloydsYesBtn)==true){
			verifyMustExists(IsLloydsYesBtn,"Existing division record");
			sleep(1000);
			verifyMustExists(cancelbtn,"Cancel Button");
			click(cancelbtn,"Cancel Button");			
		}else{
			Report.LogInfo("RecordCheck", "Existing division not available.", "FAIL");
		}
		
	}
	public void editDivision() throws InterruptedException
	{
		applyDivisionNameFilter();	
		openRecordInEditMode1();
		EditDivisionFields();
		SaveAndVerifyEditOperation1();
		sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		sleep(2000);
		verifyMustExists(BackToCompanyBtn,"Back To Company Button");
		click(BackToCompanyBtn,"Back To Company Button");
	}

	public void addNewSubDivision() throws Exception
	{
		addCompany();
		applyCompanyNameFilter(CompanyName);
		openRecordInEditMode();
		navigationOnSubDivision();
		openAddNewSubDivisionPage();
		MainDetailsAddSubDivision();
		contactInformation("9856242255");
		saveAddedSubDivision();
		verifyAddedSubDivision();
	}
	public void addNewSubDivision1() throws Exception
	{
	navigationOnSubDivision();
	openAddNewSubDivisionPage();
	MainDetailsAddSubDivision();
	contactInformation("9856242255");
	saveAddedSubDivision();
	verifyAddedSubDivision();
	}

	public void editSubDivision() throws Exception{	
		navigationOnSubDivision();
		//applyFilterSubDivisionName();
		openRecordInEditModeSubDivision();
		EditSubDivisionFields();
		SaveAndVerifyEditOperationSubDivision();
		sleep(5000);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		sleep(2000);
		verifyMustExists(BackToCompanyBtn,"Back To Company Button");
		click(BackToCompanyBtn,"Back To Company Button");
	}

	public void addNewUserForCompany() throws InterruptedException
	{
		clickonUserTabAndUserButton();
		addUserDetails();
		verifyAddedUserDetails();
	}

	public void addNewUserForCompany1() throws InterruptedException
	{
		clickonUserTabAndUserButton();
		addUserDetails();
		verifyAddedUserDetails1();
	}

	public void editNewUser() throws InterruptedException{
		openSelectedUserInEditMode();
		EditMainDetailsUser();
		EditContactInformationUser();
		saveAndVerification();
	}

	public void addUserToDivision() throws Exception{
		addDivision();
		//NavigateToDivision();
		selectAddedDivision();
		selectUsersTab();
		sleep(2000);
		createNewUserUnderDivision();
	}
	
	public void removeAddedUserToDivision() throws Exception{
		NavigateToDivision();
		selectAddedDivision();
		selectUsersTab();
		waitForElementToAppear(RemoveBtnUser,3);
		if(isVisible(RemoveBtnUser)==true){			
			verifyMustExists(RemoveBtnUser,"Remove button");
			click(RemoveBtnUser,"Remove button");
			waitForElementToAppear(RemoveBtn,3);
			verifyMustExists(RemoveBtn,"Are you sure Remove button");
			click(RemoveBtn,"Are you sure Remove button");
			sleep(2000);
		}
		scrollUp();
		waitForElementToAppear(BacktoCompanybtn,5);
		verifyMustExists(BacktoCompanybtn,"Back to company button");
		click(BacktoCompanybtn,"Back to company button");
		sleep(2000);
	}
	public void selectAddedSubDivision()
	{
		waitForElementToAppear(SelectDivision,5);
		verifyMustExists(SelectDivision,"Division exists");
		click(selectuser,"Select Division");
	}
	public void removeAddedUserToExistingDivision() throws Exception{
		waitForElementToAppear(RemoveBtnUser,3);
		if(isVisible(RemoveBtnUser)==true){			
			verifyMustExists(RemoveBtnUser,"Remove button");
			click(RemoveBtnUser,"Remove button");
			waitForElementToAppear(RemoveBtn,3);
			verifyMustExists(RemoveBtn,"Are you sure Remove button");
			click(RemoveBtn,"Are you sure Remove button");
			sleep(2000);
		}
		scrollUp();
		waitForElementToAppear(BacktoCompanybtn,5);
		verifyMustExists(BacktoCompanybtn,"Back to company button");
		click(BacktoCompanybtn,"Back to company button");
		sleep(2000);
	}

	public void addUserToSubDivision() throws Exception{
		navigationOnSubDivision();
		openRecordInEditModeSubDivision();
		selectUsersTab();
		sleep(2000);
		createNewUserUnderDivision();
	}
	public void removeUserToSubDivision() throws Exception{
		navigationOnSubDivision();
		selectAddedSubDivision();		
		selectUsersTab();
		sleep(2000);
		//createNewUserUnderDivision();
		waitForElementToAppear(RemoveBtnUser,3);
		if(isVisible(RemoveBtnUser)==true){			
			verifyMustExists(RemoveBtnUser,"Remove button");
			click(RemoveBtnUser,"Remove button");
			waitForElementToAppear(RemoveBtn,3);
			verifyMustExists(RemoveBtn,"Are you sure Remove button");
			click(RemoveBtn,"Are you sure Remove button");
			sleep(2000);
		}
		scrollUp();
		waitForElementToAppear(BacktoCompanybtn,5);
		verifyMustExists(BacktoCompanybtn,"Back to company button");
		click(BacktoCompanybtn,"Back to company button");
		sleep(2000);
	}
	//3163 Activate a User
	public void activateNewUser() throws Exception
	{
		navigationOnUserTab();
		activateUser();
		checkActiveStatus();
	}

	//3164 Deactivate a User
	public void deactivateNewUser() throws Exception
	{
		deactivateUser();
		checkDeactiveStatus();
	}

	public void Edit_UserProfile_Of_User_4062() throws Exception
	{
		String ActualMobileNumber ="9999999990";
		//waitForElementToAppear(TideAdminProfile,4);
		sleep(2000);
		if(isVisible(TideAdminProfile)==true){
			verifyMustExists(TideAdminProfile,"Tide Admin");
			click(TideAdminProfile,"TideA dmin");
		}
		if(isVisible(ComAdminProfile)==true){
			verifyMustExists(ComAdminProfile,"Tide Admin");
			click(ComAdminProfile,"TideA dmin");
		}
		
		waitForElementToAppear(profilelink,4);
		verifyMustExists(profilelink,"Pofile");
		click(profilelink,"Profile");
		verifyMustExists(EditIcondropdown,"Edit User drop down");
		click(EditIcondropdown,"Click on Edit drop down");
		verifyMustExists(EditIcon,"Edit Pofile");
		click(EditIcon,"Edit Profile");
		waitForElementToAppear(EditMobileNo,4);
		verifyMustExists(EditMobileNo,"Edit Mobile No.");
		sendKeys(EditMobileNo,ActualMobileNumber,"Edit Mobile No.");
		verifyMustExists(SavechangesBtn,"Save Edited changes");
		click(SavechangesBtn,"Save Edited changes");
		sleep(5000);
		verifyExists(verifyprofileeditpage, "Verify profile edit page");
		mouseOverAction(verifyMobileNo);
		verifyExists(verifyMobileNo, "Verify Mobile no field");
		String EditedMobileno = getTextFrom(verifyMobileNo);

		if(ActualMobileNumber.equalsIgnoreCase(EditedMobileno)){

			Report.LogInfo("ValidateEdit", "Phone Number updated successfully.", "PASS");

		}else{

			Report.LogInfo("ValidateEdit", "Phone Number not updated successfully.", "FAIL");
		}

		sleep(2000);
	}

	/******************************************************************************/
	public void StandardUserProfile() throws Exception
	{
		sleep(2000);
		if(isVisible(StandardUserProfile)==true){
			verifyMustExists(StandardUserProfile,"Tide Admin");
			click(StandardUserProfile,"TideA dmin");
			waitForElementToAppear(profilelink,4);
			verifyMustExists(profilelink,"Pofile");
			click(profilelink,"Profile");
			sleep(2000);			
		}
	}
	
	public void ReadOnlyUserProfile() throws Exception
	{
		sleep(2000);
		if(isVisible(ReadyOnlyUserProfile)==true){
			verifyMustExists(ReadyOnlyUserProfile,"Read only");
			click(ReadyOnlyUserProfile,"Read only");
			waitForElementToAppear(profilelink,4);
			verifyMustExists(profilelink,"Pofile");
			click(profilelink,"Profile");
			sleep(2000);			
		}
	}
	
	public void companyLink()
	{
		waitForElementToAppear(CompaniesLnk,5);
		verifyMustExists(CompaniesLnk,"Company Link");
		click(CompaniesLnk,"Company Link");
	}



	public void addCompanyPage()
	{
		waitForElementToAppear(CompanyPageLbl,5);
		verifyExists(CompanyPageLbl,"Companies Label");	
	}

	public void addNewCompany()
	{
		waitForElementToAppear(AddNewCompanyBtn,5);
		verifyMustExists(AddNewCompanyBtn,"Add New Company Button");	
		click(AddNewCompanyBtn,"Add New Company Button");
	}

	public void addCompanyMainDetails()
	{
		waitForElementToAppear(CompanyNameTxt,5);
		verifyMustExists(CompanyNameTxt,"Company Name Textbox");	
		sendKeys(CompanyNameTxt,CompanyName,"Company Name field.");
		verifyMustExists(TradingNameTxt,"Trading Name Textbox");	
		sendKeys(TradingNameTxt,rd.getDataFromCell(path, "TestData", 6, 1), "Trading Name textbox.");
		SelectDropDownValue(CompanyTypeDD,InsurerDDValue);

		/*verifyMustExists(CompanyTypeDD,"Company Dropdown");	
		click(CompanyTypeDD,"Company Dropdown");
		javaScriptWait();
		verifyMustExists(InsurerDDValue,"Insurer Dropdown Value");	
		click(InsurerDDValue,"Insurer Dropdown Value");*/
	}

	public void addCompanyContactInformation()
	{
		waitForElementToAppear(TelephoneTxt,5);
		verifyMustExists(TelephoneTxt,"Telephone textbox");	
		sendKeys(TelephoneTxt,rd.getDataFromCell(path, "TestData", 9, 0), "Telephone textbox.");
		verifyMustExists(Address_1Txt,"Address 1 textbox");	
		sendKeys(Address_1Txt,rd.getDataFromCell(path, "TestData", 9, 1), "Address1 textbox.");
		verifyMustExists(Address_2Txt,"Address 2 textbox");	
		sendKeys(Address_2Txt,rd.getDataFromCell(path, "TestData", 9, 2), "Address2 textbox.");
		verifyMustExists(CityTxt,"City textbox");	
		sendKeys(CityTxt,rd.getDataFromCell(path, "TestData", 9, 3), "City textbox.");
		verifyMustExists(PostalCodeTxt,"Postal Code textbox");	
		sendKeys(PostalCodeTxt,rd.getDataFromCell(path, "TestData", 9, 4), "Postal Code textbox.");
		verifyMustExists(StateTxt,"State textbox");	
		sendKeys(StateTxt,rd.getDataFromCell(path, "TestData", 9, 5), "State textbox.");
		SelectDropDownValue(CountryDD,IndiaDDValue);
	}

	public void saveNewCompanyDetails()
	{
		waitForElementToAppear(SaveBtn,5);
		verifyMustExists(SaveBtn,"Save button");	
		click(SaveBtn,"Save button");
		waitForElementToAppear(VerifyAddedCompany,5);
		verifyExists(VerifyAddedCompany,"Added Company");
	}

	public void applyCompanyNameFilter(String ComName){
		int i=0;
		String RecordCheckbox ="@xpath=//li//span[contains(text(),'"+ComName+"')]";
		//sleep(3000);
		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(CompanyNameFilter, "Company Name Filter");
			sleep(2000);
			if(isVisible(SearchFilterTxt))
			{
				verifyMustExists(SearchFilterTxt,"Search Filter Textbox");	
				sendKeys(SearchFilterTxt,ComName,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);

		click(RecordCheckbox, "Searched Record Checkbox");
		verifyMustExists(FilterBtn,"Filter Button");	
		click(FilterBtn,"Filter Button");
	}

	public void openRecordInEditMode() throws InterruptedException
	{	
		sleep(3000);
		waitForElementToAppear(SystenicsCompanyName,5);
		verifyMustExists(SystenicsCompanyName,"Filtered record");
		click(SystenicsCompanyName,"Filtered record");
		//sleep(2000);
		waitForElementToAppear(EditKebabIcon,5);
		verifyMustExists(EditKebabIcon,"Edit dots");
		click(EditKebabIcon,"Edit dots");
		verifyMustExists(EditoptionLink,"Edit link");
		click(EditoptionLink,"Edit link");
	}

	public void editCompanyNameDetails() throws InterruptedException
	{
		waitForElementToAppear(CompanyNameTxt,5);
		clearTextBox(CompanyNameTxt);
		sleep(3000);
		sendKeys(CompanyNameTxt,rd.getDataFromCell(path,"TestData",14,0), "Company Name Textbox.");
		sleep(3000);
		clearTextBox(TradingNameTxt);
		sendKeys(TradingNameTxt,rd.getDataFromCell(path, "TestData",14,1), "Trading Name Textbox.");
		verifyMustExists(CompanyTypeDD1,"Company Type DD record"); 
		click(CompanyTypeDD1,"Country Type Button");
		click(CompanyTypeBroker,"Broker Option");
		clearTextBox(TelephoneTxt);
		sendKeys(TelephoneTxt,rd.getDataFromCell(path, "TestData",17,0), "Telephone Textbox.");
		clearTextBox(Address_1Txt);
		sendKeys(Address_1Txt,rd.getDataFromCell(path, "TestData",17,1), "Address1 Textbox.");
		clearTextBox(Address_2Txt);
		sendKeys(Address_2Txt,rd.getDataFromCell(path, "TestData",17,2), "Address2 Textbox.");
		clearTextBox(CityTxt); 
		sendKeys(CityTxt,rd.getDataFromCell(path, "TestData",17,3), "City Textbox.");
		clearTextBox(PostalCodeTxt);
		sendKeys(PostalCodeTxt,rd.getDataFromCell(path, "TestData",17,4), "Postal Code Textbox.");
		clearTextBox(StateTxt);
		sendKeys(StateTxt,rd.getDataFromCell(path, "TestData",17,5), "State Textbox.");
		SelectDropDownValue(CountryDD,UnitedStateDDValue);

	}

	public void SaveAndVerifyEditOperation() throws InterruptedException
	{
		waitForElementToAppear(SaveChangesBtn,5);
		verifyMustExists(SaveChangesBtn,"Save button");
		click(SaveChangesBtn,"Save button");
		javaScriptWait();
		waitToPageLoad();
		waitForElementToAppear(Editedcountry,20);
		String expectedcompanyname =rd.getDataFromCell(path,"TestData",14,0);
		String actualcompnayname = getTextFrom(Editedcompanyname);
		if(actualcompnayname.equals(expectedcompanyname))
		{
			Report.LogInfo("ValidateCompanyName", "Company Name edited successfully.", "PASS");
		}else
		{
			Report.LogInfo("ValidateCompanyName", "Company Name not edited successfully.", "FAIL");
		}
		String actualTradingName=getTextFrom(EditedTradingname);
		String expectedTradingName=rd.getDataFromCell(path, "TestData",14,1);
		if(actualTradingName.equals(expectedTradingName))
		{
			Report.LogInfo("ValidateTradingName", "Trading Name edited successfully.", "PASS");
		}else{
			Report.LogInfo("ValidateTradingName", "Trading Name not edited successfully.", "FAIL");
		}

		String actualTelephone=getTextFrom(EditedTelephone);
		String expectedTelephone=rd.getDataFromCell(path, "TestData",17,0);
		if(actualTelephone.equals(expectedTelephone))
		{
			Report.LogInfo("ValidateTelephone", "Telephone edited successfully.", "PASS");
		}else{
			Report.LogInfo("ValidateTelephone", "Telephone not edited successfully.", "FAIL");
		}
		String actualAddress1=getTextFrom(Editedaddress1);
		String expectedAddress1=rd.getDataFromCell(path, "TestData",17,1);
		if(actualAddress1.equals(expectedAddress1))
		{
			Report.LogInfo("ValidateAddress1", "Address1 edited successfully.", "PASS");
		}else{
			Report.LogInfo("ValidateAddress1", "Address1 not edited successfully.", "FAIL");
		}
		String actualAddress2=getTextFrom(Editedaddress2);
		String expectedAddress2=rd.getDataFromCell(path, "TestData",17,2);
		if(actualAddress2.equals(expectedAddress2))
		{
			Report.LogInfo("ValidateAddress2", "Address2 edited successfully.", "PASS");
		}else{
			Report.LogInfo("ValidateAddress2", "Address2 not edited successfully.", "FAIL");
		}
		String actualCity=getTextFrom(Editedcity);
		String expectedCity=rd.getDataFromCell(path, "TestData",17,3);
		if(actualCity.equals(expectedCity))
		{
			Report.LogInfo("ValidateCity", "City edited successfully.", "PASS");
		}else{
			Report.LogInfo("ValidateCity", "City not edited successfully.", "FAIL");
		}			 
		String actualpostalcode=getTextFrom(Editedpostalcode);
		String expectedpostalcode=rd.getDataFromCell(path, "TestData",17,4);
		if(actualpostalcode.equals(expectedpostalcode))
		{
			Report.LogInfo("ValidatePostalCode", "Postal code edited successfully.", "PASS");
		}else{
			Report.LogInfo("ValidatePostalCode", "Postal code not edited successfully.", "FAIL");
		}	
		String actualstate=getTextFrom(Editedstate);
		String expectedstate=rd.getDataFromCell(path, "TestData",17,5);
		if(actualstate.equals(expectedstate))
		{
			Report.LogInfo("Validatestate", "State edited successfully.", "PASS");
		}else{
			Report.LogInfo("Validatestate", "State not edited successfully.", "FAIL");
		}	
		String actualcountry=getTextFrom(Editedcountry);
		String expectedcountry=rd.getDataFromCell(path, "TestData",17,6);

		if(actualcountry.equalsIgnoreCase(expectedcountry))
		{
			Report.LogInfo("ValidateCountry", "Country edited successfully.", "PASS");
		}else{
			Report.LogInfo("ValidateCountry", "Country not edited successfully.", "FAIL");
		}	
	}

	public void contactInformation(String number)
	{
		waitForElementToAppear(PhoneNumber,5);
		verifyMustExists(PhoneNumber,"Phone Number field");
		sendKeys(PhoneNumber, number, "Phone Number Field.");
	}

	public void MainDetailsAddDivision() throws Exception
	{
		String Country = "India";
		String PhoneNumber= "9999999999";
		NavigateToDivision();
		sleep(2000);
		verifyMustExists(Add_new_Division_Button,"Add New Division Button");
		javaScriptclick(Add_new_Division_Button,"Add New Division Button");
		sleep(3000);
		verifyMustExists(Division_Name,"Division Name field");
		sendKeys(Division_Name, DivisionName, "Division Name field.");
		verifyMustExists(Division_Reference,"Division Reference field");
		sendKeys(Division_Reference,DivisionRef,"Division Reference field.");
		/*verifyMustExists(Division_Type,"Division Type field");
		click(Division_Type,"Division Type");
		sleep(1000);
		click(Division_Insure,"Division Insurer option");*/
		sleep(2000);
		Ppage.SelectDropDownValue(Division_Type, Division_Insure);
		sleep(1000);
		verifyMustExists(Address1,"Address1 field");
		sendKeys(Address1, rd.getDataFromCell(path, "TestData",30 ,2 ), "Address1 Field.");
		verifyMustExists(City,"City field");
		sendKeys(City, rd.getDataFromCell(path, "TestData",30 ,3 ), "Address1 Field.");
		verifyMustExists(PostalCode,"PostalCode field");
		sendKeys(PostalCode, rd.getDataFromCell(path, "TestData",30 ,4), "Postal Code Field.");
		verifyMustExists(State,"State field");
		sendKeys(State, rd.getDataFromCell(path, "TestData",30 ,5), "State Field.");
		sleep(2000);
		Ppage.SelectDropDownValue(Country_Dropdown, Country_Option);
		contactInformation(PhoneNumber);
		saveAddedDivision();
	}
	public void MainDetailsAddDivision1() throws Exception
	{
		String Country = "India";
		String PhoneNumber= "9999999999";
		NavigateToDivision();
		sleep(2000);
		verifyMustExists(Add_new_Division_Button,"Add New Division Button");
		javaScriptclick(Add_new_Division_Button,"Add New Division Button");
		sleep(3000);
		verifyMustExists(Division_Name,"Division Name field");
		sendKeys(Division_Name, DivisionName, "Division Name field.");
		verifyMustExists(Division_Reference,"Division Reference field");
		sendKeys(Division_Reference,DivisionRef,"Division Reference field.");
		sleep(2000);
		Ppage.SelectDropDownValue(Division_Type, Division_Insure);
		sleep(1000);
		verifyMustExists(IsLloydsYesBtn,"Is Lloyds Yes Btn");
		javaScriptclick(IsLloydsYesBtn,"Is Lloyds Yes Btn");
		verifyMustExists(Address1,"Address1 field");
		sendKeys(Address1, rd.getDataFromCell(path, "TestData",30 ,2 ), "Address1 Field.");
		verifyMustExists(City,"City field");
		sendKeys(City, rd.getDataFromCell(path, "TestData",30 ,3 ), "Address1 Field.");
		verifyMustExists(PostalCode,"PostalCode field");
		sendKeys(PostalCode, rd.getDataFromCell(path, "TestData",30 ,4), "Postal Code Field.");
		verifyMustExists(State,"State field");
		sendKeys(State, rd.getDataFromCell(path, "TestData",30 ,5), "State Field.");
		sleep(2000);
		Ppage.SelectDropDownValue(Country_Dropdown, Country_Option);
		contactInformation(PhoneNumber);
		saveAddedDivision();
	}
	public void saveAddedDivision() throws Exception{
		waitForElementToAppear(Save_Button,5);
		verifyMustExists(Save_Button,"Save Button field");
		click(Save_Button,"Save Button");
		sleep(3000);
	}

	public void NavigateToDivision() throws Exception{
		waitForElementToAppear(Division,5);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		verifyMustExists(Division,"Division Tab");
		click(Division,"Division Tab");
		sleep(2000);
	}
	public void applyDivisionNameFilter() throws InterruptedException
	{
		waitForElementToAppear(DivisionFilterIcon,5);
		verifyMustExists(DivisionFilterIcon,"Division Filter Icon");
		click(DivisionFilterIcon,"Division Filter Icon");
		sleep(2000);
		sendKeys(DivisionSearchBox, DivisionName,  "Division SearchBox field.");
		verifyMustExists(DivisionCheckBox,"Division Checkbox");
		click(DivisionCheckBox,"Division Checkbox");
		verifyMustExists(DivisionFilterLink,"Division Filter Link");
		click(DivisionFilterLink,"Division Filter Link");		
	}

	public void openRecordInEditMode1() throws InterruptedException
	{	
		/*waitForElementToAppear(CompanyNameFilter,5);
		click(CompanyNameFilter,"Company Name Filter");
		sleep(2000);*/
		waitForElementToAppear(DivisionFirstRecrd,5);
		verifyMustExists(DivisionFirstRecrd,"Division Filter Record");
		click(DivisionFirstRecrd,"Division Filter Record");
		verifyMustExists(EditKegelDots,"Edit Dots");
		click(EditKegelDots,"Edit dots");
		verifyMustExists(EditDivisionLink,"Edit link of division");
		click(EditDivisionLink,"Edit Link of division");
	}

	public void EditDivisionFields() throws InterruptedException
	{	
		waitForElementToAppear(EdDivisionRefName,5);
		clearTextBox(EdDivisionRefName);
		sendKeys(EdDivisionRefName,expRefTitle, "Division Reference Name field.");
		clearTextBox(EdDivisionAdd1);
		sleep(1000);
		sendKeys(EdDivisionAdd1,expAddress1,"Division Address1 field.");
		clearTextBox(EdDivisionCity);
		sleep(1000);
		sendKeys(EdDivisionCity,expCity,"Division City field.");
		clearTextBox(EdDivisionPostsalCd);
		sleep(1000);
		sendKeys(EdDivisionPostsalCd,expPostalCode,"Division Postal Code field.");
		clearTextBox(EdDivisionState);
		sleep(1000);
		sendKeys(EdDivisionState,expState,"Division State field.");		
		clearTextBox(EdDivisionTelNo);
		sleep(1000);
		sendKeys(EdDivisionTelNo,expTelNo,"Division Telephone Number field.");		
	}

	public void SaveAndVerifyEditOperation1() throws InterruptedException
	{
		waitForElementToAppear(EditSaveBtn,5);
		verifyMustExists(EditSaveBtn,"Save button");
		click(EditSaveBtn,"Save button");	
		sleep(2000);
	}

	public void navigationOnSubDivision() throws InterruptedException
	{
		waitForElementToAppear(SUBDivision,5);
		verifyMustExists(SUBDivision,"Sub division tab");
		click(SUBDivision,"Sub division tab");		
	}

	public void openAddNewSubDivisionPage() throws InterruptedException
	{	
		waitForElementToAppear(Add_New_SubDivision_Button,5);
		verifyMustExists(Add_New_SubDivision_Button,"Add new sub division button");
		click(Add_New_SubDivision_Button,"Add new sub division button");		
	}

	public void MainDetailsAddSubDivision() throws Exception{
		String Country = "India";
		sleep(2000);
		waitForElementToAppear(SubDivisionName,5);
		verifyMustExists(SubDivisionName,"Division Name field");
		sendKeys(SubDivisionName, SubDivision,"Division Name field.");
		verifyMustExists(SubDivisionRefName,"Division Reference field");
		sendKeys(SubDivisionRefName, SubDivisionRef,"Division Reference field.");
		verifyMustExists(Division_Type,"Division Type field");
		click(Division_Type,"Division Type");
		sleep(1000);
		click(Division_Broker,"Division Broker option");
		sleep(2000);
		verifyMustExists(Address1,"Address1 field");
		sendKeys(Address1, rd.getDataFromCell(path, "TestData",23 ,2 ), "Address1 Field.");
		verifyMustExists(City,"City field");
		sendKeys(City, rd.getDataFromCell(path, "TestData",23 ,3 ), "Address1 Field.");
		verifyMustExists(PostalCode,"Postal Code field");
		sendKeys(PostalCode, rd.getDataFromCell(path, "TestData",23 ,4), "Postal Code Field.");
		verifyMustExists(State,"State field");
		sendKeys(State, rd.getDataFromCell(path, "TestData",23 ,5), "State Field.");
		//verifyMustExists(Country_Dropdown,"Country field");
	//	click(Country_Dropdown,"Country field");
	//	sleep(2000);
	//	sendKeys(EnterOption, Country, "Country option search Field.");
		sleep(3000);
	//	click(Country_Option,"Country option");
		javaScriptWait();
	}

	public void saveAddedSubDivision() throws Exception
	{
		waitForElementToAppear(Save_Button,5);
		verifyMustExists(Save_Button,"Save Button");
		click(Save_Button,"Save Button");
		sleep(3000);
	}

	public void verifyAddedSubDivision() throws Exception
	{
		String ActualDivisionTitle = getTextFrom(DivisionTitle);
		String ExpectedDivisionTitle = "Systenics Sub Division";

		if(ActualDivisionTitle.contains(ExpectedDivisionTitle))
		{
			Report.LogInfo("SubDivisionTitle", "Sub division get created successfully.", "PASS");
		}else{
			Report.LogInfo("SubDivisionTitle", "Sub division not get created successfully.", "FAIL");
		}
		sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		waitForElementToAppear(BacktoCompanybtn,5);
		verifyMustExists(BacktoCompanybtn,"Back to company button");
		click(BacktoCompanybtn,"Back to company button");
	}

	public void applyFilterSubDivisionName () throws InterruptedException{
		waitForElementToAppear(SubDivisionNameFilterIcon,5);
		verifyMustExists(SubDivisionNameFilterIcon,"Sub-Division Name Filter");
		click(SubDivisionNameFilterIcon,"Sub-Division Name Filter");
		sleep(2000);
		sendKeys(SubDivisionSearch,DivisionName);
		verifyMustExists(SelectCheckbox,"Sub-Division checkbox");
		click(SelectCheckbox,"Sub-Division checkbox");
		verifyMustExists(FilterButton,"Sub-Division filter link");
		click(FilterButton,"Sub-Division filter link");
	}

	public void openRecordInEditModeSubDivision(){
		waitForElementToAppear(FirstRecord,5);
		verifyMustExists(FirstRecord,"Fitered Record");
		click(FirstRecord,"Fitered Record");
		verifyMustExists(KegalButtonToEdit,"Edit dots");
		click(KegalButtonToEdit,"Edit dots");
		waitForElementToAppear(EditSubDivisionLink,5);
		verifyMustExists(EditSubDivisionLink,"Edit link of Subdivision");
		click(EditSubDivisionLink,"Edit link of subdivision");
	}

	//Edit Sub-Division Fields
	public void EditSubDivisionFields(){
		waitForElementToAppear(EdSubDivisionName,5);
		clearTextBox(EdSubDivisionName);
		sendKeys(EdSubDivisionName,EditSubDivisionName,"Sub-Division Name field.");
		clearTextBox(EdSubDivisionReference);
		sendKeys(EdSubDivisionReference,SubDivisionReference,"Sub-Division Reference field.");
		clearTextBox(EdAddress1);
		sendKeys(EdAddress1,SubDivisionAddress1,"Sub-Division Address1 field.");
		clearTextBox(EdSubDivisionCity);
		sendKeys(EdSubDivisionCity,SubDivisionCity,"Sub-Division City field.");
		clearTextBox(EdSubDivisionPostalCode);
		sendKeys(EdSubDivisionPostalCode,SubDivisionPostalCode,"Sub-Division Postal Code field.");
		clearTextBox(EdSubDivisionState);
		sendKeys(EdSubDivisionState,SubDivisionState,"Sub-Division State field.");
		clearTextBox(EdSubDivisionTelephone);
		sendKeys(EdSubDivisionTelephone,SubDivisionPHNumber,"Sub-Division Telephone field.");			
	}

	// Save and verification of edited data
	public void SaveAndVerifyEditOperationSubDivision() throws InterruptedException
	{
		verifyMustExists(SaveButton,"Save button");
		click(SaveButton,"Save button");	
		sleep(2000);
		waitForElementToAppear(DivisionPostalCode,5);
	}

	public void openSelectedCompny() throws InterruptedException
	{
		sleep(2000);
		waitForElementToAppear(SelectedCom,5);
		verifyMustExists(SelectedCom,"Selected company"); 
		click(SelectedCom,"Selected company");
		sleep(2000);
	}

	public void navigationOnUserTab() throws InterruptedException
	{
		waitForElementToAppear(UserTab,5);
		verifyMustExists(UserTab,"User tab");
		click(UserTab,"User tab");	
		sleep(2000);
	}



	public void deactivateUser() throws InterruptedException
	{
		waitForElementToAppear(Deactivatebtn,5);
		verifyMustExists(Deactivatebtn,"Deactivate Button");
		click(Deactivatebtn,"Deactivate Button");
		sleep(3000);
		verifyMustExists(ConfirmDeactivatebtn,"Deactivate Button on Confirmation Popup");
		click(ConfirmDeactivatebtn,"Deactivate Button on Confirmation Popup");
		sleep(1000);
	} 

	public void checkDeactiveStatus() throws InterruptedException
	{
		waitForElementToAppear(DeActiveStatus,5);
		String actualDeactivetxt = getTextFrom(DeActiveStatus);
		if(actualDeactivetxt.equalsIgnoreCase(expDeactive))
		{
			Report.LogInfo("StatusCheck", "User deactivated successfully or is already inactive.", "PASS");
		}
		else
		{
			Report.LogInfo("StatusCheck", "User not deactivated successfully, status not shown as inactive.", "FAIL");
		}
	}

	public void activateUser() throws InterruptedException
	{
		waitForElementToAppear(Activatebtn,5);
		verifyMustExists(Activatebtn,"Activate button");
		click(Activatebtn,"Activate button");
		sleep(3000);
		verifyMustExists(ConfirmActivatebtn,"Activate button on Confirmation popup");
		click(ConfirmActivatebtn,"Activate button on Confirmation popup");
		sleep(1000);
	} 

	public void checkActiveStatus() throws InterruptedException
	{
		waitForElementToAppear(ActiveStatus,5);
		String actualActivetxt = getTextFrom(ActiveStatus);
		if(actualActivetxt.equalsIgnoreCase(expActive))
		{
			Report.LogInfo("StatusCheck", "User Activated successfully or is already active.", "PASS");
		}
		else
		{
			Report.LogInfo("StatusCheck", "User not activated successfully, status not shown as active.", "FAIL");
		}
	}

	public void openrecord()throws InterruptedException
	{
		sleep(3000);
		verifyMustExists(FiltedCompanyName,"Filtered Company Name");
		click(FiltedCompanyName,"Filtered Company Name");
		sleep(2000);
	}

	public void clickonUserTabAndUserButton() throws InterruptedException
	{
		waitForElementToAppear(UserTab,5);
		verifyMustExists(UserTab,"User Tab");
		sleep(1000);
		click(UserTab,"User Tab");
		sleep(2000);
		verifyMustExists(AddNewUserBtx,"User Tab");
		click(AddNewUserBtx,"User Tab");
		sleep(3000);
	}

	public void addUserDetails() throws InterruptedException
	{
		waitForElementToAppear(FirstNameTxt,5);
		verifyMustExists(FirstNameTxt,"First Name text field");
		sendKeys(FirstNameTxt,rd.getDataFromCell(path, "TestData",30,0),"First Name text field.");
		verifyMustExists(LastNameTxt,"Last Name text field");
		sendKeys(LastNameTxt,rd.getDataFromCell(path, "TestData",30,1),"Last Name text field.");
		verifyMustExists(RoleDD,"Role drop-down");
		click(RoleDD,"Role drop-down");
		click(CompanyAdminRole,"Role drop-down");
		verifyMustExists(EmailAddresstxt,"Email Address text field");
		sendKeys(EmailAddresstxt,UserEmail,"Email Address text field.");
		verifyMustExists(MobilePhoneTxt,"Mobile Phone text field");
		sendKeys(MobilePhoneTxt,rd.getDataFromCell(path, "TestData",33,1),"Mobile Phone text field.");
		verifyMustExists(WorkPhonetxt,"Work Phone text field");
		sendKeys(WorkPhonetxt,rd.getDataFromCell(path, "TestData",33,2),"Work Phone text field.");
		waitForElementToAppear(SaveBtn,5);	
		verifyMustExists(SaveBtn,"Save button");
		click(SaveBtn,"Save button");
	}

	public void verifyAddedUserDetails() throws InterruptedException
	{
		if(isVisible(VerificationFail)==true)
		{	
			Report.LogInfo("VerificationFailed", "Verification failed message displayed.", "FAIL");
		}
		else
		{
			verifyMustExists(UserDeactivatedmsg,"User Deactivated message");
			verifyExists(EmailnotVerifiedmsg,"Email not verified message");

			String actualEmailID=getTextFrom(EmailID);
			String expectedEmailID=UserEmail;	
			if(actualEmailID.equalsIgnoreCase(expectedEmailID))
			{
				Report.LogInfo("ValidateEmailAddress", "Email ID added successfully.", "PASS");
			}else{
				Report.LogInfo("ValidateEmailAddress", "Email ID not added successfully.", "FAIL");
			}

			String actualPhoneNumber=getTextFrom(PhoneNumber1);
			String expectedPhoneNumber=rd.getDataFromCell(path, "TestData",33,1);	
			if(actualPhoneNumber.equalsIgnoreCase(expectedPhoneNumber))
			{
				Report.LogInfo("ValidatePhoneNumber", "Phone number added successfully.", "PASS");
			}else{
				Report.LogInfo("ValidatePhoneNumber", "Phone number not added successfully.", "FAIL");
			}

			String actualWorkPhoneNumber=getTextFrom(WorkPhoneNumber);
			String expectedWorkPhoneNumber=rd.getDataFromCell(path, "TestData",33,2);	
			if(actualWorkPhoneNumber.equalsIgnoreCase(expectedWorkPhoneNumber))
			{
				Report.LogInfo("ValidateWorkPhoneNumber", "Work Phone Number added successfully.", "PASS");
			}else{
				Report.LogInfo("ValidateWorkPhoneNumber", "Work Phone Number not added successfully.", "FAIL");
			}
			sleep(2000);

		}
	}

	public void verifyAddedUserDetails1() throws InterruptedException
	{		CompanyPermissionPage CPP = new CompanyPermissionPage();
	if(isVisible(VerificationFail)==true)
	{	
		Report.LogInfo("VerificationFailed", "Verification failed message displayed.", "FAIL");
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		if(isVisible(CPP.BackCom)==true){
			waitForElementToAppear(CPP.BackCom,5);
			verifyMustExists(CPP.BackCom,"Back To Company Button");
			javaScriptclick(CPP.BackCom,"Back To Company Button");
		}else{
			refreshPage();
			sleep(2000);
			goBack();
		}
	}
	else
	{
		verifyMustExists(UserDeactivatedmsg,"User Deactivated message");
		verifyExists(EmailnotVerifiedmsg,"Email not verified message");

		String actualEmailID=getTextFrom(EmailID);
		String expectedEmailID=UserEmail;	
		if(actualEmailID.equalsIgnoreCase(expectedEmailID))
		{
			Report.LogInfo("ValidateEmailAddress", "Email ID added successfully.", "PASS");
		}else{
			Report.LogInfo("ValidateEmailAddress", "Email ID not added successfully.", "FAIL");
		}

		String actualPhoneNumber=getTextFrom(PhoneNumber1);
		String expectedPhoneNumber=rd.getDataFromCell(path, "TestData",33,1);	
		if(actualPhoneNumber.equalsIgnoreCase(expectedPhoneNumber))
		{
			Report.LogInfo("ValidatePhoneNumber", "Phone number added successfully.", "PASS");
		}else{
			Report.LogInfo("ValidatePhoneNumber", "Phone number not added successfully.", "FAIL");
		}

		String actualWorkPhoneNumber=getTextFrom(WorkPhoneNumber);
		String expectedWorkPhoneNumber=rd.getDataFromCell(path, "TestData",33,2);	
		if(actualWorkPhoneNumber.equalsIgnoreCase(expectedWorkPhoneNumber))
		{
			Report.LogInfo("ValidateWorkPhoneNumber", "Work Phone Number added successfully.", "PASS");
		}else{
			Report.LogInfo("ValidateWorkPhoneNumber", "Work Phone Number not added successfully.", "FAIL");
		}
		sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		if(isVisible(CPP.BackCom)==true){
			waitForElementToAppear(CPP.BackCom,5);
			verifyMustExists(CPP.BackCom,"Back To Company Button");
			javaScriptclick(CPP.BackCom,"Back To Company Button");
		}else{
			refreshPage();
			sleep(2000);
			goBack();			
		}			
	}
	}

	public void openSelectedUserInEditMode(){
		waitForElementToAppear(EditSelectedUserLink,5);
		click(EditSelectedUserLink,"Edit Selected User Link");
		verifyMustExists(EditLink,"Edit User");
		click(EditLink,"Edit User");
		sleep(2000);
	}

	public void EditMainDetailsUser(){
		waitForElementToAppear(UserFirstName,5);
		verifyMustExists(UserFirstName,"User First Name");
		clearTextBox(UserFirstName);
		sendKeys(UserFirstName,UpdateUserName,"User First Name field.");
		verifyMustExists(UserLastName,"User Last Name");
		clearTextBox(UserLastName);
		sendKeys(UserLastName,UpdateUserLastName,"User Last Name field.");
	}

	public void EditContactInformationUser(){
		waitForElementToAppear(UserMobilePhoneNumber,5);
		verifyMustExists(UserMobilePhoneNumber,"User Mobile Phone Number");
		clearTextBox(UserMobilePhoneNumber);
		sendKeys(UserMobilePhoneNumber,UpdateMobilePhone,"User Mobile Phone Number field.");
		verifyMustExists(UserWorkPhone,"User Work Phone");
		clearTextBox(UserWorkPhone);
		sendKeys(UserWorkPhone,UpdateWorkPhone, "User Work Phone Number field.");
	}

	public void saveAndVerification(){

		waitForElementToAppear(SaveButtonUser,5);
		verifyMustExists(SaveButtonUser,"User Save Button");
		click(SaveButtonUser,"User Save Button");

		javaScriptWait();
		waitToPageLoad();
		sleep(6000);
		waitForElementToAppear(EditedWorkPhoneNumber,5);

		String ActualFullName = getTextFrom(EditedFullName);
		String ActualMPhoneNumber = getTextFrom(EditedPhoneNumber);
		String ActualWorkPnone = getTextFrom(EditedWorkPhoneNumber);

		if(ActualFullName.equalsIgnoreCase(ExpectedFullName)){

			Report.LogInfo("ValidateEdit", "Full Name updated successfully.", "PASS");

		}else{

			Report.LogInfo("ValidateEdit", "Full Name not updated successfully.", "FAIL");
		}

		if(ActualMPhoneNumber.equalsIgnoreCase(ExpectedPhoneNumber)){

			Report.LogInfo("ValidateEdit", "Phone Number updated successfully.", "PASS");

		}else{

			Report.LogInfo("ValidateEdit", "Phone Number not updated successfully.", "FAIL");
		}

		if(ActualWorkPnone.equalsIgnoreCase(ExpectedWorkPnone)){

			Report.LogInfo("ValidateEdit", "Work Phone Number updated successfully.", "PASS");

		}else{

			Report.LogInfo("ValidateEdit", "Work Phone Number not updated successfully.", "FAIL");
		}

		sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		waitForElementToAppear(BacktoCompanybtn,5);
		verifyMustExists(BacktoCompanybtn,"Back to company button");
		click(BacktoCompanybtn,"Back to company button");
	}

	public void  applyFilterByUserName(String firstName)
	{

		int j=0;

		verifyMustExists(UserTab,"User Tab");
		click(UserTab,"User Tab");

		javaScriptWait();
		verifyMustExists(EmailFiltericon,"Email Filter icon");

		do
		{
			if(j>0)
			{
				refreshPage();
				javaScriptWait();
			}
			click(EmailFiltericon,"Email Filter icon");
			sleep(2000);
			if(isVisible(EmailFiltersearchtxt))
			{
				verifyMustExists(EmailFiltersearchtxt,"Email search text field");
				sendKeys(EmailFiltersearchtxt,rd.getDataFromCell(path, "TestData",33,0),"Email search text field.");
				sleep(2000);
			}
			j++;
		}while(!isVisible(checkEmailID) && j<5);

		click(checkEmailID,"Email ID check box");
		verifyMustExists(FilterBtn,"Filter button");
		click(FilterBtn,"Filter button");
		verifyMustExists(selectuser,"User First Name");
		click(selectuser,"User First Name");
	}


	/**************Add User to Division*********************/
	public void selectAddedDivision()
	{
		waitForElementToAppear(SelectDivision,5);
		verifyMustExists(SelectDivision,"Division exists");
		click(selectuser,"Select Division");
	}

	public void selectUsersTab()
	{
		waitForElementToAppear(UsersTab,5);
		verifyMustExists(UsersTab,"Users Tab");
		click(UsersTab,"Users Tab");
	}

	public void createNewUserUnderDivision()
	{
		waitForElementToAppear(AddNewUserButton,5);
		verifyMustExists(AddNewUserButton,"Add New User button");
		click(AddNewUserButton,"Add New User button");
		waitForElementToAppear(AddUsersPopUp,5);
		verifyOptionalExists(AddUsersPopUp,"Add Users pop up");
		sleep(2000);
		if(isVisible(NoDataFoundValue) == true)
		{
			Report.LogInfo("NoUserFound", "No users added for company", "FAIL");
			verifyMustExists(CancelButton,"Cancel button");
			click(CancelButton,"Cancel button");
		}
		else
		{
			Ppage.SelectDropDownValue(AddUsersDropdown, SelectUserValue);
			verifyMustExists(AddUserButton,"Add User button");
			click(AddUserButton,"Add User button");
			verifyOptionalExists(AddedUserToDivision,"Added User");
		}
		sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		waitForElementToAppear(BacktoCompanybtn,5);
		verifyMustExists(BacktoCompanybtn,"Back to company button");
		click(BacktoCompanybtn,"Back to company button");
	}
	
	public void createNewUserUnderDivisionPermission()
	{
		waitForElementToAppear(AddNewUserButton,5);
		verifyMustExists(AddNewUserButton,"Add New User button");
		click(AddNewUserButton,"Add New User button");
		waitForElementToAppear(AddUsersPopUp,5);
		verifyOptionalExists(AddUsersPopUp,"Add Users pop up");
		verifyMustExists(AddUsersDropdown,"Add Users dropdown");
		click(AddUsersDropdown,"Add Users dropdown");
		sleep(2000);
		if(isVisible(NoDataFoundValue) == true)
		{
			Report.LogInfo("NoUserFound", "No users added for company", "FAIL");
			verifyMustExists(CancelButton,"Cancel button");
			click(CancelButton,"Cancel button");
		}
		else
		{
			verifyMustExists(SelectUserValue,"Users");
			click(SelectUserValue,"Users");
			verifyMustExists(AddUserButton,"Add User button");
			click(AddUserButton,"Add User button");
			//verifyOptionalExists(AddedUserToDivision,"Added User");
		}
		sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		/*waitForElementToAppear(BacktoCompanybtn,30);
		verifyMustExists(BacktoCompanybtn,"Back to company button");
		click(BacktoCompanybtn,"Back to company button");*/
	}
	
	public void BackToComBtn()
	{
		if(isVisible(BacktoCompanybtn)==true){
		waitForElementToAppear(BacktoCompanybtn,3);
		verifyMustExists(BacktoCompanybtn,"Back to company button");
		click(BacktoCompanybtn,"Back to company button");
		}
	}
	public void VerifyEditBtnHidden()
	{
		if(isVisible(EditDots) == true)
		{
			Report.LogInfo("NoUserFound", "Edit User not hidden", "FAIL");
		}
		else
		{
			Report.LogInfo("NoUserFound", "Edit User is hidden", "PASS");
		}
	}
	public void applyContractAdministratorFilter(String ContractName){
		int i=0;
		String RecordCheckbox ="@xpath=//li//span[contains(text(),'"+ContractName+"')]";
		//sleep(3000);
		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			verifyExists(ContractNameFilter, "Contract Name Filter");
			click(ContractNameFilter, "Contract Name Filter");
			sleep(2000);
			if(isVisible(SearchFilterTxt))
			{
				verifyMustExists(SearchFilterTxt,"Search Filter Textbox");	
				sendKeys(SearchFilterTxt,ContractName,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);

		click(RecordCheckbox, "Searched Record Checkbox");
		verifyMustExists(FilterBtn,"Filter Button");	
		click(FilterBtn,"Filter Button");
	}

	public void openContractAdministrator() throws InterruptedException
	{	
		sleep(3000);
		waitForElementToAppear(SystenicsCompanyName,5);
		verifyMustExists(SystenicsCompanyName,"Filtered record");
		click(SystenicsCompanyName,"Filtered record");
		//sleep(2000);
		waitForElementToAppear(EditKebabIcon,5);
		verifyMustExists(EditKebabIcon,"Edit dots");
		click(EditKebabIcon,"Edit dots");
		verifyMustExists(EditoptionLink,"Edit link");
		click(EditoptionLink,"Edit link");
	}
	public void openExistingUserFromDivision()
	{
		if(isVisible(ExistingUser)==true){
			waitForElementToAppear(ExistingUser,3);
			verifyMustExists(ExistingUser,"Existing User record");
			click(ExistingUser,"Existing User record");			
		}else{
			Report.LogInfo("RecordCheck", "Existing User not available.", "FAIL");
		}
	}
	public void selectExistingSubDivision()
	{
		waitForElementToAppear(ExistingUserFromDivision,5);
		verifyMustExists(ExistingUserFromDivision,"Sub Division exists");
		click(ExistingUserFromDivision,"Select Sub Division");
	}
}
