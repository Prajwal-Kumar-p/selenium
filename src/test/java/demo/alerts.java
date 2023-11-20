package demo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.utils.FileUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alerts extends javascript{
	public static String url="https://demoqa.com/alerts";
	ChromeDriver driver;

@BeforeTest
public void open() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get(url); 
	driver.manage().window().maximize();
}
@Test(enabled=false,priority=0)
public void al() throws InterruptedException {
	WebElement element= driver.findElement(By.id("alertButton"));
	element.click();
	Thread.sleep(5000);
	System.out.println("click me button was clicked");
	Alert alt=driver.switchTo().alert();
	alt.accept();
	   String bgcolor= element.getCssValue("backgroundColor");//gives the background color of the element
       
       for(int i=0; i<500; i++) {  // change the background color multiple times
           changeColor("#000000",element,driver);  //#000000" -> This represent black
           //changeColor(bgcolor,element,driver);  // change to it's original color
	       Thread.sleep(3000);
	
}
}

@Test(enabled=false,priority=0)
public void al1() throws InterruptedException {
	driver.findElement(By.id("timerAlertButton")).click();
	Thread.sleep(6000);
	Alert alt=driver.switchTo().alert();
	alt.accept();
	
}

@Test(enabled=false,priority=0)
public void al2() throws InterruptedException {
	driver.findElement(By.id("confirmButton")).click();
	Alert alt=driver.switchTo().alert();
	alt.accept();
}

@Test(enabled=true,priority=0)
public void al3() throws InterruptedException, IOException {
	WebElement bt=driver.findElement(By.xpath("(//*[@type='button'])[5]"));
	JavascriptExecutor scroll=(JavascriptExecutor)driver;
	scroll.executeScript("arguments[0].scrollIntoView(true);", bt);
	//{0,100} this is for going or scrolling.
	//scroll.executeScript("window.scrollBy(0,100)");
	driver.findElement(By.xpath("(//*[@type='button'])[5]")).click();
	Alert alt=driver.switchTo().alert();
	alt.sendKeys("hello");
	alt.accept();
	//scroll.executeScript("window.scrollBy(0,-100)");
	//scroll.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	
	TakesScreenshot ss=(TakesScreenshot)driver;
	File fil=ss.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(fil,new File("C:\\Users\\Admin\\Pictures\\selenium screen shots\\alertss.png") );
}




 
/*@AfterTest
public void close() {
	driver.close();
}*/

}
