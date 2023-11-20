package demo;

import java.awt.AWTException;
import java.awt.Menu;
import java.awt.Robot;
import java.util.Iterator;
import java.util.Set;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowhandles {
	public static String link="https://www.google.co.in/";
	ChromeDriver driver;
	@BeforeTest
	public void open() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(link);
		driver.manage().window().maximize();
	}
	
	@Test
	public void wh() throws AWTException, InterruptedException {
		WebElement img= driver.findElement(By.linkText("Images"));
		Actions act=new Actions(driver);
		act.contextClick(img).build().perform();
		Robot rc=new Robot();
		rc.keyPress(MenuKeyEvent.VK_DOWN);
		rc.keyPress(MenuKeyEvent.VK_ENTER);
		String parent=driver.getWindowHandle();
		Set<String> s= driver.getWindowHandles();
		System.out.println(s);
		Iterator<String> it=s.iterator();
		while(it.hasNext()) {
			String child=it.next();
				driver.switchTo().window(child);
				String text= driver.findElement(By.xpath("//*[@class='uU7dJb']")).getText();
				System.out.println(text);
				Thread.sleep(5000);
				driver.switchTo().window(parent);
				driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys(text);	
		}
	}

}
