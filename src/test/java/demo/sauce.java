package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sauce {
	public static String link="https://www.saucedemo.com/v1/";
	ChromeDriver driver;
	ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void open() {
		//System.setProperty("webdriver.chrome.driver","C:/Users/Admin/Downloads/drivers/chromedriver.exe" );
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(link);
		
		 htmlreporter=new ExtentHtmlReporter("extent.html");
	     extent=new ExtentReports();
	     extent.attachReporter(htmlreporter);
		
		driver.manage().window().maximize();
	}
	@Test (enabled=true,priority=0)
	public void login() {
		test=extent.createTest("this is first test");
		WebElement uname=driver.findElement(By.name("user-name"));
		uname.sendKeys("standard_user");
		test.pass("passing username");
		WebElement pass=driver.findElement(By.name("password"));
		pass.sendKeys("secret_sauce");
		test.pass("passing password");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		test.pass("submit button is hit");
		extent.flush();
	}
	@Test (enabled=false,priority=1)
	public void atag() {
		List<WebElement> atags= driver.findElements(By.tagName("a"));
		int n=atags.size();
		System.out.println("Number of a tags are  "+n);
		for(int i=0;i<atags.size();i++)
    	{
       	String ab=atags.get(i).getAttribute("href");
       	System.out.println("anchor tag texts are "+ab);
    	}
	}

}
