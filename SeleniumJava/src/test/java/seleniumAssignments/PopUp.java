package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUp {
	WebDriver driver;

	@BeforeMethod
	public void BeforeMethod() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mounika.n01\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("http://popuptest.com/goodpopups.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Test()
	public void A3Popups() throws InterruptedException {

		driver.findElement(By.xpath("//span[@class='hamburger-section'][@role='button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='login-button'][@rel='nofollow']")).click();
		Thread.sleep(2000);

		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='popup_modal_dismiss_button']")).click();

		System.out.println(driver.getTitle());

		// driver.findElement(By.id("popup_modal_dismiss_button")).click();

		// driver.close();
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		driver.quit();
	}
}
