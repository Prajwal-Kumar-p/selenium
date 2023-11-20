package demo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javascript {
public static void flash(WebElement element,WebDriver driver) {  // flash method
        
        String bgcolor= element.getCssValue("backgroundColor");//gives the background color of the element
        
        for(int i=0; i<500; i++) {  // change the background color multiple times
            changeColor("#000000",element,driver);  //#000000" -> This represent black
            changeColor(bgcolor,element,driver);  // change to it's original color
            
        }
    }
    
    public static void changeColor(String color,WebElement element,WebDriver driver) {
        JavascriptExecutor js= ((JavascriptExecutor)driver);
        
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        
        try {
            Thread.sleep(3000);
        }catch(InterruptedException e) {
            
        }
    }
    
    public static void drawBorder(WebElement element,WebDriver driver) {
        JavascriptExecutor js= ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].style.border = '3px solid red '", element);
    }
    public static String getTitleByJS(WebDriver driver) {
        JavascriptExecutor js= ((JavascriptExecutor)driver);
        String title= js.executeScript("return document.title;").toString();
        return title;
    }
    
    public static void clickElementByJS(WebElement element, WebDriver driver) {
        JavascriptExecutor js= ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].click();",element);
    }
    
    public static void generateAlert(WebDriver driver, String message) {
        JavascriptExecutor js= ((JavascriptExecutor)driver);
        js.executeScript("alert('" + message + "')");
    }
    
    public static void refreshBrowserByJS(WebDriver driver) {
        JavascriptExecutor js= ((JavascriptExecutor)driver);
        js.executeScript("history.go(0)");
    }
    
    public static void scrollIntoView(WebElement element, WebDriver driver) {
        JavascriptExecutor js= ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    public static void passingValuesUsingJS(WebElement element, String message, WebDriver driver) {
        JavascriptExecutor js= ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].value='" + message + "'", element);
    }
}
