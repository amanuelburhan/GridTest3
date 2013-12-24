package WhichWebdriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.*;

import com.google.common.base.Predicate;

public class WhichWebDriverFactory {

  private static WhichWebDriver instance = null;

  /**
   * @author burhanA
   * 
   */
  public static class WhichWebDriver {

    private final WebDriver driver;
    private int waitTimeout = 10;

    public WhichWebDriver(final WebDriver driver) {
      this.driver = driver;
    }
  
    
    
    public void addCookie(Cookie ssoCookie)
    {
      driver.manage().addCookie(ssoCookie);
    }

    public WebElement findElement(final By by) {
      return waitForElement(by);
    }
    
    public String getTitle() {   
    	return driver.getTitle();
      }
    
    public List<WebElement> findElements(final By by) {
      return waitForElements(by);
    }

    public WebElement waitForElement(final By by) {
      final WebDriverWait wait = new WebDriverWait(driver, waitTimeout);

      wait.ignoring(StaleElementReferenceException.class);

      return wait.until(new ExpectedCondition<WebElement>() {
        
        public WebElement apply(final WebDriver input) {
          return input.findElement(by);
        }

      });
    }

    public List<WebElement> waitForElements(final By by) {
      final WebDriverWait wait = new WebDriverWait(driver, waitTimeout);

      wait.ignoring(StaleElementReferenceException.class);

      return wait.until(new ExpectedCondition<List<WebElement>>() {
        public List<WebElement> apply(final WebDriver input) {
          return input.findElements(by);
        }

      });
    }

    public void waitForCondition(final Predicate<WebDriver> predicate) {
      final WebDriverWait wait = new WebDriverWait(driver, waitTimeout);
      wait.ignoring(StaleElementReferenceException.class);
      try {
        wait.until(predicate);
      } catch (TimeoutException e) {
        StringBuilder msg = new StringBuilder();
        msg.append("A condition has not been met in a reasonable time. This may mean for example, that a page has not loaded, or an item is not found on the page.\n");
        msg.append("Predicate Name:");
        msg.append(predicate.getClass().getName());
        msg.append('\n');
        msg.append("See StackTrace For more information");
        throw new ElementNotVisibleException(msg.toString(), e);
      }
    }

    public int getWaitTimeout() {
      return waitTimeout;
    }

    public void setWaitTimeout(final int waitTimeout) {
      this.waitTimeout = waitTimeout;
    }


    public void get(final String url) {
      driver.get(url);
    }

    public void quit() {
      driver.quit();
    }

    public String getDefaultSelectedTextInAList(final WebElement element) {
      final Select select = new Select(element);
      return select.getFirstSelectedOption().getText();
    }

