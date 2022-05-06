package seleniumAssignments;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScreenShot1 {

	WebDriver driver;

	@BeforeClass
	public void BeforeMethod() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mounika.n01\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("http://www.way2automation.com/angularjs-protractor/banking/#/login");
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}

	@Test
	public void screenshot() throws IOException {
		// convert driver to take screenshots
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ss, new File(
				"D:\\SoftwareCenterApplications\\Eclipse IDE for Enterprise Java Developers\\eclipse-jee-2021-12-R-win32-x86_64\\eclipse\\Screenshots\\Page.png"));
		// FileUtils.copyFile(scr1,new File("C:\\eclipsescreenshots\\Page.png");
		System.out.println("Screenshot is captured");
	}

	@AfterClass
	public void afterClass() {
		 driver.quit();
	}
}
