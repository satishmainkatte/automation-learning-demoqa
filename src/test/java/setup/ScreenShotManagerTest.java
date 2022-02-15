package setup;

import base.BasePage;
import org.apache.commons.io.FileUtils;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShotManagerTest extends BasePage implements MethodRule {

    public ScreenShotManagerTest(WebDriver driver) {
        super(driver);
    }

    public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {

        return new Statement() {

            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                } catch (Throwable t) {
                    captureScreenShot(frameworkMethod.getDeclaringClass().getName());
                    throw t;
                }
            }

            public void captureScreenShot(String fileName) throws IOException {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
                LocalDateTime localDateTime = LocalDateTime.now();
                fileName += dateTimeFormatter.format(localDateTime);
                File targetFile = new File(System.getProperty("user.dir") + "/target/FailedScriptScreenShots/" + fileName + ".png");
                FileUtils.copyFile(scrFile, targetFile);
            }
        };
    }

}