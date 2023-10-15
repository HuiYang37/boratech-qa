package hui_automation.steps.ui;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import hui_automation.utilities.BrowserConfig;
import hui_automation.utilities.DataManager;
import hui_automation.utilities.DriverManager;
import hui_automation.utilities.PageManager;
import hui_automation.utilities.SeleniumJob;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	WebDriver driver;
	SeleniumJob sj;

	@Before(order = 0, value = "@UI or @ui or @E2E or @e2e")
	public void configBrowser() {
		Properties p = BrowserConfig.getBrowserData();
		String headlessStr = p.getProperty("headless");
		if (Boolean.valueOf(headlessStr)) {
			DriverManager.setHeadless(true);
			System.out.println("Running headless chrome...");
		} else {
			DriverManager.setBrowserName(p.getProperty("browser"));
		}
	}

	@Before(order = 1, value = "@UI or @ui or @E2E or @e2e")
	public void setup() {
		driver = DriverManager.getInstance();
		sj = new SeleniumJob(driver);
		DataManager.getInstance();
		PageManager.getInstance();
	}

	@After("@UI or @ui or @E2E or @e2e")
	public void cleanup() {
		DriverManager.reset();
		DataManager.reset();
		PageManager.reset();
	}

	@AfterStep("@stop")
	public void didStepFail(Scenario scenario) {
		if (scenario.isFailed()) {
			sj.takeScreen(scenario);
		}
	}

}
