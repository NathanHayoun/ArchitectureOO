package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadFileProperties implements IReadProperties {
	private String path;

	public ReadFileProperties(String path) {
		this.path = path;
	}

	@Override
	public Properties readProperties() {
		Properties properties = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(path);
			properties.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return properties;
	}

}
