package automation.hui.utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.openqa.selenium.WebElement;

import automation.hui.pojos.Education;
import automation.hui.pojos.Experience;
import automation.hui.pojos.api.Post;

public class DataManager {

	private static ThreadLocal<DataManager> threadLocalDataManager;

	private String token;
	private List<String> texts;
	private Experience experienceUI;
	private Education educationUI;
	private automation.hui.pojos.api.Experience experienceAPI;	
	private automation.hui.pojos.api.Education educationAPI;
	private Post postAPI;
	private WebElement element;

	private DataManager() {
	}

	public static DataManager getInstance() {
		if (threadLocalDataManager == null)
			threadLocalDataManager = new ThreadLocal<>();
		if (threadLocalDataManager.get() == null) {
			threadLocalDataManager.set(new DataManager());
		}
		return threadLocalDataManager.get();
	}

	public static void reset() {
		threadLocalDataManager.set(null);
	}

	public String getToken() {
		assertNotNull(token, "Login token is not available");
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Experience getExperienceUI() {
		assertNotNull(experienceUI, "No experience created.");
		return experienceUI;
	}

	public void setExperienceUI(Experience experienceUI) {
		this.experienceUI = experienceUI;
	}

	public Education getEducationUI() {
		assertNotNull(educationUI, "UI - no education created.");
		return educationUI;
	}

	public void setEducationUI(Education educationUI) {
		this.educationUI = educationUI;
	}

	public List<String> getTexts() {
		assertNotNull(texts, "No text is available.");
		return texts;
	}

	public void setTexts(List<String> texts) {
		this.texts = texts;
	}

	public Post getPostAPI() {
		assertNotNull(postAPI, "No post created.");
		return postAPI;
	}

	public void setPostAPI(Post postAPI) {
		this.postAPI = postAPI;
	}

	public WebElement getElement() {
		assertNotNull(element, "No such element existed.");
		return element;
	}

	public void setElement(WebElement element) {
		this.element = element;
	}

	public automation.hui.pojos.api.Education getEducationAPI() {
		assertNotNull(educationAPI, "API - no education created.");
		return educationAPI;
	}

	public void setEducationAPI(automation.hui.pojos.api.Education educationAPI) {
		this.educationAPI = educationAPI;
	}

	public automation.hui.pojos.api.Experience getExperienceAPI() {
		assertNotNull(experienceAPI, "API - no experience created.");
		return experienceAPI;
	}

	public void setExperienceAPI(automation.hui.pojos.api.Experience experienceAPI) {
		this.experienceAPI = experienceAPI;
	}

}
