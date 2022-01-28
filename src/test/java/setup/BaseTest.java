package setup;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest {
    public static WebDriver driver;
    private static String browserDriver;
    private static String url;

    @BeforeClass
    public static void entryLoader(){
        System.out.println("Webdriver setup going on...");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Webdiver created!!");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
    }

    @AfterClass
    public static void exitLoader(){
        System.out.println("Closing Webdiver...");
        driver.close();
        driver.quit();
        System.out.println("Webdriver object destroyed!");
    }
}
