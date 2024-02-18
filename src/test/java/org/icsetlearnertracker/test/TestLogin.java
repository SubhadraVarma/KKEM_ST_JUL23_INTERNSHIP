package org.icsetlearnertracker.test;

import org.icsetlearnertracker.automationconstants.AutomationConstants;
import org.icsetlearnertracker.classobjects.ClassObjects;
import org.icsetlearnertracker.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestLogin extends TestBase{

	
	SoftAssert softassert1=new SoftAssert();
	SoftAssert softassert2=new SoftAssert();
	
	@BeforeMethod
	public void setup()
	{
		 ClassObjects.loginpage =new LoginPage(driver);
	}
	
	public void passwordvisibility()
	{
		Assert.assertEquals(ClassObjects.loginpage.passwordvisibilitybeforeclick(), "password");
		Assert.assertEquals(ClassObjects.loginpage.passwordvisibility(), "text");
	}
	
	@Test(priority=-1)
	public void logologin()
	{
		Assert.assertEquals(ClassObjects.loginpage.loginhomepageurl(),AutomationConstants.loginhomepageurl);
		Assert.assertTrue(ClassObjects.loginpage.logo(),"Logo not found");
		Assert.assertTrue(ClassObjects.loginpage.loginbutton(),"Login button not found");
	}
	
	@Test(priority=0)
	public void checkadminloginform() throws InterruptedException 
	{
		
		ClassObjects.loginpage.username("sandy12");
		ClassObjects.loginpage.password("sandy@123");
		passwordvisibility();
		
		ClassObjects.loginpage.clicklogin();
		Assert.assertEquals(ClassObjects.loginpage.loginurl(),AutomationConstants.adminurl);
		ClassObjects.loginpage.logout();
		
	}
	@Test(priority=1)
	public void checktrainingheadloginform() throws InterruptedException
	{
		ClassObjects.loginpage.username("trainer");
		ClassObjects.loginpage.password("trainer@123");
		passwordvisibility();
		ClassObjects.loginpage.clicklogin();
		Assert.assertEquals(ClassObjects.loginpage.loginurl(),AutomationConstants.trainingheadpageurl);
		ClassObjects.loginpage.logout();
	}
	@Test(priority=2)
	public void checkplacementofficerloginform() throws InterruptedException
	{
		ClassObjects.loginpage.username("pofficer");
		ClassObjects.loginpage.password("pofficer@123");
		passwordvisibility();
		ClassObjects.loginpage.clicklogin();
		Assert.assertEquals(ClassObjects.loginpage.loginurl(),AutomationConstants.placementofficerpageurl);
		ClassObjects.loginpage.logout();
	}
	
	@Test(priority=3)
	public void blankcreds()
	{
		ClassObjects.loginpage.username("");
		ClassObjects.loginpage.password("");
		ClassObjects.loginpage.clicklogin();
		Assert.assertEquals(ClassObjects.loginpage.loginhomepageurl(),AutomationConstants.loginhomepageurl);
		Assert.assertEquals(ClassObjects.loginpage.uname_error(), "Username is required.");
		Assert.assertEquals(ClassObjects.loginpage.upass_error(), "Password is required.");
		Assert.assertEquals(ClassObjects.loginpage.allfielderror(), "Please fill in all fields.");
		Assert.assertEquals(ClassObjects.loginpage.alertbox(), "User not found !!");
		
	}
	
    @Test(priority=4)
	public void invalidcreds()
	{
		ClassObjects.loginpage.username("subz");
		ClassObjects.loginpage.password("subz12");
		passwordvisibility();
		ClassObjects.loginpage.clicklogin();
		Assert.assertEquals(ClassObjects.loginpage.loginhomepageurl(),AutomationConstants.loginhomepageurl);
		Assert.assertEquals(ClassObjects.loginpage.alertbox(), "User not found !!");
		driver.navigate().refresh();
	}
	
    @Test(priority=5)
	public void validunameblankpass()
	{
		ClassObjects.loginpage.username("trainer");
		ClassObjects.loginpage.password("");
		passwordvisibility();
		ClassObjects.loginpage.clicklogin();
		Assert.assertEquals(ClassObjects.loginpage.loginhomepageurl(),AutomationConstants.loginhomepageurl);
		Assert.assertEquals(ClassObjects.loginpage.upass_error(), "Password is required.");
		Assert.assertEquals(ClassObjects.loginpage.alertbox(), "Login Failed!!");
		driver.navigate().refresh();
	}
	
	 @Test(priority=6)
	public void blankunamevalidpass()
	{
		ClassObjects.loginpage.username("");
		ClassObjects.loginpage.password("trainer@123");
		passwordvisibility();
		ClassObjects.loginpage.clicklogin();
		Assert.assertEquals(ClassObjects.loginpage.loginhomepageurl(),AutomationConstants.loginhomepageurl);
		Assert.assertEquals(ClassObjects.loginpage.uname_error(), "Username is required.");
		Assert.assertEquals(ClassObjects.loginpage.alertbox(), "User not found !!");
		driver.navigate().refresh();
	}
	
	@Test(priority=7)
	public void invalidunamevalidpass()
	{
		ClassObjects.loginpage.username("subz");
		ClassObjects.loginpage.password("trainer@123");
		passwordvisibility();
		ClassObjects.loginpage.clicklogin();
		Assert.assertEquals(ClassObjects.loginpage.loginhomepageurl(),AutomationConstants.loginhomepageurl);
		Assert.assertEquals(ClassObjects.loginpage.alertbox(), "User not found !!");
		driver.navigate().refresh();
	}
	
	@Test(priority=8)
	public void validunameinvalidpass()
	{
		ClassObjects.loginpage.username("trainer");
		ClassObjects.loginpage.password("ad");
		passwordvisibility();
		ClassObjects.loginpage.clicklogin();
		Assert.assertEquals(ClassObjects.loginpage.loginhomepageurl(),AutomationConstants.loginhomepageurl);
		Assert.assertEquals(ClassObjects.loginpage.alertbox(), "Login Failed!!");
		driver.navigate().refresh();
	}
	
	@Test(priority=9)
	public void invaliunameblankpass() throws InterruptedException
	{
		ClassObjects.loginpage.username("subz");
		ClassObjects.loginpage.password("");
	
		ClassObjects.loginpage.clicklogin();
		Thread.sleep(1000);
		Assert.assertEquals(ClassObjects.loginpage.loginhomepageurl(),AutomationConstants.loginhomepageurl);
		Assert.assertEquals(ClassObjects.loginpage.upass_error(), "Password is required.");
		Assert.assertEquals(ClassObjects.loginpage.alertbox(), "User not found !!");
		driver.navigate().refresh();
		//softassert2.assertAll();
	}
	
	@Test(priority=10)
	public void blankunameinvalidpass()
	{
		ClassObjects.loginpage.username("");
		ClassObjects.loginpage.password("subz12");
		passwordvisibility();
		ClassObjects.loginpage.clicklogin();
		Assert.assertEquals(ClassObjects.loginpage.loginhomepageurl(),AutomationConstants.loginhomepageurl);
		Assert.assertEquals(ClassObjects.loginpage.uname_error(), "Username is required.");
		Assert.assertEquals(ClassObjects.loginpage.alertbox(), "User not found !!");
		driver.navigate().refresh();
	}
	
	@Test(priority=11)
	public void admincreds()
	{
		ClassObjects.loginpage.username("admin");
		ClassObjects.loginpage.password("admin@123");
		passwordvisibility();
		ClassObjects.loginpage.clicklogin();
		softassert1.assertEquals(ClassObjects.loginpage.loginhomepageurl(),AutomationConstants.loginhomepageurl);
		//Assert.assertEquals(ClassObjects.loginpage.alertbox(), "Login Failed!!");
		driver.navigate().refresh();
		softassert1.assertAll();
		
	}
	
	
	
	

	
	
}
