package seleniumAssignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Alerts {

	WebDriver driver;

	@BeforeTest
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mounika.n01\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://letcode.in/alert");
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws InterruptedException {
//simple alert
		driver.findElement(By.id("accept")).click();
		Alert simple = driver.switchTo().alert();
		Thread.sleep(2000);
		simple.accept();
//Confirm alert
		driver.findElement(By.id("confirm")).click();
		driver.switchTo().alert().dismiss();
//Prompt alert
		driver.findElement(By.id("prompt")).click();
		Alert prompt = driver.switchTo().alert();
		prompt.sendKeys("Mouni");
		prompt.accept();
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}

}
