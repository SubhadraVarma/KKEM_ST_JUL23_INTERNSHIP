package org.icsetlearnertracker.pages;

import java.time.Duration;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminUser {
	
	WebDriver driver;
	
	/*@FindBy(xpath="//span[text()='Users")
	WebElement users;*/
	
	@FindBy(css="ion-icon[name='person-add-outline']")
	WebElement addbutton;
	
	@FindBy(xpath="//div[@id='root']//child::main//child::h3")
	WebElement heading;
	
	@FindBy(css="input#name")
	WebElement uname;
	
	@FindBy(css="input#email")
	WebElement email;
	
	@FindBy(css="input#username")
	WebElement username;
	
	@FindBy(css="input#password")
	WebElement password;
	
	@FindBy(css="select[name='roleInputs']")
	WebElement role;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submit;
	
	@FindBy(xpath="//button[text()='Back to Dashboard']")
	WebElement dashboard;
	
	@FindBy(xpath="//input[@id='name']//following-sibling::p")
	WebElement namemsg;
	
	@FindBy(xpath="//input[@id='email']//following-sibling::p")
	WebElement emailmsg;
	
	@FindBy(xpath="//input[@id='username']//following-sibling::p")
	WebElement usernamemsg;
	
	@FindBy(xpath="//input[@id='password']//following-sibling::p")
	WebElement passwordmsg;
	
	@FindBy(xpath="//input[@id='rolemsg']//following-sibling::p")
	WebElement rolemsg;
	
	@FindBy(css="div#swal2-html-container")
	WebElement success;
	
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement next;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement okbutton;
	
	@FindBy(xpath="//span[text()='Users']")
	WebElement users;
	
	@FindBy(xpath="//div[@class='table-responsive']//child::tbody//tr")
	List<WebElement>row;
	
	@FindBy(xpath="//div[@class='table-responsive']//child::tbody//tr[1]//td")
	List<WebElement>column;
	
	
	public AdminUser(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addLearner()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(addbutton));
		addbutton.click();
	}
	
	public String formheading()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(heading));
		String formheading=heading.getText();
		return formheading;
	}
	
	public void setName(String name)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(uname));
		uname.clear();
		uname.sendKeys(name);
	}
	
	public boolean setEmail(String mail) 
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(email));
		email.clear();
		email.sendKeys(mail);
		String emailfield=email.getAttribute("value");
		Pattern ptrn=Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}");  
		Matcher match = ptrn.matcher(emailfield); 
		boolean isemailvalid=match.find() && match.group().equals(emailfield);;
		return (isemailvalid); 
	
	}
	public boolean setusername(String uname)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(username));
		username.clear();
		username.sendKeys(uname);
		String unamefield=username.getAttribute("value");
		String regex="\\b(?=[a-z0-9]{5,})(?=[a-z0-9]*[a-z])[a-z0-9]*[0-9][a-z0-9]*\\b";
		Pattern ptrn=Pattern.compile(regex);
		Matcher match = ptrn.matcher(unamefield); 
		boolean isunamefieldvalid= match.find() && match.group().equals(unamefield);
		return isunamefieldvalid;
	}
	
	
	public boolean setpassword(String upass)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(password));
		password.clear();
		password.sendKeys(upass);
		String upassfield=password.getAttribute("value");
		String regexpass="^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,}$";
		Pattern ptrn=Pattern.compile(regexpass);
		Matcher match = ptrn.matcher(upassfield); 
		boolean ispassfieldvalid= match.find() && match.group().equals(upassfield);
		return ispassfieldvalid;
		
	}
	
	
	public boolean selrole(String rolename)
	{
		Select roledropdown = new Select(role);
		boolean ismultiple=roledropdown.isMultiple();
		if (ismultiple)
		{
			roledropdown.selectByIndex(1);
			roledropdown.selectByValue(rolename);
			
		}
		else
		{
			roledropdown.selectByValue(rolename);
			
		}
		return ismultiple;
	}
	
	public void clicksubmit()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(submit));
		submit.click();
	}
	public void clickbacktodashboard()
	{ 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		 wait.until(ExpectedConditions.visibilityOf(dashboard));
		 dashboard.click();
	}

	public String nameerrormg()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(namemsg));
		return namemsg.getText();
	}
	
	public String emailerrormsg()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(emailmsg));
		return emailmsg.getText();
	}
	
	public String usernameerrormsg()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(usernamemsg));
		return usernamemsg.getText();
	}
	
	public String passworderrormsg()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(passwordmsg));
		return passwordmsg.getText();
	}
	
	public String roleerrormsg()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(rolemsg));
		return rolemsg.getText();
	}
	
	public boolean delete(String value) throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",next);
		boolean found=false;
		while(next.isEnabled())
		{
		for(int i=1;i<=row.size();i++)
		{
			for(int j=1;j<=column.size();j++)
			{
				WebElement ele=driver.findElement(By.xpath("//div[@class='table-responsive']//child::tbody//tr[" + i + "]//td[3]"));
				JavascriptExecutor jo=(JavascriptExecutor)driver;
				jo.executeScript("arguments[0].scrollIntoView()",ele);
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2000));
				wait.until(ExpectedConditions.visibilityOf(ele));
				Thread.sleep(1000);
				if(ele.getText().equalsIgnoreCase(value))
				{
					       
					 WebElement delete=driver.findElement(By.xpath("//div[@class='table-responsive']//child::tbody//tr[" + i + "]//td[7]/button/ion-icon"));
					 delete.click();
					 found=true;
					 return found;
						
			    }
				else
				{
					JavascriptExecutor ji=(JavascriptExecutor)driver;
					ji.executeScript("arguments[0].scrollIntoView()",next);
					Thread.sleep(1000);
					WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(2000));
					 wait1.until(ExpectedConditions.visibilityOf(next));
					JavascriptExecutor je=(JavascriptExecutor)driver;
					je.executeScript("arguments[0].click();",next);
					Thread.sleep(1000);
				}
				
						
			}
				
			
		}
		}
		return found;
	}
	public boolean update(String value) throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",next);
		boolean found=false;
		while(next.isEnabled())
		{
	    for(int i=1;i<=row.size();i++)
		{
			for(int j=1;j<=column.size();j++)
			{
				WebElement ele=driver.findElement(By.xpath("//div[@class='table-responsive']//child::tbody//tr[" + i + "]//td[3]"));
				JavascriptExecutor jo=(JavascriptExecutor)driver;
				jo.executeScript("arguments[0].scrollIntoView()",ele);
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2000));
				wait.until(ExpectedConditions.visibilityOf(ele));
				Thread.sleep(1000);
				if(ele.getText().equals(value))
			    {
					 WebElement update=driver.findElement(By.xpath("//div[@class='table-responsive']//child::tbody//tr[" + i + "]//td[6]/button/ion-icon"));
					 update.click();
					 found=true;
					 return found;
				}
				else
				{
					JavascriptExecutor ji=(JavascriptExecutor)driver;
					ji.executeScript("arguments[0].scrollIntoView()",next);
					Thread.sleep(1000);
					WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(2000));
					 wait1.until(ExpectedConditions.visibilityOf(next));
					JavascriptExecutor je=(JavascriptExecutor)driver;
					je.executeScript("arguments[0].click();",next);
					Thread.sleep(1000);
				}
				
						
			}
				
			
		}
		}
		return found;
	}
	
	public String successmessage()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(success));
		return success.getText();
	}
	
	public String clickOK()
	{ 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		 wait.until(ExpectedConditions.visibilityOf(okbutton));
		 JavascriptExecutor je=(JavascriptExecutor)driver;
	     je.executeScript("arguments[0].click();",okbutton);
		 return driver.getCurrentUrl();
	}
	
	
	
	

}
