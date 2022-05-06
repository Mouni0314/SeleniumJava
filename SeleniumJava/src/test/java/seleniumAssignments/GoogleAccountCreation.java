package seleniumAssignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class GoogleAccountCreation {
	WebDriver driver;

	@Test
	public void f() {
		driver.findElement(By.id("firstName")).sendKeys("Mouni");
		String atr = driver.findElement(By.id("firstName")).getAttribute("name");
		driver.findElement(By.id("lastName")).sendKeys("Kola");
		driver.findElement(By.id("username")).sendKeys("at186136");
		driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input")).sendKeys("123456@123");
		driver.findElement(By.xpath("//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")).sendKeys("123456@123");
		driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/div/button/span")).click();
		System.out.println("The attribute is:" + atr);

	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mounika.n01\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://accounts.google.com/signup");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		 //driver.close();
	}

}
