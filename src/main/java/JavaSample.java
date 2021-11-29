import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.InetAddress;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Level;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaSample {
    public static final String AUTOMATE_USERNAME = "mahavirsinh.chhasatiya%40smartbear.com";
    public static final String AUTOMATE_ACCESS_KEY = "ubb0a8de2c82d0a9";

    public static void main(String[] args) throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName","chrome");
//        caps.setCapability("browserVersion","92");
        caps.setCapability("name", "Login Form Example");
        caps.setCapability("build", "1.0");
        caps.setCapability("platformName","headless");

//        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://" + URLEncoder.encode(AUTOMATE_USERNAME, StandardCharsets.UTF_8) + ":" + AUTOMATE_ACCESS_KEY +"@hub.crossbrowsertesting.com:80/wd/hub"), caps);
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY +"@hub-cloud.crossbrowsertesting.com:80/wd/hub"), caps);
        driver.setLogLevel(Level.INFO);
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Google");
        element.submit();
        Duration oneHours = Duration.ofSeconds(5);        // Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'BrowserStack'
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.titleContains("Google"));
        }
        catch(Exception e) {
            System.out.println("Something went wrong.");
        }
        System.out.println(driver.getTitle());
        driver.close();
    }
}
