package assertions;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import pages.BrokerPage;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class BrokerAssertions {

    public static void verifyBrokerDetails(BrokerPage brokerPage) throws InterruptedException {

        brokerPage.clickDetailsButton();
        Thread.sleep(6000);
        Assert.assertNotNull(brokerPage.getBrokerAddress(), "Broker address is null!");
        Assert.assertNotNull(brokerPage.getBrokerLandline(), "Broker landline is null!");
        if (brokerPage.isBrokerMobileDisplayed()) {
            Assert.assertNotNull(brokerPage.getBrokerMobile(), "Broker mobile is null!");
        }
        Assert.assertNotNull(brokerPage.getBrokerProperties(), "Broker properties are not present!");
    }

    public static void assertOnlyOneBrokerDisplayed(BrokerPage brokerPage) {

        List<String> brokers = brokerPage.getBrokerNames();
        assertEquals("Expected only one broker to be displayed, but found: " + brokers.size(), 1, brokers.size());
    }
}