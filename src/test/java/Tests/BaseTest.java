package Tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTest {


    @BeforeTest
    public void setUp(){
        ISettingsFile urls = new JsonSettingsFile("urls.json");
        Browser browser = AqualityServices.getBrowser();
        browser.goTo(urls.getValue("/mainUrl").toString());
        browser.maximize();
    }

    @AfterTest
    public void tearDown(){
        Browser browser = AqualityServices.getBrowser();
//        browser.quit();
    }
}
