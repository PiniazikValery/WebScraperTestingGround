package automationFramework.PageObjects.ElementActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automationFramework.Waiters.Waiter;

public class Actions implements IActions {
	
	private Waiter waiter;
	
	private WebDriver driver;
	
	public Actions(WebDriver driver)
	{
		this.driver=driver;
		this.waiter=new Waiter(driver);
	}
	
	public void Click(WebElement element)
	{
		waiter.WaitForElementIsDisplayed(element);
		waiter.WaitForElementIsEnabled(element);
		waiter.WaitForElementIsVisible(element);
		waiter.WaitForElementIsClickable(element);
		element.click();
	}
	
	public void SendKeys(WebElement element, String keys)
	{
		waiter.WaitForElementIsDisplayed(element);
		waiter.WaitForElementIsEnabled(element);
		waiter.WaitForElementIsVisible(element);
		waiter.WaitForElementIsClickable(element);
		element.sendKeys(keys);
	}
	
	public void Click(WebElement element, int delay)
	{
		waiter.WaitForElementIsDisplayed(element);
		waiter.WaitForElementIsEnabled(element);
		waiter.WaitForElementIsVisible(element);
		waiter.WaitForElementIsClickable(element);
		waiter.Wait(delay);
		element.click();
	}
	
	public void SendKeys(WebElement element, String keys, int delay)
	{
		waiter.WaitForElementIsDisplayed(element);
		waiter.WaitForElementIsEnabled(element);
		waiter.WaitForElementIsVisible(element);
		waiter.WaitForElementIsClickable(element);
		waiter.Wait(delay);
		element.sendKeys(keys);
	}
	
	public void UploadFile(WebElement element, String file)
	{
		waiter.WaitForElementIsDisplayed(element);
		waiter.WaitForElementIsEnabled(element);
		waiter.WaitForElementIsVisible(element);
		waiter.WaitForElementIsClickable(element);
		element.sendKeys(file);
	}
	
	public void HowerElement(WebElement element)
	{
		waiter.WaitForElementIsDisplayed(element);
		waiter.WaitForElementIsEnabled(element);
		waiter.WaitForElementIsVisible(element);
		waiter.WaitForElementIsClickable(element);
		new org.openqa.selenium.interactions.Actions(this.driver).moveToElement(element).perform();
		
	}
	
	public void HowerThenClick(WebElement element)
	{
		waiter.WaitForElementIsDisplayed(element);
		waiter.WaitForElementIsEnabled(element);
		waiter.WaitForElementIsVisible(element);
		waiter.WaitForElementIsClickable(element);
		HowerElement(element);
		Click(element);
	}	
}
