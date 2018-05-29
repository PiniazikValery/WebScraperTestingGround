package test.java.Base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import workSpace.Users.Tester;

public class BaseTestCase {

	private String basePage = "http://testing-ground.scraping.pro/login";
	
	protected Tester tester=new Tester();
	
	@BeforeMethod
	  public void beforeTest() {
		  tester.GoToPage(basePage);
	  }
	
	@AfterMethod
	  public void afterTest() {
		  tester.FinishesWork();
	  }
}
