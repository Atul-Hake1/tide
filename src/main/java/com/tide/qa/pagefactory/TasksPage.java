package com.tide.qa.pagefactory;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.server.handler.SendKeys;

import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Report;

public class TasksPage extends PageBase{

	LoginPage loginPage = new LoginPage();

	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MsMMssdd");
		String datetime = ft.format(dNow);
		return datetime;
	}
	String TaskTitle = "AutomationTask"+getCurrentDateTimeMS();

	public static final String TasksTab = "@xpath=//a[contains(.,'TASKS')]";
	public static final String AddToDoItem ="@xpath=//div[@ng-click='openAddPopup()']";
	public static final String Title="@model=data.Title";
	public static final String Description="@model=data.Description";
	public static final String selectCurrentOwner="@xpath=//div[@class='modal-content']//descendant::*[@class='k-input ng-scope'][1]";
	public static final String CurrentOwnerdrpValue="@xpath=//*[@class='k-list k-reset']//*[text()='Abhi, Standard (Charles Taylor InsureTech - Charles Taylor InsureTech - Development)']";
	public static final String selectType="@xpath=//div[@class='modal-content']//descendant::*[@class='k-input ng-scope'][2]";
	public static final String TypedrpValue="@xpath=//ul[@class='k-list k-reset']//*[text()='Action']";
	public static final String selectStatus="@xpath=//div[@class='modal-content']//descendant::*[@class='k-input ng-scope'][3]";
	public static final String StatusdrpValue="@xpath=//*[@class='k-list k-reset']//*[text()='Open']";
	public static final String ViewTime="@css=.k-icon.k-i-clock";
	public static final String ViewDate="@xpath=//*[@class='k-icon k-i-calendar']";
	public static final String TodayDate="@css=.k-link.k-nav-today";
	public static final String Savebutton="@xpath=//button[contains(text(),'Save')]";

	//Task Filter
	public static final String TitleFilter ="@xpath=//th[@data-title='Title']//a//span";
	public static final String SearchFilterTxt ="@css=[placeholder='Search']";
	public static final String FilterBtn="@buttonText=Filter";
	public static final String ClearBtn="@buttonText=Clear";

	//Task Title after filter
	public static final String FilteredTaskName="@css=table.k-selectable tbody tr.ng-scope:first-child td:nth-of-type(3)";

	//Edit Tasks
	public static final String EditTask="@xpath=//*[@ng-click='editData(dataItem)']";
	public static final String EditCurrentOwner="@css=#addEditCurrentOwner"; 
	public static final String EditCurrentOwnerdrpValue="@xpath=//*[@class='k-list k-reset']//*[text()='Jones, Standard (Coverholder Inc - Coverholder Inc - New York)']";
	public static final String AddNewNote="@css=.btn.btn-primary.p-lr-lg.pull-right.waves-effect.waves-light";
	public static final String EditViewDate="@xpath=//*[@class='k-icon k-i-calendar']";
	public static final String EditTodayDate="@css=.k-link.k-nav-today";
	public static final String EditSaveChanges="@xpath=//button[contains(text(),'Save Changes')]";
	public static final String EditedCurrentOwner="@css=.ng-scope.k-state-selected>td:nth-child(4)";
	String currentOwner= "Tide Admin";

	//Test case 3187 :- Add Tasks
	public void addTasks() throws InterruptedException
	{
		navigationOnTasksTab();
		navigationOnAddToDoItemPopup();
		addTaskDetails();
	}

	//Test case 3188 :- Edit Tasks
	public void EditTasksDetails() throws InterruptedException
	{
		navigationOnTasksTab();
		applyTaskNameFilter();
		sleep(3000);
		verifyMustExists(EditTask,"Edit button");
		click(EditTask,"Edit button");
		sleep(2000);
		waitForElementToAppear(Title,10);
		SelectDropDownValue(EditCurrentOwner,EditCurrentOwnerdrpValue);
		/*verifyMustExists(EditCurrentOwner,"Current Owner dropdown");
		click(EditCurrentOwner,"Current Owner dropdown");
		verifyMustExists(EditCurrentOwnerdrpValue,"Current owner dropdown value");
		click(EditCurrentOwnerdrpValue,"Current owner dropdown value");*/
		verifyMustExists(EditViewDate,"Date picker");
		click(EditViewDate,"Date picker");
		verifyMustExists(EditTodayDate,"Todays date");
		click(EditTodayDate,"Todays date");
		verifyMustExists(EditSaveChanges,"Save button");
		click(EditSaveChanges,"Save button");
	}

	public void navigationOnTasksTab() throws InterruptedException
	{
		verifyMustExists(TasksTab,"Tasks tab");
		click(TasksTab,"Tasks tab");
		sleep(2000);
	}

	public void navigationOnAddToDoItemPopup() throws InterruptedException
	{
		verifyMustExists(AddToDoItem,"Add To Do Item popup");
		click(AddToDoItem,"Add To Do Item button");
	}
	public void addTaskDetails() throws InterruptedException
	{
		waitForElementToAppear(Title,10);
		verifyMustExists(Title,"Title");
		sendKeys(Title,TaskTitle,"Title field.");
		//Thread.sleep(1000);
		verifyMustExists(Description,"Description");
		sendKeys(Description,"Prepare smoke Test cases","Description field.");
		//Thread.sleep(1000);

		SelectDropDownValue(selectCurrentOwner,CurrentOwnerdrpValue);

		SelectDropDownValue(selectType,TypedrpValue);

		SelectDropDownValue(selectStatus,StatusdrpValue);

		verifyMustExists(ViewDate,"Date picker");
		click(ViewDate,"Date picker");
		//Thread.sleep(1000);
		verifyMustExists(TodayDate,"Todays date");
		click(TodayDate,"Todays date");
		//Thread.sleep(2000);
		verifyMustExists(Savebutton,"Save button");
		click(Savebutton,"Save button");
		//Thread.sleep(3000);

	}	

	public void applyTaskNameFilter()
	{
		int i=0;
		String RecordCheckbox ="@xpath=//li//span[contains(text(),'"+TaskTitle+"')]";
		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				waitForElementToAppear(TitleFilter,5);
			}
			clickAndWait(TitleFilter, "Title Filter");
			sleep(2000);
			if(isVisible(SearchFilterTxt))
			{
				verifyMustExists(SearchFilterTxt,"Search Filter Textbox");	
				sendKeys(SearchFilterTxt,TaskTitle,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(FilterBtn) && i<5);

		if(isVisible(RecordCheckbox))
		{
			click(RecordCheckbox, "Searched Task Record Checkbox");
			verifyMustExists(FilterBtn,"Filter Button");	
			click(FilterBtn,"Filter Button");
			verifyExists(FilteredTaskName,"Searched Task Record.");
		}else
		{
			Report.LogInfo("TaskRecord","Searched Task Record not found after entering details in filter textbox.", "FAIL");
		}

	}

}