package automation.hui.steps.api;

import io.cucumber.java.Before;
import automation.hui.utilities.DataManager;
import io.cucumber.java.After;

public class Hooks {

	@Before("@API or @api or @E2E or @e2e")
	public void setup() {
		DataManager.getInstance();
	}

	@After("@API or @api or @E2E or @e2e")
	public void cleanup() {
		DataManager.reset();
	}

}
