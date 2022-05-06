package seleniumAssignments;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDown {

	WebDriver driver;

	@BeforeMethod
	public void BeforeMethod() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mounika.n01\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test()
	public void A1Dropdown() throws InterruptedException {

		driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/button")).click();

		WebElement frm = driver.findElement(By.id("option-droup-demo"));
		Select sc = new Select(frm);

		List<WebElement> allItems = sc.getOptions();

		List<String> check = new ArrayList<String>();
		check.add("Java");
		check.add("Python");
		check.add("Bootstrap");
		check.add("Oracle");

		for (WebElement item : allItems) {

			Thread.sleep(1000);

			if (item.isSelected()) {
				driver.findElement(By.xpath("//input[@type='checkbox'][@value='" + item.getText() + "']")).click();
			}

			for (String checkItem : check) {
				if (item.getText().equals(checkItem)) {
					driver.findElement(By.xpath("//input[@type='checkbox'][@value='" + item.getText() + "']")).click();
					System.out.println("Chceked " + item.getText());
				}
			}

		}

		List<WebElement> allSelectedItems = sc.getAllSelectedOptions();
		System.out.println("Selected Items :");
		for (WebElement selectedItem : allSelectedItems) {

			System.out.println(selectedItem.getText());
		}
		Thread.sleep(3000);

		// driver.close();

	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		 driver.quit();
	}
}
