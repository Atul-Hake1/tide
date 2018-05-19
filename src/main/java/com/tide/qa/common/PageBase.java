package com.tide.qa.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;

import com.jprotractor.NgBy;
import com.tide.qa.utility.RecordVideo;
import com.tide.qa.utility.Report;
import com.tide.qa.utility.TideSSLSocketFactory;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;


public class PageBase extends TestBase
{
	private final long waitForWebElementTimeOut = 35000l;
	private final long waitForWebElementNotExistTimeOut = 1l;
	public static final String loading = "@xpath=//*[@id='loading-bar-spinner']/div[@class='spinner']";
	GlobalVariables g =new GlobalVariables();

	public void goBack()
	{
		webDriver.navigate().back();
	}

	public void refreshPage()
	{	
		webDriver.navigate().refresh();	
		waitForSpinnerDisable();
		waitForPageLoad();
	}

	public String getTitleOfAnotherWindow(String currentHandle)
	{
		for (String handle : webDriver.getWindowHandles()) 
		{

			if (!currentHandle.equals(handle))
			{
				return webDriver.switchTo().window(handle).getTitle();
			}
		}
		return currentHandle; 
	}



	/**
	 * MouseHover on specified locator
	 * Example
	 * 
	 * @param locator
	 * @throws Exception
	 */
	public void mouseOverAction(String locator) {
		WebElement element = findWebElement(locator);

		new Actions(webDriver).moveToElement(element).build().perform();
		//log.debug("Move mouse on locator [element='"+element+"']");
		//	info("Move mouse on locator [locator='"+locator+"']");
		//log.trace("Exiting method mouseOver");
	}


	public void mouseOver(String locator)
	{
		try
		{
			WebElement element = findWebElement(locator);
			Locatable hoverItem = (Locatable) element;
			Report.LogInfo("MouseOver","Mouse over on "+locator +" is done Successfully", "INFO");

		}catch(Exception e)
		{

			Report.LogInfo("MouseOver",locator +" Is not Present on Screen", "FAIL");
		}
	}

	/**
	 * click on specified locator
	 * Example
	 * 
	 * @param locator
	 * @throws Exception
	 */
	public void click(String locator) 
	{
		try
		{
			WebElement element = findWebElement(locator);
			if(g.getBrowser().trim().equalsIgnoreCase("IE"))
			{
				((JavascriptExecutor)webDriver).executeScript("arguments[0].click();",  element);

			}
			else
			{
				element.click();
			}
			locator = element.getAttribute("id");
			Report.LogInfo("Click","\""+locator +"\" Is Clicked Successfully", "INFO");
		}catch(Exception e)
		{
			Report.LogInfo("Click","<font color=red>"+locator +" Is not Present on Screen</font>", "INFO");
			refreshPage();
		}
	}
	public void javaScriptclick(String locator) 
	{
		waitForSpinnerDisable();
		try
		{
			WebElement element = findWebElement(locator);
			((JavascriptExecutor)webDriver).executeScript("arguments[0].click();",  element);

			Report.LogInfo("Click","\""+locator +"\" Is Clicked Successfully", "INFO");
		}catch(Exception e)
		{
			Report.LogInfo("Click",locator +" Is not Present on Screen", "FAIL");
		}
	}

	public void javaScriptclick(String locator,String Object) 
	{
		waitForSpinnerDisable();
		try
		{
			WebElement element = findWebElement(locator);
			((JavascriptExecutor)webDriver).executeScript("arguments[0].click();",  element);

			Report.LogInfo("Click","<b><i>"+Object +"</i></b> : Object Is Clicked Successfully", "INFO");
		}catch(Exception e)
		{
			Report.LogInfo("Click",Object +" :Object is not Present on Screen", "FAIL");
			refreshPage();
		}
	}

