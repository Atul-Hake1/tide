package com.tide.qa.pagefactory;

import com.tide.qa.common.PageBase;

public class HomePage extends PageBase{

	//Element Locators
	public static final String adminDropdown = "@css=.dropdown.ng-scope.dropdown-toggle";

	public void adminMenu() throws InterruptedException
	{
		sleep(2000);
		verifyMustExists(adminDropdown,"Admin Dropdown");
		click(adminDropdown,"Admin Dropdown");
	}
}
