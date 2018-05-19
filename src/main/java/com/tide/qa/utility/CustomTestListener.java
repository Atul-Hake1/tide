package com.tide.qa.utility;

import java.util.List;

import org.testng.IInvokedMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.tide.qa.common.PageBase;


public class CustomTestListener extends TestListenerAdapter{

	private static int numberPassed = 0;
	private static int numberFailed = 0;
	private static int numberSkipped = 0;
	private static int beforeMethodRun = 0;
	private static int afterMethodRun = 0;

	private static void outputTestRunStatus () {
		PageBase.info("\n\t\tTotal tests run so far: " + (numberPassed + numberFailed + numberSkipped) + ", PASSED: " + numberPassed + ", FAILED: " + numberFailed + ", SKIPPED: " + numberSkipped);
		PageBase.info("\t\tTotal setup methods run so far: " + beforeMethodRun);
		PageBase.info("\t\tTotal tearDown methods run so far: " + afterMethodRun);
		PageBase.info ("\n--------------------------------------------------------------------------------------\n");
	}

	public static void updateBeforeMethodConfigurationStatus () {
		beforeMethodRun++;
	}

	public static void updateAfterMethodConfigurationStatus () {
		afterMethodRun++;
		//        outputTestRunStatus();
	}

	@Override
	public void beforeInvocation (IInvokedMethod method, ITestResult result) {
		if (method.isTestMethod())
		{
			PageBase.info ("\n-----------------------------------------------------------");
			PageBase.info ("\nRunning Test: " + method.getTestMethod().getMethodName());
			PageBase.info ("\n-----------------------------------------------------------");
			super.beforeInvocation(method, result);
		}
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult result) {

		Reporter.setCurrentTestResult(result);


		if (method.isTestMethod())
		{
			List<Throwable> verificationFailures = PageBase.getVerificationFailures();

			PageBase.info("\nCompleted Test: " + method.getTestMethod().getMethodName());

			//if there are verification failures...
			if (verificationFailures.size() > 0) {
				PageBase.info ("\n\tStatus: FAILED");

				PageBase.info ("\n-----------------------------------------------------------");
				numberFailed++ ;
				//set the tests to failed
				result.setStatus(ITestResult.FAILURE);

				//if there is an assertion failure add it to verificationFailures
				if (result.getThrowable() != null) {
					verificationFailures.add(result.getThrowable());
				}

				int size = verificationFailures.size();
				//if there's only one failure just set that
				if (size == 1) {
					result.setThrowable(verificationFailures.get(0));
				} else {
					//create a failure message with all failures and stack traces (except last failure)
					StringBuffer failureMessage = new StringBuffer("Multiple failures (").append(size).append("):\n\n");
					for (int i = 0; i < size-1; i++) {
						failureMessage.append("Failure ").append(i+1).append(" of ").append(size).append(":\n");
						Throwable t = verificationFailures.get(i);
						//String fullStackTrace = Utils.stackTrace(t, false)[1];
						String fullStackTrace = t.getMessage();
						failureMessage.append(fullStackTrace).append("\n, ");
					}

					//final failure
					Throwable last = verificationFailures.get(size-1);
					failureMessage.append("Failure ").append(size).append(" of ").append(size).append(":\n");
					failureMessage.append(last.toString());

					//set merged throwable
					Throwable merged = new Throwable(failureMessage.toString());
					merged.setStackTrace(last.getStackTrace());
					result.setThrowable(merged);
				}
			}

			else if (result.getStatus() == 1)
			{

				PageBase.info ("\n\t\tStatus: PASSED");
				//                Common.log("Status: PASSED");
				PageBase.info ("\n-----------------------------------------------------------");
				numberPassed++;
			}
			else if (result.getStatus() == 2)
			{
				PageBase.info ("\n\t\tStatus: FAILED");
				//                Common.log("Status: FAILED");
				PageBase.info ("\n-----------------------------------------------------------");
				numberFailed++;
			}
			else if (result.getStatus() == 3)
			{
				PageBase.info ("\n\t\tStatus: SKIPPED");
				//                Common.log("Status: SKIPPED");
				PageBase.info ("\n-----------------------------------------------------------");
				numberSkipped++;
			}
			//outputTestRunStatus();
		}
	}
}
