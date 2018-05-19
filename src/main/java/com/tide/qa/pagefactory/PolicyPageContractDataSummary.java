package com.tide.qa.pagefactory;

import java.awt.AWTException;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.lang.model.element.Element;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.paulhammant.ngwebdriver.ByAngular;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class PolicyPageContractDataSummary extends PageBase
{
	LoginPage loginPage = new LoginPage();
	PolicyPage policy = new PolicyPage();

	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddHHmmss");
		String datetime = ft.format(dNow);
		return datetime;
	}
	public static String getCurrentDateTimeMS1() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMssddHHmm");
		String datetime = ft.format(dNow);
		return datetime;
	}
	String UniqueReferenceVal1 = "Automation Policy3"+getCurrentDateTimeMS1();
	String UniqueReferenceVal3 = "Automation Policy4"+getCurrentDateTimeMS();
	String CompanyReferenceval = "Automation Policy5"+getCurrentDateTimeMS();
	String UniqueReferenceVal2 = "Contract 2"+getCurrentDateTimeMS();
	static String  Rule = "AutoRule"+getCurrentDateTimeMS();
	static String  Rule1 = "AutoRule1"+getCurrentDateTimeMS();
	String BrokerageVal = "10";
	String Status1 = "Draft";
	String Status2 = "Quote";
	String Broker1 = "Alwen Hough Johnson Ltd - TBC";
	String Bline1 = "Property (D&F)";
	String Underline1 = "Abhi, Standard";
	//String Status2 = "Draft";
	String Broker2 = "Alwen Hough Johnson Ltd - TBC";
	String Broker3 = "AON - DUA team";
	String Bline2 = "Energy";
	String Underline2 = "Tide, Admin";
	String InceptionDate1 = "01/01/2017";
	String InceptionDate2 = "01/01/2018";
	static String PolicyNumber;
	String OpenPolicy;
	public static String contractId;

	public static String sheet4729Path = "";
	public static String sheet4729PathScnd = "";
	public static String sheet4729PathThird = "";
	public static String sheet4729PathFourth = "";
	public static String sheet4729PathFifth = "";
	public static String sheet4729PathSixth = "";
	public static String sheet4745Path = "";
	public static String sheet4745PathScnd = "";
	public static String sheet4745PathThird = "";
	public static String sheet4745PathFourth = "";
	public static String sheet4745PathFifth = "";
	public static String sheet4745PathSixth = "";
	public static String sheet4839Path = "";
	public static String sheet4839PathSecnd = "";
	public static String sheet4839Paththird = "";
	public static String sheet4757Path = "";
	public static String sheet4757PathScnd = "";
	public static String sheet4757PathThird = "";
	public static String sheet4757PathFourth = "";
	public static String sheet4757PathFifth = "";
	public static String sheet4757PathSixth = "";
	
	public static final String contractEditDots = "@xpath=//ul[@class='actions ng-scope']//a[@class='dropdown-toggle']";
	public static final String ContractEditbtn = "@xpath=//*[@ng-if='Permission.Edit || PermissionContractMainCompanyReference.Edit']";
	public static final String SectionconDrp = "@xpath=.//*[@ng-model='form.defaultSectionRiskCode']//preceding-sibling::span";

	//TC 4745 :- Contract Data Summary-Quartely Reporting
	public void ConDataSumMonthlyReporting_4729() throws Exception
	{
		BordereauProcessPage BordPage = new BordereauProcessPage();
		String subSheet = "Bordereau Processing (kruthika test schema)";
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		//contractId = ReturnContractID();
		//Step 1
		policy.addPolicy2(IncDate,ExpDate);
		contractId = ReturnContractID();
		contractEditUSd();
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		Report.LogInfo("StepCheck", "Step 1 completed", "PASS");

		//Step 2, 3, 4
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannelForpremium();		
		Report.LogInfo("StepCheck", "Steps 2,3,4 completed", "PASS");

		//Step 5, 6, 7
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannelClaim();
		Report.LogInfo("StepCheck", "Steps 5, 6, 7 completed", "PASS");

		//Step 9, 10
		BordPage.SubmitBordereaux(subSheet);		

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4729Path = fpath+"\\src\\test\\resources\\testdata\\TC4729_January 2017 Risk.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4729Path);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"TC4729_January 2017 Risk.xlsx\",\"UniqueFileName\":\"S38959320180311.xlsx\",\"BordereauFormatId\":\"78c4312c-a24f-4223-9538-bc709f5a67b1\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S38959320180311.xlsx\",\"Filesize\":25476,\"Path\":null,\"size\":25476,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordPage.refreshUploadedFile();
		Report.LogInfo("StepCheck", "Steps 8, 9 completed", "PASS");

		//Step 10
		BordPage.navigateToDATATab();
		Report.LogInfo("StepCheck", "Steps 10 completed", "PASS");

		//Step 11
		BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
		if(isVisible(BordPage.ReviewBtn)==true){
			
			ReviewToApprvdStatus();
			BordPage.refreshUploadedFileForApproved();
			Report.LogInfo("StepCheck", "Steps 12,13,14 completed", "PASS");
			
			//Step 15
			BordPage.navigateToDATATab();
			String Janavl = "@xpath=//tr[1]//td[text()='900.51']";
			String JanTotalVal = "@xpath=//tr[2]//td//span[text()='900.51']";
			verifyExists(Janavl,"Jan month value");
			verifyExists(JanTotalVal,"Jan month total value");
			Report.LogInfo("StepCheck", "Steps 15 completed", "PASS");

			//Step 16
			BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
			Report.LogInfo("StepCheck", "Steps 16 completed", "PASS");

			//Step 17
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4729PathScnd = fpath+"\\src\\test\\resources\\testdata\\Jan2017Premium_TC4729.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile1 = new File(sheet4729PathScnd);
			String payload1 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"2\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Jan2017Premium_TC4729.xlsx\",\"UniqueFileName\":\"S16163320180311.xlsx\",\"BordereauFormatId\":\"b591afc9-f928-4e83-ac6d-c809cff00b2e\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S16163320180311.xlsx\",\"Filesize\":18516,\"Path\":null,\"size\":18516,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile1, payload1, DraftUrl);
			BordPage.refreshUploadedFile();
			Report.LogInfo("StepCheck", "Steps 17 completed", "PASS");

			//step 18
			if(isVisible(BordPage.ReviewBtn)==true){
				ReviewToApprvdStatus();
				BordPage.refreshUploadedFileForApprovedScndRw();
				Report.LogInfo("StepCheck", "Steps 19,20,21 completed", "PASS");
				
				//Step 22
				BordPage.navigateToDATATab();
				String Janavl1 = "@xpath=//tr[1]//td[text()='520.41']";
				String JanTotalVal1 = "@xpath=//tr[2]//td//span[text()='520.41']";
				verifyExists(Janavl1,"Jan month value");
				verifyExists(JanTotalVal1,"Jan month total value");
				Report.LogInfo("StepCheck", "Steps 22 completed", "PASS");

				//Step 23
				BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
				Report.LogInfo("StepCheck", "Steps 23 completed", "PASS");

				//Step 24
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet4729PathThird = fpath+"\\src\\test\\resources\\testdata\\Jan2017-Claim_TC4729Third.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File excelFile2 = new File(sheet4729PathThird);
				String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Jan2017-Claim_TC4729Third.xlsx\",\"UniqueFileName\":\"S87450120180311.xlsx\",\"BordereauFormatId\":\"a3db7e7b-7f76-4086-9e21-eb004229f74d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S87450120180311.xlsx\",\"Filesize\":17529,\"Path\":null,\"size\":17529,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				uploadFile(ReqUrl, excelFile2, payload2, DraftUrl);
				BordPage.refreshUploadedFile();
				Report.LogInfo("StepCheck", "Steps 24 completed", "PASS");

				//step 25
				if(isVisible(BordPage.ReviewBtn)==true){
					ReviewToApprvdStatus();
					BordPage.refreshUploadedFileForApprovedScndRw();
					Report.LogInfo("StepCheck", "Steps 26,27,28 completed", "PASS");
					
					//Step 29
					BordPage.navigateToDATATab();
					String Incurred1 = "@xpath=//tr[1]//td[text()='820.41']";
					String Incurred2 = "@xpath=//tr[2]//td//span[text()='820.41']";
					//String Incurred3 = "@xpath=//tr[3]//td[text()='820.41']";
					String Incurred4 = "@xpath=//tr[4]//td//span[text()='820.41']";

					verifyExists(Incurred1,"Incured value");
					verifyExists(Incurred2,"Incured value");
					//verifyExists(Incurred3,"Incured value");
					verifyExists(Incurred4,"Incured value");

					String WrittnGrossP1 = "@xpath=//tr[1]//td[text()='91.10%']";
					String WrittnGrossP2 = "@xpath=//tr[2]//td//span[text()='91.10%']";
					//String WrittnGrossP3 = "@xpath=//tr[3]//td[text()='91.10%']";
					String WrittnGrossP4 = "@xpath=//tr[4]//td//span[text()='91.10%']";

					verifyExists(WrittnGrossP1,"Written gross premium value");
					verifyExists(WrittnGrossP2,"Written gross premium value");
					//verifyExists(WrittnGrossP3,"Written gross premium value");
					verifyExists(WrittnGrossP4,"Written gross premium value");

					Report.LogInfo("StepCheck", "Steps 29 completed", "PASS");

					//Step 30, 31, 32
					String ref = "BB";
					String BrockrageVal = "5";
					String ClassBval = "Cyber";
					String currencyVal = "USD - United States Dollar";
					String EPermiumIncome1 = "5";
					String GPermiumIncome1 = "3";
					String GPermiumLimit1 = "2";
					String ConductRiskRatingValue1 = "Medium";

					policy.addSection2(ref, BrockrageVal, ClassBval, currencyVal, EPermiumIncome1, GPermiumIncome1, GPermiumLimit1, ConductRiskRatingValue1);
					Report.LogInfo("StepCheck", "Steps 30, 31, 32 completed", "PASS");

					//Step 33, 34, 35
					String RiskCode1 = "1E - OVERSEAS LEG TERRORISM ENERGY OFFSHORE PROPERTY";
					policy.navigateToRiskCodesTabOnSection();
					policy.addRiskCodesOnSection(RiskCode1);
					Report.LogInfo("StepCheck", "Steps 33, 34, 35 completed", "PASS");

					//Step 36
					BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
					Report.LogInfo("StepCheck", "Steps 36 completed", "PASS");

					//Step 37
					try 
					{
						String fpath = new File(".").getCanonicalPath();
						sheet4729PathFourth = fpath+"\\src\\test\\resources\\testdata\\MArch2017 Risk_TC4729Fourth.xlsx";
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					File excelFile3 = new File(sheet4729PathFourth);
					String payload3 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":3,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"MArch2017 Risk_TC4729Fourth.xlsx\",\"UniqueFileName\":\"S91813320180107.xlsx\",\"BordereauFormatId\":\"78c4312c-a24f-4223-9538-bc709f5a67b1\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S91813320180107.xlsx\",\"Filesize\":25480,\"Path\":null,\"size\":25480,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
					uploadFile(ReqUrl, excelFile3, payload3, DraftUrl);
					BordPage.refreshUploadedFile();
					Report.LogInfo("StepCheck", "Steps 37 completed", "PASS");

					//Step 38
					String ErrorScreen = "@xpath=.//h2[text()='Missing Bordereau periods']";
					String YesBtn = "@xpath=.//*[@value='true']";
					if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
					{	
						Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
						//Step 39
						if(isVisible(ErrorScreen)== true){							
							if(isVisible(BordPage.ContinueProcessingBodrBtn)== true){
								javaScriptclick(YesBtn,"Yes button");
								verifyMustExists(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
								javaScriptclick(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
								sleep(3000);
								BordPage.refreshUploadedFile();
								Report.LogInfo("StepCheck", "Steps 39 completed", "PASS");
							}else{
								goBack();
							}
						}
						//step 40
						if(isVisible(BordPage.ReviewBtn)==true){
							ReviewtoApprd1();
							BordPage.refreshUploadedFileForApproved();
							Report.LogInfo("StepCheck", "Steps 41,42,43 completed", "PASS");
							
							//Step 44
							BordPage.navigateToDATATab();
							String WGP1 = "@xpath=//tr[1]//td[text()='1,801.02']";
							String WGP2 = "@xpath=//tr[2]//td//span[text()='1,801.02']";

							verifyExists(WGP1,"Writtent gross premium value");
							verifyExists(WGP2,"Writtent gross premium value");
							Report.LogInfo("StepCheck", "Steps 44 completed", "PASS");

							//Step 45
							BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
							Report.LogInfo("StepCheck", "Steps 45 completed", "PASS");

							//Step 46
							try 
							{
								String fpath = new File(".").getCanonicalPath();
								sheet4729PathFifth = fpath+"\\src\\test\\resources\\testdata\\March2017Premium_TC4729Fifth.xlsx";
							} 
							catch (IOException e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							File excelFile4 = new File(sheet4729PathFifth);
							String payload4 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":3,\"DataSetType\":\"2\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"March2017Premium_TC4729Fifth.xlsx\",\"UniqueFileName\":\"S69711620180108.xlsx\",\"BordereauFormatId\":\"b591afc9-f928-4e83-ac6d-c809cff00b2e\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S69711620180108.xlsx\",\"Filesize\":18935,\"Path\":null,\"size\":18935,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
							uploadFile(ReqUrl, excelFile4, payload4, DraftUrl);
							BordPage.refreshUploadedFile();
							Report.LogInfo("StepCheck", "Steps 46 completed", "PASS");

							//Step 47
							if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
							{	
								Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
								//Step 48
								if(isVisible(ErrorScreen)== true){							
									if(isVisible(BordPage.ContinueProcessingBodrBtn)== true){
										javaScriptclick(YesBtn,"Yes button");
										verifyMustExists(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
										javaScriptclick(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
										sleep(3000);
										BordPage.refreshUploadedFile();
										Report.LogInfo("StepCheck", "Steps 48 completed", "PASS");
									}else{
										goBack();
									}
								}
								//step 49
								if(isVisible(BordPage.ReviewBtn)==true){
									ReviewtoApprd1();
									BordPage.refreshUploadedFileForApproved();
									//Report.LogInfo("StepCheck", "Steps 52 completed", "PASS");
									Report.LogInfo("StepCheck", "Steps 50,51,52 completed", "PASS");
									
									//Step 53
									BordPage.navigateToDATATab();
									String WGP3 = "@xpath=//tr[1]//td[text()='2,701.53']";
									String WGP4 = "@xpath=//tr[2]//td//span[text()='2,701.53']";

									verifyExists(WGP3,"Writtent gross premium value");
									verifyExists(WGP4,"Writtent gross premium value");
									Report.LogInfo("StepCheck", "Steps 53 completed", "PASS");

									//Step 54
									BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
									Report.LogInfo("StepCheck", "Steps 54 completed", "PASS");

									//Step 55
									try 
									{
										String fpath = new File(".").getCanonicalPath();
										sheet4729PathSixth = fpath+"\\src\\test\\resources\\testdata\\March2017Claim_TC4729Sixth.xlsx";
									} 
									catch (IOException e) 
									{
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									File excelFile5 = new File(sheet4729PathSixth);
									String payload5 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":3,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"March2017Claim_TC4729Sixth.xlsx\",\"UniqueFileName\":\"S85881820180311.xlsx\",\"BordereauFormatId\":\"a3db7e7b-7f76-4086-9e21-eb004229f74d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S85881820180311.xlsx\",\"Filesize\":17414,\"Path\":null,\"size\":17414,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
									uploadFile(ReqUrl, excelFile5, payload5, DraftUrl);
									BordPage.refreshUploadedFile();
									Report.LogInfo("StepCheck", "Steps 55 completed", "PASS");


									//Step 56

									if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
									{	
										Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
										//Step 57
										if(isVisible(ErrorScreen)== true){							
											if(isVisible(BordPage.ContinueProcessingBodrBtn)== true){
												javaScriptclick(YesBtn,"Yes button");
												verifyMustExists(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
												javaScriptclick(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
												sleep(3000);
												BordPage.refreshUploadedFile();
												Report.LogInfo("StepCheck", "Steps 57 completed", "PASS");
											}else{
												goBack();
											}
										}
										//step 58
										if(isVisible(BordPage.ReviewBtn)==true){
										ReviewtoApprd1();
											BordPage.refreshUploadedFileForApproved();
											Report.LogInfo("StepCheck", "Steps 61 completed", "PASS");
											
											
											Report.LogInfo("StepCheck", "Steps 59,60,61 completed", "PASS");
											
											//Step 62
											BordPage.navigateToDATATab();
											String ShwFigrbtn = "@xpath=.//label[@class='ts-helper']";

											verifyExists(ShwFigrbtn,"Show Cumulative Figures");
											click(ShwFigrbtn,"Show Cumulative Figures");
											sleep(1000);
											Report.LogInfo("StepCheck", "Steps 62, 63 completed", "PASS");
										}else{
											Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
											//ApplyDueDateFilter(DueDate, Valuedate);
											BordPage.deleteBorderEAUX();
										}	
									}else
									{
										Report.LogInfo("ReviewErrorStatusValidation", "Status didn't change Review Error", "FAIL");
										BordPage.deleteBorderEAUX();
									}	
								}else{
									Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
									BordPage.deleteBorderEAUX();
								}	
							}else
							{
								Report.LogInfo("ReviewErrorStatusValidation", "Status didn't change Review Error", "FAIL");
								BordPage.deleteBorderEAUX();
							}
						}else{
							Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
							BordPage.deleteBorderEAUX();
						}						
					}else
					{
						Report.LogInfo("ReviewErrorStatusValidation", "Status didn't change Review Error", "FAIL");
						BordPage.deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
					BordPage.deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
				BordPage.deleteBorderEAUX();
			}			
		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
			BordPage.deleteBorderEAUX();		
		}		
	}
	
	
	//TC 4745 :- Contract Data Summary-Quartely Reporting
	public void ConDataSumQuaterlyReporting_4745() throws Exception
	{
		BordereauProcessPage BordPage = new BordereauProcessPage();

		String subSheet = "Bordereau Processing (kruthika test schema)";
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String Type = "Risk";
		String freqVal = "Quarterly";		
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		//contractId = ReturnContractID();
		//Step 1
		policy.addPolicy2(IncDate,ExpDate);
		contractId = ReturnContractID();
		contractEditUSd();
		policy.changeStatusToQuote();
		policy.changeStatusToWritten();
		policy.changeStatusToSigned2(Type,freqVal);
		Report.LogInfo("StepCheck", "Step 1 completed", "PASS");

		//Step 2, 3, 4
		String type1 = "Premium";
		String FreqVal1 = "Quarterly";
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannelForAnyComb(type1,FreqVal1);		
		Report.LogInfo("StepCheck", "Steps 2,3,4 completed", "PASS");

		//Step 5, 6, 7
		String type2 = "Claim";
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannelForAnyComb(type2,FreqVal1);
		Report.LogInfo("StepCheck", "Steps 5, 6, 7 completed", "PASS");

		//Step 9, 10
		BordPage.SubmitBordereaux(subSheet);		

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4745Path = fpath+"\\src\\test\\resources\\testdata\\February 2017 Risk_TC4745First.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4745Path);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"February 2017 Risk_TC4745First.xlsx\",\"UniqueFileName\":\"S54643320180108.xlsx\",\"BordereauFormatId\":\"78c4312c-a24f-4223-9538-bc709f5a67b1\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S54643320180108.xlsx\",\"Filesize\":24997,\"Path\":null,\"size\":24997,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordPage.refreshUploadedFile();
		Report.LogInfo("StepCheck", "Steps 8, 9 completed", "PASS");

		//Step 10
		BordPage.navigateToDATATab();
		Report.LogInfo("StepCheck", "Steps 10 completed", "PASS");

		//Step 11
		BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
		if(isVisible(BordPage.ReviewBtn)==true){
			
			ReviewToApprvdStatus();
			BordPage.refreshUploadedFileForApproved();
			Report.LogInfo("StepCheck", "Steps 12,13,14 completed", "PASS");
			
			//Step 15
			BordPage.navigateToDATATab();
			String Janavl = "@xpath=//tr[1]//td[text()='260.20']";
			String JanTotalVal = "@xpath=//tr[2]//td//span[text()='260.20']";
			verifyExists(Janavl,"Match month value");
			verifyExists(JanTotalVal,"Match month total value");
			Report.LogInfo("StepCheck", "Steps 15 completed", "PASS");

			//Step 16
			BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
			Report.LogInfo("StepCheck", "Steps 16 completed", "PASS");

			//Step 17
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4745PathScnd = fpath+"\\src\\test\\resources\\testdata\\February2017Premium_TC4745Secnd.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile1 = new File(sheet4745PathScnd);
			String payload1 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"2\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"February2017Premium_TC4745Secnd.xlsx\",\"UniqueFileName\":\"S19629120180108.xlsx\",\"BordereauFormatId\":\"b591afc9-f928-4e83-ac6d-c809cff00b2e\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S19629120180108.xlsx\",\"Filesize\":18516,\"Path\":null,\"size\":18516,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile1, payload1, DraftUrl);
			BordPage.refreshUploadedFile();
			Report.LogInfo("StepCheck", "Steps 17 completed", "PASS");

			//step 18
			if(isVisible(BordPage.ReviewBtn)==true){
				ReviewToApprvdStatus();
				BordPage.refreshUploadedFileForApprovedScndRw();
				Report.LogInfo("StepCheck", "Steps 19,20,21 completed", "PASS");
				
				//Step 22
				BordPage.navigateToDATATab();
				String Janavl1 = "@xpath=//tr[1]//td[text()='520.41']";
				String JanTotalVal1 = "@xpath=//tr[2]//td//span[text()='520.41']";
				verifyExists(Janavl1,"March month value");
				verifyExists(JanTotalVal1,"March month total value");
				Report.LogInfo("StepCheck", "Steps 22 completed", "PASS");

				//Step 23
				BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
				Report.LogInfo("StepCheck", "Steps 23 completed", "PASS");

				//Step 24
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet4745PathThird = fpath+"\\src\\test\\resources\\testdata\\February2017-Claim_TC4745Third.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File excelFile2 = new File(sheet4745PathThird);
				String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"February2017-Claim_TC4745Third.xlsx\",\"UniqueFileName\":\"S72452520180311.xlsx\",\"BordereauFormatId\":\"a3db7e7b-7f76-4086-9e21-eb004229f74d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S72452520180311.xlsx\",\"Filesize\":17810,\"Path\":null,\"size\":17810,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
                uploadFile(ReqUrl, excelFile2, payload2, DraftUrl);
				BordPage.refreshUploadedFile();
				Report.LogInfo("StepCheck", "Steps 24 completed", "PASS");

				//step 25
				if(isVisible(BordPage.ReviewBtn)==true){
					ReviewToApprvdStatus();
					BordPage.refreshUploadedFileForApprovedScndRw();
					Report.LogInfo("StepCheck", "Steps 26,27,28 completed", "PASS");
					
					//Step 29
					BordPage.navigateToDATATab();
					String Incurred1 = "@xpath=//tr[1]//td[text()='820.41']";
					String Incurred2 = "@xpath=//tr[2]//td//span[text()='820.41']";
					
					verifyExists(Incurred1,"Incured value");
					verifyExists(Incurred2,"Incured value");
					
					String WrittnGrossP1 = "@xpath=//tr[1]//td[text()='315.29%']";
					String WrittnGrossP2 = "@xpath=//tr[2]//td//span[text()='315.29%']";
					
					verifyExists(WrittnGrossP1,"Written gross premium value");
					verifyExists(WrittnGrossP2,"Written gross premium value");
					
					Report.LogInfo("StepCheck", "Steps 29 completed", "PASS");
			
					//Step 30
					BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
					Report.LogInfo("StepCheck", "Steps 36 completed", "PASS");

					//Step 31
					try 
					{
						String fpath = new File(".").getCanonicalPath();
						sheet4745PathFourth = fpath+"\\src\\test\\resources\\testdata\\MArch2017 Risk_TC4745Fourth.xlsx";
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					File excelFile3 = new File(sheet4745PathFourth);
					String payload3 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":3,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"MArch2017 Risk_TC4745Fourth.xlsx\",\"UniqueFileName\":\"S91446520180108.xlsx\",\"BordereauFormatId\":\"78c4312c-a24f-4223-9538-bc709f5a67b1\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S91446520180108.xlsx\",\"Filesize\":24936,\"Path\":null,\"size\":24936,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
					uploadFile(ReqUrl, excelFile3, payload3, DraftUrl);
					BordPage.refreshUploadedFile();
					Report.LogInfo("StepCheck", "Steps 31 completed", "PASS");

					//Step 32
					String ErrorScreen = "@xpath=.//h2[text()='Approved bordereau already processed against the period selected']";
					if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
					{	
						Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
						//Step 33
						if(isVisible(ErrorScreen)== true){							
							if(isVisible(BordPage.ProcessAsAdditionalBtn)== true){
								verifyMustExists(BordPage.ProcessAsAdditionalBtn,"PROCESS AS AN ADDITIONAL BORDEREAU button");
								javaScriptclick(BordPage.ProcessAsAdditionalBtn,"PROCESS AS AN ADDITIONAL BORDEREAU button");
								sleep(3000);
								BordPage.refreshUploadedFile();
								Report.LogInfo("StepCheck", "Steps 33 completed", "PASS");
							}else{
								goBack();
							}
						}
						//step 34
						if(isVisible(BordPage.ReviewBtn)==true){
							ReviewToApprvdStatus();
							BordPage.refreshUploadedFileForApproved();
							Report.LogInfo("StepCheck", "Steps 34,35,36,37 completed", "PASS");
							
							//Step 38
							BordPage.navigateToDATATab();
							String WGP1 = "@xpath=//tr[1]//td[text()='780.61']";
							String WGP2 = "@xpath=//tr[2]//td//span[text()='780.61']";

							verifyExists(WGP1,"Writtent gross premium value");
							verifyExists(WGP2,"Writtent gross premium value");
							Report.LogInfo("StepCheck", "Steps 38 completed", "PASS");

							//Step 39
							BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
							Report.LogInfo("StepCheck", "Steps 39 completed", "PASS");

							//Step 40
							try 
							{
								String fpath = new File(".").getCanonicalPath();
								sheet4745PathFifth = fpath+"\\src\\test\\resources\\testdata\\March2017Premium_TC4745Fifth.xlsx";
							} 
							catch (IOException e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							File excelFile4 = new File(sheet4745PathFifth);
							String payload4 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":3,\"DataSetType\":\"2\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"March2017Premium_TC4745Fifth.xlsx\",\"UniqueFileName\":\"S58203620180108.xlsx\",\"BordereauFormatId\":\"b591afc9-f928-4e83-ac6d-c809cff00b2e\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S58203620180108.xlsx\",\"Filesize\":18451,\"Path\":null,\"size\":18451,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
							uploadFile(ReqUrl, excelFile4, payload4, DraftUrl);
							BordPage.refreshUploadedFile();
							Report.LogInfo("StepCheck", "Steps 40 completed", "PASS");

							//Step 41
							if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
							{	
								Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
								//Step 42
								if(isVisible(ErrorScreen)== true){							
									if(isVisible(BordPage.ProcessAsAdditionalBtn)== true){
										//javaScriptclick(YesBtn,"Yes button");
										verifyMustExists(BordPage.ProcessAsAdditionalBtn,"PROCESS AS AN ADDITIONAL BORDEREAU button");
										javaScriptclick(BordPage.ProcessAsAdditionalBtn,"PROCESS AS AN ADDITIONAL BORDEREAU button");
										sleep(3000);
										BordPage.refreshUploadedFile();
										Report.LogInfo("StepCheck", "Steps 41,42 completed", "PASS");
									}else{
										goBack();
									}
								}
								//step 43
								if(isVisible(BordPage.ReviewBtn)==true){
									ReviewToApprvdStatus();
									BordPage.refreshUploadedFileForApproved();
									//Report.LogInfo("StepCheck", "Steps 52 completed", "PASS");
									Report.LogInfo("StepCheck", "Steps 43,44,45 completed", "PASS");
									
									//Step 46
									BordPage.navigateToDATATab();
									String WGP3 = "@xpath=//tr[1]//td[text()='1,301.02']";
									String WGP4 = "@xpath=//tr[2]//td//span[text()='1,301.02']";

									verifyExists(WGP3,"Writtent gross premium value");
									verifyExists(WGP4,"Writtent gross premium value");
									Report.LogInfo("StepCheck", "Steps 46 completed", "PASS");

									//Step 47
									BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
									Report.LogInfo("StepCheck", "Steps 47 completed", "PASS");

									//Step 48
									try 
									{
										String fpath = new File(".").getCanonicalPath();
										sheet4745PathSixth = fpath+"\\src\\test\\resources\\testdata\\March2017Cliam_TC4745Sixth.xlsx";
									} 
									catch (IOException e) 
									{
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									File excelFile5 = new File(sheet4745PathSixth);
									String payload5 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":3,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"March2017Cliam_TC4745Sixth.xlsx\",\"UniqueFileName\":\"S64572620180311.xlsx\",\"BordereauFormatId\":\"a3db7e7b-7f76-4086-9e21-eb004229f74d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S64572620180311.xlsx\",\"Filesize\":17808,\"Path\":null,\"size\":17808,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
									uploadFile(ReqUrl, excelFile5, payload5, DraftUrl);
									BordPage.refreshUploadedFile();
									Report.LogInfo("StepCheck", "Steps 48 completed", "PASS");


									//Step 49

									if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
									{	
										Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
										//Step 50
										if(isVisible(ErrorScreen)== true){							
											if(isVisible(BordPage.ProcessAsAdditionalBtn)== true){
												//javaScriptclick(YesBtn,"Yes button");
												verifyMustExists(BordPage.ProcessAsAdditionalBtn,"ProcessAsAdditionalBtn button");
												javaScriptclick(BordPage.ProcessAsAdditionalBtn,"ProcessAsAdditionalBtn button");
												sleep(3000);
												BordPage.refreshUploadedFile();
												Report.LogInfo("StepCheck", "Steps 50 completed", "PASS");
											}else{
												goBack();
											}
										}
										//step 51
										if(isVisible(BordPage.ReviewBtn)==true){
											ReviewToApprvdStatus();
											BordPage.refreshUploadedFileForApproved();
											Report.LogInfo("StepCheck", "Steps 51,52,53,54 completed", "PASS");
											
											//Step 55
											BordPage.navigateToDATATab();
											String Incurred5 = "@xpath=//tr[1]//td[text()='820.41']";
											String Incurred6 = "@xpath=//tr[2]//td//span[text()='820.41']";
											
											verifyExists(Incurred5,"Incured value");
											verifyExists(Incurred6,"Incured value");
											sleep(1000);
											Report.LogInfo("StepCheck", "Steps 55 completed", "PASS");
											
											//Step 56, 57, 58
											String ref = "BB";
											String BrockrageVal = "5";
											String ClassBval = "Property D&F (non-US binder)";
											String currencyVal = "USD - United States Dollar";
											String EPermiumIncome1 = "5";
											String GPermiumIncome1 = "3";
											String GPermiumLimit1 = "2";
											String ConductRiskRatingValue1 = "Low";

											policy.addSection2(ref, BrockrageVal, ClassBval, currencyVal, EPermiumIncome1, GPermiumIncome1, GPermiumLimit1, ConductRiskRatingValue1);
											Report.LogInfo("StepCheck", "Steps 56, 57, 58 completed", "PASS");

											//Step 59, 60, 61
											String RiskCode1 = "1E - OVERSEAS LEG TERRORISM ENERGY OFFSHORE PROPERTY";
											String per1 = "40";
											policy.navigateToRiskCodesTabOnSection();
											policy.addRiskCodesOnSection(RiskCode1,per1);
											Report.LogInfo("StepCheck", "Steps 59, 60, 61 completed", "PASS");

											sleep(2000);
											//Step 62, 63, 64
											String per2 = "60";
											policy.navigateToRiskCodesTabOnSection();
											policy.addRiskCodesOnSection(RiskCode1,per2);
											Report.LogInfo("StepCheck", "Steps 62, 63, 64 completed", "PASS");
									
										}else{
											Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
											//ApplyDueDateFilter(DueDate, Valuedate);
											BordPage.deleteBorderEAUX();
										}	
									}else
									{
										Report.LogInfo("ReviewErrorStatusValidation", "Status didn't change Review Error", "FAIL");
										BordPage.deleteBorderEAUX();
									}	
								}else{
									Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
									BordPage.deleteBorderEAUX();
								}	
							}else
							{
								Report.LogInfo("ReviewErrorStatusValidation", "Status didn't change Review Error", "FAIL");
								BordPage.deleteBorderEAUX();
							}
						}else{
							Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
							BordPage.deleteBorderEAUX();
						}						
					}else
					{
						Report.LogInfo("ReviewErrorStatusValidation", "Status didn't change Review Error", "FAIL");
						BordPage.deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
					BordPage.deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
				BordPage.deleteBorderEAUX();
			}			
		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
			BordPage.deleteBorderEAUX();		
		}		
	}

	//TC 4839 :- Contract Data Summary-Quartely Reporting
		public void ConDataSumQuaterlyNil_4839() throws Exception
		{
			BordereauProcessPage BordPage = new BordereauProcessPage();

			String subSheet = "Bordereau Processing (kruthika test schema)";
			String IncDate = "01/01/2017";
			String ExpDate="31/12/2017";
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			BordPage.applyFilterPolicy(policy.PolicyNumber);
			//BordPage.applyFilterPolicy("159029HF");
			BordPage.openSelectedPolicy();
			contractId = ReturnContractID();
			
			//Step 3
			BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
			Report.LogInfo("StepCheck", "Steps 2 completed", "PASS");
			
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4839Path = fpath+"\\src\\test\\resources\\testdata\\Saptember 2017 Risk_TC4839First.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile1 = new File(sheet4839Path);
			String payload1 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":9,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Saptember 2017 Risk_TC4839First.xlsx\",\"UniqueFileName\":\"S47604120180311.xlsx\",\"BordereauFormatId\":\"78c4312c-a24f-4223-9538-bc709f5a67b1\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S47604120180311.xlsx\",\"Filesize\":25816,\"Path\":null,\"size\":25816,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile1, payload1, DraftUrl);
			BordPage.refreshUploadedFile();
			Report.LogInfo("StepCheck", "Steps 3 completed", "PASS");
			//Step 4
			if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
			{	
				Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
				//Step 5
				String ErrorScreen = "@xpath=.//h2[text()='Missing Bordereau periods']";
				String YesBtn = "@xpath=.//*[@value='true']";

				if(isVisible(ErrorScreen)== true){							
					if(isVisible(BordPage.ContinueProcessingBodrBtn)== true){
						javaScriptclick(YesBtn,"Yes button");
						verifyMustExists(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
						javaScriptclick(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
						sleep(3000);
						BordPage.refreshUploadedFile();
						Report.LogInfo("StepCheck", "Steps 4,5 completed", "PASS");
					}else{
						goBack();
					}
				}
				//step 6,7,8,9,10
				if(isVisible(BordPage.ReviewBtn)==true){
					ReviewtoApprd2();
					BordPage.refreshUploadedFileForApproved();
					//Report.LogInfo("StepCheck", "Steps 52 completed", "PASS");
					Report.LogInfo("StepCheck", "Steps 6,7,8,9,10 completed", "PASS");
					
					//Step 11
					BordPage.navigateToDATATab();
					String WGP3 = "@xpath=//tr[1]//td[text()='460.20']";
					String WGP4 = "@xpath=//tr[2]//td//span[text()='460.20']";

					verifyExists(WGP3,"Writtent gross premium value");
					verifyExists(WGP4,"Writtent gross premium value");
					Report.LogInfo("StepCheck", "Steps 11 completed", "PASS");
					
					//step 12
					BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
					Report.LogInfo("StepCheck", "Steps 12 completed", "PASS");
										
					//Step 13
					try 
					{
						String fpath = new File(".").getCanonicalPath();
						sheet4839PathSecnd = fpath+"\\src\\test\\resources\\testdata\\Saptember 2017Premium_TC4839Secnd.xlsx";
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					File excelFile2 = new File(sheet4839PathSecnd);
					String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":9,\"DataSetType\":\"2\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Saptember 2017Premium_TC4839Secnd.xlsx\",\"UniqueFileName\":\"S85156520180311.xlsx\",\"BordereauFormatId\":\"b591afc9-f928-4e83-ac6d-c809cff00b2e\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S85156520180311.xlsx\",\"Filesize\":19340,\"Path\":null,\"size\":19340,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
					uploadFile(ReqUrl, excelFile2, payload2, DraftUrl);
					BordPage.refreshUploadedFile();
					Report.LogInfo("StepCheck", "Steps 13 completed", "PASS");

					//Step 14
					if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
					{	
						Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
						//Step 15
						//String ErrorScreen = "@xpath=.//h2[text()='Missing Bordereau periods']";
						//String YesBtn = "@xpath=.//*[@value='true']";

						if(isVisible(ErrorScreen)== true){							
							if(isVisible(BordPage.ContinueProcessingBodrBtn)== true){
								javaScriptclick(YesBtn,"Yes button");
								verifyMustExists(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
								javaScriptclick(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
								sleep(3000);
								BordPage.refreshUploadedFile();
								Report.LogInfo("StepCheck", "Steps 14,15 completed", "PASS");
							}else{
								goBack();
							}
						}
						//step 16,17,18,19,20
						if(isVisible(BordPage.ReviewBtn)==true){
							ReviewtoApprd2();
							BordPage.refreshUploadedFileForApproved();
							//Report.LogInfo("StepCheck", "Steps 52 completed", "PASS");
							Report.LogInfo("StepCheck", "Steps 16,17,18,19,20 completed", "PASS");
							
							//Step 21
							BordPage.navigateToDATATab();
							String WGP5 = "@xpath=//tr[1]//td[text()='920.41']";
							String WGP6 = "@xpath=//tr[2]//td//span[text()='920.41']";

							verifyExists(WGP5,"Writtent gross premium value");
							verifyExists(WGP6,"Writtent gross premium value");
							Report.LogInfo("StepCheck", "Steps 21 completed", "PASS");
							//****************************************************
							
							//step 22
							BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
							Report.LogInfo("StepCheck", "Steps 22 completed", "PASS");
												
							//Step 23
							try 
							{
								String fpath = new File(".").getCanonicalPath();
								sheet4839Paththird = fpath+"\\src\\test\\resources\\testdata\\Saptember 2017-Claim_TC4839Third.xlsx";
							} 
							catch (IOException e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							File excelFile3 = new File(sheet4839Paththird);
							String payload3 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":9,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Saptember 2017-Claim_TC4839Third.xlsx\",\"UniqueFileName\":\"S48101820180311.xlsx\",\"BordereauFormatId\":\"a3db7e7b-7f76-4086-9e21-eb004229f74d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S48101820180311.xlsx\",\"Filesize\":17787,\"Path\":null,\"size\":17787,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
							uploadFile(ReqUrl, excelFile3, payload3, DraftUrl);
							BordPage.refreshUploadedFile();
							Report.LogInfo("StepCheck", "Steps 23 completed", "PASS");

							//Step 24
							if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
							{	
								Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
								//Step 15
								//String ErrorScreen = "@xpath=.//h2[text()='Missing Bordereau periods']";
								//String YesBtn = "@xpath=.//*[@value='true']";

								if(isVisible(ErrorScreen)== true){							
									if(isVisible(BordPage.ContinueProcessingBodrBtn)== true){
										javaScriptclick(YesBtn,"Yes button");
										verifyMustExists(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
										javaScriptclick(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
										sleep(3000);
										BordPage.refreshUploadedFile();
										Report.LogInfo("StepCheck", "Steps 24,25 completed", "PASS");
									}else{
										goBack();
									}
								}
								//step 26,27,28,29,30
								if(isVisible(BordPage.ReviewBtn)==true){
									ReviewtoApprd2();
									BordPage.refreshUploadedFileForApproved();
									//Report.LogInfo("StepCheck", "Steps 52 completed", "PASS");
									Report.LogInfo("StepCheck", "Steps 26,27,28,29,30 completed", "PASS");
									
									//Step 31
									BordPage.navigateToDATATab();
									String WGP7 = "@xpath=//tr[1]//td[text()='280.10']";
									String WGP8 = "@xpath=//tr[2]//td//span[text()='280.10']";

									verifyExists(WGP7,"Writtent gross premium value");
									verifyExists(WGP8,"Writtent gross premium value");
									Report.LogInfo("StepCheck", "Steps 31 completed", "PASS");
									
									
								}else{
									Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
									BordPage.deleteBorderEAUX();
								}
							}else{
									Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
									BordPage.deleteBorderEAUX();
								}	
							
							//***************************************************
						}else{
							Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
							BordPage.deleteBorderEAUX();
						}
					}else{
							Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
							BordPage.deleteBorderEAUX();
						}	
					
				}else{
					Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
					BordPage.deleteBorderEAUX();
				}
			}else{
					Report.LogInfo("ValidateReviewStatus", "Review error status not displayed.", "FAIL");
					BordPage.deleteBorderEAUX();
				}

		}
		
	
		//TC 4757 :- Contract Data Summary-Annually Reporting
		public void ConDataSumAnnuallyReporting_4757() throws Exception
		{
			BordereauProcessPage BordPage = new BordereauProcessPage();

			String subSheet = "Bordereau Processing (kruthika test schema)";
			String IncDate = "01/01/2017";
			String ExpDate="31/12/2017";
			String Type = "Risk";
			String freqVal = "Annually";		
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			//contractId = ReturnContractID();
			//Step 1
			policy.addPolicy2(IncDate,ExpDate);
			contractId = ReturnContractID();
			contractEditUSd();
			policy.changeStatusToQuote();
			policy.changeStatusToWritten();
			policy.changeStatusToSigned2(Type,freqVal);
			Report.LogInfo("StepCheck", "Step 1 completed", "PASS");

			//Step 2, 3, 4
			String type1 = "Premium";
			String FreqVal1 = "Annually";
			policy.navigateToReportingChannelsTab();
			policy.addReportingChannelForAnyComb(type1,FreqVal1);		
			Report.LogInfo("StepCheck", "Steps 2,3,4 completed", "PASS");

			//Step 5, 6, 7
			String type2 = "Claim";
			policy.navigateToReportingChannelsTab();
			policy.addReportingChannelForAnyComb(type2,FreqVal1);
			Report.LogInfo("StepCheck", "Steps 5, 6, 7 completed", "PASS");

			//Step 9, 10, 11
			String ref = "BB";
			String BrockrageVal = "5";
			String ClassBval = "Property D&F (non-US binder)";
			String currencyVal = "USD - United States Dollar";
			String EPermiumIncome1 = "5";
			String GPermiumIncome1 = "3";
			String GPermiumLimit1 = "2";
			String ConductRiskRatingValue1 = "Medium";

			policy.addSection2(ref, BrockrageVal, ClassBval, currencyVal, EPermiumIncome1, GPermiumIncome1, GPermiumLimit1, ConductRiskRatingValue1);
			Report.LogInfo("StepCheck", "Steps 9, 10, 11 completed", "PASS");
			
			//Step 12,13,14
			policy.navigateToMarketsTabOnSection();
			policy.addMarketOnSection();
			Report.LogInfo("StepCheck", "Steps 12,13,14 completed", "PASS");
			
			//Step 15,16,17
			String RiskCode1 = "1E - OVERSEAS LEG TERRORISM ENERGY OFFSHORE PROPERTY";
			String per1 = "40";
			policy.navigateToRiskCodesTabOnSection();
			policy.addRiskCodesOnSection(RiskCode1,per1);
			Report.LogInfo("StepCheck", "Steps 15,16,17 completed", "PASS");

			sleep(2000);
			//Step 18, 19, 20
			String per2 = "60";
			policy.navigateToRiskCodesTabOnSection();
			policy.addRiskCodesOnSection(RiskCode1,per2);
			Report.LogInfo("StepCheck", "Steps 18, 19, 20 completed", "PASS");

			
			//Step 21
			BordPage.SubmitBordereaux(subSheet);		

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4757Path = fpath+"\\src\\test\\resources\\testdata\\February 2017 Risk_TC4757First.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4757Path);
			String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"February 2017 Risk_TC4757First.xlsx\",\"UniqueFileName\":\"S50088720180113.xlsx\",\"BordereauFormatId\":\"78c4312c-a24f-4223-9538-bc709f5a67b1\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S50088720180113.xlsx\",\"Filesize\":24997,\"Path\":null,\"size\":24997,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordPage.refreshUploadedFile();
			Report.LogInfo("StepCheck", "Steps 21, 22 completed", "PASS");

			//Step 23
			BordPage.navigateToDATATab();
			Report.LogInfo("StepCheck", "Steps 10 completed", "PASS");

			//Step 24
			BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
			if(isVisible(BordPage.ReviewBtn)==true){
				
				ReviewtoApprd2();
				BordPage.refreshUploadedFileForApproved();
				Report.LogInfo("StepCheck", "Steps 24 to 28 completed", "PASS");
				
				//Step 29
				BordPage.navigateToDATATab();
				String Janavl = "@xpath=//tr[1]//td[text()='260.20']";
				String JanTotalVal = "@xpath=//tr[2]//td//span[text()='260.20']";
				verifyExists(Janavl,"Match month value");
				verifyExists(JanTotalVal,"Match month total value");
				Report.LogInfo("StepCheck", "Steps 15 completed", "PASS");

				//Step 30
				BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
				Report.LogInfo("StepCheck", "Steps 30 completed", "PASS");

				//Step 31
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet4757PathScnd = fpath+"\\src\\test\\resources\\testdata\\February2017Premium_TC4757Second.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File excelFile1 = new File(sheet4757PathScnd);
				String payload1 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"2\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"February2017Premium_TC4757Second.xlsx\",\"UniqueFileName\":\"S30014920180113.xlsx\",\"BordereauFormatId\":\"b591afc9-f928-4e83-ac6d-c809cff00b2e\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S30014920180113.xlsx\",\"Filesize\":18516,\"Path\":null,\"size\":18516,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				uploadFile(ReqUrl, excelFile1, payload1, DraftUrl);
				BordPage.refreshUploadedFile();
				Report.LogInfo("StepCheck", "Steps 31 completed", "PASS");

				//step 32
				if(isVisible(BordPage.ReviewBtn)==true){
					ReviewtoApprd2();
					BordPage.refreshUploadedFileForApprovedScndRw();
					Report.LogInfo("StepCheck", "Steps 32 to 36 completed", "PASS");
					
					//Step 37
					BordPage.navigateToDATATab();
					String Janavl1 = "@xpath=//tr[1]//td[text()='520.41']";
					String JanTotalVal1 = "@xpath=//tr[2]//td//span[text()='520.41']";
					verifyExists(Janavl1,"March month value");
					verifyExists(JanTotalVal1,"March month total value");
					Report.LogInfo("StepCheck", "Steps 37 completed", "PASS");

					//Step 38
					BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
					Report.LogInfo("StepCheck", "Steps 38 completed", "PASS");

					//Step 39
					try 
					{
						String fpath = new File(".").getCanonicalPath();
						sheet4757PathThird = fpath+"\\src\\test\\resources\\testdata\\February2017-Claim_TC4757Third.xlsx";
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					File excelFile2 = new File(sheet4757PathThird);
					String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"February2017-Claim_TC4757Third.xlsx\",\"UniqueFileName\":\"S60346320180311.xlsx\",\"BordereauFormatId\":\"a3db7e7b-7f76-4086-9e21-eb004229f74d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S60346320180311.xlsx\",\"Filesize\":17795,\"Path\":null,\"size\":17795,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
					uploadFile(ReqUrl, excelFile2, payload2, DraftUrl);
					BordPage.refreshUploadedFile();
					Report.LogInfo("StepCheck", "Steps 39 completed", "PASS");

					//step 40
					if(isVisible(BordPage.ReviewBtn)==true){
						ReviewtoApprd2();
						BordPage.refreshUploadedFileForApprovedScndRw();
						Report.LogInfo("StepCheck", "Steps 41 to 44 completed", "PASS");
						
						//Step 45
						BordPage.navigateToDATATab();
						String Incurred1 = "@xpath=//tr[1]//td[text()='820.41']";
						String Incurred2 = "@xpath=//tr[2]//td//span[text()='820.41']";
						
						verifyExists(Incurred1,"Incured value");
						verifyExists(Incurred2,"Incured value");
						
						String WrittnGrossP1 = "@xpath=//tr[1]//td[text()='315.29%']";
						String WrittnGrossP2 = "@xpath=//tr[2]//td//span[text()='315.29%']";
						
						verifyExists(WrittnGrossP1,"Written gross premium value");
						verifyExists(WrittnGrossP2,"Written gross premium value");
						
						Report.LogInfo("StepCheck", "Steps 45 completed", "PASS");
				
						//Step 46
						BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
						Report.LogInfo("StepCheck", "Steps 46 completed", "PASS");

						//Step 47
						try 
						{
							String fpath = new File(".").getCanonicalPath();
							sheet4757PathFourth = fpath+"\\src\\test\\resources\\testdata\\Saptember 2017 Risk_TC4757Fourth.xlsx";
						} 
						catch (IOException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						File excelFile3 = new File(sheet4757PathFourth);
						String payload3 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":9,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Saptember 2017 Risk_TC4757Fourth.xlsx\",\"UniqueFileName\":\"S42114820180113.xlsx\",\"BordereauFormatId\":\"78c4312c-a24f-4223-9538-bc709f5a67b1\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S42114820180113.xlsx\",\"Filesize\":25286,\"Path\":null,\"size\":25286,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						uploadFile(ReqUrl, excelFile3, payload3, DraftUrl);
						BordPage.refreshUploadedFile();
						Report.LogInfo("StepCheck", "Steps 47 completed", "PASS");

						//Step 48
						String ErrorScreen = "@xpath=.//h2[text()='Approved bordereau already processed against the period selected']";
						if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
						{	
							Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
							//Step 49
							if(isVisible(ErrorScreen)== true){							
								if(isVisible(BordPage.ProcessAsAdditionalBtn)== true){
									verifyMustExists(BordPage.ProcessAsAdditionalBtn,"PROCESS AS AN ADDITIONAL BORDEREAU button");
									javaScriptclick(BordPage.ProcessAsAdditionalBtn,"PROCESS AS AN ADDITIONAL BORDEREAU button");
									sleep(3000);
									BordPage.refreshUploadedFile();
									Report.LogInfo("StepCheck", "Steps 48 completed", "PASS");
								}else{
									goBack();
								}
							}
							//step 50
							if(isVisible(BordPage.ReviewBtn)==true){
								ReviewToApprvdStatus();
								BordPage.refreshUploadedFileForApproved();
								Report.LogInfo("StepCheck", "Steps 50 to 53 completed", "PASS");
								
								//Step 54
								BordPage.navigateToDATATab();
								String WGP1 = "@xpath=//tr[1]//td[text()='720.41']";
								String WGP2 = "@xpath=//tr[2]//td//span[text()='720.41']";

								verifyExists(WGP1,"Writtent gross premium value");
								verifyExists(WGP2,"Writtent gross premium value");
								Report.LogInfo("StepCheck", "Steps 54 completed", "PASS");

								//Step 55
								BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
								Report.LogInfo("StepCheck", "Steps 55 completed", "PASS");

								//Step 56
								try 
								{
									String fpath = new File(".").getCanonicalPath();
									sheet4757PathFifth = fpath+"\\src\\test\\resources\\testdata\\Saptember 2017Premium_TC4757Fifth.xlsx";
								} 
								catch (IOException e) 
								{
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								File excelFile4 = new File(sheet4757PathFifth);
								String payload4 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":9,\"DataSetType\":\"2\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Saptember 2017Premium_TC4757Fifth.xlsx\",\"UniqueFileName\":\"S69176220180113.xlsx\",\"BordereauFormatId\":\"b591afc9-f928-4e83-ac6d-c809cff00b2e\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S69176220180113.xlsx\",\"Filesize\":18887,\"Path\":null,\"size\":18887,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
								uploadFile(ReqUrl, excelFile4, payload4, DraftUrl);
								BordPage.refreshUploadedFile();
								Report.LogInfo("StepCheck", "Steps 56 completed", "PASS");

								//Step 57
								if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
								{	
									Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
									//Step 58
									if(isVisible(ErrorScreen)== true){							
										if(isVisible(BordPage.ProcessAsAdditionalBtn)== true){
											//javaScriptclick(YesBtn,"Yes button");
											verifyMustExists(BordPage.ProcessAsAdditionalBtn,"PROCESS AS AN ADDITIONAL BORDEREAU button");
											javaScriptclick(BordPage.ProcessAsAdditionalBtn,"PROCESS AS AN ADDITIONAL BORDEREAU button");
											sleep(3000);
											BordPage.refreshUploadedFile();
											Report.LogInfo("StepCheck", "Steps 58,59 completed", "PASS");
										}else{
											goBack();
										}
									}
									//step 60
									if(isVisible(BordPage.ReviewBtn)==true){
										ReviewToApprvdStatus();
										BordPage.refreshUploadedFileForApproved();
										//Report.LogInfo("StepCheck", "Steps 52 completed", "PASS");
										Report.LogInfo("StepCheck", "Steps 60 to 62 completed", "PASS");
										
										//Step 63
										BordPage.navigateToDATATab();
										String WGP3 = "@xpath=//tr[1]//td[text()='1,440.82']";
										String WGP4 = "@xpath=//tr[2]//td//span[text()='1,440.82']";

										verifyExists(WGP3,"Writtent gross premium value");
										verifyExists(WGP4,"Writtent gross premium value");
										Report.LogInfo("StepCheck", "Steps 46 completed", "PASS");

										//Step 64
										BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
										Report.LogInfo("StepCheck", "Steps 64 completed", "PASS");

										//Step 65
										try 
										{
											String fpath = new File(".").getCanonicalPath();
											sheet4757PathSixth = fpath+"\\src\\test\\resources\\testdata\\Saptember 2017-Claim_TC4757Sixth.xlsx";
										} 
										catch (IOException e) 
										{
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										File excelFile5 = new File(sheet4757PathSixth);
										String payload5 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":9,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Saptember 2017-Claim_TC4757Sixth.xlsx\",\"UniqueFileName\":\"S38338120180311.xlsx\",\"BordereauFormatId\":\"a3db7e7b-7f76-4086-9e21-eb004229f74d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S38338120180311.xlsx\",\"Filesize\":17818,\"Path\":null,\"size\":17818,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
										uploadFile(ReqUrl, excelFile5, payload5, DraftUrl);
										BordPage.refreshUploadedFile();
										Report.LogInfo("StepCheck", "Steps 65 completed", "PASS");

										//Step 66

										if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
										{	
											Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
											//Step 67
											if(isVisible(ErrorScreen)== true){							
												if(isVisible(BordPage.ProcessAsAdditionalBtn)== true){
													//javaScriptclick(YesBtn,"Yes button");
													verifyMustExists(BordPage.ProcessAsAdditionalBtn,"ProcessAsAdditionalBtn button");
													javaScriptclick(BordPage.ProcessAsAdditionalBtn,"ProcessAsAdditionalBtn button");
													sleep(3000);
													BordPage.refreshUploadedFile();
													Report.LogInfo("StepCheck", "Steps 66,67 completed", "PASS");
												}else{
													goBack();
												}
											}
											//step 68
											if(isVisible(BordPage.ReviewBtn)==true){
												ReviewToApprvdStatus();
												BordPage.refreshUploadedFileForApproved();
												Report.LogInfo("StepCheck", "Steps 69 to 71 completed", "PASS");
												
												//Step 72
												BordPage.navigateToDATATab();
												String Incurred5 = "@xpath=//tr[1]//td[text()='820.41']";
												String Incurred6 = "@xpath=//tr[2]//td//span[text()='820.41']";
												
												verifyExists(Incurred5,"Incured value");
												verifyExists(Incurred6,"Incured value");
												sleep(1000);
												Report.LogInfo("StepCheck", "Steps 72 completed", "PASS");
																								
																						
											}else{
												Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
												//ApplyDueDateFilter(DueDate, Valuedate);
												BordPage.deleteBorderEAUX();
											}	
										}else
										{
											Report.LogInfo("ReviewErrorStatusValidation", "Status didn't change Review Error", "FAIL");
											BordPage.deleteBorderEAUX();
										}	
									}else{
										Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
										BordPage.deleteBorderEAUX();
									}	
								}else
								{
									Report.LogInfo("ReviewErrorStatusValidation", "Status didn't change Review Error", "FAIL");
									BordPage.deleteBorderEAUX();
								}
							}else{
								Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
								BordPage.deleteBorderEAUX();
							}						
						}else
						{
							Report.LogInfo("ReviewErrorStatusValidation", "Status didn't change Review Error", "FAIL");
							BordPage.deleteBorderEAUX();
						}
					}else{
						Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
						BordPage.deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
					BordPage.deleteBorderEAUX();
				}			
			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
				BordPage.deleteBorderEAUX();		
			}		
		}	
	
	//==================================Reusable functions=========================================
	public void contractEditUSd()
	{
		if(isVisible(contractEditDots)==true){
			waitForElementToAppear(contractEditDots,5);
			verifyMustExists(contractEditDots,"Contract Edit dots");
			click(contractEditDots,"Contract Edit dots");
			waitForElementToAppear(ContractEditbtn,5);
			verifyMustExists(ContractEditbtn,"Contract Edit link");
			click(ContractEditbtn,"Contract Edit link");
			SelectDropDownValue(policy.ContractCurrencyDrpDown,policy.ContractCurrencyDrpDownValueUSD);
			scrollDown();
			sleep(1000);
			verifyMustExists(policy.SaveBtn,"Save Button");
			click(policy.SaveBtn,"Save button");
			sleep(1000);
		}
	}
	
	public void ReviewToApprvdStatus() throws Exception
	{
		BordereauProcessPage BordPage = new BordereauProcessPage();
		
		javaScriptclick(BordPage.ReviewBtn,"Reviwe button");
		//Report.LogInfo("StepCheck", "Steps 11 completed", "PASS");

		//Step 12
		waitForElementToAppear(BordPage.SuRcdAssmnt,5);
		verifyMustExists(BordPage.SuRcdAssmnt,"Submit record assesment button");
		click(BordPage.SuRcdAssmnt,"Submit record assesment button");
		//Report.LogInfo("StepCheck", "Steps 12 completed", "PASS");

		//step 13
		waitForElementToAppear(BordPage.FrApprovalbtn1,5);
		verifyMustExists(BordPage.FrApprovalbtn1,"For Approval button");
		click(BordPage.FrApprovalbtn1,"For Approval button");
		//Report.LogInfo("StepCheck", "Steps 13 completed", "PASS");

		//Step 14
		BordPage.clickOnApproveBordBtn();
		sleep(15000);
		//BordPage.refreshUploadedFileForApproved();
		//Report.LogInfo("StepCheck", "Steps 14 completed", "PASS");
	}
	
	public void ReviewtoApprd1() throws Exception{
		BordereauProcessPage BordPage = new BordereauProcessPage();
		
		Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
		javaScriptclick(BordPage.ReviewBtn,"Review button");
		//Report.LogInfo("StepCheck", "Steps 40 completed", "PASS");

		//step 41			
		waitForElementToAppear(BordPage.SuRcdAssmnt,5);
		verifyMustExists(BordPage.SuRcdAssmnt,"Submit record assesment button");
		javaScriptclick(BordPage.SuRcdAssmnt,"Submit record assesment button");
		//Report.LogInfo("StepCheck", "Steps 41 completed", "PASS");

		//Step 42
		String DRpval = "@xpath=//li[contains(.,'Section 2')]";
		String ComplteAssgmnt = "@xpath=//*[@id='content']//button[@type='submit']";
		SelectDropDownValue(SectionconDrp,DRpval);
		verifyMustExists(ComplteAssgmnt,"Complete assginment button");
		javaScriptclick(ComplteAssgmnt,"Complete assginment button");
		//Report.LogInfo("StepCheck", "Steps 42 completed", "PASS");
		
		
		//Step 43
		BordPage.clickOnApproveBordBtn1();
		sleep(15000);
		//BordPage.refreshUploadedFileForApproved();
		//Report.LogInfo("StepCheck", "Steps 43 completed", "PASS");
	}
	
	public void ReviewtoApprd2() throws Exception{
		BordereauProcessPage BordPage = new BordereauProcessPage();
		
		Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
		javaScriptclick(BordPage.ReviewBtn,"Review button");
		//Report.LogInfo("StepCheck", "Steps 40 completed", "PASS");

		//step 41			
		waitForElementToAppear(BordPage.SuRcdAssmnt,5);
		verifyMustExists(BordPage.SuRcdAssmnt,"Submit record assesment button");
		javaScriptclick(BordPage.SuRcdAssmnt,"Submit record assesment button");
		//Report.LogInfo("StepCheck", "Steps 41 completed", "PASS");

		//Step 42
		String DRpval = "@xpath=//li[contains(.,'Section 2')]";
		String ComplteAssgmnt = "@xpath=//*[@id='content']//button[@type='submit']";
		SelectDropDownValue(SectionconDrp,DRpval);
		verifyMustExists(ComplteAssgmnt,"Complete assginment button");
		javaScriptclick(ComplteAssgmnt,"Complete assginment button");
		//Report.LogInfo("StepCheck", "Steps 42 completed", "PASS");
		
		//step 
		String DRpval1 = "@xpath=//li[contains(.,'Default all entries in the Bordereau to the primary Risk Code of the Section')]";
		SelectDropDownValue(SectionconDrp,DRpval1);
		verifyMustExists(ComplteAssgmnt,"Complete assginment button");
		javaScriptclick(ComplteAssgmnt,"Complete assginment button");
		
		//Step 43
		BordPage.clickOnApproveBordBtn1();
		sleep(15000);
		//BordPage.refreshUploadedFileForApproved();
		//Report.LogInfo("StepCheck", "Steps 43 completed", "PASS");
	}
}
