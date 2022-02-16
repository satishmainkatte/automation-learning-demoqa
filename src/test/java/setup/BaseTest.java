package setup;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    public static WebDriver driver;

    @Rule
    public ScreenShotManagerTest failure = new ScreenShotManagerTest(driver);

    @BeforeClass
    public static void entryLoader(){
        System.out.println("Webdriver setup going on...");
        WebDriverManagerTest webDriverManagerTest = new WebDriverManagerTest("Chrome");
        driver = webDriverManagerTest.browserDriverSetup();
        System.out.println("Webdiver created!!");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
    }

    @AfterClass
    public static void exitLoader(){
        System.out.println("Closing Webdiver...");
        if (driver != null){
        driver.close();
        driver.quit();}
        System.out.println("Webdriver object destroyed!");
    }
}