	public void click(String locator,String ObjectName) 
	{
		waitForSpinnerDisable();
		try
		{
			waitForPageLoad();
			WebElement element = findWebElement(locator);
			WebDriverWait wait = new WebDriverWait(webDriver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.until(angularHasFinishedProcessing());
			if(g.getBrowser().trim().equalsIgnoreCase("IE"))
			{
				JavascriptExecutor js = (JavascriptExecutor) webDriver;
				((JavascriptExecutor)webDriver).executeScript("arguments[0].click();",  element);
				Report.LogInfo("click","<b><i>"+ObjectName +"</i></b> - Is Clicked Successfully", "INFO");	

			}
			else
			{
				element.click();
				Report.LogInfo("click","<b><i>"+ObjectName +"</i></b> - Is Clicked Successfully", "INFO");
			}

		}catch(Exception e)
		{
			Report.LogInfo("click","<font color=red"+ObjectName +" - Is not Present on Screen</font>", "INFO");
			refreshPage();
		}
	}


	public void clickAndWait(String locator,String ObjectName) 
	{
		try
		{
			WebElement element = findWebElement(locator);
			element.click();
			javaScriptWait();
			Report.LogInfo("click",ObjectName +" - Is Clicked Successfully", "INFO");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in clickAndWait "+e.getMessage(), "FAIL");
		}
	}


	/**
	 * doubleClick on specified locator
	 * Example
	 * 
	 * @param locator
	 * @throws Exception
	 */
	public void doubleClick(String locator) 
	{
		webDriver.manage().timeouts().setScriptTimeout(waitForWebElementTimeOut, TimeUnit.MILLISECONDS);
		//log.trace("Entering method doubleClick [locator="+locator+"]");
		Report.LogInfo("dobuleClick",locator +" Is Double Clicked Successfully", "INFO");
		WebElement element = findWebElement(locator);

		//log.debug("Found element for locator [element='"+element+"']");
		new Actions(webDriver).moveToElement(element).doubleClick();		
		//info("Click on locator [locator='"+locator+"']");
		//log.trace("Exiting method doubleClick");
	}


	/**
	 * submit on specified locator
	 * Example
	 * 
	 * @param locator
	 * @throws Exception
	 */
	public void submit(String locator)
	{
		try
		{
			WebElement element = findWebElement(locator);
			element.submit();
			Report.LogInfo("submit",locator +" Is Submitted Successfully", "INFO");

		}catch(Exception e)
		{
			Report.LogInfo("submit", locator +" Is not Submitted", "FAIL");
		}
	}


	public void submitAndWait(String locator)
	{
		try
		{
			WebElement element = findWebElement(locator);
			element.submit();
			javaScriptWait();
			Report.LogInfo("submit",locator +" Is Submitted Successfully", "INFO");
		}catch(Exception e)
		{
			Report.LogInfo("submit",locator +" Is not Submitted Successfully", "FAIL");
		}
	}

	/**
	 * Select one option from a single select drop down list
	 * Single Selection: Select option
	 * 
	 * @param locator (@id=option) && xpath
	 * @param field   (@id)
	 * @throws Exception
	 */
	public void select(String locator, String field)
	{
		try
		{
			Select element = new Select(findWebElement(locator));
			selectValue(element, field);
			Report.LogInfo("dropdown",locator +" Is Selected Successfully with option " +field, "INFO");
		}
		catch(Exception e)
		{
			Report.LogInfo("dropdown",locator +" Is not Selected Successfully with option " +field, "FAIL");
		}
	}

	public void selectByIndex(String locator, int index,String ObjectName) 
	{
		try
		{
			Select element = new Select(findWebElement(locator));
			element.selectByIndex(index);
			Report.LogInfo("dropDown",index +" item is Selected in "+ObjectName+" successfully", "INFO");

		}catch(Exception e)
		{
			Report.LogInfo("dropDown", ObjectName + " :Not present on Screen", "FAIL");
		}
	}
	public void selectByValue(String locator, String field) 
	{
		try
		{
			Select element = new Select(findWebElement(locator));
			element.selectByValue(field);
			Report.LogInfo("dropdown",locator +" Is Selected Successfully with option " +field, "INFO");
		}
		catch(Exception e)
		{
			Report.LogInfo("dropdown",locator +" Is not Selected Successfully with option " +field, "FAIL");
		}
	}

	public void selectByVisibleText(String locator, String field) 
	{
		try
		{
			Select element = new Select(findWebElement(locator));
			element.selectByVisibleText(field);
			Report.LogInfo("dropdown",locator +" Is Selected Successfully with option " +field, "INFO");
		}
		catch(Exception e)
		{
			Report.LogInfo("dropdown",locator +" Is not Selected Successfully with option " +field, "FAIL");
		}
	}

	/**
	 * @param singleSelect
	 * @param field
	 * @throws Exception 
	 */
	protected void selectValue(Select singleSelect, String field)
	{
		try
		{
			if(field.startsWith("@value")){
				String value = removeStart(field, "@value=");
				if (!isBlankOrNull(value)){
					singleSelect.selectByValue(removeStart(field, "@value="));
					Report.LogInfo("SelectOptionByValue",field +"  value is selected in dropdown", "INFO");
				}
			} else if(field.startsWith("@index")){
				String index = removeStart(field, "@index=");
				if (!isBlankOrNull(index)){
					singleSelect.selectByIndex(Integer.parseInt(index));
					Report.LogInfo("SelectOptionByIndex",field +" index is selected in dropdown ", "INFO");
				}
			} else if (field.startsWith("@visibleText")){
				String text = removeStart(field, "@visibleText=");
				if (!isBlankOrNull(text)){
					singleSelect.selectByVisibleText(removeStart(field, "@visibleText="));
					Report.LogInfo("SelectOptionByVisibleText",field +" visible text is selected in dropdown", "INFO");
				}
			} else
			{
				//	throw new Exception("Invalid format of the field [field='" + field+"']");
			}
		}catch(Exception e)
		{
			Report.LogInfo("SelectValue",field +"is not selected in "+singleSelect , "FAIL");
		}
		//log.trace("Exiting method selectValue");
	}

	/**
	 * @throws Exception 
	 * @see selectFromMultipleSelect
	 */
	public void selectMultiple(String locator, String values) {
		//log.trace("Entering method selectMultiple with parameters [locator='"+locator+"', values='"+values+"']");
		if(isBlankOrNull(locator) || 
				(!locator.startsWith("/") && !locator.startsWith("@name=") && !locator.startsWith("@id="))) {
		}
		Select element = new Select(findWebElement(locator));
		if(isValueEmpty(values)) {
			element.deselectAll();
			return;
		}
		String[] args = values.split(",");
		for ( String field : args) {
			selectValue(element, field);
		}
	}

	/**
	 * @param locator
	 * @param value
	 * @throws Exception
	 */
	public void selectRadio(String locator, String value) {

		if(isBlankOrNull(locator) || (!locator.startsWith("@xpath=") && !locator.startsWith("@name=") )) {
			//	throw new Exception("Invalid locator format [locator='"+locator+"']");
		}

		List<WebElement> webElements = findWebElements(locator);
		if(value.startsWith("@id=")){
			String id = removeStart(value,"@id=");
			for ( WebElement element : webElements ) {
				if(id.equals(element.getAttribute("id"))) {
					element.click();
					//log.debug("Element to select identified with id [value='"+value+"']");
				}
			}
		} else if(value.startsWith("@value=")){
			String id = removeStart(value,"@value=");
			for ( WebElement element : webElements ) {
				if(id.equals(element.getAttribute("value"))) {
					element.click();
					//log.debug("Element to select identified with value [value='"+value+"']");
				}
			}
		}
		else {
			//	throw new Exception("Invalid value format [value='"+value+"']");
		}
	}

	/**
	 * @param locator
	 * @param value
	 * @throws Exception
	 */
	public void check(String locator, String value) {
		//log.trace("Entering method check [locator='"+locator+"', value='"+value+"']");
		clickCheckBox(locator, value, true);
		//info("Checked checkbox [locator='"+locator+"', value='"+value+"']");
		//log.trace("Exiting method check");
	}

	public void checkbox(String locator,Keys key) {

		if(verifyExists(locator))
		{
			findWebElement(locator).sendKeys(key);
			Report.LogInfo("isChecked",locator , "Info");
		}
		else
		{
			Report.LogInfo("isChecked", locator+ "is not found", "FAIL");
		}

	}

	/**
	 * @param locator
	 * @param value
	 * @throws Exception
	 */
	public boolean isSelected(String locator,String infoMessage) {

		Report.LogInfo("isChecked", infoMessage, "Info");

		if(verifyExists(locator))
		{
			return (findWebElement(locator).isSelected());
		}
		else

		{
			Report.LogInfo("isChecked", locator+ "is not found", "FAIL");
			return false;
		}

	}

	/**
	 * @param locator
	 * @param value
	 * @throws Exception
	 */
	public void uncheck(String locator, String value) {
		clickCheckBox(locator, value, false);

	}

	/**
	 * @param isChecked
	 * @param element
	 * @return
	 */
	protected boolean canClickElement(boolean isCheckCommand, WebElement element) {
		boolean canClick = (isCheckCommand && !element.isSelected()) ||
				(!isCheckCommand && element.isSelected());
		return canClick;
	}


	protected void clickCheckBox(String locator, String value, boolean isCheckCommand){
		if(isBlankOrNull(locator) || (!locator.startsWith("/") && !locator.startsWith("@name=") )) {
			//	throw new Exception("Invalid locator format [locator='"+locator+"']");
		}

		List<WebElement> webElements = findWebElements(locator);
		if("all".equalsIgnoreCase(value)) {
			for ( WebElement element : webElements ) {
				if( canClickElement(isCheckCommand, element) ) {
					//log.debug("Checkbox clicked [value='"+value+"']");
					element.click();
				}
			}
		} else if(value.startsWith("@id=")){
			String id = removeStart(value,"@id=");
			for ( WebElement element : webElements ) {
				if(id.equals(element.getAttribute("id")) && canClickElement(isCheckCommand, element)) {
					//log.debug("Checkbox clicked [value='"+value+"']");
					element.click();
					break;
				}
			}
		} else if(value.startsWith("@value=")){
			String valueToSet = removeStart(value,"@value=");
			for ( WebElement element : webElements ) {
				if(valueToSet.equals(element.getAttribute("value")) && canClickElement(isCheckCommand, element)) {
					//log.debug("Checkbox clicked [value='"+value+"']");
					element.click();
					break;
				}
			}
		}
		else {
			//	throw new Exception("Invalid Value format [value='"+value+"']");
		}
	}


	/**
	 * The method returns true, if the value just has the empty keyword.
	 * 
	 * @param value
	 * @return
	 * @throws Exception 
	 */
	protected boolean isValueEmpty(String value) {
		if(StringUtils.containsIgnoreCase(value,EMPTY_KEYWORD)) {
			if(EMPTY_KEYWORD.equalsIgnoreCase(value.trim())) {
				return true;
			}
			else {
				//	throw new Exception("Invalid empty value format! [value='" + value + "']");
			}
		}
		return false;
	}

	/**
	 * The method replaces ${space} with " " and returns the string.  The end result after processing 
	 * should be all spaces if not, throws an Exception.
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	protected String processSpaceValues(String value) {
		if(StringUtils.containsIgnoreCase(value,SPACE_KEYWORD)) {
			value = value.replace(SPACE_KEYWORD, " ");
			value = value.replace(SPACE_KEYWORD.toUpperCase(), " ");
			if("".equals(value.trim())) {
				//info("Set the value in text box as [value='"+value+"']");
				//log.trace("Exit method processSpaceValues");
				return value;
			}
			else {
				//	throw new Exception("Invalid space value format! [value='" + value + "']");
			}
		}
		return value;
	}

	/**
	 * Verify if the page contains specified element
	 * 
	 * @param elementLocator
	 * @Modified on 
	 * @Modified By 
	 */
	public boolean verifyExists(String locator) {
		if(!isBlankOrNull(locator)){
			try {
				setImplicitWaitTimeout(2);
				WebElement element=findWebElement(locator);
				setImplicitWaitTimeout(50000);

				if(element != null)
				{
					Report.LogInfo("verifyExists","verify locator : \""+locator+"\" is present", "PASS");
					return true;
				}
				else
				{
					Report.LogInfo("verifyExists","verify locator : \""+locator+"\" is not present", "FAIL");
					return false;
				}


			} catch (Exception e) {

				setImplicitWaitTimeout(50000);
				Report.LogInfo("verifyExists","verify locator : \""+locator+"\" is not present", "FAIL");
				return false;
			} 
		}else{

			Report.LogInfo("verifyExists","verify locator : \""+locator+"\" is not present", "INFO");
			return false;
		}
	}

	public void waitForSpinnerDisable() {
		WebDriverWait wait1 = new WebDriverWait(webDriver, 180);
		wait1.until(angularHasFinishedProcessing());
		try{
			if(isVisible2(loading)==true){
				wait1.until(ExpectedConditions.invisibilityOf(webDriver.findElement(By.xpath("//*[@id='loading-bar-spinner']/div[@class='spinner']"))));
				sleep(100);
			}
		}catch(Exception e){}
	}



	public boolean verifyExists(String locator,String Object) {
		waitForSpinnerDisable();
		if(!isBlankOrNull(locator)){
			try {
				waitForPageLoad();
				WebElement element=findWebElement(locator);
				WebDriverWait wait = new WebDriverWait(webDriver, 60);
				wait.until(ExpectedConditions.visibilityOf(element));
				wait.until(ExpectedConditions.elementToBeClickable(element));
				wait.until(angularHasFinishedProcessing());
				if(element != null)
				{
					Report.LogInfo("verifyExists","<b><i>"+Object +"<i></b> - Object is present on screen", "PASS");
					return true;
				}
				else
				{
					Report.LogInfo("verifyExists","<b><i>"+Object +"</i></b> - Object is not present on screen", "FAIL");					
					return false;
				}				
			} catch (Exception e) {

				//setImplicitWaitTimeout(50000);
				Report.LogInfo("verifyExists","<b><i>"+Object +"</i></b> - Object is not present on screen", "FAIL");
				refreshPage();
				return false;

			} 
		}else{

			Report.LogInfo("verifyExists","<b><i>"+Object +"</i></b> - Object is not present on screen", "FAIL");			
			return false;
		}
	}

	public boolean verifyMustExists(String locator,String Object) {
		waitForSpinnerDisable();
		if(!isBlankOrNull(locator)){
			try {
				waitForPageLoad();				

				WebElement element=findWebElement(locator);
				WebDriverWait wait = new WebDriverWait(webDriver, 60);
				wait.until(ExpectedConditions.visibilityOf(element));
				wait.until(ExpectedConditions.elementToBeClickable(element));
				wait.until(angularHasFinishedProcessing());
				if(element != null)
				{
					Report.LogInfo("verifyExists","<b><i>"+Object +"<i></b> - Object is present on screen", "PASS");
					return true;
				}
				else
				{
					Report.LogInfo("verifyExists","<b><i>"+Object +"</i></b> - Object is not present on screen", "FAIL");
					refreshPage();
					throw new SkipException("Skipping This Execution");					
					//return false;					
				}				
			} catch (Exception e) {

				//setImplicitWaitTimeout(50000);
				Report.LogInfo("verifyExists","<b><i>"+Object +"</i></b> - Object is not present on screen", "FAIL");
				//return false;
				refreshPage();
				throw new SkipException("Skipping This Execution");
			} 
		}else{

			Report.LogInfo("verifyExists","<b><i>"+Object +"</i></b> - Object is not present on screen", "FAIL");
			//return false;	
			refreshPage();
			throw new SkipException("Skipping This Execution");
		}
	}

	public void waitForPageLoad()
	{
		String pageLoadStatus = null;
		JavascriptExecutor js = (JavascriptExecutor)webDriver;
		do {
			js = (JavascriptExecutor) webDriver;
			pageLoadStatus = (String)js.executeScript("return document.readyState");
		} while ( !pageLoadStatus.equals("complete") );
	}

	public void waitForElementLoad(String locator)
	{
		WebDriverWait wait = new WebDriverWait(webDriver, 15000);
		wait.until(ExpectedConditions.elementToBeClickable(findWebElement(locator)));// instead of id u can use cssSelector or xpath of ur element.
		wait.until(angularHasFinishedProcessing());
	}

	public boolean verifyOptionalExists(String locator,String Object) {
		if(!isBlankOrNull(locator)){
			try {
				WebElement element=findWebElement(locator);
				WebDriverWait wait = new WebDriverWait(webDriver, 60);
				wait.until(ExpectedConditions.visibilityOf(element));
				wait.until(ExpectedConditions.elementToBeClickable(element));
				wait.until(angularHasFinishedProcessing());
				if(element != null)
				{
					Report.LogInfo("verifyExists","<b><i>"+Object +"<i></b> - Object is present on screen", "PASS");
					return true;
				}
				else
				{
					Report.LogInfo("verifyExists","<b><i>"+Object +"</i></b> - Object is not present on screen", "FAIL");
					return false;
				}				
			} catch (Exception e) {

				//setImplicitWaitTimeout(50000);
				Report.LogInfo("verifyExists","<b><i>"+Object +"</i></b> - Object is not present on screen", "FAIL");
				return false;
			} 
		}else{

			Report.LogInfo("verifyExists","<b><i>"+Object +"</i></b> - Object is not present on screen", "FAIL");
			return false;
		}
	}



	/**
	 * Set page to accept/reject all confirm boxes
	 * 
	 * @param elementLocator
	 */
	public void clickConfirmBox(String option) {
		Alert alert = TestBase.webDriver.switchTo().alert();
		if(!isBlankOrNull(option)){
			if(option.equalsIgnoreCase("OK")) {
				alert.accept();
			} else {
				alert.dismiss();
			}
		}
	}

	/**
	 * Set window as current active window for specified title
	 * 
	 * @param title - 
	 * @throws Exception 
	 */
	public void setWindow(String title) {
		String currentHandle = TestBase.webDriver.getWindowHandle();

		for (String handle : TestBase.webDriver.getWindowHandles()) {

			if (title.equals(TestBase.webDriver.switchTo().window(handle).getTitle())) {
				return;
			}
		} 

		TestBase.webDriver.switchTo().window(currentHandle);
	}

	/**
	 * This method will find the webElement based on id/name/xpath/linkText
	 * 
	 * @param locator
	 * @param webElement
	 * @return
	 * @throws Exception 
	 */
	protected WebElement findWebElement(String locator){

		webDriver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);

		WebElement webElement = null;
		if(!isBlankOrNull(locator)){
			try {

				//Report.LogInfo("findWebElement","Web element '"+locator+ "' is finding", "INFO");
				if(locator.startsWith("@id")){ // e.g @id='elementID'
					// Find the text input element by its id
					webElement = TestBase.webDriver.findElement(By.id(removeStart(locator, "@id=")));

				}else if(locator.startsWith("@name")){
					// Find the text input element by its name
					webElement = TestBase.webDriver.findElement(By.name(removeStart(locator, "@name=")));
				}else if(locator.startsWith("@linkText")){
					// Find the text input element by its link text
					webElement = TestBase.webDriver.findElement(By.linkText(removeStart(locator, "@linkText=")));
				}else if(locator.startsWith("@partialLinkText")){
					// Find the text input element by its link text
					webElement = TestBase.webDriver.findElement(By.partialLinkText(removeStart(locator, "@partialLinkText=")));
				}else if(locator.startsWith("@xpath")){
					//using XPATH locator.
					webElement = TestBase.webDriver.findElement(By.xpath(removeStart(locator, "@xpath="))); 
				}else if(locator.startsWith("@css")){
					// Find the text input element by its css locator
					webElement = TestBase.webDriver.findElement(By.cssSelector(removeStart(locator, "@css=")));
				}else if(locator.startsWith("@className")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(By.className(removeStart(locator, "@className=")));
				}
				else if(locator.startsWith("@tagName")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(By.className(removeStart(locator, "@tagName=")));
				}
				else if(locator.startsWith("@binding")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.binding(removeStart(locator, "@binding=")));
				}
				else if(locator.startsWith("@buttonText")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.buttonText(removeStart(locator, "@buttonText=")));
				}else if(locator.startsWith("@input")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.input(removeStart(locator, "@input=")));
				}else if(locator.startsWith("@model")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.model(removeStart(locator, "@model=")));
				}else if(locator.startsWith("@options")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.options(removeStart(locator, "@options=")));
				}else if(locator.startsWith("@partialButtonText")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.partialButtonText(removeStart(locator, "@partialButtonText=")));
				}else if(locator.startsWith("@repeater")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.repeater(removeStart(locator, "@repeater=")));
				}

			} catch(NoSuchElementException e) { 
				//Report.LogInfo("findWebElement", "Exception encountered while trying to find element [locator='"+locator+"']: "+e.getMessage(), "FAIL");
			} catch(RuntimeException e) { 
				//Report.LogInfo("findWebElement", "Element does not exist [locator='"+locator+"']: "+e.getMessage(), "FAIL");	
				((JavascriptExecutor)webDriver).executeScript("arguments[0].style.border='3px solid red'", webElement);
			}
		}
		((JavascriptExecutor)webDriver).executeScript("arguments[0].style.border='3px solid green'", webElement);

		//log.trace("Exiting method findWebElement");
		return webElement;
	}

	protected WebElement findWebElement1(String locator){

		webDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		WebElement webElement = null;
		if(!isBlankOrNull(locator)){
			try {

				//Report.LogInfo("findWebElement","Web element '"+locator+ "' is finding", "INFO");
				if(locator.startsWith("@id")){ // e.g @id='elementID'
					// Find the text input element by its id
					webElement = TestBase.webDriver.findElement(By.id(removeStart(locator, "@id=")));

				}else if(locator.startsWith("@name")){
					// Find the text input element by its name
					webElement = TestBase.webDriver.findElement(By.name(removeStart(locator, "@name=")));
				}else if(locator.startsWith("@linkText")){
					// Find the text input element by its link text
					webElement = TestBase.webDriver.findElement(By.linkText(removeStart(locator, "@linkText=")));
				}else if(locator.startsWith("@partialLinkText")){
					// Find the text input element by its link text
					webElement = TestBase.webDriver.findElement(By.partialLinkText(removeStart(locator, "@partialLinkText=")));
				}else if(locator.startsWith("@xpath")){
					//using XPATH locator.
					webElement = TestBase.webDriver.findElement(By.xpath(removeStart(locator, "@xpath="))); 
				}else if(locator.startsWith("@css")){
					// Find the text input element by its css locator
					webElement = TestBase.webDriver.findElement(By.cssSelector(removeStart(locator, "@css=")));
				}else if(locator.startsWith("@className")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(By.className(removeStart(locator, "@className=")));
				}
				else if(locator.startsWith("@tagName")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(By.className(removeStart(locator, "@tagName=")));
				}
				else if(locator.startsWith("@binding")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.binding(removeStart(locator, "@binding=")));
				}
				else if(locator.startsWith("@buttonText")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.buttonText(removeStart(locator, "@buttonText=")));
				}else if(locator.startsWith("@input")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.input(removeStart(locator, "@input=")));
				}else if(locator.startsWith("@model")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.model(removeStart(locator, "@model=")));
				}else if(locator.startsWith("@options")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.options(removeStart(locator, "@options=")));
				}else if(locator.startsWith("@partialButtonText")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.partialButtonText(removeStart(locator, "@partialButtonText=")));
				}else if(locator.startsWith("@repeater")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.repeater(removeStart(locator, "@repeater=")));
				}

			} catch(NoSuchElementException e) { 
				//Report.LogInfo("findWebElement", "Exception encountered while trying to find element [locator='"+locator+"']: "+e.getMessage(), "FAIL");
			} catch(RuntimeException e) { 
				//Report.LogInfo("findWebElement", "Element does not exist [locator='"+locator+"']: "+e.getMessage(), "FAIL");	
				((JavascriptExecutor)webDriver).executeScript("arguments[0].style.border='3px solid red'", webElement);
			}
		}
		((JavascriptExecutor)webDriver).executeScript("arguments[0].style.border='3px solid green'", webElement);

		//log.trace("Exiting method findWebElement");
		return webElement;
	}

	protected WebElement findWebElement3(String locator){

		webDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		WebElement webElement = null;
		if(!isBlankOrNull(locator)){
			try {

				//Report.LogInfo("findWebElement","Web element '"+locator+ "' is finding", "INFO");
				if(locator.startsWith("@id")){ // e.g @id='elementID'
					// Find the text input element by its id
					webElement = TestBase.webDriver.findElement(By.id(removeStart(locator, "@id=")));

				}else if(locator.startsWith("@name")){
					// Find the text input element by its name
					webElement = TestBase.webDriver.findElement(By.name(removeStart(locator, "@name=")));
				}else if(locator.startsWith("@linkText")){
					// Find the text input element by its link text
					webElement = TestBase.webDriver.findElement(By.linkText(removeStart(locator, "@linkText=")));
				}else if(locator.startsWith("@partialLinkText")){
					// Find the text input element by its link text
					webElement = TestBase.webDriver.findElement(By.partialLinkText(removeStart(locator, "@partialLinkText=")));
				}else if(locator.startsWith("@xpath")){
					//using XPATH locator.
					webElement = TestBase.webDriver.findElement(By.xpath(removeStart(locator, "@xpath="))); 
				}else if(locator.startsWith("@css")){
					// Find the text input element by its css locator
					webElement = TestBase.webDriver.findElement(By.cssSelector(removeStart(locator, "@css=")));
				}else if(locator.startsWith("@className")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(By.className(removeStart(locator, "@className=")));
				}
				else if(locator.startsWith("@tagName")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(By.className(removeStart(locator, "@tagName=")));
				}
				else if(locator.startsWith("@binding")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.binding(removeStart(locator, "@binding=")));
				}
				else if(locator.startsWith("@buttonText")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.buttonText(removeStart(locator, "@buttonText=")));
				}else if(locator.startsWith("@input")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.input(removeStart(locator, "@input=")));
				}else if(locator.startsWith("@model")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.model(removeStart(locator, "@model=")));
				}else if(locator.startsWith("@options")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.options(removeStart(locator, "@options=")));
				}else if(locator.startsWith("@partialButtonText")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.partialButtonText(removeStart(locator, "@partialButtonText=")));
				}else if(locator.startsWith("@repeater")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.repeater(removeStart(locator, "@repeater=")));
				}

			} catch(NoSuchElementException e) { 
				//Report.LogInfo("findWebElement", "Exception encountered while trying to find element [locator='"+locator+"']: "+e.getMessage(), "FAIL");
			} catch(RuntimeException e) { 
				//Report.LogInfo("findWebElement", "Element does not exist [locator='"+locator+"']: "+e.getMessage(), "FAIL");	
				((JavascriptExecutor)webDriver).executeScript("arguments[0].style.border='3px solid red'", webElement);
			}
		}
		((JavascriptExecutor)webDriver).executeScript("arguments[0].style.border='3px solid green'", webElement);

		//log.trace("Exiting method findWebElement");
		return webElement;
	}

	protected WebElement findWebElement2(String locator){

		webDriver.manage().timeouts().implicitlyWait(700, TimeUnit.MILLISECONDS);

		WebElement webElement = null;
		if(!isBlankOrNull(locator)){
			try {

				//Report.LogInfo("findWebElement","Web element '"+locator+ "' is finding", "INFO");
				if(locator.startsWith("@id")){ // e.g @id='elementID'
					// Find the text input element by its id
					webElement = TestBase.webDriver.findElement(By.id(removeStart(locator, "@id=")));

				}else if(locator.startsWith("@name")){
					// Find the text input element by its name
					webElement = TestBase.webDriver.findElement(By.name(removeStart(locator, "@name=")));
				}else if(locator.startsWith("@linkText")){
					// Find the text input element by its link text
					webElement = TestBase.webDriver.findElement(By.linkText(removeStart(locator, "@linkText=")));
				}else if(locator.startsWith("@partialLinkText")){
					// Find the text input element by its link text
					webElement = TestBase.webDriver.findElement(By.partialLinkText(removeStart(locator, "@partialLinkText=")));
				}else if(locator.startsWith("@xpath")){
					//using XPATH locator.
					webElement = TestBase.webDriver.findElement(By.xpath(removeStart(locator, "@xpath="))); 
				}else if(locator.startsWith("@css")){
					// Find the text input element by its css locator
					webElement = TestBase.webDriver.findElement(By.cssSelector(removeStart(locator, "@css=")));
				}else if(locator.startsWith("@className")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(By.className(removeStart(locator, "@className=")));
				}
				else if(locator.startsWith("@tagName")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(By.className(removeStart(locator, "@tagName=")));
				}
				else if(locator.startsWith("@binding")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.binding(removeStart(locator, "@binding=")));
				}
				else if(locator.startsWith("@buttonText")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.buttonText(removeStart(locator, "@buttonText=")));
				}else if(locator.startsWith("@input")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.input(removeStart(locator, "@input=")));
				}else if(locator.startsWith("@model")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.model(removeStart(locator, "@model=")));
				}else if(locator.startsWith("@options")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.options(removeStart(locator, "@options=")));
				}else if(locator.startsWith("@partialButtonText")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.partialButtonText(removeStart(locator, "@partialButtonText=")));
				}else if(locator.startsWith("@repeater")){
					// Find the text input element by its class Name
					webElement = TestBase.webDriver.findElement(NgBy.repeater(removeStart(locator, "@repeater=")));
				}

			} catch(NoSuchElementException e) { 
				//Report.LogInfo("findWebElement", "Exception encountered while trying to find element [locator='"+locator+"']: "+e.getMessage(), "FAIL");
			} catch(RuntimeException e) { 
				//Report.LogInfo("findWebElement", "Element does not exist [locator='"+locator+"']: "+e.getMessage(), "FAIL");	
				((JavascriptExecutor)webDriver).executeScript("arguments[0].style.border='3px solid red'", webElement);
			}
		}
		((JavascriptExecutor)webDriver).executeScript("arguments[0].style.border='3px solid green'", webElement);

		//log.trace("Exiting method findWebElement");
		return webElement;
	}
	/**
	 * This method will find the webElement based on id/name/xpath/linkText
	 * 
	 * @param locator
	 * @param webElement
	 * @return
	 * @throws Exception 
	 */
	protected List<WebElement> findWebElements(String locator)
	{
		//log.trace("Entering method findWebElements [locator='"+locator+"']");
		////info("Find web elements [locator='"+locator+"']");
		List<WebElement> webElements = null;
		if(!isBlankOrNull(locator)){
			try {
				if(locator.startsWith("@id")){ // e.g @id='elementID'
					// Find the text input element by its id
					webElements = TestBase.webDriver.findElements(By.id(removeStart(locator, "@id=")));
				}else if(locator.startsWith("@name")){
					// Find the text input element by its name
					webElements = TestBase.webDriver.findElements(By.name(removeStart(locator, "@name=")));
				}else if(locator.startsWith("@linkText")){
					// Find the text input element by its link text
					webElements = TestBase.webDriver.findElements(By.linkText(removeStart(locator, "@linkText=")));
				}else if(locator.startsWith("@partialLinkText")){
					// Find the text input element by its link text
					webElements = TestBase.webDriver.findElements(By.partialLinkText(removeStart(locator, "@partialLinkText=")));
				}else if(locator.startsWith("@xpath")){
					//using XPATH locator.
					webElements = TestBase.webDriver.findElements(By.xpath(removeStart(locator, "@xpath="))); 
				}else if(locator.startsWith("@css")){
					// Find the text input element by its link text
					webElements = TestBase.webDriver.findElements(By.cssSelector(removeStart(locator, "@css=")));
				}
				else if(locator.startsWith("@className")){
					// Find the text input element by its class Name
					webElements = TestBase.webDriver.findElements(By.className(removeStart(locator, "@className=")));
				}
			} catch(NoSuchElementException e) { 
				//log.trace("Did not find specified HTML element [locator="+locator+"] \n "+e.getMessage());
				//	throw new Exception("Element does not exist [locator='"+locator+"']: "+e.getMessage());
			} catch(RuntimeException e) { 
				//log.trace(e.getMessage());
				//	throw new Exception("Exception encountered while trying to find elements [locator='"+locator+"']: "+e.getMessage());
			}
		}
		if(webElements == null) {
			//	throw new Exception("Element not found [locator='"+locator+"']");
		}
		//log.trace("Exiting method findWebElements ");
		return webElements;
	}

	/**
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyDoesNotExist(String locator) {
		//log.trace("Entering method verifyDoesNotExist [locator='"+locator+"']");
		boolean result = false;
		if(!isBlankOrNull(locator)){
			try {
				setImplicitWaitTimeout(waitForWebElementNotExistTimeOut);
				findWebElement(locator);
			} catch (Exception e) {
				if(e.getCause().getClass().equals(NoSuchElementException.class)){
					result= true;
				}else {
					//throw e;
				}
			} finally{
				setImplicitWaitTimeout(waitForWebElementTimeOut);
			}
			//info("Verify field exists [locator='"+locator+"']");

		}
		//log.trace("Exiting method verifyDoesNotExist");
		return result;
	}



	/**
	 * @throws Exception 
	 * 
	 */
	public String getAttributeFrom(String locator, String attributeName) {
		//log.trace("Entering method getAttributeValue [locator='"+locator+"']");
		String returnValue = null;
		if(!isBlankOrNull(locator) && !isBlankOrNull(attributeName)){
			try {

				WebElement webElement = findWebElement(locator);
				returnValue = webElement.getAttribute(attributeName).trim();// This should be parameter
				Report.LogInfo("getAttributeValue","Attribute <B>'"+ attributeName +"'</B> in locator : <I>'"+locator+"'</I> is :"+returnValue,"INFO");
			}catch(NoSuchElementException e) { 
				//log.trace("Did not find specified HTML element [locator="+locator+"] \n "+e.getMessage());
				//	throw new Exception("Element does not exist [locator='"+locator+"']: "+e.getMessage());
			}catch(Exception e){
				//	throw new Exception("Exception encountered while trying to getAttributeValue [locator='"+locator+"']: "+e.getMessage(), e);
			}
		}
		return returnValue;
	}


	public String getAttributeFrom(String locator, String attributeName,String objectName)
	{
		String returnValue = null;
		if(!isBlankOrNull(locator) && !isBlankOrNull(attributeName))
		{
			try {
				WebElement webElement = findWebElement(locator);
				returnValue = webElement.getAttribute(attributeName).trim();// This should be parameter
				Report.LogInfo("getAttributeValue","Value of attribute <B><i>'"+ attributeName +"'</i></B> of Object '"+objectName+"' is :'"+returnValue+"'","INFO");
			}catch(NoSuchElementException e) { 
			}catch(Exception e)
			{
				Report.LogInfo("Exception","Exception in getAttributeFrom "+e.getMessage(),"FAIL");				
			}
		}
		return returnValue;
	}


	public String getTextFrom(String locator)
	{
		waitForSpinnerDisable();
		String returnText = null;
		setImplicitWaitTimeout(2000);
		if(!isBlankOrNull(locator))
		{

			WebElement webElement = findWebElement(locator);
			WebDriverWait wait = new WebDriverWait(webDriver, 60);
			wait.until(ExpectedConditions.visibilityOf(webElement));
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
			wait.until(angularHasFinishedProcessing());
			try {

				returnText = webElement.getText().trim();
				//Report.LogInfo("getTextFrom","getting text from locator : ' "+ locator+" is "+returnText, "INFO");
			}catch(NoSuchElementException e) { 
				//Report.LogInfo("getTextFrom","Text isn't found for locator: ' "+ locator, "FAIL");
				//log.trace("Did not find specified HTML element [locator="+locator+"] \n "+e.getMessage());
				//throw new Exception("Element does not exist [locator='"+locator+"']: "+e.getMessage());
			}catch(Exception e){
				//Report.LogInfo("getTextFrom","Text isn't found for locator: ' "+ locator, "FAIL");
				//throw new Exception("Exception encountered while trying to getText [locator='"+locator+"']: "+e.getMessage(), e);
			}
		}
		return returnText;
	}

	public String getTextFrom(String locator,String Object) {
		waitForSpinnerDisable();
		String returnText = null;
		setImplicitWaitTimeout(2);
		if(!isBlankOrNull(locator)){
			try {

				WebElement webElement = findWebElement(locator);

				returnText = webElement.getText().trim();
				Report.LogInfo("getTextFrom","Text from object : '<b><i> "+ Object+"</i></b>' is '<i>"+returnText+"</i>'","INFO");
			}catch(NoSuchElementException e) { 
				Report.LogInfo("getTextFrom","<b><i>'"+Object +"'</i></b> is not present on Screen", "FAIL");
				//log.trace("Did not find specified HTML element [locator="+locator+"] \n "+e.getMessage());
				//	throw new Exception("Element does not exist [locator='"+locator+"']: "+e.getMessage());
			}catch(Exception e){
				Report.LogInfo("getTextFrom","<b><i>'"+Object +"'</i></b> is not present on Screen", "FAIL");
				//	throw new Exception("Exception encountered while trying to getText [locator='"+locator+"']: "+e.getMessage(), e);
			}
		}

		return returnText;
	}

	public void javaScriptWait()
	{
		waitForSpinnerDisable();
		String  str;
		try{
			do
			{
				JavascriptExecutor js = (JavascriptExecutor) webDriver;
				str =(String) js.executeScript("return document.readyState");

			}while(!str.equals("complete"));
		}catch(Exception e)
		{
			Report.LogInfo("Exception",e.getMessage(), "FAIL");
		}
	}

	public boolean isElementPresent(By locator) 
	{
		String loc=null;

		try {
			setImplicitWaitTimeout(1);
			webDriver.findElement(locator);
			return true;

			//log.trace("Exiting method isTextPreset returning result [TRUE]");
		} catch (NoSuchElementException e) {
			//log.trace("Exiting method isTextPreset returning result [FALSE]");
			//Report.LogInfo("isElementPresent","verify locator : \""+locator+"\" is not present", "INFO");
			return false;
			//throw e;
		}catch (Exception e) {
			//log.trace("Exiting method isTextPreset returning result [FALSE]");
			//Report.LogInfo("isElementPresent","verify locator : \""+loc+"\" is not present", "INFO");
			return false;
			//throw e;
		}

	}

	public boolean isElementPresent(By locator,String object) 
	{
		String loc=null;

		try {
			setImplicitWaitTimeout(1);
			webDriver.findElement(locator);

			//loc = webDriver.findElement(locator).getAttribute("id");
			Report.LogInfo("isElementPresent",object +": is present on screen", "PASS");
			return true;

			//log.trace("Exiting method isTextPreset returning result [TRUE]");
		} catch (NoSuchElementException e) {
			//log.trace("Exiting method isTextPreset returning result [FALSE]");
			Report.LogInfo("isElementPresent","verify locator : \""+locator+"\" is not present", "INFO");
			return false;
			//throw e;
		}catch (Exception e) {
			//log.trace("Exiting method isTextPreset returning result [FALSE]");
			Report.LogInfo("isElementPresent",object +": is not present on screen", "INFO");
			return false;
			//throw e;
		}

	}


	public void clearTextBox(String locator)
	{
		WebElement webElement = findWebElement(locator);
		webElement.clear();
	}

	public void sendKeys(String locator, String textValue) 
	{ 

		WebElement webElement = null;
		if(!isBlankOrNull(locator)){
			webElement = findWebElement(locator);
			if(isBlankOrNull(textValue)) {
				return;
			}

			if(isValueEmpty(textValue)) {
				//info("Clear the field contents [text='"+textValue+"', locator='"+locator+"']");
				webElement.clear();
				return;
			}

			textValue = processSpaceValues(textValue);

			webElement.clear();
			webElement.sendKeys(textValue);
			Report.LogInfo("sendKeys",textValue +" Entered into "+ locator, "INFO");
			//info("Type text into field [text='"+textValue+"', locator='"+locator+"']");
		}
		else {
			//	throw new Exception("Invalid locator format [locator='"+locator+"']");
		}
		//log.trace("Exiting method typeInto");
	}


	public void sendKeys(String locator, String textValue,String message) 
	{ 
		waitForSpinnerDisable();
		try
		{
			WebElement webElement = null;
			if(!isBlankOrNull(locator)){
				webElement = findWebElement(locator);
				if(isBlankOrNull(textValue)) {
					return;
				}

				if(isValueEmpty(textValue)) {
					//info("Clear the field contents [text='"+textValue+"', locator='"+locator+"']");
					webElement.clear();
					return;
				}

				textValue = processSpaceValues(textValue);

				webElement.clear();
				webElement.sendKeys(textValue);
				Report.LogInfo("sendKeys","<i>'"+textValue +"</i>' entered in - <b><i>"+message+"</i></b>", "INFO");
				//info("Type text into field [text='"+textValue+"', locator='"+locator+"']");
			}
			else {
				//	throw new Exception("Invalid locator format [locator='"+locator+"']");
				refreshPage();
				throw new SkipException("Skipping This Execution");
			}
		}
		catch(Exception e)
		{
			Report.LogInfo("sendKeys",locator +" - Not present on Screen", "FAIL");
			refreshPage();
			throw new SkipException("Skipping This Execution");

		}
	}

	public ExpectedCondition<WebElement> visibilityOfElementLocated(final By locator) {
		return new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement toReturn = driver.findElement(locator);
				if (toReturn.isDisplayed()) {
					return toReturn;
				}
				return null;
			}
		};
	}

	public boolean isVisible(String locator) throws NoSuchElementException {
		//log.trace("Entering method isVisible [locator='"+locator+"']");
		//waitForSpinnerDisable();
		boolean result = true;
		/*WebElement element=findWebElement(locator);
		WebDriverWait wait = new WebDriverWait(webDriver, 20);
		//wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));*/
		if(!isBlankOrNull(locator)){
			try {

				result=findWebElement1(locator).isDisplayed();

			} catch (Exception ignored) {
				result= false;
				//throw e;
			} 
		}
		else{
			result = false;
		}
		//info("Exiting method isVisible returning result="+result);
		//log.trace("Exiting method isVisible returning result="+result);
		return result;
	}

	public boolean isEnable(String locator) throws NoSuchElementException {

		boolean result = true;

		if(!isBlankOrNull(locator)){
			try {

				result=findWebElement1(locator).isEnabled();

			} catch (Exception ignored) {
				result= false;
				//throw e;
			} 
		}
		else{
			result = false;
		}
		return result;
	}



	public boolean isVisible3(String locator) throws NoSuchElementException {
		//log.trace("Entering method isVisible [locator='"+locator+"']");
		//waitForSpinnerDisable();
		boolean result = true;
		/*WebElement element=findWebElement(locator);
		WebDriverWait wait = new WebDriverWait(webDriver, 20);
		//wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));*/
		if(!isBlankOrNull(locator)){
			try {

				result=findWebElement3(locator).isDisplayed();

			} catch (Exception ignored) {
				result= false;
				//throw e;
			} 
		}
		else{
			result = false;
		}
		//info("Exiting method isVisible returning result="+result);
		//log.trace("Exiting method isVisible returning result="+result);
		return result;
	}

	public boolean isVisible2(String locator) throws NoSuchElementException {
		//log.trace("Entering method isVisible [locator='"+locator+"']");
		//waitForSpinnerDisable();
		boolean result = true;

		if(!isBlankOrNull(locator)){
			try {

				result=findWebElement2(locator).isDisplayed();

			} catch (Exception ignored) {
				result= false;
				//throw e;
			} 
		}
		else{
			result = false;
		}
		//info("Exiting method isVisible returning result="+result);
		//log.trace("Exiting method isVisible returning result="+result);
		return result;
	}

	public boolean isVisible(By locator) {
		//log.trace("Entering method isVisible [locator='"+locator+"']");
		boolean result = true;

		try {

			result =webDriver.findElement(locator).isDisplayed();

		} catch (Exception e) {
			result= false;
			//throw e;
		} 
		//info("Exiting method isVisible returning result="+result);
		//log.trace("Exiting method isVisible returning result="+result);
		return result;
	}
	public void waitForElementToAppear(String locator,int waitTimeInSeconds)
	{
		waitForSpinnerDisable();
		for(int i=0;i<waitTimeInSeconds;i++)
		{
			if(isVisible3(locator))
			{
				break;
			}
			else
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void waitForProtractorElementToAppear(String locator,int waitTimeInSeconds)
	{
		for(int i=0;i<waitTimeInSeconds;i++)
		{
			WebDriverWait wait = new WebDriverWait(webDriver,waitTimeInSeconds);
			JavascriptExecutor jsExec = (JavascriptExecutor) webDriver;

			String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

			//Wait for ANGULAR to load
			ExpectedCondition<Boolean> angularLoad = webDriver -> Boolean.valueOf(((JavascriptExecutor) webDriver)
					.executeScript(angularReadyScript).toString());

			//Get Angular is Ready
			boolean angularReady = Boolean.valueOf(jsExec.executeScript(angularReadyScript).toString());

			//Wait ANGULAR until it is Ready!
			if(!angularReady) {

				//Wait for Angular to load
				wait.until(angularLoad);
			} else {
				break;
			}
			sleep(1000);
		}
	}

	public void waitForElementToPresent(By locator,int waitTimeInSeconds)
	{
		for(int i=0;i<waitTimeInSeconds;i++)
		{
			if(isElementPresent(locator))
			{
				break;
			}
			else
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void waitForElementToAppear(String locator,int waitTimeInSeconds,int sleepTimeInMillSeconds)
	{
		for(int i=0;i<waitTimeInSeconds;i++)
		{
			if(isVisible(locator))
			{
				break;
			}
			else
			{
				sleep(sleepTimeInMillSeconds);
			}
		}
	}

	public void sleep(int sleepTimeInMillSeconds)
	{
		waitForSpinnerDisable();
		try {
			Thread.sleep(sleepTimeInMillSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isAlertPresent(){
		try {
			webDriver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	}
	public void waitForElementToDisappear(String locator,int waitTimeInSeconds)
	{
		for(int i=0;i<waitTimeInSeconds;i++)
		{
			if(!isVisible(locator))
			{
				break;
			}
			else
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void waitForElementToDisappear(By locator,int waitTimeInSeconds)
	{
		for(int i=0;i<waitTimeInSeconds;i++)
		{
			if(!isVisible(locator))
			{
				break;
			}
			else
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void assertTrue(boolean condition, String message) {
		Assert.assertTrue(condition, message);
	}

	public static void assertFalse(boolean condition, String message) {
		Assert.assertFalse(condition, message);
	}
	public static void assertEquals(Object actual, Object expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	public static void verifyTrue(boolean condition, String message) {
		try {
			assertTrue(condition, message);
			Report.LogInfo("verifyTrue",message, "PASS");
		} catch(Throwable e) {
			addVerificationFailure(e);
			Report.LogInfo("verifyTrue",message, "FAIL");
			failureLog(message, "verifyTrue: " + condition);
		}
	}

	public static void verifyFalse(boolean condition) {
		verifyFalse(condition, "");
	}

	public static void verifyFalse(boolean condition, String message) {
		try {
			assertFalse(condition, message);
			Report.LogInfo("verifyFalse",message, "PASS");
		} catch(Throwable e) {
			addVerificationFailure(e);
			failureLog(message, "verifyFalse: " + condition);
			Report.LogInfo("verifyFalse",message, "FAIL");
		}
	}

	public static void verifyEquals(boolean actual, boolean expected) {
		verifyEquals(actual, expected, "");
	}

	public static void verifyEquals(Object actual, Object expected) {
		verifyEquals(actual, expected, "");
	}

	public static void verifyEquals(Object actual, Object expected, String message) {
		try {
			//log.trace("Entering method verifyEquals [actual object='"+actual +"'][expected object='"+expected +"']");
			assertEquals (actual, expected, message);
			if(message.isEmpty())
			{

				Report.LogInfo("verifyEquals","ActualDisplay text <i>'"+actual +"'</i> equal to Expected Text '<i>" +expected+"</i>'", "PASS");
			}
			else
			{
				Report.LogInfo("verifyEquals","ActualDisplay text <i>'"+actual +"'</i> equal to Expected Text '<i>" +expected+"</i>'", "PASS");
				//Report.LogInfo("verifyEquals",message, "PASS");
			}
		} catch(Throwable e) {
			//   addVerificationFailure(e);
			if(message.isEmpty())
			{

				Report.LogInfo("verifyEquals","ActualDisplay text <i>'"+actual +"'</i> not equal to Expected Text '<i>" +expected+"</i>'", "FAIL");
			}
			else
			{
				Report.LogInfo("verifyEquals","ActualDisplay text <i>'"+actual +"'</i> not equal to Expected Text '<i>" +expected+"</i>'", "FAIL");
			}
			failureLog(message, "verifyEquals: " + actual + " NOT EQUAL to " + expected);
		}
		//log.trace("Exiting method verifyEquals [actual object='"+actual +"'][expected object='"+expected +"']");
	}

	public static void verifyEquals(Object[] actual, Object[] expected) {
		verifyEquals(actual, expected, "");
	}

	public static void verifyEquals(Object[] actual, Object[] expected, String message) {
		try {
			assertEquals(actual, expected,"");
			Report.LogInfo("verifyEquals",actual +" Object Is verified with " +expected, "PASS");
		} catch(Throwable e) {
			String failureReason = "verifyEquals: " + actual + " NOT EQUAL to " + expected;
			Report.LogInfo("verifyEquals",actual +" Object Is not verified with " +expected, "FAIL");

			failureReason += "\n\t\tExpected:";
			for (int i=0; i<expected.length; i++)
			{
				failureReason += (String) expected[i] + "|";
			}

			failureReason += "\n\t\tActual  : |";
			for (int i=0; i<actual.length; i++)
			{
				failureReason += (String) actual[i] + "|";
			}
			addVerificationFailure(e);
			failureLog(message, failureReason);
		}
	}


	public static void logVerificationFailure (Exception e, String message) {

		addVerificationFailure(e);
		failureLog(message, "Failure due to exception: " + e.getMessage());


	}

	public static void fail(String message) {
		Assert.fail(message);
	}

	public static List<Throwable> getVerificationFailures() {
		List<Throwable> verificationFailures = verificationFailuresMap.get(Reporter.getCurrentTestResult());
		return verificationFailures == null ? new ArrayList<Throwable>() : verificationFailures;
	}


	public static void addVerificationFailure(Throwable e)  {

		try{
			List<Throwable> verificationFailures = getVerificationFailures();
			verificationFailuresMap.put(Reporter.getCurrentTestResult(), verificationFailures);

			verificationFailures.add(e);
			failureLog (Reporter.getCurrentTestResult().getName(), "Verification Failure # " + verificationFailures.size());
			verificationFailuresMap.put(Reporter.getCurrentTestResult(), verificationFailures);

			// takeSnapshot(Reporter.getCurrentTestResult().getName() + " Failure # " + verificationFailures.size());
		}catch (Exception ex) {
			ex.getMessage();
		}
	}



	protected static void failureLog (String customMessage, String failureReason) {

		if (customMessage == "")
		{
			//log.debug("\n\t" + failureReason);
			info("\n\t" + failureReason);
			//log.trace("\n\t" + failureReason);
		}
		else
		{
			//log.debug("\n\t" + customMessage + "\n\t\t" + failureReason);

			info("\n\t" + customMessage + "\n\t\t" + failureReason);
			//log.trace("\n\t" + customMessage + "\n\t\t" + failureReason);
		}
	}


	public String getFirstSelectedOptionFromDropdown(String locator)
	{

		//log.trace("Entering method getFirstSelectedOptionFromDropdown [locator="+locator+"]");

		WebElement element = findWebElement(locator);

		//log.debug("Found element for locator [element='"+element+"']");

		Select select = new Select(element);
		String getSelectedOptionText=select.getFirstSelectedOption().toString();


		info("Select locator [locator='"+locator+"']");
		//log.trace("Exiting method getFirstSelectedOptionFromDropdown");

		return getSelectedOptionText;
	}

	public int getXPathCount(String locator) {

		setImplicitWaitTimeout(2);
		return findWebElements(locator).size();
	} 

	public static String removeStart(String str, String remove)
	{
		//log.trace((new StringBuilder()).append("Entering method removeStart [str=").append(str).append(", remove=").append(remove).append("]").toString());
		String returnStr = "";
		if(isBlankOrNull(str) || isBlankOrNull(remove))
		{
			//log.debug((new StringBuilder()).append("Returned value is [str='").append(str).append("']").toString());
			returnStr = str;
		}
		if(str.startsWith(remove))
			returnStr = str.substring(remove.length());
		//log.trace((new StringBuilder()).append("Exiting method removeStart [returnStr='").append(returnStr).append("']").toString());
		return returnStr;


	}
	public static boolean isEmptyOrNull(String str)
	{
		//log.debug((new StringBuilder()).append("Inside isEmptyOrNull [str=").append(str).append("]").toString());
		return str == null || str.length() == 0;
	}

	public static boolean isFieldNone(String str)
	{
		//log.debug((new StringBuilder()).append("Inside isEmptyOrNull [str=").append(str).append("]").toString());
		return str.equalsIgnoreCase("None");
	}

	public static boolean isBlankOrNull(String str)
	{
		//log.debug((new StringBuilder()).append("Inside isBlankOrNull [str=").append(str).append("]").toString());
		return str == null || str.trim().length() == 0;
	}

	public static boolean isAlphanumeric(String str)
	{
		//log.trace((new StringBuilder()).append("Entering method isAlphanumeric [str=").append(str).append("]").toString());
		if(isBlankOrNull(str))
		{
			//log.debug("returning false");
			return false;
		}
		int sz = str.length();
		for(int i = 0; i < sz; i++)
			if(!Character.isLetterOrDigit(str.charAt(i)))
			{
				//log.debug("returning false");
				return false;
			}

		//log.trace("Exiting method isAlphanumeric");
		return true;
	}

	public static boolean validateT(Object spattern, String text, WebElement webElement) {

		String patternToBeMatched = (String) spattern;
		Pattern pattern = Pattern.compile(patternToBeMatched);

		Matcher matcher = pattern.matcher(text);
		if (!matcher.matches()) {
			//					System.out.println("FAIL");
			((JavascriptExecutor)webDriver).executeScript("arguments[0].style.border='3px solid red'", webElement);
			Report.LogInfo("validateStringPatternMatch", "Text \"" + text + "\" is not matched with pattern : \""+ spattern + "\"", "FAIL");
		}
		else
		{
			//					System.out.println("PASS");
			((JavascriptExecutor)webDriver).executeScript("arguments[0].style.border='3px solid green'", webElement);
			Report.LogInfo("validateStringPatternMatch", "Text \"" + text + "\" is matched with pattern : \""+ spattern + "\"", "PASS");
		}
		return matcher.matches();
	}

	public static boolean validate(Object spattern, String text) {

		String patternToBeMatched = (String) spattern;
		Pattern pattern = Pattern.compile(patternToBeMatched);

		Matcher matcher = pattern.matcher(text);
		if (!matcher.matches()) {
			//					System.out.println("FAIL");
			Report.LogInfo("validateStringPatternMatch", "Text \"" + text + "\" is not matched with pattern : \""+ spattern + "\"", "FAIL");
		}
		else
		{
			//					System.out.println("PASS");
			Report.LogInfo("validateStringPatternMatch", "Text \"" + text + "\" is matched with pattern : \""+ spattern + "\"", "PASS");
		}
		return matcher.matches();
	}

	public static boolean isNumeric(String str)
	{
		//log.trace((new StringBuilder()).append("Entering method isNumeric [str=").append(str).append("]").toString());
		if(str == null)
		{
			//log.debug("returning false");
			return false;
		}
		int sz = str.length();
		for(int i = 0; i < sz; i++)
			if(!Character.isDigit(str.charAt(i)))
			{
				//log.debug("returning false");
				return false;
			}

		//log.debug("returning true");
		//log.trace("Exiting method isNumeric");
		return true;
	}

	public boolean switchWindow(String urlContent, String windowName)
	{
		boolean flag=false;
		Set<String> handlers = webDriver.getWindowHandles();  
		if (webDriver.getWindowHandles().size()>= 1)
		{  
			for(String handler : handlers)
			{  
				webDriver.switchTo().window(handler);  
				if (webDriver.getCurrentUrl().contains(urlContent))
				{  
					Report.LogInfo("switchWindow", "Window switch to "+windowName, "INFO");
					flag=true;
					break;  
				}  
			}  
		}  
		else Report.LogInfo("switchWindow", "Window "+windowName+" not present", "FAIL");
		return flag;

	}	    

	public void setWin(String title){

		String currentHandle =webDriver.getWindowHandle();


		for (String handle : webDriver.getWindowHandles()) {

			if (title.equals(webDriver.switchTo().window(handle).getTitle())) {
				return;
			}
		} 
		webDriver.switchTo().window(currentHandle);


	}

	public String getTitle(String currentHandle)
	{
		for (String handle : webDriver.getWindowHandles()) 
		{

			if (!currentHandle.equals(handle))
			{
				return webDriver.switchTo().window(handle).getTitle();
			}
		}
		return currentHandle; 
	}
	/*public void CheckIsLoginExist() throws InterruptedException
	{
		if(verifyExists(WILogin.Login.MailID)==true)
		{
			Report.LogInfo("Login Page Exists", "User is not login", "PASS");
		}
		else{
			verifyExists(WILogin.Login.LogoutButton,"Logout button exist");
			clickAndWait(WILogin.Login.LogoutButton);
			verifyExists(WILogin.Login.SubmitButtonForLogout,"Submit Button for Logout exist");
			clickAndWait(WILogin.Login.SubmitButtonForLogout);
			Thread.sleep(2000);
		}
	}*/

	public void isChecked(String locator, String Object)
	{


		boolean checked = webDriver.findElement(By.tagName("input")).isSelected();

		if(checked != true)
		{
			Report.LogInfo("Unchecked", Object+" Is unchecked", "INFO");
		}
		else
		{
			Report.LogInfo("Checked", Object+" Is checked", "INFO");
		}
	}



	public void theSearch(String value, String locator) throws Exception
	{
		// String xpathExpression = "//*[starts-with(@id,'searchResultsTable:')]";
		List<WebElement>  elementTable= webDriver.findElements(By.xpath(locator));



		for (WebElement listofElement : elementTable)
		{
			String theElement= listofElement.getText();

			if (theElement.contains(value)){
				Assert.assertEquals(value, theElement);
				// System.out.println("The Expected Value " + value + " Equals the actual " + theElement);;
			}

		}

	}

	public String getURLFromPage()
	{
		//WebDriver driver = new WebDriver();
		String url = webDriver.getCurrentUrl();
		return url;
	}



	public void waitToElementVisible(String locator1)
	{
		/*WebElement menu = webDriver.findElement(By.xpath(locator1));

				Actions builder = new Actions(webDriver);

				builder.keyDown(Keys.ARROW_DOWN).click(menu).keyUp(Keys.ARROW_UP);

				Action selectSubmenu = builder.build();
				selectSubmenu.perform();
		 */
		waitForElementToAppear(locator1, 20000);
	}


	public void waitToPageLoad()
	{
		waitForSpinnerDisable();
		JavascriptExecutor js = (JavascriptExecutor)webDriver;
		js.executeScript("return document.readyState").toString().equals("complete");
	}
	public void waitToFrameVisible()
	{
		try
		{
			sleep(8000);
			WebDriverWait driverWait = new WebDriverWait(webDriver, 20);
			driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			Thread.sleep(2000);
			//webDriver.switchTo().frame(0);
			Report.LogInfo("Element is available","Mouse over on  is done Successfully", "INFO");

		}catch(Exception e)
		{
			Report.LogInfo("Element is", "Is not Present on Screen", "FAIL");
		}
	}

	public void mouseMoveOn(String locator) 
	{
		//log.trace("Entering method mouseOver [locator="+locator+"]");

		WebElement element1 = findWebElement(locator);
		Actions builder = new Actions(webDriver);

		//builder.build().perform();
		builder.moveToElement(element1).perform();

	}

	public void keyPressOn(String locator) 
	{

		WebElement element1 = findWebElement(locator);
		Actions builder = new Actions(webDriver);

		//builder.build().perform();
		builder.keyDown(element1, Keys.CONTROL).perform();

	}




	public void clickHiddenElement(String locator)
	{
		JavascriptExecutor js = (JavascriptExecutor)webDriver;

		WebElement hiddenEle = (WebElement) js.executeScript("return document.getElementBy.Xpath(locator).mouseOver()");

		hiddenEle.click();
	}

	public static String toToggleCase(String inputString) {
		String result = "";
		for (int i = 0; i < inputString.length(); i++) {
			char currentChar = inputString.charAt(i);
			if (Character.isUpperCase(currentChar)) {
				char currentCharToLowerCase = Character.toLowerCase(currentChar);
				result = result + currentCharToLowerCase;
			} else {
				char currentCharToUpperCase = Character.toUpperCase(currentChar);
				result = result + currentCharToUpperCase;
			}
		}
		return result;
	}

	public static void readMail(String username, String password, String Subject) throws Exception
	{
		Thread.sleep(60000);
		int i=0;  
		try
		{

			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");
			props.put("mail.imap.ssl.enable", "true"); // required for Gmail
			props.put("mail.imap.sasl.enable", "true");
			props.put("mail.imap.sasl.mechanisms", "XOAUTH2");
			props.put("mail.imap.auth.login.disable", "true");
			props.put("mail.imap.auth.plain.disable", "true");

			Session session = Session.getInstance(props);
			session.setDebug(true);
			Store store = session.getStore("imaps");
			store.connect("imap.gmail.com", username, password);
			System.out.println(store);

			Folder inbox = store.getFolder("Inbox");
			inbox.open(Folder.READ_WRITE);

			FlagTerm ft =new FlagTerm(new Flags(Flags.Flag.SEEN), false);
			Message messages[] = inbox.search(ft);

			for (Message message : messages) 
			{
				message.setFlag(Flags.Flag.ANSWERED, true);
				String subject = message.getSubject();
				message.setFlag(Flags.Flag.SEEN, true);
				Address[] from = message.getFrom();
				messages = inbox.search(ft);

				if(subject.contains(Subject))
				{
					Report.LogInfo("emailVerification","New email recieved from Walsh Integrated", "PASS");

				} 
				else if(messages.length == 0)
				{
					Report.LogInfo("emailVerification","Could not find new email Walsh Integrated.", "FAIL");
				}
			}
		}
		catch (Exception e)
		{
			Report.LogInfo("Exception", "Exception in emailVerification:"+e.getMessage(),"FAIL");
		}
		Thread.sleep(2000);  
	}

	public static void emailVerification(String username, String password, String Subject ,String splitUrl, String split1, String split2) throws Exception
	{
		Thread.sleep(60000);
		int i=0;  
		try
		{

			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");
			props.put("mail.imap.ssl.enable", "true"); // required for Gmail
			props.put("mail.imap.sasl.enable", "true");
			props.put("mail.imap.sasl.mechanisms", "XOAUTH2");
			props.put("mail.imap.auth.login.disable", "true");
			props.put("mail.imap.auth.plain.disable", "true");

			Session session = Session.getInstance(props);
			session.setDebug(true);
			Store store = session.getStore("imaps");
			store.connect("imap-mail.outlook.com", username, password);
			System.out.println(store);

			Folder inbox = store.getFolder("Inbox");

			Folder sub_folder = inbox.getFolder("Other");
			inbox.open(sub_folder.READ_WRITE);

			FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
			Message messages[] = inbox.search(ft);


			for (Message message : messages) 
			{
				message.setFlag(Flags.Flag.ANSWERED, true);
				String subject = message.getSubject();
				message.setFlag(Flags.Flag.SEEN, true);
				Address[] from = message.getFrom();
				messages = inbox.search(ft);

				if(subject.contains(Subject))
				{
					Report.LogInfo("emailVerification","New email recieved from Walsh Integrated", "PASS");
					String line;
					StringBuffer buffer = new StringBuffer();
					BufferedReader reader = new BufferedReader(new InputStreamReader(message.getInputStream()));

					while ((line = reader.readLine()) != null) 
					{
						buffer.append(line);
					}
					System.out.println("Buffer Is: "+buffer);

					String activationURL = buffer.toString().split("&amp;gt;" + splitUrl)[0]
							.split(split1)[1].split(split2)[0];
					int lenght = activationURL.length();
					activationURL = activationURL.substring(1, lenght-1 );
					System.out.println("Invitation URL is: " + activationURL);


					openurl(activationURL);
					Thread.sleep(2000);

					Thread.sleep(3000);
					break;
				} 
				else if(messages.length == 0)
				{
					Report.LogInfo("emailVerification","Could not find new email from WalshIntegrated.", "FAIL");
				}
			}
		}
		catch (Exception e)
		{
			Report.LogInfo("Exception", "Exception in emailVerification:"+e.getMessage(),"FAIL");
		}
		Thread.sleep(2000);  
	}

	public boolean verifyifExists(String locator) {
		if(!isBlankOrNull(locator)){
			try {
				setImplicitWaitTimeout(2);
				WebElement element=findWebElement(locator);
				setImplicitWaitTimeout(50000);
				if(element != null)
				{
					return true;
				}
				else
				{
					return false;
				}


			} catch (Exception e) {

				setImplicitWaitTimeout(50000);
				return false;
			} 
		}else{

			return false;
		}
	}

	@SuppressWarnings({ "deprecation", "resource" })
	public void uploadFile(String requestURL, File uploadFile1, String payload, String URLname) throws ClientProtocolException, IOException
	{
		//String requestURL = "https://tideprod-tideqa.azurewebsites.net/api/FileStorage/UploadFile/4";
		String response = null;

		HttpClient client = null;							
		client = new DefaultHttpClient();
		BasicHttpParams params = new BasicHttpParams();
		params.setBooleanParameter(HttpProtocolParams.USE_EXPECT_CONTINUE, false);
		params.setBooleanParameter(HttpConnectionParams.STALE_CONNECTION_CHECK, false);
		params.setIntParameter(HttpConnectionParams.SOCKET_BUFFER_SIZE, 8192);
		HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
		HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);

		try {
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			trustStore.load(null, null);
			SSLSocketFactory sf = new TideSSLSocketFactory(trustStore);
			sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			SchemeRegistry registry = new SchemeRegistry();
			registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
			registry.register(new Scheme("https", sf, 443));
			ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);
			client = new DefaultHttpClient(ccm);
		} catch (Exception e) {
			client = new DefaultHttpClient();
		}

		String httpPutParameter = requestURL;
		HttpPut put = new HttpPut(httpPutParameter);
		// add header
		put.setHeader("Authorization", "Bearer "+access_token);
		FileBody file = new FileBody(uploadFile1, ContentType.APPLICATION_OCTET_STREAM);

		//MultipartEntity entity = new MultipartEntity();
		//entity.addPart("file", file);

		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		builder.addPart("file", file);
		HttpEntity entity = builder.build();

		put.setEntity(entity);

		HttpResponse statusCode = client.execute(put);
		response = EntityUtils.toString(statusCode.getEntity(), "UTF-8");

		addAsDraft(payload,URLname);
	}        

	public void addAsDraft(String payload, String URLname) throws ClientProtocolException, IOException
	{

		try {

			//URL url = new URL("https://tideprod-tideqa.azurewebsites.net/api/Bordereaux/AddAsDraft");
			URL url = new URL(URLname);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("Authorization", "Bearer "+access_token	);
			conn.setRequestProperty("Accept", "application/json, text/plain, */*");

			//String payload = "{\"Bordereaux\":{\"ContractId\":\"ae790a56-93bb-4144-bdd1-0d2afa22bc2a\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"PolicyId\":\"0\",\"OriginalFileName\":\""+fileName+"\",\"UniqueFileName\":\"S12076020171002.xlsx\",\"BordereauFormatId\":\"7b7d342f-a02c-4c18-8336-11b2606b2499\",\"IsPolicyRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S12076020171002.xlsx\",\"Filesize\":25257,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauPolicy\":[]}";

			OutputStream os = conn.getOutputStream();
			os.write(payload.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "deprecation", "resource" })
	public void uploadFileQue(String requestURL, File uploadFile1, String payload, String URLname) throws ClientProtocolException, IOException
	{
		//String requestURL = "https://tideprod-tideqa.azurewebsites.net/api/FileStorage/UploadFile/4";
		String response = null;
		
		HttpClient client = null;							
		client = new DefaultHttpClient();
		BasicHttpParams params = new BasicHttpParams();
		params.setBooleanParameter(HttpProtocolParams.USE_EXPECT_CONTINUE, false);
		params.setBooleanParameter(HttpConnectionParams.STALE_CONNECTION_CHECK, false);
		params.setIntParameter(HttpConnectionParams.SOCKET_BUFFER_SIZE, 8192);
		//HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
		HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
		try {
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			trustStore.load(null, null);
			SSLSocketFactory sf = new TideSSLSocketFactory(trustStore);
			sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			SchemeRegistry registry = new SchemeRegistry();
			registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
			registry.register(new Scheme("https", sf, 443));
			ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);
			client = new DefaultHttpClient(ccm);
		} catch (Exception e) {
			client = new DefaultHttpClient();
		}

		String httpPutParameter = requestURL;
		HttpPut put = new HttpPut(httpPutParameter);
		// add header
		put.setHeader("Authorization", "Bearer "+access_token);
		FileBody file = new FileBody(uploadFile1, ContentType.APPLICATION_OCTET_STREAM);

		//MultipartEntity entity = new MultipartEntity();
		//entity.addPart("file", file);

		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		builder.addPart("file", file);
		HttpEntity entity = builder.build();

		put.setEntity(entity);

		HttpResponse statusCode = client.execute(put);
		response = EntityUtils.toString(statusCode.getEntity(), "UTF-8");
		//Form = addNewBordereauFormat(payload, URLname);
		
	}        

	public String addNewBordereauFormat(String payload, String URLname) throws ClientProtocolException, IOException
	{
		BufferedReader rd  = null;
		StringBuilder sb = null;
		String line = null; 
		String response = null;
		String formatId = null;

		try {

			//URL url = new URL("https://tideprod-tideqa.azurewebsites.net/api/Bordereaux/AddAsDraft");
			URL url = new URL(URLname);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("Authorization", "Bearer "+access_token	);
			conn.setRequestProperty("Accept", "application/json, text/plain, */*");

			//String payload = "{\"Bordereaux\":{\"ContractId\":\"ae790a56-93bb-4144-bdd1-0d2afa22bc2a\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"PolicyId\":\"0\",\"OriginalFileName\":\""+fileName+"\",\"UniqueFileName\":\"S12076020171002.xlsx\",\"BordereauFormatId\":\"7b7d342f-a02c-4c18-8336-11b2606b2499\",\"IsPolicyRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S12076020171002.xlsx\",\"Filesize\":25257,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauPolicy\":[]}";

			OutputStream os = conn.getOutputStream();
			os.write(payload.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}


			rd  = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			sb = new StringBuilder();
			while ((line = rd.readLine()) != null)
			{
				sb.append(line + '\n');
			}

			response = sb.toString();
			//System.out.println(response);
			String[] rd1 = response.split("\",\"Status");
			//System.out.println(rd1);
			String[] rd2 = rd1[0].split("ReturnData\":\"");
			//System.out.println(rd2);
			formatId = rd2[1];
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return formatId;		
	}

	@SuppressWarnings({ "deprecation", "resource" })
	public void uploadFilePolicy(String requestURL, File uploadFile1, String payload, String URLname) throws ClientProtocolException, IOException
	{
		//String requestURL = "https://tideprod-tideqa.azurewebsites.net/api/FileStorage/UploadFile/4";
		String response = null;

		HttpClient client = null;							
		client = new DefaultHttpClient();
		BasicHttpParams params = new BasicHttpParams();
		params.setBooleanParameter(HttpProtocolParams.USE_EXPECT_CONTINUE, false);
		params.setBooleanParameter(HttpConnectionParams.STALE_CONNECTION_CHECK, false);
		params.setIntParameter(HttpConnectionParams.SOCKET_BUFFER_SIZE, 8192);
		//HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
		HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
		try {
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			trustStore.load(null, null);
			SSLSocketFactory sf = new TideSSLSocketFactory(trustStore);
			sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			SchemeRegistry registry = new SchemeRegistry();
			registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
			registry.register(new Scheme("https", sf, 443));
			ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);
			client = new DefaultHttpClient(ccm);
		} catch (Exception e) {
			client = new DefaultHttpClient();
		}

		String httpPutParameter = requestURL;
		HttpPut put = new HttpPut(httpPutParameter);
		// add header
		put.setHeader("Authorization", "Bearer "+access_token);
		FileBody file = new FileBody(uploadFile1, ContentType.APPLICATION_OCTET_STREAM);

		//MultipartEntity entity = new MultipartEntity();
		//entity.addPart("file", file);

		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		builder.addPart("file", file);
		HttpEntity entity = builder.build();

		put.setEntity(entity);

		HttpResponse statusCode = client.execute(put);
		response = EntityUtils.toString(statusCode.getEntity(), "UTF-8");
		allContractFiles(payload, URLname);
	}        

	public String addNewBordereauFormatPolicy(String payload, String URLname) throws ClientProtocolException, IOException
	{
		BufferedReader rd  = null;
		StringBuilder sb = null;
		String line = null; 
		String response = null;
		String formatId = null;

		try {

			//URL url = new URL("https://tideprod-tideqa.azurewebsites.net/api/Bordereaux/AddAsDraft");
			URL url = new URL(URLname);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("Authorization", "Bearer "+access_token	);
			conn.setRequestProperty("Accept", "application/json, text/plain, */*");

			//String payload = "{\"Bordereaux\":{\"ContractId\":\"ae790a56-93bb-4144-bdd1-0d2afa22bc2a\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"PolicyId\":\"0\",\"OriginalFileName\":\""+fileName+"\",\"UniqueFileName\":\"S12076020171002.xlsx\",\"BordereauFormatId\":\"7b7d342f-a02c-4c18-8336-11b2606b2499\",\"IsPolicyRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S12076020171002.xlsx\",\"Filesize\":25257,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauPolicy\":[]}";

			OutputStream os = conn.getOutputStream();
			os.write(payload.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}


			rd  = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			sb = new StringBuilder();
			while ((line = rd.readLine()) != null)
			{
				sb.append(line + '\n');
			}

			response = sb.toString();
			//System.out.println(response);
			String[] rd1 = response.split("\",.UniqueReference");
			//System.out.println(rd1);
			String[] rd2 = rd1[0].split("IsMultipleCoverholder\":false.\"Id\":\"");
			formatId = rd2[1];
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return formatId;	

	}
	
	public String GetFolderIDPolicy(String URLname) throws ClientProtocolException, IOException
	{
		BufferedReader rd  = null;
		StringBuilder sb = null;
		String line = null; 
		String response = null;
		String Id = null;

		try {

			URL url = new URL(URLname);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("Authorization", "Bearer "+access_token	);
			conn.setRequestProperty("Accept", "application/json, text/plain, */*");

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}


			rd  = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			sb = new StringBuilder();
			while ((line = rd.readLine()) != null)
			{
				sb.append(line + '\n');
			}
			
			response = sb.toString();
			
			String[] rd1 = response.split("\"FolderId\":\"");
			String a= rd1[1];
			//System.out.println(a);
			String[] rd2 = rd1[1].split("\",\"IsLloyds\"");
			Id= rd2[0];
			//System.out.println(Id);
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return Id;	
	}

	public void allContractFiles(String payload, String URLname) throws ClientProtocolException, IOException
	{

		try {

			//URL url = new URL("https://tideprod-tideqa.azurewebsites.net/api/Bordereaux/AddAsDraft");
			URL url = new URL(URLname);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("Authorization", "Bearer "+access_token	);
			conn.setRequestProperty("Accept", "application/json, text/plain, */*");

			//String payload = "{\"Bordereaux\":{\"ContractId\":\"ae790a56-93bb-4144-bdd1-0d2afa22bc2a\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"PolicyId\":\"0\",\"OriginalFileName\":\""+fileName+"\",\"UniqueFileName\":\"S12076020171002.xlsx\",\"BordereauFormatId\":\"7b7d342f-a02c-4c18-8336-11b2606b2499\",\"IsPolicyRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S12076020171002.xlsx\",\"Filesize\":25257,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauPolicy\":[]}";

			OutputStream os = conn.getOutputStream();
			os.write(payload.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public String uploadFileInvalid(String requestURL, File uploadFile1) throws ClientProtocolException, IOException
	{
		//String requestURL = "https://tideprod-tideqa.azurewebsites.net/api/FileStorage/UploadFile/4";
		String response = null;
		String  ValMsg = null;
		HttpClient client = null;							
		client = new DefaultHttpClient();
		BasicHttpParams params = new BasicHttpParams();
		params.setBooleanParameter(HttpProtocolParams.USE_EXPECT_CONTINUE, false);
		params.setBooleanParameter(HttpConnectionParams.STALE_CONNECTION_CHECK, false);
		params.setIntParameter(HttpConnectionParams.SOCKET_BUFFER_SIZE, 8192);
		//HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
		HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
		try {
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			trustStore.load(null, null);
			SSLSocketFactory sf = new TideSSLSocketFactory(trustStore);
			sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			SchemeRegistry registry = new SchemeRegistry();
			registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
			registry.register(new Scheme("https", sf, 443));
			ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);
			client = new DefaultHttpClient(ccm);
		} catch (Exception e) {
			client = new DefaultHttpClient();
		}

		String httpPutParameter = requestURL;
		HttpPut put = new HttpPut(httpPutParameter);
		// add header
		put.setHeader("Authorization", "Bearer "+access_token);
		FileBody file = new FileBody(uploadFile1, ContentType.APPLICATION_OCTET_STREAM);

		//MultipartEntity entity = new MultipartEntity();
		//entity.addPart("file", file);

		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		builder.addPart("file", file);
		HttpEntity entity = builder.build();

		put.setEntity(entity);

		HttpResponse statusCode = client.execute(put);
		response = EntityUtils.toString(statusCode.getEntity(), "UTF-8");
		String[] rd1 = response.split("\".,.Permissions");
		System.out.println(rd1);
		String[] rd2 = rd1[0].split("ReturnMessage\":.\"");
		ValMsg = rd2[1];
		return ValMsg;

	} 

	public String ReturnFormatID()
	{
		String Url = getURLFromPage();
		String[] rd1 = Url.split("FormatId=");
		String a= rd1[1];
		//System.out.println(a);
		String[] rd2 = rd1[1].split("&isEdit=");
		String b= rd2[0];
		return b;
		//System.out.println(b);
	}
	
	public String ReturnContractID()
	{
		String Url = getURLFromPage();
		String[] rd1 = Url.split("contract/");
		String a= rd1[1];
		//System.out.println(a);
		String[] rd2 = rd1[1].split("/details/main");
		String b= rd2[0];
		return b;
		//System.out.println(b);
	}
	
	public String uploadFileAndCheckError(String requestURL, File uploadFile1) throws ClientProtocolException, IOException
	{
		//String requestURL = "https://tideprod-tideqa.azurewebsites.net/api/FileStorage/UploadFile/4";
		String response = null;
		String  ValMsg = null;
		HttpClient client = null;							
		client = new DefaultHttpClient();
		BasicHttpParams params = new BasicHttpParams();
		params.setBooleanParameter(HttpProtocolParams.USE_EXPECT_CONTINUE, false);
		params.setBooleanParameter(HttpConnectionParams.STALE_CONNECTION_CHECK, false);
		params.setIntParameter(HttpConnectionParams.SOCKET_BUFFER_SIZE, 8192);
		//HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
		HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
		try {
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			trustStore.load(null, null);
			SSLSocketFactory sf = new TideSSLSocketFactory(trustStore);
			sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			SchemeRegistry registry = new SchemeRegistry();
			registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
			registry.register(new Scheme("https", sf, 443));
			ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);
			client = new DefaultHttpClient(ccm);
		} catch (Exception e) {
			client = new DefaultHttpClient();
		}

		String httpPutParameter = requestURL;
		HttpPut put = new HttpPut(httpPutParameter);
		// add header
		put.setHeader("Authorization", "Bearer "+access_token);
		FileBody file = new FileBody(uploadFile1, ContentType.APPLICATION_OCTET_STREAM);

		//MultipartEntity entity = new MultipartEntity();
		//entity.addPart("file", file);

		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		builder.addPart("file", file);
		HttpEntity entity = builder.build();

		put.setEntity(entity);

		HttpResponse statusCode = client.execute(put);
		response = EntityUtils.toString(statusCode.getEntity(), "UTF-8");
		return response;

	} 

	public void SupplementaryPost(String payload, String URLname) throws ClientProtocolException, IOException
	{

		try {

			//URL url = new URL("https://tideprod-tideqa.azurewebsites.net/api/Bordereaux/AddAsDraft");
			URL url = new URL(URLname);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("Authorization", "Bearer "+access_token	);
			conn.setRequestProperty("Accept", "application/json, text/plain, */*");

			//String payload = "{\"Bordereaux\":{\"ContractId\":\"ae790a56-93bb-4144-bdd1-0d2afa22bc2a\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"PolicyId\":\"0\",\"OriginalFileName\":\""+fileName+"\",\"UniqueFileName\":\"S12076020171002.xlsx\",\"BordereauFormatId\":\"7b7d342f-a02c-4c18-8336-11b2606b2499\",\"IsPolicyRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S12076020171002.xlsx\",\"Filesize\":25257,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauPolicy\":[]}";

			OutputStream os = conn.getOutputStream();
			os.write(payload.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "deprecation", "resource" })
	public void uploadSupplementaryFile(String requestURL, File uploadFile1, String payload, String URLname, String SupplementaryPayload, String SupplementaryURL) throws ClientProtocolException, IOException
	{
		//String requestURL = "https://tideprod-tideqa.azurewebsites.net/api/FileStorage/UploadFile/4";
		String response = null;

		HttpClient client = null;       
		client = new DefaultHttpClient();
		BasicHttpParams params = new BasicHttpParams();
		params.setBooleanParameter(HttpProtocolParams.USE_EXPECT_CONTINUE, false);
		params.setBooleanParameter(HttpConnectionParams.STALE_CONNECTION_CHECK, false);
		params.setIntParameter(HttpConnectionParams.SOCKET_BUFFER_SIZE, 8192);
		HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
		HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);

		try {
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			trustStore.load(null, null);
			SSLSocketFactory sf = new TideSSLSocketFactory(trustStore);
			sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			SchemeRegistry registry = new SchemeRegistry();
			registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
			registry.register(new Scheme("https", sf, 443));
			ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);
			client = new DefaultHttpClient(ccm);
		} catch (Exception e) {
			client = new DefaultHttpClient();
		}

		String httpPutParameter = requestURL;
		HttpPut put = new HttpPut(httpPutParameter);
		// add header
		put.setHeader("Authorization", "Bearer "+access_token);
		FileBody file = new FileBody(uploadFile1, ContentType.APPLICATION_OCTET_STREAM);

		//MultipartEntity entity = new MultipartEntity();
		//entity.addPart("file", file);

		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		builder.addPart("file", file);
		HttpEntity entity = builder.build();

		put.setEntity(entity);

		HttpResponse statusCode = client.execute(put);
		response = EntityUtils.toString(statusCode.getEntity(), "UTF-8");

		//addAsDraft(payload,URLname);
		SupplementaryPost(payload,URLname);
		SupplementaryPost(SupplementaryPayload, SupplementaryURL);
	}

	@SuppressWarnings({ "deprecation", "resource" })
	public void uploadFileWithSupplementary(String requestURL, File uploadFile1, String payload, String URLname, String requestURL3, String payload3, String ID) throws ClientProtocolException, IOException
	{
		//String requestURL = "https://tideprod-tideqa.azurewebsites.net/api/FileStorage/UploadFile/4";
		String response = null;

		HttpClient client = null;       
		client = new DefaultHttpClient();
		BasicHttpParams params = new BasicHttpParams();
		params.setBooleanParameter(HttpProtocolParams.USE_EXPECT_CONTINUE, false);
		params.setBooleanParameter(HttpConnectionParams.STALE_CONNECTION_CHECK, false);
		params.setIntParameter(HttpConnectionParams.SOCKET_BUFFER_SIZE, 8192);
		HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
		HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);

		try {
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			trustStore.load(null, null);
			SSLSocketFactory sf = new TideSSLSocketFactory(trustStore);
			sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			SchemeRegistry registry = new SchemeRegistry();
			registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
			registry.register(new Scheme("https", sf, 443));
			ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);
			client = new DefaultHttpClient(ccm);
		} catch (Exception e) {
			client = new DefaultHttpClient();
		}

		String httpPutParameter = requestURL;
		HttpPut put = new HttpPut(httpPutParameter);
		// add header
		put.setHeader("Authorization", "Bearer "+access_token);
		FileBody file = new FileBody(uploadFile1, ContentType.APPLICATION_OCTET_STREAM);

		//MultipartEntity entity = new MultipartEntity();
		//entity.addPart("file", file);

		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		builder.addPart("file", file);
		HttpEntity entity = builder.build();

		put.setEntity(entity);

		HttpResponse statusCode = client.execute(put);
		response = EntityUtils.toString(statusCode.getEntity(), "UTF-8");

		String returnData = addNewBordereauFormat(payload,URLname);
		requestURL3 = requestURL3+returnData+"/"+ID;
		addAsDraft(payload3, requestURL3);
		//SupplementaryPost(payload1,URLname1);
	}

	public static ExpectedCondition<Boolean> angularHasFinishedProcessing() {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular !== undefined) && (angular.element(document).injector() !== undefined) && (angular.element(document).injector().get('$http').pendingRequests.length === 0)").toString());
			}
		};
	}

	public void dragDropElement(String dragLocator, String dropLocator) 
	{

		WebElement element1 = findWebElement(dragLocator);
		WebElement element2 = findWebElement(dropLocator);
		Actions builder = new Actions(webDriver);

		//builder.build().perform();
		builder.dragAndDrop(element1, element2).perform();

	}


	public void SelectDropDownValue(String AppConditionValue, String DrpValue)
	{
		Actions builder = new Actions(webDriver);
		for(int i= 1; i<=9; i++)
		{
			sleep(1000);
			waitForElementToAppear(AppConditionValue,3);
			javaScriptclick(AppConditionValue,"App Condition Drop Down");
			sleep(2000);
			if(isVisible(DrpValue)==true)
			{
				javaScriptclick(DrpValue,"Select Drop Down value");
				break;
			}
			if(i==9){
				builder.sendKeys(Keys.ARROW_DOWN).perform();
				builder.sendKeys(Keys.ENTER).perform();
				break;
			}
		}
	}
		
	public void SelectDropDownValue1(String AppConditionValue, String DrpValue)
	{
		Actions builder = new Actions(webDriver);
		for(int i= 1; i<=9; i++)
		{
			sleep(1000);
			waitForElementToAppear(AppConditionValue,3);
			click(AppConditionValue,"App Condition Drop Down");
			sleep(2000);
			if(isVisible(DrpValue)==true)
			{
				javaScriptclick(DrpValue,"Select Drop Down value");
				break;
			}
			if(i==9){
				builder.sendKeys(Keys.ARROW_DOWN).perform();
				builder.sendKeys(Keys.ENTER).perform();
				break;
			}
		}
	}

	public void scrollUp() 
	{
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
	}
	public void scrollDown() 
	{
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, 250);");
	}
}
