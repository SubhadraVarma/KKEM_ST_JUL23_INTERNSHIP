package org.icsetlearnertracker.pages;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlacementOfficer {

	
	WebDriver driver;
	@FindBy(xpath="//span[text()='Next']")
	WebElement next;
	
	@FindBy(css="select[name='pstatus']")
	WebElement pstatus;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submit;
	
	@FindBy(xpath="//span[text()='Placement']")
	WebElement Placement;
	

	@FindBy(xpath="//div[@class='table-responsive']//child::tbody//tr")
	List<WebElement>row;
	
	@FindBy(xpath="//div[@class='table-responsive']//child::tbody//tr[1]//td")
	List<WebElement>column;
	
	public PlacementOfficer(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
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
				JavascriptExecutor jo=(JavascriptExecutor)driver;
				jo.executeScript("arguments[0].scrollIntoView()",ele);
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2000));
				wait.until(ExpectedConditions.visibilityOf(ele));
				Thread.sleep(1000);
				
				if(ele.getText().equalsIgnoreCase(value))
						{
					       
					        WebElement update=driver.findElement(By.xpath("//div[@class='table-responsive']//child::tbody//tr[" + i + "]//td[8]/button/ion-icon"));
					        update.click();
					        selcoursestatus("Placed");
					        submit.click();
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
	

	public void selcoursestatus(String pstatusname)
	{
		Select placementstatusdropdown = new Select(pstatus);
		placementstatusdropdown.selectByValue(pstatusname);
			
		
	}
	
	public boolean updateddata(String value) throws InterruptedException
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
				JavascriptExecutor jo=(JavascriptExecutor)driver;
				jo.executeScript("arguments[0].scrollIntoView()",ele);
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2000));
				wait.until(ExpectedConditions.visibilityOf(ele));
				Thread.sleep(1000);
				if(ele.getText().equalsIgnoreCase(value))
						{
					       
					        
					        String placement=driver.findElement(By.xpath("//div[@class='table-responsive']//child::tbody//tr[" + i + "]//td[7]")).getText();
					        if(placement.equals("Placed"))
					        {
					        	found=true;
					            return found;
					        }
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
	
	
}
