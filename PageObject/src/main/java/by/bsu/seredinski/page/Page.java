package by.bsu.seredinski.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Page {

    private WebDriver webDriver;
    private WebDriverWait wait;
    private Actions action;

    @FindBy(id = "origin")
    private WebElement originCity;

    @FindBy(id = "destination")
    private WebElement destinationCity;

    @FindBy(xpath = "//div[@class='input-set  large-6  medium-6 small-6  col outbound']")
    private WebElement departureCalendar;

    @FindBy(xpath = "//div[@class='input-set  large-6  medium-6 small-6  col inbound']")
    private WebElement returnCalendar;
    @FindBy(xpath = "//td[@class='valid-day']")
    private List<WebElement> availableDates;
    @FindBy(xpath = "//input[@id='Inbound']")
    private WebElement endDate;
    @FindBy(xpath = "//p[@id='group-booking']/span")
    private WebElement warning;
    @FindBy(id = "passengers")
    private WebElement passengers;
    @FindBy(id = "cepAddInfant")
    private WebElement buttonToAddInfant;
    @FindBy(xpath = "//div[@class='tool-tip-inner']/span")
    private WebElement error;
    @FindBy(xpath = "//div[@id='lpc-error']/p")
    private WebElement cityError;
    @FindBy(xpath = "//button[@id='search-button']")
    private WebElement searchButton;

    public Page(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(driver, 10);
        action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public Page selectDepartureAirport() {
        originCity.clear();
        originCity.sendKeys("London");
        return this;
    }

    public void selectReturnAirport() {
        destinationCity.clear();
        destinationCity.sendKeys("Paris");
    }

    public void selectReturnAirport(String str) {
        destinationCity.clear();
        destinationCity.sendKeys(str);
        destinationCity.submit();
    }

    public void selectDepartureDate(int numberOfDayFromNow) {
        departureCalendar.click();
        action.moveToElement(availableDates.get(numberOfDayFromNow)).click().build().perform();
        availableDates.get(numberOfDayFromNow - 1).click();
    }

    public void selectReturnDate(int numberOfDayFromNow) {
        returnCalendar.click();
        action.moveToElement(availableDates.get(numberOfDayFromNow)).click().build().perform();
        availableDates.get(numberOfDayFromNow - 1).click();
    }

    public String getEndDate() {
        returnCalendar.click();
        return endDate.getText();
    }

    public void setPassengers(int number) {
        clickButton(number, passengers);
    }

    public void setInfants(int number) {
        clickButton(number, buttonToAddInfant);
    }

    private void clickButton(int number) {
        for (int i = 0; i < number; i++) {
            element.click();
        }
    }

    public void clearFields() {
        originCity.clear();
        destinationCity.clear();
    }

    public String getWarning() {
        return checkVisibility(warning).getText();
    }

    public String getError() {
        return error.getText();
    }

    public String getCityError() {
        return checkVisibility(cityError).getText();
    }

    private WebElement checkVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickSearch(){
        clickButton(2, searchButton);
    }
}
