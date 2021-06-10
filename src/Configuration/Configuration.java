package Configuration;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Configuration {
	private static final Map<String, Object> config = new HashMap<>();

	public static void addConfig(String key, Object valeur) {
		config.put(key, valeur);
	}

	public static Object getConfigByKey(String key) {
		if (config.get(key) != null) {
			return config.get(key);
		} else {
			throw new Error("Invalid key");
		}
	}

	public static String getPathLanguage() {
		String path = System.getenv("path_to_file");
		// Vérifie si il existe un path. Si il existe il vérifie que ce soit bien un
		// fichier
		return path == null ? "lang/local_en.properties"
				: Path.of(path).toFile().exists() == true ? path : "lang/local_en.properties";

	}

	public static Map<String, Object> getAllConfig() {
		return config;
	}

}
