package org.icsetlearnertracker.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPlacementOfficer {
	
WebDriver driver;
	
	@FindBy(xpath="//span[text()='Placement']")
    WebElement Placement;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement next;
	
	public AdminPlacementOfficer(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickPlacement()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(Placement));
		Placement.click();
	}
	
	

}
