package automation.hui.practices.ui.selenium.tests;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedWriter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.hui.pages.LoginPage;
import automation.hui.utilities.DriverFactory;
import automation.hui.utilities.TestUtils;

public class PrintPageSource {

	public static void main(String[] args) {
		printToFile(getPageSource());
	}

	private static String getPageSource() {
		WebDriver driver = DriverFactory.getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		String page = null;
		try {
			driver.get("https://boratech-practice-app.onrender.com/login");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.login("hui-pretender@outlook.com", "Hui123456");
			// check if user is on the dashboard page
			wait.until(ExpectedConditions.urlContains("dashboard"));
			wait.until(ExpectedConditions.urlContains("boratech-practice-app"));
			// go to add education page
			driver.findElement(By.xpath("//a[@href='/add-education']")).click();
			wait.until(ExpectedConditions.urlContains("add-education"));
			wait.until(ExpectedConditions.urlContains("boratech-practice-app"));

			// submit an empty [Education]
			driver.findElement(By.cssSelector("input[type='submit']")).click();

			TestUtils.pause(1);
			// grab the page source, expected error
			page = driver.getPageSource();
			System.out.println("Page source captured.");
		} catch (Exception e) {
			System.out.println("Failed to capture the intended page source.");
			e.printStackTrace();
		} finally {
			driver.quit();
		}
		return page;
	}

	private static void printToFile(String page) {
		try {
			String dirPath = "./src/test/resources/page-sources";
			// create target folder if none exists
			if (!Files.exists(Paths.get(dirPath)))
				Files.createDirectory(Paths.get(dirPath));
			// copy to file
			File pageFile = new File(
					"./src/test/resources/page-sources/failed-test-" + TestUtils.getTimestamp() + ".html");
			FileWriter fw = new FileWriter(pageFile);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(page);

			bw.close();
			System.out.println("File created/updated.");
		} catch (Exception e) {
			System.out.println("Failed to write to file.");
			e.printStackTrace();
		}
	}

}