    public void sleep(final long millis) {
      try {
        Thread.sleep(millis);
      } catch (final InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    public void moveTo(final WebElement element) {
      final Actions a = new Actions(driver);
      a.moveToElement(element).build().perform();

    }

    public void resize() {
      //driver.manage().window().setSize(new Dimension(1000, 1000));
    }

    /**
     * @return the driver
     */
    public WebDriver getDriver() {
      return driver;
    }

  }

//  private static final Logger LOG = LoggerFactory
 //     .getLogger(WhichWebDriverFactory.class);

  public static WhichWebDriver getInstance() {
    if (instance != null) {
      return instance;
    } else {
      final WebDriver driver = createDriver();

      final WhichWebDriver whichWebDriver = new WhichWebDriver(driver);
      //skyWebDriver.setWaitTimeout(RunTimeProperties.getWaitTimeout());
      instance = whichWebDriver;
      //registerShutdownHook();
      return whichWebDriver;
    }
  }
  
  

  private static void registerShutdownHook() {

    boolean shutDownBrowser = "true".equalsIgnoreCase(RunTimeProperties.getProperty("shutdownBrowser", "true"));
    if (shutDownBrowser) {
      Runtime.getRuntime().addShutdownHook(new Thread() {
        @Override
        public void run() {
          System.out.println("shutting down webdriver");
          if (instance != null) {
            instance.quit();
          }
        }
      });
    }
  }

  private static WebDriver createDriver()  {
    WebDriver driver = null;
    String Xport = System.getProperty(
            "lmportal.xvfb.id", ":55");
    final File firefoxPath = new File(System.getProperty(
            "lmportal.deploy.firefox.path", "/usr/bin/firefox"));
    FirefoxBinary firefoxBinary = new FirefoxBinary(firefoxPath);
    firefoxBinary.setEnvironmentProperty("DISPLAY", Xport);
    driver = new FirefoxDriver(firefoxBinary, null);
    return driver;
  }
}
    
/*    
    //Solution 1
    //
    //FirefoxProfile profile = new FirefoxProfile();
    //profile.setAcceptUntrustedCertificates(true);
    //profile.setAssumeUntrustedCertificateIssuer(false);
    //profile.setAcceptUntrustedCertificates(false);
    //DesiredCapabilities cap = DesiredCapabilities.chrome();
    //cap.setCapability(FirefoxDriver.PROFILE, profile);
    //cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    //cap.setCapability("takesScreenshot", true);
    
    //Solution 2
    //FirefoxProfile profile = new FirefoxProfile();
    
    //profile.setPreference("network.http.phishy-userpass-length", 255);
    //profile.setAssumeUntrustedCertificateIssuer(true);
    
    
    /*Solution 3
    FirefoxBinary binary = new FirefoxBinary();  
    File firefoxProfileFolder = new File("/Users/aburham/Documents/workspace-sts-3.3.0.RELEASE/com.which.acceptance.tests.demo/firefoxProfile");
    //
    FirefoxProfile profile = new FirefoxProfile(firefoxProfileFolder);
    profile.setAcceptUntrustedCertificates(true);
    ///driver = new FirefoxDriver(profile); */
//    try { 
 //   DesiredCapabilities cap = DesiredCapabilities.firefox();
    //cap.setPlatform(Platform.MAC);
    //cap.setBrowserName("firefox");
    //FirefoxBinary firefoxBinary = new FirefoxBinary();
    //firefoxBinary.setEnvironmentProperty("DISPLAY", ":15");
    //cap.setCapability(FirefoxDriver.BINARY, firefoxBinary);
    
    ///
    /*String Xport = System.getProperty(
            "lmportal.xvfb.id", ":15");
    final File firefoxPath = new File(System.getProperty(
            "lmportal.deploy.firefox.path", "/opt/local/lib/firefox-x11/firefox-bin"));
    firefoxBinary = new FirefoxBinary(firefoxPath);
    firefoxBinary.setEnvironmentProperty("DISPLAY", Xport);
    */
    ///
  //  String Xport = System.getProperty(
  //          "lmportal.xvfb.id", ":55");
 //   final File firefoxPath = new File(System.getProperty(
//            "lmportal.deploy.firefox.path", "/usr/bin/firefox"));
 //   FirefoxBinary firefoxBinary = new FirefoxBinary(firefoxPath);
//    firefoxBinary.setEnvironmentProperty("DISPLAY", Xport);
 //   driver = new FirefoxDriver(firefoxBinary, null);
    
    //cap.setCapability("firefox_binary", "/opt/local/lib/firefox-x11/firefox-bin");    
    //cap.setCapability("firefox_binary.DISPLAY", "15");
    //driver = new RemoteWebDriver(new URL("http://127.0.0.1:8080/wd/hub") , cap );
    
    
    //driver = new RemoteWebDriver(new URL("http://127.0.0.1:2000/wd/hub") , cap );
    //driver = new RemoteWebDriver(new URL("http://10.178.201.122:4444/wd/hub") , cap );
    //driver = new RemoteWebDriver(new URL("http://5.79.21.8:4444/wd/hub") , cap );
    ///**********************
    /*
    String Xport = System.getProperty(
            "lmportal.xvfb.id", ":15");
    final File firefoxPath = new File(System.getProperty(
            "lmportal.deploy.firefox.path", "/opt/local/lib/firefox-x11/firefox-bin"));
    FirefoxBinary firefoxBinary = new FirefoxBinary(firefoxPath);
    firefoxBinary.setEnvironmentProperty("DISPLAY", Xport);
    
    *////************************/////
    //driver = new RemoteWebDriver(new URL("http://127.0.0.1:8989/selenium-server/driver/") , cap );
//    System.out.println("It works....I think");
 //   return driver;
 //   }
  /*  catch (Exception e) {
    	
		  driver = new FirefoxDriver();
		  driver =null;
		  System.out.println("Samsung did not connect in createDriver");
		  return driver;
		  }
 / 
  }
   
}
*/
