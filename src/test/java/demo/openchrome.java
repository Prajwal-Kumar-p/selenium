package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class openchrome {
	
	public static String url="https://demo.guru99.com/test/newtours/";
	WebDriver driver;
	
	ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	ExtentTest test;
	
    @BeforeTest
    public void bt() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:/Users/Downloads/drivers/chromedriver.exe");
    	WebDriverManager.chromedriver().setup();
    	driver=new ChromeDriver();
        driver.get(url);
        
        htmlreporter=new ExtentHtmlReporter("extent.html");
        extent=new ExtentReports();
        extent.attachReporter(htmlreporter);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
    }
    @Test (enabled = true,priority=0)
    
    public void tc1() throws InterruptedException {
    test=extent.createTest("this is first test");
    Thread.sleep(2000);
    WebElement usr=driver.findElement(By.xpath("//*[@type='text']"));
    test.pass("passing username");
    usr.sendKeys("user");
    Thread.sleep(2000);
    test.pass("passing password");
    WebElement pass=driver.findElement(By.name("password"));
    Thread.sleep(2000);
    pass.sendKeys("user");
    test.pass("clicking on submit");
    driver.findElement(By.name("submit")).click();
    extent.flush();
}
    @Test(enabled = false,priority =0 )        
    public void register() {
    	driver.findElement(By.linkText("REGISTER")).click();
    	WebElement  fname=driver.findElement(By.name("firstName"));
    	fname.sendKeys("ABC");
    	WebElement  lname=driver.findElement(By.name("lastName"));
    	lname.sendKeys("BCD");
    	WebElement  phone=driver.findElement(By.name("phone"));
    	phone.sendKeys("1234567890");
    	WebElement  email=driver.findElement(By.name("userName"));
    	email.sendKeys("abcd@gmail.com");
    	WebElement  add=driver.findElement(By.name("address1"));
    	add.sendKeys("street no4");
    	WebElement  city=driver.findElement(By.name("city"));
    	city.sendKeys("MANGLORE");
    	WebElement  state=driver.findElement(By.name("state"));
    	state.sendKeys("KARNATAKA");
    	WebElement  pc=driver.findElement(By.name("postalCode"));
    	pc.sendKeys("562101"); 
    	WebElement cont=driver.findElement(By.name("country"));
    	// whenever there is a drop down option then we have to use select method 
    	Select opt=new Select(cont);
    	opt.selectByIndex(6);
    	WebElement  un=driver.findElement(By.name("email"));
    	un.sendKeys("abcd");
    	WebElement  pas=driver.findElement(By.name("password"));
    	pas.sendKeys("12345");
    	WebElement  cpas=driver.findElement(By.name("confirmPassword"));
    	cpas.sendKeys("12345");
    	driver.findElement(By.name("submit")).click();
    }
    @Test(enabled = false,priority = 0)
    public void flights() throws InterruptedException {
    	driver.findElement(By.linkText("Flights")).click();
    	Thread.sleep(3000);
    }
    @Test(enabled=false,priority = 0)
    public void links() {
    	List<WebElement> link= driver.findElements(By.tagName("a"));  //all links in a tag
    	for(int i=0;i<link.size();i++)
    	{
       	String ab=link.get(i).getAttribute("href");
       	String c="https://demo.guru99.com/test/newtours/support.php";
       	if(ab.equals(c)) {
       		System.out.println("LINKS ARE UNDER CONSTRUCTION"+link.get(i).getText());

       	}
       	else {
       		System.out.println("Links are working"+link.get(i).getText());
       	}
    	}
    }
    
    @Test(enabled=false,priority = 0)
    public void acts() {
    	// Actions are of two types 1.Mouse over actions  2.Keyboard actions
    	// Mouse over actions
    	Actions act=new Actions(driver);
    	WebElement us=driver.findElement(By.name("userName"));
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //alternative to thread.sleep
    	//web driver waits for a specificied time and it will not find the element again
    	act.contextClick(us).click().build().perform();
    	driver.close();
    }
    
    @Test(enabled=false,priority = 0)
    public void res() {
    	String expected= driver.getTitle();
    	WebElement usr=driver.findElement(By.name("userName"));
        usr.sendKeys("user");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement pass=driver.findElement(By.name("password"));
        pass.sendKeys("user");
        driver.findElement(By.name("submit")).click();
        String actual=driver.getTitle();
        System.out.println(expected);
        System.out.println(actual);
        //Assert.assertEquals(expected, actual);    //hard
        SoftAssert s=new SoftAssert();              //soft
	    s.assertEquals(expected, actual);
	    s.assertAll();
    }
    @Test(enabled=false,priority=0)
    public void keyactions() {
    	driver.findElement(By.linkText("REGISTER")).click();
    	driver.findElement(By.name("firstName")).sendKeys("abc");
    	WebElement cont= driver.findElement(By.name("country"));
    	Actions act=new Actions(driver);
    	act.sendKeys(cont,Keys.ARROW_DOWN).click().build().perform();
    	act.sendKeys(cont,Keys.ARROW_DOWN).click().build().perform();
    	
    }
  
}
