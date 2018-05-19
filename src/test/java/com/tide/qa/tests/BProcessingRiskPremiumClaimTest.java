package com.tide.qa.tests;

import org.testng.annotations.Test;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BProcessingRiskPremiumClaimPage;
import com.tide.qa.pagefactory.BordereauQuePage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

public class BProcessingRiskPremiumClaimTest extends TestBase
{
	BProcessingRiskPremiumClaimPage BProcessRPC = new BProcessingRiskPremiumClaimPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Test123@";
	
	String AdminUsername1 = "dave.brit@brit.com";
	String AdminPassword1 = "Pa55word123";
	
	String AdminInsureRead = "readonly.brookes@aspen.co.uk";
	String AdminInsurePassRead = "Pa55word123";
	
	String BrokerRead = "tk.tester007@gmail.com";
	String BrokerPassRead = "Test123@";
	
	String CoverholderRead = "readonly.jones@coverholderinc.com";
	String CoverholderReadPass = "Pa55word123";
	
	String AdminUsername3 = "readonly.jones@coverholderinc.com";
	String AdminPassword3 = "Pa55word123";
	
	@Test(priority = 641, groups={"TC4438_BordereauProcessingForRisk"})
	public void TC4438_BordereauProcessingForRisk()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4438_BordereauProcessingForRisk");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.bordereauProcessingForRisk_4438();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4438_BordereauProcessingForRisk "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Bordereau Processing for Risk Verification");
		videoRecordingStop();
	}
		
	@Test(priority = 642, groups={"TC4510_BordereauProcessingForClaim"})
	public void TC4510_BordereauProcessingForClaim()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4510_BordereauProcessingForClaim");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.bordereauProcessingForClaim_4510();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4510_BordereauProcessingForClaim "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Bordereau Processing for claim Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 643, groups={"TC4511_BordereauProcessingForPremium"})
	public void TC4511_BordereauProcessingForPremium()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4511_BordereauProcessingForPremium");
			//login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.bordereauProcessingForPremium_4511();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4511_BordereauProcessingForPremium "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Bordereau Processing for premium Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 644, groups={"TC5356_TaskAndNotes"})
	public void TC5356_TaskAndNotes()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC5356_TaskAndNotes");
			//login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.TaskAndNotes_TC5356();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5356_TaskAndNotes "+e.getMessage(), "FAIL");
		}finally{
			
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Tasks and notes");
		videoRecordingStop();
	}
		
	@Test(priority = 645, groups={"TC4513_ContractRoleCAandCC"})
	public void TC4513_ContractRoleCAandCC()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4513_ContractRoleCAandCC");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ChangeRole_CA_Insurer();
			BProcessRPC.ContractRoleCA_Insurer();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4513_ContractRoleCAandCC "+e.getMessage(), "FAIL");
		}finally{
			
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity role: Contract Administrator -Standard User of Insurer");
		videoRecordingStop();
	}
		
	@Test(priority = 646, groups={"TC4515_ContractAdminStandrdUser"})
	public void TC4515_ContractAdminStandrdUser()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4515_ContractAdminStandrdUser");
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);
			BProcessRPC.ContractAdminStandrdUser_TC4515();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4515_ContractAdminStandrdUser "+e.getMessage(), "FAIL");
		}finally{
			
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity role: Contract Administrator -Readonly User of Insurer");
		videoRecordingStop();
	}
	
	@Test(priority = 647, groups={"TC4516_RiskInformationStandrdInsirerUser"})
	public void TC4516_RiskInformationStandrdInsirerUser()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4516_RiskInformationStandrdInsirerUser");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.Change_role_Insurer_RiskTransformation();
			BProcessRPC.RiskInformationStandrdInsirerUser_TC4516();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4516_RiskInformationStandrdInsirerUser "+e.getMessage(), "FAIL");
		}finally{
			
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity Role - Risk Transformation - Standard - Insurer");
		videoRecordingStop();
	}
	
	@Test(priority = 648, groups={"TC4639_RiskTransformationReadonly"})
	public void TC4639_RiskTransformationReadonly()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4639_RiskTransformationReadonly");
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Risk_Transformation");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4639_RiskTransformationReadonly "+e.getMessage(), "FAIL");
		}finally{
			
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity Role - Risk Transformation - Read Only - Insurer");
		videoRecordingStop();
	}
	
	@Test(priority = 649, groups={"TC4779_RiskAssignmentStandrdInsirerUser"})
	public void TC4779_RiskAssignmentStandrdInsirerUser()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4779_RiskAssignmentStandrdInsirerUser");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.RiskAssignmentRoleChange_Insurer();
			BProcessRPC.RiskAssignmentStandrdInsirerUser_TC4779();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4779_RiskAssignmentStandrdInsirerUser "+e.getMessage(), "FAIL");
		}finally{
			
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity Role - Risk Assignment - Standard - Insurer");
		videoRecordingStop();
	}

	
	@Test(priority = 650, groups={"TC4781_RiskAssignmentReadOnlyUser"})
	public void TC4781_RiskAssignmentReadOnlyUser()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4781_RiskAssignmentReadOnlyUser");
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Risk_Assignment");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4781_RiskAssignmentReadOnlyUser "+e.getMessage(), "FAIL");
		}finally{
			
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity Role - Risk Assignment - Read Only- Insurer");
		videoRecordingStop();
	}
	
	@Test(priority = 651, groups={"TC4789_RiskApprovalStandardInsurer"})
	public void TC4789_RiskApprovalStandardInsurer()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4789_RiskApprovalStandardInsurer");
			login.tideLogin(AdminUsername, AdminPassword);	
			BProcessRPC.RiskApprovalRoleChange_Insurer();
			BProcessRPC.riskApprovalStandardInsurer_TC4789();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4789_RiskApprovalStandardInsurer "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity Role - Risk Approval - Standard - Insurer");
		videoRecordingStop();
	} 
	
	@Test(priority = 652, groups={"TC4791_RiskApprovalReadOnlyInsurer"})
	public void TC4791_RiskApprovalReadOnlyInsurer()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4791_RiskApprovalReadOnlyInsurer");
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);		
			BProcessRPC.Read_Only_User_ActivityRole("Risk_Approval");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4791_RiskApprovalReadOnlyInsurer "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity Role - Risk Approval - Read Only - Insurer");
		videoRecordingStop();
	}
	
	
	@Test(priority = 653, groups={"TC4797_PremiumTransformationStandardInsurer"})
	public void TC4797_PremiumTransformationStandardInsurer()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4797_PremiumTransformationStandardInsurer");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.PremiumTransformationRoleChange_Insurer();
			BProcessRPC.premiumTransformationStandardInsurer_TC4797();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4797_PremiumTransformationStandardInsurer "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity Role - Premium Transformation - Standard - Insurer");
		videoRecordingStop();
	}
	
	@Test(priority = 654, groups={"TC4799_PremiumTransformationReadonlyInsurer"})
	public void TC4799_PremiumTransformationReadonlyInsurer()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4799_PremiumTransformationReadonlyInsurer");
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Premium_Transformation");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4799_PremiumTransformationReadonlyInsurer "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity Role - Premium Transformation - Read only - Insurer");
		videoRecordingStop();
	}
	
	@Test(priority = 655, groups={"TC4806_PremiumAssignmentStandardInsurer"})
	public void TC4806_PremiumAssignmentStandardInsurer()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4806_PremiumAssignmentStandardInsurer");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.PremiumAssignmentRoleChange_Insurer();
			BProcessRPC.premiumAssignmentStandardInsurer_TC4806();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4806_PremiumAssignmentStandardInsurer "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity role: Premium Assignment- Standard- Insurer");
		videoRecordingStop();
	} 
	
	@Test(priority = 656, groups={"TC4808_PremiumAssignmentReadOnlyInsurer"})
	public void TC4808_PremiumAssignmentReadOnlyInsurer()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4808_PremiumAssignmentReadOnlyInsurer");
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Premium_Assignment");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4808_PremiumAssignmentReadOnlyInsurer "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity role: Premium Assignment- Read Only- Insurer");
		videoRecordingStop();
	}
	
	@Test(priority = 657, groups={"TC4815_PremiumApprovalStandardInsurer"})
	public void TC4815_PremiumApprovalStandardInsurer()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4815_PremiumApprovalStandardInsurer");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.PremiumApprovalRoleChange_Insurer();
			BProcessRPC.premiumApprovalStandardInsurer_TC4815();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4815_PremiumApprovalStandardInsurer "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity Role - Premium Approval - Standard - Insurer");
		videoRecordingStop();
	}
	
	@Test(priority = 658, groups={"TC4817_PremiumApprovalReadOnlyInsurer"})
	public void TC4817_PremiumApprovalReadOnlyInsurer()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4817_PremiumApprovalReadOnlyInsurer");
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Premium_Approval");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4817_PremiumApprovalReadOnlyInsurer "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity Role - Premium Approval - Read Only - Insurer");
		videoRecordingStop();
	}
	
	@Test(priority = 659, groups={"TC4821_ClaimTransformationStandard_Insurer"})
	public void TC4821_ClaimTransformationStandard_Insurer()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4821_ClaimTransformationStandard_Insurer");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimTransformationStandard_Insurer_TC4821();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4821_ClaimTransformationStandard_Insurer "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity role: Contract Administrator -Standard User of Insurer");
		videoRecordingStop();
	}	
	@Test(priority = 660, groups={"TC4823_ClaimTransformation_ReadOnly_Insurer"})
	public void TC4823_ClaimTransformation_ReadOnly_Insurer()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4823_ClaimTransformation_ReadOnly_Insurer");
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Transformation");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4823_ClaimTransformation_ReadOnly_Insurer "+e.getMessage(), "FAIL");
		}finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity role: Contract Administrator -Read Only User of Insurer");
		videoRecordingStop();
	}
	@Test(priority = 661, groups={"TC4824_ClaimAssignment_Standard_Insurer"})
	public void TC4824_ClaimAssignment_Standard_Insurer()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4824_ClaimAssignment_Standard_Insurer");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimsAssignmentRoleChange_Insurer();
			BProcessRPC.ClaimAssignment_Standard_Insurer_TC4824();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4824_ClaimAssignment_Standard_Insurer "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity role: Contract Assignment -Standared User of Insurer");
		videoRecordingStop();
	}
	@Test(priority = 662, groups={"TC4826_ClaimAssignment_ReadOnly_Insurer"})
	public void TC4826_ClaimAssignment_ReadOnly_Insurer()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4826_ClaimAssignment_ReadOnly_Insurer");
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Assignment");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4826_ClaimAssignment_ReadOnly_Insurer "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity role: Contract Assignment - Read Only User of Insurer");
		videoRecordingStop();
	}
	@Test(priority = 663, groups={"TC4827_ClaimApproval_Standard_Insurer"})
	public void TC4827_ClaimApproval_Standard_Insurer()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4827_ClaimApproval_Standard_Insurer");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimsApprovalRoleChange_Insurer();
			BProcessRPC.ClaimApproval_Standard_Insurer_TC4827();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4827_ClaimApproval_Standard_Insurer"+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity role: Contract Approval - Standard User of Insurer");
		videoRecordingStop();
	}
	@Test(priority = 664, groups={"TC4829_ClaimApproval_ReadOnly_Insurer"})
	public void TC4829_ClaimApproval_ReadOnly_Insurer()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC4829_ClaimApproval_ReadOnly_Insurer");
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Approval");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4829_ClaimApproval_ReadOnly_Insurer "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Activity role: Claim Approval - Read Only User of Insurer");
		videoRecordingStop();
	}
	
	@Test(priority = 665, groups={"TC6621_Activity_Role_ContractAdmintrator_Standarduser_Broker"})
	public void TC6621_Activity_Role_ContractAdmintrator_Standarduser_Broker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6621_Activity_Role_ContractAdmintrator_Standarduser_Broker");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ChangeRole_CA_Broker();
			BProcessRPC.ContractRoleCA_Insurer();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4829_ClaimApproval_ReadOnly_Insurer "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6621_Activity_Role_ContractAdmintrator_Standarduser_Broker");
		videoRecordingStop();
	}

	@Test(priority = 666, groups={"TC6623_Activity_Role_ContractAdmintrator_Readonlyduser_Broker"})
	public void TC6623_Activity_Role_ContractAdmintrator_Readonlyduser_Broker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6623_Activity_Role_ContractAdmintrator_Readonlyduser_Broker");
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.ContractAdminStandrdUser_TC4515();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4829_ClaimApproval_ReadOnly_Insurer "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6623_Activity_Role_ContractAdmintrator_Readonlyduser_Broker");
		videoRecordingStop();
	}
	
	@Test(priority = 667, groups={"TC6633_ActivityRole_RiskTransformation_Standard_Broker"})
	public void TC6633_ActivityRole_RiskTransformation_Standard_Broker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6633_ActivityRole_RiskTransformation_Standard_Broker");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.Change_role_Broker_RiskTransformation();
			BProcessRPC.RiskInformationStandrdInsirerUser_TC4516();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TTC6633_ActivityRole_RiskTransformation_Standard_Broker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6633_ActivityRole_RiskTransformation_Standard_Broker");
		videoRecordingStop();
	}
	
	@Test(priority = 668, groups={"TC6634_ActivityRole_RiskTransformation_ReadOnly_Broker"})
	public void TC6634_ActivityRole_RiskTransformation_ReadOnly_Broker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6634_ActivityRole_RiskTransformation_ReadOnly_Broker");
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Risk_Transformation");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6634_ActivityRole_RiskTransformation_ReadOnly_Broker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6634_ActivityRole_RiskTransformation_ReadOnly_Broker");
		videoRecordingStop();
	}
	
	@Test(priority = 669, groups={"TC6635_ActivityRole_RiskAssignment_Standard_Broker"})
	public void TC6635_ActivityRole_RiskAssignment_Standard_Broker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6635_ActivityRole_RiskAssignment_Standard_Broker");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.RiskAssignmentRoleChange_Broker();
			BProcessRPC.RiskAssignmentStandrdInsirerUser_TC4779();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6635_ActivityRole_RiskAssignment_Standard_Broker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6635_ActivityRole_RiskAssignment_Standard_Broker");
		videoRecordingStop();
	}
	
	@Test(priority = 670, groups={"TC6636_ActivityRole_RiskAssignment_ReadOnly_Broker"})
	public void TC6636_ActivityRole_RiskAssignment_ReadOnly_Broker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6636_ActivityRole_RiskAssignment_ReadOnly_Broker");
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Risk_Assignment");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6636_ActivityRole_RiskAssignment_ReadOnly_Broker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6636_ActivityRole_RiskAssignment_ReadOnly_Broker");
		videoRecordingStop();
	}
	@Test(priority = 671, groups={"TC6637_ActivityRole_RiskApproval_Standard_Broker"})
	public void TC6637_ActivityRole_RiskApproval_Standard_Broker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6637_ActivityRole_RiskApproval_Standard_Broker");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.RiskApprovalRoleChange_Broker();
			BProcessRPC.riskApprovalStandardInsurer_TC4789();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6637_ActivityRole_RiskApproval_Standard_Broker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6637_ActivityRole_RiskApproval_Standard_Broker");
		videoRecordingStop();
	}
	
	@Test(priority = 672, groups={"TC6638_ActivityRole_RiskApproval_ReadOnly_Broker"})
	public void TC6638_ActivityRole_RiskApproval_ReadOnly_Broker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6638_ActivityRole_RiskApproval_ReadOnly_Broker");
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Risk_Approval");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6638_ActivityRole_RiskApproval_ReadOnly_Broker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6638_ActivityRole_RiskApproval_ReadOnly_Broker");
		videoRecordingStop();
	}
	
	@Test(priority = 673, groups={"TC6639_ActivityRole_PremiumTransformation_Standard_Broker"})
	public void TC6639_ActivityRole_PremiumTransformation_Standard_Broker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6639_ActivityRole_PremiumTransformation_Standard_Broker");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.PremiumTransformationRoleChange_Broker();
			BProcessRPC.premiumTransformationStandardInsurer_TC4797();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6639_ActivityRole_PremiumTransformation_Standard_Broker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6639_ActivityRole_PremiumTransformation_Standard_Broker");
		videoRecordingStop();
	}
	
	@Test(priority = 674, groups={"TC6640_ActivityRole_PremiumTransformation_ReadOnly_Broker"})
	public void TC6640_ActivityRole_PremiumTransformation_ReadOnly_Broker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6640_ActivityRole_PremiumTransformation_ReadOnly_Broker");
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Premium_Transformation");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6640_ActivityRole_PremiumTransformation_ReadOnly_Broker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6640_ActivityRole_PremiumTransformation_ReadOnly_Broker");
		videoRecordingStop();
	}
	
	@Test(priority = 675, groups={"TC6641_ActivityRole_PremiumAssignment_Standard_Broker"})
	public void TC6641_ActivityRole_PremiumAssignment_Standard_Broker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6641_ActivityRole_PremiumAssignment_Standard_Broker");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.PremiumAssignmentRoleChange_Broker();
			BProcessRPC.premiumAssignmentStandardInsurer_TC4806();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6641_ActivityRole_PremiumAssignment_Standard_Broker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6641_ActivityRole_PremiumAssignment_Standard_Broker");
		videoRecordingStop();
	}
	
	@Test(priority = 676, groups={"TC6642_ActivityRole_PremiumAssignment_ReadOnly_Broker"})
	public void TC6642_ActivityRole_PremiumAssignment_ReadOnly_Broker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6642_ActivityRole_PremiumAssignment_ReadOnly_Broker");
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Premium_Assignment");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6642_ActivityRole_PremiumAssignment_ReadOnly_Broker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6642_ActivityRole_PremiumAssignment_ReadOnly_Broker");
		videoRecordingStop();
	}
	
	@Test(priority = 677, groups={"TC6643_ActivityRole_PremiumApproval_Standard_Broker"})
	public void TC6643_ActivityRole_PremiumApproval_Standard_Broker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6643_ActivityRole_PremiumApproval_Standard_Broker");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.PremiumApprovalRoleChange_Broker();
			BProcessRPC.premiumApprovalStandardInsurer_TC4815();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6643_ActivityRole_PremiumApproval_Standard_Broker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6643_ActivityRole_PremiumApproval_Standard_Broker");
		videoRecordingStop();
	}
	
	@Test(priority = 678, groups={"TC6644_ActivityRole_PremiumApproval_ReadOnly_Broker"})
	public void TC6644_ActivityRole_PremiumApproval_ReadOnly_Broker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6644_ActivityRole_PremiumApproval_ReadOnly_Broker");
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Premium_Approval");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6644_ActivityRole_PremiumApproval_ReadOnly_Broker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6644_ActivityRole_PremiumApproval_ReadOnly_Broker");
		videoRecordingStop();
	}
	@Test(priority = 679, groups={"TC6645_ActivityRole_ClaimsTransformation_Standard_Broker"})
	public void TC6645_ActivityRole_ClaimsTransformation_Standard_Broker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6645_ActivityRole_ClaimsTransformation_Standard_Broker");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimsTransformationRoleChange_Broker();
			BProcessRPC.ClaimTransformationStandard_Insurer_TC4821();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6645_ActivityRole_ClaimsTransformation_Standard_Broker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6645_ActivityRole_ClaimsTransformation_Standard_Broker");
		videoRecordingStop();
	}
	
	@Test(priority = 678, groups={"TC6646_ActivityRole_ClaimsTransformation_ReadOnly_Broker"})
	public void TC6646_ActivityRole_ClaimsTransformation_ReadOnly_Broker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6646_ActivityRole_ClaimsTransformation_ReadOnly_Broker");
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Transformation");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6646_ActivityRole_ClaimsTransformation_ReadOnly_Broker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6646_ActivityRole_ClaimsTransformation_ReadOnly_Broker");
		videoRecordingStop();
	}
	@Test(priority = 679, groups={"TC6647_ActivityRole_ClaimAssignment_Standard_Broker"})
	public void TC6647_ActivityRole_ClaimAssignment_Standard_Broker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6647_ActivityRole_ClaimAssignment_Standard_Broker");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimsAssignmentRoleChange_Broker();
			BProcessRPC.ClaimAssignment_Standard_Insurer_TC4824();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6647_ActivityRole_ClaimAssignment_Standard_Broker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6647_ActivityRole_ClaimAssignment_Standard_Broker");
		videoRecordingStop();
	}
	
	@Test(priority = 680, groups={"TC6648_ActivityRole_ClaimAssignment_ReadOnly_Broker"})
	public void TC6648_ActivityRole_ClaimAssignment_ReadOnly_Broker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6648_ActivityRole_ClaimAssignment_ReadOnly_Broker");
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Assignment");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6648_ActivityRole_ClaimAssignment_ReadOnly_Broker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6648_ActivityRole_ClaimAssignment_ReadOnly_Broker");
		videoRecordingStop();
	}
	@Test(priority = 681, groups={"TC6649_ActivityRole_ClaimApproval_Standard_Broker"})
	public void TC6649_ActivityRole_ClaimApproval_Standard_Broker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6649_ActivityRole_ClaimApproval_Standard_Broker");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimsApprovalRoleChange_Broker();
			BProcessRPC.ClaimApproval_Standard_Insurer_TC4827();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6649_ActivityRole_ClaimApproval_Standard_Broker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6649_ActivityRole_ClaimApproval_Standard_Broker");
		videoRecordingStop();
	}
	
	@Test(priority = 682, groups={"TC6650_ActivityRole_ClaimApproval_ReadOnly_Broker"})
	public void TC6650_ActivityRole_ClaimApproval_ReadOnly_Broker()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6650_ActivityRole_ClaimApproval_ReadOnly_Broker");
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Approval");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6650_ActivityRole_ClaimApproval_ReadOnly_Broker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6650_ActivityRole_ClaimApproval_ReadOnly_Broker");
		videoRecordingStop();
	}
	
	//*******************************************************************Coverholder************************************************************
	
	
	@Test(priority = 683, groups={"TC6653_ActivityRole_RiskTransformation_Standard_Coverholderr"})
	public void TC6653_ActivityRole_RiskTransformation_Standard_Coverholderr()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6653_ActivityRole_RiskTransformation_Standard_Coverholderr");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.Change_role_Coverholder_RiskTransformation();
			BProcessRPC.RiskInformationStandrdInsirerUser_TC4516();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6653_ActivityRole_RiskTransformation_Standard_Coverholderr "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6653_ActivityRole_RiskTransformation_Standard_Coverholderr");
		videoRecordingStop();
	}
	
	@Test(priority = 684, groups={"TC6654_ActivityRole_RiskTransformation_ReadOnly_Coverholder"})
	public void TC6654_ActivityRole_RiskTransformation_ReadOnly_Coverholder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6654_ActivityRole_RiskTransformation_ReadOnly_Coverholder");
			
			login.tideLogin(CoverholderRead, CoverholderReadPass);
			BProcessRPC.Read_Only_User_ActivityRole("Risk_Transformation");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6654_ActivityRole_RiskTransformation_ReadOnly_Coverholder "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6654_ActivityRole_RiskTransformation_ReadOnly_Coverholder");
		videoRecordingStop();
	}
	
	@Test(priority = 685, groups={"TC6655_ActivityRole_RiskAssignment_Standard_Coverholder"})
	public void TC6655_ActivityRole_RiskAssignment_Standard_Coverholder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6655_ActivityRole_RiskAssignment_Standard_Coverholder");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.RiskAssignmentRoleChange_Coverholder();
			BProcessRPC.RiskAssignmentStandrdInsirerUser_TC4779();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6655_ActivityRole_RiskAssignment_Standard_Coverholder "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6655_ActivityRole_RiskAssignment_Standard_Coverholder");
		videoRecordingStop();
	}
	
	@Test(priority = 686, groups={"TC6656_ActivityRole_RiskAssignment_ReadOnly_Coverholder"})
	public void TC6656_ActivityRole_RiskAssignment_ReadOnly_Coverholder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6656_ActivityRole_RiskAssignment_ReadOnly_Coverholder");
			login.tideLogin(CoverholderRead, CoverholderReadPass);
			BProcessRPC.Read_Only_User_ActivityRole("Risk_Assignment");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6656_ActivityRole_RiskAssignment_ReadOnly_Coverholder "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6656_ActivityRole_RiskAssignment_ReadOnly_Coverholder");
		videoRecordingStop();
	}
	@Test(priority = 687, groups={"TC6657_ActivityRole_RiskApproval_Standard_Coverholder"})
	public void TC6657_ActivityRole_RiskApproval_Standard_Coverholder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6657_ActivityRole_RiskApproval_Standard_Coverholder");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.RiskApprovalRoleChange_Broker();
			BProcessRPC.riskApprovalStandardInsurer_TC4789();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6657_ActivityRole_RiskApproval_Standard_Coverholder "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6657_ActivityRole_RiskApproval_Standard_Coverholder");
		videoRecordingStop();
	}
	
	@Test(priority = 688, groups={"TC6658_ActivityRole_RiskApproval_ReadOnly_Coverholder"})
	public void TC6658_ActivityRole_RiskApproval_ReadOnly_Coverholder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6658_ActivityRole_RiskApproval_ReadOnly_Coverholder");
			login.tideLogin(CoverholderRead, CoverholderReadPass);
			BProcessRPC.Read_Only_User_ActivityRole("Risk_Approval");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6658_ActivityRole_RiskApproval_ReadOnly_Coverholder "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6658_ActivityRole_RiskApproval_ReadOnly_Coverholder");
		videoRecordingStop();
	}
	
	@Test(priority = 689, groups={"TC6659_ActivityRole_PremiumTransformation_Standard_Coverholder"})
	public void TC6659_ActivityRole_PremiumTransformation_Standard_Coverholder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6659_ActivityRole_PremiumTransformation_Standard_Coverholder");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.PremiumTransformationRoleChange_Coverholder();
			BProcessRPC.premiumTransformationStandardInsurer_TC4797();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6659_ActivityRole_PremiumTransformation_Standard_Coverholder "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6659_ActivityRole_PremiumTransformation_Standard_Coverholder");
		videoRecordingStop();
	}
	
	@Test(priority = 690, groups={"TC6660_ActivityRole_PremiumTransformation_ReadOnly_Coverholder"})
	public void TC6660_ActivityRole_PremiumTransformation_ReadOnly_Coverholder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6660_ActivityRole_PremiumTransformation_ReadOnly_Coverholder");
			login.tideLogin(CoverholderRead, CoverholderReadPass);
			BProcessRPC.Read_Only_User_ActivityRole("Premium_Transformation");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6660_ActivityRole_PremiumTransformation_ReadOnly_Coverholder "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6660_ActivityRole_PremiumTransformation_ReadOnly_Coverholder");
		videoRecordingStop();
	}
	
	@Test(priority = 691, groups={"TC6661_ActivityRole_PremiumAssignment_Standard_Coverholder"})
	public void TC6661_ActivityRole_PremiumAssignment_Standard_Coverholder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6641_ActivityRole_PremiumAssignment_Standard_Broker");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.PremiumAssignmentRoleChange_Coverholder();
			BProcessRPC.premiumAssignmentStandardInsurer_TC4806();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6641_ActivityRole_PremiumAssignment_Standard_Broker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6641_ActivityRole_PremiumAssignment_Standard_Broker");
		videoRecordingStop();
	}
	
	@Test(priority = 692, groups={"TC6662_ActivityRole_PremiumAssignment_ReadOnly_Coverholder"})
	public void TC6662_ActivityRole_PremiumAssignment_ReadOnly_Coverholder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6662_ActivityRole_PremiumAssignment_ReadOnly_Coverholder");
			login.tideLogin(CoverholderRead, CoverholderReadPass);
			BProcessRPC.Read_Only_User_ActivityRole("Premium_Assignment");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6662_ActivityRole_PremiumAssignment_ReadOnly_Coverholder "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6662_ActivityRole_PremiumAssignment_ReadOnly_Coverholder");
		videoRecordingStop();
	}
	
	@Test(priority = 693, groups={"TC6663_ActivityRole_PremiumApproval_Standard_Coverholder"})
	public void TC6663_ActivityRole_PremiumApproval_Standard_Coverholder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6663_ActivityRole_PremiumApproval_Standard_Coverholder");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.PremiumApprovalRoleChange_Coverholder();
			BProcessRPC.premiumApprovalStandardInsurer_TC4815();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6663_ActivityRole_PremiumApproval_Standard_Coverholder "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6663_ActivityRole_PremiumApproval_Standard_Coverholder");
		videoRecordingStop();
	}
	
	@Test(priority = 694, groups={"TC6664_ActivityRole_PremiumApproval_ReadOnly_Coverholder"})
	public void TC6664_ActivityRole_PremiumApproval_ReadOnly_Coverholder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6664_ActivityRole_PremiumApproval_ReadOnly_Coverholder");
			login.tideLogin(CoverholderRead, CoverholderReadPass);
			BProcessRPC.Read_Only_User_ActivityRole("Premium_Approval");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6664_ActivityRole_PremiumApproval_ReadOnly_Coverholder "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6664_ActivityRole_PremiumApproval_ReadOnly_Coverholder");
		videoRecordingStop();
	}
	@Test(priority = 695, groups={"TC6665_ActivityRole_ClaimsTransformation_Standard_Coverholder"})
	public void TC6665_ActivityRole_ClaimsTransformation_Standard_Coverholder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6665_ActivityRole_ClaimsTransformation_Standard_Coverholder");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimsTransformationRoleChange_Coverholder();
			BProcessRPC.ClaimTransformationStandard_Insurer_TC4821();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6665_ActivityRole_ClaimsTransformation_Standard_Coverholder "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6665_ActivityRole_ClaimsTransformation_Standard_Coverholder");
		videoRecordingStop();
	}
	
	@Test(priority = 696, groups={"TC6671_ActivityRole_ClaimsTransformation_ReadOnly_Coverholder"})
	public void TC6671_ActivityRole_ClaimsTransformation_ReadOnly_Coverholder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6671_ActivityRole_ClaimsTransformation_ReadOnly_Coverholder");
			login.tideLogin(CoverholderRead, CoverholderReadPass);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Transformation");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6671_ActivityRole_ClaimsTransformation_ReadOnly_Coverholder "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6671_ActivityRole_ClaimsTransformation_ReadOnly_Coverholder");
		videoRecordingStop();
	}
	@Test(priority = 697, groups={"TC6666_ActivityRole_ClaimAssignment_Standard_Coverholder"})
	public void TC6666_ActivityRole_ClaimAssignment_Standard_Coverholder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6666_ActivityRole_ClaimAssignment_Standard_Coverholder");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimsAssignmentRoleChange_Coverholder();
			BProcessRPC.ClaimAssignment_Standard_Insurer_TC4824();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6666_ActivityRole_ClaimAssignment_Standard_Coverholder "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6666_ActivityRole_ClaimAssignment_Standard_Coverholder");
		videoRecordingStop();
	}
	
	@Test(priority = 698, groups={"TC6667_ActivityRole_ClaimAssignment_ReadOnly_Coverholder"})
	public void TC6667_ActivityRole_ClaimAssignment_ReadOnly_Coverholder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6667_ActivityRole_ClaimAssignment_ReadOnly_Coverholder");
			login.tideLogin(CoverholderRead, CoverholderReadPass);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Assignment");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6667_ActivityRole_ClaimAssignment_ReadOnly_Coverholder "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6667_ActivityRole_ClaimAssignment_ReadOnly_Coverholder");
		videoRecordingStop();
	}
	@Test(priority = 699, groups={"TC668_ActivityRole_ClaimApproval_Standard_Coverholder"})
	public void TC668_ActivityRole_ClaimApproval_Standard_Coverholder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC668_ActivityRole_ClaimApproval_Standard_Coverholder");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimsApprovalRoleChange_Coverholder();
			BProcessRPC.ClaimApproval_Standard_Insurer_TC4827();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC668_ActivityRole_ClaimApproval_Standard_Coverholder "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC668_ActivityRole_ClaimApproval_Standard_Coverholder");
		videoRecordingStop();
	}
	
	@Test(priority = 700, groups={"TC6650_ActivityRole_ClaimApproval_ReadOnly_Broker"})
	public void TC6669_ActivityRole_ClaimApproval_ReadOnly_Coverholder()
	{
		Report.createTestCaseReportHeader();
		try
		{
			videoRecordingStart("TC6650_ActivityRole_ClaimApproval_ReadOnly_Broker");
			login.tideLogin(CoverholderRead, CoverholderReadPass);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Approval");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6650_ActivityRole_ClaimApproval_ReadOnly_Broker "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("TC6650_ActivityRole_ClaimApproval_ReadOnly_Broker");
		videoRecordingStop();
	}
	
}