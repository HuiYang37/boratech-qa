package hui_automation.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class SeleniumJob {

	WebDriver driver;
	WebDriverWait wait;
	Actions act;

	public SeleniumJob(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		act = new Actions(driver);
	}

	public WebDriverWait justWait() {
		return wait;
	}

	public Actions mouse() {
		return act;
	}

	public Actions keyboard() {
		return act;
	}

	public void takeScreen(Scenario scenario) {
		String name = scenario.getName().replace(" ", "_") + "_" + scenario.getLine();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filePath = String.format("./src/test/resources/failed_tests/%s_%s.png", name, TestUtils.getTimestamp());
		try {
			FileUtils.copyFile(screenshotFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
