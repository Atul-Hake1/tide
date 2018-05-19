package com.tide.qa.pagefactory;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Report;

public class ContractMetadataPage extends PageBase{

	LoginPage loginPage = new LoginPage();

	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("ssMsddMMyy");
		String datetime = ft.format(dNow);
		return datetime;
	}
	public static String getCurrentDateTimeMS1() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MMyyssMsdd");
		String datetime = ft.format(dNow);
		return datetime;
	}


	public static final String AdminTab = "@xpath=//*[@class='dropdown ng-scope dropdown-toggle']";
	public static final String ContractMetaData = "@xpath=//*[text()='Contract Metadata']";
	//public static final String AddNewItem ="@xpath=//*[@class='btn btn-primary ng-scope waves-effect waves-light']";
	public static final String AddNewItem ="@xpath=//div[@ng-click='addOrEditContractMetaDataPopup()']";
	public static final String selectCategory="@xpath=//div[@class='modal-content']//descendant::*[@class='k-input ng-scope'][1]";
	public static final String CategorydrpValue="@xpath=//*[@class='k-list k-reset']//*[text()='General']";
	public static final String selectCompany="@xpath=//div[@class='modal-content']//descendant::*[@class='k-input ng-scope'][2]";
	public static final String CompanydrpValue="@xpath=//*[@class='k-list k-reset']//*[text()='Aspen Managing Agency Limited']";
	public static final String FieldName="@model=data.DisplayFieldName";
	public static final String DatawareHousedName="@xpath=//*[@ng-model='data.DataWarehouseName']";
	public static final String selectType="@xpath=//*[@ng-model='data.Type']//preceding-sibling::span//span[@class='k-icon k-i-arrow-60-down']";
	public static final String TypedrpValue="@xpath=//ul[@class='k-list k-reset']//*[text()='String']";
	public static final String MandatoryYesBtn = "@xpath=//dd[@class='p-t-10']//descendant::label[@class='radio radio-inline m-r-20'][1]/input[@name='IsMandatory']";
	public static final String ActiveYesBtn = "@xpath=//dd[@class='p-t-10']//descendant::label[@class='radio radio-inline m-r-20'][1]/input[@name='IsActive']";
	public static final String selectDisplayOrder="@xpath=//*[@ng-model='data.DisplayOrder']//preceding-sibling::span//span[@class='k-icon k-i-arrow-60-down']";
	public static final String DisplayOrderdrpValue="@xpath=//*[@class='k-list k-reset']//*[text()='1']";
	public static final String Savebutton="@xpath=//button[contains(text(),'Save')]";

	//Name Filter
	public static final String NameFilter ="@xpath=//th[@data-title='Name']//a//span";
	public static final String SearchFilterTxt ="@css=[placeholder='Search']";
	public static final String FilterBtn="@buttonText=Filter";
	public static final String ClearBtn="@buttonText=Clear";
	public static final String PageDown ="@xpath=//*[@id='grid']//div[@data-role='pager']//span[@class='k-select']/span";
	public static final String Page100 ="@xpath=//li[contains(.,'100')]";
	// Metadata name after filter

	//Edit Contract Meta data
	//public static final String EditMedata="@xpath=//tbody/tr[1]/td[1]/div";
	public static final String EditCategory="@xpath=//div[@class='modal-content']//descendant::*[@class='k-input ng-scope'][1]"; 
	public static final String EditCategorydrpValue="@xpath=//*[@class='k-list k-reset']//*[text()='Underwriting']";
	public static final String EditCompany="@xpath=//div[@class='modal-content']//descendant::*[@class='k-input ng-scope'][2]";
	public static final String EditCompanydrpValue="@xpath=//*[@class='k-list k-reset']//*[text()='Ascot']";
	public static final String EditFieldName="@xpath=//*[@ng-model='data.DisplayFieldName']";
	public static final String EditDatawareHousedName="@xpath=//*[@ng-model='data.DataWarehouseName']";
	public static final String EditselectType="@xpath=//*[@ng-model='data.Type']//preceding-sibling::span//span[@class='k-icon k-i-arrow-60-down']";
	public static final String EditTypedrpValue="@xpath=//ul[@class='k-list k-reset']//*[text()='Money']";
	public static final String EditMandatoryYesBtn = "@xpath=//dd[@class='p-t-10']//descendant::label[@class='radio radio-inline m-r-20'][1]/input[@name='IsMandatory']";
	public static final String EditActiveYesBtn = "@xpath=//dd[@class='p-t-10']//descendant::label[@class='radio radio-inline m-r-20'][1]/input[@name='IsActive']";
	public static final String EditselectDisplayOrder="@xpath=//*[@ng-model='data.DisplayOrder']//preceding-sibling::span//span[@class='k-icon k-i-arrow-60-down']";
	public static final String EditDisplayOrderdrpValue="@xpath=//*[@class='k-list k-reset']//*[text()='2']";
	public static final String EditSaveChanges="@xpath=//button[contains(text(),'Save Changes')]";

	//Test case 3183 :- Add Contract Meta data
	public void addMetadata() throws InterruptedException
	{
		navigationOnAdminTab();
		navigationOnSelectContractMetadataOption();
		navigationOnAddNewItemPopup();
		addNewItemDetails();
		//applyMetadataNameFilter(Name);
	}

	//Test case 3184 :- Edit Existing Metadata
	public void EditMetadata() throws InterruptedException
	{
		String Name = "Automation"+getCurrentDateTimeMS();
		String DataWareHouseName = "Test Automation"+getCurrentDateTimeMS1();
		String EditMedata="@xpath=.//*[@id='grid']//div[2]//tr[1]//div[@ng-if='Permission.Edit']";

		navigationOnAdminTab();
		navigationOnSelectContractMetadataOption();

		verifyMustExists(PageDown,"Pagination down button");
		click(PageDown,"Pagination down button");
		verifyMustExists(Page100,"Pagination down button");
		click(Page100,"Pagination down button");
		sleep(2000);
		if(isVisible(EditMedata)==true){
			javaScriptclick(EditMedata,"Edit button");
			//sleep(1000);
			SelectDropDownValue(EditCategory, EditCategorydrpValue);

			verifyMustExists(EditFieldName,"Metadata Name");
			sendKeys(EditFieldName,Name,"Metadata Name");
			//Thread.sleep(1000);
			SelectDropDownValue(EditselectType, EditTypedrpValue);

			javaScriptclick(EditMandatoryYesBtn,"Mandatory Radio button");
			javaScriptclick(EditActiveYesBtn,"Yes Radio button");
			SelectDropDownValue(EditselectDisplayOrder, EditDisplayOrderdrpValue);

			verifyMustExists(EditSaveChanges,"Save button");
			click(EditSaveChanges,"Save button");
			Thread.sleep(5000);
			String FilteredMetadataName="@xpath=//tbody/tr/td[contains(.,'"+Name+"')]";
			if(isVisible(FilteredMetadataName) == true)
			{
				Report.LogInfo("MetadataEditValidation","Metadata edited successfully.", "PASS");
			}else
			{
				Report.LogInfo("MetadataEditValidation","Metadata not edited properly or edited metadata not searched.", "FAIL");
			}
		}else
		{
			Report.LogInfo("EditCheck","Value is not available for Edit", "FAIL");
		}
	}

	public void navigationOnAdminTab() throws InterruptedException
	{
		verifyMustExists(AdminTab,"Admin tab");
		click(AdminTab,"Admin tab");
		//Thread.sleep(2000);

	}
	public void navigationOnSelectContractMetadataOption() throws InterruptedException
	{
		verifyMustExists(ContractMetaData,"Contract MetaData Dropdown option");
		click(ContractMetaData,"Contract Metadata Dropdown option");
		//Thread.sleep(3000);
	}
	public void navigationOnAddNewItemPopup() throws InterruptedException
	{
		verifyMustExists(AddNewItem,"Add New Item Button");
		click(AddNewItem, "Add New Item Button");
		//Thread.sleep(2000);
	}
	public void addNewItemDetails() throws InterruptedException
	{
		String Name = "Automation"+getCurrentDateTimeMS();
		String DataWareHouseName = "Test Automation"+getCurrentDateTimeMS1();
		SelectDropDownValue(selectCategory, CategorydrpValue);

		if(isVisible(FieldName)==true){
			verifyMustExists(FieldName,"Metadata Name");
			sendKeys(FieldName,Name,"Metadata Name.");
		}

		if(isVisible(selectCompany)==true)
		{
			verifyMustExists(selectCompany,"Company dropdown");
			click(selectCompany,"Company dropdown");
			sleep(1500);
			if(isVisible(CompanydrpValue)==true)
			{
				verifyMustExists(CompanydrpValue,"Company Dropdown Value");
				click(CompanydrpValue,"Company Dropdown Value");
			}
		}

		verifyMustExists(DatawareHousedName,"Data Warehouse Name");
		sendKeys(DatawareHousedName,DataWareHouseName,"Data Warehouse Name");
		SelectDropDownValue(selectType, TypedrpValue);
		javaScriptclick(MandatoryYesBtn,"Mandatory Radio Button");
		javaScriptclick(ActiveYesBtn,"Yes Radio Button");
		SelectDropDownValue(selectDisplayOrder, DisplayOrderdrpValue);
		verifyMustExists(Savebutton,"Save Button");
		click(Savebutton,"Save Button");
		//Thread.sleep(2000);

	}


	public void applyMetadataNameFilter (String MetadataName)
	{
		int i=0;
		String RecordCheckbox ="@xpath=//li//span[contains(text(),'"+MetadataName+"')]";
		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				waitForElementToAppear(NameFilter,5);
			}
			clickAndWait(NameFilter, "Metadata Name Filter");
			//sleep(2000);
			if(isVisible(SearchFilterTxt))
			{
				verifyMustExists(SearchFilterTxt,"Search Filter Textbox");	
				sendKeys(SearchFilterTxt,MetadataName,"Search Filter Textbox.");
				//sleep(2000);
			}
			i++;
		}while(!isVisible(FilterBtn) && i<5);

		if(isVisible(RecordCheckbox))
		{
			click(RecordCheckbox, "Searched Metadata Record Checkbox");
			verifyMustExists(FilterBtn,"Filter Button");	
			click(FilterBtn,"Filter Button");
			//verifyMustExists(FilteredMetadataName,"Searched Metadata Record.");
		}else
		{
			Report.LogInfo("MetadataRecord","Searched Metadata Record not found after entering details in filter textbox.", "FAIL");
		}

	}

}