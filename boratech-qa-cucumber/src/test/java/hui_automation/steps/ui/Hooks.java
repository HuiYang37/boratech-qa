package hui_automation.steps.ui;

import hui_automation.utilities.DataManager;
import hui_automation.utilities.DriverManager;
import hui_automation.utilities.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before(order = 0, value = "@Headless or @headless")
	public void setHeadless() {
		DriverManager.setHeadless(true);
		System.out.println("Running headless...");
	}

	@Before(order = 1, value = "@Chrome or @chrome")
	public void setChrome() {
		DriverManager.setBrowserName("chrome");
		System.out.println("Open Chrome...");
	}

	@Before(order = 2, value = "@Edge or @edge")
	public void setEdge() {
		DriverManager.setBrowserName("edge");
		System.out.println("Open Edge...");
	}

//	@Before(order = 2, value = "@Firefox or @firefox")
//	public void setupFirefox() {
//		Configuration.config("browser", "firefox");
//		System.out.println("Open Firefox...");
//	}

	@Before(order = 4, value = "@UI or @ui or @E2E or @e2e or @Chrome or @chrome or @Edge or @edge or @Firefox or @firefox")
	public void powerUp() {
		DriverManager.getInstance();
		DataManager.getInstance();
		PageManager.getInstance();
		System.out.println("Power up driver...");
	}

	@After("@UI or @ui or @E2E or @e2e or @Chrome or @chrome or @Edge or @edge or @Firefox or @firefox")
	public void tearDown() {
		DriverManager.reset();
		DataManager.reset();
		PageManager.reset();
		System.out.println("Power down driver...");
	}

}
