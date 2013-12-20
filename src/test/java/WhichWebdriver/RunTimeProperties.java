package WhichWebdriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class RunTimeProperties {

 // private static final Logger log = LoggerFactory
  //    .getLogger(RunTimeProperties.class);

  private static Properties properties;

  /*
  static {
    final InputStream inputStream = RunTimeProperties.class.getClassLoader()
        .getResourceAsStream("runTime.properties");
    properties = new Properties();
    try {
      properties.load(inputStream);
    } catch (final IOException e) {
      log.error("Not able to load runTime.properties file", e);
    }
  }
*/
  private RunTimeProperties() {
    throw new IllegalStateException("Should not instatiate");
  }

  public static String getEnvironment() {
    return getProperty("Environment");
  }
  
 
  public static String getContextPath() {
	    return getProperty("testing.contextPath");
	  }

  public static String getSkyIdMocked() {
    return getProperty("SkyIdMocked");
  }

  public static String getBrowser() {
    return getProperty("browser");
  }

  public static String getFirefoxProfileDirectory() {
    return getProperty("FirefoxProfile");
  }

  public static String getUserAgentString() {
    return getProperty("UserAgentString");
  }
  
  public static String getSamsungIP() {
	    return getProperty("SamsungIP");
	  }
  
  public static String getiPhoneIP() {
	    return getProperty("iPhoneIP");
	  }

  public static String getEnvironmentUrl() {
    //return getProperty("testing.cucumber.deployedServer");
    String host = getProperty("testing.remoteServer.address");
    String port = getProperty("testing.remoteServer.port");
    return "http://" + host + ':' + port +"/service/";
   // return "http://m.stage.sky.com/service";
  }

  public static String getStubServerUrl() {
    return getProperty("testing.cucumber.deployedMockServer");
  }

  public static String getProperty(final String key, final String defaultValue) {
    return properties.getProperty(key, defaultValue);
  }

  public static String getProperty(final String key) {
    return getProperty(key, null);
  }

  public static Properties getProperties() {
    return properties;
  }

  public static int getWaitTimeout() {
    final String timeout = getProperty("testing.waitfor.defaultimeOut", "10");
    return Integer.parseInt(timeout);
  }

}
