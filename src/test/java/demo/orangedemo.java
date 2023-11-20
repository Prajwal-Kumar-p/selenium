package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class orangedemo {
	public static String link="https://developer.mozilla.org/en-US/docs/Learn/HTML/Tables/Basics";
	WebDriver driver;
	@BeforeTest
	public void orange() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver","C:/Users/Admin/Downloads/drivers/chromedriver.exe" );
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(link);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Test
	public void table() throws InterruptedException {
		List<WebElement> rows= driver.findElements(By.xpath("//*[@scope='row']"));
        int n=rows.size();
        System.out.println("size of table is"+n);
}
	}
	
