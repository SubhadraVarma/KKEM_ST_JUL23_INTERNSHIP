package org.icsetlearnertracker.pages;

import java.time.Duration;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(css="img[class='App-logo mb-2']")
	WebElement logo;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement loginbutton;
	
	@FindBy(css="input#username")
	WebElement username;
	
	@FindBy(css="input#password")
	WebElement password;
	
	@FindBy(xpath="//input[@id='password']//following-sibling::button")
	WebElement visibilitybutton;
	
	@FindBy(css="a#basic-nav-dropdown")
	WebElement logoutdropdown;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	
	@FindBy(xpath="//input[@id='username']//following-sibling::small")
	WebElement uerror;
	
	@FindBy(xpath="//div[@class='input-group']//following-sibling::small")
	WebElement upasserror;
	
	@FindBy(xpath="//button[text()='Login']//following-sibling::small")
	WebElement allfield;
	
	@FindBy(css="div[role='alert']")
	WebElement alert;
	
	
	@FindBy(css="button[aria-label='Close alert']")
	WebElement closealert;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String loginhomepageurl()
	{
		return driver.getCurrentUrl();
	}
	
	public boolean logo()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(logo));
		boolean found=logo.isDisplayed();
		return found;
	}
	
	
	public boolean loginbutton()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(loginbutton));
		boolean found=loginbutton.isDisplayed();
		return found;
	}
	public void username(String uname)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(username));
		username.clear();
		username.sendKeys(uname);
	}
	
	public void password(String upass)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(password));
		password.clear();
		password.sendKeys(upass);
		
	}
	public String passwordvisibilitybeforeclick()
	{
		String ptype=password.getAttribute("type");
		return ptype;
		
	}
	
	
	public String passwordvisibility()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(visibilitybutton));
		visibilitybutton.click();
		String newptype=password.getAttribute("type");
		return newptype;
		
	}
	public void clicklogin()
	{
		
		loginbutton.click();
		
	}
	public String loginurl()
	{
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait1.until(ExpectedConditions.visibilityOf(logoutdropdown));
		return driver.getCurrentUrl();
	}
	
	
	public void logout() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",logoutdropdown);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(logoutdropdown));
		Thread.sleep(1000);
		logoutdropdown.click();
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait1.until(ExpectedConditions.visibilityOf(logout));
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].click();",logout);
	}
	
	public String uname_error()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",uerror);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(uerror));
		String uname_error=uerror.getText();
		return uname_error;
	}
	public String upass_error()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(upasserror));
		String upassname_error=upasserror.getText();
		return upassname_error;
	}
	
	public String allfielderror()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(allfield));
		String allfielderror_error=allfield.getText();
		return allfielderror_error;
	}
	
	public String alertbox()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(alert));
		String alertmsg=alert.getText();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",closealert);
		return alertmsg;
		
	}
	
	
	
	
	
	
	
	

}
