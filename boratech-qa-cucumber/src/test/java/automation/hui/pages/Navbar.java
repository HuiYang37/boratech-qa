package automation.hui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navbar {

	// Elements
	@FindBy(xpath = "//a[@href='/']")
	private WebElement homeLink;

	@FindBy(xpath = "//nav//a[@href='/register']")
	private WebElement registerLink;

	@FindBy(xpath = "//nav//a[@href='/login']")
	private WebElement loginLink;

	@FindBy(xpath = "//nav//a[@href='/posts']")
	private WebElement postsLink;

	@FindBy(xpath = "//nav//a[@href='/dashboard']")
	private WebElement dashboardLink;

	// Constructor
	public Navbar(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void returnHome() {
		homeLink.click();
	}

	public void navigateToLoginPage() {
		loginLink.click();
	}

	public void navigateToRegisterPage() {
		registerLink.click();
	}

	public void navigateToDashboardPage() {
		dashboardLink.click();
	}

	public void navigateToPostsPage() {
		postsLink.click();
	}

}
