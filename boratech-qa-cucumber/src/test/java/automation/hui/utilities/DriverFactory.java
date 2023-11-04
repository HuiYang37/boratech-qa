package automation.hui.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	@SuppressWarnings("unused")
	private static DriverFactory driverFactory;
	private static String browserName;
	private static boolean isheadless;

	private DriverFactory() {
		browserName = ConfigReader.getConfigData().getProperty("browser");
		isheadless = Boolean.valueOf(ConfigReader.getConfigData().getProperty("headless"));
	}

	public static WebDriver getDriver() {
		driverFactory = new DriverFactory();
		if (isheadless)
			return getHeadlessChrome();
		switch (browserName.toLowerCase()) {
		case "chrome":
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			return new ChromeDriver(co);
		case "firefox":
			return new FirefoxDriver();
		default:
			return null;
		}
	}

	private static WebDriver getHeadlessChrome() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		co.addArguments("--headless");
		return new ChromeDriver(co);
	}

}
