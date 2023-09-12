package hui_automation.steps.api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hui_automation.api_pojos.Error;
import hui_automation.api_pojos.Experience;
import hui_automation.utilities.BoraTechAPIs;
import hui_automation.utilities.DataManager;
import hui_automation.utilities.Testkeys;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class AddExperienceSteps {

	private DataManager dataManager = DataManager.getInstance();

	@Then("[API] user adds a new [Experience]")
	public void api_user_adds_a_new_experience(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		Experience experience = new Experience(data.get("company") + " " + Testkeys.getTimestamp(), data.get("title"),
				data.get("location"), data.get("from"), data.get("to"), Boolean.parseBoolean(data.get("current")),
				data.get("description"));
		List<Experience> experiences = BoraTechAPIs.putExperience(dataManager.getToken(), experience);
		boolean targetFound = false;
		for (Experience actualExperience : experiences) {
			if (actualExperience.equals(experience)) {
				targetFound = true;
				dataManager.setExperienceAPI(actualExperience);
				break;
			}
		}
		assertTrue(targetFound);
		System.out.println(experience.company + ", " + experience.title);
	}

	@Then("[API] user deletes the newly added [Experience]")
	public void api_user_deletes_the_newly_added_experience() {
		List<Experience> experiences = BoraTechAPIs.deleteExperience(dataManager.getToken(),
				dataManager.getExperienceAPI());
		boolean targetFound = false;
		for (Experience experience : experiences) {
			if (experience.equals(dataManager.getExperienceAPI())) {
				targetFound = true;
				break;
			}
		}
		assertFalse(targetFound);
	}

	@When("[API] user adds a wrong [Experience] with {}, {} and {}")
	public void api_user_adds_a_wrong_experience_with_test_company_and(String company, String title, String from) {
		Experience exp = new Experience(company, title, "", from, "", true, "");
		List<Error> errors = BoraTechAPIs.putExperienceWrong(dataManager.getToken(), exp);
		List<String> texts = new ArrayList<>();
		for (Error error : errors)
			texts.add(error.msg);
		dataManager.setTexts(texts);
	}

}
