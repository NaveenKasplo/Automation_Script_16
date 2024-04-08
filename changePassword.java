package automation_Testing;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class changePassword {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	} 
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
	    System.out.println("Now u r in Change Password Feature : ");
	    System.out.println("Enter the Email");
	    String Email = sc.next();
	    System.out.println("Enter the Current Password : ");
	    String Pwd = sc.next();
	    System.out.println("Enter the New Password");
	    String new_pwd = sc.next();
	    
	   
	    WebDriver driver = new ChromeDriver();	
		driver.get("https://reviews.kasplo.com/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		// Login Page displayed 
		
	    driver.findElement(By.id("email")).sendKeys(Email);
	    driver.findElement(By.id("password")).sendKeys(Pwd);
	    driver.findElement(By.xpath("//button[@type='sumit']")).click();
	    Thread.sleep(4000);
		if(driver.getCurrentUrl().equals("https://reviews.kasplo.com/app/dashboard")) 
	    {
			
	   	    System.out.println("Logged in successfully!");
	   	    
	    }
		else {
			System.out.println("Logout failed or Login page not loaded.");
		    //driver.close();
		} 
		
		driver.findElement(By.xpath("//p[text()='kasplo-test-store']")).click();
	
		driver.findElement(By.xpath("//a[text()='Users']")).click();
		
		driver.findElement(By.id("currentPassword")).sendKeys(Pwd);
		driver.findElement(By.id("NewPassword")).sendKeys(new_pwd);
	
	 WebElement sumbit = driver.findElement(By.xpath("//button[@type='submit']"));
		
      //  sumbit.sendKeys("your_password");
        sumbit.sendKeys(Keys.ENTER);

		System.out.println("Congrats your Password is Reset Successfully ");
		driver.close();
	}

}
