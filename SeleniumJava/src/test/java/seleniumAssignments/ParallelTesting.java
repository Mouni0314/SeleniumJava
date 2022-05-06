package seleniumAssignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParallelTesting {

	WebDriver driver;

	@BeforeClass
	public void BeforeMethod() throws Exception {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\mounika.n01\\Drivers\\chromedriver.exe");
		// driver = new ChromeDriver();

	}

	@Test
	public void chromeTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mounika.n01\\Drivers\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.get("https://www.rediff.com");
		d.manage().window().maximize();
		d.quit();
	}

	@Test
	public void firefoxTest() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\mounika.n01\\Drivers\\geckodriver.exe");
		WebDriver d = new FirefoxDriver();
		d.get("https://www.rediff.com/");
		d.manage().window().maximize();
		d.quit();
	}
}
