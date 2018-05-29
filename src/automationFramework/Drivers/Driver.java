package automationFramework.Drivers;

import java.util.HashMap;
import java.util.UUID;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Driver {

	private String BaseWindow;	
	
	private WebBrowsers browser;
	
	private UUID driverKey ;
	
	private static HashMap<UUID,WebDriver> Drivers=new HashMap<UUID,WebDriver>();
		
	public Driver(WebBrowsers browser)
	{
		this.browser=browser;
		InitBrowser(this.browser);
		BaseWindow=GetDriver().getWindowHandle();
	}
	
	public UUID GetDriverKey()
	{
		return driverKey;		
	}
	
	 public WebDriver GetDriver()
     {
         if (Drivers.get(driverKey) == null)
         {
             throw new NullPointerException("The WebDriver browser instance was not initialized. You should first call the method InitBrowser or create class by constructor.");
         }
         return Drivers.get(driverKey);
     }
	 
	 public static WebDriver GetDriver(UUID key)
     {
         if (Drivers.get(key) == null)
         {
             throw new NullPointerException("The WebDriver browser instance was not initialized. You should first call the method InitBrowser or create class by constructor.");
         }
         return Drivers.get(key);
     }
	 
	 public void SetDriver(WebDriver driver)
     {
         if (Drivers.get(driverKey) == null)
         {
             throw new NullPointerException("The WebDriver browser instance was not initialized. You should first call the method InitBrowser or create class by constructor.");
         }         
         Drivers.replace(driverKey, driver);
     }
	  
	   public void SetDriver(WebDriver driver, UUID key)
       {
           if (Drivers.get(key) == null)
           {
               throw new NullPointerException("The WebDriver browser instance was not initialized. You should first call the method InitBrowser or create class by constructor.");
           }
           Drivers.replace(key, driver);
       }
	   
	   public void GoToUrl(String url)
       {
           GetDriver().get(url);
       }
	   
	   public void InitBrowser(WebBrowsers browserName)
       {
		   	String exePath = "./drivers/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);			
           switch (browserName)
           {
               case Firefox:
                   driverKey = UUID.randomUUID();
                   Drivers.put(driverKey, new FirefoxDriver());
                   break;
               case InternetExplorer:
                   driverKey = UUID.randomUUID();
                   Drivers.put(driverKey, new InternetExplorerDriver());
                   break;
               case Chrome:
                   driverKey= UUID.randomUUID();                   
                   Drivers.put(driverKey, new ChromeDriver());
                   break;
               default:
                   driverKey = UUID.randomUUID();
                   Drivers.put(driverKey, new ChromeDriver());
                   break;
           }
       }
	   
	   public void CloseAllDrivers()
       {
           for (UUID key : Drivers.keySet())
           {
               Drivers.get(key).close();
               Drivers.get(key).quit();
           }
           Drivers.clear();
       }
	   
	   public void CloseDriver()
       {
           GetDriver().close();
           GetDriver().quit();
           Drivers.remove(driverKey);
       }
	   
	   public void SwitchWindowTo(String window)
       {
           for (String defwindow : GetDriver().getWindowHandles())
           {
               if (defwindow == window)
               {
                   GetDriver().switchTo().window(defwindow);
                   break;
               }
           }
       }
	   
	   public static void SwitchWindowTo(String window, UUID key)
       {
           for (String defwindow : GetDriver(key).getWindowHandles())
           {
               if (defwindow == window)
               {
                   GetDriver(key).switchTo().window(defwindow);
                   break;
               }
           }
       }
	   
	   public void SwitchToBaseWindow()
       {
           GetDriver().switchTo().window(BaseWindow);
       }  
}


