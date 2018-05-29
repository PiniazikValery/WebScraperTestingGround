package workSpace.Steps;

import java.util.UUID;

import workSpace.PageObjects.LoginPage;

public class LoginPageSteps {
	private LoginPage _loginPage;
	
	public LoginPageSteps(UUID driverId)
	{
		_loginPage=new LoginPage(driverId);
	}
	
	public void LoginWithCreds(String userName,String password)
	{
		_loginPage.SendKeysToUserNameInput(userName);
		_loginPage.SendKeysToPasswordInput(password);
		_loginPage.ClickSubmitButton();
	}
	public Boolean SeeAccsessDenied()
	{
		return _loginPage.AccessDeniedLableIsDisplayed();
	}
	
	public Boolean SeeCookiesIsMissing()
	{
		return _loginPage.MissingCookiesIsDisplayed();
	}
}
