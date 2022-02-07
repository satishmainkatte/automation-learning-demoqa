package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class WebDriverManagerTest {

    String browserName;

    WebDriverManagerTest(String browserName){
        this.browserName=browserName;
    }

    public WebDriver browserDriverSetup() {
        try{
            switch (browserName.toLowerCase()) {
                case "chrome" -> {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver(chromeOptions);
                }
                case "firefox" -> {
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver(firefoxOptions);
                }
                case "internetexplorer" -> {
                    InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                    WebDriverManager.iedriver().setup();
                    return new InternetExplorerDriver(ieOptions);
                }
                case "edge" -> {
                    EdgeOptions edgeOptions = new EdgeOptions();
                    WebDriverManager.edgedriver().setup();
                    return new EdgeDriver(edgeOptions);
                }
                default -> {
                    System.out.println("Specify correct Browser Name!");
                    return null;
                }
            }
        }catch (Exception e){
            System.out.println("Unable to setup WebDriver instance!");
            throw e;
        }
    }
}

