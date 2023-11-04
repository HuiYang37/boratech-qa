package automation.hui.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> threadLocalDriver;

	private DriverManager() {
	}

	public static WebDriver getInstance() {
		if (threadLocalDriver == null)
			threadLocalDriver = new ThreadLocal<>();
		if (threadLocalDriver.get() == null) {
			WebDriver driver = DriverFactory.getDriver();
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
	}

}
