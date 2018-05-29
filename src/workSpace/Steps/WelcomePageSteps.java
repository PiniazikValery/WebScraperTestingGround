package workSpace.Steps;

import java.util.UUID;

import workSpace.PageObjects.WelcomePage;

public class WelcomePageSteps {
	private WelcomePage _welcomePage;
	
	public WelcomePageSteps(UUID driverId)
	{
		_welcomePage=new WelcomePage(driverId);
	}
	
	public Boolean SeeWelcomeLable()
	{
		return _welcomePage.WelcomeLableIsDisplayed();
	}
}
