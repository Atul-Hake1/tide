package com.tide.qa.pagefactory;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;

import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;

public class ApprovalAutoApprovalandpartialsubmissionPage extends PageBase{
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BordereauQuePage BQPage = new BordereauQuePage();
	PolicyPage policy = new PolicyPage();
	BordereauProcessPage BordereauProcess = new BordereauProcessPage();
	Stage2Page Stage2 = new Stage2Page();
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

	public static String sheet4756Path = "";
	public static String sheet4755Path = "";
	public static String sheet4721Path = "";
	public static String sheet4721PathScnd = "";
	public static String sheet4721PathThird = "";
	public static String sheet4720Path = "";
	public static String contractId;
	
	//==================================Locators===============================//
	public static final String OutPutFormatMenuLink = "@xpath=//a[@href='#!/app/outputformats']";
	public static final String Errorbtn = "@xpath=//*[@id='grid']//*[contains(@ng-click,'Risk')]//button";
	public static final String ResolvErrorbtn = "@xpath=//*[@id='content']//*[@ng-click='resolveRemainingErrros()']";
	public static final String DiscardErrorbtn = "@xpath=//*[@id='content']//*[@ng-click='discardRemainingErrros()']";
	public static final String ViewDiscardbtn = "@xpath=.//*[@id='profile-main']//label[@for='IsDiscard']";

	//-------------------------------------------------------- BordereauProcessIdentifySheetTests ---------------------------------------------------------------------//

