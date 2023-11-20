package demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class makemytrip {
	public static String url="https://www.makemytrip.com/";
	WebDriver driver;
	ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	ExtentTest test;
	@BeforeTest
	public void open() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		htmlreporter=new ExtentHtmlReporter("extent.html");
        extent=new ExtentReports();
        extent.attachReporter(htmlreporter);
        
		driver.get(url);
		Thread.sleep(3000);
		driver.manage().window().maximize();
		test=extent.createTest("TEST CASE 1");
		WebElement pop = driver.findElement(By.xpath("//*[@id='webklipper-publisher-widget-container-notification-frame']"));
    	driver.switchTo().frame(pop);
    	test.pass("close pop ad");
        driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        test=extent.createTest("TEST CASE 2");
        test.pass("close login pop up");
    	driver.findElement(By.xpath("//*[@class='commonModal__close']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
    	driver.switchTo().defaultContent();
    	extent.flush();
	}
	@Test
	public void holidaypack() throws AWTException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		test=extent.createTest("TEST CASE 3");
		test.pass("select holiday package");
		//click on holiday package
		driver.findElement(By.linkText("Holiday Packages")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		test=extent.createTest("TEST CASE 4");
		test.pass("cancel alerts");
		//cancel in alert
		driver.findElement(By.xpath("//*[@class='primaryBtnWhite border-btn font16 latoBold']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		test=extent.createTest("TEST CASE 5");
		test.pass("scroll down");
		//scroll down
		JavascriptExecutor scroll=(JavascriptExecutor)driver;
		scroll.executeScript("window.scrollBy(0,100)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		test=extent.createTest("TEST CASE 6");
		test.pass("add from location as banglore");
		//add from location
		driver.findElement(By.xpath("//*[@data-cy='fromCity']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement from=driver.findElement(By.xpath("//*[@placeholder='Enter City']"));
		from.clear();
		from.sendKeys("Banglore");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@data-testid='Bangalore']")).click();
		
		
		test=extent.createTest("TEST CASE 7");
		test.pass("add to location as DUBAI");
		//add to location
		driver.findElement(By.xpath("//*[@data-cy='toCity']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement to=driver.findElement(By.xpath("//*[@placeholder='To']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		to.sendKeys("dubai");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("(//*[@class='dest-city-name'])[5]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		test=extent.createTest("TEST CASE 8");
		test.pass("select date from calendar");
		//to select date
		WebElement date= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div[1]/div[3]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[3]/div[7]/div/p"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		date.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		test=extent.createTest("TEST CASE 9");
		test.pass("Select guest and click apply");
		//select guest and click apply
		driver.findElement(By.xpath("(//*[@type='button'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		test=extent.createTest("TEST CASE 10");
		test.pass("Select appropriate filters and click on apply");
		//optional field selection and click apply
		Thread.sleep(3000);
		WebElement abt= driver.findElement(By.xpath("//*[@class='action']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		abt.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		test=extent.createTest("TEST CASE 11");
		test.pass("click on submit button");
		//click on submit button
		driver.findElement(By.xpath("//*[@data-cy='submit']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		test=extent.createTest("TEST CASE 12");
		test.pass("click skip button");
		//click on skip button 
		driver.findElement(By.xpath("//*[@class='skipBtn']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().refresh();
		
		extent.flush();
	}
	
	@Test
	public void selecthotel() throws InterruptedException {
		
		test=extent.createTest("TEST CASE 13");
		test.pass("scroll down");
		//scroll down
		JavascriptExecutor scroll=(JavascriptExecutor)driver;
		scroll.executeScript("window.scrollBy(0,100)");
		scroll.executeScript("window.scrollBy(0,100)");
		Thread.sleep(2000);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		test=extent.createTest("TEST CASE 14");
		test.pass("select a hotel");
		//select a hotel filter on right
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("(//*[@class=\"selected\"])[2]")).click();
//		Thread.sleep(3000);
//		driver.navigate().refresh(); 
		
		
		
		//filter on top
		driver.findElement(By.xpath("(//*[@class='daysbadge'])[1]")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		test=extent.createTest("TEST CASE 15");
		test.pass("switch to new tab");
		//switch to new tab
		Set<String> s= driver.getWindowHandles();
		String[] arr = s.toArray(new String[s.size()]);
		String child=arr[1];
		driver.switchTo().window(child);
		test=extent.createTest("TEST CASE 16");
		test.pass("click on skip button in new tab");
		driver.findElement(By.xpath("//*[@class='skipBtn']")).click();
		
		test=extent.createTest("TEST CASE 17");
		test.pass("wait for 10 secs for pop up form to appear");
		//close form 
		driver.switchTo().window(child);
		Thread.sleep(10000);
		test=extent.createTest("TEST CASE 18");
		test.pass("close the form appearing on screen");
		driver.findElement(By.xpath("//*[@id=\"modalpopup\"]/div/span")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//scroll
		test=extent.createTest("TEST CASE 19");
		test.pass("scroll down");
		scroll.executeScript("window.scrollBy(0,100)");
		Thread.sleep(4000);
		
		
		test=extent.createTest("TEST CASE 20");
		test.pass("select change hotel");
		//change hotel
		driver.findElement(By.xpath("(//*[@id='change'])[3]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		test=extent.createTest("TEST CASE 21");
		test.pass("select a new hotel from list of available hotel");
        driver.findElement(By.xpath("(//*[@class='primaryBtn fill selectBtn'])[1]")).click();
        Thread.sleep(4000);
        test=extent.createTest("TEST CASE 22");
		test.pass("click on update in price");
        driver.findElement(By.xpath("//*[@class='updatePackageBtnText font10']")).click();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        //add activity
        test=extent.createTest("TEST CASE 23");
		test.pass("select add activity");
        driver.findElement(By.xpath("//*[@id=\"initeraryNav\"]/li[5]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        test=extent.createTest("TEST CASE 24");
		test.pass("select a particual day for activity");
        driver.findElement(By.xpath("(//*[@class=\"holidaySprite activityIcon\"])[2]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        test=extent.createTest("TEST CASE 25");
		test.pass("select add activity");
        driver.findElement(By.xpath("//*[@id=\"modalpopup\"]/div/div/div/div/div[2]/div/div[6]/div[2]/div[3]/span")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        test=extent.createTest("TEST CASE 23");
		test.pass("update the added activity");
        driver.findElement(By.xpath("//*[@id=\"modalpopup\"]/div/div/div/div/div[4]/div[2]/div/p")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        test=extent.createTest("TEST CASE 24");
		test.pass("verify day plan");
        driver.findElement(By.xpath("//*[@id=\"initeraryNav\"]/li[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(4000);
        
        test=extent.createTest("TEST CASE 25");
		test.pass("verify flights");
        driver.findElement(By.xpath("//*[@id=\"initeraryNav\"]/li[2]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(4000);
        
        test=extent.createTest("TEST CASE 26");
		test.pass("verify hotel");
        driver.findElement(By.xpath("//*[@id=\"initeraryNav\"]/li[3]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(4000);
        
        test=extent.createTest("TEST CASE 27");
		test.pass("verify transfer");
        driver.findElement(By.xpath("//*[@id=\"initeraryNav\"]/li[4]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(4000);
        
        test=extent.createTest("TEST CASE 28");
		test.pass("verify activity");
        driver.findElement(By.xpath("//*[@id=\"initeraryNav\"]/li[5]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(4000);
      
        extent.flush();
	}
	
	}


