package hui_automation.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.junit.jupiter.api.Test;

public class BrowserConfig {

	private final static String FILE_PATH = "./src/test/resources/browser.properties";
	private static Properties p;

	private static void load() throws Exception {
		FileInputStream input = new FileInputStream(FILE_PATH);
		Properties p = new Properties();
		p.load(input);
		BrowserConfig.p = p;
	}

	public static Properties getProperties() {
		try {
			load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	@Test
	public void reset() {
		try {
			load();
			p.setProperty("browser", "chrome");
			p.setProperty("headless", "false");
			p.store(new FileOutputStream(FILE_PATH), "browser name has been set to chrome");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void setHeadless() {
		try {
			load();
			p.setProperty("headless", "true");
			p.store(new FileOutputStream(FILE_PATH), "set to run headless");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
