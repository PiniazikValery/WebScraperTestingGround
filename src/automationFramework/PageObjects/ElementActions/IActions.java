package automationFramework.PageObjects.ElementActions;

import org.openqa.selenium.WebElement;

public interface IActions {
	 void Click(WebElement element);
     void SendKeys(WebElement element, String keys);
     void Click(WebElement element, int delay);
     void SendKeys(WebElement element, String keys, int delay);
     void UploadFile(WebElement element, String file);
     void HowerElement(WebElement element);
     void HowerThenClick(WebElement element);
}
