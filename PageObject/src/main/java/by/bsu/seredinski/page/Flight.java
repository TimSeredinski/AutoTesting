package by.bsu.seredinski.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flight {

    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(id = "UpsellBookValidateHdrFlight")
    private WebElement firstStage;

    @FindBy(className = "receipt-info")
    private WebElement travelInfo;

    @FindBy(id = "outboundF4")
    private WebElement outBoundFlight;

    @FindBy(id = "inboundF0")
    private WebElement inBoundFlight;

    @FindBy(className = "button-wrap")
    private WebElement submitButton;

    public String getFirstStage() {
        return checkVisibility(firstStage).getText();
    }

    public String getTravelInfo(){
        return checkVisibility(travelInfo).getText();
    }

    public void chooseOutBoundFlight(){
        checkClickable(outBoundFlight).click();
        checkVisibility(submitButton).click();
    }

    public void chooseInBoundFlight(){
        checkClickable(inBoundFlight).click();
        checkVisibility(submitButton).click();
    }

    public Flight(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    private WebElement checkVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    private WebElement checkClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
