package com.tide.qa.pagefactory;

import com.tide.qa.common.PageBase;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class DataAssignmentAndApproverRolesPage extends PageBase {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BordereauProcessPage BorderauPage = new BordereauProcessPage();
	BordereauQuePage BQPage= new BordereauQuePage();
	PolicyPage policy = new PolicyPage();
	Rules rule= new Rules();
	BProcessingRiskPremiumClaimPage BClaim = new BProcessingRiskPremiumClaimPage();

	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("ssMsddMMyy");
		String datetime = ft.format(dNow);
		return datetime;
	}

	public static String contractId;
	public static String sheet4661Path ="";
	public static String sheet4427Path ="";
	public static String sheet4427SecondPath ="";
	public static String sheet4559Path ="";
	public static String sheet4559Path1 ="";
	public static String FormatId;



	public static final String SectionDataAssignmentPopUp="@xpath=//*[text()='Section Data Assignment']";
	public static final String SectionDataAssignmentField="@xpath=//*[@ng-if='IsAutoAssignment && sectionRiskType == 1']";
	public static final String CloseBtn1="@xpath=//*[@ng-click='ok()']";
	public static final String RiskCodeDataAssignmentPopUp="@xpath=//*[text()='Risk Code Data Assignment']";
	public static final String RiskCodeDataAssignmentFiled="@xpath=//*[@ng-if='IsAutoAssignment && sectionRiskType == 2']";

	public static final String SectionAssignmentRulepage="@xpath=//h2[contains(.,'Section Assignment Rule')]";
	public static final String SectionAssignmentdropdown="@xpath=//*[@aria-label='select']";
	public static final String SectionAssignmentdropdownValue="@xpath=//ul/li[contains(.,'Data in the bordereau will specify the Section')]";
	public static final String BuildingYearBuilt="@xpath=//*[text()='Building Year Built']";
	public static final String RiskReference="@xpath=//*[text()='Risk Reference']";
	
	public static final String RightArrow="@xpath=//div[contains(@ng-click,'addToSelectionList')]";
	public static final String ValidateSectionMappingText="@xpath=//h2[contains(.,' You have changed the field(s) selected to complete the assignment mappings. As a result, the previous assignment mappings recorded will be forgotten, and new assignment mappings will need to be completed. Are you sure you wish to proceed')]";

	public static final String YESUpdateRuleButton="@xpath=//button[contains(.,'YES, UPDATE FIELD ASSIGNMENT')]";
	public static final String SetMappingRuleBtn="@xpath=//button[contains(.,'Set Mapping Rule')]";
	public static final String BackToAssignmentRuleButton="@xpath=//button[contains(.,'Back to Assignment Rules')]";
	public static final String SectionMappingpage="@xpath=//h2[contains(.,'Section Mapping')]";
	public static final String SectionMappingdropdown1="@xpath=//tr[1]//*[@aria-label='select']";
	public static final String SectionMappingdropdownvalue1="@xpath=//ul[@aria-hidden='false']//li[contains(.,'Section 1')]";
	public static final String SectionMappingdropdown2="@xpath=//tr[2]//*[@aria-label='select']";
	public static final String SectionMappingdropdownvalue2="@xpath=//ul[@aria-hidden='false']//li[contains(.,'Section 1')]";
	public static final String SectionMappingdropdown3="@xpath=//tr[3]//*[@aria-label='select']";
	public static final String SectionMappingdropdownvalue3="@xpath=//ul[@aria-hidden='false']//li[contains(.,'Section 1')]";
	public static final String SectionMappingdropdown4="@xpath=//tr[4]//*[@aria-label='select']";
	public static final String SectionMappingdropdownvalue4="@xpath=//ul[@aria-hidden='false']//li[contains(.,'Section 2')]";
	public static final String SectionMappingdropdown5="@xpath=//tr[5]//*[@aria-label='select']";
	public static final String SectionMappingdropdownvalue5="@xpath=//ul[@aria-hidden='false']//li[contains(.,'Section 2')]";

	public static final String SectionMappingdropdown6="@xpath=//tr[1]//*[@aria-label='select']";
	public static final String SectionMappingdropdownvalue6="@xpath=//ul[@aria-hidden='false']//li[contains(.,'Section 2')]";

	public static final String SectionMappingdropdown7="@xpath=//tr[2]//*[@aria-label='select']";
	public static final String SectionMappingdropdownvalue7="@xpath=//ul[@aria-hidden='false']//li[contains(.,'Section 2')]";

	public static final String SectionMappingdropdown8="@xpath=//tr[3]//*[@aria-label='select']";
	public static final String SectionMappingdropdownvalue8="@xpath=//ul[@aria-hidden='false']//li[contains(.,'Section 1')]";

	public static final String CompleteAssignmentBtn="@xpath=//button[contains(.,'Complete Assignment')]";
	public static final String RiskCodeAssignmentpage="@xpath=//h2[contains(.,'Risk Code Assignment Rule')]";
	public static final String RiskcodeAssignmentdropdown="@xpath=//*[@aria-label='select']";

	public static final String RiskcodeAssignmentdropdownValue="@xpath=//ul/li[contains(.,'Default all entries in the Bordereau to the primary Risk Code of the Section')]";

	public static final String JanuaryFrApprvl="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='January']//preceding::td[4]//button[contains(@ng-click,'GoToBordereauSummaryScreen')]";
	public static final String FebFrApprvl="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='February']//preceding::td[4]//button[contains(@ng-click,'GoToBordereauSummaryScreen')]";
	public static final String MarchFrApprvl="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='March']//preceding::td[4]//button[contains(@ng-click,'GoToBordereauSummaryScreen')]";


	public static final String RiskCodeDataAssignmentFiled5="@xpath=//*[@ng-if='ruleTypeAssignment == 1 && sectionRiskType == 2']";

	public static final String SectionAssignmentRuleBtn="@xpath=//div[@ng-click='openPopup(dataItem,1)']";
	public static final String RiskCodeRuleBtn="@xpath=//div[@ng-click='openPopup(dataItem,2)']";
	public static final String SectionAssignmentPopup="@xpath=//h2[contains(.,'Section Assignment Rules')]";
	public static final String ViewOnAssignmentRules="@xpath=//*[@ng-if='AssignementRulesPermission.View']";
	public static final String SectionAssignmentRulepage1="@xpath=//h2[contains(.,'Section Assignment Rules')]";
	public static final String SectionAssignmentMappingRulepage="@xpath=//h2[contains(.,'Section Assignment Mapping Rule')]";
	public static final String Mapping1="@xpath=//li[contains(.,'Building Year Built')]";
	public static final String CompanyNameEXists="@xpath=//p[contains(.,'Charles Taylor InsureTech - CT Test Broker company')]";
	public static final String ViewMappingRules="@xpath=//*[@ng-click='viewMappingRules()']";
	public static final String BackToAssignmentBtn1="@xpath=//*[@ng-click='viewAssignmentRules()']";	

	public static final String RiskCodeAssignmentRulesPopUp="@xpath=//h2[contains(.,'Risk Code Assignment Rules')]";
	public static final String RiskCodeAssignmentRulePopUp="@xpath=//*[@ng-if='DefaultRiskcodeFromSection']";

	public static final String VerifyVersionLbl="@xpath=//td[text()='2']";
	public static final String CloseBtn="@xpath=//button[contains(.,'CLOSE')]";

	public static final String CloseBtn2="@xpath=//*[@ng-click='close()']";


	public static final String SectionDataAssignmentField1="@xpath=//*[@ng-if='ruleTypeAssignment == 3 && sectionRiskType == 1']";
	public static final String ViewAssignmentRulebtn="@xpath=//*[@ng-click='openRuleVersionPopup()']";

	public static final String Sectionrow1="@xpath=//*[@ng-if='!hasError && !loading1 && !showMappingBtn']//tbody//tr[1]//td[1][text()='1']";
	public static final String Sectionrow2="@xpath=//*[@ng-if='!hasError && !loading1 && !showMappingBtn']//tbody//tr[2]//td[1][text()='1']";
	public static final String Sectionrow3="@xpath=//*[@ng-if='!hasError && !loading1 && !showMappingBtn']//tbody//tr[2]//td[1][text()='1']";
	public static final String Sectionrow4="@xpath=//*[@ng-if='!hasError && !loading1 && !showMappingBtn']//tbody//tr[4]//td[1][text()='2']";
	public static final String Sectionrow5="@xpath=//*[@ng-if='!hasError && !loading1 && !showMappingBtn']//tbody//tr[5]//td[1][text()='2']";
	public static final String Sectionrow6="@xpath=//*[@ng-if='!hasError && !loading1 && !showMappingBtn']//tbody//tr[6]//td[1][text()='2']";
	public static final String Sectionrow7="@xpath=//*[@ng-if='!hasError && !loading1 && !showMappingBtn']//tbody//tr[7]//td[1][text()='2']";
	public static final String Sectionrow8="@xpath=//*[@ng-if='!hasError && !loading1 && !showMappingBtn']//tbody//tr[8]//td[1][text()='1']";

	public static final String RiskReferencerow1="@xpath=//*[@ng-if='!hasError && !loading1 && !showMappingBtn']//tbody//tr[1]//td[2][text()='1']";
	public static final String RiskReferencerow2="@xpath=//*[@ng-if='!hasError && !loading1 && !showMappingBtn']//tbody//tr[2]//td[2][text()='2']";
	public static final String RiskReferencerow3="@xpath=//*[@ng-if='!hasError && !loading1 && !showMappingBtn']//tbody//tr[3]//td[2][text()='3']";
	public static final String RiskReferencerow4="@xpath=//*[@ng-if='!hasError && !loading1 && !showMappingBtn']//tbody//tr[4]//td[2][text()='4']";
	public static final String RiskReferencerow5="@xpath=//*[@ng-if='!hasError && !loading1 && !showMappingBtn']//tbody//tr[5]//td[2][text()='5']";
	public static final String RiskReferencerow6="@xpath=//*[@ng-if='!hasError && !loading1 && !showMappingBtn']//tbody//tr[6]//td[2][text()='6']";
	public static final String RiskReferencerow7="@xpath=//*[@ng-if='!hasError && !loading1 && !showMappingBtn']//tbody//tr[7]//td[2][text()='7']";
	public static final String RiskReferencerow8="@xpath=//*[@ng-if='!hasError && !loading1 && !showMappingBtn']//tbody//tr[8]//td[2][text()='8']";


	//TC 4559
	public static final String BackToAssignmentBtn="@xpath=//button[contains(.,'Back to Assignment Rules')]";
	public static final String Mapping10="@xpath=//tr[1]//*[@ng-if='data.SectionLookUp.length > 0']//preceding-sibling::span[1]";
	public static final String Section1Value="@xpath=//ul[@aria-hidden='false']//li[contains(.,'Section 1')]";
	public static final String Mapping11="@xpath=//tr[2]//*[@ng-if='data.SectionLookUp.length > 0']//preceding-sibling::span[1]";
	public static final String Section2Value="@xpath=//ul[@aria-hidden='false']//li[contains(.,'Section 2')]";	
	public static final String Mapping9="@xpath=//tr[3]//*[@ng-if='data.SectionLookUp.length > 0']//preceding-sibling::span[1]";
	public static final String NoOfStories="@xpath=//span[contains(.,'Number of Stories')]";
	//	public static final String RightArrow="@xpath=//div[contains(@ng-click,'addToSelectionList')]";
	public static final String GrossPremium="@xpath=//span[contains(.,'Gross Premium')]";
	public static final String UpdateAssignmentPopup="@xpath=//button[contains(.,'YES, UPDATE FIELD ASSIGNMENT')]";
	//	public static final String SetMappingRuleBtn="@xpath=//button[contains(.,'Set Mapping Rule')]";
	//	public static final String CompleteAssignmentBtn="@xpath=//button[contains(.,'Complete Assignment')]";
	//	public static final String SectionAssignmentRuleBtn="@xpath=//div[@ng-click='openPopup(dataItem,1)']";
	//	public static final String RiskCodeRuleBtn="@xpath=//div[@ng-click='openPopup(dataItem,2)']";
	//	public static final String SectionAssignmentPopup="@xpath=//h2[contains(.,'Section Assignment Rules')]";
	//	public static final String VerifyVersionLbl="@xpath=//td[text()='2']";
	//	public static final String CloseBtn="@xpath=//button[contains(.,'CLOSE')]";
	public static final String V2EditBtn="@xpath=//tr[1]//div[@ng-click='openRuleTypeModalOnEdit(dataItem)']";
	public static final String Sprinklers="@xpath=//td[contains(.,'Sprinklers (Y/N)')]";
	public static final String VerifyVersion3Lbl="@xpath=//td[text()='3']";
	public static final String V3ViewBtn="@xpath=//tr[1]//div[@ng-click='openRuleTypeModal(dataItem)']";
	//	public static final String Mapping1="@xpath=//li[contains(.,'Risk Reference')]";
	public static final String Mapping2="@xpath=//li[contains(.,'Sprinklers (Y/N)')]";
	public static final String Mapping3="@xpath=//li[contains(.,'Number of Stories')]";
	public static final String Mapping4="@xpath=//li[contains(.,'Gross Premium')]";
	public static final String MapClose="@xpath=//button[@ng-click='close()']";
	public static final String RiskCodeContractDD="@xpath=//*[@ng-model='form.defaultSectionRiskCode']//preceding-sibling::span[1]";
	public static final String RiskCodeContractValue="@xpath=//li[contains(.,'Data in the bordereau will specify the Risk Code')]";
	public static final String RiskCountry="@xpath=//td[contains(.,'Risk Country')]";
	public static final String SaveRuleBtn="@xpath=//button[contains(.,'SAVE RULE')]";
	public static final String RiskCountryLbl="@xpath=//li[contains(.,'Risk Country')]";
	public static final String LeftArrow="@xpath=//div[contains(@ng-click,'removeFromSelectionList')]";
	public static final String MayFrApprvl="@xpath=//span[@ng-bind='dataItem.MonthString'][text()='May']//preceding::td[4]//button[contains(@ng-click,'GoToBordereauSummaryScreen')]";



	public void automaticAssignment_4661() throws Exception
	{
		String subSheet="Process Enrichment Format (Automation Schema)";
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String SubmitSheet="SP- FirstSheet";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(SubmitSheet);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		FormatId = ReturnFormatID();
		policy.addPolicy2(IncDate, ExpDate);
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		BorderauPage.applyFilterPolicy(policy.PolicyNumber);
		//	BorderauPage.applyFilterPolicy("614918VC");
		BorderauPage.openSelectedPolicy();
		waitForElementToAppear(BorderauPage.SignedBtn,10);
		if(isVisible(BorderauPage.SignedBtn)== true){
			verifyExists(BorderauPage.SignedBtn,"Signed Status Button");
			BorderauPage.SubmitBordereaux(subSheet);	
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4661Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_4661.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4661Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			//	String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"YOAFrom_sheet_name_TC_3879.xlsx\",\"UniqueFileName\":\"S49248220180025.xlsx\",\"BordereauFormatId\":\"bc2ca3dd-d933-4930-8989-a65bf0499b82\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S49248220180025.xlsx\",\"Filesize\":18482,\"Path\":null,\"size\":18482,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";		
			String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_4661.xlsx\",\"UniqueFileName\":\"S48268220180120.xlsx\",\"BordereauFormatId\":\""+FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S48268220180120.xlsx\",\"Filesize\":24197,\"Path\":null,\"size\":24197,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BorderauPage.refreshUploadedFile();
			if(isVisible(BorderauPage.ReviewBtn)==true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed Successfully.", "PASS");
				click(BorderauPage.ReviewBtn," cliked on ReviewBtn");
				if(isVisible(rule.SummaryScreen)==true){
					Report.LogInfo("ValidateExpectedScreen", "Summary Screen open successfully", "PASS");
					rule.GetApproveStatus();
					//	BorderauPage.refreshUploadedFileApprovedStatus();
					BorderauPage.refreshAfterApproveFile(JanuaryFrApprvl);
					if(isVisible(BorderauPage.ApprovedButton)==true){
						Report.LogInfo("ValidateApproved","Approved status displayed", "PASS");
						BorderauPage.openDATALink();
						BorderauPage.navigateToDATARiskTab();
						//Section Column
						String Sectioncolumn="@xpath=//*[@data-field='Section']";
						String Section1="@xpath=//*[@data-field='Section']//following::tr[1]//td[contains(@ng-click,'Section')]";
						String Section2="@xpath=//*[@data-field='Section']//following::tr[2]//td[contains(@ng-click,'Section')]";
						String Section3="@xpath=//*[@data-field='Section']//following::tr[3]//td[contains(@ng-click,'Section')]";
						waitForElementToAppear(Sectioncolumn,8);
						mouseOverAction(Sectioncolumn);
						verifyMustExists(Sectioncolumn,"Year Of Account column");
						sleep(2000);
						verifyExists(Section1,"1st value");
						verifyExists(Section2,"2nd value");
						verifyExists(Section3,"3rd value");
						sleep(2000);
						click(Section3,"Section 1");
						waitForElementToAppear(SectionDataAssignmentPopUp,5);
						if(isVisible(SectionDataAssignmentPopUp)==true){
							verifyMustExists(SectionDataAssignmentPopUp,"Section Data Assignment pop up");
							waitForElementToAppear(SectionDataAssignmentField,3);
							verifyMustExists(SectionDataAssignmentField,"Section Data Assignment Field");
							waitForElementToAppear(CloseBtn1,3);
							verifyMustExists(CloseBtn1,"Close Button");
							click(CloseBtn1,"Close Button");
						}else{
							Report.LogInfo("ValidateSectionDataAssignmentPopUp","Section Data Assignment PopUp not displayed", "FAIL");
						}
						sleep(2000);
						//RiskCode column
						String RiskCodecolumn="@xpath=//*[@data-field='RiskCode']";
						String RiskCode1="@xpath=//*[@data-field='RiskCode']//following::tr[1]//td[contains(@ng-click,'RiskCode')]";
						String RiskCode2="@xpath=//*[@data-field='RiskCode']//following::tr[2]//td[contains(@ng-click,'RiskCode')]";
						String RiskCode3="@xpath=//*[@data-field='RiskCode']//following::tr[3]//td[contains(@ng-click,'RiskCode')]";
						waitForElementToAppear(RiskCodecolumn,8);
						mouseOverAction(RiskCodecolumn);
						verifyMustExists(RiskCodecolumn,"Year Of Account column");
						sleep(2000);
						verifyExists(RiskCode1,"1st value");
						verifyExists(RiskCode2,"2nd value");
						verifyExists(RiskCode3,"3rd value");
						sleep(2000);
						click(RiskCode3,"Risk code 1T");
						waitForElementToAppear(RiskCodeDataAssignmentPopUp,5);
						if(isVisible(RiskCodeDataAssignmentPopUp)==true){
							verifyMustExists(RiskCodeDataAssignmentPopUp,"Risk Code Data Assignment PopUp");
							waitForElementToAppear(RiskCodeDataAssignmentFiled,3);
							verifyMustExists(RiskCodeDataAssignmentFiled,"Risk Code Data Assignment Field");
							waitForElementToAppear(CloseBtn1,3);
							verifyMustExists(CloseBtn1,"Close Button");
							click(CloseBtn1,"Close Button");
						}else{
							Report.LogInfo("ValidateSectionDataAssignmentPopUp","Risk Code Data Assignment PopUp not displayed", "FAIL");
						}	
						sleep(2000);
					}else{
						Report.LogInfo("ValidateApproved","Approved status not displayed", "FAIL");
					}	
				}else{
					Report.LogInfo("ValidateExpectedScreen","Summary Screen not displayed", "FAIL");
					goBack();
					BorderauPage.deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed ", "FAIL");
				BorderauPage.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}


	public static final String RiskCode1EDDValue ="@xpath=//ul[@aria-hidden='false']//li[1]";
	public static final String RiskCode1TDDValue ="@xpath=//ul[@aria-hidden='false']//li[1]";

	public void sectionAndRiskCode_4427() throws Exception
	{
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		BorderauPage.applyFilterPolicy(policy.PolicyNumber);
		//	BorderauPage.applyFilterPolicy("775226ZV");
		BorderauPage.openSelectedPolicy();
		waitForElementToAppear(BorderauPage.SignedBtn,10);
		if(isVisible(BorderauPage.SignedBtn)== true){
			verifyExists(BorderauPage.SignedBtn,"Signed Status Button");
			policy.addSection2("Automation Section 2");
			policy.navigateToSection2Tab();
			policy.navigateToMarketsTabOnSection();
			policy.addMarketOnSection();
			if(isVisible(policy.SecondRuleSectionPopUp) == true)
			{
				verifyMustExists(policy.SaveBtn4,"Save button");
				click(policy.SaveBtn4,"Save button");
				sleep(2000);
			}
			policy.navigateToRiskCodesTabOnSection();
			policy.addRiskCodesOnSection2(RiskCode1EDDValue,"40");
			policy.addRiskCodesOnSection2(RiskCode1TDDValue,"60");
			BorderauPage.SubmitBordereauxWithYesnoButtons1();
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4427Path = fpath+"\\src\\test\\resources\\testdata\\Feb_TC_4427.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4427Path);  
			//String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_4661.xlsx\",\"UniqueFileName\":\"S48268220180120.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S48268220180120.xlsx\",\"Filesize\":24197,\"Path\":null,\"size\":24197,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Feb_TC_4427.xlsx\",\"UniqueFileName\":\"S81247720180121.xlsx\",\"BordereauFormatId\":\""+FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S81247720180121.xlsx\",\"Filesize\":24657,\"Path\":null,\"size\":24657,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BorderauPage.refreshUploadedFile();
			if(isVisible(BorderauPage.ReviewBtn)==true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed Successfully.", "PASS");
				click(BorderauPage.ReviewBtn," cliked on ReviewBtn");
				if(isVisible(rule.SummaryScreen)==true){
					Report.LogInfo("ValidateExpectedScreen", "Summary Screen open successfully", "PASS");
					approveFebFile();
					if(isVisible(FebFrApprvl)==true){
						Report.LogInfo("ValidateApproved","Approved status displayed", "PASS");
						BorderauPage.openDATALink();
						BorderauPage.navigateToDATARiskTab();
						//RiskCode column
						String RiskCodecolumn="@xpath=//*[@data-field='RiskCode']";
						String RiskCode5="@xpath=//*[@data-field='RiskCode']//following::tr[5]//td[contains(@ng-click,'RiskCode')]";
						waitForElementToAppear(RiskCodecolumn,8);
						mouseOverAction(RiskCodecolumn);
						verifyMustExists(RiskCodecolumn,"Year Of Account column");
						sleep(2000);
						verifyExists(RiskCode5,"1st value");
						sleep(2000);
						click(RiskCode5,"Risk code 1T");
						waitForElementToAppear(RiskCodeDataAssignmentPopUp,5);
						if(isVisible(RiskCodeDataAssignmentPopUp)==true){
							verifyMustExists(RiskCodeDataAssignmentPopUp,"Risk Code Data Assignment PopUp");
							waitForElementToAppear(RiskCodeDataAssignmentFiled5,3);
							verifyMustExists(RiskCodeDataAssignmentFiled5,"Risk Code Data Assignment Field");
							waitForElementToAppear(CloseBtn1,3);
							verifyMustExists(CloseBtn1,"Close Button");
							click(CloseBtn1,"Close Button");
							sleep(3000);
						}	
						policy.navigateToReportingChannelsTab();
						VerifyAssignment();
						BorderauPage.SubmitBordereauxWithYesnoButtons1();
						try 
						{
							String fpath = new File(".").getCanonicalPath();
							sheet4427SecondPath = fpath+"\\src\\test\\resources\\testdata\\March_TC_4427.xlsx";
						} 
						catch (IOException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						File excelFile2 = new File(sheet4427SecondPath);  
						//String payload2 ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Feb_TC_4427.xlsx\",\"UniqueFileName\":\"S81247720180121.xlsx\",\"BordereauFormatId\":\"cfa01995-b545-4567-a8d9-c15df85345fd\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S81247720180121.xlsx\",\"Filesize\":24657,\"Path\":null,\"size\":24657,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						String payload2 ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":3,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"March_TC_4427.xlsx\",\"UniqueFileName\":\"S63439620180121.xlsx\",\"BordereauFormatId\":\""+FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S63439620180121.xlsx\",\"Filesize\":25165,\"Path\":null,\"size\":25165,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						uploadFile(ReqUrl, excelFile2, payload2, DraftUrl);
						BorderauPage.refreshUploadedFile();
						if(isVisible(BorderauPage.ReviewBtn)==true){
							Report.LogInfo("ValidateReviewStatus", "Review status displayed Successfully.", "PASS");
							click(BorderauPage.ReviewBtn," cliked on ReviewBtn");
							if(isVisible(rule.SummaryScreen)==true){
								Report.LogInfo("ValidateExpectedScreen", "Summary Screen open successfully", "PASS");
								approveMarchFile();

								if(isVisible(MarchFrApprvl)==true){
									Report.LogInfo("ValidateApproved","Approved status displayed", "PASS");
									BorderauPage.openDATALink();
									BorderauPage.navigateToDATARiskTab();
									//RiskCode column
									RiskCodecolumn="@xpath=//*[@data-field='RiskCode']";
									String RiskCode1="@xpath=//*[@data-field='RiskCode']//following::tr[5]//td[contains(@ng-click,'RiskCode')]";
									waitForElementToAppear(RiskCodecolumn,8);
									mouseOverAction(RiskCodecolumn);
									verifyMustExists(RiskCodecolumn,"Year Of Account column");
									sleep(2000);
									verifyExists(RiskCode1,"1st value");
									//Section Column
									String Sectioncolumn="@xpath=//*[@data-field='Section']";
									String Section1="@xpath=//*[@data-field='Section']//following::tr[1]//td[contains(@ng-click,'Section')]";
									waitForElementToAppear(Sectioncolumn,8);
									mouseOverAction(Sectioncolumn);
									verifyMustExists(Sectioncolumn,"Year Of Account column");
									sleep(2000);
									verifyExists(Section1,"1st value");
									sleep(2000);
									click(Section1,"Section 1 value");
									waitForElementToAppear(SectionDataAssignmentPopUp,8);
									verifyMustExists(SectionDataAssignmentPopUp,"Section Data Assignment pop up");
									verifyMustExists(SectionDataAssignmentField1,"Section Data Assignment Field");
									verifyMustExists(ViewAssignmentRulebtn,"View Assignment Rule button");
									click(ViewAssignmentRulebtn,"View Assignment Rule button");
									waitForElementToAppear(Mapping1,5);
									verifyMustExists(Mapping1,"Risk Reference");
									verifyMustExists(ViewMappingRules,"View Mapping Rules");
									click(ViewMappingRules,"View Mapping Rules");
									waitForElementToAppear(SectionAssignmentMappingRulepage,5);
									verifyMustExists(SectionAssignmentMappingRulepage,"Section Assignment Mapping Rule page");

									verifyExists(Sectionrow1,"1st section value");
									verifyExists(RiskReferencerow1,"1st Risk Reference value");
									verifyExists(Sectionrow2,"2nd section value");
									verifyExists(RiskReferencerow2,"2nd Risk Reference  value");
									verifyExists(Sectionrow3,"3rd section value");
									verifyExists(RiskReferencerow3,"3rd Risk Reference value");
									verifyExists(Sectionrow4,"4th section value");
									verifyExists(RiskReferencerow4,"4th Risk Reference value");
									verifyExists(Sectionrow5,"5th section value");
									verifyExists(RiskReferencerow5,"5st Risk Reference value");
									verifyExists(Sectionrow6,"6st section value");
									verifyExists(RiskReferencerow6,"6stRisk Reference  value");
									verifyExists(Sectionrow7,"7th section value");
									verifyExists(RiskReferencerow7,"7th Risk Reference value");
									verifyExists(Sectionrow8,"8st section value");
									verifyExists(RiskReferencerow8,"8th Risk Reference value");
									verifyMustExists(CloseBtn2,"Close Button");
									click(CloseBtn2,"Close Button");
									waitForElementToAppear(SectionDataAssignmentPopUp,8);
									verifyMustExists(SectionDataAssignmentPopUp,"Section Data Assignment pop up");
									verifyMustExists(CloseBtn1,"Close button");
									click(CloseBtn1,"Close Button");
									sleep(3000);
								}else{
									Report.LogInfo("ValidateSectionDataAssignmentPopUp","Risk Code Data Assignment PopUp not displayed", "FAIL");
								}
								}else{
									Report.LogInfo("ValidateApproved","Approved status not displayed", "FAIL");
								}	
							}else{
								Report.LogInfo("ValidateExpectedScreen","Summary Screen not displayed", "FAIL");
								goBack();
								BorderauPage.deleteBorderEAUX();
							}	
						}else{
							Report.LogInfo("ValidateReviewStatus", "Review status not displayed ", "FAIL");
							BorderauPage.deleteBorderEAUX();
						}
					}else{
						Report.LogInfo("ValidateApproved","Approved status not displayed", "FAIL");
					}	
				}else{
					Report.LogInfo("ValidateExpectedScreen","Summary Screen not displayed", "FAIL");
					goBack();
					BorderauPage.deleteBorderEAUX();
				}	
			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed ", "FAIL");
				BorderauPage.deleteBorderEAUX();
			}
		
		
	}

	
	public void updateAssignmentMapping_4559() throws Exception
	{
		//Step 1
		BorderauPage.applyFilterPolicy(policy.PolicyNumber);
		policy.openSelectedPolicy();
		policy.navigationOnBordereauxTab();

		//Step 2
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4559Path = fpath+"\\src\\test\\resources\\testdata\\April_AssignmentMapping_4559.xlsx";

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		File excelFile = new File(sheet4559Path);
		//String payload = "{\"Bordereaux\":{\"ContractId\":\"fcf10efc-153c-4bbc-b87c-4d9ebf6fdacc\",\"Id\":\"0\",\"BordereauMonth\":4,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"April_AssignmentMapping_4559.xlsx\",\"UniqueFileName\":\"S29455820180120.xlsx\",\"BordereauFormatId\":\"cfa01995-b545-4567-a8d9-c15df85345fd\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S29455820180120.xlsx\",\"Filesize\":9617,\"Path\":null,\"size\":9617,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":4,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"April_AssignmentMapping_4559.xlsx\",\"UniqueFileName\":\"S29455820180120.xlsx\",\"BordereauFormatId\":\""+FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S29455820180120.xlsx\",\"Filesize\":9617,\"Path\":null,\"size\":9617,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BorderauPage.refreshUploadedFile();

		//Step 3 to 10
		if(isVisible(BorderauPage.ReviewBtn)==true)
		{
			BClaim.verfyndClickReview();
			waitForElementToAppear(rule.SubmitRecordButton,5);
			verifyMustExists(rule.SubmitRecordButton,"SubmitRecordButton");
			click(rule.SubmitRecordButton,"SubmitRecordButton"); 
			waitForElementToAppear(BackToAssignmentBtn,5);
			verifyMustExists(BackToAssignmentBtn,"ForApprovalButton");
			click(BackToAssignmentBtn,"ForApprovalButton"); 
			waitForElementToAppear(NoOfStories,5);
			verifyMustExists(NoOfStories,"No Of Stories");
			click(NoOfStories,"No Of Stories");
			verifyMustExists(RightArrow,"Right Arrow");
			click(RightArrow,"Right Arrow");
			verifyMustExists(GrossPremium,"Gross Premium");
			click(GrossPremium,"Gross Premium");
			verifyMustExists(RightArrow,"Right Arrow");
			click(RightArrow,"Right Arrow");
			verifyMustExists(SetMappingRuleBtn,"Set Mapping Rule button");
			click(SetMappingRuleBtn,"Set Mapping Rule button");
			waitForElementToAppear(UpdateAssignmentPopup,5);
			verifyMustExists(UpdateAssignmentPopup,"Update Assignment Popup");
			click(UpdateAssignmentPopup,"Update Assignment Popup");
			SelectDropDownValue(Mapping10, Section1Value);
			SelectDropDownValue(Mapping11, Section1Value);
			SelectDropDownValue(Mapping9, Section2Value);
			verifyMustExists(CompleteAssignmentBtn,"Complete Assignment button");
			click(CompleteAssignmentBtn,"Complete Assignment button");
			waitForElementToAppear(rule.SubmitApprovalButton,5);
			verifyMustExists(rule.SubmitApprovalButton,"SubmitApprovalButton");
			click(rule.SubmitApprovalButton,"SubmitApprovalButton");
			BorderauPage.refreshAfterApproveFile(BClaim.AprilFrApprvl);
		}
		else
		{
			Report.LogInfo("ReviewStatus", "Not displayed", "FAIL");	
		}

		//Step 11 to 13
		policy.navigateToReportingChannelsTab();
		waitForElementToAppear(SectionAssignmentRuleBtn,5);
		verifyMustExists(SectionAssignmentRuleBtn,"Section Assignment Rule button");
		click(SectionAssignmentRuleBtn,"Section Assignment Rule button");
		waitForElementToAppear(SectionAssignmentPopup,5);
		verifyMustExists(SectionAssignmentPopup,"Section Assignment Popup");
		verifyExists(VerifyVersionLbl,"Version 2");
		verifyMustExists(CloseBtn,"Close button");
		click(CloseBtn,"Close button");

		//Step 14 to 21
		verifyMustExists(SectionAssignmentRuleBtn,"Section Assignment Rule button");
		click(SectionAssignmentRuleBtn,"Section Assignment Rule button");
		verifyMustExists(V2EditBtn,"Edit button");
		click(V2EditBtn,"Edit button");
		waitForElementToAppear(Sprinklers,5);
		verifyExists(Sprinklers,"Sprinklers");
		click(Sprinklers,"Sprinklers");
		verifyMustExists(RightArrow,"Right Arrow");
		click(RightArrow,"Right Arrow");
		verifyMustExists(SaveRuleBtn,"Save Rule button");
		click(SaveRuleBtn,"Save Rule button");
		waitForElementToAppear(UpdateAssignmentPopup,5);
		verifyMustExists(UpdateAssignmentPopup,"Update Assignment Popup");
		click(UpdateAssignmentPopup,"Update Assignment Popup");
		waitForElementToAppear(VerifyVersion3Lbl,5);
		verifyMustExists(VerifyVersion3Lbl,"Version 3");
		verifyMustExists(V3ViewBtn,"View Version 3");
		click(V3ViewBtn,"View Version 3");
		waitForElementToAppear(Mapping1,5);	
		verifyExists(Mapping1,"Mapping1");
		verifyExists(Mapping2,"Mapping2");
		verifyExists(Mapping3,"Mapping3");
		verifyExists(Mapping4,"Mapping4");
		verifyExists(MapClose,"Mapping Close");
		click(MapClose,"Mapping Close");
		verifyMustExists(CloseBtn,"Close button");
		click(CloseBtn,"Close button");

		//Step 22 to 29
		waitForElementToAppear(RiskCodeRuleBtn,5);
		verifyMustExists(RiskCodeRuleBtn,"Risk Assignment Rule button");
		click(RiskCodeRuleBtn,"Risk Assignment Rule button");
		waitForElementToAppear(V2EditBtn,5);
		verifyMustExists(V2EditBtn,"Edit button");
		click(V2EditBtn,"Edit button");
		sleep(2000);
		SelectDropDownValue(RiskCodeContractDD, RiskCodeContractValue);
		waitForElementToAppear(NoOfStories,5);
		verifyMustExists(NoOfStories,"No Of Stories");
		click(NoOfStories,"No Of Stories");
		verifyMustExists(RightArrow,"Right Arrow");
		click(RightArrow,"Right Arrow");
		verifyMustExists(RiskCountry,"Risk Country");
		click(RiskCountry,"Risk Country");
		verifyMustExists(RightArrow,"Right Arrow");
		click(RightArrow,"Right Arrow");
		verifyMustExists(SaveRuleBtn,"Save Rule button");
		click(SaveRuleBtn,"Save Rule button");
		verifyMustExists(V3ViewBtn,"View button");
		click(V3ViewBtn,"View button");
		verifyMustExists(Mapping3,"Mapping1");
		verifyMustExists(RiskCountryLbl,"Mapping2");
		verifyMustExists(MapClose,"Mapping Close");
		click(MapClose,"Mapping Close");
		verifyMustExists(CloseBtn,"Close button");
		click(CloseBtn,"Close button");

		//Step 30 to 34
		verifyMustExists(SectionAssignmentRuleBtn,"Section Assignment Rule button");
		click(SectionAssignmentRuleBtn,"Section Assignment Rule button");
		verifyMustExists(V2EditBtn,"Edit button");
		click(V2EditBtn,"Edit button");
		verifyMustExists(Sprinklers,"Sprinklers");
		click(Sprinklers,"Sprinklers");
		verifyMustExists(LeftArrow,"Left Arrow");
		click(LeftArrow,"Left Arrow");
		verifyMustExists(SaveRuleBtn,"Save Rule button");
		click(SaveRuleBtn,"Save Rule button");
		if(isVisible(UpdateAssignmentPopup)==true){
			waitForElementToAppear(UpdateAssignmentPopup,5);
			verifyMustExists(UpdateAssignmentPopup,"Update Assignment Popup");
			click(UpdateAssignmentPopup,"Update Assignment Popup");
		}
		verifyMustExists(V3ViewBtn,"View button");
		click(V3ViewBtn,"View button");
		waitForElementToAppear(Mapping1,5);	
		verifyMustExists(Mapping1,"Mapping1");
		verifyMustExists(Mapping3,"Mapping3");
		verifyMustExists(Mapping4,"Mapping4");
		verifyMustExists(MapClose,"Mapping Close");
		click(MapClose,"Mapping Close");
		verifyMustExists(CloseBtn,"Close button");
		click(CloseBtn,"Close button");

		//Step 35 to 40
		policy.navigationOnBordereauxTab();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4559Path1 = fpath+"\\src\\test\\resources\\testdata\\May_AssignmentMapping_4559.xlsx";

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		File excelFile1 = new File(sheet4559Path1);
		String payload1 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":5,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"May_AssignmentMapping_4559.xlsx\",\"UniqueFileName\":\"S55634120180121.xlsx\",\"BordereauFormatId\":\""+FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S55634120180121.xlsx\",\"Filesize\":23994,\"Path\":null,\"size\":23994,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//String payload1 = "{\"Bordereaux\":{\"ContractId\":\"fcf10efc-153c-4bbc-b87c-4d9ebf6fdacc\",\"Id\":\"0\",\"BordereauMonth\":5,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"May_AssignmentMapping_4559.xlsx\",\"UniqueFileName\":\"S55634120180121.xlsx\",\"BordereauFormatId\":\"cfa01995-b545-4567-a8d9-c15df85345fd\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S55634120180121.xlsx\",\"Filesize\":23994,\"Path\":null,\"size\":23994,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile1, payload1, DraftUrl);
		BorderauPage.refreshUploadedFile();
		if(isVisible(BorderauPage.ReviewBtn)==true)
		{
			BClaim.verfyndClickReview();
			waitForElementToAppear(rule.SubmitRecordButton,5);
			verifyMustExists(rule.SubmitRecordButton,"SubmitRecordButton");
			click(rule.SubmitRecordButton,"SubmitRecordButton"); 
			SelectDropDownValue(Mapping10, Section1Value);
			SelectDropDownValue(Mapping11, Section2Value);
			verifyMustExists(CompleteAssignmentBtn,"Complete Assignment button");
			click(CompleteAssignmentBtn,"Complete Assignment button");
			waitForElementToAppear(CompleteAssignmentBtn,5);
			verifyMustExists(CompleteAssignmentBtn,"Complete Assignment button");
			click(CompleteAssignmentBtn,"Complete Assignment button");
			waitForElementToAppear(rule.SubmitApprovalButton,5);
			verifyMustExists(rule.SubmitApprovalButton,"SubmitApprovalButton");
			click(rule.SubmitApprovalButton,"SubmitApprovalButton");
			BorderauPage.refreshAfterApproveFile(MayFrApprvl);
		}
		else
		{
			Report.LogInfo("ReviewStatus", "Not displayed", "FAIL");	
		}
	}


	//============================================= Reusable function==========================================================//	
	public void approveFebFile() throws Exception
	{
		waitForElementToAppear(rule.SubmitRecordButton,5);
		verifyMustExists(rule.SubmitRecordButton,"SubmitRecordButton");
		click(rule.SubmitRecordButton,"SubmitRecordButton");
		waitForElementToAppear(SectionAssignmentRulepage,5);
		verifyMustExists(SectionAssignmentRulepage,"Section Assignment Rule");
		SelectDropDownValue(SectionAssignmentdropdown,SectionAssignmentdropdownValue);
		waitForElementToAppear(BuildingYearBuilt,5);
		verifyMustExists(BuildingYearBuilt,"Building year built");
		click(BuildingYearBuilt,"Building year built");
		verifyMustExists(RightArrow,"Right Arrow");
		click(RightArrow,"Right Arrow");
		sleep(1000);
		verifyMustExists(SetMappingRuleBtn,"Right Arrow");
		click(SetMappingRuleBtn,"Right Arrow");
		waitForElementToAppear(SectionMappingpage,5);
		verifyMustExists(SectionMappingpage,"Section Mapping page");
		//button[contains(.,'Back to Assignment Rules')]
		verifyMustExists(BackToAssignmentRuleButton,"Back to assignment Rule");
		click(BackToAssignmentRuleButton,"Back to assignment Rule");
		
		waitForElementToAppear(SectionAssignmentRulepage,5);
		verifyMustExists(SectionAssignmentRulepage,"Section Assignment Rule");
		
		
		verifyMustExists(BuildingYearBuilt,"Building Yesr");
		click(BuildingYearBuilt,"Building Year");
		verifyMustExists(LeftArrow,"Left  Arrow");
		click(LeftArrow,"Left  Arrow");
		verifyMustExists(RiskReference,"Risk Reference");
		click(RiskReference,"Risk reference");
		verifyMustExists(RightArrow,"Right Arrow");
		click(RightArrow,"Right Arrow");
		
		verifyMustExists(SetMappingRuleBtn,"click set mapping rule");
		click(SetMappingRuleBtn,"click set mapping rule");
		verifyMustExists(ValidateSectionMappingText,"Section Assignment Rule change text");
		
		verifyMustExists(YESUpdateRuleButton,"Yes update rule button");
		click(YESUpdateRuleButton,"Yes update rule button");
		
		SelectDropDownValue(SectionMappingdropdown1,SectionMappingdropdownvalue1);
		SelectDropDownValue(SectionMappingdropdown2,SectionMappingdropdownvalue2);
		SelectDropDownValue(SectionMappingdropdown3,SectionMappingdropdownvalue3);
		SelectDropDownValue(SectionMappingdropdown4,SectionMappingdropdownvalue4);
		SelectDropDownValue(SectionMappingdropdown5,SectionMappingdropdownvalue5);
		verifyMustExists(CompleteAssignmentBtn,"Completed Assignment Button");
		click(CompleteAssignmentBtn,"Completed Assignment Button");
		waitForElementToAppear(RiskCodeAssignmentpage,5);
		verifyMustExists(RiskCodeAssignmentpage,"Section Mapping page");
		SelectDropDownValue(RiskcodeAssignmentdropdown,RiskcodeAssignmentdropdownValue);
		verifyMustExists(CompleteAssignmentBtn,"Completed Assignment Button");
		click(CompleteAssignmentBtn,"Completed Assignment Button");
		waitForElementToAppear(rule.SubmitApprovalButton,5);
		verifyMustExists(rule.SubmitApprovalButton,"SubmitApprovalButton");
		click(rule.SubmitApprovalButton,"SubmitApprovalButton");
		sleep(2000);
		BorderauPage.refreshAfterApproveFile(FebFrApprvl);
	}

	public void VerifyAssignment() throws Exception
	{
		waitForElementToAppear(SectionAssignmentRuleBtn,5);
		verifyMustExists(SectionAssignmentRuleBtn,"Section Assignment Rule button");
		click(SectionAssignmentRuleBtn,"Section Assignment Rule button");
		waitForElementToAppear(SectionAssignmentPopup,5);
		verifyMustExists(SectionAssignmentPopup,"Section Assignment Popup");
		verifyMustExists(ViewOnAssignmentRules,"View On Section Assignment Rules");
		click(ViewOnAssignmentRules,"View On Section Assignment Rules");
		waitForElementToAppear(Mapping1,5);
		verifyMustExists(Mapping1,"Risk Reference");
		
		waitForElementToAppear(CompanyNameEXists,5);
		verifyMustExists(CompanyNameEXists,"Risk Reference");
		
		verifyMustExists(ViewMappingRules,"View Mapping Rules");
		click(ViewMappingRules,"View Mapping Rules");
		waitForElementToAppear(SectionAssignmentMappingRulepage,5);
		verifyMustExists(SectionAssignmentMappingRulepage,"Section Assignment Mapping Rule page");
		verifyMustExists(BackToAssignmentBtn1,"Back To Assignment Button");
		click(BackToAssignmentBtn1,"Back To Assignment Button");
		waitForElementToAppear(Mapping1,5);
		verifyMustExists(CloseBtn2,"Close Button");
		click(CloseBtn2,"Close Button");
		waitForElementToAppear(SectionAssignmentPopup,5);
		verifyMustExists(CloseBtn1,"Close Button");
		click(CloseBtn1,"Close Button");
		waitForElementToAppear(RiskCodeRuleBtn,5);
		verifyMustExists(RiskCodeRuleBtn,"Section Assignment Rule button");
		click(RiskCodeRuleBtn,"Section Assignment Rule button");
		waitForElementToAppear(RiskCodeAssignmentRulesPopUp,5);
		verifyMustExists(RiskCodeAssignmentRulesPopUp,"Section Assignment Popup");
		verifyMustExists(ViewOnAssignmentRules,"View On Section Assignment Rules");
		click(ViewOnAssignmentRules,"View On Section Assignment Rules");
		waitForElementToAppear(RiskCodeAssignmentRulePopUp,5);
		verifyMustExists(RiskCodeAssignmentRulePopUp,"Risk Code Assignment Rule PopUp");
		verifyMustExists(CloseBtn2,"Close Button");
		click(CloseBtn2,"Close Button");
		waitForElementToAppear(RiskCodeAssignmentRulesPopUp,5);
		verifyMustExists(CloseBtn1,"Close Button");
		click(CloseBtn1,"Close Button");
		sleep(3000);	
	}
	public void approveMarchFile() throws Exception
	{
		waitForElementToAppear(rule.SubmitRecordButton,5);
		verifyMustExists(rule.SubmitRecordButton,"SubmitRecordButton");
		click(rule.SubmitRecordButton,"SubmitRecordButton");
		waitForElementToAppear(SectionMappingpage,5);
		verifyMustExists(SectionMappingpage,"Section Mapping page");
		SelectDropDownValue(SectionMappingdropdown6,SectionMappingdropdownvalue6);
		SelectDropDownValue(SectionMappingdropdown7,SectionMappingdropdownvalue7);
		SelectDropDownValue(SectionMappingdropdown8,SectionMappingdropdownvalue8);
		verifyMustExists(CompleteAssignmentBtn,"Completed Assignment Button");
		click(CompleteAssignmentBtn,"Completed Assignment Button");
		waitForElementToAppear(rule.SubmitApprovalButton,5);
		verifyMustExists(rule.SubmitApprovalButton,"SubmitApprovalButton");
		click(rule.SubmitApprovalButton,"SubmitApprovalButton");
		sleep(2000);
		BorderauPage.refreshAfterApproveFile(MarchFrApprvl);
	}

}
