package seleniumAssignments;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebTables {

	WebDriver driver;

	@BeforeClass
	public void BeforeMethod() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mounika.n01\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("https://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}

	@Test
	public void test() throws Exception {
		double m = 0, r = 0, m1 = 0, r1 = 0;
		// No.of rows
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		System.out.println("The no.of rows:" + rows.size());
		// No.of columns
		List<WebElement> cols = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
		System.out.println("The no.of columns:" + cols.size());
		// To find the 3rd row 4th column data
		String ele = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]/td[4]")).getText();
		System.out.println("The cell value:" + ele);
		Thread.sleep(1000);
// For max current price
		for (int i = 1; i < rows.size(); i++) {
			String max = driver.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[4]")).getText();
			// System.out.println(max);
			NumberFormat nf = NumberFormat.getNumberInstance();
			Number num = nf.parse(max);
			max = num.toString();
			m = Double.parseDouble(max);
			if (m > r) {
				r = m;

			}
		}
		System.out.println("The max current price is " + r);
		// For max Prev Close

		for (int i = 1; i < rows.size(); i++) {
			String maxPc = driver.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[3]")).getText();
			// System.out.println(maxPc);
			NumberFormat nf = NumberFormat.getNumberInstance();
			Number num1 = nf.parse(maxPc);
			maxPc = num1.toString();
			m1 = Double.parseDouble(maxPc);
			if (m1 > r1) {
				r1 = m1;

			}
		}
		System.out.println("The max Prev Close is " + r1);

	}

	@AfterClass
	public void afterClass() {
		// d.quit();
	}
}
