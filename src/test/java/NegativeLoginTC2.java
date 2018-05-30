package test.java;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import workSpace.TC.BaseTestCase;


public class NegativeLoginTC2 extends BaseTestCase{
  @Test
  public void NegativeLogin() {
	  tester.AtLoginPage().LoginWithCreds("admin", "123456");
	  assertTrue(tester.AtLoginPage().SeeAccsessDenied());
  }
}
