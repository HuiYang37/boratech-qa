package automation.hui.steps.api;

import static org.junit.jupiter.api.Assertions.*;

import automation.hui.utilities.BoraTechAPIs;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class LoginSteps {

	private String loginErrorMsg;

	@Given("[API] user enters wrong credentials")
	public void api_user_enters_wrong_credentials(DataTable dataTable) {
		String email = dataTable.asMap().get("email");
		String password = dataTable.asMap().get("password");
		this.loginErrorMsg = BoraTechAPIs.negativeLogin(email, password);
	}

	@Then("[API] user should receive login errors")
	public void api_user_should_receive_login_errors(DataTable dataTable) {
		String expectedErrorMsg = dataTable.asMap().get("error");
		String actualErrorMsg = this.loginErrorMsg;
		assertEquals(expectedErrorMsg, actualErrorMsg);
	}

}
