package properties;

import java.util.Map;
import java.util.Properties;

public class ReadArrayProperties implements IReadProperties {
	private Map<String, Object> properties;

	public ReadArrayProperties(Map<String, Object> data) {
		this.properties = data;
	}

	@Override
	public Properties readProperties() {
		Properties properties = new Properties();
		properties.putAll(this.properties);

		return properties;
	}

}
