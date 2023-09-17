package hui_automation.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class Configuration {

	public static void add(String key, String value) {
		String filePath = "src/test/resources/config.txt";
		File configFile = new File(filePath);
		try {
			// create config file
			if (!configFile.exists())
				configFile.createNewFile();

			// load config file into a map
			Map<String, String> data = new HashMap<>();
			Properties p = new Properties();
			p.load(new FileInputStream(configFile));
			for (String propertyName : p.stringPropertyNames()) {
				data.put(propertyName, p.getProperty(propertyName));
			}

			// new data
			data.put(key, value);

			FileWriter fw = new FileWriter(configFile);
			BufferedWriter bw = new BufferedWriter(fw);

			for (Entry<String, String> entry : data.entrySet()) {
				String content = entry.getKey() + "=" + entry.getValue() + "\n";
				bw.write(content);
			}

			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String get(String key) {
		String filePath = "src/test/resources/config.txt";
		File configFile = new File(filePath);
		if (!configFile.exists())
			return null;
		try {
			Properties p = new Properties();
			FileReader fr = new FileReader(configFile);
			BufferedReader br = new BufferedReader(fr);
			p.load(br);
			return p.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
