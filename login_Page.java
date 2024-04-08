package automation_Testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login_Page {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	} 
	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
		driver.get("https://reviews.kasplo.com/auth/login");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		   // Login Credentials
		//    Thread.sleep(3000);
		    driver.manage().window().maximize();
		    driver.findElement(By.id("email")).sendKeys("support@kasplo.com");
		    driver.findElement(By.id("password")).sendKeys("Demo@1609");
		    driver.findElement(By.xpath("//button[@type='sumit']")).click();
		    Thread.sleep(7000);
		   
		    if(driver.getCurrentUrl().contains("https://reviews.kasplo.com/app/dashboard")) {
		    	System.out.println("Logged in successfully!");
		    	driver.close();
		    }
		    else {
		    	System.out.println("Login failed or home page not loaded.");
		    }
	}

}
