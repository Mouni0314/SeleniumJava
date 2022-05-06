package seleniumAssignments;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Executor {

	WebDriver d;

	@BeforeClass
	public void BeforeMethod() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mounika.n01\\Drivers\\chromedriver.exe");
		d = new ChromeDriver();

		d.navigate().to("https://google.com");
		d.manage().window().maximize();
		Thread.sleep(1000);
	}

	@Test
	public void test() {
		String parent = d.getWindowHandle();
		JavascriptExecutor js = ((JavascriptExecutor) d);
		js.executeScript("window.open();");
		System.out.println(parent);
		Set<String> windowHandle = d.getWindowHandles();
		for (String window : windowHandle) {
			if (window != parent) {
				d.switchTo().window(window);
			}
		}
		d.navigate().to("https://gmail.com");
		// to scroll down the page
		js.executeScript("window.scroll(0,600)");
	}

	@AfterClass
	public void afterClass() {
		 d.quit();
	}

}
