package org.icsetlearnertracker.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop=null;

	
	@BeforeTest
	public void setUp() throws IOException
	{
		
		prop=new Properties();
		FileInputStream ip=new FileInputStream("E:\\Software_Testing\\KKEM_JULY23_ST_INTERNSHIP_SubhadraVarma\\ICSETLearnerTracker\\src\\test\\resources\\config.properties");
		prop.load(ip);
		String newBrowser=prop.getProperty("browser");
		if(newBrowser.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if(newBrowser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
	}

}
