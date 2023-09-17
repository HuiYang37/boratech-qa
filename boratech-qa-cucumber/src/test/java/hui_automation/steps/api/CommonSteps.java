package hui_automation.steps.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import hui_automation.utilities.BoraTechAPIs;
import hui_automation.utilities.DataManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class CommonSteps {

	private DataManager dataManager = DataManager.getInstance();

	@Given("[API] user is logged in")
	public void api_user_is_logged_in(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		String token = BoraTechAPIs.login(data.get("email"), data.get("password"));
		dataManager.setToken(token);
	}

	@Then("[API] user gets a list of error messages")
	public void api_user_gets_a_list_of_error_messages(DataTable dataTable) {
		// generate expected error messages
		String[] errors = dataTable.asMap().get("error").split(",");
		for (int i = 0; i < errors.length; i++)
			errors[i] = errors[i].trim();
		List<String> expectedErrorMsgs = Arrays.asList(errors);

		// generate actual error messages
		List<String> actualErrorMsgs = dataManager.getTexts();

		// validation
		Collections.sort(expectedErrorMsgs);
		Collections.sort(actualErrorMsgs);
		assertEquals(expectedErrorMsgs, actualErrorMsgs);
	}

}
