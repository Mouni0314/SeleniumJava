package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseHover {

	WebDriver d;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mounika.n01\\Drivers\\chromedriver.exe");
		d = new ChromeDriver();
		d.get("https://demo.guru99.com/test/newtours/");
		d.manage().window().maximize();
	}

	@Test
	public void actions() {
		WebElement link_Home = d.findElement(By.linkText("Home"));
		WebElement td_Home = d.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]\r\n"
				+ "\r\n"));
		Actions ac = new Actions(d);
		Action mouseOverHome = ac.moveToElement(link_Home).build();
		String bgColor = td_Home.getCssValue("background color");
		System.out.println("Before hover:" + bgColor);
		mouseOverHome.perform();
		td_Home.getCssValue("background-color");
		System.out.println("After hover:" + bgColor);
	}

	private Object moveToElement(WebElement link_Home) {
		// TODO Auto-generated method stub
		return null;
	}

	@AfterClass
	public void afterClass() {
		 d.quit();
	}
}
