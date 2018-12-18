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

    @FindBy(xpath = "//select[@id='airport']")
    private WebElement home;

    @FindBy(xpath = "//option[@value='ABZ']")
    private WebElement homeAirport;

    @FindBy(xpath = "//span[class='city-name']")
    private WebElement cityOfHomeAirport;

    @FindBy(xpath = "//div[@class='input-set  large-6  medium-6 small-6  col outbound']")
    private WebElement departureCalendar;

    @FindBy(xpath = "//div[@class='input-set  large-6  medium-6 small-6  col inbound']")
    private WebElement returnCalendar;

    @FindBy(xpath = "//td[@class='valid-day']")
    private List<WebElement> availableDates;

    @FindBy(xpath = "//input[@id='Inbound']")
    private WebElement endDate;

    @FindBy(id = "passengers")
    private WebElement passengers;

    @FindBy(xpath = "//li[@class='book-youth']/a")
    private WebElement buttonToChangeTypeOfPassengersToYouth;

    @FindBy(id = "cepAddAdult")
    private WebElement buttonToAddAdult;

    @FindBy(id = "cepAddInfant")
    private WebElement buttonToAddInfant;

    @FindBy(id = "cepAddYouth")
    private WebElement buttonToAddYouth;

    @FindBy(xpath = "//button[@class='btn primary medium large-12 medium-12 mrgn-b-20 pull-left']")
    private WebElement buttonToChangeHomeAirport;

    @FindBy(xpath = "//div[@class='tool-tip-inner']/span")
    private WebElement error;

    @FindBy(xpath = "//div[@id='lpc-error']/p")
    private WebElement cityError;

    @FindBy(xpath = "//p[@id='group-booking']/span")
    private WebElement warning;

    @FindBy(xpath = "//div[@class='cep-youth-disclaimer']")
    private WebElement youthDisclaimer;

    @FindBy(xpath = "//button[@id='search-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='firstName_ADT0']")
    private WebElement travelerFirstName;

    @FindBy(xpath = "//input[@id='lastName_ADT0']")
    private WebElement travelerSurName;

    @FindBy(xpath = "//input[@id='email_ADT0']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='mobile_ADT0']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//button[@id='eb-signup-btn']")
    private WebElement registerButton;

    public Page(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(driver, 10);
        action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void setHomeAirport() {
        home.click();
        checkVisibility(homeAirport).click();
        buttonToChangeHomeAirport.click();
    }

    public void selectDepartureAirport(String str) {
        originCity.clear();
        originCity.sendKeys(str);
        originCity.submit();
    }

    public void selectReturnAirport(String str) {
        destinationCity.clear();
        destinationCity.sendKeys(str);
        destinationCity.submit();
    }

    public void selectDepartureDate(int numberOfDayFromNow) {
        departureCalendar.click();
        action.click(availableDates.get(numberOfDayFromNow));
        availableDates.get(numberOfDayFromNow - 1).click();
    }

    public void selectReturnDate(int numberOfDayFromNow) {
        returnCalendar.click();
        action.click(availableDates.get(numberOfDayFromNow)).perform();
        availableDates.get(numberOfDayFromNow - 1).submit();
    }

    public String getEndDate() {
        returnCalendar.click();
        return endDate.getText();
    }

    public void setAdults(int number) {
        passengers.click();
        for (int i = 0; i < number; i++) {
            buttonToAddAdult.click();
        }
    }

    public void setInfants(int number) {
        passengers.click();
        for (int i = 0; i < number; i++) {
            buttonToAddInfant.click();
        }
    }

    public void setYouth(int number) {
        checkVisibility(passengers).click();
        checkVisibility(buttonToChangeTypeOfPassengersToYouth).click();
        for (int i = 0; i < number; i++) {
            buttonToAddYouth.click();
        }
    }

    public void clearFields() {
        originCity.clear();
        destinationCity.clear();
    }

    public void setFirstName(String str) {
        travelerFirstName.clear();
        travelerFirstName.sendKeys(str);
        travelerFirstName.submit();
    }

    public void setSurName(String str) {
        travelerSurName.clear();
        checkVisibility(travelerSurName).sendKeys(str);
        travelerSurName.submit();
    }

    public void setEmail(String str) {
        email.clear();
        checkVisibility(email).sendKeys(str);
        email.submit();
    }

    public void setPhoneNumber(String str) {
        phoneNumber.clear();
        checkVisibility(phoneNumber).sendKeys(str);
        phoneNumber.submit();
    }

    public String getWarning() {
        return checkVisibility(warning).getText();
    }

    public String getError() {
        return checkVisibility(error).getText();
    }

    public String getCityError() {
        return checkVisibility(cityError).getText();
    }

    public String getYouthDisclaimer() {
        return checkVisibility(youthDisclaimer).getText();
    }

    public String getCityOfHomeAirport() {
        return originCity.getText();
    }

    public void clickSearch() {
        checkVisibility(searchButton).submit();
    }

    public boolean checkRegisterButton() {
        return checkVisibility(registerButton).isDisplayed();
    }

    private WebElement checkVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    private WebElement checkClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
