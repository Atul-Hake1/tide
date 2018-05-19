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

public class DashBoardPage extends PageBase{

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("ssMsddMMyy");
		String datetime = ft.format(dNow);
		return datetime;
	}

	// Dashboard name and link
	public static final String DashboardName = "Auto_Dashboard_"+getCurrentDateTimeMS();
	public static final String DashboardName1 = "Dashboard_Auto_"+getCurrentDateTimeMS();
	public static final String DashboardLink = "@linkText=Dashboard";

	public static final String FilePath="https://app.powerbi.com/view?r=eyJrIjoiZDZiYTM0MWUtNzYwNC00OWQwLTk2ZTMtNjRmNjczOTc5ZGE4IiwidCI6ImJhMjAzYjg0LTllMmYtNGIxMC1iNDExLTFhOGU3MGI0OTBjYSIsImMiOjh9";

	//Dashboard page
	public static final String DashboardPageLbl = "@xpath=//*[@id='content']//div[text()='Dashboard']";
	public static final String AddDashboardBtn = "@xpath=//*[@ng-click='openAddEditPopup()']";

	//Add Dashboard page details
	public static final String DashboardNameTxt = "@xpath=//*[@ng-model='data.Name']";
	public static final String DescriptionTxt = "@xpath=//*[@ng-model='data.Description']";
	public static final String CategoryDD="@xpath=//*[@ng-hide='loading1']//dl[3]//div[@class='form-group']";
	public static final String CategoryDDValue = "@xpath=//li[contains(text(),'Bordereaux')]";
	public static final String CompanyDD="@xpath=//*[@ng-if='isTideAdmin']//div[@class='form-group']";
	public static final String CompanyDDValue = "@xpath=//li[contains(text(),'ACE Underwriting Agencies Limited')]";
	public static final String FilePathTxt="@xpath=//*[@ng-model='data.FilePath']";
	public static final String IsActiveYesfld="@xpath=//*[@ng-model='data.IsActive'][@value='true']/..";
	public static final String IsActiveYesRadiobtn="@xpath=//*[@ng-model='data.IsActive'][@value='true']/../i";
	public static final String SaveBtn="@buttonText=Save";
	public static final String SaveChangesBtn="@buttonText=Save Changes";

	//DashboardName Filter
	public static final String NameFilter ="@xpath=//th[@data-title='Name']//a//span";
	public static final String SearchFilterTxt ="@css=[placeholder='Search']";
	public static final String FilterBtn="@buttonText=Filter";
	public static final String EditDashboardbtn ="@xpath=//*[@ng-click='openAddEditPopup(dataItem)']";
	public static final String AddedDashboard = "@xpath=//td[text()='"+DashboardName+"']";
	public static final String EditedDashboard = "@xpath=//td[text()='"+DashboardName1+"']";
	public static final String OriginalValueFilter ="@xpath=//th[@data-title='Original Value']//a//span";

	public void addDashboard_3379() throws InterruptedException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		dashboardLink();
		dashboardPage();
		addNewDashboard();
		waitForElementToAppear(DashboardNameTxt,5);
		verifyMustExists(DashboardNameTxt,"Dashboard Name Textbox");	
		sendKeys(DashboardNameTxt,DashboardName,"Dashboard Name field.");
		verifyMustExists(DescriptionTxt,"Description Textbox");	
		sendKeys(DescriptionTxt,"Autodashboard","Description field.");
		verifyMustExists(CategoryDD,"Category Dropdown");	
		click(CategoryDD,"Category Dropdown");
		javaScriptWait();
		verifyMustExists(CategoryDDValue,"Bordereaux Dropdown Value");	
		click(CategoryDDValue,"Bordereaux Dropdown Value");
		verifyMustExists(CompanyDD,"Company Dropdown");	
		click(CompanyDD,"Company Dropdown");
		javaScriptWait();
		verifyMustExists(CompanyDDValue,"ACE Underwriting Agencies Limited Dropdown Value");	
		click(CompanyDDValue,"ACE Underwriting Agencies Limited Dropdown Value");
		verifyMustExists(FilePathTxt,"FilePath text field");
		sendKeys(FilePathTxt,FilePath,"Description field.");
		verifyMustExists(IsActiveYesfld,"Is Active Yes field.");
		verifyMustExists(IsActiveYesRadiobtn,"Is Active Yes radio button");
		click(IsActiveYesRadiobtn,"Yes button");		
		verifyMustExists(SaveBtn,"Save button");
		click(SaveBtn,"Save button");
		dashboardPage();
		applyNameFilter(DashboardName);
		if(isVisible(AddedDashboard)==true){
			verifyDashboard(AddedDashboard);
			Report.LogInfo("AddedDashboardValidation", "Added dashboard validate successfully", "PASS");

		}else{
			Report.LogInfo("AddedDashboardValidation", "Added dashboard not validate successfully", "FAIL");				

		}

	}


	public void editDashboard_3380() throws InterruptedException
	{
		selectEditDashboard();
		waitForElementToAppear(DashboardNameTxt,5);
		verifyMustExists(DashboardNameTxt,"Dashboard Name Textbox");	
		sendKeys(DashboardNameTxt,DashboardName1,"Dashboard Name field.");
		verifyMustExists(SaveChangesBtn,"Save button");
		click(SaveChangesBtn,"Save button");
		sleep(3000);
		refreshPage();
		dashboardPage();
		applyNameFilter(DashboardName1);
		if(isVisible(EditedDashboard)==true){
			verifyDashboard(EditedDashboard);
			Report.LogInfo("EditedDashboardValidation", "Edited dashboard validate successfully", "PASS");	
		}else{
			Report.LogInfo("EditedDashboardValidation", "Edited dashboard not validate successfully", "FAIL");				
		}

	}



	//==============================================================Reusable function=========================================================

	public void dashboardLink()
	{
		waitForElementToAppear(DashboardLink,5);
		verifyMustExists(DashboardLink,"Dashboard Link");
		click(DashboardLink,"Dashboard Link");
	}

	public void dashboardPage()
	{
		if(isVisible(DashboardPageLbl)==true)
		{
			waitForElementToAppear(DashboardPageLbl,5);
			verifyMustExists(DashboardPageLbl,"Dashboard Lbl");
		}else
		{
			Report.LogInfo("validatedashboardpage", "Dashboard page not displayed", "FAIL");
		}
	}

	public void addNewDashboard()
	{
		if(isVisible(AddDashboardBtn)==true){
			waitForElementToAppear(AddDashboardBtn,5);
			verifyMustExists(AddDashboardBtn,"Add Dashboard Button");	
			click(AddDashboardBtn,"Add Dashboard Button");
		}else{
			Report.LogInfo("validateAddDashboardbutton", "Add Dashboard button not displayed", "FAIL");
		}
	}

	public void applyNameFilter (String DBName){
		int i=0;
		String RecordCheckbox ="@xpath=//li//span[contains(text(),'"+DBName+"')]";
		//sleep(3000);
		javaScriptWait();
		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(NameFilter, "Name Filter");
			sleep(2000);
			if(isVisible(SearchFilterTxt))
			{
				verifyMustExists(SearchFilterTxt,"Search Filter Textbox");	
				sendKeys(SearchFilterTxt,DBName,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);

		click(RecordCheckbox, "Searched Record Checkbox");
		verifyMustExists(FilterBtn,"Filter Button");	
		click(FilterBtn,"Filter Button");
	}

	public void selectEditDashboard()
	{
		if(isVisible(EditDashboardbtn)==true){
			waitForElementToAppear(EditDashboardbtn,5);
			verifyMustExists(EditDashboardbtn,"Edit Dashboard Button");	
			click(EditDashboardbtn,"Edit Dashboard Button");
		}else{
			Report.LogInfo("validateEditDashboardbutton", "Edit Dashboard button not displayed", "FAIL");
		}

	}

	public void verifyDashboard(String dashboardName)
	{
		if(isVisible(dashboardName)==true){
			waitForElementToAppear(dashboardName,5);
			verifyMustExists(dashboardName,"Verify dashboard Name ");
		}else{
			Report.LogInfo("validatedashboardname", "Dashboard name not displayed", "FAIL");
		}
	}



}