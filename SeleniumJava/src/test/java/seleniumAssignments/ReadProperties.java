package seleniumAssignments;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadProperties {

	public static void main(String[] args) throws IOException {

		WebDriver d; // Driver Object for Interface
// Read properties file
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"C:\\Users\\mounika.n01\\eclipse-workspace\\SeleniumJava\\src\\test\\java\\seleniumAssignments\\config.properties");
		prop.load(ip);

		System.out.println(prop.getProperty("browser"));
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\mounika.n01\\Drivers\\chromedriver.exe"); // Setting the browser name,Setting
			// the path of the webdriver
			d = new ChromeDriver();

		}

	}
}
