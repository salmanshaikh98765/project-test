package org.testing.project_test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException 
    {
    	
    // initializing the web driver 
    System.setProperty("webdriver.chrome.driver", "/Users/Dell/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
    
    //system properties
    ChromeOptions chromeOptions = new ChromeOptions();
    //to run in headless mode
    //chromeOptions.addArguments("--headless");
    // open url
    WebDriver driver = new ChromeDriver(chromeOptions);    	
    driver.get("http://43.204.97.176:8081/contact.html");
    
    // invoke implicit wait
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    
    //enter details
    //name id - inputName
    driver.findElement(By.id("inputName")).sendKeys("Salman");
	Thread.sleep(2000);
    //contact id - inputNumber
    driver.findElement(By.id("inputNumber")).sendKeys("0000000000");
    Thread.sleep(2000);
    //email id - inputMail
    driver.findElement(By.id("inputMail")).sendKeys("salman@xyz.com");
    Thread.sleep(2000);
    //message id - inputMessage
    driver.findElement(By.id("inputMessage")).sendKeys("Hello");
    Thread.sleep(2000);
    //send button id - my-button
    driver.findElement(By.id("my-button")).click();
    Thread.sleep(2000);
    //response message id - response
    String response = driver.findElement(By.id("response")).getText();	
    
    //for screen shot
    TakesScreenshot scrShot = ((TakesScreenshot)driver);
    //for saving the screenshots
    File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
    //this dest is locally 
    File destFile = new File("/Users/Dell/Documents/test-reports.jpg");
    //this dest is in ubuntu jenkins server
   // File destFile = new File("/home/ubuntu/test-reports.jpg");
    FileUtils.copyFile(srcFile, destFile);
    Thread.sleep(1000);
    
    System.out.println(response);
    driver.quit();
        
    }
}
