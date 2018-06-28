package hris;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login{
	
	WebDriver webdriver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shivanjalisingh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.get("https://hris.qainfotech.com/login.php");
	}

	@Test(priority = 0)
	public void positiveLoginAndLogoutTest() throws InterruptedException {
		webdriver.findElement(By.className("icon-lock")).click();
		webdriver.findElement(By.id("txtUserName")).sendKeys("Shivanjalisingh");
		webdriver.findElement(By.id("txtPassword")).sendKeys("Shivanjali@321#");
		webdriver.findElement(By.name("Submit")).click();
		webdriver.findElement(By.className("user-image")).click();

		Thread.sleep(5000);
		webdriver.findElement(By.xpath("//span[.='Logout']")).click();
	}
	

	@Test(priority = 1)
	public void invalidUsername() throws InterruptedException {
		webdriver.findElement(By.className("icon-lock")).click();
		webdriver.findElement(By.id("txtUserName")).sendKeys("123");
		webdriver.findElement(By.id("txtPassword")).sendKeys("shivanjali@321#");

		webdriver.findElement(By.name("Submit")).click();
		webdriver.findElement(By.className("icon-lock")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void enterOnlyPassword() {

		webdriver.findElement(By.id("txtPassword")).sendKeys("Shivanjali@321#");
		webdriver.findElement(By.name("Submit")).click();

	}
	
	@Test(priority = 3)
	public void invalidpassword() throws InterruptedException {
		webdriver.findElement(By.className("icon-lock")).click();
		webdriver.findElement(By.id("txtUserName")).sendKeys("shivanjalisingh");
		webdriver.findElement(By.id("txtPassword")).sendKeys("12345");

		webdriver.findElement(By.name("Submit")).click();
		webdriver.findElement(By.className("icon-lock")).click();
		Thread.sleep(3000);
	
}
	@Test(priority = 4)
	public void enteronlypassword() throws InterruptedException {
		webdriver.findElement(By.className("icon-lock")).click();
		webdriver.findElement(By.id("txtUserName")).sendKeys("Shivanjalisingh");	
		webdriver.findElement(By.name("Submit")).click();
		webdriver.findElement(By.className("icon-lock")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 5)
	
	public void forgotpassword() throws InterruptedException  {
		  webdriver.findElement(By.xpath("//*[text()[contains(.,'Forgot Password')]]")).click();

			
		 for (String handle : webdriver.getWindowHandles()) {

			   webdriver.switchTo().window(handle);
			  }
		 webdriver.findElement(By.name("login")).sendKeys("shivanjalisingh");
			webdriver.findElement(By.name("mail")).sendKeys("shivanjalisingh@qainfotech.com");
			Thread.sleep(2000);
			webdriver.findElement(By.xpath("//input[@type='submit']")).click();
			
	}
			  
			    
	}

