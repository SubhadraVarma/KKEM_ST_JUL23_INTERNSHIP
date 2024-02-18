package org.icsetlearnertracker.test;

import java.util.Arrays;
import java.util.List;

import org.icsetlearnertracker.automationconstants.AutomationConstants;
import org.icsetlearnertracker.classobjects.ClassObjects;
import org.icsetlearnertracker.pages.LoginPage;
import org.icsetlearnertracker.pages.TrainerHead;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestTrainingHead extends TestBase{
	
	 SoftAssert softassert1=new SoftAssert();
	 SoftAssert softassert2=new SoftAssert();
	 SoftAssert softassert3=new SoftAssert();
	 //SoftAssert softassert2=new SoftAssert();
	 
	 @BeforeMethod
	public void setup()
	{
		 ClassObjects.trainingheadleanerform =new TrainerHead(driver);
	}
	
	@Test(priority=-1)
	public void trainerlogin()
	{
		ClassObjects.loginpage =new LoginPage(driver);
		ClassObjects.loginpage.username("trainer");
		ClassObjects.loginpage.password("trainer@123");
		ClassObjects.loginpage.passwordvisibility();
		ClassObjects.loginpage.clicklogin();
		Assert.assertEquals(ClassObjects.loginpage.loginurl(),AutomationConstants.trainingheadpageurl);
		
	}
	
@Test(priority=0)
	public void addvalidLearner() throws InterruptedException
	{
		ClassObjects.trainingheadleanerform.addLearner();
		Assert.assertEquals(ClassObjects.trainingheadleanerform.formheading(), AutomationConstants.formheading);
		Assert.assertTrue(ClassObjects.trainingheadleanerform.setLearnerId("KKEM-ST-May22-003"),"incorrect lid");
		ClassObjects.trainingheadleanerform.setName("Ashwini Prabhu");
		List<String> expectedcourseOption=Arrays.asList("","FSD","DSA","ML-AI","RPA","ST","CSA");
		Assert.assertEqualsNoOrder(ClassObjects.trainingheadleanerform.coursedropdown(),expectedcourseOption);
	    Assert.assertFalse(ClassObjects.trainingheadleanerform.selcourse("ST"),"Mutliple dropdown");
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
	
	
	
	@Test(priority=1)
	public void bulklearner()
	{
		ClassObjects.trainingheadleanerform.addbulk();
		ClassObjects.trainingheadleanerform.uploadfile("E:\\Software_Testing\\ICSET_Internship\\Data1.csv");
		ClassObjects.trainingheadleanerform.submmitfile();
        Assert.assertEquals(ClassObjects.trainingheadleanerform.filesubmissionmessage(), AutomationConstants.learnercsvfilesubmissionmg);
        ClassObjects.trainingheadleanerform.returndashboard();
        Assert.assertEquals(ClassObjects.trainingheadleanerform.filesubmissionmessage(), AutomationConstants.filesavedmsg);
	    Assert.assertEquals(ClassObjects.trainingheadleanerform.clickOK(),AutomationConstants.trainingheadpageurl);
	   
	}
	
   
	@Test(priority=3)
	public void invalidlearner1() throws InterruptedException
	{
		ClassObjects.trainingheadleanerform.addLearner();
		
		softassert1.assertTrue(ClassObjects.trainingheadleanerform.setLearnerId("KKEM"),"incorrect lid");
		ClassObjects.trainingheadleanerform.setName("12345");
		  Assert.assertFalse(ClassObjects.trainingheadleanerform.selcoursestatus("Qualified"),"Mutliple dropdown");
	    ClassObjects.trainingheadleanerform.clicksubmit();
	    Assert.assertEquals(ClassObjects.trainingheadleanerform.usernameerror(), "Must contain letters only");
	    Assert.assertEquals(ClassObjects.trainingheadleanerform.courserror(), "Please select a course for the learner");
	    Assert.assertEquals(ClassObjects.trainingheadleanerform.cstatuserror(), "Please select the course status of the learner");
	    Assert.assertEquals(ClassObjects.trainingheadleanerform.learneriderrormsg(), "Must contain letters,numbers and - only");
	    //Assert.assertAll();
	
	}
	
@Test(priority=4)
	public void invalidlearner2() throws InterruptedException
	{
		
		softassert2.assertTrue(ClassObjects.trainingheadleanerform.setLearnerId("9012"),"incorrect lid");
		ClassObjects.trainingheadleanerform.setName("&*@#");
		
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
	    Assert.assertEquals(ClassObjects.trainingheadleanerform.usernameerror(), "Must contain letters only");
	    Assert.assertEquals(ClassObjects.trainingheadleanerform.courserror(), "Please select a course for the learner");
	    Assert.assertEquals(ClassObjects.trainingheadleanerform.learneriderrormsg(), "Must contain letters,numbers and - only");
	    softassert2.assertAll();
	
	}
	
 @Test(priority=5)
	public void invalidlearner3() throws InterruptedException
	{
		
		softassert3.assertTrue(ClassObjects.trainingheadleanerform.setLearnerId("9012"),"incorrect lid");
		ClassObjects.trainingheadleanerform.setName("Suneethi Raja");
		List<String> expectedcourseOption=Arrays.asList("","FSD","DSA","ML-AI","RPA","ST","CSA");
		Assert.assertEqualsNoOrder(ClassObjects.trainingheadleanerform.coursedropdown(),expectedcourseOption);
	    Assert.assertFalse(ClassObjects.trainingheadleanerform.selcourse("ST"),"Mutliple dropdown");
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
	
	    Assert.assertEquals(ClassObjects.trainingheadleanerform.learneriderrormsg(), "Must contain letters,numbers and - only");
	    ClassObjects.trainingheadleanerform.clickbacktodashboard();
	    softassert3.assertAll();
	   
	}
	
       @Test(priority=6)
		public void searchlearner() throws InterruptedException
		{
			ClassObjects.loginpage =new LoginPage(driver);
			Assert.assertTrue(ClassObjects.trainingheadleanerform.search("89"), "not found");
			//Thread.sleep(1000);
			ClassObjects.loginpage.logout();
		}
	 	
	
	
	
	

}
