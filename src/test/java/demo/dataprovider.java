package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataprovider {
	public static String link="https://www.saucedemo.com/v1/";
	WebDriver driver;
	
	@BeforeTest
	public void open() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(link);
		driver.manage().window().maximize();
	}
	@Test (dataProvider = "dp")
	public void login(String unam,String password) throws InterruptedException {
		WebElement uname=driver.findElement(By.name("user-name"));
		uname.sendKeys(unam);
		Thread.sleep(3000);
		WebElement pass=driver.findElement(By.name("password"));
		pass.sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.navigate().back();
		driver.navigate().refresh();
	}
	@DataProvider()
	public Object[][] dp() {
		return new Object[][]{
		new Object[] {"standard_user","secret_sauce"},
		new Object[] {"abc","abc"},
	};}


}
