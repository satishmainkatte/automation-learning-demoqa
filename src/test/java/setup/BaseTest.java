package setup;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    public static WebDriver driver;

    @BeforeClass
    public static void entryLoader(){
        System.out.println("Webdriver setup going on...");
        driver = WebDriverManagerTest.browserDriverSetup("Chrome");
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
