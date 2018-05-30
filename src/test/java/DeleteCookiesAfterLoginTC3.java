package test.java;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import workSpace.TC.BaseTestCase;


public class DeleteCookiesAfterLoginTC3 extends BaseTestCase {
  @Test
  public void DeleteCookiesAfterLogin() {
	  tester.AtLoginPage().LoginWithCreds("admin", "12345");	  
	  tester.DeleteAllCookies();
	  tester.RefreshPage();
	  assertTrue(tester.AtLoginPage().SeeCookiesIsMissing());
  }
}
