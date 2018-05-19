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

public class AdminPermissionPage extends PageBase{
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BordereauQuePage BQPage = new BordereauQuePage();
	PolicyPage policy = new PolicyPage();
	BordereauProcessPage BordereauProcess = new BordereauProcessPage();
	ContractMetadataPage ConMeta = new ContractMetadataPage();
	DatasetReferenceDataPage DRD = new DatasetReferenceDataPage();
	RateOfExchangePage REX = new RateOfExchangePage();
	TasksPage Task = new TasksPage();
	DatasetReferenceDataPage DR = new DatasetReferenceDataPage();
	CompanyPage compny = new CompanyPage();
	
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

	public static final String SystemReferenceData = "@xpath=.//*[@ng-if='isSystemReferenceDataView']";
	public static final String TransactionType1 = "@xpath=.//*[@id='content']//tr[1]/td[2][text()='Transaction Type']";
	public static final String Currency = "@xpath=.//*[@id='content']//tr[1]/td[2][text()='Transaction Type']";
	public static final String ClaimStatus = "@xpath=.//*[@id='content']//tr[1]/td[2][text()='Claim Status']";
	
	public static final String BackToRefPage = "@xpath=.//*[@ng-click='BackToRefPage()']";
	public static final String TransactionType = "@xpath=.//*[@id='content']//tr[6]/td[2][text()='Transaction Type']";
	public static final String FrstDeactivatebtn = "@xpath=.//*[@id='grid']//tr[1]//td[8]//button";
	public static final String NoRecrdMsg = "@xpath=.//*[@id='grid']//tr//td[text()='No result returned']";
	//-------------------------------------------------------- BordereauProcessIdentifySheetTests ---------------------------------------------------------------------//

	public void AdminPermission_4174() throws Exception{
		//ConMeta.addMetadata();
		//ConMeta.EditMetadata();
		DRD.addDatasetReference_3381();
		DRD.addvalueDatasetReference_3382();
		DRD.mappingReferenceDataset_3383();
		REX.editRateOfExchange_3376();
		REX.uploadInvalidFile_3377();
		REX.uploadvalidFile_3378();
		//Task.addTasks();
		//Task.EditTasksDetails();
	}

	public void ComAdminTypeInsurer_4175() throws Exception{
	
		homePage.adminMenu();

		DR.DatasetReferenceDataLink();
		sleep(2000);
		if(isVisible(DR.AddDatasetReferenceDataBtn)==false){
			Report.LogInfo("ElementCheck", "Add Data set Reference Data Btn not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Add Data set Reference Data Btn available", "FAIL");
		}
		
		selectCurrencyFilter("Sprinklers");
		waitForElementToAppear(Currency,5);
		verifyExists(Currency,"Sprinklers");
		click(Currency,"Sprinklers");

		sleep(2000);
		if(isVisible(DR.AddValueBtn)==false){
			Report.LogInfo("ElementCheck", "Add value Btn not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Add value Btn available", "FAIL");
		}

		DR.selectMappingsTab();
		sleep(2000);
		if(isVisible(DR.NewMappingBtn)==false){
			Report.LogInfo("ElementCheck", "Add mapping Btn not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Add mapping Btn available", "FAIL");
		}
	
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
		
		waitForElementToAppear(BackToRefPage,5);
		verifyExists(BackToRefPage,"Back To Ref Page button");
		click(BackToRefPage,"Back To Ref Page button");

	}

	public void StandardUserTypeInsurer_4180() throws Exception{
		homePage.adminMenu();

		sleep(1000);
		if(isVisible(DR.DatasetReferenceDataLink)==false){
			Report.LogInfo("ElementCheck", "Data set Reference not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Data set Reference available", "FAIL");
		}

	}

	public void ReadOnlyUserTypeInsurer_4185() throws Exception{
		//homePage.adminMenu();

		sleep(2000);
		if(isVisible(homePage.adminDropdown)==false){
			Report.LogInfo("ElementCheck", "Admin option not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Admin option is available", "FAIL");
		}		
	}

