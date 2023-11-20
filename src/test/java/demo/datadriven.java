package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.github.bonigarcia.wdm.WebDriverManager;

public class datadriven {
	public static String url="https://demo.guru99.com/test/newtours/";
	WebDriver driver;
	public String usr,pass;
	@BeforeTest
    public void bt() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
    	driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Test
	public void dd() throws IOException, InterruptedException, InvalidFormatException {
		File exfil=new File("//C://Users//Admin//Desktop/input.xlsx/");     //path of file
		 FileInputStream fis=new FileInputStream(exfil);//getting data from excel file
	        XSSFWorkbook book=new XSSFWorkbook(exfil); //telling that i want my excel sheet in XSSF format
	        XSSFSheet sheet=book.getSheet("Sheet1"); //taking the input from Sheet1 which is in XSSF format
	        int rowcount = sheet.getLastRowNum();
	        System.out.println(rowcount);
	        for(int i=0;i<=rowcount;i++) {
	            String uname = sheet.getRow(i).getCell(0).getStringCellValue();
	            String password = sheet.getRow(i).getCell(1).getStringCellValue();
	            WebElement un=driver.findElement(By.name("userName"));
	            un.sendKeys(uname);
	            WebElement pwd=driver.findElement(By.name("password"));
	            pwd.sendKeys(password);
	            driver.findElement(By.name("submit")).click();
	        }    
	    }
	
}
