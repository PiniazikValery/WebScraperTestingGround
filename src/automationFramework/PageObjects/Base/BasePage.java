package automationFramework.PageObjects.Base;

import java.util.Iterator;
import java.util.UUID;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import automationFramework.Drivers.Driver;
import automationFramework.PageObjects.ElementActions.Actions;
import automationFramework.PageObjects.ElementActions.IActions;

public abstract class BasePage {
	protected String PageWindow;
	
	protected IActions Perform;
	
	protected UUID DriverKey;		
	
	public BasePage(UUID DriverKey)
	{
		this.DriverKey=DriverKey;
		Perform=new Actions(Driver.GetDriver(DriverKey));
		PageFactory.initElements(Driver.GetDriver(DriverKey),this);
	}
	
	public WebDriver GetDriver()
	{
		return Driver.GetDriver(DriverKey);
	}
	
	public void SwitchWindow() {
		if (PageWindow==null) {					
			PageWindow=getLastWindow(Driver.GetDriver(DriverKey).getWindowHandles());
		}
		else {
			if (!Driver.GetDriver(DriverKey).getWindowHandles().contains(PageWindow)) {
				PageWindow=getLastWindow(Driver.GetDriver(DriverKey).getWindowHandles());
			}
		}
	}
	
	private <T> T getLastWindow(final Iterable<T> elements) {
        final Iterator<T> itr = elements.iterator();
        T lastElement = itr.next();

        while(itr.hasNext()) {
            lastElement=itr.next();
        }

        return lastElement;
    }
}
