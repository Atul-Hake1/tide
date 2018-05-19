package com.tide.qa.pagefactory;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;

import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;

public class OutputFormatPage extends PageBase{
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BordereauQuePage BQPage = new BordereauQuePage();
	PolicyPage policy = new PolicyPage();
	BordereauProcessPage BordereauProcess = new BordereauProcessPage();
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
	String UniqueReferenceVal2 = "Contract 2"+getCurrentDateTimeMS();
	static String  Rule = "AutoRule"+getCurrentDateTimeMS();
	static String  Rule1 = "AutoRule1"+getCurrentDateTimeMS();
	String FilteredOutputFormatNameEditing;
	String NameOutputFormatEditing ;
	String NameOutputFormat;
	String FilteredRuleNameVerification;
	String FieldName = "SCHEMA FIELD NAME";
	String FilteredOutputFormatNameVerification;

	public static final String OutPutFormatMenuLink = "@xpath=//a[@href='#!/app/outputformats']";
	public static final String AddOutputFormatButton = "@xpath=//div[@ng-click='addEditOutputFormatPopup()']";
	public static final String Name = "@xpath=//*[@ng-model='data.Name']";
	public static final String Description = "@xpath=//*[@ng-model='data.Description']";
	public static final String BordereauType = "@xpath=//*[@ng-model='data.BordereauType']//preceding-sibling::span";
	public static final String BordereauTypeSelectOption = "@xpath=//li[text()='Risk']";
	public static final String FileType = "@xpath=//*[@ng-model='data.FileType']//preceding-sibling::span";
	public static final String FileTypeSelectOption = "@xpath=//li[contains(text(),'Excel (XLSX)')]";
	public static final String ReportPath = "@xpath=//input[@ng-model='data.ReportPath']";
	public static final String AddOuputFormatSaveButton = "@xpath=//button[@ng-click='save()']";
	public static final String SaveButtonOutputFormat= "@xpath=//button[@ng-click='save()']";
	public static final String SearchedRuleFilterButton= "@xpath=//button[text()='Filter']";

	//TC 3535
	public static final String OutputFormatFilterIcon ="@xpath=//th[@data-field='Name']//span";
	public static final String OutputFormatFilterSearchText ="@xpath=//input[@placeholder='Search']";
	public static final String EditOutputFormatName= "@xpath=//tr[1]//td//preceding::td[2]//descendant::i";
	public static final String CancelButtonOnPopUp= "@xpath=//*[@ng-click='cancel()']";

	//-------------------------------------------------------- BordereauProcessIdentifySheetTests ---------------------------------------------------------------------//

	public void AddOutputFormat_3535() throws Exception{
		NameOutputFormat = "Lloyds CoverholderReporting Standards v5"+getCurrentTime();
		//System.out.println("Name:- "+NameOutputFormat);
		FilteredOutputFormatNameVerification= "@xpath=//tr[1]//td[contains(text(),'"+NameOutputFormat+"')]";
		String Description = "The Lloyd's Coverholder Reporting v5";
		String ReportPath =" /Reports/Dev/Extracts/Risk_Tide_Standards_v1.rdl";
		String BordereauType = "Risk";
		String FileType = "Excel (XLSX)";

		//loginPage.tideLogin();
		homePage.adminMenu();
		AddOutputFormatByAdmin(NameOutputFormat,Description,BordereauType,FileType,ReportPath);
		refreshPage();
		waitForElementToAppear(OutputFormatFilterIcon,3);
		OutputFormatNameFilter(NameOutputFormat);
		waitForElementToAppear(FilteredOutputFormatNameVerification,5);
		verifyMustExists(FilteredOutputFormatNameVerification,"Filtered OutputFormat Name Verification");
		String ActualOutputFormatName = getTextFrom(FilteredOutputFormatNameVerification);
		if(NameOutputFormat.equals(ActualOutputFormatName)){
			Report.LogInfo("ValidateAddedOutputFormat", "Output Format added successfully.", "PASS");
		}else{

			Report.LogInfo("ValidateAddedOutputFormat", "Output Format not added successfully.", "FAIL");
		}
	}


