package seleniumAssignments;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollWeb {
	WebDriver driver;

	@BeforeMethod
	public void BeforeMethod() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mounika.n01\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("http://openclinic.sourceforge.net/openclinic/home/index.php");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Test()
	public void A5ScrollWeb() throws InterruptedException {

		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(1000);

	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		driver.quit();
	}

}
