package hui_automation.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public static WebDriver getDriver(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			return new ChromeDriver(co);
		case "edge":
			return new EdgeDriver();
		case "firefox":
			return new FirefoxDriver();
		default:
			return null;
		}
	}

	public static WebDriver getHeadlessChrome() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		co.addArguments("--headless");
		return new ChromeDriver(co);

	}

}
