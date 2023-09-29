package hui_automation.steps.ui;

import java.util.Properties;

import hui_automation.utilities.BrowserConfig;
import hui_automation.utilities.DataManager;
import hui_automation.utilities.DriverManager;
import hui_automation.utilities.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before(order = 0, value = "@UI or @ui or @E2E or @e2e")
	public void setBrowser() {
		Properties p = BrowserConfig.getProperties();
		String headlessStr = p.getProperty("headless");
		if (Boolean.valueOf(headlessStr)) {
			DriverManager.setHeadless(true);
			System.out.println("Running headless chrome...");
		} else {
			DriverManager.setBrowserName(p.getProperty("browser"));
		}
	}

	@Before(order = 1, value = "@UI or @ui or @E2E or @e2e")
	public void powerUp() {
		DriverManager.getInstance();
		DataManager.getInstance();
		PageManager.getInstance();
		System.out.println("Power up driver...");
	}

	@After("@UI or @ui or @E2E or @e2e")
	public void tearDown() {
		DriverManager.reset();
		DataManager.reset();
		PageManager.reset();
		System.out.println("Power down driver...");
	}

}
