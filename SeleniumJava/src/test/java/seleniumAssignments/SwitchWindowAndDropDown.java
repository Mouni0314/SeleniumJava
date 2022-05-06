package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwitchWindowAndDropDown {
	WebDriver driver;

	@Test
	public void f() {
		driver.findElement(By.linkText("Medical Records")).click();
		driver.findElement(By.linkText("Search Patient")).click();
		WebElement dd = driver.findElement(By.id("search_type"));
		Select sc = new Select(dd);
		sc.selectByVisibleText("First Name");
		driver.findElement(By.id("search_text")).sendKeys("Mounika");
		driver.findElement(By.id("search_patient")).click();

	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mounika.n01\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		 driver.quit();
	}
}
