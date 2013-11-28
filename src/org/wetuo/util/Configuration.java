package org.wetuo.util;
import java.util.ResourceBundle;
/**
 * 
 * <p>读取properties文件辅助类</p>
 * @author LH
 * 
 */
public class Configuration {
	private static Configuration configuration = null;
	private static ResourceBundle resourceBundle = null;
	private static final String CONFIG_FILE = "configuration";
	public Configuration() {
		resourceBundle = ResourceBundle.getBundle(CONFIG_FILE);
	}
	public synchronized static Configuration getInstance() {
		if (null == configuration) {
			configuration = new Configuration();
		}
		return (configuration);
	}
	public  String getValue(String key) {
		return (resourceBundle.getString(key));
	}
}
