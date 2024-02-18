package org.icsetlearnertracker.test;

import org.icsetlearnertracker.automationconstants.AutomationConstants;
import org.icsetlearnertracker.classobjects.ClassObjects;
import org.icsetlearnertracker.pages.AdminPlacementOfficer;
import org.icsetlearnertracker.pages.LoginPage;
import org.icsetlearnertracker.pages.PlacementOfficer;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAdminPlacement extends TestBase{

	@BeforeMethod
	public void setup()
	{
		 ClassObjects.adminplacement=new AdminPlacementOfficer(driver);
	}
	
	@Test(priority=-1)
	public void checkadminloginform() throws InterruptedException 
	{
		ClassObjects.loginpage =new LoginPage(driver);
		ClassObjects.loginpage.username("sandy12");
		ClassObjects.loginpage.password("sandy@123");
		ClassObjects.loginpage.passwordvisibility();
		ClassObjects.loginpage.clicklogin();
		Assert.assertEquals(ClassObjects.loginpage.loginurl(),AutomationConstants.adminurl);
		ClassObjects.adminplacement.clickPlacement();
		
	}
	
	@Test(priority=0)
	public void updatelearner() throws InterruptedException
	{
		
		ClassObjects.placementofficer =new PlacementOfficer(driver);
		Assert.assertTrue(ClassObjects.placementofficer.search("78"), "not found");
		driver.navigate().refresh();
		Assert.assertTrue(ClassObjects.placementofficer.updateddata("78"), "not updated");
		ClassObjects.loginpage.logout();
	}
	
	
	
	
	
}
