package properties;

import java.util.Map.Entry;
import java.util.Properties;

public class ShowPropertiesStrategy {
	private static ShowPropertiesStrategy uniqueInstance;
	private IReadProperties iReadProperties;
	private Properties properties;

	private ShowPropertiesStrategy() {

	}

	public static ShowPropertiesStrategy getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ShowPropertiesStrategy();
		}
		return uniqueInstance;
	}

	public void showProperties() {
		if (getInstance().iReadProperties != null) {
			for (Entry<Object, Object> prop : getInstance().properties.entrySet()) {
				System.out.println("Key :" + prop.getKey() + " Value :" + prop.getValue());
			}
		}
	}

	private void loadProperties() {
		getInstance().properties = iReadProperties.readProperties();
	}

	public String readProperties(String key, String defaultMessage) {
		if (getInstance().iReadProperties != null) {

			return getInstance().properties.get(key) == null ? defaultMessage
					: getInstance().properties.getProperty(key);
		}
		return null;
	}

	public ShowPropertiesStrategy setPropertiesStrategy(IReadProperties properties) {
		getInstance().iReadProperties = properties;
		getInstance().loadProperties();
		return this;
	}

}
