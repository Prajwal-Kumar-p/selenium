package demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class junitano {
	WebDriver driver;
	@Before
	public void bef() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
	}
	@Test
	public void tc1() {
		String tit= driver.getTitle();
		System.out.println("titel of page is "+tit);
	}
	@Test
	public void tc2() {
		System.out.println(driver.getCurrentUrl());
	}
	@After
	public void close() {
		driver.close();
	}
	

}
