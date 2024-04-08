package automation_Testing;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class add_Teammate_VerifyIt {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	} 
	public static void main(String[] args) throws InterruptedException {
	
    Scanner sc = new Scanner(System.in);
  /* System.out.println("Enter the Teammate details one by one : ");
    System.out.println("Enter the Name : ");
    String Name = sc.next();
    System.out.println("Enter the Email : ");
    String Email = sc.next();
    System.out.println("Enter the pwd : ");
    String Pwd = sc.next(); */
    WebDriver driver = new ChromeDriver();	
	driver.get("https://reviews.kasplo.com/auth/login");
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().window().maximize();
	// Login Page displayed 
	Thread.sleep(3000);
    driver.findElement(By.id("email")).sendKeys("support@kasplo.com");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.findElement(By.id("password")).sendKeys("Demo@1609");
    driver.findElement(By.xpath("//button[@type='sumit']")).click();
	Thread.sleep(7000);
	
	// Verify weather Home page displayed are not?
	if(driver.getCurrentUrl().equals("https://reviews.kasplo.com/app/dashboard")) 
    {
		Thread.sleep(2000);
   	    System.out.println("Logged in successfully!");
   	    
    }
	else {
		System.out.println("Logout failed or Login page not loaded.");
	    //driver.close();
	}  	
//	WebDriverWait wait = new WebDriverWait(driver, 10);
//  WebElement homePageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pagelet_bluebar")));
    
// WebElement hpelement = driver.findElement(By.xpath("//p[text()='Dashboard']"));
	Thread.sleep(4000);
	driver.findElement(By.xpath("//p[text()='kasplo-test-store']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[text()='Users']")).click();
	Thread.sleep(5000);
	// Enter the Teammate details 
   /* driver.findElement(By.xpath("//button[text()='Add Teammates']")).click();
    Thread.sleep(3000);
 
    driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys(Name);
    driver.findElement(By.xpath("//input[@placeholder='Enter Email Address']")).sendKeys(Email);
    driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(Pwd);
    // Save Teammate 
    driver.findElement(By.xpath("//button[text()='Save Teammate']")).click(); 
    */
    // Verify the Table 
    WebElement Table = driver.findElement(By.xpath("//table[@aria-label='custom pagination table']"));
    List<WebElement> rows = Table.findElements(By.tagName("tr"));
    
    // Name to search
    String desiredName = "Naveen";
    boolean nameFound = false;
    for (WebElement row : rows) {
        // Get all cells in the current row
        java.util.List<WebElement> cells = row.findElements(By.tagName("td"));

        // Iterate through each cell in the row to check for the desired name
        for (WebElement cell : cells) {
            if (cell.getText().contains(desiredName)) {
                nameFound = true;
                break; // Exit the loop if the name is found
            }
        }

        if (nameFound) {
            break; // Exit the outer loop if the name is found in any row
        }
    }

    // Verify if the name was found in the table
    if (nameFound) {
        System.out.println("The name '" + desiredName + "' is present in the table.");
    } else {
        System.out.println("The name '" + desiredName + "' is not present in the table.");
    }
	
    //WebDriverWait wait = new WebDriverWait(driver, 10);

	}

}
