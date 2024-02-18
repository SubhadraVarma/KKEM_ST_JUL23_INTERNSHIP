package org.icsetlearnertracker.test;




import org.icsetlearnertracker.automationconstants.AutomationConstants;
import org.icsetlearnertracker.classobjects.ClassObjects;
import org.icsetlearnertracker.pages.AdminUser;
import org.icsetlearnertracker.pages.LoginPage;
import org.icsetlearnertracker.pages.PlacementOfficer;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestAdminUser extends TestBase{
	

	SoftAssert softassert1=new SoftAssert();
	SoftAssert softassert2=new SoftAssert();
	@BeforeMethod
	public void setup()
	{
		 ClassObjects.adminuser =new AdminUser(driver);
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
		
		
	}
   @Test(priority=0)
	public void validuserdetailsTR()
	{
		ClassObjects.adminuser.addLearner();
		ClassObjects.adminuser.formheading();
		ClassObjects.adminuser.setName("Anu Venkitesh");
		ClassObjects.adminuser.setEmail("anuvenki7@gmail.com");
		Assert.assertTrue(ClassObjects.adminuser.setusername("anuvenki7"), "Wrong username!");
		Assert.assertTrue(ClassObjects.adminuser.setpassword("anuvenki@7"),"Wrong password");
		
	    Assert.assertFalse(ClassObjects.adminuser.selrole("Training Head"),"Mutliple dropdown");
	    ClassObjects.adminuser.clicksubmit();
	    Assert.assertEquals(ClassObjects.adminuser.successmessage(), AutomationConstants.learnerformsuccessmsg);
		   
	    Assert.assertEquals(ClassObjects.adminuser.clickOK(),AutomationConstants.adminurl);
		
	}
	
 @Test(priority=1)
	public void validuserdetailsAD()
	{
		ClassObjects.adminuser.addLearner();
		
		ClassObjects.adminuser.setName("Susan George");
		ClassObjects.adminuser.setEmail("susangeo1@gmail.com");
		Assert.assertTrue(ClassObjects.adminuser.setusername("susangeo1"), "Wrong username!");
		Assert.assertTrue(ClassObjects.adminuser.setpassword("susangeo@1"),"Wrong password");
		
	    Assert.assertFalse(ClassObjects.adminuser.selrole("Admin"),"Mutliple dropdown");
	    ClassObjects.adminuser.clicksubmit();
	    Assert.assertEquals(ClassObjects.adminuser.successmessage(), AutomationConstants.learnerformsuccessmsg);
		   
	    Assert.assertEquals(ClassObjects.adminuser.clickOK(),AutomationConstants.adminurl);
		
	}
	
 @Test(priority=2)
	public void validuserdetailsPO()
	{
		ClassObjects.adminuser.addLearner();
		
		ClassObjects.adminuser.setName("Fazeela Farzan");
		Assert.assertTrue(ClassObjects.adminuser.setEmail("fazee4u@gmail.com"),"Wrong Email");
		Assert.assertTrue(ClassObjects.adminuser.setusername("fazee4u"), "Wrong username!");
		Assert.assertTrue(ClassObjects.adminuser.setpassword("fazeef@1"),"Wrong password");
		
	    Assert.assertFalse(ClassObjects.adminuser.selrole("Placement Officer"),"Mutliple dropdown");
	    ClassObjects.adminuser.clicksubmit();
	    Assert.assertEquals(ClassObjects.adminuser.successmessage(), AutomationConstants.learnerformsuccessmsg);
		   
	    Assert.assertEquals(ClassObjects.adminuser.clickOK(),AutomationConstants.adminurl);
	}
	
	
	@Test(priority=3)	
	public void invaliddetails1()
	{
		ClassObjects.adminuser.addLearner();
		ClassObjects.adminuser.setName("Fazeela123");
		softassert1.assertFalse(ClassObjects.adminuser.setEmail("fazee#u@gmail.com"),"Wrong Email");
		Assert.assertFalse(ClassObjects.adminuser.setusername("fa4u"), "Wrong username!");
		Assert.assertFalse(ClassObjects.adminuser.setpassword("faf@1ds"),"Wrong password");
		
	    Assert.assertFalse(ClassObjects.adminuser.selrole("Admin"),"Mutliple dropdown");
	    ClassObjects.adminuser.clicksubmit();
	    Assert.assertEquals(ClassObjects.adminuser.nameerrormg(), "Must contain letters only");
	   
		softassert1.assertAll();
	}
	@Test(priority=4)	
	public void invaliddetails2()
	{
		//ClassObjects.adminuser.addLearner();
		ClassObjects.adminuser.setName("Fazeela");
		Assert.assertFalse(ClassObjects.adminuser.setEmail("fazeeugmail.com"),"Wrong Email");
		softassert2.assertFalse(ClassObjects.adminuser.setusername("12345"), "Wrong username!");
		softassert2.assertFalse(ClassObjects.adminuser.setpassword("fafaa123"),"Wrong password!");
		
	    Assert.assertFalse(ClassObjects.adminuser.selrole("Admin"),"Mutliple dropdown");
	    ClassObjects.adminuser.clicksubmit();
	    Assert.assertEquals(ClassObjects.adminuser.emailerrormsg(), "Must be a valid Email ID");
	    ClassObjects.adminuser.clickbacktodashboard();
	    softassert2.assertAll();
	    
		
	}
	
	
	@Test(priority=5)	
	public void invaliddetails3() throws InterruptedException
	{
		ClassObjects.adminuser.addLearner();
		ClassObjects.loginpage =new LoginPage(driver);
		ClassObjects.adminuser.setName("Fazeela");
		Assert.assertFalse(ClassObjects.adminuser.setEmail("fazeeu@gmail"),"Wrong Email");
		softassert2.assertFalse(ClassObjects.adminuser.setusername("abcdef"), "Wrong username!");
		softassert2.assertTrue(ClassObjects.adminuser.setpassword("fafaa@123"),"Wrong password!");
		
	    Assert.assertFalse(ClassObjects.adminuser.selrole("Admin"),"Mutliple dropdown");
	    ClassObjects.adminuser.clicksubmit();
	   
	    softassert2.assertEquals(ClassObjects.adminuser.clickOK(),AutomationConstants.userformurl);
	    
	    ClassObjects.adminuser.clickbacktodashboard();
	    softassert2.assertAll();
	    
		
	}
	
	@Test(priority=6)
	public void updateuser() throws InterruptedException
	{
		ClassObjects.placementofficer =new PlacementOfficer(driver);
		ClassObjects.loginpage =new LoginPage(driver);
		Assert.assertTrue(ClassObjects.adminuser.delete("megha"),"not found");
		driver.navigate().refresh();
		ClassObjects.loginpage.logout();
		//Thread.sleep(1000);//driver.navigate().refresh();
		//Assert.assertTrue(ClassObjects.adminuser.update("megha"), "not updated");
		//ClassObjects.loginpage.logout();
	}
	
	
	@Test(priority=7)
		public void checkplacementofficer() throws InterruptedException 
		{
		    ClassObjects.loginpage =new LoginPage(driver);
			ClassObjects.loginpage.username("fazee4u");
			ClassObjects.loginpage.password("fazeef@1");
			ClassObjects.loginpage.passwordvisibility();
			ClassObjects.loginpage.clicklogin();
			Assert.assertEquals(ClassObjects.loginpage.loginurl(),AutomationConstants.placementofficerpageurl);
			ClassObjects.loginpage.logout();
			
		}
    @Test(priority=8)
		public void checktraininghead() throws InterruptedException
		{
    	    ClassObjects.loginpage =new LoginPage(driver);
			ClassObjects.loginpage.username("anuvenki7");
			ClassObjects.loginpage.password("anuvenki@7");
			ClassObjects.loginpage.passwordvisibility();
			ClassObjects.loginpage.clicklogin();
			Assert.assertEquals(ClassObjects.loginpage.loginurl(),AutomationConstants.trainingheadpageurl);
			ClassObjects.loginpage.logout();
		}
	@Test(priority=9)
		public void checkadmin() throws InterruptedException
		{
			ClassObjects.loginpage =new LoginPage(driver);
			ClassObjects.loginpage.username("susangeo1");
			ClassObjects.loginpage.password("susangeo@1");
			ClassObjects.loginpage.passwordvisibility();
			ClassObjects.loginpage.clicklogin();
			Assert.assertEquals(ClassObjects.loginpage.loginurl(),AutomationConstants.adminurl);
			ClassObjects.loginpage.logout();
		}
		
		

	
	

	
	
	
	
	

}