	public void ComAdminTypeBrocker_4176() throws Exception{
	
		homePage.adminMenu();

		DR.DatasetReferenceDataLink();
		sleep(2000);
		if(isVisible(DR.AddDatasetReferenceDataBtn)==false){
			Report.LogInfo("ElementCheck", "Add Data set Reference Data Btn not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Add Data set Reference Data Btn available", "FAIL");
		}
		
		selectCurrencyFilter("Transaction Type");
		waitForElementToAppear(TransactionType1,5);
		verifyExists(TransactionType1,"Transaction Type");
		click(TransactionType1,"Transaction Type");

		sleep(2000);
		if(isVisible(DR.AddValueBtn)==false){
			Report.LogInfo("ElementCheck", "Add value Btn not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Add value Btn available", "FAIL");
		}

		DR.selectMappingsTab();
		sleep(2000);
		if(isVisible(DR.NewMappingBtn)==false){
			Report.LogInfo("ElementCheck", "Add mapping Btn not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Add mapping Btn available", "FAIL");
		}
		
		if(isVisible(NoRecrdMsg)==false){
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
			Report.LogInfo("ElementCheck", "Record not available for active deactive", "PASS");
		}
		sleep(2000);
		homePage.adminMenu();
		sleep(2000);
		if(isVisible(REX.RateOfExchangeLink)==false){
			Report.LogInfo("ElementCheck", "Rate of exchange not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Rate of exchange available", "FAIL");
		}
	}

