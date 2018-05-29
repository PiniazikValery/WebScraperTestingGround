package workSpace.PageObjects;

import java.util.UUID;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import automationFramework.PageObjects.Base.BasePage;

public class WelcomePage extends BasePage {

	public WelcomePage(UUID DriverKey)
	{
		super(DriverKey);
	}
	
	@FindBy(how = How.XPATH, using = "//h3[@class='success']")
	private WebElement _welcomeLable;
	
	public Boolean WelcomeLableIsDisplayed()
	{
		return _welcomeLable.isDisplayed();
	}
}
