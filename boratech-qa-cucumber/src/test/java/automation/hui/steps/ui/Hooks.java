package automation.hui.steps.ui;

import org.openqa.selenium.WebDriver;

import automation.hui.utilities.DataManager;
import automation.hui.utilities.DriverManager;
import automation.hui.utilities.PageManager;
import automation.hui.utilities.SeleniumJob;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	WebDriver driver;
	SeleniumJob sj;

	@Before("@UI or @ui or @E2E or @e2e")
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
