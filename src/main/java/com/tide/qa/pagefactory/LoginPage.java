package com.tide.qa.pagefactory;



import org.openqa.selenium.Keys;

import org.openqa.selenium.interactions.Actions;

import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.PageBase;

import com.tide.qa.utility.Report;

public class LoginPage extends PageBase
{
	GlobalVariables globalVar;

	//Element Locators
	public static final String Username = "@name=username";
	public static final String Password = "@name=password";

	//Logout
	public static final String TideAdminLink = "@xpath=//*[@id='header']//span[@class='clearfix']/span[contains(.,'Tide Admin')]";
	public static final String CompanyAdminLink = "@xpath=//*[@id='header']//span[@class='clearfix']/span[contains(.,'Company Admin')]";
	public static final String LogoutLink = "@xpath=//*[@id='header']//a[contains(.,'Log Out')]";
	public static final String Profilecircle = "@xpath=//li[@ng-if='authentication.authenticated']";

	public void tideLogin(String UName, String Pass) throws InterruptedException
	{
		Actions action = new Actions(webDriver);

		verifyMustExists(Username,"Username Field");
		//sendKeys(Username, globalVar.getLoginUsername(), "Username Field (Valid Input).");
		sendKeys(Username, UName, "Username Field (Valid Input).");

		verifyMustExists(Password,"Password Field");
		//sendKeys(Password, globalVar.getLoginPassword(), "Password Field (Valid Input).");
		sendKeys(Password, Pass, "Password Field (Valid Input).");
		sleep(2000);
		action.sendKeys(Keys.ENTER).build().perform();
		sleep(2000);
		javaScriptWait();
		sleep(2000);

		String PageTile = webDriver.getTitle();
		String ExpctTitle = "Home";
		if(PageTile.contains(ExpctTitle))
		{
			Report.LogInfo("ValidLoginTest", "User logged in successfully and landed on home page.", "PASS");
		}else{
			Report.LogInfo("ValidLoginTest", "Something went wrong while logging into applcation, user did not land on home page.", "FAIL");
		}

	}

	public void tideAdminLogOut()
	{
		verifyMustExists(TideAdminLink,"Tide Admin Link");
		click(TideAdminLink,"Tide Admin Link");
		verifyMustExists(LogoutLink,"LogOut Link");
		click(LogoutLink,"LogOut Link");
	}

	public void tideCompanyAdminLogOut()
	{
		verifyMustExists(CompanyAdminLink,"Company Admin Link");
		click(CompanyAdminLink,"Company Admin Link");
		verifyMustExists(LogoutLink,"LogOut Link");
		click(LogoutLink,"LogOut Link");
	}

	public void tideReadOnlyLogOut()
	{
		verifyMustExists(Profilecircle,"Admin Link");
		click(Profilecircle,"Admin Link");
		verifyMustExists(LogoutLink,"LogOut Link");
		click(LogoutLink,"LogOut Link");
	}


}