	public void EditOutputFormat_3536(){
		NameOutputFormatEditing = "Testing :- Aspen User"+getCurrentTime();
		//System.out.println("Name:- "+NameOutputFormatEditing);
		FilteredOutputFormatNameEditing= "@xpath=//tr[1]//td[contains(text(),'"+NameOutputFormatEditing+"')]";
		String DescriptionData = "Testing Purpose";

		UpdateOutputFormatData(NameOutputFormatEditing,DescriptionData);
		refreshPage();
		sleep(2000);
		waitForElementToAppear(EditOutputFormatName,6);
		OutputFormatNameFilter(NameOutputFormatEditing);
		sleep(3000);
		waitForElementToAppear(EditOutputFormatName,5);
		click(EditOutputFormatName,"EditOutputFormatName");
		String ActualOutputFormatName = getTextFrom(FilteredOutputFormatNameEditing);
		if(NameOutputFormatEditing.equalsIgnoreCase(ActualOutputFormatName)){
			Report.LogInfo("ValidateAddedOutputFormat", "Output Format added successfully.", "PASS");
		}else{

			Report.LogInfo("ValidateAddedOutputFormat", "Output Format not added successfully.", "FAIL");
		}

		waitForElementToAppear(CancelButtonOnPopUp,6);
		verifyMustExists(CancelButtonOnPopUp,"CancelButtonOnPopUp");
		click(CancelButtonOnPopUp,"CancelButtonOnPopUp");		
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

	public void AddOutputFormatByAdmin(String name1,String description,String bordereauType,String fileType, String reportPath ){
		if(isVisible(OutPutFormatMenuLink)==true){
			waitForElementToAppear(OutPutFormatMenuLink,5);
			verifyMustExists(OutPutFormatMenuLink,"OutPutFormatMenuLink");
			click(OutPutFormatMenuLink,"OutPutFormatMenuLink");
			waitForElementToAppear(AddOutputFormatButton,5);
			verifyMustExists(AddOutputFormatButton,"AddOutputFormatButton");
			click(AddOutputFormatButton,"AddOutputFormatButton");
			waitForElementToAppear(Name,5);
			verifyMustExists(Name,"Name");
			sendKeys(Name,name1,"Enter Name");
			waitForElementToAppear(Description,5);
			verifyMustExists(Description,"Description");
			sendKeys(Description,description,"Enter Description");
			waitForElementToAppear(BordereauType,5);
			verifyMustExists(BordereauType,"BordereauType");
			click(BordereauType,"BordereauType");
			waitForElementToAppear(BordereauTypeSelectOption,5);
			verifyMustExists(BordereauTypeSelectOption,"BordereauType");
			webDriver.findElement(By.xpath("//li[text()='"+bordereauType+"']")).click();
			waitForElementToAppear(FileType,5);
			verifyMustExists(FileType,"FileType");
			click(FileType,"FileType");
			waitForElementToAppear(FileTypeSelectOption,5);
			verifyMustExists(FileTypeSelectOption,"FileType Select Option");
			webDriver.findElement(By.xpath("//li[contains(text(),'"+fileType+"')]")).click();
			waitForElementToAppear(ReportPath,5);
			verifyMustExists(ReportPath,"ReportPath");
			sendKeys(ReportPath,reportPath,"Enter Description");
			waitForElementToAppear(SaveButtonOutputFormat,5);
			verifyMustExists(SaveButtonOutputFormat,"SaveButtonOutputFormat");
			click(SaveButtonOutputFormat,"Add Ouput Format Save Button");
			sleep(5000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}
	public void OutputFormatNameFilter(String name){

		int i=0;
		String SearchedCheckBox1 ="@xpath=//li/label/span[contains(.,'"+name+"')]";


		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(OutputFormatFilterIcon, "OutputFormatFilterIcon");
			sleep(2000);
			if(isVisible(OutputFormatFilterSearchText))
			{
				verifyMustExists(OutputFormatFilterSearchText,"OutputFormatFilterSearchText");	
				sendKeys(OutputFormatFilterSearchText,name,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(SearchedCheckBox1) && i<5);

		click(SearchedCheckBox1, "Searched Record Checkbox");
		waitForElementToAppear(SearchedRuleFilterButton,3);
		verifyMustExists(SearchedRuleFilterButton,"Filter Button");
		click(SearchedRuleFilterButton,"Filter Button");
	}

	public void UpdateOutputFormatData(String name1,String descroption ){
		if(isVisible(EditOutputFormatName)==true){
			waitForElementToAppear(EditOutputFormatName,4);
			verifyMustExists(EditOutputFormatName,"EditOutputFormatName");
			click(EditOutputFormatName,"EditOutputFormatName");
			waitForElementToAppear(Name,5);
			verifyMustExists(Name,"Name");
			clearTextBox(Name);
			sendKeys(Name,name1,"Enter Name");
			waitForElementToAppear(Description,5);
			verifyMustExists(Description,"Description");
			clearTextBox(Description);
			sendKeys(Description,descroption,"Enter Description");
			waitForElementToAppear(AddOuputFormatSaveButton,5);
			verifyMustExists(SaveButtonOutputFormat,"SaveButtonOutputFormat");
			click(SaveButtonOutputFormat,"Add Ouput Format Save Button");
			sleep(6000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}

	}
}