package automation.hui.utilities;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils {

	public static String getDateInput(LocalDate date, String dateInputPattern) {
		return date.format(DateTimeFormatter.ofPattern(dateInputPattern));
	}

	public static LocalDate getDate(String dateData, String datePattern) {
		return LocalDate.parse(datePattern, DateTimeFormatter.ofPattern(datePattern));
	}

	public static Map<String, String> getNoNullMap(Map<String, String> data) {
		Map<String, String> output = new HashMap<>();
		for (Entry<String, String> entry : data.entrySet()) {
			output.put(entry.getKey(), entry.getValue());
			if (entry.getValue() == null)
				output.put(entry.getKey(), "");
		}
		return output;
	}

	public static String getTimestamp() {
		long time = Timestamp.valueOf(LocalDateTime.now()).getTime();
		return String.valueOf(time);
	}

	public static boolean containsElement(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public static void pause(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void jsClick(WebDriver driver, By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", driver.findElement(locator));
	}

	public static void jsViewTop(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");
	}

	public static void clickDropDown(WebDriver driver, By loctor) {
		try {
			driver.findElement(loctor).click();
		} catch (ElementClickInterceptedException e) {
			new Actions(driver).scrollToElement(driver.findElement(loctor)).moveToElement(driver.findElement(loctor))
					.click().build().perform();
		} catch (ElementNotInteractableException e) {
			new Actions(driver).scrollToElement(driver.findElement(loctor)).moveToElement(driver.findElement(loctor))
					.click().build().perform();
		}
	}

}
