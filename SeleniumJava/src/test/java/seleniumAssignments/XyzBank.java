package seleniumAssignments;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class XyzBank {

	WebDriver wd;

	@BeforeClass
	public void BeforeMethod() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mounika.n01\\Drivers\\chromedriver.exe");
		wd = new ChromeDriver();

		wd.navigate().to("http://www.way2automation.com/angularjs-protractor/banking/#/login");
		wd.manage().window().maximize();
		Thread.sleep(1000);
	}

	@BeforeTest
	public void beforeTestCount() {
		System.out.println("New Test Starts");
	}

	@AfterTest
	public void afterTestCount() {
		System.out.println("New Test Ends");
	}

	@Test
	public void test1() throws InterruptedException {
		// CUSTOMER SECTION TEST METHOD
		// to click on customer login
		wd.findElement(By.xpath("//button[@class='btn btn-primary btn-lg'][@ng-click='customer()']")).click();
		Thread.sleep(2000);

		// to select from dropdown
		WebElement dd1 = wd.findElement(By.xpath("//select[@class='form-control ng-pristine ng-untouched ng-valid']"));
		Select name = new Select(dd1);
		name.selectByVisibleText("Harry Potter");
		Thread.sleep(2000);

		// to click login button
		// Absolute xpath
		wd.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/form/button")).click();
		Thread.sleep(1000);

		// to validate the welcome the message
		// Relative xpath
		String message = wd.findElement(By.xpath("//span[@class='fontBig ng-binding']")).getText();
		assertEquals("Harry Potter", message);

		// to click on deposit
		wd.findElement(By.xpath("//button[@ng-class='btnClass2']")).click();
		Thread.sleep(1000);

		// to enter the amount to be deposited
		wd.findElement(
				By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-invalid ng-invalid-required']"))
				.sendKeys("600");
		Thread.sleep(1000);

		// to click on deposit button
		wd.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		Thread.sleep(1000);

		// to validate the deposit successful message
		String msg = wd.findElement(By.xpath("//span[@class='error ng-binding']")).getText();
		assertEquals("Deposit Successful", msg);

		// to click on transactions
		wd.findElement(By.xpath("//button[@ng-class='btnClass1']")).click();
		Thread.sleep(1000);

		// to print the transaction from web table

		String amt = wd.findElement(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr[1]/td[2]"))
				.getText();
		String trnsctnType = wd
				.findElement(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr[1]/td[3]"))
				.getText();

		System.out.println(amt + " is " + trnsctnType + " to your account");
		Thread.sleep(1000);

		// go back to home
		wd.findElement(By.xpath("//button[@class='btn home']")).click();
		Thread.sleep(1000);

	}

	@Test
	public void test2() throws InterruptedException {

		// MANAGER SECTION TEST METHOD
		// clicking on bank manager login
		wd.findElement(By.xpath("//button[@ng-click='manager()']")).click();
		Thread.sleep(1000);

		// open an account
		wd.findElement(By.xpath("//button[@ng-class='btnClass2']")).click();
		Thread.sleep(1000);

		// customer name dropdown
		WebElement dd2 = wd.findElement(By.xpath("//select[@id='userSelect']"));
		Select custName = new Select(dd2);
		custName.selectByVisibleText("Hermoine Granger");
		Thread.sleep(2000);

		// currency drop down
		WebElement dd3 = wd.findElement(By.xpath("//select[@id='currency']"));
		Select currency = new Select(dd3);
		currency.selectByVisibleText("Rupee");
		Thread.sleep(2000);

		// clicking process
		wd.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);

		// alert
		System.out.println(wd.switchTo().alert().getText());
		wd.switchTo().alert().accept();

		// ADDING A NEW CUSTOMER
		wd.findElement(By.xpath("//button[@ng-class='btnClass1']")).click();
		Thread.sleep(1000);

		// adding first name
		wd.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div[1]/input")).sendKeys("Mouni");
		Thread.sleep(1000);

		// adding last name
		wd.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div[2]/input"))
				.sendKeys("Kola");
		Thread.sleep(1000);

		// adding post code
		wd.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div[3]/input"))
				.sendKeys("MEH908");
		Thread.sleep(1000);
		// clicking on add add customer button
		wd.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);

		System.out.println(wd.switchTo().alert().getText());
		wd.switchTo().alert().accept();

		// CUSTOMER TABLE
		System.out.println("----------- Customer Table -------------");

		wd.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/button[3]")).click();
		Thread.sleep(1000);

		WebElement tab2 = wd.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/table"));
		List<WebElement> rows2 = tab2.findElements(By.tagName("tr"));
		for (int i = 0; i < rows2.size(); i++) {
			List<WebElement> cols2 = rows2.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < cols2.size() - 1; j++) {
				System.out.print(cols2.get(j).getText() + " | ");
			}
			System.out.println();
		}
		wd.findElement(By.xpath("/html/body/div[3]/div/div[1]/button[1]")).click();
		Thread.sleep(1000);

	}

	@AfterClass
	public void afterClass() {
		 wd.quit();
	}
}
