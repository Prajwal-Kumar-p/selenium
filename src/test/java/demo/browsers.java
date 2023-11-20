package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browsers {
	public static String url="https://demo.guru99.com/test/newtours/";
	WebDriver edriver;
	WebDriver mdriver;
	@Parameters ("mybrowser")
	
@BeforeTest
public void open() {
//
//		WebDriverManager.edgedriver().setup();
//		edriver=new EdgeDriver();
//		edriver.get(url);
		
		WebDriverManager.firefoxdriver().setup();
		mdriver=new FirefoxDriver();
		mdriver.get (url);
		}
	@Test
	public void tc1() {
		System.out.println("hello");
	}
}
