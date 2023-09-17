package hui_automation.steps.api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hui_automation.api_pojos.Education;
import hui_automation.api_pojos.Error;
import hui_automation.utilities.BoraTechAPIs;
import hui_automation.utilities.DataManager;
import hui_automation.utilities.Testkeys;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class AddEducationSteps {

	private DataManager dataManager = DataManager.getInstance();

	@Then("[API] user adds a new [Education]")
	public void api_user_adds_a_new_education(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		Education education = new Education(data.get("school") + " " + Testkeys.getTimestamp(), data.get("degree"),
				data.get("fieldofstudy"), data.get("from"), data.get("to"), Boolean.parseBoolean(data.get("current")),
				data.get("description"));
		List<Education> educations = BoraTechAPIs.putEducation(dataManager.getToken(), education);
		boolean targetFound = false;
		for (Education actualEducation : educations) {
			if (actualEducation.equals(education)) {
				targetFound = true;
				dataManager.setEducationAPI(actualEducation);
				break;
			}
		}
		assertTrue(targetFound);
	}

	@Then("[API] user deletes the newly added [Education]")
	public void api_user_deletes_the_newly_added_education() {
		List<Education> educations = BoraTechAPIs.deleteEducation(dataManager.getToken(),
				dataManager.getEducationAPI());
		boolean targetFound = false;
		for (Education education : educations) {
			if (education.equals(dataManager.getEducationAPI())) {
				targetFound = true;
				break;
			}
		}
		assertFalse(targetFound);
	}

	@When("[API] user adds a wrong [Education] with {}, {}, {} and {}")
	public void api_user_adds_a_wrong_education_with_and(String school, String degree, String fieldofstudy,
			String from) {
		Education education = new Education(school, degree, fieldofstudy, from, "", true, "");
		List<Error> errors = BoraTechAPIs.putEducationWrong(dataManager.getToken(), education);
		List<String> texts = new ArrayList<>();
		for (Error error : errors)
			texts.add(error.msg);
		dataManager.setTexts(texts);
	}

}
