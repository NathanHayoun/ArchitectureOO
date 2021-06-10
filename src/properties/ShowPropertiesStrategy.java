package properties;

import java.util.Map.Entry;
import java.util.Properties;

public class ShowPropertiesStrategy {
	private IReadProperties iReadProperties;
	private Properties properties;

	public ShowPropertiesStrategy() {

	}

	public void showProperties() {
		if (iReadProperties != null) {
			for (Entry<Object, Object> prop : properties.entrySet()) {
				System.out.println("Key :" + prop.getKey() + " Value :" + prop.getValue());
			}
		} else {
			System.err.println("Vous devez d'abord instantier un objet de type iReadProperties");
		}

	}

	private void loadProperties() {
		this.properties = iReadProperties.readProperties();
	}

	public String readProperties(String key, String defaultMessage) {
		if (iReadProperties != null) {

			return this.properties.get(key) == null ? defaultMessage : this.properties.getProperty(key);
		} else {
			System.err.println("Vous devez d'abord instantier un objet de type iReadProperties");
		}

		return null;
	}

	public ShowPropertiesStrategy setPropertiesStrategy(IReadProperties properties) {
		iReadProperties = properties;
		loadProperties();
		return this;
	}

}
