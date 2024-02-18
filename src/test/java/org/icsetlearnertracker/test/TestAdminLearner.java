package org.icsetlearnertracker.test;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import org.icsetlearnertracker.automationconstants.AutomationConstants;
import org.icsetlearnertracker.classobjects.ClassObjects;
import org.icsetlearnertracker.pages.AdminLearner;
import org.icsetlearnertracker.pages.LoginPage;
import org.icsetlearnertracker.pages.TrainerHead;


public class TestAdminLearner extends TestBase{
	
	@BeforeMethod
	public void setup()
	{
		 ClassObjects.adminlearner=new AdminLearner(driver);
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
		ClassObjects.adminlearner.clickLearner();
		
		
	}
	
	@Test(priority=0)
	public void addvalidLearner() throws InterruptedException
	{
		ClassObjects.trainingheadleanerform =new TrainerHead(driver);
		ClassObjects.trainingheadleanerform.addLearner();
		Assert.assertEquals(ClassObjects.trainingheadleanerform.formheading(), AutomationConstants.formheading);
		Assert.assertTrue(ClassObjects.trainingheadleanerform.setLearnerId("KKEM-DSA-May22-004"),"incorrect lid");
		ClassObjects.trainingheadleanerform.setName("Balu Sudheer");
		List<String> expectedcourseOption=Arrays.asList("","FSD","DSA","ML-AI","RPA","ST","CSA");
		Assert.assertEqualsNoOrder(ClassObjects.trainingheadleanerform.coursedropdown(),expectedcourseOption);
	    Assert.assertFalse(ClassObjects.trainingheadleanerform.selcourse("DSA"),"Mutliple dropdown");
	    List<String> expectedprojectOption=Arrays.asList("","ICTAK","KKEM","NORKA","ABCD","KDISC");
		Assert.assertEqualsNoOrder(ClassObjects.trainingheadleanerform.projectdropdown(),expectedprojectOption);
	    Assert.assertFalse(ClassObjects.trainingheadleanerform.selproject("KKEM"),"Mutliple dropdown");
	    List<String> expectedbatchOption=Arrays.asList("","May_22","Jun_22","Jul_22","Aug_22","Dec_22","Mar_23");
	    Assert.assertEqualsNoOrder(ClassObjects.trainingheadleanerform.batchdropdown(),expectedbatchOption);
	    Assert.assertFalse(ClassObjects.trainingheadleanerform.selbatch("Jul_22"),"Mutliple dropdown");
	    List<String> expectedcoursestatusOption=Arrays.asList("","Qualified","Incompetent");
	    Assert.assertEqualsNoOrder(ClassObjects.trainingheadleanerform.coursestatusdropdown(),expectedcoursestatusOption);
	    Assert.assertFalse(ClassObjects.trainingheadleanerform.selcoursestatus("Qualified"),"Mutliple dropdown");
	    ClassObjects.trainingheadleanerform.clicksubmit();
	    Assert.assertEquals(ClassObjects.trainingheadleanerform.submissionmsg(), AutomationConstants.learnerformsuccessmsg);
	   
	    Assert.assertEquals(ClassObjects.trainingheadleanerform.clickOK(),AutomationConstants.trainingheadpageurl);
	    
	
		
		
	}
	//@Test(priority=0)
	public void bulklearner()
	{
		ClassObjects.trainingheadleanerform.addbulk();
		ClassObjects.trainingheadleanerform.uploadfile("E:\\Software_Testing\\ICSET_Internship\\Data2.csv");
		ClassObjects.trainingheadleanerform.submmitfile();
        Assert.assertEquals(ClassObjects.trainingheadleanerform.filesubmissionmessage(), AutomationConstants.learnercsvfilesubmissionmg);
        ClassObjects.trainingheadleanerform.returndashboard();
        Assert.assertEquals(ClassObjects.trainingheadleanerform.filesubmissionmessage(), AutomationConstants.filesavedmsg);
	    Assert.assertEquals(ClassObjects.trainingheadleanerform.clickOK(),AutomationConstants.trainingheadpageurl);
	   
	}
	
	@Test(priority=1)
	public void checkvalidlearner() throws InterruptedException
	{
		
		 ClassObjects.loginpage =new LoginPage(driver);
		 ClassObjects.trainingheadleanerform=new TrainerHead(driver);
		 
		 Assert.assertTrue(ClassObjects.trainingheadleanerform.search("45"), "not found");
		 Assert.assertTrue(ClassObjects.adminlearner.updatelearner("45"), "not found");
	     Assert.assertTrue(ClassObjects.adminlearner.deletelearner("45"), "not found");
		
		 Thread.sleep(1000);
		 ClassObjects.loginpage.logout();
	}
	
	
	
	
	
	

}
