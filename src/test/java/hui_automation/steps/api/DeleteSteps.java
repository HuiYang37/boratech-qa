package hui_automation.steps.api;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import hui_automation.api_pojos.Education;
import hui_automation.api_pojos.Experience;
import hui_automation.api_pojos.Post;
import hui_automation.api_pojos.Profile;
import hui_automation.utilities.BoraTechAPIs;
import hui_automation.utilities.DataManager;
import io.cucumber.java.en.*;

public class DeleteSteps {

	private DataManager dataManager = DataManager.getInstance();

	@Then("user deletes all experiences")
	public void user_deletes_all_experiences() {
		List<Experience> experiences = BoraTechAPIs.getUserProfile(dataManager.getToken()).experience;
		for (Experience experience : experiences)
			BoraTechAPIs.deleteExperience(dataManager.getToken(), experience);
		experiences = BoraTechAPIs.getUserProfile(dataManager.getToken()).experience;
		assertEquals(0, experiences.size());
	}

	@Then("user deletes all educations")
	public void user_deletes_all_educations() {
		List<Education> educations = BoraTechAPIs.getUserProfile(dataManager.getToken()).education;
		for (Education education : educations)
			BoraTechAPIs.deleteEducation(dataManager.getToken(), education);
		educations = BoraTechAPIs.getUserProfile(dataManager.getToken()).education;
		assertEquals(0, educations.size());
	}

	@Then("user deletes all posts")
	public void user_deletes_all_posts() {
		List<Post> posts = BoraTechAPIs.getPosts(dataManager.getToken());
		Profile userProfile = BoraTechAPIs.getUserProfile(dataManager.getToken());
		String userID = userProfile.user._id;
		for (Post post : posts) {
			if (post.user.equals(userID))
				BoraTechAPIs.deletePost(dataManager.getToken(), post);
		}
	}

}
