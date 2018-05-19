package com.tide.qa.pagefactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;
import java.text.SimpleDateFormat;
import java.util.Date;



public class SchedulePage extends PageBase {
	 SchemaPage schema = new SchemaPage();
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BordereauProcessPage Br = new BordereauProcessPage();
	BordereauQuePage QuePage = new BordereauQuePage();
	BordereauProcessPage BordereauProcess = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();
	Rules rule = new Rules();
	DatasetReferenceDataPage DR = new DatasetReferenceDataPage();
	
	BProcessingRiskPremiumClaimPage Bprocessing = new BProcessingRiskPremiumClaimPage();
	
	String AdminUsername= "admin@tide.com";
	String AdminPassword = "Systenics123@";
	
	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("ssMsddMMyy");
		String datetime = ft.format(dNow);
		return datetime;
	}

	public static String getCurrentDateTimeMS1() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMssddHHmm");
		String datetime = ft.format(dNow);
		return datetime;
	}

	String CompanyReferenceval = "Automation Policy1"+getCurrentDateTimeMS();
	String UniqueReferenceVal2 = "Contract 2"+getCurrentDateTimeMS();
	String BrokerageVal = "10";
	String Status1 = "Draft";
	String Broker1 = "Alwen Hough Johnson Ltd - TBC";
	String Bline1 = "Property (D&F)";
	String Underline1 = "Abhi, Standard";
	String InceptionDate1 = "01/09/2017";
	String InceptionDate2 = "01/09/2018";
	public static String contractId;
	String QueName = "Risk And Premium format_"+getCurrentDateTimeMS();
	
	public static String allSheetsPath = "";
	public static String sheet5185Path = "";
	public static String sheet5188Path = "";
	public static String sheet5085Path = "";
	public static String sheet5190Path = "";
	public static String sheet5303Path = "";
	
	
	
	
	//TC5122
		 public static final String DataField ="@xpath=//th[@data-title='Data']";
		 public static final String DescriptionField ="@xpath=//th[@data-title='Description']";
		 public static final String DatasetField ="@xpath=//th[@data-title='Dataset']";
		 public static final String SystemField ="@xpath=//th[@data-title='System']";
		 public static final String DataValueFilter ="@xpath=//th[@data-title='Data']//a//span";
		 public static final String DescriptionValueFilter ="@xpath=//th[@data-title='Description']//a//span";
		 public static final String DatasetValueFilter ="@xpath=//th[@data-title='Dataset']//a//span";
		 public static final String SystemValueFilter ="@xpath=//th[@data-title='System']//a//span";
		 public static final String SystemColumnData="@xpath=//tr[1]//td[text()='No']";
		 public static final String DescriptionColumnData="@xpath=//tbody[@role='rowgroup']//tr[1]//td[2]";
		 public static final String DatasetColumnData="@xpath=//tbody[@role='rowgroup']//tr[1]//td[3]";
		 public static final String SystemColumnWithYesValue="@xpath=//tr[1]//td[text()='Yes']";
		 public static final String SystemColumnWithNoValue="@xpath=//tr[2]//td[text()='No']";
		 public static final String DescriptionWithoutData ="@xpath=.//tbody[@role='rowgroup']//tr[1]//td[2][text()='-']";
		 public static final String DatasetWithoutData ="@xpath=.//tbody[@role='rowgroup']//tr[1]//td[3][text()='-']";
		 public static final String DataFieldAscIcon ="@xpath=//*[@data-field='Name']//*[@class='k-icon k-i-sort-asc-sm']";
			
