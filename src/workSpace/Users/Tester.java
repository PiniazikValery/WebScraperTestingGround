package workSpace.Users;

import automationFramework.Drivers.Driver;
import automationFramework.Drivers.WebBrowsers;
import workSpace.Steps.LoginPageSteps;
import workSpace.Steps.WelcomePageSteps;

public class Tester {
	
private Driver driver=new Driver(WebBrowsers.Chrome);

public LoginPageSteps AtLoginPage() {
	return new LoginPageSteps(driver.GetDriverKey());
}

public WelcomePageSteps AtWelcomePage() {
	return new WelcomePageSteps(driver.GetDriverKey());
}

public void GoToPage(String url) {
	driver.GoToUrl(url);
}

public void FinishesWork() {
	driver.CloseDriver();
}

public void DeleteAllCookies()
{
	driver.GetDriver().manage().deleteAllCookies();
	}

public  void RefreshPage() {
	driver.GetDriver().navigate().refresh();
}
}
