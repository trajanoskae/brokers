package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class BrokerPage {

    private WebDriver driver;

    @FindBy(xpath = "//h6[@class='MuiTypography-root MuiTypography-h6 mui-style-fnahqf']")
    private List<WebElement> brokerNames;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[1]/div/div[2]/div/button")
    private WebElement detailsButton;
    @FindBy(xpath = "/html/body/div[2]/div/div[3]/div/div[3]/div/input")
    private WebElement searchField;

    @FindBy(xpath = "/html/body/div[3]/div/div[1]/div/div[2]/div/div/div/div/div[1]/span")
    private WebElement brokerAddress;

    @FindBy(xpath = "/html/body/div[3]/div/div[1]/div/div[2]/div/div/div/div/div[2]/a[1]")
    private WebElement brokerLandline;

    @FindBy(xpath = "/html/body/div[3]/div/div[1]/div/div[2]/div/div/div/div/div[2]/a[2]")
    private WebElement brokerMobile;

    @FindBy(xpath = "/html/body/div[3]/div/div[1]/div/div[2]/a[2]")
    private WebElement brokerProperties;

    public BrokerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> getBrokerNames() {
        return brokerNames.stream().map(WebElement::getText).toList();
    }

    public void clickDetailsButton() throws InterruptedException {
        Thread.sleep(7000);
        detailsButton.click();
    }

    public void searchBroker(String name) throws InterruptedException {
        searchField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        searchField.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(5000);
        searchField.sendKeys(name);
    }

    public boolean isBrokerMobileDisplayed() {
        try {
            return brokerMobile.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getBrokerAddress() {
        return brokerAddress.getText();
    }

    public String getBrokerLandline() {
        return brokerLandline.getText();
    }

    public String getBrokerMobile() {
        return brokerMobile.getText();
    }

    public String getBrokerProperties() {
        return brokerProperties.getText();
    }
}