	public void LetTideSelctQue_4756() throws Exception{
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String Type = "Risk";
		String freqVal = "Monthly";
		String subSheet = "Bordereau Processing (kruthika test schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		//Step 1
		policy.addPolicy2(IncDate,ExpDate);
		contractId = ReturnContractID();

		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned2(Type,freqVal);
		Report.LogInfo("StepCheck", "Step 1 completed", "PASS");

		//BordereauProcess.applyFilterPolicy("433019OO");
		//BordereauProcess.openSelectedPolicy();
		//Step 2
		BordereauProcess.SubmitBordereaux(subSheet);
		Report.LogInfo("StepCheck", "Step 2 completed", "PASS");
		//Step 3 
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4756Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC4756.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4756Path);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC4756.xlsx\",\"UniqueFileName\":\"S83523520180115.xlsx\",\"BordereauFormatId\":\"1\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":true,\"Status\":0},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S83523520180115.xlsx\",\"Filesize\":19654,\"Path\":null,\"size\":19654,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[],\"letLunaProcess\":true}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauProcess.refreshAfterUploadedFileForReviewSatusAndUploadStatus();
		if(isVisible(BordereauProcess.UploadedButton)==true){
			Report.LogInfo("ValidateUploadedStatus", "UPLOADED status displayed", "PASS");
			verifyExists(BordereauProcess.UploadedButton,"Upload button");
			click(BordereauProcess.UploadedButton,"Upload button");

			//step 4
			clickOnContinue();
			Report.LogInfo("StepCheck", "Step 4 completed", "PASS");

			//step 5 
			clickOnContinue();
			Report.LogInfo("StepCheck", "Step 5 completed", "PASS");
			sleep(3000);

			//Step 6
			String Quename = "Stage 2 Processing";
			String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+Quename+"')][1]";
			BQPage.filterBordereauQuestionnaire(Quename, SelectQuestionnaire);
			Report.LogInfo("StepCheck", "Step 6 completed", "PASS");

			//Step 7
			clickOnContinue();
			Report.LogInfo("StepCheck", "Step 7 completed", "PASS");
			sleep(3000);

		}else{
			Report.LogInfo("ValidateUploadedStatus", "UPLOADED status not displayed", "FAIL");
			//deleteBorderEAUX();
		}
	}


	public void PatialSubResolvError_4755() throws Exception{
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String Type = "Risk";
		String freqVal = "Monthly";
		String val1 = "1";
		String val2 = "5";
		String subSheet = "Bordereau Processing (kruthika test schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		//Step 1
		policy.addPolicy2(IncDate,ExpDate);
		contractId = ReturnContractID();

		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned2(Type,freqVal);
		Report.LogInfo("StepCheck", "Step 1 completed", "PASS");

		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		BordereauProcess.openSelectedPolicy();
		//Step 2
		BordereauProcess.SubmitBordereaux(subSheet);
		Report.LogInfo("StepCheck", "Step 2 completed", "PASS");
		//Step 3 
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4755Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC4755.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4755Path);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC4755.xlsx\",\"UniqueFileName\":\"S70532220180115.xlsx\",\"BordereauFormatId\":\"e1f3d92f-bd74-4e8a-b3c2-2eb5f4d3bb9c\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S70532220180115.xlsx\",\"Filesize\":20461,\"Path\":null,\"size\":20461,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauProcess.refreshUploadedFile();

		//Step 3
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true){
			Report.LogInfo("StepCheck", "Step 3 completed", "PASS");
			//Step 4
			waitForElementToAppear(BordereauProcess.SkippAllErroBtn,5);
			verifyExists(BordereauProcess.SkippAllErroBtn,"Skip all error button");
			click(BordereauProcess.SkippAllErroBtn,"Skip all error button");
			Report.LogInfo("StepCheck", "Step 4 completed", "PASS");
			//Step 5
			waitForElementToAppear(BordereauProcess.SubProcessRcdBtn,5);
			verifyExists(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
			click(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
			Report.LogInfo("StepCheck", "Step 5 completed", "PASS");
			//Step 6
			verifyMustExists(BordereauProcess.PartialSubmission,"Partialsubmission set to yes");
			verifyMustExists(BordereauProcess.FrApprovalbtn1,"For Approval button");
			click(BordereauProcess.FrApprovalbtn1,"For Approval button");
			Report.LogInfo("StepCheck", "Step 6 completed", "PASS");
			//Step 7
			BordereauProcess.clickOnApproveBordBtn();
			Report.LogInfo("StepCheck", "Step 7 completed", "PASS");
			//Add Approved refresh
			BordereauProcess.refreshUploadedFileApprovedStatus();
			//Step 8			
			verifyMustExists(Errorbtn,"Error button");
			click(Errorbtn,"Error button");
			Report.LogInfo("StepCheck", "Step 8 completed", "PASS");
			//Step 9 
			verifyMustExists(ResolvErrorbtn,"Resolve Error button");
			click(ResolvErrorbtn,"ResolveError button");
			Report.LogInfo("StepCheck", "Step 9 completed", "PASS");

			//Step 10
			if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true){
				if(isVisible(Stage2.RenewalDrp)==true){
					Stage2.EndorsmentFirstContinue(val1,val2);
					Stage2.EndorsmentContinueSecond();
					Stage2.ChangeStasCanToNew();
					Stage2.ReinstatementToCancl1();
					Stage2.EnrichedValChange();
					Stage2.TideValChange();
					Stage2.TideValChangeToUnitedKingdm();
					//Stage2.TideValUKToRMS();
					Report.LogInfo("StepCheck", "Step 10 completed", "PASS");
					//waitForElementToAppear(SbmtRcdAssmntBtn,3);
					//Step 11
					if(isVisible(BordereauProcess.ErrorsAndWarningTab)==true){
						verifyMustExists(BordereauProcess.ErrorsAndWarningTab," errors and warning  button");
						click(BordereauProcess.ErrorsAndWarningTab," error and warning button");
						sleep(2000);
						
							verifyMustExists(BordereauProcess.NegativePremiumResolveErrors," errors and warning  button");
							click(BordereauProcess.NegativePremiumResolveErrors," error and warning button");
							verifyMustExists(Stage2.GrossPremTxt,"gross Premium text");
							
								Stage2.ChangGrossPremTxtVal();
						Report.LogInfo("StepCheck", "Step 11 completed", "PASS");
						sleep(2000);
						verifyMustExists(BordereauProcess.CancelAndDeleteBordereaux," errors and warning  button");
						click(BordereauProcess.CancelAndDeleteBordereaux," error and warning button");
						//Step 12
						BordereauProcess.navigateToDATATab();
						if(isVisible(BordereauProcess.DATARiskTab)==true){
							BordereauProcess.navigateToDATARiskTab();
							BordereauProcess.VerificationRcddCounts(5);
							
							Report.LogInfo("StepCheck", "Step 12 completed", "PASS");
						}else{
							Report.LogInfo("RiskTab", "Risk tab not gets opned", "FAIL");

						}
					}
				}else{
					Report.LogInfo("ErroScreenCheck", "Expected error not displayed.", "FAIL");
					goBack();
					BordereauProcess.deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateUploadedStatus", "Review error status not displayed", "FAIL");
				//deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateUploadedStatus", "Review error status not displayed", "FAIL");
			//deleteBorderEAUX();
		
		}
		}
		
	


	public void PatialSubDisscardError_4754() throws Exception{
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String Type = "Risk";
		String freqVal = "Monthly";
		String val1 = "1";
		String val2 = "5";
		String subSheet = "Bordereau Processing (kruthika test schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		//Step 1
		policy.addPolicy2(IncDate,ExpDate);
		contractId = ReturnContractID();

		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned2(Type,freqVal);
		Report.LogInfo("StepCheck", "Step 1 completed", "PASS");

		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		BordereauProcess.openSelectedPolicy();
		//Step 2
		BordereauProcess.SubmitBordereaux(subSheet);
		Report.LogInfo("StepCheck", "Step 2 completed", "PASS");
		//Step 3 
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4755Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC4755.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4755Path);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC4755.xlsx\",\"UniqueFileName\":\"S70532220180115.xlsx\",\"BordereauFormatId\":\"e1f3d92f-bd74-4e8a-b3c2-2eb5f4d3bb9c\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S70532220180115.xlsx\",\"Filesize\":20461,\"Path\":null,\"size\":20461,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauProcess.refreshUploadedFile();

		//Step 3
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true){
			Report.LogInfo("StepCheck", "Step 3 completed", "PASS");
			//Step 4
			waitForElementToAppear(BordereauProcess.SkippAllErroBtn,5);
			verifyExists(BordereauProcess.SkippAllErroBtn,"Skip all error button");
			click(BordereauProcess.SkippAllErroBtn,"Skip all error button");
			Report.LogInfo("StepCheck", "Step 4 completed", "PASS");
			//Step 5
			waitForElementToAppear(BordereauProcess.SubProcessRcdBtn,5);
			verifyExists(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
			click(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
			Report.LogInfo("StepCheck", "Step 5 completed", "PASS");
			//Step 6
			waitForElementToAppear(BordereauProcess.FrApprovalbtn1,5);
			verifyMustExists(BordereauProcess.PartialSubmission,"Partialsubmission set to yes");
			verifyMustExists(BordereauProcess.FrApprovalbtn1,"For Approval button");
			click(BordereauProcess.FrApprovalbtn1,"For Approval button");
			Report.LogInfo("StepCheck", "Step 6 completed", "PASS");
			//Step 7
			BordereauProcess.clickOnApproveBordBtn();
			Report.LogInfo("StepCheck", "Step 7 completed", "PASS");
			//Add Approved refresh
			BordereauProcess.refreshUploadedFileApprovedStatus();
			//Step 8			
			verifyMustExists(Errorbtn,"Error button");
			click(Errorbtn,"Error button");
			Report.LogInfo("StepCheck", "Step 8 completed", "PASS");
			//Step 9 
			verifyMustExists(DiscardErrorbtn,"Discard Error button");
			click(DiscardErrorbtn,"Discard Error button");
			Report.LogInfo("StepCheck", "Step 9 completed", "PASS");

			BordereauProcess.navigateToDATATab();
			if(isVisible(BordereauProcess.DATARiskTab)==true){
				BordereauProcess.navigateToDATARiskTab();
				waitForElementToAppear(ViewDiscardbtn,5);
				verifyMustExists(ViewDiscardbtn,"View Discard Error button");
				click(ViewDiscardbtn,"View discard Error button");
				if (isVisible(BordereauProcess.BlankDetailsMsgRiskTab)==true)
				{
					Report.LogInfo("StatusCheck", "No status records found", "PASS");
				}else{
					Report.LogInfo("StatusCheck", "status records found", "FAIL");
				}
				Report.LogInfo("StepCheck", "Step 12 completed", "PASS");
			}else{
				Report.LogInfo("RiskTab", "Risk tab not gets opned", "FAIL");
			}
		}else{
			Report.LogInfo("ValidateUploadedStatus", "Review error status not displayed", "FAIL");
			//deleteBorderEAUX();
		}
	}

	public void AutoApprvl_4721() throws Exception{

		String val1 = "1";
		String val2 = "5";
		String subSheet = "Bordereau Processing (kruthika test schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		
		signedStatus();
		contractId = ReturnContractID();
		BordereauProcess.SubmitBordereaux(subSheet);

		Report.LogInfo("StepCheck", "Step 5 completed", "PASS");
		//Step 3 
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4721Path = fpath+"\\src\\test\\resources\\testdata\\January 2017 - Aprroved_TC4721.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4721Path);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017 - Aprroved_TC4721.xlsx\",\"UniqueFileName\":\"S29376620180120.xlsx\",\"BordereauFormatId\":\"e1f3d92f-bd74-4e8a-b3c2-2eb5f4d3bb9c\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S29376620180120.xlsx\",\"Filesize\":17660,\"Path\":null,\"size\":17660,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauProcess.refreshUploadedFile();
		//Step 6
		if(isVisible(BordereauProcess.ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			verifyExists(BordereauProcess.ReviewBtn,"Review button");
			click(BordereauProcess.ReviewBtn,"Review button");
			Report.LogInfo("StepCheck", "Step 6 completed", "PASS");
			//Step 7
			waitForElementToAppear(BordereauProcess.SubProcessRcdBtn,5);
			verifyExists(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
			click(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
			
			waitForElementToAppear(BordereauProcess.FrApprovalbtn1,5);
			verifyMustExists(BordereauProcess.FrApprovalbtn1,"For Approval button");
			click(BordereauProcess.FrApprovalbtn1,"For Approval button");
		
			BordereauProcess.clickOnApproveBordBtn();			
			BordereauProcess.refreshUploadedFileApprovedStatus();
			Report.LogInfo("StepCheck", "Step 7 completed", "PASS");
						
			//Step 8 
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4721PathScnd = fpath+"\\src\\test\\resources\\testdata\\January 2017 - Approved_TC4721Scnd.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile1 = new File(sheet4721PathScnd);
			String payload1 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"2\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017 - Approved_TC4721Scnd.xlsx\",\"UniqueFileName\":\"S59862220180119.xlsx\",\"BordereauFormatId\":\"f248094f-a93d-446c-ac1a-ec3426404255\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S59862220180119.xlsx\",\"Filesize\":17644,\"Path\":null,\"size\":17644,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile1, payload1, DraftUrl);
			BordereauProcess.refreshUploadedFile();		
			Report.LogInfo("StepCheck", "Step 8 completed", "PASS");
			
			//Step 9
			if(isVisible(BordereauProcess.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				verifyExists(BordereauProcess.ReviewBtn,"Review button");
				click(BordereauProcess.ReviewBtn,"Review button");
				Report.LogInfo("StepCheck", "Step 9 completed", "PASS");
				//Step 7
				waitForElementToAppear(BordereauProcess.SubProcessRcdBtn,5);
				verifyExists(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
				click(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
				
				waitForElementToAppear(BordereauProcess.FrApprovalbtn1,5);
				verifyMustExists(BordereauProcess.FrApprovalbtn1,"For Approval button");
				click(BordereauProcess.FrApprovalbtn1,"For Approval button");
			
				BordereauProcess.clickOnApproveBordBtn();			
				BordereauProcess.refreshUploadedFileForApprovedScndRw();
				Report.LogInfo("StepCheck", "Step 10 completed", "PASS");
				//---------------------------------------------------------------
				//Step 8 
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet4721PathThird = fpath+"\\src\\test\\resources\\testdata\\January 2017 - Approved_TC4721Third.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File excelFile2 = new File(sheet4721PathThird);
				String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017 - Approved_TC4721Third.xlsx\",\"UniqueFileName\":\"S74019320180119.xlsx\",\"BordereauFormatId\":\"226f0ae5-7bc1-4eba-95d2-862c0f8c3971\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S74019320180119.xlsx\",\"Filesize\":15319,\"Path\":null,\"size\":15319,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				uploadFile(ReqUrl, excelFile2, payload2, DraftUrl);
				BordereauProcess.refreshUploadedFile();		
				Report.LogInfo("StepCheck", "Step 11 completed", "PASS");
				
				//Step 9
				if(isVisible(BordereauProcess.ReviewBtn)== true){
					Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
					verifyExists(BordereauProcess.ReviewBtn,"Review button");
					click(BordereauProcess.ReviewBtn,"Review button");
					Report.LogInfo("StepCheck", "Step 12 completed", "PASS");
					//Step 13
					waitForElementToAppear(BordereauProcess.SubProcessRcdBtn,5);
					verifyExists(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
					click(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
					
					waitForElementToAppear(BordereauProcess.FrApprovalbtn1,5);
					verifyMustExists(BordereauProcess.FrApprovalbtn1,"For Approval button");
					click(BordereauProcess.FrApprovalbtn1,"For Approval button");
				
					BordereauProcess.clickOnApproveBordBtn();			
					BordereauProcess.refreshUploadedFileForApprovedScndRw();
					Report.LogInfo("StepCheck", "Step 13 completed", "PASS");					
					
				}
				else{
					Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail");
					BordereauProcess.deleteBorderEAUX();
					sleep(3000);
				}
				
			}
			else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail");
				BordereauProcess.deleteBorderEAUX();
				sleep(3000);
			}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail");
			BordereauProcess.deleteBorderEAUX();
			sleep(3000);
		}		
	}

	public void ApprvlMultplConSameCon_4720() throws Exception{
		BProcessingRiskPremiumClaimPage BPProcessng = new BProcessingRiskPremiumClaimPage();
		String UniqueReferenceVal2 = "Automation Policy"+getCurrentDateTimeMS1();
		
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String IncDate1 = "01/01/2018";
		String ExpDate2="01/01/2019";
		String Type = "Risk";
		String freqVal = "Monthly";
		String subSheet = "Bordereau Processing (kruthika test schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String Status1 = "Draft";
		String Status2 = "Quote";
		String Broker2 = "Alwen Hough Johnson Ltd - TBC";
		String Bline2 = "Property (D&F)";
		String Underline2 = "Abhi, Standard";
		//Step 1
		policy.addPolicy2(IncDate,ExpDate);
		
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned2(Type,freqVal);
		Report.LogInfo("StepCheck", "Step 1 completed", "PASS");
		
		BPProcessng.openPolicyCreateContract();
		policy.addPolicyContractDetails1(UniqueReferenceVal2, IncDate1, ExpDate2, Status1, Broker2, Bline2, Underline2);
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned2(Type,freqVal);
		
		contractId = ReturnContractID();
		BordereauProcess.SubmitBordereaux(subSheet);
		Report.LogInfo("StepCheck", "Step 5 completed", "PASS");
		//Step 3 
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4720Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 errors - March_TC4720.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4720Path);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 errors - March_TC4720.xlsx\",\"UniqueFileName\":\"S21988320180119.xlsx\",\"BordereauFormatId\":\"e1f3d92f-bd74-4e8a-b3c2-2eb5f4d3bb9c\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S21988320180119.xlsx\",\"Filesize\":19276,\"Path\":null,\"size\":19276,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauProcess.refreshUploadedFile();
		
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)== true)
		{
			String ErrorScreen = "@xpath=.//h2[text()='Missing Bordereau periods']";
			String YesBtn = "@xpath=.//*[@value='true']";
			if(isVisible(ErrorScreen)== true){							
				if(isVisible(BordereauProcess.ContinueProcessingBodrBtn)== true){
					javaScriptclick(YesBtn,"Yes button");
					verifyMustExists(BordereauProcess.ContinueProcessingBodrBtn,"Continue Processing button");
					javaScriptclick(BordereauProcess.ContinueProcessingBodrBtn,"Continue Processing button");
					sleep(3000);
					BordereauProcess.refreshUploadedFile();
					if(isVisible(BordereauProcess.ReviewBtn)==true){
						Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
						verifyExists(BordereauProcess.ReviewBtn,"Review button");
						click(BordereauProcess.ReviewBtn,"Review button");
						Report.LogInfo("StepCheck", "Step 12 completed", "PASS");
						//Step 13
						waitForElementToAppear(BordereauProcess.SubProcessRcdBtn,5);
						verifyExists(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
						click(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
						
						waitForElementToAppear(BordereauProcess.FrApprovalbtn1,5);
						verifyMustExists(BordereauProcess.FrApprovalbtn1,"For Approval button");
						click(BordereauProcess.FrApprovalbtn1,"For Approval button");
					
						BordereauProcess.clickOnApproveBordBtn();			
						BordereauProcess.refreshUploadedFileApprovedStatus();
					}else{
						Report.LogInfo("Status", "Review button not display", "FAIL");

					}
					}else{
						goBack();
					}				
			}else{
				goBack();
			}
		}else{
			goBack();
		}
	}

	//--------------------------------------------------------------------------------------------------------------------------------------------//	
	//------------------------------------------------------- Reusable functions -----------------------------------------------------------------//
	//--------------------------------------------------------------------------------------------------------------------------------------------//	

	public void clickOnContinue(){
		waitForElementToAppear(BordereauProcess.continuebtx,5);
		verifyExists(BordereauProcess.continuebtx,"Continue button");
		click(BordereauProcess.continuebtx,"Continue button");
	}

	public void signedStatus() throws InterruptedException{
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String Type = "Risk";
		String TypePre = "Premium";
		String TypeClaim = "Claim";
		String freqVal = "Monthly";
		//Step 2
		policy.addPolicy2(IncDate,ExpDate);
		contractId = ReturnContractID();
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.addSection();
		policy.navigateToMarketsTabOnSection();
		policy.addMarketOnSection();
		policy.navigateToRiskCodesTabOnSection();
		policy.addRiskCodesOnSection();
		Report.LogInfo("StepCheck", "Step 2 completed", "PASS");
		//Step 3
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannelForAnyComb(Type,freqVal);
		policy.addReportingChannelForAnyComb(TypePre,freqVal);
		policy.addReportingChannelForAnyComb(TypeClaim,freqVal);
		Report.LogInfo("StepCheck", "Step 3 completed", "PASS");
		//Step 4
		policy.navigateToContractDetailsTab();		
		policy.writtenToSignedStatus();
		verifyExists(policy.SaveBtn,"Save Button");
		click(policy.SaveBtn,"Save Button");
		sleep(3000);
		verifyExists(policy.SignedBtn,"Signed Status Button");
		Report.LogInfo("StepCheck", "Step 4 completed", "PASS");
	}
}