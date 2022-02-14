package testcases;

import jdk.javadoc.doclet.Reporter;
import org.junit.Assert;
import org.junit.Test;
import pages.Homepage;
import pages.elements.Elements;
import pages.elements.dynamicproperties.DynamicProperties;
import setup.BaseTest;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class VerifyDynamicPropertiesPageTest extends BaseTest {
    @Test
    public void test1() {
        Homepage home = new Homepage(driver);
        home.clickOnCardElements();

        Elements elements = new Elements(driver);
        elements.ClickonElementsDynamicProperties();

        DynamicProperties dynamicProperties=new DynamicProperties(driver);

        String text=dynamicProperties.verifyDynamicpropertiesheader();
        String expectedresult= "Dynamic Properties";
        Assert.assertEquals(text,expectedresult );

        dynamicProperties.verifyAttributeValue();







    }
}