package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class orange {
	public static String link="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	WebDriver driver;
	ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void open()  {
		//System.setProperty("webdriver.chrome.driver","C:/Users/Admin/Downloads/drivers/chromedriver.exe" );
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(link);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Test(enabled=true,priority=0)
	public void orangelogin() throws InterruptedException {
		htmlreporter=new ExtentHtmlReporter("extent.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		
		test=extent.createTest("login test case");
		test.pass("username is entered");
		driver.findElement(By.name("username")).sendKeys("Admin");
		Thread.sleep(3000);
		test.pass("passowrd is passed");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("admin123");
		Thread.sleep(3000);
		test.pass("login button is hit");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        extent.flush();
	}
	@Test(enabled=false,priority=1)
	public void actions() throws InterruptedException {
		WebElement usr=driver.findElement(By.name("username"));
		Actions act=new Actions(driver);
		Thread.sleep(5000);
		act.contextClick(usr).click().build().perform();
		
	}
	@Test(enabled=false,priority=1)
	public void comp() throws InterruptedException {
		String exp=driver.getTitle();
		WebElement uname=driver.findElement(By.name("username"));
		uname.sendKeys("Admin");
		Thread.sleep(3000);
		WebElement pass=driver.findElement(By.name("password"));
		pass.sendKeys("admin123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		String actual=driver.getTitle();
		System.out.println(exp);
		System.out.println(actual);
	    SoftAssert s=new SoftAssert();
	    s.assertEquals(exp, actual);
	    s.assertAll();
	    
	}
	@Test(enabled=false,priority=1)
	public void table() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("Admin");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("admin123");
		Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.findElement(By.linkText("Admin")).click();
        List<WebElement> rows= driver.findElements(By.xpath("//*[@class='oxd-table-row oxd-table-row--with-border']"));
        int n=rows.size();
        System.out.println("size of table is"+n);
	}
	@Test(enabled=false,priority=1)
	public void delrec() {
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.xpath("(//*[@type='button'])[6]")).click();
		driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
	}
	
	
}

