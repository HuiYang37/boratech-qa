package hui_automation.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> threadLocalDriver;
	private static String browserName;
	private static boolean headless;

	private DriverManager() {
	};

	public static WebDriver getInstance() {
		if (threadLocalDriver == null)
			threadLocalDriver = new ThreadLocal<>();
		if (threadLocalDriver.get() == null) {
			WebDriver driver;
			if (headless)
				driver = DriverFactory.getHeadlessChrome();
			else if (browserName == null)
				driver = DriverFactory.getDriver("chrome");
			else
				driver = DriverFactory.getDriver(browserName);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			threadLocalDriver.set(driver);
		}
		return threadLocalDriver.get();
	}

	public static void reset() {
		if (threadLocalDriver.get() != null)
			threadLocalDriver.get().quit();
		threadLocalDriver.set(null);
		headless = false;
		browserName = null;
	}

	public static void setHeadless(boolean headless) {
		DriverManager.headless = headless;
	}

	public static void setBrowserName(String browserName) {
		DriverManager.browserName = browserName;
	}

}
