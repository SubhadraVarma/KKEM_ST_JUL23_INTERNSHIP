package org.icsetlearnertracker.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainerHead {
	
	WebDriver driver;
	
	@FindBy(css="ion-icon[name='person-add-outline']")
	WebElement addbutton;
	
	@FindBy(xpath="//div[@id='root']//child::main//child::h3")
	WebElement heading;
	
	@FindBy(css="input#learnerid")
	WebElement learnerid;
	
	@FindBy(css="input#name")
	WebElement uname;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submit;
	
	@FindBy(css="select[name='course']")
	WebElement course;
	
	@FindBy(css="select[name='project']")
	WebElement project;
	
	@FindBy(css="select[name='batch']")
	WebElement batch;
	
	@FindBy(css="select[name='cstatus']")
	WebElement cstatus;
	
	@FindBy(css="div#swal2-html-container")
	WebElement successmsg;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement okbutton;
	
	@FindBy(xpath="//button[text()='Back to Dashboard']")
	WebElement dashboard;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement next;
	
	
	@FindBy(css="ion-icon[name='cloud-upload']")
    WebElement addbulk;
    
	
	@FindBy(css="input[accept='.csv']")
	WebElement fileupload;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submitfile;
	
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement cancel;
	
	@FindBy(css="h2#swal2-title")
    WebElement submsg;
	
	@FindBy(xpath="//button[text()='Return to Dashboard']")
	WebElement returndashboard;
	
	@FindBy(xpath="//div[@class='table-responsive']//child::tbody//tr")
	List<WebElement>row;
	
	@FindBy(xpath="//div[@class='table-responsive']//child::tbody//tr[1]//td")
	List<WebElement>column;
	
	
	

	public TrainerHead(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addLearner()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(addbutton));
		JavascriptExecutor je=(JavascriptExecutor)driver;
	     je.executeScript("arguments[0].click();",addbutton);
	}
	
	public String formheading()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(heading));
		String formheading=heading.getText();
		return formheading;
	}
	
	public boolean setLearnerId(String lid) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(learnerid));
		learnerid.clear();
		learnerid.sendKeys(lid);
		String lidfield=learnerid.getAttribute("value");
	
	    String n=".*[0-9].*";
	    String a=".*[A-Za-z].*";
	    String h=".*-.*";
	  
	    boolean islidfieldvalid= lidfield.matches(n)&&lidfield.matches(a)&&lidfield.matches(h);
		return islidfieldvalid;
	    
	}	
	
	public void setName(String name)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(uname));
		uname.clear();
		uname.sendKeys(name);
	}
	
	public void clicksubmit()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(submit));
		submit.click();
	}
	
	
	public List<String> coursedropdown()
	{
		Select coursedropdown = new Select(course);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		 wait.until(ExpectedConditions.visibilityOf(course));
		 List<WebElement> dropdown = coursedropdown.getOptions();
		 List<String> actualContents = new ArrayList<String>();
		 for(WebElement ref:dropdown)
			 actualContents.add(ref.getText());
		 return actualContents;
		 
	}
	
	public boolean selcourse(String coursename)
	{
		Select coursedropdown = new Select(course);
		boolean ismultiple=coursedropdown.isMultiple();
		if (ismultiple)
		{
			coursedropdown.selectByIndex(1);
			coursedropdown.selectByValue(coursename);
			
		}
		else
		{
			coursedropdown.selectByValue(coursename);
			
		}
		return ismultiple;
	}
	
	public List<String> projectdropdown() 
	{
		Select projectdropdown = new Select(project);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		 wait.until(ExpectedConditions.visibilityOf(project));
		 List<WebElement> pdropdown = projectdropdown.getOptions();
		 List<String> actualpContents = new ArrayList<String>();
		 for(WebElement ref:pdropdown)
			 actualpContents.add(ref.getText());
		 return actualpContents;
	}
	public boolean selproject(String projectname)
	{
		Select projectdropdown = new Select(project);
		boolean ismultiple=projectdropdown.isMultiple();
		if (ismultiple)
		{
			projectdropdown.selectByIndex(1);
			projectdropdown.selectByValue(projectname);
			
		}
		else
		{
			projectdropdown.selectByValue(projectname);
			
		}
		return ismultiple;
	}
	public List<String> batchdropdown() 
	{
		Select batchdropdown = new Select(batch);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		 wait.until(ExpectedConditions.visibilityOf(project));
		 List<WebElement> bdropdown = batchdropdown.getOptions();
		 List<String> actualbcontents = new ArrayList<String>();
		 for(WebElement ref:bdropdown)
			 actualbcontents.add(ref.getText());
		 return actualbcontents;
	}
	public boolean selbatch(String value)
	{
		Select batchdropdown = new Select(batch);
		boolean ismultiple=batchdropdown.isMultiple();
		if (ismultiple)
		{
			batchdropdown.selectByIndex(1);
			batchdropdown.selectByValue(value);
			
		}
		else
		{
			batchdropdown.selectByValue(value);
			
		}
		return ismultiple;
	}
	public List<String> coursestatusdropdown() 
	{
		Select coursestatusdropdown = new Select(cstatus);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		 wait.until(ExpectedConditions.visibilityOf(cstatus));
		 List<WebElement> csdropdown = coursestatusdropdown.getOptions();
		 List<String> actualcsContents = new ArrayList<String>();
		 for(WebElement ref:csdropdown)
			 actualcsContents.add(ref.getText());
		 return actualcsContents;
	}
	public boolean selcoursestatus(String cstatusname)
	{
		Select coursestatusdropdown = new Select(cstatus);
		boolean ismultiple=coursestatusdropdown.isMultiple();
		if (ismultiple)
		{
			coursestatusdropdown.selectByIndex(1);
			coursestatusdropdown.selectByValue(cstatusname);
			
		}
		else
		{
			coursestatusdropdown.selectByValue(cstatusname);
			
		}
		
		return ismultiple;
	}
	public String submissionmsg()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		 wait.until(ExpectedConditions.visibilityOf(successmsg));
		 String smsg=successmsg.getText();
		 return smsg;
		 
	}
	public String clickOK()
	{ 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		 wait.until(ExpectedConditions.visibilityOf(okbutton));
		 JavascriptExecutor je=(JavascriptExecutor)driver;
	     je.executeScript("arguments[0].click();",okbutton);
		 return driver.getCurrentUrl();
	}
	public void clickbacktodashboard()
	{ 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		 wait.until(ExpectedConditions.visibilityOf(dashboard));
		 dashboard.click();
	}
	
	public String learneriderrormsg()
	{
		String lidmessage="Must contain letters,numbers and - only";
		return lidmessage;
	}
	
	public String usernameerror()
	{
		String unamemsg="Must contain letters only";
		return unamemsg;
		
	}
	
	public String courserror()
	{
		String courseerrormsg="Please select a course for the learner";
		return courseerrormsg;
	}
	
	public String projecterror()
	{
		String projecterrormsg="Please select a project for the learnerer";
		return projecterrormsg;
	}
	
	public String batcherror()
	{
		String batcherrormsg="Please select a batch  for the learnerrer";
		return batcherrormsg;
	}
	
	public String cstatuserror()
	{
		String cstatuserrormsg="Please select the course status of the learner";
		return cstatuserrormsg;
	}
	public boolean search(String value) throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",next);
		
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(2000));
		wait1.until(ExpectedConditions.visibilityOf(next));
		
		boolean found=false;
		
		while(next.isEnabled())
	{
		for(int i=1;i<=row.size();i++)
		{
			for(int j=1;j<=column.size();j++)
			{
				WebElement ele=driver.findElement(By.xpath("//div[@class='table-responsive']//child::tbody//tr[" + i + "]//td[1]"));
				Thread.sleep(1000);
				JavascriptExecutor jo=(JavascriptExecutor)driver;
				jo.executeScript("arguments[0].scrollIntoView()",ele);
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2000));
				wait.until(ExpectedConditions.visibilityOf(ele));
				Thread.sleep(1000);
			
				if(driver.findElement(By.xpath("//div[@class='table-responsive']//child::tbody//tr[" + i + "]//td[1]")).getText().equalsIgnoreCase(value))
			    {
					 found=true;
					 return found;
				}
				else
				{
					JavascriptExecutor ji=(JavascriptExecutor)driver;
					ji.executeScript("arguments[0].scrollIntoView()",next);
					Thread.sleep(1000);
					WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(2000));
					wait2.until(ExpectedConditions.visibilityOf(next));
					JavascriptExecutor je=(JavascriptExecutor)driver;
					je.executeScript("arguments[0].click();",next);
					Thread.sleep(1000);
				}
				
						
			}
				
			
		}
	}
		return found;
	}
	
	public void addbulk()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		 wait.until(ExpectedConditions.visibilityOf(addbulk));
		 JavascriptExecutor je=(JavascriptExecutor)driver;
	     je.executeScript("arguments[0].click();",addbulk);
	}
	
	public void uploadfile(String filename)
	{
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		 wait.until(ExpectedConditions.visibilityOf(fileupload));
		 fileupload.sendKeys(filename);
		
		 
	}
	public void submmitfile()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
	     js.executeScript("arguments[0].scrollIntoView()",submitfile);
	     WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		 wait.until(ExpectedConditions.visibilityOf(submitfile));
		 JavascriptExecutor je=(JavascriptExecutor)driver;
	     je.executeScript("arguments[0].click();",submitfile);
	}
	
	public String filesubmissionmessage()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(submsg));
		String submessage=submsg.getText();
		
		return submessage;
		
	}
	
	public void returndashboard()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(returndashboard));
		returndashboard.click();
	}
	
	public void cancel()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(cancel));
		 JavascriptExecutor je=(JavascriptExecutor)driver;
	     je.executeScript("arguments[0].click();",cancel);
	}
	
	
	
	
	
	
	
}

	
	
	
	
	


