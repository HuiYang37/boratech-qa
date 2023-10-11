package hui_automation.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class BrowserConfig {

	private final static String FILE_PATH = "./src/test/resources/browser.properties";
	private static Properties p;

	private static void load() throws Exception {
		FileInputStream input = new FileInputStream(FILE_PATH);
		Properties p = new Properties();
		p.load(input);
		BrowserConfig.p = p;
	}

	public static Properties getBrowserData() {
		try {
			load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
