package automation_Testing;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginToLogout {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	} 
	
	public static void main(String[] args) throws InterruptedException {
		

	    WebDriver driver = new ChromeDriver();
		
	    driver.get("https://reviews.kasplo.com/auth/login");
	
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   // Login Credentials
	  
	    driver.manage().window().maximize();
	    driver.findElement(By.id("email")).sendKeys("support@kasplo.com");
	    driver.findElement(By.id("password")).sendKeys("Demo@1609");
	    driver.findElement(By.xpath("//button[@type='sumit']")).click();
	    Thread.sleep(5000);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    // Verify the Home Page
	     if(driver.getCurrentUrl().equals("https://reviews.kasplo.com/app/dashboard")) 
	     {
	    	  System.out.println("Logged in successfully!");
	           Thread.sleep(3000);
	   	    driver.findElement(By.xpath("//p[text()='kasplo-test-store']")).click();
//Thread.sleep(3000);
	   	    driver.findElement(By.xpath("//div[text()='Logout']")).click();
// Verify the logout feature
// Thread.sleep(3000);
	   	    if(driver.getCurrentUrl().contains("https://reviews.kasplo.com/auth/login")) {
	   	    	
	   	           System.out.println("Logout successfully!");
// Thread.sleep(3000);
	   	           
	   	    driver.close();
	   	    }
	   	    else {
	   	    	System.out.println("Logout failed or Login page not loaded.");
	   	    	driver.close();
	   	    }
	    	
	    }
	    else {
	    	System.out.println("Login failed or home page not loaded.");
	    }
	    
	    
	}


}
