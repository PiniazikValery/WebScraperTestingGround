package workSpace.PageObjects;

import java.util.UUID;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import automationFramework.PageObjects.Base.BasePage;

public class LoginPage extends BasePage {
	
	public LoginPage(UUID DriverKey)
	{
		super(DriverKey);
	}
	
	@FindBy(how = How.ID, using = "usr")
	private WebElement _userNameInput;
	
	@FindBy(how = How.ID, using = "pwd")
	private WebElement _passwordInput;
	
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement _submitButton;
	
	@FindBy(how = How.XPATH, using = "//h3[@class='error' and contains(text(),'DENIED')]")
	private WebElement _accessDeniedLable;
		
	
	@FindBy(how = How.XPATH, using = "//h3[@class='error' and contains(text(),'COOKIE')]")
	private WebElement _missingCookiesLable;
	
	public void SendKeysToUserNameInput(String keys)
	{
		_userNameInput.sendKeys(keys);
	}
	
	public void SendKeysToPasswordInput(String keys)
	{
		_passwordInput.sendKeys(keys);
	}
	
	public void ClickSubmitButton()
	{
		_submitButton.click();
	}
	
	public Boolean AccessDeniedLableIsDisplayed()
	{
		return _accessDeniedLable.isDisplayed();
	}
	
	public Boolean MissingCookiesIsDisplayed()
	{
		return _missingCookiesLable.isDisplayed();
	}
}
