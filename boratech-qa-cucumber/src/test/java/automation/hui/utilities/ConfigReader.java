package automation.hui.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	private final static String FILE_PATH = "./src/test/resources/config.properties";
	private static Properties p;

	private static void load() throws Exception {
		FileInputStream input = new FileInputStream(FILE_PATH);
		Properties p = new Properties();
		p.load(input);
		ConfigReader.p = p;
	}

	public static Properties getConfigData() {
		try {
			load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
