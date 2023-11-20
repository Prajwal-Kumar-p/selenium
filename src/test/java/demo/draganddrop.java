package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class draganddrop {
	public static String url="https://jqueryui.com/droppable/";
	ChromeDriver driver;
	
	@BeforeTest
	public void open() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(enabled=true,priority=0)
	public void dd() throws InterruptedException{
		driver.findElements(By.tagName("iframe")).size();
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		WebElement frame= driver.findElement(By.xpath("//*[@class='demo-frame']"));
		JavascriptExecutor js= ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].style.border = '3px solid red '", frame);
        Thread.sleep(3000);
		driver.switchTo().frame(frame);
		WebElement drag =driver.findElement(By.id("draggable"));
		WebElement drop= driver.findElement(By.id("droppable"));
		Actions act=new Actions(driver);
		act.dragAndDrop(drag, drop).click().build().perform();
	}
	

}