	public void StandardUserTypeBroker_4181() throws Exception{
		homePage.adminMenu();

		sleep(2000);
		if(isVisible(DR.DatasetReferenceDataLink)==true){
			Report.LogInfo("ElementCheck", "Referance data option available", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Referance data option not available", "PASS");
		}		
	}

	public void ReadOnlyUserTypeBrocker_4186() throws Exception{
		//homePage.adminMenu();

		sleep(2000);
		if(isVisible(homePage.adminDropdown)==false){
			Report.LogInfo("ElementCheck", "Admin option not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Admin option is available", "FAIL");
		}		
	}

	public void ComAdminTypeCoverHolder_4177() throws Exception{

		homePage.adminMenu();

		DR.DatasetReferenceDataLink();
		sleep(2000);
		if(isVisible(DR.AddDatasetReferenceDataBtn)==false){
			Report.LogInfo("ElementCheck", "Add Data set Reference Data Btn not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Add Data set Reference Data Btn available", "FAIL");
		}

		selectCurrencyFilter("Transaction Type");
		waitForElementToAppear(Currency,5);
		verifyExists(Currency,"Transaction Type");
		click(Currency,"Transaction Type");

		sleep(2000);
		if(isVisible(DR.AddValueBtn)==false){
			Report.LogInfo("ElementCheck", "Add value Btn not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Add value Btn available", "FAIL");
		}
		
		DR.selectMappingsTab();
		sleep(2000);
		if(isVisible(DR.NewMappingBtn)==false){
			Report.LogInfo("ElementCheck", "Add mapping Btn not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Add mapping Btn available", "FAIL");
		}

		if(isVisible(NoRecrdMsg)==false){
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
			Report.LogInfo("ElementCheck", "Record not available for active deactive", "PASS");
		}
		
		waitForElementToAppear(BackToRefPage,5);
		verifyExists(BackToRefPage,"Back To Ref Page button");
		click(BackToRefPage,"Back To Ref Page button");
	}

	public void StandardUserTypeCoverHolder_4182() throws Exception{
		homePage.adminMenu();

		sleep(2000);
		if(isVisible(DR.DatasetReferenceDataLink)==true){
			Report.LogInfo("ElementCheck", "Referance data option available", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Referance data option not available", "PASS");
		}		
	}

	public void ReadOnlyUserTypeCoverHolder_4187() throws Exception{
		//homePage.adminMenu();

		sleep(2000);
		if(isVisible(homePage.adminDropdown)==false){
			Report.LogInfo("ElementCheck", "Admin option not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Admin option is available", "FAIL");
		}		
	}

	public void ComAdminTypeTPA_4178() throws Exception{
		homePage.adminMenu();

		DR.DatasetReferenceDataLink();
		sleep(2000);
		if(isVisible(DR.AddDatasetReferenceDataBtn)==false){
			Report.LogInfo("ElementCheck", "Add Data set Reference Data Btn not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Add Data set Reference Data Btn available", "FAIL");
		}

		selectCurrencyFilter("Claim Status");
		waitForElementToAppear(ClaimStatus,5);
		verifyExists(ClaimStatus,"Claim Status");
		click(ClaimStatus,"Claim Status");

		sleep(2000);
		if(isVisible(DR.AddValueBtn)==false){
			Report.LogInfo("ElementCheck", "Add value Btn not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Add value Btn available", "FAIL");
		}
		
		DR.selectMappingsTab();
		sleep(2000);
		if(isVisible(DR.NewMappingBtn)==false){
			Report.LogInfo("ElementCheck", "Add mapping Btn not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Add mapping Btn available", "FAIL");
		}

		if(isVisible(NoRecrdMsg)==false){
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
			Report.LogInfo("ElementCheck", "Record not available for active deactive", "PASS");
		}
		
		waitForElementToAppear(BackToRefPage,5);
		verifyExists(BackToRefPage,"Back To Ref Page button");
		click(BackToRefPage,"Back To Ref Page button");
	}

	public void StandardUserTypeTPA_4183() throws Exception{
		homePage.adminMenu();

		sleep(2000);
		if(isVisible(DR.DatasetReferenceDataLink)==true){
			Report.LogInfo("ElementCheck", "Referance data option available", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Referance data option not available", "PASS");
		}		
	}

	public void ReadOnlyUserTypeTPA_4189() throws Exception{
		//homePage.adminMenu();

		sleep(2000);
		if(isVisible(homePage.adminDropdown)==false){
			Report.LogInfo("ElementCheck", "Admin option not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Admin option is available", "FAIL");
		}		
	}

	public void CompAdminUserTypeServiceProvdr_4179() throws Exception{
		homePage.adminMenu();

		DR.DatasetReferenceDataLink();
		sleep(2000);
		if(isVisible(DR.AddDatasetReferenceDataBtn)==false){
			Report.LogInfo("ElementCheck", "Add Data set Reference Data Btn not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Add Data set Reference Data Btn available", "FAIL");
		}

		selectCurrencyFilter("Claim Status");
		waitForElementToAppear(ClaimStatus,5);
		verifyExists(ClaimStatus,"Claim Status");
		click(ClaimStatus,"Claim status");

		sleep(2000);
		if(isVisible(DR.AddValueBtn)==false){
			Report.LogInfo("ElementCheck", "Add value Btn not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Add value Btn available", "FAIL");
		}
		
		DR.selectMappingsTab();
		sleep(2000);
		if(isVisible(DR.NewMappingBtn)==false){
			Report.LogInfo("ElementCheck", "Add mapping Btn not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Add mapping Btn available", "FAIL");
		}

		if(isVisible(NoRecrdMsg)==false){
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
			Report.LogInfo("ElementCheck", "Record not available for active deactive", "PASS");
		}		
		waitForElementToAppear(BackToRefPage,5);
		verifyExists(BackToRefPage,"Back To Ref Page button");
		click(BackToRefPage,"Back To Ref Page button");
	}

	public void StandardUserTypeServiceProdr_4184() throws Exception{
		homePage.adminMenu();
		
		if(isVisible(DR.DatasetReferenceDataLink)==true){
			Report.LogInfo("ElementCheck", "Referance data option available", "FAIL");
		}else{
			Report.LogInfo("ElementCheck", "Referance data option not available", "PASS");
		}		
	}

	public void ReadOnlyUserTypeServicePro_4188() throws Exception{
		//homePage.adminMenu();

		sleep(2000);
		if(isVisible(homePage.adminDropdown)==false){
			Report.LogInfo("ElementCheck", "Admin option not available", "PASS");
		}else{
			Report.LogInfo("ElementCheck", "Admin option is available", "FAIL");
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
	
	public void selectCurrencyFilter(String CheckName) throws Exception
	{
		String DescTypeFilter = "@xpath=.//*[@data-title='Description']/a[1]/span";
		int i=0;
		String RecordCheckbox = "@xpath=//input[@value='"+CheckName+"']";
		javaScriptWait();
		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			if(isVisible(DescTypeFilter)==true){
				//waitForElementToAppear(PolicyNumberFilter,5);
				click(DescTypeFilter, "Description Type Filter");
				sleep(2000);
			}
			if(isVisible(RecordCheckbox))
			{
				click(RecordCheckbox, "Schema checkbox");
				verifyMustExists(policy.FilterBtn,"Filter Button");	
				click(policy.FilterBtn,"Filter Button");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<1);		
		//refreshPage();		
	}
}