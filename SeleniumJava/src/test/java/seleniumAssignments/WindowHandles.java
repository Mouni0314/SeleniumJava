package seleniumAssignments;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindowHandles {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mounika.n01\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws Exception {
		String mainwindow = driver.getWindowHandle();
		System.out.println(mainwindow);
		driver.findElement(By.id("newWindowBtn")).click();
		Set<String> windowhandles = driver.getWindowHandles();
		for (String handle : windowhandles) {
			System.out.println(handle);

		}
		driver.switchTo().window(mainwindow);
	}

	@AfterClass
	public void afterClass() {
		 driver.quit();
	}
}