package com.tide.qa.pagefactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import com.jprotractor.NgBy;
import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;

public class DatasetReferenceDataPage extends PageBase{

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("ssMsddMMyy");
		String datetime = ft.format(dNow);
		return datetime;
	}

	String FieldName;

	//DataSet ReferenceData name and link
	public static final String DatasetReferenceDataName = "AutoBenifit_"+getCurrentDateTimeMS();
	public static final String DatasetReferenceDataLink = "@linkText=Reference Data";

	//DataSet Reference Data page 
	public static final String DatasetReferenceDataPageLbl = "@xpath=//*[@id='content']//div[text()=' Reference Data']";
	public static final String AddDatasetReferenceDataBtn = "@xpath=//*[@ng-click='addData()']";

	//Add Dataset Reference Data page details
	public static final String DatasetReferenceDataNameTxt = "@xpath=//*[@ng-model='data.Name']";
	public static final String DescriptionTxt = "@xpath=//*[@ng-model='data.Description']";
	public static final String DatasetTypeDD="@css=.k-input.ng-scope";
	public static final String PremiumDDValue = "@xpath=//li[contains(text(),'Premium')]";
	public static final String SaveBtn="@buttonText=Save";
	public static final String VerifyDatasetReferenceData = "@xpath=//*[text()='"+DatasetReferenceDataName+"']";
	public static final String Pagination20 = "@xpath=//*[@id='grid']//span[text()='20']";
	public static final String Pagination100 = "@xpath=//li[contains(.,'100')]";

	//Value Page
	public static final String AddValueBtn = "@xpath=//*[@ng-click='addData()']";
	public static final String InputValueTxt = "@xpath=//*[@ng-model='data.InputValue']";
	public static final String VerifyAddValue = "@xpath=//*[text()='Autovalue 1']";

	//Mapping page
	public static final String MappingsTab = "@xpath=//*[text()='Mappings']";
	public static final String NewMappingBtn = "@xpath=//*[@ng-click='addData()']";
	public static final String MapToDD="@css=.k-input.ng-scope";
	public static final String Autovalue1DDValue = "@xpath=//li[contains(text(),'Autovalue 1')]";
	public static final String VerifyCreatedMapping = "@xpath=//*[text()='Mapping Value']";

	public static final String OriginalValueFilter ="@xpath=//th[@data-title='Original Value']//a//span";
	public static final String SearchFilterTxt ="@css=[placeholder='Search']";
	public static final String FilterBtn="@buttonText=Filter";

	//TC-4027:-Locators
	public static final String DatasetLink = "@xpath=//a[text()='Datasets']";
	public static final String AddNewFieldsButton = "@xpath=//div[@ng-click='openFieldPopup()']";
	public static final String FieldName1 = "@xpath=//input[@ng-model='fieldData.DisplayFieldName']";
	public static final String DataBaseFieldName = "@xpath=//input[@ng-model='fieldData.DbFieldName']";
	public static final String FieldDescription = "@xpath=//input[@ng-model='fieldData.FieldDescription']";
	public static final String SchemaTypeDropDwn = "@xpath=//*[@ng-model='fieldData.schemaType']//preceding-sibling::span";
	public static final String SelectOptionSchemaTypeDropDwn = "@xpath=//li[text()='Bordereaux']";
	public static final String SystemCategoryDropDwn = "@xpath=//*[@ng-model='fieldData.Category']//preceding-sibling::span";
	public static final String FieldTypeDropDwn = "@xpath=//*[@ng-model='fieldData.FieldType']//preceding-sibling::span";
	public static final String SelectOptionFieldTypeDropDwn = "@xpath=//li[contains(.,'Risk And Premium')]";
	public static final String SelectOptionSystemCategoryDropDwn = "@xpath=//li[text()='Occupancy']";
	public static final String SelectOptionSystemCategoryDropDwn1 = "@xpath=//li[text()='Construction']";
	public static final String DataTypeDropDwn = "@xpath=//*[@ng-model='fieldData.DataTypeId']//preceding-sibling::span";
	public static final String SelectOptionDataTypeDropDwn = "@xpath=//li[text()='String']";
	public static final String ValueIfNullDropDwn = "@xpath=//*[@ng-model='fieldData.ValueIfNull']//preceding-sibling::span";
	public static final String SelectOptionValueIfNullDropDwn = "@xpath=//li[text()='null']";
	public static final String SelectOptionValueIfDefaultValueDropDwn = "@xpath=//li[text()='Default Value']";
	public static final String MandatoryNoradioButton = "@xpath=//input[@ng-model='fieldData.IsMandatory'][@value='false']//parent::label";
	public static final String SourceDataStandard = "@xpath=//input[@ng-model='fieldData.SrcDataStd']";
	public static final String SourceDataStandardReference = "@xpath=//input[@ng-model='fieldData.SrcDataStdReference']";
	public static final String MDMReference = "@xpath=//input[@ng-model='fieldData.MdmReference']";
	public static final String MapFieldDropDwn = "@xpath=//*[@ng-model='fieldData.CategoryFieldName']//preceding-sibling::span";
	public static final String SelctOptionMapFieldDropDwn = "@xpath=//li[contains(.,'Occupancy Description')]";
	public static final String SelctOptionMapFieldDropDwn1 = "@xpath=//li[contains(.,'Construction Schema')]";
	public static final String AddFieldsPopupSaveButton = "@xpath=//button[@ng-click='save()']";
	public static final String AddFieldsPopupSaveChangesButton = "@xpath=//span[@ng-click='saveChanges()']";
	public static final String WarningMessage = "@xpath=//span[contains(.,' Warning! You made changes, please save changes.')]";
	public static final String FieldNameLinkOfRecords = "@xpath=//*[@data-field='DisplayFieldName']//a[contains(.,'Field Name')]";
	public static final String ErrorMessage = "@xpath=//div[@ng-if='hasError']//div[contains(.,'{ Category = Occupancy, CategoryFieldName = DescriptionValue }, can only be mapped with one field')]";
	public static final String ErrorMessageRiskPremium = "@xpath=//div[@ng-if='hasError']//div[contains(.,'{ Category = Construction, CategoryFieldName = SchemaValue }, can only be mapped with one field')]";

	//Locators:- TC_4023
	public static final String RiskAndPremiumLink = "@xpath=//td[contains(.,'Risk And Premium')]";
	public static final String InteresrDropDwn = "@xpath=//*[@ng-model='fieldData.InterestPerilId']//preceding-sibling::span";
	public static final String SelectOptionInteresrDropDwn = "@xpath=//li[text()='Buildings']";
	public static final String FieldGroupingDropDwn = "@xpath=//*[@ng-model='fieldData.LookupId']//preceding-sibling::span";
	public static final String SelectOptionFieldGroupingDropDwn = "@xpath=//li[text()='Additional Details'][1]";
	public static final String ClaimLink = "@xpath=//td[text()='Claim']";
	public static final String EditKebabThreeDotsLink = "@xpath=//a[@class='dropdown-toggle']";
	public static final String EditLink = "@xpath=//a[text()='Edit']";
	public static final String DefaultValueTextBox = "@xpath=//input[@ng-model='fieldData.DefaultValue']";
	
	public static final String FieldNameFilter ="@xpath=//th[@data-title='Field Name']//a[1]//span";
	public static final String SearchTxt ="@xpath=//input[@placeholder='Search']";


	public void addDatasetReference_3381() throws InterruptedException
	{
		homePage.adminMenu();
		DatasetReferenceDataLink();
		DatasetReferenceDatapage();
		addNewDatasetReferenceData();
		waitForElementToAppear(DatasetReferenceDataNameTxt,5);
		verifyMustExists(DatasetReferenceDataNameTxt,"Dataset Reference Data Name Textbox");	
		sendKeys(DatasetReferenceDataNameTxt,DatasetReferenceDataName,"Dataset Reference Data Name field.");
		verifyMustExists(DescriptionTxt,"Description Textbox");	
		sendKeys(DescriptionTxt,"Automation Dataset Reference Data","Description field.");
		verifyMustExists(DatasetTypeDD,"DataSet Type Dropdown");	
		click(DatasetTypeDD,"DataSet Type Dropdown");
		sleep(2000);
		verifyMustExists(PremiumDDValue,"Premium Dropdown Value");	
		click(PremiumDDValue,"Premium Dropdown Value");
		verifyMustExists(SaveBtn,"Save button");
		click(SaveBtn,"Save button");
		sleep(2000);
		verifyMustExists(Pagination20,"Pagination 20");
		click(Pagination20,"Pagination 20");
		verifyMustExists(Pagination100,"Pagination 100");
		click(Pagination100,"Pagination 100");
		sleep(2000);
		DatasetReferenceDatapage();
		if(isVisible(VerifyDatasetReferenceData) == true){
			Report.LogInfo("ValidateAddedDatasetReferenceData", "Dataset Reference Data Added successfully", "PASS");

		}else{
			Report.LogInfo("ValidateAddedDatasetReferenceData", "Dataset Reference Data not Added successfully", "FAIL");
		}	
	}

	public void addvalueDatasetReference_3382() throws InterruptedException
	{
		/*homePage.adminMenu();
		DatasetReferenceDataLink();*/
		DatasetReferenceDatapage();
		if(isVisible(VerifyDatasetReferenceData) == true){
			Report.LogInfo("ValidateAddedDatasetReferenceData", "Verify Dataset Reference Data Added", "PASS");
			verifyMustExists(VerifyDatasetReferenceData,"AddedDatasetReferenceData");
			click(VerifyDatasetReferenceData,"Dataset Reference Data");
			addValue();
			waitForElementToAppear(InputValueTxt,5);
			verifyMustExists(InputValueTxt,"Input value Textbox ");
			sendKeys(InputValueTxt,"Autovalue 1","Input value");
			verifyMustExists(SaveBtn,"Save button");
			click(SaveBtn,"Save button");
			if(isVisible(VerifyAddValue) == true){
				Report.LogInfo("VerifyAddedValue", "Value added successfully", "PASS");
			}else{
				Report.LogInfo("VerifyAddedValue", "Value not added successfully", "FAIL");
			}	
		}else{
			Report.LogInfo("ValidateAddedDatasetReferenceData", "Dataset Reference Data not Added ", "FAIL");
		}
	}


	public void mappingReferenceDataset_3383() throws InterruptedException
	{
		homePage.adminMenu();
		DatasetReferenceDataLink();
		DatasetReferenceDatapage();
		sleep(2000);
		verifyMustExists(Pagination20,"Pagination 20");
		click(Pagination20,"Pagination 20");
		verifyMustExists(Pagination100,"Pagination 100");
		click(Pagination100,"Pagination 100");
		sleep(2000);
		if(isVisible(VerifyDatasetReferenceData) == true){
			Report.LogInfo("ValidateAddedDatasetReferenceData", "Verify Dataset Reference Data Added ", "PASS");
			verifyMustExists(VerifyDatasetReferenceData,"AddedDatasetReferenceData");
			click(VerifyDatasetReferenceData,"Dataset Reference Data");
			selectMappingsTab();
			waitForElementToAppear(NewMappingBtn,5);
			verifyMustExists(NewMappingBtn,"New Mapping Button");
			click(NewMappingBtn,"New Mapping Button");
			waitForElementToAppear(InputValueTxt,5);
			verifyMustExists(InputValueTxt,"Input value Textbox ");
			sendKeys(InputValueTxt,"Mapping Value"," Input value");
			verifyMustExists(MapToDD,"Map dropdown");
			//click(MapToDD,"Map dropdown");
			clickondropdown(MapToDD);
			javaScriptWait();
			verifyMustExists(Autovalue1DDValue," Autovalue 1 dropdown value");
			click(Autovalue1DDValue,"Autovalue 1 dropdown value");
			verifyMustExists(SaveBtn,"Save button");
			click(SaveBtn,"Save button");
			if(isVisible(VerifyCreatedMapping) == true){
				Report.LogInfo("VerifyCreatedMapping", "Mapping created successfully", "PASS");
			}else{
				Report.LogInfo("VerifyCreatedMapping", "Mapping not created successfully", "FAIL");
			}		
		}
		else{
			Report.LogInfo("ValidateAddedDatasetReferenceData", "Dataset Reference Data not Added", "FAIL");
		}			
	}

	public void AddClaimFields_4027() throws Exception{
		FieldName ="Automation_claim_field_1"+getCurrentTime();
		String DatabaseFieldName1 = "Automation_claim_field_1";
		String FieldDescription1 = "Automation_claim_field_1";
		String SchemaType = "Bordereaux";
		String FieldTypeSystemCategory = "Occupancy";
		String MappedField = "Occupancy Description";
		// String DataType = "String";
		String ValueIfNull = "null";

		homePage.adminMenu(); 
		waitForElementToAppear(DatasetLink,5);
		verifyMustExists(DatasetLink,"Dataset link");
		click(DatasetLink,"Data set link");
		sleep(3000);
		SelectClaim();
		EditingClaim();
		AddClaimFields(FieldName,DatabaseFieldName1,FieldDescription1,SchemaType,FieldTypeSystemCategory,MappedField,ValueIfNull);		 
	}

	public void AddRiskPremiumFields_4023() throws Exception{
		FieldName ="Automation_field_1"+getCurrentTime();
		String DatabaseFieldName1 = "Automation_field_1";
		String FieldDescription1 = "Automation_field_1";
		String SchemaType = "Bordereaux";
		String FieldType = "Risk And Premium";
		String SystemCategory ="Construction";
		String MappedField = "Construction Schema";
		String ValueIfNull = "Default Value";
		String Interest = "Buildings";
		String FieldGrouping = "Additional Details";

		homePage.adminMenu();
		waitForElementToAppear(DatasetLink,5);
		verifyMustExists(DatasetLink,"Dataset link");
		click(DatasetLink,"Data set link");
		sleep(3000);
		SelectRiskAndPremium();
		EditingClaim();
		AddClaimFieldsForRiskAndPremium(FieldName,DatabaseFieldName1,FieldDescription1,SchemaType,FieldType,SystemCategory,MappedField,ValueIfNull,Interest,FieldGrouping);
	}


	//========================================= Reusable function ===============================================================================================================//	
	public void SelectClaim(){
		waitForElementToAppear(ClaimLink,5);
		verifyMustExists(ClaimLink,"Claim link");
		click(ClaimLink,"Claim link");		 
	}

	public void EditingClaim(){
		waitForElementToAppear(EditKebabThreeDotsLink,5);
		verifyMustExists(EditKebabThreeDotsLink,"EditKebabThreeDotsLink");
		click(EditKebabThreeDotsLink,"EditKebabThreeDotsLink");
		waitForElementToAppear(EditLink,5);
		verifyMustExists(EditLink,"EditLink");
		click(EditLink,"EditLink");
	}

	public void AddClaimFields(String FieldName2,String DataBaseFieldName2,String FieldDescription2, String SchemaType1,String FieldTypeSystemCategory1,String MappedField1 ,String ValueIfNull1 ){
		String SourceDataStandard1 = "Automation_claim_field_1";
		String SourceDataStandardReference1 = "Automation_claim_field_1";
		String MOMReference1 = "Automation_claim_field_1";
		String AddedFieldName = "//*[@ng-bind='dataItem.DisplayFieldName'][contains(.,'"+FieldName+"')]";

		waitForElementToAppear(AddNewFieldsButton,5);
		verifyMustExists(AddNewFieldsButton,"AddNewFieldsButton");
		click(AddNewFieldsButton,"AddNewFieldsButton");
		waitForElementToAppear(FieldName1,5);
		verifyMustExists(FieldName1,"FieldName1");
		sendKeys(FieldName1, FieldName2, "Enter FieldName");
		waitForElementToAppear(DataBaseFieldName,5);
		verifyMustExists(DataBaseFieldName,"DataBaseFieldName");
		sendKeys(DataBaseFieldName, DataBaseFieldName2, "Enter DataBaseFieldName");
		waitForElementToAppear(FieldDescription,5);
		verifyMustExists(FieldDescription,"FieldDescription");
		sendKeys(FieldDescription, DataBaseFieldName2, "Enter FieldDescription");
		waitForElementToAppear(SchemaTypeDropDwn,5);
		verifyMustExists(SchemaTypeDropDwn,"SchemaTypeDropDwn");
		click(SchemaTypeDropDwn,"SchemaTypeDropDwn");
		//sleep(1000);
		waitForElementToAppear(SelectOptionSchemaTypeDropDwn,5);
		verifyMustExists(SelectOptionSchemaTypeDropDwn,"SelectOptionSchemaTypeDropDwn");
		webDriver.findElement(By.xpath("//li[text()='"+SchemaType1+"']")).click();
		waitForElementToAppear(SystemCategoryDropDwn,5);
		verifyMustExists(SystemCategoryDropDwn,"SystemCategoryDropDwn");
		click(SystemCategoryDropDwn,"SystemCategoryDropDwn");
		// sleep(1000);
		waitForElementToAppear(SelectOptionSystemCategoryDropDwn,5);
		verifyMustExists(SelectOptionSystemCategoryDropDwn,"SelectOptionSystemCategoryDropDwn");
		webDriver.findElement(By.xpath("//li[text()='"+FieldTypeSystemCategory1+"']")).click();
		sleep(3000);
		waitForElementToAppear(MapFieldDropDwn,5);
		verifyMustExists(MapFieldDropDwn,"MapFieldDropDwn");
		click(MapFieldDropDwn,"MapFieldDropDwn");
		//sleep(2000);
		waitForElementToAppear(SelctOptionMapFieldDropDwn,5);
		verifyMustExists(SelctOptionMapFieldDropDwn,"SelctOptionMapFieldDropDwn");
		webDriver.findElement(By.xpath("//li[text()='"+MappedField1+"']")).click();
		waitForElementToAppear(ValueIfNullDropDwn,5);
		verifyMustExists(ValueIfNullDropDwn,"ValueIfNullDropDwn");
		click(ValueIfNullDropDwn,"ValueIfNullDropDwn");
		// sleep(2000);
		waitForElementToAppear(SelectOptionValueIfNullDropDwn,5);
		verifyMustExists(SelectOptionValueIfNullDropDwn,"SelectOptionValueIfNullDropDwn");
		webDriver.findElement(By.xpath("//li[text()='"+ValueIfNull1+"']")).click();
		waitForElementToAppear(MandatoryNoradioButton,5);
		verifyMustExists(MandatoryNoradioButton,"MandatoryNoradioButton");
		click(MandatoryNoradioButton,"MandatoryNoradioButton");
		waitForElementToAppear(SourceDataStandard,5);
		verifyMustExists(SourceDataStandard,"SourceDataStandard");
		sendKeys(SourceDataStandard, SourceDataStandard1, "Enter SourceDataStandard");
		waitForElementToAppear(SourceDataStandardReference,5);
		verifyMustExists(SourceDataStandardReference,"SourceDataStandardReference");
		sendKeys(SourceDataStandardReference, SourceDataStandardReference1, "Enter SourceDataStandardReference");
		waitForElementToAppear(MDMReference,5);
		verifyMustExists(MDMReference,"MDMReference");
		sendKeys(MDMReference, MOMReference1, "Enter MDMReference");
		waitForElementToAppear(ValueIfNullDropDwn,5);
		verifyMustExists(AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		click(AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		sleep(4000);
		waitForElementToAppear(WarningMessage,5);
		verifyMustExists(WarningMessage,"WarningMessage");
		// waitForElementToAppear(ValueIfNullDropDwn,5);*/
		verifyMustExists(AddFieldsPopupSaveChangesButton,"AddFieldsPopupSaveChangesButton");
		click(AddFieldsPopupSaveChangesButton,"AddFieldsPopupSaveChangesButton");
		sleep(2000);
	}	

	
	public void AddClaimFieldsForRiskAndPremium(String FieldName2,String DataBaseFieldName2,String FieldDescription2, String SchemaType1,String FieldType1,String SystemCategory1,String MappedField1 ,String ValueIfNull1,String Interest1,String FieldGrouping1 ){
		String SourceDataStandard1 = "Automation_field_1";
		String SourceDataStandardReference1 = "Automation_field_1";
		String MOMReference1 = "Automation_field_1";
		String AddedFieldName = "//*[@ng-bind='dataItem.DisplayFieldName'][contains(.,'"+FieldName+"')]";

		waitForElementToAppear(AddNewFieldsButton,5);
		verifyMustExists(AddNewFieldsButton,"AddNewFieldsButton");
		click(AddNewFieldsButton,"AddNewFieldsButton");
		waitForElementToAppear(FieldName1,5);
		verifyMustExists(FieldName1,"FieldName1");
		sendKeys(FieldName1, FieldName2, "Enter FieldName");
		waitForElementToAppear(DataBaseFieldName,5);
		verifyMustExists(DataBaseFieldName,"DataBaseFieldName");
		sendKeys(DataBaseFieldName, DataBaseFieldName2, "Enter DataBaseFieldName");
		waitForElementToAppear(FieldDescription,5);
		verifyMustExists(FieldDescription,"FieldDescription");
		sendKeys(FieldDescription, DataBaseFieldName2, "Enter FieldDescription");
		waitForElementToAppear(SchemaTypeDropDwn,5);
		verifyMustExists(SchemaTypeDropDwn,"SchemaTypeDropDwn");
		click(SchemaTypeDropDwn,"SchemaTypeDropDwn");
		waitForElementToAppear(SelectOptionSchemaTypeDropDwn,5);
		verifyMustExists(SelectOptionSchemaTypeDropDwn,"SelectOptionSchemaTypeDropDwn");
		webDriver.findElement(By.xpath("//li[text()='"+SchemaType1+"']")).click();
		/////
		waitForElementToAppear(FieldTypeDropDwn ,5);
		verifyMustExists(FieldTypeDropDwn ,"FieldTypeDropDwn ");
		click(FieldTypeDropDwn ,"FieldTypeDropDwn ");
		waitForElementToAppear(SelectOptionFieldTypeDropDwn ,5);
		verifyMustExists(SelectOptionFieldTypeDropDwn ,"SelectOptionFieldTypeDropDwn ");
		webDriver.findElement(By.xpath("//li[text()='"+FieldType1+"']")).click();
		waitForElementToAppear(SystemCategoryDropDwn,5);
		verifyMustExists(SystemCategoryDropDwn,"SystemCategoryDropDwn");
		click(SystemCategoryDropDwn,"SystemCategoryDropDwn");
		waitForElementToAppear(SelectOptionSystemCategoryDropDwn1,5);
		verifyMustExists(SelectOptionSystemCategoryDropDwn1,"SelectOptionSystemCategoryDropDwn");
		webDriver.findElement(By.xpath("//li[text()='"+SystemCategory1+"']")).click();
		sleep(3000);
		waitForElementToAppear(MapFieldDropDwn,5);
		verifyMustExists(MapFieldDropDwn,"MapFieldDropDwn");
		click(MapFieldDropDwn,"MapFieldDropDwn");
		//sleep(2000);
		waitForElementToAppear(SelctOptionMapFieldDropDwn1,5);
		verifyMustExists(SelctOptionMapFieldDropDwn1,"SelctOptionMapFieldDropDwn");
		webDriver.findElement(By.xpath("//li[text()='"+MappedField1+"']")).click();
		waitForElementToAppear(ValueIfNullDropDwn,5);
		verifyMustExists(ValueIfNullDropDwn,"ValueIfNullDropDwn");
		click(ValueIfNullDropDwn,"ValueIfNullDropDwn");
		waitForElementToAppear(SelectOptionValueIfDefaultValueDropDwn,5);
		verifyMustExists(SelectOptionValueIfDefaultValueDropDwn,"SelectOptionValueIfDefaultValueDropDwn");
		webDriver.findElement(By.xpath("//li[text()='"+ValueIfNull1+"']")).click();
		waitForElementToAppear(DefaultValueTextBox,5);
		verifyMustExists(DefaultValueTextBox,"DefaultValueTextBox");
		sendKeys(DefaultValueTextBox, "10", "Enter DefaultValueTextBox");
		waitForElementToAppear(InteresrDropDwn,5);
		verifyMustExists(InteresrDropDwn,"InteresrDropDwn");
		click(InteresrDropDwn,"InteresrDropDwn");
		waitForElementToAppear(SelectOptionInteresrDropDwn,5);
		verifyMustExists(SelectOptionInteresrDropDwn,"SelectOptionInteresrDropDwn");
		webDriver.findElement(By.xpath("//li[text()='"+Interest1+"']")).click();
		waitForElementToAppear(FieldGroupingDropDwn,5);
		verifyMustExists(FieldGroupingDropDwn,"FieldGroupingDropDwn");
		click(FieldGroupingDropDwn,"FieldGroupingDropDwn");
		waitForElementToAppear(SelectOptionFieldGroupingDropDwn,5);
		verifyMustExists(SelectOptionFieldGroupingDropDwn,"SelectOptionFieldGroupingDropDwn");
		webDriver.findElement(By.xpath("//li[text()='"+FieldGrouping1+"']")).click();
		waitForElementToAppear(SourceDataStandard,5);
		verifyMustExists(SourceDataStandard,"SourceDataStandard");
		sendKeys(SourceDataStandard, SourceDataStandard1, "Enter SourceDataStandard");
		waitForElementToAppear(SourceDataStandardReference,5);
		verifyMustExists(SourceDataStandardReference,"SourceDataStandardReference");
		sendKeys(SourceDataStandardReference, SourceDataStandardReference1, "Enter SourceDataStandardReference");
		waitForElementToAppear(MDMReference,5);
		verifyMustExists(MDMReference,"MDMReference");
		sendKeys(MDMReference, MOMReference1, "Enter MDMReference");
		waitForElementToAppear(ValueIfNullDropDwn,5);
		verifyMustExists(AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		click(AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		sleep(4000);
		waitForElementToAppear(WarningMessage,5);
		verifyMustExists(WarningMessage,"WarningMessage");
		verifyMustExists(AddFieldsPopupSaveChangesButton,"AddFieldsPopupSaveChangesButton");
		click(AddFieldsPopupSaveChangesButton,"AddFieldsPopupSaveChangesButton");
		sleep(3000);
	}

	public void DatasetReferenceDataLink()
	{
		waitForElementToAppear(DatasetReferenceDataLink,5);
		verifyMustExists(DatasetReferenceDataLink,"Dataset Reference Data Link");
		click(DatasetReferenceDataLink,"Dataset Reference Data Link");
	}

	public void DatasetReferenceDatapage()
	{
		if(isVisible(DatasetReferenceDataPageLbl)==true){
			waitForElementToAppear(DatasetReferenceDataPageLbl,5);
			verifyMustExists(DatasetReferenceDataPageLbl,"Dataset Reference Data Lbl");
			sleep(2000);
		}else{
			Report.LogInfo("ValidateDataReferencepage", "Dataset Reference page not displayed", "FAIL");
		}
	}

	public void addNewDatasetReferenceData()
	{
		if(isVisible(AddDatasetReferenceDataBtn)==true){
			waitForElementToAppear(AddDatasetReferenceDataBtn,5);
			verifyMustExists(AddDatasetReferenceDataBtn,"Add Dataset Reference Data Button");	
			click(AddDatasetReferenceDataBtn,"Add Dataset Reference Data Button");
		}else{
			Report.LogInfo("ValidateNewDatasetReference", "new Dataset Reference data button not displayed", "FAIL");
		}
	}

	public void addValue()
	{
		if(isVisible(AddValueBtn)==true){
			waitForElementToAppear(AddValueBtn,10);
			verifyMustExists(AddValueBtn,"Add value Button");
			sleep(5000);
			click(AddValueBtn,"Add value button");
		}else{
			Report.LogInfo("ValidateAddValue", "Add Value not displayed", "FAIL");
		}
	}

	public void selectMappingsTab()
	{
		if(isVisible(MappingsTab)==true){
			waitForElementToAppear(MappingsTab,5);
			verifyMustExists(MappingsTab,"Mappings Tab");
			click(MappingsTab,"Mapping Tab");
		}else{
			Report.LogInfo("ValidateAddValue", "Add Value not displayed", "FAIL");
		}
	}

	public void applyOriginalNameFilter (String OriginalName){
		int i=0;
		String RecordCheckbox ="@xpath=//li//span[contains(text(),'"+OriginalName+"')]";
		//sleep(3000);
		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(OriginalValueFilter, "Original Value Filter");
			sleep(2000);
			if(isVisible(SearchFilterTxt))
			{
				verifyMustExists(SearchFilterTxt,"Search Filter Textbox");	
				sendKeys(SearchFilterTxt,OriginalName,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);

		click(RecordCheckbox, "Searched Record Checkbox");
		verifyMustExists(FilterBtn,"Filter Button");	
		click(FilterBtn,"Filter Button");
	}

	public void clickondropdown(String dopdown)
	{
		for(int i= 0; i<=5; i++)
		{
			click(dopdown,"dropdown");
			sleep(2000);
			if(isVisible(Autovalue1DDValue)==true)
			{
				break;
			}
		}
	}

	public String getCurrentTime(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmssSS");
		String strDate = sdf.format(cal.getTime());
		//System.out.println("Current date in String Format: "+strDate); 
		return strDate;
	}
	
	public void SelectRiskAndPremium(){
		waitForElementToAppear(RiskAndPremiumLink,5);
		verifyMustExists(RiskAndPremiumLink,"RiskAndPremium Link");
		click(RiskAndPremiumLink,"RiskAndPremium Link");
	}
	
	public void applyFieldNameFilter(String FieldName)
	{
		 String SelectFieldName = "@xpath=//input[@value='"+FieldName+"']";
		
		waitForElementToPresent(By.xpath(FieldNameFilter), 3);
		verifyMustExists(FieldNameFilter,"Borderue Field Name Filter");
		click(FieldNameFilter,"Borderue Field Name Filter");
		waitForElementToPresent(By.xpath(SearchTxt), 3);
		verifyMustExists(SearchTxt,"Search textbox");
		sendKeys(SearchTxt,FieldName,"Search textbox");
		waitForElementToPresent(By.xpath(SelectFieldName), 3);
		verifyMustExists(SelectFieldName,"Field Name");
		click(SelectFieldName,"Field Name");
		verifyMustExists(FilterBtn,"Filter button");
		click(FilterBtn,"Filter button");
	}

}
