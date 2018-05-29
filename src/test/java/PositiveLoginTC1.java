package test.java;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import test.java.Base.BaseTestCase;

public class PositiveLoginTC1 extends BaseTestCase {
  @Test
  public void PositiveLogin() {
	 tester.AtLoginPage().LoginWithCreds("admin", "12345");	
	 assertTrue(tester.AtWelcomePage().SeeWelcomeLable());
  }
}
