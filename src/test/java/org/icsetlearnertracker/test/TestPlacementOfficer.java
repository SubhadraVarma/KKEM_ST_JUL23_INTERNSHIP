package org.icsetlearnertracker.test;

import org.icsetlearnertracker.automationconstants.AutomationConstants;
import org.icsetlearnertracker.classobjects.ClassObjects;
import org.icsetlearnertracker.pages.LoginPage;
import org.icsetlearnertracker.pages.PlacementOfficer;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPlacementOfficer extends TestBase{
	
	@BeforeMethod
	public void setup()
	{
		 ClassObjects.placementofficer =new PlacementOfficer(driver);
	}
	
	@Test(priority=-1)
	public void placementofficerlogin()
	{
		ClassObjects.loginpage =new LoginPage(driver);
		ClassObjects.loginpage.username("pofficer");
		ClassObjects.loginpage.password("pofficer@123");
		ClassObjects.loginpage.passwordvisibility();
		ClassObjects.loginpage.clicklogin();
		Assert.assertEquals(ClassObjects.loginpage.loginurl(),AutomationConstants.placementofficerpageurl);
		
	}
	
	@Test(priority=1)
	public void updatelearner() throws InterruptedException
	{
		
		Assert.assertTrue(ClassObjects.placementofficer.search("45"), "not found");
		driver.navigate().refresh();
		Assert.assertTrue(ClassObjects.placementofficer.updateddata("45"), "not updated");
		ClassObjects.loginpage.logout();
	}

}
