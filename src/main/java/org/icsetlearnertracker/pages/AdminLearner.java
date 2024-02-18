package org.icsetlearnertracker.pages;

import java.time.Duration;
import java.util.List;

import org.icsetlearnertracker.classobjects.ClassObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminLearner {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='Learners']")
    WebElement Learner;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement next;
	
	@FindBy(xpath="//div[@class='table-responsive']//child::tbody//tr")
	List<WebElement>row;
	
	@FindBy(xpath="//div[@class='table-responsive']//child::tbody//tr[1]//td")
	List<WebElement>column;
	
	public AdminLearner(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickLearner()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(Learner));
		Learner.click();
	}
	
	public boolean deletelearner(String value) throws InterruptedException
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
				
				if(ele.getText().equals(value))
						{
					
					        WebElement delete=driver.findElement(By.xpath("//div[@class='table-responsive']//child::tbody//tr[" + i + "]//td[9]/button"));
					        delete.click();
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
	
	
	public boolean updatelearner(String value) throws InterruptedException
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
				if(ele.getText().equals(value))
						{
					
					        WebElement update=driver.findElement(By.xpath("//div[@class='table-responsive']//child::tbody//tr[" + i + "]//td[8]/button"));
					        update.click();
					        ClassObjects.trainingheadleanerform.selcoursestatus("Qualified");
					        ClassObjects.trainingheadleanerform.submit.click();
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
	
	}
	


