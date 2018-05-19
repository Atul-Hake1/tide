package com.tide.qa.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.paulhammant.ngwebdriver.ByAngular;
import com.tide.qa.common.TestBase;
import org.openqa.selenium.Keys;

public class AngularHelper extends TestBase
{
	public static WebElement findByModel(String model) 
	{
	  return webDriver.findElement(ByAngular.model(model));
	}

	  public static List<WebElement> findByBinding(String binding) 
	  {
	    return webDriver.findElements(ByAngular.binding(binding));
	  }

	  public static List<WebElement> findByOptions(String options) 
	  {
	    return webDriver.findElements(ByAngular.options(options));
	  }

	  public static WebElement findByButtonText(String buttonText) 
	  {
	    return webDriver.findElement(ByAngular.buttonText(buttonText));
	  }

	  public static List<WebElement> findByRepeater(String repeater) 
	  {
	    return webDriver.findElement(By.tagName("table")).findElements(ByAngular.repeater(repeater));
	  }
	  
	  /**
	   * Gets the drop down option count.
	   *
	   * @return the drop down option count make sure element should be
	   *         like.//*[contains(@id,'ui-select-choices-row-1-')]
	   */
	  public int getAngularDropDownOptionCount(List<WebElement> selectElement) {
	    int count = selectElement.size();
	    return count;
	  }

	  /**
	   * Gets the drop down options.
	   *
	   * @return the drop down options
	   */
	  public List<WebElement> getAngularDropDownOptions(List<WebElement> list) 
	  {
	    for (int i = 0; i < list.size(); i++) 
	    {
	         list.add(i, list.get(i));
	    }
	    return list;
	  }

	  /**
	   * Checks if is option text present for drop down.
	   *
	   * @param textToFind the text to find
	   * @return true, if is option text present for drop down
	   */
	  public boolean isOptionTextPresentForAngularDropdown(List<WebElement> list, String textToFind) 
	  {
	    List<WebElement> options = getAngularDropDownOptions(list);
	    boolean found = false;
	    if (options != null & !options.isEmpty()) {
	      for (WebElement option : options) {
	        if (option.getText().equalsIgnoreCase(textToFind)) {
	          found = true;
	          break;
	        }
	      }
	    }
	    return found;
	  }

	  /**
	   * Select drop down option by index.
	   *
	   * @param index the index
	   */

	  public void selectAngularDropdownOptionByIndex(List<WebElement> list, int index) 
	  {
	    list.get(index - 1).click();
	  }

	  /**
	   * Select drop down option by value.
	   *
	   * @param index the index
	   */

	  public void selectAngularDropdownOptionByValue(WebElement selectElement, String optionText) 
	  {
	   
	    selectElement.click();
	    selectElement.sendKeys(optionText);
	    selectElement.sendKeys(Keys.TAB);
	  }

	  /**
	   * Clean Drop down value by name.
	   *
	   * @param index the index
	   */

	  public void clearDropDownElement(WebElement selectElement) 
	  {
	    List<WebElement> options = selectElement.findElements(By.xpath(
	        "//span[@ng-repeat='$item in $select.selected']//span[@ng-click='$select.removeChoice($index)']"));
	    if (options != null & !options.isEmpty()) {
	      for (WebElement option : options) {
	        option.click();
	      }
	    }
	  }

	  /**
	   * Get Selected Drop down value.
	   *
	   * @param index the index
	   */

	  public String selectedAngularDropDownValue(WebDriver browser, String fieldName) 
	  {
	    WebElement options;
	    options = browser.findElement(By.xpath(
	        "//div[contains(@id,'" + fieldName + "')]//span[contains(@class,'ng-binding ng-scope')]"));
	    return options.getText();
	  }
}
