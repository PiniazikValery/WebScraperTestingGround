package automationFramework.Waiters;


import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;


public class Waiter {
	
	private WebDriver driver;
	
	private FluentWait<WebDriver> wait;
	
	public Waiter(WebDriver driver)
	{
		this.driver=driver;	
		this.wait=new FluentWait<WebDriver>(this.driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);		
	}
	
	public void WaitForElementIsClickable(WebElement element)
    {       
		wait.until(ExpectedConditions.elementToBeClickable(element));
    }
	
	public void WaitForDOMLoad() {						 
		wait.until(new Function<WebDriver, Boolean>()
		{
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor)driver).executeScript("return document.readyState")=="complete";
				}
			});
	}
	
	public void WaitForElementIsStalenessOf(WebElement element)
    {
        wait.until(ExpectedConditions.stalenessOf(element));
    }
	
	 public void Wait(int SecondsToWait)
     {
        driver.manage().timeouts().implicitlyWait(SecondsToWait,TimeUnit.SECONDS);
     }
	 public void WaitForAjaxLoad()
     {      
		 if(jQueryExists())
		 {
         wait.until(new Function<WebDriver, Boolean>()
 		{
 				public Boolean apply(WebDriver driver) {
 					return (Boolean)((JavascriptExecutor)driver).executeScript("return jQuery.active == 0");
 				}
 			});
		 }
     }
	 
	 public void WaitForElementIsDisplayed(final WebElement element) {
		 wait.until(new Function<WebDriver, Boolean>()
	 		{
	 				public Boolean apply(WebDriver driver) {
	 					return element.isDisplayed();
	 				}
	 			});
	}
	 
	 public void WaitForElementIsEnabled(final WebElement element) {
		 wait.until(new Function<WebDriver, Boolean>()
	 		{
	 				public Boolean apply(WebDriver driver) {
	 					return element.isEnabled();
	 				}
	 			});
	}
	 
	 public void WaitForElementIsVisible(WebElement element) {
		 wait.until(ExpectedConditions.visibilityOf(element));
	}
	 
	 private Boolean jQueryExists() {
		try
		{
			((JavascriptExecutor)driver).executeScript("return jQuery.active == 0");
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}	 
}