//==============================================Sprint 7_otherthanpermission==================================//
	
	public static final String PolicyLink = "@xpath=//a[text()='POLICIES']";
	public static final String locationEditBtn = "@xpath=//*[@ng-click='edit()']";
	public static final String CopyFromSection1 = "@xpath=//*[@ng-click='copyFromSection1()']";
	public static final String EuropeExpandarrow  = "@xpath=//*[text()='Europe']/preceding-sibling::span";
	public static final String Swedencheckbox  = "@xpath=//*[text()='Sweden']/preceding-sibling::input[@type='checkbox']";
	public static final String Switzerlandcheckbox  = "@xpath=//*[text()='Switzerland']/preceding-sibling::input[@type='checkbox']";
	public static final String SwitzerlandArrow  = "@xpath=//*[@id='grid']//tr[52]/td[1]/span[2]";
	public static final String ArgaucheckBox  = "@xpath=//label[contains(.,'Bern')]/preceding-sibling::input[@ng-model='dataItem.IsState']";
	public static final String SwitzerlandState  = "@xpath=//label[text()='Aargau']//preceding-sibling::input[@type='checkbox']";
	public static final String SaveBtn  = "@xpath=//*[@ng-click='save()']";
	public static final String ErrorPage  = "@xpath=//h2[contains(.,'Invalid date values identified')]";
	public static final String ErrorWarringlink  = "@xpath=//*[text()='Errors & Warnings']";
	public static final String SkipAllErrorbtn1 = "@xpath=//*[@ng-click='skipAllErrros()']";
	public static final String errorWarringMsg1= "@xpath=//tr//td[text()='Invalid date values identified - Risk Expiry Date']";
	public static final String errorWarringMsg2= "@xpath=//tr//td[text()='Invalid integer values identified - Number of Stories']";
	public static final String errorWarringMsg3= "@xpath=//tr//td[text()='Sprinklers (Y/N) - reference data translation required']";
	public static final String errorWarringMsg4= "@xpath=//tr//td[text()='Insured Country - reference data translation required']";
	public static final String errorWarringMsg5= "@xpath=//tr//td[text()='Premium Currency - reference data translation required']";
	public static final String errorWarringMsg6= "@xpath=//tr//td[text()='Risk Country - reference data translation required']";
	public static final String errorWarringMsg7= "@xpath=//tr//td[text()='Risk Currency - reference data translation required']";
	public static final String errorWarringMsg8= "@xpath=//tr//td[text()='Construction reference data translation required']";
	public static final String CompleteAssignbtn= "@xpath=//button[@ng-click='nextStep()']";
	
	
	public void Update_DataReferenceData_AdminArea_TC5122() throws Exception
	{
		homePage.adminMenu();
		DR.DatasetReferenceDataLink();
		DR.DatasetReferenceDatapage();
		verifyMustExists(DataField,"Verify Data Column");
		verifyMustExists(DescriptionField,"Verify Description Column");
		verifyMustExists(DatasetField,"Verify Dataset Column");
		verifyMustExists(SystemField,"Verify System Column");
		verifyMustExists(DataValueFilter,"Verify Data Column Filter");
		verifyMustExists(DescriptionValueFilter,"Verify Description Column Filter");
		verifyMustExists(DatasetValueFilter,"Verify Dataset Column Filter");
		verifyMustExists(SystemValueFilter,"Verify System Column Filter");
		selectDataFieldAscOrder();
		verifyMustExists(SystemColumnData,"Verify System Column displayed data'NO'");
		if(isVisible(SystemColumnData)==true)
		{
			Report.LogInfo("ValueCheck", "System Column displayed data'NO'", "PASS");
		}
		else{
			Report.LogInfo("ValueCheck", "System Column not displayed data as'NO'", "FAIL");
		}
		verifyMustExists(DescriptionColumnData,"Verify Description column displayed data");
		if(isVisible(DescriptionColumnData)==true)
		{
			Report.LogInfo("ValueCheck", "Description Column displayed data", "PASS");
		}
		else{
			Report.LogInfo("ValueCheck", "Description Column not displayed data", "FAIL");
		}
		verifyMustExists(DatasetColumnData,"Verify Dataset Column displayed data");
		if(isVisible(DatasetColumnData)==true)
		{
			Report.LogInfo("ValueCheck", "Dataset Column displayed data", "PASS");
		}
		else{
			Report.LogInfo("ValueCheck", "Dataset Column not displayed data", "FAIL");
		}
		loginPage.tideReadOnlyLogOut();
		sleep(3000);
		loginPage.tideLogin(AdminUsername, AdminPassword);
		homePage.adminMenu();
		DR.DatasetReferenceDataLink();
		sleep(2000);
		if(isVisible(SystemColumnWithYesValue)==true && isVisible(SystemColumnWithNoValue)==true) 
		{
			Report.LogInfo("ValueCheck", "System Column displayed data With 'Yes' & 'No' values", "PASS");
		}
		else{
			Report.LogInfo("ValueCheck", "System Column not displayed data With 'Yes' & 'No' values", "FAIL");
		}
		if(isVisible(DescriptionWithoutData)==true)
		{
			Report.LogInfo("ValueCheck", "'-' is displayed when Description not present", "PASS");
		}
		else{
			Report.LogInfo("ValueCheck", "'-' is not displayed when Description not present", "FAIL");
		}
		if(isVisible(DatasetWithoutData)==true)
		{
			Report.LogInfo("ValueCheck", "'-' is displayed when Dataset not present", "PASS");
		}
		else{
			Report.LogInfo("ValueCheck", "'-' is not displayed when Dataset not present", "FAIL");
		}		
	}
	
	
	
	public void riskPremiumBordereauType_5185() throws Exception{
			
		
		String RiskSchemaName = "RiskAndPremium_"+getCurrentDateTimeMS();
		schema.AddSchema_Risk(RiskSchemaName);
		BordereauQuePage QuePage = new BordereauQuePage();
		QuePage.sheetProcessingriskAndPrimium(RiskSchemaName,QueName);
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS();
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String subSheet=QueName;
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails1(UniqueReferenceVal1, IncDate,ExpDate, Status1, policy.Broker1, policy.Bline1, policy.Underline1);
		waitForElementToAppear(BordereauProcess.DraftBtn,5);
		verifyExists(BordereauProcess.DraftBtn,"Draft Status Button");
		policy.changeStatusToQuote();
		policy.contractId=ReturnContractID();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		BordereauProcess.openSelectedPolicy();
		if(isVisible(BordereauProcess.SignedBtn)== true){
		verifyExists(BordereauProcess.SignedBtn,"Signed Status Button");
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannel1(policy.TypeDDValue_RiskAndPremium, "30", "24", "Risk And Premium Bordereaux ");
		BordereauProcess.SubmitBordereaux(subSheet);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet5185Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_5185_second.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet5185Path); 
		//5185
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"4\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_5185_second.xlsx\",\"UniqueFileName\":\"S14353120180220.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S14353120180220.xlsx\",\"Filesize\":24663,\"Path\":null,\"size\":24663,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauProcess.refreshUploadedFile();
		if(isVisible(BordereauProcess.ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			click(BordereauProcess.ReviewBtn,"Review Button");
			sleep(3000);
			waitForElementToAppear(BordereauProcess.SuRcdAssmnt,10);
			verifyMustExists(BordereauProcess.SuRcdAssmnt,"Submit recor for Assignment button");
			click(BordereauProcess.SuRcdAssmnt,"Submit recor for Assignment button");
			waitForElementToAppear(BordereauProcess.SubAssesmntBtn,10);
			verifyMustExists(BordereauProcess.SubAssesmntBtn,"For Assignment button");
			click(BordereauProcess.SubAssesmntBtn,"For Assignment button");
			BordereauProcess.clickOnApproveBordBtn();
			BordereauProcess.refreshUploadedFileApprovedStatus();
				if(isVisible(BordereauProcess.Approvedbtn)==true){
				Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
				BordereauProcess.openDATALink();
				BordereauProcess.navigateToDATARiskTab();
				List <WebElement> totatRecordsRisk = findWebElements(BordereauProcess.TotalRowCountAfterFiltered);
				int recordsCountRisk = totatRecordsRisk.size();
				sleep(2000);
				BordereauProcess.navigateToDATAPremiumTab();
				List <WebElement> totatRecordsRremiunm = findWebElements(BordereauProcess.TotalRowCountAfterFiltered);
				int recordsCountPremium = totatRecordsRremiunm.size();
				sleep(1000);
					if(recordsCountRisk==recordsCountPremium)
					{
						Report.LogInfo("CheckTotalCount", "Risk and Premium total count equal", "PASS");
					}else{
					Report.LogInfo("CheckTotalCount", "Risk and Premium total count not equal", "FAIL");
					}
					
				}else{
				Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
				}	
			}
			else{
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not Displayed", "FAIL");
			}	
		}
		else{
			Report.LogInfo("validateSignedbutton", "Signed Status Button not Displayed", "FAIL");
		}		
	}	
	
	
	public void coreFinancialRevisedCalculation_5188() throws Exception{
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS();
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails1(UniqueReferenceVal1, IncDate,ExpDate, Status1, policy.Broker1, policy.Bline1, policy.Underline1);
		waitForElementToAppear(BordereauProcess.DraftBtn,5);
		verifyExists(BordereauProcess.DraftBtn,"Draft Status Button");
		policy.changeStatusToQuote();
		policy.contractId=ReturnContractID();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		BordereauProcess.openSelectedPolicy();
		if(isVisible(BordereauProcess.SignedBtn)== true){
			verifyExists(BordereauProcess.SignedBtn,"Signed Status Button");
			policy.addSection2("Section2","10","Property D&F (US binder)","GBP - British Pound","10","10","10","Low");
			policy.navigateToSection2Tab();
			policy.navigateToRiskCodesTabOnSection();
			policy.addRiskCodesOnSection("1E - OVERSEAS LEG");
			Report.LogInfo("StepCheck", "Step 3,4 completed", "PASS"); 
			scrollUp();
			policy.navigationOnBordereauxTab();
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet5188Path = fpath+"\\src\\test\\resources\\testdata\\CoreFinancial Calculation_TC_5188.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet5188Path);  
			String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"CoreFinancial Calculation_TC_5188.xlsx\",\"UniqueFileName\":\"S30699820180222.xlsx\",\"BordereauFormatId\":\"7f75b3bf-dd45-4b3a-82a3-587b28556fce\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S30699820180222.xlsx\",\"Filesize\":113972,\"Path\":null,\"size\":113972,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauProcess.refreshUploadedFile();
			if(isVisible(BordereauProcess.ReviewBtn)==true){
				Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
				BordereauProcess.openDATALink();
				BordereauProcess.navigateToDATARiskTab();
				//Gross Premium 
				String GrossPremium="@xpath=//*[@data-field='Gross_Premium']";
				String GrossPremium1Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][2][text()='10.00']";
				String GrossPremium2Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][2][text()='10.00']";
				String GrossPremium3Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium')][2][text()='10.00']";
				String GrossPremium4Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium')][2][text()='10.00']";
				String GrossPremium5Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[5]//td[contains(@ng-click,'Gross_Premium')][2][text()='10.00']";
				String GrossPremium6Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[6]//td[contains(@ng-click,'Gross_Premium')][2][text()='10.00']";
				waitForElementToAppear(GrossPremium,5);
				mouseOverAction(GrossPremium);
				verifyMustExists(GrossPremium,"Gross Premium Including Tax column");
				sleep(2000);
				verifyExists(GrossPremium1Row,"Gross Premium 1 Value");
				verifyExists(GrossPremium2Row,"Gross Premium 2 Value");
				verifyExists(GrossPremium3Row,"Gross Premium 3 Value");
				verifyExists(GrossPremium4Row,"Gross Premium 4 Value");
				verifyExists(GrossPremium5Row,"Gross Premium 5 Value");
				verifyExists(GrossPremium6Row,"Gross Premium 6 Value");
				//NetPremium
				String NetPremium="@xpath=//*[@data-field='Net_Premium']";
				String NetPreium1Row="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][text()='-114.50']";
				String NetPreium2Row="@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][text()='-114.50']";
				String NetPreium3Row="@xpath=//*[@data-field='Net_Premium']//following::tr[3]//td[contains(@ng-click,'Net_Premium')][text()='-114.50']";
				String NetPreium4Row="@xpath=//*[@data-field='Net_Premium']//following::tr[4]//td[contains(@ng-click,'Net_Premium')][text()='10.00']";
				String NetPreium5Row="@xpath=//*[@data-field='Net_Premium']//following::tr[5]//td[contains(@ng-click,'Net_Premium')][text()='10.00']";
				String NetPreium6Row="@xpath=//*[@data-field='Net_Premium']//following::tr[6]//td[contains(@ng-click,'Net_Premium')][text()='-14.50']";
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
				sleep(2000);
				policy.navigationOnBordereauxTab();
				if(isVisible(BordereauProcess.ReviewBtn)==true){
					Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
					click(BordereauProcess.ReviewBtn,"Review Button");
					sleep(3000);
					waitForElementToAppear(BordereauProcess.SuRcdAssmnt,10);
					verifyMustExists(BordereauProcess.SuRcdAssmnt,"Submit recor for Assignment button");
					click(BordereauProcess.SuRcdAssmnt,"Submit recor for Assignment button");
					if(isVisible(Bprocessing.SectionAssignmentRuleScreen)==true){
						Report.LogInfo("ValidateScreen", "Expected screen page displayed.", "PASS");			
						SelectDropDownValue(Bprocessing.BordereauAssignmentSectionDropDwn, Bprocessing.BordereauAssignmentSectionDropDwnOption);
						Bprocessing.SetMapping("Insured Address");
						
						SelectDropDownValue(Bprocessing.SectionUpperDropDwn, Bprocessing.SectionIdDropDwnOption2);
						SelectDropDownValue(Bprocessing.SectionLowerDropDwn, Bprocessing.SectionIdDropDwnOption2);
						SelectDropDownValue(Bprocessing.SectionBrentwoodDropDwn, Bprocessing.SectionIdDropDwnOption2);
						SelectDropDownValue(Bprocessing.SectionMainDropDwn, Bprocessing.SectionIdDropDwnOption1);
						SelectDropDownValue(Bprocessing.SectionFrnechDropDwn, Bprocessing.SectionIdDropDwnOption1);
						click(Bprocessing.CompleteAssignmentBtn,"Complete Assignment button");			
						
						SelectDropDownValue(Bprocessing.SectionRiskCodeDwn, Bprocessing.SectionRiskCodeDropoption);
						Bprocessing.SetMapping("Insured Address");
						SelectDropDownValue(Bprocessing.RiskcodeUpperDropDwn,  Bprocessing.SectionIdDropDwnOption2);
						SelectDropDownValue(Bprocessing.RiskcodeLowerDropDwn,  Bprocessing.SectionIdDropDwnOption2);
						SelectDropDownValue(Bprocessing.RiskcodeBrentwoodDropDwn,  Bprocessing.SectionIdDropDwnOption2);
						SelectDropDownValue(Bprocessing.RiskcodeMainDropDwn,  Bprocessing.SectionIdDropDwnOption1);
						SelectDropDownValue(Bprocessing.RiskcodeFrnechDropDwn,  Bprocessing.SectionIdDropDwnOption1);
						click(Bprocessing.CompleteAssignmentBtn,"Complete Assignment button");			
						BordereauProcess.clickOnApproveBordBtn();
						BordereauProcess.refreshUploadedFileApprovedStatus();
							if(isVisible(BordereauProcess.Approvedbtn)==true){
							Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
							BordereauProcess.openDATALink();
							BordereauProcess.navigateToDATARiskTab();
							//GrossPremium
							waitForElementToAppear(GrossPremium,5);
							mouseOverAction(GrossPremium);
							verifyMustExists(GrossPremium,"Gross Premium Including Tax column");
							sleep(2000);
							verifyExists(GrossPremium1Row,"Gross Premium 1 Value");
							verifyExists(GrossPremium2Row,"Gross Premium 2 Value");
							verifyExists(GrossPremium3Row,"Gross Premium 3 Value");
							verifyExists(GrossPremium4Row,"Gross Premium 4 Value");
							verifyExists(GrossPremium5Row,"Gross Premium 5 Value");
							verifyExists(GrossPremium6Row,"Gross Premium 6 Value");
							//NetPremium
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
							sleep(2000);
							policy.navigationOnBordereauxTab();
							BordereauProcess.navigateToApprovedTab();
							waitForElementToAppear(BordereauProcess.ApprovedButton,5);
							click(BordereauProcess.ApprovedButton,"Approved button");
							waitForElementToAppear(BordereauProcess.UnApprvBdrBtn,5);
							click(BordereauProcess.UnApprvBdrBtn,"UnApproved button");
							BordereauProcess.refreshUploadedFileForApprovalStatus();
							click(BordereauProcess.ForApprovalButton,"For Approval button");
							waitForElementToAppear(Bprocessing.RejectBtn,5);
							click(Bprocessing.RejectBtn,"Reject button");
							
							waitForElementToAppear(Bprocessing.RejectYesBtn,5);
							click(Bprocessing.RejectYesBtn,"Yes button");
							sleep(3000);
							if(isVisible(BordereauProcess.ReviewBtn)==true){
								Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
								BordereauProcess.openDATALink();
								BordereauProcess.navigateToDATARiskTab();
								//GrossPremium
								waitForElementToAppear(GrossPremium,5);
								mouseOverAction(GrossPremium);
								verifyMustExists(GrossPremium,"Gross Premium Including Tax column");
								sleep(2000);
								verifyExists(GrossPremium1Row,"Gross Premium 1 Value");
								verifyExists(GrossPremium2Row,"Gross Premium 2 Value");
								verifyExists(GrossPremium3Row,"Gross Premium 3 Value");
								verifyExists(GrossPremium4Row,"Gross Premium 4 Value");
								verifyExists(GrossPremium5Row,"Gross Premium 5 Value");
								verifyExists(GrossPremium6Row,"Gross Premium 6 Value");
								//NetPremium
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
								}else{
									Report.LogInfo("ReviewStatusValidation", "Review Status Button not Displayed", "FAIL");
								}
							}else{
								Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
							}
						}else{
							Report.LogInfo("validateexpectedScreen", "section assignment screen not Displayed", "FAIL");
						}
					}else{
						Report.LogInfo("ReviewStatusValidation", "Review Status Button not Displayed", "FAIL");
					}
			}else{
				Report.LogInfo("ReviewStatusValidation", "Review Status Button not Displayed", "FAIL");
				}
		}else{
			Report.LogInfo("validateSignedbutton", "Signed Status Button not Displayed", "FAIL");
		}	
	}
	
	
	public void locationBreaches_5085() throws Exception{
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS();
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails1(UniqueReferenceVal1, IncDate,ExpDate, Status1, policy.Broker1, policy.Bline1, policy.Underline1);
		waitForElementToAppear(BordereauProcess.DraftBtn,5);
		verifyExists(BordereauProcess.DraftBtn,"Draft Status Button");
		policy.changeStatusToQuote();
		policy.contractId = ReturnContractID();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		BordereauProcess.openSelectedPolicy();
		if(isVisible(BordereauProcess.SignedBtn)== true){
			verifyExists(BordereauProcess.SignedBtn,"Signed Status Button");
			policy.navigateToSectionTab1();	
			policy.navigateLocationTab();
			waitForElementToAppear(Bprocessing.LocationthreeRefdot,5);
			click(Bprocessing.LocationthreeRefdot,"location Edit dot");
			waitForElementToAppear(locationEditBtn,5);
			click(locationEditBtn,"location Edit option");
			waitForElementToAppear(EuropeExpandarrow,5);
			click(EuropeExpandarrow,"location Edit option");
			sleep(3000);
			waitForElementToAppear(Swedencheckbox,5);
			click(Swedencheckbox,"sweden check box");
			verifyMustExists(SwitzerlandArrow,"Switzerland Arrow" );
			click(SwitzerlandArrow,"switzerland Arrow");
			sleep(1000);
			verifyMustExists(ArgaucheckBox,"Switzerland Arrow" );
			click(ArgaucheckBox,"switzerland Arrow");
			verifyMustExists(SaveBtn,"Save button");
			click(SaveBtn,"Save button");
			sleep(2000);
			if(isVisible(policy.ConEndrsmntPopUp) == true)
			{
				sleep(1000);
				waitForElementToAppear(policy.SaveBtn3,5);
				verifyExists(policy.SaveBtn3,"Save Button");
				javaScriptclick(policy.SaveBtn3,"Save Button");
				sleep(5000);
			}

			scrollUp();
			sleep(2000);
			policy.navigationOnBordereauxTab();
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet5085Path = fpath+"\\src\\test\\resources\\testdata\\test locations_TC_5085.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet5085Path);  
	//		String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"test locations_TC_5085.xlsx\",\"UniqueFileName\":\"S83123220180222.xlsx\",\"BordereauFormatId\":\"fc9e696b-72a7-4ff3-b9d2-d49d3ac7bf4d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S83123220180222.xlsx\",\"Filesize\":19398,\"Path\":null,\"size\":19398,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"test locations_TC_5085.xlsx\",\"UniqueFileName\":\"S95956220180226.xlsx\",\"BordereauFormatId\":\"fc9e696b-72a7-4ff3-b9d2-d49d3ac7bf4d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S95956220180226.xlsx\",\"Filesize\":19398,\"Path\":null,\"size\":19398,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauProcess.refreshUploadedFile();
			if(isVisible(BordereauProcess.ReviewBtn)==true){
				Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
				click(BordereauProcess.ReviewBtn,"Review Button");
				sleep(3000);
				waitForElementToAppear(BordereauProcess.SuRcdAssmnt,10);
				verifyMustExists(BordereauProcess.SuRcdAssmnt,"Submit recor for Assignment button");
				click(BordereauProcess.SuRcdAssmnt,"Submit recor for Assignment button");
				BordereauProcess.refreshUploadedFileForApprovalStatus();
				click(BordereauProcess.ForApprovalButton,"ForApproval button");
				BordereauProcess.clickOnApproveBordBtn();
				BordereauProcess.refreshUploadedFileApprovedStatus();
				if(isVisible(BordereauProcess.Approvedbtn)==true){
					Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
					policy.navigateRulesTab();
					policy.navigateBreachesTab();
					waitForElementToAppear(policy.RulesDD,3);
					verifyMustExists(policy.RulesDD,"Rules Drop Down");
					click(policy.RulesDD,"Rule Drop Down");
						if(isVisible(policy.RulesRisksStateDDValue)==true){
							Report.LogInfo("validateExpectedoption", "Risks Located State option  displayed", "PASS");
							click(policy.RulesRisksStateDDValue,"Rule Drop Down value");
							sleep(2000);
							List <WebElement> list = findWebElements(Br.ActualExpectedRowCount);
							int count = list.size();
							if(count ==3)
							{
								Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is:"+count,"PASS");
							}else{
								Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is:"+count,"FAIL");
							}
							sleep(2000);
						}else{
							Report.LogInfo("validateExpectedoption", "Risks Located State option not displayed", "FAIL");
						}
					sleep(2000);
					refreshPage();
					sleep(2000);
					waitForElementToAppear(policy.RulesDD,3);
					verifyMustExists(policy.RulesDD,"Rules Drop Down");
					click(policy.RulesDD,"Rule Drop Down");
						if(isVisible(policy.RulesInsuredStateDDValue)==true){
							Report.LogInfo("validateExpectedoption", "Insured Domiciled State option  displayed", "PASS");
							click(policy.RulesInsuredStateDDValue,"Rule Drop Down value");
							sleep(2000);
							List <WebElement> list = findWebElements(Br.ActualExpectedRowCount);
							int count = list.size();
							if(count ==3)
							{
								Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is:"+count,"PASS");
							}else{
								Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is:"+count,"FAIL");
							}
							sleep(2000);
						}else{
							Report.LogInfo("validateExpectedoption", "Insured Domiciled State option not displayed", "FAIL");
						}
					sleep(2000);
					refreshPage();
					sleep(2000);
					waitForElementToAppear(policy.RulesDD,3);
					verifyMustExists(policy.RulesDD,"Rules Drop Down");
					click(policy.RulesDD,"Rule Drop Down");
						if(isVisible(policy.RulesRisksCountryDDValue)==true){
							Report.LogInfo("validateExpectedoption", "Risk Located country option  displayed", "PASS");
							click(policy.RulesRisksCountryDDValue,"Rule Drop Down value");
							sleep(2000);
							List <WebElement> list = findWebElements(Br.ActualExpectedRowCount);
							int count = list.size();
							if(count ==4)
							{
								Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is:"+count,"PASS");
							}else{
								Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is:"+count,"FAIL");
							}
							sleep(2000);
						}else{
							Report.LogInfo("validateExpectedoption", "Risk Located country option not displayed", "FAIL");
						}
					sleep(2000);
					refreshPage();
					sleep(2000);
					waitForElementToAppear(policy.RulesDD,3);
					verifyMustExists(policy.RulesDD,"Rules Drop Down");
					click(policy.RulesDD,"Rule Drop Down");
						if(isVisible(policy.RulesInsuredCountryDDValue)==true){
							Report.LogInfo("validateExpectedoption", "Insured Domiciled country option  displayed", "PASS");
							click(policy.RulesInsuredCountryDDValue,"Rule Drop Down value");
							sleep(2000);
							List <WebElement> list = findWebElements(Br.ActualExpectedRowCount);
							int count = list.size();
							if(count ==4)
							{
								Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is:"+count,"PASS");
							}else{
								Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is:"+count,"FAIL");
							}
							sleep(2000);
						}else{
							Report.LogInfo("validateExpectedoption", "Insured Domiciled country option not displayed", "FAIL");
						}
					sleep(2000);
				}else{
					Report.LogInfo("validateApprovedbutton", "Approved Status Button not Displayed", "FAIL");
				}
			}else{
				Report.LogInfo("validateReviewbutton", "Review Status Button not Displayed", "FAIL");
			}	
		}else{
			Report.LogInfo("validateSignedbutton", "Signed Status Button not Displayed", "FAIL");
		}
	}
	
	
	
	public void BordereauSummaryErrorsAndWarnings_5190() throws Exception{
		
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS();
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String subSheet = "SP - First Sheet";
		homePage.adminMenu();
		QuePage.bordereauQueLink();
		QuePage.bordereauQuePage();
		QuePage.filterBordereauQuestionnaire1(subSheet);
		sleep(2000);
		waitForElementToAppear(QuePage.EditBtn,5);
		verifyMustExists(QuePage.EditBtn,"Edit button");
		click(QuePage.EditBtn,"Edit button");
		QuePage.nextStapeClick();
		QuePage.FormatId = ReturnFormatID();
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails1(UniqueReferenceVal1, IncDate,ExpDate, Status1, policy.Broker1, policy.Bline1, policy.Underline1);
		waitForElementToAppear(BordereauProcess.DraftBtn,5);
		verifyExists(BordereauProcess.DraftBtn,"Draft Status Button");
		policy.changeStatusToQuote();
		policy.contractId = ReturnContractID();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		BordereauProcess.openSelectedPolicy();
		System.out.println(policy.contractId);
		if(isVisible(BordereauProcess.SignedBtn)== true){
			verifyExists(BordereauProcess.SignedBtn,"Signed Status Button");
			policy.navigationOnBordereauxTab();
			try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet5190Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_5190.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File excelFile = new File(sheet5190Path);  
				String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_5190.xlsx\",\"UniqueFileName\":\"S20158720180222.xlsx\",\"BordereauFormatId\":\""+QuePage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S20158720180222.xlsx\",\"Filesize\":18343,\"Path\":null,\"size\":18343,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				uploadFile(ReqUrl, excelFile, payload, DraftUrl);
				BordereauProcess.refreshUploadedFile();
				if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
				{
					Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error", "PASS");
					if(isVisible(ErrorPage)==true){
						verifyMustExists(ErrorPage,"Invalid date values identified error page");
						waitForElementToAppear(SkipAllErrorbtn1,10);
						verifyMustExists(SkipAllErrorbtn1,"Skip All Error");
						click(SkipAllErrorbtn1,"Skip All Error");
						sleep(2000);
						waitForElementToAppear(ErrorWarringlink,5);
						verifyMustExists(ErrorWarringlink,"Error Warring Tab");
						click(ErrorWarringlink,"Error Warring Tab");
						waitForElementToAppear(errorWarringMsg1,5);
						verifyExists(errorWarringMsg1,"Error and Warning message 1");
						verifyExists(errorWarringMsg2,"Error and Warning message 2");
						verifyExists(errorWarringMsg3,"Error and Warning message 3");
						verifyExists(errorWarringMsg4,"Error and Warning message 4");
						verifyExists(errorWarringMsg5,"Error and Warning message 5");
						verifyExists(errorWarringMsg6,"Error and Warning message 6");
						verifyExists(errorWarringMsg7,"Error and Warning message 7");
					//	verifyExists(errorWarringMsg8,"Error and Warning message 8");
						sleep(2000);
					}
				}else{
					Report.LogInfo("ReviewErrorStatusValidation", "Review error not Displayed", "FAIL");
				}
			
		}else{
			Report.LogInfo("validateSignedbutton", "Signed Status Button not Displayed", "FAIL");
		}
	}
	
	
	public void bordereauSummaryErrorsAndWarnings_5303() throws Exception{
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS();
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails1(UniqueReferenceVal1, IncDate,ExpDate, Status1, policy.Broker1, policy.Bline1, policy.Underline1);
		waitForElementToAppear(BordereauProcess.DraftBtn,5);
		verifyExists(BordereauProcess.DraftBtn,"Draft Status Button");
		policy.changeStatusToQuote();
		policy.contractId = ReturnContractID();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		BordereauProcess.openSelectedPolicy();
		if(isVisible(BordereauProcess.SignedBtn)== true){
			verifyExists(BordereauProcess.SignedBtn,"Signed Status Button");
			policy.addSection2("Section2","10","Property D&F (US binder)","GBP - British Pound","10","10","10","Low");
			Report.LogInfo("StepCheck", "Step 2,3 completed", "PASS");
			policy.navigateToSection2Tab();
			policy.navigateToRiskCodesTabOnSection();
			policy.addRiskCodesOnSection("1E - OVERSEAS LEG");
			Report.LogInfo("StepCheck", "Step 4 completed", "PASS"); 
			policy.navigateToSectionTab1();
			policy.navigateLocationTab();
			waitForElementToAppear(Bprocessing.LocationthreeRefdot,5);
			click(Bprocessing.LocationthreeRefdot,"location Edit dot");
			waitForElementToAppear(locationEditBtn,5);
			click(locationEditBtn,"location Edit option");
			sleep(2000);
			waitForElementToAppear(EuropeExpandarrow,5);
			click(EuropeExpandarrow,"location Edit option");
			sleep(3000);
			waitForElementToAppear(Swedencheckbox,5);
			click(Swedencheckbox,"sweden check box");
			sleep(1000);
			verifyMustExists(SaveBtn,"Save button");
			click(SaveBtn,"Save button");
			sleep(2000);
			if(isVisible(policy.ConEndrsmntPopUp) == true)
			{
				sleep(2000);
				waitForElementToAppear(policy.SaveBtn3,3);
				verifyExists(policy.SaveBtn3,"Save Button");
				javaScriptclick(policy.SaveBtn3,"Save Button");
				sleep(5000);
			}
			Report.LogInfo("StepCheck", "Step 9 completed", "PASS");
			scrollUp();
			policy.navigateToSectionTab2();
			policy.navigateLocationTab();
			waitForElementToAppear(Bprocessing.LocationthreeRefdot,5);
			click(Bprocessing.LocationthreeRefdot,"location Edit dot");
			waitForElementToAppear(locationEditBtn,5);
			click(locationEditBtn,"location Edit option");
			sleep(2000);
			waitForElementToAppear(EuropeExpandarrow,5);
			click(EuropeExpandarrow,"location Edit option");
			sleep(3000);
			
			
			verifyMustExists(SwitzerlandArrow,"Switzerland arrow" );
			click(SwitzerlandArrow,"switzerland arrow");
			sleep(1000);
			verifyMustExists(ArgaucheckBox,"Switzerland state" );
			click(ArgaucheckBox,"switzerland state");
			verifyMustExists(SaveBtn,"Save button");
			click(SaveBtn,"Save button");
			sleep(2000);
			if(isVisible(policy.ConEndrsmntPopUp) == true)
			{
				sleep(1000);
				waitForElementToAppear(policy.SaveBtn3,5);
				verifyExists(policy.SaveBtn3,"Save Button");
				javaScriptclick(policy.SaveBtn3,"Save Button");
				sleep(5000);
			}
			scrollUp();
			Report.LogInfo("StepCheck", "Step 13 completed", "PASS");
			waitForElementToAppear(Bprocessing.LocationthreeRefdot,5);
			click(Bprocessing.LocationthreeRefdot,"location Edit dot");
			waitForElementToAppear(CopyFromSection1,5);
			click(CopyFromSection1,"Copy from section 1 option");
			if(isVisible(policy.ConEndrsmntPopUp) == true)
			{
				sleep(1000);
				waitForElementToAppear(policy.SaveBtn3,5);
				verifyExists(policy.SaveBtn3,"Save Button");
				javaScriptclick(policy.SaveBtn3,"Save Button");
				sleep(3000);
			}
			scrollUp();
			sleep(2000);
			policy.navigationOnBordereauxTab();
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet5303Path = fpath+"\\src\\test\\resources\\testdata\\test locations_TC_5303.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet5303Path);  
			String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"test locations_TC_5303.xlsx\",\"UniqueFileName\":\"S96613420180223.xlsx\",\"BordereauFormatId\":\"fc9e696b-72a7-4ff3-b9d2-d49d3ac7bf4d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S96613420180223.xlsx\",\"Filesize\":18919,\"Path\":null,\"size\":18919,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		 	uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauProcess.refreshUploadedFile();
			if(isVisible(BordereauProcess.ReviewBtn)==true){
				Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
				click(BordereauProcess.ReviewBtn,"Review Button");
				sleep(3000);
				waitForElementToAppear(BordereauProcess.SuRcdAssmnt,10);
				verifyMustExists(BordereauProcess.SuRcdAssmnt,"Submit recor for Assignment button");
				click(BordereauProcess.SuRcdAssmnt,"Submit recor for Assignment button");
				if(isVisible(Bprocessing.SectionAssignmentRuleScreen)==true){
					Report.LogInfo("ValidateScreen", "Expected screen page displayed.", "PASS");			
					SelectDropDownValue(Bprocessing.BordereauAssignmentSectionDropDwn, Bprocessing.SectionAssignmentSection2);
					click(CompleteAssignbtn,"Complete Assignment button");			
					BordereauProcess.clickOnApproveBordBtn();
					BordereauProcess.refreshUploadedFileApprovedStatus();
						if(isVisible(BordereauProcess.Approvedbtn)==true){
						Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
						Report.LogInfo("StepCheck", "Step 19 completed", "PASS");
						sleep(20000);
						policy.navigateRulesTab();
						policy.navigateBreachesTab();
						waitForElementToAppear(policy.RulesDD,3);
						verifyMustExists(policy.RulesDD,"Rules Drop Down");
						click(policy.RulesDD,"Rule Drop Down");
						if(isVisible(policy.RulesRisksCountryDDValue)==true){
								Report.LogInfo("validateExpectedoption", "Risks Located Country option  displayed", "PASS");
								click(policy.RulesRisksCountryDDValue,"Rule Drop Down value");
								sleep(2000);
								List <WebElement> list = findWebElements(Br.ActualExpectedRowCount);
								int count = list.size();
								if(count ==4)
								{
									Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is:"+count,"PASS");
								}else{
									Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is:"+count,"FAIL");
								}
								sleep(2000);
							}else{
								Report.LogInfo("validateExpectedoption", "Risks Located Country option not displayed", "FAIL");
							}
							sleep(2000);
						refreshPage();
						sleep(2000);
						waitForElementToAppear(policy.RulesDD,3);
						verifyMustExists(policy.RulesDD,"Rules Drop Down");
						click(policy.RulesDD,"Rule Drop Down");
						if(isVisible(policy.RulesInsuredCountryDDValue)==true){
								Report.LogInfo("validateExpectedoption", "Insured Domiciled country option  displayed", "PASS");
								click(policy.RulesInsuredCountryDDValue,"Rule Drop Down value");
								sleep(2000);
								List <WebElement> list = findWebElements(Br.ActualExpectedRowCount);
								int count = list.size();
								if(count ==4)
								{
									Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is:"+count,"PASS");
								}else{
									Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is:"+count,"FAIL");
								}
								sleep(2000);
							}else{
								Report.LogInfo("validateExpectedoption", "Insured Domiciled country option not displayed", "FAIL");
							}
							sleep(2000);
						refreshPage();
						sleep(2000);
						waitForElementToAppear(policy.RulesDD,3);
						verifyMustExists(policy.RulesDD,"Rules Drop Down");
						click(policy.RulesDD,"Rule Drop Down");
						if(isVisible(policy.RulesRisksStateDDValue)==true){
								Report.LogInfo("validateExpectedoption", "Risk Located State option  displayed", "PASS");
								click(policy.RulesRisksStateDDValue,"Rule Drop Down value");
								sleep(2000);
								List <WebElement> list = findWebElements(Br.ActualExpectedRowCount);
								int count = list.size();
								if(count ==3)
								{
									Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is:"+count,"PASS");
								}else{
									Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is:"+count,"FAIL");
								}
								sleep(2000);
							}else{
								Report.LogInfo("validateExpectedoption", "Risk Located State option not displayed", "FAIL");
							}
							sleep(2000);
						refreshPage();
						sleep(2000);
						waitForElementToAppear(policy.RulesDD,3);
						verifyMustExists(policy.RulesDD,"Rules Drop Down");
						click(policy.RulesDD,"Rule Drop Down");
						if(isVisible(policy.RulesInsuredStateDDValue)==true){
								Report.LogInfo("validateExpectedoption", "Insured Domiciled State option  displayed", "PASS");
								click(policy.RulesInsuredStateDDValue,"Rule Drop Down value");
								sleep(2000);
								List <WebElement> list = findWebElements(Br.ActualExpectedRowCount);
								int count = list.size();
								if(count ==3)
								{
									Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is:"+count,"PASS");
								}else{
									Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is:"+count,"FAIL");
								}
								sleep(2000);
							}else{
								Report.LogInfo("validateExpectedoption", "Insured Domiciled State option not displayed", "FAIL");
							}
							sleep(2000);
						}else{
							Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
						}
				}else{
				Report.LogInfo("validateReviewdbutton", "Review Status Button not Displayed", "FAIL");
				}
			}else{
			Report.LogInfo("validateSignedbutton", "Signed Status Button not Displayed", "FAIL");
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//********************Reusable Functions********************************************
	public void selectDataFieldAscOrder()
	{
		verifyMustExists(DataField,"Data field Column");
		click(DataField,"Click on Data field Column");
		sleep(3000);
		verifyMustExists(DataFieldAscIcon,"Row Number Ascending icon");  
		sleep(3000);
	}
}
