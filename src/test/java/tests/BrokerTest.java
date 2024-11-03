package tests;

import assertions.BrokerAssertions;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BrokerPage;

import java.util.List;

public class BrokerTest {

    private WebDriver driver;
    private BrokerPage brokerPage;

    @BeforeClass
    void Setup() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.yavlena.com/en/broker?city=Sofia");
        brokerPage = new BrokerPage(driver);
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that broker search is successful")
    @Step("Search broker by name and verify details")
    public void testBrokerSearch() throws InterruptedException {

        List<String> brokerNames = brokerPage.getBrokerNames();
        for (String brokerName : brokerNames) {
            brokerPage.searchBroker(brokerName);
            Thread.sleep(15000);
            BrokerAssertions.assertOnlyOneBrokerDisplayed(brokerPage);
            BrokerAssertions.verifyBrokerDetails(brokerPage);
        }
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}