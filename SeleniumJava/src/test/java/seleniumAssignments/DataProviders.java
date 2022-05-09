package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
	WebDriver driver;

	@BeforeClass
	public void before() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mounika.n01\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://10.82.180.36/Common/Login.aspx");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "donhere";
		data[0][1] = "don";
		data[0][2] = "Incorrect Username/Password";
		data[1][0] = "donere";
		data[1][1] = "don";
		data[1][2] = "User Id does not exist";
		return data;
	}

	@Test(dataProvider = "getData")
	public void test(String username, String password, String expectedErrorMessage) throws InterruptedException {
		WebElement usernameTextBox = driver.findElement(By.id("body_txtUserID"));
		WebElement passwordTextBox = driver.findElement(By.id("body_txtPassword"));
		WebElement loginButton = driver.findElement(By.id("body_btnLogin"));

		usernameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		loginButton.click();
		String actualErrorMessage = driver.findElement(By.id("body_lblStatus")).getText();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
		Thread.sleep(5000);

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();

	}

}
